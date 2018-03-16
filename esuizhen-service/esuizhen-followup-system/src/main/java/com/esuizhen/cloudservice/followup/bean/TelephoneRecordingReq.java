package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class TelephoneRecordingReq {

	private Long phoneCallRecordId;
	private String followupAssignId;
	private String followupTaskId;
	private Long patientId;
	private String origFileName;
	private String phoneCallPath;
	private String phoneCallUrl;
	private Date startTime;
	private Date endTime;
	private Integer duration;
	private Integer readFlag;
	private Long operator;
	private Date createTime;
	private Date updateTime;
	private String followupPhone;

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getFollowupPhone() {
		return followupPhone;
	}

	public void setFollowupPhone(String followupPhone) {
		this.followupPhone = followupPhone;
	}

	public Long getPhoneCallRecordId() {
		return phoneCallRecordId;
	}

	public void setPhoneCallRecordId(Long phoneCallRecordId) {
		this.phoneCallRecordId = phoneCallRecordId;
	}

	public String getFollowupAssignId() {
		return followupAssignId;
	}

	public void setFollowupAssignId(String followupAssignId) {
		this.followupAssignId = followupAssignId;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getOrigFileName() {
		return origFileName;
	}

	public void setOrigFileName(String origFileName) {
		this.origFileName = origFileName;
	}

	public String getPhoneCallPath() {
		return phoneCallPath;
	}

	public void setPhoneCallPath(String phoneCallPath) {
		this.phoneCallPath = phoneCallPath;
	}

	public String getPhoneCallUrl() {
		return phoneCallUrl;
	}

	public void setPhoneCallUrl(String phoneCallUrl) {
		this.phoneCallUrl = phoneCallUrl;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
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
