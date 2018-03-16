/**
 * 
 * @author Da Loong
 * @date  2016年6月2日 下午4:23:15
 */
package com.westangel.commonservice.trade.bean;

import java.util.List;

/**
 * @author Da Loong
 * @date  2016年6月2日 下午4:23:15
 */
public class THospitalProductInitReq {

	private  Long  userId;
	
	private List<THospitalProductInitInfo> productList;

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the productList
	 */
	public List<THospitalProductInitInfo> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<THospitalProductInitInfo> productList) {
		this.productList = productList;
	}
	
	
}
