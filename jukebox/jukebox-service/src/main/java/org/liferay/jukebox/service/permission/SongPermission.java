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

import org.liferay.jukebox.model.Song;
import org.liferay.jukebox.service.SongLocalServiceUtil;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 * @author Sergio González
 * @author Eudaldo Alonso
 */
@Component(
	property = {"model.class.name=org.liferay.jukebox.model.Song"},
	service = BaseModelPermissionChecker.class
)
public class SongPermission implements BaseModelPermissionChecker {

	public static void check(
			PermissionChecker permissionChecker, long songId, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, songId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static void check(
			PermissionChecker permissionChecker, Song song, String actionId)
		throws PortalException {

		if (!contains(permissionChecker, song, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(
			PermissionChecker permissionChecker, long songId, String actionId)
		throws PortalException {

		Song song = SongLocalServiceUtil.getSong(songId);

		Boolean hasPermission = StagingPermissionUtil.hasPermission(
			permissionChecker, song.getGroupId(), Song.class.getName(),
			song.getSongId(), PortletKeys.ALBUMS, actionId);

		if (hasPermission != null) {
			return hasPermission.booleanValue();
		}

		return permissionChecker.hasPermission(
			song.getGroupId(), Song.class.getName(), song.getSongId(),
			actionId);
	}

	public static boolean contains(
			PermissionChecker permissionChecker, Song song, String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			song.getGroupId(), Song.class.getName(), song.getSongId(),
			actionId);
	}
	
	@Override
	public void checkBaseModel(
			PermissionChecker permissionChecker, long groupId, long primaryKey,
			String actionId)
		throws PortalException {

		check(permissionChecker, primaryKey, actionId);
	}

}