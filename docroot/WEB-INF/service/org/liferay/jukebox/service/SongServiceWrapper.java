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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SongService}.
 *
 * @author Julio Camarero
 * @see SongService
 * @generated
 */
@ProviderType
public class SongServiceWrapper implements SongService,
	ServiceWrapper<SongService> {
	public SongServiceWrapper(SongService songService) {
		_songService = songService;
	}

	@Override
	public int getSongsCount(long groupId) {
		return _songService.getSongsCount(groupId);
	}

	@Override
	public int getSongsCount(long groupId, java.lang.String keywords) {
		return _songService.getSongsCount(groupId, keywords);
	}

	@Override
	public int getSongsCountByAlbumId(long groupId, long albumId) {
		return _songService.getSongsCountByAlbumId(groupId, albumId);
	}

	@Override
	public int getSongsCountByAlbumId(long groupId, long albumId, int status) {
		return _songService.getSongsCountByAlbumId(groupId, albumId, status);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _songService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _songService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Song> getSongs(long groupId) {
		return _songService.getSongs(groupId);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Song> getSongs(
		long groupId, int start, int end) {
		return _songService.getSongs(groupId, start, end);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Song> getSongs(
		long groupId, java.lang.String keywords) {
		return _songService.getSongs(groupId, keywords);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		long groupId, long albumId) {
		return _songService.getSongsByAlbumId(groupId, albumId);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		long groupId, long albumId, int status) {
		return _songService.getSongsByAlbumId(groupId, albumId, status);
	}

	@Override
	public org.liferay.jukebox.model.Song addSong(long albumId,
		java.lang.String name, java.lang.String songFileName,
		java.io.InputStream songInputStream, java.lang.String lyricsFileName,
		java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _songService.addSong(albumId, name, songFileName,
			songInputStream, lyricsFileName, lyricsInputStream, serviceContext);
	}

	@Override
	public org.liferay.jukebox.model.Song deleteSong(long songId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _songService.deleteSong(songId, serviceContext);
	}

	@Override
	public org.liferay.jukebox.model.Song moveSongToTrash(long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _songService.moveSongToTrash(songId);
	}

	@Override
	public org.liferay.jukebox.model.Song restoreSongFromTrash(long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _songService.restoreSongFromTrash(songId);
	}

	@Override
	public org.liferay.jukebox.model.Song updateSong(long songId, long albumId,
		java.lang.String name, java.lang.String songFileName,
		java.io.InputStream songInputStream, java.lang.String lyricsFileName,
		java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _songService.updateSong(songId, albumId, name, songFileName,
			songInputStream, lyricsFileName, lyricsInputStream, serviceContext);
	}

	@Override
	public SongService getWrappedService() {
		return _songService;
	}

	@Override
	public void setWrappedService(SongService songService) {
		_songService = songService;
	}

	private SongService _songService;
}