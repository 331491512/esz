/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.service.impl;<br/>  
 * <b>文件名：</b>BatchServiceImpl.java<br/>
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月18日下午6:34:49<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.client.sync.common.ConstantClient;
import com.esuizhen.client.sync.dao.PatientDao;
import com.esuizhen.client.sync.dao.sc.BatchClientDao;
import com.esuizhen.client.sync.dao.sc.BatchDetailClientDao;
import com.esuizhen.client.sync.dao.sc.ConfSyncDao;
import com.esuizhen.client.sync.dao.sc.DoIncreSyncResultDao;
import com.esuizhen.client.sync.dao.sc.MonitorClientDao;
import com.esuizhen.client.sync.model.ConfSyncInfo;
import com.esuizhen.client.sync.model.ConfTableInfo;
import com.esuizhen.client.sync.model.TBatchDetailInfo;
import com.esuizhen.client.sync.model.TBatchInfo;
import com.esuizhen.client.sync.service.BatchService;
import com.esuizhen.client.sync.service.DataSyncService;
import com.esuizhen.client.sync.service.factory.DataSyncFactory;
import com.esuizhen.client.sync.util.ClientRequestServerUtil;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sync.MonitorDataPushReq;
import com.westangel.common.constant.ConstantSync;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.TimerUtil;

/**
 * @ClassName: BatchServiceImpl
 * @Description:
 * @author lichenghao
 * @date 2017年3月18日 下午6:34:49
 */
