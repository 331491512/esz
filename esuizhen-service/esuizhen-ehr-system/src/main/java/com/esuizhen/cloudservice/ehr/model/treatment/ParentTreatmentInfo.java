package com.esuizhen.cloudservice.ehr.model.treatment;

import java.util.List;

public class ParentTreatmentInfo {
	/**
	 * 患者id
	 */
	private Long patientId;
	
	/**
	 * 住院id
	 */
	private String inhospitalId;
	
	/**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	
	/**
	 * 治疗信息列表
	 */
	private List<TPatientTreatmentInfo> patientTreatmentInfos;
	
	/**
	 * 门诊id
	 */
	private String clinicMedicalId;

	
	private Long operatorId;
	
	private String treatmentName;
	private Integer treatmentSchemeId;
	
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public Integer getOperateFlag() {
		return operateFlag;
	}

	public void setOperateFlag(Integer operateFlag) {
		this.operateFlag = operateFlag;
	}

	public List<TPatientTreatmentInfo> getPatientTreatmentInfos() {
		return patientTreatmentInfos;
	}

	public void setPatientTreatmentInfos(List<TPatientTreatmentInfo> patientTreatmentInfos) {
		this.patientTreatmentInfos = patientTreatmentInfos;
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

	public String getTreatmentName() {
		return treatmentName;
	}

	public void setTreatmentName(String treatmentName) {
		this.treatmentName = treatmentName;
	}

	public Integer getTreatmentSchemeId() {
		return treatmentSchemeId;
	}

	public void setTreatmentSchemeId(Integer treatmentSchemeId) {
		this.treatmentSchemeId = treatmentSchemeId;
	}
}
