package com.esuizhen.client.sync.util;

import com.esuizhen.client.sync.bean.TBatchDataResultDetailInfo;
import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;

public class GetModel {
	public static TBatchDataResultDetailInfo getTBatchDataResultDetailInfoModel(TBatchDataResultInfo t1,TBatchDetailInfo t2){
		TBatchDataResultDetailInfo t = new TBatchDataResultDetailInfo();
		
		t.setResultId(t1.getResultId());
		t.setSyncFlag(t1.getSyncFlag());
		t.setSyncTime(t1.getSyncTime());
		t.setCause(t1.getCause());
		
		t.setBatchId(t2.getBatchId());
		t.setTableId(t2.getTableId());
		
		return t;
	}
}
