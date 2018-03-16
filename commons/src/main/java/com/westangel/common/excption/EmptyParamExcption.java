package com.westangel.common.excption;

/**
 * 参数为空异常
 * @author YYCHEN
 *
 */
public class EmptyParamExcption extends NullPointerException {
	private static final long serialVersionUID = 1L;
	
	public EmptyParamExcption(){
		
	}
	public EmptyParamExcption(String message){
		super(message);
	}
}
