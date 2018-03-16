package com.esuizhen.server.sync.model.server;

import java.io.Serializable;
import java.util.Date;
/**
 * Created by Nidan on 2017年03月21 上午 11:40
 */
public class TExamReport implements Serializable {

    private static final long serialVersionUID = 1L;

    private String examReportId;

    private String emrId;

    private Integer patientId;

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

    private Float longestDiameter;

    private Float shortestDiameter;

    private String examFinding;

    private String examConclusion;

    private String examConclusionRtf;

    private Integer hasImage;

    private String picFileUrls;

    private String imageFileFormat;

    private Long applyDoctorId;

    private String applyDoctorNo;

    private String applyDoctorName;

    private Long reportDoctorId;

    private String reportDoctorNo;

    private String reportDoctorName;

    private Integer state;

    private Integer readFlag;

    private Date applyTime;

    private Date excuteTime;

    private Date reportTime;

    private Date createTime;

    private Date updateTime;

    private Date syncTime;

    private Integer syncFlag;

    private Integer patientSex;

    private String patientBirth;

    private String patientIdno;

    private String patientMobile;

    private String patientAddress;

    private String applyDoctorUuid;

    private String reportDoctorUuid;

    private Date rawCreateTime;

    private String operateDoctorUuid;

    private String auditDoctorUuid;

    private Integer mergeFlag;

    private Long mergeFrom;

    private Long mergeTarget;

    private Date mergeTime;

    private String mergeFromUuid;
    private String mergeTargetUuid;
    private Integer id;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExamReportId() {
        return examReportId;
    }

    public void setExamReportId(String examReportId) {
        this.examReportId = examReportId == null ? null : examReportId.trim();
    }

    public String getEmrId() {
        return emrId;
    }

