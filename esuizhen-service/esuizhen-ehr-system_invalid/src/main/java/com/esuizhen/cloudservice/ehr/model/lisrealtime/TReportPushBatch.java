package com.esuizhen.cloudservice.ehr.model.lisrealtime;

import java.util.Date;

public class TReportPushBatch {
	private Long reportPushItemId;
	private Long reportPushBatchId;
	private Integer type;
	private String reportId;
	private Integer promptFlag;
	private Integer hospitalId;
	private Long userId;
	private Long patientId;
	private Integer pushState;
	private String failCause;
	private Date pushTime;
	private String firstText;
	private Integer pushItemCount;
	private Integer pushCount;
	private String pushItemName;
	private Date itemCheckTime;
	private Long doctorId;
	private Long doctorUserId;
	private Date reportTime;
	private Date applyTime;
	private Date sampleTime;
	private Date createTime;
	private Date updateTime;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getReportPushItemId() {
		return reportPushItemId;
	}
	public void setReportPushItemId(Long reportPushItemId) {
		this.reportPushItemId = reportPushItemId;
	}
	public String getFirstText() {
		return firstText;
	}
	public void setFirstText(String firstText) {
		this.firstText = firstText;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	public Integer getPromptFlag() {
		return promptFlag;
	}
	public void setPromptFlag(Integer promptFlag) {
		this.promptFlag = promptFlag;
	}
	public Long getReportPushBatchId() {
		return reportPushBatchId;
	}
	public void setReportPushBatchId(Long reportPushBatchId) {
		this.reportPushBatchId = reportPushBatchId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getPushState() {
		return pushState;
	}
	public void setPushState(Integer pushState) {
		this.pushState = pushState;
	}
	public String getFailCause() {
		return failCause;
	}
	public void setFailCause(String failCause) {
		this.failCause = failCause;
	}
	public Date getPushTime() {
		return pushTime;
	}
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
	public Integer getPushItemCount() {
		return pushItemCount;
	}
	public void setPushItemCount(Integer pushItemCount) {
		this.pushItemCount = pushItemCount;
	}
	public Integer getPushCount() {
		return pushCount;
	}
	public void setPushCount(Integer pushCount) {
		this.pushCount = pushCount;
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
	public String getPushItemName() {
		return pushItemName;
	}
	public void setPushItemName(String pushItemName) {
		this.pushItemName = pushItemName;
	}
	public Date getItemCheckTime() {
		return itemCheckTime;
	}
	public void setItemCheckTime(Date itemCheckTime) {
		this.itemCheckTime = itemCheckTime;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(Date sampleTime) {
		this.sampleTime = sampleTime;
	}
}
