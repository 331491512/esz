/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>DoctorSendReviewAlertReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年3月28日上午9:55:56<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;
import java.util.List;

import com.westangel.common.bean.PatientGroup;

/** 
* @ClassName: DoctorSendReviewAlertReq
* @Description: 
* @author lichenghao
* @date 2016年3月28日 上午9:55:56  
*/
public class DoctorSendReviewAlertReq {
	
	//发送医生userId
	private Long doctorUserId;
	
	//接收患者的userId
	private List<Long> patientUserIds;
	
	//接收分组
	private List<PatientGroup>groups;
	
	//复查提醒内容
	private String reviewContent;
	
	//复查日期
	private Date reviewDate;
	
	//备注
	private String remark;
	
	//发送类型
	private Integer sendFlag;
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public List<Long> getPatientUserIds() {
		return patientUserIds;
	}
	public void setPatientUserIds(List<Long> patientUserIds) {
		this.patientUserIds = patientUserIds;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<PatientGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<PatientGroup> groups) {
		this.groups = groups;
	}
	public Integer getSendFlag() {
		return sendFlag;
	}
	public void setSendFlag(Integer sendFlag) {
		this.sendFlag = sendFlag;
	}
}
