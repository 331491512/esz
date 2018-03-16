package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.InhospitalNoteRes;
import com.esuizhen.server.sync.dao.sc.InhospitalNoteSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempInhospitalNoteDao;
import com.esuizhen.server.sync.model.temp.SyncInhospitalNote;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.InhospitalNoteHandle;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * author:lhy
 * descp:user service
 * date:2017.03.17
 */

@Component
public class InhospitalNoteServiceImpl implements DataSyncService {

	@Autowired
	private TempInhospitalNoteDao tempInhospitalNoteDao;
    @Autowired
    private InhospitalNoteSyncResultServerDao syncResultServerDao;
    @Autowired
    private SyncResultHistoryServerDao historyServerDao;
    @Autowired
    private InhospitalNoteHandle inhospitalNoteHandle;

	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncInhospitalNote inhospitalNote = JsonUtil.toObject(JsonUtil.toJson(object), SyncInhospitalNote.class);
			inhospitalNote.setBatchId(req.getBatchId());
			tempInhospitalNoteDao.insert(inhospitalNote);
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
        List<InhospitalNoteRes> list=tempInhospitalNoteDao.getSyncInhospitalNote(detail);
        if(list!=null&&list.size()>0){
            for (InhospitalNoteRes inhospitalNote : list) {
                TBatchDataResultInfo resultInfo=this.inhospitalNoteSyncProcess(detail,inhospitalNote);
                LogUtil.log.info("异步结果：{}",JsonUtil.toJson(resultInfo));
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

    private TBatchDataResultInfo inhospitalNoteSyncProcess(TBatchDetailInfo detail,InhospitalNoteRes inhospitalNote) {
        TBatchDataResultInfo resultInfo=inhospitalNote.createResultInfo();
        resultInfo.setBatchId(detail.getBatchId());
        resultInfo.setTableId(detail.getTableId());
        if(inhospitalNote.getPatientId()!=null){
            try {
                LogUtil.log.info("-----------------异步inhospitalNote：{}同步开始-------------------",inhospitalNote.getUuid());
                //同步至正式库
                if(inhospitalNote.getOpFlag().equals(1)) {
                    inhospitalNoteHandle.syncAddInhospitalNote(inhospitalNote);
                }else{
                    inhospitalNoteHandle.syncUpdateInhospitalNote(inhospitalNote);
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