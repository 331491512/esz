package com.esuizhen.client.sync.dao.sc;

import java.util.List;
import java.util.Map;

import com.esuizhen.client.sync.model.TBatchDetailInfo;

public interface BatchDetailClientDao {
	//插入
	public int insert(Object obj);
	
	public TBatchDetailInfo queryBatchDetailInfo(Map<String, Object> params);
	
	public List<TBatchDetailInfo> queryBatchDetailList(Map<String, Object> params);

	public void updateState(TBatchDetailInfo detailInfo);
	
	public int updateCountNum(Object object);
}
