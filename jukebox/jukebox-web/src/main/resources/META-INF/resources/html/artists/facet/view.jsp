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

<%@ include file="/html/init.jsp" %>

<%
String randomNamespace = PortalUtil.generateRandomKey(request, "portlet_search_facets_" + StringUtil.randomString()) + StringPool.UNDERLINE;

Facet facet = (Facet)request.getAttribute("search.jsp-facet");

String fieldParam = ParamUtil.getString(request, facet.getFieldId());

FacetConfiguration facetConfiguration = facet.getFacetConfiguration();

JSONObject dataJSONObject = facetConfiguration.getData();

FacetCollector facetCollector = facet.getFacetCollector();

List<TermCollector> termCollectors = facetCollector.getTermCollectors();

String cssClass = "search-facet search-".concat(HtmlUtil.escapeAttribute(facetConfiguration.getDisplayStyle()));

if (termCollectors.isEmpty()) {
	return;
}

int frequencyThreshold = dataJSONObject.getInt("frequencyThreshold");
int maxTerms = dataJSONObject.getInt("maxTerms", 10);
boolean showAssetCount = dataJSONObject.getBoolean("showAssetCount", true);

Indexer indexer = IndexerRegistryUtil.getIndexer("org.liferay.jukebox.model.Artist");
%>

<div class="panel panel-default">
	<div class="panel-heading">
		<div class="panel-title">
			<liferay-ui:message key="artists" />
		</div>
	</div>

	<div class="panel-body">
		<div class="<%= cssClass %>" data-facetFieldName="<%= facet.getFieldId() %>" id="<%= randomNamespace %>facet">
			<aui:input name="<%= facet.getFieldId() %>" type="hidden" value="<%= fieldParam %>" />

			<ul class="artist list-unstyled">
				<li class="facet-value default <%= Validator.isNull(fieldParam) ? "current-term" : StringPool.BLANK %>">
					<a class="<%= Validator.isNull(fieldParam) ? "text-primary" : "text-default" %> data-value="" href="javascript:;"><liferay-ui:message key="<%= facetConfiguration.getLabel() %>" /></a>
				</li>

				<%
				long artistId = GetterUtil.getLong(fieldParam);

				for (int i = 0; i < termCollectors.size(); i++) {
					TermCollector termCollector = termCollectors.get(i);

					long curArtistId = GetterUtil.getLong(termCollector.getTerm());

					SearchContext searchContext = SearchContextFactory.getInstance(request);

					searchContext.setAttribute("artistId", curArtistId);
					searchContext.setKeywords(StringPool.BLANK);

					Hits results = indexer.search(searchContext);

					if (results.getLength() == 0) {
						continue;
					}

					Document document = results.doc(0);

					String artistName = document.get(Field.TITLE);
				%>

					<c:if test="<%= artistId == curArtistId %>">
						<aui:script use="liferay-token-list">
							Liferay.Search.tokenList.add(
								{
									clearFields: '<%= renderResponse.getNamespace() + facet.getFieldId() %>',
									text: '<%= artistName %>'
								}
							);
						</aui:script>
					</c:if>

					<%
					if (((maxTerms > 0) && (i >= maxTerms)) || ((frequencyThreshold > 0) && (frequencyThreshold > termCollector.getFrequency()))) {
						break;
					}
					%>

					<li class="facet-value <%= (artistId == curArtistId) ? "current-term" : StringPool.BLANK %>">
						<a data-value="<%= curArtistId %>" href="javascript:;"><%= HtmlUtil.escape(artistName) %></a><c:if test="<%= showAssetCount %>"> <span class="frequency">(<%= termCollector.getFrequency() %>)</span></c:if>
					</li>

				<%
				}
				%>

			</ul>
		</div>
	</div>
</div>