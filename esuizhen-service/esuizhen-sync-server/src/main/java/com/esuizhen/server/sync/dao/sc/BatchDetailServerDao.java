package com.esuizhen.server.sync.dao.sc;

import java.util.List;
import java.util.Map;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;

public interface BatchDetailServerDao {
	//插入
	public int insert(Object obj);
	
	public TBatchDetailInfo queryBatchDetailInfo(Map<String, Object> params);
	
	public List<TBatchDetailInfo> queryBatchDetailList(Map<String, Object> params);

	public void updateState(TBatchDetailInfo detailInfo);
	
	public int updateCountNum(Object object);

}
