/**
 * 
 */
package com.westangel.common.excption;

/**
 * @author DaLoong
 * @date  2016/1/26
 *
 */
public class TimeTooShortException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public TimeTooShortException(){
		//errorcode=1506
	}
	public TimeTooShortException(String message){
		super(message);
	}
}
