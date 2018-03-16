package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.PatientSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.sc.UserSyncResultServerDao;
import com.esuizhen.server.sync.dao.temp.TempPatientDao;
import com.esuizhen.server.sync.model.temp.SyncPatient;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.PatientHandle;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * author:lhy descp:user service date:2017.03.17
 */

@Component
public class PatientServiceImpl implements DataSyncService {
	
	@Autowired
	private PatientHandle patientHandle;
	@Autowired
	private TempPatientDao tempPatientDao;
	@Autowired
	private PatientSyncResultServerDao patientSyncResultServerDao;
	@Autowired
	private UserSyncResultServerDao userSyncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;

	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncPatient patient = JsonUtil.toObject(JsonUtil.toJson(object), SyncPatient.class);
			patient.setBatchId(req.getBatchId());
			tempPatientDao.insert(patient);
		}

	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return patientSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		// 获取患者信息
		List<SyncPatient> list = tempPatientDao.queryPatientByBatchId(detail);
		for (SyncPatient tempPatient : list) {
			// 患者异步处理
			TBatchDataResultInfo result = patientSyncProcess(tempPatient);
			SyncResultUtil.checkSyncResult(result, detail);
			// 保存同步结果
			patientSyncResultServerDao.insert(result);// 患者
			userSyncResultServerDao.insert(result);// 用户
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}

	// 患者同步处理
	@SuppressWarnings("finally")
	private TBatchDataResultInfo patientSyncProcess(SyncPatient tempPatient) {
		TBatchDataResultInfo result = tempPatient.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		// 处理过程
		try {
			patientHandle.handlePatient(tempPatient);
		} catch (Exception e) {
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error,uuid=" + tempPatient.getUuid()
					+ ",batchId=" + tempPatient.getBatchId()+",msg:" + e.getMessage());
		} finally {
			return result;
		}
	}

	
}
