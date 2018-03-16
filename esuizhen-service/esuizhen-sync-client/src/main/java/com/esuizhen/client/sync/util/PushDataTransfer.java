package com.esuizhen.client.sync.util;

import java.util.LinkedHashMap;
import java.util.List;

import com.esuizhen.client.sync.bean.BatchDataPushReq;
import com.esuizhen.client.sync.bean.BatchDataResultGetReq;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.util.JsonUtil;

public class PushDataTransfer {
	
	public static String transfer(String BatchId,int tableId,List<LinkedHashMap> l_data){
		
		BatchDataPushReq batchData = new BatchDataPushReq();
	    
		batchData.setBatchId(BatchId);
		
	     //转换参数
		batchData.setTableId(tableId);
		batchData.setTableCode(ConstantSync.Sync_Table.getInfoViaId(tableId).code);
	    
		batchData.setDataList(l_data);
		
		return JsonUtil.toJson(batchData);
		
	}
	
	public static String transfer2(TBatchDetailInfo detailInfo) {
		BatchDataResultGetReq b = new BatchDataResultGetReq();
			b.setBatchId(detailInfo.getBatchId());
			b.setTableId(detailInfo.getTableId());
			b.setTableCode(ConstantSync.Sync_Table.getInfoViaId(detailInfo.getTableId()).code);
		return JsonUtil.toJson(b);
	}
	
	public static void main(String[] args) {
		System.out.println(ConstantSync.Sync_Table.getInfoViaId(300).code);
	}
	
}
