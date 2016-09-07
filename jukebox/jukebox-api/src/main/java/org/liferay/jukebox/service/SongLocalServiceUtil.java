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
 * Provides the local service utility for Song. This utility wraps
 * {@link org.liferay.jukebox.service.impl.SongLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Julio Camarero
 * @see SongLocalService
 * @see org.liferay.jukebox.service.base.SongLocalServiceBaseImpl
 * @see org.liferay.jukebox.service.impl.SongLocalServiceImpl
 * @generated
 */
@ProviderType
public class SongLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.liferay.jukebox.service.impl.SongLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Returns the number of songs.
	*
	* @return the number of songs
	*/
	public static int getSongsCount() {
		return getService().getSongsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the songs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link org.liferay.jukebox.model.impl.SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of songs
	*/
	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		int start, int end) {
		return getService().getSongs(start, end);
	}

	/**
	* Returns all the songs matching the UUID and company.
	*
	* @param uuid the UUID of the songs
	* @param companyId the primary key of the company
	* @return the matching songs, or an empty list if no matches were found
	*/
	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getSongsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of songs matching the UUID and company.
	*
	* @param uuid the UUID of the songs
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching songs, or an empty list if no matches were found
	*/
	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<org.liferay.jukebox.model.Song> orderByComparator) {
		return getService()
				   .getSongsByUuidAndCompanyId(uuid, companyId, start, end,
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
	* Adds the song to the database. Also notifies the appropriate model listeners.
	*
	* @param song the song
	* @return the song that was added
	*/
	public static org.liferay.jukebox.model.Song addSong(
		org.liferay.jukebox.model.Song song) {
		return getService().addSong(song);
	}

	/**
	* Creates a new song with the primary key. Does not add the song to the database.
	*
	* @param songId the primary key for the new song
	* @return the new song
	*/
	public static org.liferay.jukebox.model.Song createSong(long songId) {
		return getService().createSong(songId);
	}

	/**
	* Deletes the song with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param songId the primary key of the song
	* @return the song that was removed
	* @throws PortalException if a song with the primary key could not be found
	*/
	public static org.liferay.jukebox.model.Song deleteSong(long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSong(songId);
	}

	/**
	* Deletes the song from the database. Also notifies the appropriate model listeners.
	*
	* @param song the song
	* @return the song that was removed
	*/
	public static org.liferay.jukebox.model.Song deleteSong(
		org.liferay.jukebox.model.Song song) {
		return getService().deleteSong(song);
	}

	public static org.liferay.jukebox.model.Song fetchSong(long songId) {
		return getService().fetchSong(songId);
	}

	/**
	* Returns the song matching the UUID and group.
	*
	* @param uuid the song's UUID
	* @param groupId the primary key of the group
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public static org.liferay.jukebox.model.Song fetchSongByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchSongByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the song with the primary key.
	*
	* @param songId the primary key of the song
	* @return the song
	* @throws PortalException if a song with the primary key could not be found
	*/
	public static org.liferay.jukebox.model.Song getSong(long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSong(songId);
	}

	/**
	* Returns the song matching the UUID and group.
	*
	* @param uuid the song's UUID
	* @param groupId the primary key of the group
	* @return the matching song
	* @throws PortalException if a matching song could not be found
	*/
	public static org.liferay.jukebox.model.Song getSongByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSongByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the song in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param song the song
	* @return the song that was updated
	*/
	public static org.liferay.jukebox.model.Song updateSong(
		org.liferay.jukebox.model.Song song) {
		return getService().updateSong(song);
	}

	public static SongLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SongLocalService, SongLocalService> _serviceTracker =
		ServiceTrackerFactory.open(SongLocalService.class);
}