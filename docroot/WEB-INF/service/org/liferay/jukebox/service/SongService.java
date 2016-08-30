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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.InvokableService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.liferay.jukebox.model.Song;

import java.io.InputStream;

import java.util.List;

/**
 * Provides the remote service interface for Song. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Julio Camarero
 * @see SongServiceUtil
 * @see org.liferay.jukebox.service.base.SongServiceBaseImpl
 * @see org.liferay.jukebox.service.impl.SongServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SongService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SongServiceUtil} to access the song remote service. Add custom service methods to {@link org.liferay.jukebox.service.impl.SongServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSongsCount(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSongsCount(long groupId, java.lang.String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSongsCountByAlbumId(long groupId, long albumId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSongsCountByAlbumId(long groupId, long albumId, int status);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Song> getSongs(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Song> getSongs(long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Song> getSongs(long groupId, java.lang.String keywords);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Song> getSongsByAlbumId(long groupId, long albumId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Song> getSongsByAlbumId(long groupId, long albumId, int status);

	public Song addSong(long albumId, java.lang.String name,
		java.lang.String songFileName, InputStream songInputStream,
		java.lang.String lyricsFileName, InputStream lyricsInputStream,
		ServiceContext serviceContext) throws PortalException;

	public Song deleteSong(long songId, ServiceContext serviceContext)
		throws PortalException;

	public Song moveSongToTrash(long songId) throws PortalException;

	public Song restoreSongFromTrash(long songId) throws PortalException;

	public Song updateSong(long songId, long albumId, java.lang.String name,
		java.lang.String songFileName, InputStream songInputStream,
		java.lang.String lyricsFileName, InputStream lyricsInputStream,
		ServiceContext serviceContext) throws PortalException;
}