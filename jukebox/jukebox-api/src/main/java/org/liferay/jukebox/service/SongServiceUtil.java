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

package org.liferay.jukebox.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Song. This utility wraps
 * {@link org.liferay.jukebox.service.impl.SongServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Julio Camarero
 * @see SongService
 * @see org.liferay.jukebox.service.base.SongServiceBaseImpl
 * @see org.liferay.jukebox.service.impl.SongServiceImpl
 * @generated
 */
@ProviderType
public class SongServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.liferay.jukebox.service.impl.SongServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static int getSongsCount(long groupId) {
		return getService().getSongsCount(groupId);
	}

	public static int getSongsCount(long groupId, java.lang.String keywords) {
		return getService().getSongsCount(groupId, keywords);
	}

	public static int getSongsCountByAlbumId(long groupId, long albumId) {
		return getService().getSongsCountByAlbumId(groupId, albumId);
	}

	public static int getSongsCountByAlbumId(long groupId, long albumId,
		int status) {
		return getService().getSongsCountByAlbumId(groupId, albumId, status);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		long groupId) {
		return getService().getSongs(groupId);
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		long groupId, int start, int end) {
		return getService().getSongs(groupId, start, end);
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		long groupId, java.lang.String keywords) {
		return getService().getSongs(groupId, keywords);
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		long groupId, long albumId) {
		return getService().getSongsByAlbumId(groupId, albumId);
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		long groupId, long albumId, int status) {
		return getService().getSongsByAlbumId(groupId, albumId, status);
	}

	public static org.liferay.jukebox.model.Song addSong(long albumId,
		java.lang.String name, java.lang.String songFileName,
		java.io.InputStream songInputStream, java.lang.String lyricsFileName,
		java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .addSong(albumId, name, songFileName, songInputStream,
			lyricsFileName, lyricsInputStream, serviceContext);
	}

	public static org.liferay.jukebox.model.Song deleteSong(long songId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSong(songId, serviceContext);
	}

	public static org.liferay.jukebox.model.Song moveSongToTrash(long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().moveSongToTrash(songId);
	}

	public static org.liferay.jukebox.model.Song restoreSongFromTrash(
		long songId) throws com.liferay.portal.kernel.exception.PortalException {
		return getService().restoreSongFromTrash(songId);
	}

	public static org.liferay.jukebox.model.Song updateSong(long songId,
		long albumId, java.lang.String name, java.lang.String songFileName,
		java.io.InputStream songInputStream, java.lang.String lyricsFileName,
		java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateSong(songId, albumId, name, songFileName,
			songInputStream, lyricsFileName, lyricsInputStream, serviceContext);
	}

	public static SongService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SongService, SongService> _serviceTracker = ServiceTrackerFactory.open(SongService.class);
}