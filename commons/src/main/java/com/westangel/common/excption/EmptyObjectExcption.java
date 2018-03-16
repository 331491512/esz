package com.westangel.common.excption;

/**
 * 对象为空异常
 * @author YYCHEN
 *
 */
public class EmptyObjectExcption extends NullPointerException {
	private static final long serialVersionUID = 1L;
	
	public EmptyObjectExcption(){
		
	}
	public EmptyObjectExcption(String message){
		super(message);
	}
}
