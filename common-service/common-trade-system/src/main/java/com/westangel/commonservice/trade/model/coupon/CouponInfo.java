/**
 * 
 */
package com.westangel.commonservice.trade.model.coupon;

import java.util.Date;

/**
 * @author chenghao
 * @date  2016年6月30日 上午10:47:29
 */
public class CouponInfo {
	private String couponId;
	private String couponTemplateId;
	private Integer couponState;
	private Long owner;
	private Date startDate;
	private Date endDate;
	private Float price;
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponTemplateId() {
		return couponTemplateId;
	}
	public void setCouponTemplateId(String couponTemplateId) {
		this.couponTemplateId = couponTemplateId;
	}
	public Integer getCouponState() {
		return couponState;
	}
	public void setCouponState(Integer couponState) {
		this.couponState = couponState;
	}
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public CouponInfo(){}
	public CouponInfo(String couponId,Integer couponState,Float price,Long owner){
		this.couponId=couponId;
		this.couponState=couponState;
		this.price = price;
		this.owner = owner;
	}
}
