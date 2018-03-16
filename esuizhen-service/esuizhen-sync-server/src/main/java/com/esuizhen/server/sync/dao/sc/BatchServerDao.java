package com.esuizhen.server.sync.dao.sc;

import java.util.List;

import com.esuizhen.server.sync.bean.TBatchInfo;

public interface BatchServerDao {
	// 插入
	public int insert(Object obj);

	// 查询批次
	public TBatchInfo queryBatchInfo(Object obj);

	public int updateState(TBatchInfo batchInfo);
	//查询批量批次
	public List<TBatchInfo> queryBatchInfoList(Object params);
	//未处理完成的批次进行修改 将 3的修改为2
	public int updateUnfinishedProcessing();
	
	
}
