package com.esuizhen.cloudservice.user.controller.followuppatient;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.service.followuppatient.FollowupPatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class LostFollowupPatientController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FollowupPatientService patientFollowupService;
	
	@ResponseBody
	@RequestMapping(value="/lostfollow/patient/list",method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> queryLostFollowPatient(@RequestBody TPatientSearchInfo patientSearch,Locale locale) {
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		patientSearch.setFollowupFlag(2);
		try {
			patientSearch.setInterfaceName("/user/lostfollow/patient/list");
			int searchId = patientFollowupService.saveMiddlePatientSimpleInfo(patientSearch);
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("searchId", searchId);
			tMsgResponse.setResult(resultMap);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/lostfollow/patient/update",method=RequestMethod.GET)
	public TMsgResponse<Integer> updateLostFollowPatient(Long patientId,Locale locale) {
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.updateLostFollowupPatientState(patientId);
			if(tMsgResponse.result == null || tMsgResponse.result == 0)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
		
		
	}
	
	/**
	 * 失访患者批量撤销
	 * @param patientIds
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/lostfollow/patient/batch/revoke",method=RequestMethod.POST)
	public TMsgResponse<Integer> batchRevokeLostFollowPatient(@RequestBody List<Long>  patientIds,Locale locale) {
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.batchRevokeLostFollowPatient(patientIds);
			if(tMsgResponse.result == null || tMsgResponse.result == 0)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
}
