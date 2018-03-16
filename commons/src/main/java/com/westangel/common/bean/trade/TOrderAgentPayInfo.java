/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.trade;<br/>  
 * <b>文件名：</b>TOrderAgentPayInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月26日下午2:47:21<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.trade;

import java.util.Date;

/** 
* @ClassName: TOrderAgentPayInfo
* @Description: 
* @author lichenghao
* @date 2016年10月26日 下午2:47:21  
*/
public class TOrderAgentPayInfo {
	private String agentPayId; //支付流水
	private String orderId;   //原始订单
	private String agentOrderId; //代支付订单
	private int   onlinePayWay ; //在线支付方式  0：未使用 ; 1：支付宝；2: 微信；3：银行卡
	private float onlinePayValue; // 在线支付额，单位：元
	private String onlinePayAccount;//	在线支付帐号
	private String onlinePayNo; //在线支付流水号(第三方给出，用户对账用)
	private String refundNo; //退款单号
	private Date payCompleteTime; //支付完成时间
	private int state; //支付状态. 0: 未支付/待支付;1: 已支付;2：支付中;3：支付失败
	private String remark; //备注信息
	private String onlinePayAccountInfo; //支付者信息
	public String getAgentPayId() {
		return agentPayId;
	}
	public void setAgentPayId(String agentPayId) {
		this.agentPayId = agentPayId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAgentOrderId() {
		return agentOrderId;
	}
	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}
	public int getOnlinePayWay() {
		return onlinePayWay;
	}
	public void setOnlinePayWay(int onlinePayWay) {
		this.onlinePayWay = onlinePayWay;
	}
	public float getOnlinePayValue() {
		return onlinePayValue;
	}
	public void setOnlinePayValue(float onlinePayValue) {
		this.onlinePayValue = onlinePayValue;
	}
	public String getOnlinePayAccount() {
		return onlinePayAccount;
	}
	public void setOnlinePayAccount(String onlinePayAccount) {
		this.onlinePayAccount = onlinePayAccount;
	}
	public String getOnlinePayNo() {
		return onlinePayNo;
	}
	public void setOnlinePayNo(String onlinePayNo) {
		this.onlinePayNo = onlinePayNo;
	}
	public String getRefundNo() {
		return refundNo;
	}
	public void setRefundNo(String refundNo) {
		this.refundNo = refundNo;
	}
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getOnlinePayAccountInfo() {
		return onlinePayAccountInfo;
	}
	public void setOnlinePayAccountInfo(String onlinePayAccountInfo) {
		this.onlinePayAccountInfo = onlinePayAccountInfo;
	}
}
