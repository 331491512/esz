/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import java.util.List;

/**
 * 商品下架（服务关闭）请求消息
 * @author bigdragon
 * @date  2015-12-25 上午1:29:38
 */
public class TProductOffShelfReq {
	private Long userId;
	private List<String> productIdList;
	
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
	 * @return the productIdList
	 */
	public List<String> getProductIdList() {
		return productIdList;
	}
	/**
	 * @param productIdList the productIdList to set
	 */
	public void setProductIdList(List<String> productIdList) {
		this.productIdList = productIdList;
	}

}
