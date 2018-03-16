/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>MonitorFollowupAlert.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午3:59:33<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date;

/**
 * @ClassName: MonitorFollowupAlert.java
 * @Description: 随访提醒实体
 * @author lichenghao
 * @date 2015年12月12日 下午3:59:33
 */
public class MonitorFollowupAlert {

	/**
	 * 随访提醒ID
	 */
	private Long followupAlertId;

	/**
	 * 随访计划ID
	 */
	private String followupId;

	/**
	 * 随访详情项ID
	 */
	private Long followupItemId;

	/**
	 * 随访日期
	 */
	private Date followupDate;

	/**
	 * 提醒时间。定时任务据此进行提醒触发
	 */
	private Date followupAlertTime;

	/**
	 * 记录创建时间
	 */
	private Date createTime;

	public Long getFollowupAlertId() {
		return followupAlertId;
	}

	public void setFollowupAlertId(Long followupAlertId) {
		this.followupAlertId = followupAlertId;
	}

	public String getFollowupId() {
		return followupId;
	}

	public void setFollowupId(String followupId) {
		this.followupId = followupId;
	}

	public Long getFollowupItemId() {
		return followupItemId;
	}

	public void setFollowupItemId(Long followupItemId) {
		this.followupItemId = followupItemId;
	}

	public Date getFollowupDate() {
		return followupDate;
	}

	public void setFollowupDate(Date followupDate) {
		this.followupDate = followupDate;
	}

	public Date getFollowupAlertTime() {
		return followupAlertTime;
	}

	public void setFollowupAlertTime(Date followupAlertTime) {
		this.followupAlertTime = followupAlertTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
