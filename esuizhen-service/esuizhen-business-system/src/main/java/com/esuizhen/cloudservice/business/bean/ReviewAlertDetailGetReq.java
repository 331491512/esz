/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAlertDetailGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月28日下午1:56:56<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ReviewAlertDetailGetReq
* @Description: 
* @author lichenghao
* @date 2017年8月28日 下午1:56:56  
*/
public class ReviewAlertDetailGetReq {
	private String reviewDetailId;
	private Long patientId;
	private String reviewBatchId;
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
	public String getReviewBatchId() {
		return reviewBatchId;
	}
	public void setReviewBatchId(String reviewBatchId) {
		this.reviewBatchId = reviewBatchId;
	}
}
