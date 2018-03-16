package com.esuizhen.cloudservice.ehr.controller.medicalRecord;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.ehr.bean.PatientReportResp;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PatientReportService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: PatientReportController
 * @Description: 检查检验
 * @author zhuguo
 * @date 2017-5-31 10:31:03
 */
@Controller
public class PatientReportController {

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@Autowired
	private PatientReportService patientReportService;

	/**
	 * 最近三个月检查检验列表
	 * 
	 * @author zhuguo
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/report/list/new", method = RequestMethod.POST)
	public TMsgResponse<Page<PatientReportResp>> getNewReportList(
			@RequestBody PatientReportResp resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<PatientReportResp>> msg = new TMsgResponse<Page<PatientReportResp>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = patientReportService.getNewReportList(resp);

			// 如果为空
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info,
						null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	/**
	 * 三个月前检查检验列表
	 * 
	 * @author zhuguo
	 * @param resp
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/report/list/more", method = RequestMethod.POST)
	public TMsgResponse<Page<PatientReportResp>> getMoreReportList(
			@RequestBody PatientReportResp resp, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<PatientReportResp>> msg = new TMsgResponse<Page<PatientReportResp>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null,
				locale);
		try {
			msg.result = patientReportService.getMoreReportList(resp);

			// 如果为空
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info,
						null, locale);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info,
					null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
