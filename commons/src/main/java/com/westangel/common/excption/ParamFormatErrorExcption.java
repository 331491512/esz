package com.westangel.common.excption;

/**
 * 对象参数格式错误异常
 * @author YYCHEN
 *
 */
public class ParamFormatErrorExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ParamFormatErrorExcption(){
		
	}
	public ParamFormatErrorExcption(String message){
		super(message);
	}
}
