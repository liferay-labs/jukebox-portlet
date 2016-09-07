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

package org.liferay.jukebox.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Song service. Represents a row in the &quot;jukebox_Song&quot; database table, with each column mapped to a property of this class.
 *
 * @author Julio Camarero
 * @see SongModel
 * @see org.liferay.jukebox.model.impl.SongImpl
 * @see org.liferay.jukebox.model.impl.SongModelImpl
 * @generated
 */
@ImplementationClassName("org.liferay.jukebox.model.impl.SongImpl")
@ProviderType
public interface Song extends SongModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.liferay.jukebox.model.impl.SongImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Song, Long> SONG_ID_ACCESSOR = new Accessor<Song, Long>() {
			@Override
			public Long get(Song song) {
				return song.getSongId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Song> getTypeClass() {
				return Song.class;
			}
		};

	public java.lang.String getImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay);

	public java.lang.String getLyricsURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.lang.String getSongURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		java.lang.String audioContainer)
		throws com.liferay.portal.kernel.exception.PortalException;
}