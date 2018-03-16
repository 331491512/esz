package com.esuizhen.cloudservice.followup.model.followup;

import java.io.Serializable;
import java.util.Date;

/**
* @ClassName: FollowupPlanTemplateDetialInfo 
* @Description: 随访计划模版详情
* @author wang_hw
* @date 2015年12月3日 下午2:01:57
 */
public class FollowupPlanTemplateDetialInfo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1780762436233367955L;
	
	/**
	 * 随访计划模板详情项ID
	 */
	private String planTemplateItemId ;
	
	/**
	 * 随访计划模板ID
	 */
	private String planTemplateId ;
	
	/**
	 * 随访项索引。第 n 次随访。从1开始编号
	 */
	private Integer planTemplateItemIndex ;
	
	/**
	 * 距离天数
	 */
	private Integer intervalDays ;
	
	/**
	 * 提示。如“术后2天”
	 */
	private String intervalDaysTips ;
	
	/**
	 * 动作类型。0：随访计划开启；1：康复知识；2：复查提醒；3：随访问卷
	 */
	private Integer actionType ;
	
	/**
	 * 距离月份
	 */
	private Integer intervalMonths;
	
	/**
	 * 随访提醒内容
	 */
	private String content ;
	
	/**
	 * 记录创建时间（如第一次上传时间）
	 */
	private Date createTime ;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime ;

	public FollowupPlanTemplateDetialInfo()
	{
		
	}
	
	public FollowupPlanTemplateDetialInfo(String planTemplateItemId, String planTemplateId, Integer planTemplateItemIndex, Integer intervalDays, String intervalDaysTips, Integer actionType,
			Integer intervalMonths, String content, Date createTime, Date updateTime)
	{
		super();
		this.planTemplateItemId = planTemplateItemId;
		this.planTemplateId = planTemplateId;
		this.planTemplateItemIndex = planTemplateItemIndex;
		this.intervalDays = intervalDays;
		this.intervalDaysTips = intervalDaysTips;
		this.actionType = actionType;
		this.intervalMonths = intervalMonths;
		this.content = content;
		this.createTime = createTime;
		this.updateTime = updateTime;
	}

	public String getPlanTemplateItemId()
	{
		return planTemplateItemId;
	}

	public void setPlanTemplateItemId(String planTemplateItemId)
	{
		this.planTemplateItemId = planTemplateItemId;
	}

	public String getPlanTemplateId()
	{
		return planTemplateId;
	}

	public void setPlanTemplateId(String planTemplateId)
	{
		this.planTemplateId = planTemplateId;
	}

	public Integer getPlanTemplateItemIndex()
	{
		return planTemplateItemIndex;
	}

	public void setPlanTemplateItemIndex(Integer planTemplateItemIndex)
	{
		this.planTemplateItemIndex = planTemplateItemIndex;
	}

	public Integer getIntervalDays()
	{
		return intervalDays;
	}

	public void setIntervalDays(Integer intervalDays)
	{
		this.intervalDays = intervalDays;
	}

	public String getIntervalDaysTips()
	{
		return intervalDaysTips;
	}

	public void setIntervalDaysTips(String intervalDaysTips)
	{
		this.intervalDaysTips = intervalDaysTips;
	}

	public Integer getActionType()
	{
		return actionType;
	}

	public void setActionType(Integer actionType)
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

	public Integer getIntervalMonths()
	{
		return intervalMonths;
	}

	public void setIntervalMonths(Integer intervalMonths)
	{
		this.intervalMonths = intervalMonths;
	}

	@Override
	public String toString()
	{
		return "FollowupPlanTemplateDetialInfo [planTemplateItemId=" + planTemplateItemId + ", planTemplateId=" + planTemplateId + ", planTemplateItemIndex=" + planTemplateItemIndex
				+ ", intervalDays=" + intervalDays + ", intervalDaysTips=" + intervalDaysTips + ", actionType=" + actionType + ", intervalMonths=" + intervalMonths + ", content=" + content
				+ ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}

	
}
