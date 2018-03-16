package com.esuizhen.server.sync.timerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.esuizhen.server.sync.bean.BatchProcessDoReq;
import com.esuizhen.server.sync.service.BatchService;
import com.westangel.common.util.LogUtil;

/**
 * 
 * @author lhy
 *
 */
public class ScanningTimerTask {
	//是否运行
	public static boolean run_flag = true;
	
	@Autowired
	private BatchService batchService;
	
	@PostConstruct
	public void initStart(){
		//处理错误执行中的数据
		batchService.loadingBatch();
	}
	
	@Scheduled(cron = "30 17 16 * * ?")
	public void scanning() {
		
	}
	
	@Scheduled(cron = "${batch.sync.process.timer}")
	public void runSyncDataProcess(){
		LogUtil.log.info("----------批次异步处理开始--------------");
		batchService.doBatchProcess(new BatchProcessDoReq());
		LogUtil.log.info("----------批次异步处理结束--------------");
	}
	
	@Scheduled(cron = "${batch.sync.process.timer.week}")
	public void runSyncDataProcessWeek(){
		LogUtil.log.info("----------批次异步处理开始--------------");
		batchService.doBatchProcess(new BatchProcessDoReq());
		LogUtil.log.info("----------批次异步处理结束--------------");
	}
}
