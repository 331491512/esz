package com.westangel.commonservice.sms.model.yuntongxun;
/**
 * 
* @ClassName: YuntongxunCallRecord 
* @Description: 通话记录 
* @author LIPENG
* @date 2016年1月31日 下午4:21:41 
*
 */
public class YuntongxunCallRecord {
	private Long id;
	private String userData;
	private String callbackUrl="";
	private String callSid="";
	private String request="";
	private String response1="";
	private String response2="";
	private String occurTime="";
	private String updateTime="";
	/**
	 * 0 已通话 1 未通话
	 */
	private Integer result=0;
	/** 
	* @return id 
	*/
	public Long getId() {
		return id;
	}
	/** 
	* @param id 要设置的 id 
	*/
	public void setId(Long id) {
		this.id = id;
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
	* @return callbackUrl 
	*/
	public String getCallbackUrl() {
		return callbackUrl;
	}
	/** 
	* @param callbackUrl 要设置的 callbackUrl 
	*/
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
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
	* @return result 
	*/
	public Integer getResult() {
		return result;
	}
	/** 
	* @param result 要设置的 result 
	*/
	public void setResult(Integer result) {
		this.result = result;
	}
	/** 
	* @return request 
	*/
	public String getRequest() {
		return request;
	}
	/** 
	* @param request 要设置的 request 
	*/
	public void setRequest(String request) {
		this.request = request;
	}
	/** 
	* @return response1 
	*/
	public String getResponse1() {
		return response1;
	}
	/** 
	* @param response1 要设置的 response1 
	*/
	public void setResponse1(String response1) {
		this.response1 = response1;
	}
	/** 
	* @return response2 
	*/
	public String getResponse2() {
		return response2;
	}
	/** 
	* @param response2 要设置的 response2 
	*/
	public void setResponse2(String response2) {
		this.response2 = response2;
	}
	/** 
	* @return occurTime 
	*/
	public String getOccurTime() {
		return occurTime;
	}
	/** 
	* @param occurTime 要设置的 occurTime 
	*/
	public void setOccurTime(String occurTime) {
		this.occurTime = occurTime;
	}
	/** 
	* @return updateTime 
	*/
	public String getUpdateTime() {
		return updateTime;
	}
	/** 
	* @param updateTime 要设置的 updateTime 
	*/
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}
