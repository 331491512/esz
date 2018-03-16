package com.westangel.commonservice.push.bean;
/**
* @author 作者 :LIPENG
* @Description: TODO
* @version 创建时间：2015年12月5日 下午10:08:24
* 类说明
*/
public class PushBindReq {	
	/**
	 * 用户编号
	 */
	private Long userId;
	/**
	 * 用户角色
	 */
	private Integer userRole;
	/**
	 * 业务线编号
	 */
	private Integer businessId;
	/**
	 * 产品编号
	 */
	private Integer productId;
	/**
	 * 绑定类型
	 */
	private Integer bindType;
	/**
	 * 设备类型
	 */
	private Integer deviceType;
	/**
	 * diviceToken
	 */
	private String deviceToken;
	
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public Integer getUserRole() {
		return userRole;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setBindType(Integer bindType) {
		this.bindType = bindType;
	}
	public Integer getBindType() {
		return bindType;
	}
	/** 
	* @return deviceType 
	*/
	public Integer getDeviceType() {
		return deviceType;
	}
	/** 
	* @param deviceType 要设置的 deviceType 
	*/
	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
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
	* @return deviceToken 
	*/
	public String getDeviceToken() {
		return deviceToken;
	}
	/** 
	* @param deviceToken 要设置的 deviceToken 
	*/
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}
}
