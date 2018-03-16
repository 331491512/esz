package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class ReBasiserReviewOrderReq {
	/**
	 * 预约APPOINT
	 */
	private String appointId;
	/**
	 * 患者id
	 */
	private Long patientId;
	/**
	 * 医院id
	 */
	private Integer hospitalId;
	/**
	 * 随访任务ID
	 */
	private String followupTaskId;
	/**
	 * 任务分配ID
	 */
	private String followupAssignId;
	/**
	 * 诊断
	 */
	private String diagnosis;
	/**
	 * 申请日期
	 */
	private Date applyTime;
	/**
	 * 操作员id
	 */
	private Long operatorId;
	/**
	 * 操作员名称
	 */
	private String operatorName;
	/**
	 * 预约科室id
	 */
	private Integer appointDeptId;
	/**
	 * 预约科室名称
	 */
	private String appointDeptName;
	/**
	 * 预约医生id
	 */
	private Integer appointDoctorId;
	/**
	 * 预约医生
	 */
	private String appointDoctorName;
	/**
	 * 预约日期
	 */
	private Date appointDate;
	/**
	 * 上午  或者   下午
	 */
	private Integer appointTimeRange;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 申请来源1：微信2：医生邀请3：随访系统
	 */
	private String sourceFlag;
	/**
	 * 预约手机号
	 */
	private String appointMobile;
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public Integer getAppointDeptId() {
		return appointDeptId;
	}
	public void setAppointDeptId(Integer appointDeptId) {
		this.appointDeptId = appointDeptId;
	}
	public String getAppointDeptName() {
		return appointDeptName;
	}
	public void setAppointDeptName(String appointDeptName) {
		this.appointDeptName = appointDeptName;
	}
	public Integer getAppointDoctorId() {
		return appointDoctorId;
	}
	public void setAppointDoctorId(Integer appointDoctorId) {
		this.appointDoctorId = appointDoctorId;
	}
	public String getAppointDoctorName() {
		return appointDoctorName;
	}
	public void setAppointDoctorName(String appointDoctorName) {
		this.appointDoctorName = appointDoctorName;
	}
	public Date getAppointDate() {
		return appointDate;
	}
	public void setAppointDate(Date appointDate) {
		this.appointDate = appointDate;
	}
	public Integer getAppointTimeRange() {
		return appointTimeRange;
	}
	public void setAppointTimeRange(Integer appointTimeRange) {
		this.appointTimeRange = appointTimeRange;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAppointId() {
		return appointId;
	}
	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
	public String getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(String sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public String getAppointMobile() {
		return appointMobile;
	}
	public void setAppointMobile(String appointMobile) {
		this.appointMobile = appointMobile;
	}
	
}
