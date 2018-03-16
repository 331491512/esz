package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.RDeptPatientSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.server.DeptPatientDao;
import com.esuizhen.server.sync.dao.temp.TempRDeptPatientDao;
import com.esuizhen.server.sync.model.temp.SyncRDeptPatient;
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
public class RDeptPatientServiceImpl implements DataSyncService{
    
	@Autowired
	private TempRDeptPatientDao tempRDeptPatientDao;
	@Autowired
	private DeptPatientDao deptPatientDao;
	@Autowired
	private RDeptPatientSyncResultServerDao deptPatientSyncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao syncResultHistoryServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncRDeptPatient rDeptPatient = JsonUtil.toObject(JsonUtil.toJson(object), SyncRDeptPatient.class);
			rDeptPatient.setBatchId(req.getBatchId());
			tempRDeptPatientDao.insert(rDeptPatient);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return deptPatientSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		//获取医生患者关系信息
		List<SyncRDeptPatient> list = tempRDeptPatientDao.queryDeptPatientByBatchId(detail);
		for(SyncRDeptPatient tempRDeptPatient:list){
			TBatchDataResultInfo result = patientFamilySyncProcess(tempRDeptPatient);
			SyncResultUtil.checkSyncResult(result, detail);
			// 保存同步结果
			deptPatientSyncResultServerDao.insert(result); //医患关系
			syncResultHistoryServerDao.insert(result);// 历史记录
			detail.handleSyncFlag(result);
		}
	}

	private TBatchDataResultInfo patientFamilySyncProcess(SyncRDeptPatient tempRDeptPatient) {
		TBatchDataResultInfo result = tempRDeptPatient.createResultInfo();
		result.setSyncFlag(ConstantSync.SYNCFLAG.SYNC_OK);// 默认成功
		try{
			if(tempRDeptPatient.getPatientId()==null||tempRDeptPatient.getDeptId()==null)
				throw new EmptyObjectExcption("dept or patient not in server");
			result.setOpFlag(deptPatientDao.insert(tempRDeptPatient)==1?1:2);
		}catch(EmptyObjectExcption e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.NOT_IN_SERVER);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error" 
				+ ",doctorUuid=" + tempRDeptPatient.getDeptUuid()
				+ ",patientUuid="+tempRDeptPatient.getPatientUuid()
				+ ",hospitalId="+tempRDeptPatient.getHospitalId()
				+ ",batchId="+ tempRDeptPatient.getBatchId()
				+ ",msg:" + e.getMessage());
		}catch(Exception e){
			result.setSyncFlag(ConstantSync.SYNCFLAG.SERVER_ERROR);
			result.setCause("process error,msg:" + e.getMessage());
			LogUtil.logError.error("process error" 
				+ ",deptUuid=" + tempRDeptPatient.getDeptUuid()
				+ ",patientUuid="+tempRDeptPatient.getPatientUuid()
				+ ",hospitalId="+tempRDeptPatient.getHospitalId()
				+ ",batchId="+ tempRDeptPatient.getBatchId()
				+ ",msg:" + e.getMessage());
		}finally{
			return result;
		}
	}
	
	
}
