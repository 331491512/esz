package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import com.esuizhen.cloudservice.sync.model.QuestionnaireResultOptionsDetail;

/**
* @ClassName: QuestionnaireResultOptionsDetailDao 
* @Description: 问题结果选项数据操作接口
* @author wang_hw
* @date 2015年12月30日 下午4:30:10
 */
public interface QuestionnaireResultOptionsDetailDao{
	
	
	
	/**
	 * @author wang_hw
	 * @title :queryResultOptionsDetailByResultStemId
	 * @Description:根据题干ID查询结果选项
	 * @return List<TQuestionnaireResultOptionsDetail>
	 * @date 2015年12月30日 下午4:36:40
	 */
	public List<QuestionnaireResultOptionsDetail> queryResultOptionsDetailByResultStemId(String questionnaireResultStemId);
	
}
