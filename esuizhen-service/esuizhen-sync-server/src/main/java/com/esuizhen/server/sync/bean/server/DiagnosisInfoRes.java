package com.esuizhen.server.sync.bean.server;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

import java.util.Date;

/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class DiagnosisInfoRes {
    private String diagnosisId;

    private String emrId;

    private Long patientId;

    private String patientNo;

    private String oldPatientNo;

    private Integer inhospitalTimes;

    private Integer oldInhospitalTimes;

    private String inhospitalNo;

    private String inhospitalId;

    private Integer diagnosisTypeId;

    private String diagnosis;

    private Integer diagnosisExplain;

    private Integer inHospitalCondition;

    private Integer icdDiseaseTypeId;

    private Integer diseaseTypeId;

    private Integer diseaseBodyPartId;

    private String diseaseCode;

    private String zdyCode;

    private String organCode;

    private String organName;

    private Integer treatmentHistory;

    private Integer isFollowup;

    private Integer sourceCancerCount;

    private String diseaseBasis;

    private Integer diagnosisBasisId;

    private String pathologyDiagnosis;

    private String pathologyDiagnosisCode;

    private Integer isSourceDiagnosis;

    private Integer disagnosisPeriodizationId;

    private String remark;

    private Date visitTime;

    private Long creator;

    private Long operatorId;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private Integer handleFlag;

    private Integer outhospitalCondition;

    private Long firstdiagnosisHospitalId;

    private String firstdiagnosisHospitalName;

    private Date firstdiagnosisTime;

    private Integer specialDiseaseDiagnosisId;

    private Long diagnosisDoctorId;

    private String diagnosisDoctorName;

    private Integer suspectedDiagnosisFlag;

    private Integer surgeryFlag;

    private Integer outhospitalDeptId;
    
    private String outhospitalDeptUuid;

    private String tumourPeriodizationT;

    private String tumourPeriodizationN;

    private String tumourPeriodizationM1;

    private String tumourPeriodizationClinic;

    private String tumourPeriodization;

    private String outhospitalDiagnosis;

    private String outhospitalDiagnosisCode;

    private String clinicNo;

    private String mainID;

    private String patientUuid;

    private String creatorUuid;

    private String operatorUuid;

    private String diagnosisDoctorUuid;

    private String eszCode;

    private Date rawCreateTime;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private Integer opFlag;//opFlag用于标识云端是否已经存在

    private Integer cpFlag;//cpFlag标识是否存在电子病历主表
    private Integer sourceFlag;

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
    }

    private String mergeFromUuid;
    private String mergeTargetUuid;
    private Long specialDiseaseRegisterId;
    private Integer tempId;
    private Integer seq;

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

    public Long getSpecialDiseaseRegisterId() {
        return specialDiseaseRegisterId;
    }

    public void setSpecialDiseaseRegisterId(Long specialDiseaseRegisterId) {
        this.specialDiseaseRegisterId = specialDiseaseRegisterId;
    }

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
    }

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public Integer getCpFlag() {
        return cpFlag;
    }

    public void setCpFlag(Integer cpFlag) {
        this.cpFlag = cpFlag;
    }

    public Integer getOpFlag() {
		return opFlag;
	}

	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}

	public String getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(String diagnosisId) {
        this.diagnosisId = diagnosisId == null ? null : diagnosisId.trim();
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

    public String getOldPatientNo() {
        return oldPatientNo;
    }

    public void setOldPatientNo(String oldPatientNo) {
        this.oldPatientNo = oldPatientNo == null ? null : oldPatientNo.trim();
    }

    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    public Integer getOldInhospitalTimes() {
        return oldInhospitalTimes;
    }

    public void setOldInhospitalTimes(Integer oldInhospitalTimes) {
        this.oldInhospitalTimes = oldInhospitalTimes;
    }

    public String getInhospitalNo() {
        return inhospitalNo;
    }

    public void setInhospitalNo(String inhospitalNo) {
        this.inhospitalNo = inhospitalNo == null ? null : inhospitalNo.trim();
    }

    public String getInhospitalId() {
        return inhospitalId;
    }

    public void setInhospitalId(String inhospitalId) {
        this.inhospitalId = inhospitalId == null ? null : inhospitalId.trim();
    }

    public Integer getDiagnosisTypeId() {
        return diagnosisTypeId;
    }

    public void setDiagnosisTypeId(Integer diagnosisTypeId) {
        this.diagnosisTypeId = diagnosisTypeId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis == null ? null : diagnosis.trim();
    }

    public Integer getDiagnosisExplain() {
        return diagnosisExplain;
    }

    public void setDiagnosisExplain(Integer diagnosisExplain) {
        this.diagnosisExplain = diagnosisExplain;
    }

    public Integer getInHospitalCondition() {
        return inHospitalCondition;
    }

    public void setInHospitalCondition(Integer inHospitalCondition) {
        this.inHospitalCondition = inHospitalCondition;
    }

    public Integer getIcdDiseaseTypeId() {
        return icdDiseaseTypeId;
    }

    public void setIcdDiseaseTypeId(Integer icdDiseaseTypeId) {
        this.icdDiseaseTypeId = icdDiseaseTypeId;
    }

    public Integer getDiseaseTypeId() {
        return diseaseTypeId;
    }

    public void setDiseaseTypeId(Integer diseaseTypeId) {
        this.diseaseTypeId = diseaseTypeId;
    }

    public Integer getDiseaseBodyPartId() {
        return diseaseBodyPartId;
    }

    public void setDiseaseBodyPartId(Integer diseaseBodyPartId) {
        this.diseaseBodyPartId = diseaseBodyPartId;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode == null ? null : diseaseCode.trim();
    }

    public String getZdyCode() {
        return zdyCode;
    }

    public void setZdyCode(String zdyCode) {
        this.zdyCode = zdyCode == null ? null : zdyCode.trim();
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode == null ? null : organCode.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public Integer getTreatmentHistory() {
        return treatmentHistory;
    }

    public void setTreatmentHistory(Integer treatmentHistory) {
        this.treatmentHistory = treatmentHistory;
    }

    public Integer getIsFollowup() {
        return isFollowup;
    }

    public void setIsFollowup(Integer isFollowup) {
        this.isFollowup = isFollowup;
    }

    public Integer getSourceCancerCount() {
        return sourceCancerCount;
    }

    public void setSourceCancerCount(Integer sourceCancerCount) {
        this.sourceCancerCount = sourceCancerCount;
    }

    public String getDiseaseBasis() {
        return diseaseBasis;
    }

    public void setDiseaseBasis(String diseaseBasis) {
        this.diseaseBasis = diseaseBasis == null ? null : diseaseBasis.trim();
    }

    public Integer getDiagnosisBasisId() {
        return diagnosisBasisId;
    }

    public void setDiagnosisBasisId(Integer diagnosisBasisId) {
        this.diagnosisBasisId = diagnosisBasisId;
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

    public Integer getIsSourceDiagnosis() {
        return isSourceDiagnosis;
    }

    public void setIsSourceDiagnosis(Integer isSourceDiagnosis) {
        this.isSourceDiagnosis = isSourceDiagnosis;
    }

    public Integer getDisagnosisPeriodizationId() {
        return disagnosisPeriodizationId;
    }

    public void setDisagnosisPeriodizationId(Integer disagnosisPeriodizationId) {
        this.disagnosisPeriodizationId = disagnosisPeriodizationId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
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

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
    }

    public Integer getOuthospitalCondition() {
        return outhospitalCondition;
    }

    public void setOuthospitalCondition(Integer outhospitalCondition) {
        this.outhospitalCondition = outhospitalCondition;
    }

    public Long getFirstdiagnosisHospitalId() {
        return firstdiagnosisHospitalId;
    }

    public void setFirstdiagnosisHospitalId(Long firstdiagnosisHospitalId) {
        this.firstdiagnosisHospitalId = firstdiagnosisHospitalId;
    }

    public String getFirstdiagnosisHospitalName() {
        return firstdiagnosisHospitalName;
    }

    public void setFirstdiagnosisHospitalName(String firstdiagnosisHospitalName) {
        this.firstdiagnosisHospitalName = firstdiagnosisHospitalName == null ? null : firstdiagnosisHospitalName.trim();
    }

    public Date getFirstdiagnosisTime() {
        return firstdiagnosisTime;
    }

    public void setFirstdiagnosisTime(Date firstdiagnosisTime) {
        this.firstdiagnosisTime = firstdiagnosisTime;
    }

    public Integer getSpecialDiseaseDiagnosisId() {
        return specialDiseaseDiagnosisId;
    }

    public void setSpecialDiseaseDiagnosisId(Integer specialDiseaseDiagnosisId) {
        this.specialDiseaseDiagnosisId = specialDiseaseDiagnosisId;
    }

    public Long getDiagnosisDoctorId() {
        return diagnosisDoctorId;
    }

    public void setDiagnosisDoctorId(Long diagnosisDoctorId) {
        this.diagnosisDoctorId = diagnosisDoctorId;
    }

    public String getDiagnosisDoctorName() {
        return diagnosisDoctorName;
    }

    public void setDiagnosisDoctorName(String diagnosisDoctorName) {
        this.diagnosisDoctorName = diagnosisDoctorName == null ? null : diagnosisDoctorName.trim();
    }

    public Integer getSuspectedDiagnosisFlag() {
        return suspectedDiagnosisFlag;
    }

    public void setSuspectedDiagnosisFlag(Integer suspectedDiagnosisFlag) {
        this.suspectedDiagnosisFlag = suspectedDiagnosisFlag;
    }

    public Integer getSurgeryFlag() {
        return surgeryFlag;
    }

    public void setSurgeryFlag(Integer surgeryFlag) {
        this.surgeryFlag = surgeryFlag;
    }

    public Integer getOuthospitalDeptId() {
        return outhospitalDeptId;
    }

    public void setOuthospitalDeptId(Integer outhospitalDeptId) {
        this.outhospitalDeptId = outhospitalDeptId;
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

    public String getOuthospitalDiagnosis() {
        return outhospitalDiagnosis;
    }

    public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
        this.outhospitalDiagnosis = outhospitalDiagnosis == null ? null : outhospitalDiagnosis.trim();
    }

    public String getOuthospitalDiagnosisCode() {
        return outhospitalDiagnosisCode;
    }

    public void setOuthospitalDiagnosisCode(String outhospitalDiagnosisCode) {
        this.outhospitalDiagnosisCode = outhospitalDiagnosisCode == null ? null : outhospitalDiagnosisCode.trim();
    }

    public String getClinicNo() {
        return clinicNo;
    }

    public void setClinicNo(String clinicNo) {
        this.clinicNo = clinicNo == null ? null : clinicNo.trim();
    }

    public String getMainID() {
        return mainID;
    }

    public void setMainID(String mainID) {
        this.mainID = mainID == null ? null : mainID.trim();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public String getCreatorUuid() {
        return creatorUuid;
    }

    public void setCreatorUuid(String creatorUuid) {
        this.creatorUuid = creatorUuid == null ? null : creatorUuid.trim();
    }

    public String getOperatorUuid() {
        return operatorUuid;
    }

    public void setOperatorUuid(String operatorUuid) {
        this.operatorUuid = operatorUuid == null ? null : operatorUuid.trim();
    }

    public String getDiagnosisDoctorUuid() {
        return diagnosisDoctorUuid;
    }

    public void setDiagnosisDoctorUuid(String diagnosisDoctorUuid) {
        this.diagnosisDoctorUuid = diagnosisDoctorUuid == null ? null : diagnosisDoctorUuid.trim();
    }

    public String getEszCode() {
        return eszCode;
    }

    public void setEszCode(String eszCode) {
        this.eszCode = eszCode == null ? null : eszCode.trim();
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

    public String getOuthospitalDeptUuid() {
		return outhospitalDeptUuid;
	}

	public void setOuthospitalDeptUuid(String outhospitalDeptUuid) {
		this.outhospitalDeptUuid = outhospitalDeptUuid;
	}

	public TBatchDataResultInfo createResultInfo(){
        TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
        resultInfo.setOpFlag(this.opFlag);
        resultInfo.setSyncTime(new Date());
        resultInfo.setResultId(this.diagnosisId);
        return resultInfo;
    }
}