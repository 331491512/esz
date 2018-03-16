package com.westangel.common.bean.timertask;

import java.io.Serializable;
import java.util.Date;


public class Timertask implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8588085649675738166L;
	/**
	 * 任务ID。主键。
	 */
	private String timerTaskId;
	/**
	 * 用户ID
	 */
	private String userId;
	/**
	 * 业务目标ID
	 */
	private String serviceTargetId;
	/**
	 * 任务类型。
	 */
	private Integer taskType;
	/**
	 * 动作类型。
	 */
	private Integer actionType;
	/**
	 * 任务动作类型
	 */
	private String actionPushType;
	/**
	 * 任务内容
	 */
	private String pushContent;
	/**
	 * 任务执行后的回写SQL
	 */
	private String sqlContent;
	/**
	 * 微信推送通道
	 */
	private Integer wxProductId;
	/**
	 * 模版名称
	 */
	private String wxTemplateName;
	
	/**
	 * 模版URL
	 */
	private String wxTemplateUrl;
	/**
	 * 任务执行的存储过程
	 */
	private String procedureContent;
	/**
	 * Http调用url
	 */
	private String httpUrl;
	/**
	 * Http Json调用消息体
	 */
	private String httpContent;
	/**
	 * 业务类型
	 */
	private Integer serviceType;
	/**
	 * 任务执行日期
	 */
	private Date actionTime;
	
	/**
	 * 任务在当天几点执行
	 */
	private Date time;
	
	/**
	 * 任务标识
	 */
	private String taskTag;
	
	/**
	 * 最大调用数
	 */
	private Integer retry;
	
	/**
	 * 用户电话号码
	 */
	private String contactMobile;
	/**
	 * 创建日期
	 */
	private Date createTime;
	
	/**
	 * 1：按天（默认）；2：按周；3：按月；4：按年
	 */
	private Integer periodType;
	
	/**
	 * 周期公式
	 */
	private String expr;

	public void setTimerTaskId(String value) {
		this.timerTaskId = value;
	}
	
	public String getTimerTaskId() {
		return this.timerTaskId;
	}
	public void setTaskType(Integer value) {
		this.taskType = value;
	}
	
	public Integer getTaskType() {
		return this.taskType;
	}
	public void setActionType(Integer value) {
		this.actionType = value;
	}
	
	public Integer getActionType() {
		return this.actionType;
	}
	public void setActionPushType(String value) {
		this.actionPushType = value;
	}
	
	public String getActionPushType() {
		return this.actionPushType;
	}
	public void setPushContent(String value) {
		this.pushContent = value;
	}
	
	public String getPushContent() {
		return this.pushContent;
	}
	public void setSqlContent(String value) {
		this.sqlContent = value;
	}
	
	public String getSqlContent() {
		return this.sqlContent;
	}
	public void setProcedureContent(String value) {
		this.procedureContent = value;
	}
	
	public String getProcedureContent() {
		return this.procedureContent;
	}
	public void setHttpUrl(String value) {
		this.httpUrl = value;
	}
	
	public String getHttpUrl() {
		return this.httpUrl;
	}
	public void setHttpContent(String value) {
		this.httpContent = value;
	}
	
	public String getHttpContent() {
		return this.httpContent;
	}
	public void setServiceType(Integer value) {
		this.serviceType = value;
	}
	
	public Integer getServiceType() {
		return this.serviceType;
	}
	public void setActionTime(Date value) {
		this.actionTime = value;
	}
	
	public Date getActionTime() {
		return this.actionTime;
	}
	public String getUserId()
	{
		return userId;
	}
	public void setUserId(String userId)
	{
		this.userId = userId;
	}

	public String getServiceTargetId()
	{
		return serviceTargetId;
	}

	public void setServiceTargetId(String serviceTargetId)
	{
		this.serviceTargetId = serviceTargetId;
	}

	public String getWxTemplateName()
	{
		return wxTemplateName;
	}

	public void setWxTemplateName(String wxTemplateName)
	{
		this.wxTemplateName = wxTemplateName;
	}

	public String getWxTemplateUrl()
	{
		return wxTemplateUrl;
	}

	public void setWxTemplateUrl(String wxTemplateUrl)
	{
		this.wxTemplateUrl = wxTemplateUrl;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public String getTaskTag()
	{
		return taskTag;
	}

	public void setTaskTag(String taskTag)
	{
		this.taskTag = taskTag;
	}

	public Integer getRetry()
	{
		return retry;
	}

	public void setRetry(Integer retry)
	{
		this.retry = retry;
	}

	public String getContactMobile()
	{
		return contactMobile;
	}

	public void setContactMobile(String contactMobile)
	{
		this.contactMobile = contactMobile;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

	public Integer getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}

	public Integer getPeriodType() {
		return periodType;
	}

	public void setPeriodType(Integer periodType) {
		this.periodType = periodType;
	}

	public String getExpr() {
		return expr;
	}

	public void setExpr(String expr) {
		this.expr = expr;
	}
}

