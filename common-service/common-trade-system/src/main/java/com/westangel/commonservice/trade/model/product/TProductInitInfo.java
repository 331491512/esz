/**
 * 
 */
package com.westangel.commonservice.trade.model.product;

/**
 * 产品初始化信息
 * @author DaLoong
 * @date  2016年2月16日 下午4:03:23
 */
public class TProductInitInfo {

	private String productId;   //商品ID
	private String productNo;   //商品编号
	private String productName; //商品名
	private int    productType; //类型。1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	private long   vendor;      //提供商ID， 如医生的userId
	private String introduction;//商品介绍
	private int    productSpecId; //商品规格ID
	private float  refPrice;    //参考价格
	private float  unitPrice;   //商品价格
	private int    feeType;     //付费类型。 1：预付费(默认)；2：后付费；3：即时付费
	private float  discount;    //折扣。 realPrice=unitPrice*discount;
	private int    state;       //1: 上架； 2：下架（关闭）
	private String productTemplateId;//产品模板ID
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
	 * @return the vendor
	 */
	public long getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(long vendor) {
		this.vendor = vendor;
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
	 * @return the productTemplateId
	 */
	public String getProductTemplateId() {
		return productTemplateId;
	}
	/**
	 * @param productTemplateId the productTemplateId to set
	 */
	public void setProductTemplateId(String productTemplateId) {
		this.productTemplateId = productTemplateId;
	}
	
	
}
