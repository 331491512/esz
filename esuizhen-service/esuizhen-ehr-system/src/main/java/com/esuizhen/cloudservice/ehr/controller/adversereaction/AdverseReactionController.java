package com.esuizhen.cloudservice.ehr.controller.adversereaction;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.service.adversereaction.AdverseReactionService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class AdverseReactionController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private AdverseReactionService adverseReactionService;
	
	/**
	 * 查询不良反应结果查询
	 * @param req
	 */
	@ResponseBody
	@RequestMapping(value="/patient/adverse/reaction/result/query" , method=RequestMethod.POST)
	public TMsgResponse<List<AdverseReactionResultInfo>> queryAdverseReactionResult(@RequestBody AttendPatientReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<AdverseReactionResultInfo>> msg = new TMsgResponse<List<AdverseReactionResultInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = adverseReactionService.queryAdverseReactionResult(req);
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
	
	/**
	 * 保存不良反应结果查询
	 * @param req
	 */
	@ResponseBody
	@RequestMapping(value="/patient/adverse/reaction/result/save",method=RequestMethod.POST)
	public TMsgResponse<Object> saveAdverseReactionResult(@RequestBody List<AdverseReactionResultInfo> infoList,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			adverseReactionService.saveAdverseReactionResult(infoList);
		}catch(EmptyParamExcption ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1419.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1419.info, null, locale);
		}catch(EmptyObjectExcption ex){
			LogUtil.log.error(ex.getCause() + "\t" + ex.getMessage());
			msg.setRespCode(ErrorMessage.E1417.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1417.info, null, locale));
		}
		catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
}
