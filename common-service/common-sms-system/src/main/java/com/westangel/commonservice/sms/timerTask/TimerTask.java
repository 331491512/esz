package com.westangel.commonservice.sms.timerTask;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.sms.service.SmsService;

@Service(value="timerTask")
public class TimerTask {
	@Autowired
	SmsService smsService;
	
	public static boolean pushSmsReport = false;
	//最后一次获取时间
	public static Date lastGetReportDate;
	/**
	 * 
	* @Title: invokeWhenStarup 
	* @Description: 启动时执行
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@PostConstruct
	public void invokeWhenStarup()
	{
		
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getSmsReportAndPush
	 * @Description:执行短信拉取
	 * @return void
	 * @date 2016年8月26日 上午9:50:34
	 */
	@Scheduled(cron="0 * * * * ?")
	public void getSmsReportAndPush()
	{
		if(pushSmsReport){
			LogUtil.log.debug("start get sms report");
			if(smsService.getSmsReport()){
				lastGetReportDate = new Date();
			}else{
				if(lastGetReportDate==null){
					lastGetReportDate = new Date();
					return;
				}
				//判断如果大于3天没有获取到数据 直接关闭定时器
				if((new Date()).getTime()-lastGetReportDate.getTime()>1000l*60*60*24*3){
					pushSmsReport = false;
				}
			}
		}
	}
}
