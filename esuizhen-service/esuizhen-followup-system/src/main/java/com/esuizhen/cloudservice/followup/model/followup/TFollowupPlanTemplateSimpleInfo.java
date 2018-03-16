package com.esuizhen.cloudservice.followup.model.followup;

/**
* @ClassName: TFollowupPlanTemplateSimpleInfo 
* @Description: 随访计划简要信息实体
* @author wang_hw
* @date 2015年12月9日 下午5:16:50
 */
public class TFollowupPlanTemplateSimpleInfo
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
	 * 是否公开。0：不公开；1：公开
	 */
	private Integer isPublic;
	
	/**
	 * 医院名称
	 */
	private String hospitalName;
	
	/**
	 * 创建人名称
	 */
	private String userName;
	
	/**
	 * 引用次数
	 */
	private Integer referenceCount;

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

	public Integer getIsPublic()
	{
		return isPublic;
	}

	public void setIsPublic(Integer isPublic)
	{
		this.isPublic = isPublic;
	}

	public String getHospitalName()
	{
		return hospitalName;
	}

	public void setHospitalName(String hospitalName)
	{
		this.hospitalName = hospitalName;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public Integer getReferenceCount()
	{
		return referenceCount;
	}

	public void setReferenceCount(Integer referenceCount)
	{
		this.referenceCount = referenceCount;
	}
}
