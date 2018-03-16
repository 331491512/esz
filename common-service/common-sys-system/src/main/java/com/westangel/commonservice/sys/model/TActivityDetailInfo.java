/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.commonservice.sys.model;<br/>  
 * <b>文件名：</b>TActivityDetailInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月17日下午4:58:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.commonservice.sys.model;
/** 
* @ClassName: TActivityDetailInfo
* @Description:活动详情信息 
* @author lichenghao
* @date 2015年12月17日 下午4:58:10  
*/
public class TActivityDetailInfo {
	
	//活动ID
	private String activityId;
	
	//活动类型
	private Integer activityType;
	//活动标题
	private String subject;
	
	//分享标题
	private String activityContent;
	
	//活动介绍
	private String activityIntroduction;
	
	//活动要求填写
	private String required;
	
	//主讲人
	private String lecturer;
	
	//活动开始时间
	private String activityBeginTime;
	
	//活动结束时间
	private String activityEndTime;
	
	//活动地点
	private String activityPlace;
	
	//活动介绍 H5 url
	private String introductionUrl;
	
	//活动报道H5 url
	private String reportUrl;
	
	//活动状态
	private Integer state;
	
	//已报名人数
	private Integer signupCounter;
	
	//人数上限
	private Integer signupLimit;
	
	private Integer progressState;
	
	private Integer isPublish;

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getSubject() {
		return subject;
	}

	

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getActivityContent() {
		return activityContent;
	}

	public void setActivityContent(String activityContent) {
		this.activityContent = activityContent;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getActivityBeginTime() {
		return activityBeginTime;
	}

	public void setActivityBeginTime(String activityBeginTime) {
		this.activityBeginTime = activityBeginTime;
	}

	public String getActivityEndTime() {
		return activityEndTime;
	}

	public void setActivityEndTime(String activityEndTime) {
		this.activityEndTime = activityEndTime;
	}

	public String getActivityPlace() {
		return activityPlace;
	}

	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}

	public String getIntroductionUrl() {
		return introductionUrl;
	}

	public void setIntroductionUrl(String introductionUrl) {
		this.introductionUrl = introductionUrl;
	}

	public String getReportUrl() {
		return reportUrl;
	}

	public void setReportUrl(String reportUrl) {
		this.reportUrl = reportUrl;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSignupCounter() {
		return signupCounter;
	}

	public void setSignupCounter(Integer signupCounter) {
		this.signupCounter = signupCounter;
	}

	public Integer getSignupLimit() {
		return signupLimit;
	}

	public void setSignupLimit(Integer signupLimit) {
		this.signupLimit = signupLimit;
	}

	public String getActivityIntroduction() {
		return activityIntroduction;
	}

	public void setActivityIntroduction(String activityIntroduction) {
		this.activityIntroduction = activityIntroduction;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public Integer getProgressState() {
		return progressState;
	}

	public void setProgressState(Integer progressState) {
		this.progressState = progressState;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

	
	
}
