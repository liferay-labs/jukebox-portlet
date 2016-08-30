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
 * The extended model interface for the Artist service. Represents a row in the &quot;jukebox_Artist&quot; database table, with each column mapped to a property of this class.
 *
 * @author Julio Camarero
 * @see ArtistModel
 * @see org.liferay.jukebox.model.impl.ArtistImpl
 * @see org.liferay.jukebox.model.impl.ArtistModelImpl
 * @generated
 */
@ImplementationClassName("org.liferay.jukebox.model.impl.ArtistImpl")
@ProviderType
public interface Artist extends ArtistModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.liferay.jukebox.model.impl.ArtistImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Artist, Long> ARTIST_ID_ACCESSOR = new Accessor<Artist, Long>() {
			@Override
			public Long get(Artist artist) {
				return artist.getArtistId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Artist> getTypeClass() {
				return Artist.class;
			}
		};

	public com.liferay.portal.kernel.repository.model.FileEntry getCustomImage();

	public java.lang.String getImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException;

	public boolean hasCustomImage()
		throws com.liferay.portal.kernel.exception.PortalException;
}