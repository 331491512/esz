package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 住院bean
 * @author LHY
 */
public class SyncInhospitalNote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String inhospitalId;
	private String inhospitalNo;
	private Integer opFlag;
	private String emrId;
	private String tempId;
	private Long patientId;
	private String patientUuid;
	private String patientNo;
	private String inpatientNo;
	private Integer inhospitalTimes;
	private String oldPatientNo;
	private Integer oldInhospitalTimes;
	private Integer hospitalId;
	private Integer medicalPayType;
	private Integer flag;
	private String healthCardNo;
	private Integer inhospitalWay;
	private Integer inhospitalSource;
	private Date inhospitalDate;
	private Integer inhospitalDeptId;
	private String inhospitalDeptUuid;
	private String inhospitalWard;
	private Integer inhospitalLastTime;
	private Integer turnDeptId;
	private String turnDeptUuid;
	private Date turnDeptDate;
	private String turnDept;
	private Date outhospitalDate;
	private Integer outhospitalDeptId;
	private String outhospitalDeptUuid;
	private String outhospitalWard;
	private Integer outhoispitalWay;
	private Integer inhospitalDays;
	private String diagnose;
	private String diseaseCode;
	private Long deptDoctor;
	private String deptDoctorUuid;
	private String deptDoctorName;
	private Long directorDoctor;
	private String directorDoctorUuid;
	private String directorDoctorName;
	private Long inchargeDoctor;
	private String inchargeDoctorUuid;
	private String inchargeDoctorName;
	private Long inhospitalDoctor;
	private String inhospitalDoctorUuid;
	private String inhospitalDoctorName;
	private Long attendingDoctor;
	private String attendingDoctorUuid;
	private String attendingDoctorName;
	private Long dutyNurse;
	private String dutyNurseUuid;
	private String dutyNurseName;
	private Long postgraduateDoctor;
	private String postgraduateDoctorUuid;
	private String postgraduateDoctorName;
	private Long internshipDoctor;
	private String internshipDoctorUuid;
	private String internshipDoctorName;
	private Integer codePerson;
	private String codePersonUuid;
	private String codePersonName;
	private Integer medicalRecordsQuality;
	private Long qualityControlDoctor;
	private String qualityControlDoctorUuid;
	private String qualityControlDoctorName;
	private Long qualityControlNurse;
	private String qualityControlNurseUuid;
	private String qualityControlNurseName;
	private Date qualityControlDate;
	private String mainDiagnosis;
	private String mainDiagnosisCode;
	private Integer inhospitalCondition;
	private Integer sourceFlag;
	private Integer historyCuration;
	private Integer sourceCancerNum;
	private Integer age;
	private String occupationId;
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
	private Date deathTime;
	private String deathCause;
	private Date createTime;
	private Date updateTime;
	private Integer deleteFlag;
	private Integer operatorId;
	private String operatorName;
	private Integer handleFlag;
	private Integer catalogState;
	private Date rawCreateTime;
	private Integer mergeFlag;
	private Long mergeFrom;
	private String mergeFromUuid;
	private Long mergeTarget;
	private String mergeTargetUuid;
	private Date mergeTime;
	private String oldinhospitalid;
	private Integer infoState;
	private Integer dataSource;
	private String batchId;
	public String getInhospitalId() {
		return inhospitalId;
	}
	public void setInhospitalId(String inhospitalId) {
		this.inhospitalId = inhospitalId;
	}
	public String getInhospitalNo() {
		return inhospitalNo;
	}
	public void setInhospitalNo(String inhospitalNo) {
		this.inhospitalNo = inhospitalNo;
	}
	public Integer getOpFlag() {
		return opFlag;
	}
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public String getTempId() {
		return tempId;
	}
	public void setTempId(String tempId) {
		this.tempId = tempId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
	}
	public String getInpatientNo() {
		return inpatientNo;
	}
	public void setInpatientNo(String inpatientNo) {
		this.inpatientNo = inpatientNo;
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
		this.oldPatientNo = oldPatientNo;
	}
	public Integer getOldInhospitalTimes() {
		return oldInhospitalTimes;
	}
	public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
		this.oldInhospitalTimes = oldInhospitalTimes;
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
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getHealthCardNo() {
		return healthCardNo;
	}
	public void setHealthCardNo(String healthCardNo) {
		this.healthCardNo = healthCardNo;
	}
	public Integer getInhospitalWay() {
		return inhospitalWay;
	}
	public void setInhospitalWay(Integer inhospitalWay) {
		this.inhospitalWay = inhospitalWay;
	}
	public Integer getInhospitalSource() {
		return inhospitalSource;
	}
	public void setInhospitalSource(Integer inhospitalSource) {
		this.inhospitalSource = inhospitalSource;
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
	public String getInhospitalDeptUuid() {
		return inhospitalDeptUuid;
	}
	public void setInhospitalDeptUuid(String inhospitalDeptUuid) {
		this.inhospitalDeptUuid = inhospitalDeptUuid;
	}
	public String getInhospitalWard() {
		return inhospitalWard;
	}
	public void setInhospitalWard(String inhospitalWard) {
		this.inhospitalWard = inhospitalWard;
	}
	public Integer getInhospitalLastTime() {
		return inhospitalLastTime;
	}
	public void setInhospitalLastTime(Integer inhospitalLastTime) {
		this.inhospitalLastTime = inhospitalLastTime;
	}
	public Integer getTurnDeptId() {
		return turnDeptId;
	}
	public void setTurnDeptId(Integer turnDeptId) {
		this.turnDeptId = turnDeptId;
	}
	public String getTurnDeptUuid() {
		return turnDeptUuid;
	}
	public void setTurnDeptUuid(String turnDeptUuid) {
		this.turnDeptUuid = turnDeptUuid;
	}
	public Date getTurnDeptDate() {
		return turnDeptDate;
	}
	public void setTurnDeptDate(Date turnDeptDate) {
		this.turnDeptDate = turnDeptDate;
	}
	public String getTurnDept() {
		return turnDept;
	}
	public void setTurnDept(String turnDept) {
		this.turnDept = turnDept;
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
	public String getOuthospitalDeptUuid() {
		return outhospitalDeptUuid;
	}
	public void setOuthospitalDeptUuid(String outhospitalDeptUuid) {
		this.outhospitalDeptUuid = outhospitalDeptUuid;
	}
	public String getOuthospitalWard() {
		return outhospitalWard;
	}
	public void setOuthospitalWard(String outhospitalWard) {
		this.outhospitalWard = outhospitalWard;
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
		this.diagnose = diagnose;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public Long getDeptDoctor() {
		return deptDoctor;
	}
	public void setDeptDoctor(Long deptDoctor) {
		this.deptDoctor = deptDoctor;
	}
	public String getDeptDoctorUuid() {
		return deptDoctorUuid;
	}
	public void setDeptDoctorUuid(String deptDoctorUuid) {
		this.deptDoctorUuid = deptDoctorUuid;
	}
	public String getDeptDoctorName() {
		return deptDoctorName;
	}
	public void setDeptDoctorName(String deptDoctorName) {
		this.deptDoctorName = deptDoctorName;
	}
	public Long getDirectorDoctor() {
		return directorDoctor;
	}
	public void setDirectorDoctor(Long directorDoctor) {
		this.directorDoctor = directorDoctor;
	}
	public String getDirectorDoctorUuid() {
		return directorDoctorUuid;
	}
	public void setDirectorDoctorUuid(String directorDoctorUuid) {
		this.directorDoctorUuid = directorDoctorUuid;
	}
	public String getDirectorDoctorName() {
		return directorDoctorName;
	}
	public void setDirectorDoctorName(String directorDoctorName) {
		this.directorDoctorName = directorDoctorName;
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
	public String getInchargeDoctorName() {
		return inchargeDoctorName;
	}
	public void setInchargeDoctorName(String inchargeDoctorName) {
		this.inchargeDoctorName = inchargeDoctorName;
	}
	public Long getInhospitalDoctor() {
		return inhospitalDoctor;
	}
	public void setInhospitalDoctor(Long inhospitalDoctor) {
		this.inhospitalDoctor = inhospitalDoctor;
	}
	public String getInhospitalDoctorUuid() {
		return inhospitalDoctorUuid;
	}
	public void setInhospitalDoctorUuid(String inhospitalDoctorUuid) {
		this.inhospitalDoctorUuid = inhospitalDoctorUuid;
	}
	public String getInhospitalDoctorName() {
		return inhospitalDoctorName;
	}
	public void setInhospitalDoctorName(String inhospitalDoctorName) {
		this.inhospitalDoctorName = inhospitalDoctorName;
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
	public String getAttendingDoctorName() {
		return attendingDoctorName;
	}
	public void setAttendingDoctorName(String attendingDoctorName) {
		this.attendingDoctorName = attendingDoctorName;
	}
	public Long getDutyNurse() {
		return dutyNurse;
	}
	public void setDutyNurse(Long dutyNurse) {
		this.dutyNurse = dutyNurse;
	}
	public String getDutyNurseUuid() {
		return dutyNurseUuid;
	}
	public void setDutyNurseUuid(String dutyNurseUuid) {
		this.dutyNurseUuid = dutyNurseUuid;
	}
	public String getDutyNurseName() {
		return dutyNurseName;
	}
	public void setDutyNurseName(String dutyNurseName) {
		this.dutyNurseName = dutyNurseName;
	}
	public Long getPostgraduateDoctor() {
		return postgraduateDoctor;
	}
	public void setPostgraduateDoctor(Long postgraduateDoctor) {
		this.postgraduateDoctor = postgraduateDoctor;
	}
	public String getPostgraduateDoctorUuid() {
		return postgraduateDoctorUuid;
	}
	public void setPostgraduateDoctorUuid(String postgraduateDoctorUuid) {
		this.postgraduateDoctorUuid = postgraduateDoctorUuid;
	}
	public String getPostgraduateDoctorName() {
		return postgraduateDoctorName;
	}
	public void setPostgraduateDoctorName(String postgraduateDoctorName) {
		this.postgraduateDoctorName = postgraduateDoctorName;
	}
	public Long getInternshipDoctor() {
		return internshipDoctor;
	}
	public void setInternshipDoctor(Long internshipDoctor) {
		this.internshipDoctor = internshipDoctor;
	}
	public String getInternshipDoctorUuid() {
		return internshipDoctorUuid;
	}
	public void setInternshipDoctorUuid(String internshipDoctorUuid) {
		this.internshipDoctorUuid = internshipDoctorUuid;
	}
	public String getInternshipDoctorName() {
		return internshipDoctorName;
	}
	public void setInternshipDoctorName(String internshipDoctorName) {
		this.internshipDoctorName = internshipDoctorName;
	}
	public Integer getCodePerson() {
		return codePerson;
	}
	public void setCodePerson(Integer codePerson) {
		this.codePerson = codePerson;
	}
	public String getCodePersonUuid() {
		return codePersonUuid;
	}
	public void setCodePersonUuid(String codePersonUuid) {
		this.codePersonUuid = codePersonUuid;
	}
	public String getCodePersonName() {
		return codePersonName;
	}
	public void setCodePersonName(String codePersonName) {
		this.codePersonName = codePersonName;
	}
	public Integer getMedicalRecordsQuality() {
		return medicalRecordsQuality;
	}
	public void setMedicalRecordsQuality(Integer medicalRecordsQuality) {
		this.medicalRecordsQuality = medicalRecordsQuality;
	}
	public Long getQualityControlDoctor() {
		return qualityControlDoctor;
	}
	public void setQualityControlDoctor(Long qualityControlDoctor) {
		this.qualityControlDoctor = qualityControlDoctor;
	}
	public String getQualityControlDoctorUuid() {
		return qualityControlDoctorUuid;
	}
	public void setQualityControlDoctorUuid(String qualityControlDoctorUuid) {
		this.qualityControlDoctorUuid = qualityControlDoctorUuid;
	}
	public String getQualityControlDoctorName() {
		return qualityControlDoctorName;
	}
	public void setQualityControlDoctorName(String qualityControlDoctorName) {
		this.qualityControlDoctorName = qualityControlDoctorName;
	}
	public Long getQualityControlNurse() {
		return qualityControlNurse;
	}
	public void setQualityControlNurse(Long qualityControlNurse) {
		this.qualityControlNurse = qualityControlNurse;
	}
	public String getQualityControlNurseUuid() {
		return qualityControlNurseUuid;
	}
	public void setQualityControlNurseUuid(String qualityControlNurseUuid) {
		this.qualityControlNurseUuid = qualityControlNurseUuid;
	}
	public String getQualityControlNurseName() {
		return qualityControlNurseName;
	}
	public void setQualityControlNurseName(String qualityControlNurseName) {
		this.qualityControlNurseName = qualityControlNurseName;
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
		this.mainDiagnosis = mainDiagnosis;
	}
	public String getMainDiagnosisCode() {
		return mainDiagnosisCode;
	}
	public void setMainDiagnosisCode(String mainDiagnosisCode) {
		this.mainDiagnosisCode = mainDiagnosisCode;
	}
	public Integer getInhospitalCondition() {
		return inhospitalCondition;
	}
	public void setInhospitalCondition(Integer inhospitalCondition) {
		this.inhospitalCondition = inhospitalCondition;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getOccupationId() {
		return occupationId;
	}
	public void setOccupationId(String occupationId) {
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
		this.identification = identification;
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
		this.reInhospitalTarget31Days = reInhospitalTarget31Days;
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
		this.allergyDesc = allergyDesc;
	}
	public Integer getAutopsy() {
		return autopsy;
	}
	public void setAutopsy(Integer autopsy) {
		this.autopsy = autopsy;
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
	public String getTumourPeriodizationT() {
		return tumourPeriodizationT;
	}
	public void setTumourPeriodizationT(String tumourPeriodizationT) {
		this.tumourPeriodizationT = tumourPeriodizationT;
	}
	public String getTumourPeriodizationN() {
		return tumourPeriodizationN;
	}
	public void setTumourPeriodizationN(String tumourPeriodizationN) {
		this.tumourPeriodizationN = tumourPeriodizationN;
	}
	public String getTumourPeriodizationM1() {
		return tumourPeriodizationM1;
	}
	public void setTumourPeriodizationM1(String tumourPeriodizationM1) {
		this.tumourPeriodizationM1 = tumourPeriodizationM1;
	}
	public String getTumourPeriodizationM2() {
		return tumourPeriodizationM2;
	}
	public void setTumourPeriodizationM2(String tumourPeriodizationM2) {
		this.tumourPeriodizationM2 = tumourPeriodizationM2;
	}
	public String getTumourPeriodizationClinic() {
		return tumourPeriodizationClinic;
	}
	public void setTumourPeriodizationClinic(String tumourPeriodizationClinic) {
		this.tumourPeriodizationClinic = tumourPeriodizationClinic;
	}
	public String getTumourPeriodization() {
		return tumourPeriodization;
	}
	public void setTumourPeriodization(String tumourPeriodization) {
		this.tumourPeriodization = tumourPeriodization;
	}
	public String getPathologyDiagnosis() {
		return pathologyDiagnosis;
	}
	public void setPathologyDiagnosis(String pathologyDiagnosis) {
		this.pathologyDiagnosis = pathologyDiagnosis;
	}
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
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
		this.nativePlaceCityCode = nativePlaceCityCode;
	}
	public String getNativePlaceAddress() {
		return nativePlaceAddress;
	}
	public void setNativePlaceAddress(String nativePlaceAddress) {
		this.nativePlaceAddress = nativePlaceAddress;
	}
	public String getHouseholdZipCode() {
		return householdZipCode;
	}
	public void setHouseholdZipCode(String householdZipCode) {
		this.householdZipCode = householdZipCode;
	}
	public String getHouseholdCountyCode() {
		return householdCountyCode;
	}
	public void setHouseholdCountyCode(String householdCountyCode) {
		this.householdCountyCode = householdCountyCode;
	}
	public String getHouseholdAddress() {
		return householdAddress;
	}
	public void setHouseholdAddress(String householdAddress) {
		this.householdAddress = householdAddress;
	}
	public String getCompanyZipCode() {
		return companyZipCode;
	}
	public void setCompanyZipCode(String companyZipCode) {
		this.companyZipCode = companyZipCode;
	}
	public String getCompanyCountyCode() {
		return companyCountyCode;
	}
	public void setCompanyCountyCode(String companyCountyCode) {
		this.companyCountyCode = companyCountyCode;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getCompanyTel() {
		return companyTel;
	}
	public void setCompanyTel(String companyTel) {
		this.companyTel = companyTel;
	}
	public String getLiveZipCode() {
		return liveZipCode;
	}
	public void setLiveZipCode(String liveZipCode) {
		this.liveZipCode = liveZipCode;
	}
	public String getLiveCountyCode() {
		return liveCountyCode;
	}
	public void setLiveCountyCode(String liveCountyCode) {
		this.liveCountyCode = liveCountyCode;
	}
	public String getLiveAddress() {
		return liveAddress;
	}
	public void setLiveAddress(String liveAddress) {
		this.liveAddress = liveAddress;
	}
	public String getLiveTel() {
		return liveTel;
	}
	public void setLiveTel(String liveTel) {
		this.liveTel = liveTel;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public Integer getPatientRelation() {
		return patientRelation;
	}
	public void setPatientRelation(Integer patientRelation) {
		this.patientRelation = patientRelation;
	}
	public String getFamilyCountyCode() {
		return familyCountyCode;
	}
	public void setFamilyCountyCode(String familyCountyCode) {
		this.familyCountyCode = familyCountyCode;
	}
	public String getFamilyAddress() {
		return familyAddress;
	}
	public void setFamilyAddress(String familyAddress) {
		this.familyAddress = familyAddress;
	}
	public String getFamilyTel() {
		return familyTel;
	}
	public void setFamilyTel(String familyTel) {
		this.familyTel = familyTel;
	}
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
	public Integer getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	public Integer getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Integer operatorId) {
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
	public Integer getCatalogState() {
		return catalogState;
	}
	public void setCatalogState(Integer catalogState) {
		this.catalogState = catalogState;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
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
		this.oldinhospitalid = oldinhospitalid;
	}
	public Integer getInfoState() {
		return infoState;
	}
	public void setInfoState(Integer infoState) {
		this.infoState = infoState;
	}
	
	public Integer getDataSource() {
		return dataSource;
	}
	public void setDataSource(Integer dataSource) {
		this.dataSource = dataSource;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	
}
