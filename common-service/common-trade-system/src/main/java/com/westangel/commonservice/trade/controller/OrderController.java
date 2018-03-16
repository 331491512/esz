/**
 * 
 */
package com.westangel.commonservice.trade.controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TOrderPayInfo;
import com.westangel.common.bean.trade.TOrderPublishInfo;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.model.order.TOrderDetailInfo;
import com.westangel.commonservice.trade.model.order.TOrderSimpleInfo;
import com.westangel.commonservice.trade.bean.TOrderPayPrepareReq;
import com.westangel.commonservice.trade.bean.TOrderPrepareInfo;
import com.westangel.commonservice.trade.bean.TProductOnShelfReq;
import com.westangel.commonservice.trade.service.order.OrderService;

/**
 * 订单接口服务控制器
 * @class OrderController
 * @author bigdragon
 * @date  2015-12-24 上午12:22:29
 */
@Controller
@RequestMapping("/")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	/**
	 * 下单和支付准备接口
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/order/pay/prepare" , method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> prepareOrderPay(@RequestBody TOrderPayPrepareReq orderPayPrepareReq,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String,Object>> msg = new TMsgResponse<Map<String,Object>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			TOrderPrepareInfo orderInfo = orderPayPrepareReq.getOrderInfo();
			LogUtil.log.info("prepareOrderPay:  buyer="+orderPayPrepareReq.getOrderInfo().getBuyer()+",productId="+orderInfo.getProductId()
			+",description="+orderInfo.getDescription()+",attachement="+orderInfo.getAttachement());
			
			msg = orderService.prepareOrderPay(orderPayPrepareReq);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 创建订单
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/order/create" , method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> createOrder(@RequestBody TOrderPublishInfo orderInfo,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Map<String,Object>> msg = new TMsgResponse<Map<String,Object>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = orderService.createOrder(orderInfo);
			
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
	@RequestMapping(value="/order/list" , method=RequestMethod.GET)
	public TMsgResponse<Page> listOrder(Long userId, Integer role,Integer productType,Integer page,Integer num,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = orderService.listOrder(userId,role,productType,page,num);
			
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
	@RequestMapping(value="/order/detail" , method=RequestMethod.GET)
	public TMsgResponse<TOrderDetailInfo> getOrderDetail(Long userId, String orderId,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TOrderDetailInfo> msg = new TMsgResponse<TOrderDetailInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = orderService.getOrderDetail(userId,orderId);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 订单支付
	 * 只是将支付结果保存，不做实际的支付动作。支付动作由前端微信完成。
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/order/pay" , method=RequestMethod.POST)
	public TMsgResponse payOrder(@RequestBody TOrderPayInfo orderPayInfo,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = orderService.payOrder(orderPayInfo);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
