/**
 * 
 */
package com.westangel.commonservice.trade.bean;

/**
 * @author chenghao
 * @date  2016年6月30日 下午4:13:32
 */
public class TCouponInfo {
	//抵用券编号
	private String couponId;
	//抵用券名称
	private String couponName;
	//抵用券类型
	private Integer couponType;
	//抵用数额
	private Float couponNumber;
	//抵用券状态
	private Integer couponState;
	//抵用券起始时间
	private String startDate;
	//抵用券结束时间
	private String endDate;
	//最大抵用金额
	private Float maxPrice;
	//最小订单金额
	private Float minOrderPrice;
	//背景图片
	private String backimage;
	//抵用券类型名称
	private String typeName;
	//可分享次数
	private Integer shareNum;
	//可叠加使用次数
	private Integer superpositionNum;
	//红包是否可以抵用
	private Integer isCouponRed;
	
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponName() {
		return couponName;
	}
	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
	public Integer getCouponType() {
		return couponType;
	}
	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
	public Float getCouponNumber() {
		return couponNumber;
	}
	public void setCouponNumber(Float couponNumber) {
		this.couponNumber = couponNumber;
	}
	public Integer getCouponState() {
		return couponState;
	}
	public void setCouponState(Integer couponState) {
		this.couponState = couponState;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Float getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Float maxPrice) {
		this.maxPrice = maxPrice;
	}
	public Float getMinOrderPrice() {
		return minOrderPrice;
	}
	public void setMinOrderPrice(Float minOrderPrice) {
		this.minOrderPrice = minOrderPrice;
	}
	public String getBackimage() {
		return backimage;
	}
	public void setBackimage(String backimage) {
		this.backimage = backimage;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getShareNum() {
		return shareNum;
	}
	public void setShareNum(Integer shareNum) {
		this.shareNum = shareNum;
	}
	public Integer getSuperpositionNum() {
		return superpositionNum;
	}
	public void setSuperpositionNum(Integer superpositionNum) {
		this.superpositionNum = superpositionNum;
	}
	public Integer getIsCouponRed() {
		return isCouponRed;
	}
	public void setIsCouponRed(Integer isCouponRed) {
		this.isCouponRed = isCouponRed;
	}
}
