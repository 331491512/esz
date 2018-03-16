/**
 * 
 */
package com.westangel.commonservice.trade.model.order;

/**
 * @author bigdragon
 * @date  2015-12-24 上午12:57:34
 */
public class TProductOrderInfo {
	private String orderId;     //订单ID
	
	private String productId;   //商品ID
	
	private String productNo;   //商品编号
	
	private String productName; //商品名
	
	private int    productType; //类型。1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	
	private long   vendor;    //提供商ID， 如医生的userId
	
	private String vendorName;  //提供商名字。如医生姓名。
	
	private String introduction;//商品介绍
	
	private int    productSpecId; //商品规格ID
	
	private String productSpec; //商品规格
	
	private float  unitPrice;   //商品价格
	
	private float    realPrice;     //实际价格
	private int      amount;         //购买数量

	private Integer productSubType;//产品子类型

	public TProductOrderInfo(){
		orderId = "";
		productId="";
		productNo="";
		productName="";
		productType=0;
		vendor=0;
		vendorName="";
		introduction="";
		productSpecId=0;
		productSpec="";
		unitPrice=0;
		realPrice=0;
		amount=0;
	}

	public Integer getProductSubType() {
		return productSubType;
	}

	public void setProductSubType(Integer productSubType) {
		this.productSubType = productSubType;
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
	public long getVendor() {
		return vendor;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendor(long vendorId) {
		this.vendor = vendorId;
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

}
