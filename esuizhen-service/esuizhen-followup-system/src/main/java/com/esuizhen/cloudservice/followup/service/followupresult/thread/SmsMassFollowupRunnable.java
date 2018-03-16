package com.esuizhen.cloudservice.followup.service.followupresult.thread;


import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.westangel.common.spring.SpringContext;
import com.westangel.common.util.LogUtil;

public class SmsMassFollowupRunnable implements Runnable {
	private FollowupSmsResultService followupSmsResultService;
	
	private FollowupMsgSendReq followupMsgSendReq;
	
	public SmsMassFollowupRunnable(FollowupMsgSendReq followupMsgSendReq) {
		this.followupMsgSendReq = followupMsgSendReq;
		this.followupSmsResultService = (FollowupSmsResultService) SpringContext.getBean("followupSmsResultService");
	}


	@Override
	public void run() {
		try {
			synchronized (followupMsgSendReq) {
				followupSmsResultService.sendSpecifySmsFollowup(followupMsgSendReq);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
		}
	}
}
