/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TReportPushBatch.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月17日下午3:40:44<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/** 
* @ClassName: TReportPushBatch
* @Description: 
* @author lichenghao
* @date 2017年8月17日 下午3:40:44  
*/
public class TReportPatientPushBatchDetail {
	private String reportPushItemId;
	private String reportPushBatchId;
	private Integer type;
	private String reportId;
	private Integer promptFlag;
	private String pushItemName;
	private Date itemCheckTime;
	private Date reportTime;
	private Date applyTime;
	private Date sampleTime;
	private Integer hospitalId;
	private Long doctorId;
	private Long doctorUserId;
	private Date createTime;
	private Date updateTime;
	public String getReportPushItemId() {
		return reportPushItemId;
	}
	public void setReportPushItemId(String reportPushItemId) {
		this.reportPushItemId = reportPushItemId;
	}
	
	public String getReportPushBatchId() {
		return reportPushBatchId;
	}
	public void setReportPushBatchId(String reportPushBatchId) {
		this.reportPushBatchId = reportPushBatchId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getReportId() {
		return reportId;
	}
	public void setReportId(String reportId) {
		this.reportId = reportId;
	}
	
	public String getPushItemName() {
		return pushItemName;
	}
	public void setPushItemName(String pushItemName) {
		this.pushItemName = pushItemName;
	}
	public Date getItemCheckTime() {
		return itemCheckTime;
	}
	public void setItemCheckTime(Date itemCheckTime) {
		this.itemCheckTime = itemCheckTime;
	}
	public Date getReportTime() {
		return reportTime;
	}
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
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
	public Integer getPromptFlag() {
		return promptFlag;
	}
	public void setPromptFlag(Integer promptFlag) {
		this.promptFlag = promptFlag;
	}
}
