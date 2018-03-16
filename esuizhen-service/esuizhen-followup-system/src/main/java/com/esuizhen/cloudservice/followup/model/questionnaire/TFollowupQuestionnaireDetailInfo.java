package com.esuizhen.cloudservice.followup.model.questionnaire;

import java.util.Date;
import java.util.List;

/**
* @ClassName: TFollowupQuestionnaireDetailInfo 
* @Description: 问卷主表实体 
* @author wang_hw
* @date 2015年12月7日 上午10:59:36
 */
public class TFollowupQuestionnaireDetailInfo
{
	/**
	 * 问卷ID
	 */
	private String questionnaireId;
	
	/**
	 * 问卷主题
	 */
	private String subject;
	
	/**
	 * 随访内容模板Id
	 */
	private String contentTemplateId;

	/**
	 * 随访任务Id
	 */
	private String followupTaskId;
	
	/**
	 * 问卷描述
	 */
	private String description;
	
	/**
	 * 是否公开。0：否；1：是
	 */
	private Integer isPublish ;
	
	/**
	 * 创建医生ID。9：表示系统内部创建。（如常规随访问卷）
	 */
	private Integer author;
	
	/**
	 * 创建医生名称
	 */
	private String authorName;
	
	/**
	 * 记录创建时间
	 */
	private Date createTime;
	
	/**
	 * 记录更新时间
	 */
	private Date updateTime;
	
	/**
	 * 问题描述列表
	 */
	private List<TFollowupQuestionnaireStem> stemList;//问卷明细
	
	/**
	 * 此值为1前端不能发起删除操作
	 */
	private Integer isInUsage;

	public String getQuestionnaireId()
	{
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId)
	{
		this.questionnaireId = questionnaireId;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	public String getContentTemplateId() 
	{
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId)
	{
		this.contentTemplateId = contentTemplateId;
	}

	public String getFollowupTaskId()
	{
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) 
	{
		this.followupTaskId = followupTaskId;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public Integer getIsPublish()
	{
		return isPublish;
	}

	public void setIsPublish(Integer isPublish)
	{
		this.isPublish = isPublish;
	}

	public Integer getAuthor()
	{
		return author;
	}

	public void setAuthor(Integer author)
	{
		this.author = author;
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

	public List<TFollowupQuestionnaireStem> getStemList() {
		return stemList;
	}

	public void setStemList(List<TFollowupQuestionnaireStem> stemList) {
		this.stemList = stemList;
	}

	public Integer getIsInUsage() {
		return isInUsage;
	}

	public void setIsInUsage(Integer isInUsage) {
		this.isInUsage = isInUsage;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
