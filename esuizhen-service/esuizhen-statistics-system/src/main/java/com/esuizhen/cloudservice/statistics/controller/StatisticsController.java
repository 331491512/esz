package com.esuizhen.cloudservice.statistics.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.statistics.bean.PatientSpreadReq;
import com.esuizhen.cloudservice.statistics.bean.SurvivalRateReq;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultSpread;
import com.esuizhen.cloudservice.statistics.bean.TFollowupSpread;
import com.esuizhen.cloudservice.statistics.service.StatisticsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class StatisticsController {
	/**
	 * 消息服务
	 */
	@Autowired
	private StatisticsService statisticsService;
	
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * 生存率
	 * @author lichenghao
	 * @title :calculateSurvivalRate
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年4月6日 下午6:14:51
	 */
	@ResponseBody
	@RequestMapping(value="/survival",method=RequestMethod.POST)
	public TMsgResponse<Object> calculateSurvivalRate(@RequestBody SurvivalRateReq req,Locale locale) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		try {
			msgResponse.setResult(statisticsService.calculateSurvivalRate(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
		}
		return msgResponse;
	}
	
	
	/**
	 * 患者概要信息统计
	 * @author lichenghao
	 * @title :calculatePatientSpread
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年4月7日 上午10:18:00
	 */
	@ResponseBody
	@RequestMapping(value="/patient",method=RequestMethod.POST)
	public TMsgResponse<Object> calculatePatientSpread(@RequestBody PatientSpreadReq req,Locale locale) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		try {
			msgResponse.setResult(statisticsService.calculatePatientSpread(req));
			msgResponse.setRespCode(0);
			msgResponse.setRespMsg("success");
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause()+"/t"+e.getMessage());
			msgResponse.setRespCode(ErrorMessage.SUCCESS.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));	
		}
		return msgResponse;
	}
	
	@ResponseBody
	@RequestMapping(value="/followup/report/check/send",method=RequestMethod.GET)
	public TMsgResponse<Object> followupReportCheckSend(Locale locale) {
		TMsgResponse<Object> msgResponse = new TMsgResponse<Object>();
		msgResponse.setRespCode(0);
		msgResponse.setRespMsg("success");
		try {
			statisticsService.checkFollowReportApply();
		} catch (Exception e) {
			msgResponse.setRespCode(ErrorMessage.E1500.code);
			msgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
		}
		return msgResponse;
	}
	
	/**
	 * 随访进度统计-医生空间
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/followup/progressively/statistics",method=RequestMethod.POST)
	public TMsgResponse<TFollowupSpread> statisticsFollowupProgressively(@RequestBody PatientSpreadReq req,Locale locale) {
		TMsgResponse<TFollowupSpread> msg=new TMsgResponse<TFollowupSpread>();
		try {
			msg.result=statisticsService.statisticsFollowupProgressively(req);
			msg.setRespCode(ErrorMessage.SUCCESS.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage(),e);
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 统计患者末次有效随访结果
	 * @param req
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/last/effective/followup/result/statistics",method=RequestMethod.POST)
	public TMsgResponse<TFollowupResultSpread> statisticsLastEffectiveFollowupResult(@RequestBody PatientSpreadReq req,Locale locale) {
		TMsgResponse<TFollowupResultSpread> msg=new TMsgResponse<TFollowupResultSpread>();
		try {
			msg.result=statisticsService.statisticsLastEffectiveFollowupResult(req);
			msg.setRespCode(ErrorMessage.SUCCESS.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage(),e);
			msg.setRespCode(ErrorMessage.E1500.getCode());
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			msg.setErrorDesc(e.getMessage());
		}
		return msg;
	}
	
	public static void main(String[] args) {
		for(int i=1;i<=20;i++){
			System.out.print("\""+i*3+"\",");
		}
	}
}
