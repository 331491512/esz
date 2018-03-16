package com.esuizhen.cloudservice.followup.controller.conf;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.followup.bean.TFollowupConfigDiseaseType;
import com.esuizhen.cloudservice.followup.bean.TFollowupRangeIcdCodeText;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.service.conf.FollowupRangeService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * 
 * @author raox
 *
 */
@Controller
public class FollowupRangeController {
	
	@Autowired
	private FollowupRangeService followupRangeService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	

	@RequestMapping(value="/config/diseaseType/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TFollowupConfigDiseaseType>> getFollowupConfigDiseaseTypeList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TFollowupConfigDiseaseType>> msg = new TMsgResponse<List<TFollowupConfigDiseaseType>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupRangeService.getFollowupConfigDiseaseTypeList();
			if(msg.result==null){
				//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/config/diseaseType/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupConfigDiseaseType(@RequestBody List<TFollowupConfigDiseaseType> followupConfigDiseaseTypeList, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupRangeService.saveFollowupConfigDiseaseType(followupConfigDiseaseTypeList);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value="/config/icd/code/list",method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<List<TFollowupRangeIcdCodeText>> getFollowupConfigIcdCodeList(Locale locale){
		//设置返回成功代码及提示消息
		TMsgResponse<List<TFollowupRangeIcdCodeText>> msg = new TMsgResponse<List<TFollowupRangeIcdCodeText>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=followupRangeService.getFollowupConfigIcdCodeList();
			if(msg.result==null){
				//如果为空
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		}catch(Exception e){
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage(),e);
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "/config/icd/code/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupConfigIcdCode(@RequestBody List<TFollowupRangeIcdCodeText> followupRangeIcdCodeTextList, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			followupRangeService.saveFollowupConfigIcdCode(followupRangeIcdCodeTextList);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
}
