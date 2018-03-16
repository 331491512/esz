package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:41
 */
public class TPatient implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long patientId;

    private Long userId;

    private String uuid;

    private Integer syncFlag;

    private String mobile;

    private String trueName;

    private String preTrueName;

    private Integer auditState;

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

    private Integer isTumourDeath;

    private String bloodType;

    private Integer bloodTypeRH;

    private Integer bodyHeight;

    private Integer bodyWeight;

    private String disabilityStatus;

    private String geneticDiseaseHistory;

    private String drugAllergyHistory;

    private Integer medicalPayType;

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

    private Long inchargeDoctor;

    private Integer followupFlag;

    private String lostFollowupCause;

    private Integer trueNameDataFlag;

    private Integer diseaseCodeDataFlag;

    private Integer identificationDataFlag;

    private Integer contactDataFlag;

    private Integer patientNoDataFlag;

    private Integer diagnosisDataFlag;

    private Integer diseaseTypeDataFlag;

    private Date dataFlagUpdateTime;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private String auditRemark;

    private Integer outPatientFlag;
    
    private Integer inhospitalState;

    private String clinicNo;

    private Integer patientType;

    private String patientNo;

    private String medicareCardNo;

    private Integer medicalCareAreaId;

    private String medicalCarePlace;

    private String famZipCode;

    private Integer isInHospitalDeath;

    private String sourceDiseaseTypeName;

    private String sourceDiseaseTypeName2;

    private Integer icdDiseaseTypeId2;

    private Integer sourceTumorFlag2;

    private Integer diagnosisType2;

    private String diagnosisId2;

    private String inhospitalId;

    private String inhospitalId2;

    private Integer confirmedAge2;

    private String sourcePathologyDiagnosis2;

    private String sourcePathologyDiseaseCode2;

    private String secondaryDiagnosis;

    private String secondaryDiseaseCode;

    private String secondaryPathologyDiagnosis;

    private String secondaryPathologyDiseaseCode;

    private String attendingDoctorUuid;

    private String inchargeDoctorUuid;

    private Date rawCreateTime;

    private Integer icdDiseaseTypeId;

    private Integer sourceTumorFlag;

    private Integer diagnosisType;

    private String diagnosisId;

    private Integer confirmedAge;

    private Integer lostFollowupCauseResultValue;

    private Date lostFollowupTime;

    private Integer infoState;

    private Integer mergeFlag;
    
    private String mergeFromUuid;
    
    private String mergeTargetUuid;

    private Integer codePerson;

    private String codePersonName;

    private Integer age;

    private String patientCode;

    private String inpatientNo;

    private String underlyCausesOfDeath;

    private String sourceDiseaseTypeName3;

    private Integer oldFollowupFlag;

    private String oldLostFollowupCause;

    private Integer oldLostFollowupCauseResultValue;

    private Integer handleFlag;

    private Date lastAttendingDate;

    private Integer cancelLostFollowupFlag;

    private Date cancelLostFollowupTime;

    private Integer specialDiseaseRegisterId;

    private Integer stafferType;

    private Integer otherHospital;

    private String serialNo;

    private Date mergeTime;

    public Date getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Date mergeTime) {
        this.mergeTime = mergeTime;
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

    public Integer getSpecialDiseaseRegisterId() {
        return specialDiseaseRegisterId;
    }

    public void setSpecialDiseaseRegisterId(Integer specialDiseaseRegisterId) {
        this.specialDiseaseRegisterId = specialDiseaseRegisterId;
    }

    public Integer getStafferType() {
        return stafferType;
    }

    public void setStafferType(Integer stafferType) {
        this.stafferType = stafferType;
    }

    public Integer getOtherHospital() {
        return otherHospital;
    }

    public void setOtherHospital(Integer otherHospital) {
        this.otherHospital = otherHospital;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public Date getLastAttendingDate() {
        return lastAttendingDate;
    }

    public void setLastAttendingDate(Date lastAttendingDate) {
        this.lastAttendingDate = lastAttendingDate;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    private Date oldLostFollowupTime;

    public Date getOldLostFollowupTime() {
        return oldLostFollowupTime;
    }

    public void setOldLostFollowupTime(Date oldLostFollowupTime) {
        this.oldLostFollowupTime = oldLostFollowupTime;
    }

    public Integer getOldLostFollowupCauseResultValue() {
        return oldLostFollowupCauseResultValue;
    }

    public void setOldLostFollowupCauseResultValue(Integer oldLostFollowupCauseResultValue) {
        this.oldLostFollowupCauseResultValue = oldLostFollowupCauseResultValue;
    }

    public String getOldLostFollowupCause() {
        return oldLostFollowupCause;
    }

    public void setOldLostFollowupCause(String oldLostFollowupCause) {
        this.oldLostFollowupCause = oldLostFollowupCause;
    }

    public Integer getOldFollowupFlag() {
        return oldFollowupFlag;
    }

    public void setOldFollowupFlag(Integer oldFollowupFlag) {
        this.oldFollowupFlag = oldFollowupFlag;
    }

    public String getSourceDiseaseTypeName3() {
        return sourceDiseaseTypeName3;
    }

    public void setSourceDiseaseTypeName3(String sourceDiseaseTypeName3) {
        this.sourceDiseaseTypeName3 = sourceDiseaseTypeName3;
    }

    public String getUnderlyCausesOfDeath() {
        return underlyCausesOfDeath;
    }

    public void setUnderlyCausesOfDeath(String underlyCausesOfDeath) {
        this.underlyCausesOfDeath = underlyCausesOfDeath;
    }

    public String getInpatientNo() {
        return inpatientNo;
    }

    public void setInpatientNo(String inpatientNo) {
        this.inpatientNo = inpatientNo;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public Long getPatientId() {
        return patientId;
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName == null ? null : trueName.trim();
    }

    public String getPreTrueName() {
        return preTrueName;
    }

    public void setPreTrueName(String preTrueName) {
        this.preTrueName = preTrueName == null ? null : preTrueName.trim();
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
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
        this.userPictureUrl = userPictureUrl == null ? null : userPictureUrl.trim();
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
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone == null ? null : familyPhone.trim();
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
        this.causeOfDeath = causeOfDeath == null ? null : causeOfDeath.trim();
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
        this.bloodType = bloodType == null ? null : bloodType.trim();
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

    public Integer getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(Integer bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getDisabilityStatus() {
        return disabilityStatus;
    }

    public void setDisabilityStatus(String disabilityStatus) {
        this.disabilityStatus = disabilityStatus == null ? null : disabilityStatus.trim();
    }

    public String getGeneticDiseaseHistory() {
        return geneticDiseaseHistory;
    }

    public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
        this.geneticDiseaseHistory = geneticDiseaseHistory == null ? null : geneticDiseaseHistory.trim();
    }

    public String getDrugAllergyHistory() {
        return drugAllergyHistory;
    }

    public void setDrugAllergyHistory(String drugAllergyHistory) {
        this.drugAllergyHistory = drugAllergyHistory == null ? null : drugAllergyHistory.trim();
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
        this.sourceDiagnosis = sourceDiagnosis == null ? null : sourceDiagnosis.trim();
    }

    public String getSourceDiseaseCode() {
        return sourceDiseaseCode;
    }

    public void setSourceDiseaseCode(String sourceDiseaseCode) {
        this.sourceDiseaseCode = sourceDiseaseCode == null ? null : sourceDiseaseCode.trim();
    }

    public Integer getSourceDiseaseTypeId() {
        return sourceDiseaseTypeId;
    }

    public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
        this.sourceDiseaseTypeId = sourceDiseaseTypeId;
    }

    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public String getSourceDiagnosis2() {
        return sourceDiagnosis2;
    }

    public void setSourceDiagnosis2(String sourceDiagnosis2) {
        this.sourceDiagnosis2 = sourceDiagnosis2 == null ? null : sourceDiagnosis2.trim();
    }

    public String getSourceDiseaseCode2() {
        return sourceDiseaseCode2;
    }

    public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
        this.sourceDiseaseCode2 = sourceDiseaseCode2 == null ? null : sourceDiseaseCode2.trim();
    }

    public Integer getSourceDiseaseTypeId2() {
        return sourceDiseaseTypeId2;
    }

    public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
        this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
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
        this.sourceDiagnosis3 = sourceDiagnosis3 == null ? null : sourceDiagnosis3.trim();
    }

    public String getSourceDiseaseCode3() {
        return sourceDiseaseCode3;
    }

    public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
        this.sourceDiseaseCode3 = sourceDiseaseCode3 == null ? null : sourceDiseaseCode3.trim();
    }

    public Integer getSourceDiseaseTypeId3() {
        return sourceDiseaseTypeId3;
    }

    public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
        this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
    }

    public Date getConfirmedDate3() {
        return confirmedDate3;
    }

    public void setConfirmedDate3(Date confirmedDate3) {
        this.confirmedDate3 = confirmedDate3;
    }

    public String getSourcePathologyDiagnosis() {
        return sourcePathologyDiagnosis;
    }

    public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
        this.sourcePathologyDiagnosis = sourcePathologyDiagnosis == null ? null : sourcePathologyDiagnosis.trim();
    }

    public String getSourcePathologyDiseaseCode() {
        return sourcePathologyDiseaseCode;
    }

    public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
        this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode == null ? null : sourcePathologyDiseaseCode.trim();
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
        this.lostFollowupCause = lostFollowupCause == null ? null : lostFollowupCause.trim();
    }

    public Integer getTrueNameDataFlag() {
        return trueNameDataFlag;
    }

    public void setTrueNameDataFlag(Integer trueNameDataFlag) {
        this.trueNameDataFlag = trueNameDataFlag;
    }

    public Integer getDiseaseCodeDataFlag() {
        return diseaseCodeDataFlag;
    }

    public void setDiseaseCodeDataFlag(Integer diseaseCodeDataFlag) {
        this.diseaseCodeDataFlag = diseaseCodeDataFlag;
    }

    public Integer getIdentificationDataFlag() {
        return identificationDataFlag;
    }

    public void setIdentificationDataFlag(Integer identificationDataFlag) {
        this.identificationDataFlag = identificationDataFlag;
    }

    public Integer getContactDataFlag() {
        return contactDataFlag;
    }

    public void setContactDataFlag(Integer contactDataFlag) {
        this.contactDataFlag = contactDataFlag;
    }

    public Integer getPatientNoDataFlag() {
        return patientNoDataFlag;
    }

    public void setPatientNoDataFlag(Integer patientNoDataFlag) {
        this.patientNoDataFlag = patientNoDataFlag;
    }

    public Integer getDiagnosisDataFlag() {
        return diagnosisDataFlag;
    }

    public void setDiagnosisDataFlag(Integer diagnosisDataFlag) {
        this.diagnosisDataFlag = diagnosisDataFlag;
    }

    public Integer getDiseaseTypeDataFlag() {
        return diseaseTypeDataFlag;
    }

    public void setDiseaseTypeDataFlag(Integer diseaseTypeDataFlag) {
        this.diseaseTypeDataFlag = diseaseTypeDataFlag;
    }

    public Date getDataFlagUpdateTime() {
        return dataFlagUpdateTime;
    }

    public void setDataFlagUpdateTime(Date dataFlagUpdateTime) {
        this.dataFlagUpdateTime = dataFlagUpdateTime;
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

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public Integer getOutPatientFlag() {
        return outPatientFlag;
    }

    public void setOutPatientFlag(Integer outPatientFlag) {
        this.outPatientFlag = outPatientFlag;
    }

    public Integer getInhospitalState() {
		return inhospitalState;
	}

	public void setInhospitalState(Integer inhospitalState) {
		this.inhospitalState = inhospitalState;
	}

	public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo == null ? null : clinicNo.trim();
    }

    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo == null ? null : patientNo.trim();
    }

    public String getMedicareCardNo() {
        return medicareCardNo;
    }

    public void setMedicareCardNo(String medicareCardNo) {
        this.medicareCardNo = medicareCardNo == null ? null : medicareCardNo.trim();
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
        this.medicalCarePlace = medicalCarePlace == null ? null : medicalCarePlace.trim();
    }

    public String getFamZipCode() {
        return famZipCode;
    }

    public void setFamZipCode(String famZipCode) {
        this.famZipCode = famZipCode == null ? null : famZipCode.trim();
    }

    public Integer getIsInHospitalDeath() {
        return isInHospitalDeath;
    }

    public void setIsInHospitalDeath(Integer isInHospitalDeath) {
        this.isInHospitalDeath = isInHospitalDeath;
    }

    public String getSourceDiseaseTypeName() {
        return sourceDiseaseTypeName;
    }

    public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
        this.sourceDiseaseTypeName = sourceDiseaseTypeName == null ? null : sourceDiseaseTypeName.trim();
    }

    public String getSourceDiseaseTypeName2() {
        return sourceDiseaseTypeName2;
    }

    public void setSourceDiseaseTypeName2(String sourceDiseaseTypeName2) {
        this.sourceDiseaseTypeName2 = sourceDiseaseTypeName2 == null ? null : sourceDiseaseTypeName2.trim();
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
        this.diagnosisId2 = diagnosisId2 == null ? null : diagnosisId2.trim();
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId == null ? null : inhospitalId.trim();
    }

    public String getInhospitalId2() {
        return inhospitalId2;
    }

    public void setInhospitalId2(String inhospitalId2) {
        this.inhospitalId2 = inhospitalId2 == null ? null : inhospitalId2.trim();
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
        this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2 == null ? null : sourcePathologyDiagnosis2.trim();
    }

    public String getSourcePathologyDiseaseCode2() {
        return sourcePathologyDiseaseCode2;
    }

    public void setSourcePathologyDiseaseCode2(String sourcePathologyDiseaseCode2) {
        this.sourcePathologyDiseaseCode2 = sourcePathologyDiseaseCode2 == null ? null : sourcePathologyDiseaseCode2.trim();
    }

    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis == null ? null : secondaryDiagnosis.trim();
    }

    public String getSecondaryDiseaseCode() {
        return secondaryDiseaseCode;
    }

    public void setSecondaryDiseaseCode(String secondaryDiseaseCode) {
        this.secondaryDiseaseCode = secondaryDiseaseCode == null ? null : secondaryDiseaseCode.trim();
    }

    public String getSecondaryPathologyDiagnosis() {
        return secondaryPathologyDiagnosis;
    }

    public void setSecondaryPathologyDiagnosis(String secondaryPathologyDiagnosis) {
        this.secondaryPathologyDiagnosis = secondaryPathologyDiagnosis == null ? null : secondaryPathologyDiagnosis.trim();
    }

    public String getSecondaryPathologyDiseaseCode() {
        return secondaryPathologyDiseaseCode;
    }

    public void setSecondaryPathologyDiseaseCode(String secondaryPathologyDiseaseCode) {
        this.secondaryPathologyDiseaseCode = secondaryPathologyDiseaseCode == null ? null : secondaryPathologyDiseaseCode.trim();
    }

    public String getAttendingDoctorUuid() {
        return attendingDoctorUuid;
    }

    public void setAttendingDoctorUuid(String attendingDoctorUuid) {
        this.attendingDoctorUuid = attendingDoctorUuid == null ? null : attendingDoctorUuid.trim();
    }

    public String getInchargeDoctorUuid() {
        return inchargeDoctorUuid;
    }

    public void setInchargeDoctorUuid(String inchargeDoctorUuid) {
        this.inchargeDoctorUuid = inchargeDoctorUuid == null ? null : inchargeDoctorUuid.trim();
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
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

    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId == null ? null : diagnosisId.trim();
    }

    public Integer getConfirmedAge() {
        return confirmedAge;
    }

    public void setConfirmedAge(Integer confirmedAge) {
        this.confirmedAge = confirmedAge;
    }

    public Integer getLostFollowupCauseResultValue() {
        return lostFollowupCauseResultValue;
    }

    public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
        this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
    }

    public Date getLostFollowupTime() {
        return lostFollowupTime;
    }

    public void setLostFollowupTime(Date lostFollowupTime) {
        this.lostFollowupTime = lostFollowupTime;
    }

    public Integer getInfoState() {
        return infoState;
    }

    public void setInfoState(Integer infoState) {
        this.infoState = infoState;
    }

    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
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
        this.codePersonName = codePersonName == null ? null : codePersonName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

	public String getMergeFromUuid() {
		return mergeFromUuid;
	}

	public void setMergeFromUuid(String mergeFromUuid) {
		this.mergeFromUuid = mergeFromUuid;
	}

	public String getMergeTargetUuid() {
		return mergeTargetUuid;
	}

	public void setMergeTargetUuid(String mergeTargetUuid) {
		this.mergeTargetUuid = mergeTargetUuid;
	}
    
}