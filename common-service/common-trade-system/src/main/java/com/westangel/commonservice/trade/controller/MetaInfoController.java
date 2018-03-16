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
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.trade.TProductDetailInfo;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.trade.bean.TExpressCompanyInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInfo;
import com.westangel.commonservice.trade.bean.THospitalProductInitReq;
import com.westangel.commonservice.trade.bean.TProductInitReq;
import com.westangel.commonservice.trade.bean.TProductOffShelfReq;
import com.westangel.commonservice.trade.bean.TProductOnShelfReq;
import com.westangel.commonservice.trade.bean.TProductTemplateInfo;
import com.westangel.commonservice.trade.service.metainfo.MetaInfoService;
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
public class MetaInfoController {

	/**
	 * 接口
	 */
	@Autowired
	private MetaInfoService metaInfoService;
	
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
	@RequestMapping(value="/metainfo/express/company/list" , method=RequestMethod.GET)
	public TMsgResponse<List<TExpressCompanyInfo>> listMetaInfoExpressCompany(Integer hospitalId,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TExpressCompanyInfo>> msg = new TMsgResponse<List<TExpressCompanyInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//调用服务接口
			msg.result = metaInfoService.listMetaInfoExpressCompany(hospitalId);
			
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