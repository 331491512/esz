/**
 * 
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.List;

/**
 * 订单最简单信息
 * @author bigdragon
 * @date  2016-1-12 下午5:12:08
 */
public class TOrderMinInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;            //订单ID

	private Long   buyer;              //买方用户ID
	

	private Long   vendor;             //卖方用户ID。
	
	private String orderTitle;        //订单标题
	
	private float  realPrice;
	
	private int    state;             //订单状态。
							/*0: 买方已提交（默认）、未支付
							1：（买方）已支付
							2:  （卖方）已确认
							3：（卖方）已拒绝
							4：（服务）进行中
							5：（服务）已完成
							6：订单过期
							7：订单取消*/

	private String description;
	
	private String couponIds; //抵扣券
	
	private float discountPrice; //抵扣金额

	private float totalPrice;//总价

	private List<TOrderPaymentItemInfo> orderPaymentItemList;//订单支付明细项

	public List<TOrderPaymentItemInfo> getOrderPaymentItemList() {
		return orderPaymentItemList;
	}

	public void setOrderPaymentItemList(List<TOrderPaymentItemInfo> orderPaymentItemList) {
		this.orderPaymentItemList = orderPaymentItemList;
	}

	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return the buyer
	 */
	public Long getBuyer() {
		return buyer;
	}

	/**
	 * @param buyer the buyer to set
	 */
	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	/**
	 * @return the vendor
	 */
	public Long getVendor() {
		return vendor;
	}

	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(Long vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the orderTitle
	 */
	public String getOrderTitle() {
		return orderTitle;
	}

	/**
	 * @param orderTitle the orderTitle to set
	 */
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * @return the realPrice
	 */
	public float getRealPrice() {
		return realPrice;
	}

	/**
	 * @param realPrice the realPrice to set
	 */
	public void setRealPrice(float realPrice) {
		this.realPrice = realPrice;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public String getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}

	public float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	
}
