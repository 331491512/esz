package com.westangel.common.excption;

/**
 * 调用方法异常
 * @author YYCHEN
 *
 */
public class RemoteCallExcption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RemoteCallExcption(){
		
	}
	public RemoteCallExcption(String message){
		super(message);
	}
}
