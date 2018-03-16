/**
 * 
 */
package com.westangel.commonservice.trade.service.impl.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.trade.TAccountInfo;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.commonservice.trade.dao.AccountDao;
import com.westangel.commonservice.trade.dao.PayDao;
import com.westangel.commonservice.trade.dao.ProductDao;
import com.westangel.commonservice.trade.model.account.TAccountPublishInfo;
import com.westangel.commonservice.trade.model.account.TDebitCreditRecordItemInfo;
import com.westangel.commonservice.trade.model.account.TIncomeExpensesItemInfo;
import com.westangel.commonservice.trade.model.account.TTradeRecordItemInfo;
import com.westangel.commonservice.trade.model.order.TOrderSimpleInfo;
import com.westangel.commonservice.trade.service.account.AccountService;
import com.westangel.commonservice.trade.util.AccountUtil;

/**
 * 账户服务。主要和账目、收益、费用相关。
 * @author bigdraon
 * @date  2015-12-23 上午12:58:13
 */
@Service
public class AccountServiceImpl implements AccountService,com.westangel.common.service.AccountService {
	@Autowired
	private AccountDao   accountDao;
	
	@Autowired
	private PayDao       payDao;

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.AccountService#getAccountInfo(java.lang.Long, java.lang.Integer)
	 */
	@Override
	public TAccountInfo getAccountInfo(Long userId, Integer role) {
		// TODO Auto-generated method stub
		
		//1.获得积分和余额
		TAccountInfo info = accountDao.getBasicAccountInfo(userId);
		if(info==null){
			LogUtil.log.info("WARN in getAccountInfo: user account not found.");
			return null;
		}
		try{
			//以下需要统计得到
			//2.获得订单数
			int totalOrderNum = 0;
			if(role==1)//患者
				totalOrderNum = accountDao.getBuyerTotalOrderNum(userId);
			else if(role==2)//医生
				totalOrderNum = accountDao.getVendorTotalOrderNum(userId);
			else{
				LogUtil.logError.error("ERROR in getAccountInfo: role(1 or 2) is invalid: "+role);
				return info;
			}
			info.setTotalOrderNum(totalOrderNum);
			
			float totalExpenses = 0;
			float totalIncome = 0;
			//3.获得收益和支出
			if(role==1)//患者
				totalExpenses = accountDao.getBuyerTotalExpenses(userId);
			else if(role==2)//医生
				totalIncome = accountDao.getVendorTotalIncome(userId);
		
			info.setTotalIncome(totalIncome);
			info.setTotalExpenses(totalExpenses);
		}
		catch(Exception e){
			//基本的info还是返回
			LogUtil.logError.warn("WARN in getAccountInfo: "+e.getMessage());
		}
		
		return info;
	}

	

	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.AccountService#listIncomeExpensesDetail(java.lang.Long, java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page<TIncomeExpensesItemInfo> listIncomeExpensesDetail(Long userId,
			Integer role,Integer page, Integer num) {
		// TODO Auto-generated method stub
		// 不同的角色，收支明细查看不同的账户
		int accountClass = getAccountClass(role);
		PageHelper.startPage(page+1, num);
		List<TIncomeExpensesItemInfo> list = accountDao.listIncomeExpensesDetail(userId,accountClass);
		return PageUtil.returnPage((com.github.pagehelper.Page<TIncomeExpensesItemInfo>)list);

	
	}



	/**
	 * @param role
	 * @return
	 */
	private int getAccountClass(Integer role) {
		// TODO Auto-generated method stub
		switch(role){
			case 1://买家
				 return 2; //支出账户
			case 2: //卖家
				return 1; //易随诊主账户
			case 3://第三方，如药厂、保险
				return 2; //支出账户
			case 0: //平台
				return 1;//易随诊主账户 
			default:
				return 1;
		}
	}



	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.account.AccountService#refund(java.lang.String)
	 */
	@Override
	public void refund(String orderId) {
		
		// 退款后的处理
		// 0. 先看看是否有打款标识
		TOrderPayInfo orderPayInfo = payDao.getOrderPayInfo(orderId);
		if(orderPayInfo==null){
			LogUtil.logError.error(Constant.LOGTAG.ERR+" refund failed: gerOrderPayInfo return null. orderId="+orderId);
			return ;

		}
		if(orderPayInfo.getProfitFlag()==0){
			LogUtil.log.info(Constant.LOGTAG.INF+" Do NOT need to refund: profitFlag=0. orderId="+orderId);
			return ;
		}
		
		
		TTradeRecordItemInfo tradeRecordItemInfo = accountDao.getTradeRecordItemInfo(orderId);
		if(tradeRecordItemInfo==null){
			LogUtil.logError.warn("########### WARN when refund: trade record not found for order. orderId="+orderId);;
			return ;
			
		}
		
		if(tradeRecordItemInfo.getState()==2){
			LogUtil.logError.warn("########### WARN when refund: trade record already REFUND(2). orderId="+orderId);;
			return ;

		}

		//1. 将交易表account_trade_record设为已退款
		accountDao.tradeRecordRefund(orderId,orderPayInfo.getRemark()+"已退款");
		
		//2. 生成退款收支记录. 因为没有生成收益，故不须修改记账单记录
		//生成记账单记录. 需要生成两笔记录
		//获得accountId. 收益方（被退款方，即买家）传入accountClass=2. 如果没有获得，将会抛出异常
		Long accountId = accountDao.getAccountId(tradeRecordItemInfo.getBuyer(),2);
		LogUtil.log.debug("accountDao.getAccountId() for buyer: result= "+accountId+",userId="+tradeRecordItemInfo.getBuyer());
		TDebitCreditRecordItemInfo debitRecordItemInfo = tradeRecordItemInfo.getDebitRecordItemInfo(accountId);
		//2.1先生成借方记录(debit),即收益方
		int rt = accountDao.createDebitCreditRecord(debitRecordItemInfo);
		LogUtil.log.info("REFUND: create account debit record succeed. recId="+debitRecordItemInfo.getRecId()
		+",recRlatedId="+debitRecordItemInfo.getRecRelatedId()+",vendor="+tradeRecordItemInfo.getVendor()+",debit="+debitRecordItemInfo.getDebit());

			
		//获得accountId. 支出方（退款方，即提供商）传入accountClass=1. 如果没有获得，将会抛出异常
		accountId = accountDao.getAccountId(tradeRecordItemInfo.getVendor(),1);
		LogUtil.log.debug("accountDao.getAccountId() for vendor: result= "+accountId+",userId="+tradeRecordItemInfo.getVendor());
		TDebitCreditRecordItemInfo creditRecordItemInfo = tradeRecordItemInfo.getCreditRecordItemInfo(accountId);
		creditRecordItemInfo.setRecRelatedId(debitRecordItemInfo.getRecRelatedId());
		rt = accountDao.createDebitCreditRecord(creditRecordItemInfo);
		if(rt==1){
			LogUtil.log.info("REFUND: create account credit record succeed. recId="+creditRecordItemInfo.getRecId()
					+",recRlatedId="+creditRecordItemInfo.getRecRelatedId()+",buyer="+tradeRecordItemInfo.getBuyer()+",credit=-"+creditRecordItemInfo.getCredit());
			//更新一下账户表的余额,需要扣款
			accountDao.updateAccountBalance(debitRecordItemInfo.getAccountId(),-debitRecordItemInfo.getDebit());

		}
		
	}



	/* (non-Javadoc)
	 * @see com.westangel.commonservice.trade.service.account.AccountService#createDebitCreditRecord(com.westangel.commonservice.trade.model.account.TTradeRecordItemInfo)
	 * payFlag  0：只有线上  1：只有抵用券  2： 所有支付
	 */
	@Override
	public int createDebitCreditRecord(TTradeRecordItemInfo tradeRecordItemInfo,int payFlag) {
		// TODO Auto-generated method stub
		//3.生成记账单记录. 
		//获得accountId. 收益方传入accountClass=1. 如果没有获得，将会抛出异常
		Long accountId = accountDao.getAccountId(tradeRecordItemInfo.getVendor(),1);
		LogUtil.log.debug("accountDao.getAccountId() for vendor: result= "+accountId+",userId="+tradeRecordItemInfo.getVendor());
		int rt = 0;
		//3.1先生成借方记录(debit),即收益方
		List<TDebitCreditRecordItemInfo> debitRecordItemInfos = tradeRecordItemInfo.getDebitRecordItemInfos(accountId, payFlag);
		for(TDebitCreditRecordItemInfo debitRecordItemInfo:debitRecordItemInfos){
			rt = accountDao.createDebitCreditRecord(debitRecordItemInfo);
			if(rt==1){
				LogUtil.log.info("create account debit record succeed. recId="+debitRecordItemInfo.getRecId()
						+",recRlatedId="+debitRecordItemInfo.getRecRelatedId()+",vendor="+tradeRecordItemInfo.getVendor()+",debit="+debitRecordItemInfo.getDebit());
				//3.1.1 对于收益方，更新一下账户表的余额
				accountDao.updateAccountBalance(debitRecordItemInfo.getAccountId(),debitRecordItemInfo.getDebit());
				tradeRecordItemInfo.setDebitRecId(debitRecordItemInfo.getRecId());//需要返回给服务系统
			}
		}
		
		//3.2  再生成贷方记录
		rt = accountDao.isExistAccount(tradeRecordItemInfo.getBuyer(),2);//accountClass=2 表示支付账户
		if(rt==0){
			//3.2.1 先检查是否存在account买方支付账户，如果不存在，则生成一条
			TAccountPublishInfo accountInfo = AccountUtil.getAccountPublishInfo(tradeRecordItemInfo.getBuyer(),1,2);
			accountDao.createAccount(accountInfo);
			
		}

		//获得accountId. 支出方传入accountClass=2. 如果没有获得，将会抛出异常
		accountId = accountDao.getAccountId(tradeRecordItemInfo.getBuyer(),2);
		Long systemAccountId = accountDao.getAccountId(Constant.User.SuizhenSys, 4);
		LogUtil.log.debug("accountDao.getAccountId() for buyer: result= "+accountId+",userId="+tradeRecordItemInfo.getBuyer());
		List<TDebitCreditRecordItemInfo> creditRecordItemInfos = tradeRecordItemInfo.getCreditRecordItemInfos(accountId,payFlag,systemAccountId);
		for(TDebitCreditRecordItemInfo creditRecordItemInfo : creditRecordItemInfos){	
			rt = accountDao.createDebitCreditRecord(creditRecordItemInfo);
			if(rt==1){
				LogUtil.log.info("create account credit record succeed. recId="+creditRecordItemInfo.getRecId()
						+",recRlatedId="+creditRecordItemInfo.getRecRelatedId()+",buyer="+tradeRecordItemInfo.getBuyer()+",credit="+creditRecordItemInfo.getCredit());
				
			}
		}
		return 0;//success
	}



	/* 给供应商正式打款。需要在服务完成后。只有私人医生（套餐）在同意后。
	 * @see com.westangel.common.service.AccountService#makeProfit(int, java.lang.String)
	 */
	@Override
	public String makeProfit(int state, String orderId) {
		//检查state和order表中一致
		LogUtil.log.info(Constant.LOGTAG.INF+"Begin to makeProfit...state="+state+",orderId="+orderId);
		int rt = 0;
		try{
			TOrderPayInfo orderPayInfo = payDao.getOrderPayInfo(orderId);
			if(orderPayInfo==null){
				LogUtil.logError.error(Constant.LOGTAG.ERR+" makeProfit failed: gerOrderPayInfo return null. orderId="+orderId);
				return null;
	
			}
			if(orderPayInfo.getProfitFlag()==1){
				LogUtil.logError.error(Constant.LOGTAG.ERR+" makeProfit failed: profitFlag=1. already make profit. orderId="+orderId);
				return null;
			}
			
			TTradeRecordItemInfo tradeRecordItemInfo = getTradeRecordItemInfo(orderPayInfo);//从orderPayInfo得到tradeRecordItemInfo
			int payFlag = 0;
			if(orderPayInfo.getCouponsPayValue()!=0){
				if(orderPayInfo.getOnlinePayValue()==0)
					payFlag = 1;
				else
					payFlag = 2;
			}
			rt = accountDao.createTradeRecord(tradeRecordItemInfo);
			if(rt==1){
				LogUtil.log.info("create trade record succeed. tradeId="+tradeRecordItemInfo.getTradeId()
						+",buyer="+tradeRecordItemInfo.getBuyer()+",vendor="+tradeRecordItemInfo.getVendor()+",volume="+tradeRecordItemInfo.getVolume());
			}	
			
			rt = createDebitCreditRecord(tradeRecordItemInfo,payFlag);
			if(rt==0){
				//更新支付表的profitFlag标识为已打款
				payDao.updateProfitFlag(orderId, 1); 
				LogUtil.log.info(Constant.LOGTAG.OK+"makeProfit succeed and update profiltFlag=1! orderId="+orderId+",state="+state);
				return tradeRecordItemInfo.getDebitRecId();//success
			}
		}
		catch(Exception e){
			LogUtil.logError.error(Constant.LOGTAG.ERR+" makeProfit failed. orderId="+orderId+",error="+e.getMessage());;
		}
		
		
		return null;//failed
	}
	
	private TTradeRecordItemInfo getTradeRecordItemInfo(
			TOrderPayInfo orderPayInfo) {
		// TODO Auto-generated method stub
		TTradeRecordItemInfo item = new TTradeRecordItemInfo();
		item.setTradeId(GeneralUtil.generateUniqueID("TRAD"));
		item.setBuyer(orderPayInfo.getBuyer());
		item.setVendor(orderPayInfo.getVendor());
		item.setOrderId(orderPayInfo.getOrderId());
		item.setPayment(orderPayInfo.getBalancePayValue()+orderPayInfo.getOnlinePayValue());
		float realPrice = orderPayInfo.getBalancePayValue()+orderPayInfo.getOnlinePayValue()+orderPayInfo.getPointsPayValue()+orderPayInfo.getCouponsPayValue();
		item.setVolume(realPrice);
		item.setState(1);//正常
		item.setRemark(orderPayInfo.getRemark()+"-已打款");
		return item;
	}



	/** 
	 * 创建一个账户
	 * @see com.westangel.commonservice.trade.service.account.AccountService#createAccount(java.lang.Long, int, int)
	 */
	@Override
	public boolean createAccount(Long userId, int role, int accountClass) {
		try{
			TAccountPublishInfo accountInfo = AccountUtil.getAccountPublishInfo(userId,role,accountClass);
			accountDao.createAccount(accountInfo);
			
		}
		catch(Exception e)
		{
			LogUtil.logError.error(Constant.LOGTAG.ERR+"createAccount exception: userId="+userId+",err="+e.getMessage());
			return false;
		}
		
	
		return true;
	}



	@Override
	public void dealWithDrawMoney(Long userId, String money) {
		// TODO Auto-generated method stub
		accountDao.updateAccountForDraw(userId, money);
		accountDao.addWithDrawRecord(userId, money);
	}

}
