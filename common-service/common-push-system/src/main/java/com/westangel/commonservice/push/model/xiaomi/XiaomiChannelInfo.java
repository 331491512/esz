package com.westangel.commonservice.push.model.xiaomi;

import com.westangel.commonservice.push.model.PushChannelInfo;

/**
* @author 作者 :LIPENG
* @Description: 小米推送
* @version 创建时间：2015年12月5日 下午11:27:14
* 类说明
*/
public class XiaomiChannelInfo extends PushChannelInfo {
	//应用类型
	private String appType;
	//app编号
	private String appId;
	//key
	private String appKey;
	//secret
	private String appSecret;
	//app包名
	private String appPackageName;
	//是否正式环境，对IOS
	private Integer useOfficial=0;
	//说明信息
	private String remark="";
	
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

	/** 
	* @return appPackageName 
	*/
	public String getAppPackageName() {
		return appPackageName;
	}

	/** 
	* @param appPackageName 要设置的 appPackageName 
	*/
	public void setAppPackageName(String appPackageName) {
		this.appPackageName = appPackageName;
	}

	/** 
	* @return useOfficial 
	*/
	public Integer getUseOfficial() {
		return useOfficial;
	}

	/** 
	* @param useOfficial 要设置的 useOfficial 
	*/
	public void setUseOfficial(Integer useOfficial) {
		this.useOfficial = useOfficial;
	}

	/** 
	* @return remark 
	*/
	public String getRemark() {
		return remark;
	}

	/** 
	* @param remark 要设置的 remark 
	*/
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/** 
	* @return appKey 
	*/
	public String getAppKey() {
		return appKey;
	}

	/** 
	* @param appKey 要设置的 appKey 
	*/
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/** 
	* @return appType 
	*/
	public String getAppType() {
		return appType;
	}

	/** 
	* @param appType 要设置的 appType 
	*/
	public void setAppType(String appType) {
		this.appType = appType;
	}
	
	@Override
	public String key() {
		// TODO Auto-generated method stub
		return super.key()+appType;
	}
}
