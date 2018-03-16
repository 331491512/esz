package com.esuizhen.server.sync.bean.server;

import com.esuizhen.server.sync.bean.TBatchDataResultInfo;

import java.util.Date;

/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class OuthospitalNoteRes {
    private String outhospitalId;

    private String inhospitalId;

    private String inhospitalNo;

    private Integer inhospitalTimes;

    private String emrId;

    private Long patientId;

    private String patientNo;

    private Integer hospitalId;

    private Date inhospitalDate;

    private Date outhospitalDate;

    private Integer inhospitalDays;

    private String symptomSummary;

    private String inhospitalDiagnosis;

    private String treatmentSummary;

    private String outhospitalDiagnosis;

    private String outhospitalDoctorAdvice;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private Integer syncFlag;

    private String patientuuId;

    private String mainID;

    private Integer contentType;

    private String outhospitalSummary;

    private Date rawCreateTime;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private String summaryContent;

    private String rawContent;

    private Integer opFlag;//opFlag用于标识云端是否已经存在

    private Integer cpFlag;//cpFlag标识是否存在电子病历主表

    private String mergeFromUuid;
    private String mergeTargetUuid;
    private Integer tempId;
    private String oldPatientNo;
    private Integer oldInhospitalTimes;
    private String treatmentResult;
    private Integer handleFlag;
    private Integer sourceFlag;

    public Integer getSourceFlag() {
        return sourceFlag;
    }

    public void setSourceFlag(Integer sourceFlag) {
        this.sourceFlag = sourceFlag;
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

    public Integer getTempId() {
        return tempId;
    }

    public void setTempId(Integer tempId) {
        this.tempId = tempId;
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

    public String getTreatmentResult() {
        return treatmentResult;
    }

    public void setTreatmentResult(String treatmentResult) {
        this.treatmentResult = treatmentResult;
    }

    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
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

	public String getSummaryContent() {
        return summaryContent;
    }

    public void setSummaryContent(String summaryContent) {
        this.summaryContent = summaryContent == null ? null : summaryContent.trim();
    }

    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent == null ? null : rawContent.trim();
    }

    public String getOuthospitalId() {
        return outhospitalId;
    }

    public void setOuthospitalId(String outhospitalId) {
        this.outhospitalId = outhospitalId == null ? null : outhospitalId.trim();
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

    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
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

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Date getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Date inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
    }

    public Date getOuthospitalDate() {
        return outhospitalDate;
    }

    public void setOuthospitalDate(Date outhospitalDate) {
        this.outhospitalDate = outhospitalDate;
    }

    public Integer getInhospitalDays() {
        return inhospitalDays;
    }

    public void setInhospitalDays(Integer inhospitalDays) {
        this.inhospitalDays = inhospitalDays;
    }

    public String getSymptomSummary() {
        return symptomSummary;
    }

    public void setSymptomSummary(String symptomSummary) {
        this.symptomSummary = symptomSummary == null ? null : symptomSummary.trim();
    }

    public String getInhospitalDiagnosis() {
        return inhospitalDiagnosis;
    }

    public void setInhospitalDiagnosis(String inhospitalDiagnosis) {
        this.inhospitalDiagnosis = inhospitalDiagnosis == null ? null : inhospitalDiagnosis.trim();
    }

    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    public void setTreatmentSummary(String treatmentSummary) {
        this.treatmentSummary = treatmentSummary == null ? null : treatmentSummary.trim();
    }

    public String getOuthospitalDiagnosis() {
        return outhospitalDiagnosis;
    }

    public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
        this.outhospitalDiagnosis = outhospitalDiagnosis == null ? null : outhospitalDiagnosis.trim();
    }

    public String getOuthospitalDoctorAdvice() {
        return outhospitalDoctorAdvice;
    }

    public void setOuthospitalDoctorAdvice(String outhospitalDoctorAdvice) {
        this.outhospitalDoctorAdvice = outhospitalDoctorAdvice == null ? null : outhospitalDoctorAdvice.trim();
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

    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    public String getPatientuuId() {
        return patientuuId;
    }

    public void setPatientuuId(String patientuuId) {
        this.patientuuId = patientuuId == null ? null : patientuuId.trim();
    }

    public String getMainID() {
        return mainID;
    }

    public void setMainID(String mainID) {
        this.mainID = mainID == null ? null : mainID.trim();
    }

    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
    }

    public String getOuthospitalSummary() {
        return outhospitalSummary;
    }

    public void setOuthospitalSummary(String outhospitalSummary) {
        this.outhospitalSummary = outhospitalSummary == null ? null : outhospitalSummary.trim();
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

    public TBatchDataResultInfo createResultInfo(){
        TBatchDataResultInfo resultInfo = new TBatchDataResultInfo();
        resultInfo.setOpFlag(this.opFlag);
        resultInfo.setSyncTime(new Date());
        resultInfo.setResultId(this.outhospitalId);
        return resultInfo;
    }
}