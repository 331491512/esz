package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.HospitalPatientRes;
import com.esuizhen.server.sync.dao.sc.HospitalPatientSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempRHospitalPatientDao;
import com.esuizhen.server.sync.model.temp.SyncRHospitalPatient;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.RHospitalPatientHandle;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Component
public class RHospitalPatientServiceImpl implements DataSyncService{
    
	@Autowired
	private TempRHospitalPatientDao tempRHospitalPatientDao;
	@Autowired
	private RHospitalPatientHandle hospitalPatientHandle;
	@Autowired
	private HospitalPatientSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncRHospitalPatient rHospitalPatient = JsonUtil.toObject(JsonUtil.toJson(object), SyncRHospitalPatient.class);
			rHospitalPatient.setBatchId(req.getBatchId());
			tempRHospitalPatientDao.insert(rHospitalPatient);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return syncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		if(detail.getBatchId()==null){
			LogUtil.logError.error("param error,batchId is not null!");
		}
		LogUtil.log.info("-----------------异步数据装配中-------------------");
		List<HospitalPatientRes> list=tempRHospitalPatientDao.getSyncHospitalPatient(detail);
		if(list!=null&&list.size()>0){
			for (HospitalPatientRes hospitalPatient : list) {
				TBatchDataResultInfo resultInfo=this.hospitalPatientSyncProcess(hospitalPatient);
				try {
					SyncResultUtil.checkSyncResult(resultInfo, detail);
					//插入状态结果表
					syncResultServerDao.insert(resultInfo);
					//插入历史击入结果表
					historyServerDao.insert(resultInfo);
				} catch (Exception e) {
					LogUtil.logError.error(e.getMessage(),e);
				}
				detail.handleSyncFlag(resultInfo);
			}
		}else{
			LogUtil.log.info("-----------------本批次{}没有要异步执行的数据-------------------",detail.getBatchId());
		}
	}

	private TBatchDataResultInfo hospitalPatientSyncProcess(HospitalPatientRes hospitalPatient) {
		TBatchDataResultInfo resultInfo=hospitalPatient.createResultInfo();
		if(hospitalPatient.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步hospitalPatient：{}同步开始-------------------",hospitalPatient.getId());
				//同步至正式库
				hospitalPatientHandle.syncHospitalPatient(hospitalPatient);
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_YES);
				LogUtil.log.info("-----------------异步数据同步成功-------------------");
			} catch (Exception e) {
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_FIRSTFAIL);
				resultInfo.setCause(e.getMessage());
				LogUtil.logError.error("-----------------异步数据同步异常{}-------------------",e.getMessage());
			}
		}else{
			resultInfo.setSyncFlag(Constant.User.SYNCFLAG_SECONDFAIL);
			resultInfo.setCause("云端患者不存在");
			LogUtil.log.info("-----------------云端患者不存在-------------------");
		}
		return resultInfo;
	}

}
