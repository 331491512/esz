package com.esuizhen.cloudservice.statistics.bean;

import java.io.Serializable;
import java.util.List;

/**
 * <p>Title:TQuestionnaireSurveyInfo</p>
 * <p>Description:调查问卷查询信息</p>
 * @author YYCHEN
 * @date 2016年9月1日 上午11:58:41
 */
public class TQuestionnaireOptionsStatisInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private String followupTaskId;
	//答案ID
	private String questionnaireOptionId;
	//调查问卷ID
	private String content;
	//问卷主题
	private Integer feedbackQuantity;
	//占比
	private Float feedbackRate;
	//层级等级
	private Integer level;
	//嵌套结果统计
	private List<TQuestionnaireOptionsStatisInfo> optionList;
	//嵌套题统计信息
	private List<TQuestionnaireStemStatisInfo> stemList;
	public Float getFeedbackRate() {
		return feedbackRate;
	}
	public void setFeedbackRate(Float feedbackRate) {
		this.feedbackRate = feedbackRate;
	}
	public String getQuestionnaireOptionId() {
		return questionnaireOptionId;
	}
	public void setQuestionnaireOptionId(String questionnaireOptionId) {
		this.questionnaireOptionId = questionnaireOptionId;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	public List<TQuestionnaireStemStatisInfo> getStemList() {
		return stemList;
	}
	public void setStemList(List<TQuestionnaireStemStatisInfo> stemList) {
		this.stemList = stemList;
	}
	public String getFollowupTaskId() {
		return followupTaskId;
	}
	public void setFollowupTaskId(String followupTaskId) {
		this.followupTaskId = followupTaskId;
	}
}
