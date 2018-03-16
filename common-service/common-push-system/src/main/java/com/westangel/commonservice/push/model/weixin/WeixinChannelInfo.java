package com.westangel.commonservice.push.model.weixin;

import com.westangel.commonservice.push.model.PushChannelInfo;

/**
 * 
* @ClassName: WeixinChannelInfo 
* @Description: 微信通道 
* @author LIPENG
* @date 2015年12月16日 下午7:57:31 
*
 */
public class WeixinChannelInfo extends PushChannelInfo {
	/**
	 * 服务号
	 */
	private String serviceName;
	/**
	 * 是否从外部更新
	 */
	private Integer syncOutter=0;
	/**
	 * appId
	 */
	private String appId;
	/**
	 * appSecret
	 */
	private String appSecret;
	/**
	 * 凭证
	 */
	private String accessToken="";
	/**
	 * jsapi_ticket
	 */
	private String jsTicket="";
	/**
	 * 备注说明
	 */
	private String remark="";
	
	/**
	 * 商户号
	 */
	private String mchId;
	
	/**
	 * 证书路径
	 */
	private String certificatePath;
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
	* @return appSecret 
	*/
	public String getAppSecret() {
		return appSecret;
	}
	/** 
	* @param appSecret 要设置的 appSecret 
	*/
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	/** 
	* @return accessToken 
	*/
	public String getAccessToken() {
		return accessToken;
	}
	/** 
	* @param accessToken 要设置的 accessToken 
	*/
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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
	* @return serviceName 
	*/
	public String getServiceName() {
		return serviceName;
	}
	/** 
	* @param serviceName 要设置的 serviceName 
	*/
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	/** 
	* @return jsTicket 
	*/
	public String getJsTicket() {
		return jsTicket;
	}
	/** 
	* @param jsTicket 要设置的 jsTicket 
	*/
	public void setJsTicket(String jsTicket) {
		this.jsTicket = jsTicket;
	}
	/** 
	* @return syncOutter 
	*/
	public Integer getSyncOutter() {
		return syncOutter;
	}
	/** 
	* @param syncOutter 要设置的 syncOutter 
	*/
	public void setSyncOutter(Integer syncOutter) {
		this.syncOutter = syncOutter;
	}
	public String getMchId() {
		return mchId;
	}
	public void setMchId(String mchId) {
		this.mchId = mchId;
	}
	public String getCertificatePath() {
		return certificatePath;
	}
	public void setCertificatePath(String certificatePath) {
		this.certificatePath = certificatePath;
	}
}
