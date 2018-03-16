package com.westangel.common.excption;

/**
 * 拒绝请求异常
 * @author YYCHEN
 *
 */
public class RejectRequestExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public RejectRequestExcption(){
		
	}
	public RejectRequestExcption(String message){
		super(message);
	}
}
