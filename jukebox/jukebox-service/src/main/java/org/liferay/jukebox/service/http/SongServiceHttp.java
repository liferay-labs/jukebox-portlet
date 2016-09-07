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

import org.liferay.jukebox.service.SongServiceUtil;

/**
 * Provides the HTTP utility for the
 * {@link SongServiceUtil} service utility. The
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
 * @see SongServiceSoap
 * @see HttpPrincipal
 * @see SongServiceUtil
 * @generated
 */
@ProviderType
public class SongServiceHttp {
	public static org.liferay.jukebox.model.Song addSong(
		HttpPrincipal httpPrincipal, long albumId, java.lang.String name,
		java.lang.String songFileName, java.io.InputStream songInputStream,
		java.lang.String lyricsFileName, java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"addSong", _addSongParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, albumId,
					name, songFileName, songInputStream, lyricsFileName,
					lyricsInputStream, serviceContext);

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

			return (org.liferay.jukebox.model.Song)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Song deleteSong(
		HttpPrincipal httpPrincipal, long songId,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"deleteSong", _deleteSongParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, songId,
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

			return (org.liferay.jukebox.model.Song)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongs", _getSongsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Song>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		HttpPrincipal httpPrincipal, long groupId, int start, int end) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongs", _getSongsParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Song>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongs(
		HttpPrincipal httpPrincipal, long groupId, java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongs", _getSongsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					keywords);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Song>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		HttpPrincipal httpPrincipal, long groupId, long albumId) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsByAlbumId", _getSongsByAlbumIdParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					albumId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Song>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<org.liferay.jukebox.model.Song> getSongsByAlbumId(
		HttpPrincipal httpPrincipal, long groupId, long albumId, int status) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsByAlbumId", _getSongsByAlbumIdParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					albumId, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(e);
			}

			return (java.util.List<org.liferay.jukebox.model.Song>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static int getSongsCount(HttpPrincipal httpPrincipal, long groupId) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsCount", _getSongsCountParameterTypes7);

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

	public static int getSongsCount(HttpPrincipal httpPrincipal, long groupId,
		java.lang.String keywords) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsCount", _getSongsCountParameterTypes8);

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

	public static int getSongsCountByAlbumId(HttpPrincipal httpPrincipal,
		long groupId, long albumId) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsCountByAlbumId",
					_getSongsCountByAlbumIdParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					albumId);

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

	public static int getSongsCountByAlbumId(HttpPrincipal httpPrincipal,
		long groupId, long albumId, int status) {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"getSongsCountByAlbumId",
					_getSongsCountByAlbumIdParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey, groupId,
					albumId, status);

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

	public static org.liferay.jukebox.model.Song moveSongToTrash(
		HttpPrincipal httpPrincipal, long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"moveSongToTrash", _moveSongToTrashParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, songId);

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

			return (org.liferay.jukebox.model.Song)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Song restoreSongFromTrash(
		HttpPrincipal httpPrincipal, long songId)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"restoreSongFromTrash",
					_restoreSongFromTrashParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, songId);

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

			return (org.liferay.jukebox.model.Song)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static org.liferay.jukebox.model.Song updateSong(
		HttpPrincipal httpPrincipal, long songId, long albumId,
		java.lang.String name, java.lang.String songFileName,
		java.io.InputStream songInputStream, java.lang.String lyricsFileName,
		java.io.InputStream lyricsInputStream,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		try {
			MethodKey methodKey = new MethodKey(SongServiceUtil.class,
					"updateSong", _updateSongParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, songId,
					albumId, name, songFileName, songInputStream,
					lyricsFileName, lyricsInputStream, serviceContext);

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

			return (org.liferay.jukebox.model.Song)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SongServiceHttp.class);
	private static final Class<?>[] _addSongParameterTypes0 = new Class[] {
			long.class, java.lang.String.class, java.lang.String.class,
			java.io.InputStream.class, java.lang.String.class,
			java.io.InputStream.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deleteSongParameterTypes1 = new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _getSongsParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getSongsParameterTypes3 = new Class[] {
			long.class, int.class, int.class
		};
	private static final Class<?>[] _getSongsParameterTypes4 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getSongsByAlbumIdParameterTypes5 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getSongsByAlbumIdParameterTypes6 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[] _getSongsCountParameterTypes7 = new Class[] {
			long.class
		};
	private static final Class<?>[] _getSongsCountParameterTypes8 = new Class[] {
			long.class, java.lang.String.class
		};
	private static final Class<?>[] _getSongsCountByAlbumIdParameterTypes9 = new Class[] {
			long.class, long.class
		};
	private static final Class<?>[] _getSongsCountByAlbumIdParameterTypes10 = new Class[] {
			long.class, long.class, int.class
		};
	private static final Class<?>[] _moveSongToTrashParameterTypes11 = new Class[] {
			long.class
		};
	private static final Class<?>[] _restoreSongFromTrashParameterTypes12 = new Class[] {
			long.class
		};
	private static final Class<?>[] _updateSongParameterTypes13 = new Class[] {
			long.class, long.class, java.lang.String.class,
			java.lang.String.class, java.io.InputStream.class,
			java.lang.String.class, java.io.InputStream.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
}