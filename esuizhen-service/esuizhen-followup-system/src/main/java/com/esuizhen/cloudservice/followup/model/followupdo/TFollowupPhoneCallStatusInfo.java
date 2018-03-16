package com.esuizhen.cloudservice.followup.model.followupdo;

import java.util.Date;

public class TFollowupPhoneCallStatusInfo {

	private Integer reqId;
	
	private String followupTaskId;
	
	private String followupAssignId;
	
	private Integer hospitalId;
	
	private Long patientId;
	
	private String callId;
	
	private Date followupDate;
	
	private String trueName;
	
	private String telphone;
	
	private Integer state;
	
	private Integer resultProcessState;
	
	private String followupResultBuffId;
	
	private String followupResultId;
	
	private Long operator;
	
	private Integer callType;
	
	private Integer isInstallVoiceBox;

	private Date createTime;
	
	private Date updateTime;

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public String getFollowupAssignId() {
		return followupAssignId;
	}

	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getCallId() {
		return callId;
	}

	public void setCallId(String callId) {
		this.callId = callId;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getResultProcessState() {
		return resultProcessState;
	}

	public void setResultProcessState(Integer resultProcessState) {
		this.resultProcessState = resultProcessState;
	}

	public String getFollowupResultBuffId() {
		return followupResultBuffId;
	}

	public void setFollowupResultBuffId(String followupResultBuffId) {
		this.followupResultBuffId = followupResultBuffId;
	}

	public String getFollowupResultId() {
		return followupResultId;
	}

	public void setFollowupResultId(String followupResultId) {
		this.followupResultId = followupResultId;
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

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getCallType() {
		return callType;
	}

	public void setCallType(Integer callType) {
		this.callType = callType;
	}

	public Integer getIsInstallVoiceBox() {
		return isInstallVoiceBox;
	}

	public void setIsInstallVoiceBox(Integer isInstallVoiceBox) {
		this.isInstallVoiceBox = isInstallVoiceBox;
	}
}
