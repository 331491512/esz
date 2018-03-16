package com.westangel.common.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 患者bean
 * @author YYCHEN
 */
public class Patient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long patientId;

	private Long userId;
	
	private String uuid;

	private String preTrueName;
	
	//start 170323
	private String patientCode;
	private String inpatientNo;
	private String sourceDiseaseTypeName3;
	private String famZipCode;
	private String lastAttendingDate;
	private String cancelLostFollowupFlag;
	private String cancelLostFollowupTime;
	private String stafferType;
	private String deathPatientIntoTask;
	private String lostPatientIntoTask;
	private String otherHospital;
	//end 170323
	private String trueName;

	private String nickName;

	private String mobile;

	private Integer sex;
	
	private Integer syncFlag;

	private Date birthDate;

	private String userPictureUrl;

	private String familyName;

	private String familyPhone;
	
	private Integer marriageStatus;

	private Integer liveStatus;

	private Date deathDate;
	
	private Integer patientRelation;

	private String causeOfDeath;
	
	private String underlyCausesOfDeath;
	
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
	/*
	 * 门诊住院标识。
		1：门诊；2：住院(默认)
	 */
	private Integer outPatientFlag;
	
	private Integer isInHospitalDeath;
	
	private Integer isTumourDeath;
	
	private String deathCause;
	
	private Integer followupFlag;
	
	private Integer lostFollowupCauseResultValue;
	
	private String lostFollowupCause;
	
	private Date lostFollowupTime; 

	private Date createTime;

	private Date updateTime;
	
	/**
	 * lichenghao
	 */
	private String patientNo;
	private Date inhospitalDate;
	private Integer hospitalId;
	private String medicareCardNo;
	private Integer bodyWeight;
	private Integer icdDiseaseTypeId;
	private Integer sourceTumorFlag;
	private Integer diagnosisType;
	private Integer confirmedAge;
	private String inchargeDoctorUuid;
	private Long inchargeDoctor;
	private String clinicNo;
	private Integer patientType;
	private Date rawCreateTime;
	private Date syncTime;
	
	private String sourceDiseaseTypeName;
	private String inhospitalId;
	private String sourceDiseaseTypeName2;
	private Integer icdDiseaseTypeId2;
	private Integer sourceTumorFlag2;
	private Integer diagnosisType2;
	private String diagnosisId;
	private String diagnosisId2;
	private String inhospitalId2;
	private Integer confirmedAge2;
	private String sourcePathologyDiagnosis2;
	private String sourcePathologyDiseaseCode2;
	private String secondaryDiagnosis;
	private String secondaryDiseaseCode;
	private String secondaryPathologyDiagnosis;
	private String secondaryPathologyDiseaseCode;
	
	private Integer medicalCareAreaId;
	private String medicalCarePlace;
	//患者标识
	private int infoState=2;
	
	private Integer matchFlag;
	
	// 全程诊疗 add by zhuguo
	private String wholeProcessFlag;
	
	public String getWholeProcessFlag() {
		return wholeProcessFlag;
	}

	public void setWholeProcessFlag(String wholeProcessFlag) {
		this.wholeProcessFlag = wholeProcessFlag;
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

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
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

	
	public String getPatientCode() {
		return patientCode;
	}

	public void setPatientCode(String patientCode) {
		this.patientCode = patientCode;
	}

	public String getInpatientNo() {
		return inpatientNo;
	}

	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
	}

	public String getSourceDiseaseTypeName3() {
		return sourceDiseaseTypeName3;
	}

	public void setSourceDiseaseTypeName3(String sourceDiseaseTypeName3) {
		this.sourceDiseaseTypeName3 = sourceDiseaseTypeName3;
	}

	public String getFamZipCode() {
		return famZipCode;
	}

	public void setFamZipCode(String famZipCode) {
		this.famZipCode = famZipCode;
	}

	public String getLastAttendingDate() {
		return lastAttendingDate;
	}

	public void setLastAttendingDate(String lastAttendingDate) {
		this.lastAttendingDate = lastAttendingDate;
	}

	public String getCancelLostFollowupFlag() {
		return cancelLostFollowupFlag;
	}

	public void setCancelLostFollowupFlag(String cancelLostFollowupFlag) {
		this.cancelLostFollowupFlag = cancelLostFollowupFlag;
	}

	public String getCancelLostFollowupTime() {
		return cancelLostFollowupTime;
	}

	public void setCancelLostFollowupTime(String cancelLostFollowupTime) {
		this.cancelLostFollowupTime = cancelLostFollowupTime;
	}

	public String getStafferType() {
		return stafferType;
	}

	public void setStafferType(String stafferType) {
		this.stafferType = stafferType;
	}

	public String getDeathPatientIntoTask() {
		return deathPatientIntoTask;
	}

	public void setDeathPatientIntoTask(String deathPatientIntoTask) {
		this.deathPatientIntoTask = deathPatientIntoTask;
	}

	public String getLostPatientIntoTask() {
		return lostPatientIntoTask;
	}

	public void setLostPatientIntoTask(String lostPatientIntoTask) {
		this.lostPatientIntoTask = lostPatientIntoTask;
	}

	public String getOtherHospital() {
		return otherHospital;
	}

	public void setOtherHospital(String otherHospital) {
		this.otherHospital = otherHospital;
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

	public Long getInchargeDoctor() {
		return inchargeDoctor;
	}

	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
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

	public String getDeathCause() {
		return deathCause;
	}

	public void setDeathCause(String deathCause) {
		this.deathCause = deathCause;
	}

	public Integer getFollowupFlag() {
		return followupFlag;
	}

	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	public Integer getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}

	public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}

	public String getLostFollowupCause() {
		return lostFollowupCause;
	}

	public void setLostFollowupCause(String lostFollowupCause) {
		this.lostFollowupCause = lostFollowupCause;
	}

	public Date getLostFollowupTime() {
		return lostFollowupTime;
	}

	public void setLostFollowupTime(Date lostFollowupTime) {
		this.lostFollowupTime = lostFollowupTime;
	}
	
	/**
	 * 
	 * lichenghao
	 */
	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	public Date getInhospitalDate() {
		return inhospitalDate;
	}

	public void setInhospitalDate(Date inhospitalDate) {
		this.inhospitalDate = inhospitalDate;
	}

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getMedicareCardNo() {
		return medicareCardNo;
	}

	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
	}

	public Integer getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(Integer bodyWeight) {
		this.bodyWeight = bodyWeight;
	}

	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}

	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}

	public Integer getSourceTumorFlag() {
		return sourceTumorFlag;
	}

	public void setSourceTumorFlag(Integer sourceTumorFlag) {
		this.sourceTumorFlag = sourceTumorFlag;
	}

	public Integer getDiagnosisType() {
		return diagnosisType;
	}

	public void setDiagnosisType(Integer diagnosisType) {
		this.diagnosisType = diagnosisType;
	}

	public Integer getConfirmedAge() {
		return confirmedAge;
	}

	public void setConfirmedAge(Integer confirmedAge) {
		this.confirmedAge = confirmedAge;
	}

	public String getInchargeDoctorUuid() {
		return inchargeDoctorUuid;
	}

	public void setInchargeDoctorUuid(String inchargeDoctorUuid) {
		this.inchargeDoctorUuid = inchargeDoctorUuid;
	}

	public String getClinicNo() {
		return clinicNo;
	}

	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}

	public Integer getPatientType() {
		return patientType;
	}

	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}

	public Date getRawCreateTime() {
		return rawCreateTime;
	}

	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}

	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}

	public String getInhospitalId() {
		return inhospitalId;
	}

	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}

	public String getSourceDiseaseTypeName2() {
		return sourceDiseaseTypeName2;
	}

	public void setSourceDiseaseTypeName2(String sourceDiseaseTypeName2) {
		this.sourceDiseaseTypeName2 = sourceDiseaseTypeName2;
	}

	public Integer getIcdDiseaseTypeId2() {
		return icdDiseaseTypeId2;
	}

	public void setIcdDiseaseTypeId2(Integer icdDiseaseTypeId2) {
		this.icdDiseaseTypeId2 = icdDiseaseTypeId2;
	}

	public Integer getSourceTumorFlag2() {
		return sourceTumorFlag2;
	}

	public void setSourceTumorFlag2(Integer sourceTumorFlag2) {
		this.sourceTumorFlag2 = sourceTumorFlag2;
	}

	public Integer getDiagnosisType2() {
		return diagnosisType2;
	}

	public void setDiagnosisType2(Integer diagnosisType2) {
		this.diagnosisType2 = diagnosisType2;
	}

	public String getDiagnosisId2() {
		return diagnosisId2;
	}

	public void setDiagnosisId2(String diagnosisId2) {
		this.diagnosisId2 = diagnosisId2;
	}

	public String getInhospitalId2() {
		return inhospitalId2;
	}

	public void setInhospitalId2(String inhospitalId2) {
		this.inhospitalId2 = inhospitalId2;
	}

	public Integer getConfirmedAge2() {
		return confirmedAge2;
	}

	public void setConfirmedAge2(Integer confirmedAge2) {
		this.confirmedAge2 = confirmedAge2;
	}

	public String getSourcePathologyDiagnosis2() {
		return sourcePathologyDiagnosis2;
	}

	public void setSourcePathologyDiagnosis2(String sourcePathologyDiagnosis2) {
		this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2;
	}

	public String getSourcePathologyDiseaseCode2() {
		return sourcePathologyDiseaseCode2;
	}

	public void setSourcePathologyDiseaseCode2(String sourcePathologyDiseaseCode2) {
		this.sourcePathologyDiseaseCode2 = sourcePathologyDiseaseCode2;
	}

	public String getSecondaryDiagnosis() {
		return secondaryDiagnosis;
	}

	public void setSecondaryDiagnosis(String secondaryDiagnosis) {
		this.secondaryDiagnosis = secondaryDiagnosis;
	}

	public String getSecondaryDiseaseCode() {
		return secondaryDiseaseCode;
	}

	public void setSecondaryDiseaseCode(String secondaryDiseaseCode) {
		this.secondaryDiseaseCode = secondaryDiseaseCode;
	}

	public String getSecondaryPathologyDiagnosis() {
		return secondaryPathologyDiagnosis;
	}

	public void setSecondaryPathologyDiagnosis(String secondaryPathologyDiagnosis) {
		this.secondaryPathologyDiagnosis = secondaryPathologyDiagnosis;
	}

	public String getSecondaryPathologyDiseaseCode() {
		return secondaryPathologyDiseaseCode;
	}

	public void setSecondaryPathologyDiseaseCode(String secondaryPathologyDiseaseCode) {
		this.secondaryPathologyDiseaseCode = secondaryPathologyDiseaseCode;
	}

	public Integer getMedicalCareAreaId() {
		return medicalCareAreaId;
	}

	public void setMedicalCareAreaId(Integer medicalCareAreaId) {
		this.medicalCareAreaId = medicalCareAreaId;
	}

	public String getMedicalCarePlace() {
		return medicalCarePlace;
	}

	public void setMedicalCarePlace(String medicalCarePlace) {
		this.medicalCarePlace = medicalCarePlace;
	}
	
	public String getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	
	public int getInfoState() {
		return infoState;
	}

	public void setInfoState(int infoState) {
		this.infoState = infoState;
	}
	
	public String getUnderlyCausesOfDeath() {
		return underlyCausesOfDeath;
	}

	public Integer getMatchFlag() {
		return matchFlag;
	}

	public void setMatchFlag(Integer matchFlag) {
		this.matchFlag = matchFlag;
	}

	public void setUnderlyCausesOfDeath(String underlyCausesOfDeath) {
		this.underlyCausesOfDeath = underlyCausesOfDeath;
	}

	public static void main(String[] args) {
		String str = "patientId,uuid,patientNo,userId,medicareCardNo,trueName,nickNamemobile,familyName,familyPhone,sex,birthDate,userPictureUrl,patientRelation,liveStatus,deathDate,causeOfDeath,isInHospitalDeath,isTumourDeath,bloodType,bloodTypeRH,bodyHeight,bodyWeight,disabilityStatus,geneticDiseaseHistory,drugAllergyHistory,medicalPayType,medicalCareAreaId,medicalCarePlace,sourceDiagnosis,sourceDiagnosis2,sourceDiseaseCode,sourceDiseaseCode2,sourceDiseaseTypeId,sourceDiseaseTypeId2,sourceDiseaseTypeName,sourceDiseaseTypeName2,icdDiseaseTypeId,icdDiseaseTypeId2,sourceTumorFlag,sourceTumorFlag2,diagnosisType,diagnosisType2,diagnosisId,diagnosisId2,inhospitalId,inhospitalId2,confirmedDate,confirmedDate2,confirmedAge,confirmedAge2,sourcePathologyDiagnosis,sourcePathologyDiagnosis2,sourcePathologyDiseaseCode,sourcePathologyDiseaseCode2,attendingDoctor,inchargeDoctor,secondaryDiagnosis,secondaryDiseaseCode,secondaryPathologyDiagnosis,secondaryPathologyDiseaseCode,hasVisibleMedicalRecord,outPatientFlag,auditState,auditRemark,followupFlag,lostFollowupCauseResultValue,lostFollowupCause,lostFollowupTime,patientType,clinicNo,rawCreateTime,createTime,updateTime,syncTime";
		StringBuffer sb = new StringBuffer();
		for(String pc : str.split(",")){
			sb.append("<if test=\"").append(pc).append("!=null\">\n").append(pc).append("=").append("#{").append(pc).append("},\n</if>\n");
		}
		System.out.println(sb.toString());
	}
}