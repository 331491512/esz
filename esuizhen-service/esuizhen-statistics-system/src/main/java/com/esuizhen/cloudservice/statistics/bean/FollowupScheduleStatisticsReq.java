 /**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean<br/>  
 * <b>文件名：</b>FollowupScheduleStatisticsReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年11月25日下午5:22:46<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.Date;
import java.util.List;

/** 
* @ClassName: FollowupScheduleStatisticsReq
* @Description: 
* @author NiDan
* @date 2016年11月25日下午5:22:46 
*/
public class FollowupScheduleStatisticsReq {
	/**
	 * 确诊开始日期
	 */
	private Date confirmBeginDate;
	/**
	 * 确诊结束日期
	 */
	private Date confirmEndDate;
	/**
	 * 随访开始日期
	 */
	private Date followupBeginDate;
	/**
	 * 随访结束日期
	 */
	private Date followupEndDate;
	
	private Integer followupRangeFlag;
	
	//add by fanpanwei
	private Integer includeDeathFlag;//已随访中是否包含随访前死亡的，1：包含，0：不包含
	private Integer calTaskFlag=0;//是否统计分配任务标识；0：不统计，1：统计
	private String sourceTumorFlags;
	
	public Date getConfirmBeginDate() {
		return confirmBeginDate;
	}
	public void setConfirmBeginDate(Date confirmBeginDate) {
		this.confirmBeginDate = confirmBeginDate;
	}
	public Date getConfirmEndDate() {
		return confirmEndDate;
	}
	public void setConfirmEndDate(Date confirmEndDate) {
		this.confirmEndDate = confirmEndDate;
	}
	public Date getFollowupBeginDate() {
		return followupBeginDate;
	}
	public void setFollowupBeginDate(Date followupBeginDate) {
		this.followupBeginDate = followupBeginDate;
	}
	public Date getFollowupEndDate() {
		return followupEndDate;
	}
	public void setFollowupEndDate(Date followupEndDate) {
		this.followupEndDate = followupEndDate;
	}
	public Integer getIncludeDeathFlag() {
		return includeDeathFlag;
	}
	public void setIncludeDeathFlag(Integer includeDeathFlag) {
		this.includeDeathFlag = includeDeathFlag;
	}
	public Integer getCalTaskFlag() {
		return calTaskFlag;
	}
	public void setCalTaskFlag(Integer calTaskFlag) {
		this.calTaskFlag = calTaskFlag;
	}
	public String getSourceTumorSplit() {
		return this.sourceTumorFlags;
	}
	public void setSourceTumorFlags(String sourceTumorFlags) {
		this.sourceTumorFlags = sourceTumorFlags;
	}
	public Integer getFollowupRangeFlag() {
		return followupRangeFlag;
	}
	public void setFollowupRangeFlag(Integer followupRangeFlag) {
		this.followupRangeFlag = followupRangeFlag;
	}
		
}
