package com.westangel.common.excption;

/**
 * 对象未匹配异常
 * @author YYCHEN
 *
 */
public class ObjectNotAvailableExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotAvailableExcption(){
		
	}
	public ObjectNotAvailableExcption(String message){
		super(message);
	}
}
