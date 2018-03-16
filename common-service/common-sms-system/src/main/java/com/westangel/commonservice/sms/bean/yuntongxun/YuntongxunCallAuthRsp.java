package com.westangel.commonservice.sms.bean.yuntongxun;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Response")
public class YuntongxunCallAuthRsp {
	private String statuscode;
	private String statusmsg;
	private String billdata;
	private String sessiontime;
	/** 
	* @return statusmsg 
	*/
	public String getStatusmsg() {
		return statusmsg;
	}
	/** 
	* @param statusmsg 要设置的 statusmsg 
	*/
	public void setStatusmsg(String statusmsg) {
		this.statusmsg = statusmsg;
	}
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
	/** 
	* @return billdata 
	*/
	public String getBilldata() {
		return billdata;
	}
	/** 
	* @param billdata 要设置的 billdata 
	*/
	public void setBilldata(String billdata) {
		this.billdata = billdata;
	}
	/** 
	* @return sessiontime 
	*/
	public String getSessiontime() {
		return sessiontime;
	}
	/** 
	* @param sessiontime 要设置的 sessiontime 
	*/
	public void setSessiontime(String sessiontime) {
		this.sessiontime = sessiontime;
	}
}
