package com.westangel.commonservice.sms.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallAuthReq;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallAuthRsp;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallEstablishReq;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallEstablishRsp;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallerBillReq;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunCallerBillRsp;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunHangupReq;
import com.westangel.commonservice.sms.bean.yuntongxun.YuntongxunHangupRsp;
import com.westangel.commonservice.sms.service.YuntongxunCallInvoker;

@Controller
public class YuntongxunController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource(name="yuntongxunService")
	YuntongxunCallInvoker ytxService;
	
	@ResponseBody
	@RequestMapping(value="/call/Yuntongxun/CallAuth", method=RequestMethod.POST)
	public YuntongxunCallAuthRsp callTwowayCallAuth(@RequestBody YuntongxunCallAuthReq req)
	{
		YuntongxunCallAuthRsp rsp = new YuntongxunCallAuthRsp();
		logger.info("callTwowayCallAuth----------\n"+req.getUserData()+"\n----------");
		return rsp;
	}
	
	@ResponseBody
	@RequestMapping(value="/call/Yuntongxun/CallEstablish", method=RequestMethod.POST)
	public YuntongxunCallEstablishRsp callTwowayEstablish(@RequestBody YuntongxunCallEstablishReq req)
	{
		YuntongxunCallEstablishRsp rsp = new YuntongxunCallEstablishRsp();
		logger.info("callTwowayEstablish----------\n"+req.getAction()+"\n----------");
		return rsp;
	}
	
	@ResponseBody
	@RequestMapping(value="/call/Yuntongxun/Hangup", method=RequestMethod.POST)
	public YuntongxunHangupRsp callTwowayHangup(@RequestBody YuntongxunHangupReq req)
	{
		YuntongxunHangupRsp rsp = new YuntongxunHangupRsp();
		logger.info("callTwowayHangup----------\n"+req.getAction()+"\n----------");
		return rsp;
	}
	
	@ResponseBody
	@RequestMapping(value="/call/Yuntongxun/callerBill", method=RequestMethod.POST)
	public YuntongxunCallerBillRsp callTwowayCallerBill(@RequestBody YuntongxunCallerBillReq req)
	{
		logger.info("callTwowayCallerBill----------\n"+req.getUserData()+"\n----------");
		ytxService.callerBillCallback(req);
		YuntongxunCallerBillRsp rsp = new YuntongxunCallerBillRsp();
		rsp.setStatuscode("000000");
		return rsp;
	}
}
