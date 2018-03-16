package com.esuizhen.cloudservice.followup.model.followupdo;

import java.util.Date;

public class TFollowupResultLog {
	private Long followupResultLogId;
	private Long patientId;
	private Integer actionType;
	private Date followupTime;
	private Long followupOperatorId;
	private String followupOperatorName;
	private Long operatorId;
	private String operatorTrueName;
	private String description;
	private Date createTime;
	private String followupTaskId;
	public Long getFollowupResultLogId() {
		return followupResultLogId;
	}
	public void setFollowupResultLogId(Long followupResultLogId) {
		this.followupResultLogId = followupResultLogId;
	}
	public Integer getActionType() {
		return actionType;
	}
	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}
	public Date getFollowupTime() {
		return followupTime;
	}
	public void setFollowupTime(Date followupTime) {
		this.followupTime = followupTime;
	}
	public Long getFollowupOperatorId() {
		return followupOperatorId;
	}
	public void setFollowupOperatorId(Long followupOperatorId) {
		this.followupOperatorId = followupOperatorId;
	}
	public String getFollowupOperatorName() {
		return followupOperatorName;
	}
	public void setFollowupOperatorName(String followupOperatorName) {
		this.followupOperatorName = followupOperatorName;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorTrueName() {
		return operatorTrueName;
	}
	public void setOperatorTrueName(String operatorTrueName) {
		this.operatorTrueName = operatorTrueName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
}
