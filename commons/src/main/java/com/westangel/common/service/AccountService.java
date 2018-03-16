/**
 * 
 */
package com.westangel.common.service;

import java.util.List;

import com.westangel.common.bean.Page;
import com.westangel.common.bean.trade.TAccountInfo;

/**
 * 交易系统-账户接口
 * @author bigdragon
 * @date  2015-12-23 上午12:38:12
 */
public interface AccountService {

	/**
	 * 获得账户信息
	 * @param userId
	 * @param role
	 * @return
	 */
	TAccountInfo getAccountInfo(Long userId,Integer role);
	

	/**
	 * 给供应商正式打款（服务完成后）
	 * @return debitRecId: 收益单号
	 */
	String makeProfit(int state,String orderId);
	
	
}
