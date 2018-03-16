package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_detection_report", schema = "lis_db",catalog="")
//@Audited
//@AuditTable(value = "eci_detection_report_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciDetectionReport {
    private String detectionReportId;
    private String emrId;
    private Long patientId;
    private String patientUuid;
    private String patientNo;
    private Integer inhospitalTimes;
    private String patientIdno;
    private String patientAddress;
    private String patientMobile;
    private Integer patientSex;
    private Integer patientAge;
    private Timestamp patientBirth;
    private String patientName;
    private String wardArea;
    private String bedNo;
    private Integer outPatientFlag;
    private Integer hospitalId;
    private Integer detectionTypeId;
    private Integer detectionChildTypeId;
    private String detectionTypeName;
    private Integer deptId;
    private String deptName;
    private String diagnosis;
    private String sampleNo;
    private String sampleName;
    private String sampleType;
    private Integer sampleState;
    private String instrument;
    private Long applyDoctorId;
    private String applyDoctorNo;
    private String applyDoctorName;
    private Long operateDoctorId;
    private String operateDoctorNo;
    private String operateDoctorName;
    private Long reportDoctorId;
    private String reportDoctorNo;
    private String reportDoctorName;
    private Long auditDoctorId;
    private String auditDoctorNo;
    private String auditDoctorName;
    private String remark;
    private Integer readFlag;
    private Timestamp applyTime;
    private Timestamp sampleTime;
    private Timestamp acceptTime;
    private Timestamp reportTime;
    private Integer state;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp syncTime;
    private Integer syncFlag;
    private Integer rawDetectionTypeId;
    private Integer rawDetectionChildTypeId;
    private Long mainId;
    private Timestamp rawCreateTime;
