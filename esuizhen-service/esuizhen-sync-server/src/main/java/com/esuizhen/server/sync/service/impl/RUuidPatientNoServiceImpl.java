package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.RUuidPatientNoSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.server.RUuidPatientnoDao;
import com.esuizhen.server.sync.dao.temp.TempRUuidPatientNoDao;
import com.esuizhen.server.sync.model.temp.SyncRUuidPatientNo;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * author:lhy descp:user service date:2017.03.17
 */

@Component
public class RUuidPatientNoServiceImpl implements DataSyncService {

	@Autowired
	private TempRUuidPatientNoDao tempUuidPatientNoDao;
	@Autowired
	private RUuidPatientNoSyncResultServerDao rUuidPatientNoSyncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;
	@Autowired
	private RUuidPatientnoDao rUuidPatientnoDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncRUuidPatientNo rUuidPatientNo = JsonUtil.toObject(JsonUtil.toJson(object), SyncRUuidPatientNo.class);
			rUuidPatientNo.setBatchId(req.getBatchId());
			tempUuidPatientNoDao.insert(rUuidPatientNo);
		}
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return rUuidPatientNoSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		List<SyncRUuidPatientNo> list = tempUuidPatientNoDao.queryRUuidPatientNoList(detail);
		for (SyncRUuidPatientNo tempRUuidPatientNo : list) {
			TBatchDataResultInfo result = uuidPatientNoSyncProcess(tempRUuidPatientNo);
			SyncResultUtil.checkSyncResult(result, detail);
			// 保存同步结果
			rUuidPatientNoSyncResultServerDao.insert(result); // 患者病案表
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}
	
	@Transactional
	private TBatchDataResultInfo uuidPatientNoSyncProcess(SyncRUuidPatientNo tempRUuidPatientNo) {
		TBatchDataResultInfo result = tempRUuidPatientNo.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		try{
			if(tempRUuidPatientNo.getPatientId()==null)
				throw new EmptyObjectExcption("patient not in server");
			result.setOpFlag(rUuidPatientnoDao.insert(tempRUuidPatientNo)==1?1:2);
		}catch(EmptyObjectExcption e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.NOT_IN_SERVER);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error"
				+ ",id="+tempRUuidPatientNo.getId()
				+ ",patientUuid="+tempRUuidPatientNo.getPatientUuid()
				+ ",batchId="+ tempRUuidPatientNo.getBatchId()
				+ ",msg:" + e.getMessage());
		}catch(Exception e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error"
				+ ",id="+tempRUuidPatientNo.getId()
				+ ",patientUuid="+tempRUuidPatientNo.getPatientUuid()
				+ ",batchId="+ tempRUuidPatientNo.getBatchId()
				+ ",msg:" + e.getMessage());
		}finally{
			return result;
		}
	}

}
