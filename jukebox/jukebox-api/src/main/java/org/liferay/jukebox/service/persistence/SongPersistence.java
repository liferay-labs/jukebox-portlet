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

import org.liferay.jukebox.exception.NoSuchSongException;
import org.liferay.jukebox.model.Song;

/**
 * The persistence interface for the song service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Julio Camarero
 * @see org.liferay.jukebox.service.persistence.impl.SongPersistenceImpl
 * @see SongUtil
 * @generated
 */
@ProviderType
public interface SongPersistence extends BasePersistence<Song> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SongUtil} to access the song persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the songs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching songs
	*/
	public java.util.List<Song> findByUuid(java.lang.String uuid);

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
	public java.util.List<Song> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Song> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where uuid = &#63;.
	*
	* @param songId the primary key of the current song
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByUuid_PrevAndNext(long songId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of songs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching songs
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSongException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSongException;

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the song where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the song that was removed
	*/
	public Song removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchSongException;

	/**
	* Returns the number of songs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching songs
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the songs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song[] findByUuid_C_PrevAndNext(long songId, java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of songs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching songs
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the songs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByGroupId(long groupId);

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
	public java.util.List<Song> findByGroupId(long groupId, int start, int end);

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
	public java.util.List<Song> findByGroupId(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByGroupId(long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where groupId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByGroupId_PrevAndNext(long songId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of songs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching songs
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the songs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByUserId(long userId);

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
	public java.util.List<Song> findByUserId(long userId, int start, int end);

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
	public java.util.List<Song> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByUserId(long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUserId_First(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByUserId_Last(long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where userId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByUserId_PrevAndNext(long songId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public void removeByUserId(long userId);

	/**
	* Returns the number of songs where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching songs
	*/
	public int countByUserId(long userId);

	/**
	* Returns all the songs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByCompanyId(long companyId);

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
	public java.util.List<Song> findByCompanyId(long companyId, int start,
		int end);

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
	public java.util.List<Song> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByCompanyId(long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByCompanyId_First(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByCompanyId_Last(long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where companyId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByCompanyId_PrevAndNext(long songId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	*/
	public void removeByCompanyId(long companyId);

	/**
	* Returns the number of songs where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching songs
	*/
	public int countByCompanyId(long companyId);

	/**
	* Returns all the songs where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByArtistId(long artistId);

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
	public java.util.List<Song> findByArtistId(long artistId, int start, int end);

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
	public java.util.List<Song> findByArtistId(long artistId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByArtistId(long artistId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByArtistId_First(long artistId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByArtistId_First(long artistId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByArtistId_Last(long artistId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByArtistId_Last(long artistId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where artistId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param artistId the artist ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByArtistId_PrevAndNext(long songId, long artistId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where artistId = &#63; from the database.
	*
	* @param artistId the artist ID
	*/
	public void removeByArtistId(long artistId);

	/**
	* Returns the number of songs where artistId = &#63;.
	*
	* @param artistId the artist ID
	* @return the number of matching songs
	*/
	public int countByArtistId(long artistId);

	/**
	* Returns all the songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByAlbumId(long albumId);

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
	public java.util.List<Song> findByAlbumId(long albumId, int start, int end);

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
	public java.util.List<Song> findByAlbumId(long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByAlbumId(long albumId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByAlbumId_First(long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByAlbumId_First(long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByAlbumId_Last(long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where albumId = &#63;.
	*
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByAlbumId_Last(long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the songs before and after the current song in the ordered set where albumId = &#63;.
	*
	* @param songId the primary key of the current song
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song[] findByAlbumId_PrevAndNext(long songId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where albumId = &#63; from the database.
	*
	* @param albumId the album ID
	*/
	public void removeByAlbumId(long albumId);

	/**
	* Returns the number of songs where albumId = &#63;.
	*
	* @param albumId the album ID
	* @return the number of matching songs
	*/
	public int countByAlbumId(long albumId);

	/**
	* Returns all the songs where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching songs
	*/
	public java.util.List<Song> findByG_S(long groupId, int status);

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
	public java.util.List<Song> findByG_S(long groupId, int status, int start,
		int end);

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
	public java.util.List<Song> findByG_S(long groupId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByG_S(long groupId, int status, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_S_First(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_S_Last(long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song[] findByG_S_PrevAndNext(long songId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	*/
	public void removeByG_S(long groupId, int status);

	/**
	* Returns the number of songs where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching songs
	*/
	public int countByG_S(long groupId, int status);

	/**
	* Returns all the songs where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the matching songs
	*/
	public java.util.List<Song> findByG_A(long groupId, long albumId);

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
	public java.util.List<Song> findByG_A(long groupId, long albumId,
		int start, int end);

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
	public java.util.List<Song> findByG_A(long groupId, long albumId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByG_A(long groupId, long albumId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByG_A_First(long groupId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_A_First(long groupId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song
	* @throws NoSuchSongException if a matching song could not be found
	*/
	public Song findByG_A_Last(long groupId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_A_Last(long groupId, long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song[] findByG_A_PrevAndNext(long songId, long groupId,
		long albumId,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where groupId = &#63; and albumId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	*/
	public void removeByG_A(long groupId, long albumId);

	/**
	* Returns the number of songs where groupId = &#63; and albumId = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @return the number of matching songs
	*/
	public int countByG_A(long groupId, long albumId);

	/**
	* Returns all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the matching songs
	*/
	public java.util.List<Song> findByG_A_S(long groupId, long albumId,
		int status);

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
	public java.util.List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end);

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
	public java.util.List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByG_A_S(long groupId, long albumId,
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

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
	public Song findByG_A_S_First(long groupId, long albumId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_A_S_First(long groupId, long albumId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song findByG_A_S_Last(long groupId, long albumId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_A_S_Last(long groupId, long albumId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song[] findByG_A_S_PrevAndNext(long songId, long groupId,
		long albumId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where groupId = &#63; and albumId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	*/
	public void removeByG_A_S(long groupId, long albumId, int status);

	/**
	* Returns the number of songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param albumId the album ID
	* @param status the status
	* @return the number of matching songs
	*/
	public int countByG_A_S(long groupId, long albumId, int status);

	/**
	* Returns all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the matching songs
	*/
	public java.util.List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status);

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
	public java.util.List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end);

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
	public java.util.List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findByG_LikeN_S(long groupId,
		java.lang.String name, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

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
	public Song findByG_LikeN_S_First(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the first song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_LikeN_S_First(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song findByG_LikeN_S_Last(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Returns the last song in the ordered set where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_LikeN_S_Last(long groupId, java.lang.String name,
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public Song[] findByG_LikeN_S_PrevAndNext(long songId, long groupId,
		java.lang.String name, int status,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException;

	/**
	* Removes all the songs where groupId = &#63; and name LIKE &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	*/
	public void removeByG_LikeN_S(long groupId, java.lang.String name,
		int status);

	/**
	* Returns the number of songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param name the name
	* @param status the status
	* @return the number of matching songs
	*/
	public int countByG_LikeN_S(long groupId, java.lang.String name, int status);

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
	public Song findByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name) throws NoSuchSongException;

	/**
	* Returns the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the matching song, or <code>null</code> if a matching song could not be found
	*/
	public Song fetchByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name);

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
	public Song fetchByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the song where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63; from the database.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the song that was removed
	*/
	public Song removeByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name) throws NoSuchSongException;

	/**
	* Returns the number of songs where groupId = &#63; and artistId = &#63; and albumId = &#63; and name = &#63;.
	*
	* @param groupId the group ID
	* @param artistId the artist ID
	* @param albumId the album ID
	* @param name the name
	* @return the number of matching songs
	*/
	public int countByG_A_A_N(long groupId, long artistId, long albumId,
		java.lang.String name);

	/**
	* Caches the song in the entity cache if it is enabled.
	*
	* @param song the song
	*/
	public void cacheResult(Song song);

	/**
	* Caches the songs in the entity cache if it is enabled.
	*
	* @param songs the songs
	*/
	public void cacheResult(java.util.List<Song> songs);

	/**
	* Creates a new song with the primary key. Does not add the song to the database.
	*
	* @param songId the primary key for the new song
	* @return the new song
	*/
	public Song create(long songId);

	/**
	* Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param songId the primary key of the song
	* @return the song that was removed
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song remove(long songId) throws NoSuchSongException;

	public Song updateImpl(Song song);

	/**
	* Returns the song with the primary key or throws a {@link NoSuchSongException} if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song
	* @throws NoSuchSongException if a song with the primary key could not be found
	*/
	public Song findByPrimaryKey(long songId) throws NoSuchSongException;

	/**
	* Returns the song with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param songId the primary key of the song
	* @return the song, or <code>null</code> if a song with the primary key could not be found
	*/
	public Song fetchByPrimaryKey(long songId);

	@Override
	public java.util.Map<java.io.Serializable, Song> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the songs.
	*
	* @return the songs
	*/
	public java.util.List<Song> findAll();

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
	public java.util.List<Song> findAll(int start, int end);

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
	public java.util.List<Song> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator);

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
	public java.util.List<Song> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the songs from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of songs.
	*
	* @return the number of songs
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}