package com.ppship.common.i18n.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;

import com.neovisionaries.i18n.CountryCode;
import com.ppship.common.model.BaseObject;
import com.ppship.common.util.JsonUtil;

@Entity
public class I18NString extends BaseObject {
	private static final long serialVersionUID = 6972283191544924576L;

	@Id
	@GeneratedValue
	private Long no;
	@Column(nullable = false)
	private String rawString;
	@Transient
	private Map<CountryCode, String> stringMap;
	@Column
	private Date createdAt = new Date();
	@Column
	private Date updatedAt = new Date();

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getRawString() {
		return rawString;
	}

	public void setRawString(String rawString) {
		this.rawString = rawString;
		getStringMap();
	}

	public Map<CountryCode, String> getStringMap() {
		if (rawString != null && stringMap == null) {
			stringMap = JsonUtil.getMap(rawString);
		}
		return stringMap;
	}

	public void setStringMap(Map<CountryCode, String> stringMap) {
		this.stringMap = stringMap;
		if (stringMap != null) {
			rawString = JsonUtil.getString(stringMap);
		} else {
			rawString = null;
		}
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PreUpdate
	public void setLastUpdate() {
		this.updatedAt = new Date();
	}
}
