package com.esuizhen.cloudservice.followup.model.questionnaire;

import java.util.List;


/**
 * 
* @ClassName: TFollowupQuestionnaireTile 
* @Description: 问卷标题 
* @author wang_hw
* @date 2015年12月7日 上午11:04:23
 */
public class TFollowupQuestionnaireTitle
{
	/**
	 * 标题名称
	 */
	private String title;
	
	/**
	 * 标题中问题列表
	 */
	private List<TFollowupQuestionnaireStem> questionnaireList;

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public List<TFollowupQuestionnaireStem> getQuestionnaireList()
	{
		return questionnaireList;
	}

	public void setQuestionnaireList(List<TFollowupQuestionnaireStem> questionnaireList)
	{
		this.questionnaireList = questionnaireList;
	}
	
	
	
}
