package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;

import com.esuizhen.cloudservice.sync.model.HospitalPatient;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;

/**
 * 医生基本信息
 * @author YYCHEN
 *
 */
public class TPatientSyncProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer opFlag;
	private Long userId;
	private String uuid;
	private String trueName;
	private Integer sex;
	private Date birthDate;
	private String country;
	private String mobile;
	private String city;
	private String nativePlace;
	private String cityCode;
	private String birthplace;
	private String districtid;
	private String nation;
	private Integer idType;
	private String identification;
	private String profession;
	private Integer marriageStatus;
	private String rawOccupationId;
	private String rawProfession;
	private Integer liveStatus;
	private Integer sourceFlag;
	private Date deathDate;
	private String causeOfDeath;
	private Date latestClinicDate;
	private Date latestOutHospitalDate;
	private Date latestFollowupTime;
	private Long attendingDoctor;
	private String attendingDoctorUuid;
	private String hospitalUuid;
	private Integer followupFlag;
	private String bloodType;
	private Integer bloodTypeRH;
	private Integer bodyHeight;
	private String disabilityStatus;
	private String geneticDiseaseHistory;
	private String drugAllergyHistory;
	private Integer medicalPayType;
	private Integer patientRelation;
	private String openId;
	private Integer followupState;
	private Integer followupResultValue;
	private Integer projectFollowupState;
	private Integer currFollowupPerformDays;
	private Integer sourceDiseaseTypeId1;
	private Date confirmedDate;
	private Integer sourceDiseaseTypeId2;
	private Date confirmedDate2;
	private Integer sourceDiseaseTypeId3;
	private Date confirmedDate3;
	private Integer hasVisibleMedicalRecord;
	private Integer auditState;
	private String auditRemark;
	private String userPictureUrl;
	/*
	 * 门诊住院标识。
		1：门诊；2：住院(默认)
	 */
	private Integer outPatientFlag;
	private String patientNo;
	private String nickName;
	private List<TPatientContactInfo> patientContactList;
	
	private Date inhospitalDate;
	private Integer hospitalId;
	private Long patientId;
	/**
	 * lichenghao
	 */
	private String medicareCardNo;
	private Integer isInHospitalDeath;
	private Integer isTumourDeath;
	private Integer bodyWeight;
	private String sourceDiagnosis;
	private String sourceDiseaseCode;
	private Integer sourceDiseaseTypeId;
	private Integer icdDiseaseTypeId;
	private Integer sourceTumorFlag;
	private Integer diagnosisType;
	private Integer confirmedAge;
	private String sourcePathologyDiagnosis;
	private String sourcePathologyDiseaseCode;
	private Long inchargeDoctor;
	private String inchargeDoctorUuid;
	private Integer lostFollowupCauseResultValue;
	private String lostFollowupCause;
	private Date lostFollowupTime;
	private String clinicNo;
	private Integer patientType;
	private Date rawCreateTime;
	private Date createTime;
	private Date updateTime;
	private Date syncTime;
	
	//11-12 lichenghao
	private String sourceDiseaseTypeName;
	private String inhospitalId;
	private String sourceDiseaseCode2;
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
	private Integer syncFlag;
	private String sourceDiagnosis2;
	
	private Integer medicalCareAreaId;
	private String medicalCarePlace;
	
	
	//start 170323
		private String patientCode;
		private String inpatientNo;
		private String preTrueName;
		private String underlyCausesOfDeath;
		private String sourceDiagnosis3;
		private String sourceDiseaseCode3;
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
		
	private int pInfoState=2;
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	
	public Integer getSyncFlag() {
		return syncFlag;
	}

	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}

	public Integer getSourceFlag() {
		return sourceFlag;
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

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getPatientNo() {
		return patientNo;
	}

	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}

	/**
	 * @return the opFlag
	 */
	public Integer getOpFlag() {
		return opFlag;
	}

	/**
	 * @param opFlag the opFlag to set
	 */
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}

	/**
	 * @return the trueName
	 */
	public String getTrueName() {
		return trueName;
	}

	/**
	 * @param trueName the trueName to set
	 */
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	/**
	 * @return the patientId
	 */
	public Long getPatientId() {
		return patientId;
	}

	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	/**
	 * @return the idType
	 */
	public Integer getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthDate
	 */
	public Date getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the nativePlace
	 */
	public String getNativePlace() {
		return nativePlace;
	}

	/**
	 * @param nativePlace the nativePlace to set
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	/**
	 * @return the birthplace
	 */
	public String getBirthplace() {
		return birthplace;
	}

	/**
	 * @param birthplace the birthplace to set
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	/**
	 * @return the districtid
	 */
	public String getDistrictid() {
		return districtid;
	}

	/**
	 * @param districtid the districtid to set
	 */
	public void setDistrictid(String districtid) {
		this.districtid = districtid;
	}

	/**
	 * @return the nation
	 */
	public String getNation() {
		return nation;
	}

	/**
	 * @param nation the nation to set
	 */
	public void setNation(String nation) {
		this.nation = nation;
	}

	/**
	 * @return the identification
	 */
	public String getIdentification() {
		return identification;
	}

	/**
	 * @param identification the identification to set
	 */
	public void setIdentification(String identification) {
		this.identification = identification;
	}

	/**
	 * @return the profession
	 */
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the marriageStatus
	 */
	public Integer getMarriageStatus() {
		return marriageStatus;
	}

	/**
	 * @param marriageStatus the marriageStatus to set
	 */
	public void setMarriageStatus(Integer marriageStatus) {
		this.marriageStatus = marriageStatus;
	}


	/**
	 * @return the liveStatus
	 */
	public Integer getLiveStatus() {
		return liveStatus;
	}

	/**
	 * @param liveStatus the liveStatus to set
	 */
	public void setLiveStatus(Integer liveStatus) {
		this.liveStatus = liveStatus;
	}

	/**
	 * @return the deathDate
	 */
	public Date getDeathDate() {
		return deathDate;
	}

	/**
	 * @param deathDate the deathDate to set
	 */
	public void setDeathDate(Date deathDate) {
		this.deathDate = deathDate;
	}

	/**
	 * @return the causeOfDeath
	 */
	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	/**
	 * @param causeOfDeath the causeOfDeath to set
	 */
	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	/**
	 * @return the latestClinicDate
	 */
	public Date getLatestClinicDate() {
		return latestClinicDate;
	}

	/**
	 * @param latestClinicDate the latestClinicDate to set
	 */
	public void setLatestClinicDate(Date latestClinicDate) {
		this.latestClinicDate = latestClinicDate;
	}

	/**
	 * @return the latestOutHospitalDate
	 */
	public Date getLatestOutHospitalDate() {
		return latestOutHospitalDate;
	}

	/**
	 * @param latestOutHospitalDate the latestOutHospitalDate to set
	 */
	public void setLatestOutHospitalDate(Date latestOutHospitalDate) {
		this.latestOutHospitalDate = latestOutHospitalDate;
	}

	/**
	 * @return the latestFollowupTime
	 */
	public Date getLatestFollowupTime() {
		return latestFollowupTime;
	}

	/**
	 * @param latestFollowupTime the latestFollowupTime to set
	 */
	public void setLatestFollowupTime(Date latestFollowupTime) {
		this.latestFollowupTime = latestFollowupTime;
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
	 * @return the hospitalUuid
	 */
	public String getHospitalUuid() {
		return hospitalUuid;
	}

	/**
	 * @param hospitalUuid the hospitalUuid to set
	 */
	public void setHospitalUuid(String hospitalUuid) {
		this.hospitalUuid = hospitalUuid;
	}

	/**
	 * @return the followupFlag
	 */
	public Integer getFollowupFlag() {
		return followupFlag;
	}

	/**
	 * @param followupFlag the followupFlag to set
	 */
	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}

	/**
	 * @return the bloodType
	 */
	public String getBloodType() {
		return bloodType;
	}

	/**
	 * @param bloodType the bloodType to set
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	/**
	 * @return the bloodTypeRH
	 */
	public Integer getBloodTypeRH() {
		return bloodTypeRH;
	}

	/**
	 * @param bloodTypeRH the bloodTypeRH to set
	 */
	public void setBloodTypeRH(Integer bloodTypeRH) {
		this.bloodTypeRH = bloodTypeRH;
	}

	/**
	 * @return the bodyHeight
	 */
	public Integer getBodyHeight() {
		return bodyHeight;
	}

	/**
	 * @param bodyHeight the bodyHeight to set
	 */
	public void setBodyHeight(Integer bodyHeight) {
		this.bodyHeight = bodyHeight;
	}

	/**
	 * @return the disabilityStatus
	 */
	public String getDisabilityStatus() {
		return disabilityStatus;
	}

	/**
	 * @param disabilityStatus the disabilityStatus to set
	 */
	public void setDisabilityStatus(String disabilityStatus) {
		this.disabilityStatus = disabilityStatus;
	}

	/**
	 * @return the geneticDiseaseHistory
	 */
	public String getGeneticDiseaseHistory() {
		return geneticDiseaseHistory;
	}

	/**
	 * @param geneticDiseaseHistory the geneticDiseaseHistory to set
	 */
	public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
		this.geneticDiseaseHistory = geneticDiseaseHistory;
	}

	/**
	 * @return the drugAllergyHistory
	 */
	public String getDrugAllergyHistory() {
		return drugAllergyHistory;
	}

	/**
	 * @param drugAllergyHistory the drugAllergyHistory to set
	 */
	public void setDrugAllergyHistory(String drugAllergyHistory) {
		this.drugAllergyHistory = drugAllergyHistory;
	}

	/**
	 * @return the medicalPayType
	 */
	public Integer getMedicalPayType() {
		return medicalPayType;
	}

	/**
	 * @param medicalPayType the medicalPayType to set
	 */
	public void setMedicalPayType(Integer medicalPayType) {
		this.medicalPayType = medicalPayType;
	}

	/**
	 * @return the patientRelation
	 */
	public Integer getPatientRelation() {
		return patientRelation;
	}

	/**
	 * @param patientRelation the patientRelation to set
	 */
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}

	/**
	 * @return the openId
	 */
	public String getOpenId() {
		return openId;
	}

	/**
	 * @param openId the openId to set
	 */
	public void setOpenId(String openId) {
		this.openId = openId;
	}

	/**
	 * @return the followupState
	 */
	public Integer getFollowupState() {
		return followupState;
	}

	/**
	 * @param followupState the followupState to set
	 */
	public void setFollowupState(Integer followupState) {
		this.followupState = followupState;
	}

	/**
	 * @return the followupResultValue
	 */
	public Integer getFollowupResultValue() {
		return followupResultValue;
	}

	/**
	 * @param followupResultValue the followupResultValue to set
	 */
	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}

	/**
	 * @return the projectFollowupState
	 */
	public Integer getProjectFollowupState() {
		return projectFollowupState;
	}

	/**
	 * @param projectFollowupState the projectFollowupState to set
	 */
	public void setProjectFollowupState(Integer projectFollowupState) {
		this.projectFollowupState = projectFollowupState;
	}

	/**
	 * @return the currFollowupPerformDays
	 */
	public Integer getCurrFollowupPerformDays() {
		return currFollowupPerformDays;
	}

	/**
	 * @param currFollowupPerformDays the currFollowupPerformDays to set
	 */
	public void setCurrFollowupPerformDays(Integer currFollowupPerformDays) {
		this.currFollowupPerformDays = currFollowupPerformDays;
	}

	/**
	 * @return the sourceDiseaseTypeId1
	 */
	public Integer getSourceDiseaseTypeId1() {
		return sourceDiseaseTypeId1;
	}

	/**
	 * @param sourceDiseaseTypeId1 the sourceDiseaseTypeId1 to set
	 */
	public void setSourceDiseaseTypeId1(Integer sourceDiseaseTypeId1) {
		this.sourceDiseaseTypeId1 = sourceDiseaseTypeId1;
	}

	/**
	 * @return the confirmedDate
	 */
	public Date getConfirmedDate() {
		return confirmedDate;
	}

	/**
	 * @param confirmedDate the confirmedDate to set
	 */
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	/**
	 * @return the sourceDiseaseTypeId2
	 */
	public Integer getSourceDiseaseTypeId2() {
		return sourceDiseaseTypeId2;
	}

	/**
	 * @param sourceDiseaseTypeId2 the sourceDiseaseTypeId2 to set
	 */
	public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
		this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
	}

	/**
	 * @return the confirmedDate2
	 */
	public Date getConfirmedDate2() {
		return confirmedDate2;
	}

	/**
	 * @param confirmedDate2 the confirmedDate2 to set
	 */
	public void setConfirmedDate2(Date confirmedDate2) {
		this.confirmedDate2 = confirmedDate2;
	}

	/**
	 * @return the sourceDiseaseTypeId3
	 */
	public Integer getSourceDiseaseTypeId3() {
		return sourceDiseaseTypeId3;
	}

	/**
	 * @param sourceDiseaseTypeId3 the sourceDiseaseTypeId3 to set
	 */
	public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
		this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
	}

	/**
	 * @return the confirmedDate3
	 */
	public Date getConfirmedDate3() {
		return confirmedDate3;
	}

	/**
	 * @param confirmedDate3 the confirmedDate3 to set
	 */
	public void setConfirmedDate3(Date confirmedDate3) {
		this.confirmedDate3 = confirmedDate3;
	}

	/**
	 * @return the hasVisibleMedicalRecord
	 */
	public Integer getHasVisibleMedicalRecord() {
		return hasVisibleMedicalRecord;
	}

	/**
	 * @param hasVisibleMedicalRecord the hasVisibleMedicalRecord to set
	 */
	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
	}

	/**
	 * @return the auditState
	 */
	public Integer getAuditState() {
		return auditState;
	}

	/**
	 * @param auditState the auditState to set
	 */
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}

	/**
	 * @return the auditRemark
	 */
	public String getAuditRemark() {
		return auditRemark;
	}

	/**
	 * @param auditRemark the auditRemark to set
	 */
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	/**
	 * @return the userPictureUrl
	 */
	public String getUserPictureUrl() {
		return userPictureUrl;
	}

	/**
	 * @param userPictureUrl the userPictureUrl to set
	 */
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * @return the patientContactList
	 */
	public List<TPatientContactInfo> getPatientContactList() {
		return patientContactList;
	}

	/**
	 * @param patientContactList the patientContactList to set
	 */
	public void setPatientContactList(List<TPatientContactInfo> patientContactList) {
		this.patientContactList = patientContactList;
	}

	public String getMedicareCardNo() {
		return medicareCardNo;
	}

	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
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

	public Integer getBodyWeight() {
		return bodyWeight;
	}

	public void setBodyWeight(Integer bodyWeight) {
		this.bodyWeight = bodyWeight;
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

	public Integer getSourceDiseaseTypeId() {
		return sourceDiseaseTypeId;
	}

	public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
		this.sourceDiseaseTypeId = sourceDiseaseTypeId;
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

	public String getInchargeDoctorUuid() {
		return inchargeDoctorUuid;
	}

	public void setInchargeDoctorUuid(String inchargeDoctorUuid) {
		this.inchargeDoctorUuid = inchargeDoctorUuid;
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

	public String getSourceDiseaseCode2() {
		return sourceDiseaseCode2;
	}

	public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
		this.sourceDiseaseCode2 = sourceDiseaseCode2;
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
	
	public String getSourceDiagnosis2() {
		return sourceDiagnosis2;
	}

	public void setSourceDiagnosis2(String sourceDiagnosis2) {
		this.sourceDiagnosis2 = sourceDiagnosis2;
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

	public String getPreTrueName() {
		return preTrueName;
	}

	public void setPreTrueName(String preTrueName) {
		this.preTrueName = preTrueName;
	}

	public String getUnderlyCausesOfDeath() {
		return underlyCausesOfDeath;
	}

	public void setUnderlyCausesOfDeath(String underlyCausesOfDeath) {
		this.underlyCausesOfDeath = underlyCausesOfDeath;
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

	public int getpInfoState() {
		return pInfoState;
	}

	public void setpInfoState(int pInfoState) {
		this.pInfoState = pInfoState;
	}

	public User createUser(){
		User user = new User();
		BeanUtils.copyProperties(this, user);
		user.setUserName(mobile);
		user.setRole(Constant.User.ROLE_PATIENT);
		return user;
	}
	
	public User createColudUser(){
		User user = createUser();
		if(StringUtils.isEmpty(user.getUserName()))
			user.setUserName("TEMP" + GeneralUtil.getCaptchaNum() + GeneralUtil.generatorRandom(10));
		user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		user.setSyncFlag(Constant.User.SYNCFLAG_YES);
		user.setAccountType(Constant.User.ACCOUNTTYPE_NONACTIVATED);
		user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
		user.setState(Constant.User.USERSTATE_NORMAL);
		user.setInfoState(Constant.User.INFOSTATE_REALNAME);
		if(StringUtils.isEmpty(identification)){
			user.setIdType(null);
			user.setIdentification(null);
			user.setInfoState(null);
		}
		user.setSourceFlag(sourceFlag);
		user.setPoints(0);
		return user;
	}
	
	public Patient createPatient(){
		Patient patient = new Patient();
		BeanUtils.copyProperties(this, patient);
		patient.setInfoState(this.pInfoState);//患者标识
		return patient;
	}
	
	public Patient createColudPatient(){
		Patient patient = createPatient();
		patient.setAuditState(Constant.User.AUDITSTATE_NOT);
		patient.setPatientRelation(Constant.User.PATIENTRELATION_ONESELF);
		patient.setSyncFlag(Constant.User.SYNCFLAG_YES);
		patient.setHasVisibleMedicalRecord(Constant.User.HASVISIBLEMEDICALRECORD_NO);
		/*if(StringUtils.isNotEmpty(identification))
			patient.setAuditState(Constant.User.AUDITSTATE_ADVANCEDPASS);*/
		if(patient.getLiveStatus()==null)
			patient.setLiveStatus(Constant.User.LIVESTATUS_ALIVE);
		return patient;
	}
	
	public HospitalPatient createHospitalPatient(){
		HospitalPatient hospitalPatient = new HospitalPatient();
		hospitalPatient.setHospitalId(hospitalId);
		hospitalPatient.setPatientUuid(uuid);
		hospitalPatient.setPatientNo(patientNo);
		hospitalPatient.setCreateTime(rawCreateTime);
		hospitalPatient.setSyncTime(syncTime);
		return hospitalPatient;
	}

	public Patient mergerPatient(Patient patient) {
		// TODO Auto-generated method stub
		Patient targetPatient = new Patient();
		BeanUtils.copyProperties(patient, targetPatient);
		this.userId = patient.getUserId();
		this.uuid = patient.getUuid();
		this.patientId = patient.getPatientId();
		BeanUtils.copyProperties(createColudPatient(), targetPatient);
		return targetPatient;
	}

	public String getRawOccupationId() {
		return rawOccupationId;
	}

	public void setRawOccupationId(String rawOccupationId) {
		this.rawOccupationId = rawOccupationId;
	}

	public String getRawProfession() {
		return rawProfession;
	}

	public void setRawProfession(String rawProfession) {
		this.rawProfession = rawProfession;
	}
	
}
