/**
 * 
 */
package com.westangel.commonservice.trade.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.CouponTemplateReq;
import com.westangel.common.bean.trade.TCouponTemplateDetailInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.CouponReq;
import com.westangel.commonservice.trade.bean.TCouponInfo;
import com.westangel.commonservice.trade.service.coupon.CouponService;

/**
 * @author chenghao
 * @date  2016年6月29日 下午2:25:48
 */
@Controller
public class CouponController {
	@Autowired
	private CouponService couponService;
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 获取抵用券模版详情
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/template/detail/get",method=RequestMethod.GET)
	public TMsgResponse<TCouponTemplateDetailInfo> getCouponTemplate (String couponTemplateId,Locale locale){
		return couponService.getCouponTemplate(couponTemplateId);
	}
	/**
	 * 创建抵用券模版
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/template/create",method=RequestMethod.POST)
	public TMsgResponse<Object> createCouponTemplate(@RequestBody CouponTemplateReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg = couponService.createCouponTemplate(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 修改抵用券模版
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/template/modify",method=RequestMethod.POST)
	public TMsgResponse<Object> modifyCouponTemplate(@RequestBody CouponTemplateReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg = couponService.modifyCouponTemplate(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 初始化抵用券
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/init",method=RequestMethod.POST)
	public TMsgResponse<Object> initCoupon(@RequestBody CouponTemplateReq req,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg = couponService.initCoupon(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 抵用券查询
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/search",method=RequestMethod.GET)
	public TMsgResponse<List<TCouponInfo>> searchCoupon (CouponReq req,Locale locale){
		TMsgResponse<List<TCouponInfo>> msg = new TMsgResponse<List<TCouponInfo>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = couponService.searchCoupon(req);
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1419.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 抵用券领取接口
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/coupon/receive",method=RequestMethod.POST)
	public TMsgResponse<String> receiveCoupon(@RequestBody CouponReq req,Locale locale){
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			couponService.receiveCoupon(req);
		}catch(EmptyParamExcption e){
			msg.setRespCode(ErrorMessage.E1419.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1419.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}catch(EmptyObjectExcption e){
			msg.setRespCode(ErrorMessage.E1404.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
