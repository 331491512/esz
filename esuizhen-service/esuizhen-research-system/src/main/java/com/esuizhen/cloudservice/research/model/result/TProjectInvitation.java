package com.esuizhen.cloudservice.research.model.result;

import java.io.Serializable;
import java.util.Date;

public class TProjectInvitation implements Serializable {
	private static final long serialVersionUID = 1L;

	//主键
	private Long id;
	//分中心ID。
	private Long subcenterId;
	//专题ID
	private String projectId;
	//邀请者ID
	private Long inviter;
	//被邀请医生ID
	private Long invitee;
	//描述
	private String description;
	//状态。0：已邀请，待确认；1：已接受 -1：已拒绝
	private Integer state;
	//记录创建时间
	private Date createTime;
	//记录更新时间
	private Date updateTime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSubcenterId() {
		return subcenterId;
	}
	public void setSubcenterId(Long subcenterId) {
		this.subcenterId = subcenterId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Long getInviter() {
		return inviter;
	}
	public void setInviter(Long inviter) {
		this.inviter = inviter;
	}
	public Long getInvitee() {
		return invitee;
	}
	public void setInvitee(Long invitee) {
		this.invitee = invitee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
