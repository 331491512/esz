package com.esuizhen.cloudservice.sync.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * <p>Title:TDetectionReportSync</p>
 * <p>Description:</p>
 * @author YYCHEN
 * @date 2016年5月6日 下午4:17:44
 */
public class TDetectionReportSync implements Serializable {
	private static final long serialVersionUID = 1L;

	//化验单记录ID
	private String detectionReportId;
	//患者ID
	private Long patientId;
	//患者姓名
	private String patientName;
	//患者uuid
	private String patientUuid;
	//病案号
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
	//检验类型ID
	private Integer detectionTypeId;
	//检验子类型
	private Integer detectionChildTypeId;
	//原始LIS检验类型ID
	private Integer rawDetectionTypeId;
	//原始LIS检验子类型ID
	private Integer rawDetectionChildTypeId;
	//检验子类型名
	private String detectionTypeName;
	//科别ID
	private Integer deptId;
	//科别
	private String deptName;
	//临床诊断
	private String diagnosis;
	//标本号
	private String sampleNo;
	//标本名称
	private String sampleName;
	//标本种类。如静脉血
	private String sampleType;
	//标本状态
	private Integer sampleState;
	//仪器名称
	private String instrument;
	//申请医师ID
	private Long applyDoctorId;
	//
	private String applyDoctorUuid;
	//申请医师工号
	private String applyDoctorNo;
	//申请医师姓名
	private String applyDoctorName;
	//操作医师ID
	private Long operateDoctorId;
	//操作医师工号
	private String operateDoctorNo;
	//操作医师姓名
	private String operateDoctorName;
	//报告医师ID
	private Long reportDoctorId;
	//报告医师工号
	private String reportDoctorNo;
	//报告医师姓名
	private String reportDoctorName;
	//审核医师Id
	private Long auditDoctorId;
	//审核医师工号
	private String auditDoctorNo;
	//审核医师姓名
	private String auditDoctorName;
	//报告备注
	private String remark;
	//申请日期
	private Date applyTime;
	//采样时间
	private Date sampleTime;
	//标本接受时间
	private Date acceptTime;
	//报告时间
	private Date reportTime;
	//检查结果状态
	private Integer state;
	//创建时间（单据创建时间）
	private Date createTime;
	//更新时间
	private Date updateTime;
	//检验单信息详情
	private List<TDetectionReportDetailSync> detectionReportDetailList;
	
	private String emrId;
	private String emrNo;
	private Integer readFlag;
	private Date syncTime;
	private Long mainID;
	//start by fanpanwei
	private String deptUuid;
	private String operateDoctorUuid;
	private String reportDoctorUuid;
	private String auditDoctorUuid;
	private Date rawCreateTime;
	private Integer inhospitaltimes;
	//end by fanpanwei
	public Long getMainID() {
		return mainID;
	}
	public void setMainID(Long mainID) {
		this.mainID = mainID;
	}
	public String getDetectionReportId() {
		return detectionReportId;
	}
	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getPatientUuid() {
		return patientUuid;
	}
	public void setPatientUuid(String patientUuid) {
		this.patientUuid = patientUuid;
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
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
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
	public Integer getRawDetectionTypeId() {
		return rawDetectionTypeId;
	}
	public void setRawDetectionTypeId(Integer rawDetectionTypeId) {
		this.rawDetectionTypeId = rawDetectionTypeId;
	}
	public Integer getRawDetectionChildTypeId() {
		return rawDetectionChildTypeId;
	}
	public void setRawDetectionChildTypeId(Integer rawDetectionChildTypeId) {
		this.rawDetectionChildTypeId = rawDetectionChildTypeId;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
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
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getSampleNo() {
		return sampleNo;
	}
	public void setSampleNo(String sampleNo) {
		this.sampleNo = sampleNo;
	}
	public String getSampleName() {
		return sampleName;
	}
	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public Integer getSampleState() {
		return sampleState;
	}
	public void setSampleState(Integer sampleState) {
		this.sampleState = sampleState;
	}
	public String getInstrument() {
		return instrument;
	}
	public void setInstrument(String instrument) {
		this.instrument = instrument;
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
	public Long getOperateDoctorId() {
		return operateDoctorId;
	}
	public void setOperateDoctorId(Long operateDoctorId) {
		this.operateDoctorId = operateDoctorId;
	}
	public String getOperateDoctorNo() {
		return operateDoctorNo;
	}
	public void setOperateDoctorNo(String operateDoctorNo) {
		this.operateDoctorNo = operateDoctorNo;
	}
	public String getOperateDoctorName() {
		return operateDoctorName;
	}
	public void setOperateDoctorName(String operateDoctorName) {
		this.operateDoctorName = operateDoctorName;
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
	public Long getAuditDoctorId() {
		return auditDoctorId;
	}
	public void setAuditDoctorId(Long auditDoctorId) {
		this.auditDoctorId = auditDoctorId;
	}
	public String getAuditDoctorNo() {
		return auditDoctorNo;
	}
	public void setAuditDoctorNo(String auditDoctorNo) {
		this.auditDoctorNo = auditDoctorNo;
	}
	public String getAuditDoctorName() {
		return auditDoctorName;
	}
	public void setAuditDoctorName(String auditDoctorName) {
		this.auditDoctorName = auditDoctorName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(Date sampleTime) {
		this.sampleTime = sampleTime;
	}
	public Date getAcceptTime() {
		return acceptTime;
	}
	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	public List<TDetectionReportDetailSync> getDetectionReportDetailList() {
		return detectionReportDetailList;
	}
	public void setDetectionReportDetailList(List<TDetectionReportDetailSync> detectionReportDetailList) {
		this.detectionReportDetailList = detectionReportDetailList;
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
	public Integer getReadFlag() {
		return readFlag;
	}
	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	
	public String getDeptUuid() {
		return deptUuid;
	}
	public void setDeptUuid(String deptUuid) {
		this.deptUuid = deptUuid;
	}
	public String getOperateDoctorUuid() {
		return operateDoctorUuid;
	}
	public void setOperateDoctorUuid(String operateDoctorUuid) {
		this.operateDoctorUuid = operateDoctorUuid;
	}
	public String getReportDoctorUuid() {
		return reportDoctorUuid;
	}
	public void setReportDoctorUuid(String reportDoctorUuid) {
		this.reportDoctorUuid = reportDoctorUuid;
	}
	public String getAuditDoctorUuid() {
		return auditDoctorUuid;
	}
	public void setAuditDoctorUuid(String auditDoctorUuid) {
		this.auditDoctorUuid = auditDoctorUuid;
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
