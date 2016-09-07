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
 * Provides a wrapper for {@link AlbumLocalService}.
 *
 * @author Julio Camarero
 * @see AlbumLocalService
 * @generated
 */
@ProviderType
public class AlbumLocalServiceWrapper implements AlbumLocalService,
	ServiceWrapper<AlbumLocalService> {
	public AlbumLocalServiceWrapper(AlbumLocalService albumLocalService) {
		_albumLocalService = albumLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _albumLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _albumLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _albumLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _albumLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of albums.
	*
	* @return the number of albums
	*/
	@Override
	public int getAlbumsCount() {
		return _albumLocalService.getAlbumsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _albumLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _albumLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _albumLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _albumLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of albums
	*/
	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		int start, int end) {
		return _albumLocalService.getAlbums(start, end);
	}

	/**
	* Returns all the albums matching the UUID and company.
	*
	* @param uuid the UUID of the albums
	* @param companyId the primary key of the company
	* @return the matching albums, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbumsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _albumLocalService.getAlbumsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of albums matching the UUID and company.
	*
	* @param uuid the UUID of the albums
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching albums, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<org.liferay.jukebox.model.Album> getAlbumsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.liferay.jukebox.model.Album> orderByComparator) {
		return _albumLocalService.getAlbumsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _albumLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _albumLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the album to the database. Also notifies the appropriate model listeners.
	*
	* @param album the album
	* @return the album that was added
	*/
	@Override
	public org.liferay.jukebox.model.Album addAlbum(
		org.liferay.jukebox.model.Album album) {
		return _albumLocalService.addAlbum(album);
	}

	/**
	* Creates a new album with the primary key. Does not add the album to the database.
	*
	* @param albumId the primary key for the new album
	* @return the new album
	*/
	@Override
	public org.liferay.jukebox.model.Album createAlbum(long albumId) {
		return _albumLocalService.createAlbum(albumId);
	}

	/**
	* Deletes the album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the album
	* @return the album that was removed
	* @throws PortalException if a album with the primary key could not be found
	*/
	@Override
	public org.liferay.jukebox.model.Album deleteAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumLocalService.deleteAlbum(albumId);
	}

	/**
	* Deletes the album from the database. Also notifies the appropriate model listeners.
	*
	* @param album the album
	* @return the album that was removed
	*/
	@Override
	public org.liferay.jukebox.model.Album deleteAlbum(
		org.liferay.jukebox.model.Album album) {
		return _albumLocalService.deleteAlbum(album);
	}

	@Override
	public org.liferay.jukebox.model.Album fetchAlbum(long albumId) {
		return _albumLocalService.fetchAlbum(albumId);
	}

	/**
	* Returns the album matching the UUID and group.
	*
	* @param uuid the album's UUID
	* @param groupId the primary key of the group
	* @return the matching album, or <code>null</code> if a matching album could not be found
	*/
	@Override
	public org.liferay.jukebox.model.Album fetchAlbumByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _albumLocalService.fetchAlbumByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the album with the primary key.
	*
	* @param albumId the primary key of the album
	* @return the album
	* @throws PortalException if a album with the primary key could not be found
	*/
	@Override
	public org.liferay.jukebox.model.Album getAlbum(long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumLocalService.getAlbum(albumId);
	}

	/**
	* Returns the album matching the UUID and group.
	*
	* @param uuid the album's UUID
	* @param groupId the primary key of the group
	* @return the matching album
	* @throws PortalException if a matching album could not be found
	*/
	@Override
	public org.liferay.jukebox.model.Album getAlbumByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _albumLocalService.getAlbumByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the album in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param album the album
	* @return the album that was updated
	*/
	@Override
	public org.liferay.jukebox.model.Album updateAlbum(
		org.liferay.jukebox.model.Album album) {
		return _albumLocalService.updateAlbum(album);
	}

	@Override
	public AlbumLocalService getWrappedService() {
		return _albumLocalService;
	}

	@Override
	public void setWrappedService(AlbumLocalService albumLocalService) {
		_albumLocalService = albumLocalService;
	}

	private AlbumLocalService _albumLocalService;
}