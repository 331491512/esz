/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.controller.report;<br/>  
 * <b>文件名：</b>InspectionReport.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月3日上午9:41:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.controller.report;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.service.report.InspectionReportService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: InspectionReport
* @Description: 检查报告相关
* @author lichenghao
* @date 2016年5月3日 上午9:41:10  
*/
@Controller
public class InspectionReportController {
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private InspectionReportService inspectionReportService;
	
	/**
	 * 检查结果列表
	 * @author lichenghao
	 * @title :getHospitalsOfPatientList
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月3日 下午4:04:54
	 */
	@RequestMapping(value="/inspection/report/list", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> getInspectionResultList(Long patientId,Integer hospitalId,Integer resultFlag,Integer sortFlag,Integer page,Integer num,Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = inspectionReportService.getInspectionResultList(patientId,hospitalId,resultFlag,sortFlag,page,num);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 检验报告详情
	 * @author lichenghao
	 * @title :getDetectionReportDetail
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月3日 下午4:08:54
	 */
	@RequestMapping(value="/detection/report/detail", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> getDetectionReportDetail(String reportId,Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = inspectionReportService.getDetectionReportDetail(reportId);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 检查报告详情
	 * @author lichenghao
	 * @title :getExamReportDetail
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2016年5月3日 下午4:09:07
	 */
	@RequestMapping(value="/exam/report/detail", method=RequestMethod.GET)
	@ResponseBody
	public TMsgResponse<Object> getExamReportDetail(String reportId,Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			msg.result = inspectionReportService.getExamReportDetail(reportId);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
