package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.HospitalDoctorRes;
import com.esuizhen.server.sync.dao.sc.HospitalDoctorSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempRHospitalDoctorDao;
import com.esuizhen.server.sync.model.temp.SyncRHospitalDoctor;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.RHospitalDoctorHandle;
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
public class RHospitalDoctorServiceImpl implements DataSyncService{
    
	@Autowired
	private TempRHospitalDoctorDao tempRHospitalDoctorDao;
	@Autowired
	private RHospitalDoctorHandle hospitalDoctorHandle;
	@Autowired
	private HospitalDoctorSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncRHospitalDoctor RHospitalDoctor = JsonUtil.toObject(JsonUtil.toJson(object), SyncRHospitalDoctor.class);
			RHospitalDoctor.setBatchId(req.getBatchId());
			tempRHospitalDoctorDao.insert(RHospitalDoctor);
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
		List<HospitalDoctorRes> list=tempRHospitalDoctorDao.getSyncHospitalDoctor(detail);
		if(list!=null&&list.size()>0){
			for (HospitalDoctorRes hospitalDoctor : list) {
				TBatchDataResultInfo resultInfo=this.hospitalDoctorSyncProcess(hospitalDoctor);
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

	private TBatchDataResultInfo hospitalDoctorSyncProcess(HospitalDoctorRes hospitalDoctor) {
		TBatchDataResultInfo resultInfo=hospitalDoctor.createResultInfo();
		if(hospitalDoctor.getDoctorId()!=null){
			try {
				LogUtil.log.info("-----------------异步hospitalPatient：{}同步开始-------------------",hospitalDoctor.getId());
				//同步至正式库
				hospitalDoctorHandle.syncHospitalDoctor(hospitalDoctor);
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_YES);
				LogUtil.log.info("-----------------异步数据同步成功-------------------");
			} catch (Exception e) {
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_FIRSTFAIL);
				resultInfo.setCause(e.getMessage());
				LogUtil.logError.error("-----------------异步数据同步异常{}-------------------",e.getMessage());
			}
		}else{
			resultInfo.setSyncFlag(Constant.User.SYNCFLAG_SECONDFAIL);
			resultInfo.setCause("云端医生不存在");
			LogUtil.log.info("-----------------云端医生不存在-------------------");
		}
		return resultInfo;
	}

}
