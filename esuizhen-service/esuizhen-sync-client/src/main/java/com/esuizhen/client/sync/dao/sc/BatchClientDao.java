package com.esuizhen.client.sync.dao.sc;

import java.util.List;

import com.esuizhen.client.sync.model.TBatchInfo;

public interface BatchClientDao {
	// 插入
	public int insert(Object obj);

	// 查询批次
	public TBatchInfo queryBatchInfo(Object obj);
	
	//查询批次列表
	public List<TBatchInfo> queryBatchInfoList(Object obj);

	public int updateState(TBatchInfo batchInfo);
	// 修改未推送完成的批次 state=1 改为 state=0
	public void updateUnfinishedPush();
	
	
}
