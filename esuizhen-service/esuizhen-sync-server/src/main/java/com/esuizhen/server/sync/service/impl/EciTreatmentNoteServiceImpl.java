package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.TreatmentNoteRes;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.sc.TreatmentNoteSyncResultServerDao;
import com.esuizhen.server.sync.dao.temp.TempEciTreatmentNoteDao;
import com.esuizhen.server.sync.model.temp.SyncEciTreatmentNote;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.TreatmentNoteHandle;
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
public class EciTreatmentNoteServiceImpl implements DataSyncService{
    
	@Autowired
	private TempEciTreatmentNoteDao tempEciTreatmentNoteDao;
	@Autowired
	private TreatmentNoteSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private TreatmentNoteHandle treatmentNoteHandle;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncEciTreatmentNote eciTreatmentNote = JsonUtil.toObject(JsonUtil.toJson(object), SyncEciTreatmentNote.class);
			eciTreatmentNote.setBatchId(req.getBatchId());
			tempEciTreatmentNoteDao.insert(eciTreatmentNote);
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
		List<TreatmentNoteRes> list=tempEciTreatmentNoteDao.getSyncTreatmentNote(detail);
		if(list!=null&&list.size()>0){
			for (TreatmentNoteRes treatmentNote : list) {
				TBatchDataResultInfo resultInfo=this.treatmentNoteSyncProcess(detail,treatmentNote);
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

	private TBatchDataResultInfo treatmentNoteSyncProcess(TBatchDetailInfo detail,TreatmentNoteRes treatmentNote) {
		TBatchDataResultInfo resultInfo=treatmentNote.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(treatmentNote.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步treatmentNote：{}同步开始-------------------",treatmentNote.getTreatmentId());
				//同步至正式库
				if(treatmentNote.getOpFlag().equals(1)) {//opFlag不用判断？
					treatmentNoteHandle.syncAddTreatmentNote(treatmentNote);
				}else{
					treatmentNoteHandle.syncUpdateTreatmentNote(treatmentNote);
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
			resultInfo.setCause("云端此患者的信息未同步");
			LogUtil.log.info("-----------------云端此患者的信息未同步-------------------");
		}
		return resultInfo;
	}

}
