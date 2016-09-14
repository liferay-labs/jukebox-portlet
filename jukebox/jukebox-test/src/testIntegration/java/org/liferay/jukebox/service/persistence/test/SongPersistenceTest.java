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

package org.liferay.jukebox.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.liferay.jukebox.exception.NoSuchSongException;
import org.liferay.jukebox.model.Song;
import org.liferay.jukebox.service.SongLocalServiceUtil;
import org.liferay.jukebox.service.persistence.SongPersistence;
import org.liferay.jukebox.service.persistence.SongUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SongPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = SongUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Song> iterator = _songs.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Song song = _persistence.create(pk);

		Assert.assertNotNull(song);

		Assert.assertEquals(song.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Song newSong = addSong();

		_persistence.remove(newSong);

		Song existingSong = _persistence.fetchByPrimaryKey(newSong.getPrimaryKey());

		Assert.assertNull(existingSong);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSong();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Song newSong = _persistence.create(pk);

		newSong.setUuid(RandomTestUtil.randomString());

		newSong.setCompanyId(RandomTestUtil.nextLong());

		newSong.setGroupId(RandomTestUtil.nextLong());

		newSong.setUserId(RandomTestUtil.nextLong());

		newSong.setUserName(RandomTestUtil.randomString());

		newSong.setCreateDate(RandomTestUtil.nextDate());

		newSong.setModifiedDate(RandomTestUtil.nextDate());

		newSong.setArtistId(RandomTestUtil.nextLong());

		newSong.setAlbumId(RandomTestUtil.nextLong());

		newSong.setName(RandomTestUtil.randomString());

		newSong.setStatus(RandomTestUtil.nextInt());

		newSong.setStatusByUserId(RandomTestUtil.nextLong());

		newSong.setStatusByUserName(RandomTestUtil.randomString());

		newSong.setStatusDate(RandomTestUtil.nextDate());

		_songs.add(_persistence.update(newSong));

		Song existingSong = _persistence.findByPrimaryKey(newSong.getPrimaryKey());

		Assert.assertEquals(existingSong.getUuid(), newSong.getUuid());
		Assert.assertEquals(existingSong.getSongId(), newSong.getSongId());
		Assert.assertEquals(existingSong.getCompanyId(), newSong.getCompanyId());
		Assert.assertEquals(existingSong.getGroupId(), newSong.getGroupId());
		Assert.assertEquals(existingSong.getUserId(), newSong.getUserId());
		Assert.assertEquals(existingSong.getUserName(), newSong.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(existingSong.getCreateDate()),
			Time.getShortTimestamp(newSong.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingSong.getModifiedDate()),
			Time.getShortTimestamp(newSong.getModifiedDate()));
		Assert.assertEquals(existingSong.getArtistId(), newSong.getArtistId());
		Assert.assertEquals(existingSong.getAlbumId(), newSong.getAlbumId());
		Assert.assertEquals(existingSong.getName(), newSong.getName());
		Assert.assertEquals(existingSong.getStatus(), newSong.getStatus());
		Assert.assertEquals(existingSong.getStatusByUserId(),
			newSong.getStatusByUserId());
		Assert.assertEquals(existingSong.getStatusByUserName(),
			newSong.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(existingSong.getStatusDate()),
			Time.getShortTimestamp(newSong.getStatusDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testCountByUserId() throws Exception {
		_persistence.countByUserId(RandomTestUtil.nextLong());

		_persistence.countByUserId(0L);
	}

	@Test
	public void testCountByCompanyId() throws Exception {
		_persistence.countByCompanyId(RandomTestUtil.nextLong());

		_persistence.countByCompanyId(0L);
	}

	@Test
	public void testCountByArtistId() throws Exception {
		_persistence.countByArtistId(RandomTestUtil.nextLong());

		_persistence.countByArtistId(0L);
	}

	@Test
	public void testCountByAlbumId() throws Exception {
		_persistence.countByAlbumId(RandomTestUtil.nextLong());

		_persistence.countByAlbumId(0L);
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_S(0L, 0);
	}

	@Test
	public void testCountByG_A() throws Exception {
		_persistence.countByG_A(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_A(0L, 0L);
	}

	@Test
	public void testCountByG_A_S() throws Exception {
		_persistence.countByG_A_S(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextInt());

		_persistence.countByG_A_S(0L, 0L, 0);
	}

	@Test
	public void testCountByG_LikeN_S() throws Exception {
		_persistence.countByG_LikeN_S(RandomTestUtil.nextLong(),
			StringPool.BLANK, RandomTestUtil.nextInt());

		_persistence.countByG_LikeN_S(0L, StringPool.NULL, 0);

		_persistence.countByG_LikeN_S(0L, (String)null, 0);
	}

	@Test
	public void testCountByG_A_A_N() throws Exception {
		_persistence.countByG_A_A_N(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong(),
			StringPool.BLANK);

		_persistence.countByG_A_A_N(0L, 0L, 0L, StringPool.NULL);

		_persistence.countByG_A_A_N(0L, 0L, 0L, (String)null);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Song newSong = addSong();

		Song existingSong = _persistence.findByPrimaryKey(newSong.getPrimaryKey());

		Assert.assertEquals(existingSong, newSong);
	}

	@Test(expected = NoSuchSongException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	@Test
	public void testFilterFindByGroupId() throws Exception {
		_persistence.filterFindByGroupId(0, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Song> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("jukebox_Song", "uuid",
			true, "songId", true, "companyId", true, "groupId", true, "userId",
			true, "userName", true, "createDate", true, "modifiedDate", true,
			"artistId", true, "albumId", true, "name", true, "status", true,
			"statusByUserId", true, "statusByUserName", true, "statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Song newSong = addSong();

		Song existingSong = _persistence.fetchByPrimaryKey(newSong.getPrimaryKey());

		Assert.assertEquals(existingSong, newSong);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Song missingSong = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSong);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Song newSong1 = addSong();
		Song newSong2 = addSong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSong1.getPrimaryKey());
		primaryKeys.add(newSong2.getPrimaryKey());

		Map<Serializable, Song> songs = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, songs.size());
		Assert.assertEquals(newSong1, songs.get(newSong1.getPrimaryKey()));
		Assert.assertEquals(newSong2, songs.get(newSong2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Song> songs = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(songs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Song newSong = addSong();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSong.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Song> songs = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, songs.size());
		Assert.assertEquals(newSong, songs.get(newSong.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Song> songs = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(songs.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Song newSong = addSong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSong.getPrimaryKey());

		Map<Serializable, Song> songs = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, songs.size());
		Assert.assertEquals(newSong, songs.get(newSong.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = SongLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Song>() {
				@Override
				public void performAction(Song song) {
					Assert.assertNotNull(song);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Song newSong = addSong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Song.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("songId",
				newSong.getSongId()));

		List<Song> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Song existingSong = result.get(0);

		Assert.assertEquals(existingSong, newSong);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Song.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("songId",
				RandomTestUtil.nextLong()));

		List<Song> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Song newSong = addSong();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Song.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("songId"));

		Object newSongId = newSong.getSongId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("songId",
				new Object[] { newSongId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSongId = result.get(0);

		Assert.assertEquals(existingSongId, newSongId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Song.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("songId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("songId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Song newSong = addSong();

		_persistence.clearCache();

		Song existingSong = _persistence.findByPrimaryKey(newSong.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingSong.getUuid(),
				ReflectionTestUtil.invoke(existingSong, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingSong.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingSong, "getOriginalGroupId",
				new Class<?>[0]));

		Assert.assertEquals(Long.valueOf(existingSong.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingSong, "getOriginalGroupId",
				new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingSong.getArtistId()),
			ReflectionTestUtil.<Long>invoke(existingSong,
				"getOriginalArtistId", new Class<?>[0]));
		Assert.assertEquals(Long.valueOf(existingSong.getAlbumId()),
			ReflectionTestUtil.<Long>invoke(existingSong, "getOriginalAlbumId",
				new Class<?>[0]));
		Assert.assertTrue(Objects.equals(existingSong.getName(),
				ReflectionTestUtil.invoke(existingSong, "getOriginalName",
					new Class<?>[0])));
	}

	protected Song addSong() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Song song = _persistence.create(pk);

		song.setUuid(RandomTestUtil.randomString());

		song.setCompanyId(RandomTestUtil.nextLong());

		song.setGroupId(RandomTestUtil.nextLong());

		song.setUserId(RandomTestUtil.nextLong());

		song.setUserName(RandomTestUtil.randomString());

		song.setCreateDate(RandomTestUtil.nextDate());

		song.setModifiedDate(RandomTestUtil.nextDate());

		song.setArtistId(RandomTestUtil.nextLong());

		song.setAlbumId(RandomTestUtil.nextLong());

		song.setName(RandomTestUtil.randomString());

		song.setStatus(RandomTestUtil.nextInt());

		song.setStatusByUserId(RandomTestUtil.nextLong());

		song.setStatusByUserName(RandomTestUtil.randomString());

		song.setStatusDate(RandomTestUtil.nextDate());

		_songs.add(_persistence.update(song));

		return song;
	}

	private List<Song> _songs = new ArrayList<Song>();
	private SongPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}