package com.esuizhen.server.sync.service;

import java.util.List;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;

public interface DataSyncService {
	//数据推送
    public void pushBatchData(BatchDataPushReq req);
    //结果获取
    public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req);
    //数据异步处理
    public void dataProcessSync(TBatchDetailInfo detail);
}
