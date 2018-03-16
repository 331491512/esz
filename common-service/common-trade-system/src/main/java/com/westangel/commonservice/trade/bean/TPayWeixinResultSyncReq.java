/**
 * 
 */
package com.westangel.commonservice.trade.bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.westangel.common.constant.Constant;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.LogUtil;

/**
 * 微信支付结果通知
 * 为XML结构
 * @author bigdragon
 * @date  2016-1-11 下午11:33:56
 */
@XmlRootElement(name="xml") 
public class TPayWeixinResultSyncReq {

	private String return_code;//SUCCESS/FAIL
	
	private String return_msg; //结果描述
	
	private String err_code; //错误描述码，如SYSTEMERROR
	
	private String err_code_desc;//错误描述

	private String app_id;//对应微信公众号
	
	private String mch_id; //商户号
	
	private String open_id; //对应一个微信用户
	
	private int    total_fee; //总费用。单位分。
	
	private String transaction_id; //微信支付订单号
	
	private String out_trade_no;   //交易号，对应orderId
	
	private String time_end;       //支付完成时间。YYYYMMDDHHmmss

	/**
	 * @return the return_code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * @param return_code the return_code to set
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * @return the return_msg
	 */
	public String getReturn_msg() {
		return return_msg;
	}

	/**
	 * @param return_msg the return_msg to set
	 */
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	/**
	 * @return the err_code
	 */
	public String getErr_code() {
		return err_code;
	}

	/**
	 * @param err_code the err_code to set
	 */
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	/**
	 * @return the err_code_desc
	 */
	public String getErr_code_desc() {
		return err_code_desc;
	}

	/**
	 * @param err_code_desc the err_code_desc to set
	 */
	public void setErr_code_desc(String err_code_desc) {
		this.err_code_desc = err_code_desc;
	}

	/**
	 * @return the app_id
	 */
	public String getApp_id() {
		return app_id;
	}

	/**
	 * @param app_id the app_id to set
	 */
	public void setApp_id(String app_id) {
		this.app_id = app_id;
	}

	/**
	 * @return the mch_id
	 */
	public String getMch_id() {
		return mch_id;
	}

	/**
	 * @param mch_id the mch_id to set
	 */
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	/**
	 * @return the open_id
	 */
	public String getOpen_id() {
		return open_id;
	}

	/**
	 * @param open_id the open_id to set
	 */
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	/**
	 * @return the total_fee
	 */
	public int getTotal_fee() {
		return total_fee;
	}

	/**
	 * @param total_fee the total_fee to set
	 */
	public void setTotal_fee(int total_fee) {
		this.total_fee = total_fee;
	}

	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the out_trade_no
	 */
	public String getOut_trade_no() {
		return out_trade_no;
	}

	/**
	 * @param out_trade_no the out_trade_no to set
	 */
	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	/**
	 * @return the time_end
	 */
	public String getTime_end() {
		return time_end;
	}

	/**
	 * @param time_end the time_end to set
	 */
	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	/**
	 * @return
	 */
	public TPayResultSyncInfo createResultSyncInfo() {
		// TODO Auto-generated method stub
		TPayResultSyncInfo info = new TPayResultSyncInfo();
		info.setOrderId(out_trade_no);
		if(return_code.equals("SUCCESS")){
			info.setState( Constant.Pay.PAY_STATE_SUCCESS); //支付成功
			info.setRemark("支付成功");
		}
		else{
			info.setState(Constant.Pay.PAY_STATE_FAIL); //支付失败
			info.setRemark("支付失败. "+err_code_desc);
		}
		
		float f_total_fee = (float)total_fee;//用浮点型
		float fee = f_total_fee/100;
		info.setOnlinePayValue(fee);//分转成元
		LogUtil.log.info("createResultSyncInfo(): fee="+fee);
		info.setOnlinePayWay(Constant.Pay.PAY_WAY_WEIXIN);
		info.setOnlinePayAccount(open_id);
		info.setOnlinePayNo(transaction_id);
		info.setPayCompleteTime(DateUtil.stringToDate(time_end, "yyyyMMddHHmmss"));

		return info;
	}
	
	
}
