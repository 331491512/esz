package com.esuizhen.cloudservice.timertask.dao;

import java.util.LinkedHashMap;
import java.util.List;

public interface TimerTaskDao
{

	/**
	 * @author wang_hw
	 * @title :queryFollowupPlanDetailInfo
	 * @Description:根据随访计划ID查询随访计划
	 * @return LinkedHashMap<String,Object>
	 * @date 2016年1月8日 下午5:12:35
	 */
	public List<LinkedHashMap<String, Object>> queryFollowupPlanDetailInfo(String followupId);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupTaskCount
	 * @Description:查询随访计划是否生成过任务
	 * @return Integer
	 * @date 2016年1月27日 下午8:17:24
	 */
	public Integer queryTaskCount(LinkedHashMap<String, Object> param);
	/**
	 * @author wang_hw
	 * @title :queryProductServiceApplyDetailInfo
	 * @Description:根据服务申请ID查询服务信息
	 * @return List<LinkedHashMap<String,Object>>
	 * @date 2016年1月20日 下午5:37:24
	 */
	public LinkedHashMap<String, Object> queryProductServiceApplyDetailInfo(String productApplyId);
	
}
