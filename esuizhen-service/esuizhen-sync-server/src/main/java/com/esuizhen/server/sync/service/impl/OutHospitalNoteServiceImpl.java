package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.OuthospitalNoteRes;
import com.esuizhen.server.sync.dao.sc.OuthospitalNoteSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempOutHospitalNoteDao;
import com.esuizhen.server.sync.model.temp.SyncOutHospitalNote;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.OutHospitalNoteHandle;
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
public class OutHospitalNoteServiceImpl implements DataSyncService{
    
	@Autowired
	private TempOutHospitalNoteDao tempOutHospitalNoteDao;
	@Autowired
	private OuthospitalNoteSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private OutHospitalNoteHandle outHospitalNoteHandle;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncOutHospitalNote outHospitalNote = JsonUtil.toObject(JsonUtil.toJson(object), SyncOutHospitalNote.class);
			outHospitalNote.setBatchId(req.getBatchId());
			tempOutHospitalNoteDao.insert(outHospitalNote);
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
		List<OuthospitalNoteRes> list=tempOutHospitalNoteDao.getSyncOutHospitalNote(detail);
		if(list!=null&&list.size()>0){
			for (OuthospitalNoteRes outhospitalNote : list) {
				TBatchDataResultInfo resultInfo=this.outhospitalNoteSyncProcess(detail,outhospitalNote);
				detail.handleSyncFlag(resultInfo);
				try {
					SyncResultUtil.checkSyncResult(resultInfo, detail);
					//插入状态结果表
					syncResultServerDao.insert(resultInfo);
					//插入历史击入结果表
					historyServerDao.insert(resultInfo);
				} catch (Exception e) {
					LogUtil.logError.error(e.getMessage(),e);
				}
			}
		}else{
			LogUtil.log.info("-----------------本批次{}没有要异步执行的数据-------------------",detail.getBatchId());
		}
	}

	private TBatchDataResultInfo outhospitalNoteSyncProcess(TBatchDetailInfo detail,OuthospitalNoteRes outhospitalNote) {
		TBatchDataResultInfo resultInfo=outhospitalNote.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(outhospitalNote.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步outhospitalNote：{}同步开始-------------------",outhospitalNote.getOuthospitalId());
				//同步至正式库
				if(outhospitalNote.getOpFlag().equals(1)) {
					outHospitalNoteHandle.syncAddOuthospitalNote(outhospitalNote);
				}else{
					outHospitalNoteHandle.syncUpdateOuthospitalNote(outhospitalNote);
				}
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_YES);
				LogUtil.log.info("-----------------异步数据同步成功-------------------");
			} catch (Exception e) {
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_FIRSTFAIL);
				resultInfo.setCause(e.getMessage());
				LogUtil.logError.error("-----------------异步数据同步异常{}-------------------",e.getMessage(),e);
			}
		}else{
			resultInfo.setSyncFlag(Constant.User.SYNCFLAG_SECONDFAIL);
			resultInfo.setCause("云端患者信息不存在");
			LogUtil.log.info("-----------------云端患者信息不存在-------------------");
		}
		return resultInfo;
	}

}
