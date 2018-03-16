package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.DoctorSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.sc.UserSyncResultServerDao;
import com.esuizhen.server.sync.dao.temp.TempDoctorDao;
import com.esuizhen.server.sync.model.temp.SyncDoctor;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.DoctorHandle;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * author:lhy descp:user service date:2017.03.17
 */

@Component
public class DoctorServiceImpl implements DataSyncService {

	@Autowired
	private DoctorHandle doctorHandle;
	@Autowired
	private TempDoctorDao tempDoctorDao;
	@Autowired
	private DoctorSyncResultServerDao doctorSyncResultServerDao;
	@Autowired
	private UserSyncResultServerDao userSyncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;

	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncDoctor doctor = JsonUtil.toObject(JsonUtil.toJson(object), SyncDoctor.class);
			doctor.setBatchId(req.getBatchId());
			tempDoctorDao.insert(doctor);
		}

	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return doctorSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	@Transactional
	public void dataProcessSync(TBatchDetailInfo detail) {
		// 获取医生信息
		List<SyncDoctor> list = tempDoctorDao.queryDoctorByBatchId(detail);
		for (SyncDoctor tempDoctor : list) {
			TBatchDataResultInfo result = doctorSyncProcess(tempDoctor);
			result.setBatchId(detail.getBatchId());
			result.setTableId(detail.getTableId());
			result.checkCause();
			// 保存同步结果
			doctorSyncResultServerDao.insert(result);// 医生
			userSyncResultServerDao.insert(result);// 用户
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}

	@SuppressWarnings("finally")
	public TBatchDataResultInfo doctorSyncProcess(SyncDoctor tempDoctor) {
		TBatchDataResultInfo result = tempDoctor.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		// 处理过程 单独处理   1.方法中catch后事务无法回滚。2.事务在第一次调用的方法中开启，类自身方法子方法事务无效
		try {
			doctorHandle.handleDoctor(tempDoctor);
		} catch (Exception e) {
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error,uuid=" + tempDoctor.getUuid() + ",batchId="
					+ tempDoctor.getBatchId()+",msg:" + e.getMessage());
		} finally {
			return result;
		}
	}
	

	

}
