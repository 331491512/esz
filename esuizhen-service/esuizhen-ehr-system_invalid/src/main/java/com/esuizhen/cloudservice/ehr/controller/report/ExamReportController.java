package com.esuizhen.cloudservice.ehr.controller.report;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.TExamReportListReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.ExamReport;
import com.esuizhen.cloudservice.ehr.service.report.ExamReportService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class ExamReportController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private ExamReportService examReportService;
	
	@RequestMapping(value="/exam/report/list", method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Page<ExamReport>> getExamReportList(@RequestBody TExamReportListReq req,Locale locale) {
		TMsgResponse<Page<ExamReport>> msg = new TMsgResponse<Page<ExamReport>>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = examReportService.getExamReportList(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value="/exam/report/add",method=RequestMethod.POST)
	public TMsgResponse<List<ExamReport>> addExamReport(@RequestBody List<ExamReport> req,Locale locale){
		TMsgResponse<List<ExamReport>> msg = new TMsgResponse<List<ExamReport>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			msg.result=examReportService.batchAddExamReport(req);
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
