package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.SurgeryNoteRes;
import com.esuizhen.server.sync.dao.sc.SurgeryNoteSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempEciSurgeryNoteDao;
import com.esuizhen.server.sync.model.temp.SyncEciSurgeryNote;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.SurgeryNoteHandle;
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
public class EciSurgeryNoteServiceImpl implements DataSyncService {

	@Autowired
	private TempEciSurgeryNoteDao tempEciSurgeryNoteDao;
	@Autowired
	private SurgeryNoteSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private SurgeryNoteHandle surgeryNoteHandle;

	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncEciSurgeryNote eciSurgeryNote = JsonUtil.toObject(JsonUtil.toJson(object), SyncEciSurgeryNote.class);
			eciSurgeryNote.setBatchId(req.getBatchId());
			tempEciSurgeryNoteDao.insert(eciSurgeryNote);
		}

	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return syncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		if (detail.getBatchId() == null) {
			LogUtil.logError.error("param error,batchId is not null!");
		}
		LogUtil.log.info("-----------------异步数据装配中-------------------");
		List<SurgeryNoteRes> list = tempEciSurgeryNoteDao.getSyncSurgeryNote(detail);
		if (list != null && list.size() > 0) {
			for (SurgeryNoteRes surgeryNote : list) {
				TBatchDataResultInfo resultInfo = this.surgeryNoteSyncProcess(detail,surgeryNote);
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
		} else {
			LogUtil.log.info("-----------------本批次{}没有要异步执行的数据-------------------", detail.getBatchId());
		}
	}

	private TBatchDataResultInfo surgeryNoteSyncProcess(TBatchDetailInfo detail,SurgeryNoteRes surgeryNote) {
		TBatchDataResultInfo resultInfo = surgeryNote.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if (surgeryNote.getPatientId() != null) {
			try {
				LogUtil.log.info("-----------------异步inhospitalNote：{}同步开始-------------------", surgeryNote.getSurgeryId());
				//同步至正式库
				if (surgeryNote.getOpFlag().equals(1)) {//opFlag不用判断？
					surgeryNoteHandle.syncAddSurgeryNote(surgeryNote);
				} else {
					surgeryNoteHandle.syncUpdateSurgeryNote(surgeryNote);
				}
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_YES);
				LogUtil.log.info("-----------------异步数据同步成功-------------------");
			} catch (Exception e) {
				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_FIRSTFAIL);
				resultInfo.setCause(e.getMessage());
				LogUtil.logError.error("-----------------异步数据同步异常{}-------------------", e.getMessage());
			}
		} else {
			resultInfo.setSyncFlag(Constant.User.SYNCFLAG_SECONDFAIL);
			resultInfo.setCause("云端此患者的信息未同步");
			LogUtil.log.info("-----------------云端此患者的信息未同步-------------------");
		}
		return resultInfo;
	}

}
