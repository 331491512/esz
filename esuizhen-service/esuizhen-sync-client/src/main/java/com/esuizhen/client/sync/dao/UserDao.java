package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;

/**
 * author:lhy
 * descp:user dao 
 * date:2017.03.17
 */

public interface UserDao {
	//获取批量同步user列表
	public List<LinkedHashMap> getBatchSyncUserByUserId(@Param("userIds") String userIds);

	public void updateUserSyncflag(@Param("userIds") String userIds);

	public void updateSyncResult(@Param("tBatchDataResultInfo") TBatchDataResultInfo tBatchDataResultInfo);
}
