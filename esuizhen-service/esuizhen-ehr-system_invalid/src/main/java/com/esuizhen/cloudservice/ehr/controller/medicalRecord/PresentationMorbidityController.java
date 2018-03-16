package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.PresentationMorbidityInfo;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PresentationMorbidityService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class PresentationMorbidityController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PresentationMorbidityService presentationMorbidityService;
	
	/**
	 * 表现与发病查询
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/presentation/morbidity/query",method=RequestMethod.POST)
	public TMsgResponse<PresentationMorbidityInfo> queryPresentationMorbidity(@RequestBody CommonReq req, Locale locale) {
		//设置返回成功代码及提示消息
		TMsgResponse<PresentationMorbidityInfo> msg = new TMsgResponse<PresentationMorbidityInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//病例上传
			msg.setResult(presentationMorbidityService.queryPresentationMorbidity(req));
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
	 * 表现与发病保存
	 * @param presentationMorbidity
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/presentation/morbidity/save",method=RequestMethod.POST)
	public TMsgResponse<Integer> savePresentationMorbidity(@RequestBody PresentationMorbidityInfo presentationMorbidity, Locale locale) {
		//设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			msg.setResult(presentationMorbidityService.insertPresentationMorbidity(presentationMorbidity));
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
