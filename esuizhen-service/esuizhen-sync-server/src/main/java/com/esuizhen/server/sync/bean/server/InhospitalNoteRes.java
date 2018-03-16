package com.esuizhen.server.sync.bean.server;

import java.util.Date;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class InhospitalNoteRes {

    private String inhospitalId;

    private String inhospitalNo;

    private String emrId;

    private Long patientId;

    private String patientNo;

    private Integer inhospitalTimes;

    private String oldPatientNo;

    private Integer oldInhospitalTimes;

    private String patientUuid;

    private Integer hospitalId;

    private Integer medicalPayType;

    private String healthCardNo;

    private Integer inhospitalWay;

    private Date inhospitalDate;

    private Integer inhospitalDeptId;

    private String inhospitalWard;

    private Integer turnDeptId;

    private Date turnDeptDate;

    private Date outhospitalDate;

    private Integer outhospitalDeptId;

    private String outhospitalWard;

    private Integer outhoispitalWay;

    private Integer inhospitalDays;

    private String diagnose;

    private String diseaseCode;

    private Integer deptDoctor;

    private Integer directorDoctor;

    private Integer inchargeDoctor;

    private Integer inhospitalDoctor;

    private Integer attendingDoctor;

    private Integer dutyNurse;

    private Integer postgraduateDoctor;

    private Integer internshipDoctor;

    private Integer codePerson;

    private Integer medicalRecordsQuality;

    private Integer qualityControlDoctor;

    private Integer qualityControlNurse;

    private Date qualityControlDate;

    private String mainDiagnosis;

    private String mainDiagnosisCode;

    private Integer inhospitalCondition;

    private Integer syncflag;

    private Integer sourceFlag;

    private Integer historyCuration;

    private Integer sourceCancerNum;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private String tumourPeriodizationT;

    private String tumourPeriodizationN;

    private String tumourPeriodizationM1;

    private String tumourPeriodizationM2;

    private String tumourPeriodizationClinic;

    private String tumourPeriodization;

    private Integer catalogState;

    private String inhospitalDeptUuid;

    private String turnDeptUuid;

    private String outhospitalDeptUuid;

    private String deptDoctorUuid;

    private String directorDoctorUuid;

    private String inchargeDoctorUuid;

    private String inhospitalDoctorUuid;

    private String attendingDoctorUuid;

    private String dutyNurseUuid;

    private String postgraduateDoctorUuid;

    private String internshipDoctorUuid;

    private String codePersonUuid;

    private String qualityControlDoctorUuid;

    private String qualityControlNurseUuid;

    private Integer flag;

    private Integer treatmentSource;

    private Integer inhospitalLastTime;

    private String turnDept;

    private String deptDoctorName;

    private String directorDoctorName;

    private String inchargeDoctorName;

    private String inhospitalDoctorName;

    private String attendingDoctorName;

    private String dutyNurseName;

    private String postgraduateDoctorName;

    private String internshipDoctorName;

    private String codePersonName;

    private String qualityControlDoctorName;

    private String qualityControlNurseName;

    private Integer age;

    private Integer occupationId;

    private Integer idType;

    private String identification;

    private Integer marriageStatus;

    private Integer outhospitalCondition;

    private Integer autopsy;

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

    private Integer aboBlood;

    private Integer rhBlood;

    private String pathologyDiagnosis;

    private String pathologyDiagnosisCode;

    private Integer nationalityId;

    private String nativePlaceCityCode;

    private String nativePlaceAddress;

    private String householdZipCode;

    private String householdAddress;

    private String companyZipCode;

    private String companyCountyCode;

    private String companyAddress;

    private String companyTel;

    private String liveZipCode;

    private String liveCountyCode;

    private String liveTel;

    private String familyName;

    private Integer patientRelation;

    private String familyAddress;

    private String familyTel;

    private String familyCountyCode;

    private Date rawCreateTime;

    private Integer infoState;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private String oldinhospitalid;

    //同步
    private Long matchTarget;

    private String matchTargetUuid;

    private Long matchFrom;

    private String matchFromUuid;

    private Integer matchFlag;

    private Integer recordId;

    private String batchId;

    private String uuid;

    private Integer opFlag;

    private Integer upFlag;//upFlag用于标识云端是否已经存在

    private Integer cpFlag;//cpFlag标识是否存在电子病历主表

    private Date deathTime;
    private String deathCause;
    private Integer deleteFlag;
    private Long operatorId;
    private String operatorName;
    private Integer handleFlag;
    private String mergeFromUuid;
    private String mergeTargetUuid;
    private String inpatientNo;
    private Integer inhospitalSource;
    private Integer redBloodCell;
    private Integer platelet;
    private Integer plasma;
    private Integer wholeBlood;
    private String other;
    private String pathologyNo;
    private String poisoningReason;
    private String poisoningDiseaseCode;
    private String recHospitalName;
    private String householdCountyCode;
    private String liveAddress;
    private Integer tempId;
    private Integer dataSource;

    public Date getDeathTime() {
        return deathTime;
    }

    public void setDeathTime(Date deathTime) {
        this.deathTime = deathTime;
    }

    public String getDeathCause() {
        return deathCause;
    }

    public void setDeathCause(String deathCause) {
        this.deathCause = deathCause;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
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

    public String getInpatientNo() {
        return inpatientNo;
    }

    public void setInpatientNo(String inpatientNo) {
        this.inpatientNo = inpatientNo;
    }

    public Integer getInhospitalSource() {
        return inhospitalSource;
    }

    public void setInhospitalSource(Integer inhospitalSource) {
        this.inhospitalSource = inhospitalSource;
    }

    public Integer getRedBloodCell() {
        return redBloodCell;
    }

    public void setRedBloodCell(Integer redBloodCell) {
        this.redBloodCell = redBloodCell;
    }

    public Integer getPlatelet() {
        return platelet;
    }

    public void setPlatelet(Integer platelet) {
        this.platelet = platelet;
    }

    public Integer getPlasma() {
        return plasma;
    }

    public void setPlasma(Integer plasma) {
        this.plasma = plasma;
    }

    public Integer getWholeBlood() {
        return wholeBlood;
    }

    public void setWholeBlood(Integer wholeBlood) {
        this.wholeBlood = wholeBlood;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPathologyNo() {
        return pathologyNo;
    }

    public void setPathologyNo(String pathologyNo) {
        this.pathologyNo = pathologyNo;
    }

    public String getPoisoningReason() {
        return poisoningReason;
    }

    public void setPoisoningReason(String poisoningReason) {
        this.poisoningReason = poisoningReason;
    }

    public String getPoisoningDiseaseCode() {
        return poisoningDiseaseCode;
    }

    public void setPoisoningDiseaseCode(String poisoningDiseaseCode) {
        this.poisoningDiseaseCode = poisoningDiseaseCode;
    }

    public String getRecHospitalName() {
        return recHospitalName;
    }

    public void setRecHospitalName(String recHospitalName) {
        this.recHospitalName = recHospitalName;
    }

    public String getHouseholdCountyCode() {
        return householdCountyCode;
    }

    public void setHouseholdCountyCode(String householdCountyCode) {
        this.householdCountyCode = householdCountyCode;
    }

    public String getLiveAddress() {
        return liveAddress;
    }

    public void setLiveAddress(String liveAddress) {
        this.liveAddress = liveAddress;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(Integer cpFlag) {
        this.cpFlag = cpFlag;
    }

    public Integer getUpFlag() {
        return upFlag;
    }

    public void setUpFlag(Integer upFlag) {
        this.upFlag = upFlag;
    }

    public Long getMatchTarget() {
        return matchTarget;
    }

    public void setMatchTarget(Long matchTarget) {
        this.matchTarget = matchTarget;
    }

    public String getMatchTargetUuid() {
        return matchTargetUuid;
    }

    public void setMatchTargetUuid(String matchTargetUuid) {
        this.matchTargetUuid = matchTargetUuid;
    }

    public Long getMatchFrom() {
        return matchFrom;
    }

    public void setMatchFrom(Long matchFrom) {
        this.matchFrom = matchFrom;
    }

    public String getMatchFromUuid() {
        return matchFromUuid;
    }

    public void setMatchFromUuid(String matchFromUuid) {
        this.matchFromUuid = matchFromUuid;
    }

    public Integer getMatchFlag() {
        return matchFlag;
    }

    public void setMatchFlag(Integer matchFlag) {
        this.matchFlag = matchFlag;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getOpFlag() {
        return opFlag;
    }

    public void setOpFlag(Integer opFlag) {
        this.opFlag = opFlag;
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId == null ? null : inhospitalId.trim();
    }

    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo == null ? null : inhospitalNo.trim();
    }

    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId == null ? null : emrId.trim();
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

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo == null ? null : patientNo.trim();
    }

    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo == null ? null : oldPatientNo.trim();
    }

    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getMedicalPayType() {
        return medicalPayType;
    }

    public void setMedicalPayType(Integer medicalPayType) {
        this.medicalPayType = medicalPayType;
    }

    public String getHealthCardNo() {
        return healthCardNo;
    }

    public void setHealthCardNo(String healthCardNo) {
        this.healthCardNo = healthCardNo == null ? null : healthCardNo.trim();
    }

    public Integer getInhospitalWay() {
        return inhospitalWay;
    }

    public void setInhospitalWay(Integer inhospitalWay) {
        this.inhospitalWay = inhospitalWay;
    }

    public Date getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Date inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }

    public Integer getInhospitalDeptId() {
        return inhospitalDeptId;
    }

    public void setInhospitalDeptId(Integer inhospitalDeptId) {
        this.inhospitalDeptId = inhospitalDeptId;
    }

    public String getInhospitalWard() {
        return inhospitalWard;
    }

    public void setInhospitalWard(String inhospitalWard) {
        this.inhospitalWard = inhospitalWard == null ? null : inhospitalWard.trim();
    }

    public Integer getTurnDeptId() {
        return turnDeptId;
    }

    public void setTurnDeptId(Integer turnDeptId) {
        this.turnDeptId = turnDeptId;
    }

    public Date getTurnDeptDate() {
        return turnDeptDate;
    }

    public void setTurnDeptDate(Date turnDeptDate) {
        this.turnDeptDate = turnDeptDate;
    }

    public Date getOuthospitalDate() {
        return outhospitalDate;
    }

    public void setOuthospitalDate(Date outhospitalDate) {
        this.outhospitalDate = outhospitalDate;
    }

    public Integer getOuthospitalDeptId() {
        return outhospitalDeptId;
    }

    public void setOuthospitalDeptId(Integer outhospitalDeptId) {
        this.outhospitalDeptId = outhospitalDeptId;
    }

    public String getOuthospitalWard() {
        return outhospitalWard;
    }

    public void setOuthospitalWard(String outhospitalWard) {
        this.outhospitalWard = outhospitalWard == null ? null : outhospitalWard.trim();
    }

    public Integer getOuthoispitalWay() {
        return outhoispitalWay;
    }

    public void setOuthoispitalWay(Integer outhoispitalWay) {
        this.outhoispitalWay = outhoispitalWay;
    }

    public Integer getInhospitalDays() {
        return inhospitalDays;
    }

    public void setInhospitalDays(Integer inhospitalDays) {
        this.inhospitalDays = inhospitalDays;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose == null ? null : diagnose.trim();
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public Integer getDeptDoctor() {
        return deptDoctor;
    }

    public void setDeptDoctor(Integer deptDoctor) {
        this.deptDoctor = deptDoctor;
    }

    public Integer getDirectorDoctor() {
        return directorDoctor;
    }

    public void setDirectorDoctor(Integer directorDoctor) {
        this.directorDoctor = directorDoctor;
    }

    public Integer getInchargeDoctor() {
        return inchargeDoctor;
    }

    public void setInchargeDoctor(Integer inchargeDoctor) {
        this.inchargeDoctor = inchargeDoctor;
    }

    public Integer getInhospitalDoctor() {
        return inhospitalDoctor;
    }

    public void setInhospitalDoctor(Integer inhospitalDoctor) {
        this.inhospitalDoctor = inhospitalDoctor;
    }

    public Integer getAttendingDoctor() {
        return attendingDoctor;
    }

    public void setAttendingDoctor(Integer attendingDoctor) {
        this.attendingDoctor = attendingDoctor;
    }

    public Integer getDutyNurse() {
        return dutyNurse;
    }

    public void setDutyNurse(Integer dutyNurse) {
        this.dutyNurse = dutyNurse;
    }

    public Integer getPostgraduateDoctor() {
        return postgraduateDoctor;
    }

    public void setPostgraduateDoctor(Integer postgraduateDoctor) {
        this.postgraduateDoctor = postgraduateDoctor;
    }

    public Integer getInternshipDoctor() {
        return internshipDoctor;
    }

    public void setInternshipDoctor(Integer internshipDoctor) {
        this.internshipDoctor = internshipDoctor;
    }

    public Integer getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(Integer codePerson) {
        this.codePerson = codePerson;
    }

    public Integer getMedicalRecordsQuality() {
        return medicalRecordsQuality;
    }

    public void setMedicalRecordsQuality(Integer medicalRecordsQuality) {
        this.medicalRecordsQuality = medicalRecordsQuality;
    }

    public Integer getQualityControlDoctor() {
        return qualityControlDoctor;
    }

    public void setQualityControlDoctor(Integer qualityControlDoctor) {
        this.qualityControlDoctor = qualityControlDoctor;
    }

    public Integer getQualityControlNurse() {
        return qualityControlNurse;
    }

    public void setQualityControlNurse(Integer qualityControlNurse) {
        this.qualityControlNurse = qualityControlNurse;
    }

    public Date getQualityControlDate() {
        return qualityControlDate;
    }

    public void setQualityControlDate(Date qualityControlDate) {
        this.qualityControlDate = qualityControlDate;
    }

    public String getMainDiagnosis() {
        return mainDiagnosis;
    }

    public void setMainDiagnosis(String mainDiagnosis) {
        this.mainDiagnosis = mainDiagnosis == null ? null : mainDiagnosis.trim();
    }

    public String getMainDiagnosisCode() {
        return mainDiagnosisCode;
    }

    public void setMainDiagnosisCode(String mainDiagnosisCode) {
        this.mainDiagnosisCode = mainDiagnosisCode == null ? null : mainDiagnosisCode.trim();
    }

    public Integer getInhospitalCondition() {
        return inhospitalCondition;
    }

    public void setInhospitalCondition(Integer inhospitalCondition) {
        this.inhospitalCondition = inhospitalCondition;
    }

    public Integer getSyncflag() {
        return syncflag;
    }

    public void setSyncflag(Integer syncflag) {
        this.syncflag = syncflag;
    }

    public Integer getSourceFlag() {
		return sourceFlag;
	}

	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}

	public Integer getHistoryCuration() {
        return historyCuration;
    }

    public void setHistoryCuration(Integer historyCuration) {
        this.historyCuration = historyCuration;
    }

    public Integer getSourceCancerNum() {
        return sourceCancerNum;
    }

    public void setSourceCancerNum(Integer sourceCancerNum) {
        this.sourceCancerNum = sourceCancerNum;
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

    public String getTumourPeriodizationT() {
        return tumourPeriodizationT;
    }

    public void setTumourPeriodizationT(String tumourPeriodizationT) {
        this.tumourPeriodizationT = tumourPeriodizationT == null ? null : tumourPeriodizationT.trim();
    }

    public String getTumourPeriodizationN() {
        return tumourPeriodizationN;
    }

    public void setTumourPeriodizationN(String tumourPeriodizationN) {
        this.tumourPeriodizationN = tumourPeriodizationN == null ? null : tumourPeriodizationN.trim();
    }

    public String getTumourPeriodizationM1() {
        return tumourPeriodizationM1;
    }

    public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
        this.tumourPeriodizationM1 = tumourPeriodizationM1 == null ? null : tumourPeriodizationM1.trim();
    }

    public String getTumourPeriodizationM2() {
        return tumourPeriodizationM2;
    }

    public void setTumourPeriodizationM2(String tumourPeriodizationM2) {
        this.tumourPeriodizationM2 = tumourPeriodizationM2 == null ? null : tumourPeriodizationM2.trim();
    }

    public String getTumourPeriodizationClinic() {
        return tumourPeriodizationClinic;
    }

    public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
        this.tumourPeriodizationClinic = tumourPeriodizationClinic == null ? null : tumourPeriodizationClinic.trim();
    }

    public String getTumourPeriodization() {
        return tumourPeriodization;
    }

    public void setTumourPeriodization(String tumourPeriodization) {
        this.tumourPeriodization = tumourPeriodization == null ? null : tumourPeriodization.trim();
    }

    public Integer getCatalogState() {
        return catalogState;
    }

    public void setCatalogState(Integer catalogState) {
        this.catalogState = catalogState;
    }

    public String getInhospitalDeptUuid() {
        return inhospitalDeptUuid;
    }

    public void setInhospitalDeptUuid(String inhospitalDeptUuid) {
        this.inhospitalDeptUuid = inhospitalDeptUuid == null ? null : inhospitalDeptUuid.trim();
    }

    public String getTurnDeptUuid() {
        return turnDeptUuid;
    }

    public void setTurnDeptUuid(String turnDeptUuid) {
        this.turnDeptUuid = turnDeptUuid == null ? null : turnDeptUuid.trim();
    }

    public String getOuthospitalDeptUuid() {
        return outhospitalDeptUuid;
    }

    public void setOuthospitalDeptUuid(String outhospitalDeptUuid) {
        this.outhospitalDeptUuid = outhospitalDeptUuid == null ? null : outhospitalDeptUuid.trim();
    }

    public String getDeptDoctorUuid() {
        return deptDoctorUuid;
    }

    public void setDeptDoctorUuid(String deptDoctorUuid) {
        this.deptDoctorUuid = deptDoctorUuid == null ? null : deptDoctorUuid.trim();
    }

    public String getDirectorDoctorUuid() {
        return directorDoctorUuid;
    }

    public void setDirectorDoctorUuid(String directorDoctorUuid) {
        this.directorDoctorUuid = directorDoctorUuid == null ? null : directorDoctorUuid.trim();
    }

    public String getInchargeDoctorUuid() {
        return inchargeDoctorUuid;
    }

    public void setInchargeDoctorUuid(String inchargeDoctorUuid) {
        this.inchargeDoctorUuid = inchargeDoctorUuid == null ? null : inchargeDoctorUuid.trim();
    }

    public String getInhospitalDoctorUuid() {
        return inhospitalDoctorUuid;
    }

    public void setInhospitalDoctorUuid(String inhospitalDoctorUuid) {
        this.inhospitalDoctorUuid = inhospitalDoctorUuid == null ? null : inhospitalDoctorUuid.trim();
    }

    public String getAttendingDoctorUuid() {
        return attendingDoctorUuid;
    }

    public void setAttendingDoctorUuid(String attendingDoctorUuid) {
        this.attendingDoctorUuid = attendingDoctorUuid == null ? null : attendingDoctorUuid.trim();
    }

    public String getDutyNurseUuid() {
        return dutyNurseUuid;
    }

    public void setDutyNurseUuid(String dutyNurseUuid) {
        this.dutyNurseUuid = dutyNurseUuid == null ? null : dutyNurseUuid.trim();
    }

    public String getPostgraduateDoctorUuid() {
        return postgraduateDoctorUuid;
    }

    public void setPostgraduateDoctorUuid(String postgraduateDoctorUuid) {
        this.postgraduateDoctorUuid = postgraduateDoctorUuid == null ? null : postgraduateDoctorUuid.trim();
    }

    public String getInternshipDoctorUuid() {
        return internshipDoctorUuid;
    }

    public void setInternshipDoctorUuid(String internshipDoctorUuid) {
        this.internshipDoctorUuid = internshipDoctorUuid == null ? null : internshipDoctorUuid.trim();
    }

    public String getCodePersonUuid() {
        return codePersonUuid;
    }

    public void setCodePersonUuid(String codePersonUuid) {
        this.codePersonUuid = codePersonUuid == null ? null : codePersonUuid.trim();
    }

    public String getQualityControlDoctorUuid() {
        return qualityControlDoctorUuid;
    }

    public void setQualityControlDoctorUuid(String qualityControlDoctorUuid) {
        this.qualityControlDoctorUuid = qualityControlDoctorUuid == null ? null : qualityControlDoctorUuid.trim();
    }

    public String getQualityControlNurseUuid() {
        return qualityControlNurseUuid;
    }

    public void setQualityControlNurseUuid(String qualityControlNurseUuid) {
        this.qualityControlNurseUuid = qualityControlNurseUuid == null ? null : qualityControlNurseUuid.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getTreatmentSource() {
        return treatmentSource;
    }

    public void setTreatmentSource(Integer treatmentSource) {
        this.treatmentSource = treatmentSource;
    }

    public Integer getInhospitalLastTime() {
        return inhospitalLastTime;
    }

    public void setInhospitalLastTime(Integer inhospitalLastTime) {
        this.inhospitalLastTime = inhospitalLastTime;
    }

    public String getTurnDept() {
        return turnDept;
    }

    public void setTurnDept(String turnDept) {
        this.turnDept = turnDept == null ? null : turnDept.trim();
    }

    public String getDeptDoctorName() {
        return deptDoctorName;
    }

    public void setDeptDoctorName(String deptDoctorName) {
        this.deptDoctorName = deptDoctorName == null ? null : deptDoctorName.trim();
    }

    public String getDirectorDoctorName() {
        return directorDoctorName;
    }

    public void setDirectorDoctorName(String directorDoctorName) {
        this.directorDoctorName = directorDoctorName == null ? null : directorDoctorName.trim();
    }

    public String getInchargeDoctorName() {
        return inchargeDoctorName;
    }

    public void setInchargeDoctorName(String inchargeDoctorName) {
        this.inchargeDoctorName = inchargeDoctorName == null ? null : inchargeDoctorName.trim();
    }

    public String getInhospitalDoctorName() {
        return inhospitalDoctorName;
    }

    public void setInhospitalDoctorName(String inhospitalDoctorName) {
        this.inhospitalDoctorName = inhospitalDoctorName == null ? null : inhospitalDoctorName.trim();
    }

    public String getAttendingDoctorName() {
        return attendingDoctorName;
    }

    public void setAttendingDoctorName(String attendingDoctorName) {
        this.attendingDoctorName = attendingDoctorName == null ? null : attendingDoctorName.trim();
    }

    public String getDutyNurseName() {
        return dutyNurseName;
    }

    public void setDutyNurseName(String dutyNurseName) {
        this.dutyNurseName = dutyNurseName == null ? null : dutyNurseName.trim();
    }

    public String getPostgraduateDoctorName() {
        return postgraduateDoctorName;
    }

    public void setPostgraduateDoctorName(String postgraduateDoctorName) {
        this.postgraduateDoctorName = postgraduateDoctorName == null ? null : postgraduateDoctorName.trim();
    }

    public String getInternshipDoctorName() {
        return internshipDoctorName;
    }

    public void setInternshipDoctorName(String internshipDoctorName) {
        this.internshipDoctorName = internshipDoctorName == null ? null : internshipDoctorName.trim();
    }

    public String getCodePersonName() {
        return codePersonName;
    }

    public void setCodePersonName(String codePersonName) {
        this.codePersonName = codePersonName == null ? null : codePersonName.trim();
    }

    public String getQualityControlDoctorName() {
        return qualityControlDoctorName;
    }

    public void setQualityControlDoctorName(String qualityControlDoctorName) {
        this.qualityControlDoctorName = qualityControlDoctorName == null ? null : qualityControlDoctorName.trim();
    }

    public String getQualityControlNurseName() {
        return qualityControlNurseName;
    }

    public void setQualityControlNurseName(String qualityControlNurseName) {
        this.qualityControlNurseName = qualityControlNurseName == null ? null : qualityControlNurseName.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getOccupationId() {
        return occupationId;
    }

    public void setOccupationId(Integer occupationId) {
        this.occupationId = occupationId;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification == null ? null : identification.trim();
    }

    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public Integer getOuthospitalCondition() {
        return outhospitalCondition;
    }

    public void setOuthospitalCondition(Integer outhospitalCondition) {
        this.outhospitalCondition = outhospitalCondition;
    }

    public Integer getAutopsy() {
        return autopsy;
    }

    public void setAutopsy(Integer autopsy) {
        this.autopsy = autopsy;
    }

    public Integer getReInhospitalPlan31Days() {
        return reInhospitalPlan31Days;
    }

    public void setReInhospitalPlan31Days(Integer reInhospitalPlan31Days) {
        this.reInhospitalPlan31Days = reInhospitalPlan31Days;
    }

    public String getReInhospitalTarget31Days() {
        return reInhospitalTarget31Days;
    }

    public void setReInhospitalTarget31Days(String reInhospitalTarget31Days) {
        this.reInhospitalTarget31Days = reInhospitalTarget31Days == null ? null : reInhospitalTarget31Days.trim();
    }

    public Integer getPreComaHour() {
        return preComaHour;
    }

    public void setPreComaHour(Integer preComaHour) {
        this.preComaHour = preComaHour;
    }

    public Integer getPreComaMinute() {
        return preComaMinute;
    }

    public void setPreComaMinute(Integer preComaMinute) {
        this.preComaMinute = preComaMinute;
    }

    public Integer getInComaHour() {
        return inComaHour;
    }

    public void setInComaHour(Integer inComaHour) {
        this.inComaHour = inComaHour;
    }

    public Integer getInComaMinute() {
        return inComaMinute;
    }

    public void setInComaMinute(Integer inComaMinute) {
        this.inComaMinute = inComaMinute;
    }

    public Integer getInviabilityScore() {
        return inviabilityScore;
    }

    public void setInviabilityScore(Integer inviabilityScore) {
        this.inviabilityScore = inviabilityScore;
    }

    public Integer getOutviabilityScore() {
        return outviabilityScore;
    }

    public void setOutviabilityScore(Integer outviabilityScore) {
        this.outviabilityScore = outviabilityScore;
    }

    public Integer getBabyAge() {
        return babyAge;
    }

    public void setBabyAge(Integer babyAge) {
        this.babyAge = babyAge;
    }

    public Integer getBabyBornWeight() {
        return babyBornWeight;
    }

    public void setBabyBornWeight(Integer babyBornWeight) {
        this.babyBornWeight = babyBornWeight;
    }

    public Integer getBabyWeightInHospital() {
        return babyWeightInHospital;
    }

    public void setBabyWeightInHospital(Integer babyWeightInHospital) {
        this.babyWeightInHospital = babyWeightInHospital;
    }

    public Integer getTransfusion() {
        return transfusion;
    }

    public void setTransfusion(Integer transfusion) {
        this.transfusion = transfusion;
    }

    public Integer getRespiratorUseTime() {
        return respiratorUseTime;
    }

    public void setRespiratorUseTime(Integer respiratorUseTime) {
        this.respiratorUseTime = respiratorUseTime;
    }

    public Integer getIsAllergy() {
        return isAllergy;
    }

    public void setIsAllergy(Integer isAllergy) {
        this.isAllergy = isAllergy;
    }

    public String getAllergyDesc() {
        return allergyDesc;
    }

    public void setAllergyDesc(String allergyDesc) {
        this.allergyDesc = allergyDesc == null ? null : allergyDesc.trim();
    }

    public Integer getAboBlood() {
        return aboBlood;
    }

    public void setAboBlood(Integer aboBlood) {
        this.aboBlood = aboBlood;
    }

    public Integer getRhBlood() {
        return rhBlood;
    }

    public void setRhBlood(Integer rhBlood) {
        this.rhBlood = rhBlood;
    }

    public String getPathologyDiagnosis() {
        return pathologyDiagnosis;
    }

    public void setPathologyDiagnosis(String pathologyDiagnosis) {
        this.pathologyDiagnosis = pathologyDiagnosis == null ? null : pathologyDiagnosis.trim();
    }

    public String getPathologyDiagnosisCode() {
        return pathologyDiagnosisCode;
    }

    public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
        this.pathologyDiagnosisCode = pathologyDiagnosisCode == null ? null : pathologyDiagnosisCode.trim();
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public String getNativePlaceCityCode() {
        return nativePlaceCityCode;
    }

    public void setNativePlaceCityCode(String nativePlaceCityCode) {
        this.nativePlaceCityCode = nativePlaceCityCode == null ? null : nativePlaceCityCode.trim();
    }

    public String getNativePlaceAddress() {
        return nativePlaceAddress;
    }

    public void setNativePlaceAddress(String nativePlaceAddress) {
        this.nativePlaceAddress = nativePlaceAddress == null ? null : nativePlaceAddress.trim();
    }

    public String getHouseholdZipCode() {
        return householdZipCode;
    }

    public void setHouseholdZipCode(String householdZipCode) {
        this.householdZipCode = householdZipCode == null ? null : householdZipCode.trim();
    }

    public String getHouseholdAddress() {
        return householdAddress;
    }

    public void setHouseholdAddress(String householdAddress) {
        this.householdAddress = householdAddress == null ? null : householdAddress.trim();
    }

    public String getCompanyZipCode() {
        return companyZipCode;
    }

    public void setCompanyZipCode(String companyZipCode) {
        this.companyZipCode = companyZipCode == null ? null : companyZipCode.trim();
    }

    public String getCompanyCountyCode() {
        return companyCountyCode;
    }

    public void setCompanyCountyCode(String companyCountyCode) {
        this.companyCountyCode = companyCountyCode == null ? null : companyCountyCode.trim();
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress == null ? null : companyAddress.trim();
    }

    public String getCompanyTel() {
        return companyTel;
    }

    public void setCompanyTel(String companyTel) {
        this.companyTel = companyTel == null ? null : companyTel.trim();
    }

    public String getLiveZipCode() {
        return liveZipCode;
    }

    public void setLiveZipCode(String liveZipCode) {
        this.liveZipCode = liveZipCode == null ? null : liveZipCode.trim();
    }

    public String getLiveCountyCode() {
        return liveCountyCode;
    }

    public void setLiveCountyCode(String liveCountyCode) {
        this.liveCountyCode = liveCountyCode == null ? null : liveCountyCode.trim();
    }

    public String getLiveTel() {
        return liveTel;
    }

    public void setLiveTel(String liveTel) {
        this.liveTel = liveTel == null ? null : liveTel.trim();
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName == null ? null : familyName.trim();
    }

    public Integer getPatientRelation() {
        return patientRelation;
    }

    public void setPatientRelation(Integer patientRelation) {
        this.patientRelation = patientRelation;
    }

    public String getFamilyAddress() {
        return familyAddress;
    }

    public void setFamilyAddress(String familyAddress) {
        this.familyAddress = familyAddress == null ? null : familyAddress.trim();
    }

    public String getFamilyTel() {
        return familyTel;
    }

    public void setFamilyTel(String familyTel) {
        this.familyTel = familyTel == null ? null : familyTel.trim();
    }

    public String getFamilyCountyCode() {
        return familyCountyCode;
    }

    public void setFamilyCountyCode(String familyCountyCode) {
        this.familyCountyCode = familyCountyCode == null ? null : familyCountyCode.trim();
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
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

    public Long getMergeFrom() {
        return mergeFrom;
    }

    public void setMergeFrom(Long mergeFrom) {
        this.mergeFrom = mergeFrom;
    }

    public Long getMergeTarget() {
        return mergeTarget;
    }

    public void setMergeTarget(Long mergeTarget) {
        this.mergeTarget = mergeTarget;
    }

    public Date getMergeTime() {
        return mergeTime;
    }

    public void setMergeTime(Date mergeTime) {
        this.mergeTime = mergeTime;
    }

    public String getOldinhospitalid() {
        return oldinhospitalid;
    }

    public void setOldinhospitalid(String oldinhospitalid) {
        this.oldinhospitalid = oldinhospitalid == null ? null : oldinhospitalid.trim();
    }

    public Integer getDataSource() {
		return dataSource;
	}

	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}

	public TBatchDataResultInfo createResultInfo(){
        TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
        resultInfo.setOpFlag(this.opFlag);
        resultInfo.setSyncTime(new Date());
        resultInfo.setResultId(this.inhospitalId);
        return resultInfo;
    }
}