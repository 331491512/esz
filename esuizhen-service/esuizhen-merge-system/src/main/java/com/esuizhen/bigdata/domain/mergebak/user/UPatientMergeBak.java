package com.esuizhen.bigdata.domain.mergebak.user;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/24.
 */
@Entity
@Table(name = "u_patient_merge_bak", schema = "user_db", catalog = "")
public class UPatientMergeBak {
    private long patientId;
    private String patientNo;
    private Integer tempId;
    private long userId;
    private String uuid;
    private Integer syncFlag;
    private String mobile;
    private String trueName;
    private String preTrueName;
    private int auditState;
    private String auditRemark;
    private String nickName;
    private int hasVisibleMedicalRecord;
    private Integer sex;
    private Date birthDate;
    private String userPictureUrl;
    private Integer patientRelation;
    private String familyName;
    private String familyPhone;
    private int liveStatus;
    private Date deathDate;
    private String causeOfDeath;
    private Integer isInHospitalDeath;
    private Integer isTumourDeath;
    private String bloodType;
    private Integer bloodTypeRh;
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
    private Timestamp confirmedDate2;
    private Timestamp confirmedDate3;
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
    private Long inchargeDoctor;
    private int followupFlag;
    private String lostFollowupCause;
    private Integer lostFollowupCauseResultValue;
    private Timestamp lostFollowupTime;
    private Integer oldFollowupFlag;
    private String oldLostFollowupCause;
    private Integer oldLostFollowupCauseResultValue;
    private Timestamp oldLostFollowupTime;
    private Integer trueNameDataFlag;
    private Integer diseaseCodeDataFlag;
    private Integer identificationDataFlag;
    private Integer contactDataFlag;
    private Integer patientNoDataFlag;
    private Integer diagnosisDataFlag;
    private Integer diseaseTypeDataFlag;
    private Timestamp dataFlagUpdateTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer codePerson;
    private String codePersonName;
    private Integer handleFlag;
    private Integer outPatientFlag;
    private Integer patientType;
    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;
    private String clinicNo;
    private String medicareCardNo;
    private Integer medicalCareAreaId;
    private String medicalCarePlace;
    private String famZipCode;
    private Timestamp rawCreateTime;
    private Timestamp lastAttendingDate;

