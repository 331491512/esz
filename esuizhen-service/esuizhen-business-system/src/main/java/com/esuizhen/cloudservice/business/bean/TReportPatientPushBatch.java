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
import java.util.List;

/** 
* @ClassName: TReportPushBatch
* @Description: 
* @author lichenghao
* @date 2017年8月17日 下午3:40:44  
*/
public class TReportPatientPushBatch {
	private String reportPushBatchId;
	private Long userId;
	private Long patientId;
	private Integer pushState;
	private String failCause;
	private Integer	pushCount;
	private Integer pushItemCount;
	private Date pushTime;
	private Date createTime;
	private Date updateTime;
	private String openId;
	private List<TReportPatientPushBatchDetail> detailList;
	public String getReportPushBatchId() {
		return reportPushBatchId;
	}
	public void setReportPushBatchId(String reportPushBatchId) {
		this.reportPushBatchId = reportPushBatchId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPatientId() {
		return patientId;
	}
	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	public Integer getPushState() {
		return pushState;
	}
	public void setPushState(Integer pushState) {
		this.pushState = pushState;
	}
	
	public String getFailCause() {
		return failCause;
	}
	public void setFailCause(String failCause) {
		this.failCause = failCause;
	}
	public Integer getPushCount() {
		return pushCount;
	}
	public void setPushCount(Integer pushCount) {
		this.pushCount = pushCount;
	}
	public Integer getPushItemCount() {
		return pushItemCount;
	}
	public void setPushItemCount(Integer pushItemCount) {
		this.pushItemCount = pushItemCount;
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
	public List<TReportPatientPushBatchDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<TReportPatientPushBatchDetail> detailList) {
		this.detailList = detailList;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public Date getPushTime() {
		return pushTime;
	}
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
}
