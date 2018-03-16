/**
 * 
 */
package com.westangel.common.bean.trade;

import java.io.Serializable;
import java.util.Date;

/**
 * @author bigdragon
 * @date  2015-12-22 下午2:31:08
 */
public class TOrderPayInfo implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private String payId ;//支付ID。内部生成。
	
	private Long   buyer;//买家userId
	
	private Long   vendor; //卖家userId
	
	private String orderId;//订单ID
	
	private int points	;  //积分冲抵
	
	private float pointsPayValue ;//积分冲抵额，单位：元
	
	private float balancePayValue ;//余额支付额，单位：元
	
	private int coupons;//冲抵张数
	
	private float couponsPayValue; //优惠券冲抵金额。单位：分
	
	private int   onlinePayWay ;//在线支付方式  0：未使用 ; 1：支付宝；2: 微信；3：银行卡
	
	private float onlinePayValue;//	在线支付额，单位：元
	
	private String onlinePayAccount;//	在线支付帐号
	
	private String onlinePayNo	;//在线支付流水号(第三方给出，用户对账用）
		
	private Date payCompleteTime; //支付完成时间，优先以第三方给出为准。YYYY-MM-DD HH:MM:SS
	
	private int   state; //支付状态. 0: 未支付/待支付;1: 已支付;2：支付中;3：支付失败
	
	private String remark; //备注。
	
	private String refundNo; //退款单号
	
	private int    profitFlag;//打款标识。0：未打款；1：已打款
	
	private int agentPayFlag; //代支付标识 0:本人 1：代支付
	
	private String agentAccountId; //代支付用户Id 微信号或支付宝号
	
	private String agentOrderId; //代支付订单号
	
	public TOrderPayInfo(){
		buyer = 0L;
		vendor = 0L;
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
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * @param points the points to set
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * @return the pointsPayValue
	 */
	public float getPointsPayValue() {
		return pointsPayValue;
	}

	/**
	 * @param pointsPayValue the pointsPayValue to set
	 */
	public void setPointsPayValue(float pointsPayValue) {
		this.pointsPayValue = pointsPayValue;
	}

	/**
	 * @return the balancePayValue
	 */
	public float getBalancePayValue() {
		return balancePayValue;
	}

	/**
	 * @param balancePayValue the balancePayValue to set
	 */
	public void setBalancePayValue(float balancePayValue) {
		this.balancePayValue = balancePayValue;
	}

	/**
	 * @return the onlinePayWay
	 */
	public int getOnlinePayWay() {
		return onlinePayWay;
	}

	/**
	 * @param onlinePayWay the onlinePayWay to set
	 */
	public void setOnlinePayWay(int onlinePayWay) {
		this.onlinePayWay = onlinePayWay;
	}

	/**
	 * @return the onlinePayValue
	 */
	public float getOnlinePayValue() {
		return onlinePayValue;
	}

	/**
	 * @param onlinePayValue the onlinePayValue to set
	 */
	public void setOnlinePayValue(float onlinePayValue) {
		this.onlinePayValue = onlinePayValue;
	}

	/**
	 * @return the onlinePayAccount
	 */
	public String getOnlinePayAccount() {
		return onlinePayAccount;
	}

	/**
	 * @param onlinePayAccount the onlinePayAccount to set
	 */
	public void setOnlinePayAccount(String onlinePayAccount) {
		this.onlinePayAccount = onlinePayAccount;
	}

	/**
	 * @return the onlinePayNo
	 */
	public String getOnlinePayNo() {
		return onlinePayNo;
	}

	/**
	 * @param onlinePayNo the onlinePayNo to set
	 */
	public void setOnlinePayNo(String onlinePayNo) {
		this.onlinePayNo = onlinePayNo;
	}

	/**
	 * @return the payCompleteTime
	 */
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}

	/**
	 * @param payCompleteTime the payCompleteTime to set
	 */
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
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
	 * @return the payId
	 */
	public String getPayId() {
		return payId;
	}

	/**
	 * @param payId the payId to set
	 */
	public void setPayId(String payId) {
		this.payId = payId;
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
	 * @return the refundNo
	 */
	public String getRefundNo() {
		return refundNo;
	}
	/**
	 * @param refundNo the refundNo to set
	 */
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	/**
	 * @return the profitFlag
	 */
	public int getProfitFlag() {
		return profitFlag;
	}
	/**
	 * @param profitFlag the profitFlag to set
	 */
	public void setProfitFlag(int profitFlag) {
		this.profitFlag = profitFlag;
	}
	public int getCoupons() {
		return coupons;
	}
	public void setCoupons(int coupons) {
		this.coupons = coupons;
	}
	public float getCouponsPayValue() {
		return couponsPayValue;
	}
	public void setCouponsPayValue(float couponsPayValue) {
		this.couponsPayValue = couponsPayValue;
	}
	public int getAgentPayFlag() {
		return agentPayFlag;
	}
	public void setAgentPayFlag(int agentPayFlag) {
		this.agentPayFlag = agentPayFlag;
	}
	public String getAgentAccountId() {
		return agentAccountId;
	}
	public void setAgentAccountId(String agentAccountId) {
		this.agentAccountId = agentAccountId;
	}
	public String getAgentOrderId() {
		return agentOrderId;
	}
	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}
}
