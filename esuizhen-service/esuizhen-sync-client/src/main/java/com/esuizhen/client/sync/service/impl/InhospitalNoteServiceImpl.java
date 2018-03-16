package com.esuizhen.client.sync.service.impl;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.esuizhen.client.sync.dao.InhospitalNoteDao;
import com.esuizhen.client.sync.dao.sc.SyncResultHistoryClientDao;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.service.DataSyncService;
import com.esuizhen.client.sync.util.ClientRequestServerUtil;
import com.esuizhen.client.sync.util.PushDataTransfer;
import com.esuizhen.client.sync.util.SyncResultUtil;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Component
public class InhospitalNoteServiceImpl implements DataSyncService {

	@Autowired
	private InhospitalNoteDao inhospitalNoteDao;
	
	@Autowired
	private SyncResultHistoryClientDao syncResultHistoryClientDao;
	

	@Transactional
	@Override
	public int pushDataToServer(TBatchDetailInfo detailInfo) {
		int totalnum = 0;
		try {
			List<LinkedHashMap> l_inhospitalNote = inhospitalNoteDao.getBatchSyncInhospitalNote(detailInfo);
			totalnum = l_inhospitalNote.size();

			if (l_inhospitalNote.size() > 0) {
				// -->开始推住院息
				// 01封装住院信息
				String inhospitalNote_json_data = PushDataTransfer.transfer(detailInfo.getBatchId(), 200,
						l_inhospitalNote);

				// 02推送住院信息
				String res1 = ClientRequestServerUtil.pushBatchData(inhospitalNote_json_data);
				TMsgResponse<Object> msg = JsonUtil.toObject(res1, TMsgResponse.class);
				// 判断返回结果
				if (null != msg && msg.getRespCode() == 0) {

					// 03修改住院表状态
					String inhospitalIds = "";

					for (LinkedHashMap d : l_inhospitalNote) {
						inhospitalIds = inhospitalIds +"'"+ d.get("inhospitalId").toString().replace(" ","") + "',";
					}
					inhospitalIds = inhospitalIds.substring(0,inhospitalIds.length()-1);
					
					inhospitalNoteDao.updateInhospitalNoteSyncflag(inhospitalIds);
				} else {
					totalnum = -1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			totalnum = -1;
		}
		return totalnum;
	}
	
	@Transactional
	@Override
	public int getResultFromServer(TBatchDetailInfo detailInfo) {
		int totalnum = 0;
		try {
			// 拼接推送信息
			String json_data = PushDataTransfer.transfer2(detailInfo);
	        // 获取推送结果
			String res = ClientRequestServerUtil.getBatChDataResult(json_data);
			
			TMsgResponse<Object> msg = JsonUtil.toObject(res, TMsgResponse.class);
			
			if(null!=msg && msg.getRespCode()==0){
				List<Object> l_tBatchDataResultInfo = (List<Object>) msg.getResult();
				totalnum = l_tBatchDataResultInfo.size();
				
				if(l_tBatchDataResultInfo.size()>0){
					for (Object obj : l_tBatchDataResultInfo) {
						TBatchDataResultInfo result = SyncResultUtil.trunkToSyncResult(obj, detailInfo);
						inhospitalNoteDao.updateSyncResult(result);
						syncResultHistoryClientDao.insertResult(result);
					}
				}
				
			}else{
				totalnum=-1;
			}
		} catch (Exception e) {
			LogUtil.logError.error("<ERROR>---住院信息同步结果获取失败==>>>:"+e.getMessage());
			e.printStackTrace();
			totalnum=-1;
		}
		return totalnum;
	}

}
