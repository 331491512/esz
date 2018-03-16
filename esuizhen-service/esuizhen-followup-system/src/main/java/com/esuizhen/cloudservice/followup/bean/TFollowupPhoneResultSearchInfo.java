package com.esuizhen.cloudservice.followup.bean;

import java.util.Date;

public class TFollowupPhoneResultSearchInfo {

	private String patientNo;

	private String trueName;

	private String operatorName;

	private Integer diseaseTypeId;

	private Integer cityId;

	private Integer deptId;

	private String treatmentSchemeIds;

	private String[] treatmentSchemeIdArr;

	private String sourceDiagnosis;

	private String sourceDiseaseCode;

	private String sourcePathologyDiagnosis;

	private String sourcePathologyDiseaseCode;

	private Date confirmedDateStart;

	private Date confirmedDateEnd;

	private Date followupTimeStart;

	private Date followupTimeEnd;
	
	private Integer userRole;
	
	private Integer page;

	private Integer num;
	
	private Long operator;
	private String sql;
	

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String[] getTreatmentSchemeIdArr() {
		return treatmentSchemeIdArr;
	}

	public void setTreatmentSchemeIdArr(String[] treatmentSchemeIdArr) {
		this.treatmentSchemeIdArr = treatmentSchemeIdArr;
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

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getTreatmentSchemeIds() {
		return treatmentSchemeIds;
	}

	public void setTreatmentSchemeIds(String treatmentSchemeIds) {
		this.treatmentSchemeIds = treatmentSchemeIds;
	}

	public String getSourceDiagnosis() {
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis) {
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}

	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	public String getSourcePathologyDiagnosis() {
		return sourcePathologyDiagnosis;
	}

	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}

	public String getSourcePathologyDiseaseCode() {
		return sourcePathologyDiseaseCode;
	}

	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
	}

	public Date getConfirmedDateStart() {
		return confirmedDateStart;
	}

	public void setConfirmedDateStart(Date confirmedDateStart) {
		this.confirmedDateStart = confirmedDateStart;
	}

	public Date getConfirmedDateEnd() {
		return confirmedDateEnd;
	}

	public void setConfirmedDateEnd(Date confirmedDateEnd) {
		this.confirmedDateEnd = confirmedDateEnd;
	}

	public Date getFollowupTimeStart() {
		return followupTimeStart;
	}

	public void setFollowupTimeStart(Date followupTimeStart) {
		this.followupTimeStart = followupTimeStart;
	}

	public Date getFollowupTimeEnd() {
		return followupTimeEnd;
	}

	public void setFollowupTimeEnd(Date followupTimeEnd) {
		this.followupTimeEnd = followupTimeEnd;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
}
