package com.westangel.timertask.model;

public class OpPushQueryResult
{
 
	/**
	 * 文章ID
	 */
	private Integer articleId;
	
	/**
	 * 文章标题
	 */
	private String articleTitle;
	
	/**
	 * 规则ID
	 */
	private Integer pushRuleId;
	
	/**
	 * 患者ID
	 */
	private Long patientId;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 最新文章ID
	 */
	private String newPushArticleId;
	
	/**
	 * 全部文章ID（当前推送队列）
	 */
	private String allPushArticleIdJson;
	
	/**
	 * 已推送文章ID（当前推送队列）
	 */
	private String pushAtricleIdJson;

//	/**
//	 * 单次最大推送文章数
//	 */
//	private Integer pushArticleMaxNum;
	
	/**
	 * 推送文章队列ID
	 */
	private Integer pushResultQueueId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 备注
	 */
	private String bak;
	
	/**
	 * 推送次数
	 */
	private Integer pushTimes;
	
	/**
	 * 最多推送多少次
	 */
//	private Integer pushTime;
//	
	/**
	 * 是否使用标题
	 */
	private Integer isUseTitle;

	/**
	 * 推送结果
	 */
	private Integer pushResultId;

	public Integer getPushResultId() {
		return pushResultId;
	}

	public void setPushResultId(Integer pushResultId) {
		this.pushResultId = pushResultId;
	}

	public Integer getArticleId()
	{
		return articleId;
	}

	public void setArticleId(Integer articleId)
	{
		this.articleId = articleId;
	}

	public Integer getPushRuleId()
	{
		return pushRuleId;
	}

	public void setPushRuleId(Integer pushRuleId)
	{
		this.pushRuleId = pushRuleId;
	}

	public Long getPatientId()
	{
		return patientId;
	}

	public void setPatientId(Long patientId)
	{
		this.patientId = patientId;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getNewPushArticleId()
	{
		return newPushArticleId;
	}

	public void setNewPushArticleId(String newPushArticleId)
	{
		this.newPushArticleId = newPushArticleId;
	}

	public String getAllPushArticleIdJson()
	{
		return allPushArticleIdJson;
	}

	public void setAllPushArticleIdJson(String allPushArticleIdJson)
	{
		this.allPushArticleIdJson = allPushArticleIdJson;
	}

	public String getPushAtricleIdJson()
	{
		return pushAtricleIdJson;
	}

	public void setPushAtricleIdJson(String pushAtricleIdJson)
	{
		this.pushAtricleIdJson = pushAtricleIdJson;
	}

	public Integer getPushResultQueueId()
	{
		return pushResultQueueId;
	}

	public void setPushResultQueueId(Integer pushResultQueueId)
	{
		this.pushResultQueueId = pushResultQueueId;
	}

	public Integer getPushTimes()
	{
		return pushTimes;
	}

	public void setPushTimes(Integer pushTimes)
	{
		this.pushTimes = pushTimes;
	}

	public String getArticleTitle()
	{
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle)
	{
		this.articleTitle = articleTitle;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getBak()
	{
		return bak;
	}

	public void setBak(String bak)
	{
		this.bak = bak;
	}

	public Integer getIsUseTitle()
	{
		return isUseTitle;
	}

	public void setIsUseTitle(Integer isUseTitle)
	{
		this.isUseTitle = isUseTitle;
	}
	
	
}
