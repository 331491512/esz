package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultOptionsDetail;

/**
* @ClassName: QuestionnaireResultOptionsDetailDao 
* @Description: 问题结果选项数据操作接口
* @author wang_hw
* @date 2015年12月30日 下午4:30:10
 */
public interface QuestionnaireResultOptionsDetailDao{
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireResultOptionsDetail
	 * @Description:录入结果选项
	 * @return void
	 * @date 2015年12月30日 下午4:30:47
	 */
	public void insertQuestionnaireResultOptionsDetail(TQuestionnaireResultOptionsDetail questionnaireResultOptionsDetail);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireResultOptionsDetail
	 * @Description:修改结果选项
	 * @return void
	 * @date 2015年12月30日 下午4:31:00
	 */
	public void updateQuestionnaireResultOptionsDetail(TQuestionnaireResultOptionsDetail questionnaireResultOptionsDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireResultOptionsDetail
	 * @Description:删除结果选项
	 * @return void
	 * @date 2015年12月30日 下午4:31:50
	 */
	public void deleteQuestionnaireResultOptionsDetail(Long questionnaireResultOptionsDetailId);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireResultOptionsDetail
	 * @Description:根据问题ID查询
	 * @return TQuestionnaireResultOptionsDetail
	 * @date 2015年12月30日 下午4:32:04
	 */
	public TQuestionnaireResultOptionsDetail queryQuestionnaireResultOptionsDetail(Long questionnaireResultOptionsDetailId);
	
	/**
	 * @author wang_hw
	 * @title :queryResultOptionsDetailByResultStemId
	 * @Description:根据题干ID查询结果选项
	 * @return List<TQuestionnaireResultOptionsDetail>
	 * @date 2015年12月30日 下午4:36:40
	 */
	public List<TQuestionnaireResultOptionsDetail> queryResultOptionsDetailByResultStemId(String questionnaireResultStemId);
	
	/**
	 * @author wang_hw
	 * @title :queryResultOptionsDetailByParentOptionId
	 * @Description:TODO
	 * @return List<TQuestionnaireResultOptionsDetail>
	 * @date 2015年12月30日 下午4:37:13
	 */
	public List<TQuestionnaireResultOptionsDetail> queryResultOptionsDetailByParentOptionId(String parentOptionId);
	
	void batchInsertQuestionnaireResultOptionsDetail(Map<String, Object> paramsMap);
	
}
