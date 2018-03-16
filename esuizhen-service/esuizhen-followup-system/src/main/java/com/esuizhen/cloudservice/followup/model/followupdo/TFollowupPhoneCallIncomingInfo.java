package com.esuizhen.cloudservice.followup.model.followupdo;

import java.util.Date;

public class TFollowupPhoneCallIncomingInfo {

	private Integer incomingCallId;
	
	private String followupTaskId;
	
	// add by zhuguo
	private String followupTaskName;
	
	private String followupAssignId;
	
	private Integer hospitalId;
	
	private Long patientId;
	
	private Date callTime;
	
	private String trueName;
	
	private String telphone;
	
	private Integer state;
	
	private String telLocale;
	
	private String localPhone;
	
	private String patientNo;
	
	private Integer resultProcessState;
	
	private String followupResultBuffId;
	
	private String followupResultId;
	
	private Date createTime;
	
	private Date updateTime;
	private Long operator;

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public String getFollowupTaskName() {
		return followupTaskName;
	}

	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}

	public Integer getIncomingCallId() {
		return incomingCallId;
	}

	public void setIncomingCallId(Integer incomingCallId) {
		this.incomingCallId = incomingCallId;
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

	public Date getCallTime() {
		return callTime;
	}

	public void setCallTime(Date callTime) {
		this.callTime = callTime;
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

	public String getTelLocale() {
		return telLocale;
	}

	public void setTelLocale(String telLocale) {
		this.telLocale = telLocale;
	}

	public String getLocalPhone() {
		return localPhone;
	}

	public void setLocalPhone(String localPhone) {
		this.localPhone = localPhone;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
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
}
