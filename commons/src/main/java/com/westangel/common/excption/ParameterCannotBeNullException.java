package com.westangel.common.excption;

/**
 * <p>Title:ParameterCannotBeNullException</p>
 * <p>Description:参数不能为空，拒绝处理异常</p>
 * @author YYCHEN
 * @date 2016年5月27日 下午4:05:55
 */
public class ParameterCannotBeNullException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ParameterCannotBeNullException(){
		
	}
	public ParameterCannotBeNullException(String message){
		super(message);
	}
}
