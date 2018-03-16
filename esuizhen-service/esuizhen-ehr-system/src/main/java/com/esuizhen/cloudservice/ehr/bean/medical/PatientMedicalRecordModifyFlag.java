package com.esuizhen.cloudservice.ehr.bean.medical;
/**
 * 修改标识：0：未修改；1：已修改
 */
public class PatientMedicalRecordModifyFlag {
	/**
	 * 住院信息修改标识。0-未未修改，1-修改
	 */
	private Integer inhospitalDetailModifyFlag;
	/**
	 * 门诊信息修改标识。0-未未修改，1-修改
	 */
	private Integer patientClinicInfoModifyFlag;
	/**
	 * 诊断信息修改标识。0-未未修改，1-修改
	 */
	private Integer diagnosisModifyFlag;
	/**
	 * 手术治疗信息修改标识。0-未未修改，1-修改
	 */
	private Integer surgeryTreatmentModifyFlag;
	/**
	 * 住院费用修改标识。0-未未修改，1-修改
	 */
	private Integer inhospitalCostModifyFlag;
	/**
	 * 表现与发病修改标识。0-未未修改，1-修改
	 */
	private Integer presentationMorbidityModifyFlag;
	/**
	 * 体格检查修改标识。0-未未修改，1-修改
	 */
	private Integer genenalExamSignsModifyFlag;
	/**
	 * 不良反应修改标识。0-未未修改，1-修改
	 */
	private Integer adverseReactionModifyFlag;
	

	public Integer getInhospitalDetailModifyFlag() {
		return inhospitalDetailModifyFlag;
	}

	public void setInhospitalDetailModifyFlag(Integer inhospitalDetailModifyFlag) {
		this.inhospitalDetailModifyFlag = inhospitalDetailModifyFlag;
	}

	public Integer getPatientClinicInfoModifyFlag() {
		return patientClinicInfoModifyFlag;
	}

	public void setPatientClinicInfoModifyFlag(Integer patientClinicInfoModifyFlag) {
		this.patientClinicInfoModifyFlag = patientClinicInfoModifyFlag;
	}

	public Integer getDiagnosisModifyFlag() {
		return diagnosisModifyFlag;
	}

	public void setDiagnosisModifyFlag(Integer diagnosisModifyFlag) {
		this.diagnosisModifyFlag = diagnosisModifyFlag;
	}

	public Integer getSurgeryTreatmentModifyFlag() {
		return surgeryTreatmentModifyFlag;
	}

	public void setSurgeryTreatmentModifyFlag(Integer surgeryTreatmentModifyFlag) {
		this.surgeryTreatmentModifyFlag = surgeryTreatmentModifyFlag;
	}

	public Integer getInhospitalCostModifyFlag() {
		return inhospitalCostModifyFlag;
	}

	public void setInhospitalCostModifyFlag(Integer inhospitalCostModifyFlag) {
		this.inhospitalCostModifyFlag = inhospitalCostModifyFlag;
	}

	public Integer getPresentationMorbidityModifyFlag() {
		return presentationMorbidityModifyFlag;
	}

	public void setPresentationMorbidityModifyFlag(
			Integer presentationMorbidityModifyFlag) {
		this.presentationMorbidityModifyFlag = presentationMorbidityModifyFlag;
	}

	public Integer getGenenalExamSignsModifyFlag() {
		return genenalExamSignsModifyFlag;
	}

	public void setGenenalExamSignsModifyFlag(Integer genenalExamSignsModifyFlag) {
		this.genenalExamSignsModifyFlag = genenalExamSignsModifyFlag;
	}

	public Integer getAdverseReactionModifyFlag() {
		return adverseReactionModifyFlag;
	}

	public void setAdverseReactionModifyFlag(Integer adverseReactionModifyFlag) {
		this.adverseReactionModifyFlag = adverseReactionModifyFlag;
	}
}
