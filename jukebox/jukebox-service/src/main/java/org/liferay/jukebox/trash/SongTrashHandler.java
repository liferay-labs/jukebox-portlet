/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.liferay.jukebox.trash;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ContainerModel;
import com.liferay.portal.kernel.model.TrashedModel;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.trash.TrashActionKeys;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.trash.TrashHandlerRegistryUtil;
import com.liferay.portal.kernel.trash.TrashRenderer;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.trash.kernel.exception.RestoreEntryException;
import com.liferay.trash.kernel.model.TrashEntry;
import com.liferay.trash.kernel.model.TrashEntryConstants;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.liferay.jukebox.model.Album;
import org.liferay.jukebox.model.Song;
import org.liferay.jukebox.service.AlbumLocalService;
import org.liferay.jukebox.service.SongLocalService;
import org.liferay.jukebox.service.permission.AlbumPermission;
import org.liferay.jukebox.service.permission.SongPermission;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Implements trash handling for the songs.
 *
 * @author Sergio González
 */
@Component(
	property = {"model.class.name=org.liferay.jukebox.model.Song"},
	service = TrashHandler.class
)
public class SongTrashHandler extends JukeBoxBaseTrashHandler {

	public void checkDuplicateTrashEntry(
			TrashEntry trashEntry, long containerModelId, String newName)
		throws PortalException {

		Song song = _songLocalService.getSong(trashEntry.getClassPK());

		if (containerModelId == TrashEntryConstants.DEFAULT_CONTAINER_ID) {
			containerModelId = song.getAlbumId();
		}

		String originalName = trashEntry.getTypeSettingsProperty("title");

		if (Validator.isNotNull(newName)) {
			originalName = newName;
		}

		Song duplicateSong = _songLocalService.getSong(
			song.getGroupId(), song.getArtistId(), containerModelId,
			originalName);

		if (duplicateSong != null) {
			RestoreEntryException ree = new RestoreEntryException();

			ree.setDuplicateEntryId(duplicateSong.getSongId());
			ree.setOldName(duplicateSong.getName());
			ree.setTrashEntryId(trashEntry.getEntryId());

			throw ree;
		}
	}

	@Override
	public void deleteTrashEntry(long classPK) throws PortalException {
		_songLocalService.deleteSong(classPK);
	}

	@Override
	public String getClassName() {
		return Song.class.getName();
	}

	@Override
	public ContainerModel getParentContainerModel(long classPK)
		throws PortalException {

		Song song = _songLocalService.getSong(classPK);

		return getContainerModel(song.getAlbumId());
	}

	@Override
	public ContainerModel getParentContainerModel(TrashedModel trashedModel)
		throws PortalException {

		Song song = (Song)trashedModel;

		return getContainerModel(song.getAlbumId());
	}

	@Override
	public String getRestoreContainerModelLink(
			PortletRequest portletRequest, long classPK)
		throws PortalException {

		Song song = _songLocalService.getSong(classPK);

		PortletURL portletURL = getRestoreURL(portletRequest, classPK);

		portletURL.setParameter("songId", String.valueOf(song.getSongId()));

		return portletURL.toString();
	}

	@Override
	public String getRestoreMessage(
		PortletRequest portletRequest, long classPK) {

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		return themeDisplay.translate("songs");
	}

	@Override
	public String getTrashContainedModelName() {
		return "songs";
	}

	@Override
	public int getTrashContainedModelsCount(long classPK)
		throws PortalException {

		Album album = _albumLocalService.getAlbum(classPK);

		return _songLocalService.getSongsByAlbumIdCount(classPK);
	}

	@Override
	public List<TrashRenderer> getTrashContainedModelTrashRenderers(
			long classPK, int start, int end)
		throws PortalException {

		List<TrashRenderer> trashRenderers = new ArrayList<>();

		List<Song> songs = _songLocalService.getSongsByAlbumId(
			classPK, start, end);

		for (Song song : songs) {
			TrashHandler trashHandler =
				TrashHandlerRegistryUtil.getTrashHandler(Song.class.getName());

			TrashRenderer trashRenderer = trashHandler.getTrashRenderer(
				song.getSongId());

			trashRenderers.add(trashRenderer);
		}

		return trashRenderers;
	}

	@Override
	public TrashEntry getTrashEntry(long classPK) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		return song.getTrashEntry();
	}

	@Override
	public boolean hasTrashPermission(
			PermissionChecker permissionChecker, long groupId, long classPK,
			String trashActionId)
		throws PortalException {

		if (trashActionId.equals(TrashActionKeys.MOVE)) {
			return AlbumPermission.contains(
				permissionChecker, classPK, "ADD_ALBUM");
		}

		return super.hasTrashPermission(
			permissionChecker, groupId, classPK, trashActionId);
	}

	@Override
	public boolean isInTrash(long classPK) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		return song.isInTrash();
	}

	@Override
	public boolean isInTrashContainer(long classPK) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		return song.isInTrashContainer();
	}

	@Override
	public boolean isRestorable(long classPK) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		if ((song.getAlbumId() > 0) &&
			(_albumLocalService.fetchAlbum(song.getAlbumId()) == null)) {

			return false;
		}

		return !song.isInTrashContainer();
	}

	@Override
	public void moveEntry(
			long userId, long classPK, long containerModelId,
			ServiceContext serviceContext)
		throws PortalException {

		_songLocalService.moveSong(classPK, containerModelId);
	}

	@Override
	public void moveTrashEntry(
			long userId, long classPK, long containerId,
			ServiceContext serviceContext)
		throws PortalException {

		_songLocalService.moveSongFromTrash(userId, classPK, containerId);
	}

	@Override
	public void restoreTrashEntry(long userId, long classPK)
		throws PortalException {

		_songLocalService.restoreSongFromTrash(userId, classPK);
	}

	@Override
	public void updateTitle(long classPK, String name) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		song.setName(name);

		_songLocalService.updateSong(song);
	}

	@Override
	protected long getGroupId(long classPK) throws PortalException {
		Song song = _songLocalService.getSong(classPK);

		return song.getGroupId();
	}

	protected PortletURL getRestoreURL(
			PortletRequest portletRequest, long classPK)
		throws PortalException {

		String portletId = PortletKeys.SONGS;

		Song song = _songLocalService.getSong(classPK);

		long plid = PortalUtil.getPlidFromPortletId(
			song.getGroupId(), PortletKeys.SONGS);

		PortletURL portletURL = PortletURLFactoryUtil.create(
			portletRequest, portletId, plid, PortletRequest.RENDER_PHASE);

		portletURL.setParameter("jspPage", "/html/songs/view_song.jsp");

		return portletURL;
	}

	@Override
	protected boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws PortalException {

		return SongPermission.contains(permissionChecker, classPK, actionId);
	}

	@Reference(unbind = "-")
	protected void setAlbumLocalService(AlbumLocalService albumLocalService) {
		_albumLocalService = albumLocalService;
	}

	@Reference(unbind = "-")
	protected void setSongLocalService(SongLocalService songLocalService) {
		_songLocalService = songLocalService;
	}

	private static AlbumLocalService _albumLocalService;
	private static SongLocalService _songLocalService;

}