/**
 * 
 */
package com.westangel.commonservice.trade.controller;

import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.*;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**
 * @author chenghao
 * @date  2017年2月17日 上午10:14:08
 * 运营商品管理接口
 */
@Controller
@RequestMapping("/")
public class ProductInfoController {
	/**
	 * 产品接口
	 */
	@Autowired
	private ProductService productService;
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	
	/**
	 * 获取商品信息列表
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/info/list/get" , method=RequestMethod.GET)
	public TMsgResponse<Page<TProductInfo>> getProductInfoList(ProductInfoListGetReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TProductInfo>> msg = new TMsgResponse<Page<TProductInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.getProductInfoList(req);
		}catch(EmptyParamExcption ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1400.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/product/info/get" , method=RequestMethod.GET)
	public TMsgResponse<TProductInfo> getProductInfo(ProductInfoGetReq  req,Locale locale)
	{
		TMsgResponse<TProductInfo> msg = new TMsgResponse<TProductInfo>();//设置返回成功代码及提示消息
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = productService.getProductInfo(req);//调用获取商品接口
		}catch(EmptyParamExcption ex){//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1400.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 新增商品
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/info/add" , method=RequestMethod.POST)
	public TMsgResponse<Object> addProductInfo(@RequestBody ProductInfoAddReq  req,Locale locale)
	{
		TMsgResponse<Object> msg = new TMsgResponse<Object>();//设置返回成功代码及提示消息
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = productService.addProductInfo(req);//调用新增商品接口
		}catch(EmptyParamExcption ex){//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1400.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage(),ex);
		}
		return msg;
	}
	
	
	/**
	 * 2.4.38	商品状态（上架/下架）更新接口-ProductInfoStateUpdate
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/info/state/update" , method=RequestMethod.POST)
	public TMsgResponse<Object> productStateUpdate(@RequestBody ProductStateUpdateReq req,Locale locale)
	{
		TMsgResponse<Object> msg = new TMsgResponse<Object>();//设置返回成功代码及提示消息
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = productService.productStateUpdate(req);//调用新增商品接口
		}catch(EmptyParamExcption ex){//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1400.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/product/info/update" , method=RequestMethod.POST)
	public TMsgResponse<Object> updateProductInfo(@RequestBody ProductInfoUpdateReq  req,Locale locale)
	{
		TMsgResponse<Object> msg = new TMsgResponse<Object>();//设置返回成功代码及提示消息
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.result = productService.updateProductInfo(req);//调用新增商品接口
		}catch(EmptyParamExcption ex){//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1400.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
