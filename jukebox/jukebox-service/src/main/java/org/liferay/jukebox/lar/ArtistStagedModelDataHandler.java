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

package org.liferay.jukebox.lar;

import com.liferay.exportimport.kernel.lar.BaseStagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.ExportImportPathUtil;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.trash.TrashHandler;
import com.liferay.portal.kernel.xml.Element;

import java.util.List;

import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.ArtistLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mate Thurzo
 */
@Component(immediate = true, service = StagedModelDataHandler.class)
public class ArtistStagedModelDataHandler
	extends BaseStagedModelDataHandler<Artist> {

	public static final String[] CLASS_NAMES = {Artist.class.getName()};

	@Override
	public void deleteStagedModel(Artist artist) throws PortalException {
		_artistLocalService.deleteArtist(artist);
	}

	@Override
	public void deleteStagedModel(
			String uuid, long groupId, String className, String extraData)
		throws PortalException {

		Artist artist = _artistLocalService.fetchArtistByUuidAndGroupId(
			uuid, groupId);

		if (artist != null) {
			_artistLocalService.deleteArtist(artist);
		}
	}

	@Override
	public List<Artist> fetchStagedModelsByUuidAndCompanyId(
		String uuid, long companyId) {

		return _artistLocalService.getArtistsByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public String[] getClassNames() {
		return CLASS_NAMES;
	}

	@Override
	public String getDisplayName(Artist artist) {
		return artist.getName();
	}

	@Override
	protected void doExportStagedModel(
			PortletDataContext portletDataContext, Artist artist)
		throws Exception {

		Element artistElement = portletDataContext.getExportDataElement(artist);

		if (artist.hasCustomImage()) {
			FileEntry fileEntry = artist.getCustomImage();

			StagedModelDataHandlerUtil.exportReferenceStagedModel(
				portletDataContext, artist, Artist.class, fileEntry,
				FileEntry.class, PortletDataContext.REFERENCE_TYPE_WEAK);
		}

		portletDataContext.addClassedModel(
			artistElement, ExportImportPathUtil.getModelPath(artist), artist);
	}

	@Override
	protected void doImportStagedModel(
			PortletDataContext portletDataContext, Artist artist)
		throws Exception {

		long userId = portletDataContext.getUserId(artist.getUserUuid());

		ServiceContext serviceContext = portletDataContext.createServiceContext(
			artist);

		Artist importedArtist = null;

		if (portletDataContext.isDataStrategyMirror()) {
			Artist existingArtist =
				_artistLocalService.fetchArtistByUuidAndGroupId(
					artist.getUuid(), portletDataContext.getScopeGroupId());

			if (existingArtist == null) {
				serviceContext.setUuid(artist.getUuid());

				importedArtist = _artistLocalService.addArtist(
					userId, artist.getName(), artist.getBio(), null,
					serviceContext);
			}
			else {
				importedArtist = _artistLocalService.updateArtist(
					userId, existingArtist.getArtistId(), artist.getName(),
					artist.getBio(), null, serviceContext);
			}
		}
		else {
			importedArtist = _artistLocalService.addArtist(
				userId, artist.getName(), artist.getBio(), null,
				serviceContext);
		}

		Element artistElement =
			portletDataContext.getImportDataStagedModelElement(artist);

		List<Element> attachmentElements =
			portletDataContext.getReferenceDataElements(
				artistElement, FileEntry.class,
				PortletDataContext.REFERENCE_TYPE_WEAK);

		for (Element attachmentElement : attachmentElements) {
			String path = attachmentElement.attributeValue("path");

			FileEntry fileEntry =
				(FileEntry)portletDataContext.getZipEntryAsObject(path);

			importedArtist = _artistLocalService.updateArtist(
				userId, importedArtist.getArtistId(), importedArtist.getName(),
				importedArtist.getBio(), fileEntry.getContentStream(),
				serviceContext);
		}

		portletDataContext.importClassedModel(artist, importedArtist);
	}

	@Override
	protected void doRestoreStagedModel(
			PortletDataContext portletDataContext, Artist artist)
		throws Exception {

		long userId = portletDataContext.getUserId(artist.getUserUuid());

		Artist existingArtist = _artistLocalService.fetchArtistByUuidAndGroupId(
			artist.getUuid(), portletDataContext.getScopeGroupId());

		if ((existingArtist == null) || !existingArtist.isInTrash()) {
			return;
		}

		TrashHandler trashHandler = existingArtist.getTrashHandler();

		if (trashHandler.isRestorable(existingArtist.getArtistId())) {
			trashHandler.restoreTrashEntry(
				userId, existingArtist.getArtistId());
		}
	}

	@Reference(unbind = "-")
	protected void setArtistLocalService(
		ArtistLocalService artistLocalService) {

		_artistLocalService = artistLocalService;
	}

	@Override
	protected boolean validateMissingReference(String uuid, long groupId) {
		Artist artist = _artistLocalService.fetchArtistByUuidAndGroupId(
			uuid, groupId);

		if (artist == null) {
			return false;
		}

		return true;
	}

	private static ArtistLocalService _artistLocalService;

}