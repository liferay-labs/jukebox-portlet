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

package org.liferay.jukebox.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.liferay.jukebox.model.Song;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the song service. This utility wraps {@link org.liferay.jukebox.service.persistence.impl.SongPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Julio Camarero
 * @see SongPersistence
 * @see org.liferay.jukebox.service.persistence.impl.SongPersistenceImpl
 * @generated
 */
@ProviderType
public class SongUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Song song) {
		getPersistence().clearCache(song);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Song> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Song> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Song> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Song update(Song song) {
		return getPersistence().update(song);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Song update(Song song, ServiceContext serviceContext) {
		return getPersistence().update(song, serviceContext);
	}

	/**
	* Returns all the songs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching songs
	*/
	public static List<Song> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the songs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the songs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUuid_First(java.lang.String uuid,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where uuid = &#63;.
	*
	* @param songId the primary key of the current song
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByUuid_PrevAndNext(long songId,
		java.lang.String uuid, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByUuid_PrevAndNext(songId, uuid, orderByComparator);
	}

	/**
	* Removes all the songs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of songs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching songs
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSongException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUUID_G(java.lang.String uuid, long groupId)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the song where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the song that was removed
	*/
	public static Song removeByUUID_G(java.lang.String uuid, long groupId)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of songs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching songs
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the songs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching songs
	*/
	public static List<Song> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the songs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUuid_C_Last(java.lang.String uuid, long companyId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByUuid_C_PrevAndNext(long songId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(songId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the songs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of songs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching songs
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the songs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching songs
	*/
	public static List<Song> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the songs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByGroupId_First(long groupId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByGroupId_First(long groupId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByGroupId_Last(long groupId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByGroupId_Last(long groupId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByGroupId_PrevAndNext(long songId, long groupId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(songId, groupId, orderByComparator);
	}

	/**
	* Returns all the songs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the songs that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByGroupId(long groupId, int start,
		int end) {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the songs that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByGroupId(long groupId, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set of songs that the user has permission to view where groupId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] filterFindByGroupId_PrevAndNext(long songId,
		long groupId, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(songId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the songs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of songs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching songs
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of songs that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching songs that the user has permission to view
	*/
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns all the songs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching songs
	*/
	public static List<Song> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the songs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUserId(long userId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByUserId(long userId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUserId_First(long userId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUserId_First(long userId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByUserId_Last(long userId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByUserId_Last(long userId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where userId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByUserId_PrevAndNext(long songId, long userId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByUserId_PrevAndNext(songId, userId, orderByComparator);
	}

	/**
	* Removes all the songs where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of songs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching songs
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the songs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching songs
	*/
	public static List<Song> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the songs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByCompanyId(long companyId, int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByCompanyId_First(long companyId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByCompanyId_First(long companyId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByCompanyId_Last(long companyId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByCompanyId_Last(long companyId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where companyId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByCompanyId_PrevAndNext(long songId,
		long companyId, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(songId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the songs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of songs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching songs
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the songs where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the matching songs
	*/
	public static List<Song> findByArtistId(long artistId) {
		return getPersistence().findByArtistId(artistId);
	}

	/**
	* Returns a range of all the songs where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByArtistId(long artistId, int start, int end) {
		return getPersistence().findByArtistId(artistId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByArtistId(artistId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByArtistId(artistId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByArtistId_First(long artistId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByArtistId_First(artistId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByArtistId_First(long artistId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByArtistId_First(artistId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByArtistId_Last(long artistId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByArtistId_Last(artistId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByArtistId_Last(long artistId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByArtistId_Last(artistId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where artistId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByArtistId_PrevAndNext(long songId, long artistId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByArtistId_PrevAndNext(songId, artistId,
			orderByComparator);
	}

	/**
	* Removes all the songs where artistId = &#63; from the database.
	*
	* @param artistId the artist ID
	*/
	public static void removeByArtistId(long artistId) {
		getPersistence().removeByArtistId(artistId);
	}

	/**
	* Returns the number of songs where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the number of matching songs
	*/
	public static int countByArtistId(long artistId) {
		return getPersistence().countByArtistId(artistId);
	}

	/**
	* Returns all the songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the matching songs
	*/
	public static List<Song> findByAlbumId(long albumId) {
		return getPersistence().findByAlbumId(albumId);
	}

	/**
	* Returns a range of all the songs where albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByAlbumId(long albumId, int start, int end) {
		return getPersistence().findByAlbumId(albumId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByAlbumId(long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByAlbumId(albumId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByAlbumId(long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByAlbumId(albumId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByAlbumId_First(long albumId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByAlbumId_First(albumId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByAlbumId_First(long albumId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByAlbumId_First(albumId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByAlbumId_Last(long albumId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByAlbumId_Last(albumId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByAlbumId_Last(long albumId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().fetchByAlbumId_Last(albumId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where albumId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByAlbumId_PrevAndNext(long songId, long albumId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByAlbumId_PrevAndNext(songId, albumId, orderByComparator);
	}

	/**
	* Removes all the songs where albumId = &#63; from the database.
	*
	* @param albumId the album ID
	*/
	public static void removeByAlbumId(long albumId) {
		getPersistence().removeByAlbumId(albumId);
	}

	/**
	* Returns the number of songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the number of matching songs
	*/
	public static int countByAlbumId(long albumId) {
		return getPersistence().countByAlbumId(albumId);
	}

	/**
	* Returns all the songs where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching songs
	*/
	public static List<Song> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	* Returns a range of all the songs where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByG_S(long groupId, int status, int start,
		int end) {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_S_First(long groupId, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_S_First(long groupId, int status,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_S_Last(long groupId, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_S_Last(long groupId, int status,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByG_S_PrevAndNext(long songId, long groupId,
		int status, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_S_PrevAndNext(songId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns all the songs that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_S(long groupId, int status) {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	* Returns a range of all the songs that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_S(long groupId, int status,
		int start, int end) {
		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_S(long groupId, int status,
		int start, int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .filterFindByG_S(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set of songs that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] filterFindByG_S_PrevAndNext(long songId, long groupId,
		int status, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(songId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the songs where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Returns the number of songs where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching songs
	*/
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Returns the number of songs that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching songs that the user has permission to view
	*/
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	* Returns all the songs where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the matching songs
	*/
	public static List<Song> findByG_A(long groupId, long albumId) {
		return getPersistence().findByG_A(groupId, albumId);
	}

	/**
	* Returns a range of all the songs where groupId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByG_A(long groupId, long albumId, int start,
		int end) {
		return getPersistence().findByG_A(groupId, albumId, start, end);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_A(long groupId, long albumId, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByG_A(groupId, albumId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_A(long groupId, long albumId, int start,
		int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_A(groupId, albumId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_A_First(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_First(groupId, albumId, orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_First(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_First(groupId, albumId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_A_Last(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_Last(groupId, albumId, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_Last(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_Last(groupId, albumId, orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByG_A_PrevAndNext(long songId, long groupId,
		long albumId, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_PrevAndNext(songId, groupId, albumId,
			orderByComparator);
	}

	/**
	* Returns all the songs that the user has permission to view where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A(long groupId, long albumId) {
		return getPersistence().filterFindByG_A(groupId, albumId);
	}

	/**
	* Returns a range of all the songs that the user has permission to view where groupId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A(long groupId, long albumId,
		int start, int end) {
		return getPersistence().filterFindByG_A(groupId, albumId, start, end);
	}

	/**
	* Returns an ordered range of all the songs that the user has permissions to view where groupId = &#63; and albumId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A(long groupId, long albumId,
		int start, int end, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .filterFindByG_A(groupId, albumId, start, end,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set of songs that the user has permission to view where groupId = &#63; and albumId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] filterFindByG_A_PrevAndNext(long songId, long groupId,
		long albumId, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .filterFindByG_A_PrevAndNext(songId, groupId, albumId,
			orderByComparator);
	}

	/**
	* Removes all the songs where groupId = &#63; and albumId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	*/
	public static void removeByG_A(long groupId, long albumId) {
		getPersistence().removeByG_A(groupId, albumId);
	}

	/**
	* Returns the number of songs where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the number of matching songs
	*/
	public static int countByG_A(long groupId, long albumId) {
		return getPersistence().countByG_A(groupId, albumId);
	}

	/**
	* Returns the number of songs that the user has permission to view where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the number of matching songs that the user has permission to view
	*/
	public static int filterCountByG_A(long groupId, long albumId) {
		return getPersistence().filterCountByG_A(groupId, albumId);
	}

	/**
	* Returns all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the matching songs
	*/
	public static List<Song> findByG_A_S(long groupId, long albumId, int status) {
		return getPersistence().findByG_A_S(groupId, albumId, status);
	}

	/**
	* Returns a range of all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end) {
		return getPersistence().findByG_A_S(groupId, albumId, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByG_A_S(groupId, albumId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_A_S(groupId, albumId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_A_S_First(long groupId, long albumId,
		int status, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_S_First(groupId, albumId, status,
			orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_S_First(long groupId, long albumId,
		int status, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_S_First(groupId, albumId, status,
			orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_A_S_Last(long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_S_Last(groupId, albumId, status, orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_S_Last(long groupId, long albumId,
		int status, OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_S_Last(groupId, albumId, status,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByG_A_S_PrevAndNext(long songId, long groupId,
		long albumId, int status, OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_A_S_PrevAndNext(songId, groupId, albumId, status,
			orderByComparator);
	}

	/**
	* Returns all the songs that the user has permission to view where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A_S(long groupId, long albumId,
		int status) {
		return getPersistence().filterFindByG_A_S(groupId, albumId, status);
	}

	/**
	* Returns a range of all the songs that the user has permission to view where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A_S(long groupId, long albumId,
		int status, int start, int end) {
		return getPersistence()
				   .filterFindByG_A_S(groupId, albumId, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs that the user has permissions to view where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_A_S(long groupId, long albumId,
		int status, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .filterFindByG_A_S(groupId, albumId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set of songs that the user has permission to view where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] filterFindByG_A_S_PrevAndNext(long songId,
		long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .filterFindByG_A_S_PrevAndNext(songId, groupId, albumId,
			status, orderByComparator);
	}

	/**
	* Removes all the songs where groupId = &#63; and albumId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	*/
	public static void removeByG_A_S(long groupId, long albumId, int status) {
		getPersistence().removeByG_A_S(groupId, albumId, status);
	}

	/**
	* Returns the number of songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the number of matching songs
	*/
	public static int countByG_A_S(long groupId, long albumId, int status) {
		return getPersistence().countByG_A_S(groupId, albumId, status);
	}

	/**
	* Returns the number of songs that the user has permission to view where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the number of matching songs that the user has permission to view
	*/
	public static int filterCountByG_A_S(long groupId, long albumId, int status) {
		return getPersistence().filterCountByG_A_S(groupId, albumId, status);
	}

	/**
	* Returns all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching songs
	*/
	public static List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status) {
		return getPersistence().findByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns a range of all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs
	*/
	public static List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching songs
	*/
	public static List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_LikeN_S_First(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_LikeN_S_First(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the first song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_LikeN_S_First(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_LikeN_S_First(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_LikeN_S_Last(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_LikeN_S_Last(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the last song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_LikeN_S_Last(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .fetchByG_LikeN_S_Last(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] findByG_LikeN_S_PrevAndNext(long songId, long groupId,
		java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .findByG_LikeN_S_PrevAndNext(songId, groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns all the songs that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status) {
		return getPersistence().filterFindByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns a range of all the songs that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end) {
		return getPersistence()
				   .filterFindByG_LikeN_S(groupId, name, status, start, end);
	}

	/**
	* Returns an ordered range of all the songs that the user has permissions to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching songs that the user has permission to view
	*/
	public static List<Song> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence()
				   .filterFindByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the songs before and after the current song in the ordered set of songs that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song[] filterFindByG_LikeN_S_PrevAndNext(long songId,
		long groupId, java.lang.String name, int status,
		OrderByComparator<Song> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence()
				   .filterFindByG_LikeN_S_PrevAndNext(songId, groupId, name,
			status, orderByComparator);
	}

	/**
	* Removes all the songs where groupId = &#63; and name LIKE &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	*/
	public static void removeByG_LikeN_S(long groupId, java.lang.String name,
		int status) {
		getPersistence().removeByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns the number of songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching songs
	*/
	public static int countByG_LikeN_S(long groupId, java.lang.String name,
		int status) {
		return getPersistence().countByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns the number of songs that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching songs that the user has permission to view
	*/
	public static int filterCountByG_LikeN_S(long groupId,
		java.lang.String name, int status) {
		return getPersistence().filterCountByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; or throws a {@link NoSuchSongException} if it could not be found.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public static Song findByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByG_A_A_N(groupId, artistId, albumId, name);
	}

	/**
	* Returns the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_A_N(long groupId, long artistId,
		long albumId, java.lang.String name) {
		return getPersistence().fetchByG_A_A_N(groupId, artistId, albumId, name);
	}

	/**
	* Returns the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public static Song fetchByG_A_A_N(long groupId, long artistId,
		long albumId, java.lang.String name, boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByG_A_A_N(groupId, artistId, albumId, name,
			retrieveFromCache);
	}

	/**
	* Removes the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the song that was removed
	*/
	public static Song removeByG_A_A_N(long groupId, long artistId,
		long albumId, java.lang.String name)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().removeByG_A_A_N(groupId, artistId, albumId, name);
	}

	/**
	* Returns the number of songs where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the number of matching songs
	*/
	public static int countByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name) {
		return getPersistence().countByG_A_A_N(groupId, artistId, albumId, name);
	}

	/**
	* Caches the song in the entity cache if it is enabled.
	*
	* @param song the song
	*/
	public static void cacheResult(Song song) {
		getPersistence().cacheResult(song);
	}

	/**
	* Caches the songs in the entity cache if it is enabled.
	*
	* @param songs the songs
	*/
	public static void cacheResult(List<Song> songs) {
		getPersistence().cacheResult(songs);
	}

	/**
	* Creates a new song with the primary key. Does not add the song to the database.
	*
	* @param songId the primary key for the new song
	* @return the new song
	*/
	public static Song create(long songId) {
		return getPersistence().create(songId);
	}

	/**
	* Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param songId the primary key of the song
	* @return the song that was removed
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song remove(long songId)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().remove(songId);
	}

	public static Song updateImpl(Song song) {
		return getPersistence().updateImpl(song);
	}

	/**
	* Returns the song with the primary key or throws a {@link NoSuchSongException} if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public static Song findByPrimaryKey(long songId)
		throws org.liferay.jukebox.exception.NoSuchSongException {
		return getPersistence().findByPrimaryKey(songId);
	}

	/**
	* Returns the song with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song, or <code>null</code> if a song with the primary key could not be found
	*/
	public static Song fetchByPrimaryKey(long songId) {
		return getPersistence().fetchByPrimaryKey(songId);
	}

	public static java.util.Map<java.io.Serializable, Song> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the songs.
	*
	* @return the songs
	*/
	public static List<Song> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the songs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @return the range of songs
	*/
	public static List<Song> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the songs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of songs
	*/
	public static List<Song> findAll(int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the songs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SongModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of songs
	* @param end the upper bound of the range of songs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of songs
	*/
	public static List<Song> findAll(int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the songs from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of songs.
	*
	* @return the number of songs
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SongPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SongPersistence, SongPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SongPersistence.class);
}