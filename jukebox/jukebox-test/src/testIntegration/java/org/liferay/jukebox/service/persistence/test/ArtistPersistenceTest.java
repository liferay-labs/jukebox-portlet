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

import org.liferay.jukebox.exception.NoSuchArtistException;
import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.ArtistLocalServiceUtil;
import org.liferay.jukebox.service.persistence.ArtistPersistence;
import org.liferay.jukebox.service.persistence.ArtistUtil;

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
public class ArtistPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = ArtistUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Artist> iterator = _artists.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Artist artist = _persistence.create(pk);

		Assert.assertNotNull(artist);

		Assert.assertEquals(artist.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Artist newArtist = addArtist();

		_persistence.remove(newArtist);

		Artist existingArtist = _persistence.fetchByPrimaryKey(newArtist.getPrimaryKey());

		Assert.assertNull(existingArtist);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addArtist();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Artist newArtist = _persistence.create(pk);

		newArtist.setUuid(RandomTestUtil.randomString());

		newArtist.setCompanyId(RandomTestUtil.nextLong());

		newArtist.setGroupId(RandomTestUtil.nextLong());

		newArtist.setUserId(RandomTestUtil.nextLong());

		newArtist.setUserName(RandomTestUtil.randomString());

		newArtist.setCreateDate(RandomTestUtil.nextDate());

		newArtist.setModifiedDate(RandomTestUtil.nextDate());

		newArtist.setStatus(RandomTestUtil.nextInt());

		newArtist.setStatusByUserId(RandomTestUtil.nextLong());

		newArtist.setStatusByUserName(RandomTestUtil.randomString());

		newArtist.setStatusDate(RandomTestUtil.nextDate());

		newArtist.setName(RandomTestUtil.randomString());

		newArtist.setBio(RandomTestUtil.randomString());

		_artists.add(_persistence.update(newArtist));

		Artist existingArtist = _persistence.findByPrimaryKey(newArtist.getPrimaryKey());

		Assert.assertEquals(existingArtist.getUuid(), newArtist.getUuid());
		Assert.assertEquals(existingArtist.getArtistId(),
			newArtist.getArtistId());
		Assert.assertEquals(existingArtist.getCompanyId(),
			newArtist.getCompanyId());
		Assert.assertEquals(existingArtist.getGroupId(), newArtist.getGroupId());
		Assert.assertEquals(existingArtist.getUserId(), newArtist.getUserId());
		Assert.assertEquals(existingArtist.getUserName(),
			newArtist.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingArtist.getCreateDate()),
			Time.getShortTimestamp(newArtist.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingArtist.getModifiedDate()),
			Time.getShortTimestamp(newArtist.getModifiedDate()));
		Assert.assertEquals(existingArtist.getStatus(), newArtist.getStatus());
		Assert.assertEquals(existingArtist.getStatusByUserId(),
			newArtist.getStatusByUserId());
		Assert.assertEquals(existingArtist.getStatusByUserName(),
			newArtist.getStatusByUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingArtist.getStatusDate()),
			Time.getShortTimestamp(newArtist.getStatusDate()));
		Assert.assertEquals(existingArtist.getName(), newArtist.getName());
		Assert.assertEquals(existingArtist.getBio(), newArtist.getBio());
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
	public void testCountByU_G() throws Exception {
		_persistence.countByU_G(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByU_G(0L, 0L);
	}

	@Test
	public void testCountByG_S() throws Exception {
		_persistence.countByG_S(RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt());

		_persistence.countByG_S(0L, 0);
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
		Artist newArtist = addArtist();

		Artist existingArtist = _persistence.findByPrimaryKey(newArtist.getPrimaryKey());

		Assert.assertEquals(existingArtist, newArtist);
	}

	@Test(expected = NoSuchArtistException.class)
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

	protected OrderByComparator<Artist> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("jukebox_Artist", "uuid",
			true, "artistId", true, "companyId", true, "groupId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "status", true, "statusByUserId", true,
			"statusByUserName", true, "statusDate", true, "name", true, "bio",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Artist newArtist = addArtist();

		Artist existingArtist = _persistence.fetchByPrimaryKey(newArtist.getPrimaryKey());

		Assert.assertEquals(existingArtist, newArtist);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Artist missingArtist = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingArtist);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Artist newArtist1 = addArtist();
		Artist newArtist2 = addArtist();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArtist1.getPrimaryKey());
		primaryKeys.add(newArtist2.getPrimaryKey());

		Map<Serializable, Artist> artists = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, artists.size());
		Assert.assertEquals(newArtist1, artists.get(newArtist1.getPrimaryKey()));
		Assert.assertEquals(newArtist2, artists.get(newArtist2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Artist> artists = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(artists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Artist newArtist = addArtist();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArtist.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Artist> artists = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, artists.size());
		Assert.assertEquals(newArtist, artists.get(newArtist.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Artist> artists = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(artists.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Artist newArtist = addArtist();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newArtist.getPrimaryKey());

		Map<Serializable, Artist> artists = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, artists.size());
		Assert.assertEquals(newArtist, artists.get(newArtist.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = ArtistLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Artist>() {
				@Override
				public void performAction(Artist artist) {
					Assert.assertNotNull(artist);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Artist newArtist = addArtist();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Artist.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("artistId",
				newArtist.getArtistId()));

		List<Artist> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Artist existingArtist = result.get(0);

		Assert.assertEquals(existingArtist, newArtist);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Artist.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("artistId",
				RandomTestUtil.nextLong()));

		List<Artist> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Artist newArtist = addArtist();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Artist.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("artistId"));

		Object newArtistId = newArtist.getArtistId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("artistId",
				new Object[] { newArtistId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingArtistId = result.get(0);

		Assert.assertEquals(existingArtistId, newArtistId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Artist.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("artistId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("artistId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Artist newArtist = addArtist();

		_persistence.clearCache();

		Artist existingArtist = _persistence.findByPrimaryKey(newArtist.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingArtist.getUuid(),
				ReflectionTestUtil.invoke(existingArtist, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingArtist.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingArtist,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Artist addArtist() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Artist artist = _persistence.create(pk);

		artist.setUuid(RandomTestUtil.randomString());

		artist.setCompanyId(RandomTestUtil.nextLong());

		artist.setGroupId(RandomTestUtil.nextLong());

		artist.setUserId(RandomTestUtil.nextLong());

		artist.setUserName(RandomTestUtil.randomString());

		artist.setCreateDate(RandomTestUtil.nextDate());

		artist.setModifiedDate(RandomTestUtil.nextDate());

		artist.setStatus(RandomTestUtil.nextInt());

		artist.setStatusByUserId(RandomTestUtil.nextLong());

		artist.setStatusByUserName(RandomTestUtil.randomString());

		artist.setStatusDate(RandomTestUtil.nextDate());

		artist.setName(RandomTestUtil.randomString());

		artist.setBio(RandomTestUtil.randomString());

		_artists.add(_persistence.update(artist));

		return artist;
	}

	private List<Artist> _artists = new ArrayList<Artist>();
	private ArtistPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}