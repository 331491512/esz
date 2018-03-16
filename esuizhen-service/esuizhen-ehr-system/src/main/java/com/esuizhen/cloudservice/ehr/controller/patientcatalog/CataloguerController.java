package com.esuizhen.cloudservice.ehr.controller.patientcatalog;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.patientcatalog.CatalogueInfo;
import com.esuizhen.cloudservice.ehr.service.patientcatalog.CataloguerService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class CataloguerController {
	
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private CataloguerService cataloguerService;
	
	@ResponseBody
	@RequestMapping(value="/cataloguer/index/query",method=RequestMethod.GET)
	public TMsgResponse<Page<CatalogueInfo>> queryCataloguerIndex(String hospitalName,Integer page,Integer num, Locale locale) {
		//设置返回成功代码及提示消息
		TMsgResponse<Page<CatalogueInfo>> msg = new TMsgResponse<Page<CatalogueInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = cataloguerService.queryCataloguerIndex(hospitalName, page, num);
			if(msg.result==null)
			{
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
