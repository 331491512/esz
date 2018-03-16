package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.QuestionnaireResultStem;

/**
* @ClassName: QuestionnaireResultStemDao 
* @Description: 问卷结果题干数据操作接口 
* @author wang_hw
* @date 2015年12月30日 下午3:44:46
 */
public interface QuestionnaireResultStemDao{
	/**
	 * 查询问卷结果题干
	 * @param questionnaireResultId
	 * @return
	 */
	public List<QuestionnaireResultStem> queryQuestionnaireResultStemByResultId(@Param("questionnaireResultId") String questionnaireResultId);
}
