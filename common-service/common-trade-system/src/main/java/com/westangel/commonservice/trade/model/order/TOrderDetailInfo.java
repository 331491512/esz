/**
 * 
 */
package com.westangel.commonservice.trade.model.order;

import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPaymentItemInfo;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.model.coupon.CouponInfo;

import java.util.Date;
import java.util.List;



/** 订单详细信息
 * @author bigdragon
 * @date  2015-12-22 下午2:27:35
 */
public class TOrderDetailInfo {
	
	private String orderId; //订单ID

	private String orderNo; //订单编号
	
	private Long buyer;  //买家userId
	
	private String buyerName;
	
	private Long vendor; //卖家userId
	
	private String vendorName;
	
	private String orderTitle; //订单标题
	
	private float totalPrice; //总价
	
	private float discount;   //折扣。默认1.0（不打折)

	private float realPrice;  //实际支付价格。 realPrice=totalPrice*discount
	
	private float plusPrice;  //加价价格

	private int   state;   //状态：0:未支付, 1：已支付
	
	private String stateName; 
	
	private String remark;    //备注
	
	private String contactMobile ;//联系电话
	
	private String createTime;
	
	private String updateTime;
	
	private String description; //病情描述
	
	private int    subscriptionFlag;
	
	private int    inPackage; //是否套餐内产品。套餐内产品申请时，填1.（后端不再计费，但记使用次数）
	
	private int    quota; //配额。inPackage=1时有效。
	
	private int    usage;//配额使用次数。inPackage=1时有效。
	
	private String  parentProductName; //父类产品名。inPackage=1时有效。
	
	private String recommendedDoctor;//引荐医生。MDT需要。
	
	private Long agentApplicant;//代理申请者userId
	
	private Integer wxProductId;//微信产品编号
	
	private float discountPrice;//抵用价格
	
	private String couponIds; //抵用券Id集合
	
	private List<CouponInfo> coupons; //抵用券集合
	
	private Integer agentPayFlag; // 代支付状态
	
	private List<TAgentPayInfo> agentPayList; //代支付列表
	
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getCouponIds() {
		return couponIds;
	}
	public void setCouponIds(String couponIds) {
		this.couponIds = couponIds;
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
	private String attachement; //附件。病历照片url
	
	
	
	private List<TProductOrderInfo> orderProductList; //订单商品列表

	private List<TOrderPaymentItemInfo> orderPaymentItemList;//订单支付项明细

	private Integer productSubType;//产品子类型

	public List<TOrderPaymentItemInfo> getOrderPaymentItemList() {
		return orderPaymentItemList;
	}

	public void setOrderPaymentItemList(List<TOrderPaymentItemInfo> orderPaymentItemList) {
		this.orderPaymentItemList = orderPaymentItemList;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
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
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
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
	 * @return the discount
	 */
	public float getDiscount() {
		return discount;
	}
	/**
	 * @param discount the discount to set
	 */
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	/**
	 * @return the orderProductList
	 */
	public List<TProductOrderInfo> getOrderProductList() {
		return orderProductList;
	}
	/**
	 * @param orderProductList the orderProductList to set
	 */
	public void setOrderProductList(List<TProductOrderInfo> orderProductList) {
		this.orderProductList = orderProductList;
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
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}
	/**
	 * @param stateName the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the updateTime
	 */
	public String getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}
	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
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
	 * @return the subscriptionFlag
	 */
	public int getSubscriptionFlag() {
		return subscriptionFlag;
	}
	/**
	 * @param subscriptionFlag the subscriptionFlag to set
	 */
	public void setSubscriptionFlag(int subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}
	/**
	 * @return the inPackage
	 */
	public int getInPackage() {
		return inPackage;
	}
	/**
	 * @param inPackage the inPackage to set
	 */
	public void setInPackage(int inPackage) {
		this.inPackage = inPackage;
	}
	/**
	 * @return the quota
	 */
	public int getQuota() {
		return quota;
	}
	/**
	 * @param quota the quota to set
	 */
	public void setQuota(int quota) {
		this.quota = quota;
	}
	/**
	 * @return the usage
	 */
	public int getUsage() {
		return usage;
	}
	/**
	 * @param usage the usage to set
	 */
	public void setUsage(int usage) {
		this.usage = usage;
	}
	/**
	 * @return the parentProductName
	 */
	public String getParentProductName() {
		return parentProductName;
	}
	/**
	 * @param parentProductName the parentProductName to set
	 */
	public void setParentProductName(String parentProductName) {
		this.parentProductName = parentProductName;
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
	public Long getAgentApplicant() {
		return agentApplicant;
	}
	public void setAgentApplicant(Long agentApplicant) {
		this.agentApplicant = agentApplicant;
	}
	public Integer getWxProductId() {
		return wxProductId;
	}
	public void setWxProductId(Integer wxProductId) {
		this.wxProductId = wxProductId;
	}
	public List<CouponInfo> getCoupons() {
		return coupons;
	}
	public void setCoupons(List<CouponInfo> coupons) {
		this.coupons = coupons;
	}
	
	
	public Integer getAgentPayFlag() {
		return agentPayFlag;
	}
	public void setAgentPayFlag(Integer agentPayFlag) {
		this.agentPayFlag = agentPayFlag;
	}
	public List<TAgentPayInfo> getAgentPayList() {
		return agentPayList;
	}
	public void setAgentPayList(List<TAgentPayInfo> agentPayList) {
		this.agentPayList = agentPayList;
	}
	/**
	 * @return
	 */
	public TOrderPayInfo createPayOrderInfo() {
		// TODO Auto-generated method stub
		TOrderPayInfo info = new TOrderPayInfo();
		info.setBalancePayValue(0);
		info.setOnlinePayAccount("");
		info.setOnlinePayNo("");
		info.setOnlinePayValue(realPrice-discountPrice);
		info.setOnlinePayWay(0);
		info.setOrderId(orderId);
		info.setPoints(0);
		info.setPointsPayValue(0);
		if(coupons!=null){
			info.setCoupons(coupons.size());
			info.setCouponsPayValue(discountPrice);
		}
		//根据线上支付金额来判断是否支付
		if(info.getOnlinePayValue()<=0l){
			info.setState(1);
			info.setPayCompleteTime(new Date());
			info.setRemark("支付成功");
		}
		else
			info.setState(0);
		LogUtil.log.info("createOrderPayInfo(): state="+info.getState());
		return info;
	}
}
