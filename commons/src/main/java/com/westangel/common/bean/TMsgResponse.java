package com.westangel.common.bean;

import java.io.Serializable;

/**
 * TMsgResponse类
 * 消息返回公共类。所有消息返回结果均使用此类。
 * 必须包括respCode和respMsg。
 * 对于具体返回的结果，通过模板类型T来指定具体的result对象。
 * @author bigdragon 
 * Created at 2015/12/2
 *
 * @param <T>
 * 
 */
public class TMsgResponse<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public int respCode;
	public String respMsg;
	public String errorDesc;//错误详细描述
	
	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	public T result;

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
