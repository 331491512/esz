package com.esuizhen.cloudservice.user.bean;

import java.util.Date;

/**
 * @ClassName: AutiPatientApproveInfo.java
 * @Description: 防癌患者审批信息
 * @author fanpanwei
 * @date 2016年9月24日
 */
public class AutiPatientApproveInfo {
	private String approvalId;
	private Integer patientId;
	private String clinicMedicalId;
	private String clinicNo;
	private String patientName;
	private Integer sex;
	private Integer age;
	private String mobile;
	private String medicalCarePlace;
	private String payType;// 医保类型
	private String medicalCareArea;
	private String firstdiagnosisHospitalName;
	private Date firstdiagnosisTime;
	private String idNo;
	private Date handleDate;
	private String medicalCareCardNo;
	private String specialDiseaseDiagnosisName;
	private String diagnosisBasis;
	private String diagnosisDoctorName;
	private String outHospitalDiagnosis;
	private String diseaseCode;
	private Integer isSurgery;
	private Integer diagnosisDescId;
	private String diagnosisDesc;
	private Integer adviceId;
	private String advice;
	private String specialistName;
	private String specialFollowupRecord;
	private String specializedFollowupRecord;
	private String remark;
	/**
	 * 患者基本信息登记id
	 */
	private Long specialDiseaseRegisterId;
	
	/**
	 * 页面操作。1-登记，2-编辑
	 */
	private Integer operateFlag;
	private Date birthDate;
	private String outhospitalDiagnosisCode;
	/**
	 * 人员类别 1-在职，2-退休
	 */
	private Integer stafferType;
	public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getClinicMedicalId() {
		return clinicMedicalId;
	}

	public void setClinicMedicalId(String clinicMedicalId) {
		this.clinicMedicalId = clinicMedicalId;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMedicalCarePlace() {
		return medicalCarePlace;
	}

	public void setMedicalCarePlace(String medicalCarePlace) {
		this.medicalCarePlace = medicalCarePlace;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getMedicalCareArea() {
		return medicalCareArea;
	}

	public void setMedicalCareArea(String medicalCareArea) {
		this.medicalCareArea = medicalCareArea;
	}

	public String getFirstdiagnosisHospitalName() {
		return firstdiagnosisHospitalName;
	}

	public void setFirstdiagnosisHospitalName(String firstdiagnosisHospitalName) {
		this.firstdiagnosisHospitalName = firstdiagnosisHospitalName;
	}

	public Date getFirstdiagnosisTime() {
		return firstdiagnosisTime;
	}

	public void setFirstdiagnosisTime(Date firstdiagnosisTime) {
		this.firstdiagnosisTime = firstdiagnosisTime;
	}

	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	public Date getHandleDate() {
		return handleDate;
	}

	public void setHandleDate(Date handleDate) {
		this.handleDate = handleDate;
	}

	public String getMedicalCareCardNo() {
		return medicalCareCardNo;
	}

	public void setMedicalCareCardNo(String medicalCareCardNo) {
		this.medicalCareCardNo = medicalCareCardNo;
	}

	public String getSpecialDiseaseDiagnosisName() {
		return specialDiseaseDiagnosisName;
	}

	public void setSpecialDiseaseDiagnosisName(
			String specialDiseaseDiagnosisName) {
		this.specialDiseaseDiagnosisName = specialDiseaseDiagnosisName;
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

	public String getOutHospitalDiagnosis() {
		return outHospitalDiagnosis;
	}

	public void setOutHospitalDiagnosis(String outHospitalDiagnosis) {
		this.outHospitalDiagnosis = outHospitalDiagnosis;
	}

	public String getDiseaseCode() {
		return diseaseCode;
	}

	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}

	public Integer getIsSurgery() {
		return isSurgery;
	}

	public void setIsSurgery(Integer isSurgery) {
		this.isSurgery = isSurgery;
	}

	public Integer getdiagnosisDescId() {
		return diagnosisDescId;
	}

	public void setdiagnosisDescId(Integer diagnosisDescId) {
		this.diagnosisDescId = diagnosisDescId;
	}

	public Integer getAdviceId() {
		return adviceId;
	}

	public void setAdviceId(Integer adviceId) {
		this.adviceId = adviceId;
	}

	public String getSpecialistName() {
		return specialistName;
	}

	public void setSpecialistName(String specialistName) {
		this.specialistName = specialistName;
	}

	public String getSpecialFollowupRecord() {
		return specialFollowupRecord;
	}

	public void setSpecialFollowupRecord(String specialFollowupRecord) {
		this.specialFollowupRecord = specialFollowupRecord;
	}

	public String getSpecializedFollowupRecord() {
		return specializedFollowupRecord;
	}

	public void setSpecializedFollowupRecord(String specializedFollowupRecord) {
		this.specializedFollowupRecord = specializedFollowupRecord;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}

	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}

	public Integer getOperateFlag() {
		return operateFlag;
	}

	public void setOperateFlag(Integer operateFlag) {
		this.operateFlag = operateFlag;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getOuthospitalDiagnosisCode() {
		return outhospitalDiagnosisCode;
	}

	public void setOuthospitalDiagnosisCode(String outhospitalDiagnosisCode) {
		this.outhospitalDiagnosisCode = outhospitalDiagnosisCode;
	}

	public Integer getStafferType() {
		return stafferType;
	}

	public void setStafferType(Integer stafferType) {
		this.stafferType = stafferType;
	}

}
