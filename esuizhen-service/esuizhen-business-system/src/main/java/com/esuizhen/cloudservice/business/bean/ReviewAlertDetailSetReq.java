/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAlertDetailSetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:17:17<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.Date;

/**
 * @ClassName: ReviewAlertDetailSetReq
 * @Description:
 * @author lichenghao
 * @date 2017年8月23日 下午4:17:17
 */
public class ReviewAlertDetailSetReq {
	private String reviewDetailId;
	private String reviewBatchId;
	// 医生编号 修改reviewDetailId不存在时  需要查询并生成reviewDetailId相关的数据
	private String doctorId;
	private Long patientId;
	/**
	 * -1 拒绝 1同意
	 */
	private Integer confirmFlag;
	private String cause;
	private String alertContent;
	private Date alertTime;
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
	public Integer getConfirmFlag() {
		return confirmFlag;
	}
	public void setConfirmFlag(Integer confirmFlag) {
		this.confirmFlag = confirmFlag;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getAlertContent() {
		return alertContent;
	}
	public void setAlertContent(String alertContent) {
		this.alertContent = alertContent;
	}
	public Date getAlertTime() {
		return alertTime;
	}
	public void setAlertTime(Date alertTime) {
		this.alertTime = alertTime;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getReviewBatchId() {
		return reviewBatchId;
	}
	public void setReviewBatchId(String reviewBatchId) {
		this.reviewBatchId = reviewBatchId;
	}
}
