package com.esuizhen.cloudservice.ehr.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.service.patientreport.ReportPushService;
import com.westangel.common.util.LogUtil;

@Service(value = "reportPushServiceTimerTask")
public class ReportPushServiceTimerTask {
	@Autowired
	ReportPushService reportPushService;

	/**
	 * 
	 * @Title: invokeWhenStarup
	 * @Description: 启动时执行一次
	 * @param 设定文件
	 * @return void 返回类型
	 * @throws
	 */
	// @PostConstruct
	public void invokeWhenStarup() {
	}

	public void scanAddReportBatchWait() {
		try {
			LogUtil.log.info("【开始】轮询要推送检查/检验报告的患者");
			reportPushService.addReportBatchWait();
			LogUtil.log.info("【结束】轮询要推送检查/检验报告的患者");
		} catch (Exception e) {
			LogUtil.log.error("[轮询要推送检查/检验报告的患者失败！]," + e.getMessage());
		}
	}
	
	public void scanPushReportBatch() {
		try {
			LogUtil.log.info("【开始】推送检查/检验报告");
			reportPushService.pushReportBatch();
			LogUtil.log.info("【结束】推送检查/检验报告");
		} catch (Exception e) {
			LogUtil.log.error("[推送检查/检验报告失败！]," + e.getMessage());
		}
	}
}
