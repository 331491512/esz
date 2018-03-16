package com.esuizhen.cloudservice.ehr.bean;

import java.util.List;

public class PresentationMorbidityInfo {
	private Long patientId;
	private String inhospitalId;
	private String clinicMedicalId;
	/**
	 * 症状信息列表
	 */
	private List<PatientSymptomInfo> symptomList;
	/**
	 * 肿瘤家族史信息列表
	 */
	private List<TumourFamilyHistoryInfo> familyHistoryList;
	/**
	 * 危险因素信息
	 */
	private RiskfactorsInfo riskfactors;
	public List<PatientSymptomInfo> getSymptomList() {
		return symptomList;
	}
	public void setSymptomList(List<PatientSymptomInfo> symptomList) {
		this.symptomList = symptomList;
	}
	public List<TumourFamilyHistoryInfo> getFamilyHistoryList() {
		return familyHistoryList;
	}
	public void setFamilyHistoryList(List<TumourFamilyHistoryInfo> familyHistoryList) {
		this.familyHistoryList = familyHistoryList;
	}
	public RiskfactorsInfo getRiskfactors() {
		return riskfactors;
	}
	public void setRiskfactors(RiskfactorsInfo riskfactors) {
		this.riskfactors = riskfactors;
	}
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
	public String getClinicMedicalId() {
		return clinicMedicalId;
	}
	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
	}
}
