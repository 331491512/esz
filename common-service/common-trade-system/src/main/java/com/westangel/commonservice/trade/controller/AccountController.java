/**
 * 
 */
package com.westangel.commonservice.trade.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TAccountInfo;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.model.account.TIncomeExpensesItemInfo;
import com.westangel.commonservice.trade.service.account.AccountService;

/**
 * 账户控制器。
 * 完成账户相关服务调用，如账户统计信息（余额、订单数等）、交易明细、收支明细等
 * @author bigdragon
 * @date  2015-12-26 上午11:58:47
 */
@Controller
@RequestMapping("/") 
public class AccountController {

	@Autowired 
	AccountService accountService;
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	

	@ResponseBody
	@RequestMapping(value="/account/info" , method=RequestMethod.GET)
	public TMsgResponse<TAccountInfo> getAccountInfo(Long userId, Integer role,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TAccountInfo> msg = new TMsgResponse<TAccountInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = accountService.getAccountInfo(userId,role);
			if(msg.result==null){
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
				LogUtil.logError.error("accountService.getAccountInfo return null. userId="+userId+",role="+role);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/account/income/expenses/detail" , method=RequestMethod.GET)
	public TMsgResponse<Page<TIncomeExpensesItemInfo>> listIncomeExpensesDetail(Long userId,Integer role, Integer page,Integer num,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TIncomeExpensesItemInfo>> msg = new TMsgResponse<Page<TIncomeExpensesItemInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = accountService.listIncomeExpensesDetail(userId,role,page,num);
			if(msg.result==null){
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
				LogUtil.logError.error("accountService.getAccountInfo return null. userId="+userId+",page="+page+",num="+num);
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/draw/money" , method=RequestMethod.GET)
	public String getWithDrawMoney(Long userId,String money, Integer role,Locale locale)
	{
		//设置返回成功代码及提示消息
		try
		{
			//调用提现接口
			accountService.dealWithDrawMoney(userId,money);
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			LogUtil.logError.error(ex.getMessage());
			return "提现失败";
		}
		return "提现成功";
	}
}
