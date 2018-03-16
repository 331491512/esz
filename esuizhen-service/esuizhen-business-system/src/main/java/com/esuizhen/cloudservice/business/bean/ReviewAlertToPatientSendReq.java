/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAlertTOPatientSendReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:07:50<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import java.util.List;

/** 
* @ClassName: ReviewAlertTOPatientSendReq
* @Description: 
* @author lichenghao
* @date 2017年8月23日 下午4:07:50  
*/
public class ReviewAlertToPatientSendReq {
	private Long doctorId;
	private String reviewBatchId;
	private List<String> reviewDetailList;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getReviewBatchId() {
		return reviewBatchId;
	}
	public void setReviewBatchId(String reviewBatchId) {
		this.reviewBatchId = reviewBatchId;
	}
	public List<String> getReviewDetailList() {
		return reviewDetailList;
	}
	public void setReviewDetailList(List<String> reviewDetailList) {
		this.reviewDetailList = reviewDetailList;
	}
}
