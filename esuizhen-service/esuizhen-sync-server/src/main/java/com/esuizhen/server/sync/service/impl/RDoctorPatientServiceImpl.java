package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.RDoctorPatientSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.server.DoctorPatientDao;
import com.esuizhen.server.sync.dao.temp.TempRDoctorPatientDao;
import com.esuizhen.server.sync.model.temp.SyncRDoctorPatient;
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
public class RDoctorPatientServiceImpl implements DataSyncService{
    
	@Autowired
	private TempRDoctorPatientDao tempRDoctorPatientDao;
	@Autowired
	private DoctorPatientDao doctorPatientDao;
	@Autowired
	private RDoctorPatientSyncResultServerDao doctorPatientSyncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncRDoctorPatient rDoctorPatient = JsonUtil.toObject(JsonUtil.toJson(object), SyncRDoctorPatient.class);
			rDoctorPatient.setBatchId(req.getBatchId());
			tempRDoctorPatientDao.insert(rDoctorPatient);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return doctorPatientSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		//获取医生患者关系信息
		List<SyncRDoctorPatient> list = tempRDoctorPatientDao.queryDoctorPatientByBatchId(detail);
		for(SyncRDoctorPatient tempRDoctorPatient:list){
			TBatchDataResultInfo result = patientFamilySyncProcess(tempRDoctorPatient);
			SyncResultUtil.checkSyncResult(result, detail);
			// 保存同步结果
			doctorPatientSyncResultServerDao.insert(result); //医患关系
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}

	private TBatchDataResultInfo patientFamilySyncProcess(SyncRDoctorPatient tempRDoctorPatient) {
		TBatchDataResultInfo result = tempRDoctorPatient.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		try{
			if(tempRDoctorPatient.getPatientId()==null||tempRDoctorPatient.getDoctorId()==null)
				throw new EmptyObjectExcption("doctor or patient not in server");
			if(tempRDoctorPatient.getAttentionTime()==null)//如果首次关注  关注时间为当前处理时间
				tempRDoctorPatient.setAttentionTime(new java.util.Date());
			result.setOpFlag(doctorPatientDao.insert(tempRDoctorPatient)==1?1:2);
		}catch(EmptyObjectExcption e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.NOT_IN_SERVER);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error" 
				+ ",doctorUuid=" + tempRDoctorPatient.getDoctorUuid()
				+ ",patientUuid="+tempRDoctorPatient.getPatientUuid()
				+ ",batchId="+ tempRDoctorPatient.getBatchId()
				+ ",msg:" + e.getMessage());
		}catch(Exception e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error" 
				+ ",doctorUuid=" + tempRDoctorPatient.getDoctorUuid()
				+ ",patientUuid="+tempRDoctorPatient.getPatientUuid()
				+ ",batchId="+ tempRDoctorPatient.getBatchId()
				+ ",msg:" + e.getMessage());
		}finally{
			return result;
		}
	}
	
	
}
