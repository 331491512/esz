package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.sync.model.QuestionnaireResult;


public interface QuestionnaireResultDao{
	
	/**
	 * @author wang_hw
	 * @title :selectFollowupQuestionnaireResult
	 * @Description:查看问卷结果
	 * @return List<TQuestionnaireResultSimpleInfo>
	 * @date 2015年12月11日 下午5:30:31
	 */
	public List<QuestionnaireResult> selectFollowupQuestionnaireResult(Integer hospitalId);
	
	/**
	 * 置问卷结果同步标识。
	 * @param paramMap
	 */
	void setQuestionnaireResultSyncFlag(Map<String, Object> paramMap);
}
