package com.esuizhen.client.sync.dao;

import java.util.LinkedHashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;


/**
 * author:lhy
 * descp:user dao 
 * date:2017.03.17
 */

public interface DoctorDao {
	
	public List<LinkedHashMap> getBatchSyncDoctor(@Param("detailInfo") TBatchDetailInfo detailInfo);
	
	List<LinkedHashMap> getBatchSyncUserByDoctorUserId(@Param("userIds") String userIds);

	public void updateDoctorSyncflag(@Param("doctorIds")  String doctorIds);

	public void updateSyncResult(@Param("tBatchDataResultInfo") TBatchDataResultInfo tBatchDataResultInfo);
	
}
