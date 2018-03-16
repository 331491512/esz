/**
 * 
 */
package com.westangel.commonservice.trade.controller;

import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.TMsgResponseWeixin;
import com.westangel.commonservice.trade.bean.TMsgResponseWeixinPayCallback;
import com.westangel.commonservice.trade.bean.TOrderPayPrepareReq;
import com.westangel.commonservice.trade.bean.TPayResultSyncInfo;
import com.westangel.commonservice.trade.bean.TPayWeixinQrcodeScanCallbackReq;
import com.westangel.commonservice.trade.bean.TPayWeixinResultSyncReq;
import com.westangel.commonservice.trade.service.pay.PayService;

/**
 * 支付服务控制器。
 * 具体支付实现对应到各类支付平台，目前暂支持微信支付。
 * 下单和预支付接口走的是OrderController和OrderService，
 * 这里PayController目前主要定义了第三方平台（如微信支付）支付结果通知回调接口。
 * @author bigdraogn
 * @date  2016-1-9 下午2:19:53
 */
@Controller
@RequestMapping("/")
public class PayController {

	@Resource(name="payServiceImpl")
	PayService payService;
	
	/**
	 * 微信公众号支付结果回调
	 */
	@ResponseBody
	@RequestMapping(value="/pay/weixin/result/sync" , method=RequestMethod.POST)
	public TMsgResponseWeixin payWeixinResultSync(@RequestBody TPayWeixinResultSyncReq payResult,Locale locale)
	{
		//TPayWeixinResultSyncReq payResult=new TPayWeixinResultSyncReq();
		LogUtil.log.info("payWeixinResultSync was called.");
		//设置返回成功代码及提示消息
		TMsgResponseWeixin msg = new TMsgResponseWeixin();
		msg.setReturn_code("SUCCESS");
		msg.setReturn_msg("OK");
		
		try
		{
			//调用服务接口
			TPayResultSyncInfo resultSyncInfo = payResult.createResultSyncInfo();
			int result = payService.payResultSync(resultSyncInfo);
			if(result!=0){
				msg.setReturn_code("FAIL");
				msg.setReturn_msg("error");
				LogUtil.logError.error("payResultSync failed! orderId="+resultSyncInfo.getOrderId());
			}
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.setReturn_code("FAIL");
			msg.setReturn_msg("error");
			LogUtil.logError.error("payResultSync failed! orderId="+payResult.getOut_trade_no()+",error:"+ex.getMessage());
			
		}
		return msg;
	}
	
	/**
	 * 微信扫码支付回调
	 */
	@ResponseBody
	@RequestMapping(value="/pay/weixin/qrcode/scan" , method=RequestMethod.POST)
	public TMsgResponseWeixinPayCallback payWeixinQrcodeScan(@RequestBody TPayWeixinQrcodeScanCallbackReq payWeixinQrcodeScanReq,Locale locale)
	{
		//TPayWeixinResultSyncReq payResult=new TPayWeixinResultSyncReq();
		LogUtil.log.info("payWeixinResultSync was called.");
		//设置返回成功代码及提示消息
		TMsgResponseWeixinPayCallback msg = new TMsgResponseWeixinPayCallback();
		msg.setReturn_code("SUCCESS");
		msg.setReturn_msg("OK");
		msg.setAppid(payWeixinQrcodeScanReq.getAppid());
		msg.setMch_id(payWeixinQrcodeScanReq.getMch_id());
		
		try
		{
			//调用服务接口
			TMsgResponse<Map<String, Object>> result = payService.payQrcodeScan(payWeixinQrcodeScanReq,2);
			if(result==null){
				msg.setReturn_code("FAIL");
				msg.setReturn_msg("error");
				LogUtil.logError.error("payWeixinQrcodeScan failed! openId="+payWeixinQrcodeScanReq.getOpenid()+",productId="+payWeixinQrcodeScanReq.getProduct_id());
			}
			
			msg.setNonce_str((String) result.getResult().get("nonceStr"));
			
			String packageStr = (String) result.getResult().get("package");
			if(packageStr!=null){
				String prepay_id = packageStr.substring(10);//"prepay_id=";
				msg.setPrepay_id(prepay_id);
			}
			msg.setSign((String) result.getResult().get("paySign"));
		
		
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.setReturn_code("FAIL");
			msg.setReturn_msg("error");
			LogUtil.logError.error("payWeixinQrcodeScan failed! openId="+payWeixinQrcodeScanReq.getOpenid()+",productId="+payWeixinQrcodeScanReq.getProduct_id());
					
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/pay/round" , method=RequestMethod.POST)
	public TMsgResponseWeixinPayCallback payRound(String orderId,Locale locale){
//		payService.refund(orderId);
		return null;
	}
}
