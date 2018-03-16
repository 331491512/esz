package com.esuizhen.cloudservice.followup.service.followupdo;

import com.esuizhen.cloudservice.followup.bean.FollowupResultLogReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupResultLog;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.westangel.common.bean.Page;

public interface FollowupResultLogService {
	/**
	 * 查询随访结果日志
	 */
	public void saveFollowupResultLog(TFollowupResultDetailInfo oldFollowupResult,TFollowupResultDetailInfo currFollowupResult, Integer actionType);

	/**
	 * 查询随访结果日志
	 */
	Page<TFollowupResultLog> queryFollowupResultLog(FollowupResultLogReq followupResultLogReq);
}
