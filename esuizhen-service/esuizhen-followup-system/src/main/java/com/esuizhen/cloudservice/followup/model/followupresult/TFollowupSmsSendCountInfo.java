package com.esuizhen.cloudservice.followup.model.followupresult;

import java.util.Date;

public class TFollowupSmsSendCountInfo {

	private Long id;

	private Long patientId;

	private Long patientFamilyId;

	private String mobile;

	private Integer sendFailCount;

	private Date lastSendFailTime;

	private Integer sendSuccessCount;

	private Date lastSendSuccessTime;

	private Integer currSendCount;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getPatientFamilyId() {
		return patientFamilyId;
	}

	public void setPatientFamilyId(Long patientFamilyId) {
		this.patientFamilyId = patientFamilyId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSendFailCount() {
		return sendFailCount;
	}

	public void setSendFailCount(Integer sendFailCount) {
		this.sendFailCount = sendFailCount;
	}

	public Date getLastSendFailTime() {
		return lastSendFailTime;
	}

	public void setLastSendFailTime(Date lastSendFailTime) {
		this.lastSendFailTime = lastSendFailTime;
	}

	public Integer getSendSuccessCount() {
		return sendSuccessCount;
	}

	public void setSendSuccessCount(Integer sendSuccessCount) {
		this.sendSuccessCount = sendSuccessCount;
	}

	public Date getLastSendSuccessTime() {
		return lastSendSuccessTime;
	}

	public void setLastSendSuccessTime(Date lastSendSuccessTime) {
		this.lastSendSuccessTime = lastSendSuccessTime;
	}

	public Integer getCurrSendCount() {
		return currSendCount;
	}

	public void setCurrSendCount(Integer currSendCount) {
		this.currSendCount = currSendCount;
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
