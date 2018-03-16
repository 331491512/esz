/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAlertPatientListGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月23日下午4:13:50<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ReviewAlertPatientListGetReq
* @Description: 
* @author lichenghao
* @date 2017年8月23日 下午4:13:50  
*/
public class ReviewAlertPatientListGetReq {
	private int page;
	private int num;
	//0：待提醒 1：已预约 2：赴约中
	private int reqFlag;
	private String reviewBatchId;
	//无reviewBatchId时 以此为准
	private Long doctorId;
	//范围  1：未来14天 -1之前14天
	private Integer domainFlag;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(int reqFlag) {
		this.reqFlag = reqFlag;
	}
	public String getReviewBatchId() {
		return reviewBatchId;
	}
	public void setReviewBatchId(String reviewBatchId) {
		this.reviewBatchId = reviewBatchId;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Integer getDomainFlag() {
		return domainFlag;
	}
	public void setDomainFlag(Integer domainFlag) {
		this.domainFlag = domainFlag;
	}
}
