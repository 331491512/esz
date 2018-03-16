package com.esuizhen.server.sync.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * 检验bean
 * @author LHY
 */
public class SyncEciExamReport implements Serializable { 
	
	private static final long serialVersionUID = 1L;
	private Integer ID;  
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
	private String deptUuid;  
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
	private String longestDiameter;  
	private String shortestDiameter;   
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
	private String reportDoctorUuid;
	private String reportDoctorNo;   
	private String reportDoctorName;   
	private Integer state;   
	private Integer readFlag;  
	private Date applyTime;  
	private Date excuteTime;   
	private Date reportTime;   
	private Date createTime;  
	private Date updateTime;   
	private Integer patientSex;  
	private Date patientBirth;   
	private String patientIdno;   
	private String patientMobile;   
	private String patientAddress;   
	private String examConclusionRtf;  
	private Date rawCreateTime;   
	private Integer mergeFlag;  
	private Long mergeFrom;  
	private String mergeFromUuid;   
	private Long mergeTarget;   
	private String mergeTargetUuid;  
	private Date mergeTime;
	private String batchId;
	private Integer sourceFlag;
	
	public Integer getSourceFlag() {
		return sourceFlag;
	}
	public void setSourceFlag(Integer sourceFlag) {
		this.sourceFlag = sourceFlag;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getExamReportId() {
		return examReportId;
	}
	public void setExamReportId(String examReportId) {
		this.examReportId = examReportId;
	}
	public String getEmrId() {
		return emrId;
	}
	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientNo() {
		return patientNo;
	}
	public void setPatientNo(String patientNo) {
		this.patientNo = patientNo;
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
		this.patientUuid = patientUuid;
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
		this.examTypeName = examTypeName;
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
		this.deptName = deptName;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getScanningTechnique() {
		return scanningTechnique;
	}
	public void setScanningTechnique(String scanningTechnique) {
		this.scanningTechnique = scanningTechnique;
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
		this.obtainWay = obtainWay;
	}
	public String getOrganCode() {
		return organCode;
	}
	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
	public String getOrgan() {
		return organ;
	}
	public void setOrgan(String organ) {
		this.organ = organ;
	}
	public String getBodyCode() {
		return bodyCode;
	}
	public void setBodyCode(String bodyCode) {
		this.bodyCode = bodyCode;
	}
	public String getBodyPart() {
		return bodyPart;
	}
	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}
	public String getNidusCode() {
		return nidusCode;
	}
	public void setNidusCode(String nidusCode) {
		this.nidusCode = nidusCode;
	}
	public String getNidus() {
		return nidus;
	}
	public void setNidus(String nidus) {
		this.nidus = nidus;
	}
	public Integer getNidusSourceFlag() {
		return nidusSourceFlag;
	}
	public void setNidusSourceFlag(Integer nidusSourceFlag) {
		this.nidusSourceFlag = nidusSourceFlag;
	}
	public String getLongestDiameter() {
		return longestDiameter;
	}
	public void setLongestDiameter(String longestDiameter) {
		this.longestDiameter = longestDiameter;
	}
	public String getShortestDiameter() {
		return shortestDiameter;
	}
	public void setShortestDiameter(String shortestDiameter) {
		this.shortestDiameter = shortestDiameter;
	}
	public String getExamFinding() {
		return examFinding;
	}
	public void setExamFinding(String examFinding) {
		this.examFinding = examFinding;
	}
	public String getExamConclusion() {
		return examConclusion;
	}
	public void setExamConclusion(String examConclusion) {
		this.examConclusion = examConclusion;
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
		this.picFileUrls = picFileUrls;
	}
	public String getImageFileFormat() {
		return imageFileFormat;
	}
	public void setImageFileFormat(String imageFileFormat) {
		this.imageFileFormat = imageFileFormat;
	}
	public Integer getApplyDoctorId() {
		return applyDoctorId;
	}
	public void setApplyDoctorId(Integer applyDoctorId) {
		this.applyDoctorId = applyDoctorId;
	}
	public String getApplyDoctorUuid() {
		return applyDoctorUuid;
	}
	public void setApplyDoctorUuid(String applyDoctorUuid) {
		this.applyDoctorUuid = applyDoctorUuid;
	}
	public String getApplyDoctorNo() {
		return applyDoctorNo;
	}
	public void setApplyDoctorNo(String applyDoctorNo) {
		this.applyDoctorNo = applyDoctorNo;
	}
	public String getApplyDoctorName() {
		return applyDoctorName;
	}
	public void setApplyDoctorName(String applyDoctorName) {
		this.applyDoctorName = applyDoctorName;
	}
	public Integer getReportDoctorId() {
		return reportDoctorId;
	}
	public void setReportDoctorId(Integer reportDoctorId) {
		this.reportDoctorId = reportDoctorId;
	}
	public String getReportDoctorUuid() {
		return reportDoctorUuid;
	}
	public void setReportDoctorUuid(String reportDoctorUuid) {
		this.reportDoctorUuid = reportDoctorUuid;
	}
	public String getReportDoctorNo() {
		return reportDoctorNo;
	}
	public void setReportDoctorNo(String reportDoctorNo) {
		this.reportDoctorNo = reportDoctorNo;
	}
	public String getReportDoctorName() {
		return reportDoctorName;
	}
	public void setReportDoctorName(String reportDoctorName) {
		this.reportDoctorName = reportDoctorName;
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
	public Integer getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(Integer patientSex) {
		this.patientSex = patientSex;
	}
	public Date getPatientBirth() {
		return patientBirth;
	}
	public void setPatientBirth(Date patientBirth) {
		this.patientBirth = patientBirth;
	}
	public String getPatientIdno() {
		return patientIdno;
	}
	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getExamConclusionRtf() {
		return examConclusionRtf;
	}
	public void setExamConclusionRtf(String examConclusionRtf) {
		this.examConclusionRtf = examConclusionRtf;
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
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
}