/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>TReviewAlertDetailInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:30:19<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/** 
* @ClassName: TReviewAlertDetailInfo
* @Description: 
* @author lichenghao
* @date 2017年8月23日 下午4:30:19  
*/
public class TReviewAlertDetailInfo {
	
	private String reviewDetailId;
	private String reviewBatchId;
	private Long patientId;
	private String trueName;
	private String pictureUrl;
	private Integer updateFlag;
	private Integer	state;
	private Date alertTime;
	private String affirmTime;
	private String alertContent;
	private String productApplyId;
	private String cause;
	
	private Long doctorId;
	private String doctorName;
	private Long doctorUserId;
	private Integer confirmFlag;
	private String deptName;
	private Integer deptId;
	public String getReviewDetailId() {
		return reviewDetailId;
	}
	public void setReviewDetailId(String reviewDetailId) {
		this.reviewDetailId = reviewDetailId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public Integer getUpdateFlag() {
		return updateFlag;
	}
	public void setUpdateFlag(Integer updateFlag) {
		this.updateFlag = updateFlag;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getAffirmTime() {
		return affirmTime;
	}
	public void setAffirmTime(String affirmTime) {
		this.affirmTime = affirmTime;
	}
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public Date getAlertTime() {
		return alertTime;
	}
	public void setAlertTime(Date alertTime) {
		this.alertTime = alertTime;
	}
	public String getAlertContent() {
		return alertContent;
	}
	public void setAlertContent(String alertContent) {
		this.alertContent = alertContent;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public Integer getConfirmFlag() {
		return confirmFlag;
	}
	public void setConfirmFlag(Integer confirmFlag) {
		this.confirmFlag = confirmFlag;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Long getDoctorUserId() {
		return doctorUserId;
	}
	public void setDoctorUserId(Long doctorUserId) {
		this.doctorUserId = doctorUserId;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getReviewBatchId() {
		return reviewBatchId;
	}
	public void setReviewBatchId(String reviewBatchId) {
		this.reviewBatchId = reviewBatchId;
	}
}
