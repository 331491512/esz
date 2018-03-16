package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

/** 
 * @ClassName: SpecialDiseaseResp.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月24日
 */
public class SpecialDiseaseResp {

	private Integer patientId;
	private String patientName;
	private Integer sex;
	private Integer age;
	private String medicalCareType;
	private String medicalCareArea;
	private String specialDiseaseDiagnosis;
	private String diagnosisBasis;
	private String diagnosisDoctorName;
	private String firstdiagnosisHospitalName;
	private String clinicNo;
	private Date handleDate;
	private String advice;
	private Long specialDiseaseRegisterId;
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
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
	public String getSpecialDiseaseDiagnosis() {
		return specialDiseaseDiagnosis;
	}
	public void setSpecialDiseaseDiagnosis(String specialDiseaseDiagnosis) {
		this.specialDiseaseDiagnosis = specialDiseaseDiagnosis;
	}
	public String getDiagnosisBasis() {
		return diagnosisBasis;
	}
	public void setDiagnosisBasis(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}
	public String getDiagnosisDoctorName() {
		return diagnosisDoctorName;
	}
	public void setDiagnosisDoctorName(String diagnosisDoctorName) {
		this.diagnosisDoctorName = diagnosisDoctorName;
	}
	public String getFirstdiagnosisHospitalName() {
		return firstdiagnosisHospitalName;
	}
	public void setFirstdiagnosisHospitalName(String firstdiagnosisHospitalName) {
		this.firstdiagnosisHospitalName = firstdiagnosisHospitalName;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public Date getHandleDate() {
		return handleDate;
	}
	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	
}
