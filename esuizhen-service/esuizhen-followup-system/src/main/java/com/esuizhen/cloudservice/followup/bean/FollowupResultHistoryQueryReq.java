/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupResultHistoryQueryReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月18日下午7:59:43<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: FollowupResultHistoryQueryReq
* @Description: 
* @author lichenghao
* @date 2016年10月18日 下午7:59:43  
*/
public class FollowupResultHistoryQueryReq {
	private String followupTimeStart;
	private String followupTimeEnd;
	private Integer followupType;
	private Integer followupWay;
	private Integer followupResultValue;
	private Long patientId;
	private Integer page;
	private Integer num;
	private Integer reqFlag;
	private Integer sortFlag;
	public String getFollowupTimeStart() {
		return followupTimeStart;
	}
	public void setFollowupTimeStart(String followupTimeStart) {
		this.followupTimeStart = followupTimeStart;
	}
	public String getFollowupTimeEnd() {
		return followupTimeEnd;
	}
	public void setFollowupTimeEnd(String followupTimeEnd) {
		this.followupTimeEnd = followupTimeEnd;
	}
	public Integer getFollowupType() {
		return followupType;
	}
	public void setFollowupType(Integer followupType) {
		this.followupType = followupType;
	}
	public Integer getFollowupWay() {
		return followupWay;
	}
	public void setFollowupWay(Integer followupWay) {
		this.followupWay = followupWay;
	}
	public Integer getFollowupResultValue() {
		return followupResultValue;
	}
	public void setFollowupResultValue(Integer followupResultValue) {
		this.followupResultValue = followupResultValue;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public Integer getSortFlag() {
		return sortFlag;
	}
	public void setSortFlag(Integer sortFlag) {
		this.sortFlag = sortFlag;
	}
}
