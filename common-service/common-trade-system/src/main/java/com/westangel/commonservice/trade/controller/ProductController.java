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
import com.westangel.common.bean.trade.ProductTemplateListReq;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.ProductGetReq;
import com.westangel.commonservice.trade.bean.ProductListRuleGetReq;
import com.westangel.commonservice.trade.bean.THospitalProductInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInitReq;
import com.westangel.commonservice.trade.bean.TProductInitReq;
import com.westangel.commonservice.trade.bean.TProductOffShelfReq;
import com.westangel.commonservice.trade.bean.TProductOnShelfReq;
import com.westangel.commonservice.trade.bean.TProductTemplateInfo;
import com.westangel.commonservice.trade.service.product.ProductService;

/**
 * 
* @ClassName: ProductController 
* @Description: 产品（商品）控制器
* @author bigdragon
* @date 2015年12月19日 下午16:51:25
 */
@Controller
@RequestMapping("/")
public class ProductController {

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
	 * 获取商品模板接口
	 * By Da Loong
	 * 2016/6/2
	 */
	@ResponseBody
	@RequestMapping(value="/product/template/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TProductTemplateInfo>> listProductTemplate(ProductTemplateListReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TProductTemplateInfo>> msg = new TMsgResponse<List<TProductTemplateInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.listProductTemplate(req);
			
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
	 * 修改商品模板
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/template/modify" , method=RequestMethod.POST)
	public TMsgResponse<Integer> modifyProductTemplate(@RequestBody TProductTemplateInfo req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.modifyProductTemplate(req);
			msg.respMsg=messageSource.getMessage("set.success", null, locale);
			LogUtil.log.info("modifyProductTemplate(): productTemplateId="+req.getProductTemplateId()+",respCode="+msg.respCode+",respMsg="+msg.respMsg);
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage("set.error", null, locale);
			LogUtil.logError.error("makeProductOnShelf():  productTemplateId="+req.getProductTemplateId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}

	/**
	 * 获取某个供应商（如某医生）的产品（商品）列表
	 * @param userId
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TProductDetailInfo>> listProduct(Long userId,Long reqFlag, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TProductDetailInfo>> msg = new TMsgResponse<List<TProductDetailInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.listProduct(userId,reqFlag);
			
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
	 * 获取某个供应商单类商品
	 * @param userId
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/get" , method=RequestMethod.GET)
	public TMsgResponse<List<TProductDetailInfo>> getProduct(ProductGetReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TProductDetailInfo>> msg = new TMsgResponse<List<TProductDetailInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.getProduct(req);
			
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
	 * 获取展示规则的产品（商品）列表
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/list/rule/get" , method=RequestMethod.GET)
	public TMsgResponse<Object> getProductByRule(ProductListRuleGetReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.getProductByRule(req);
			
		}catch(EmptyParamExcption ex){
			msg.respCode=ErrorMessage.E1400.code;//设置错误代码及提示消息
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(EmptyObjectExcption ex){
			msg.respCode=ErrorMessage.E1404.code;//设置错误代码及提示消息
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}catch(Exception ex){
			msg.respCode=ErrorMessage.E1500.code;//设置错误代码及提示消息
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 获取商品详情
	 * @param userId
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/detail" , method=RequestMethod.GET)
	public TMsgResponse<TProductDetailInfo> getProductDetail(String productId,Long buyer,Integer productSubType,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TProductDetailInfo> msg = new TMsgResponse<TProductDetailInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.getProductDetail(productId,buyer,productSubType);
			
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
	 * 商品上架接口（为供应商配置产品服务接口）
	 * @param userId
	 * @param productList
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/onshelf" , method=RequestMethod.POST)
	public TMsgResponse<Integer> makeProductOnShelf(@RequestBody TProductOnShelfReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.makeProductOnShelf(req.getUserId(),req.getProductList());
			msg.respMsg=messageSource.getMessage("set.success", null, locale);
			LogUtil.log.info("makeProductOnShelf(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="+msg.respMsg);
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
//			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.respMsg=messageSource.getMessage("set.error", null, locale);
			LogUtil.logError.error("makeProductOnShelf(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/product/offshelf" , method=RequestMethod.POST)
	public TMsgResponse makeProductOffShelf(@RequestBody TProductOffShelfReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.makeProductOffShelf(req.getUserId(),req.getProductIdList());
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error("makeProductOffShelf(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",error:"+ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 查询订购关系
	 * @param userId
	 * @param productType
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/subscription/query" , method=RequestMethod.GET)
	public TMsgResponse<Integer> queryProductSubscription(Long buyer,Long vendor, Integer productType,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = productService.queryProductSubscription(buyer,vendor,productType);
			
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			msg.result = 0;
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 商品设置（初始化）接口（为供应商初始化产品服务接口）
	 * @param userId
	 * @param productList
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/init" , method=RequestMethod.POST)
	public TMsgResponse<Integer> initProduct(@RequestBody TProductInitReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.initProduct(req.getUserId(),req.getProfessionalRankId());
			LogUtil.log.info("initProduct(): userId="+req.getUserId()+",professionalRankId="+req.getProfessionalRankId()+",respCode="+msg.respCode+",respMsg="+msg.respMsg);
		
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error("makeProductOnShelf(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}
	
	/**
	 * 医院服务开通和关闭
	 * @param userId
	 * @param productList
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/hospital/service/init" , method=RequestMethod.POST)
	public TMsgResponse<Integer> initHospitalProduct(@RequestBody THospitalProductInitReq req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.initProduct(req.getUserId(),req.getProductList());
			LogUtil.log.info("initProduct(): userId="+req.getUserId());	
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error("initHospitalProduct(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}
	
	/**
	 * 医院服务认证模式设置
	 * @param userId
	 * @param productList
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/hospital/certification/mode/set", method=RequestMethod.POST)
	public TMsgResponse<Integer> setHospitalProductCertificationMode(@RequestBody THospitalProductInfo req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.setProductCertificationMode(req);
			LogUtil.log.info("setHospitalProductCertificationMode(): userId="+req.getUserId());	
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error("setHospitalProductCertificationMode(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}
	
	
	/**
	 * 医院服务信息（费用、快递、认证模式）设置
	 * @param userId
	 * @param productList
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/product/hospital/info/set", method=RequestMethod.POST)
	public TMsgResponse<Integer> setHospitalProductInfo(@RequestBody THospitalProductInfo req,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg = productService.setProductHospitalInfo(req);
			LogUtil.log.info("setHospitalProductInfo() Ok: userId="+req.getUserId());	
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error("setHospitalProductInfo(): userId="+req.getUserId()+",respCode="+msg.respCode+",respMsg="
					+ msg.respMsg
					+",ex:"+ex.getMessage());
			
		}
		return msg;
	}
}
