package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;

public class PatientGroup implements Serializable {
	private Integer groupId;
	
	private String groupNo;

	private String groupName;

	private String description;

	private Integer groupWay;

	private Long creator;
	
	private Integer groupMembersNum;
	
	private Integer notOperat=0;

	private Date createTime;

	private Date updateTime;

	private static final long serialVersionUID = 1L;

	public Integer getGroupMembersNum() {
		return groupMembersNum;
	}

	public void setGroupMembersNum(Integer groupMembersNum) {
		this.groupMembersNum = groupMembersNum;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getGroupWay() {
		return groupWay;
	}

	public void setGroupWay(Integer groupWay) {
		this.groupWay = groupWay;
	}


	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public Integer getNotOperat() {
		return notOperat;
	}

	public void setNotOperat(Integer notOperat) {
		this.notOperat = notOperat;
	}
}