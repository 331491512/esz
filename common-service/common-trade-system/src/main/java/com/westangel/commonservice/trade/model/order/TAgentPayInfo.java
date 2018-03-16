/**
 * 
 */
package com.westangel.commonservice.trade.model.order;

import java.util.Date;

/**
 * @author chenghao
 * @date  2016年11月2日 上午9:52:46
 */
public class TAgentPayInfo {
	
	private String agentOrderId; //代支付单号
	private String agentPayAccountNo; //代支付方信息
	private String agentPayAccountInfo; //代支付方信息
	private Date payCompleteTime; //代支付时间
	private Integer onlinePayWay; //支付方式
	private Integer state; //支付状态
	private String remark; //备注
	
	public String getAgentOrderId() {
		return agentOrderId;
	}
	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}
	
	public String getAgentPayAccountNo() {
		return agentPayAccountNo;
	}
	public void setAgentPayAccountNo(String agentPayAccountNo) {
		this.agentPayAccountNo = agentPayAccountNo;
	}
	public String getAgentPayAccountInfo() {
		return agentPayAccountInfo;
	}
	public void setAgentPayAccountInfo(String agentPayAccountInfo) {
		this.agentPayAccountInfo = agentPayAccountInfo;
	}
	public Date getPayCompleteTime() {
		return payCompleteTime;
	}
	public void setPayCompleteTime(Date payCompleteTime) {
		this.payCompleteTime = payCompleteTime;
	}
	public Integer getOnlinePayWay() {
		return onlinePayWay;
	}
	public void setOnlinePayWay(Integer onlinePayWay) {
		this.onlinePayWay = onlinePayWay;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
