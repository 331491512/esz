package com.esuizhen.cloudservice.followup.dao.questionnaire;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.questionnaire.TQuestionnaireResultStem;

/**
* @ClassName: QuestionnaireResultStemDao 
* @Description: 问卷结果题干数据操作接口 
* @author wang_hw
* @date 2015年12月30日 下午3:44:46
 */
public interface QuestionnaireResultStemDao{
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireResultStem
	 * @Description:录入问卷结果题干
	 * @return void
	 * @date 2015年12月30日 下午3:45:31
	 */
	public void insertQuestionnaireResultStem(TQuestionnaireResultStem questionnaireResultStem);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireResultStem
	 * @Description:修改问卷结果题干
	 * @return void
	 * @date 2015年12月30日 下午3:46:36
	 */
	public void updateQuestionnaireResultStem(TQuestionnaireResultStem questionnaireResultStem);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireResultStem
	 * @Description:删除问卷结果
	 * @return void
	 * @date 2015年12月30日 下午3:46:56
	 */
	public void deleteQuestionnaireResultStem(Long questionnaireResultStemId);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireResultStem
	 * @Description:根据ID查询结果题干
	 * @return TQuestionnaireResultStem
	 * @date 2015年12月30日 下午3:59:59
	 */
	public TQuestionnaireResultStem queryQuestionnaireResultStem(Long questionnaireResultStemId);
	
	/**
	 * @author wang_hw
	 * @title :queryResultStemByQuestionnaireId
	 * @Description:根据问卷ID查询问题题干
	 * @return List<TQuestionnaireResultStem>
	 * @date 2015年12月30日 下午4:00:50
	 */
	public List<TQuestionnaireResultStem> queryResultStemByQuestionnaireId(@Param("questionnaireResultId") String questionnaireResultId , @Param("followupItemId") String followupItemId);
}
