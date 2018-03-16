package com.westangel.common.bean;

import java.io.Serializable;

/**
 * 
* @ClassName: TBMsgResponse 
* @Description: 消息相应类 
* @author LIPENG
* @date 2015年12月11日 下午4:41:06 
*
 */
public class TBMsgResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private int respCode;
	private String respMsg;
	private String errorDesc;//错误详细描述
	/** 
	* @return respCode 
	*/
	public int getRespCode() {
		return respCode;
	}
	/** 
	* @param respCode 要设置的 respCode 
	*/
	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}
	/** 
	* @return respMsg 
	*/
	public String getRespMsg() {
		return respMsg;
	}
	/** 
	* @param respMsg 要设置的 respMsg 
	*/
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	/** 
	* @return errorDesc 
	*/
	public String getErrorDesc() {
		return errorDesc;
	}
	/** 
	* @param errorDesc 要设置的 errorDesc 
	*/
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
}
