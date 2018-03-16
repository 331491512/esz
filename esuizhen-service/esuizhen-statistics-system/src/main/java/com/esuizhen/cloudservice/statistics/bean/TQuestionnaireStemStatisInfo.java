package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:TQuestionnaireSurveyInfo</p>
 * <p>Description:调查问卷查询信息</p>
 * @author YYCHEN
 * @date 2016年9月1日 上午11:58:41
 */
public class TQuestionnaireStemStatisInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	//随访结果Id
	private String followupTaskId;
	//问题ID
	private String questionnaireStemId;
	
	private String content;
	//问题标题
	private String questionTitle;
	//问卷反馈数
	private Integer feedbackQuantity;
	//调查问卷选项统计信息
	private List<TQuestionnaireOptionsStatisInfo> optionList;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getQuestionnaireStemId() {
		return questionnaireStemId;
	}
	public void setQuestionnaireStemId(String questionnaireStemId) {
		this.questionnaireStemId = questionnaireStemId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public Integer getFeedbackQuantity() {
		return feedbackQuantity;
	}
	public void setFeedbackQuantity(Integer feedbackQuantity) {
		this.feedbackQuantity = feedbackQuantity;
	}
	public List<TQuestionnaireOptionsStatisInfo> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<TQuestionnaireOptionsStatisInfo> optionList) {
		this.optionList = optionList;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
}
