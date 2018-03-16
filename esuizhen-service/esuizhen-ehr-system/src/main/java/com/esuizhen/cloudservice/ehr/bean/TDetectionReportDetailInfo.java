/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TDiagnosisReportDetail.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午11:36:02<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;
import java.util.List;

/** 
* @ClassName: TDiagnosisReportDetail
* @Description: 检验报告单详细信息
* @author lichenghao
* @date 2016年5月3日 上午11:36:02  
*/
public class TDetectionReportDetailInfo {
	
	
	private String detectionReportId;				//检验项记录id
	private String emrId;
	private Integer detectionTypeId;		//检验项类型Id
	private Integer sortNum;				//  排序字段
	private Integer isDelete;				//  1：标识删除  其他：存在recordId表示修改，否则新增
	private String hospitalName;			//医院名称
	private Integer parentId;
	private Long doctorId;				//登录用户医生Id
	private Long patientId;         		//增加检验的患者Id
	private String doctorName;
	private String doctorNo;
	private String patientName;
	private String patientNo;
	private String patientIdno;
	private String patientAddress;
	private String patientMobile;
	private Integer patientSex;
	private Integer outPatientFlag;
	
	private Integer readFlag;
	private Integer hospitalId;			//登录医生所属医院的Id
	
	
	private String sampleType;
	//诊断内容
	private String diagnosis;
	private Integer deptId;
	//科别
	private String deptName;
	//检查类型
	private String detectionTypeName;
	
	private Integer state;
	//申请时间
	private Date applyTime;
	//采样时间
	private Date sampleTime;
	//报告时间
	private Date reportTime;
	//检验标题
	private String reportTitle;
	//检查项目
	private List<TDetectionItemInfo> detectionItemDetails;

	// 检查者 add by zhuguo
	private String auditDoctorName;
	
	public String getAuditDoctorName() {
		return auditDoctorName;
	}

	public void setAuditDoctorName(String auditDoctorName) {
		this.auditDoctorName = auditDoctorName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getOutPatientFlag() {
		return outPatientFlag;
	}

	public void setOutPatientFlag(Integer outPatientFlag) {
		this.outPatientFlag = outPatientFlag;
	}

	public Integer getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(Integer readFlag) {
		this.readFlag = readFlag;
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

	public String getPatientIdno() {
		return patientIdno;
	}

	public void setPatientIdno(String patientIdno) {
		this.patientIdno = patientIdno;
	}

	public String getDetectionReportId() {
		return detectionReportId;
	}

	public void setDetectionReportId(String detectionReportId) {
		this.detectionReportId = detectionReportId;
	}
	
	public String getEmrId() {
		return emrId;
	}

	public void setEmrId(String emrId) {
		this.emrId = emrId;
	}

	public Integer getDetectionTypeId() {
		return detectionTypeId;
	}

	public void setDetectionTypeId(Integer detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDetectionTypeName() {
		return detectionTypeName;
	}

	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}

	public List<TDetectionItemInfo> getDetectionItemDetails() {
		return detectionItemDetails;
	}

	public void setDetectionItemDetails(List<TDetectionItemInfo> detectionItemDetails) {
		this.detectionItemDetails = detectionItemDetails;
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

	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getDoctorNo() {
		return doctorNo;
	}

	public void setDoctorNo(String doctorNo) {
		this.doctorNo = doctorNo;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getSampleType() {
		return sampleType;
	}

	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	
}
