package com.esuizhen.bigdata.domain.ehr;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_detection_detail", schema = "lis_db",catalog="")
//@Audited
//@AuditTable(value = "eci_detection_detail_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciDetectionDetail {
    private String detectionDetailId;
    private String detectionReportId;
    private Long patientId;
    private String patientUuid;
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
    private String refrenceRangeMin;
    private String refrenceRangeMax;
    private String detectionMethod;
    private String reagentBrand;
    private String instrument;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp syncTime;
    private Integer syncFlag;
    private String rawDetectionItemCode;
    private Long mainId;
    private Long detailId;
    private Timestamp rawCreateTime;
//    private EciDetectionReport eciDetectionReportByDetectionReportId;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

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

    @Id
    @Column(name = "detectionDetailId", nullable = false, length = 128)
    public String getDetectionDetailId() {
        return detectionDetailId;
    }

    public void setDetectionDetailId(String detectionDetailId) {
        this.detectionDetailId = detectionDetailId;
    }

    @Basic
    @Column(name = "detectionReportId", nullable = false, length = 128)
    public String getDetectionReportId() {
        return detectionReportId;
    }

    public void setDetectionReportId(String detectionReportId) {
        this.detectionReportId = detectionReportId;
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
    @Column(name = "patientUuid", nullable = true, length = 32)
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
    @Column(name = "seqNo", nullable = true)
    public Integer getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }

    @Basic
    @Column(name = "detectionTypeName", nullable = true, length = 255)
    public String getDetectionTypeName() {
        return detectionTypeName;
    }

    public void setDetectionTypeName(String detectionTypeName) {
        this.detectionTypeName = detectionTypeName;
    }

    @Basic
    @Column(name = "detectionItemId", nullable = true)
    public Integer getDetectionItemId() {
        return detectionItemId;
    }

    public void setDetectionItemId(Integer detectionItemId) {
        this.detectionItemId = detectionItemId;
    }

    @Basic
    @Column(name = "detectionItemCode", nullable = true, length = 30)
    public String getDetectionItemCode() {
        return detectionItemCode;
    }

    public void setDetectionItemCode(String detectionItemCode) {
        this.detectionItemCode = detectionItemCode;
    }

    @Basic
    @Column(name = "detectionItemName", nullable = false, length = 1024)
    public String getDetectionItemName() {
        return detectionItemName;
    }

    public void setDetectionItemName(String detectionItemName) {
        this.detectionItemName = detectionItemName;
    }

    @Basic
    @Column(name = "detectionItemEnglishName", nullable = true, length = 255)
    public String getDetectionItemEnglishName() {
        return detectionItemEnglishName;
    }

    public void setDetectionItemEnglishName(String detectionItemEnglishName) {
        this.detectionItemEnglishName = detectionItemEnglishName;
    }

    @Basic
    @Column(name = "detectionResult", nullable = false, length = 256)
    public String getDetectionResult() {
        return detectionResult;
    }

    public void setDetectionResult(String detectionResult) {
        this.detectionResult = detectionResult;
    }

    @Basic
    @Column(name = "prompt", nullable = true, length = 30)
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    @Basic
    @Column(name = "promptType", nullable = true)
    public Integer getPromptType() {
        return promptType;
    }

    public void setPromptType(Integer promptType) {
        this.promptType = promptType;
    }

    @Basic
    @Column(name = "resultType", nullable = true)
    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    @Basic
    @Column(name = "unit", nullable = true, length = 30)
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "refrenceRange", nullable = true, length = 255)
    public String getRefrenceRange() {
        return refrenceRange;
    }

    public void setRefrenceRange(String refrenceRange) {
        this.refrenceRange = refrenceRange;
    }

    @Basic
    @Column(name = "refrenceRangeMin", nullable = true, length = 30)
    public String getRefrenceRangeMin() {
        return refrenceRangeMin;
    }

    public void setRefrenceRangeMin(String refrenceRangeMin) {
        this.refrenceRangeMin = refrenceRangeMin;
    }

    @Basic
    @Column(name = "refrenceRangeMax", nullable = true, length = 30)
    public String getRefrenceRangeMax() {
        return refrenceRangeMax;
    }

    public void setRefrenceRangeMax(String refrenceRangeMax) {
        this.refrenceRangeMax = refrenceRangeMax;
    }

    @Basic
    @Column(name = "detectionMethod", nullable = true, length = 20)
    public String getDetectionMethod() {
        return detectionMethod;
    }

    public void setDetectionMethod(String detectionMethod) {
        this.detectionMethod = detectionMethod;
    }

    @Basic
    @Column(name = "reagentBrand", nullable = true, length = 30)
    public String getReagentBrand() {
        return reagentBrand;
    }

    public void setReagentBrand(String reagentBrand) {
        this.reagentBrand = reagentBrand;
    }

    @Basic
    @Column(name = "instrument", nullable = true, length = 50)
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
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
    @Column(name = "syncFlag", nullable = true)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
    }

    @Basic
    @Column(name = "rawDetectionItemCode", nullable = true, length = 30)
    public String getRawDetectionItemCode() {
        return rawDetectionItemCode;
    }

    public void setRawDetectionItemCode(String rawDetectionItemCode) {
        this.rawDetectionItemCode = rawDetectionItemCode;
    }

    @Basic
    @Column(name = "mainID", nullable = true)
    public Long getMainId() {
        return mainId;
    }

    public void setMainId(Long mainId) {
        this.mainId = mainId;
    }

    @Basic
    @Column(name = "detailID", nullable = true)
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
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

        EciDetectionDetail that = (EciDetectionDetail) o;

        if (detectionDetailId != null ? !detectionDetailId.equals(that.detectionDetailId) : that.detectionDetailId != null)
            return false;
        if (detectionReportId != null ? !detectionReportId.equals(that.detectionReportId) : that.detectionReportId != null)
            return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (seqNo != null ? !seqNo.equals(that.seqNo) : that.seqNo != null) return false;
        if (detectionTypeName != null ? !detectionTypeName.equals(that.detectionTypeName) : that.detectionTypeName != null)
            return false;
        if (detectionItemId != null ? !detectionItemId.equals(that.detectionItemId) : that.detectionItemId != null)
            return false;
        if (detectionItemCode != null ? !detectionItemCode.equals(that.detectionItemCode) : that.detectionItemCode != null)
            return false;
        if (detectionItemName != null ? !detectionItemName.equals(that.detectionItemName) : that.detectionItemName != null)
            return false;
        if (detectionItemEnglishName != null ? !detectionItemEnglishName.equals(that.detectionItemEnglishName) : that.detectionItemEnglishName != null)
            return false;
        if (detectionResult != null ? !detectionResult.equals(that.detectionResult) : that.detectionResult != null)
            return false;
        if (prompt != null ? !prompt.equals(that.prompt) : that.prompt != null) return false;
        if (promptType != null ? !promptType.equals(that.promptType) : that.promptType != null) return false;
        if (resultType != null ? !resultType.equals(that.resultType) : that.resultType != null) return false;
        if (unit != null ? !unit.equals(that.unit) : that.unit != null) return false;
        if (refrenceRange != null ? !refrenceRange.equals(that.refrenceRange) : that.refrenceRange != null)
            return false;
        if (refrenceRangeMin != null ? !refrenceRangeMin.equals(that.refrenceRangeMin) : that.refrenceRangeMin != null)
            return false;
        if (refrenceRangeMax != null ? !refrenceRangeMax.equals(that.refrenceRangeMax) : that.refrenceRangeMax != null)
            return false;
        if (detectionMethod != null ? !detectionMethod.equals(that.detectionMethod) : that.detectionMethod != null)
            return false;
        if (reagentBrand != null ? !reagentBrand.equals(that.reagentBrand) : that.reagentBrand != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (rawDetectionItemCode != null ? !rawDetectionItemCode.equals(that.rawDetectionItemCode) : that.rawDetectionItemCode != null)
            return false;
        if (mainId != null ? !mainId.equals(that.mainId) : that.mainId != null) return false;
        if (detailId != null ? !detailId.equals(that.detailId) : that.detailId != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detectionDetailId != null ? detectionDetailId.hashCode() : 0;
        result = 31 * result + (detectionReportId != null ? detectionReportId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (seqNo != null ? seqNo.hashCode() : 0);
        result = 31 * result + (detectionTypeName != null ? detectionTypeName.hashCode() : 0);
        result = 31 * result + (detectionItemId != null ? detectionItemId.hashCode() : 0);
        result = 31 * result + (detectionItemCode != null ? detectionItemCode.hashCode() : 0);
        result = 31 * result + (detectionItemName != null ? detectionItemName.hashCode() : 0);
        result = 31 * result + (detectionItemEnglishName != null ? detectionItemEnglishName.hashCode() : 0);
        result = 31 * result + (detectionResult != null ? detectionResult.hashCode() : 0);
        result = 31 * result + (prompt != null ? prompt.hashCode() : 0);
        result = 31 * result + (promptType != null ? promptType.hashCode() : 0);
        result = 31 * result + (resultType != null ? resultType.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (refrenceRange != null ? refrenceRange.hashCode() : 0);
        result = 31 * result + (refrenceRangeMin != null ? refrenceRangeMin.hashCode() : 0);
        result = 31 * result + (refrenceRangeMax != null ? refrenceRangeMax.hashCode() : 0);
        result = 31 * result + (detectionMethod != null ? detectionMethod.hashCode() : 0);
        result = 31 * result + (reagentBrand != null ? reagentBrand.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (rawDetectionItemCode != null ? rawDetectionItemCode.hashCode() : 0);
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (detailId != null ? detailId.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
//
//    @ManyToOne
//    @JoinColumn(name = "detectionReportId", referencedColumnName = "detectionReportId", nullable = false)
//    public EciDetectionReport getEciDetectionReportByDetectionReportId() {
//        return eciDetectionReportByDetectionReportId;
//    }
//
//    public void setEciDetectionReportByDetectionReportId(EciDetectionReport eciDetectionReportByDetectionReportId) {
//        this.eciDetectionReportByDetectionReportId = eciDetectionReportByDetectionReportId;
//    }
}
