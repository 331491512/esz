/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TExamReportDetailInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午11:55:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

import java.util.Date;

/** 
* @ClassName: TExamReportDetailInfo
* @Description: 检查报告单详细信息
* @author lichenghao
* @date 2016年5月3日 上午11:55:10  
*/
public class TExamReportDetailInfo {
	//报告单标题
	private String reportTitle;
	//检查所见
	private String examFinding;
	//检查结论
	private String examConclusion;
	//样本类型
	private String sampleType;
	//报告单图片url列表
	private String[] picFileUrls;
	//申请时间
	private Date applyTime;
	//报告时间
	private Date reportTime;
	//检查时间
	private Date excuteTime;
	//报告单图片url
	private String picFileUrl;
	
	// 检查者 add by zhuguo
	private String auditDoctorName;
	
	// 申请科室 add by zhuguo
	private String deptName;
	
	// 检验项目 add by zhuguo
	private String examTypeName;

	private Integer hospitalId;

	public Integer getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getExamTypeName() {
		return examTypeName;
	}
	public void setExamTypeName(String examTypeName) {
		this.examTypeName = examTypeName;
	}
	public String getAuditDoctorName() {
		return auditDoctorName;
	}
	public void setAuditDoctorName(String auditDoctorName) {
		this.auditDoctorName = auditDoctorName;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
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
	public String getSampleType() {
		return sampleType;
	}
	public void setSampleType(String sampleType) {
		this.sampleType = sampleType;
	}
	public String[] getPicFileUrls() {
		return picFileUrls;
	}
	public void setPicFileUrls(String[] picFileUrls) {
		this.picFileUrls = picFileUrls;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	public Date getExcuteTime() {
		return excuteTime;
	}
	public void setExcuteTime(Date excuteTime) {
		this.excuteTime = excuteTime;
	}
	public String getPicFileUrl() {
		return picFileUrl;
	}
	public void setPicFileUrl(String picFileUrl) {
		this.picFileUrl = picFileUrl;
		this.picFileUrls = picFileUrl.split(",");
	}
}
