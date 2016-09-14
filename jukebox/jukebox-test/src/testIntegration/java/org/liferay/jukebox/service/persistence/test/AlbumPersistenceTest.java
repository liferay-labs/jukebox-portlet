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

import org.liferay.jukebox.exception.NoSuchAlbumException;
import org.liferay.jukebox.model.Album;
import org.liferay.jukebox.service.AlbumLocalServiceUtil;
import org.liferay.jukebox.service.persistence.AlbumPersistence;
import org.liferay.jukebox.service.persistence.AlbumUtil;

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
public class AlbumPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = AlbumUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Album> iterator = _albums.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Album album = _persistence.create(pk);

		Assert.assertNotNull(album);

		Assert.assertEquals(album.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Album newAlbum = addAlbum();

		_persistence.remove(newAlbum);

		Album existingAlbum = _persistence.fetchByPrimaryKey(newAlbum.getPrimaryKey());

		Assert.assertNull(existingAlbum);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAlbum();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Album newAlbum = _persistence.create(pk);

		newAlbum.setUuid(RandomTestUtil.randomString());

		newAlbum.setCompanyId(RandomTestUtil.nextLong());

		newAlbum.setGroupId(RandomTestUtil.nextLong());

		newAlbum.setUserId(RandomTestUtil.nextLong());

		newAlbum.setUserName(RandomTestUtil.randomString());

		newAlbum.setCreateDate(RandomTestUtil.nextDate());

		newAlbum.setModifiedDate(RandomTestUtil.nextDate());

		newAlbum.setArtistId(RandomTestUtil.nextLong());

		newAlbum.setName(RandomTestUtil.randomString());

		newAlbum.setYear(RandomTestUtil.nextInt());

		newAlbum.setStatus(RandomTestUtil.nextInt());

		newAlbum.setStatusByUserId(RandomTestUtil.nextLong());

		newAlbum.setStatusByUserName(RandomTestUtil.randomString());

		newAlbum.setStatusDate(RandomTestUtil.nextDate());

		_albums.add(_persistence.update(newAlbum));

		Album existingAlbum = _persistence.findByPrimaryKey(newAlbum.getPrimaryKey());

		Assert.assertEquals(existingAlbum.getUuid(), newAlbum.getUuid());
		Assert.assertEquals(existingAlbum.getAlbumId(), newAlbum.getAlbumId());
		Assert.assertEquals(existingAlbum.getCompanyId(),
			newAlbum.getCompanyId());
		Assert.assertEquals(existingAlbum.getGroupId(), newAlbum.getGroupId());
		Assert.assertEquals(existingAlbum.getUserId(), newAlbum.getUserId());
		Assert.assertEquals(existingAlbum.getUserName(), newAlbum.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAlbum.getCreateDate()),
			Time.getShortTimestamp(newAlbum.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingAlbum.getModifiedDate()),
			Time.getShortTimestamp(newAlbum.getModifiedDate()));
		Assert.assertEquals(existingAlbum.getArtistId(), newAlbum.getArtistId());
		Assert.assertEquals(existingAlbum.getName(), newAlbum.getName());
		Assert.assertEquals(existingAlbum.getYear(), newAlbum.getYear());
		Assert.assertEquals(existingAlbum.getStatus(), newAlbum.getStatus());
		Assert.assertEquals(existingAlbum.getStatusByUserId(),
			newAlbum.getStatusByUserId());
		Assert.assertEquals(existingAlbum.getStatusByUserName(),
			newAlbum.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingAlbum.getStatusDate()),
			Time.getShortTimestamp(newAlbum.getStatusDate()));
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
	public void testCountByG_U() throws Exception {
		_persistence.countByG_U(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByG_U(0L, 0L);
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_S(0L, 0);
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		Album newAlbum = addAlbum();

		Album existingAlbum = _persistence.findByPrimaryKey(newAlbum.getPrimaryKey());

		Assert.assertEquals(existingAlbum, newAlbum);
	}

	@Test(expected = NoSuchAlbumException.class)
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

	protected OrderByComparator<Album> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("jukebox_Album", "uuid",
			true, "albumId", true, "companyId", true, "groupId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "artistId", true, "name", true, "year", true,
			"status", true, "statusByUserId", true, "statusByUserName", true,
			"statusDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Album newAlbum = addAlbum();

		Album existingAlbum = _persistence.fetchByPrimaryKey(newAlbum.getPrimaryKey());

		Assert.assertEquals(existingAlbum, newAlbum);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Album missingAlbum = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAlbum);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Album newAlbum1 = addAlbum();
		Album newAlbum2 = addAlbum();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAlbum1.getPrimaryKey());
		primaryKeys.add(newAlbum2.getPrimaryKey());

		Map<Serializable, Album> albums = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, albums.size());
		Assert.assertEquals(newAlbum1, albums.get(newAlbum1.getPrimaryKey()));
		Assert.assertEquals(newAlbum2, albums.get(newAlbum2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Album> albums = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(albums.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Album newAlbum = addAlbum();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAlbum.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Album> albums = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, albums.size());
		Assert.assertEquals(newAlbum, albums.get(newAlbum.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Album> albums = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(albums.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Album newAlbum = addAlbum();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAlbum.getPrimaryKey());

		Map<Serializable, Album> albums = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, albums.size());
		Assert.assertEquals(newAlbum, albums.get(newAlbum.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = AlbumLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Album>() {
				@Override
				public void performAction(Album album) {
					Assert.assertNotNull(album);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Album newAlbum = addAlbum();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Album.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("albumId",
				newAlbum.getAlbumId()));

		List<Album> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Album existingAlbum = result.get(0);

		Assert.assertEquals(existingAlbum, newAlbum);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Album.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("albumId",
				RandomTestUtil.nextLong()));

		List<Album> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Album newAlbum = addAlbum();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Album.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("albumId"));

		Object newAlbumId = newAlbum.getAlbumId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("albumId",
				new Object[] { newAlbumId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAlbumId = result.get(0);

		Assert.assertEquals(existingAlbumId, newAlbumId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Album.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("albumId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("albumId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Album newAlbum = addAlbum();

		_persistence.clearCache();

		Album existingAlbum = _persistence.findByPrimaryKey(newAlbum.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingAlbum.getUuid(),
				ReflectionTestUtil.invoke(existingAlbum, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingAlbum.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingAlbum,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Album addAlbum() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Album album = _persistence.create(pk);

		album.setUuid(RandomTestUtil.randomString());

		album.setCompanyId(RandomTestUtil.nextLong());

		album.setGroupId(RandomTestUtil.nextLong());

		album.setUserId(RandomTestUtil.nextLong());

		album.setUserName(RandomTestUtil.randomString());

		album.setCreateDate(RandomTestUtil.nextDate());

		album.setModifiedDate(RandomTestUtil.nextDate());

		album.setArtistId(RandomTestUtil.nextLong());

		album.setName(RandomTestUtil.randomString());

		album.setYear(RandomTestUtil.nextInt());

		album.setStatus(RandomTestUtil.nextInt());

		album.setStatusByUserId(RandomTestUtil.nextLong());

		album.setStatusByUserName(RandomTestUtil.randomString());

		album.setStatusDate(RandomTestUtil.nextDate());

		_albums.add(_persistence.update(album));

		return album;
	}

	private List<Album> _albums = new ArrayList<Album>();
	private AlbumPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}