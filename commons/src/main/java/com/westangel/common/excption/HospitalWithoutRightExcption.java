package com.westangel.common.excption;

/**
 *  医院权限不足 异常
 * @author fanpanwei
 *
 */
public class HospitalWithoutRightExcption extends Exception {
	private static final long serialVersionUID = 1L;
	
	public HospitalWithoutRightExcption(){
		
	}
	public HospitalWithoutRightExcption(String message){
		super(message);
	}
}
