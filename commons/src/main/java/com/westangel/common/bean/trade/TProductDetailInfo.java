/**
 * 
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 产品（商品）详情定义
 * @author bigdragon
 * @date  2015-12-19 
 */
public class TProductDetailInfo implements Serializable {
	private static final long serialVersionUID = 2L;

	private String productId;   //商品ID
	private String productNo;   //商品编号
	private String productName; //商品名
	private int    productType; //类型。1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	private Integer productSource; 
	private long   vendorId;    //提供商ID， 如医生的userId
	private String vendorName;  //提供商名字。如医生姓名。
	private String introduction;//商品介绍
	private int    productSpecId; //商品规格ID
	private String productSpec; //商品规格
	private float  refPrice;    //参考价格
	private float  unitPrice;   //商品价格
	private float  discountPrice; //折扣价格
	private int    feeType;     //付费类型。 1：预付费(默认)；2：后付费；3：即时付费
	private float  discount;    //折扣。 realPrice=unitPrice*discount;
	private int    state;       //1: 上架； 2：下架（关闭）
	private int    enable;      //使能标识。0：不可用（此时卖方只能查看，不可修改。身份未审核通过时置为0）；  1：启用
	private int    isGroup;     //是否为组。0：否；1：是；
	private int    orderState; //订单状态。
	private int    subscriptionFlag; //订单进行状态
	private String orderId;    //订单ID
	private String description;//商品详情
	private String expressPrice; //快递费参数
	private Integer hospitalCertificateFlag;  //是否需要医院认证
	private Integer certificateFlag; //是否需要实名认证
	private Integer expressCompanyId; //快递公司Id
	private String productPictureUrls;//商品图片
	private String provider; // 第三方提供商
	private String customerMobile; // 客服电话
	private Date   createTime;
	private Integer productSubType;//产品子类型
	private String productSubTypes;
	private Integer isFeeThree; //是否支付给三方
	
	private List<TProductGroupMemberInfo> groupMemberList; //组成员列表
	private List<TProductCategoryInfo> productCategoryList;//类别列表

	private String productTemplateId;
	
	public TProductDetailInfo(){
		feeType = 1;
		productId = "";
		productName = "";
		productType = 1;
		vendorId = 9;
		vendorName = "";
		introduction = "";
		productSpecId =0;
		productSpec = "";
		setRefPrice(0);
		unitPrice = 0;
		state = 1;
		isGroup=0;
		setEnable(1);
	}

	public String getProductTemplateId() {
		return productTemplateId;
	}

	public void setProductTemplateId(String productTemplateId) {
		this.productTemplateId = productTemplateId;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
	}

	public String getProductSubTypes() {
		return productSubTypes;
	}

	public void setProductSubTypes(String productSubTypes) {
		this.productSubTypes = productSubTypes;
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
	 * @return the productNo
	 */
	public String getProductNo() {
		return productNo;
	}

	/**
	 * @param productNo the productNo to set
	 */
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
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
	 * @return the vendorId
	 */
	public long getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(long vendorId) {
		this.vendorId = vendorId;
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
	 * @return the introduction
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * @param introduction the introduction to set
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * @return the productSpec
	 */
	public String getProductSpec() {
		return productSpec;
	}

	/**
	 * @param productSpec the productSpec to set
	 */
	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	/**
	 * @return the unitPrice
	 */
	public float getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the feeType
	 */
	public int getFeeType() {
		return feeType;
	}

	/**
	 * @param feeType the feeType to set
	 */
	public void setFeeType(int feeType) {
		this.feeType = feeType;
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
	 * @return the productSpecId
	 */
	public int getProductSpecId() {
		return productSpecId;
	}

	/**
	 * @param productSpecId the productSpecId to set
	 */
	public void setProductSpecId(int productSpecId) {
		this.productSpecId = productSpecId;
	}

	/**
	 * @return the refPrice
	 */
	public float getRefPrice() {
		return refPrice;
	}

	/**
	 * @param refPrice the refPrice to set
	 */
	public void setRefPrice(float refPrice) {
		this.refPrice = refPrice;
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
	 * @return the isGroup
	 */
	public int getIsGroup() {
		return isGroup;
	}

	/**
	 * @param isGroup the isGroup to set
	 */
	public void setIsGroup(int isGroup) {
		this.isGroup = isGroup;
	}

	/**
	 * @return the groupMemberList
	 */
	public List<TProductGroupMemberInfo> getGroupMemberList() {
		return groupMemberList;
	}

	/**
	 * @param groupMemberList the groupMemberList to set
	 */
	public void setGroupMemberList(List<TProductGroupMemberInfo> groupMemberList) {
		this.groupMemberList = groupMemberList;
	}

	/**
	 * @return the orderState
	 */
	public int getOrderState() {
		return orderState;
	}

	/**
	 * @param orderState the orderState to set
	 */
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	/** 
	* @return orderId 
	*/
	public String getOrderId() {
		return orderId;
	}

	/** 
	* @param orderId 要设置的 orderId 
	*/
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/** 
	* @return description 
	*/
	public String getDescription() {
		return description;
	}

	/** 
	* @param description 要设置的 description 
	*/
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the enable
	 */
	public int getEnable() {
		return enable;
	}

	/**
	 * @param enable the enable to set
	 */
	public void setEnable(int enable) {
		this.enable = enable;
	}

	public int getSubscriptionFlag() {
		return subscriptionFlag;
	}

	public void setSubscriptionFlag(int subscriptionFlag) {
		this.subscriptionFlag = subscriptionFlag;
	}

	public String getExpressPrice() {
		return expressPrice;
	}

	public void setExpressPrice(String expressPrice) {
		this.expressPrice = expressPrice;
	}

	public Integer getHospitalCertificateFlag() {
		return hospitalCertificateFlag;
	}

	public void setHospitalCertificateFlag(Integer hospitalCertificateFlag) {
		this.hospitalCertificateFlag = hospitalCertificateFlag;
	}

	public Integer getCertificateFlag() {
		return certificateFlag;
	}

	public void setCertificateFlag(Integer certificateFlag) {
		this.certificateFlag = certificateFlag;
	}

	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public Integer getProductSource()
	{
		return productSource;
	}

	public void setProductSource(Integer productSource)
	{
		this.productSource = productSource;
	}

	public String getProductPictureUrls() {
		return productPictureUrls;
	}

	public void setProductPictureUrls(String productPictureUrls) {
		this.productPictureUrls = productPictureUrls;
	}

	public float getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public Integer getIsFeeThree() {
		return isFeeThree;
	}

	public void setIsFeeThree(Integer isFeeThree) {
		this.isFeeThree = isFeeThree;
	}

	public List<TProductCategoryInfo> getProductCategoryList() {
		return productCategoryList;
	}

	public void setProductCategoryList(List<TProductCategoryInfo> productCategoryList) {
		this.productCategoryList = productCategoryList;
	}
}
