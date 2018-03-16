package com.westangel.commonservice.push.model.getui;

import com.westangel.commonservice.push.model.PushChannelInfo;

/**
* @author 作者 :LIPENG
* @Description: 个推
* @version 创建时间：2015年12月6日 下午5:09:38
* 类说明
*/
public class GetuiChannelInfo extends PushChannelInfo {
	//app编号
	private String appId;
	//secret
	private String appSecret;
	
	public void setAppId(String appId) {
		this.appId = appId;
	}
	
	public String getAppId() {
		return appId;
	}
	
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	
	public String getAppSecret() {
		return appSecret;
	}	
}
