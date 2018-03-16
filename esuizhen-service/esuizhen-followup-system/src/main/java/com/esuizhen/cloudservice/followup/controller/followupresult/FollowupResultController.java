package com.esuizhen.cloudservice.followup.controller.followupresult;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDetailQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultHistoryQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultLogReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultStatisReq;
import com.esuizhen.cloudservice.followup.bean.TFollowupPhoneResultSearchInfo;
import com.esuizhen.cloudservice.followup.model.followup.TFollowupPlanDetialInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupResultLog;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultFeedbackStatisInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupResultLogService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupPhoneResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.esuizhen.cloudservice.followup.util.ExportExcel;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: FollowupResultController
 * @Description: 随访结果接口
 * @author raox
 * @date 2016年8月6日 上午11:03:33
 */
@Controller
@RequestMapping(value = "/result/")
public class FollowupResultController {
	@Autowired
	private FollowupSmsResultService followupSmsResultService;

	@Autowired
	private FollowupWxResultService followupWxResultService;

	@Autowired
	private FollowupPhoneResultService followupPhoneResultService;

	@Autowired
	private FollowupResultService followupResultService;
	
	@Autowired
	private FollowupResultLogService followupResultLogService;
	
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@ResponseBody
	@RequestMapping(value = "query", method = RequestMethod.POST)
	public TMsgResponse<Page> queryFollowupResultStatis(@RequestBody FollowupResultReq req, Locale locale) {
		Integer followupWay = req.getFollowupWay();
		if (followupWay == null) {
			throw new EmptyParamExcption("\"followupWay\" cannot be empty!");
		}
		String sql = organizationDoctorService.getDoctorIdSql(req.getOperator(), null);
		req.setSql(sql);
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 随访结果明细查看
			if (followupWay == 1) {
				msg.result = followupSmsResultService.queryFollowupResultStatis(req);
			} else {
				msg.result = followupWxResultService.queryFollowupResultStatis(req);
			}
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "detail/query", method = RequestMethod.POST)
	public TMsgResponse<Page> queryFollowupResultDetail(@RequestBody FollowupResultDetailQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			String sql = organizationDoctorService.getDoctorIdSql(req.getOperator(), null);
			req.setSql(sql);
			// 随访结果反馈明细查看
			if (req.getFollowupWay() == 1) {
				msg.result = followupSmsResultService.queryFollowupResultDetail(req);
			} else {
				msg.result = followupWxResultService.queryFollowupResultDetail(req);
			}

			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "statis", method = RequestMethod.POST)
	public TMsgResponse<TFollowupResultFeedbackStatisInfo> statisFollowupResult(@RequestBody FollowupResultStatisReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultFeedbackStatisInfo> msg = new TMsgResponse<TFollowupResultFeedbackStatisInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		TFollowupResultFeedbackStatisInfo followupResultFeedbackStatisInfo = new TFollowupResultFeedbackStatisInfo();
		try {
			// 随访结果反馈明细查看
			if (req.getFollowupWay() == 1) {
				followupResultFeedbackStatisInfo.setTotalCount(followupSmsResultService.statisFollowupResultTotal(req));
				followupResultFeedbackStatisInfo.setFollowupResultValueList(followupSmsResultService.statisFollowupResult(req));
			} else {
				followupResultFeedbackStatisInfo.setTotalCount(followupWxResultService.statisFollowupResultTotal(req));
				followupResultFeedbackStatisInfo.setFollowupResultValueList(followupWxResultService.statisFollowupResult(req));
			}
			msg.result = followupResultFeedbackStatisInfo;

			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "history/query", method = RequestMethod.GET)
	public TMsgResponse<Page> queryFollowupResultHistory(String followupTimeStart, String followupTimeEnd, Integer followupType, Integer followupWay, Integer followupResultValue,
			Long patientId, Integer page, Integer num, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 随访结果历史查询条件
			Map<String, Object> searchParams = new HashMap<String, Object>();
			searchParams.put("followupTimeStart", followupTimeStart);
			searchParams.put("followupTimeEnd", followupTimeEnd);
			searchParams.put("followupType", followupType);
			searchParams.put("followupWay", followupWay);
			searchParams.put("followupResultValue", followupResultValue);
			searchParams.put("patientId", patientId);
			// 随访结果历史
			msg.result = followupResultService.queryFollowupResultHistory(searchParams, page, num);

			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "formal/history/query", method = RequestMethod.GET)
	public TMsgResponse<Page> queryFollowupResultFormalHistory(FollowupResultHistoryQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			// 正式随访结果历史
			msg.result = followupResultService.queryFollowupResultFormalHistory(req);
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "phone/query", method = RequestMethod.POST)
	public TMsgResponse<Page> queryFollowupPhoneResult(@RequestBody TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			msg.result = followupPhoneResultService.queryFollowupPhoneResult(followupPhoneResultSearchInfo);

			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "phone/statis", method = RequestMethod.POST)
	public TMsgResponse<TFollowupResultFeedbackStatisInfo> statisFollowupPhoneResult(@RequestBody TFollowupPhoneResultSearchInfo followupPhoneResultSearchInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultFeedbackStatisInfo> msg = new TMsgResponse<TFollowupResultFeedbackStatisInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		TFollowupResultFeedbackStatisInfo followupResultFeedbackStatisInfo = new TFollowupResultFeedbackStatisInfo();
		try {
			followupResultFeedbackStatisInfo.setOperatorCount(followupPhoneResultService.statisFollowupOperatorTotal(followupPhoneResultSearchInfo));
			followupResultFeedbackStatisInfo.setTotalCount(followupPhoneResultService.statisFollowupPhoneResultTotal(followupPhoneResultSearchInfo));
			followupResultFeedbackStatisInfo.setFollowupResultValueList(followupPhoneResultService.statisFollowupPhoneResult(followupPhoneResultSearchInfo));
			msg.result = followupResultFeedbackStatisInfo;

			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@RequestMapping("/history/export/excel")
	public void exportFollowupResultHistory(HttpServletResponse response, String followupTimeStart, String followupTimeEnd, Integer followupType, Integer followupWay,
			Integer followupResultValue, Long patientId, Locale locale) throws IOException {
		ExportExcel<TFollowupResultDetailInfo> exportExcel = new ExportExcel<TFollowupResultDetailInfo>();

		// 随访结果历史查询条件
		Map<String, Object> searchParams = new HashMap<String, Object>();
		searchParams.put("followupTimeStart", followupTimeStart);
		searchParams.put("followupTimeEnd", followupTimeEnd);
		searchParams.put("followupType", followupType);
		searchParams.put("followupWay", followupWay);
		searchParams.put("followupResultValue", followupResultValue);
		searchParams.put("patientId", patientId);
		List<TFollowupResultDetailInfo> list = this.followupResultService.queryFollowupResultHistory(searchParams);

		String[] headers = messageSource.getMessage("followup.result.history.excel.header", null, locale).split(",");
		String[] fields = messageSource.getMessage("followup.result.history.excel.field", null, locale).split(",");
		String fileName = messageSource.getMessage("followup.result.history.excel.fileName", null, locale);
		response.setContentType("application/x-excel");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream out = response.getOutputStream();
		exportExcel.exportExcel(headers, fields, list, response.getOutputStream());
		out.close();
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :createFollowupResult
	 * @Description:随访结果提交接口
	 * @return TMsgResponse<String>
	 * @date 2016年9月26日 下午4:47:28
	 */
	@ResponseBody
	@RequestMapping(value="/submit", method = RequestMethod.POST)
	public TMsgResponse<String> createFollowupResult(@RequestBody FollowupResultReq req, Locale locale) {
		TMsgResponse<String> msg = new TMsgResponse<String>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			req.getFollowupTime();
			followupResultService.createFollowupResult(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setTocVarPatientFollowup
	 * @Description:设置患者的随访动态信息
	 * @return TMsgResponse<Object>
	 * @date 2016年10月29日 下午4:22:30
	 */
	@ResponseBody
	@RequestMapping(value="/var/patient/followup/update/toc", method = RequestMethod.POST)
	public TMsgResponse<Object> updateTocVarPatientFollowup(@RequestBody TFollowupResultDetailInfo req, Locale locale) {
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.setRespCode(ErrorMessage.SUCCESS.code);
		msg.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try{
			req.getFollowupTime();
			followupResultService.updateTocVarPatientFollowup(req);
		}catch(Exception e){
			msg.setRespCode(ErrorMessage.E1500.code);
			msg.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			LogUtil.logError.error(e.getMessage());
		}
		return msg;
	}
	

	
	/**
	 *	获取患者列表的最后一次随访结果
	 * @param locale
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/last/followup/result/query", method = RequestMethod.POST)
	public TMsgResponse<List<TFollowupResultDetailInfo>> queryLastFollowupResultList(Locale locale, @RequestBody List<PatientSimpleInfo> params) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<TFollowupResultDetailInfo>> msg = new TMsgResponse<List<TFollowupResultDetailInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			List<TFollowupResultDetailInfo> followupResultDetailInfos = this.followupResultService.queryLastFollowupResultList(params);
			if (followupResultDetailInfos == null || followupResultDetailInfos.isEmpty()) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}else{
				msg.setResult(followupResultDetailInfos);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 *	获取随访结果日志列表
	 * @param locale
	 * @param params
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "log/list", method = RequestMethod.POST)
	public TMsgResponse<Page> queryFollowupResultLog (Locale locale, @RequestBody FollowupResultLogReq req) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page> msg = new TMsgResponse<Page>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			Page<TFollowupResultLog> log=  this.followupResultLogService.queryFollowupResultLog(req);
			msg.result=log;
			if (msg.result == null) {
				msg.respCode = ErrorMessage.E1404.code;
				msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
			}
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年8月22日
	* @param 
	* @description:更新随访结果（问卷用）
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "update/toc", method = RequestMethod.POST)
	public TMsgResponse<Object> setFollowupResultToC (Locale locale, @RequestBody TFollowupResultDetailInfo followupResultBuff) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try {
			followupResultService.updateFollowupResultToC(followupResultBuff);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	/**
	* @author fanpanwei
	* @date 2017年8月22日
	* @param 
	* @description:估算死亡时间接口（问卷用）
	* @return
	 */
	@ResponseBody
	@RequestMapping(value="guess/death/date" , method=RequestMethod.POST)
	public TMsgResponse<Date> modifyFollowupPlanDetail(@RequestBody TFollowupResultDetailInfo followupResult,Locale locale)
	{
		//设置返回成功代码及提示消息
		TMsgResponse<Date> msg = new TMsgResponse<Date>();
		msg.respCode=ErrorMessage.SUCCESS.code;
		msg.respMsg=messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
		try
		{
			if(followupResult!=null)
			msg.result=followupResultService.guessDeathDate(followupResult.getDeathDate(), followupResult.getPatientId());
		}catch(Exception ex)
		{
			//设置错误代码及提示消息
			msg.respCode=ErrorMessage.E1500.code;
			msg.respMsg=messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
}
