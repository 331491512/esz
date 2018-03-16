package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.Date;

public class TPatientTreatmentInfo {

	private String treatmentId;
	
	private String emrId;
	
	private Long patientId;
	
	private Integer treatmentTypeId;
	/**
	 * 治疗类型名称
	 */
	private String treatmentTypeName;
	
	private String treatmentName;
	
	private String inhospitalId;
	
	private String treatmentDesc;
	
	private Date treatmentBeginTime;
	
	private Date treatmentEndTime;
	/**
	 * 治疗完成情况
	 */
	private Integer treatmentProcessFlag;
	/**
	 * 当前疗程
	 */
	private String treatmentCourse;
	
	/**
	 * 总疗程
	 */
	private String totalCourse;
	
	/**
	 * 疗效
	 */
	private String treatmentEffect;
	/**
	 * 数据来源标示。1：患者上传2：医生上传3：医院同步（默认）
	 */
	private Integer sourceFlag;
	
	/**
	 * 患者基本信息登记Id
	 */
	private Long specialDiseaseRegisterId;
	
	/**
	 * 放疗信息
	 */
	private TreatmentRadiotherapyInfo radiotherapyInfo;
	
	/**
	 * 化疗信息
	 */
	private TreatmentChemotherapyMedicationInfo chemotherapyMedication;
	
	/**
	 * 门诊记录
	 */
	private String clinicMedicalId;
	
	
	private Integer metaDataType;
	
	private Integer treatmentSchemeId;
	
	private Long operatorId;
	/**
	 * 操作标识
	 */
	private Integer actionFlag;

	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}

	public Integer getMetaDataType() {
		return metaDataType;
	}

	public void setMetaDataType(Integer metaDataType) {
		this.metaDataType = metaDataType;
	}

	public String getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(String treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getTreatmentDesc() {
		return treatmentDesc;
	}

	public void setTreatmentDesc(String treatmentDesc) {
		this.treatmentDesc = treatmentDesc;
	}

	public Date getTreatmentBeginTime() {
		return treatmentBeginTime;
	}

	public void setTreatmentBeginTime(Date treatmentBeginTime) {
		this.treatmentBeginTime = treatmentBeginTime;
	}

	public Date getTreatmentEndTime() {
		return treatmentEndTime;
	}

	public void setTreatmentEndTime(Date treatmentEndTime) {
		this.treatmentEndTime = treatmentEndTime;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Integer getTreatmentTypeId() {
		return treatmentTypeId;
	}

	public void setTreatmentTypeId(Integer treatmentTypeId) {
		this.treatmentTypeId = treatmentTypeId;
	}

	public String getTreatmentName() {
		return treatmentName;
	}

	public Integer getTreatmentProcessFlag() {
		return treatmentProcessFlag;
	}

	public void setTreatmentProcessFlag(Integer treatmentProcessFlag) {
		this.treatmentProcessFlag = treatmentProcessFlag;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public String getTreatmentCourse() {
		return treatmentCourse;
	}

	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}

	public String getTotalCourse() {
		return totalCourse;
	}

	public void setTotalCourse(String totalCourse) {
		this.totalCourse = totalCourse;
	}

	public String getTreatmentEffect() {
		return treatmentEffect;
	}

	public void setTreatmentEffect(String treatmentEffect) {
		this.treatmentEffect = treatmentEffect;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}

	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}

	public TreatmentRadiotherapyInfo getRadiotherapyInfo() {
		return radiotherapyInfo;
	}

	public void setRadiotherapyInfo(TreatmentRadiotherapyInfo radiotherapyInfo) {
		this.radiotherapyInfo = radiotherapyInfo;
	}

	public TreatmentChemotherapyMedicationInfo getChemotherapyMedication() {
		return chemotherapyMedication;
	}

	public void setChemotherapyMedication(
			TreatmentChemotherapyMedicationInfo chemotherapyMedication) {
		this.chemotherapyMedication = chemotherapyMedication;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public String getTreatmentTypeName() {
		return treatmentTypeName;
	}

	public void setTreatmentTypeName(String treatmentTypeName) {
		this.treatmentTypeName = treatmentTypeName;
	}

	public Integer getActionFlag() {
		return actionFlag;
	}

	public void setActionFlag(Integer actionFlag) {
		this.actionFlag = actionFlag;
	}
}
