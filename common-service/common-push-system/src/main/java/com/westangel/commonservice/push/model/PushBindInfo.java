package com.westangel.commonservice.push.model;

/**
* @author 作者 :LIPENG
* @Description: 推送绑定信息
* @version 创建时间：2015年12月5日 下午11:36:32
* 类说明
*/
public class PushBindInfo {
	//类型
	private Integer bindType;
	//设备类型
	private Integer deviceType;
	//token
	private String deviceToken;
	//业务线编号
	private Integer businessId;
	//产品Id
	private Integer productId;
	
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
}
