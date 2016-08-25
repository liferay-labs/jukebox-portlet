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

package org.liferay.jukebox.model.impl;

import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.util.DLUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Repository;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.StringPool;

import org.liferay.jukebox.util.Constants;

/**
 * The extended model implementation for the Album service. Represents a row in the &quot;jukebox_Album&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link org.liferay.jukebox.model.Album} interface.
 * </p>
 *
 * @author Julio Camarero
 * @author Sergio González
 * @author Eudaldo Alonso
 */
public class AlbumImpl extends AlbumBaseImpl {

	public FileEntry getCustomImage() {
		Repository repository =
			PortletFileRepositoryUtil.fetchPortletRepository(
				getGroupId(), Constants.JUKEBOX_PORTLET_REPOSITORY);

		if (repository == null) {
			return null;
		}

		try {
			return PortletFileRepositoryUtil.getPortletFileEntry(
				repository.getRepositoryId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
				String.valueOf(getAlbumId()));
		}
		catch (Exception e) {
			return null;
		}
	}

	public String getImageURL(ThemeDisplay themeDisplay)
		throws PortalException {

		FileEntry fileEntry = getCustomImage();

		if (fileEntry != null) {
			return DLUtil.getPreviewURL(
				fileEntry, fileEntry.getLatestFileVersion(), themeDisplay,
				StringPool.BLANK);
		}
		else {
			return themeDisplay.getPathContext() +
				"/o/jukebox-portlet/images/vinilo.png";
		}
	}

	public boolean hasCustomImage() throws PortalException {
		FileEntry fileEntry = getCustomImage();

		if (fileEntry != null) {
			return true;
		}

		return false;
	}

}