package com.esuizhen.cloudservice.followup.model.followup;

import java.util.Date;

/**
* @ClassName: TPatientSimpleInfo 
* @Description: 患者概要信息 
* @author wang_hw
* @date 2015年12月11日 下午2:13:20
 */
public class TPatientSimpleInfo
{
	/**
	 * 用户ID
	 */
	private Long userId	;
	
	/**
	 * 患者ID。
	 */
	private Long patientId;	
	
	/**
	 * 用户姓名
	 */
	private String trueName;
	
	/**
	 * 用户头像URL
	 */
	private String userPictureUrl;
	
	/**
	 * 出生日期
	 */
	private Date birthDate;	
	
	/**
	 * 0:未定义 1:男 2:女
	 */
	private Integer sex	;
	
	/**
	 * 原发诊断
	 */
	private String sourceDiagnosis;	
	
	/**
	 * 原发诊断编码
	 */
	private String sourceDiseaseCode;
	
	/**
	 * 原发病理诊断
	 */
	private String sourcePathologyDiagnosis;
	
	/**
	 * 原发病理诊断编码
	 */
	private String sourcePathologyDiseaseCode;
	
	/**
	 * 首次确诊日期
	 */
	private Date confirmedDate;	
	
	/**
	 * 患病时长(单位:月）
	 */
	private Integer confirmedMonths;
	
	/**
	 * 关注时间
	 */
	private Date attentionTime;
	
	/**
	 * 是否有病历
	 */
	private Integer hasVisibleMedicalRecord;
	
	/**
	 * 常规随访状态:0:待随访；1:随访进行中；2:已结束
	 */
	private Integer followupState;
	
	/**
	 * 随访结果。1	稳定2	复发3	转移4	死亡>=5	其他
	 */
	private Integer followupResultValue;
	
	/**
	 * 专题随访状态。0:无专题随访；1:专题随访进行中；2:专题随访已结束
	 */
	private Integer projectFollowupState;
	
	/**
	 * 是否VIP用户
	 */
	private Integer isVip;
	
	/**
	 * 分中心名称
	 */
	private String subcenterName;

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}

	public String getTrueName()
	{
		return trueName;
	}

	public void setTrueName(String trueName)
	{
		this.trueName = trueName;
	}

	public String getUserPictureUrl()
	{
		return userPictureUrl;
	}

	public void setUserPictureUrl(String userPictureUrl)
	{
		this.userPictureUrl = userPictureUrl;
	}

	public Date getBirthDate()
	{
		return birthDate;
	}

	public void setBirthDate(Date birthDate)
	{
		this.birthDate = birthDate;
	}

	public Integer getSex()
	{
		return sex;
	}

	public void setSex(Integer sex)
	{
		this.sex = sex;
	}

	public String getSourceDiagnosis()
	{
		return sourceDiagnosis;
	}

	public void setSourceDiagnosis(String sourceDiagnosis)
	{
		this.sourceDiagnosis = sourceDiagnosis;
	}

	public String getSourceDiseaseCode()
	{
		return sourceDiseaseCode;
	}

	public void setSourceDiseaseCode(String sourceDiseaseCode)
	{
		this.sourceDiseaseCode = sourceDiseaseCode;
	}

	public String getSourcePathologyDiagnosis()
	{
		return sourcePathologyDiagnosis;
	}

	public void setSourcePathologyDiagnosis(String sourcePathologyDiagnosis)
	{
		this.sourcePathologyDiagnosis = sourcePathologyDiagnosis;
	}

	public String getSourcePathologyDiseaseCode()
	{
		return sourcePathologyDiseaseCode;
	}

	public void setSourcePathologyDiseaseCode(String sourcePathologyDiseaseCode)
	{
		this.sourcePathologyDiseaseCode = sourcePathologyDiseaseCode;
	}

	public Date getConfirmedDate()
	{
		return confirmedDate;
	}

	public void setConfirmedDate(Date confirmedDate)
	{
		this.confirmedDate = confirmedDate;
	}

	public Integer getConfirmedMonths()
	{
		return confirmedMonths;
	}

	public void setConfirmedMonths(Integer confirmedMonths)
	{
		this.confirmedMonths = confirmedMonths;
	}

	public Date getAttentionTime()
	{
		return attentionTime;
	}

	public void setAttentionTime(Date attentionTime)
	{
		this.attentionTime = attentionTime;
	}

	public Integer getHasVisibleMedicalRecord()
	{
		return hasVisibleMedicalRecord;
	}

	public void setHasVisibleMedicalRecord(Integer hasVisibleMedicalRecord)
	{
		this.hasVisibleMedicalRecord = hasVisibleMedicalRecord;
	}

	public Integer getFollowupState()
	{
		return followupState;
	}

	public void setFollowupState(Integer followupState)
	{
		this.followupState = followupState;
	}

	public Integer getFollowupResultValue()
	{
		return followupResultValue;
	}

	public void setFollowupResultValue(Integer followupResultValue)
	{
		this.followupResultValue = followupResultValue;
	}

	public Integer getProjectFollowupState()
	{
		return projectFollowupState;
	}

	public void setProjectFollowupState(Integer projectFollowupState)
	{
		this.projectFollowupState = projectFollowupState;
	}

	public Integer getIsVip()
	{
		return isVip;
	}

	public void setIsVip(Integer isVip)
	{
		this.isVip = isVip;
	}

	public String getSubcenterName()
	{
		return subcenterName;
	}

	public void setSubcenterName(String subcenterName)
	{
		this.subcenterName = subcenterName;
	}

}
