package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>Title:TExamReportSync</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月6日 下午3:56:11
 */
public class TExamReportSync implements Serializable {
	private static final long serialVersionUID = 1L;

	//医学影像记录ID
	private String examReportId;
	//电子病历ID
	private String emrId;
	//电子病历登记号
	private String emrNo;
	//患者ID
	private Long patientId;
	//患者uuid
	private String patientUuid;
	//
	private Integer detectionTypeId;
	//
	private Integer detectionChildTypeId;
	//
	private String detectionTypeName;
	//
	private String patientName;
	//
	private String patientNo;
	//患者身份证号
	private String patientIdno;
	//患者地址
	private String patientAddress;
	//患者手机号
	private String patientMobile;
	//患者性别
	private Integer patientSex;
	//门诊住院标识
	private Integer outPatientFlag;
	//就诊医院ID
	private Integer hospitalId;
	//检查类型
	private Integer examTypeId;
	//检查子类型
	private Integer examChildTypeId;
	
	private String examTypeName;
	//科别ID
	private Integer deptId;
	//科别
	private String deptName;
	//报告单标题
	private String reportTitle;
	//扫描技术
	private String scanningTechnique;
	//检查方式. 病理学检查有效
	private Integer examWay;
	//标本获取方式。病理学检查有效
	private String obtainWay;
	//检查器官编码
	private String organCode;
	//器官，如肝。如果organId为0（未在元数据字典中），则使用organ表示自定义器官
	private String organ;
	//检查部位，如右叶。对于病理学检查，指送检标本部位
	private String bodyPart;
	//病灶编码
	private String nidusCode;
	//病灶
	private String nidus;
	//1:原发；2：继发
	private Integer nidusSourceFlag;
	//最长径。单位：mm
	private Float longestDiameter;
	//垂直最短径。单位：mm
	private Float shortestDiameter;
	//检查所见
	private String examFinding;
	//检查结论或诊断或意见
	private String examConclusion;
	//影像文件URL地址。多个文件用逗号","分隔
	private String picFileUrls;
	//影像格式
	private String imageFileFormat;
	//申请医师ID
	private Long applyDoctorId;
	//
	private String applyDoctorUuid;
	//申请医师工号
	private String applyDoctorNo;
	//申请医生姓名
	private String applyDoctorName;
	//报告医师ID
	private Long reportDoctorId;
	//报告医师工号
	private String reportDoctorNo;
	//报告医师姓名
	private String reportDoctorName;
	//检查结果状态
	private Integer state;
	//申请日期
	private Date applyTime;
	//检查日期
	private Date excuteTime;
	//报告时间
	private Date reportTime;
	//创建时间（单据生成时间）
	private Date createTime;
	//更新时间
	private Date updateTime;
	//start by fanpanwei
	private String deptUuid;
	private String reportDoctorUuid;
	private Date rawCreateTime;
	private Integer inhospitaltimes;
	//end by fanpanwei
	
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
	public String getEmrNo() {
		return emrNo;
	}
	public void setEmrNo(String emrNo) {
		this.emrNo = emrNo;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
	}
	public Integer getDetectionTypeId() {
		return detectionTypeId;
	}
	public void setDetectionTypeId(Integer detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}
	public Integer getDetectionChildTypeId() {
		return detectionChildTypeId;
	}
	public void setDetectionChildTypeId(Integer detectionChildTypeId) {
		this.detectionChildTypeId = detectionChildTypeId;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
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
	public String getPatientIdno() {
		return patientIdno;
	}
	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public Integer getPatientSex() {
		return patientSex;
	}
	public void setPatientSex(Integer patientSex) {
		this.patientSex = patientSex;
	}
	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}
	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
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
		this.examFinding = examFinding;
	}
	public String getExamConclusion() {
		return examConclusion;
	}
	public void setExamConclusion(String examConclusion) {
		this.examConclusion = examConclusion;
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
	public Long getApplyDoctorId() {
		return applyDoctorId;
	}
	public void setApplyDoctorId(Long applyDoctorId) {
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
	
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getReportDoctorUuid() {
		return reportDoctorUuid;
	}
	public void setReportDoctorUuid(String reportDoctorUuid) {
		this.reportDoctorUuid = reportDoctorUuid;
	}
	public Date getRawCreateTime() {
		return rawCreateTime;
	}
	public void setRawCreateTime(Date rawCreateTime) {
		this.rawCreateTime = rawCreateTime;
	}
	public Integer getInhospitaltimes() {
		return inhospitaltimes;
	}
	public void setInhospitaltimes(Integer inhospitaltimes) {
		this.inhospitaltimes = inhospitaltimes;
	}
	
	
}
