/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import java.util.List;

import com.westangel.common.bean.trade.TProductDetailInfo;

/**
 * 商品上架（服务设置）请求消息
 * @author bigdragon
 * @date  2015-12-23 下午9:29:09
 */
public class TProductOnShelfReq {
	private Long userId;
	private List<TProductDetailInfo> productList;
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
	public List<TProductDetailInfo> getProductList() {
		return productList;
	}
	/**
	 * @param productList the productList to set
	 */
	public void setProductList(List<TProductDetailInfo> productList) {
		this.productList = productList;
	}

}
