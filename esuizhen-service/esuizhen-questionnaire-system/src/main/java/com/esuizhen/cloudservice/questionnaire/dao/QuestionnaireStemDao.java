package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireStem;

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
	
	/**
	* @author fanpanwei
	* @date 2017年8月22日
	* @param 
	* @description:获取Stemid根据StemType和questionnaireId
	* @return
	 */
	public List<String> getStemIdByStemType(@Param("questionnaireId") String questionnaireId,@Param("stemType") String stemType);
	
	/**
	 * 通过问卷查询题干和题支
	 * @param questionnaireId
	 * @return
	 */
	public List<TFollowupQuestionnaireStem> queryStemOptionsByQuestionnaireId(String questionnaireId);
}
