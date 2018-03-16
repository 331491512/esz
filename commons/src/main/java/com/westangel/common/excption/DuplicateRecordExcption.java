package com.westangel.common.excption;

/**
 *  数据重复 异常
 * @author fanpanwei
 *
 */
public class DuplicateRecordExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public DuplicateRecordExcption(){
		
	}
	public DuplicateRecordExcption(String message){
		super(message);
	}
}
