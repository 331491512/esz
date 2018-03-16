package com.westangel.common.excption;

/**
 * 参数不足异常
 * @author YYCHEN
 *
 */
public class InsufficientParameterExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InsufficientParameterExcption(){
		
	}
	public InsufficientParameterExcption(String message){
		super(message);
	}
}
