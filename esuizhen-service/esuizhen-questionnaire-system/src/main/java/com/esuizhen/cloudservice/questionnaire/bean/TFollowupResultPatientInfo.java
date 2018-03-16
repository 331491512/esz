package com.esuizhen.cloudservice.questionnaire.bean;

import java.io.Serializable;
import java.util.Date;

public class TFollowupResultPatientInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long patientId;

	private Long userId;
	
	private String uuid;

	private String preTrueName;
	
	private String trueName;

	private String nickName;

	private String mobile;

	private Integer sex;
	
	private String sexTxt;
	
	private Integer syncFlag;

	private Date birthDate;

	private String userPictureUrl;

	private String familyName;

	private String familyPhone;
	
	private Integer marriageStatus;

	private Integer liveStatus;

	private Date deathDate;
	
	private String deathCause;
	
	private Integer isInHospitalDeath;
	
	private Integer isTumourDeath;
	
	private Integer patientRelation;

	private String causeOfDeath;
	
	private String bloodType;

	private Integer bloodTypeRH;

	private Integer bodyHeight;

	private String disabilityStatus;

	private String geneticDiseaseHistory;

	private String drugAllergyHistory;

	private Integer medicalPayType;
	
	private Date latestClinicDate;
	
	private Date latestOutHospitalDate;
	
	private Date latestFollowupTime;

	private String sourceDiagnosis;

	private String sourceDiseaseCode;
	
	private Integer sourceDiseaseTypeId;

	private Date confirmedDate;

	private String sourceDiagnosis2;

	private String sourceDiseaseCode2;
	
	private Integer sourceDiseaseTypeId2;

	private Date confirmedDate2;

	private String sourceDiagnosis3;

	private String sourceDiseaseCode3;
	
	private Integer sourceDiseaseTypeId3;

	private Date confirmedDate3;

	private String sourcePathologyDiagnosis;

	private String sourcePathologyDiseaseCode;

	private Long attendingDoctor;
	
	private String attendingDoctorUuid;
	
	private Integer hasVisibleMedicalRecord;
	
	private Integer auditState;
	
	private String auditRemark;

	private Date createTime;

	private Date updateTime;
	
	private Integer followupFlag;
	
	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	/**
	 * 身份证号
	 */
	private String identification;
	
	/**
	 * 病案号
	 */
	private String patientNo;
	
	/**
	 * 年龄
	 */
	private Integer age;
	
	
	public Integer getIsInHospitalDeath() {
		return isInHospitalDeath;
	}

	public void setIsInHospitalDeath(Integer isInHospitalDeath) {
		this.isInHospitalDeath = isInHospitalDeath;
	}

	public Integer getIsTumourDeath() {
		return isTumourDeath;
	}

	public void setIsTumourDeath(Integer isTumourDeath) {
		this.isTumourDeath = isTumourDeath;
	}

	public String getSexTxt() {
		return sexTxt;
	}

	public void setSexTxt(String sexTxt) {
		this.sexTxt = sexTxt;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Long getPatientId() {
		return patientId;
	}

	public Integer getAuditState() {
		return auditState;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public Integer getPatientRelation() {
		return patientRelation;
	}

	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	public String getNickName() {
		return nickName;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getMarriageStatus() {
		return marriageStatus;
	}

	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}

	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public Integer getLiveStatus() {
		return liveStatus;
	}

	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	public Date getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Integer getBloodTypeRH() {
		return bloodTypeRH;
	}

	public void setBloodTypeRH(Integer bloodTypeRH) {
		this.bloodTypeRH = bloodTypeRH;
	}

	public Integer getBodyHeight() {
		return bodyHeight;
	}

	public void setBodyHeight(Integer bodyHeight) {
		this.bodyHeight = bodyHeight;
	}

	public String getDisabilityStatus() {
		return disabilityStatus;
	}

	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}

	public String getGeneticDiseaseHistory() {
		return geneticDiseaseHistory;
	}

	public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
		this.geneticDiseaseHistory = geneticDiseaseHistory;
	}

	public String getDrugAllergyHistory() {
		return drugAllergyHistory;
	}

	public void setDrugAllergyHistory(String drugAllergyHistory) {
		this.drugAllergyHistory = drugAllergyHistory;
	}

	public Integer getMedicalPayType() {
		return medicalPayType;
	}

	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
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

	public Long getAttendingDoctor() {
		return attendingDoctor;
	}

	public void setAttendingDoctor(Long attendingDoctor) {
		this.attendingDoctor = attendingDoctor;
	}

	public Date getConfirmedDate() {
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	public Integer getHasVisibleMedicalRecord() {
		return hasVisibleMedicalRecord;
	}

	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getLatestClinicDate() {
		return latestClinicDate;
	}

	public void setLatestClinicDate(Date latestClinicDate) {
		this.latestClinicDate = latestClinicDate;
	}

	public Date getLatestOutHospitalDate() {
		return latestOutHospitalDate;
	}

	public void setLatestOutHospitalDate(Date latestOutHospitalDate) {
		this.latestOutHospitalDate = latestOutHospitalDate;
	}

	public Date getLatestFollowupTime() {
		return latestFollowupTime;
	}

	public void setLatestFollowupTime(Date latestFollowupTime) {
		this.latestFollowupTime = latestFollowupTime;
	}

	public String getSourceDiagnosis2() {
		return sourceDiagnosis2;
	}

	public void setSourceDiagnosis2(String sourceDiagnosis2) {
		this.sourceDiagnosis2 = sourceDiagnosis2;
	}

	public String getSourceDiseaseCode2() {
		return sourceDiseaseCode2;
	}

	public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
		this.sourceDiseaseCode2 = sourceDiseaseCode2;
	}

	public Date getConfirmedDate2() {
		return confirmedDate2;
	}

	public void setConfirmedDate2(Date confirmedDate2) {
		this.confirmedDate2 = confirmedDate2;
	}

	public String getSourceDiagnosis3() {
		return sourceDiagnosis3;
	}

	public void setSourceDiagnosis3(String sourceDiagnosis3) {
		this.sourceDiagnosis3 = sourceDiagnosis3;
	}

	public String getSourceDiseaseCode3() {
		return sourceDiseaseCode3;
	}

	public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
		this.sourceDiseaseCode3 = sourceDiseaseCode3;
	}

	public Date getConfirmedDate3() {
		return confirmedDate3;
	}

	public void setConfirmedDate3(Date confirmedDate3) {
		this.confirmedDate3 = confirmedDate3;
	}

	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
	}

	public Integer getSourceDiseaseTypeId2() {
		return sourceDiseaseTypeId2;
	}

	public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
		this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
	}

	public Integer getSourceDiseaseTypeId3() {
		return sourceDiseaseTypeId3;
	}

	public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
		this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
	}

	/**
	 * @return the attendingDoctorUuid
	 */
	public String getAttendingDoctorUuid() {
		return attendingDoctorUuid;
	}

	/**
	 * @param attendingDoctorUuid the attendingDoctorUuid to set
	 */
	public void setAttendingDoctorUuid(String attendingDoctorUuid) {
		this.attendingDoctorUuid = attendingDoctorUuid;
	}

	/** 
	* @return preTrueName 
	*/
	public String getPreTrueName() {
		return preTrueName;
	}

	/** 
	* @param preTrueName 要设置的 preTrueName 
	*/
	public void setPreTrueName(String preTrueName) {
		this.preTrueName = preTrueName;
	}

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}
	
}