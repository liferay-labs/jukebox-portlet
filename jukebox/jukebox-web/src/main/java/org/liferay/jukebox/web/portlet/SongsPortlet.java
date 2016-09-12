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

package org.liferay.jukebox.web.portlet;

import javax.portlet.Portlet;

import org.liferay.jukebox.util.PortletKeys;

import org.osgi.service.component.annotations.Component;

/**
 * @author Julio Camarero
 * @author Sergio González
 * @author Eudaldo Alonso
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.css-class-wrapper=songs-portlet",
		"com.liferay.portlet.display-category=category.jukebox",
		"com.liferay.portlet.header-portlet-css=/css/jukebox.css",
		"com.liferay.portlet.header-portlet-css=/css/inlineplayer.css",
		"com.liferay.portlet.header-portlet-css=/css/flashblock.css",
		"com.liferay.portlet.header-portlet-javascript=/js/soundmanager2-jsmin.js",
		"com.liferay.portlet.header-portlet-javascript=/js/inlineplayer.js",
		"com.liferay.portlet.header-portlet-javascript=/js/songs.js",
		"com.liferay.portlet.header-portlet-javascript=/js/jukebox_search.js",
		"com.liferay.portlet.icon=/icons/songs.png",
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.preferences-owned-by-group=true",
		"com.liferay.portlet.preferences-unique-per-layout=true",
		"com.liferay.portlet.render-weight=50",
		"com.liferay.portlet.scopeable=true",
		"javax.portlet.display-name=Songs", "javax.portlet.expiration-cache=0",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/html/songs/view.jsp",
		"javax.portlet.name=" + PortletKeys.SONGS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user",
		"javax.portlet.supports.mime-type=text/html"
	},
	service = {SongsPortlet.class, Portlet.class}
)
public class SongsPortlet extends JukeboxPortlet {
}