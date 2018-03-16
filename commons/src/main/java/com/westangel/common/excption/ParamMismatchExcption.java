package com.westangel.common.excption;

/**
 * 参数不匹配异常
 * @author YYCHEN
 *
 */
public class ParamMismatchExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ParamMismatchExcption(){
		
	}
	public ParamMismatchExcption(String message){
		super(message);
	}
}
