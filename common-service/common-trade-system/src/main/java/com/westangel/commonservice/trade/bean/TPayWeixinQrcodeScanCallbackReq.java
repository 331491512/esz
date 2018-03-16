/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Da Loong
 * @date  2016年4月21日 下午7:44:17
 */
@XmlRootElement(name="xml") 
public class TPayWeixinQrcodeScanCallbackReq {

	private String appid;//对应微信公众号
	
	private String mch_id; //商户号
	
	private String openid; //对应一个微信用户
	
	private String  is_subscribe; //用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注
	
	private String nonce_str; //随机字符串。
	
	private String product_id;   //产品ID. 对应交易系统产品ID
	
	private String sign;        //签名

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

	/**
	 * @return the mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * @param mch_id the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * @return the openid
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * @param openid the openid to set
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}

	/**
	 * @return the is_subscribe
	 */
	public String getIs_subscribe() {
		return is_subscribe;
	}

	/**
	 * @param is_subscribe the is_subscribe to set
	 */
	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	/**
	 * @return the nonce_str
	 */
	public String getNonce_str() {
		return nonce_str;
	}

	/**
	 * @param nonce_str the nonce_str to set
	 */
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	/**
	 * @return the product_id
	 */
	public String getProduct_id() {
		return product_id;
	}

	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	/**
	 * @return the sign
	 */
	public String getSign() {
		return sign;
	}

	/**
	 * @param sign the sign to set
	 */
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
	
}
