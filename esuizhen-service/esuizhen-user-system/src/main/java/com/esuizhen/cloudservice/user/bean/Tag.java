package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

public class Tag {

	private Integer tagId;
	
	private String tagName;
	
	private Integer tagTypeId;
	
	private String tagTypeName;
	
	private String tagDescription;
	
	private Date createTime;
	
	private Date updateTime;

	public Integer getTagId() {
		return tagId;
	}

	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public Integer getTagTypeId() {
		return tagTypeId;
	}

	public void setTagTypeId(Integer tagTypeId) {
		this.tagTypeId = tagTypeId;
	}

	public String getTagTypeName() {
		return tagTypeName;
	}

	public void setTagTypeName(String tagTypeName) {
		this.tagTypeName = tagTypeName;
	}

	public String getTagDescription() {
		return tagDescription;
	}

	public void setTagDescription(String tagDescription) {
		this.tagDescription = tagDescription;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
