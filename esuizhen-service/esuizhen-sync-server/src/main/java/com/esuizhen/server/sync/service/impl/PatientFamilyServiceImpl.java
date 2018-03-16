package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.PatientFamilySyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.server.PatientFamilyDao;
import com.esuizhen.server.sync.dao.temp.TempPatientFamilyDao;
import com.esuizhen.server.sync.model.temp.SyncPatientFamily;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Component
public class PatientFamilyServiceImpl implements DataSyncService{
    
	@Autowired
	private TempPatientFamilyDao tempPatientFamilyDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;
	@Autowired
	private PatientFamilySyncResultServerDao patientFamilySyncResultServerDao;
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncPatientFamily contact = JsonUtil.toObject(JsonUtil.toJson(object), SyncPatientFamily.class);
			contact.setBatchId(req.getBatchId());
			tempPatientFamilyDao.insert(contact);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return patientFamilySyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		//获取联系人信息
		List<SyncPatientFamily> list = tempPatientFamilyDao.queryPatientFamilyByBatchId(detail);
		for(SyncPatientFamily tempPatientFamily:list){
			TBatchDataResultInfo result = patientFamilySyncProcess(tempPatientFamily);
			SyncResultUtil.checkSyncResult(result, detail);
			// 保存同步结果
			patientFamilySyncResultServerDao.insert(result);//患者联系人
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}
	
	//联系人同步
	@Transactional
	private TBatchDataResultInfo patientFamilySyncProcess(SyncPatientFamily tempPatientFamily) {
		TBatchDataResultInfo result = tempPatientFamily.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		// 处理过程
		try{
			if(tempPatientFamily.getPatientId()==null)
				throw new EmptyObjectExcption("patient not in server");
			result.setOpFlag(patientFamilyDao.insert(tempPatientFamily)==1?1:2);
		}catch(EmptyObjectExcption e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.NOT_IN_SERVER);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error,contactId=" + tempPatientFamily.getContactId()
				+ ",patientUuid="+tempPatientFamily.getPatientUuid()
				+ ",batchId="+ tempPatientFamily.getBatchId()
				+ ",msg:" + e.getMessage());
		}catch(Exception e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error,contactId=" + tempPatientFamily.getContactId()
				+ ",patientUuid="+tempPatientFamily.getPatientUuid()
				+ ",batchId="+ tempPatientFamily.getBatchId()
				+ ",msg:" + e.getMessage());
		}finally {
			return result;
		}
	}
	
	
}