    /*private Long id;

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    @Id
    //@Basic
    @Column(name = "patientId", nullable = false)
    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patientNo", nullable = true, length = 64)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "tempId", nullable = true)
    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "uuid", nullable = true, length = 45)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Basic
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "trueName", nullable = true, length = 50)
    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    @Basic
    @Column(name = "preTrueName", nullable = true, length = 50)
    public String getPreTrueName() {
        return preTrueName;
    }

    public void setPreTrueName(String preTrueName) {
        this.preTrueName = preTrueName;
    }

    @Basic
    @Column(name = "auditState", nullable = false)
    public int getAuditState() {
        return auditState;
    }

    public void setAuditState(int auditState) {
        this.auditState = auditState;
    }

    @Basic
    @Column(name = "auditRemark", nullable = true, length = 255)
    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark;
    }

    @Basic
    @Column(name = "nickName", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "hasVisibleMedicalRecord", nullable = false)
    public int getHasVisibleMedicalRecord() {
        return hasVisibleMedicalRecord;
    }

    public void setHasVisibleMedicalRecord(int hasVisibleMedicalRecord) {
        this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
    }

    @Basic
    @Column(name = "sex", nullable = true)
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthDate", nullable = true)
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Basic
    @Column(name = "userPictureUrl", nullable = true, length = 256)
    public String getUserPictureUrl() {
        return userPictureUrl;
    }

    public void setUserPictureUrl(String userPictureUrl) {
        this.userPictureUrl = userPictureUrl;
    }

    @Basic
    @Column(name = "patientRelation", nullable = true)
    public Integer getPatientRelation() {
        return patientRelation;
    }

    public void setPatientRelation(Integer patientRelation) {
        this.patientRelation = patientRelation;
    }

    @Basic
    @Column(name = "familyName", nullable = true, length = 100)
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    @Basic
    @Column(name = "familyPhone", nullable = true, length = 100)
    public String getFamilyPhone() {
        return familyPhone;
    }

    public void setFamilyPhone(String familyPhone) {
        this.familyPhone = familyPhone;
    }

    @Basic
    @Column(name = "liveStatus", nullable = false)
    public int getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(int liveStatus) {
        this.liveStatus = liveStatus;
    }

    @Basic
    @Column(name = "deathDate", nullable = true)
    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    @Basic
    @Column(name = "causeOfDeath", nullable = true, length = 50)
    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    @Basic
    @Column(name = "isInHospitalDeath", nullable = true)
    public Integer getIsInHospitalDeath() {
        return isInHospitalDeath;
    }

    public void setIsInHospitalDeath(Integer isInHospitalDeath) {
        this.isInHospitalDeath = isInHospitalDeath;
    }

    @Basic
    @Column(name = "isTumourDeath", nullable = true)
    public Integer getIsTumourDeath() {
        return isTumourDeath;
    }

    public void setIsTumourDeath(Integer isTumourDeath) {
        this.isTumourDeath = isTumourDeath;
    }

    @Basic
    @Column(name = "bloodType", nullable = true, length = 10)
    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    @Basic
    @Column(name = "bloodTypeRH", nullable = true)
    public Integer getBloodTypeRh() {
        return bloodTypeRh;
    }

    public void setBloodTypeRh(Integer bloodTypeRh) {
        this.bloodTypeRh = bloodTypeRh;
    }

    @Basic
    @Column(name = "bodyHeight", nullable = true)
    public Integer getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(Integer bodyHeight) {
        this.bodyHeight = bodyHeight;
    }

    @Basic
    @Column(name = "disabilityStatus", nullable = true, length = 50)
    public String getDisabilityStatus() {
        return disabilityStatus;
    }

    public void setDisabilityStatus(String disabilityStatus) {
        this.disabilityStatus = disabilityStatus;
    }

    @Basic
    @Column(name = "geneticDiseaseHistory", nullable = true, length = 255)
    public String getGeneticDiseaseHistory() {
        return geneticDiseaseHistory;
    }

    public void setGeneticDiseaseHistory(String geneticDiseaseHistory) {
        this.geneticDiseaseHistory = geneticDiseaseHistory;
    }

    @Basic
    @Column(name = "drugAllergyHistory", nullable = true, length = 255)
    public String getDrugAllergyHistory() {
        return drugAllergyHistory;
    }

    public void setDrugAllergyHistory(String drugAllergyHistory) {
        this.drugAllergyHistory = drugAllergyHistory;
    }

    @Basic
    @Column(name = "medicalPayType", nullable = true)
    public Integer getMedicalPayType() {
        return medicalPayType;
    }

    public void setMedicalPayType(Integer medicalPayType) {
        this.medicalPayType = medicalPayType;
    }

    @Basic
    @Column(name = "sourceDiagnosis", nullable = true, length = 500)
    public String getSourceDiagnosis() {
        return sourceDiagnosis;
    }

    public void setSourceDiagnosis(String sourceDiagnosis) {
        this.sourceDiagnosis = sourceDiagnosis;
    }

    @Basic
    @Column(name = "sourceDiagnosis2", nullable = true, length = 500)
    public String getSourceDiagnosis2() {
        return sourceDiagnosis2;
    }

    public void setSourceDiagnosis2(String sourceDiagnosis2) {
        this.sourceDiagnosis2 = sourceDiagnosis2;
    }

    @Basic
    @Column(name = "sourceDiagnosis3", nullable = true, length = 500)
    public String getSourceDiagnosis3() {
        return sourceDiagnosis3;
    }

    public void setSourceDiagnosis3(String sourceDiagnosis3) {
        this.sourceDiagnosis3 = sourceDiagnosis3;
    }

    @Basic
    @Column(name = "sourceDiseaseCode", nullable = true, length = 20)
    public String getSourceDiseaseCode() {
        return sourceDiseaseCode;
    }

    public void setSourceDiseaseCode(String sourceDiseaseCode) {
        this.sourceDiseaseCode = sourceDiseaseCode;
    }

    @Basic
    @Column(name = "sourceDiseaseCode2", nullable = true, length = 20)
    public String getSourceDiseaseCode2() {
        return sourceDiseaseCode2;
    }

    public void setSourceDiseaseCode2(String sourceDiseaseCode2) {
        this.sourceDiseaseCode2 = sourceDiseaseCode2;
    }

    @Basic
    @Column(name = "sourceDiseaseCode3", nullable = true, length = 20)
    public String getSourceDiseaseCode3() {
        return sourceDiseaseCode3;
    }

    public void setSourceDiseaseCode3(String sourceDiseaseCode3) {
        this.sourceDiseaseCode3 = sourceDiseaseCode3;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeId", nullable = true)
    public Integer getSourceDiseaseTypeId() {
        return sourceDiseaseTypeId;
    }

    public void setSourceDiseaseTypeId(Integer sourceDiseaseTypeId) {
        this.sourceDiseaseTypeId = sourceDiseaseTypeId;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeId2", nullable = true)
    public Integer getSourceDiseaseTypeId2() {
        return sourceDiseaseTypeId2;
    }

    public void setSourceDiseaseTypeId2(Integer sourceDiseaseTypeId2) {
        this.sourceDiseaseTypeId2 = sourceDiseaseTypeId2;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeId3", nullable = true)
    public Integer getSourceDiseaseTypeId3() {
        return sourceDiseaseTypeId3;
    }

    public void setSourceDiseaseTypeId3(Integer sourceDiseaseTypeId3) {
        this.sourceDiseaseTypeId3 = sourceDiseaseTypeId3;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeName", nullable = true, length = 255)
    public String getSourceDiseaseTypeName() {
        return sourceDiseaseTypeName;
    }

    public void setSourceDiseaseTypeName(String sourceDiseaseTypeName) {
        this.sourceDiseaseTypeName = sourceDiseaseTypeName;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeName2", nullable = true, length = 255)
    public String getSourceDiseaseTypeName2() {
        return sourceDiseaseTypeName2;
    }

    public void setSourceDiseaseTypeName2(String sourceDiseaseTypeName2) {
        this.sourceDiseaseTypeName2 = sourceDiseaseTypeName2;
    }

    @Basic
    @Column(name = "sourceDiseaseTypeName3", nullable = true, length = 255)
    public String getSourceDiseaseTypeName3() {
        return sourceDiseaseTypeName3;
    }

    public void setSourceDiseaseTypeName3(String sourceDiseaseTypeName3) {
        this.sourceDiseaseTypeName3 = sourceDiseaseTypeName3;
    }

    @Basic
    @Column(name = "icdDiseaseTypeId", nullable = true)
    public Integer getIcdDiseaseTypeId() {
        return icdDiseaseTypeId;
    }

    public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
        this.icdDiseaseTypeId = icdDiseaseTypeId;
    }

    @Basic
    @Column(name = "icdDiseaseTypeId2", nullable = true)
    public Integer getIcdDiseaseTypeId2() {
        return icdDiseaseTypeId2;
    }

    public void setIcdDiseaseTypeId2(Integer icdDiseaseTypeId2) {
        this.icdDiseaseTypeId2 = icdDiseaseTypeId2;
    }

    @Basic
    @Column(name = "diagnosisType", nullable = true)
    public Integer getDiagnosisType() {
        return diagnosisType;
    }

    public void setDiagnosisType(Integer diagnosisType) {
        this.diagnosisType = diagnosisType;
    }

    @Basic
    @Column(name = "diagnosisType2", nullable = true)
    public Integer getDiagnosisType2() {
        return diagnosisType2;
    }

    public void setDiagnosisType2(Integer diagnosisType2) {
        this.diagnosisType2 = diagnosisType2;
    }

    @Basic
    @Column(name = "sourceTumorFlag", nullable = true)
    public Integer getSourceTumorFlag() {
        return sourceTumorFlag;
    }

    public void setSourceTumorFlag(Integer sourceTumorFlag) {
        this.sourceTumorFlag = sourceTumorFlag;
    }

    @Basic
    @Column(name = "sourceTumorFlag2", nullable = true)
    public Integer getSourceTumorFlag2() {
        return sourceTumorFlag2;
    }

    public void setSourceTumorFlag2(Integer sourceTumorFlag2) {
        this.sourceTumorFlag2 = sourceTumorFlag2;
    }

    @Basic
    @Column(name = "confirmedDate", nullable = true)
    public Date getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(Date confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    @Basic
    @Column(name = "confirmedDate2", nullable = true)
    public Timestamp getConfirmedDate2() {
        return confirmedDate2;
    }

    public void setConfirmedDate2(Timestamp confirmedDate2) {
        this.confirmedDate2 = confirmedDate2;
    }

    @Basic
    @Column(name = "confirmedDate3", nullable = true)
    public Timestamp getConfirmedDate3() {
        return confirmedDate3;
    }

    public void setConfirmedDate3(Timestamp confirmedDate3) {
        this.confirmedDate3 = confirmedDate3;
    }

    @Basic
    @Column(name = "confirmedAge", nullable = true)
    public Integer getConfirmedAge() {
        return confirmedAge;
    }

    public void setConfirmedAge(Integer confirmedAge) {
        this.confirmedAge = confirmedAge;
    }

    @Basic
    @Column(name = "confirmedAge2", nullable = true)
    public Integer getConfirmedAge2() {
        return confirmedAge2;
    }

    public void setConfirmedAge2(Integer confirmedAge2) {
        this.confirmedAge2 = confirmedAge2;
    }

    @Basic
    @Column(name = "diagnosisId", nullable = true, length = 128)
    public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    @Basic
    @Column(name = "diagnosisId2", nullable = true, length = 255)
    public String getDiagnosisId2() {
        return diagnosisId2;
    }

    public void setDiagnosisId2(String diagnosisId2) {
        this.diagnosisId2 = diagnosisId2;
    }

    @Basic
    @Column(name = "inhospitalId", nullable = true, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "inhospitalId2", nullable = true, length = 128)
    public String getInhospitalId2() {
        return inhospitalId2;
    }

    public void setInhospitalId2(String inhospitalId2) {
        this.inhospitalId2 = inhospitalId2;
    }

    @Basic
    @Column(name = "sourcePathologyDiagnosis", nullable = true, length = 500)
    public String getSourcePathologyDiagnosis() {
        return sourcePathologyDiagnosis;
    }

    public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis) {
        this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
    }

    @Basic
    @Column(name = "sourcePathologyDiagnosis2", nullable = true, length = 500)
    public String getSourcePathologyDiagnosis2() {
        return sourcePathologyDiagnosis2;
    }

    public void setSourcePathologyDiagnosis2(String sourcePathologyDiagnosis2) {
        this.sourcePathologyDiagnosis2 = sourcePathologyDiagnosis2;
    }

    @Basic
    @Column(name = "sourcePathologyDiseaseCode", nullable = true, length = 30)
    public String getSourcePathologyDiseaseCode() {
        return sourcePathologyDiseaseCode;
    }

    public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode) {
        this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
    }

    @Basic
    @Column(name = "sourcePathologyDiseaseCode2", nullable = true, length = 30)
    public String getSourcePathologyDiseaseCode2() {
        return sourcePathologyDiseaseCode2;
    }

    public void setSourcePathologyDiseaseCode2(String sourcePathologyDiseaseCode2) {
        this.sourcePathologyDiseaseCode2 = sourcePathologyDiseaseCode2;
    }

    @Basic
    @Column(name = "secondaryDiagnosis", nullable = true, length = 255)
    public String getSecondaryDiagnosis() {
        return secondaryDiagnosis;
    }

    public void setSecondaryDiagnosis(String secondaryDiagnosis) {
        this.secondaryDiagnosis = secondaryDiagnosis;
    }

    @Basic
    @Column(name = "secondaryDiseaseCode", nullable = true, length = 30)
    public String getSecondaryDiseaseCode() {
        return secondaryDiseaseCode;
    }

    public void setSecondaryDiseaseCode(String secondaryDiseaseCode) {
        this.secondaryDiseaseCode = secondaryDiseaseCode;
    }

    @Basic
    @Column(name = "secondaryPathologyDiagnosis", nullable = true, length = 500)
    public String getSecondaryPathologyDiagnosis() {
        return secondaryPathologyDiagnosis;
    }

    public void setSecondaryPathologyDiagnosis(String secondaryPathologyDiagnosis) {
        this.secondaryPathologyDiagnosis = secondaryPathologyDiagnosis;
    }

    @Basic
    @Column(name = "secondaryPathologyDiseaseCode", nullable = true, length = 30)
    public String getSecondaryPathologyDiseaseCode() {
        return secondaryPathologyDiseaseCode;
    }

    public void setSecondaryPathologyDiseaseCode(String secondaryPathologyDiseaseCode) {
        this.secondaryPathologyDiseaseCode = secondaryPathologyDiseaseCode;
    }

    @Basic
    @Column(name = "attendingDoctor", nullable = true)
    public Long getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(Long attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    @Basic
    @Column(name = "inchargeDoctor", nullable = true)
    public Long getInchargeDoctor() {
        return inchargeDoctor;
    }

    public void setInchargeDoctor(Long inchargeDoctor) {
        this.inchargeDoctor = inchargeDoctor;
    }

    @Basic
    @Column(name = "followupFlag", nullable = false)
    public int getFollowupFlag() {
        return followupFlag;
    }

    public void setFollowupFlag(int followupFlag) {
        this.followupFlag = followupFlag;
    }

    @Basic
    @Column(name = "lostFollowupCause", nullable = true, length = 255)
    public String getLostFollowupCause() {
        return lostFollowupCause;
    }

    public void setLostFollowupCause(String lostFollowupCause) {
        this.lostFollowupCause = lostFollowupCause;
    }

    @Basic
    @Column(name = "lostFollowupCauseResultValue", nullable = true)
    public Integer getLostFollowupCauseResultValue() {
        return lostFollowupCauseResultValue;
    }

    public void setLostFollowupCauseResultValue(Integer lostFollowupCauseResultValue) {
        this.lostFollowupCauseResultValue = lostFollowupCauseResultValue;
    }

    @Basic
    @Column(name = "lostFollowupTime", nullable = true)
    public Timestamp getLostFollowupTime() {
        return lostFollowupTime;
    }

    public void setLostFollowupTime(Timestamp lostFollowupTime) {
        this.lostFollowupTime = lostFollowupTime;
    }

    @Basic
    @Column(name = "oldFollowupFlag", nullable = true)
    public Integer getOldFollowupFlag() {
        return oldFollowupFlag;
    }

    public void setOldFollowupFlag(Integer oldFollowupFlag) {
        this.oldFollowupFlag = oldFollowupFlag;
    }

    @Basic
    @Column(name = "oldLostFollowupCause", nullable = true, length = 255)
    public String getOldLostFollowupCause() {
        return oldLostFollowupCause;
    }

    public void setOldLostFollowupCause(String oldLostFollowupCause) {
        this.oldLostFollowupCause = oldLostFollowupCause;
    }

    @Basic
    @Column(name = "oldLostFollowupCauseResultValue", nullable = true)
    public Integer getOldLostFollowupCauseResultValue() {
        return oldLostFollowupCauseResultValue;
    }

    public void setOldLostFollowupCauseResultValue(Integer oldLostFollowupCauseResultValue) {
        this.oldLostFollowupCauseResultValue = oldLostFollowupCauseResultValue;
    }

    @Basic
    @Column(name = "oldLostFollowupTime", nullable = true)
    public Timestamp getOldLostFollowupTime() {
        return oldLostFollowupTime;
    }

    public void setOldLostFollowupTime(Timestamp oldLostFollowupTime) {
        this.oldLostFollowupTime = oldLostFollowupTime;
    }

    @Basic
    @Column(name = "trueNameDataFlag", nullable = true)
    public Integer getTrueNameDataFlag() {
        return trueNameDataFlag;
    }

    public void setTrueNameDataFlag(Integer trueNameDataFlag) {
        this.trueNameDataFlag = trueNameDataFlag;
    }

    @Basic
    @Column(name = "diseaseCodeDataFlag", nullable = true)
    public Integer getDiseaseCodeDataFlag() {
        return diseaseCodeDataFlag;
    }

    public void setDiseaseCodeDataFlag(Integer diseaseCodeDataFlag) {
        this.diseaseCodeDataFlag = diseaseCodeDataFlag;
    }

    @Basic
    @Column(name = "IdentificationDataFlag", nullable = true)
    public Integer getIdentificationDataFlag() {
        return identificationDataFlag;
    }

    public void setIdentificationDataFlag(Integer identificationDataFlag) {
        this.identificationDataFlag = identificationDataFlag;
    }

    @Basic
    @Column(name = "contactDataFlag", nullable = true)
    public Integer getContactDataFlag() {
        return contactDataFlag;
    }

    public void setContactDataFlag(Integer contactDataFlag) {
        this.contactDataFlag = contactDataFlag;
    }

    @Basic
    @Column(name = "patientNoDataFlag", nullable = true)
    public Integer getPatientNoDataFlag() {
        return patientNoDataFlag;
    }

    public void setPatientNoDataFlag(Integer patientNoDataFlag) {
        this.patientNoDataFlag = patientNoDataFlag;
    }

    @Basic
    @Column(name = "diagnosisDataFlag", nullable = true)
    public Integer getDiagnosisDataFlag() {
        return diagnosisDataFlag;
    }

    public void setDiagnosisDataFlag(Integer diagnosisDataFlag) {
        this.diagnosisDataFlag = diagnosisDataFlag;
    }

    @Basic
    @Column(name = "diseaseTypeDataFlag", nullable = true)
    public Integer getDiseaseTypeDataFlag() {
        return diseaseTypeDataFlag;
    }

    public void setDiseaseTypeDataFlag(Integer diseaseTypeDataFlag) {
        this.diseaseTypeDataFlag = diseaseTypeDataFlag;
    }

    @Basic
    @Column(name = "dataFlagUpdateTime", nullable = true)
    public Timestamp getDataFlagUpdateTime() {
        return dataFlagUpdateTime;
    }

    public void setDataFlagUpdateTime(Timestamp dataFlagUpdateTime) {
        this.dataFlagUpdateTime = dataFlagUpdateTime;
    }

    @Basic
    @Column(name = "createTime", nullable = false)
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTime", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "codePerson", nullable = true)
    public Integer getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(Integer codePerson) {
        this.codePerson = codePerson;
    }

    @Basic
    @Column(name = "codePersonName", nullable = true, length = 32)
    public String getCodePersonName() {
        return codePersonName;
    }

    public void setCodePersonName(String codePersonName) {
        this.codePersonName = codePersonName;
    }

    @Basic
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    @Basic
    @Column(name = "outPatientFlag", nullable = true)
    public Integer getOutPatientFlag() {
        return outPatientFlag;
    }

    public void setOutPatientFlag(Integer outPatientFlag) {
        this.outPatientFlag = outPatientFlag;
    }

    @Basic
    @Column(name = "patientType", nullable = true)
    public Integer getPatientType() {
        return patientType;
    }

    public void setPatientType(Integer patientType) {
        this.patientType = patientType;
    }

    @Basic
    @Column(name = "mergeFlag", nullable = true)
    public Integer getMergeFlag() {
        return mergeFlag;
    }

    public void setMergeFlag(Integer mergeFlag) {
        this.mergeFlag = mergeFlag;
    }

    @Basic
    @Column(name = "mergeFrom", nullable = true)
    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    @Basic
    @Column(name = "mergeTarget", nullable = true)
    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    @Basic
    @Column(name = "mergeTime", nullable = true)
    public Timestamp getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Timestamp mergeTime) {
        this.mergeTime = mergeTime;
    }

    @Basic
    @Column(name = "clinicNo", nullable = true, length = 32)
    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo;
    }

    @Basic
    @Column(name = "medicareCardNo", nullable = true, length = 32)
    public String getMedicareCardNo() {
        return medicareCardNo;
    }

    public void setMedicareCardNo(String medicareCardNo) {
        this.medicareCardNo = medicareCardNo;
    }

    @Basic
    @Column(name = "medicalCareAreaId", nullable = true)
    public Integer getMedicalCareAreaId() {
        return medicalCareAreaId;
    }

    public void setMedicalCareAreaId(Integer medicalCareAreaId) {
        this.medicalCareAreaId = medicalCareAreaId;
    }

    @Basic
    @Column(name = "medicalCarePlace", nullable = true, length = 500)
    public String getMedicalCarePlace() {
        return medicalCarePlace;
    }

    public void setMedicalCarePlace(String medicalCarePlace) {
        this.medicalCarePlace = medicalCarePlace;
    }

    @Basic
    @Column(name = "famZipCode", nullable = true, length = 10)
    public String getFamZipCode() {
        return famZipCode;
    }

    public void setFamZipCode(String famZipCode) {
        this.famZipCode = famZipCode;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Basic
    @Column(name = "lastAttendingDate", nullable = true)
    public Timestamp getLastAttendingDate() {
        return lastAttendingDate;
    }

    public void setLastAttendingDate(Timestamp lastMaxDate) {
        this.lastAttendingDate = lastAttendingDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UPatientMergeBak that = (UPatientMergeBak) o;

        if (patientId != that.patientId) return false;
        if (userId != that.userId) return false;
        if (auditState != that.auditState) return false;
        if (hasVisibleMedicalRecord != that.hasVisibleMedicalRecord) return false;
        if (liveStatus != that.liveStatus) return false;
        if (followupFlag != that.followupFlag) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null) return false;
        if (preTrueName != null ? !preTrueName.equals(that.preTrueName) : that.preTrueName != null) return false;
        if (auditRemark != null ? !auditRemark.equals(that.auditRemark) : that.auditRemark != null) return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null) return false;
        if (userPictureUrl != null ? !userPictureUrl.equals(that.userPictureUrl) : that.userPictureUrl != null)
            return false;
        if (patientRelation != null ? !patientRelation.equals(that.patientRelation) : that.patientRelation != null)
            return false;
        if (familyName != null ? !familyName.equals(that.familyName) : that.familyName != null) return false;
        if (familyPhone != null ? !familyPhone.equals(that.familyPhone) : that.familyPhone != null) return false;
        if (deathDate != null ? !deathDate.equals(that.deathDate) : that.deathDate != null) return false;
        if (causeOfDeath != null ? !causeOfDeath.equals(that.causeOfDeath) : that.causeOfDeath != null) return false;
        if (isInHospitalDeath != null ? !isInHospitalDeath.equals(that.isInHospitalDeath) : that.isInHospitalDeath != null)
            return false;
        if (isTumourDeath != null ? !isTumourDeath.equals(that.isTumourDeath) : that.isTumourDeath != null)
            return false;
        if (bloodType != null ? !bloodType.equals(that.bloodType) : that.bloodType != null) return false;
        if (bloodTypeRh != null ? !bloodTypeRh.equals(that.bloodTypeRh) : that.bloodTypeRh != null) return false;
        if (bodyHeight != null ? !bodyHeight.equals(that.bodyHeight) : that.bodyHeight != null) return false;
        if (disabilityStatus != null ? !disabilityStatus.equals(that.disabilityStatus) : that.disabilityStatus != null)
            return false;
        if (geneticDiseaseHistory != null ? !geneticDiseaseHistory.equals(that.geneticDiseaseHistory) : that.geneticDiseaseHistory != null)
            return false;
        if (drugAllergyHistory != null ? !drugAllergyHistory.equals(that.drugAllergyHistory) : that.drugAllergyHistory != null)
            return false;
        if (medicalPayType != null ? !medicalPayType.equals(that.medicalPayType) : that.medicalPayType != null)
            return false;
        if (sourceDiagnosis != null ? !sourceDiagnosis.equals(that.sourceDiagnosis) : that.sourceDiagnosis != null)
            return false;
        if (sourceDiagnosis2 != null ? !sourceDiagnosis2.equals(that.sourceDiagnosis2) : that.sourceDiagnosis2 != null)
            return false;
        if (sourceDiagnosis3 != null ? !sourceDiagnosis3.equals(that.sourceDiagnosis3) : that.sourceDiagnosis3 != null)
            return false;
        if (sourceDiseaseCode != null ? !sourceDiseaseCode.equals(that.sourceDiseaseCode) : that.sourceDiseaseCode != null)
            return false;
        if (sourceDiseaseCode2 != null ? !sourceDiseaseCode2.equals(that.sourceDiseaseCode2) : that.sourceDiseaseCode2 != null)
            return false;
        if (sourceDiseaseCode3 != null ? !sourceDiseaseCode3.equals(that.sourceDiseaseCode3) : that.sourceDiseaseCode3 != null)
            return false;
        if (sourceDiseaseTypeId != null ? !sourceDiseaseTypeId.equals(that.sourceDiseaseTypeId) : that.sourceDiseaseTypeId != null)
            return false;
        if (sourceDiseaseTypeId2 != null ? !sourceDiseaseTypeId2.equals(that.sourceDiseaseTypeId2) : that.sourceDiseaseTypeId2 != null)
            return false;
        if (sourceDiseaseTypeId3 != null ? !sourceDiseaseTypeId3.equals(that.sourceDiseaseTypeId3) : that.sourceDiseaseTypeId3 != null)
            return false;
        if (sourceDiseaseTypeName != null ? !sourceDiseaseTypeName.equals(that.sourceDiseaseTypeName) : that.sourceDiseaseTypeName != null)
            return false;
        if (sourceDiseaseTypeName2 != null ? !sourceDiseaseTypeName2.equals(that.sourceDiseaseTypeName2) : that.sourceDiseaseTypeName2 != null)
            return false;
        if (sourceDiseaseTypeName3 != null ? !sourceDiseaseTypeName3.equals(that.sourceDiseaseTypeName3) : that.sourceDiseaseTypeName3 != null)
            return false;
        if (icdDiseaseTypeId != null ? !icdDiseaseTypeId.equals(that.icdDiseaseTypeId) : that.icdDiseaseTypeId != null)
            return false;
        if (icdDiseaseTypeId2 != null ? !icdDiseaseTypeId2.equals(that.icdDiseaseTypeId2) : that.icdDiseaseTypeId2 != null)
            return false;
        if (diagnosisType != null ? !diagnosisType.equals(that.diagnosisType) : that.diagnosisType != null)
            return false;
        if (diagnosisType2 != null ? !diagnosisType2.equals(that.diagnosisType2) : that.diagnosisType2 != null)
            return false;
        if (sourceTumorFlag != null ? !sourceTumorFlag.equals(that.sourceTumorFlag) : that.sourceTumorFlag != null)
            return false;
        if (sourceTumorFlag2 != null ? !sourceTumorFlag2.equals(that.sourceTumorFlag2) : that.sourceTumorFlag2 != null)
            return false;
        if (confirmedDate != null ? !confirmedDate.equals(that.confirmedDate) : that.confirmedDate != null)
            return false;
        if (confirmedDate2 != null ? !confirmedDate2.equals(that.confirmedDate2) : that.confirmedDate2 != null)
            return false;
        if (confirmedDate3 != null ? !confirmedDate3.equals(that.confirmedDate3) : that.confirmedDate3 != null)
            return false;
        if (confirmedAge != null ? !confirmedAge.equals(that.confirmedAge) : that.confirmedAge != null) return false;
        if (confirmedAge2 != null ? !confirmedAge2.equals(that.confirmedAge2) : that.confirmedAge2 != null)
            return false;
        if (diagnosisId != null ? !diagnosisId.equals(that.diagnosisId) : that.diagnosisId != null) return false;
        if (diagnosisId2 != null ? !diagnosisId2.equals(that.diagnosisId2) : that.diagnosisId2 != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (inhospitalId2 != null ? !inhospitalId2.equals(that.inhospitalId2) : that.inhospitalId2 != null)
            return false;
        if (sourcePathologyDiagnosis != null ? !sourcePathologyDiagnosis.equals(that.sourcePathologyDiagnosis) : that.sourcePathologyDiagnosis != null)
            return false;
        if (sourcePathologyDiagnosis2 != null ? !sourcePathologyDiagnosis2.equals(that.sourcePathologyDiagnosis2) : that.sourcePathologyDiagnosis2 != null)
            return false;
        if (sourcePathologyDiseaseCode != null ? !sourcePathologyDiseaseCode.equals(that.sourcePathologyDiseaseCode) : that.sourcePathologyDiseaseCode != null)
            return false;
        if (sourcePathologyDiseaseCode2 != null ? !sourcePathologyDiseaseCode2.equals(that.sourcePathologyDiseaseCode2) : that.sourcePathologyDiseaseCode2 != null)
            return false;
        if (secondaryDiagnosis != null ? !secondaryDiagnosis.equals(that.secondaryDiagnosis) : that.secondaryDiagnosis != null)
            return false;
        if (secondaryDiseaseCode != null ? !secondaryDiseaseCode.equals(that.secondaryDiseaseCode) : that.secondaryDiseaseCode != null)
            return false;
        if (secondaryPathologyDiagnosis != null ? !secondaryPathologyDiagnosis.equals(that.secondaryPathologyDiagnosis) : that.secondaryPathologyDiagnosis != null)
            return false;
        if (secondaryPathologyDiseaseCode != null ? !secondaryPathologyDiseaseCode.equals(that.secondaryPathologyDiseaseCode) : that.secondaryPathologyDiseaseCode != null)
            return false;
        if (attendingDoctor != null ? !attendingDoctor.equals(that.attendingDoctor) : that.attendingDoctor != null)
            return false;
        if (inchargeDoctor != null ? !inchargeDoctor.equals(that.inchargeDoctor) : that.inchargeDoctor != null)
            return false;
        if (lostFollowupCause != null ? !lostFollowupCause.equals(that.lostFollowupCause) : that.lostFollowupCause != null)
            return false;
        if (lostFollowupCauseResultValue != null ? !lostFollowupCauseResultValue.equals(that.lostFollowupCauseResultValue) : that.lostFollowupCauseResultValue != null)
            return false;
        if (lostFollowupTime != null ? !lostFollowupTime.equals(that.lostFollowupTime) : that.lostFollowupTime != null)
            return false;
        if (oldFollowupFlag != null ? !oldFollowupFlag.equals(that.oldFollowupFlag) : that.oldFollowupFlag != null)
            return false;
        if (oldLostFollowupCause != null ? !oldLostFollowupCause.equals(that.oldLostFollowupCause) : that.oldLostFollowupCause != null)
            return false;
        if (oldLostFollowupCauseResultValue != null ? !oldLostFollowupCauseResultValue.equals(that.oldLostFollowupCauseResultValue) : that.oldLostFollowupCauseResultValue != null)
            return false;
        if (oldLostFollowupTime != null ? !oldLostFollowupTime.equals(that.oldLostFollowupTime) : that.oldLostFollowupTime != null)
            return false;
        if (trueNameDataFlag != null ? !trueNameDataFlag.equals(that.trueNameDataFlag) : that.trueNameDataFlag != null)
            return false;
        if (diseaseCodeDataFlag != null ? !diseaseCodeDataFlag.equals(that.diseaseCodeDataFlag) : that.diseaseCodeDataFlag != null)
            return false;
        if (identificationDataFlag != null ? !identificationDataFlag.equals(that.identificationDataFlag) : that.identificationDataFlag != null)
            return false;
        if (contactDataFlag != null ? !contactDataFlag.equals(that.contactDataFlag) : that.contactDataFlag != null)
            return false;
        if (patientNoDataFlag != null ? !patientNoDataFlag.equals(that.patientNoDataFlag) : that.patientNoDataFlag != null)
            return false;
        if (diagnosisDataFlag != null ? !diagnosisDataFlag.equals(that.diagnosisDataFlag) : that.diagnosisDataFlag != null)
            return false;
        if (diseaseTypeDataFlag != null ? !diseaseTypeDataFlag.equals(that.diseaseTypeDataFlag) : that.diseaseTypeDataFlag != null)
            return false;
        if (dataFlagUpdateTime != null ? !dataFlagUpdateTime.equals(that.dataFlagUpdateTime) : that.dataFlagUpdateTime != null)
            return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (codePerson != null ? !codePerson.equals(that.codePerson) : that.codePerson != null) return false;
        if (codePersonName != null ? !codePersonName.equals(that.codePersonName) : that.codePersonName != null)
            return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (outPatientFlag != null ? !outPatientFlag.equals(that.outPatientFlag) : that.outPatientFlag != null)
            return false;
        if (patientType != null ? !patientType.equals(that.patientType) : that.patientType != null) return false;
        if (mergeFlag != null ? !mergeFlag.equals(that.mergeFlag) : that.mergeFlag != null) return false;
        if (mergeFrom != null ? !mergeFrom.equals(that.mergeFrom) : that.mergeFrom != null) return false;
        if (mergeTarget != null ? !mergeTarget.equals(that.mergeTarget) : that.mergeTarget != null) return false;
        if (mergeTime != null ? !mergeTime.equals(that.mergeTime) : that.mergeTime != null) return false;
        if (clinicNo != null ? !clinicNo.equals(that.clinicNo) : that.clinicNo != null) return false;
        if (medicareCardNo != null ? !medicareCardNo.equals(that.medicareCardNo) : that.medicareCardNo != null)
            return false;
        if (medicalCareAreaId != null ? !medicalCareAreaId.equals(that.medicalCareAreaId) : that.medicalCareAreaId != null)
            return false;
        if (medicalCarePlace != null ? !medicalCarePlace.equals(that.medicalCarePlace) : that.medicalCarePlace != null)
            return false;
        if (famZipCode != null ? !famZipCode.equals(that.famZipCode) : that.famZipCode != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;
        if (lastAttendingDate != null ? !lastAttendingDate.equals(that.lastAttendingDate) : that.lastAttendingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (patientId ^ (patientId >>> 32));
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (preTrueName != null ? preTrueName.hashCode() : 0);
        result = 31 * result + auditState;
        result = 31 * result + (auditRemark != null ? auditRemark.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + hasVisibleMedicalRecord;
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (userPictureUrl != null ? userPictureUrl.hashCode() : 0);
        result = 31 * result + (patientRelation != null ? patientRelation.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (familyPhone != null ? familyPhone.hashCode() : 0);
        result = 31 * result + liveStatus;
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (causeOfDeath != null ? causeOfDeath.hashCode() : 0);
        result = 31 * result + (isInHospitalDeath != null ? isInHospitalDeath.hashCode() : 0);
        result = 31 * result + (isTumourDeath != null ? isTumourDeath.hashCode() : 0);
        result = 31 * result + (bloodType != null ? bloodType.hashCode() : 0);
        result = 31 * result + (bloodTypeRh != null ? bloodTypeRh.hashCode() : 0);
        result = 31 * result + (bodyHeight != null ? bodyHeight.hashCode() : 0);
        result = 31 * result + (disabilityStatus != null ? disabilityStatus.hashCode() : 0);
        result = 31 * result + (geneticDiseaseHistory != null ? geneticDiseaseHistory.hashCode() : 0);
        result = 31 * result + (drugAllergyHistory != null ? drugAllergyHistory.hashCode() : 0);
        result = 31 * result + (medicalPayType != null ? medicalPayType.hashCode() : 0);
        result = 31 * result + (sourceDiagnosis != null ? sourceDiagnosis.hashCode() : 0);
        result = 31 * result + (sourceDiagnosis2 != null ? sourceDiagnosis2.hashCode() : 0);
        result = 31 * result + (sourceDiagnosis3 != null ? sourceDiagnosis3.hashCode() : 0);
        result = 31 * result + (sourceDiseaseCode != null ? sourceDiseaseCode.hashCode() : 0);
        result = 31 * result + (sourceDiseaseCode2 != null ? sourceDiseaseCode2.hashCode() : 0);
        result = 31 * result + (sourceDiseaseCode3 != null ? sourceDiseaseCode3.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeId != null ? sourceDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeId2 != null ? sourceDiseaseTypeId2.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeId3 != null ? sourceDiseaseTypeId3.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeName != null ? sourceDiseaseTypeName.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeName2 != null ? sourceDiseaseTypeName2.hashCode() : 0);
        result = 31 * result + (sourceDiseaseTypeName3 != null ? sourceDiseaseTypeName3.hashCode() : 0);
        result = 31 * result + (icdDiseaseTypeId != null ? icdDiseaseTypeId.hashCode() : 0);
        result = 31 * result + (icdDiseaseTypeId2 != null ? icdDiseaseTypeId2.hashCode() : 0);
        result = 31 * result + (diagnosisType != null ? diagnosisType.hashCode() : 0);
        result = 31 * result + (diagnosisType2 != null ? diagnosisType2.hashCode() : 0);
        result = 31 * result + (sourceTumorFlag != null ? sourceTumorFlag.hashCode() : 0);
        result = 31 * result + (sourceTumorFlag2 != null ? sourceTumorFlag2.hashCode() : 0);
        result = 31 * result + (confirmedDate != null ? confirmedDate.hashCode() : 0);
        result = 31 * result + (confirmedDate2 != null ? confirmedDate2.hashCode() : 0);
        result = 31 * result + (confirmedDate3 != null ? confirmedDate3.hashCode() : 0);
        result = 31 * result + (confirmedAge != null ? confirmedAge.hashCode() : 0);
        result = 31 * result + (confirmedAge2 != null ? confirmedAge2.hashCode() : 0);
        result = 31 * result + (diagnosisId != null ? diagnosisId.hashCode() : 0);
        result = 31 * result + (diagnosisId2 != null ? diagnosisId2.hashCode() : 0);
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (inhospitalId2 != null ? inhospitalId2.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiagnosis != null ? sourcePathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiagnosis2 != null ? sourcePathologyDiagnosis2.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiseaseCode != null ? sourcePathologyDiseaseCode.hashCode() : 0);
        result = 31 * result + (sourcePathologyDiseaseCode2 != null ? sourcePathologyDiseaseCode2.hashCode() : 0);
        result = 31 * result + (secondaryDiagnosis != null ? secondaryDiagnosis.hashCode() : 0);
        result = 31 * result + (secondaryDiseaseCode != null ? secondaryDiseaseCode.hashCode() : 0);
        result = 31 * result + (secondaryPathologyDiagnosis != null ? secondaryPathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (secondaryPathologyDiseaseCode != null ? secondaryPathologyDiseaseCode.hashCode() : 0);
        result = 31 * result + (attendingDoctor != null ? attendingDoctor.hashCode() : 0);
        result = 31 * result + (inchargeDoctor != null ? inchargeDoctor.hashCode() : 0);
        result = 31 * result + followupFlag;
        result = 31 * result + (lostFollowupCause != null ? lostFollowupCause.hashCode() : 0);
        result = 31 * result + (lostFollowupCauseResultValue != null ? lostFollowupCauseResultValue.hashCode() : 0);
        result = 31 * result + (lostFollowupTime != null ? lostFollowupTime.hashCode() : 0);
        result = 31 * result + (oldFollowupFlag != null ? oldFollowupFlag.hashCode() : 0);
        result = 31 * result + (oldLostFollowupCause != null ? oldLostFollowupCause.hashCode() : 0);
        result = 31 * result + (oldLostFollowupCauseResultValue != null ? oldLostFollowupCauseResultValue.hashCode() : 0);
        result = 31 * result + (oldLostFollowupTime != null ? oldLostFollowupTime.hashCode() : 0);
        result = 31 * result + (trueNameDataFlag != null ? trueNameDataFlag.hashCode() : 0);
        result = 31 * result + (diseaseCodeDataFlag != null ? diseaseCodeDataFlag.hashCode() : 0);
        result = 31 * result + (identificationDataFlag != null ? identificationDataFlag.hashCode() : 0);
        result = 31 * result + (contactDataFlag != null ? contactDataFlag.hashCode() : 0);
        result = 31 * result + (patientNoDataFlag != null ? patientNoDataFlag.hashCode() : 0);
        result = 31 * result + (diagnosisDataFlag != null ? diagnosisDataFlag.hashCode() : 0);
        result = 31 * result + (diseaseTypeDataFlag != null ? diseaseTypeDataFlag.hashCode() : 0);
        result = 31 * result + (dataFlagUpdateTime != null ? dataFlagUpdateTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (codePerson != null ? codePerson.hashCode() : 0);
        result = 31 * result + (codePersonName != null ? codePersonName.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (outPatientFlag != null ? outPatientFlag.hashCode() : 0);
        result = 31 * result + (patientType != null ? patientType.hashCode() : 0);
        result = 31 * result + (mergeFlag != null ? mergeFlag.hashCode() : 0);
        result = 31 * result + (mergeFrom != null ? mergeFrom.hashCode() : 0);
        result = 31 * result + (mergeTarget != null ? mergeTarget.hashCode() : 0);
        result = 31 * result + (mergeTime != null ? mergeTime.hashCode() : 0);
        result = 31 * result + (clinicNo != null ? clinicNo.hashCode() : 0);
        result = 31 * result + (medicareCardNo != null ? medicareCardNo.hashCode() : 0);
        result = 31 * result + (medicalCareAreaId != null ? medicalCareAreaId.hashCode() : 0);
        result = 31 * result + (medicalCarePlace != null ? medicalCarePlace.hashCode() : 0);
        result = 31 * result + (famZipCode != null ? famZipCode.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        result = 31 * result + (lastAttendingDate != null ? lastAttendingDate.hashCode() : 0);
        return result;
    }
}