//    private Collection<EciDetectionDetail> eciDetectionDetailsByDetectionReportId;
//    private EMedicalRecord eMedicalRecordByEmrId;

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
    @Column(name = "detectionReportId", nullable = false, length = 128)
    public String getDetectionReportId() {
        return detectionReportId;
    }

    public void setDetectionReportId(String detectionReportId) {
        this.detectionReportId = detectionReportId;
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
    @Column(name = "inhospitalTimes", nullable = true)
    public Integer getInhospitalTimes() {
        return inhospitalTimes;
    }

    public void setInhospitalTimes(Integer inhospitalTimes) {
        this.inhospitalTimes = inhospitalTimes;
    }

    @Basic
    @Column(name = "patientIdno", nullable = true, length = 30)
    public String getPatientIdno() {
        return patientIdno;
    }

    public void setPatientIdno(String patientIdno) {
        this.patientIdno = patientIdno;
    }

    @Basic
    @Column(name = "patientAddress", nullable = true, length = 255)
    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    @Basic
    @Column(name = "patientMobile", nullable = true, length = 30)
    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
    }

    @Basic
    @Column(name = "patientSex", nullable = true)
    public Integer getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Integer patientSex) {
        this.patientSex = patientSex;
    }

    @Basic
    @Column(name = "patientAge", nullable = true)
    public Integer getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(Integer patientAge) {
        this.patientAge = patientAge;
    }

    @Basic
    @Column(name = "patientBirth", nullable = true)
    public Timestamp getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Timestamp patientBirth) {
        this.patientBirth = patientBirth;
    }

    @Basic
    @Column(name = "patientName", nullable = true, length = 50)
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Basic
    @Column(name = "wardArea", nullable = true, length = 100)
    public String getWardArea() {
        return wardArea;
    }

    public void setWardArea(String wardArea) {
        this.wardArea = wardArea;
    }

    @Basic
    @Column(name = "bedNo", nullable = true, length = 30)
    public String getBedNo() {
        return bedNo;
    }

    public void setBedNo(String bedNo) {
        this.bedNo = bedNo;
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
    @Column(name = "hospitalId", nullable = true)
    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    @Basic
    @Column(name = "detectionTypeId", nullable = true)
    public Integer getDetectionTypeId() {
        return detectionTypeId;
    }

    public void setDetectionTypeId(Integer detectionTypeId) {
        this.detectionTypeId = detectionTypeId;
    }

    @Basic
    @Column(name = "detectionChildTypeId", nullable = true)
    public Integer getDetectionChildTypeId() {
        return detectionChildTypeId;
    }

    public void setDetectionChildTypeId(Integer detectionChildTypeId) {
        this.detectionChildTypeId = detectionChildTypeId;
    }

    @Basic
    @Column(name = "detectionTypeName", nullable = false, length = 100)
    public String getDetectionTypeName() {
        return detectionTypeName;
    }

    public void setDetectionTypeName(String detectionTypeName) {
        this.detectionTypeName = detectionTypeName;
    }

    @Basic
    @Column(name = "deptId", nullable = true)
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Basic
    @Column(name = "deptName", nullable = true, length = 30)
    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Basic
    @Column(name = "diagnosis", nullable = true, length = 300)
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    @Basic
    @Column(name = "sampleNo", nullable = true, length = 20)
    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    @Basic
    @Column(name = "sampleName", nullable = true, length = 100)
    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    @Basic
    @Column(name = "sampleType", nullable = true, length = 30)
    public String getSampleType() {
        return sampleType;
    }

    public void setSampleType(String sampleType) {
        this.sampleType = sampleType;
    }

    @Basic
    @Column(name = "sampleState", nullable = true)
    public Integer getSampleState() {
        return sampleState;
    }

    public void setSampleState(Integer sampleState) {
        this.sampleState = sampleState;
    }

    @Basic
    @Column(name = "instrument", nullable = true, length = 128)
    public String getInstrument() {
        return instrument;
    }

    public void setInstrument(String instrument) {
        this.instrument = instrument;
    }

    @Basic
    @Column(name = "applyDoctorId", nullable = true)
    public Long getApplyDoctorId() {
        return applyDoctorId;
    }

    public void setApplyDoctorId(Long applyDoctorId) {
        this.applyDoctorId = applyDoctorId;
    }

    @Basic
    @Column(name = "applyDoctorNo", nullable = true, length = 30)
    public String getApplyDoctorNo() {
        return applyDoctorNo;
    }

    public void setApplyDoctorNo(String applyDoctorNo) {
        this.applyDoctorNo = applyDoctorNo;
    }

    @Basic
    @Column(name = "applyDoctorName", nullable = true, length = 50)
    public String getApplyDoctorName() {
        return applyDoctorName;
    }

    public void setApplyDoctorName(String applyDoctorName) {
        this.applyDoctorName = applyDoctorName;
    }

    @Basic
    @Column(name = "operateDoctorId", nullable = true)
    public Long getOperateDoctorId() {
        return operateDoctorId;
    }

    public void setOperateDoctorId(Long operateDoctorId) {
        this.operateDoctorId = operateDoctorId;
    }

    @Basic
    @Column(name = "operateDoctorNo", nullable = true, length = 30)
    public String getOperateDoctorNo() {
        return operateDoctorNo;
    }

    public void setOperateDoctorNo(String operateDoctorNo) {
        this.operateDoctorNo = operateDoctorNo;
    }

    @Basic
    @Column(name = "operateDoctorName", nullable = true, length = 50)
    public String getOperateDoctorName() {
        return operateDoctorName;
    }

    public void setOperateDoctorName(String operateDoctorName) {
        this.operateDoctorName = operateDoctorName;
    }

    @Basic
    @Column(name = "reportDoctorId", nullable = true)
    public Long getReportDoctorId() {
        return reportDoctorId;
    }

    public void setReportDoctorId(Long reportDoctorId) {
        this.reportDoctorId = reportDoctorId;
    }

    @Basic
    @Column(name = "reportDoctorNo", nullable = true, length = 30)
    public String getReportDoctorNo() {
        return reportDoctorNo;
    }

    public void setReportDoctorNo(String reportDoctorNo) {
        this.reportDoctorNo = reportDoctorNo;
    }

    @Basic
    @Column(name = "reportDoctorName", nullable = true, length = 50)
    public String getReportDoctorName() {
        return reportDoctorName;
    }

    public void setReportDoctorName(String reportDoctorName) {
        this.reportDoctorName = reportDoctorName;
    }

    @Basic
    @Column(name = "auditDoctorId", nullable = true)
    public Long getAuditDoctorId() {
        return auditDoctorId;
    }

    public void setAuditDoctorId(Long auditDoctorId) {
        this.auditDoctorId = auditDoctorId;
    }

    @Basic
    @Column(name = "auditDoctorNo", nullable = true, length = 30)
    public String getAuditDoctorNo() {
        return auditDoctorNo;
    }

    public void setAuditDoctorNo(String auditDoctorNo) {
        this.auditDoctorNo = auditDoctorNo;
    }

    @Basic
    @Column(name = "auditDoctorName", nullable = true, length = 50)
    public String getAuditDoctorName() {
        return auditDoctorName;
    }

    public void setAuditDoctorName(String auditDoctorName) {
        this.auditDoctorName = auditDoctorName;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 255)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "readFlag", nullable = true)
    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    @Basic
    @Column(name = "applyTime", nullable = false)
    public Timestamp getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Timestamp applyTime) {
        this.applyTime = applyTime;
    }

    @Basic
    @Column(name = "sampleTime", nullable = true)
    public Timestamp getSampleTime() {
        return sampleTime;
    }

    public void setSampleTime(Timestamp sampleTime) {
        this.sampleTime = sampleTime;
    }

    @Basic
    @Column(name = "acceptTime", nullable = true)
    public Timestamp getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Timestamp acceptTime) {
        this.acceptTime = acceptTime;
    }

    @Basic
    @Column(name = "reportTime", nullable = false)
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    @Column(name = "rawDetectionTypeId", nullable = true)
    public Integer getRawDetectionTypeId() {
        return rawDetectionTypeId;
    }

    public void setRawDetectionTypeId(Integer rawDetectionTypeId) {
        this.rawDetectionTypeId = rawDetectionTypeId;
    }

    @Basic
    @Column(name = "rawDetectionChildTypeId", nullable = true)
    public Integer getRawDetectionChildTypeId() {
        return rawDetectionChildTypeId;
    }

    public void setRawDetectionChildTypeId(Integer rawDetectionChildTypeId) {
        this.rawDetectionChildTypeId = rawDetectionChildTypeId;
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

        EciDetectionReport that = (EciDetectionReport) o;

        if (detectionReportId != null ? !detectionReportId.equals(that.detectionReportId) : that.detectionReportId != null)
            return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (patientIdno != null ? !patientIdno.equals(that.patientIdno) : that.patientIdno != null) return false;
        if (patientAddress != null ? !patientAddress.equals(that.patientAddress) : that.patientAddress != null)
            return false;
        if (patientMobile != null ? !patientMobile.equals(that.patientMobile) : that.patientMobile != null)
            return false;
        if (patientSex != null ? !patientSex.equals(that.patientSex) : that.patientSex != null) return false;
        if (patientAge != null ? !patientAge.equals(that.patientAge) : that.patientAge != null) return false;
        if (patientBirth != null ? !patientBirth.equals(that.patientBirth) : that.patientBirth != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (wardArea != null ? !wardArea.equals(that.wardArea) : that.wardArea != null) return false;
        if (bedNo != null ? !bedNo.equals(that.bedNo) : that.bedNo != null) return false;
        if (outPatientFlag != null ? !outPatientFlag.equals(that.outPatientFlag) : that.outPatientFlag != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (detectionTypeId != null ? !detectionTypeId.equals(that.detectionTypeId) : that.detectionTypeId != null)
            return false;
        if (detectionChildTypeId != null ? !detectionChildTypeId.equals(that.detectionChildTypeId) : that.detectionChildTypeId != null)
            return false;
        if (detectionTypeName != null ? !detectionTypeName.equals(that.detectionTypeName) : that.detectionTypeName != null)
            return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (diagnosis != null ? !diagnosis.equals(that.diagnosis) : that.diagnosis != null) return false;
        if (sampleNo != null ? !sampleNo.equals(that.sampleNo) : that.sampleNo != null) return false;
        if (sampleName != null ? !sampleName.equals(that.sampleName) : that.sampleName != null) return false;
        if (sampleType != null ? !sampleType.equals(that.sampleType) : that.sampleType != null) return false;
        if (sampleState != null ? !sampleState.equals(that.sampleState) : that.sampleState != null) return false;
        if (instrument != null ? !instrument.equals(that.instrument) : that.instrument != null) return false;
        if (applyDoctorId != null ? !applyDoctorId.equals(that.applyDoctorId) : that.applyDoctorId != null)
            return false;
        if (applyDoctorNo != null ? !applyDoctorNo.equals(that.applyDoctorNo) : that.applyDoctorNo != null)
            return false;
        if (applyDoctorName != null ? !applyDoctorName.equals(that.applyDoctorName) : that.applyDoctorName != null)
            return false;
        if (operateDoctorId != null ? !operateDoctorId.equals(that.operateDoctorId) : that.operateDoctorId != null)
            return false;
        if (operateDoctorNo != null ? !operateDoctorNo.equals(that.operateDoctorNo) : that.operateDoctorNo != null)
            return false;
        if (operateDoctorName != null ? !operateDoctorName.equals(that.operateDoctorName) : that.operateDoctorName != null)
            return false;
        if (reportDoctorId != null ? !reportDoctorId.equals(that.reportDoctorId) : that.reportDoctorId != null)
            return false;
        if (reportDoctorNo != null ? !reportDoctorNo.equals(that.reportDoctorNo) : that.reportDoctorNo != null)
            return false;
        if (reportDoctorName != null ? !reportDoctorName.equals(that.reportDoctorName) : that.reportDoctorName != null)
            return false;
        if (auditDoctorId != null ? !auditDoctorId.equals(that.auditDoctorId) : that.auditDoctorId != null)
            return false;
        if (auditDoctorNo != null ? !auditDoctorNo.equals(that.auditDoctorNo) : that.auditDoctorNo != null)
            return false;
        if (auditDoctorName != null ? !auditDoctorName.equals(that.auditDoctorName) : that.auditDoctorName != null)
            return false;
        if (remark != null ? !remark.equals(that.remark) : that.remark != null) return false;
        if (readFlag != null ? !readFlag.equals(that.readFlag) : that.readFlag != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (sampleTime != null ? !sampleTime.equals(that.sampleTime) : that.sampleTime != null) return false;
        if (acceptTime != null ? !acceptTime.equals(that.acceptTime) : that.acceptTime != null) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (rawDetectionTypeId != null ? !rawDetectionTypeId.equals(that.rawDetectionTypeId) : that.rawDetectionTypeId != null)
            return false;
        if (rawDetectionChildTypeId != null ? !rawDetectionChildTypeId.equals(that.rawDetectionChildTypeId) : that.rawDetectionChildTypeId != null)
            return false;
        if (mainId != null ? !mainId.equals(that.mainId) : that.mainId != null) return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = detectionReportId != null ? detectionReportId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (patientIdno != null ? patientIdno.hashCode() : 0);
        result = 31 * result + (patientAddress != null ? patientAddress.hashCode() : 0);
        result = 31 * result + (patientMobile != null ? patientMobile.hashCode() : 0);
        result = 31 * result + (patientSex != null ? patientSex.hashCode() : 0);
        result = 31 * result + (patientAge != null ? patientAge.hashCode() : 0);
        result = 31 * result + (patientBirth != null ? patientBirth.hashCode() : 0);
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + (wardArea != null ? wardArea.hashCode() : 0);
        result = 31 * result + (bedNo != null ? bedNo.hashCode() : 0);
        result = 31 * result + (outPatientFlag != null ? outPatientFlag.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (detectionTypeId != null ? detectionTypeId.hashCode() : 0);
        result = 31 * result + (detectionChildTypeId != null ? detectionChildTypeId.hashCode() : 0);
        result = 31 * result + (detectionTypeName != null ? detectionTypeName.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (diagnosis != null ? diagnosis.hashCode() : 0);
        result = 31 * result + (sampleNo != null ? sampleNo.hashCode() : 0);
        result = 31 * result + (sampleName != null ? sampleName.hashCode() : 0);
        result = 31 * result + (sampleType != null ? sampleType.hashCode() : 0);
        result = 31 * result + (sampleState != null ? sampleState.hashCode() : 0);
        result = 31 * result + (instrument != null ? instrument.hashCode() : 0);
        result = 31 * result + (applyDoctorId != null ? applyDoctorId.hashCode() : 0);
        result = 31 * result + (applyDoctorNo != null ? applyDoctorNo.hashCode() : 0);
        result = 31 * result + (applyDoctorName != null ? applyDoctorName.hashCode() : 0);
        result = 31 * result + (operateDoctorId != null ? operateDoctorId.hashCode() : 0);
        result = 31 * result + (operateDoctorNo != null ? operateDoctorNo.hashCode() : 0);
        result = 31 * result + (operateDoctorName != null ? operateDoctorName.hashCode() : 0);
        result = 31 * result + (reportDoctorId != null ? reportDoctorId.hashCode() : 0);
        result = 31 * result + (reportDoctorNo != null ? reportDoctorNo.hashCode() : 0);
        result = 31 * result + (reportDoctorName != null ? reportDoctorName.hashCode() : 0);
        result = 31 * result + (auditDoctorId != null ? auditDoctorId.hashCode() : 0);
        result = 31 * result + (auditDoctorNo != null ? auditDoctorNo.hashCode() : 0);
        result = 31 * result + (auditDoctorName != null ? auditDoctorName.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (readFlag != null ? readFlag.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (sampleTime != null ? sampleTime.hashCode() : 0);
        result = 31 * result + (acceptTime != null ? acceptTime.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (rawDetectionTypeId != null ? rawDetectionTypeId.hashCode() : 0);
        result = 31 * result + (rawDetectionChildTypeId != null ? rawDetectionChildTypeId.hashCode() : 0);
        result = 31 * result + (mainId != null ? mainId.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }

//    @OneToMany(mappedBy = "eciDetectionReportByDetectionReportId")
//    public Collection<EciDetectionDetail> getEciDetectionDetailsByDetectionReportId() {
//        return eciDetectionDetailsByDetectionReportId;
//    }
//
//    public void setEciDetectionDetailsByDetectionReportId(Collection<EciDetectionDetail> eciDetectionDetailsByDetectionReportId) {
//        this.eciDetectionDetailsByDetectionReportId = eciDetectionDetailsByDetectionReportId;
//    }
//
//    @ManyToOne
//    @JoinColumn(name = "emrId", referencedColumnName = "emrId", nullable = false)
//    public EMedicalRecord geteMedicalRecordByEmrId() {
//        return eMedicalRecordByEmrId;
//    }
//
//    public void seteMedicalRecordByEmrId(EMedicalRecord eMedicalRecordByEmrId) {
//        this.eMedicalRecordByEmrId = eMedicalRecordByEmrId;
//    }
}
