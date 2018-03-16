package com.esuizhen.cloudservice.statistics.timerTask;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.statistics.service.StatisticsService;
import com.westangel.common.util.LogUtil;

@Service(value="timerTask")
public class TimerTask {
	
	@Autowired
	StatisticsService statisticsService;
	public static boolean isToB = true;
	/**
	 * 
	* @Title: invokeWhenStarup 
	* @Description: 启动时执行一次 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@PostConstruct
	public void invokeWhenStarup()
	{
		LogUtil.log.debug("--------------------timer start------------------------");
		isToB = checkTimerStart();
		if(isToB){
			return;
		}
		init_survivalRetaAndPatientInfo();
		send_survivalRetaReport();
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :checkTimerStart
	 * @Description:检查是否启动定时器
	 * @return boolean
	 * @date 2016年8月17日 上午8:34:59
	 */
	public boolean checkTimerStart(){
		return statisticsService.isToB();
	}
	/**
	 * 执行初始化数据
	 * @author lichenghao
	 * @title :init_survivalRetaAndPatientInfo
	 * @Description:TODO @Scheduled(cron="0 0 23 * * ? ")
	 * @return void
	 * @date 2016年4月13日 上午10:27:20
	 */
//	
	@Scheduled(cron="0 0 23 * * ? ")
	public void init_survivalRetaAndPatientInfo()
	{
		try {
			if(isToB)return;
			LogUtil.log.debug("--------------------execute update------------------------");
			statisticsService.update_data();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(cron="0 0 0/2 * * ? ")
	public void send_survivalRetaReport()
	{
		try {
			if(isToB)return;
			LogUtil.log.debug("--------------------execute update------------------------");
			statisticsService.checkFollowReportApply();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
