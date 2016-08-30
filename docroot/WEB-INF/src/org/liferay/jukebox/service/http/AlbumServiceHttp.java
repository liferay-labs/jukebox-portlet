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

package org.liferay.jukebox.service.http;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import org.liferay.jukebox.service.AlbumServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link AlbumServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * {@link HttpPrincipal} parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Julio Camarero
 * @see AlbumServiceSoap
 * @see HttpPrincipal
 * @see AlbumServiceUtil
 * @generated
 */
@ProviderType
public class AlbumServiceHttp {
	public static org.liferay.jukebox.model.Album addAlbum(
		HttpPrincipal httpPrincipal, long artistId, java.lang.String name,
		int year, java.io.InputStream inputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"addAlbum", _addAlbumParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey,
					artistId, name, year, inputStream, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.liferay.jukebox.model.Album)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Album deleteAlbum(
		HttpPrincipal httpPrincipal, long albumId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"deleteAlbum", _deleteAlbumParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, albumId,
					serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.liferay.jukebox.model.Album)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbums", _getAlbumsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Album>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		HttpPrincipal httpPrincipal, long groupId, int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbums", _getAlbumsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Album>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Album> getAlbums(
		HttpPrincipal httpPrincipal, long groupId, java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbums", _getAlbumsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Album>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Album> getAlbumsByArtistId(
		HttpPrincipal httpPrincipal, long groupId, long artistId) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbumsByArtistId", _getAlbumsByArtistIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					artistId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Album>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAlbumsCount(HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbumsCount", _getAlbumsCountParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAlbumsCount(HttpPrincipal httpPrincipal, long groupId,
		java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbumsCount", _getAlbumsCountParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getAlbumsCountByArtistId(HttpPrincipal httpPrincipal,
		long groupId, long artistId) {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"getAlbumsCountByArtistId",
					_getAlbumsCountByArtistIdParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					artistId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Album moveAlbumToTrash(
		HttpPrincipal httpPrincipal, long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"moveAlbumToTrash", _moveAlbumToTrashParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, albumId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.liferay.jukebox.model.Album)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Album restoreAlbumFromTrash(
		HttpPrincipal httpPrincipal, long albumId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"restoreAlbumFromTrash",
					_restoreAlbumFromTrashParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey, albumId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.liferay.jukebox.model.Album)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Album updateAlbum(
		HttpPrincipal httpPrincipal, long albumId, long artistId,
		java.lang.String name, int year, java.io.InputStream inputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(AlbumServiceUtil.class,
					"updateAlbum", _updateAlbumParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, albumId,
					artistId, name, year, inputStream, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof com.liferay.portal.kernel.exception.PortalException) {
					throw (com.liferay.portal.kernel.exception.PortalException)e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (org.liferay.jukebox.model.Album)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(AlbumServiceHttp.class);
	private static final Class<?>[] _addAlbumParameterTypes0 = new Class[] {
			long.class, java.lang.String.class, int.class,
			java.io.InputStream.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteAlbumParameterTypes1 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getAlbumsParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getAlbumsParameterTypes3 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[] _getAlbumsParameterTypes4 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getAlbumsByArtistIdParameterTypes5 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getAlbumsCountParameterTypes6 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getAlbumsCountParameterTypes7 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getAlbumsCountByArtistIdParameterTypes8 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _moveAlbumToTrashParameterTypes9 = new Class[] {
			long.class
		};
	private static final Class<?>[] _restoreAlbumFromTrashParameterTypes10 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateAlbumParameterTypes11 = new Class[] {
			long.class, long.class, java.lang.String.class, int.class,
			java.io.InputStream.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}