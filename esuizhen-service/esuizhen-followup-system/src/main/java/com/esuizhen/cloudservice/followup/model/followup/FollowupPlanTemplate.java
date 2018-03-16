package com.esuizhen.cloudservice.followup.model.followup;

import java.util.Date;
import java.util.List;

/**
* @ClassName: FollowupPlanTemplate 
* @Description: 随访计划模版实体 
* @author wang_hw
* @date 2015年12月2日 下午6:59:00
 */
public class FollowupPlanTemplate
{
	/**
	 * 随访计划模板ID
	 */
	private String planTemplateId;
	
	/**
	 * 随访计划模板名称
	 */
	private String planTemplateName;
	
	/**
	 * 模板类型：1：常规随访模板；2：专题随访模板
	 */
	private Integer planTemplateType;
	
	/**
	 * 随访计划来源。常规随访计划为易随诊
	 */
	private String followupSource ;
	
	/**
	 * 随访计划模版描述
	 */
	private String followupDescrption;
	
	/**
	 * 随访计划对应的病种ID
	 */
	private Integer diseaseTypeId;
	
	/**
	 * 创建医生ID 9：表示系统内部创建。
	 */
	private Integer author;
	
	/**
	 * 是否公开。0：不公开；1：公开
	 */
	private Integer isPublic;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime;

	/**
	 * 随访计划模版详情
	 */
	private List<FollowupPlanTemplateDetialInfo> detailList;

	public FollowupPlanTemplate()
	{
		
	}
	public FollowupPlanTemplate(String planTemplateId, String planTemplateName, Integer planTemplateType, String followupSource, String followupDescrption, Integer diseaseTypeId, Integer author,
			Integer isPublic, Date createTime, Date updateTime, List<FollowupPlanTemplateDetialInfo> detailList)
	{
		this.planTemplateId = planTemplateId;
		this.planTemplateName = planTemplateName;
		this.planTemplateType = planTemplateType;
		this.followupSource = followupSource;
		this.followupDescrption = followupDescrption;
		this.diseaseTypeId = diseaseTypeId;
		this.author = author;
		this.isPublic = isPublic;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.detailList = detailList;
	}

	public String getPlanTemplateId()
	{
		return planTemplateId;
	}

	public void setPlanTemplateId(String planTemplateId)
	{
		this.planTemplateId = planTemplateId;
	}

	public String getPlanTemplateName()
	{
		return planTemplateName;
	}

	public void setPlanTemplateName(String planTemplateName)
	{
		this.planTemplateName = planTemplateName;
	}

	public Integer getPlanTemplateType()
	{
		return planTemplateType;
	}

	public void setPlanTemplateType(Integer planTemplateType)
	{
		this.planTemplateType = planTemplateType;
	}

	public Integer getAuthor()
	{
		return author;
	}

	public void setAuthor(Integer author)
	{
		this.author = author;
	}

	public Integer getIsPublic()
	{
		return isPublic;
	}

	public void setIsPublic(Integer isPublic)
	{
		this.isPublic = isPublic;
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

	
	public List<FollowupPlanTemplateDetialInfo> getDetailList()
	{
		return detailList;
	}

	public void setDetailList(List<FollowupPlanTemplateDetialInfo> detailList)
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

	
	public String getFollowupDescrption()
	{
		return followupDescrption;
	}

	public void setFollowupDescrption(String followupDescrption)
	{
		this.followupDescrption = followupDescrption;
	}

	public Integer getDiseaseTypeId()
	{
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId)
	{
		this.diseaseTypeId = diseaseTypeId;
	}

	@Override
	public String toString()
	{
		return "FollowupPlanTemplate [planTemplateId=" + planTemplateId + ", planTemplateName=" + planTemplateName + ", planTemplateType=" + planTemplateType + ", followupSource=" + followupSource
				+ ", followupDescrption=" + followupDescrption + ", diseaseTypeId=" + diseaseTypeId + ", author=" + author + ", isPublic=" + isPublic + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", detailList=" + detailList + "]";
	}

	
}
