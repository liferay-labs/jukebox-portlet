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

package org.liferay.jukebox.web.lar;

import com.liferay.exportimport.kernel.lar.BasePortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.PortletDataHandler;
import com.liferay.exportimport.kernel.lar.PortletDataHandlerBoolean;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;

import javax.portlet.PortletPreferences;

import org.liferay.jukebox.model.Album;
import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.AlbumLocalService;
import org.liferay.jukebox.service.ArtistLocalService;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(
	property = {"javax.portlet.name=" + PortletKeys.ARTISTS},
	service = PortletDataHandler.class
)
public class JukeboxPortletDataHandler extends BasePortletDataHandler {

	public static final String NAMESPACE = "jukebox";

	public JukeboxPortletDataHandler() {
		setDeletionSystemEventStagedModelTypes(
			new StagedModelType(Artist.class),
			new StagedModelType(Album.class));
		setExportControls(
			new PortletDataHandlerBoolean(
				NAMESPACE, "albums", true, false, null, Album.class.getName()),
			new PortletDataHandlerBoolean(
				NAMESPACE, "artists", true, false, null,
				Artist.class.getName()));
		setImportControls(getExportControls());
		setPublishToLiveByDefault(true);
	}

	@Override
	protected PortletPreferences doDeleteData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		_albumLocalService.deleteAlbums(portletDataContext.getScopeGroupId());

		_artistLocalService.deleteArtists(portletDataContext.getScopeGroupId());

		return portletPreferences;
	}

	@Override
	protected String doExportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences)
		throws Exception {

		Element rootElement = addExportDataRootElement(portletDataContext);

		if (portletDataContext.getBooleanParameter(NAMESPACE, "albums")) {
			ActionableDynamicQuery albumActionableDynamicQuery =
				_albumLocalService.getExportActionableDynamicQuery(
					portletDataContext);

			albumActionableDynamicQuery.performActions();
		}

		if (portletDataContext.getBooleanParameter(NAMESPACE, "artists")) {
			ActionableDynamicQuery artistActionableDynamicQuery =
				_artistLocalService.getExportActionableDynamicQuery(
					portletDataContext);

			artistActionableDynamicQuery.performActions();
		}

		return getExportDataRootElementString(rootElement);
	}

	@Override
	protected PortletPreferences doImportData(
			PortletDataContext portletDataContext, String portletId,
			PortletPreferences portletPreferences, String data)
		throws Exception {

		if (portletDataContext.getBooleanParameter(NAMESPACE, "albums")) {
			Element albumsElement =
				portletDataContext.getImportDataGroupElement(Album.class);

			List<Element> albumElements = albumsElement.elements();

			for (Element albumElement : albumElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, albumElement);
			}
		}

		if (portletDataContext.getBooleanParameter(NAMESPACE, "artists")) {
			Element artistsElement =
				portletDataContext.getImportDataGroupElement(Artist.class);

			List<Element> artistElements = artistsElement.elements();

			for (Element artistElement : artistElements) {
				StagedModelDataHandlerUtil.importStagedModel(
					portletDataContext, artistElement);
			}
		}

		return null;
	}

	@Override
	protected void doPrepareManifestSummary(
			PortletDataContext portletDataContext,
			PortletPreferences portletPreferences)
		throws Exception {

		ActionableDynamicQuery albumActionableDynamicQuery =
			_albumLocalService.getExportActionableDynamicQuery(
				portletDataContext);

		albumActionableDynamicQuery.performCount();

		ActionableDynamicQuery artistActionableDynamicQuery =
			_artistLocalService.getExportActionableDynamicQuery(
				portletDataContext);

		artistActionableDynamicQuery.performCount();
	}

	@Reference(unbind = "-")
	protected void setAlbumLocalService(AlbumLocalService albumLocalService) {
		_albumLocalService = albumLocalService;
	}

	@Reference(unbind = "-")
	protected void setArtistLocalService(
		ArtistLocalService artistLocalService) {

		_artistLocalService = artistLocalService;
	}

	private static AlbumLocalService _albumLocalService;
	private static ArtistLocalService _artistLocalService;

}