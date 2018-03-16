package com.westangel.commonservice.trade.bean;

import com.westangel.common.bean.trade.TOrderPaymentItemInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 订单提交准备信息。此订单尚未完成支付。
 * @author bigdragon
 *
 */
public class TOrderPrepareInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long   buyer;       //买家userId
	
	private Long threeVendor; //三方卖家
	
	private String productId;   //商品ID
	
	private float realPrice;  //实际支付价格。 realPrice=totalPrice*discount
	
	private float  plusPrice;   //加价价格
	
	private String remark;      //备注
	
	private String contactMobile ;//联系电话
	
	private String description; //病情描述
	
	private String attachement; //附件。病历照片url
	
	private String orderId; //如果此值不为空，则表示已经通过服务系统创建过未支付订单了。只要更新即可
	
	private String recommendedDoctor;//引荐医生。MDT需要。
	
	private Integer wxProductId; //微信号
	
	private String couponIds; //需要使用优惠券集合
	
	private Float discountPrice;  //抵扣价格

	private Integer productSubType;//产品子类型

	private float totalPrice;//总价

	private List<TOrderPaymentItemInfo> orderPaymentItemList;//订单支付项明细

	public List<TOrderPaymentItemInfo> getOrderPaymentItemList() {
		return orderPaymentItemList;
	}

	public void setOrderPaymentItemList(List<TOrderPaymentItemInfo> orderPaymentItemList) {
		this.orderPaymentItemList = orderPaymentItemList;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
	}

	public TOrderPrepareInfo(){
		buyer = 0L;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
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
	 * @return the plusPrice
	 */
	public float getPlusPrice() {
		return plusPrice;
	}

	/**
	 * @param plusPrice the plusPrice to set
	 */
	public void setPlusPrice(float plusPrice) {
		this.plusPrice = plusPrice;
	}



	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * @return the contactMobile
	 */
	public String getContactMobile() {
		return contactMobile;
	}

	/**
	 * @param contactMobile the contactMobile to set
	 */
	public void setContactMobile(String contactMobile) {
		this.contactMobile = contactMobile;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAttachement() {
		return attachement;
	}

	public void setAttachement(String attachement) {
		this.attachement = attachement;
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
	 * @return the recommendedDoctor
	 */
	public String getRecommendedDoctor() {
		return recommendedDoctor;
	}

	/**
	 * @param recommendedDoctor the recommendedDoctor to set
	 */
	public void setRecommendedDoctor(String recommendedDoctor) {
		this.recommendedDoctor = recommendedDoctor;
	}

	public Integer getWxProductId() {
		return wxProductId;
	}

	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}

	public String getCouponIds() {
		return couponIds;
	}

	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
	}

	public Float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getThreeVendor() {
		return threeVendor;
	}

	public void setThreeVendor(Long threeVendor) {
		this.threeVendor = threeVendor;
	}
}
