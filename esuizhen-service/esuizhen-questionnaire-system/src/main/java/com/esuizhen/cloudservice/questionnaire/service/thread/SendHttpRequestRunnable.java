package com.esuizhen.cloudservice.questionnaire.service.thread;


import com.esuizhen.cloudservice.questionnaire.util.MyHttpUtil;
import com.westangel.common.util.LogUtil;

public class SendHttpRequestRunnable<T> implements Runnable {
	
	private T reqObj;
	private String url;
	
	public SendHttpRequestRunnable(T reqObj,String url) {
		this.reqObj = reqObj;
		this.url=url;
	}
 

	@Override
	public void run() {
		try {
			synchronized (reqObj) {
				MyHttpUtil.postJson(url, reqObj);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
		}
	}
}
