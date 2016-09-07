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
 * The extended model interface for the Album service. Represents a row in the &quot;jukebox_Album&quot; database table, with each column mapped to a property of this class.
 *
 * @author Julio Camarero
 * @see AlbumModel
 * @see org.liferay.jukebox.model.impl.AlbumImpl
 * @see org.liferay.jukebox.model.impl.AlbumModelImpl
 * @generated
 */
@ImplementationClassName("org.liferay.jukebox.model.impl.AlbumImpl")
@ProviderType
public interface Album extends AlbumModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link org.liferay.jukebox.model.impl.AlbumImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Album, Long> ALBUM_ID_ACCESSOR = new Accessor<Album, Long>() {
			@Override
			public Long get(Album album) {
				return album.getAlbumId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Album> getTypeClass() {
				return Album.class;
			}
		};
}