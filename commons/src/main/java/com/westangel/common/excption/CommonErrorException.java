package com.westangel.common.excption;

public class CommonErrorException extends RuntimeException {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -1753740513837520529L;
	//错误码
	private Integer errorCode;
	//错误描述
	private String errorDescription="";
	
	public CommonErrorException(String message) {
		super(message);
	}
	/** 
	* @return errorCode 
	*/
	public Integer getErrorCode() {
		return errorCode;
	}

	/** 
	* @param errorCode 要设置的 errorCode 
	*/
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	/** 
	* @return errorDescription 
	*/
	public String getErrorDescription() {
		return errorDescription;
	}
	/** 
	* @param errorDescription 要设置的 errorDescription 
	*/
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	
}
