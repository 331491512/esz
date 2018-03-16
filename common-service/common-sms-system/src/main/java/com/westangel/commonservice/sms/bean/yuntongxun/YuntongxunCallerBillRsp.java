package com.westangel.commonservice.sms.bean.yuntongxun;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class YuntongxunCallerBillRsp {
	private String statuscode;

	/** 
	* @return statuscode 
	*/
	public String getStatuscode() {
		return statuscode;
	}

	/** 
	* @param statuscode 要设置的 statuscode 
	*/
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
}
