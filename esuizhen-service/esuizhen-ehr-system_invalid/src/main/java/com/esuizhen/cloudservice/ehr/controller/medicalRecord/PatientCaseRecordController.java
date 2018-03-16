package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

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
import com.esuizhen.cloudservice.ehr.bean.GenenalExamSignsInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.AdverseReactionResultInfo;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PatientCaseRecordService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class PatientCaseRecordController {

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private PatientCaseRecordService patientCaseRecordService;
	
	/**
	 * 查询常规体检与体征
	 * @param req
	 */
	@ResponseBody
	@RequestMapping(value="/patient/genenal/exam/signs/info/query" , method=RequestMethod.POST)
	public TMsgResponse<GenenalExamSignsInfo> queryGenenalExamSignsInfo(@RequestBody AttendPatientReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<GenenalExamSignsInfo> msg = new TMsgResponse<GenenalExamSignsInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = patientCaseRecordService.queryGenenalExamSignsInfo(req);
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
	 * 保存常规体检与体征
	 * @param genenalExamSigns
	 */
	@ResponseBody
	@RequestMapping(value="/patient/genenal/exam/signs/info/save",method=RequestMethod.POST)
	public TMsgResponse<Object> saveGenenalExamSignsInfo(@RequestBody GenenalExamSignsInfo info,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientCaseRecordService.saveGenenalExamSignsInfo(info);
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
	
	/**
	 * 查询身体状态评分
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/patient/qualityoflife/info/query" , method=RequestMethod.POST)
	public TMsgResponse<QualityoflifeInfo> queryQualityoflifeInfo(@RequestBody AttendPatientReq req, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<QualityoflifeInfo> msg = new TMsgResponse<QualityoflifeInfo>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			//查询
			msg.result = patientCaseRecordService.queryQualityoflifeInfo(req);
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
	 * 保存身体状态评分
	 * @param qualityoflifeInfo
	 */
	@ResponseBody
	@RequestMapping(value="/patient/qualityoflife/info/save",method=RequestMethod.POST)
	public TMsgResponse<Object> saveQualityoflifeInfo(@RequestBody QualityoflifeInfo info,Locale locale){
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			patientCaseRecordService.saveQualityoflifeInfo(info);
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
			msg.result = patientCaseRecordService.queryAdverseReactionResult(req);
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
			patientCaseRecordService.saveAdverseReactionResult(infoList);
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
