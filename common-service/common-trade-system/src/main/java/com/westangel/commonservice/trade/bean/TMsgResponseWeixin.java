/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信支付通知响应
 * 为XML格式
 * @author bigdragon
 * @date  2016-1-11 下午11:51:47
 */
@XmlRootElement(name="xml") 
public class TMsgResponseWeixin {

	private String return_code;// 返回码。 SUCCESS/FAIL
	
	private String return_msg ;//描述

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
	
	
}
