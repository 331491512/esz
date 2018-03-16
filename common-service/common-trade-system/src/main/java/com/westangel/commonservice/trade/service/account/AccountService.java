/**
 * 
 */
package com.westangel.commonservice.trade.service.account;

import java.util.List;

import com.westangel.common.bean.Page;
import com.westangel.common.bean.trade.TAccountInfo;
import com.westangel.commonservice.trade.model.account.TIncomeExpensesItemInfo;
import com.westangel.commonservice.trade.model.account.TTradeRecordItemInfo;

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
	 * 获得收支明细
	 * @param userId
	 * @param role 
	 * @param page
	 * @param num
	 * @return
	 */
	Page<TIncomeExpensesItemInfo> listIncomeExpensesDetail(Long userId,Integer role,
			Integer page, Integer num);


	/**
	 * 退款处理
	 * @param orderId
	 */
	void refund(String orderId);
	
	/**
	 * 生成记账单记录。交易系统内部调用。
	 * @param info
	 * @return 0：success; >0: respCode. 失败
	 */
	int createDebitCreditRecord(TTradeRecordItemInfo tradeRecordItemInfo,int payFlag);
	
	/**
	 * 创建一个账户. 内部调用
	 * @param userId
	 * @param role
	 * @param accountClass
	 * @return true: success; false:failed
	 */
	boolean createAccount(Long userId, int role, int accountClass);

	
	void dealWithDrawMoney(Long userId, String money);
}
