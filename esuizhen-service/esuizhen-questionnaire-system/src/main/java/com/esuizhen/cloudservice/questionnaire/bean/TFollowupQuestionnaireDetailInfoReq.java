/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean<br/>  
 * <b>文件名：</b>TFollowupQuestionnaireDetailInfoReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月24日上午11:55:27<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.questionnaire.bean;

import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.questionnaire.model.TFollowupContentTemplateInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireStem;

/** 
* @ClassName: TFollowupQuestionnaireDetailInfoReq
* @Description: 
* @author NiDan
* @date 2016年8月24日上午11:55:27 
*/
public class TFollowupQuestionnaireDetailInfoReq {
	
	private String questionnaireId;//问卷ID
	
	private String subject;//问卷主题
	
	private String description;// 问卷描述

	private String contentTemplateId;//随访内容模板Id
	
	/**
	 * 随访内容模板
	 */
	private TFollowupContentTemplateInfo contentTemplateInfo;

	private String followupTaskId;//随访任务Id
	
	private Integer isPublish;//是否公开。0：否；1：是
	
	private Integer author;//创建医生ID。9：表示系统内部创建。（如常规随访问卷）
	
	private Date createTime;//记录创建时间
	
	private Date updateTime;//记录更新时间

	private List<TFollowupQuestionnaireStem> stemList;//问卷明细
	
	private int type;
	public String getQuestionnaireId() {
		return questionnaireId;
	}

	public void setQuestionnaireId(String questionnaireId) {
		this.questionnaireId = questionnaireId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContentTemplateId() {
		return contentTemplateId;
	}

	public void setContentTemplateId(String contentTemplateId) {
		this.contentTemplateId = contentTemplateId;
	}

	public String getFollowupTaskId() {
		return followupTaskId;
	}

	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}

	public Integer getIsPublish() {
		return isPublish;
	}

	public void setIsPublish(Integer isPublish) {
		this.isPublish = isPublish;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public List<TFollowupQuestionnaireStem> getStemList() {
		return stemList;
	}

	public void setStemList(List<TFollowupQuestionnaireStem> stemList) {
		this.stemList = stemList;
	}

	public TFollowupContentTemplateInfo getContentTemplateInfo() {
		return contentTemplateInfo;
	}

	public void setContentTemplateInfo(
			TFollowupContentTemplateInfo contentTemplateInfo) {
		this.contentTemplateInfo = contentTemplateInfo;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
