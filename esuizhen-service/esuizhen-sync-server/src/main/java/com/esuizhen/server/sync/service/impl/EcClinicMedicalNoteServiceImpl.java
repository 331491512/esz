package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.ClinicMedicalNoteRes;
import com.esuizhen.server.sync.dao.sc.ClinicMedicalNoteSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempEcClinicMedicalNoteDao;
import com.esuizhen.server.sync.model.temp.SyncEcClinicMedicalNote;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.ClinicMedicalNoteHandle;
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
public class EcClinicMedicalNoteServiceImpl implements DataSyncService{
    
	@Autowired
	private TempEcClinicMedicalNoteDao pushEcClinicMedicalNoteDao;
	@Autowired
	private ClinicMedicalNoteSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private ClinicMedicalNoteHandle clinicMedicalNoteHandle;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncEcClinicMedicalNote ecClinicMedicalNote = JsonUtil.toObject(JsonUtil.toJson(object), SyncEcClinicMedicalNote.class);
			ecClinicMedicalNote.setBatchId(req.getBatchId());
			pushEcClinicMedicalNoteDao.insert(ecClinicMedicalNote);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return syncResultServerDao.getBatChDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		if(detail.getBatchId()==null){
			LogUtil.logError.error("param error,batchId is not null!");
		}
		LogUtil.log.info("-----------------异步数据装配中-------------------");
		List<ClinicMedicalNoteRes> list=pushEcClinicMedicalNoteDao.getSyncClinicMedicalNote(detail);

		if(list!=null&&list.size()>0){
			for (ClinicMedicalNoteRes clinicMedicalNote : list) {
				TBatchDataResultInfo resultInfo=this.clinicMedicalNoteSyncProcess(detail,clinicMedicalNote);
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


	private TBatchDataResultInfo clinicMedicalNoteSyncProcess(TBatchDetailInfo detail,ClinicMedicalNoteRes clinicMedicalNote){
		TBatchDataResultInfo resultInfo=clinicMedicalNote.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(clinicMedicalNote.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步inhospitalNote：{}同步开始-------------------",clinicMedicalNote.getClinicMedicalId());
				//同步至正式库
				if(clinicMedicalNote.getOpFlag().equals(1)) {//opFlag不用判断？
					clinicMedicalNoteHandle.syncAddInhospitalNote(clinicMedicalNote);
				}else{
					clinicMedicalNoteHandle.syncUpdateInhospitalNote(clinicMedicalNote);
				}
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
