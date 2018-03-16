package com.esuizhen.server.sync.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.BatchInfoGetReq;
import com.esuizhen.server.sync.bean.BatchProcessDoReq;
import com.esuizhen.server.sync.bean.BatchProcessUpdateReq;
import com.esuizhen.server.sync.bean.PatientMergeInfoSyncReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.bean.TBatchInfo;
import com.esuizhen.server.sync.dao.sc.BatchDetailServerDao;
import com.esuizhen.server.sync.dao.sc.BatchServerDao;
import com.esuizhen.server.sync.dao.server.SignedHospitalDao;
import com.esuizhen.server.sync.service.BatchService;
import com.esuizhen.server.sync.service.DataSyncService;
import com.esuizhen.server.sync.service.factory.DataSyncFactory;
import com.esuizhen.server.sync.service.handle.MergePatientInfoHandle;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.CommonErrorException;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.TimerUtil;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Service
public class BatchServiceImpl implements BatchService {
    @Autowired
    public DataSyncFactory dataSyncFactory;
	@Autowired
	public SignedHospitalDao signedHospitalDao;
	@Autowired
	public BatchDetailServerDao batchDetailServerDao;
	@Autowired
	public BatchServerDao batchServerDao;
	@Autowired
	private MergePatientInfoHandle mergePatientInfoHandle;
	@Value("${process.thread.pool.size}")
	private Integer processSize;