@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private ConfSyncDao confSyncDao;
	@Autowired
	private BatchClientDao batchClientDao;
	@Autowired
	private BatchDetailClientDao batchDetailClientDao;
	@Autowired
	private DataSyncFactory dataSyncFactory;
	
	@Autowired
	private DoIncreSyncResultDao increSyncResultDao;
	@Autowired
	private PatientDao patientDao;
	
	@Autowired
	private MonitorClientDao monitorClientDao;

	/**
	 * 
	 * @author lichenghao
	 * @title :initSyncCtl
	 * @Description:初始化总体开关
	 * @return void
	 * @date 2017年3月18日 下午6:37:43
	 */
	@Override
	public void initSyncCtl() {// 初始化开关
		ConfSyncInfo info = confSyncDao.getConfSyncInfo();
		info.initParams();
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :runBatchPush
	 * @Description:数据推送开始执行
	 * @return void
	 * @date 2017年3月20日 下午7:29:29
	 */
	@Override
	public void runBatchPush() {//推送获取
		TimerUtil timer = new TimerUtil();
		//1.获取是否有未开始的批次
		TBatchInfo batchInfo = null;
		try{
			batchInfo = getBatchInfo();
		}catch(Exception e){
			LogUtil.logError.error("getBatchInfo Error,msg:{}",e.getMessage());
		}
		if(batchInfo==null){
			return;
		}
		//2.批次开始执行
		if(batchInfo.getState()<ConstantSync.BatchState.PUSH_START)//如果批次小于1
			batchStateUpdate(batchInfo, ConstantSync.BatchState.PUSH_START);
		//3.数据推送
		TBatchDetailInfo userDetail=null;
		for(TBatchDetailInfo detail :batchInfo.getTableList()){
			LogUtil.log.info("---------batch detail push start,batchId:{},tableId:{},state:{}-----------"
					,new Object[]{detail.getBatchId(),detail.getTableId(),detail.getState()});
			//3.1详情推送开始
			if(detail.getState()<ConstantSync.BatchState.PUSH_START){//如果状态小于1 更新推送开始
				batchDetailStateUpdate(detail, ConstantSync.BatchState.PUSH_START);
			}
			else{//否则更新推送完成
				if(detail.getState()<ConstantSync.BatchState.PUSH_END)
					batchDetailStateUpdate(detail, ConstantSync.BatchState.PUSH_END);
				continue;
			}
			if(detail.getTableId()==ConstantSync.TableId.USER){
				userDetail=detail;
				continue;
			}
			TimerUtil time = new TimerUtil();
			DataSyncService dataService = dataSyncFactory.getDataSyncServiceInvoker(detail.getTableId());
			if(dataService==null){//如果service不存在 默认执行完成
				batchDetailStateUpdate(detail, ConstantSync.BatchState.DATA_HADLE);
				continue;
			}
			//3.2向云端推送结果
			int pushNum = dataService.pushDataToServer(detail);
			if(pushNum==0||pushNum==-1){//如果推送条数为0 默认同步完成
				batchDetailStateUpdate(detail, ConstantSync.BatchState.SYNC_OK);
				continue;
			}
			detail.setPushNum(pushNum);
			batchDetailClientDao.updateCountNum(detail);
			detail.setPushTimes(time.end());
			//3.3结果推送完成
			batchDetailStateUpdate(detail, ConstantSync.BatchState.PUSH_END);
			LogUtil.log.info("---------batch detail push end,batchId:{},tableId:{},state:{}-----------"
					,new Object[]{detail.getBatchId(),detail.getTableId(),detail.getState()});
		}
		if(userDetail!=null){//用户结果特殊处理
			batchDetailStateUpdate(userDetail, ConstantSync.BatchState.PUSH_END);
		}
		//4.批次执行结束
		batchInfo.setPushTimes(timer.end());
		batchStateUpdate(batchInfo, ConstantSync.BatchState.PUSH_END);
		LogUtil.log.info("batch push end,batchId="+batchInfo.getBatchId()+",timer="+batchInfo.getGetTimes());
	}

	@Override
	public void runBatchGetResult() {
		//获取待同步的结果数据
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("state", ConstantSync.BatchState.PUSH_END);
		List<TBatchInfo> list = batchClientDao.queryBatchInfoList(params);
		if(list==null||list.size()==0)
			return;
		for(TBatchInfo batchInfo:list){
			LogUtil.log.info("----------批次结果获取开始------------batchId="+batchInfo.getBatchId());
			params.clear();
			params.put("batchId", batchInfo.getBatchId());
			params.put("state", ConstantSync.BatchState.PUSH_END);
			List<TBatchDetailInfo> detailList = batchDetailClientDao.queryBatchDetailList(params);
			if(detailList==null||detailList.size()==0){//如果没有可完成的批次，则同步完成
				batchStateUpdate(batchInfo, ConstantSync.BatchState.SYNC_OK);
				LogUtil.log.info("----------批次结果获取结束------------batchId="+batchInfo.getBatchId());
				continue;
			}
			int unfinishedNum=0;//未完成的结果数量
			TimerUtil timer = new TimerUtil();
			for(TBatchDetailInfo detail:detailList){
				DataSyncService service = dataSyncFactory.getDataSyncServiceInvoker(detail.getTableId());
				if(service==null){//如果service不存在 设定为同步完成
					batchDetailStateUpdate(detail, ConstantSync.BatchState.SYNC_OK);
					continue;
				}
				TimerUtil time = new TimerUtil();
				int resultNum = service.getResultFromServer(detail);
				if(resultNum>=0){//结果获取完成 修改同步完成状态 
					batchDetailClientDao.updateCountNum(detail);
					detail.setGetTimes(time.end());
					batchDetailStateUpdate(detail, ConstantSync.BatchState.SYNC_OK);
				}else{//结果获取未完成  未完成数+1  小于0 未获取有效结果
					unfinishedNum++;
				}
			}
			if(unfinishedNum==0){//如果未完成结果为0  批次结果完成
				batchInfo.setGetTimes(timer.end());
				batchStateUpdate(batchInfo, ConstantSync.BatchState.SYNC_OK);
				LogUtil.log.debug("get result end,batchId="+batchInfo.getBatchId()+",timer="+batchInfo.getGetTimes());
			}
		}
	}


	@Override
	public void runPatientMerger() {
		//获取被合并已同步的患者
		List<LinkedHashMap> list=patientDao.getBatchMegerPatient();
		if(list==null||list.size()==0){
			LogUtil.log.debug("------------没有发现被合并已同步的患者---------------");
			return;
		}
		StringBuilder sf=new StringBuilder();
		for (LinkedHashMap map : list) {
			try {
				if(map.get("mergeFromUuid")==null||map.get("mergeTargetUuid")==null){
                    LogUtil.log.debug("------------uuid is null,患者不存在---------------");
                    continue;
                }
				String json = JsonUtil.toJson(map);
				LogUtil.log.debug("------------推送合并的患者{}---------------",json);
				String res = ClientRequestServerUtil.pushPatientMerge(json);
				TMsgResponse<Object> msg = JsonUtil.toObject(res, TMsgResponse.class);
				if (msg!=null && msg.getRespCode() == 0) {
                    sf.append(map.get("patientId").toString());
                    if(sf.length()>0)
                    	sf.append(",");
                    LogUtil.log.debug("------------推送完成---------------");
                }else{
                    LogUtil.log.debug("------------推送失败---------------");
                }
			} catch (Exception e) {
				LogUtil.logError.error(e.getMessage(),e);
			}
		}
		if(sf.length()>0){
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("patientIds", sf);
			params.put("syncFlag", -3);
			patientDao.updatePatientSyncflag(params);
		}

	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getBatchInfo
	 * @Description:获取批次
	 * @return TBatchInfo
	 * @date 2017年3月20日 下午7:12:28
	 */
	private TBatchInfo getBatchInfo(){
		//1.本地获取批次
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("hospitalId", ConstantClient.hospitalId);
		params.put("state", ConstantSync.BatchState.SYNC_INIT);
		TBatchInfo batchInfo = batchClientDao.queryBatchInfo(params);
		boolean isNull = batchInfo==null;
		//2.服务端批次同步
		{
			List<ConfTableInfo> list = confSyncDao.getConfTableInfoList();
			if(list==null||list.size()==0)
				return null;
			params.remove("state");
			params.put("tableList", list);
			if(!isNull)
				params.put("batchId",batchInfo.getBatchId());
			String result = ClientRequestServerUtil.getBatchInfo(JsonUtil.toJson(params));
			LogUtil.log.info("-----------sync batchInfo------------\r\n params{}\r\n result:{}",JsonUtil.toJson(params),result);
			TMsgResponse<Object> msg = JsonUtil.toObject(result, TMsgResponse.class);
			if(msg==null){
				LogUtil.logError.error("------------获取批次失败---------------");
				return null;
			}else if(msg.getRespCode()!=0){
				LogUtil.logError.error("------------获取批次失败---------------code:"+msg.getRespCode()+",msg:"+msg.getRespMsg());
				return null;
			}
			batchInfo = JsonUtil.toObject(JsonUtil.toJson(msg.getResult()), TBatchInfo.class);
			if(isNull){//客户端不存在
				batchClientDao.insert(batchInfo);
				for(TBatchDetailInfo detail:batchInfo.getTableList()){
					batchDetailClientDao.insert(detail);
				}
				LogUtil.log.info("-----------sync new batchInfo------------batchId:{}",batchInfo.getBatchId());
			}else{//更新状态
				batchClientDao.updateState(batchInfo);
				LogUtil.log.info("-----------sync old batchInfo------------batchId:{},state:{}",batchInfo.getState());
			}
		}
		//3.从本地获取批次详情
		params.clear();
		params.put("batchId", batchInfo.getBatchId());
		batchInfo.setTableList(batchDetailClientDao.queryBatchDetailList(params));
		return batchInfo;
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :batchStateUpdate
	 * @Description:修改批次状态
	 * @return void
	 * @date 2017年3月20日 下午7:01:17
	 */
	@Transactional
	private void batchStateUpdate(TBatchInfo batchInfo,Integer state) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("batchId", batchInfo.getBatchId());
		params.put("state",state);
		params.put("pushTimes", batchInfo.getPushTimes());
		params.put("getTimes", batchInfo.getGetTimes());
		if(batchInfo!=null
				&&batchInfo.getState()>ConstantSync.BatchState.PUSH_END
				&&batchInfo.getState()<ConstantSync.BatchState.SYNC_OK){//只更新当前库状态 ，不更新服务端
			batchInfo.setState(state);
			batchClientDao.updateState(batchInfo);
			return;
		}
		for(int i=0;i<3;i++){
			String result = ClientRequestServerUtil.updateBatchProcess(JsonUtil.toJson(params));
			try{
				TMsgResponse<Object> msg = JsonUtil.toObject(result, TMsgResponse.class);
				if(msg==null||msg.getRespCode()!=0){
					if(msg==null)
						LogUtil.logError.error("------------批次修改失败---------------;batchId="+batchInfo.getBatchId()+",state="+state);
					else
						LogUtil.logError.error("------------批次修改失败---------------;batchId="+batchInfo.getBatchId()
						+",state="+state+";msg.respCode="+msg.getRespCode()+",msg.respMsg="+msg.getRespMsg());
					if(batchInfo.getState()==ConstantSync.BatchState.PUSH_END){
						if(msg==null||msg.getRespCode()!=1415){
							batchRollBack(batchInfo);//回滚状态
						}else if(msg.getRespCode()==1415){//如果等于1415 进行本地修改
							batchInfo.setState(state);
							batchClientDao.updateState(batchInfo);
						}
					}
				}else{
					batchInfo.setState(state);
					batchClientDao.updateState(batchInfo);
					return;
				}
			}catch(Exception e){
				LogUtil.logError.error("------------update batch state error,msg{}-------------",e.getMessage());
			}
		}
	}
	/**
	 * 
	 * @author lichenghao
	 * @title :batchDetailStateUpdate
	 * @Description:修改详情状态
	 * @return void
	 * @date 2017年3月20日 下午7:01:04
	 */
	@Transactional
	private void batchDetailStateUpdate(TBatchDetailInfo batchDetail,Integer state) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("batchId", batchDetail.getBatchId());
		params.put("tableId", batchDetail.getTableId());
		params.put("tableCode", ConstantSync.Sync_Table.getInfoViaId(batchDetail.getTableId()).code);
		params.put("state",state);
		params.put("pushTimes", batchDetail.getPushTimes());
		params.put("getTimes", batchDetail.getGetTimes());
		for(int i=0;i<3;i++){
			try{
				String result = ClientRequestServerUtil.updateBatchProcess(JsonUtil.toJson(params));
				LogUtil.log.info("------------updateDetail-------------result:{}");
				TMsgResponse<Object> msg = JsonUtil.toObject(result, TMsgResponse.class);
				if(msg==null||msg.respCode!=0){
					if(msg==null)
						LogUtil.logError.error("------------批次详情修改失败---------------;batchId="+batchDetail.getBatchId()+",state="+state);
					else
						LogUtil.logError.error("------------批次详情修改失败---------------;batchId="+batchDetail.getBatchId()
						+",state="+state+";msg.respCode="+msg.getRespCode()+",msg.respMsg="+msg.getRespMsg());
					if(batchDetail.getState()==ConstantSync.BatchState.PUSH_END){
						batchDetailRollBack(batchDetail);//回滚状态
						throw new EmptyObjectExcption("update batchDetail state error ，msg:"+JsonUtil.toJson(msg));
					}
				}else{
					batchDetail.setState(state);
					batchDetailClientDao.updateState(batchDetail);
					return;
				}
			}catch(Exception e){
				LogUtil.logError.error("------------update batch detail state error,msg{}-------------",e.getMessage());
			}
		}
	}
	
	//批次状态回滚
	private void batchRollBack(TBatchInfo info){
		info.setState(ConstantSync.BatchState.SYNC_INIT);
		batchClientDao.updateState(info);
	}
	//批次详情状态回滚
	private void batchDetailRollBack(TBatchDetailInfo detail){
		detail.setState(ConstantSync.BatchState.SYNC_INIT);
		batchDetailClientDao.updateState(detail);
		TBatchInfo info = new TBatchInfo();
		info.setBatchId(detail.getBatchId());
		batchRollBack(info);
	}
	
	@Override
	public void runIncreSyncResult() {
		LogUtil.log.info("------------增量同步结果刷新开始----------------");
		List<ConfTableInfo> list = confSyncDao.getConfTableInfoList();
		if(list!=null&&list.size()>0){
			for(ConfTableInfo tableInfo:list){
				try{
					if(tableInfo.getTableId()!=null)
						increSyncResultDao.doIncreSyncResultPre(tableInfo.getTableId());
				}catch(Exception e){
					LogUtil.log.error("incre "+tableInfo.getTableCode()+" sync result error,msg:"+e.getMessage());
				}
			}
		}
		LogUtil.log.info("------------增量同步结果刷新结束----------------");
	}

	@Override
	public void loadingBatch() {
		batchClientDao.updateUnfinishedPush();
	}

	@Override
	public void pushMonitorToServer(String date) {
		MonitorDataPushReq req = new MonitorDataPushReq();
		monitorClientDao.updateMonitorSyncFlag("client_temp_data_monitor", 0, 9);
		monitorClientDao.updateMonitorSyncFlag("client_formal_data_monitor", 0, 9);
		monitorClientDao.updateMonitorSyncFlag("client_sync_data_monitor", 0, 9);
		req.setClientTempDataMonitor(monitorClientDao.queryTempDataMonitor(date));
		req.setClientFormalDataMonitor(monitorClientDao.queryFormalDataMonitor(date));
		req.setClientSyncDataMonitor(monitorClientDao.querySyncDataMonitor(date));
		String result = ClientRequestServerUtil.pushMonitorData(JsonUtil.toJson(req));
		TMsgResponse<Object> msg = JsonUtil.toObject(result, TMsgResponse.class);
		if(msg==null||msg.respCode!=0){
			monitorClientDao.updateMonitorSyncFlag("client_temp_data_monitor", 9, 0);
			monitorClientDao.updateMonitorSyncFlag("client_formal_data_monitor", 9, 0);
			monitorClientDao.updateMonitorSyncFlag("client_sync_data_monitor", 9, 0);
			LogUtil.logError.error("----------------------监控统计数据推送失败--------------------------");
		}else{
			monitorClientDao.updateMonitorSyncFlag("client_temp_data_monitor", 9, 1);
			monitorClientDao.updateMonitorSyncFlag("client_formal_data_monitor", 9, 1);
			monitorClientDao.updateMonitorSyncFlag("client_sync_data_monitor", 9, 1);
			LogUtil.log.info("----------------------监控统计数据推送成功--------------------------");
		}
	}
}
