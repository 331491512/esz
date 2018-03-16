package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class TDetectionDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    private String detectionDetailId;

    private String detectionReportId;

    private Long patientId;

    private String patientNo;

    private Integer seqNo;

    private String detectionTypeName;

    private Integer detectionItemId;

    private String detectionItemCode;

    private String detectionItemName;

    private String detectionItemEnglishName;

    private String detectionResult;

    private String prompt;

    private Integer promptType;

    private Integer resultType;

    private String unit;

    private String refrenceRange;

    private String patientUuid;

    private String refrenceRangeMin;

    private String refrenceRangeMax;

    private String detectionMethod;

    private String reagentBrand;

    private String instrument;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private String rawDetectionItemCode;

    private Long detailID;

    private Long mainID;

    private Integer syncflag;

    private Date rawCreateTime;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private String mergeFromUuid;
    private String mergeTargetUuid;

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

    public String getDetectionDetailId() {
        return detectionDetailId;
    }

    public void setDetectionDetailId(String detectionDetailId) {
        this.detectionDetailId = detectionDetailId == null ? null : detectionDetailId.trim();
    }

    public String getDetectionReportId() {
        return detectionReportId;
    }

    public void setDetectionReportId(String detectionReportId) {
        this.detectionReportId = detectionReportId == null ? null : detectionReportId.trim();
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

    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    public String getDetectionTypeName() {
        return detectionTypeName;
    }

    public void setDetectionTypeName(String detectionTypeName) {
        this.detectionTypeName = detectionTypeName == null ? null : detectionTypeName.trim();
    }

    public Integer getDetectionItemId() {
        return detectionItemId;
    }

    public void setDetectionItemId(Integer detectionItemId) {
        this.detectionItemId = detectionItemId;
    }

    public String getDetectionItemCode() {
        return detectionItemCode;
    }

    public void setDetectionItemCode(String detectionItemCode) {
        this.detectionItemCode = detectionItemCode == null ? null : detectionItemCode.trim();
    }

    public String getDetectionItemName() {
        return detectionItemName;
    }

    public void setDetectionItemName(String detectionItemName) {
        this.detectionItemName = detectionItemName == null ? null : detectionItemName.trim();
    }

    public String getDetectionItemEnglishName() {
        return detectionItemEnglishName;
    }

    public void setDetectionItemEnglishName(String detectionItemEnglishName) {
        this.detectionItemEnglishName = detectionItemEnglishName == null ? null : detectionItemEnglishName.trim();
    }

    public String getDetectionResult() {
        return detectionResult;
    }

    public void setDetectionResult(String detectionResult) {
        this.detectionResult = detectionResult == null ? null : detectionResult.trim();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? null : prompt.trim();
    }

    public Integer getPromptType() {
        return promptType;
    }

    public void setPromptType(Integer promptType) {
        this.promptType = promptType;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getRefrenceRange() {
        return refrenceRange;
    }

    public void setRefrenceRange(String refrenceRange) {
        this.refrenceRange = refrenceRange == null ? null : refrenceRange.trim();
    }

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public String getRefrenceRangeMin() {
        return refrenceRangeMin;
    }

    public void setRefrenceRangeMin(String refrenceRangeMin) {
        this.refrenceRangeMin = refrenceRangeMin == null ? null : refrenceRangeMin.trim();
    }

    public String getRefrenceRangeMax() {
        return refrenceRangeMax;
    }

    public void setRefrenceRangeMax(String refrenceRangeMax) {
        this.refrenceRangeMax = refrenceRangeMax == null ? null : refrenceRangeMax.trim();
    }

    public String getDetectionMethod() {
        return detectionMethod;
    }

    public void setDetectionMethod(String detectionMethod) {
        this.detectionMethod = detectionMethod == null ? null : detectionMethod.trim();
    }

    public String getReagentBrand() {
        return reagentBrand;
    }

    public void setReagentBrand(String reagentBrand) {
        this.reagentBrand = reagentBrand == null ? null : reagentBrand.trim();
    }

    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument == null ? null : instrument.trim();
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

    public String getRawDetectionItemCode() {
        return rawDetectionItemCode;
    }

    public void setRawDetectionItemCode(String rawDetectionItemCode) {
        this.rawDetectionItemCode = rawDetectionItemCode == null ? null : rawDetectionItemCode.trim();
    }

    public Long getDetailID() {
        return detailID;
    }

    public void setDetailID(Long detailID) {
        this.detailID = detailID;
    }

    public Long getMainID() {
        return mainID;
    }

    public void setMainID(Long mainID) {
        this.mainID = mainID;
    }

    public Integer getSyncflag() {
        return syncflag;
    }

    public void setSyncflag(Integer syncflag) {
        this.syncflag = syncflag;
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
}