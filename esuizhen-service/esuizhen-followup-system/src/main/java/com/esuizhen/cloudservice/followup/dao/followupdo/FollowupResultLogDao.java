package com.esuizhen.cloudservice.followup.dao.followupdo;

import java.util.List;

import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupResultLog;

public interface FollowupResultLogDao {
	/**
	 * 插入随访结果日志
	 */
	public void insertFollowupResultLog(TFollowupResultLog followupResultLog);
	
	/**
	 * 查询随访结果日志
	 */
	public List<TFollowupResultLog> queryFollowupResultLog(Long patientId);
}
