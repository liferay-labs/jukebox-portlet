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

package org.liferay.jukebox.service.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.util.DLProcessorRegistryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.trash.kernel.model.TrashEntry;
import com.liferay.trash.kernel.model.TrashVersion;
import com.liferay.trash.kernel.util.TrashUtil;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import org.liferay.jukebox.DuplicatedSongException;
import org.liferay.jukebox.SongNameException;
import org.liferay.jukebox.model.Album;
import org.liferay.jukebox.model.Song;
import org.liferay.jukebox.service.base.SongLocalServiceBaseImpl;
import org.liferay.jukebox.util.Constants;

/**
 * The implementation of the song local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.liferay.jukebox.service.SongLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Julio Camarero
 * @author Sergio González
 * @author Eudaldo Alonso
 * @see org.liferay.jukebox.service.base.SongLocalServiceBaseImpl
 * @see org.liferay.jukebox.service.SongLocalServiceUtil
 */
public class SongLocalServiceImpl extends SongLocalServiceBaseImpl {

	@Override
	public void addEntryResources(
			Song song, boolean addGroupPermissions, boolean addGuestPermissions)
		throws PortalException {

		resourceLocalService.addResources(
			song.getCompanyId(), song.getGroupId(), song.getUserId(),
			Song.class.getName(), song.getSongId(), false, addGroupPermissions,
			addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			Song song, String[] groupPermissions, String[] guestPermissions)
		throws PortalException {

		resourceLocalService.addModelResources(
			song.getCompanyId(), song.getGroupId(), song.getUserId(),
			Song.class.getName(), song.getSongId(), groupPermissions,
			guestPermissions);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Song addSong(
			long userId, long albumId, String name, String songFileName,
			InputStream songInputStream, String lyricsFileName,
			InputStream lyricsInputStream, ServiceContext serviceContext)
		throws PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		long songId = counterLocalService.increment();
		Album album = albumPersistence.findByPrimaryKey(albumId);

		validate(songId, groupId, album.getArtistId(), albumId, name);

		Song song = songPersistence.create(songId);

		song.setUuid(serviceContext.getUuid());
		song.setGroupId(groupId);
		song.setCompanyId(user.getCompanyId());
		song.setUserId(user.getUserId());
		song.setUserName(user.getFullName());
		song.setCreateDate(serviceContext.getCreateDate(now));
		song.setModifiedDate(serviceContext.getModifiedDate(now));

		song.setArtistId(album.getArtistId());
		song.setAlbumId(albumId);
		song.setName(name);
		song.setExpandoBridgeAttributes(serviceContext);

		songPersistence.update(song);

		if ((songInputStream != null) || (lyricsInputStream != null)) {
			Repository repository =
				PortletFileRepositoryUtil.addPortletRepository(
					groupId, Constants.JUKEBOX_PORTLET_REPOSITORY,
					serviceContext);

			Folder folder = PortletFileRepositoryUtil.addPortletFolder(
				userId, repository.getRepositoryId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				String.valueOf(song.getSongId()), serviceContext);

			if (songInputStream != null) {
				Folder songFolder = PortletFileRepositoryUtil.addPortletFolder(
					userId, repository.getRepositoryId(), folder.getFolderId(),
					Constants.SONGS_FOLDER_NAME, serviceContext);

				FileEntry fileEntry =
					PortletFileRepositoryUtil.addPortletFileEntry(
						groupId, userId, Song.class.getName(), song.getSongId(),
						Constants.JUKEBOX_PORTLET_REPOSITORY,
						songFolder.getFolderId(), songInputStream, songFileName,
						StringPool.BLANK, true);

				DLProcessorRegistryUtil.trigger(fileEntry, null, true);
			}

			if (lyricsInputStream != null) {
				Folder lyricsFolder =
					PortletFileRepositoryUtil.addPortletFolder(
						userId, repository.getRepositoryId(),
						folder.getFolderId(), Constants.LYRICS_FOLDER_NAME,
						serviceContext);

				FileEntry fileEntry =
					PortletFileRepositoryUtil.addPortletFileEntry(
						groupId, userId, Song.class.getName(), song.getSongId(),
						Constants.JUKEBOX_PORTLET_REPOSITORY,
						lyricsFolder.getFolderId(), lyricsInputStream,
						lyricsFileName, StringPool.BLANK, true);

				DLProcessorRegistryUtil.trigger(fileEntry, null, true);
			}
		}

		// Resources

		if (serviceContext.isAddGroupPermissions() ||
			serviceContext.isAddGuestPermissions()) {

			addEntryResources(
				song, serviceContext.isAddGroupPermissions(),
				serviceContext.isAddGuestPermissions());
		}
		else {
			addEntryResources(
				song, serviceContext.getGroupPermissions(),
				serviceContext.getGuestPermissions());
		}

		// Message boards

		mbMessageLocalService.addDiscussionMessage(
			userId, album.getUserName(), groupId, Song.class.getName(), songId,
			WorkflowConstants.ACTION_PUBLISH);

		// Asset

		updateAsset(
			userId, song, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds());

		return song;
	}

	@Indexable(type = IndexableType.DELETE)
	public Song deleteSong(long songId) throws PortalException {
		Song song = songPersistence.findByPrimaryKey(songId);

		Repository repository =
			PortletFileRepositoryUtil.fetchPortletRepository(
				song.getGroupId(), Constants.JUKEBOX_PORTLET_REPOSITORY);

		if (repository != null) {
			try {
				Folder folder = PortletFileRepositoryUtil.getPortletFolder(
					0, repository.getRepositoryId(),
					DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
					String.valueOf(songId), null);

				PortletFileRepositoryUtil.deleteFolder(folder.getFolderId());
			}
			catch (Exception e) {
			}
		}

		return songPersistence.remove(songId);
	}

	public Song getSong(
		long groupId, long artistId, long albumId, String name) {

		return songPersistence.fetchByG_A_A_N(groupId, artistId, albumId, name);
	}

	public List<Song> getSongs(long groupId) {
		return songPersistence.findByGroupId(groupId);
	}

	public List<Song> getSongs(long groupId, int start, int end) {
		return songPersistence.findByGroupId(groupId, start, end);
	}

	public List<Song> getSongsByAlbumId(long albumId) {
		return songPersistence.findByAlbumId(albumId);
	}

	public List<Song> getSongsByAlbumId(long albumId, int start, int end) {
		return songPersistence.findByAlbumId(albumId, start, end);
	}

	public List<Song> getSongsByAlbumId(
		long groupId, long albumId, int status) {

		return songPersistence.findByG_A_S(groupId, albumId, status);
	}

	public int getSongsByAlbumIdCount(long albumId) {
		return songPersistence.countByAlbumId(albumId);
	}

	public int getSongsCount(long groupId) {
		return songPersistence.countByGroupId(groupId);
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Song moveSong(long songId, long albumId) throws PortalException {
		Song song = getSong(songId);

		song.setAlbumId(albumId);

		songPersistence.update(song);

		return song;
	}

	@Override
	public Song moveSongFromTrash(long userId, long songId, long albumId)
		throws PortalException {

		Song song = getSong(songId);

		TrashEntry trashEntry = song.getTrashEntry();

		if (trashEntry.isTrashEntry(Song.class, songId)) {
			restoreSongFromTrash(userId, songId);
		}
		else {

			// Entry

			TrashVersion trashVersion =
				trashVersionLocalService.fetchVersion(
					trashEntry.getEntryId(), Song.class.getName(), songId);

			int status = WorkflowConstants.STATUS_APPROVED;

			if (trashVersion != null) {
				status = trashVersion.getStatus();
			}

			ServiceContext serviceContext = new ServiceContext();

			// Entry

			User user = userPersistence.findByPrimaryKey(userId);
			Date now = new Date();

			song.setModifiedDate(serviceContext.getModifiedDate(now));
			song.setStatus(status);
			song.setStatusByUserId(user.getUserId());
			song.setStatusByUserName(user.getFullName());
			song.setStatusDate(serviceContext.getModifiedDate(now));

			songPersistence.update(song);

			// Asset

			assetEntryLocalService.updateVisible(
				Song.class.getName(), song.getSongId(), false);

			// Indexer

			Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(
				Song.class);

			indexer.reindex(song);

			// Trash

			if (trashVersion != null) {
				trashVersionLocalService.deleteTrashVersion(trashVersion);
			}
		}

		return songLocalService.moveSong(songId, albumId);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Song moveSongToTrash(long userId, Song song) throws PortalException {
		ServiceContext serviceContext = new ServiceContext();

		// Entry

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		int oldStatus = song.getStatus();

		song.setModifiedDate(serviceContext.getModifiedDate(now));
		song.setStatus(WorkflowConstants.STATUS_IN_TRASH);
		song.setStatusByUserId(user.getUserId());
		song.setStatusByUserName(user.getFullName());
		song.setStatusDate(serviceContext.getModifiedDate(now));

		// Asset

		assetEntryLocalService.updateVisible(
			Song.class.getName(), song.getSongId(), false);

		// Trash

		UnicodeProperties typeSettingsProperties = new UnicodeProperties();

		typeSettingsProperties.put("title", song.getName());

		TrashEntry trashEntry = trashEntryLocalService.addTrashEntry(
			userId, song.getGroupId(), Song.class.getName(), song.getSongId(),
			song.getUuid(), null, oldStatus, null, typeSettingsProperties);

		song.setName(TrashUtil.getTrashTitle(trashEntry.getEntryId()));

		songPersistence.update(song);

		return song;
	}

	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Song restoreSongFromTrash(long userId, long songId)
		throws PortalException {

		ServiceContext serviceContext = new ServiceContext();

		// Entry

		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();

		TrashEntry trashEntry = trashEntryLocalService.getEntry(
			Song.class.getName(), songId);

		Song song = songPersistence.findByPrimaryKey(songId);

		song.setName(TrashUtil.getOriginalTitle(song.getName()));
		song.setModifiedDate(serviceContext.getModifiedDate(now));
		song.setStatus(trashEntry.getStatus());
		song.setStatusByUserId(user.getUserId());
		song.setStatusByUserName(user.getFullName());
		song.setStatusDate(serviceContext.getModifiedDate(now));

		songPersistence.update(song);

		assetEntryLocalService.updateVisible(
			Song.class.getName(), song.getSongId(), true);

		trashEntryLocalService.deleteEntry(Song.class.getName(), songId);

		return song;
	}

	public void updateAsset(
			long userId, Song song, long[] assetCategoryIds,
			String[] assetTagNames, long[] assetLinkEntryIds)
		throws PortalException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(
			userId, song.getGroupId(), song.getCreateDate(),
			song.getModifiedDate(), Song.class.getName(), song.getSongId(),
			song.getUuid(), 0, assetCategoryIds, assetTagNames, true, null,
			null, null, ContentTypes.TEXT_HTML, song.getName(), null, null,
			null, null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(
			userId, assetEntry.getEntryId(), assetLinkEntryIds,
			AssetLinkConstants.TYPE_RELATED);
	}

	@Indexable(type = IndexableType.REINDEX)
	public Song updateSong(
			long userId, long songId, long albumId, String name,
			String songFileName, InputStream songInputStream,
			String lyricsFileName, InputStream lyricsInputStream,
			ServiceContext serviceContext)
		throws PortalException {

		// Event

		User user = userPersistence.findByPrimaryKey(userId);

		Song song = songPersistence.findByPrimaryKey(songId);
		Album album = albumPersistence.findByPrimaryKey(albumId);

		validate(songId, song.getGroupId(), album.getArtistId(), albumId, name);

		song.setModifiedDate(serviceContext.getModifiedDate(null));

		song.setArtistId(album.getArtistId());
		song.setAlbumId(albumId);

		song.setName(name);
		song.setExpandoBridgeAttributes(serviceContext);

		songPersistence.update(song);

		if ((songInputStream != null) || (lyricsInputStream != null)) {
			Repository repository =
				PortletFileRepositoryUtil.addPortletRepository(
					serviceContext.getScopeGroupId(),
					Constants.JUKEBOX_PORTLET_REPOSITORY, serviceContext);

			Folder folder = PortletFileRepositoryUtil.addPortletFolder(
				userId, repository.getRepositoryId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				String.valueOf(song.getSongId()), serviceContext);

			if (songInputStream != null) {
				Folder songFolder = PortletFileRepositoryUtil.addPortletFolder(
					userId, repository.getRepositoryId(), folder.getFolderId(),
					Constants.SONGS_FOLDER_NAME, serviceContext);

				List<FileEntry> fileEntries =
					PortletFileRepositoryUtil.getPortletFileEntries(
						serviceContext.getScopeGroupId(),
						songFolder.getFolderId());

				for (FileEntry fileEntry : fileEntries) {
					PortletFileRepositoryUtil.deletePortletFileEntry(
						fileEntry.getFileEntryId());

					DLProcessorRegistryUtil.cleanUp(fileEntry);
				}

				FileEntry fileEntry =
					PortletFileRepositoryUtil.addPortletFileEntry(
						serviceContext.getScopeGroupId(), userId,
						Song.class.getName(), song.getSongId(),
						Constants.JUKEBOX_PORTLET_REPOSITORY,
						songFolder.getFolderId(), songInputStream, songFileName,
						StringPool.BLANK, true);

				triggerDLProcessors(fileEntry);
			}

			if (lyricsInputStream != null) {
				Folder lyricsFolder =
					PortletFileRepositoryUtil.addPortletFolder(
						userId, repository.getRepositoryId(),
						folder.getFolderId(), Constants.LYRICS_FOLDER_NAME,
						serviceContext);

				List<FileEntry> fileEntries =
					PortletFileRepositoryUtil.getPortletFileEntries(
						serviceContext.getScopeGroupId(),
						lyricsFolder.getFolderId());

				for (FileEntry fileEntry : fileEntries) {
					PortletFileRepositoryUtil.deletePortletFileEntry(
						fileEntry.getFileEntryId());

					DLProcessorRegistryUtil.cleanUp(fileEntry);
				}

				FileEntry fileEntry =
					PortletFileRepositoryUtil.addPortletFileEntry(
						serviceContext.getScopeGroupId(), userId,
						Song.class.getName(), song.getSongId(),
						Constants.JUKEBOX_PORTLET_REPOSITORY,
						lyricsFolder.getFolderId(), lyricsInputStream,
						lyricsFileName, StringPool.BLANK, true);

				triggerDLProcessors(fileEntry);
			}
		}

		// Asset

		updateAsset(
			userId, song, serviceContext.getAssetCategoryIds(),
			serviceContext.getAssetTagNames(),
			serviceContext.getAssetLinkEntryIds());

		return song;
	}

	protected void triggerDLProcessors(final FileEntry fileEntry) {
		TransactionCommitCallbackRegistryUtil.registerCallback(
			new Callable<Void>() {

				@Override
				public Void call() throws Exception {
					DLProcessorRegistryUtil.trigger(fileEntry, null, true);

					return null;
				}

			});
	}

	protected void validate(
			long songId, long groupId, long artistId, long albumId, String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new SongNameException();
		}

		Song song = songPersistence.fetchByG_A_A_N(
			groupId, artistId, albumId, name);

		if ((song != null) && (song.getSongId() != songId)) {
			throw new DuplicatedSongException();
		}
	}

}