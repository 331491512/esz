/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.westangel.common.bean.trade.TOrderAgentPayInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.LogUtil;

/**
 * 支付结果通知
 * @author bigdragon
 * @date  2016-1-11 下午11:33:56
 */
public class TPayResultSyncInfo {

	private int    state;//1；已支付； 3：失败
	
	private String remark; //结果描述
	
	private int    onlinePayWay; //1:支付宝； 2：微信（默认）
	
	private float  onlinePayValue; //支付金额。单位：元
	
	private String  onlinePayAccount; //对应openId
	
	private String onlinePayNo; //第三方支付订单号
	
	private String orderId;    //交易系统订单号
	
	private Date   payCompleteTime; //支付完成时间。
	
	private String agentOrderId; // 代支付订单

	
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
	
	public String getAgentOrderId() {
		return agentOrderId;
	}

	public void setAgentOrderId(String agentOrderId) {
		this.agentOrderId = agentOrderId;
	}

	/**
	 * @return
	 */
	public TOrderPayInfo createOrderPayInfo() {
		// TODO Auto-generated method stub
		TOrderPayInfo info = new TOrderPayInfo();
		info.setBalancePayValue(0);
		info.setOnlinePayAccount(onlinePayAccount);
		info.setOnlinePayNo(onlinePayNo);
		info.setOnlinePayValue(onlinePayValue);
		info.setOnlinePayWay(onlinePayWay);
		info.setOrderId(orderId);
		info.setPoints(0);
		info.setPointsPayValue(0);
		info.setPayCompleteTime(payCompleteTime);
		info.setState(state);
		if(state==Constant.Pay.PAY_STATE_SUCCESS){
			info.setPayCompleteTime(payCompleteTime);
			info.setRemark("支付成功");
		}
		//如果代支付订单不为空
		if(StringUtils.isNotEmpty(agentOrderId)){
			info.setAgentOrderId(agentOrderId);
			info.setAgentAccountId(onlinePayAccount);
			info.setAgentPayFlag(1);
		}
		LogUtil.log.info("createOrderPayInfo(): state="+info.getState());
		return info;
	}
	
	// 代支付信息
	public TOrderAgentPayInfo createOrderAgentPayInfo(){
		TOrderAgentPayInfo info = new TOrderAgentPayInfo();
		info.setOnlinePayAccount(onlinePayAccount);
		info.setOnlinePayNo(onlinePayNo);
		info.setOnlinePayValue(onlinePayValue);
		info.setOnlinePayWay(onlinePayWay);
		info.setAgentOrderId(orderId);
		info.setState(state);
		if(state==Constant.Pay.PAY_STATE_SUCCESS){
			info.setPayCompleteTime(payCompleteTime);
			info.setRemark("支付成功");
		}
		LogUtil.log.info("createOrderAgentPayInfo(): state="+info.getState());
		return info;
	}
	
	
	
}
