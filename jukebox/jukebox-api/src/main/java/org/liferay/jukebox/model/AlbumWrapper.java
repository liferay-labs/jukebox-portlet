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
 * This class is a wrapper for {@link Album}.
 * </p>
 *
 * @author Julio Camarero
 * @see Album
 * @generated
 */
@ProviderType
public class AlbumWrapper implements Album, ModelWrapper<Album> {
	public AlbumWrapper(Album album) {
		_album = album;
	}

	@Override
	public Class<?> getModelClass() {
		return Album.class;
	}

	@Override
	public String getModelClassName() {
		return Album.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("albumId", getAlbumId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("artistId", getArtistId());
		attributes.put("name", getName());
		attributes.put("year", getYear());
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

		Long albumId = (Long)attributes.get("albumId");

		if (albumId != null) {
			setAlbumId(albumId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
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
	public Album toEscapedModel() {
		return new AlbumWrapper(_album.toEscapedModel());
	}

	@Override
	public Album toUnescapedModel() {
		return new AlbumWrapper(_album.toUnescapedModel());
	}

	@Override
	public boolean hasCustomImage()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _album.hasCustomImage();
	}

	/**
	* Returns <code>true</code> if this album is approved.
	*
	* @return <code>true</code> if this album is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _album.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _album.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this album is denied.
	*
	* @return <code>true</code> if this album is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _album.isDenied();
	}

	/**
	* Returns <code>true</code> if this album is a draft.
	*
	* @return <code>true</code> if this album is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _album.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _album.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this album is expired.
	*
	* @return <code>true</code> if this album is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _album.isExpired();
	}

	/**
	* Returns <code>true</code> if this album is in the Recycle Bin.
	*
	* @return <code>true</code> if this album is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _album.isInTrash();
	}

	/**
	* Returns <code>true</code> if the parent of this album is in the Recycle Bin.
	*
	* @return <code>true</code> if the parent of this album is in the Recycle Bin; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrashContainer() {
		return _album.isInTrashContainer();
	}

	@Override
	public boolean isInTrashExplicitly() {
		return _album.isInTrashExplicitly();
	}

	@Override
	public boolean isInTrashImplicitly() {
		return _album.isInTrashImplicitly();
	}

	/**
	* Returns <code>true</code> if this album is inactive.
	*
	* @return <code>true</code> if this album is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _album.isInactive();
	}

	/**
	* Returns <code>true</code> if this album is incomplete.
	*
	* @return <code>true</code> if this album is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _album.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _album.isNew();
	}

	/**
	* Returns <code>true</code> if this album is pending.
	*
	* @return <code>true</code> if this album is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _album.isPending();
	}

	/**
	* Returns <code>true</code> if this album is scheduled.
	*
	* @return <code>true</code> if this album is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _album.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _album.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Album> toCacheModel() {
		return _album.toCacheModel();
	}

	@Override
	public com.liferay.portal.kernel.repository.model.FileEntry getCustomImage() {
		return _album.getCustomImage();
	}

	/**
	* Returns the trash handler for this album.
	*
	* @return the trash handler for this album
	*/
	@Override
	public com.liferay.portal.kernel.trash.TrashHandler getTrashHandler() {
		return _album.getTrashHandler();
	}

	/**
	* Returns the trash entry created when this album was moved to the Recycle Bin. The trash entry may belong to one of the ancestors of this album.
	*
	* @return the trash entry created when this album was moved to the Recycle Bin
	*/
	@Override
	public com.liferay.trash.kernel.model.TrashEntry getTrashEntry()
		throws com.liferay.portal.kernel.exception.PortalException {
		return _album.getTrashEntry();
	}

	@Override
	public int compareTo(Album album) {
		return _album.compareTo(album);
	}

	/**
	* Returns the status of this album.
	*
	* @return the status of this album
	*/
	@Override
	public int getStatus() {
		return _album.getStatus();
	}

	/**
	* Returns the year of this album.
	*
	* @return the year of this album
	*/
	@Override
	public int getYear() {
		return _album.getYear();
	}

	@Override
	public int hashCode() {
		return _album.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _album.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AlbumWrapper((Album)_album.clone());
	}

	/**
	* Returns the container name of this album.
	*
	* @return the container name of this album
	*/
	@Override
	public java.lang.String getContainerModelName() {
		return _album.getContainerModelName();
	}

	@Override
	public java.lang.String getImageURL(
		com.liferay.portal.kernel.theme.ThemeDisplay themeDisplay)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _album.getImageURL(themeDisplay);
	}

	/**
	* Returns the name of this album.
	*
	* @return the name of this album
	*/
	@Override
	public java.lang.String getName() {
		return _album.getName();
	}

	/**
	* Returns the status by user name of this album.
	*
	* @return the status by user name of this album
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _album.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this album.
	*
	* @return the status by user uuid of this album
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _album.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this album.
	*
	* @return the user name of this album
	*/
	@Override
	public java.lang.String getUserName() {
		return _album.getUserName();
	}

	/**
	* Returns the user uuid of this album.
	*
	* @return the user uuid of this album
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _album.getUserUuid();
	}

	/**
	* Returns the uuid of this album.
	*
	* @return the uuid of this album
	*/
	@Override
	public java.lang.String getUuid() {
		return _album.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _album.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _album.toXmlString();
	}

	/**
	* Returns the create date of this album.
	*
	* @return the create date of this album
	*/
	@Override
	public Date getCreateDate() {
		return _album.getCreateDate();
	}

	/**
	* Returns the modified date of this album.
	*
	* @return the modified date of this album
	*/
	@Override
	public Date getModifiedDate() {
		return _album.getModifiedDate();
	}

	/**
	* Returns the status date of this album.
	*
	* @return the status date of this album
	*/
	@Override
	public Date getStatusDate() {
		return _album.getStatusDate();
	}

	/**
	* Returns the album ID of this album.
	*
	* @return the album ID of this album
	*/
	@Override
	public long getAlbumId() {
		return _album.getAlbumId();
	}

	/**
	* Returns the artist ID of this album.
	*
	* @return the artist ID of this album
	*/
	@Override
	public long getArtistId() {
		return _album.getArtistId();
	}

	/**
	* Returns the company ID of this album.
	*
	* @return the company ID of this album
	*/
	@Override
	public long getCompanyId() {
		return _album.getCompanyId();
	}

	/**
	* Returns the container model ID of this album.
	*
	* @return the container model ID of this album
	*/
	@Override
	public long getContainerModelId() {
		return _album.getContainerModelId();
	}

	/**
	* Returns the group ID of this album.
	*
	* @return the group ID of this album
	*/
	@Override
	public long getGroupId() {
		return _album.getGroupId();
	}

	/**
	* Returns the parent container model ID of this album.
	*
	* @return the parent container model ID of this album
	*/
	@Override
	public long getParentContainerModelId() {
		return _album.getParentContainerModelId();
	}

	/**
	* Returns the primary key of this album.
	*
	* @return the primary key of this album
	*/
	@Override
	public long getPrimaryKey() {
		return _album.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this album.
	*
	* @return the status by user ID of this album
	*/
	@Override
	public long getStatusByUserId() {
		return _album.getStatusByUserId();
	}

	/**
	* Returns the class primary key of the trash entry for this album.
	*
	* @return the class primary key of the trash entry for this album
	*/
	@Override
	public long getTrashEntryClassPK() {
		return _album.getTrashEntryClassPK();
	}

	/**
	* Returns the user ID of this album.
	*
	* @return the user ID of this album
	*/
	@Override
	public long getUserId() {
		return _album.getUserId();
	}

	@Override
	public void persist() {
		_album.persist();
	}

	/**
	* Sets the album ID of this album.
	*
	* @param albumId the album ID of this album
	*/
	@Override
	public void setAlbumId(long albumId) {
		_album.setAlbumId(albumId);
	}

	/**
	* Sets the artist ID of this album.
	*
	* @param artistId the artist ID of this album
	*/
	@Override
	public void setArtistId(long artistId) {
		_album.setArtistId(artistId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_album.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this album.
	*
	* @param companyId the company ID of this album
	*/
	@Override
	public void setCompanyId(long companyId) {
		_album.setCompanyId(companyId);
	}

	/**
	* Sets the container model ID of this album.
	*
	* @param containerModelId the container model ID of this album
	*/
	@Override
	public void setContainerModelId(long containerModelId) {
		_album.setContainerModelId(containerModelId);
	}

	/**
	* Sets the create date of this album.
	*
	* @param createDate the create date of this album
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_album.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_album.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_album.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_album.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this album.
	*
	* @param groupId the group ID of this album
	*/
	@Override
	public void setGroupId(long groupId) {
		_album.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this album.
	*
	* @param modifiedDate the modified date of this album
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_album.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this album.
	*
	* @param name the name of this album
	*/
	@Override
	public void setName(java.lang.String name) {
		_album.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_album.setNew(n);
	}

	/**
	* Sets the parent container model ID of this album.
	*
	* @param parentContainerModelId the parent container model ID of this album
	*/
	@Override
	public void setParentContainerModelId(long parentContainerModelId) {
		_album.setParentContainerModelId(parentContainerModelId);
	}

	/**
	* Sets the primary key of this album.
	*
	* @param primaryKey the primary key of this album
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_album.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_album.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this album.
	*
	* @param status the status of this album
	*/
	@Override
	public void setStatus(int status) {
		_album.setStatus(status);
	}

	/**
	* Sets the status by user ID of this album.
	*
	* @param statusByUserId the status by user ID of this album
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_album.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this album.
	*
	* @param statusByUserName the status by user name of this album
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_album.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this album.
	*
	* @param statusByUserUuid the status by user uuid of this album
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_album.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this album.
	*
	* @param statusDate the status date of this album
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_album.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this album.
	*
	* @param userId the user ID of this album
	*/
	@Override
	public void setUserId(long userId) {
		_album.setUserId(userId);
	}

	/**
	* Sets the user name of this album.
	*
	* @param userName the user name of this album
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_album.setUserName(userName);
	}

	/**
	* Sets the user uuid of this album.
	*
	* @param userUuid the user uuid of this album
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_album.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this album.
	*
	* @param uuid the uuid of this album
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_album.setUuid(uuid);
	}

	/**
	* Sets the year of this album.
	*
	* @param year the year of this album
	*/
	@Override
	public void setYear(int year) {
		_album.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AlbumWrapper)) {
			return false;
		}

		AlbumWrapper albumWrapper = (AlbumWrapper)obj;

		if (Objects.equals(_album, albumWrapper._album)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _album.getStagedModelType();
	}

	@Override
	public Album getWrappedModel() {
		return _album;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _album.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _album.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_album.resetOriginalValues();
	}

	private final Album _album;
}