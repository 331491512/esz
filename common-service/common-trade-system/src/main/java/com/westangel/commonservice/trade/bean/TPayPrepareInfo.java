/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import java.io.Serializable;

/**
 * @author bigdragon
 * @date  2015-12-22 下午2:31:08
 */
public class TPayPrepareInfo implements Serializable {
	private static final long serialVersionUID = 1L;
		
	private float pointsPayValue ;//积分冲抵额，单位：元
	
	private float balancePayValue ;//余额支付额，单位：元
	
	private int   onlinePayWay ;//在线支付方式  0：未使用 ; 1：支付宝；2: 微信；3：银行卡
	
	private float onlinePayValue;//	在线支付额，单位：元
	
	private String onlinePayMethod;// 支付方法。JSAPI: 微信JS调用
	
	private String agentAccountId;//支付方
	
	private String onlinePayAccountInfo; //支付方信息
	
	
	public TPayPrepareInfo(){
		onlinePayWay = 2; //微信支付
		setOnlinePayMethod("JSAPI"); //微信JSAPI
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
	 * @return the onlinePayMethod
	 */
	public String getOnlinePayMethod() {
		return onlinePayMethod;
	}


	/**
	 * @param onlinePayMethod the onlinePayMethod to set
	 */
	public void setOnlinePayMethod(String onlinePayMethod) {
		this.onlinePayMethod = onlinePayMethod;
	}


	public String getAgentAccountId() {
		return agentAccountId;
	}


	public void setAgentAccountId(String agentAccountId) {
		this.agentAccountId = agentAccountId;
	}


	public String getOnlinePayAccountInfo() {
		return onlinePayAccountInfo;
	}


	public void setOnlinePayAccountInfo(String onlinePayAccountInfo) {
		this.onlinePayAccountInfo = onlinePayAccountInfo;
	}
}
