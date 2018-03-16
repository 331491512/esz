/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author bigdragon
 * @date  2016-1-10 下午4:45:35
 */
public class TOrderPayPrepareReq {
	
	private  TOrderPrepareInfo  orderInfo;
	
	private  TPayPrepareInfo    payInfo;

	/**
	 * @return the payInfo
	 */
	public TPayPrepareInfo getPayInfo() {
		return payInfo;
	}

	/**
	 * @param payInfo the payInfo to set
	 */
	public void setPayInfo(TPayPrepareInfo payInfo) {
		this.payInfo = payInfo;
	}

	/**
	 * @return the orderInfo
	 */
	public TOrderPrepareInfo getOrderInfo() {
		return orderInfo;
	}

	/**
	 * @param orderInfo the orderInfo to set
	 */
	public void setOrderInfo(TOrderPrepareInfo orderInfo) {
		this.orderInfo = orderInfo;
	}
	
	
}
