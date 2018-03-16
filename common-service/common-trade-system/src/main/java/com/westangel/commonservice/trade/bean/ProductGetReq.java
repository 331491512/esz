/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author chenghao
 * @date  2017年2月17日 下午8:21:28
 */
public class ProductGetReq {
	private Long userId;
	private int productType;
	private Long buyer;
	private Integer reqFlag;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public int getProductType() {
		return productType;
	}
	public void setProductType(int productType) {
		this.productType = productType;
	}
	public Long getBuyer() {
		return buyer;
	}
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
}
