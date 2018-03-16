package com.westangel.commonservice.sms.bean.yuntongxun;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
* @ClassName: YuntongxunBillReq 
* @Description: 实时话单 
* @author LIPENG
* @date 2016年1月31日 下午1:04:36 
*
 */
@XmlRootElement(name="CDR")
public class YuntongxunCallerBillReq {
	private String appId;
	private String callSid;
	private String userData;
	private String subId;
	private String caller;
	private String called;
	private String starttime;
	private String endtime;
	private String duration;
	private String beginCallTime;
	private String ringingBeginTime;
	private String ringingEndTime;
	private String byetype;
	private String recordurl;
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
	/** 
	* @return subId 
	*/
	public String getSubId() {
		return subId;
	}
	/** 
	* @param subId 要设置的 subId 
	*/
	public void setSubId(String subId) {
		this.subId = subId;
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
	* @return starttime 
	*/
	public String getStarttime() {
		return starttime;
	}
	/** 
	* @param starttime 要设置的 starttime 
	*/
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	/** 
	* @return endtime 
	*/
	public String getEndtime() {
		return endtime;
	}
	/** 
	* @param endtime 要设置的 endtime 
	*/
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	/** 
	* @return duration 
	*/
	public String getDuration() {
		return duration;
	}
	/** 
	* @param duration 要设置的 duration 
	*/
	public void setDuration(String duration) {
		this.duration = duration;
	}
	/** 
	* @return beginCallTime 
	*/
	public String getBeginCallTime() {
		return beginCallTime;
	}
	/** 
	* @param beginCallTime 要设置的 beginCallTime 
	*/
	public void setBeginCallTime(String beginCallTime) {
		this.beginCallTime = beginCallTime;
	}
	/** 
	* @return ringingBeginTime 
	*/
	public String getRingingBeginTime() {
		return ringingBeginTime;
	}
	/** 
	* @param ringingBeginTime 要设置的 ringingBeginTime 
	*/
	public void setRingingBeginTime(String ringingBeginTime) {
		this.ringingBeginTime = ringingBeginTime;
	}
	/** 
	* @return ringingEndTime 
	*/
	public String getRingingEndTime() {
		return ringingEndTime;
	}
	/** 
	* @param ringingEndTime 要设置的 ringingEndTime 
	*/
	public void setRingingEndTime(String ringingEndTime) {
		this.ringingEndTime = ringingEndTime;
	}
	/** 
	* @return byetype 
	*/
	public String getByetype() {
		return byetype;
	}
	/** 
	* @param byetype 要设置的 byetype 
	*/
	public void setByetype(String byetype) {
		this.byetype = byetype;
	}
	/** 
	* @return recordurl 
	*/
	public String getRecordurl() {
		return recordurl;
	}
	/** 
	* @param recordurl 要设置的 recordurl 
	*/
	public void setRecordurl(String recordurl) {
		this.recordurl = recordurl;
	}
}
