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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.liferay.jukebox.exception.NoSuchArtistException;
import org.liferay.jukebox.model.Artist;

/**
 * The persistence interface for the artist service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Julio Camarero
 * @see org.liferay.jukebox.service.persistence.impl.ArtistPersistenceImpl
 * @see ArtistUtil
 * @generated
 */
@ProviderType
public interface ArtistPersistence extends BasePersistence<Artist> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArtistUtil} to access the artist persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the artists where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching artists
	*/
	public java.util.List<Artist> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the artists where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByUuid(java.lang.String uuid, int start,
		int end);

	/**
	* Returns an ordered range of all the artists where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where uuid = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByUuid_PrevAndNext(long artistId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of artists where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching artists
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the artist where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchArtistException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchArtistException;

	/**
	* Returns the artist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the artist where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the artist where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the artist that was removed
	*/
	public Artist removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchArtistException;

	/**
	* Returns the number of artists where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching artists
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the artists where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching artists
	*/
	public java.util.List<Artist> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the artists where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the artists where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByUuid_C_PrevAndNext(long artistId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of artists where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching artists
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the artists where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching artists
	*/
	public java.util.List<Artist> findByGroupId(long groupId);

	/**
	* Returns a range of all the artists where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByGroupId(long groupId, int start, int end);

	/**
	* Returns an ordered range of all the artists where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where groupId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByGroupId_PrevAndNext(long artistId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns all the artists that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByGroupId(long groupId);

	/**
	* Returns a range of all the artists that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByGroupId(long groupId, int start,
		int end);

	/**
	* Returns an ordered range of all the artists that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set of artists that the user has permission to view where groupId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] filterFindByGroupId_PrevAndNext(long artistId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of artists where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching artists
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns the number of artists that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching artists that the user has permission to view
	*/
	public int filterCountByGroupId(long groupId);

	/**
	* Returns all the artists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching artists
	*/
	public java.util.List<Artist> findByUserId(long userId);

	/**
	* Returns a range of all the artists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByUserId(long userId, int start, int end);

	/**
	* Returns an ordered range of all the artists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where userId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByUserId_PrevAndNext(long artistId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of artists where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching artists
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the artists where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching artists
	*/
	public java.util.List<Artist> findByCompanyId(long companyId);

	/**
	* Returns a range of all the artists where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByCompanyId(long companyId, int start,
		int end);

	/**
	* Returns an ordered range of all the artists where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where companyId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByCompanyId_PrevAndNext(long artistId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of artists where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching artists
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the artists where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching artists
	*/
	public java.util.List<Artist> findByU_G(long userId, long groupId);

	/**
	* Returns a range of all the artists where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByU_G(long userId, long groupId,
		int start, int end);

	/**
	* Returns an ordered range of all the artists where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByU_G(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByU_G(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByU_G_First(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByU_G_First(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByU_G_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByU_G_Last(long userId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where userId = &#63; and groupId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByU_G_PrevAndNext(long artistId, long userId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns all the artists that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByU_G(long userId, long groupId);

	/**
	* Returns a range of all the artists that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByU_G(long userId, long groupId,
		int start, int end);

	/**
	* Returns an ordered range of all the artists that the user has permissions to view where userId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByU_G(long userId, long groupId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set of artists that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param userId the user ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] filterFindByU_G_PrevAndNext(long artistId, long userId,
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where userId = &#63; and groupId = &#63; from the database.
	*
	* @param userId the user ID
	* @param groupId the group ID
	*/
	public void removeByU_G(long userId, long groupId);

	/**
	* Returns the number of artists where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching artists
	*/
	public int countByU_G(long userId, long groupId);

	/**
	* Returns the number of artists that the user has permission to view where userId = &#63; and groupId = &#63;.
	*
	* @param userId the user ID
	* @param groupId the group ID
	* @return the number of matching artists that the user has permission to view
	*/
	public int filterCountByU_G(long userId, long groupId);

	/**
	* Returns all the artists where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching artists
	*/
	public java.util.List<Artist> findByG_S(long groupId, int status);

	/**
	* Returns a range of all the artists where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByG_S(long groupId, int status,
		int start, int end);

	/**
	* Returns an ordered range of all the artists where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByG_S_PrevAndNext(long artistId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns all the artists that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_S(long groupId, int status);

	/**
	* Returns a range of all the artists that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_S(long groupId, int status,
		int start, int end);

	/**
	* Returns an ordered range of all the artists that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_S(long groupId, int status,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set of artists that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] filterFindByG_S_PrevAndNext(long artistId, long groupId,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByG_S(long groupId, int status);

	/**
	* Returns the number of artists where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching artists
	*/
	public int countByG_S(long groupId, int status);

	/**
	* Returns the number of artists that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching artists that the user has permission to view
	*/
	public int filterCountByG_S(long groupId, int status);

	/**
	* Returns all the artists where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching artists
	*/
	public java.util.List<Artist> findByG_LikeN_S(long groupId,
		java.lang.String name, int status);

	/**
	* Returns a range of all the artists where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists
	*/
	public java.util.List<Artist> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end);

	/**
	* Returns an ordered range of all the artists where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching artists
	*/
	public java.util.List<Artist> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first artist in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByG_LikeN_S_First(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the first artist in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByG_LikeN_S_First(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the last artist in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist
	* @throws NoSuchArtistException if a matching artist could not be found
	*/
	public Artist findByG_LikeN_S_Last(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns the last artist in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching artist, or <code>null</code> if a matching artist could not be found
	*/
	public Artist fetchByG_LikeN_S_Last(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] findByG_LikeN_S_PrevAndNext(long artistId, long groupId,
		java.lang.String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Returns all the artists that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status);

	/**
	* Returns a range of all the artists that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end);

	/**
	* Returns an ordered range of all the artists that the user has permissions to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching artists that the user has permission to view
	*/
	public java.util.List<Artist> filterFindByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns the artists before and after the current artist in the ordered set of artists that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param artistId the primary key of the current artist
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist[] filterFindByG_LikeN_S_PrevAndNext(long artistId,
		long groupId, java.lang.String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator)
		throws NoSuchArtistException;

	/**
	* Removes all the artists where groupId = &#63; and name LIKE &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	*/
	public void removeByG_LikeN_S(long groupId, java.lang.String name,
		int status);

	/**
	* Returns the number of artists where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching artists
	*/
	public int countByG_LikeN_S(long groupId, java.lang.String name, int status);

	/**
	* Returns the number of artists that the user has permission to view where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching artists that the user has permission to view
	*/
	public int filterCountByG_LikeN_S(long groupId, java.lang.String name,
		int status);

	/**
	* Caches the artist in the entity cache if it is enabled.
	*
	* @param artist the artist
	*/
	public void cacheResult(Artist artist);

	/**
	* Caches the artists in the entity cache if it is enabled.
	*
	* @param artists the artists
	*/
	public void cacheResult(java.util.List<Artist> artists);

	/**
	* Creates a new artist with the primary key. Does not add the artist to the database.
	*
	* @param artistId the primary key for the new artist
	* @return the new artist
	*/
	public Artist create(long artistId);

	/**
	* Removes the artist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param artistId the primary key of the artist
	* @return the artist that was removed
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist remove(long artistId) throws NoSuchArtistException;

	public Artist updateImpl(Artist artist);

	/**
	* Returns the artist with the primary key or throws a {@link NoSuchArtistException} if it could not be found.
	*
	* @param artistId the primary key of the artist
	* @return the artist
	* @throws NoSuchArtistException if a artist with the primary key could not be found
	*/
	public Artist findByPrimaryKey(long artistId) throws NoSuchArtistException;

	/**
	* Returns the artist with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param artistId the primary key of the artist
	* @return the artist, or <code>null</code> if a artist with the primary key could not be found
	*/
	public Artist fetchByPrimaryKey(long artistId);

	@Override
	public java.util.Map<java.io.Serializable, Artist> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the artists.
	*
	* @return the artists
	*/
	public java.util.List<Artist> findAll();

	/**
	* Returns a range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @return the range of artists
	*/
	public java.util.List<Artist> findAll(int start, int end);

	/**
	* Returns an ordered range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of artists
	*/
	public java.util.List<Artist> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator);

	/**
	* Returns an ordered range of all the artists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArtistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of artists
	* @param end the upper bound of the range of artists (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of artists
	*/
	public java.util.List<Artist> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Artist> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the artists from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of artists.
	*
	* @return the number of artists
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}