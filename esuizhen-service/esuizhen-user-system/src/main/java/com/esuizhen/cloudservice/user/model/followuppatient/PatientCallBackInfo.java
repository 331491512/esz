package com.esuizhen.cloudservice.user.model.followuppatient;

public class PatientCallBackInfo {
	/**
	 *患者id
	 */
	private Long patientId;
	/**
	 * 病案号
	 */
	private String patientNo;
	/**
	 * 患者姓名
	 */
	private String trueName;
	/**
	 * 来电号码，即联系人电话号码
	 */
	private String familyPhone;
	/**
	 * 号码归属地
	 */
	private String phoneHome;
	/**
	 * 随访任务id
	 */
	private String followupTaskId;
	/**
	 * 随访任务分配ID
	 */
	private String followupAssignId;
	
	// add by zhuguo
	// 随访任务名称
	private String followupTaskName;
	
	// 病种
	private String sourceDiseaseTypeName;
	
	// 主要诊断
	private String sourceDiagnosis;
	// end
	
	public Long getPatientId() {
		return patientId;
	}
	public String getFollowupTaskName() {
		return followupTaskName;
	}
	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}
	
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}
	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}
	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public String getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(String phoneHome) {
		this.phoneHome = phoneHome;
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
	
}
