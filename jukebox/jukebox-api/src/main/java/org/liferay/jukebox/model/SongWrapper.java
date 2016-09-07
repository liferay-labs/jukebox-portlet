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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Song}.
 * </p>
 *
 * @author Julio Camarero
 * @see Song
 * @generated
 */
@ProviderType
public class SongWrapper implements Song, ModelWrapper<Song> {
	public SongWrapper(Song song) {
		_song = song;
	}

	@Override
	public Class<?> getModelClass() {
		return Song.class;
	}

	@Override
	public String getModelClassName() {
		return Song.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("songId", getSongId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("artistId", getArtistId());
		attributes.put("albumId", getAlbumId());
		attributes.put("name", getName());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long songId = (Long)attributes.get("songId");

		if (songId != null) {
			setSongId(songId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long artistId = (Long)attributes.get("artistId");

		if (artistId != null) {
			setArtistId(artistId);
		}

		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}
	}

	@Override
	public Song toEscapedModel() {
		return new SongWrapper(_song.toEscapedModel());
	}

	@Override
	public Song toUnescapedModel() {
		return new SongWrapper(_song.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this song is approved.
	*
	* @return <code>true</code> if this song is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _song.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _song.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this song is denied.
	*
	* @return <code>true</code> if this song is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _song.isDenied();
	}

	/**
	* Returns <code>true</code> if this song is a draft.
	*
	* @return <code>true</code> if this song is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _song.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _song.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this song is expired.
	*
	* @return <code>true</code> if this song is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _song.isExpired();
	}

	/**
	* Returns <code>true</code> if this song is in the Recycle Bin.
	*
	* @return <code>true</code> if this song is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _song.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this song is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this song is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrashContainer() {
		return _song.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return _song.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return _song.isInTrashImplicitly();
	}

	/**
	* Returns <code>true</code> if this song is inactive.
	*
	* @return <code>true</code> if this song is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _song.isInactive();
	}

	/**
	* Returns <code>true</code> if this song is incomplete.
	*
	* @return <code>true</code> if this song is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _song.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _song.isNew();
	}

	/**
	* Returns <code>true</code> if this song is pending.
	*
	* @return <code>true</code> if this song is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _song.isPending();
	}

	/**
	* Returns <code>true</code> if this song is scheduled.
	*
	* @return <code>true</code> if this song is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _song.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _song.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Song> toCacheModel() {
		return _song.toCacheModel();
	}

	/**
	* Returns the trash handler for this song.
	*
	* @return the trash handler for this song
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _song.getTrashHandler();
	}

	/**
	* Returns the trash entry created when this song was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this song.
	*
	* @return the trash entry created when this song was moved to the Recycle Bin
	*/
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _song.getTrashEntry();
	}

	@Override
	public int compareTo(Song song) {
		return _song.compareTo(song);
	}

	/**
	* Returns the status of this song.
	*
	* @return the status of this song
	*/
	@Override
	public int getStatus() {
		return _song.getStatus();
	}

	@Override
	public int hashCode() {
		return _song.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _song.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SongWrapper((Song)_song.clone());
	}

	@Override
	public java.lang.String getImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay) {
		return _song.getImageURL(themeDisplay);
	}

	@Override
	public java.lang.String getLyricsURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _song.getLyricsURL(themeDisplay);
	}

	/**
	* Returns the name of this song.
	*
	* @return the name of this song
	*/
	@Override
	public java.lang.String getName() {
		return _song.getName();
	}

