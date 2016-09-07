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

package org.liferay.jukebox.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import org.liferay.jukebox.exception.NoSuchSongException;
import org.liferay.jukebox.model.Song;
import org.liferay.jukebox.model.impl.SongImpl;
import org.liferay.jukebox.model.impl.SongModelImpl;
import org.liferay.jukebox.service.persistence.SongPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the song service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Julio Camarero
 * @see SongPersistence
 * @see org.liferay.jukebox.service.persistence.SongUtil
 * @generated
 */
@ProviderType
public class SongPersistenceImpl extends BasePersistenceImpl<Song>
	implements SongPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SongUtil} to access the song persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SongImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			SongModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the songs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Song> findByUuid(String uuid, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByUuid(String uuid, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if (!Objects.equals(uuid, song.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByUuid_First(String uuid,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUuid_First(uuid, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUuid_First(String uuid,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByUuid_Last(String uuid,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUuid_Last(uuid, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUuid_Last(String uuid,
		OrderByComparator<Song> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByUuid_PrevAndNext(long songId, String uuid,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByUuid_PrevAndNext(session, song, uuid,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByUuid_PrevAndNext(session, song, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByUuid_PrevAndNext(Session session, Song song,
		String uuid, OrderByComparator<Song> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Song song : findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching songs
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "song.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "song.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(song.uuid IS NULL OR song.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			SongModelImpl.UUID_COLUMN_BITMASK |
			SongModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the song where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchSongException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByUUID_G(String uuid, long groupId)
		throws NoSuchSongException {
		Song song = fetchByUUID_G(uuid, groupId);

		if (song == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSongException(msg.toString());
		}

		return song;
	}

	/**
	 * Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the song where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Song) {
			Song song = (Song)result;

			if (!Objects.equals(uuid, song.getUuid()) ||
					(groupId != song.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Song> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Song song = list.get(0);

					result = song;

					cacheResult(song);

					if ((song.getUuid() == null) ||
							!song.getUuid().equals(uuid) ||
							(song.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, song);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Song)result;
		}
	}

	/**
	 * Removes the song where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the song that was removed
	 */
	@Override
	public Song removeByUUID_G(String uuid, long groupId)
		throws NoSuchSongException {
		Song song = findByUUID_G(uuid, groupId);

		return remove(song);
	}

	/**
	 * Returns the number of songs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "song.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "song.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(song.uuid IS NULL OR song.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "song.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			SongModelImpl.UUID_COLUMN_BITMASK |
			SongModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the songs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Song> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Song> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if (!Objects.equals(uuid, song.getUuid()) ||
							(companyId != song.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Song findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByUuid_C(uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByUuid_C_PrevAndNext(long songId, String uuid,
		long companyId, OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, song, uuid, companyId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByUuid_C_PrevAndNext(session, song, uuid, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByUuid_C_PrevAndNext(Session session, Song song,
		String uuid, long companyId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Song song : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SONG_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "song.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "song.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(song.uuid IS NULL OR song.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "song.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			SongModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Song> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((groupId != song.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByGroupId_First(long groupId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByGroupId_First(groupId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByGroupId_First(long groupId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByGroupId_Last(long groupId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByGroupId_Last(groupId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByGroupId_Last(long groupId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByGroupId_PrevAndNext(long songId, long groupId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, song, groupId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByGroupId_PrevAndNext(session, song, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByGroupId_PrevAndNext(Session session, Song song,
		long groupId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Song song : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "song.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] { Long.class.getName() },
			SongModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
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
	@Override
	public List<Song> findByUserId(long userId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByUserId(userId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByUserId(long userId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
			finderArgs = new Object[] { userId, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((userId != song.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByUserId_First(long userId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUserId_First(userId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUserId_First(long userId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByUserId_Last(long userId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByUserId_Last(userId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByUserId_Last(long userId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByUserId(userId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByUserId_PrevAndNext(long songId, long userId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByUserId_PrevAndNext(session, song, userId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByUserId_PrevAndNext(session, song, userId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByUserId_PrevAndNext(Session session, Song song,
		long userId, OrderByComparator<Song> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (Song song : findByUserId(userId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USERID;

		Object[] finderArgs = new Object[] { userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USERID_USERID_2 = "song.userId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			SongModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByCompanyId(long companyId) {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Song> findByCompanyId(long companyId, int start, int end) {
		return findByCompanyId(companyId, start, end, null);
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
	@Override
	public List<Song> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByCompanyId(companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByCompanyId(long companyId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((companyId != song.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByCompanyId_First(long companyId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByCompanyId_First(companyId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByCompanyId_First(long companyId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByCompanyId(companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByCompanyId_Last(long companyId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByCompanyId_Last(companyId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByCompanyId_Last(long companyId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByCompanyId(companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByCompanyId_PrevAndNext(long songId, long companyId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, song, companyId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByCompanyId_PrevAndNext(session, song, companyId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByCompanyId_PrevAndNext(Session session, Song song,
		long companyId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	@Override
	public void removeByCompanyId(long companyId) {
		for (Song song : findByCompanyId(companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByCompanyId(long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "song.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTISTID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByArtistId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTISTID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByArtistId",
			new String[] { Long.class.getName() },
			SongModelImpl.ARTISTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ARTISTID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByArtistId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByArtistId(long artistId) {
		return findByArtistId(artistId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Song> findByArtistId(long artistId, int start, int end) {
		return findByArtistId(artistId, start, end, null);
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
	@Override
	public List<Song> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByArtistId(artistId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByArtistId(long artistId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTISTID;
			finderArgs = new Object[] { artistId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ARTISTID;
			finderArgs = new Object[] { artistId, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((artistId != song.getArtistId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ARTISTID_ARTISTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(artistId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByArtistId_First(long artistId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByArtistId_First(artistId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("artistId=");
		msg.append(artistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByArtistId_First(long artistId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByArtistId(artistId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByArtistId_Last(long artistId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByArtistId_Last(artistId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("artistId=");
		msg.append(artistId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByArtistId_Last(long artistId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByArtistId(artistId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByArtistId(artistId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByArtistId_PrevAndNext(long songId, long artistId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByArtistId_PrevAndNext(session, song, artistId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByArtistId_PrevAndNext(session, song, artistId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByArtistId_PrevAndNext(Session session, Song song,
		long artistId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_ARTISTID_ARTISTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(artistId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where artistId = &#63; from the database.
	 *
	 * @param artistId the artist ID
	 */
	@Override
	public void removeByArtistId(long artistId) {
		for (Song song : findByArtistId(artistId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where artistId = &#63;.
	 *
	 * @param artistId the artist ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByArtistId(long artistId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ARTISTID;

		Object[] finderArgs = new Object[] { artistId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ARTISTID_ARTISTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(artistId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ARTISTID_ARTISTID_2 = "song.artistId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUMID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAlbumId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAlbumId",
			new String[] { Long.class.getName() },
			SongModelImpl.ALBUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ALBUMID = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAlbumId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the songs where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByAlbumId(long albumId) {
		return findByAlbumId(albumId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByAlbumId(long albumId, int start, int end) {
		return findByAlbumId(albumId, start, end, null);
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
	@Override
	public List<Song> findByAlbumId(long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByAlbumId(albumId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByAlbumId(long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID;
			finderArgs = new Object[] { albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_ALBUMID;
			finderArgs = new Object[] { albumId, start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((albumId != song.getAlbumId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(albumId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByAlbumId_First(long albumId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByAlbumId_First(albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByAlbumId_First(long albumId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByAlbumId(albumId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song
	 * @throws NoSuchSongException if a matching song could not be found
	 */
	@Override
	public Song findByAlbumId_Last(long albumId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByAlbumId_Last(albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByAlbumId_Last(long albumId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByAlbumId(albumId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByAlbumId(albumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByAlbumId_PrevAndNext(long songId, long albumId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByAlbumId_PrevAndNext(session, song, albumId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByAlbumId_PrevAndNext(session, song, albumId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByAlbumId_PrevAndNext(Session session, Song song,
		long albumId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(albumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where albumId = &#63; from the database.
	 *
	 * @param albumId the album ID
	 */
	@Override
	public void removeByAlbumId(long albumId) {
		for (Song song : findByAlbumId(albumId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where albumId = &#63;.
	 *
	 * @param albumId the album ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByAlbumId(long albumId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ALBUMID;

		Object[] finderArgs = new Object[] { albumId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_ALBUMID_ALBUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(albumId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ALBUMID_ALBUMID_2 = "song.albumId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() },
			SongModelImpl.GROUPID_COLUMN_BITMASK |
			SongModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the songs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByG_S(long groupId, int status) {
		return findByG_S(groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Song> findByG_S(long groupId, int status, int start, int end) {
		return findByG_S(groupId, status, start, end, null);
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
	@Override
	public List<Song> findByG_S(long groupId, int status, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByG_S(groupId, status, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByG_S(long groupId, int status, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, status,
					
					start, end, orderByComparator
				};
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((groupId != song.getGroupId()) ||
							(status != song.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Song findByG_S_First(long groupId, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_S_First(groupId, status, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByG_S_First(long groupId, int status,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByG_S(groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song findByG_S_Last(long groupId, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_S_Last(groupId, status, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByG_S_Last(long groupId, int status,
		OrderByComparator<Song> orderByComparator) {
		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByG_S(groupId, status, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByG_S_PrevAndNext(long songId, long groupId, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByG_S_PrevAndNext(session, song, groupId, status,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByG_S_PrevAndNext(session, song, groupId, status,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByG_S_PrevAndNext(Session session, Song song,
		long groupId, int status, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (Song song : findByG_S(groupId, status, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching songs
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "song.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "song.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_A",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A",
			new String[] { Long.class.getName(), Long.class.getName() },
			SongModelImpl.GROUPID_COLUMN_BITMASK |
			SongModelImpl.ALBUMID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the songs where groupId = &#63; and albumId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByG_A(long groupId, long albumId) {
		return findByG_A(groupId, albumId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByG_A(long groupId, long albumId, int start, int end) {
		return findByG_A(groupId, albumId, start, end, null);
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
	@Override
	public List<Song> findByG_A(long groupId, long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findByG_A(groupId, albumId, start, end, orderByComparator, true);
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
	@Override
	public List<Song> findByG_A(long groupId, long albumId, int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] { groupId, albumId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A;
			finderArgs = new Object[] {
					groupId, albumId,
					
					start, end, orderByComparator
				};
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((groupId != song.getGroupId()) ||
							(albumId != song.getAlbumId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ALBUMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(albumId);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Song findByG_A_First(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_A_First(groupId, albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the first song in the ordered set where groupId = &#63; and albumId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByG_A_First(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByG_A(groupId, albumId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song findByG_A_Last(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_A_Last(groupId, albumId, orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
	}

	/**
	 * Returns the last song in the ordered set where groupId = &#63; and albumId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching song, or <code>null</code> if a matching song could not be found
	 */
	@Override
	public Song fetchByG_A_Last(long groupId, long albumId,
		OrderByComparator<Song> orderByComparator) {
		int count = countByG_A(groupId, albumId);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByG_A(groupId, albumId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByG_A_PrevAndNext(long songId, long groupId,
		long albumId, OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByG_A_PrevAndNext(session, song, groupId, albumId,
					orderByComparator, true);

			array[1] = song;

			array[2] = getByG_A_PrevAndNext(session, song, groupId, albumId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByG_A_PrevAndNext(Session session, Song song,
		long groupId, long albumId, OrderByComparator<Song> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_G_A_GROUPID_2);

		query.append(_FINDER_COLUMN_G_A_ALBUMID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(albumId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where groupId = &#63; and albumId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 */
	@Override
	public void removeByG_A(long groupId, long albumId) {
		for (Song song : findByG_A(groupId, albumId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where groupId = &#63; and albumId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @return the number of matching songs
	 */
	@Override
	public int countByG_A(long groupId, long albumId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_A;

		Object[] finderArgs = new Object[] { groupId, albumId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_ALBUMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(albumId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_A_GROUPID_2 = "song.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_ALBUMID_2 = "song.albumId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_A_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_A_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			SongModelImpl.GROUPID_COLUMN_BITMASK |
			SongModelImpl.ALBUMID_COLUMN_BITMASK |
			SongModelImpl.STATUS_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A_S = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A_S",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @param status the status
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByG_A_S(long groupId, long albumId, int status) {
		return findByG_A_S(groupId, albumId, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByG_A_S(long groupId, long albumId, int status,
		int start, int end) {
		return findByG_A_S(groupId, albumId, status, start, end, null);
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
	@Override
	public List<Song> findByG_A_S(long groupId, long albumId, int status,
		int start, int end, OrderByComparator<Song> orderByComparator) {
		return findByG_A_S(groupId, albumId, status, start, end,
			orderByComparator, true);
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
	@Override
	public List<Song> findByG_A_S(long groupId, long albumId, int status,
		int start, int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A_S;
			finderArgs = new Object[] { groupId, albumId, status };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_A_S;
			finderArgs = new Object[] {
					groupId, albumId, status,
					
					start, end, orderByComparator
				};
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((groupId != song.getGroupId()) ||
							(albumId != song.getAlbumId()) ||
							(status != song.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_S_ALBUMID_2);

			query.append(_FINDER_COLUMN_G_A_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(albumId);

				qPos.add(status);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Song findByG_A_S_First(long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_A_S_First(groupId, albumId, status,
				orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
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
	@Override
	public Song fetchByG_A_S_First(long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByG_A_S(groupId, albumId, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song findByG_A_S_Last(long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_A_S_Last(groupId, albumId, status,
				orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", albumId=");
		msg.append(albumId);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
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
	@Override
	public Song fetchByG_A_S_Last(long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator) {
		int count = countByG_A_S(groupId, albumId, status);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByG_A_S(groupId, albumId, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByG_A_S_PrevAndNext(long songId, long groupId,
		long albumId, int status, OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByG_A_S_PrevAndNext(session, song, groupId, albumId,
					status, orderByComparator, true);

			array[1] = song;

			array[2] = getByG_A_S_PrevAndNext(session, song, groupId, albumId,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByG_A_S_PrevAndNext(Session session, Song song,
		long groupId, long albumId, int status,
		OrderByComparator<Song> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_G_A_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_A_S_ALBUMID_2);

		query.append(_FINDER_COLUMN_G_A_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(albumId);

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where groupId = &#63; and albumId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @param status the status
	 */
	@Override
	public void removeByG_A_S(long groupId, long albumId, int status) {
		for (Song song : findByG_A_S(groupId, albumId, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where groupId = &#63; and albumId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param albumId the album ID
	 * @param status the status
	 * @return the number of matching songs
	 */
	@Override
	public int countByG_A_S(long groupId, long albumId, int status) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_A_S;

		Object[] finderArgs = new Object[] { groupId, albumId, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_S_ALBUMID_2);

			query.append(_FINDER_COLUMN_G_A_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(albumId);

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_A_S_GROUPID_2 = "song.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_S_ALBUMID_2 = "song.albumId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_S_STATUS_2 = "song.status = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_LIKEN_S =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_LikeN_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_LIKEN_S =
		new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByG_LikeN_S",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns all the songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the matching songs
	 */
	@Override
	public List<Song> findByG_LikeN_S(long groupId, String name, int status) {
		return findByG_LikeN_S(groupId, name, status, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findByG_LikeN_S(long groupId, String name, int status,
		int start, int end) {
		return findByG_LikeN_S(groupId, name, status, start, end, null);
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
	@Override
	public List<Song> findByG_LikeN_S(long groupId, String name, int status,
		int start, int end, OrderByComparator<Song> orderByComparator) {
		return findByG_LikeN_S(groupId, name, status, start, end,
			orderByComparator, true);
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
	@Override
	public List<Song> findByG_LikeN_S(long groupId, String name, int status,
		int start, int end, OrderByComparator<Song> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_LIKEN_S;
		finderArgs = new Object[] {
				groupId, name, status,
				
				start, end, orderByComparator
			};

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Song song : list) {
					if ((groupId != song.getGroupId()) ||
							!StringUtil.wildcardMatches(song.getName(), name,
								CharPool.UNDERLINE, CharPool.PERCENT,
								CharPool.BACK_SLASH, false) ||
							(status != song.getStatus())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_LIKEN_S_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_2);
			}

			query.append(_FINDER_COLUMN_G_LIKEN_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(SongModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
				}

				qPos.add(status);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Song findByG_LikeN_S_First(long groupId, String name, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_LikeN_S_First(groupId, name, status,
				orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
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
	@Override
	public Song fetchByG_LikeN_S_First(long groupId, String name, int status,
		OrderByComparator<Song> orderByComparator) {
		List<Song> list = findByG_LikeN_S(groupId, name, status, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song findByG_LikeN_S_Last(long groupId, String name, int status,
		OrderByComparator<Song> orderByComparator) throws NoSuchSongException {
		Song song = fetchByG_LikeN_S_Last(groupId, name, status,
				orderByComparator);

		if (song != null) {
			return song;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", name=");
		msg.append(name);

		msg.append(", status=");
		msg.append(status);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSongException(msg.toString());
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
	@Override
	public Song fetchByG_LikeN_S_Last(long groupId, String name, int status,
		OrderByComparator<Song> orderByComparator) {
		int count = countByG_LikeN_S(groupId, name, status);

		if (count == 0) {
			return null;
		}

		List<Song> list = findByG_LikeN_S(groupId, name, status, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Song[] findByG_LikeN_S_PrevAndNext(long songId, long groupId,
		String name, int status, OrderByComparator<Song> orderByComparator)
		throws NoSuchSongException {
		Song song = findByPrimaryKey(songId);

		Session session = null;

		try {
			session = openSession();

			Song[] array = new SongImpl[3];

			array[0] = getByG_LikeN_S_PrevAndNext(session, song, groupId, name,
					status, orderByComparator, true);

			array[1] = song;

			array[2] = getByG_LikeN_S_PrevAndNext(session, song, groupId, name,
					status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Song getByG_LikeN_S_PrevAndNext(Session session, Song song,
		long groupId, String name, int status,
		OrderByComparator<Song> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SONG_WHERE);

		query.append(_FINDER_COLUMN_G_LIKEN_S_GROUPID_2);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_2);
		}

		query.append(_FINDER_COLUMN_G_LIKEN_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(SongModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindName) {
			qPos.add(StringUtil.toLowerCase(name));
		}

		qPos.add(status);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(song);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Song> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the songs where groupId = &#63; and name LIKE &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 */
	@Override
	public void removeByG_LikeN_S(long groupId, String name, int status) {
		for (Song song : findByG_LikeN_S(groupId, name, status,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs where groupId = &#63; and name LIKE &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param name the name
	 * @param status the status
	 * @return the number of matching songs
	 */
	@Override
	public int countByG_LikeN_S(long groupId, String name, int status) {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_G_LIKEN_S;

		Object[] finderArgs = new Object[] { groupId, name, status };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_LIKEN_S_GROUPID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_LIKEN_S_NAME_2);
			}

			query.append(_FINDER_COLUMN_G_LIKEN_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindName) {
					qPos.add(StringUtil.toLowerCase(name));
				}

				qPos.add(status);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_LIKEN_S_GROUPID_2 = "song.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_LIKEN_S_NAME_1 = "song.name IS NULL AND ";
	private static final String _FINDER_COLUMN_G_LIKEN_S_NAME_2 = "lower(song.name) LIKE ? AND ";
	private static final String _FINDER_COLUMN_G_LIKEN_S_NAME_3 = "(song.name IS NULL OR song.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_G_LIKEN_S_STATUS_2 = "song.status = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_G_A_A_N = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, SongImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByG_A_A_N",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			},
			SongModelImpl.GROUPID_COLUMN_BITMASK |
			SongModelImpl.ARTISTID_COLUMN_BITMASK |
			SongModelImpl.ALBUMID_COLUMN_BITMASK |
			SongModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_A_A_N = new FinderPath(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_A_A_N",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				String.class.getName()
			});

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
	@Override
	public Song findByG_A_A_N(long groupId, long artistId, long albumId,
		String name) throws NoSuchSongException {
		Song song = fetchByG_A_A_N(groupId, artistId, albumId, name);

		if (song == null) {
			StringBundler msg = new StringBundler(10);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("groupId=");
			msg.append(groupId);

			msg.append(", artistId=");
			msg.append(artistId);

			msg.append(", albumId=");
			msg.append(albumId);

			msg.append(", name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSongException(msg.toString());
		}

		return song;
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
	@Override
	public Song fetchByG_A_A_N(long groupId, long artistId, long albumId,
		String name) {
		return fetchByG_A_A_N(groupId, artistId, albumId, name, true);
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
	@Override
	public Song fetchByG_A_A_N(long groupId, long artistId, long albumId,
		String name, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { groupId, artistId, albumId, name };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_G_A_A_N,
					finderArgs, this);
		}

		if (result instanceof Song) {
			Song song = (Song)result;

			if ((groupId != song.getGroupId()) ||
					(artistId != song.getArtistId()) ||
					(albumId != song.getAlbumId()) ||
					!Objects.equals(name, song.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(6);

			query.append(_SQL_SELECT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_A_N_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_A_N_ARTISTID_2);

			query.append(_FINDER_COLUMN_G_A_A_N_ALBUMID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_A_A_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_A_A_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_A_A_N_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(artistId);

				qPos.add(albumId);

				if (bindName) {
					qPos.add(name);
				}

				List<Song> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_G_A_A_N,
						finderArgs, list);
				}
				else {
					Song song = list.get(0);

					result = song;

					cacheResult(song);

					if ((song.getGroupId() != groupId) ||
							(song.getArtistId() != artistId) ||
							(song.getAlbumId() != albumId) ||
							(song.getName() == null) ||
							!song.getName().equals(name)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_G_A_A_N,
							finderArgs, song);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_G_A_A_N,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Song)result;
		}
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
	@Override
	public Song removeByG_A_A_N(long groupId, long artistId, long albumId,
		String name) throws NoSuchSongException {
		Song song = findByG_A_A_N(groupId, artistId, albumId, name);

		return remove(song);
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
	@Override
	public int countByG_A_A_N(long groupId, long artistId, long albumId,
		String name) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_A_A_N;

		Object[] finderArgs = new Object[] { groupId, artistId, albumId, name };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_SONG_WHERE);

			query.append(_FINDER_COLUMN_G_A_A_N_GROUPID_2);

			query.append(_FINDER_COLUMN_G_A_A_N_ARTISTID_2);

			query.append(_FINDER_COLUMN_G_A_A_N_ALBUMID_2);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_G_A_A_N_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_G_A_A_N_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_G_A_A_N_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(artistId);

				qPos.add(albumId);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_A_A_N_GROUPID_2 = "song.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_A_N_ARTISTID_2 = "song.artistId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_A_N_ALBUMID_2 = "song.albumId = ? AND ";
	private static final String _FINDER_COLUMN_G_A_A_N_NAME_1 = "song.name IS NULL";
	private static final String _FINDER_COLUMN_G_A_A_N_NAME_2 = "song.name = ?";
	private static final String _FINDER_COLUMN_G_A_A_N_NAME_3 = "(song.name IS NULL OR song.name = '')";

	public SongPersistenceImpl() {
		setModelClass(Song.class);
	}

	/**
	 * Caches the song in the entity cache if it is enabled.
	 *
	 * @param song the song
	 */
	@Override
	public void cacheResult(Song song) {
		entityCache.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { song.getUuid(), song.getGroupId() }, song);

		finderCache.putResult(FINDER_PATH_FETCH_BY_G_A_A_N,
			new Object[] {
				song.getGroupId(), song.getArtistId(), song.getAlbumId(),
				song.getName()
			}, song);

		song.resetOriginalValues();
	}

	/**
	 * Caches the songs in the entity cache if it is enabled.
	 *
	 * @param songs the songs
	 */
	@Override
	public void cacheResult(List<Song> songs) {
		for (Song song : songs) {
			if (entityCache.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
						SongImpl.class, song.getPrimaryKey()) == null) {
				cacheResult(song);
			}
			else {
				song.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all songs.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SongImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the song.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Song song) {
		entityCache.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SongModelImpl)song);
	}

	@Override
	public void clearCache(List<Song> songs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Song song : songs) {
			entityCache.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
				SongImpl.class, song.getPrimaryKey());

			clearUniqueFindersCache((SongModelImpl)song);
		}
	}

	protected void cacheUniqueFindersCache(SongModelImpl songModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					songModelImpl.getUuid(), songModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				songModelImpl);

			args = new Object[] {
					songModelImpl.getGroupId(), songModelImpl.getArtistId(),
					songModelImpl.getAlbumId(), songModelImpl.getName()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_G_A_A_N, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_G_A_A_N, args,
				songModelImpl);
		}
		else {
			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getUuid(), songModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					songModelImpl);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_G_A_A_N.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getGroupId(), songModelImpl.getArtistId(),
						songModelImpl.getAlbumId(), songModelImpl.getName()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_G_A_A_N, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_G_A_A_N, args,
					songModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(SongModelImpl songModelImpl) {
		Object[] args = new Object[] {
				songModelImpl.getUuid(), songModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((songModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					songModelImpl.getOriginalUuid(),
					songModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		args = new Object[] {
				songModelImpl.getGroupId(), songModelImpl.getArtistId(),
				songModelImpl.getAlbumId(), songModelImpl.getName()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A_A_N, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_G_A_A_N, args);

		if ((songModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_G_A_A_N.getColumnBitmask()) != 0) {
			args = new Object[] {
					songModelImpl.getOriginalGroupId(),
					songModelImpl.getOriginalArtistId(),
					songModelImpl.getOriginalAlbumId(),
					songModelImpl.getOriginalName()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A_A_N, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_G_A_A_N, args);
		}
	}

	/**
	 * Creates a new song with the primary key. Does not add the song to the database.
	 *
	 * @param songId the primary key for the new song
	 * @return the new song
	 */
	@Override
	public Song create(long songId) {
		Song song = new SongImpl();

		song.setNew(true);
		song.setPrimaryKey(songId);

		String uuid = PortalUUIDUtil.generate();

		song.setUuid(uuid);

		song.setCompanyId(companyProvider.getCompanyId());

		return song;
	}

	/**
	 * Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param songId the primary key of the song
	 * @return the song that was removed
	 * @throws NoSuchSongException if a song with the primary key could not be found
	 */
	@Override
	public Song remove(long songId) throws NoSuchSongException {
		return remove((Serializable)songId);
	}

	/**
	 * Removes the song with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song that was removed
	 * @throws NoSuchSongException if a song with the primary key could not be found
	 */
	@Override
	public Song remove(Serializable primaryKey) throws NoSuchSongException {
		Session session = null;

		try {
			session = openSession();

			Song song = (Song)session.get(SongImpl.class, primaryKey);

			if (song == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(song);
		}
		catch (NoSuchSongException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Song removeImpl(Song song) {
		song = toUnwrappedModel(song);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(song)) {
				song = (Song)session.get(SongImpl.class, song.getPrimaryKeyObj());
			}

			if (song != null) {
				session.delete(song);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (song != null) {
			clearCache(song);
		}

		return song;
	}

	@Override
	public Song updateImpl(Song song) {
		song = toUnwrappedModel(song);

		boolean isNew = song.isNew();

		SongModelImpl songModelImpl = (SongModelImpl)song;

		if (Validator.isNull(song.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			song.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (song.getCreateDate() == null)) {
			if (serviceContext == null) {
				song.setCreateDate(now);
			}
			else {
				song.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!songModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				song.setModifiedDate(now);
			}
			else {
				song.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (song.isNew()) {
				session.save(song);

				song.setNew(false);
			}
			else {
				song = (Song)session.merge(song);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !SongModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { songModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getOriginalUuid(),
						songModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						songModelImpl.getUuid(), songModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { songModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);

				args = new Object[] { songModelImpl.getUserId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { songModelImpl.getCompanyId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_COMPANYID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTISTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalArtistId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ARTISTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTISTID,
					args);

				args = new Object[] { songModelImpl.getArtistId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ARTISTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ARTISTID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { songModelImpl.getOriginalAlbumId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ALBUMID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID,
					args);

				args = new Object[] { songModelImpl.getAlbumId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_ALBUMID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_ALBUMID,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getOriginalGroupId(),
						songModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						songModelImpl.getGroupId(), songModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getOriginalGroupId(),
						songModelImpl.getOriginalAlbumId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);

				args = new Object[] {
						songModelImpl.getGroupId(), songModelImpl.getAlbumId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A,
					args);
			}

			if ((songModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						songModelImpl.getOriginalGroupId(),
						songModelImpl.getOriginalAlbumId(),
						songModelImpl.getOriginalStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A_S,
					args);

				args = new Object[] {
						songModelImpl.getGroupId(), songModelImpl.getAlbumId(),
						songModelImpl.getStatus()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_G_A_S, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_A_S,
					args);
			}
		}

		entityCache.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
			SongImpl.class, song.getPrimaryKey(), song, false);

		clearUniqueFindersCache(songModelImpl);
		cacheUniqueFindersCache(songModelImpl, isNew);

		song.resetOriginalValues();

		return song;
	}

	protected Song toUnwrappedModel(Song song) {
		if (song instanceof SongImpl) {
			return song;
		}

		SongImpl songImpl = new SongImpl();

		songImpl.setNew(song.isNew());
		songImpl.setPrimaryKey(song.getPrimaryKey());

		songImpl.setUuid(song.getUuid());
		songImpl.setSongId(song.getSongId());
		songImpl.setCompanyId(song.getCompanyId());
		songImpl.setGroupId(song.getGroupId());
		songImpl.setUserId(song.getUserId());
		songImpl.setUserName(song.getUserName());
		songImpl.setCreateDate(song.getCreateDate());
		songImpl.setModifiedDate(song.getModifiedDate());
		songImpl.setArtistId(song.getArtistId());
		songImpl.setAlbumId(song.getAlbumId());
		songImpl.setName(song.getName());
		songImpl.setStatus(song.getStatus());
		songImpl.setStatusByUserId(song.getStatusByUserId());
		songImpl.setStatusByUserName(song.getStatusByUserName());
		songImpl.setStatusDate(song.getStatusDate());

		return songImpl;
	}

	/**
	 * Returns the song with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song
	 * @throws NoSuchSongException if a song with the primary key could not be found
	 */
	@Override
	public Song findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSongException {
		Song song = fetchByPrimaryKey(primaryKey);

		if (song == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSongException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return song;
	}

	/**
	 * Returns the song with the primary key or throws a {@link NoSuchSongException} if it could not be found.
	 *
	 * @param songId the primary key of the song
	 * @return the song
	 * @throws NoSuchSongException if a song with the primary key could not be found
	 */
	@Override
	public Song findByPrimaryKey(long songId) throws NoSuchSongException {
		return findByPrimaryKey((Serializable)songId);
	}

	/**
	 * Returns the song with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the song
	 * @return the song, or <code>null</code> if a song with the primary key could not be found
	 */
	@Override
	public Song fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
				SongImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Song song = (Song)serializable;

		if (song == null) {
			Session session = null;

			try {
				session = openSession();

				song = (Song)session.get(SongImpl.class, primaryKey);

				if (song != null) {
					cacheResult(song);
				}
				else {
					entityCache.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
						SongImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SongModelImpl.ENTITY_CACHE_ENABLED,
					SongImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return song;
	}

	/**
	 * Returns the song with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param songId the primary key of the song
	 * @return the song, or <code>null</code> if a song with the primary key could not be found
	 */
	@Override
	public Song fetchByPrimaryKey(long songId) {
		return fetchByPrimaryKey((Serializable)songId);
	}

	@Override
	public Map<Serializable, Song> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Song> map = new HashMap<Serializable, Song>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Song song = fetchByPrimaryKey(primaryKey);

			if (song != null) {
				map.put(primaryKey, song);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SongModelImpl.ENTITY_CACHE_ENABLED,
					SongImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Song)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SONG_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Song song : (List<Song>)q.list()) {
				map.put(song.getPrimaryKeyObj(), song);

				cacheResult(song);

				uncachedPrimaryKeys.remove(song.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SongModelImpl.ENTITY_CACHE_ENABLED,
					SongImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the songs.
	 *
	 * @return the songs
	 */
	@Override
	public List<Song> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Song> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Song> findAll(int start, int end,
		OrderByComparator<Song> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Song> findAll(int start, int end,
		OrderByComparator<Song> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Song> list = null;

		if (retrieveFromCache) {
			list = (List<Song>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SONG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SONG;

				if (pagination) {
					sql = sql.concat(SongModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Song>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the songs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Song song : findAll()) {
			remove(song);
		}
	}

	/**
	 * Returns the number of songs.
	 *
	 * @return the number of songs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SONG);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SongModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the song persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SongImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SONG = "SELECT song FROM Song song";
	private static final String _SQL_SELECT_SONG_WHERE_PKS_IN = "SELECT song FROM Song song WHERE songId IN (";
	private static final String _SQL_SELECT_SONG_WHERE = "SELECT song FROM Song song WHERE ";
	private static final String _SQL_COUNT_SONG = "SELECT COUNT(song) FROM Song song";
	private static final String _SQL_COUNT_SONG_WHERE = "SELECT COUNT(song) FROM Song song WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "song.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Song exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Song exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SongPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}