/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author chenghao
 * @date  2016年6月30日 下午4:09:53
 */
public class CouponReq {
	private Integer reqFlag;
	private String couponId;
	private Long owner;
	private Long hospitalId;
	private String cityCode;
	private String diseaseCode;
	private String productType;
	private Float orderPrice;
	private String[] couponIds;
	public Integer getReqFlag() {
		return reqFlag;
	}
	public void setReqFlag(Integer reqFlag) {
		this.reqFlag = reqFlag;
	}
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	public Long getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	public String getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public Float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String[] getCouponIds() {
		return couponIds;
	}
	public void setCouponIds(String[] couponIds) {
		this.couponIds = couponIds;
	}
}
