package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.List;

/**
 * 订单提交信息
 * @author bigdragon
 *
 */
public class TOrderPublishInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productApplyId; //产品申请号。服务系统中传入
	
	private String orderId;        //调用交易系统createOrder时传入空，之后由服务系统获得返回值后被赋值，给通知下发流程使用
	
	private String orderTitle;  //订单标题
	
	private Long   buyer;       //买家userId
	
	private Long   vendor;      //卖家userId
	
	private String productId;   //商品ID
	
	private int    productType; //类型。1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	
	private float totalPrice; //总价
	
	private float discount;   //折扣。默认1.0（不打折)

	private float realPrice;  //实际支付价格。 realPrice=totalPrice*discount
	
	private float  plusPrice;   //加价价格
	
	private int    amount;      //购买数量
	
	private int    state;       //0:未支付；1：已支付. 缺省0.
	
	private String remark;      //备注
	
	private String contactMobile ;//联系电话
	
	private String description; //病情描述
	
	private String treatmentCourse;	//治疗经过
	
	private String explain;			//其他描述
	
	private String attachement; //图片url列表
	
	private int    inPackage; //是否套餐内产品。套餐内产品申请时，填1.（后端不再计费，但记使用次数）
	
	private int    quota; //配额。inPackage=1时有效。
	
	private int    usage;//配额使用次数。inPackage=1时有效。
	
	private String  parentProductName; //父类产品名。inPackage=1时有效。
	
	private Long agentApplicant; //代理医生UserId

	private String recommendedDoctor;//引荐医生。MDT需要。
	
	private Integer wxProductId; //微信公众号ID。从哪个公众号来的订单，使用对应公众号的支付配置和消息推送
	
	private String couponIds; //需要使用优惠券集合
	
	private Float discountPrice;  //抵扣价格
	
	private Integer applySource;//申请来源。　2：微信(默认)　3：app　4：Web

	private int allowGoldRoll;//是否允许使用抵金卷。 0:不可以使用   1：可以使用
	
	private String agentAccountId; //代理支付账户

	private List<TOrderPaymentItemInfo> orderPaymentItemList;//订单支付项明细

	private Integer productSubType;//子类型

	public TOrderPublishInfo(){
		buyer = 0L;
		vendor = 0L;
		inPackage = 0;
		allowGoldRoll = 1;
		setQuota(0);
		setUsage(0);
	}
	/**
	 * @return the orderTitle
	 */
	public String getOrderTitle() {
		return orderTitle;
	}

	public int getAllowGoldRoll() {
		return allowGoldRoll;
	}
	public void setAllowGoldRoll(int allowGoldRoll) {
		this.allowGoldRoll = allowGoldRoll;
	}
	public Integer getApplySource() {
		return applySource;
	}
	public void setApplySource(Integer applySource) {
		this.applySource = applySource;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
	}

	public List<TOrderPaymentItemInfo> getOrderPaymentItemList() {
		return orderPaymentItemList;
	}

	public void setOrderPaymentItemList(List<TOrderPaymentItemInfo> orderPaymentItemList) {
		this.orderPaymentItemList = orderPaymentItemList;
	}

	/**
	 * @param orderTitle the orderTitle to set
	 */
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
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
	 * @return the productType
	 */
	public int getProductType() {
		return productType;
	}

	/**
	 * @param productType the productType to set
	 */
	public void setProductType(int productType) {
		this.productType = productType;
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
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
	 * @return the productApplyId
	 */
	public String getProductApplyId() {
		return productApplyId;
	}
	/**
	 * @param productApplyId the productApplyId to set
	 */
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
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
	public String getAgentAccountId() {
		return agentAccountId;
	}
	public void setAgentAccountId(String agentAccountId) {
		this.agentAccountId = agentAccountId;
	}
	public String getTreatmentCourse() {
		return treatmentCourse;
	}
	public void setTreatmentCourse(String treatmentCourse) {
		this.treatmentCourse = treatmentCourse;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
}
