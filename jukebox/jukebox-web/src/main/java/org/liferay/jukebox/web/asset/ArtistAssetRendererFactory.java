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

import org.liferay.jukebox.model.Artist;
import org.liferay.jukebox.service.ArtistLocalServiceUtil;
import org.liferay.jukebox.service.permission.ArtistPermission;
import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 */
@Component(
	immediate = true, property = {"javax.portlet.name=" + PortletKeys.ARTISTS},
	service = AssetRendererFactory.class
)
public class ArtistAssetRendererFactory
	extends BaseAssetRendererFactory<Artist> {

	public static final String CLASS_NAME = Artist.class.getName();

	public static final String TYPE = "artist";

	public AssetRenderer<Artist> getAssetRenderer(long classPK, int type)
		throws PortalException {

		Artist artist = ArtistLocalServiceUtil.getArtist(classPK);

		return new ArtistAssetRenderer(artist);
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

		return ArtistPermission.contains(permissionChecker, classPK, actionId);
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	private static final boolean _LINKABLE = true;

}