package com.esuizhen.cloudservice.followup.model.followup;

import java.util.Date;

/**
* @ClassName: TFollowupPlanDetialInfo 
* @Description: 随访计划明细实体
* @author wang_hw
* @date 2015年12月10日 下午5:21:16
 */
public class TFollowupPlanDetialInfo
{
	/**
	 * 随访计划项ID
	 */
	private String followupItemId;
	
	/**
	 * 随访计划ID
	 */
	private String followupId;
	
	/**
	 * 模板索引项
	 */
	private Integer planTemplateItemIndex;
	
	/**
	 * 随访日期
	 */
	private Date followupDate;
	
	/**
	 * 0：随访计划开启；1：康复知识；2：复查提醒；3：随访问卷
	 */
	private String actionType;
	
	/**
	 * 随访计划名称
	 */
	private String actionTypeName;
	
	/**
	 * 距离月份
	 */
	private int intervalMonths;
	/**
	 * 随访提醒内容
	 */
	private String content;
	
	/**
	 * 患者ID
	 */
	private Long patientId;
	/**
	 * 距离天数
	 */
	private int intervalDays;
	
	/**
	 * 是否已发送提醒。0：未发送提醒1：已发送提醒
	 */
	private Integer isAlertSent;
	
	/**
	 * 是否收到调查问卷反馈（对于调查问卷有效）0：未收到反馈；1：已收到反馈。
	 */
	private Integer isSurveryFeedback;
	
	/**
	 * 提示消息
	 */
	private String intervalDaysTips;
	
	/**
	 * 问卷地址
	 */
	private String questionnaireUrl;
	
	/**
	 * 问卷地址
	 */
	private String questionnaireResultUrl;
	
	/**
	 * 首次确诊日期
	 */
	private String confirmedDate;
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 随访计划模版ID
	 */
	private String planTemplateId;
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	public String getFollowupItemId()
	{
		return followupItemId;
	}

	public void setFollowupItemId(String followupItemId)
	{
		this.followupItemId = followupItemId;
	}

	public String getFollowupId()
	{
		return followupId;
	}

	public void setFollowupId(String followupId)
	{
		this.followupId = followupId;
	}

	public Integer getPlanTemplateItemIndex()
	{
		return planTemplateItemIndex;
	}

	public void setPlanTemplateItemIndex(Integer planTemplateItemIndex)
	{
		this.planTemplateItemIndex = planTemplateItemIndex;
	}

	public Date getFollowupDate()
	{
		return followupDate;
	}

	public void setFollowupDate(Date followupDate)
	{
		this.followupDate = followupDate;
	}

	public int getIntervalDays()
	{
		return intervalDays;
	}

	public void setIntervalDays(int intervalDays)
	{
		this.intervalDays = intervalDays;
	}

	public Integer getIsAlertSent()
	{
		return isAlertSent;
	}

	public void setIsAlertSent(Integer isAlertSent)
	{
		this.isAlertSent = isAlertSent;
	}

	public Integer getIsSurveryFeedback()
	{
		return isSurveryFeedback;
	}

	public void setIsSurveryFeedback(Integer isSurveryFeedback)
	{
		this.isSurveryFeedback = isSurveryFeedback;
	}

	public String getIntervalDaysTips()
	{
		return intervalDaysTips;
	}

	public void setIntervalDaysTips(String intervalDaysTips)
	{
		this.intervalDaysTips = intervalDaysTips;
	}

	public String getQuestionnaireUrl()
	{
		return questionnaireUrl;
	}

	public void setQuestionnaireUrl(String questionnaireUrl)
	{
		this.questionnaireUrl = questionnaireUrl;
	}

	public String getQuestionnaireResultUrl()
	{
		return questionnaireResultUrl;
	}

	public void setQuestionnaireResultUrl(String questionnaireResultUrl)
	{
		this.questionnaireResultUrl = questionnaireResultUrl;
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

	public String getActionType()
	{
		return actionType;
	}

	public void setActionType(String actionType)
	{
		this.actionType = actionType;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getActionTypeName()
	{
		return actionTypeName;
	}

	public void setActionTypeName(String actionTypeName)
	{
		this.actionTypeName = actionTypeName;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}

	public String getConfirmedDate()
	{
		return confirmedDate;
	}

	public void setConfirmedDate(String confirmedDate)
	{
		this.confirmedDate = confirmedDate;
	}

	public String getPlanTemplateId()
	{
		return planTemplateId;
	}

	public void setPlanTemplateId(String planTemplateId)
	{
		this.planTemplateId = planTemplateId;
	}

	public int getIntervalMonths()
	{
		return intervalMonths;
	}

	public void setIntervalMonths(int intervalMonths)
	{
		this.intervalMonths = intervalMonths;
	}
	
	

}
