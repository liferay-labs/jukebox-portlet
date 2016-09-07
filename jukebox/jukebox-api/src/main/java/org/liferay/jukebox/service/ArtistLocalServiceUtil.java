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
 * Provides the local service utility for Artist. This utility wraps
 * {@link org.liferay.jukebox.service.impl.ArtistLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Julio Camarero
 * @see ArtistLocalService
 * @see org.liferay.jukebox.service.base.ArtistLocalServiceBaseImpl
 * @see org.liferay.jukebox.service.impl.ArtistLocalServiceImpl
 * @generated
 */
@ProviderType
public class ArtistLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.liferay.jukebox.service.impl.ArtistLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of artists.
	*
	* @return the number of artists
	*/
	public static int getArtistsCount() {
		return getService().getArtistsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of artists
	*/
	public static java.util.List<org.liferay.jukebox.model.Artist> getArtists(
		int start, int end) {
		return getService().getArtists(start, end);
	}

	/**
	* Returns all the artists matching the UUID and company.
	*
	* @param uuid the UUID of the artists
	* @param companyId the primary key of the company
	* @return the matching artists, or an empty list if no matches were found
	*/
	public static java.util.List<org.liferay.jukebox.model.Artist> getArtistsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getArtistsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of artists matching the UUID and company.
	*
	* @param uuid the UUID of the artists
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching artists, or an empty list if no matches were found
	*/
	public static java.util.List<org.liferay.jukebox.model.Artist> getArtistsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.liferay.jukebox.model.Artist> orderByComparator) {
		return getService()
				   .getArtistsByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	/**
	* Adds the artist to the database. Also notifies the appropriate model listeners.
	*
	* @param artist the artist
	* @return the artist that was added
	*/
	public static org.liferay.jukebox.model.Artist addArtist(
		org.liferay.jukebox.model.Artist artist) {
		return getService().addArtist(artist);
	}

	/**
	* Creates a new artist with the primary key. Does not add the artist to the database.
	*
	* @param artistId the primary key for the new artist
	* @return the new artist
	*/
	public static org.liferay.jukebox.model.Artist createArtist(long artistId) {
		return getService().createArtist(artistId);
	}

	/**
	* Deletes the artist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param artistId the primary key of the artist
	* @return the artist that was removed
	* @throws PortalException if a artist with the primary key could not be found
	*/
	public static org.liferay.jukebox.model.Artist deleteArtist(long artistId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteArtist(artistId);
	}

	/**
	* Deletes the artist from the database. Also notifies the appropriate model listeners.
	*
	* @param artist the artist
	* @return the artist that was removed
	*/
	public static org.liferay.jukebox.model.Artist deleteArtist(
		org.liferay.jukebox.model.Artist artist) {
		return getService().deleteArtist(artist);
	}

	public static org.liferay.jukebox.model.Artist fetchArtist(long artistId) {
		return getService().fetchArtist(artistId);
	}

	/**
	* Returns the artist matching the UUID and group.
	*
	* @param uuid the artist's UUID
	* @param groupId the primary key of the group
	* @return the matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public static org.liferay.jukebox.model.Artist fetchArtistByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchArtistByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the artist with the primary key.
	*
	* @param artistId the primary key of the artist
	* @return the artist
	* @throws PortalException if a artist with the primary key could not be found
	*/
	public static org.liferay.jukebox.model.Artist getArtist(long artistId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getArtist(artistId);
	}

	/**
	* Returns the artist matching the UUID and group.
	*
	* @param uuid the artist's UUID
	* @param groupId the primary key of the group
	* @return the matching artist
	* @throws PortalException if a matching artist could not be found
	*/
	public static org.liferay.jukebox.model.Artist getArtistByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getArtistByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the artist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param artist the artist
	* @return the artist that was updated
	*/
	public static org.liferay.jukebox.model.Artist updateArtist(
		org.liferay.jukebox.model.Artist artist) {
		return getService().updateArtist(artist);
	}

	public static ArtistLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArtistLocalService, ArtistLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ArtistLocalService.class);
}