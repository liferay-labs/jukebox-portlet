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

package org.liferay.jukebox.util;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BaseRelatedEntryIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.RelatedEntryIndexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.ArtistLocalServiceUtil;
import org.liferay.jukebox.service.permission.ArtistPermission;

/**
 * @author Eudaldo Alonso
 */
public class ArtistIndexer
	extends BaseIndexer<Artist> implements RelatedEntryIndexer {

	public static final String[] CLASS_NAMES = {Artist.class.getName()};

	public static final String PORTLET_ID = PortletKeys.ARTISTS;

	public ArtistIndexer() {
		setPermissionAware(true);
	}

	@Override
	public void addRelatedClassNames(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		_relatedEntryIndexer.addRelatedClassNames(
			contextBooleanFilter, searchContext);
	}

	@Override
	public void addRelatedEntryFields(Document document, Object obj)
		throws Exception {

		if (obj instanceof FileEntry) {
			FileEntry fileEntry = (FileEntry)obj;

			Artist artist = ArtistLocalServiceUtil.getArtist(
				fileEntry.getFileEntryId());

			document.addKeyword(
				Field.CLASS_NAME_ID,
				PortalUtil.getClassNameId(Artist.class.getName()));
			document.addKeyword(Field.CLASS_PK, artist.getArtistId());
			document.addKeyword(Field.RELATED_ENTRY, true);
		}
	}

	@Override
	public String getClassName() {
		return Artist.class.getName();
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getPortletId() {
		return PORTLET_ID;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, String entryClassName,
			long entryClassPK, String actionId)
		throws Exception {

		return ArtistPermission.contains(
			permissionChecker, entryClassPK, ActionKeys.VIEW);
	}

	@Override
	public void postProcessContextBooleanFilter(
			BooleanFilter contextBooleanFilter, SearchContext searchContext)
		throws Exception {

		addStatus(contextBooleanFilter, searchContext);
	}

	@Override
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, SearchContext searchContext)
		throws Exception {

		if (searchContext.getAttributes() == null) {
			return;
		}

		addSearchTerm(searchQuery, searchContext, Field.TITLE, true);
		addSearchTerm(searchQuery, searchContext, "bio", true);
	}

	@Override
	public void updateFullQuery(SearchContext searchContext) {
		if (searchContext.isIncludeAttachments()) {
			searchContext.addFullQueryEntryClassName(
				Artist.class.getName());
		}
	}

	@Override
	protected void doDelete(Artist artist) throws Exception {
		deleteDocument(artist.getCompanyId(), artist.getArtistId());
	}

	@Override
	protected Document doGetDocument(Artist artist) throws Exception {
		Document document = getBaseModelDocument(PORTLET_ID, artist);

		document.addDate(Field.MODIFIED_DATE, artist.getModifiedDate());
		document.addText(Field.TITLE, artist.getName());
		document.addKeyword("artistId", artist.getArtistId());
		document.addText("bio", artist.getBio());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet,
		PortletRequest portletRequest, PortletResponse portletResponse) {

		Summary summary = createSummary(document);

		summary.setMaxContentLength(200);

		String title = document.get(Field.TITLE);

		String content = snippet;

		if (Validator.isNull(snippet)) {
			content = StringUtil.shorten(document.get("bio"), 200);
		}

		return new Summary(title, content);
	}

	@Override
	protected void doReindex(Artist artist) throws Exception {
		Document document = getDocument(artist);

		SearchEngineUtil.updateDocument(
			getSearchEngineId(), artist.getCompanyId(), document);
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		Artist artist = ArtistLocalServiceUtil.getArtist(classPK);

		doReindex(artist);
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		reindexEntries(companyId);
	}

	@Override
	protected String getPortletId(SearchContext searchContext) {
		return PORTLET_ID;
	}

	protected void reindexEntries(long companyId) throws PortalException {
		final Collection<Document> documents = new ArrayList<>();

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			ArtistLocalServiceUtil.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
				}

			});

		indexableActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Artist>() {

				@Override
				public void performAction(Artist artist)
					throws PortalException {

					Document document = getDocument(artist);

					if (document != null) {
						indexableActionableDynamicQuery.addDocuments(document);
					}
				}

			});

		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		indexableActionableDynamicQuery.performActions();
	}

	private final RelatedEntryIndexer _relatedEntryIndexer =
		new BaseRelatedEntryIndexer();

}