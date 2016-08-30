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
 * Provides a wrapper for {@link AlbumService}.
 *
 * @author Julio Camarero
 * @see AlbumService
 * @generated
 */
@ProviderType
public class AlbumServiceWrapper implements AlbumService,
	ServiceWrapper<AlbumService> {
	public AlbumServiceWrapper(AlbumService albumService) {
		_albumService = albumService;
	}

	@Override
	public int getAlbumsCount(long groupId) {
		return _albumService.getAlbumsCount(groupId);
	}

	@Override
	public int getAlbumsCount(long groupId, java.lang.String keywords) {
		return _albumService.getAlbumsCount(groupId, keywords);
	}

	@Override
	public int getAlbumsCountByArtistId(long groupId, long artistId) {
		return _albumService.getAlbumsCountByArtistId(groupId, artistId);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _albumService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _albumService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		long groupId) {
		return _albumService.getAlbums(groupId);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		long groupId, int start, int end) {
		return _albumService.getAlbums(groupId, start, end);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		long groupId, java.lang.String keywords) {
		return _albumService.getAlbums(groupId, keywords);
	}

	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbumsByArtistId(
		long groupId, long artistId) {
		return _albumService.getAlbumsByArtistId(groupId, artistId);
	}

	@Override
	public org.liferay.jukebox.model.Album addAlbum(long artistId,
		java.lang.String name, int year, java.io.InputStream inputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumService.addAlbum(artistId, name, year, inputStream,
			serviceContext);
	}

	@Override
	public org.liferay.jukebox.model.Album deleteAlbum(long albumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumService.deleteAlbum(albumId, serviceContext);
	}

	@Override
	public org.liferay.jukebox.model.Album moveAlbumToTrash(long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumService.moveAlbumToTrash(albumId);
	}

	@Override
	public org.liferay.jukebox.model.Album restoreAlbumFromTrash(long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumService.restoreAlbumFromTrash(albumId);
	}

	@Override
	public org.liferay.jukebox.model.Album updateAlbum(long albumId,
		long artistId, java.lang.String name, int year,
		java.io.InputStream inputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumService.updateAlbum(albumId, artistId, name, year,
			inputStream, serviceContext);
	}

	@Override
	public AlbumService getWrappedService() {
		return _albumService;
	}

	@Override
	public void setWrappedService(AlbumService albumService) {
		_albumService = albumService;
	}

	private AlbumService _albumService;
}