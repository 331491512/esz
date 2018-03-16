package com.esuizhen.cloudservice.user.bean;
/** 
 * @ClassName: AutiPatientListResp.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月22日
 */
public class AutiPatientListResp {

	private int patientId;
	private String firstHospital;  
	private String clinicNo;
	private String patientName;
	private int sex;
	private String mobile;
	private String idNo;
	private String medicalCareType;
	private String medicalCareArea;      
	private String sourceDiagnosis1;
	private String specialDiseaseDiagnosis;
	private String diagnosisBasis;
	private String doctorName;
	private String outdiagnosis;
	/**
	 * 特病患者登记id
	 */
	private Long specialDiseaseRegisterId;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirstHospital() {
		return firstHospital;
	}
	public void setFirstHospital(String firstHospital) {
		this.firstHospital = firstHospital;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getMedicalCareType() {
		return medicalCareType;
	}
	public void setMedicalCareType(String medicalCareType) {
		this.medicalCareType = medicalCareType;
	}
	public String getMedicalCareArea() {
		return medicalCareArea;
	}
	public void setMedicalCareArea(String medicalCareArea) {
		this.medicalCareArea = medicalCareArea;
	}
	public String getSourceDiagnosis1() {
		return sourceDiagnosis1;
	}
	public void setSourceDiagnosis1(String sourceDiagnosis1) {
		this.sourceDiagnosis1 = sourceDiagnosis1;
	}
	public String getSpecialDiseaseDiagnosis() {
		return specialDiseaseDiagnosis;
	}
	public void setSpecialDiseaseDiagnosis(String specialDiseaseDiagnosis) {
		this.specialDiseaseDiagnosis = specialDiseaseDiagnosis;
	}
	public String getDiagnosisGist() {
		return diagnosisBasis;
	}
	public void setDiagnosisGist(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	
}