    public void setEmrId(String emrId) {
        this.emrId = emrId == null ? null : emrId.trim();
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName == null ? null : patientName.trim();
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

    public String getPatientUuid() {
        return patientUuid;
    }

    public void setPatientUuid(String patientUuid) {
        this.patientUuid = patientUuid == null ? null : patientUuid.trim();
    }

    public Integer getOutPatientFlag() {
        return outPatientFlag;
    }

    public void setOutPatientFlag(Integer outPatientFlag) {
        this.outPatientFlag = outPatientFlag;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(Integer examTypeId) {
        this.examTypeId = examTypeId;
    }

    public Integer getExamChildTypeId() {
        return examChildTypeId;
    }

    public void setExamChildTypeId(Integer examChildTypeId) {
        this.examChildTypeId = examChildTypeId;
    }

    public String getExamTypeName() {
        return examTypeName;
    }

    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName == null ? null : examTypeName.trim();
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle == null ? null : reportTitle.trim();
    }

    public String getScanningTechnique() {
        return scanningTechnique;
    }

    public void setScanningTechnique(String scanningTechnique) {
        this.scanningTechnique = scanningTechnique == null ? null : scanningTechnique.trim();
    }

    public Integer getExamWay() {
        return examWay;
    }

    public void setExamWay(Integer examWay) {
        this.examWay = examWay;
    }

    public String getObtainWay() {
        return obtainWay;
    }

    public void setObtainWay(String obtainWay) {
        this.obtainWay = obtainWay == null ? null : obtainWay.trim();
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode == null ? null : organCode.trim();
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ == null ? null : organ.trim();
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode == null ? null : bodyCode.trim();
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart == null ? null : bodyPart.trim();
    }

    public String getNidusCode() {
        return nidusCode;
    }

    public void setNidusCode(String nidusCode) {
        this.nidusCode = nidusCode == null ? null : nidusCode.trim();
    }

    public String getNidus() {
        return nidus;
    }

    public void setNidus(String nidus) {
        this.nidus = nidus == null ? null : nidus.trim();
    }

    public Integer getNidusSourceFlag() {
        return nidusSourceFlag;
    }

    public void setNidusSourceFlag(Integer nidusSourceFlag) {
        this.nidusSourceFlag = nidusSourceFlag;
    }

    public Float getLongestDiameter() {
        return longestDiameter;
    }

    public void setLongestDiameter(Float longestDiameter) {
        this.longestDiameter = longestDiameter;
    }

    public Float getShortestDiameter() {
        return shortestDiameter;
    }

    public void setShortestDiameter(Float shortestDiameter) {
        this.shortestDiameter = shortestDiameter;
    }

    public String getExamFinding() {
        return examFinding;
    }

    public void setExamFinding(String examFinding) {
        this.examFinding = examFinding == null ? null : examFinding.trim();
    }

    public String getExamConclusion() {
        return examConclusion;
    }

    public void setExamConclusion(String examConclusion) {
        this.examConclusion = examConclusion == null ? null : examConclusion.trim();
    }

    public String getExamConclusionRtf() {
        return examConclusionRtf;
    }

    public void setExamConclusionRtf(String examConclusionRtf) {
        this.examConclusionRtf = examConclusionRtf == null ? null : examConclusionRtf.trim();
    }

    public Integer getHasImage() {
        return hasImage;
    }

    public void setHasImage(Integer hasImage) {
        this.hasImage = hasImage;
    }

    public String getPicFileUrls() {
        return picFileUrls;
    }

    public void setPicFileUrls(String picFileUrls) {
        this.picFileUrls = picFileUrls == null ? null : picFileUrls.trim();
    }

    public String getImageFileFormat() {
        return imageFileFormat;
    }

    public void setImageFileFormat(String imageFileFormat) {
        this.imageFileFormat = imageFileFormat == null ? null : imageFileFormat.trim();
    }

    public Long getApplyDoctorId() {
        return applyDoctorId;
    }

    public void setApplyDoctorId(Long applyDoctorId) {
        this.applyDoctorId = applyDoctorId;
    }

    public String getApplyDoctorNo() {
        return applyDoctorNo;
    }

    public void setApplyDoctorNo(String applyDoctorNo) {
        this.applyDoctorNo = applyDoctorNo == null ? null : applyDoctorNo.trim();
    }

    public String getApplyDoctorName() {
        return applyDoctorName;
    }

    public void setApplyDoctorName(String applyDoctorName) {
        this.applyDoctorName = applyDoctorName == null ? null : applyDoctorName.trim();
    }

    public Long getReportDoctorId() {
        return reportDoctorId;
    }

    public void setReportDoctorId(Long reportDoctorId) {
        this.reportDoctorId = reportDoctorId;
    }

    public String getReportDoctorNo() {
        return reportDoctorNo;
    }

    public void setReportDoctorNo(String reportDoctorNo) {
        this.reportDoctorNo = reportDoctorNo == null ? null : reportDoctorNo.trim();
    }

    public String getReportDoctorName() {
        return reportDoctorName;
    }

    public void setReportDoctorName(String reportDoctorName) {
        this.reportDoctorName = reportDoctorName == null ? null : reportDoctorName.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getReadFlag() {
        return readFlag;
    }

    public void setReadFlag(Integer readFlag) {
        this.readFlag = readFlag;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Date getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(Date excuteTime) {
        this.excuteTime = excuteTime;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
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

    public Integer getPatientSex() {
        return patientSex;
    }

    public void setPatientSex(Integer patientSex) {
        this.patientSex = patientSex;
    }

    public String getPatientBirth() {
        return patientBirth;
    }

    public void setPatientBirth(String patientBirth) {
        this.patientBirth = patientBirth == null ? null : patientBirth.trim();
    }

    public String getPatientIdno() {
        return patientIdno;
    }

    public void setPatientIdno(String patientIdno) {
        this.patientIdno = patientIdno == null ? null : patientIdno.trim();
    }

    public String getPatientMobile() {
        return patientMobile;
    }

    public void setPatientMobile(String patientMobile) {
        this.patientMobile = patientMobile == null ? null : patientMobile.trim();
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress == null ? null : patientAddress.trim();
    }

    public String getApplyDoctorUuid() {
        return applyDoctorUuid;
    }

    public void setApplyDoctorUuid(String applyDoctorUuid) {
        this.applyDoctorUuid = applyDoctorUuid == null ? null : applyDoctorUuid.trim();
    }

    public String getReportDoctorUuid() {
        return reportDoctorUuid;
    }

    public void setReportDoctorUuid(String reportDoctorUuid) {
        this.reportDoctorUuid = reportDoctorUuid == null ? null : reportDoctorUuid.trim();
    }

    public Date getRawCreateTime() {
        return rawCreateTime;
    }

    public void setRawCreateTime(Date rawCreateTime) {
        this.rawCreateTime = rawCreateTime;
    }

    public String getOperateDoctorUuid() {
        return operateDoctorUuid;
    }

    public void setOperateDoctorUuid(String operateDoctorUuid) {
        this.operateDoctorUuid = operateDoctorUuid == null ? null : operateDoctorUuid.trim();
    }

    public String getAuditDoctorUuid() {
        return auditDoctorUuid;
    }

    public void setAuditDoctorUuid(String auditDoctorUuid) {
        this.auditDoctorUuid = auditDoctorUuid == null ? null : auditDoctorUuid.trim();
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