	@Transactional
	@Override
	public TBatchInfo getBatchInfo(BatchInfoGetReq req) {
		if(req==null||req.getHospitalId()==null||req.getTableList()==null||req.getTableList().size()==0){
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));//参数错误
		}
		for(TBatchDetailInfo detail:req.getTableList()){
			if(!ConstantSync.checkTableIdCode(detail.getTableId(), detail.getTableCode()))
				throw new EmptyParamExcption("param error,batch detail error,detail tableId:"+detail.getTableId()+",tableCode:"+detail.getTableCode());
		}
		if(req.getHospitalId()!=0&&signedHospitalDao.getHospitalSingned(req.getHospitalId())==0)//判断医院是否可以同步
			throw new EmptyObjectExcption("hospital not sync,hospitalId="+req.getHospitalId());
		Map<String,Object> params = new HashMap<String, Object>();
		if(StringUtils.isEmpty(req.getBatchId())){
			params.put("hospitalId", req.getHospitalId());
			params.put("state", ConstantSync.BatchState.SYNC_INIT);
		}else{
			params.put("batchId", req.getBatchId());
			params.put("hospitalId", req.getHospitalId());
		}
		LogUtil.log.info("----------1. 获取同步批次 -----------");
		TBatchInfo batchInfo = batchServerDao.queryBatchInfo(params);
		if(batchInfo!=null){
			LogUtil.log.info("----------2.a 存在批次  直接返回-----------");
			params.put("batchId", batchInfo.getBatchId());
			params.remove("state");
			batchInfo.setTableList(batchDetailServerDao.queryBatchDetailList(params));
			return batchInfo;
		}
		LogUtil.log.info("----------2b. 未获取到未完成的批次 创建并返回  -----------");
		batchInfo = new TBatchInfo();
		BeanUtils.copyProperties(req, batchInfo);
		batchInfo.setBatchId(GeneralUtil.generateUniqueID("BATC"));
		batchInfo.setState(ConstantSync.BatchState.SYNC_INIT);
		batchServerDao.insert(batchInfo);
		for(TBatchDetailInfo detail :batchInfo.getTableList()){
			detail.setBatchId(batchInfo.getBatchId());
			batchDetailServerDao.insert(detail);
		}
		return batchInfo;
	}
	@Transactional
	@Override
	public void updateBatchProcess(BatchProcessUpdateReq req) {
		if(req==null||StringUtils.isBlank(req.getBatchId())||req.getState()==null)
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));
		if(req.getTableId()!=null){
			if(StringUtils.isBlank(req.getTableCode())
					||StringUtils.isBlank(req.getTableCode())
					||!ConstantSync.checkTableIdCode(req.getTableId(),req.getTableCode()))
				throw new EmptyParamExcption("param error, tableId/tableCode not match,tableId="+req.getTableId()+",tableCode="+req.getTableCode());
			LogUtil.log.info("--------------1.判断批次相请是否存在-------------------");
			TBatchDetailInfo detailInfo = checkBatchDetailInfo(req.getBatchId(), req.getTableId(),null);
			LogUtil.log.info("--------------2.检查批次是否可修改-------------------");
			if(checkBatchState(detailInfo.getState(), req.getState())){
				detailInfo.setPushTimes(req.getPushTimes());
				detailInfo.setProcessTimes(req.getProcessTimes());
				detailInfo.setGetTimes(req.getGetTimes());
				detailInfo.setState(req.getState());
				LogUtil.log.info("--------------3.修改批次详情状态-------------------");
				batchDetailServerDao.updateState(detailInfo);
			}else{
				throw new EmptyParamExcption("param error,batchInfo state not update,batchInfo state="+detailInfo.getState()+",taggetState="+req.getState());
			}
		}else{
			LogUtil.log.info("--------------1.判断批次是否存在-------------------");
			TBatchInfo batchInfo = checkBatchInfo(req.getBatchId(),null);
			LogUtil.log.info("--------------2.检查批次是否可修改-------------------");
			if(checkBatchState(batchInfo.getState(), req.getState())){
				batchInfo.setPushTimes(req.getPushTimes());
				batchInfo.setProcessTimes(req.getProcessTimes());
				batchInfo.setGetTimes(req.getGetTimes());
				batchInfo.setState(req.getState());
				LogUtil.log.info("--------------3.修改批次状态-------------------");
				batchServerDao.updateState(batchInfo);
			}else{
				throw new EmptyParamExcption("param error,batchInfo state not update,batchInfo state="+batchInfo.getState()+",taggetState="+req.getState());
			}
		}
	}
	
	/**
	 * 数据推送接收
	 */
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		if(req==null
				||StringUtils.isBlank(req.getBatchId())
				||req.getTableId()==null
				||StringUtils.isBlank(req.getTableCode())
				||!ConstantSync.checkTableIdCode(req.getTableId(), req.getTableCode())
				||req.getDataList()==null){
			req.setDataList(null);//避免数据大，所以设置为null
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));
		}
		LogUtil.log.info("--------------1.判断批次详情是否存在-------------------");
		TBatchDetailInfo batchDetailInfo = checkBatchDetailInfo(req.getBatchId(), req.getTableId(),ConstantSync.BatchState.PUSH_START);
		LogUtil.log.info("--------------2.开始插入-------------------tableId"+req.getTableId()+",tableCode="+req.getTableCode());
		if(req.getDataList().size()==0){
			LogUtil.log.info("--------------3.插入集合值为0，无需处理-------------------");
			return;
		}
		try{
			dataSyncFactory.getDataSyncServiceInvoker(req.getTableId()).pushBatchData(req);
			//修改推送数量
			batchDetailInfo.setPushNum(batchDetailInfo.getPushNum()+req.getDataList().size());
			batchDetailServerDao.updateCountNum(batchDetailInfo);
			LogUtil.log.info("--------------3.插入完成-------------------");
		}catch(Exception e){
			LogUtil.log.info("--------------3.插入错误-------------------");
			throw new CommonErrorException("push insert error,message:"+e.getMessage());
		}
	}

	@Override
	public List<TBatchDataResultInfo> getBatchDataResult(BatchDataResultGetReq req) {
		if(req==null
				||StringUtils.isBlank(req.getBatchId())
				||req.getTableId()==null
				||StringUtils.isBlank(req.getTableCode())
				||!ConstantSync.checkTableIdCode(req.getTableId(), req.getTableCode())
				){
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));
		}
		LogUtil.log.info("--------------1.判断批次详情是否存在-------------------");
		checkBatchDetailInfo(req.getBatchId(), req.getTableId(),ConstantSync.BatchState.SYNC_RESULT);
		LogUtil.log.info("--------------2.判断批次是否存在-------------------");
		List<TBatchDataResultInfo> resultList = null;
		try{
			resultList = dataSyncFactory.getDataSyncServiceInvoker(req.getTableId()).getBatChDataResult(req);
			if(resultList==null){
				throw new EmptyObjectExcption("not query detail result");
			}
			LogUtil.log.info("--------------3.返回结果完成-------------------");
			return resultList;
		}catch(Exception e){
			LogUtil.log.info("--------------3.返回结果错误-------------------");
			throw new CommonErrorException("result return error,message:"+e.getMessage());
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :checkBatchInfo
	 * @Description:检查批次是否存在
	 * @return TBatchInfo
	 * @date 2017年3月18日 下午2:55:50
	 */
	private TBatchInfo checkBatchInfo(String batchId,Integer state){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("batchId", batchId);
		params.put("state", state);
		TBatchInfo batchInfo = batchServerDao.queryBatchInfo(params);
		if(batchInfo==null)
			throw new EmptyObjectExcption(" batchInfo is null,batchId="+batchId+",state="+state);
		return batchInfo;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :checkBatchDetailInfo
	 * @Description:检查批次详情
	 * @return TBatchDetailInfo
	 * @date 2017年3月18日 下午3:05:28
	 */
	private TBatchDetailInfo checkBatchDetailInfo(String batchId,Integer tableId,Integer state){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("batchId", batchId);
		params.put("tableId", tableId);
		if(state!=null)
			params.put("state", state);
		TBatchDetailInfo batchDetailInfo = batchDetailServerDao.queryBatchDetailInfo(params);
		if(batchDetailInfo==null)
			throw new EmptyObjectExcption(" batchDetailInfo is null,batchId="+batchId+",tableId="+tableId+",state="+state);
		return batchDetailInfo;
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :checkBatchState
	 * @Description:判断目前状态是否可修改
	 * @return boolean
	 * @date 2017年3月18日 下午2:55:12
	 */
	private boolean checkBatchState(int sourceState,int state){
		return sourceState<state;
	}
	
	/**
	 * 批次异步处理
	 */
	@Override
	public void doBatchProcess(BatchProcessDoReq req) {
		TimerUtil time = new TimerUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", ConstantSync.BatchState.PUSH_END);
		params.put("batchId", req.getBatchId());
		params.put("tableId", req.getTableId());
		params.put("processSize", processSize);
		List<TBatchInfo> batchInfoList = batchServerDao.queryBatchInfoList(params);
		if(batchInfoList==null||batchInfoList.isEmpty()){
			LogUtil.log.info("---------------------no do process batch----------------------");
			return;
		}
		int pSize=batchInfoList.size();
		//如果没有线程数，指定为10
		processSize = processSize==null?10:processSize;
		//如果线程大于数量，责用数量
		pSize= processSize>pSize?pSize:processSize;
		//开启线程处理
		ExecutorService exec = Executors.newFixedThreadPool(pSize);
		LogUtil.log.info("---------------------open thread pool：{},batchList:{}----------------------",pSize,batchInfoList.size());
		final CountDownLatch doneSignal = new CountDownLatch(batchInfoList.size());
		for(final TBatchInfo batchInfo:batchInfoList){
			Runnable run = new Runnable() {
				@Override
				public void run() {
					doProcessBatchAsync(batchInfo);
					doneSignal.countDown();
				}
			};
			exec.submit(run);
		}
		try {
			doneSignal.await();
		} catch (InterruptedException e) {
			LogUtil.log.error("doBatchProcess error,msg:{}",e.getMessage());
		}finally {
			exec.shutdown();
			LogUtil.log.info("doBatchProcess end,bitch size="+batchInfoList.size()+",timer="+time.end());
		}
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :doProcessBatchAsync
	 * @Description:批次单独处理
	 * @return void
	 * @date 2017年3月21日 上午11:10:45
	 */
	public void doProcessBatchAsync(TBatchInfo batchInfo){
		TimerUtil timer = new TimerUtil();
		LogUtil.log.info("------------1.开始处理批次-----------batchId：{}",batchInfo.getBatchId());
		try{
			Map<String, Object> params = JsonUtil.toObject(JsonUtil.toJson(batchInfo), HashMap.class);
			List<TBatchDetailInfo> detailList = batchDetailServerDao.queryBatchDetailList(params);
			LogUtil.log.info("------------2.获取批次详情-----------batchId："+batchInfo.getBatchId()+",size:"+(detailList!=null?detailList.size():0));
			if(detailList!=null){//如果没有详情，直接修改为处理完成
				batchInfo.setState(ConstantSync.BatchState.DATA_HADLE);//标记批次开始处理
				batchServerDao.updateState(batchInfo);
				for(TBatchDetailInfo detail:detailList){
					detail.setState(batchInfo.getState());//标记批次详情开始处理
					batchDetailServerDao.updateState(detail);
					try{//异常捕获，确保其它数据能正常执行
						TimerUtil time = new TimerUtil();
						LogUtil.log.info("------------2.1 处理批次详情开始-----------batchId：{}，tableId:{}",batchInfo.getBatchId(),+detail.getTableId());
						DataSyncService service = dataSyncFactory.getDataSyncServiceInvoker(detail.getTableId());
						service.dataProcessSync(detail);
						detail.setProcessTimes(time.end());
						detail.setState(ConstantSync.BatchState.SYNC_RESULT);//标记批次详情处理完成
						batchDetailServerDao.updateState(detail);
						batchDetailServerDao.updateCountNum(detail);
						LogUtil.log.info("------------2.2 处理批次详情完成-----------batchId：{},tableId:{},pushNum：{},handleNum:",
								new Object[]{batchInfo.getBatchId(),detail.getTableId(),detail.getPushNum(),detail.getHandleNum()});
					}catch(Exception e){//异常捕获并抛出
						detail.setState(ConstantSync.BatchState.SYNC_ERROR);
						batchDetailServerDao.updateState(detail);
						batchDetailServerDao.updateCountNum(detail);
						LogUtil.logError.error("-------------async do process batch detail Error,batchId:{},tableId:{},error:{}",
								new Object[]{batchInfo.getBatchId(),detail.getTableId(),e.getMessage()});
					}
				}
			}
			batchInfo.setState(ConstantSync.BatchState.SYNC_RESULT);//标记批次处理完成
			batchInfo.setProcessTimes(timer.end());
			batchServerDao.updateState(batchInfo);
			LogUtil.log.info("------------3.批次处理完成-----------batchId：{}",batchInfo.getBatchId());
		}catch (Exception e) {
			LogUtil.logError.error("-------------async do process batch Error,batchId:{},error:{}",batchInfo.getBatchId(),e.getMessage());
			batchInfo.setProcessTimes(timer.end());
			batchInfo.setState(ConstantSync.BatchState.PUSH_END);
			batchServerDao.updateState(batchInfo);
		}finally{
			LogUtil.log.debug("doBatchProcess end,batchId:{},timer:{}",batchInfo.getBatchId(),(batchInfo.getProcessTimes()==null?timer.end():batchInfo.getProcessTimes()));
		}
	}

	@Override
	public void pushPatientMergeInfo(PatientMergeInfoSyncReq req) {
		if(req==null||req.getMergeFlag()==null||req.getMergeFromUuid()==null||req.getMergeTargetUuid()==null){
			throw new EmptyParamExcption("param error,param:"+JsonUtil.toJson(req));
		}
		mergePatientInfoHandle.mergePatientInfoDeleteHandle(req);
	}
	@Override
	public void loadingBatch() {
		int num = batchServerDao.updateUnfinishedProcessing();
	}
}
