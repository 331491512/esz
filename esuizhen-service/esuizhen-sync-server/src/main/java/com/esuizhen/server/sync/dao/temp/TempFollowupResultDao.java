package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.FollowupResultRes;
import com.esuizhen.server.sync.model.temp.SyncFollowupResult;

public interface TempFollowupResultDao {

	void insert(SyncFollowupResult followupResult);

	List<FollowupResultRes> getSyncFollowupResult(TBatchDetailInfo detail);
	
}
