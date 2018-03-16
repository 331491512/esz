package com.esuizhen.cloudservice.ehr.model.meta;


public class TMetaInfoPayChannel
{
	
	/**
	 * 支付渠道ID
	 */
	private Integer payChannelId;
	/**
	 * 支付渠道代码
	 */
	private String payChannelCode;
	/**
	 * 支付渠道名称
	 */
	private String payChannelName;

	public void setPayChannelId(Integer payChannelId) {
		this.payChannelId = payChannelId;
	}
	
	public Integer getPayChannelId() {
		return this.payChannelId;
	}
	public void setPayChannelCode(String payChannelCode) {
		this.payChannelCode = payChannelCode;
	}
	
	public String getPayChannelCode() {
		return this.payChannelCode;
	}
	public void setPayChannelName(String payChannelName) {
		this.payChannelName = payChannelName;
	}
	
	public String getPayChannelName() {
		return this.payChannelName;
	}


}

