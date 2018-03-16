package com.westangel.commonservice.sms.bean.yuntongxun;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="request")
public class YuntongxunCallAuthReq {
	private String action;
	private String orderid;
	private Integer type;
	private String subid;
	private String caller;
	private String called;
	private String subtype;
	private String callSid;
	private String userData;
	/** 
	* @return action 
	*/
	public String getAction() {
		return action;
	}
	/** 
	* @param action 要设置的 action 
	*/
	public void setAction(String action) {
		this.action = action;
	}
	/** 
	* @return orderid 
	*/
	public String getOrderid() {
		return orderid;
	}
	/** 
	* @param orderid 要设置的 orderid 
	*/
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/** 
	* @return type 
	*/
	public Integer getType() {
		return type;
	}
	/** 
	* @param type 要设置的 type 
	*/
	public void setType(Integer type) {
		this.type = type;
	}
	/** 
	* @return subid 
	*/
	public String getSubid() {
		return subid;
	}
	/** 
	* @param subid 要设置的 subid 
	*/
	public void setSubid(String subid) {
		this.subid = subid;
	}
	/** 
	* @return caller 
	*/
	public String getCaller() {
		return caller;
	}
	/** 
	* @param caller 要设置的 caller 
	*/
	public void setCaller(String caller) {
		this.caller = caller;
	}
	/** 
	* @return called 
	*/
	public String getCalled() {
		return called;
	}
	/** 
	* @param called 要设置的 called 
	*/
	public void setCalled(String called) {
		this.called = called;
	}
	/** 
	* @return callSid 
	*/
	public String getCallSid() {
		return callSid;
	}
	/** 
	* @param callSid 要设置的 callSid 
	*/
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	/** 
	* @return subtype 
	*/
	public String getSubtype() {
		return subtype;
	}
	/** 
	* @param subtype 要设置的 subtype 
	*/
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	/** 
	* @return userData 
	*/
	public String getUserData() {
		return userData;
	}
	/** 
	* @param userData 要设置的 userData 
	*/
	public void setUserData(String userData) {
		this.userData = userData;
	}
}
