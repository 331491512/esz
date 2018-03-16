package com.esuizhen.bigdata.domain.ehr;



import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fqc on 16/12/5.
 */
@Entity
@Table(name = "eci_exam_report", schema = "lis_db",catalog="")
//@Audited
//@AuditTable(value = "eci_exam_report_audit",schema = "ehr_db_audit",catalog = "ehr_db_audit")
public class EciExamReport {
    private String examReportId;
    private String emrId;
    private Long patientId;
    private String patientName;
    private String patientNo;
    private Integer inhospitalTimes;
    private String patientUuid;
    private Integer outPatientFlag;
    private Integer hospitalId;
    private Integer examTypeId;
    private Integer examChildTypeId;
    private String examTypeName;
    private Integer deptId;
    private String deptName;
    private String reportTitle;
    private String scanningTechnique;
    private Integer examWay;
    private String obtainWay;
    private String organCode;
    private String organ;
    private String bodyCode;
    private String bodyPart;
    private String nidusCode;
    private String nidus;
    private Integer nidusSourceFlag;
    private Double longestDiameter;
    private Double shortestDiameter;
    private String examFinding;
    private String examConclusion;
    private Integer hasImage;
    private String picFileUrls;
    private String imageFileFormat;
    private Integer applyDoctorId;
    private String applyDoctorUuid;
    private String applyDoctorNo;
    private String applyDoctorName;
    private Integer reportDoctorId;
    private String reportDoctorNo;
    private String reportDoctorName;
    private Integer state;
    private Integer readFlag;
    private Timestamp applyTime;
    private Timestamp excuteTime;
    private Timestamp reportTime;
    private Timestamp createTime;
    private Timestamp updateTime;
    private Timestamp syncTime;
    private Integer syncFlag;
    private Integer patientSex;
    private Timestamp patientBirth;
    private String patientIdno;
    private String patientMobile;
    private String patientAddress;
    private String examConclusionRtf;
    private Timestamp rawCreateTime;
//    private EMedicalRecord eMedicalRecordByEmrId;

    private Integer mergeFlag;
    private Long mergeFrom;
    private Long mergeTarget;
    private Timestamp mergeTime;

    private Integer ID;

    @Basic
    @Column(name = "ID", nullable = false)
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    @Id
    @Column(name = "examReportId", nullable = false, length = 128)
    public String getExamReportId() {
        return examReportId;
    }

    public void setExamReportId(String examReportId) {
        this.examReportId = examReportId;
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
    @Column(name = "patientName", nullable = false, length = 50)
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Basic
    @Column(name = "patientNo", nullable = false, length = 30)
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
    @Column(name = "patientUuid", nullable = true, length = 32)
    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid;
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
    @Column(name = "examTypeId", nullable = false)
    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    @Basic
    @Column(name = "examChildTypeId", nullable = true)
    public Integer getExamChildTypeId() {
        return examChildTypeId;
    }

    public void setExamChildTypeId(Integer examChildTypeId) {
        this.examChildTypeId = examChildTypeId;
    }

    @Basic
    @Column(name = "examTypeName", nullable = false, length = 100)
    public String getExamTypeName() {
        return examTypeName;
    }

    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName;
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
    @Column(name = "reportTitle", nullable = true, length = 50)
    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    @Basic
    @Column(name = "scanningTechnique", nullable = true, length = 50)
    public String getScanningTechnique() {
        return scanningTechnique;
    }

    public void setScanningTechnique(String scanningTechnique) {
        this.scanningTechnique = scanningTechnique;
    }

    @Basic
    @Column(name = "examWay", nullable = true)
    public Integer getExamWay() {
        return examWay;
    }

    public void setExamWay(Integer examWay) {
        this.examWay = examWay;
    }

    @Basic
    @Column(name = "obtainWay", nullable = true, length = 30)
    public String getObtainWay() {
        return obtainWay;
    }

    public void setObtainWay(String obtainWay) {
        this.obtainWay = obtainWay;
    }

    @Basic
    @Column(name = "organCode", nullable = true, length = 30)
    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode;
    }