	@Override
	public java.lang.String getSongURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay,
		java.lang.String audioContainer)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _song.getSongURL(themeDisplay, audioContainer);
	}

	/**
	* Returns the status by user name of this song.
	*
	* @return the status by user name of this song
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _song.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this song.
	*
	* @return the status by user uuid of this song
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _song.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this song.
	*
	* @return the user name of this song
	*/
	@Override
	public java.lang.String getUserName() {
		return _song.getUserName();
	}

	/**
	* Returns the user uuid of this song.
	*
	* @return the user uuid of this song
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _song.getUserUuid();
	}

	/**
	* Returns the uuid of this song.
	*
	* @return the uuid of this song
	*/
	@Override
	public java.lang.String getUuid() {
		return _song.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _song.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _song.toXmlString();
	}

	/**
	* Returns the create date of this song.
	*
	* @return the create date of this song
	*/
	@Override
	public Date getCreateDate() {
		return _song.getCreateDate();
	}

	/**
	* Returns the modified date of this song.
	*
	* @return the modified date of this song
	*/
	@Override
	public Date getModifiedDate() {
		return _song.getModifiedDate();
	}

	/**
	* Returns the status date of this song.
	*
	* @return the status date of this song
	*/
	@Override
	public Date getStatusDate() {
		return _song.getStatusDate();
	}

	/**
	* Returns the album ID of this song.
	*
	* @return the album ID of this song
	*/
	@Override
	public long getAlbumId() {
		return _song.getAlbumId();
	}

	/**
	* Returns the artist ID of this song.
	*
	* @return the artist ID of this song
	*/
	@Override
	public long getArtistId() {
		return _song.getArtistId();
	}

	/**
	* Returns the company ID of this song.
	*
	* @return the company ID of this song
	*/
	@Override
	public long getCompanyId() {
		return _song.getCompanyId();
	}

	/**
	* Returns the group ID of this song.
	*
	* @return the group ID of this song
	*/
	@Override
	public long getGroupId() {
		return _song.getGroupId();
	}

	/**
	* Returns the primary key of this song.
	*
	* @return the primary key of this song
	*/
	@Override
	public long getPrimaryKey() {
		return _song.getPrimaryKey();
	}

	/**
	* Returns the song ID of this song.
	*
	* @return the song ID of this song
	*/
	@Override
	public long getSongId() {
		return _song.getSongId();
	}

	/**
	* Returns the status by user ID of this song.
	*
	* @return the status by user ID of this song
	*/
	@Override
	public long getStatusByUserId() {
		return _song.getStatusByUserId();
	}

	/**
	* Returns the class primary key of the trash entry for this song.
	*
	* @return the class primary key of the trash entry for this song
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _song.getTrashEntryClassPK();
	}

	/**
	* Returns the user ID of this song.
	*
	* @return the user ID of this song
	*/
	@Override
	public long getUserId() {
		return _song.getUserId();
	}

	@Override
	public void persist() {
		_song.persist();
	}

	/**
	* Sets the album ID of this song.
	*
	* @param albumId the album ID of this song
	*/
	@Override
	public void setAlbumId(long albumId) {
		_song.setAlbumId(albumId);
	}

	/**
	* Sets the artist ID of this song.
	*
	* @param artistId the artist ID of this song
	*/
	@Override
	public void setArtistId(long artistId) {
		_song.setArtistId(artistId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_song.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this song.
	*
	* @param companyId the company ID of this song
	*/
	@Override
	public void setCompanyId(long companyId) {
		_song.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this song.
	*
	* @param createDate the create date of this song
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_song.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_song.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_song.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_song.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this song.
	*
	* @param groupId the group ID of this song
	*/
	@Override
	public void setGroupId(long groupId) {
		_song.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this song.
	*
	* @param modifiedDate the modified date of this song
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_song.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this song.
	*
	* @param name the name of this song
	*/
	@Override
	public void setName(java.lang.String name) {
		_song.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_song.setNew(n);
	}

	/**
	* Sets the primary key of this song.
	*
	* @param primaryKey the primary key of this song
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_song.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_song.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the song ID of this song.
	*
	* @param songId the song ID of this song
	*/
	@Override
	public void setSongId(long songId) {
		_song.setSongId(songId);
	}

	/**
	* Sets the status of this song.
	*
	* @param status the status of this song
	*/
	@Override
	public void setStatus(int status) {
		_song.setStatus(status);
	}

	/**
	* Sets the status by user ID of this song.
	*
	* @param statusByUserId the status by user ID of this song
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_song.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this song.
	*
	* @param statusByUserName the status by user name of this song
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_song.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this song.
	*
	* @param statusByUserUuid the status by user uuid of this song
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_song.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this song.
	*
	* @param statusDate the status date of this song
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_song.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this song.
	*
	* @param userId the user ID of this song
	*/
	@Override
	public void setUserId(long userId) {
		_song.setUserId(userId);
	}

	/**
	* Sets the user name of this song.
	*
	* @param userName the user name of this song
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_song.setUserName(userName);
	}

	/**
	* Sets the user uuid of this song.
	*
	* @param userUuid the user uuid of this song
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_song.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this song.
	*
	* @param uuid the uuid of this song
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_song.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SongWrapper)) {
			return false;
		}

		SongWrapper songWrapper = (SongWrapper)obj;

		if (Objects.equals(_song, songWrapper._song)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _song.getStagedModelType();
	}

	@Override
	public Song getWrappedModel() {
		return _song;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _song.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _song.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_song.resetOriginalValues();
	}

	private final Song _song;
}