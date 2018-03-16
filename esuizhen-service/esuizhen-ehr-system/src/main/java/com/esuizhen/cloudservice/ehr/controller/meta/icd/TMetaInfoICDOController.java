package com.esuizhen.cloudservice.ehr.controller.meta.icd;

import java.util.List; 
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoICDO;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoICDOService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TMetaInfoICDOController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TMetaInfoICDOService<TMetaInfoICDO> metaInfoICDOService;
	
	@ResponseBody
	@RequestMapping(value="/metainfo/icdo/query" , method=RequestMethod.GET)
	public TMsgResponse<List<TMetaInfoICDO>> queryICDO(String key , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TMetaInfoICDO>> msg = new TMsgResponse<List<TMetaInfoICDO>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = metaInfoICDOService.queryListLike(key);
			if(msg.result == null || msg.result.size() == 0)
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

