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

package org.liferay.jukebox.service.base;

import aQute.bnd.annotation.ProviderType;

import org.liferay.jukebox.service.AlbumServiceUtil;

import java.util.Arrays;

/**
 * @author Julio Camarero
 * @generated
 */
@ProviderType
public class AlbumServiceClpInvoker {
	public AlbumServiceClpInvoker() {
		_methodName86 = "getOSGiServiceIdentifier";

		_methodParameterTypes86 = new String[] {  };

		_methodName91 = "addAlbum";

		_methodParameterTypes91 = new String[] {
				"long", "java.lang.String", "int", "java.io.InputStream",
				"com.liferay.portal.kernel.service.ServiceContext"
			};

		_methodName92 = "deleteAlbum";

		_methodParameterTypes92 = new String[] {
				"long", "com.liferay.portal.kernel.service.ServiceContext"
			};

		_methodName93 = "getAlbums";

		_methodParameterTypes93 = new String[] { "long" };

		_methodName94 = "getAlbums";

		_methodParameterTypes94 = new String[] { "long", "int", "int" };

		_methodName95 = "getAlbums";

		_methodParameterTypes95 = new String[] { "long", "java.lang.String" };

		_methodName96 = "getAlbumsByArtistId";

		_methodParameterTypes96 = new String[] { "long", "long" };

		_methodName97 = "getAlbumsCount";

		_methodParameterTypes97 = new String[] { "long" };

		_methodName98 = "getAlbumsCount";

		_methodParameterTypes98 = new String[] { "long", "java.lang.String" };

		_methodName99 = "getAlbumsCountByArtistId";

		_methodParameterTypes99 = new String[] { "long", "long" };

		_methodName100 = "moveAlbumToTrash";

		_methodParameterTypes100 = new String[] { "long" };

		_methodName101 = "restoreAlbumFromTrash";

		_methodParameterTypes101 = new String[] { "long" };

		_methodName102 = "updateAlbum";

		_methodParameterTypes102 = new String[] {
				"long", "long", "java.lang.String", "int", "java.io.InputStream",
				"com.liferay.portal.kernel.service.ServiceContext"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName86.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes86, parameterTypes)) {
			return AlbumServiceUtil.getOSGiServiceIdentifier();
		}

		if (_methodName91.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes91, parameterTypes)) {
			return AlbumServiceUtil.addAlbum(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Integer)arguments[2]).intValue(),
				(java.io.InputStream)arguments[3],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[4]);
		}

		if (_methodName92.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes92, parameterTypes)) {
			return AlbumServiceUtil.deleteAlbum(((Long)arguments[0]).longValue(),
				(com.liferay.portal.kernel.service.ServiceContext)arguments[1]);
		}

		if (_methodName93.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes93, parameterTypes)) {
			return AlbumServiceUtil.getAlbums(((Long)arguments[0]).longValue());
		}

		if (_methodName94.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes94, parameterTypes)) {
			return AlbumServiceUtil.getAlbums(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName95.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes95, parameterTypes)) {
			return AlbumServiceUtil.getAlbums(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName96.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes96, parameterTypes)) {
			return AlbumServiceUtil.getAlbumsByArtistId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName97.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes97, parameterTypes)) {
			return AlbumServiceUtil.getAlbumsCount(((Long)arguments[0]).longValue());
		}

		if (_methodName98.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes98, parameterTypes)) {
			return AlbumServiceUtil.getAlbumsCount(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName99.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes99, parameterTypes)) {
			return AlbumServiceUtil.getAlbumsCountByArtistId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName100.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes100, parameterTypes)) {
			return AlbumServiceUtil.moveAlbumToTrash(((Long)arguments[0]).longValue());
		}

		if (_methodName101.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes101, parameterTypes)) {
			return AlbumServiceUtil.restoreAlbumFromTrash(((Long)arguments[0]).longValue());
		}

		if (_methodName102.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes102, parameterTypes)) {
			return AlbumServiceUtil.updateAlbum(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Integer)arguments[3]).intValue(),
				(java.io.InputStream)arguments[4],
				(com.liferay.portal.kernel.service.ServiceContext)arguments[5]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName86;
	private String[] _methodParameterTypes86;
	private String _methodName91;
	private String[] _methodParameterTypes91;
	private String _methodName92;
	private String[] _methodParameterTypes92;
	private String _methodName93;
	private String[] _methodParameterTypes93;
	private String _methodName94;
	private String[] _methodParameterTypes94;
	private String _methodName95;
	private String[] _methodParameterTypes95;
	private String _methodName96;
	private String[] _methodParameterTypes96;
	private String _methodName97;
	private String[] _methodParameterTypes97;
	private String _methodName98;
	private String[] _methodParameterTypes98;
	private String _methodName99;
	private String[] _methodParameterTypes99;
	private String _methodName100;
	private String[] _methodParameterTypes100;
	private String _methodName101;
	private String[] _methodParameterTypes101;
	private String _methodName102;
	private String[] _methodParameterTypes102;
}