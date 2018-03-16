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
import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.service.followuppatient.FollowupPatientService;
import com.esuizhen.cloudservice.user.service.followuppatient.OperationHistoryService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class SimilarPatientController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FollowupPatientService patientFollowupService;
	
	@Autowired
	private OperationHistoryService operationHistoryService;
	
	@ResponseBody
	@RequestMapping(value="/similar/patient/list",method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> querySimilarPatient(@RequestBody TPatientSearchInfo patientSearchInfo,Locale locale) {
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		patientSearchInfo.setSimilarType(99);
		try {
			patientSearchInfo.setInterfaceName("/user/similar/patient/list");
			int searchId = patientFollowupService.saveMiddlePatientSimpleInfo(patientSearchInfo);
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
	
	/**
	 * 二次查询疑似患者列表信息
	 * @param twiceSearchReq
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/similar/patient/simple/list/search",method=RequestMethod.POST)
	public TMsgResponse<Map<String,Object>> getSearchSimilarPatientSimpleInfo(@RequestBody TwiceSearchReq twiceSearchReq,Locale locale) {
		TMsgResponse<Map<String,Object>> tMsgResponse = new TMsgResponse<Map<String,Object>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		///twiceSearchReq.setClickType(Constants.SIMILAR_NUM_FLAG);
		try {
			Page<PatientSimpleInfo> page = patientFollowupService.searchSimilarPatientSimpleInfoList(twiceSearchReq);
			if(page.getDataList() == null)
			{
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else {
				if(twiceSearchReq.getClickType().equals(5)){
					int sortNum=patientFollowupService.getGroupsOfPatientSortCount(twiceSearchReq);
					int groupNum = patientFollowupService.getGroupsOfPatientByName(null);
					Map<String,Object> result = new HashMap<String,Object>();
					result.put("sortNum", sortNum);
					result.put("page", page);
					result.put("groupNum", groupNum);
					tMsgResponse.setResult(result);
				}else{
					Map<String,Object> result = new HashMap<String,Object>();
					result.put("page", page);
					tMsgResponse.setResult(result);
				}
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage(),ex);
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/similar/patient/merge",method=RequestMethod.POST)
	public TMsgResponse<Integer> mergeSimilarPatient(@RequestBody List<Long> patientIds,Locale locale) {
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if(patientIds == null || patientIds.size() == 0) {
				tMsgResponse.respCode=ErrorMessage.E1404.code;
				tMsgResponse.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else {
				patientFollowupService.mergeSimilarPatient(patientIds);
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
	 * 撤销疑似重复患者
	 * @param patientProfile
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/similar/patient/revoke",method=RequestMethod.GET)
	public TMsgResponse<Integer> revokeSimilarPatient(Long patientId,Locale locale) {
		TMsgResponse<Integer> tMsgResponse = new TMsgResponse<Integer>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = patientFollowupService.revokeSimilarPatient(patientId);
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
	
	@ResponseBody
	@RequestMapping(value="/similar/patient/merget/log/list",method=RequestMethod.POST)
	TMsgResponse<Page<OperationHistory>> operationHistoryList(@RequestBody TwiceSearchReq twiceSearchReq,Locale locale) {
		TMsgResponse<Page<OperationHistory>> tMsgResponse = new TMsgResponse<Page<OperationHistory>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			tMsgResponse.result = operationHistoryService.getList(twiceSearchReq);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		return tMsgResponse;
	}
	
	/**
	 * 获取符合随访任务查询的凝似重复患者列表
	 * @param locale
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/demand/might/repeat/patient/list",method=RequestMethod.GET)
	public TMsgResponse<Page<PatientSimpleInfo>> queryDemandMightRepeatPatientList(Locale locale, TwiceSearchReq req){
		TMsgResponse<Page<PatientSimpleInfo>> msg = new TMsgResponse<Page<PatientSimpleInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			Page<PatientSimpleInfo> result = this.patientFollowupService.queryDemandMightRepeatPatientList(req);
			if (result.getDataList() == null || result.getDataList().isEmpty()) {
				msg.respCode=ErrorMessage.E1404.code;
				msg.respMsg=messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
			msg.setResult(result);
		}catch(Exception e){
			e.printStackTrace();
			msg.respCode=ErrorMessage.E1417.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
