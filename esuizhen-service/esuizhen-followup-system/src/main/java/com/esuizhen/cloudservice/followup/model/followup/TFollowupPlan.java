package com.esuizhen.cloudservice.followup.model.followup;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
* @ClassName: TFollowupPlan 
* @Description: 随访计划实体
* @author wang_hw
* @date 2015年12月10日 下午5:20:51
 */
public class TFollowupPlan
{
	/**
	 * 随访计划ID
	 */
	private String followupId ;
	
	/**
	 * 数据更新索引
	 */
	private Long cacheIndex ;
	
	/**
	 * 随访计划名称
	 */
	private String followupName ;
	
	/**
	 * 随访计划介绍
	 */
	private String followupDescription;
	
	/**
	 * 随访计划类型。1：常规随访；2：专题随访
	 */
	private Integer followupType ;
	
	/**
	 * 随访计划来源。常规随访计划为易随诊
	 */
	private String followupSource ;
	
	/**
	 * 患者姓名
	 */
	private String trueName;
	
	/**
	 * 原发诊断
	 */
	private String sourceDiagnosis;
	/**
	 * 患者ID
	 */
	private String patientId ;
	
	/**
	 * 随访模板ID。followup_plan_template.planTemplateId
	 */
	private String planTemplateId ;
	
	/**
	 * 状态：0：待随访；1：随访中； 2：已结束
	 */
	private Integer state ;
	
	/**
	 * 首次确诊日期
	 */
	private Date confirmedDate ;
	
	/**
	 * 随访计划开启时间
	 */
	private Date startTime ;
	
	/**
	 * 随访计划执行到的天数
	 */
	private Integer currPerformDays ;
	
	/**
	 * 最近一次提醒信息
	 */
	private String alertText ;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime ;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime ;
	
	/**
	 * 未反馈问卷
	 */
	private Integer noFeedbackNum;
	
	/**
	 * 最后一次出院日期
	 */
	private Date outHospitalDate;
	
	/**
	 * 上一次复查时间
	 */
	private Date beforAlterDate;
	
	/**
	 * 最近一次复查时间
	 */
	private Date afterAlterDate;

	/**
	 * 随访计划明细列表
	 */
	private List<TFollowupPlanDetialInfo> detailList;
	
	public String getFollowupId()
	{
		return followupId;
	}

	public void setFollowupId(String followupId)
	{
		this.followupId = followupId;
	}

	public Long getCacheIndex()
	{
		return cacheIndex;
	}

	public void setCacheIndex(Long cacheIndex)
	{
		this.cacheIndex = cacheIndex;
	}

	public String getFollowupName()
	{
		return followupName;
	}

	public void setFollowupName(String followupName)
	{
		this.followupName = followupName;
	}

	public String getFollowupDescription()
	{
		return followupDescription;
	}

	public void setFollowupDescription(String followupDescription)
	{
		this.followupDescription = followupDescription;
	}

	public Integer getFollowupType()
	{
		return followupType;
	}

	public void setFollowupType(Integer followupType)
	{
		this.followupType = followupType;
	}

	public String getPatientId()
	{
		return patientId;
	}

	public void setPatientId(String patientId)
	{
		this.patientId = patientId;
	}

	public String getPlanTemplateId()
	{
		return planTemplateId;
	}

	public void setPlanTemplateId(String planTemplateId)
	{
		this.planTemplateId = planTemplateId;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Date getConfirmedDate()
	{
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate)
	{
		this.confirmedDate = confirmedDate;
	}

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Integer getCurrPerformDays()
	{
		return currPerformDays;
	}

	public void setCurrPerformDays(Integer currPerformDays)
	{
		this.currPerformDays = currPerformDays;
	}

	public String getAlertText()
	{
		return alertText;
	}

	public void setAlertText(String alertText)
	{
		this.alertText = alertText;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public List<TFollowupPlanDetialInfo> getDetailList()
	{
		return detailList;
	}

	public void setDetailList(List<TFollowupPlanDetialInfo> detailList)
	{
		this.detailList = detailList;
	}

	public String getFollowupSource()
	{
		return followupSource;
	}

	public void setFollowupSource(String followupSource)
	{
		this.followupSource = followupSource;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public String getSourceDiagnosis()
	{
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis)
	{
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public Integer getNoFeedbackNum() {
		return noFeedbackNum;
	}

	public void setNoFeedbackNum(Integer noFeedbackNum) {
		this.noFeedbackNum = noFeedbackNum;
	}

	public Date getOutHospitalDate() {
		return outHospitalDate;
	}

	public void setOutHospitalDate(Date outHospitalDate) {
		this.outHospitalDate = outHospitalDate;
	}

	public Date getBeforAlterDate() {
		return beforAlterDate;
	}

	public void setBeforAlterDate(Date beforAlterDate) {
		this.beforAlterDate = beforAlterDate;
	}

	public Date getAfterAlterDate() {
		return afterAlterDate;
	}

	public void setAfterAlterDate(Date afterAlterDate) {
		this.afterAlterDate = afterAlterDate;
	}
}
