package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.DetectionDetailRes;
import com.esuizhen.server.sync.dao.sc.DetectionDetailSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempEciDetectionDetailDao;
import com.esuizhen.server.sync.model.temp.SyncEciDetectionDetail;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.DetectionDetailHandle;
import com.esuizhen.server.sync.utils.SyncResultUtil;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Component
public class EciDetectionDetailServiceImpl implements DataSyncService{
    
	@Autowired
	private TempEciDetectionDetailDao tempEciDetectionDetailDao;
	@Autowired
	private DetectionDetailSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private DetectionDetailHandle detectionDetailHandle;
	@Value("${sync.realtime.process.switch}")
	private Integer realtimeSwitch;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncEciDetectionDetail eciDetectionDetail = JsonUtil.toObject(JsonUtil.toJson(object), SyncEciDetectionDetail.class);
			eciDetectionDetail.setBatchId(req.getBatchId());
			tempEciDetectionDetailDao.insert(eciDetectionDetail);
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
		List<DetectionDetailRes> list=tempEciDetectionDetailDao.getSyncDetectionDetailNote(detail);
		//实时库也需要同步一份
//		List<DetectionDetailRes> realtimeList=null;
//		if(realtimeSwitch==1){
//			realtimeList=tempEciDetectionDetailDao.getSyncDetectionDetailNoteByRealtime(detail);
//		}
		if(list!=null&&list.size()>0){
			for (DetectionDetailRes detectionDetail : list) {
				TBatchDataResultInfo resultInfo=this.detectionDetailSyncProcess(detail,detectionDetail);
//				if(realtimeSwitch==1) {
//					TBatchDataResultInfo realtimeResultInfo = this.realtimeDetectionDetailSyncProcess(realtimeList, detectionDetail, detail);
//					resultInfo = getResultInfo(resultInfo, realtimeResultInfo);
//				}
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

	/**
	 * SYNCFLAG_SECONDFAIL<---SYNCFLAG_FIRSTFAIL（排序）
	 * @param resultInfo
	 * @param realtimeResultInfo
	 * @return
	 */
	/*
	private TBatchDataResultInfo getResultInfo(TBatchDataResultInfo resultInfo,TBatchDataResultInfo realtimeResultInfo){
		if(resultInfo!=null&&realtimeResultInfo!=null&&resultInfo.getSyncFlag()!=null
				&&realtimeResultInfo.getSyncFlag()!=null){
			if(resultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_SECONDFAIL)){
				return resultInfo;
			}else if(realtimeResultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_SECONDFAIL)){
				return realtimeResultInfo;
			}else if(realtimeResultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_FIRSTFAIL)){
				resultInfo=realtimeResultInfo;
			}
			return resultInfo;
		}
		return resultInfo;
	}
*/
	private TBatchDataResultInfo detectionDetailSyncProcess(TBatchDetailInfo detail,DetectionDetailRes detectionDetail ) {
		TBatchDataResultInfo resultInfo=detectionDetail.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(detectionDetail.getDetectionReportId()!=null){
			try {
				LogUtil.log.info("-----------------异步detectionDetail：{}同步开始-------------------",detectionDetail.getDetectionDetailId());
				//同步至正式库
				if(detectionDetail.getOpFlag().equals(1)) {
					detectionDetailHandle.syncAddDetectionDetail(detectionDetail);
					if(realtimeSwitch==1)
						detectionDetailHandle.syncAddRealtimeDetectionDetail(detectionDetail);
				}else{
					detectionDetailHandle.syncUpdateDetectionDetail(detectionDetail);
					if(realtimeSwitch==1)
						detectionDetailHandle.syncUpdateRealtimeDetectionDetail(detectionDetail);
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
			resultInfo.setCause("检查报告单DetectionReport不存在");
			LogUtil.log.info("-----------------检查报告单DetectionReport不存在-------------------");
		}
		return resultInfo;
	}
	/*
	private TBatchDataResultInfo realtimeDetectionDetailSyncProcess(List<DetectionDetailRes> realtimeList, DetectionDetailRes dr, TBatchDetailInfo detail) {
		DetectionDetailRes detectionDetail=null;
		for (DetectionDetailRes detectionDetailRes : realtimeList){
			if(detectionDetailRes.getDetectionDetailId()!=null&&detectionDetailRes.getDetectionDetailId().equals(dr.getDetectionDetailId())){
				detectionDetail=detectionDetailRes;
			}
		}
		TBatchDataResultInfo resultInfo=detectionDetail.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(detectionDetail.getDetectionReportId()!=null){
			try {
				LogUtil.log.info("-----------------异步detectionDetail：{}同步开始-------------------",detectionDetail.getDetectionDetailId());
				//同步至正式库
				if(detectionDetail.getOpFlag().equals(1)) {
					detectionDetailHandle.syncAddRealtimeDetectionDetail(detectionDetail);
				}else{
					detectionDetailHandle.syncUpdateRealtimeDetectionDetail(detectionDetail);
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
			resultInfo.setCause("检查报告单DetectionReport不存在");
			LogUtil.log.info("-----------------检查报告单DetectionReport不存在-------------------");
		}
		return resultInfo;
	}
*/
}
