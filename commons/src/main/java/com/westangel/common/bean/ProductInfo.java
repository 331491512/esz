package com.westangel.common.bean;

import java.io.Serializable;

public class ProductInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 业务线ID
	 */
	private Integer businessId;
	/**
	 * 产品ID
	 */
	private Integer productId;
	public ProductInfo(Integer businessId, Integer productId){
		super();
		this.setBusinessId(businessId);
		this.setProductId(productId);
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
	 * 
	* @Title: key 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public String key(){
		return ""+businessId+"-"+productId+"";
	}

}
