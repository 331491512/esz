package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResult;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultOptionsDetail;


public interface QuestionnaireResultDao{
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireResult
	 * @Description:问卷保存
	 * @return void
	 * @date 2016年2月18日 下午2:21:10
	 */
	public void insertQuestionnaireResult(TQuestionnaireResult questionnaireResult);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireResult
	 * @Description:问卷修改
	 * @return void
	 * @date 2016年2月18日 下午2:21:29
	 */
	public void updateQuestionnaireResult(TQuestionnaireResult questionnaireResult);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireResult
	 * @Description:问卷删除
	 * @return void
	 * @date 2016年2月18日 下午2:21:32
	 */
	public void deleteQuestionnaireResult(String questionnaireResultId);
	/**
	 * 
	 * @author lichenghao
	 * @title :deleteQuestionnaireStemResult
	 * @Description:删除结果题干
	 * @return void
	 * @date 2016年9月8日 下午5:15:23
	 */
	public void deleteQuestionnaireStemResult(String questionnaireResultId);
	/**
	 * 
	 * @author lichenghao
	 * @title :deleteQuestionnaireOptionResult
	 * @Description:删除结果选项
	 * @return void
	 * @date 2016年9月8日 下午5:25:34
	 */
	public void deleteQuestionnaireOptionResult(String questionnaireResultId);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireResult
	 * @Description:问卷结果查询
	 * @return TQuestionnaireResult
	 * @date 2016年2月18日 下午2:21:49
	 */
	public TQuestionnaireResult queryQuestionnaireResult(Object obj);
	
	/**
	 * @author wang_hw
	 * @title :selectFollowupQuestionnaireResult
	 * @Description:查看问卷结果
	 * @return List<TQuestionnaireResultSimpleInfo>
	 * @date 2015年12月11日 下午5:30:31
	 */
	public List<TQuestionnaireResult> selectFollowupQuestionnaireResult(Map<String , Object> param);
	
	
	public List<TQuestionnaireResultOptionsDetail> queryResultOptionsDetail(Map<String , Object> param);
	/**
	 * @author wang_hw
	 * @title :queryPatientFollowupItemId
	 * @Description:查看患者归集follupItemId
	 * @return String
	 * @date 2016年2月18日 下午2:20:45
	 */
	public Map<String , String> queryPatientFollowupItemId(@Param("patientId")String patientId , @Param("followupItemId")String followupItemId);
	
	int existsQuestionnaireResult(Map<String , Object> paramsMap);
}
