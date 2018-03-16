/**
 * 
 */
package com.westangel.commonservice.trade.model.account;

import java.util.ArrayList;
import java.util.List;

import com.westangel.common.util.GeneralUtil;

/**
 * 交易记录信息
 * @author bigdragon
 * @date  2015-12-29 下午7:14:20
 */
public class TTradeRecordItemInfo {
	
	private String tradeId;
	
	private String orderId; //订单ID。
	
	private Long   buyer;//买家
	
	private Long   vendor; //卖家
	
	private float  payment;//	买家实际付款额。付款额=实际交易额-积分冲抵额
	
	private float  volume; //交易额。指本次交易收款额。卖家收益据此计算。
	
	private int    state ;//交易状态,	1：正常（成功付款）,2：退款

	private String remark; //备注。
	
	private String debitRecId; //收益方记录单号。打款后填写。用于给服务系统返回。

	/**
	 * @return the tradeId
	 */
	public String getTradeId() {
		return tradeId;
	}

	/**
	 * @param tradeId the tradeId to set
	 */
	public void setTradeId(String tradeId) {
		this.tradeId = tradeId;
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
	 * @return the payment
	 */
	public float getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(float payment) {
		this.payment = payment;
	}

	/**
	 * @return the volume
	 */
	public float getVolume() {
		return volume;
	}

	/**
	 * @param volume the volume to set
	 */
	public void setVolume(float volume) {
		this.volume = volume;
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
	 * @param accountId
	 * @return
	 */
	public TDebitCreditRecordItemInfo getDebitRecordItemInfo(Long accountId) {
		// TODO Auto-generated method stub
		TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
		//获得accountId. 支出方传入accountClass=2. 如果没有获得，将会抛出异常
		item.setAccountId(accountId);
		item.setAccountingTitleCode("1.1");//!!这里要修订
		item.setCredit(0);
		item.setDebit(getVolume());
		item.setRefId(getTradeId());
		item.setRefTable("account_trade_record");
		item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
		//item.setRecRelatedId(GeneralUtil.generateUniqueID("RELA"));
		//使用上次的
		item.setRemark(getRemark());
		item.setRecRelatedId(getOrderId());
		
		return item;
	}
	
	public List<TDebitCreditRecordItemInfo> getDebitRecordItemInfos(Long accountId,int payFlag) {
		// TODO Auto-generated method stub
		List<TDebitCreditRecordItemInfo> list = new ArrayList<TDebitCreditRecordItemInfo>();
		if(payFlag==2||payFlag==0){
			TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
			//获得accountId. 支出方传入accountClass=2. 如果没有获得，将会抛出异常
			item.setAccountId(accountId);
			item.setAccountingTitleCode("1.1");
			item.setCredit(0);
			if(payFlag==0)
				item.setDebit(getVolume());
			if(payFlag==2)
				item.setDebit(getPayment());
			item.setRefId(getTradeId());
			item.setRefTable("account_trade_record");
			item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
			item.setRemark(getRemark());
			item.setRecRelatedId(getOrderId());
			list.add(item);
		}
		if(payFlag==2||payFlag==1){
			TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
			//获得accountId. 支出方传入accountClass=2. 如果没有获得，将会抛出异常
			item.setAccountId(accountId);
			item.setAccountingTitleCode("1.1");
			item.setCredit(0);
			if(payFlag==1)
				item.setDebit(getVolume());
			if(payFlag==2)
				item.setDebit(getVolume()-getPayment());
			item.setRefId(getTradeId());
			item.setRefTable("account_trade_record");
			item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
			//item.setRecRelatedId(GeneralUtil.generateUniqueID("RELA"));
			//使用上次的
			item.setRemark(getRemark());
			item.setRecRelatedId(getOrderId());
			list.add(item);
		}
		return list;
	}
	/**
	 * @param accountId
	 * @return
	 */
	public TDebitCreditRecordItemInfo getCreditRecordItemInfo(Long accountId) {
		// TODO Auto-generated method stub
		TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
		item.setAccountId(accountId);
		item.setAccountingTitleCode("2.1");//!!这里要修订
		item.setDebit(0);
		item.setCredit(getVolume());
		item.setRefId(getTradeId());
		item.setRefTable("account_trade_record");
		item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
		item.setRemark(getRemark());
		item.setRecRelatedId(getOrderId());
		return item;
	}
	
	public List<TDebitCreditRecordItemInfo> getCreditRecordItemInfos(Long accountId,int payFlag,Long sysAccountId) {
		// TODO Auto-generated method stub
		List<TDebitCreditRecordItemInfo> list = new ArrayList<TDebitCreditRecordItemInfo>();
		if(payFlag==2||payFlag==0){
			TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
			item.setAccountId(accountId);
			item.setAccountingTitleCode("2.1");
			item.setDebit(0);
			if(payFlag==0)
				item.setCredit(getVolume());
			if(payFlag==2)
				item.setCredit(getPayment());
			item.setRefId(getTradeId());
			item.setRefTable("account_trade_record");
			item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
			item.setRemark(getRemark());
			item.setRecRelatedId(getOrderId());
			list.add(item);
		}
		if(payFlag==2||payFlag==1){
			TDebitCreditRecordItemInfo item = new TDebitCreditRecordItemInfo();
			item.setAccountId(sysAccountId);
			item.setAccountingTitleCode("6.0");
			item.setDebit(0);
			if(payFlag==1)
				item.setCredit(getVolume());
			if(payFlag==2)
				item.setCredit(getVolume()-getPayment());
			item.setRefId(getTradeId());
			item.setRefTable("account_trade_record");
			item.setRecId(GeneralUtil.generateUniqueID("DEBI"));
			item.setRemark(getRemark());
			item.setRecRelatedId(getOrderId());
			list.add(item);
		}
		return list;
	}

	/**
	 * @return the debitRecId
	 */
	public String getDebitRecId() {
		return debitRecId;
	}

	/**
	 * @param debitRecId the debitRecId to set
	 */
	public void setDebitRecId(String debitRecId) {
		this.debitRecId = debitRecId;
	}
	

	
}
