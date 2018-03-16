package com.westangel.common.bean.sms;
/**
 * 
* @ClassName: CallTwoWayReq 
* @Description: 双向回拨 
* @author LIPENG
* @date 2015年12月28日 下午4:25:07 
*
 */
public class CallTwoWayReq implements java.io.Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 586349931357489986L;

	/**
	 * 业务线编号
	 */
	private Integer businessId;
	/**
	 * 产品编号
	 */
	private Integer productId;
	/**
	 * 主叫电话号码
	 */
	private String from;
	/**
	 * 被叫电话号码
	 */
	private String to;
	/**
	 * 被叫侧显示的号码
	 */
	private String toSerNum;
	/**
	 * 主叫侧显示的号码
	 */
	private String fromSerNum;
	/**
	 * 用户信息，如服务申请号
	 */
	private String userData="";
	/**
	 * 最长通话时间秒数，默认15分钟
	 */
	private String maxCallTime="900";
	/**
	 * 回调URL，会通过get的方式拼接?userData=xxx&result=0(1)
	 */
	private String callbackUrl="";
	/** 
	* @return from 
	*/
	public String getFrom() {
		return from;
	}
	/** 
	* @param from 要设置的 from 
	*/
	public void setFrom(String from) {
		this.from = from;
	}
	/** 
	* @return to 
	*/
	public String getTo() {
		return to;
	}
	/** 
	* @param to 要设置的 to 
	*/
	public void setTo(String to) {
		this.to = to;
	}
	/** 
	* @return fromSerNum 
	*/
	public String getFromSerNum() {
		return fromSerNum;
	}
	/** 
	* @param fromSerNum 要设置的 fromSerNum 
	*/
	public void setFromSerNum(String fromSerNum) {
		this.fromSerNum = fromSerNum;
	}
	/** 
	* @return businessId 
	*/
	public Integer getBusinessId() {
		return businessId;
	}
	/** 
	* @param businessId 要设置的 businessId 
	*/
	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}
	/** 
	* @return productId 
	*/
	public Integer getProductId() {
		return productId;
	}
	/** 
	* @param productId 要设置的 productId 
	*/
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	/** 
	* @return toSerNum 
	*/
	public String getToSerNum() {
		return toSerNum;
	}
	/** 
	* @param toSerNum 要设置的 toSerNum 
	*/
	public void setToSerNum(String toSerNum) {
		this.toSerNum = toSerNum;
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
	* @return maxCallTime 
	*/
	public String getMaxCallTime() {
		return maxCallTime;
	}
	/** 
	* @param maxCallTime 要设置的 maxCallTime 
	*/
	public void setMaxCallTime(String maxCallTime) {
		this.maxCallTime = maxCallTime;
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
}
