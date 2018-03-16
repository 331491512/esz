package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.server.DetectionReportRes;
import com.esuizhen.server.sync.dao.sc.DetectionReportSyncResultServerDao;
import com.esuizhen.server.sync.dao.sc.SyncResultHistoryServerDao;
import com.esuizhen.server.sync.dao.temp.TempEciDetectionReportDao;
import com.esuizhen.server.sync.model.temp.SyncEciDetectionReport;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.handle.DetectionReportHandle;
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
public class EciDetectionReportServiceImpl implements DataSyncService{
    
	@Autowired
	private TempEciDetectionReportDao tempEciDetectionReportDao;
	@Autowired
	private DetectionReportSyncResultServerDao syncResultServerDao;
	@Autowired
	private SyncResultHistoryServerDao historyServerDao;
	@Autowired
	private DetectionReportHandle detectionReportHandle;
	@Value("${sync.realtime.process.switch}")
	private Integer realtimeSwitch;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncEciDetectionReport eciDetectionReport = JsonUtil.toObject(JsonUtil.toJson(object), SyncEciDetectionReport.class);
			eciDetectionReport.setBatchId(req.getBatchId());
			tempEciDetectionReportDao.insert(eciDetectionReport);
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
		List<DetectionReportRes> list=tempEciDetectionReportDao.getSyncDetectionReport(detail);
		//实时库也需要同步一份
//		List<DetectionReportRes> realtimeList=null;
//		if(realtimeSwitch==1){
//			realtimeList=tempEciDetectionReportDao.getSyncDetectionReportByRealtime(detail);
//		}
		if(list!=null&&list.size()>0){
			for (DetectionReportRes detectionReport : list) {
				TBatchDataResultInfo resultInfo=this.detectionReportSyncProcess(detail,detectionReport);
//				if(realtimeSwitch==1) {
//					TBatchDataResultInfo realtimeResultInfo = this.realtimeDetectionReportSyncProcess(realtimeList, detectionReport, detail);
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
//	private TBatchDataResultInfo getResultInfo(TBatchDataResultInfo resultInfo,TBatchDataResultInfo realtimeResultInfo){
//		if(resultInfo!=null&&realtimeResultInfo!=null&&resultInfo.getSyncFlag()!=null
//				&&realtimeResultInfo.getSyncFlag()!=null){
//			if(resultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_SECONDFAIL)){
//				return resultInfo;
//			}else if(realtimeResultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_SECONDFAIL)){
//				return realtimeResultInfo;
//			}else if(realtimeResultInfo.getSyncFlag().equals(Constant.User.SYNCFLAG_FIRSTFAIL)){
//				resultInfo=realtimeResultInfo;
//			}
//			return resultInfo;
//		}
//		return resultInfo;
//	}

	private TBatchDataResultInfo detectionReportSyncProcess(TBatchDetailInfo detail,DetectionReportRes detectionReport) {
		TBatchDataResultInfo resultInfo=detectionReport.createResultInfo();
		resultInfo.setBatchId(detail.getBatchId());
		resultInfo.setTableId(detail.getTableId());
		if(detectionReport.getPatientId()!=null){
			try {
				LogUtil.log.info("-----------------异步detectionReport：{}同步开始-------------------",detectionReport.getDetectionReportId());
				//同步至正式库
				if(detectionReport.getOpFlag().equals(1)) {//opFlag不用判断？
					detectionReportHandle.syncAddDetectionReport(detectionReport);
					if(realtimeSwitch==1)
						detectionReportHandle.syncRealtimeAddDetectionReport(detectionReport);
				}else{
					detectionReportHandle.syncUpdateDetectionReport(detectionReport);
					if(realtimeSwitch==1)
						detectionReportHandle.syncRealtimeUpdateDetectionReport(detectionReport);
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
			resultInfo.setCause("云端此患者尚未同步");
			LogUtil.log.info("-----------------云端此患者尚未同步-------------------");
		}
		return resultInfo;
	}

//	private TBatchDataResultInfo realtimeDetectionReportSyncProcess(List<DetectionReportRes> realtimeList, DetectionReportRes dr, TBatchDetailInfo detail) {
//		DetectionReportRes detectionReport=null;
//		for (DetectionReportRes detectionReportRes : realtimeList){
//			if(detectionReportRes.getDetectionReportId()!=null&&detectionReportRes.getDetectionReportId().equals(dr.getDetectionReportId())){
//				detectionReport=detectionReportRes;
//			}
//		}
//		if(detectionReport!=null) {
//			TBatchDataResultInfo resultInfo = detectionReport.createResultInfo();
//			resultInfo.setBatchId(detail.getBatchId());
//			resultInfo.setTableId(detail.getTableId());
//			if (detectionReport.getPatientId() != null) {
//				try {
//					LogUtil.log.info("-----------------realtime异步detectionReport：{}同步开始-------------------", detectionReport.getDetectionReportId());
//					//同步至realtime
//					if (detectionReport.getUpFlag().equals(0)) {//opFlag不用判断？
//						detectionReportHandle.syncRealtimeAddDetectionReport(detectionReport);
//					} else {
//						detectionReportHandle.syncRealtimeUpdateDetectionReport(detectionReport);
//					}
//					resultInfo.setSyncFlag(Constant.User.SYNCFLAG_YES);
//					LogUtil.log.info("-----------------realtime异步数据同步成功-------------------");
//				} catch (Exception e) {
//					resultInfo.setSyncFlag(Constant.User.SYNCFLAG_FIRSTFAIL);
//					resultInfo.setCause(e.getMessage());
//					LogUtil.logError.error("-----------------realtime异步数据同步异常{}-------------------", e.getMessage());
//				}
//			} else {
//				resultInfo.setSyncFlag(Constant.User.SYNCFLAG_SECONDFAIL);
//				resultInfo.setCause("realtime云端此患者尚未同步");
//				LogUtil.log.info("-----------------realtime云端此患者尚未同步-------------------");
//			}
//			return resultInfo;
//		}else{
//			return null;
//		}
//	}

}
