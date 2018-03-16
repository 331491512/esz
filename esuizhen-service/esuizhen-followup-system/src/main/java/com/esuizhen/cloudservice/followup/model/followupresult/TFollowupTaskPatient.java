package com.esuizhen.cloudservice.followup.model.followupresult;

import java.util.Date;

public class TFollowupTaskPatient {

	private Long id;

	private String followupAssignId;

	private String followupTaskId;

	private Long patientId;

	private Integer state;

	private Integer latestFollowupResultValue;

	private Date latesFollowupTime;

	private Long operator;

	private Date createTime;

	private Date updateTime;

	private Integer wxState;

	private Integer smsState;

	private Long wxReqId;

	private Long smsReqId;
	
	private Integer followupWay;
	
	private Integer followupResultValue;
	
	private Integer followupResultType;
	
	/**
	 * 患者详细信息
	 */
	private TFollowupResultPatientInfo patient;
	
	
	public Integer getFollowupResultType() {
		return followupResultType;
	}

	public void setFollowupResultType(Integer followupResultType) {
		this.followupResultType = followupResultType;
	}

	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	public Integer getFollowupWay() {
		return followupWay;
	}

	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}

	public Integer getWxState() {
		return wxState;
	}

	public void setWxState(Integer wxState) {
		this.wxState = wxState;
	}

	public Integer getSmsState() {
		return smsState;
	}

	public void setSmsState(Integer smsState) {
		this.smsState = smsState;
	}

	public Long getWxReqId() {
		return wxReqId;
	}

	public void setWxReqId(Long wxReqId) {
		this.wxReqId = wxReqId;
	}

	public Long getSmsReqId() {
		return smsReqId;
	}

	public void setSmsReqId(Long smsReqId) {
		this.smsReqId = smsReqId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getLatestFollowupResultValue() {
		return latestFollowupResultValue;
	}

	public void setLatestFollowupResultValue(Integer latestFollowupResultValue) {
		this.latestFollowupResultValue = latestFollowupResultValue;
	}

	public Date getLatesFollowupTime() {
		return latesFollowupTime;
	}

	public void setLatesFollowupTime(Date latesFollowupTime) {
		this.latesFollowupTime = latesFollowupTime;
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

	public TFollowupResultPatientInfo getPatient() {
		return patient;
	}

	public void setPatient(TFollowupResultPatientInfo patient) {
		this.patient = patient;
	}

}
