package com.westangel.common.excption;

/**
 * <p>Title:BindingDataExcption</p>
 * <p>Description:绑定数据异常</p>
 * @author YYCHEN
 * @date 2016年5月11日 下午5:48:23
 */
public class BindingDataExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public BindingDataExcption(){
		
	}
	public BindingDataExcption(String message){
		super(message);
	}
}
