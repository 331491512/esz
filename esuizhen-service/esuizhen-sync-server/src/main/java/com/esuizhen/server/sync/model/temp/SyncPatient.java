package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;


/**
 * 患者bean
 * @author LHY
 */
public class SyncPatient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long patientId;
	private String patientNo;
	private Integer opFlag;
	private String patientCode;
	private String inpatientNo;
	private Long userId;
	private String uuid;
	private String mobile;
	private String trueName;
	private String preTrueName;
	private Integer auditState;
	private String auditRemark;
	private String nickName;
	private Integer hasVisibleMedicalRecord;
	private Integer sex;
	private Date birthDate;
	private String userPictureUrl;
	private Integer patientRelation;
	private String familyName;
	private String familyPhone;
	private Integer liveStatus;
	private Date deathDate;
	private String causeOfDeath;
	private String underlyCausesOfDeath;
	private Integer isInHospitalDeath;
	private Integer isTumourDeath;
	private String bloodType;
	private Integer bloodTypeRH;
	private Integer bodyHeight;
	private String disabilityStatus;
	private String geneticDiseaseHistory;
	private String drugAllergyHistory;
	private Integer medicalPayType;
	private String sourceDiagnosis;
	private String sourceDiagnosis2;
	private String sourceDiagnosis3;
	private String sourceDiseaseCode;
	private String sourceDiseaseCode2;
	private String sourceDiseaseCode3;
	private Integer sourceDiseaseTypeId;
	private Integer sourceDiseaseTypeId2;
	private Integer sourceDiseaseTypeId3;
	private String sourceDiseaseTypeName;
	private String sourceDiseaseTypeName2;
	private String sourceDiseaseTypeName3;
	private Integer icdDiseaseTypeId;
	private Integer icdDiseaseTypeId2;
	private Integer diagnosisType;
	private Integer diagnosisType2;
	private Integer sourceTumorFlag;
	private Integer sourceTumorFlag2;
	private Date confirmedDate;
	private Date confirmedDate2;
	private Date confirmedDate3;
	private Integer confirmedAge;
	private Integer confirmedAge2;
	private String diagnosisId;
	private String diagnosisId2;
	private String inhospitalId;
	private String inhospitalId2;
	private String sourcePathologyDiagnosis;
	private String sourcePathologyDiagnosis2;
	private String sourcePathologyDiseaseCode;
	private String sourcePathologyDiseaseCode2;
	private String secondaryDiagnosis;
	private String secondaryDiseaseCode;
	private String secondaryPathologyDiagnosis;
	private String secondaryPathologyDiseaseCode;
	private Long attendingDoctor;
	private String attendingDoctorUuid;
	private Long inchargeDoctor;
	private String inchargeDoctorUuid;
	private Integer followupFlag;
	private String lostFollowupCause;
	private Integer lostFollowupCauseResultValue;
	private String lostFollowupTime;
	private Integer oldFollowupFlag;
	private String oldLostFollowupCause;
	private Integer oldLostFollowupCauseResultValue;
	private Date oldLostFollowupTime;
	private Date createTime;
	private Date updateTime;
	private Integer codePerson;
	private String codePersonName;
	private Integer handleFlag;
	private Integer outPatientFlag;
	private Integer inhospitalState;
	private Integer patientType;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private String mergeTime;
	private String clinicNo;
	private String medicareCardNo;
	private Integer medicalCareAreaId;
	private String medicalCarePlace;
	private String famZipCode;
	private Date rawCreateTime;
	private Date lastAttendingDate;
	private Integer bodyWeight;
	private Integer cancelLostFollowupFlag;
	private Date cancelLostFollowupTime;
	private Integer infoState;
	private Integer stafferType;
	private Long specialDiseaseRegisterId;
	private Integer deathPatientIntoTask;
	private Integer lostPatientIntoTask;
	private String otherHospital;
	private String batchId;
	private Integer hospitalId;
	
	//业务处理字段
	private Integer syncFlag;
	
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
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
	public Integer getOpFlag() {
		return opFlag;
	}
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPreTrueName() {
		return preTrueName;
	}
	public void setPreTrueName(String preTrueName) {
		this.preTrueName = preTrueName;
	}
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public String getAuditRemark() {
		return auditRemark;
	}
	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getHasVisibleMedicalRecord() {
		return hasVisibleMedicalRecord;
	}
	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord) {
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
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
	public String getUserPictureUrl() {
		return userPictureUrl;
	}
	public void setUserPictureUrl(String userPictureUrl) {
		this.userPictureUrl = userPictureUrl;
	}
	public Integer getPatientRelation() {
		return patientRelation;
	}
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
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
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}
	public String getUnderlyCausesOfDeath() {
		return underlyCausesOfDeath;
	}
	public void setUnderlyCausesOfDeath(String underlyCausesOfDeath) {
		this.underlyCausesOfDeath = underlyCausesOfDeath;
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
	public String getSourceDiagnosis2() {
		return sourceDiagnosis2;
	}
	public void setSourceDiagnosis2(String sourceDiagnosis2) {
		this.sourceDiagnosis2 = sourceDiagnosis2;
	}
	public String getSourceDiagnosis3() {
		return sourceDiagnosis3;
	}
	public void setSourceDiagnosis3(String sourceDiagnosis3) {
		this.sourceDiagnosis3 = sourceDiagnosis3;
	}
	public String getSourceDiseaseCode() {
		return sourceDiseaseCode;
	}
	public void setSourceDiseaseCode(String sourceDiseaseCode) {
		this.sourceDiseaseCode = sourceDiseaseCode;
	}
	public String getSourceDiseaseCode2() {
		return sourceDiseaseCode2;
	}
	public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
		this.sourceDiseaseCode2 = sourceDiseaseCode2;
	}
	public String getSourceDiseaseCode3() {
		return sourceDiseaseCode3;
	}
	public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
		this.sourceDiseaseCode3 = sourceDiseaseCode3;
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
	public String getSourceDiseaseTypeName() {
		return sourceDiseaseTypeName;
	}
	public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
		this.sourceDiseaseTypeName = sourceDiseaseTypeName;
	}
	public String getSourceDiseaseTypeName2() {
		return sourceDiseaseTypeName2;
	}
	public void setSourceDiseaseTypeName2(String sourceDiseaseTypeName2) {
		this.sourceDiseaseTypeName2 = sourceDiseaseTypeName2;
	}
	public String getSourceDiseaseTypeName3() {
		return sourceDiseaseTypeName3;
	}
	public void setSourceDiseaseTypeName3(String sourceDiseaseTypeName3) {
		this.sourceDiseaseTypeName3 = sourceDiseaseTypeName3;
	}
	public Integer getIcdDiseaseTypeId() {
		return icdDiseaseTypeId;
	}
	public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
		this.icdDiseaseTypeId = icdDiseaseTypeId;
	}
	public Integer getIcdDiseaseTypeId2() {
		return icdDiseaseTypeId2;
	}
	public void setIcdDiseaseTypeId2(Integer icdDiseaseTypeId2) {
		this.icdDiseaseTypeId2 = icdDiseaseTypeId2;
	}
	public Integer getDiagnosisType() {
		return diagnosisType;
	}
	public void setDiagnosisType(Integer diagnosisType) {
		this.diagnosisType = diagnosisType;
	}
	public Integer getDiagnosisType2() {
		return diagnosisType2;
	}
	public void setDiagnosisType2(Integer diagnosisType2) {
		this.diagnosisType2 = diagnosisType2;
	}
	public Integer getSourceTumorFlag() {
		return sourceTumorFlag;
	}
	public void setSourceTumorFlag(Integer sourceTumorFlag) {
		this.sourceTumorFlag = sourceTumorFlag;
	}
	public Integer getSourceTumorFlag2() {
		return sourceTumorFlag2;
	}
	public void setSourceTumorFlag2(Integer sourceTumorFlag2) {
		this.sourceTumorFlag2 = sourceTumorFlag2;
	}
	public Date getConfirmedDate() {
		return confirmedDate;
	}
	public void setConfirmedDate(Date confirmedDate) {
		this.confirmedDate = confirmedDate;
	}
	public Date getConfirmedDate2() {
		return confirmedDate2;
	}
	public void setConfirmedDate2(Date confirmedDate2) {
		this.confirmedDate2 = confirmedDate2;
	}
	public Date getConfirmedDate3() {
		return confirmedDate3;
	}
	public void setConfirmedDate3(Date confirmedDate3) {
		this.confirmedDate3 = confirmedDate3;
	}
	public Integer getConfirmedAge() {
		return confirmedAge;
	}
	public void setConfirmedAge(Integer confirmedAge) {
		this.confirmedAge = confirmedAge;
	}
	public Integer getConfirmedAge2() {
		return confirmedAge2;
	}
	public void setConfirmedAge2(Integer confirmedAge2) {
		this.confirmedAge2 = confirmedAge2;
	}
	public String getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getDiagnosisId2() {
		return diagnosisId2;
	}
	public void setDiagnosisId2(String diagnosisId2) {
		this.diagnosisId2 = diagnosisId2;
	}
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getInhospitalId2() {
		return inhospitalId2;
	}
	public void setInhospitalId2(String inhospitalId2) {
		this.inhospitalId2 = inhospitalId2;
	}
	public String getSourcePathologyDiagnosis() {
		return sourcePathologyDiagnosis;
	}
	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}
	public String getSourcePathologyDiagnosis2() {
		return sourcePathologyDiagnosis2;
	}
	public void setSourcePathologyDiagnosis2(String sourcePathologyDiagnosis2) {
		this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2;
	}
	public String getSourcePathologyDiseaseCode() {
		return sourcePathologyDiseaseCode;
	}
	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
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
	public String getAttendingDoctorUuid() {
		return attendingDoctorUuid;
	}
	public void setAttendingDoctorUuid(String attendingDoctorUuid) {
		this.attendingDoctorUuid = attendingDoctorUuid;
	}
	public Long getInchargeDoctor() {
		return inchargeDoctor;
	}
	public void setInchargeDoctor(Long inchargeDoctor) {
		this.inchargeDoctor = inchargeDoctor;
	}
	public String getInchargeDoctorUuid() {
		return inchargeDoctorUuid;
	}
	public void setInchargeDoctorUuid(String inchargeDoctorUuid) {
		this.inchargeDoctorUuid = inchargeDoctorUuid;
	}
	public Integer getFollowupFlag() {
		return followupFlag;
	}
	public void setFollowupFlag(Integer followupFlag) {
		this.followupFlag = followupFlag;
	}
	public String getLostFollowupCause() {
		return lostFollowupCause;
	}
	public void setLostFollowupCause(String lostFollowupCause) {
		this.lostFollowupCause = lostFollowupCause;
	}
	public Integer getLostFollowupCauseResultValue() {
		return lostFollowupCauseResultValue;
	}
	public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
		this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
	}
	public String getLostFollowupTime() {
		return lostFollowupTime;
	}
	public void setLostFollowupTime(String lostFollowupTime) {
		this.lostFollowupTime = lostFollowupTime;
	}
	public Integer getOldFollowupFlag() {
		return oldFollowupFlag;
	}
	public void setOldFollowupFlag(Integer oldFollowupFlag) {
		this.oldFollowupFlag = oldFollowupFlag;
	}
	public String getOldLostFollowupCause() {
		return oldLostFollowupCause;
	}
	public void setOldLostFollowupCause(String oldLostFollowupCause) {
		this.oldLostFollowupCause = oldLostFollowupCause;
	}
	public Integer getOldLostFollowupCauseResultValue() {
		return oldLostFollowupCauseResultValue;
	}
	public void setOldLostFollowupCauseResultValue(Integer oldLostFollowupCauseResultValue) {
		this.oldLostFollowupCauseResultValue = oldLostFollowupCauseResultValue;
	}
	public Date getOldLostFollowupTime() {
		return oldLostFollowupTime;
	}
	public void setOldLostFollowupTime(Date oldLostFollowupTime) {
		this.oldLostFollowupTime = oldLostFollowupTime;
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
	public Integer getCodePerson() {
		return codePerson;
	}
	public void setCodePerson(Integer codePerson) {
		this.codePerson = codePerson;
	}
	public String getCodePersonName() {
		return codePersonName;
	}
	public void setCodePersonName(String codePersonName) {
		this.codePersonName = codePersonName;
	}
	public Integer getHandleFlag() {
		return handleFlag;
	}
	public void setHandleFlag(Integer handleFlag) {
		this.handleFlag = handleFlag;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}
	public Integer getPatientType() {
		return patientType;
	}
	public void setPatientType(Integer patientType) {
		this.patientType = patientType;
	}
	public Integer getMergeFlag() {
		return mergeFlag;
	}
	public void setMergeFlag(Integer mergeFlag) {
		this.mergeFlag = mergeFlag;
	}
	public Long getMergeFrom() {
		return mergeFrom;
	}
	public void setMergeFrom(Long mergeFrom) {
		this.mergeFrom = mergeFrom;
	}
	public String getMergeFromUuid() {
		return mergeFromUuid;
	}
	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}
	public Long getMergeTarget() {
		return mergeTarget;
	}
	public void setMergeTarget(Long mergeTarget) {
		this.mergeTarget = mergeTarget;
	}
	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}
	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
	public String getMergeTime() {
		return mergeTime;
	}
	public void setMergeTime(String mergeTime) {
		this.mergeTime = mergeTime;
	}
	public String getClinicNo() {
		return clinicNo;
	}
	public void setClinicNo(String clinicNo) {
		this.clinicNo = clinicNo;
	}
	public String getMedicareCardNo() {
		return medicareCardNo;
	}
	public void setMedicareCardNo(String medicareCardNo) {
		this.medicareCardNo = medicareCardNo;
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
	public String getFamZipCode() {
		return famZipCode;
	}
	public void setFamZipCode(String famZipCode) {
		this.famZipCode = famZipCode;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Date getLastAttendingDate() {
		return lastAttendingDate;
	}
	public void setLastAttendingDate(Date lastAttendingDate) {
		this.lastAttendingDate = lastAttendingDate;
	}
	public Integer getBodyWeight() {
		return bodyWeight;
	}
	public void setBodyWeight(Integer bodyWeight) {
		this.bodyWeight = bodyWeight;
	}
	public Integer getCancelLostFollowupFlag() {
		return cancelLostFollowupFlag;
	}
	public void setCancelLostFollowupFlag(Integer cancelLostFollowupFlag) {
		this.cancelLostFollowupFlag = cancelLostFollowupFlag;
	}
	public Date getCancelLostFollowupTime() {
		return cancelLostFollowupTime;
	}
	public void setCancelLostFollowupTime(Date cancelLostFollowupTime) {
		this.cancelLostFollowupTime = cancelLostFollowupTime;
	}
	public Integer getInfoState() {
		return infoState;
	}
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
	public Integer getStafferType() {
		return stafferType;
	}
	public void setStafferType(Integer stafferType) {
		this.stafferType = stafferType;
	}
	public Long getSpecialDiseaseRegisterId() {
		return specialDiseaseRegisterId;
	}
	public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
		this.specialDiseaseRegisterId = specialDiseaseRegisterId;
	}
	public Integer getDeathPatientIntoTask() {
		return deathPatientIntoTask;
	}
	public void setDeathPatientIntoTask(Integer deathPatientIntoTask) {
		this.deathPatientIntoTask = deathPatientIntoTask;
	}
	public Integer getLostPatientIntoTask() {
		return lostPatientIntoTask;
	}
	public void setLostPatientIntoTask(Integer lostPatientIntoTask) {
		this.lostPatientIntoTask = lostPatientIntoTask;
	}
	public String getOtherHospital() {
		return otherHospital;
	}
	public void setOtherHospital(String otherHospital) {
		this.otherHospital = otherHospital;
	}
	
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public Integer getInhospitalState() {
		return inhospitalState;
	}
	public void setInhospitalState(Integer inhospitalState) {
		this.inhospitalState = inhospitalState;
	}
	public TBatchDataResultInfo createResultInfo(){
		TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
		resultInfo.setOpFlag(this.patientId==null?1:2);
		resultInfo.setSyncTime(new Date());
		resultInfo.setResultId(this.uuid);
		return resultInfo;
	}
}