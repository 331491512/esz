package com.esuizhen.bigdata.domain.ehr;


import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "ei_inhospital_note", schema = "ehr_db", catalog="")
//@Audited
//@AuditTable(value = "ei_inhospital_note_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EiInhospitalNote {
    private String inhospitalId;
    private String inhospitalNo;
    private String emrId;
    private String tempId;
    private Long patientId;
    private String patientUuid;
    private String patientNo;
    private Integer inhospitalTimes;
    private String oldPatientNo;
    private Integer oldInhospitalTimes;
    private Integer hospitalId;
    private Integer medicalPayType;
    private Integer flag;
    private String healthCardNo;
    private Integer inhospitalWay;
    private Integer inhospitalSource;
    private Timestamp inhospitalDate;
    private Integer inhospitalDeptId;
    private String inhospitalWard;
    private Integer inhospitalLastTime;
    private Integer turnDeptId;
    private Timestamp turnDeptDate;
    private String turnDept;
    private Timestamp outhospitalDate;
    private Integer outhospitalDeptId;
    private String outhospitalWard;
    private Integer outhoispitalWay;
    private Integer inhospitalDays;
    private String diagnose;
    private String diseaseCode;
    private Long deptDoctor;
    private String deptDoctorName;
    private Long directorDoctor;
    private String directorDoctorName;
    private Long inchargeDoctor;
    private String inchargeDoctorName;
    private Long inhospitalDoctor;
    private String inhospitalDoctorName;
    private Long attendingDoctor;
    private String attendingDoctorName;
    private Long dutyNurse;
    private String dutyNurseName;
    private Long postgraduateDoctor;
    private String postgraduateDoctorName;
    private Long internshipDoctor;
    private String internshipDoctorName;
    private Integer codePerson;
    private String codePersonName;
    private Integer medicalRecordsQuality;
    private Long qualityControlDoctor;
    private String qualityControlDoctorName;
    private Long qualityControlNurse;
    private String qualityControlNurseName;
    private Timestamp qualityControlDate;
    private String mainDiagnosis;
    private String mainDiagnosisCode;
    private Integer inhospitalCondition;
    private Integer sourceflag;
    private Integer historyCuration;
    private Integer sourceCancerNum;
    private Integer age;
    private Integer occupationId;
    private Integer idType;
    private String identification;
    private Integer marriageStatus;
    private Integer outhospitalCondition;
    private Integer reInhospitalPlan31Days;
    private String reInhospitalTarget31Days;
    private Integer preComaHour;
    private Integer preComaMinute;
    private Integer inComaHour;
    private Integer inComaMinute;
    private Integer inviabilityScore;
    private Integer outviabilityScore;
    private Integer babyAge;
    private Integer babyBornWeight;
    private Integer babyWeightInHospital;
    private Integer transfusion;
    private Integer respiratorUseTime;
    private Integer isAllergy;
    private String allergyDesc;
    private Integer autopsy;
    private Integer aboBlood;
    private Integer rhBlood;
    private Integer redBloodCell;
    private Integer platelet;
    private Integer plasma;
    private Integer wholeBlood;
    private String other;
    private String pathologyNo;
    private String poisoningReason;
    private String poisoningDiseaseCode;
    private String recHospitalName;
    private String tumourPeriodizationT;
    private String tumourPeriodizationN;
    private String tumourPeriodizationM1;
    private String tumourPeriodizationM2;
    private String tumourPeriodizationClinic;
    private String tumourPeriodization;
    private String pathologyDiagnosis;
    private String pathologyDiagnosisCode;
    private Integer nationalityId;
    private String nativePlaceCityCode;
    private String nativePlaceAddress;
    private String householdZipCode;
    private String householdCountyCode;
    private String householdAddress;
    private String companyZipCode;
    private String companyCountyCode;
    private String companyAddress;
    private String companyTel;
    private String liveZipCode;
    private String liveCountyCode;
    private String liveAddress;
    private String liveTel;
    private String familyName;
    private Integer patientRelation;
    private String familyCountyCode;
    private String familyAddress;
    private String familyTel;
    private Timestamp deathTime;
    private String deathCause;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp syncTime;
    private Integer syncflag;
    private Integer deleteFlag;
    private Integer operatorId;
    private String operatorName;
    private Integer handleFlag;
    private Integer catalogState;
    private Timestamp rawCreateTime;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;
    private String oldInhospitalId;

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
    @Column(name = "oldinhospitalid", nullable = true, length = 128)
    public String getOldInhospitalId() {
        return oldInhospitalId;
    }

    public void setOldInhospitalId(String oldInhospitalId) {
        this.oldInhospitalId = oldInhospitalId;
    }

    @Id
    @Column(name = "inhospitalId", nullable = false, length = 128)
    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId;
    }

    @Basic
    @Column(name = "inhospitalNo", nullable = true, length = 128)
    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo;
    }

    @Basic
    @Column(name = "emrId", nullable = true, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
    }

    @Basic
    @Column(name = "tempId", nullable = true, length = 255)
    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    @Basic
    @Column(name = "patientId", nullable = false)
    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    @Basic
    @Column(name = "patientUuid", nullable = true, length = 128)
    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
    }

    @Basic
    @Column(name = "patientNo", nullable = false, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
    }

    @Basic
    @Column(name = "inhospitalTimes", nullable = false)
    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    @Basic
    @Column(name = "oldPatientNo", nullable = true, length = 128)
    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo;
    }

    @Basic
    @Column(name = "oldInhospitalTimes", nullable = true)
    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    @Basic
    @Column(name = "hospitalId", nullable = false)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
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
    @Column(name = "flag", nullable = true)
    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "healthCardNo", nullable = true, length = 20)
    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo;
    }

    @Basic
    @Column(name = "inhospitalWay", nullable = true)
    public Integer getInhospitalWay() {
        return inhospitalWay;
    }

    public void setInhospitalWay(Integer inhospitalWay) {
        this.inhospitalWay = inhospitalWay;
    }

    @Basic
    @Column(name = "inhospitalSource", nullable = true)
    public Integer getInhospitalSource() {
        return inhospitalSource;
    }

    public void setInhospitalSource(Integer inhospitalSource) {
        this.inhospitalSource = inhospitalSource;
    }

    @Basic
    @Column(name = "inhospitalDate", nullable = false)
    public Timestamp getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Timestamp inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }

    @Basic
    @Column(name = "inhospitalDeptId", nullable = true)
    public Integer getInhospitalDeptId() {
        return inhospitalDeptId;
    }

    public void setInhospitalDeptId(Integer inhospitalDeptId) {
        this.inhospitalDeptId = inhospitalDeptId;
    }

    @Basic
    @Column(name = "inhospitalWard", nullable = true, length = 15)
    public String getInhospitalWard() {
        return inhospitalWard;
    }

    public void setInhospitalWard(String inhospitalWard) {
        this.inhospitalWard = inhospitalWard;
    }

    @Basic
    @Column(name = "inhospitalLastTime", nullable = true)
    public Integer getInhospitalLastTime() {
        return inhospitalLastTime;
    }

    public void setInhospitalLastTime(Integer inhospitalLastTime) {
        this.inhospitalLastTime = inhospitalLastTime;
    }

    @Basic
    @Column(name = "turnDeptId", nullable = true)
    public Integer getTurnDeptId() {
        return turnDeptId;
    }

    public void setTurnDeptId(Integer turnDeptId) {
        this.turnDeptId = turnDeptId;
    }

    @Basic
    @Column(name = "turnDeptDate", nullable = true)
    public Timestamp getTurnDeptDate() {
        return turnDeptDate;
    }

    public void setTurnDeptDate(Timestamp turnDeptDate) {
        this.turnDeptDate = turnDeptDate;
    }

    @Basic
    @Column(name = "turnDept", nullable = true, length = 32)
    public String getTurnDept() {
        return turnDept;
    }

    public void setTurnDept(String turnDept) {
        this.turnDept = turnDept;
    }

    @Basic
    @Column(name = "outhospitalDate", nullable = true)
    public Timestamp getOuthospitalDate() {
        return outhospitalDate;
    }

    public void setOuthospitalDate(Timestamp outhospitalDate) {
        this.outhospitalDate = outhospitalDate;
    }

    @Basic
    @Column(name = "outhospitalDeptId", nullable = true)
    public Integer getOuthospitalDeptId() {
        return outhospitalDeptId;
    }

    public void setOuthospitalDeptId(Integer outhospitalDeptId) {
        this.outhospitalDeptId = outhospitalDeptId;
    }

    @Basic
    @Column(name = "outhospitalWard", nullable = true, length = 15)
    public String getOuthospitalWard() {
        return outhospitalWard;
    }

    public void setOuthospitalWard(String outhospitalWard) {
        this.outhospitalWard = outhospitalWard;
    }

    @Basic
    @Column(name = "outhoispitalWay", nullable = true)
    public Integer getOuthoispitalWay() {
        return outhoispitalWay;
    }

    public void setOuthoispitalWay(Integer outhoispitalWay) {
        this.outhoispitalWay = outhoispitalWay;
    }

    @Basic
    @Column(name = "inhospitalDays", nullable = true)
    public Integer getInhospitalDays() {
        return inhospitalDays;
    }

    public void setInhospitalDays(Integer inhospitalDays) {
        this.inhospitalDays = inhospitalDays;
    }

    @Basic
    @Column(name = "diagnose", nullable = true, length = 100)
    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    @Basic
    @Column(name = "diseaseCode", nullable = true, length = 20)
    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    @Basic
    @Column(name = "deptDoctor", nullable = true)
    public Long getDeptDoctor() {
        return deptDoctor;
    }

    public void setDeptDoctor(Long deptDoctor) {
        this.deptDoctor = deptDoctor;
    }

    @Basic
    @Column(name = "deptDoctorName", nullable = true, length = 32)
    public String getDeptDoctorName() {
        return deptDoctorName;
    }

    public void setDeptDoctorName(String deptDoctorName) {
        this.deptDoctorName = deptDoctorName;
    }

    @Basic
    @Column(name = "directorDoctor", nullable = true)
    public Long getDirectorDoctor() {
        return directorDoctor;
    }

    public void setDirectorDoctor(Long directorDoctor) {
        this.directorDoctor = directorDoctor;
    }

    @Basic
    @Column(name = "directorDoctorName", nullable = true, length = 32)
    public String getDirectorDoctorName() {
        return directorDoctorName;
    }

    public void setDirectorDoctorName(String directorDoctorName) {
        this.directorDoctorName = directorDoctorName;
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
    @Column(name = "inchargeDoctorName", nullable = true, length = 32)
    public String getInchargeDoctorName() {
        return inchargeDoctorName;
    }

    public void setInchargeDoctorName(String inchargeDoctorName) {
        this.inchargeDoctorName = inchargeDoctorName;
    }

    @Basic
    @Column(name = "inhospitalDoctor", nullable = true)
    public Long getInhospitalDoctor() {
        return inhospitalDoctor;
    }

    public void setInhospitalDoctor(Long inhospitalDoctor) {
        this.inhospitalDoctor = inhospitalDoctor;
    }

    @Basic
    @Column(name = "inhospitalDoctorName", nullable = true, length = 32)
    public String getInhospitalDoctorName() {
        return inhospitalDoctorName;
    }

    public void setInhospitalDoctorName(String inhospitalDoctorName) {
        this.inhospitalDoctorName = inhospitalDoctorName;
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
    @Column(name = "attendingDoctorName", nullable = true, length = 32)
    public String getAttendingDoctorName() {
        return attendingDoctorName;
    }

    public void setAttendingDoctorName(String attendingDoctorName) {
        this.attendingDoctorName = attendingDoctorName;
    }

    @Basic
    @Column(name = "dutyNurse", nullable = true)
    public Long getDutyNurse() {
        return dutyNurse;
    }

    public void setDutyNurse(Long dutyNurse) {
        this.dutyNurse = dutyNurse;
    }

    @Basic
    @Column(name = "dutyNurseName", nullable = true, length = 32)
    public String getDutyNurseName() {
        return dutyNurseName;
    }

    public void setDutyNurseName(String dutyNurseName) {
        this.dutyNurseName = dutyNurseName;
    }

    @Basic
    @Column(name = "postgraduateDoctor", nullable = true)
    public Long getPostgraduateDoctor() {
        return postgraduateDoctor;
    }

    public void setPostgraduateDoctor(Long postgraduateDoctor) {
        this.postgraduateDoctor = postgraduateDoctor;
    }

    @Basic
    @Column(name = "postgraduateDoctorName", nullable = true, length = 32)
    public String getPostgraduateDoctorName() {
        return postgraduateDoctorName;
    }

    public void setPostgraduateDoctorName(String postgraduateDoctorName) {
        this.postgraduateDoctorName = postgraduateDoctorName;
    }

    @Basic
    @Column(name = "internshipDoctor", nullable = true)
    public Long getInternshipDoctor() {
        return internshipDoctor;
    }

    public void setInternshipDoctor(Long internshipDoctor) {
        this.internshipDoctor = internshipDoctor;
    }

    @Basic
    @Column(name = "internshipDoctorName", nullable = true, length = 32)
    public String getInternshipDoctorName() {
        return internshipDoctorName;
    }

    public void setInternshipDoctorName(String internshipDoctorName) {
        this.internshipDoctorName = internshipDoctorName;
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
    @Column(name = "medicalRecordsQuality", nullable = true)
    public Integer getMedicalRecordsQuality() {
        return medicalRecordsQuality;
    }

    public void setMedicalRecordsQuality(Integer medicalRecordsQuality) {
        this.medicalRecordsQuality = medicalRecordsQuality;
    }

    @Basic
    @Column(name = "qualityControlDoctor", nullable = true)
    public Long getQualityControlDoctor() {
        return qualityControlDoctor;
    }

    public void setQualityControlDoctor(Long qualityControlDoctor) {
        this.qualityControlDoctor = qualityControlDoctor;
    }

    @Basic
    @Column(name = "qualityControlDoctorName", nullable = true, length = 32)
    public String getQualityControlDoctorName() {
        return qualityControlDoctorName;
    }

    public void setQualityControlDoctorName(String qualityControlDoctorName) {
        this.qualityControlDoctorName = qualityControlDoctorName;
    }

    @Basic
    @Column(name = "qualityControlNurse", nullable = true)
    public Long getQualityControlNurse() {
        return qualityControlNurse;
    }

    public void setQualityControlNurse(Long qualityControlNurse) {
        this.qualityControlNurse = qualityControlNurse;
    }

    @Basic
    @Column(name = "qualityControlNurseName", nullable = true, length = 32)
    public String getQualityControlNurseName() {
        return qualityControlNurseName;
    }

    public void setQualityControlNurseName(String qualityControlNurseName) {
        this.qualityControlNurseName = qualityControlNurseName;
    }

    @Basic
    @Column(name = "qualityControlDate", nullable = true)
    public Timestamp getQualityControlDate() {
        return qualityControlDate;
    }

    public void setQualityControlDate(Timestamp qualityControlDate) {
        this.qualityControlDate = qualityControlDate;
    }

    @Basic
    @Column(name = "mainDiagnosis", nullable = true, length = 300)
    public String getMainDiagnosis() {
        return mainDiagnosis;
    }

    public void setMainDiagnosis(String mainDiagnosis) {
        this.mainDiagnosis = mainDiagnosis;
    }

    @Basic
    @Column(name = "mainDiagnosisCode", nullable = true, length = 20)
    public String getMainDiagnosisCode() {
        return mainDiagnosisCode;
    }

    public void setMainDiagnosisCode(String mainDiagnosisCode) {
        this.mainDiagnosisCode = mainDiagnosisCode;
    }

    @Basic
    @Column(name = "inhospitalCondition", nullable = true)
    public Integer getInhospitalCondition() {
        return inhospitalCondition;
    }

    public void setInhospitalCondition(Integer inhospitalCondition) {
        this.inhospitalCondition = inhospitalCondition;
    }

    @Basic
    @Column(name = "sourceflag", nullable = false)
    public Integer getSourceflag() {
        return sourceflag;
    }

    public void setSourceflag(Integer sourceflag) {
        this.sourceflag = sourceflag;
    }

    @Basic
    @Column(name = "historyCuration", nullable = true)
    public Integer getHistoryCuration() {
        return historyCuration;
    }

    public void setHistoryCuration(Integer historyCuration) {
        this.historyCuration = historyCuration;
    }

    @Basic
    @Column(name = "sourceCancerNum", nullable = true)
    public Integer getSourceCancerNum() {
        return sourceCancerNum;
    }

    public void setSourceCancerNum(Integer sourceCancerNum) {
        this.sourceCancerNum = sourceCancerNum;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "occupationId", nullable = true)
    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    @Basic
    @Column(name = "idType", nullable = true)
    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "identification", nullable = true, length = 20)
    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Basic
    @Column(name = "marriageStatus", nullable = true)
    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    @Basic
    @Column(name = "outhospitalCondition", nullable = true)
    public Integer getOuthospitalCondition() {
        return outhospitalCondition;
    }

    public void setOuthospitalCondition(Integer outhospitalCondition) {
        this.outhospitalCondition = outhospitalCondition;
    }

    @Basic
    @Column(name = "reInhospitalPlan31Days", nullable = true)
    public Integer getReInhospitalPlan31Days() {
        return reInhospitalPlan31Days;
    }

    public void setReInhospitalPlan31Days(Integer reInhospitalPlan31Days) {
        this.reInhospitalPlan31Days = reInhospitalPlan31Days;
    }

    @Basic
    @Column(name = "reInhospitalTarget31Days", nullable = true, length = 64)
    public String getReInhospitalTarget31Days() {
        return reInhospitalTarget31Days;
    }

    public void setReInhospitalTarget31Days(String reInhospitalTarget31Days) {
        this.reInhospitalTarget31Days = reInhospitalTarget31Days;
    }

    @Basic
    @Column(name = "preComaHour", nullable = true)
    public Integer getPreComaHour() {
        return preComaHour;
    }

    public void setPreComaHour(Integer preComaHour) {
        this.preComaHour = preComaHour;
    }

    @Basic
    @Column(name = "preComaMinute", nullable = true)
    public Integer getPreComaMinute() {
        return preComaMinute;
    }

    public void setPreComaMinute(Integer preComaMinute) {
        this.preComaMinute = preComaMinute;
    }

    @Basic
    @Column(name = "inComaHour", nullable = true)
    public Integer getInComaHour() {
        return inComaHour;
    }

    public void setInComaHour(Integer inComaHour) {
        this.inComaHour = inComaHour;
    }

    @Basic
    @Column(name = "inComaMinute", nullable = true)
    public Integer getInComaMinute() {
        return inComaMinute;
    }

    public void setInComaMinute(Integer inComaMinute) {
        this.inComaMinute = inComaMinute;
    }

    @Basic
    @Column(name = "inviabilityScore", nullable = true)
    public Integer getInviabilityScore() {
        return inviabilityScore;
    }

    public void setInviabilityScore(Integer inviabilityScore) {
        this.inviabilityScore = inviabilityScore;
    }

    @Basic
    @Column(name = "outviabilityScore", nullable = true)
    public Integer getOutviabilityScore() {
        return outviabilityScore;
    }

    public void setOutviabilityScore(Integer outviabilityScore) {
        this.outviabilityScore = outviabilityScore;
    }

    @Basic
    @Column(name = "babyAge", nullable = true)
    public Integer getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(Integer babyAge) {
        this.babyAge = babyAge;
    }

    @Basic
    @Column(name = "babyBornWeight", nullable = true)
    public Integer getBabyBornWeight() {
        return babyBornWeight;
    }

    public void setBabyBornWeight(Integer babyBornWeight) {
        this.babyBornWeight = babyBornWeight;
    }

    @Basic
    @Column(name = "babyWeightInHospital", nullable = true)
    public Integer getBabyWeightInHospital() {
        return babyWeightInHospital;
    }

    public void setBabyWeightInHospital(Integer babyWeightInHospital) {
        this.babyWeightInHospital = babyWeightInHospital;
    }

    @Basic
    @Column(name = "transfusion", nullable = true)
    public Integer getTransfusion() {
        return transfusion;
    }

    public void setTransfusion(Integer transfusion) {
        this.transfusion = transfusion;
    }

    @Basic
    @Column(name = "respiratorUseTime", nullable = true)
    public Integer getRespiratorUseTime() {
        return respiratorUseTime;
    }

    public void setRespiratorUseTime(Integer respiratorUseTime) {
        this.respiratorUseTime = respiratorUseTime;
    }

    @Basic
    @Column(name = "isAllergy", nullable = true)
    public Integer getIsAllergy() {
        return isAllergy;
    }

    public void setIsAllergy(Integer isAllergy) {
        this.isAllergy = isAllergy;
    }

    @Basic
    @Column(name = "allergyDesc", nullable = true, length = 5000)
    public String getAllergyDesc() {
        return allergyDesc;
    }

    public void setAllergyDesc(String allergyDesc) {
        this.allergyDesc = allergyDesc;
    }

    @Basic
    @Column(name = "autopsy", nullable = true)
    public Integer getAutopsy() {
        return autopsy;
    }

    public void setAutopsy(Integer autopsy) {
        this.autopsy = autopsy;
    }

    @Basic
    @Column(name = "aboBlood", nullable = true)
    public Integer getAboBlood() {
        return aboBlood;
    }

    public void setAboBlood(Integer aboBlood) {
        this.aboBlood = aboBlood;
    }

    @Basic
    @Column(name = "rhBlood", nullable = true)
    public Integer getRhBlood() {
        return rhBlood;
    }

    public void setRhBlood(Integer rhBlood) {
        this.rhBlood = rhBlood;
    }

    @Basic
    @Column(name = "redBloodCell", nullable = true)
    public Integer getRedBloodCell() {
        return redBloodCell;
    }

    public void setRedBloodCell(Integer redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    @Basic
    @Column(name = "platelet", nullable = true)
    public Integer getPlatelet() {
        return platelet;
    }

    public void setPlatelet(Integer platelet) {
        this.platelet = platelet;
    }

    @Basic
    @Column(name = "plasma", nullable = true)
    public Integer getPlasma() {
        return plasma;
    }

    public void setPlasma(Integer plasma) {
        this.plasma = plasma;
    }

    @Basic
    @Column(name = "wholeBlood", nullable = true)
    public Integer getWholeBlood() {
        return wholeBlood;
    }

    public void setWholeBlood(Integer wholeBlood) {
        this.wholeBlood = wholeBlood;
    }

    @Basic
    @Column(name = "other", nullable = true, length = 64)
    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Basic
    @Column(name = "pathologyNo", nullable = true, length = 64)
    public String getPathologyNo() {
        return pathologyNo;
    }

    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }

    @Basic
    @Column(name = "poisoningReason", nullable = true, length = 64)
    public String getPoisoningReason() {
        return poisoningReason;
    }

    public void setPoisoningReason(String poisoningReason) {
        this.poisoningReason = poisoningReason;
    }

    @Basic
    @Column(name = "poisoningDiseaseCode", nullable = true, length = 64)
    public String getPoisoningDiseaseCode() {
        return poisoningDiseaseCode;
    }

    public void setPoisoningDiseaseCode(String poisoningDiseaseCode) {
        this.poisoningDiseaseCode = poisoningDiseaseCode;
    }

    @Basic
    @Column(name = "recHospitalName", nullable = true, length = 64)
    public String getRecHospitalName() {
        return recHospitalName;
    }

    public void setRecHospitalName(String recHospitalName) {
        this.recHospitalName = recHospitalName;
    }

    @Basic
    @Column(name = "tumourPeriodizationT", nullable = true, length = 32)
    public String getTumourPeriodizationT() {
        return tumourPeriodizationT;
    }

    public void setTumourPeriodizationT(String tumourPeriodizationT) {
        this.tumourPeriodizationT = tumourPeriodizationT;
    }

    @Basic
    @Column(name = "tumourPeriodizationN", nullable = true, length = 32)
    public String getTumourPeriodizationN() {
        return tumourPeriodizationN;
    }

    public void setTumourPeriodizationN(String tumourPeriodizationN) {
        this.tumourPeriodizationN = tumourPeriodizationN;
    }

    @Basic
    @Column(name = "tumourPeriodizationM1", nullable = true, length = 32)
    public String getTumourPeriodizationM1() {
        return tumourPeriodizationM1;
    }

    public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
        this.tumourPeriodizationM1 = tumourPeriodizationM1;
    }

    @Basic
    @Column(name = "tumourPeriodizationM2", nullable = true, length = 32)
    public String getTumourPeriodizationM2() {
        return tumourPeriodizationM2;
    }

    public void setTumourPeriodizationM2(String tumourPeriodizationM2) {
        this.tumourPeriodizationM2 = tumourPeriodizationM2;
    }

    @Basic
    @Column(name = "tumourPeriodizationClinic", nullable = true, length = 32)
    public String getTumourPeriodizationClinic() {
        return tumourPeriodizationClinic;
    }

    public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
        this.tumourPeriodizationClinic = tumourPeriodizationClinic;
    }

    @Basic
    @Column(name = "tumourPeriodization", nullable = true, length = 128)
    public String getTumourPeriodization() {
        return tumourPeriodization;
    }

    public void setTumourPeriodization(String tumourPeriodization) {
        this.tumourPeriodization = tumourPeriodization;
    }

    @Basic
    @Column(name = "pathologyDiagnosis", nullable = true, length = 300)
    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis;
    }

    @Basic
    @Column(name = "pathologyDiagnosisCode", nullable = true, length = 20)
    public String getPathologyDiagnosisCode() {
        return pathologyDiagnosisCode;
    }

    public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
        this.pathologyDiagnosisCode = pathologyDiagnosisCode;
    }

    @Basic
    @Column(name = "nationalityId", nullable = true)
    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    @Basic
    @Column(name = "nativePlaceCityCode", nullable = true, length = 32)
    public String getNativePlaceCityCode() {
        return nativePlaceCityCode;
    }

    public void setNativePlaceCityCode(String nativePlaceCityCode) {
        this.nativePlaceCityCode = nativePlaceCityCode;
    }

    @Basic
    @Column(name = "nativePlaceAddress", nullable = true, length = 255)
    public String getNativePlaceAddress() {
        return nativePlaceAddress;
    }

    public void setNativePlaceAddress(String nativePlaceAddress) {
        this.nativePlaceAddress = nativePlaceAddress;
    }

    @Basic
    @Column(name = "householdZipCode", nullable = true, length = 32)
    public String getHouseholdZipCode() {
        return householdZipCode;
    }

    public void setHouseholdZipCode(String householdZipCode) {
        this.householdZipCode = householdZipCode;
    }

    @Basic
    @Column(name = "householdCountyCode", nullable = true, length = 32)
    public String getHouseholdCountyCode() {
        return householdCountyCode;
    }

    public void setHouseholdCountyCode(String householdCountyCode) {
        this.householdCountyCode = householdCountyCode;
    }

    @Basic
    @Column(name = "householdAddress", nullable = true, length = 255)
    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress;
    }

    @Basic
    @Column(name = "companyZipCode", nullable = true, length = 32)
    public String getCompanyZipCode() {
        return companyZipCode;
    }

    public void setCompanyZipCode(String companyZipCode) {
        this.companyZipCode = companyZipCode;
    }

    @Basic
    @Column(name = "companyCountyCode", nullable = true, length = 32)
    public String getCompanyCountyCode() {
        return companyCountyCode;
    }

    public void setCompanyCountyCode(String companyCountyCode) {
        this.companyCountyCode = companyCountyCode;
    }

    @Basic
    @Column(name = "companyAddress", nullable = true, length = 255)
    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Basic
    @Column(name = "companyTel", nullable = true, length = 128)
    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel;
    }

    @Basic
    @Column(name = "liveZipCode", nullable = true, length = 32)
    public String getLiveZipCode() {
        return liveZipCode;
    }

    public void setLiveZipCode(String liveZipCode) {
        this.liveZipCode = liveZipCode;
    }

    @Basic
    @Column(name = "liveCountyCode", nullable = true, length = 32)
    public String getLiveCountyCode() {
        return liveCountyCode;
    }

    public void setLiveCountyCode(String liveCountyCode) {
        this.liveCountyCode = liveCountyCode;
    }

    @Basic
    @Column(name = "liveAddress", nullable = true, length = 255)
    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    @Basic
    @Column(name = "liveTel", nullable = true, length = 128)
    public String getLiveTel() {
        return liveTel;
    }

    public void setLiveTel(String liveTel) {
        this.liveTel = liveTel;
    }

    @Basic
    @Column(name = "familyName", nullable = true, length = 32)
    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
    @Column(name = "familyCountyCode", nullable = true, length = 32)
    public String getFamilyCountyCode() {
        return familyCountyCode;
    }

    public void setFamilyCountyCode(String familyCountyCode) {
        this.familyCountyCode = familyCountyCode;
    }

    @Basic
    @Column(name = "familyAddress", nullable = true, length = 255)
    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress;
    }

    @Basic
    @Column(name = "familyTel", nullable = true, length = 128)
    public String getFamilyTel() {
        return familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel;
    }

    @Basic
    @Column(name = "deathTime", nullable = true)
    public Timestamp getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Timestamp deathTime) {
        this.deathTime = deathTime;
    }

    @Basic
    @Column(name = "deathCause", nullable = true, length = 128)
    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
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
    @Column(name = "syncTime", nullable = true)
    public Timestamp getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(Timestamp syncTime) {
        this.syncTime = syncTime;
    }

    @Basic
    @Column(name = "syncflag", nullable = false)
    public Integer getSyncflag() {
        return syncflag;
    }

    public void setSyncflag(Integer syncflag) {
        this.syncflag = syncflag;
    }

    @Basic
    @Column(name = "deleteFlag", nullable = true)
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Basic
    @Column(name = "operatorId", nullable = true)
    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    @Basic
    @Column(name = "operatorName", nullable = true, length = 32)
    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
    @Column(name = "catalogState", nullable = true)
    public Integer getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(Integer catalogState) {
        this.catalogState = catalogState;
    }

    @Basic
    @Column(name = "rawCreateTime", nullable = true)
    public Timestamp getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Timestamp rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EiInhospitalNote that = (EiInhospitalNote) o;

        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (inhospitalNo != null ? !inhospitalNo.equals(that.inhospitalNo) : that.inhospitalNo != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (oldPatientNo != null ? !oldPatientNo.equals(that.oldPatientNo) : that.oldPatientNo != null) return false;
        if (oldInhospitalTimes != null ? !oldInhospitalTimes.equals(that.oldInhospitalTimes) : that.oldInhospitalTimes != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (medicalPayType != null ? !medicalPayType.equals(that.medicalPayType) : that.medicalPayType != null)
            return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;
        if (healthCardNo != null ? !healthCardNo.equals(that.healthCardNo) : that.healthCardNo != null) return false;
        if (inhospitalWay != null ? !inhospitalWay.equals(that.inhospitalWay) : that.inhospitalWay != null)
            return false;
        if (inhospitalSource != null ? !inhospitalSource.equals(that.inhospitalSource) : that.inhospitalSource != null)
            return false;
        if (inhospitalDate != null ? !inhospitalDate.equals(that.inhospitalDate) : that.inhospitalDate != null)
            return false;
        if (inhospitalDeptId != null ? !inhospitalDeptId.equals(that.inhospitalDeptId) : that.inhospitalDeptId != null)
            return false;
        if (inhospitalWard != null ? !inhospitalWard.equals(that.inhospitalWard) : that.inhospitalWard != null)
            return false;
        if (inhospitalLastTime != null ? !inhospitalLastTime.equals(that.inhospitalLastTime) : that.inhospitalLastTime != null)
            return false;
        if (turnDeptId != null ? !turnDeptId.equals(that.turnDeptId) : that.turnDeptId != null) return false;
        if (turnDeptDate != null ? !turnDeptDate.equals(that.turnDeptDate) : that.turnDeptDate != null) return false;
        if (turnDept != null ? !turnDept.equals(that.turnDept) : that.turnDept != null) return false;
        if (outhospitalDate != null ? !outhospitalDate.equals(that.outhospitalDate) : that.outhospitalDate != null)
            return false;
        if (outhospitalDeptId != null ? !outhospitalDeptId.equals(that.outhospitalDeptId) : that.outhospitalDeptId != null)
            return false;
        if (outhospitalWard != null ? !outhospitalWard.equals(that.outhospitalWard) : that.outhospitalWard != null)
            return false;
        if (outhoispitalWay != null ? !outhoispitalWay.equals(that.outhoispitalWay) : that.outhoispitalWay != null)
            return false;
        if (inhospitalDays != null ? !inhospitalDays.equals(that.inhospitalDays) : that.inhospitalDays != null)
            return false;
        if (diagnose != null ? !diagnose.equals(that.diagnose) : that.diagnose != null) return false;
        if (diseaseCode != null ? !diseaseCode.equals(that.diseaseCode) : that.diseaseCode != null) return false;
        if (deptDoctor != null ? !deptDoctor.equals(that.deptDoctor) : that.deptDoctor != null) return false;
        if (deptDoctorName != null ? !deptDoctorName.equals(that.deptDoctorName) : that.deptDoctorName != null)
            return false;
        if (directorDoctor != null ? !directorDoctor.equals(that.directorDoctor) : that.directorDoctor != null)
            return false;
        if (directorDoctorName != null ? !directorDoctorName.equals(that.directorDoctorName) : that.directorDoctorName != null)
            return false;
        if (inchargeDoctor != null ? !inchargeDoctor.equals(that.inchargeDoctor) : that.inchargeDoctor != null)
            return false;
        if (inchargeDoctorName != null ? !inchargeDoctorName.equals(that.inchargeDoctorName) : that.inchargeDoctorName != null)
            return false;
        if (inhospitalDoctor != null ? !inhospitalDoctor.equals(that.inhospitalDoctor) : that.inhospitalDoctor != null)
            return false;
        if (inhospitalDoctorName != null ? !inhospitalDoctorName.equals(that.inhospitalDoctorName) : that.inhospitalDoctorName != null)
            return false;
        if (attendingDoctor != null ? !attendingDoctor.equals(that.attendingDoctor) : that.attendingDoctor != null)
            return false;
        if (attendingDoctorName != null ? !attendingDoctorName.equals(that.attendingDoctorName) : that.attendingDoctorName != null)
            return false;
        if (dutyNurse != null ? !dutyNurse.equals(that.dutyNurse) : that.dutyNurse != null) return false;
        if (dutyNurseName != null ? !dutyNurseName.equals(that.dutyNurseName) : that.dutyNurseName != null)
            return false;
        if (postgraduateDoctor != null ? !postgraduateDoctor.equals(that.postgraduateDoctor) : that.postgraduateDoctor != null)
            return false;
        if (postgraduateDoctorName != null ? !postgraduateDoctorName.equals(that.postgraduateDoctorName) : that.postgraduateDoctorName != null)
            return false;
        if (internshipDoctor != null ? !internshipDoctor.equals(that.internshipDoctor) : that.internshipDoctor != null)
            return false;
        if (internshipDoctorName != null ? !internshipDoctorName.equals(that.internshipDoctorName) : that.internshipDoctorName != null)
            return false;
        if (codePerson != null ? !codePerson.equals(that.codePerson) : that.codePerson != null) return false;
        if (codePersonName != null ? !codePersonName.equals(that.codePersonName) : that.codePersonName != null)
            return false;
        if (medicalRecordsQuality != null ? !medicalRecordsQuality.equals(that.medicalRecordsQuality) : that.medicalRecordsQuality != null)
            return false;
        if (qualityControlDoctor != null ? !qualityControlDoctor.equals(that.qualityControlDoctor) : that.qualityControlDoctor != null)
            return false;
        if (qualityControlDoctorName != null ? !qualityControlDoctorName.equals(that.qualityControlDoctorName) : that.qualityControlDoctorName != null)
            return false;
        if (qualityControlNurse != null ? !qualityControlNurse.equals(that.qualityControlNurse) : that.qualityControlNurse != null)
            return false;
        if (qualityControlNurseName != null ? !qualityControlNurseName.equals(that.qualityControlNurseName) : that.qualityControlNurseName != null)
            return false;
        if (qualityControlDate != null ? !qualityControlDate.equals(that.qualityControlDate) : that.qualityControlDate != null)
            return false;
        if (mainDiagnosis != null ? !mainDiagnosis.equals(that.mainDiagnosis) : that.mainDiagnosis != null)
            return false;
        if (mainDiagnosisCode != null ? !mainDiagnosisCode.equals(that.mainDiagnosisCode) : that.mainDiagnosisCode != null)
            return false;
        if (inhospitalCondition != null ? !inhospitalCondition.equals(that.inhospitalCondition) : that.inhospitalCondition != null)
            return false;
        if (sourceflag != null ? !sourceflag.equals(that.sourceflag) : that.sourceflag != null) return false;
        if (historyCuration != null ? !historyCuration.equals(that.historyCuration) : that.historyCuration != null)
            return false;
        if (sourceCancerNum != null ? !sourceCancerNum.equals(that.sourceCancerNum) : that.sourceCancerNum != null)
            return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (occupationId != null ? !occupationId.equals(that.occupationId) : that.occupationId != null) return false;
        if (idType != null ? !idType.equals(that.idType) : that.idType != null) return false;
        if (identification != null ? !identification.equals(that.identification) : that.identification != null)
            return false;
        if (marriageStatus != null ? !marriageStatus.equals(that.marriageStatus) : that.marriageStatus != null)
            return false;
        if (outhospitalCondition != null ? !outhospitalCondition.equals(that.outhospitalCondition) : that.outhospitalCondition != null)
            return false;
        if (reInhospitalPlan31Days != null ? !reInhospitalPlan31Days.equals(that.reInhospitalPlan31Days) : that.reInhospitalPlan31Days != null)
            return false;
        if (reInhospitalTarget31Days != null ? !reInhospitalTarget31Days.equals(that.reInhospitalTarget31Days) : that.reInhospitalTarget31Days != null)
            return false;
        if (preComaHour != null ? !preComaHour.equals(that.preComaHour) : that.preComaHour != null) return false;
        if (preComaMinute != null ? !preComaMinute.equals(that.preComaMinute) : that.preComaMinute != null)
            return false;
        if (inComaHour != null ? !inComaHour.equals(that.inComaHour) : that.inComaHour != null) return false;
        if (inComaMinute != null ? !inComaMinute.equals(that.inComaMinute) : that.inComaMinute != null) return false;
        if (inviabilityScore != null ? !inviabilityScore.equals(that.inviabilityScore) : that.inviabilityScore != null)
            return false;
        if (outviabilityScore != null ? !outviabilityScore.equals(that.outviabilityScore) : that.outviabilityScore != null)
            return false;
        if (babyAge != null ? !babyAge.equals(that.babyAge) : that.babyAge != null) return false;
        if (babyBornWeight != null ? !babyBornWeight.equals(that.babyBornWeight) : that.babyBornWeight != null)
            return false;
        if (babyWeightInHospital != null ? !babyWeightInHospital.equals(that.babyWeightInHospital) : that.babyWeightInHospital != null)
            return false;
        if (transfusion != null ? !transfusion.equals(that.transfusion) : that.transfusion != null) return false;
        if (respiratorUseTime != null ? !respiratorUseTime.equals(that.respiratorUseTime) : that.respiratorUseTime != null)
            return false;
        if (isAllergy != null ? !isAllergy.equals(that.isAllergy) : that.isAllergy != null) return false;
        if (allergyDesc != null ? !allergyDesc.equals(that.allergyDesc) : that.allergyDesc != null) return false;
        if (autopsy != null ? !autopsy.equals(that.autopsy) : that.autopsy != null) return false;
        if (aboBlood != null ? !aboBlood.equals(that.aboBlood) : that.aboBlood != null) return false;
        if (rhBlood != null ? !rhBlood.equals(that.rhBlood) : that.rhBlood != null) return false;
        if (redBloodCell != null ? !redBloodCell.equals(that.redBloodCell) : that.redBloodCell != null) return false;
        if (platelet != null ? !platelet.equals(that.platelet) : that.platelet != null) return false;
        if (plasma != null ? !plasma.equals(that.plasma) : that.plasma != null) return false;
        if (wholeBlood != null ? !wholeBlood.equals(that.wholeBlood) : that.wholeBlood != null) return false;
        if (other != null ? !other.equals(that.other) : that.other != null) return false;
        if (pathologyNo != null ? !pathologyNo.equals(that.pathologyNo) : that.pathologyNo != null) return false;
        if (poisoningReason != null ? !poisoningReason.equals(that.poisoningReason) : that.poisoningReason != null)
            return false;
        if (poisoningDiseaseCode != null ? !poisoningDiseaseCode.equals(that.poisoningDiseaseCode) : that.poisoningDiseaseCode != null)
            return false;
        if (recHospitalName != null ? !recHospitalName.equals(that.recHospitalName) : that.recHospitalName != null)
            return false;
        if (tumourPeriodizationT != null ? !tumourPeriodizationT.equals(that.tumourPeriodizationT) : that.tumourPeriodizationT != null)
            return false;
        if (tumourPeriodizationN != null ? !tumourPeriodizationN.equals(that.tumourPeriodizationN) : that.tumourPeriodizationN != null)
            return false;
        if (tumourPeriodizationM1 != null ? !tumourPeriodizationM1.equals(that.tumourPeriodizationM1) : that.tumourPeriodizationM1 != null)
            return false;
        if (tumourPeriodizationM2 != null ? !tumourPeriodizationM2.equals(that.tumourPeriodizationM2) : that.tumourPeriodizationM2 != null)
            return false;
        if (tumourPeriodizationClinic != null ? !tumourPeriodizationClinic.equals(that.tumourPeriodizationClinic) : that.tumourPeriodizationClinic != null)
            return false;
        if (tumourPeriodization != null ? !tumourPeriodization.equals(that.tumourPeriodization) : that.tumourPeriodization != null)
            return false;
        if (pathologyDiagnosis != null ? !pathologyDiagnosis.equals(that.pathologyDiagnosis) : that.pathologyDiagnosis != null)
            return false;
        if (pathologyDiagnosisCode != null ? !pathologyDiagnosisCode.equals(that.pathologyDiagnosisCode) : that.pathologyDiagnosisCode != null)
            return false;
        if (nationalityId != null ? !nationalityId.equals(that.nationalityId) : that.nationalityId != null)
            return false;
        if (nativePlaceCityCode != null ? !nativePlaceCityCode.equals(that.nativePlaceCityCode) : that.nativePlaceCityCode != null)
            return false;
        if (nativePlaceAddress != null ? !nativePlaceAddress.equals(that.nativePlaceAddress) : that.nativePlaceAddress != null)
            return false;
        if (householdZipCode != null ? !householdZipCode.equals(that.householdZipCode) : that.householdZipCode != null)
            return false;
        if (householdCountyCode != null ? !householdCountyCode.equals(that.householdCountyCode) : that.householdCountyCode != null)
            return false;
        if (householdAddress != null ? !householdAddress.equals(that.householdAddress) : that.householdAddress != null)
            return false;
        if (companyZipCode != null ? !companyZipCode.equals(that.companyZipCode) : that.companyZipCode != null)
            return false;
        if (companyCountyCode != null ? !companyCountyCode.equals(that.companyCountyCode) : that.companyCountyCode != null)
            return false;
        if (companyAddress != null ? !companyAddress.equals(that.companyAddress) : that.companyAddress != null)
            return false;
        if (companyTel != null ? !companyTel.equals(that.companyTel) : that.companyTel != null) return false;
        if (liveZipCode != null ? !liveZipCode.equals(that.liveZipCode) : that.liveZipCode != null) return false;
        if (liveCountyCode != null ? !liveCountyCode.equals(that.liveCountyCode) : that.liveCountyCode != null)
            return false;
        if (liveAddress != null ? !liveAddress.equals(that.liveAddress) : that.liveAddress != null) return false;
        if (liveTel != null ? !liveTel.equals(that.liveTel) : that.liveTel != null) return false;
        if (familyName != null ? !familyName.equals(that.familyName) : that.familyName != null) return false;
        if (patientRelation != null ? !patientRelation.equals(that.patientRelation) : that.patientRelation != null)
            return false;
        if (familyCountyCode != null ? !familyCountyCode.equals(that.familyCountyCode) : that.familyCountyCode != null)
            return false;
        if (familyAddress != null ? !familyAddress.equals(that.familyAddress) : that.familyAddress != null)
            return false;
        if (familyTel != null ? !familyTel.equals(that.familyTel) : that.familyTel != null) return false;
        if (deathTime != null ? !deathTime.equals(that.deathTime) : that.deathTime != null) return false;
        if (deathCause != null ? !deathCause.equals(that.deathCause) : that.deathCause != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (syncflag != null ? !syncflag.equals(that.syncflag) : that.syncflag != null) return false;
        if (deleteFlag != null ? !deleteFlag.equals(that.deleteFlag) : that.deleteFlag != null) return false;
        if (operatorId != null ? !operatorId.equals(that.operatorId) : that.operatorId != null) return false;
        if (operatorName != null ? !operatorName.equals(that.operatorName) : that.operatorName != null) return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (catalogState != null ? !catalogState.equals(that.catalogState) : that.catalogState != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = inhospitalId != null ? inhospitalId.hashCode() : 0;
        result = 31 * result + (inhospitalNo != null ? inhospitalNo.hashCode() : 0);
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (oldPatientNo != null ? oldPatientNo.hashCode() : 0);
        result = 31 * result + (oldInhospitalTimes != null ? oldInhospitalTimes.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (medicalPayType != null ? medicalPayType.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        result = 31 * result + (healthCardNo != null ? healthCardNo.hashCode() : 0);
        result = 31 * result + (inhospitalWay != null ? inhospitalWay.hashCode() : 0);
        result = 31 * result + (inhospitalSource != null ? inhospitalSource.hashCode() : 0);
        result = 31 * result + (inhospitalDate != null ? inhospitalDate.hashCode() : 0);
        result = 31 * result + (inhospitalDeptId != null ? inhospitalDeptId.hashCode() : 0);
        result = 31 * result + (inhospitalWard != null ? inhospitalWard.hashCode() : 0);
        result = 31 * result + (inhospitalLastTime != null ? inhospitalLastTime.hashCode() : 0);
        result = 31 * result + (turnDeptId != null ? turnDeptId.hashCode() : 0);
        result = 31 * result + (turnDeptDate != null ? turnDeptDate.hashCode() : 0);
        result = 31 * result + (turnDept != null ? turnDept.hashCode() : 0);
        result = 31 * result + (outhospitalDate != null ? outhospitalDate.hashCode() : 0);
        result = 31 * result + (outhospitalDeptId != null ? outhospitalDeptId.hashCode() : 0);
        result = 31 * result + (outhospitalWard != null ? outhospitalWard.hashCode() : 0);
        result = 31 * result + (outhoispitalWay != null ? outhoispitalWay.hashCode() : 0);
        result = 31 * result + (inhospitalDays != null ? inhospitalDays.hashCode() : 0);
        result = 31 * result + (diagnose != null ? diagnose.hashCode() : 0);
        result = 31 * result + (diseaseCode != null ? diseaseCode.hashCode() : 0);
        result = 31 * result + (deptDoctor != null ? deptDoctor.hashCode() : 0);
        result = 31 * result + (deptDoctorName != null ? deptDoctorName.hashCode() : 0);
        result = 31 * result + (directorDoctor != null ? directorDoctor.hashCode() : 0);
        result = 31 * result + (directorDoctorName != null ? directorDoctorName.hashCode() : 0);
        result = 31 * result + (inchargeDoctor != null ? inchargeDoctor.hashCode() : 0);
        result = 31 * result + (inchargeDoctorName != null ? inchargeDoctorName.hashCode() : 0);
        result = 31 * result + (inhospitalDoctor != null ? inhospitalDoctor.hashCode() : 0);
        result = 31 * result + (inhospitalDoctorName != null ? inhospitalDoctorName.hashCode() : 0);
        result = 31 * result + (attendingDoctor != null ? attendingDoctor.hashCode() : 0);
        result = 31 * result + (attendingDoctorName != null ? attendingDoctorName.hashCode() : 0);
        result = 31 * result + (dutyNurse != null ? dutyNurse.hashCode() : 0);
        result = 31 * result + (dutyNurseName != null ? dutyNurseName.hashCode() : 0);
        result = 31 * result + (postgraduateDoctor != null ? postgraduateDoctor.hashCode() : 0);
        result = 31 * result + (postgraduateDoctorName != null ? postgraduateDoctorName.hashCode() : 0);
        result = 31 * result + (internshipDoctor != null ? internshipDoctor.hashCode() : 0);
        result = 31 * result + (internshipDoctorName != null ? internshipDoctorName.hashCode() : 0);
        result = 31 * result + (codePerson != null ? codePerson.hashCode() : 0);
        result = 31 * result + (codePersonName != null ? codePersonName.hashCode() : 0);
        result = 31 * result + (medicalRecordsQuality != null ? medicalRecordsQuality.hashCode() : 0);
        result = 31 * result + (qualityControlDoctor != null ? qualityControlDoctor.hashCode() : 0);
        result = 31 * result + (qualityControlDoctorName != null ? qualityControlDoctorName.hashCode() : 0);
        result = 31 * result + (qualityControlNurse != null ? qualityControlNurse.hashCode() : 0);
        result = 31 * result + (qualityControlNurseName != null ? qualityControlNurseName.hashCode() : 0);
        result = 31 * result + (qualityControlDate != null ? qualityControlDate.hashCode() : 0);
        result = 31 * result + (mainDiagnosis != null ? mainDiagnosis.hashCode() : 0);
        result = 31 * result + (mainDiagnosisCode != null ? mainDiagnosisCode.hashCode() : 0);
        result = 31 * result + (inhospitalCondition != null ? inhospitalCondition.hashCode() : 0);
        result = 31 * result + (sourceflag != null ? sourceflag.hashCode() : 0);
        result = 31 * result + (historyCuration != null ? historyCuration.hashCode() : 0);
        result = 31 * result + (sourceCancerNum != null ? sourceCancerNum.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (occupationId != null ? occupationId.hashCode() : 0);
        result = 31 * result + (idType != null ? idType.hashCode() : 0);
        result = 31 * result + (identification != null ? identification.hashCode() : 0);
        result = 31 * result + (marriageStatus != null ? marriageStatus.hashCode() : 0);
        result = 31 * result + (outhospitalCondition != null ? outhospitalCondition.hashCode() : 0);
        result = 31 * result + (reInhospitalPlan31Days != null ? reInhospitalPlan31Days.hashCode() : 0);
        result = 31 * result + (reInhospitalTarget31Days != null ? reInhospitalTarget31Days.hashCode() : 0);
        result = 31 * result + (preComaHour != null ? preComaHour.hashCode() : 0);
        result = 31 * result + (preComaMinute != null ? preComaMinute.hashCode() : 0);
        result = 31 * result + (inComaHour != null ? inComaHour.hashCode() : 0);
        result = 31 * result + (inComaMinute != null ? inComaMinute.hashCode() : 0);
        result = 31 * result + (inviabilityScore != null ? inviabilityScore.hashCode() : 0);
        result = 31 * result + (outviabilityScore != null ? outviabilityScore.hashCode() : 0);
        result = 31 * result + (babyAge != null ? babyAge.hashCode() : 0);
        result = 31 * result + (babyBornWeight != null ? babyBornWeight.hashCode() : 0);
        result = 31 * result + (babyWeightInHospital != null ? babyWeightInHospital.hashCode() : 0);
        result = 31 * result + (transfusion != null ? transfusion.hashCode() : 0);
        result = 31 * result + (respiratorUseTime != null ? respiratorUseTime.hashCode() : 0);
        result = 31 * result + (isAllergy != null ? isAllergy.hashCode() : 0);
        result = 31 * result + (allergyDesc != null ? allergyDesc.hashCode() : 0);
        result = 31 * result + (autopsy != null ? autopsy.hashCode() : 0);
        result = 31 * result + (aboBlood != null ? aboBlood.hashCode() : 0);
        result = 31 * result + (rhBlood != null ? rhBlood.hashCode() : 0);
        result = 31 * result + (redBloodCell != null ? redBloodCell.hashCode() : 0);
        result = 31 * result + (platelet != null ? platelet.hashCode() : 0);
        result = 31 * result + (plasma != null ? plasma.hashCode() : 0);
        result = 31 * result + (wholeBlood != null ? wholeBlood.hashCode() : 0);
        result = 31 * result + (other != null ? other.hashCode() : 0);
        result = 31 * result + (pathologyNo != null ? pathologyNo.hashCode() : 0);
        result = 31 * result + (poisoningReason != null ? poisoningReason.hashCode() : 0);
        result = 31 * result + (poisoningDiseaseCode != null ? poisoningDiseaseCode.hashCode() : 0);
        result = 31 * result + (recHospitalName != null ? recHospitalName.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationT != null ? tumourPeriodizationT.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationN != null ? tumourPeriodizationN.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationM1 != null ? tumourPeriodizationM1.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationM2 != null ? tumourPeriodizationM2.hashCode() : 0);
        result = 31 * result + (tumourPeriodizationClinic != null ? tumourPeriodizationClinic.hashCode() : 0);
        result = 31 * result + (tumourPeriodization != null ? tumourPeriodization.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosis != null ? pathologyDiagnosis.hashCode() : 0);
        result = 31 * result + (pathologyDiagnosisCode != null ? pathologyDiagnosisCode.hashCode() : 0);
        result = 31 * result + (nationalityId != null ? nationalityId.hashCode() : 0);
        result = 31 * result + (nativePlaceCityCode != null ? nativePlaceCityCode.hashCode() : 0);
        result = 31 * result + (nativePlaceAddress != null ? nativePlaceAddress.hashCode() : 0);
        result = 31 * result + (householdZipCode != null ? householdZipCode.hashCode() : 0);
        result = 31 * result + (householdCountyCode != null ? householdCountyCode.hashCode() : 0);
        result = 31 * result + (householdAddress != null ? householdAddress.hashCode() : 0);
        result = 31 * result + (companyZipCode != null ? companyZipCode.hashCode() : 0);
        result = 31 * result + (companyCountyCode != null ? companyCountyCode.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (companyTel != null ? companyTel.hashCode() : 0);
        result = 31 * result + (liveZipCode != null ? liveZipCode.hashCode() : 0);
        result = 31 * result + (liveCountyCode != null ? liveCountyCode.hashCode() : 0);
        result = 31 * result + (liveAddress != null ? liveAddress.hashCode() : 0);
        result = 31 * result + (liveTel != null ? liveTel.hashCode() : 0);
        result = 31 * result + (familyName != null ? familyName.hashCode() : 0);
        result = 31 * result + (patientRelation != null ? patientRelation.hashCode() : 0);
        result = 31 * result + (familyCountyCode != null ? familyCountyCode.hashCode() : 0);
        result = 31 * result + (familyAddress != null ? familyAddress.hashCode() : 0);
        result = 31 * result + (familyTel != null ? familyTel.hashCode() : 0);
        result = 31 * result + (deathTime != null ? deathTime.hashCode() : 0);
        result = 31 * result + (deathCause != null ? deathCause.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (syncflag != null ? syncflag.hashCode() : 0);
        result = 31 * result + (deleteFlag != null ? deleteFlag.hashCode() : 0);
        result = 31 * result + (operatorId != null ? operatorId.hashCode() : 0);
        result = 31 * result + (operatorName != null ? operatorName.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (catalogState != null ? catalogState.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
}
