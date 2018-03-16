/**
 * 
 * @author Da Loong
 * @date  2016年4月22日 下午2:31:48
 */
package com.westangel.commonservice.trade.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Da Loong
 * @date  2016年4月22日 下午2:31:48
 */
@XmlRootElement(name="xml") 
public class TMsgResponseWeixinPayCallback {
	
	private String return_code;// 返回码。 SUCCESS/FAIL
	
	private String return_msg ;//描述
	
	private String appid;//对应微信公众号
	
	private String mch_id; //商户号
	
	private String nonce_str; //随机字符串。
	
	private String prepay_id; //调用统一下单接口生成的预支付ID
	
	private String result_code; //SUCCESS/FAIL
	
	private String err_code_desc;//当result_code为FAIL时，商户展示给用户的错误提示
	
	private String sign;        //签名

	/**
	 * @return the return_code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * @param return_code the return_code to set
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * @return the return_msg
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * @param return_msg the return_msg to set
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

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
	 * @return the prepay_id
	 */
	public String getPrepay_id() {
		return prepay_id;
	}

	/**
	 * @param prepay_id the prepay_id to set
	 */
	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	/**
	 * @return the result_code
	 */
	public String getResult_code() {
		return result_code;
	}

	/**
	 * @param result_code the result_code to set
	 */
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	/**
	 * @return the err_code_desc
	 */
	public String getErr_code_desc() {
		return err_code_desc;
	}

	/**
	 * @param err_code_desc the err_code_desc to set
	 */
	public void setErr_code_desc(String err_code_desc) {
		this.err_code_desc = err_code_desc;
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
