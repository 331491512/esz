package com.westangel.common.excption;

/**
 * <p>Title:DisableDataExcption</p>
 * <p>Description:禁止使用异常</p>
 * @author YYCHEN
 * @date 2016年7月7日 上午11:29:43
 */
public class DisableExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DisableExcption(){
		
	}
	public DisableExcption(String message){
		super(message);
	}
}
