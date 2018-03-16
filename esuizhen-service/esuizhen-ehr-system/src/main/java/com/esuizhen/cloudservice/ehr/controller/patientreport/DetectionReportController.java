package com.esuizhen.cloudservice.ehr.controller.patientreport;

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

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.ehr.bean.TDetectionReportDetailInfo;
import com.esuizhen.cloudservice.ehr.model.detection.DetectionReport;
import com.esuizhen.cloudservice.ehr.service.patientreport.DetectionReportService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class DetectionReportController {
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private DetectionReportService detectionReportService;
	
	/**
	* @author fanpanwei
	* @date 2017年3月31日
	* @param 
	* @description
	* @return
	 */
	@ResponseBody
	@RequestMapping(value="/detection/report/detail/save" , method=RequestMethod.POST)
	public TMsgResponse<List<TDetectionReportDetailInfo>> saveDetectionReportDetail( @RequestBody List<TDetectionReportDetailInfo> tDetailInfoList, Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<List<TDetectionReportDetailInfo>> msg = new TMsgResponse<List<TDetectionReportDetailInfo>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			List<TDetectionReportDetailInfo> resultList = detectionReportService.saveDetectionReportDetailList(tDetailInfoList);
			 msg.setResult(resultList);
		}catch(Exception ex)
		{
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 获取检验结果列表
	 * @author fanpanwei
	 * @title :addPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2017年04月01日 上午9:03:26
	 */
	@ResponseBody
	@RequestMapping(value="/detection/specify/report/list",method=RequestMethod.POST)
	public TMsgResponse<List<DetectionReport>> getDetectionReportList(@RequestBody Patient patient,Locale locale){
		TMsgResponse<List<DetectionReport>> msg = new TMsgResponse<List<DetectionReport>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			if(patient==null)throw new Exception("patientId是空");
			Long patientId = patient.getPatientId();
			List<DetectionReport> detectionReportList = detectionReportService.getDetectionReportList(patientId);
			msg.setResult(detectionReportList);
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
		}
		return msg;
	}
	
	/**
	 * 获取检验报告详情
	 * @author fanpanwei
	 * @title :addPatientDiagnosis
	 * @Description:TODO
	 * @return TMsgResponse<Object>
	 * @date 2017年04月01日 上午9:03:26
	 */
	@ResponseBody
	@RequestMapping(value="/detection/specify/report/detail",method=RequestMethod.POST)
	public TMsgResponse<Map<String, Object>> getDetectionReportDetail(@RequestBody TDetectionReportDetailInfo detailInfo,Locale locale){
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try{
			if(detailInfo==null||StringUtils.isBlank(detailInfo.getDetectionReportId()))throw new Exception("detectionReportId is null");
			String detectionReportId = detailInfo.getDetectionReportId();
			Map<String, Object> detectionReport = detectionReportService.getSpecifyDetectionReport(detectionReportId);
			msg.setResult(detectionReport);
		}catch(Exception ex){
			LogUtil.logError.error(ex.getCause()+"\t"+ex.getMessage());
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
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
			msg.result = detectionReportService.getDetectionReportDetail(reportId);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1400.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1400.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
