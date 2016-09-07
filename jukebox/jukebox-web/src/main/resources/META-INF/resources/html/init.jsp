<%--
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
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/trash" prefix="liferay-trash" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %><%@
page import="com.liferay.portal.kernel.search.Field" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.search.Indexer" %><%@
page import="com.liferay.portal.kernel.search.IndexerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.search.QueryConfig" %><%@
page import="com.liferay.portal.kernel.search.SearchContext" %><%@
page import="com.liferay.portal.kernel.search.SearchContextFactory" %><%@
page import="com.liferay.portal.kernel.search.SearchResult" %><%@
page import="com.liferay.portal.kernel.search.SearchResultUtil" %><%@
page import="com.liferay.portal.kernel.search.Summary" %><%@
page import="com.liferay.portal.kernel.security.permission.ActionKeys" %><%@
page import="com.liferay.portal.kernel.template.TemplateHandler" %><%@
page import="com.liferay.portal.kernel.template.TemplateHandlerRegistryUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.StringPool" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.portal.kernel.xuggler.XugglerUtil" %><%@
page import="com.liferay.trash.kernel.util.TrashUtil" %>

<%@ page import="java.util.Collections" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<%@ page import="org.liferay.jukebox.exception.AlbumNameException" %><%@
page import="org.liferay.jukebox.exception.ArtistNameException" %><%@
page import="org.liferay.jukebox.exception.DuplicatedSongException" %><%@
page import="org.liferay.jukebox.exception.SongNameException" %><%@
page import="org.liferay.jukebox.model.Album" %><%@
page import="org.liferay.jukebox.model.Artist" %><%@
page import="org.liferay.jukebox.model.Song" %><%@
page import="org.liferay.jukebox.search.AlbumDisplayTerms" %><%@
page import="org.liferay.jukebox.search.AlbumSearch" %><%@
page import="org.liferay.jukebox.search.ArtistDisplayTerms" %><%@
page import="org.liferay.jukebox.search.ArtistSearch" %><%@
page import="org.liferay.jukebox.search.SongDisplayTerms" %><%@
page import="org.liferay.jukebox.search.SongSearch" %><%@
page import="org.liferay.jukebox.service.AlbumLocalServiceUtil" %><%@
page import="org.liferay.jukebox.service.AlbumServiceUtil" %><%@
page import="org.liferay.jukebox.service.ArtistLocalServiceUtil" %><%@
page import="org.liferay.jukebox.service.ArtistServiceUtil" %><%@
page import="org.liferay.jukebox.service.SongLocalServiceUtil" %><%@
page import="org.liferay.jukebox.service.SongServiceUtil" %><%@
page import="org.liferay.jukebox.service.permission.AlbumPermission" %><%@
page import="org.liferay.jukebox.service.permission.ArtistPermission" %><%@
page import="org.liferay.jukebox.service.permission.JukeBoxPermission" %><%@
page import="org.liferay.jukebox.service.permission.SongPermission" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
PortletURL currentURLObj = PortletURLUtil.getCurrent(liferayPortletRequest, liferayPortletResponse);

String currentURL = currentURLObj.toString();
%>