/**
 * 
 */
package com.westangel.commonservice.trade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.trade.TAccountInfo;
import com.westangel.commonservice.trade.model.account.TAccountPublishInfo;
import com.westangel.commonservice.trade.model.account.TDebitCreditRecordItemInfo;
import com.westangel.commonservice.trade.model.account.TIncomeExpensesItemInfo;
import com.westangel.commonservice.trade.model.account.TTradeRecordItemInfo;

/**
 * 账户Dao
 * @author bigdragon
 * @date  2015-12-26 下午2:11:48
 */
public interface AccountDao {

	/**
	 * 获得基本账户信息
	 * @param userId
	 * @return
	 */
	public TAccountInfo getBasicAccountInfo(Long userId);

	/**
	 * 获得订单总数
	 * @param userId
	 * @return
	 */
	public int getVendorTotalOrderNum(Long userId);

	/**
	 * 获得买方的订单数
	 * @param userId
	 * @return
	 */
	public int getBuyerTotalOrderNum(Long userId);

	/**
	 * 获得总支出
	 * @param userId
	 * @return
	 */
	public float getBuyerTotalExpenses(Long userId);

	/**
	 * 获得总收入
	 * @param userId
	 * @return
	 */
	public float getVendorTotalIncome(Long userId);

	/**
	 * 获取收支明细
	 * @param userId
	 * @param accountClass
	 * @return
	 */
	public List<TIncomeExpensesItemInfo> listIncomeExpensesDetail(@Param("userId") Long userId,
			@Param("accountClass") int accountClass);

	/**
	 * 创建交易记录。内部接口，不被外部调用。
	 * @param tradeRecordItemInfo
	 * @return
	 */
	public int createTradeRecord(TTradeRecordItemInfo tradeRecordItemInfo);

	/**
	 * 创建记账单记录。内部接口。不被外部调用。
	 * @param debitCreditRecordItemInfo
	 * @return
	 */
	public int createDebitCreditRecord(
			TDebitCreditRecordItemInfo debitCreditRecordItemInfo);


	/**
	 * 根据userId和accountClass，获得accountId
	 * @param userId
	 * @param accountClass
	 * @return
	 */
	public Long getAccountId(@Param("userId") Long userId, @Param("accountClass") int accountClass);

	
	/**
	 * 判断账户是否存在
	 * @param userId
	 * @param accountClass
	 * @return
	 */
	public int isExistAccount(@Param("userId") Long userId, @Param("accountClass") int accountClass);

	
	/**
	 * 创建账户（买方）
	 * @param accountInfo
	 */
	public void createAccount(TAccountPublishInfo accountInfo);

	/**
	 * 更新用户账户余额
	 * @param accountId
	 * @param debit:本次收益
	 */
	public void updateAccountBalance(@Param("accountId") Long accountId,@Param("debit") float debit);

	/**
	 * @param orderId
	 * @param 更新交易状态-退款
	 */
	public void tradeRecordRefund(@Param("orderId") String orderId,@Param("remark") String remark);

	/**
	 * 活动交易记录信息
	 * @param orderId
	 * @return
	 */
	public TTradeRecordItemInfo getTradeRecordItemInfo(String orderId);
	
	public void updateAccountForDraw(@Param("userId") Long userId,@Param("money") String money);
	
	
	public void addWithDrawRecord(@Param("userId") Long userId,@Param("money") String money);
	
}
