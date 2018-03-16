/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.controller.user;<br/>  
 * <b>文件名：</b>LISResportController.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年8月14日下午4:03:23<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.controller.user;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.business.bean.ReportPatientStatisLiistGetReq;
import com.esuizhen.cloudservice.business.bean.TMsgResponse;
import com.esuizhen.cloudservice.business.bean.TReportPatientStatiesDetailInfo;
import com.esuizhen.cloudservice.business.service.user.LISReportServer;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.util.LogUtil;

/** 
* @ClassName: LISResportController
* @Description: 
* @author lichenghao
* @date 2017年8月14日 下午4:03:23  
*/
@Controller
public class LISResportController {
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private LISReportServer lisReportServer;
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendPatientRepostToDoctor
	 * @Description:发送开单医生的报告患者数统计
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月14日 下午4:54:23
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/lis/report/to/doctor/send", method = RequestMethod.GET)
	public TMsgResponse<Map<String, Object>> sendPatientRepostToDoctor(Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			lisReportServer.sendPatientReportToDoctor();
		} catch (Exception e) {
			e.printStackTrace();
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getReportPatientStatisList
	 * @Description:获取统计检查检验报告的患者列表
	 * @return TMsgResponse<Page<TitemInfo>>
	 * @date 2017年8月14日 下午4:55:01
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/report/patient/statis/list/get", method = RequestMethod.GET)
	public TMsgResponse<Page<TReportPatientStatiesDetailInfo>> getReportPatientStatisList(ReportPatientStatisLiistGetReq req,Locale locale) {
		TMsgResponse<Page<TReportPatientStatiesDetailInfo>> msg = new TMsgResponse<Page<TReportPatientStatiesDetailInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result=lisReportServer.getReportPatientStatisList(req);
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1404.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}catch (Exception e) {
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :sendPatientRepost
	 * @Description:推送患者报告
	 * @return TMsgResponse<Map<String,Object>>
	 * @date 2017年8月17日 下午3:37:32
	 */
	@ResponseBody
	@RequestMapping(value = "/patient/exam/detection/report/send", method = RequestMethod.GET)
	public TMsgResponse<Map<String, Object>> sendPatientRepost(Locale locale) {
		TMsgResponse<Map<String, Object>> msg = new TMsgResponse<Map<String, Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			lisReportServer.sendPatientReport();
		} catch (Exception e) {
			e.printStackTrace();
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
}
