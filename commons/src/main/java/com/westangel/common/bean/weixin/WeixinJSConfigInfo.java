package com.westangel.common.bean.weixin;

public class WeixinJSConfigInfo implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1508860881452436874L;
	
	private String appId;
	
	private String timestamp;
	
	private String nonceStr;
	
	private String signature;

	/** 
	* @return appId 
	*/
	public String getAppId() {
		return appId;
	}

	/** 
	* @param appId 要设置的 appId 
	*/
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/** 
	* @return timestamp 
	*/
	public String getTimestamp() {
		return timestamp;
	}

	/** 
	* @param timestamp 要设置的 timestamp 
	*/
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	/** 
	* @return nonceStr 
	*/
	public String getNonceStr() {
		return nonceStr;
	}

	/** 
	* @param nonceStr 要设置的 nonceStr 
	*/
	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	/** 
	* @return signature 
	*/
	public String getSignature() {
		return signature;
	}

	/** 
	* @param signature 要设置的 signature 
	*/
	public void setSignature(String signature) {
		this.signature = signature;
	}
	
}
