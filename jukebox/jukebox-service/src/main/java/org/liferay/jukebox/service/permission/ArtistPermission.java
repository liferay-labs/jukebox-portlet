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

package org.liferay.jukebox.service.permission;

import com.liferay.exportimport.kernel.staging.permission.StagingPermissionUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.ArtistLocalService;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	property = {"model.class.name=org.liferay.jukebox.model.Artist"},
	service = BaseModelPermissionChecker.class
)
public class ArtistPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long artistId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, artistId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long artistId, String actionId)
		throws PortalException {

		Artist artist = _artistLocalService.getArtist(artistId);

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, artist.getGroupId(), Artist.class.getName(),
			artist.getArtistId(), PortletKeys.ALBUMS, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(
			artist.getGroupId(), Artist.class.getName(), artist.getArtistId(),
			actionId);
	}

	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}

	@Reference(unbind = "-")
	protected void setArtistLocalService(
		ArtistLocalService artistLocalService) {

		_artistLocalService = artistLocalService;
	}

	private static ArtistLocalService _artistLocalService;

}