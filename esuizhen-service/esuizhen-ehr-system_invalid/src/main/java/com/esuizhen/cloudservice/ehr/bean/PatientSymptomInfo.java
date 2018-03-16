package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

public class PatientSymptomInfo {
	/**
	 *  症状记录ID
	 */
	private String symptomId;
	/**
	 *  电子病历ID
	 */
	private String emrId="";
	/**
	 *  患者id
	 */
	private Long patientId;
	/**
	 *  病案号
	 */
	private String patientNo;
	/**
	 * 住院首页id
	 */
	private String inhospitalId;
	
	/**
	 * 门诊id
	 */
	private String clinicMedicalId;
	/**
	 * 就诊时间。发病时间
	 */
	private Date visitTime;
	/**
	 * 症状类型ID。
	 */
	private Integer symptomTypeId;
	/**
	 * 症状名称
	 */
	private String symptomName;
	/**
	 * 症状程度
	 */
	private Integer symptomDegree=0;
	/**
	 * 症状描述
	 */
	private String remark="";
	/**
	 * 检查
	 */
	private String inspect;
	/**
	 * 检验
	 */
	private String checkout;
	/**
	 * 与患者关系id
	 */
	private Integer relationId;
	/**
	 * 与患者关系名称
	 */
	private String relationName;
	/**
	 * 肿瘤家庭史id
	 */
	private Integer familyHistoryDiseaseTypeId;
	
	/**
	 * 肿瘤家庭史
	 */
	private String familyHistoryDiseaseTypeName;
	/**
	 * 危险因素
	 */
	private String riskFactors;
	/**
	 * 发病转移
	 */
	private String diseaseTransfer;
	/**
	 * 编目状态
	 */
	private Integer catalogState;
	/**
	 * 持续时间
	 */
	private String sustainTime;
	/**
	 * 持续时间单位
	 */
	private Integer sustainTimeUnit;
	
	private Long operatorId;
	
	public String getSymptomId() {
		return symptomId;
	}
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
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
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
	public Date getVisitTime() {
		return visitTime;
	}
	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}
	public Integer getSymptomTypeId() {
		return symptomTypeId;
	}
	public void setSymptomTypeId(Integer symptomTypeId) {
		this.symptomTypeId = symptomTypeId;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}
	
	public Integer getSymptomDegree() {
		return symptomDegree;
	}
	public void setSymptomDegree(Integer symptomDegree) {
		this.symptomDegree = symptomDegree;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getInspect() {
		return inspect;
	}
	public void setInspect(String inspect) {
		this.inspect = inspect;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public Integer getRelationId() {
		return relationId;
	}
	public void setRelationId(Integer relationId) {
		this.relationId = relationId;
	}
	public String getRelationName() {
		return relationName;
	}
	public void setRelationName(String relationName) {
		this.relationName = relationName;
	}
	public Integer getFamilyHistoryDiseaseTypeId() {
		return familyHistoryDiseaseTypeId;
	}
	public void setFamilyHistoryDiseaseTypeId(Integer familyHistoryDiseaseTypeId) {
		this.familyHistoryDiseaseTypeId = familyHistoryDiseaseTypeId;
	}
	public String getFamilyHistoryDiseaseTypeName() {
		return familyHistoryDiseaseTypeName;
	}
	public void setFamilyHistoryDiseaseTypeName(String familyHistoryDiseaseTypeName) {
		this.familyHistoryDiseaseTypeName = familyHistoryDiseaseTypeName;
	}
	public String getRiskFactors() {
		return riskFactors;
	}
	public void setRiskFactors(String riskFactors) {
		this.riskFactors = riskFactors;
	}
	public String getDiseaseTransfer() {
		return diseaseTransfer;
	}
	public void setDiseaseTransfer(String diseaseTransfer) {
		this.diseaseTransfer = diseaseTransfer;
	}
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public String getSustainTime() {
		return sustainTime;
	}
	public void setSustainTime(String sustainTime) {
		this.sustainTime = sustainTime;
	}
	public Integer getSustainTimeUnit() {
		return sustainTimeUnit;
	}
	public void setSustainTimeUnit(Integer sustainTimeUnit) {
		this.sustainTimeUnit = sustainTimeUnit;
	}
	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
}
