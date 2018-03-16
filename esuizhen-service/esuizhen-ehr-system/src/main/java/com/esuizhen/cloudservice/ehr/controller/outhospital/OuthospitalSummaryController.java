package com.esuizhen.cloudservice.ehr.controller.outhospital;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.TOuthospitalSummaryInfo;
import com.esuizhen.cloudservice.ehr.service.outhospital.OuthospitalSummaryService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class OuthospitalSummaryController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private OuthospitalSummaryService outhospitalSummaryService;
	
	@ResponseBody
	@RequestMapping(value="/outhospital/summary/query" , method=RequestMethod.GET)
	public TMsgResponse<TOuthospitalSummaryInfo> queryOuthospitalSummary(String inhospitalId, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TOuthospitalSummaryInfo> msg = new TMsgResponse<TOuthospitalSummaryInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = outhospitalSummaryService.queryOuthospitalSummary(inhospitalId);
			if(msg.result == null) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
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
	@RequestMapping(value="/outhospital/info/list/query" , method=RequestMethod.POST)
	public TMsgResponse<Page<TOuthospitalSummaryInfo>> queryOuthospitalInfoList(@RequestBody CommonReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Page<TOuthospitalSummaryInfo>> msg = new TMsgResponse<Page<TOuthospitalSummaryInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = outhospitalSummaryService.queryPageOuthospitalList(req);
			if(msg.result == null) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
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
}

