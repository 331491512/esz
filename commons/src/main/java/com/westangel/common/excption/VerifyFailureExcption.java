/**
 * 
 */
package com.westangel.common.excption;


/**
 * @author Da Loong
 *
 */
public class VerifyFailureExcption extends Exception {

	public VerifyFailureExcption(){
		//errorcode=1403
	}
	public VerifyFailureExcption(String message){
		super(message);
	}
}
