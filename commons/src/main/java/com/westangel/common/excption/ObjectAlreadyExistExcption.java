package com.westangel.common.excption;

/**
 * 对象已存在异常
 * @author YYCHEN
 *
 */
public class ObjectAlreadyExistExcption extends NullPointerException {
	private static final long serialVersionUID = 1L;
	
	public ObjectAlreadyExistExcption(){
		
	}
	public ObjectAlreadyExistExcption(String message){
		super(message);
	}
}
