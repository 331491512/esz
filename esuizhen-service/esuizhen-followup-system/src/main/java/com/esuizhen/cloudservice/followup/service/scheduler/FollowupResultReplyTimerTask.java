package com.esuizhen.cloudservice.followup.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.westangel.common.util.LogUtil;

@Service(value = "followupResultReplyTimerTask")
public class FollowupResultReplyTimerTask {
	@Autowired
	FollowupResultService followupResultService;

	@Autowired
	FollowupWxResultService followupWxResultService;

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

	/**
	 * @Title: scanAllReply
	 * @Description: 每隔半小时扫描微信及短信回复
	 */
//	@Scheduled(cron = "0 0/30 * * * ? ")
	public void scanAllReply() {
		try {
			followupWxResultService.scanWxReply();
		} catch (Exception e) {
			LogUtil.log.error("[扫描微信回复失败！]," + e.getMessage());
		}
		try {
			followupResultService.scanSmsReply();
		} catch (Exception e) {
			LogUtil.log.error("[扫描短信回复失败！]," + e.getMessage());
		}

	}
}
