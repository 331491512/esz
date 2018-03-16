package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.FollowupResultRes;
import com.esuizhen.server.sync.dao.sc.FollowupResultSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.server.TFollowupResultDao;
import com.esuizhen.server.sync.dao.temp.TempFollowupResultDao;
import com.esuizhen.server.sync.model.temp.SyncFollowupResult;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Component
public class FollowupResultServiceImpl implements DataSyncService{
    
	@Autowired
	private TempFollowupResultDao tempFollowupResultDao;
	@Autowired
	private TFollowupResultDao followupResultDao;
	@Autowired
	private FollowupResultSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncFollowupResult followupResult = JsonUtil.toObject(JsonUtil.toJson(object), SyncFollowupResult.class);
			followupResult.setBatchId(req.getBatchId());
			tempFollowupResultDao.insert(followupResult);
		}
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return syncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		// TODO Auto-generated method stub
		if(detail.getBatchId()==null){
			LogUtil.logError.error("param error,batchId is not null!");
		}
		LogUtil.log.info("-----------------异步数据装配中-------------------");
		List<FollowupResultRes> list=tempFollowupResultDao.getSyncFollowupResult(detail);
		if(list!=null&&list.size()>0){
			for (FollowupResultRes followupResult : list) {
				TBatchDataResultInfo resultInfo=this.followupResultSyncProcess(detail,followupResult);
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
	
	private TBatchDataResultInfo followupResultSyncProcess(TBatchDetailInfo detail,FollowupResultRes followupResult) {
		TBatchDataResultInfo resultInfo=followupResult.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(followupResult.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步inhospitalNote：{}同步开始-------------------",followupResult.getFollowupResultId());
				//同步至正式库
				if(followupResult.getOpFlag().equals(1)) {
					followupResultDao.insertSelective(followupResult);
				}else{
					followupResultDao.updateByPrimaryKeySelective(followupResult);
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
