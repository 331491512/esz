package com.esuizhen.cloudservice.followup.dao.questionnaire;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.questionnaire.TFollowupQuestionnaireStem;

/**
* @ClassName: QuestionnaireStemDao 
* @Description: 问卷题干数据操作接口类
* @author wang_hw
* @date 2015年12月29日 下午4:26:43
 */
public interface QuestionnaireStemDao{
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireStem
	 * @Description:题干录入
	 * @return void
	 * @date 2015年12月29日 下午4:31:43
	 */
	public void insertQuestionnaireStem(TFollowupQuestionnaireStem questionnaireStem);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireStem
	 * @Description:题干修改
	 * @return void
	 * @date 2015年12月29日 下午4:32:07
	 */
	public void updateQuestionnaireStem(TFollowupQuestionnaireStem questionnaireStem);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireStem
	 * @Description:题干删除
	 * @return void
	 * @date 2015年12月29日 下午4:32:20
	 */
	public void deleteQuestionnaireStem(Long questionnaireStemId);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireStem
	 * @Description:题干查询
	 * @return TFollowupQuestionnaireStem
	 * @date 2015年12月29日 下午4:32:35
	 */
	public TFollowupQuestionnaireStem queryQuestionnaireStem(Long questionnaireStemId);
	
	/**
	 * @author wang_hw
	 * @title :queryStemByQuestionnaireId
	 * @Description:根据问卷ID查询题干
	 * @return List<TFollowupQuestionnaireStem>
	 * @date 2015年12月29日 下午5:35:49
	 */
	public List<TFollowupQuestionnaireStem> queryStemByQuestionnaireId(String questionnaireId);
	
	/**
	 * @author wang_hw
	 * @title :queryStemByAuthor
	 * @Description:查询常规随访计划
	 * @return List<TFollowupQuestionnaireStem>
	 * @date 2016年1月12日 下午5:48:59
	 */
	public List<TFollowupQuestionnaireStem> queryStemByAuthor(String patientId);
	
}
