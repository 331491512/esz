/**
 * 
 */
package com.westangel.commonservice.trade.model.pay;

/**
 * @author chenghao
 * @date  2016年6月20日 下午3:40:39
 */
public class WeiXinPayInfo {
	//微信服务号对应的appId
	private String appId;
	//微信服务号对应的appSecret
	private String appSecret;
	private String mchId;
	//证书路径
	private String certificatePath;
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
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
