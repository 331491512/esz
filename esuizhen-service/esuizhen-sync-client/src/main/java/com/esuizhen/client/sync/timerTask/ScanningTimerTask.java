package com.esuizhen.client.sync.timerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esuizhen.client.sync.common.ConstantClient;
import com.esuizhen.client.sync.service.BatchService;
import com.westangel.common.util.LogUtil;

/**
 * 
 * @author lhy
 *
 */
@Service(value = "timerTask")
public class ScanningTimerTask {
	//是否运行
	public static boolean run_flag = true;
	public static boolean pushSyncFlag=true;
	public static Runnable runnable =null;
	
	
	@Autowired
	private BatchService batchService;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :initStart
	 * @Description:初始化完成
	 * @return void
	 * @date 2017年3月18日 下午6:39:53
	 */
	@PostConstruct
	public void initStart(){
		//总开关控制
		batchService.initSyncCtl();
		batchService.loadingBatch();
	}
	
	@Scheduled(cron = "${batch.push.timer}")
	public void scanningBatchPush(){
		try{
			LogUtil.log.info("ctl control is : ctlFlag="+ConstantClient.ctlFlag+";ctlPushFlag="+ConstantClient.ctlPushFlag+";pushSyncFlag="+pushSyncFlag);
			if(ConstantClient.ctlFlag==0||ConstantClient.ctlPushFlag==0||!ScanningTimerTask.pushSyncFlag)
				return;
			if(this.runnable==null){
				this.runnable = new Runnable(){
					@Override
					public void run() {
						try{
							ScanningTimerTask.pushSyncFlag=false;
							LogUtil.log.info("-------------批次定时执行开始-------------");
							batchService.runBatchPush();
							LogUtil.log.info("-------------批次定时执行结束-------------");
						}catch(Exception e){
							LogUtil.log.info("-------------批次定时执行错误-------------");
						}finally{
							ScanningTimerTask.pushSyncFlag=true;
						}
					}
				};
				LogUtil.log.info("-------------线程装载成功-------------");
			}
			new Thread(this.runnable).start(); 
			LogUtil.log.info("-------------线程启动-------------");
		}catch(Exception e){
			LogUtil.log.info("-------------线程执行错误-------------");
		}
	}
	
	@Scheduled(cron = "${batch.get.timer}")
	public void scanningBatchGetResult(){
//		batchService.initSyncCtl();
		if(ConstantClient.ctlFlag==0||ConstantClient.ctlGetFlag==0)
			return;
		LogUtil.log.info("-------------批次结果拉取定时执行开始-------------");
		batchService.runBatchGetResult();
		LogUtil.log.info("-------------批次结果拉取定时执行结束-------------");
	}
	
	@Scheduled(cron = "${patient.merger.timer}")
	public void scanningMerger(){
		if(ConstantClient.ctlFlag==0)
			return;
		LogUtil.log.info("-------------合并同步定时执行开始-------------");
		batchService.runPatientMerger();
		LogUtil.log.info("-------------合并同步定时执行结束-------------");
	}
	
	@Scheduled(cron = "${incre.sync.result.timer}")
	public void scanningIncreSyncResult(){
		if(ConstantClient.ctlFlag==0)
			return;
		LogUtil.log.info("-------------增量同步结果初始化定时执行开始-------------");
		batchService.runIncreSyncResult();
		LogUtil.log.info("-------------增量同步结果初始化定时执行结束-------------");
	}
	
	@Scheduled(cron = "${data.monitor.push.timer}")
	public void scanningPushMonitorData(){
		if(ConstantClient.ctlFlag==0)
			return;
		LogUtil.log.info("-------------数据监控统计开始-------------");
		batchService.pushMonitorToServer(null);
		LogUtil.log.info("-------------数据监控统计结束-------------");
	}
}
