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

import org.liferay.jukebox.model.Album;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the album service. This utility wraps {@link org.liferay.jukebox.service.persistence.impl.AlbumPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Julio Camarero
 * @see AlbumPersistence
 * @see org.liferay.jukebox.service.persistence.impl.AlbumPersistenceImpl
 * @generated
 */
@ProviderType
public class AlbumUtil {
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
	public static void clearCache(Album album) {
		getPersistence().clearCache(album);
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
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Album> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Album update(Album album) {
		return getPersistence().update(album);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Album update(Album album, ServiceContext serviceContext) {
		return getPersistence().update(album, serviceContext);
	}

	/**
	* Returns all the albums where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching albums
	*/
	public static List<Album> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the albums where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the albums where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Album> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Album> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUuid_First(java.lang.String uuid,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where uuid = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByUuid_PrevAndNext(long albumId,
		java.lang.String uuid, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByUuid_PrevAndNext(albumId, uuid, orderByComparator);
	}

	/**
	* Removes all the albums where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of albums where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching albums
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the album where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchAlbumException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUUID_G(java.lang.String uuid, long groupId)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the album where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the album where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the album where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the album that was removed
	*/
	public static Album removeByUUID_G(java.lang.String uuid, long groupId)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of albums where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching albums
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the albums where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching albums
	*/
	public static List<Album> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the albums where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByUuid_C_PrevAndNext(long albumId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(albumId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the albums where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of albums where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching albums
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the albums where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching albums
	*/
	public static List<Album> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the albums where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByGroupId_First(long groupId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByGroupId_First(long groupId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByGroupId_Last(long groupId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByGroupId_Last(long groupId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where groupId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByGroupId_PrevAndNext(long albumId, long groupId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(albumId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the albums where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of albums where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching albums
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the albums where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching albums
	*/
	public static List<Album> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the albums where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByUserId(long userId, int start, int end) {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUserId(long userId, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByUserId(long userId, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUserId_First(long userId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUserId_First(long userId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByUserId_Last(long userId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByUserId_Last(long userId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where userId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByUserId_PrevAndNext(long albumId, long userId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByUserId_PrevAndNext(albumId, userId, orderByComparator);
	}

	/**
	* Removes all the albums where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of albums where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching albums
	*/
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the albums where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching albums
	*/
	public static List<Album> findByCompanyId(long companyId) {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the albums where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByCompanyId(long companyId, int start, int end) {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByCompanyId(long companyId, int start,
		int end, OrderByComparator<Album> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByCompanyId_First(long companyId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByCompanyId_First(long companyId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByCompanyId_Last(long companyId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByCompanyId_Last(long companyId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where companyId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByCompanyId_PrevAndNext(long albumId,
		long companyId, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(albumId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the albums where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public static void removeByCompanyId(long companyId) {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of albums where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching albums
	*/
	public static int countByCompanyId(long companyId) {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns all the albums where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the matching albums
	*/
	public static List<Album> findByArtistId(long artistId) {
		return getPersistence().findByArtistId(artistId);
	}

	/**
	* Returns a range of all the albums where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByArtistId(long artistId, int start, int end) {
		return getPersistence().findByArtistId(artistId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByArtistId(artistId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where artistId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param artistId the artist ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByArtistId(artistId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByArtistId_First(long artistId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByArtistId_First(artistId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByArtistId_First(long artistId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByArtistId_First(artistId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByArtistId_Last(long artistId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByArtistId_Last(artistId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByArtistId_Last(long artistId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().fetchByArtistId_Last(artistId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where artistId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByArtistId_PrevAndNext(long albumId,
		long artistId, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByArtistId_PrevAndNext(albumId, artistId,
			orderByComparator);
	}

	/**
	* Removes all the albums where artistId = &#63; from the database.
	*
	* @param artistId the artist ID
	*/
	public static void removeByArtistId(long artistId) {
		getPersistence().removeByArtistId(artistId);
	}

	/**
	* Returns the number of albums where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the number of matching albums
	*/
	public static int countByArtistId(long artistId) {
		return getPersistence().countByArtistId(artistId);
	}

	/**
	* Returns all the albums where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the matching albums
	*/
	public static List<Album> findByG_U(long groupId, long userId) {
		return getPersistence().findByG_U(groupId, userId);
	}

	/**
	* Returns a range of all the albums where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByG_U(long groupId, long userId, int start,
		int end) {
		return getPersistence().findByG_U(groupId, userId, start, end);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByG_U(groupId, userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_U(long groupId, long userId, int start,
		int end, OrderByComparator<Album> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_U(groupId, userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_U_First(long groupId, long userId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_U_First(groupId, userId, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_U_First(long groupId, long userId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_U_First(groupId, userId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_U_Last(long groupId, long userId,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_U_Last(groupId, userId, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_U_Last(long groupId, long userId,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_U_Last(groupId, userId, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where groupId = &#63; and userId = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param groupId the group ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByG_U_PrevAndNext(long albumId, long groupId,
		long userId, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_U_PrevAndNext(albumId, groupId, userId,
			orderByComparator);
	}

	/**
	* Removes all the albums where groupId = &#63; and userId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param userId the user ID
	*/
	public static void removeByG_U(long groupId, long userId) {
		getPersistence().removeByG_U(groupId, userId);
	}

	/**
	* Returns the number of albums where groupId = &#63; and userId = &#63;.
	*
	* @param groupId the group ID
	* @param userId the user ID
	* @return the number of matching albums
	*/
	public static int countByG_U(long groupId, long userId) {
		return getPersistence().countByG_U(groupId, userId);
	}

	/**
	* Returns all the albums where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching albums
	*/
	public static List<Album> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	* Returns a range of all the albums where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByG_S(long groupId, int status, int start,
		int end) {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_S(long groupId, int status, int start,
		int end, OrderByComparator<Album> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_S_First(long groupId, int status,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_S_First(long groupId, int status,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_S_Last(long groupId, int status,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_S_Last(long groupId, int status,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByG_S_PrevAndNext(long albumId, long groupId,
		int status, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_S_PrevAndNext(albumId, groupId, status,
			orderByComparator);
	}

	/**
	* Removes all the albums where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Returns the number of albums where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching albums
	*/
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Returns all the albums where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @return the matching albums
	*/
	public static List<Album> findByG_A_S(long groupId, long artistId,
		int status) {
		return getPersistence().findByG_A_S(groupId, artistId, status);
	}

	/**
	* Returns a range of all the albums where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByG_A_S(long groupId, long artistId,
		int status, int start, int end) {
		return getPersistence()
				   .findByG_A_S(groupId, artistId, status, start, end);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_A_S(long groupId, long artistId,
		int status, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByG_A_S(groupId, artistId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_A_S(long groupId, long artistId,
		int status, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_A_S(groupId, artistId, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_A_S_First(long groupId, long artistId,
		int status, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_A_S_First(groupId, artistId, status,
			orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_A_S_First(long groupId, long artistId,
		int status, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_S_First(groupId, artistId, status,
			orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_A_S_Last(long groupId, long artistId,
		int status, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_A_S_Last(groupId, artistId, status,
			orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_A_S_Last(long groupId, long artistId,
		int status, OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_A_S_Last(groupId, artistId, status,
			orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByG_A_S_PrevAndNext(long albumId, long groupId,
		long artistId, int status, OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_A_S_PrevAndNext(albumId, groupId, artistId, status,
			orderByComparator);
	}

	/**
	* Removes all the albums where groupId = &#63; and artistId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	*/
	public static void removeByG_A_S(long groupId, long artistId, int status) {
		getPersistence().removeByG_A_S(groupId, artistId, status);
	}

	/**
	* Returns the number of albums where groupId = &#63; and artistId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param status the status
	* @return the number of matching albums
	*/
	public static int countByG_A_S(long groupId, long artistId, int status) {
		return getPersistence().countByG_A_S(groupId, artistId, status);
	}

	/**
	* Returns all the albums where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching albums
	*/
	public static List<Album> findByG_LikeN_S(long groupId,
		java.lang.String name, int status) {
		return getPersistence().findByG_LikeN_S(groupId, name, status);
	}

	/**
	* Returns a range of all the albums where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of matching albums
	*/
	public static List<Album> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching albums
	*/
	public static List<Album> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_LikeN_S_First(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_LikeN_S_First(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the first album in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_LikeN_S_First(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_LikeN_S_First(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album
	* @throws NoSuchAlbumException if a matching album could not be found
	*/
	public static Album findByG_LikeN_S_Last(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_LikeN_S_Last(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the last album in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching album, or <code>null</code> if a matching album could not be found
	*/
	public static Album fetchByG_LikeN_S_Last(long groupId,
		java.lang.String name, int status,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence()
				   .fetchByG_LikeN_S_Last(groupId, name, status,
			orderByComparator);
	}

	/**
	* Returns the albums before and after the current album in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param albumId the primary key of the current album
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album[] findByG_LikeN_S_PrevAndNext(long albumId,
		long groupId, java.lang.String name, int status,
		OrderByComparator<Album> orderByComparator)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence()
				   .findByG_LikeN_S_PrevAndNext(albumId, groupId, name, status,
			orderByComparator);
	}

	/**
	* Removes all the albums where groupId = &#63; and name LIKE &#63; and status = &#63; from the database.
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
	* Returns the number of albums where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching albums
	*/
	public static int countByG_LikeN_S(long groupId, java.lang.String name,
		int status) {
		return getPersistence().countByG_LikeN_S(groupId, name, status);
	}

	/**
	* Caches the album in the entity cache if it is enabled.
	*
	* @param album the album
	*/
	public static void cacheResult(Album album) {
		getPersistence().cacheResult(album);
	}

	/**
	* Caches the albums in the entity cache if it is enabled.
	*
	* @param albums the albums
	*/
	public static void cacheResult(List<Album> albums) {
		getPersistence().cacheResult(albums);
	}

	/**
	* Creates a new album with the primary key. Does not add the album to the database.
	*
	* @param albumId the primary key for the new album
	* @return the new album
	*/
	public static Album create(long albumId) {
		return getPersistence().create(albumId);
	}

	/**
	* Removes the album with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param albumId the primary key of the album
	* @return the album that was removed
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album remove(long albumId)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().remove(albumId);
	}

	public static Album updateImpl(Album album) {
		return getPersistence().updateImpl(album);
	}

	/**
	* Returns the album with the primary key or throws a {@link NoSuchAlbumException} if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album
	* @throws NoSuchAlbumException if a album with the primary key could not be found
	*/
	public static Album findByPrimaryKey(long albumId)
		throws org.liferay.jukebox.exception.NoSuchAlbumException {
		return getPersistence().findByPrimaryKey(albumId);
	}

	/**
	* Returns the album with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param albumId the primary key of the album
	* @return the album, or <code>null</code> if a album with the primary key could not be found
	*/
	public static Album fetchByPrimaryKey(long albumId) {
		return getPersistence().fetchByPrimaryKey(albumId);
	}

	public static java.util.Map<java.io.Serializable, Album> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the albums.
	*
	* @return the albums
	*/
	public static List<Album> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @return the range of albums
	*/
	public static List<Album> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of albums
	*/
	public static List<Album> findAll(int start, int end,
		OrderByComparator<Album> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the albums.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AlbumModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of albums
	* @param end the upper bound of the range of albums (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of albums
	*/
	public static List<Album> findAll(int start, int end,
		OrderByComparator<Album> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the albums from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of albums.
	*
	* @return the number of albums
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static AlbumPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AlbumPersistence, AlbumPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AlbumPersistence.class);
}