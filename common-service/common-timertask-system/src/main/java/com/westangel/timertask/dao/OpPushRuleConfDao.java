package com.westangel.timertask.dao;

import com.westangel.timertask.model.OpPushQueryResult;
import com.westangel.timertask.model.OpPushRuleConf;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpPushRuleConfDao
{
	
	public void updateOpPushRuleConf(OpPushRuleConf opPushRuleConf);
	
	public List<OpPushRuleConf> queryOpPushRuleConfList();
	
	public List<OpPushQueryResult> queryPushList(OpPushRuleConf pushRule);
	
	public List<OpPushQueryResult> queryTestPushList(Long pushRuleId);
	
	public List<OpPushQueryResult> queryPushCircleList(Long pushRuleId);
	
	public String queryArticleTitle(Integer articleId);

	List<OpPushQueryResult> queryPushArticleList(@Param("pushArticle") List<Integer> pushArticle,
												 @Param("pushRuleId") Long pushRuleId, @Param("patientId")Long patientId);

}
