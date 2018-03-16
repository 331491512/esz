/**
 * 
 */
package com.westangel.common.service;


import com.westangel.common.bean.TMsgResponse;

/**
 * 交易系统-支付服务接口
 * 目前给服务系统调用，用于退款操作。
 * @author bigdragon
 * 
 */
public interface PayService {

	
	/**
	 * 退款
	 * return: respCode. 0: success.  
	 *                   !=0: 失败
	 */
	public int refund(int state,String orderId) throws Exception ;

}
