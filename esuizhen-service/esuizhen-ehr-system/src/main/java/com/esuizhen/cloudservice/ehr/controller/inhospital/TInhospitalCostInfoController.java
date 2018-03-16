package com.esuizhen.cloudservice.ehr.controller.inhospital;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.model.inhospitalcost.TInhospitalCostInfo;
import com.esuizhen.cloudservice.ehr.service.inhospital.TInhospitalCostInfoService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class TInhospitalCostInfoController{

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TInhospitalCostInfoService inhospitalCostInfoService;
	
	@ResponseBody
	@RequestMapping(value="/inhospital/cost/query" , method=RequestMethod.GET)
	public TMsgResponse<TInhospitalCostInfo> queryInhospitalCost(String inhospitalId , Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<TInhospitalCostInfo> msg = new TMsgResponse<TInhospitalCostInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
//			msg.result = inhospitalDetailInfoService.queryInhospitalDetail(inhospitalId);
			msg.result = inhospitalCostInfoService.queryEiInhospitalCostByInhospitalId(inhospitalId);
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
	
	@ResponseBody
	@RequestMapping(value="/inhospital/cost/update" , method=RequestMethod.POST)
	public TMsgResponse<Integer> updateTInhospitalCostInfo(@RequestBody TInhospitalCostInfo inhospitalCostInfo ,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		if(inhospitalCostInfo == null || inhospitalCostInfo.getInhospitalId() == null) {
			msg.respCode=ErrorMessage.E1404.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			return msg;
		}
		try
		{
			//修改
			msg.result = inhospitalCostInfoService.updateEiInhospitalCost(null,inhospitalCostInfo);
			if(msg.result == 0) {
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

