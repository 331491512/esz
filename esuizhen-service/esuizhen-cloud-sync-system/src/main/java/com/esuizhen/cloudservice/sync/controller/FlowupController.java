package com.esuizhen.cloudservice.sync.controller;

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
/**
 * 
* @ClassName: FlowupController 
* @Description: 随访同步 
* @author LIPENG
* @date 2016年2月1日 下午8:40:50 
*
 */
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.service.CloudMedcalPostSerivceService;
import com.esuizhen.cloudservice.sync.service.CloudReviewOrderService;
import com.esuizhen.cloudservice.sync.service.FlowupService;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.esuizhen.cloudservice.sync.service.QuestionnaireService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.DuplicateRecordExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class FlowupController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	FlowupService flowupService;
	@Autowired
	PatientService patientService;
	@Autowired
	CloudReviewOrderService reviewOrderService;
	@Autowired
	CloudMedcalPostSerivceService cloudMedcalPostSerivceService;
	
	@Autowired
	QuestionnaireService questionnaireService;
	
	/**
	 * 
	* @Title: syncFollowupResult 
	* @Description: B端到C端同步 
	* @param @param result
	* @param @return    设定文件 
	* @return TMsgResponse<Map<String,String>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/tocloud/followupresult", method=RequestMethod.POST)
	public TMsgResponse<Map<String, String>> syncFollowupResult(Locale locale, @RequestBody TPatientFollowupResultDetailInfo result)
	{
		LogUtil.log.debug("syncFollowupResult()==========>>>>>>>>>>");
		TMsgResponse<Map<String, String>> tMsgResponse = new TMsgResponse<Map<String, String>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Map<String, String> map = new HashMap<String, String>();
			String rid = flowupService.syncB2CResultRecord(result);
			map.put("followupResultId", rid);
			tMsgResponse.setResult(map);
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg=result==null?"calling method syncFollowupResult;paramater:result is null":"云端未开启三通的医院Id:"+result.getHospitalId();
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (DuplicateRecordExcption de) {
			LogUtil.logError.error(de.getCause() + "\t" + de.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1420.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(de.getCause() + "\t" + de.getMessage());
			tMsgResponse.setErrorDesc(de.getMessage());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.debug("syncFollowupResult()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	* @Title: syncFollowupResultFromCloud 
	* @Description: C端到B端同步随访结果 
	* @param @param hospitalId
	* @param @return    设定文件 
	* @return TMsgResponse<List<TPatientFollowupResultDetailInfo>>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/fromcloud/followupresult", method=RequestMethod.GET)
	public TMsgResponse<List<TPatientFollowupResultDetailInfo>> syncFollowupResultFromCloud(Locale locale, Integer hospitalId, Integer page, Integer num){
		LogUtil.log.debug("syncFollowupResultFromCloud()==========>>>>>>>>>>");
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1 || num > 200) {
			num = 100;
		}
		TMsgResponse<List<TPatientFollowupResultDetailInfo>> tMsgResponse = new TMsgResponse<List<TPatientFollowupResultDetailInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			Page<TPatientFollowupResultDetailInfo> pageData = flowupService.syncFollowupResultFromCloud(hospitalId, page, num);
			if (pageData.getCurrPage() == pageData.getTotalPage() ||
					pageData.getCurrPage() == pageData.getTotalPage() - 1) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.code);
				tMsgResponse.setRespMsg("Complete synchronization!");
			}
			tMsgResponse.setResult(pageData.getDataList());
		} catch(HospitalWithoutRightExcption hx){
			String returnMsg="云端未开启三通的医院Id:"+hospitalId;
			LogUtil.logError.error(returnMsg);
			tMsgResponse.setRespCode(ErrorMessage.E1406.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1406.info, null, locale));
			tMsgResponse.setErrorDesc(returnMsg);
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.debug("syncFollowupResultFromCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
	
	/**
	 * 
	* @Title: syncResultNotifyToCloud 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @return    设定文件 
	* @return TMsgResponse<String>    返回类型 
	* @throws
	 */
	@ResponseBody
	@RequestMapping(value="/tocloud/result/notify", method=RequestMethod.POST)
	public TMsgResponse<String> syncResultNotifyToCloud(Locale locale, @RequestBody TSyncResultNotify notify)
	{
		LogUtil.log.info("syncResultNotifyToCloud()==========>>>>>>>>>>");
		TMsgResponse<String> tMsgResponse = new TMsgResponse<String>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.code);
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			if (TSyncResultNotify.resultType.resultTypeFlowup.ordinal() == notify.getResultType()) {//1:随访
				this.flowupService.setSyncedFlag4Uuids(notify);
			} else if (TSyncResultNotify.resultType.resultTypeWeixin.ordinal() == notify.getResultType()){//2:微信
				this.patientService.setWeixinSyncedFlag4Uuids(notify);
			}else if(TSyncResultNotify.resultType.resultTypeProductApply.ordinal() == notify.getResultType()){//3:服务申请
				this.cloudMedcalPostSerivceService.setMedicalPostSyncedFlag(notify);
			}else if(TSyncResultNotify.resultType.questionnaireResultId.ordinal() == notify.getResultType()) {
				questionnaireService.setQuestionnaireResultSyncFlag(notify);
			}
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			//msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setRespMsg(ex.getCause() + "\t" + ex.getMessage());
			tMsgResponse.setErrorDesc(ex.getMessage());
		}
		LogUtil.log.info("syncResultNotifyToCloud()==========<<<<<<<<<<");
		return tMsgResponse;
	}
}
