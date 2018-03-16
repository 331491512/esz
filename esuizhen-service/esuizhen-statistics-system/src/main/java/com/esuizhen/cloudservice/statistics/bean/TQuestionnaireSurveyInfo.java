package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;

/**
 * <p>Title:TQuestionnaireSurveyInfo</p>
 * <p>Description:调查问卷查询信息</p>
 * @author YYCHEN
 * @date 2016年9月1日 上午11:58:41
 */
public class TQuestionnaireSurveyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//调查问卷ID
	private String questionnaireId;
	//问卷主题
	private String subject;
	//随访任务ID
	private String followupTaskId;
	//随访任务名称
	private String followupTaskName;
	//问卷反馈总数
	private Integer feedbackTotalQuantity;
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
	public String getFollowupTaskName() {
		return followupTaskName;
	}
	public void setFollowupTaskName(String followupTaskName) {
		this.followupTaskName = followupTaskName;
	}
	public Integer getFeedbackTotalQuantity() {
		return feedbackTotalQuantity;
	}
	public void setFeedbackTotalQuantity(Integer feedbackTotalQuantity) {
		this.feedbackTotalQuantity = feedbackTotalQuantity;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
}
