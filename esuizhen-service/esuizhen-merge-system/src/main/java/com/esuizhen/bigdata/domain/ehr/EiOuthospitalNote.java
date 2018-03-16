package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "ei_outhospital_note", schema = "ehr_db",catalog="")
//@Audited
//@AuditTable(value = "ei_outhospital_note_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EiOuthospitalNote {
    private String outhospitalId;
    private String mainId;
    private Integer tempId;
    private String inhospitalId;
    private String inhospitalNo;
    private Integer inhospitalTimes;
    private String emrId;
    private Long patientId;
    private String patientNo;
    private String oldPatientNo;
    private Integer oldInhospitalTimes;
    private Integer hospitalId;
    private Timestamp inhospitalDate;
    private Timestamp outhospitalDate;
    private Integer inhospitalDays;
    private String treatmentResult;
    private String symptomSummary;
    private String inhospitalDiagnosis;
    private String treatmentSummary;
    private String outhospitalDiagnosis;
    private String outhospitalSummary;
    private String outhospitalDoctorAdvice;
    private String summaryContent;
    private String rawContent;
    private Integer contentType;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Integer handleFlag;
    private Integer syncFlag;
    private Timestamp rawCreateTime;

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
    @Column(name = "outhospitalId", nullable = false, length = 128)
    public String getOuthospitalId() {
        return outhospitalId;
    }

    public void setOuthospitalId(String outhospitalId) {
        this.outhospitalId = outhospitalId;
    }

    @Basic
    @Column(name = "mainID", nullable = true, length = 128)
    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
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
    @Column(name = "inhospitalId", nullable = true, length = 128)
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
    @Column(name = "inhospitalTimes", nullable = true)
    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    @Basic
    @Column(name = "emrId", nullable = false, length = 128)
    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId;
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
    @Column(name = "patientNo", nullable = false, length = 128)
    public String getPatientNo() {
        return patientNo;
    }

    public void setPatientNo(String patientNo) {
        this.patientNo = patientNo;
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
    @Column(name = "inhospitalDate", nullable = true)
    public Timestamp getInhospitalDate() {
        return inhospitalDate;
    }

    public void setInhospitalDate(Timestamp inhospitalDate) {
        this.inhospitalDate = inhospitalDate;
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
    @Column(name = "inhospitalDays", nullable = true)
    public Integer getInhospitalDays() {
        return inhospitalDays;
    }

    public void setInhospitalDays(Integer inhospitalDays) {
        this.inhospitalDays = inhospitalDays;
    }

    @Basic
    @Column(name = "treatmentResult", nullable = true, length = 100)
    public String getTreatmentResult() {
        return treatmentResult;
    }

    public void setTreatmentResult(String treatmentResult) {
        this.treatmentResult = treatmentResult;
    }

    @Basic
    @Column(name = "symptomSummary", nullable = true, length = 4096)
    public String getSymptomSummary() {
        return symptomSummary;
    }

    public void setSymptomSummary(String symptomSummary) {
        this.symptomSummary = symptomSummary;
    }

    @Basic
    @Column(name = "inhospitalDiagnosis", nullable = true, length = 300)
    public String getInhospitalDiagnosis() {
        return inhospitalDiagnosis;
    }

    public void setInhospitalDiagnosis(String inhospitalDiagnosis) {
        this.inhospitalDiagnosis = inhospitalDiagnosis;
    }

    @Basic
    @Column(name = "treatmentSummary", nullable = true, length = 4096)
    public String getTreatmentSummary() {
        return treatmentSummary;
    }

    public void setTreatmentSummary(String treatmentSummary) {
        this.treatmentSummary = treatmentSummary;
    }

    @Basic
    @Column(name = "outhospitalDiagnosis", nullable = true, length = 300)
    public String getOuthospitalDiagnosis() {
        return outhospitalDiagnosis;
    }

    public void setOuthospitalDiagnosis(String outhospitalDiagnosis) {
        this.outhospitalDiagnosis = outhospitalDiagnosis;
    }

    @Basic
    @Column(name = "outhospitalSummary", nullable = true, length = 4096)
    public String getOuthospitalSummary() {
        return outhospitalSummary;
    }

    public void setOuthospitalSummary(String outhospitalSummary) {
        this.outhospitalSummary = outhospitalSummary;
    }

    @Basic
    @Column(name = "outhospitalDoctorAdvice", nullable = true, length = 4096)
    public String getOuthospitalDoctorAdvice() {
        return outhospitalDoctorAdvice;
    }

    public void setOuthospitalDoctorAdvice(String outhospitalDoctorAdvice) {
        this.outhospitalDoctorAdvice = outhospitalDoctorAdvice;
    }

    @Basic
    @Column(columnDefinition = "TEXT",name = "summaryContent", nullable = true)
    public String getSummaryContent() {
        return summaryContent;
    }

    public void setSummaryContent(String summaryContent) {
        this.summaryContent = summaryContent;
    }

    @Basic
    @Column(columnDefinition = "TEXT",name = "rawContent", nullable = true)
//    @Column(name = "rawContent", nullable = true, length = -1)
    public String getRawContent() {
        return rawContent;
    }

    public void setRawContent(String rawContent) {
        this.rawContent = rawContent;
    }

    @Basic
    @Column(name = "contentType", nullable = true)
    public Integer getContentType() {
        return contentType;
    }

    public void setContentType(Integer contentType) {
        this.contentType = contentType;
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
    @Column(name = "handleFlag", nullable = true)
    public Integer getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(Integer handleFlag) {
        this.handleFlag = handleFlag;
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

        EiOuthospitalNote that = (EiOuthospitalNote) o;

        if (outhospitalId != null ? !outhospitalId.equals(that.outhospitalId) : that.outhospitalId != null)
            return false;
        if (mainId != null ? !mainId.equals(that.mainId) : that.mainId != null) return false;
        if (tempId != null ? !tempId.equals(that.tempId) : that.tempId != null) return false;
        if (inhospitalId != null ? !inhospitalId.equals(that.inhospitalId) : that.inhospitalId != null) return false;
        if (inhospitalNo != null ? !inhospitalNo.equals(that.inhospitalNo) : that.inhospitalNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (oldPatientNo != null ? !oldPatientNo.equals(that.oldPatientNo) : that.oldPatientNo != null) return false;
        if (oldInhospitalTimes != null ? !oldInhospitalTimes.equals(that.oldInhospitalTimes) : that.oldInhospitalTimes != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (inhospitalDate != null ? !inhospitalDate.equals(that.inhospitalDate) : that.inhospitalDate != null)
            return false;
        if (outhospitalDate != null ? !outhospitalDate.equals(that.outhospitalDate) : that.outhospitalDate != null)
            return false;
        if (inhospitalDays != null ? !inhospitalDays.equals(that.inhospitalDays) : that.inhospitalDays != null)
            return false;
        if (treatmentResult != null ? !treatmentResult.equals(that.treatmentResult) : that.treatmentResult != null)
            return false;
        if (symptomSummary != null ? !symptomSummary.equals(that.symptomSummary) : that.symptomSummary != null)
            return false;
        if (inhospitalDiagnosis != null ? !inhospitalDiagnosis.equals(that.inhospitalDiagnosis) : that.inhospitalDiagnosis != null)
            return false;
        if (treatmentSummary != null ? !treatmentSummary.equals(that.treatmentSummary) : that.treatmentSummary != null)
            return false;
        if (outhospitalDiagnosis != null ? !outhospitalDiagnosis.equals(that.outhospitalDiagnosis) : that.outhospitalDiagnosis != null)
            return false;
        if (outhospitalSummary != null ? !outhospitalSummary.equals(that.outhospitalSummary) : that.outhospitalSummary != null)
            return false;
        if (outhospitalDoctorAdvice != null ? !outhospitalDoctorAdvice.equals(that.outhospitalDoctorAdvice) : that.outhospitalDoctorAdvice != null)
            return false;
        if (summaryContent != null ? !summaryContent.equals(that.summaryContent) : that.summaryContent != null)
            return false;
        if (rawContent != null ? !rawContent.equals(that.rawContent) : that.rawContent != null) return false;
        if (contentType != null ? !contentType.equals(that.contentType) : that.contentType != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (handleFlag != null ? !handleFlag.equals(that.handleFlag) : that.handleFlag != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = outhospitalId != null ? outhospitalId.hashCode() : 0;
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (tempId != null ? tempId.hashCode() : 0);
        result = 31 * result + (inhospitalId != null ? inhospitalId.hashCode() : 0);
        result = 31 * result + (inhospitalNo != null ? inhospitalNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (oldPatientNo != null ? oldPatientNo.hashCode() : 0);
        result = 31 * result + (oldInhospitalTimes != null ? oldInhospitalTimes.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (inhospitalDate != null ? inhospitalDate.hashCode() : 0);
        result = 31 * result + (outhospitalDate != null ? outhospitalDate.hashCode() : 0);
        result = 31 * result + (inhospitalDays != null ? inhospitalDays.hashCode() : 0);
        result = 31 * result + (treatmentResult != null ? treatmentResult.hashCode() : 0);
        result = 31 * result + (symptomSummary != null ? symptomSummary.hashCode() : 0);
        result = 31 * result + (inhospitalDiagnosis != null ? inhospitalDiagnosis.hashCode() : 0);
        result = 31 * result + (treatmentSummary != null ? treatmentSummary.hashCode() : 0);
        result = 31 * result + (outhospitalDiagnosis != null ? outhospitalDiagnosis.hashCode() : 0);
        result = 31 * result + (outhospitalSummary != null ? outhospitalSummary.hashCode() : 0);
        result = 31 * result + (outhospitalDoctorAdvice != null ? outhospitalDoctorAdvice.hashCode() : 0);
        result = 31 * result + (summaryContent != null ? summaryContent.hashCode() : 0);
        result = 31 * result + (rawContent != null ? rawContent.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (handleFlag != null ? handleFlag.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }
}
