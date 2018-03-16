package com.esuizhen.server.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.SyncResultDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryDao;
import com.esuizhen.server.sync.model.sc.TSyncResultHistoryServer;
import com.esuizhen.server.sync.model.sc.TSyncResultServer;
import com.esuizhen.server.sync.service.SyncResultService;

import java.util.Date;

/**
 * Created by Nidan on 2017年03月22 下午 15:03
 */
@Service
public class SyncResultServiceImpl implements SyncResultService {

    @Autowired
    private SyncResultHistoryDao syncResultHistoryDao;
    @Autowired
    private SyncResultDao syncResultDao;

    @Override
    public void recordSyncResult(TBatchDetailInfo detail, Object resultId, Integer syncFlag, String cause) {
       TSyncResultServer srs=syncResultDao.findByKey(resultId,"sc_db.ei_inhospital_note_sync_result_server","inhospitalId");

       if(srs!=null){
           srs.setSyncTime(new Date());
           srs.setUpdateTime(new Date());
           srs.setSyncFlag(syncFlag);
           srs.setCause(cause);
           syncResultDao.update(srs,"sc_db.ei_inhospital_note_sync_result_server","inhospitalId",resultId);
       }else{
           srs=new TSyncResultServer();
           srs.setSyncTime(new Date());
           srs.setUpdateTime(new Date());
           srs.setSyncFlag(syncFlag);
           srs.setCause(cause);
           srs.setCreateTime(new Date());
           srs.setBatchId(detail.getBatchId());
           syncResultDao.insert(srs,"sc_db.ei_inhospital_note_sync_result_server","inhospitalId",resultId);
       }
    }

    @Override
    public void recordSyncResultHistory(TBatchDetailInfo detail, String resultId, Integer syncFlag, String cause) {
        TSyncResultHistoryServer srhs=new TSyncResultHistoryServer();
        srhs.setSyncTime(new Date());
        srhs.setCreateTime(new Date());
        srhs.setBatchId(detail.getBatchId());
        srhs.setCause(cause);
        srhs.setResultId(resultId);
        srhs.setSyncFlag(syncFlag);
        srhs.setUpdateTime(new Date());
        srhs.setTableId(200);
        syncResultHistoryDao.insert();
    }
}
