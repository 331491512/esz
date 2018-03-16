/**
 * 
 */
package com.westangel.commonservice.trade.model.product;

import java.util.List;

/**
 * 产品（商品）详情定义
 * @author bigdragon
 * @date  2015-12-19 
 */
public class TProductDetailInfo {

	private String productId;   //商品ID
	private String productNo;   //商品编号
	private String productName; //商品名
	private int    productType; //类型。1：图文咨询；2：电话咨询；3：预约挂号；4：MDT（专家组会诊);5: 私人医生
	private long   vendorId;    //提供商ID， 如医生的userId
	private String vendorName;  //提供商名字。如医生姓名。
	private String introduction;//商品介绍
	private int    productSpecId; //商品规格ID
	private String productSpec; //商品规格
	private float  refPrice;    //参考价格
	private float  unitPrice;   //商品价格
	private int    feeType;     //付费类型。 1：预付费(默认)；2：后付费；3：即时付费
	private float  discount;    //折扣。 realPrice=unitPrice*discount;
	private int    state;       //1: 上架； 2：下架（关闭）
	private int    isGroup;     //是否为组。0：否；1：是；
	
	private List<TProductGroupMemberInfo> groupMemberList; //组成员列表
	
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
	
	
}
