package com.esuizhen.server.sync.dao.temp;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.FollowupResultBuffRes;
import com.esuizhen.server.sync.model.temp.SyncFollowupResultBuff;

public interface TempFollowupResultBuffDao {

	void insert(SyncFollowupResultBuff followupResultBuff);

    List<FollowupResultBuffRes> getSyncFollowupResultBuff(TBatchDetailInfo detail);
}
