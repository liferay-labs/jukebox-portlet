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

package org.liferay.jukebox.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;

import org.liferay.jukebox.model.Album;
import org.liferay.jukebox.service.AlbumLocalService;
import org.liferay.jukebox.service.permission.AlbumPermission;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true, property = {"javax.portlet.name=" + PortletKeys.ALBUMS},
	service = AssetRendererFactory.class
)
public class AlbumAssetRendererFactory extends BaseAssetRendererFactory<Album> {

	public static final String CLASS_NAME = Album.class.getName();

	public static final String TYPE = "album";

	public AssetRenderer<Album> getAssetRenderer(long classPK, int type)
		throws PortalException {

		Album album = _albumLocalService.getAlbum(classPK);

		return new AlbumAssetRenderer(album);
	}

	public String getClassName() {
		return CLASS_NAME;
	}

	public String getType() {
		return TYPE;
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return AlbumPermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	@Reference(unbind = "-")
	protected void setAlbumLocalService(AlbumLocalService albumLocalService) {
		_albumLocalService = albumLocalService;
	}

	private static final boolean _LINKABLE = true;

	private static AlbumLocalService _albumLocalService;

}