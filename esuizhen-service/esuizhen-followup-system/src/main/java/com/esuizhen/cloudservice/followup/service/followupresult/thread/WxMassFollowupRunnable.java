package com.esuizhen.cloudservice.followup.service.followupresult.thread;

import java.util.concurrent.ExecutorService; 
import java.util.concurrent.Executors;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.westangel.common.spring.SpringContext;
import com.westangel.common.util.LogUtil;

public class WxMassFollowupRunnable implements Runnable {

	private FollowupWxResultService followupWxResultService;

	private FollowupMsgSendReq followupMsgSendReq;


	public WxMassFollowupRunnable(FollowupMsgSendReq followupMsgSendReq) {
		this.followupMsgSendReq = followupMsgSendReq;
		this.followupWxResultService = (FollowupWxResultService) SpringContext.getBean("followupWxResultService");
	}

	@Override
	public void run() {
		try {
			synchronized (followupMsgSendReq) {
				followupWxResultService.sendSpecifyWxFollowup(followupMsgSendReq);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
		}

	}

	public static void main(String args[]) {
		Long userIds[] = new Long[10];
		for (Integer i = 0; i < 10; i++) {
			userIds[i] = i.longValue();
		}
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
	}

}