    @Basic
    @Column(name = "organ", nullable = true, length = 50)
    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }

    @Basic
    @Column(name = "bodyCode", nullable = true, length = 30)
    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    @Basic
    @Column(name = "bodyPart", nullable = true, length = 50)
    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Basic
    @Column(name = "nidusCode", nullable = true, length = 30)
    public String getNidusCode() {
        return nidusCode;
    }

    public void setNidusCode(String nidusCode) {
        this.nidusCode = nidusCode;
    }

    @Basic
    @Column(name = "nidus", nullable = true, length = 50)
    public String getNidus() {
        return nidus;
    }

    public void setNidus(String nidus) {
        this.nidus = nidus;
    }

    @Basic
    @Column(name = "nidusSourceFlag", nullable = true)
    public Integer getNidusSourceFlag() {
        return nidusSourceFlag;
    }

    public void setNidusSourceFlag(Integer nidusSourceFlag) {
        this.nidusSourceFlag = nidusSourceFlag;
    }

    @Basic
    @Column(name = "longestDiameter", nullable = true, precision = 0)
    public Double getLongestDiameter() {
        return longestDiameter;
    }

    public void setLongestDiameter(Double longestDiameter) {
        this.longestDiameter = longestDiameter;
    }

    @Basic
    @Column(name = "shortestDiameter", nullable = true, precision = 0)
    public Double getShortestDiameter() {
        return shortestDiameter;
    }

    public void setShortestDiameter(Double shortestDiameter) {
        this.shortestDiameter = shortestDiameter;
    }

    @Basic
    @Column(name = "examFinding", nullable = false, length = 4096)
    public String getExamFinding() {
        return examFinding;
    }

    public void setExamFinding(String examFinding) {
        this.examFinding = examFinding;
    }

    @Basic
    @Column(name = "examConclusion", nullable = false, length = 4096)
    public String getExamConclusion() {
        return examConclusion;
    }

    public void setExamConclusion(String examConclusion) {
        this.examConclusion = examConclusion;
    }

    @Basic
    @Column(name = "hasImage", nullable = true)
    public Integer getHasImage() {
        return hasImage;
    }

    public void setHasImage(Integer hasImage) {
        this.hasImage = hasImage;
    }

    @Basic
    @Column(name = "picFileUrls", nullable = true, length = 512)
    public String getPicFileUrls() {
        return picFileUrls;
    }

    public void setPicFileUrls(String picFileUrls) {
        this.picFileUrls = picFileUrls;
    }

    @Basic
    @Column(name = "imageFileFormat", nullable = true, length = 20)
    public String getImageFileFormat() {
        return imageFileFormat;
    }

    public void setImageFileFormat(String imageFileFormat) {
        this.imageFileFormat = imageFileFormat;
    }

    @Basic
    @Column(name = "applyDoctorId", nullable = true)
    public Integer getApplyDoctorId() {
        return applyDoctorId;
    }

    public void setApplyDoctorId(Integer applyDoctorId) {
        this.applyDoctorId = applyDoctorId;
    }

    @Basic
    @Column(name = "applyDoctorUuid", nullable = true, length = 45)
    public String getApplyDoctorUuid() {
        return applyDoctorUuid;
    }

    public void setApplyDoctorUuid(String applyDoctorUuid) {
        this.applyDoctorUuid = applyDoctorUuid;
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
    @Column(name = "reportDoctorId", nullable = true)
    public Integer getReportDoctorId() {
        return reportDoctorId;
    }

    public void setReportDoctorId(Integer reportDoctorId) {
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
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
    @Column(name = "excuteTime", nullable = true)
    public Timestamp getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Timestamp excuteTime) {
        this.excuteTime = excuteTime;
    }

    @Basic
    @Column(name = "reportTime", nullable = true)
    public Timestamp getReportTime() {
        return reportTime;
    }

    public void setReportTime(Timestamp reportTime) {
        this.reportTime = reportTime;
    }

    @Basic
    @Column(name = "createTime", nullable = true)
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
    @Column(name = "syncFlag", nullable = false)
    public Integer getSyncFlag() {
        return syncFlag;
    }

    public void setSyncFlag(Integer syncFlag) {
        this.syncFlag = syncFlag;
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
    @Column(name = "patientBirth", nullable = true)
    public Timestamp getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(Timestamp patientBirth) {
        this.patientBirth = patientBirth;
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
    @Column(name = "patientMobile", nullable = true, length = 30)
    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile;
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
    @Column(name = "examConclusionRtf", nullable = true, length = 4096)
    public String getExamConclusionRtf() {
        return examConclusionRtf;
    }

    public void setExamConclusionRtf(String examConclusionRtf) {
        this.examConclusionRtf = examConclusionRtf;
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

        EciExamReport that = (EciExamReport) o;

        if (examReportId != null ? !examReportId.equals(that.examReportId) : that.examReportId != null) return false;
        if (emrId != null ? !emrId.equals(that.emrId) : that.emrId != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;
        if (patientName != null ? !patientName.equals(that.patientName) : that.patientName != null) return false;
        if (patientNo != null ? !patientNo.equals(that.patientNo) : that.patientNo != null) return false;
        if (inhospitalTimes != null ? !inhospitalTimes.equals(that.inhospitalTimes) : that.inhospitalTimes != null)
            return false;
        if (patientUuid != null ? !patientUuid.equals(that.patientUuid) : that.patientUuid != null) return false;
        if (outPatientFlag != null ? !outPatientFlag.equals(that.outPatientFlag) : that.outPatientFlag != null)
            return false;
        if (hospitalId != null ? !hospitalId.equals(that.hospitalId) : that.hospitalId != null) return false;
        if (examTypeId != null ? !examTypeId.equals(that.examTypeId) : that.examTypeId != null) return false;
        if (examChildTypeId != null ? !examChildTypeId.equals(that.examChildTypeId) : that.examChildTypeId != null)
            return false;
        if (examTypeName != null ? !examTypeName.equals(that.examTypeName) : that.examTypeName != null) return false;
        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null) return false;
        if (reportTitle != null ? !reportTitle.equals(that.reportTitle) : that.reportTitle != null) return false;
        if (scanningTechnique != null ? !scanningTechnique.equals(that.scanningTechnique) : that.scanningTechnique != null)
            return false;
        if (examWay != null ? !examWay.equals(that.examWay) : that.examWay != null) return false;
        if (obtainWay != null ? !obtainWay.equals(that.obtainWay) : that.obtainWay != null) return false;
        if (organCode != null ? !organCode.equals(that.organCode) : that.organCode != null) return false;
        if (organ != null ? !organ.equals(that.organ) : that.organ != null) return false;
        if (bodyCode != null ? !bodyCode.equals(that.bodyCode) : that.bodyCode != null) return false;
        if (bodyPart != null ? !bodyPart.equals(that.bodyPart) : that.bodyPart != null) return false;
        if (nidusCode != null ? !nidusCode.equals(that.nidusCode) : that.nidusCode != null) return false;
        if (nidus != null ? !nidus.equals(that.nidus) : that.nidus != null) return false;
        if (nidusSourceFlag != null ? !nidusSourceFlag.equals(that.nidusSourceFlag) : that.nidusSourceFlag != null)
            return false;
        if (longestDiameter != null ? !longestDiameter.equals(that.longestDiameter) : that.longestDiameter != null)
            return false;
        if (shortestDiameter != null ? !shortestDiameter.equals(that.shortestDiameter) : that.shortestDiameter != null)
            return false;
        if (examFinding != null ? !examFinding.equals(that.examFinding) : that.examFinding != null) return false;
        if (examConclusion != null ? !examConclusion.equals(that.examConclusion) : that.examConclusion != null)
            return false;
        if (hasImage != null ? !hasImage.equals(that.hasImage) : that.hasImage != null) return false;
        if (picFileUrls != null ? !picFileUrls.equals(that.picFileUrls) : that.picFileUrls != null) return false;
        if (imageFileFormat != null ? !imageFileFormat.equals(that.imageFileFormat) : that.imageFileFormat != null)
            return false;
        if (applyDoctorId != null ? !applyDoctorId.equals(that.applyDoctorId) : that.applyDoctorId != null)
            return false;
        if (applyDoctorUuid != null ? !applyDoctorUuid.equals(that.applyDoctorUuid) : that.applyDoctorUuid != null)
            return false;
        if (applyDoctorNo != null ? !applyDoctorNo.equals(that.applyDoctorNo) : that.applyDoctorNo != null)
            return false;
        if (applyDoctorName != null ? !applyDoctorName.equals(that.applyDoctorName) : that.applyDoctorName != null)
            return false;
        if (reportDoctorId != null ? !reportDoctorId.equals(that.reportDoctorId) : that.reportDoctorId != null)
            return false;
        if (reportDoctorNo != null ? !reportDoctorNo.equals(that.reportDoctorNo) : that.reportDoctorNo != null)
            return false;
        if (reportDoctorName != null ? !reportDoctorName.equals(that.reportDoctorName) : that.reportDoctorName != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (readFlag != null ? !readFlag.equals(that.readFlag) : that.readFlag != null) return false;
        if (applyTime != null ? !applyTime.equals(that.applyTime) : that.applyTime != null) return false;
        if (excuteTime != null ? !excuteTime.equals(that.excuteTime) : that.excuteTime != null) return false;
        if (reportTime != null ? !reportTime.equals(that.reportTime) : that.reportTime != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;
        if (syncTime != null ? !syncTime.equals(that.syncTime) : that.syncTime != null) return false;
        if (syncFlag != null ? !syncFlag.equals(that.syncFlag) : that.syncFlag != null) return false;
        if (patientSex != null ? !patientSex.equals(that.patientSex) : that.patientSex != null) return false;
        if (patientBirth != null ? !patientBirth.equals(that.patientBirth) : that.patientBirth != null) return false;
        if (patientIdno != null ? !patientIdno.equals(that.patientIdno) : that.patientIdno != null) return false;
        if (patientMobile != null ? !patientMobile.equals(that.patientMobile) : that.patientMobile != null)
            return false;
        if (patientAddress != null ? !patientAddress.equals(that.patientAddress) : that.patientAddress != null)
            return false;
        if (examConclusionRtf != null ? !examConclusionRtf.equals(that.examConclusionRtf) : that.examConclusionRtf != null)
            return false;
        if (rawCreateTime != null ? !rawCreateTime.equals(that.rawCreateTime) : that.rawCreateTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = examReportId != null ? examReportId.hashCode() : 0;
        result = 31 * result + (emrId != null ? emrId.hashCode() : 0);
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        result = 31 * result + (patientName != null ? patientName.hashCode() : 0);
        result = 31 * result + (patientNo != null ? patientNo.hashCode() : 0);
        result = 31 * result + (inhospitalTimes != null ? inhospitalTimes.hashCode() : 0);
        result = 31 * result + (patientUuid != null ? patientUuid.hashCode() : 0);
        result = 31 * result + (outPatientFlag != null ? outPatientFlag.hashCode() : 0);
        result = 31 * result + (hospitalId != null ? hospitalId.hashCode() : 0);
        result = 31 * result + (examTypeId != null ? examTypeId.hashCode() : 0);
        result = 31 * result + (examChildTypeId != null ? examChildTypeId.hashCode() : 0);
        result = 31 * result + (examTypeName != null ? examTypeName.hashCode() : 0);
        result = 31 * result + (deptId != null ? deptId.hashCode() : 0);
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (reportTitle != null ? reportTitle.hashCode() : 0);
        result = 31 * result + (scanningTechnique != null ? scanningTechnique.hashCode() : 0);
        result = 31 * result + (examWay != null ? examWay.hashCode() : 0);
        result = 31 * result + (obtainWay != null ? obtainWay.hashCode() : 0);
        result = 31 * result + (organCode != null ? organCode.hashCode() : 0);
        result = 31 * result + (organ != null ? organ.hashCode() : 0);
        result = 31 * result + (bodyCode != null ? bodyCode.hashCode() : 0);
        result = 31 * result + (bodyPart != null ? bodyPart.hashCode() : 0);
        result = 31 * result + (nidusCode != null ? nidusCode.hashCode() : 0);
        result = 31 * result + (nidus != null ? nidus.hashCode() : 0);
        result = 31 * result + (nidusSourceFlag != null ? nidusSourceFlag.hashCode() : 0);
        result = 31 * result + (longestDiameter != null ? longestDiameter.hashCode() : 0);
        result = 31 * result + (shortestDiameter != null ? shortestDiameter.hashCode() : 0);
        result = 31 * result + (examFinding != null ? examFinding.hashCode() : 0);
        result = 31 * result + (examConclusion != null ? examConclusion.hashCode() : 0);
        result = 31 * result + (hasImage != null ? hasImage.hashCode() : 0);
        result = 31 * result + (picFileUrls != null ? picFileUrls.hashCode() : 0);
        result = 31 * result + (imageFileFormat != null ? imageFileFormat.hashCode() : 0);
        result = 31 * result + (applyDoctorId != null ? applyDoctorId.hashCode() : 0);
        result = 31 * result + (applyDoctorUuid != null ? applyDoctorUuid.hashCode() : 0);
        result = 31 * result + (applyDoctorNo != null ? applyDoctorNo.hashCode() : 0);
        result = 31 * result + (applyDoctorName != null ? applyDoctorName.hashCode() : 0);
        result = 31 * result + (reportDoctorId != null ? reportDoctorId.hashCode() : 0);
        result = 31 * result + (reportDoctorNo != null ? reportDoctorNo.hashCode() : 0);
        result = 31 * result + (reportDoctorName != null ? reportDoctorName.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (readFlag != null ? readFlag.hashCode() : 0);
        result = 31 * result + (applyTime != null ? applyTime.hashCode() : 0);
        result = 31 * result + (excuteTime != null ? excuteTime.hashCode() : 0);
        result = 31 * result + (reportTime != null ? reportTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (syncTime != null ? syncTime.hashCode() : 0);
        result = 31 * result + (syncFlag != null ? syncFlag.hashCode() : 0);
        result = 31 * result + (patientSex != null ? patientSex.hashCode() : 0);
        result = 31 * result + (patientBirth != null ? patientBirth.hashCode() : 0);
        result = 31 * result + (patientIdno != null ? patientIdno.hashCode() : 0);
        result = 31 * result + (patientMobile != null ? patientMobile.hashCode() : 0);
        result = 31 * result + (patientAddress != null ? patientAddress.hashCode() : 0);
        result = 31 * result + (examConclusionRtf != null ? examConclusionRtf.hashCode() : 0);
        result = 31 * result + (rawCreateTime != null ? rawCreateTime.hashCode() : 0);
        return result;
    }

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
