package com.esuizhen.cloudservice.followup.controller.followupdo;

import java.util.Date;
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

import com.esuizhen.cloudservice.followup.bean.FollowupMsgResultRes;
import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPhoneCallIncomingQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDeleteReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsInvalidSetReq;
import com.esuizhen.cloudservice.followup.bean.FollowupSmsSendReq;
import com.esuizhen.cloudservice.followup.bean.QualityoflifeReq;
import com.esuizhen.cloudservice.followup.model.followupdo.FollowupPhonePatientPageTurnQueryReq;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallIncomingInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallStatusInfo;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupSmsReqInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TPatientContactInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupCallIncomingService;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupCallReqService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupPhoneResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupQualityoflifeResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupSmsResultService;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupWxResultService;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.sms.SmsSendReportInfo;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.util.LogUtil;

@Controller
@RequestMapping(value = "/do/")
public class FollowupDoController {
	@Autowired
	private FollowupResultService followupResultService;

	@Autowired
	private FollowupPhoneResultService followupPhoneResultService;
	
	@Autowired
	private FollowupQualityoflifeResultService followupQualityoflifeResultService;

	@Autowired
	private FollowupWxResultService followupWxResultService;

	@Autowired
	private FollowupSmsResultService followupSmsResultService;

	@Autowired
	private FollowupCallReqService followupCallReqService;

	@Autowired
	private FollowupCallIncomingService followupCallIncomingService;

	/**
	 * 消息资源
	 */
	@Autowired
	private MessageSource messageSource;

	@ResponseBody
	@RequestMapping(value = "phone/patient/page/turn/query", method = RequestMethod.POST)
	public TMsgResponse<TFollowupResultDetailInfo> queryFollowupPhonePatientPageTurn(@RequestBody FollowupPhonePatientPageTurnQueryReq followupPhonePatientPageTurnQueryReq,
			Locale locale) {
		Date date = null;
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupPhoneResultService.queryFollowupPhonePatientPageTurn(followupPhonePatientPageTurnQueryReq);

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
	@RequestMapping(value = "phone/call/status/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupPhoneCallStatus(@RequestBody TFollowupPhoneCallStatusInfo followupPhoneCallStatusInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupCallReqService.insertFollowupCallReq(followupPhoneCallStatusInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "phone/result/temp/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupPhoneResultTemp(@RequestBody TFollowupResultDetailInfo followupResultDetailInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupPhoneResultService.saveFollowupPhoneResultTemp(followupResultDetailInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "phone/result/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupPhone(@RequestBody TFollowupResultDetailInfo followupResultDetailInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupPhoneResultService.saveFollowupPhone(followupResultDetailInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "qualityoflife/result/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupQualityoflife(@RequestBody QualityoflifeReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupQualityoflifeResultService.saveFollowupQualityoflife(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	@ResponseBody
	@RequestMapping(value = "result/save", method = RequestMethod.POST)
	public TMsgResponse saveFollowupResult(@RequestBody TFollowupResultDetailInfo followupResultDetailInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupResultService.saveFollowupResult(followupResultDetailInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "result/delete", method = RequestMethod.POST)
	public TMsgResponse deleteFollowupResult(@RequestBody FollowupResultDeleteReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupResultService.deleteFollowupResult(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "wx/send", method = RequestMethod.POST)
	public TMsgResponse<FollowupMsgResultRes> sendWxFollowup(@RequestBody FollowupMsgSendReq followupMsgSendReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupMsgResultRes> msg = new TMsgResponse<FollowupMsgResultRes>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {

			msg.result=followupWxResultService.sendSpecifyWxFollowup(followupMsgSendReq);

		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "wx/mass/send", method = RequestMethod.POST)
	public TMsgResponse<FollowupMsgResultRes> sendWxMassFollowup(@RequestBody FollowupMsgSendReq followupMsgSendReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupMsgResultRes> msg = new TMsgResponse<FollowupMsgResultRes>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupWxResultService.sendWxMassFollowup(followupMsgSendReq);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "sms/send", method = RequestMethod.POST)
	public TMsgResponse<FollowupMsgResultRes> sendSmsFollowup(@RequestBody FollowupMsgSendReq followupMsgSendReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupMsgResultRes> msg = new TMsgResponse<FollowupMsgResultRes>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupSmsResultService.sendSpecifySmsFollowup(followupMsgSendReq);
		}catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}

		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "sms/mass/send", method = RequestMethod.POST)
	public TMsgResponse<FollowupMsgResultRes> sendSmsMassFollowup(@RequestBody FollowupMsgSendReq followupMsgSendReq, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<FollowupMsgResultRes> msg = new TMsgResponse<FollowupMsgResultRes>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupSmsResultService.sendSmsMassFollowup(followupMsgSendReq);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "sms/reply/list", method = RequestMethod.POST)
	public TMsgResponse<Page<TFollowupSmsReqInfo>> queryFollowupSmsReply(@RequestBody FollowupSmsSendReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupSmsReqInfo>> msg = new TMsgResponse<Page<TFollowupSmsReqInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupSmsResultService.queryFollowupSmsReply(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "sms/send/state/receipt", method = RequestMethod.POST)
	public TMsgResponse receiptSmsSendState(@RequestBody Map<String, List<SmsSendReportInfo>> data, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse msg = new TMsgResponse();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			List<SmsSendReportInfo> smsSendReportInfoList = data.get("data");
			if (UtilValidate.isNotEmpty(smsSendReportInfoList)) {
				followupSmsResultService.receiptSmsSendState(smsSendReportInfoList);
			} else {
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
	@RequestMapping(value = "sms/reply/process", method = RequestMethod.POST)
	public TMsgResponse<TFollowupResultDetailInfo> processFollowupSmsReply(@RequestBody TFollowupResultDetailInfo followupResultDetailInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupSmsResultService.processFollowupSmsReply(followupResultDetailInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "sms/invalid/set", method = RequestMethod.POST)
	public TMsgResponse<TFollowupResultDetailInfo> setInvalidSmsFollowup(@RequestBody FollowupSmsInvalidSetReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupSmsResultService.setInvalidSmsFollowup(req.getReqId());
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "/user/contact/phone/status/modify", method = RequestMethod.GET)
	public TMsgResponse<TFollowupResultDetailInfo> modifyUserContactPhoneStatus(TPatientContactInfo patientContactInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupSmsResultService.modifyUserContactPhoneStatus(patientContactInfo);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "patient/needless/set", method = RequestMethod.GET)
	public TMsgResponse<TFollowupResultDetailInfo> setFollowupNeedless(Long patientId,Integer searchId,Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupResultService.setFollowupNeedless(patientId,searchId);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "scanAllReply", method = RequestMethod.GET)
	public TMsgResponse scanAllReply(Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupResultDetailInfo> msg = new TMsgResponse<TFollowupResultDetailInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			followupWxResultService.scanWxReply();
			followupResultService.scanSmsReply();
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "phone/call/incoming/query", method = RequestMethod.POST)
	public TMsgResponse<Page<TFollowupPhoneCallIncomingInfo>> queryPhoneCallIncoming(@RequestBody FollowupPhoneCallIncomingQueryReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Page<TFollowupPhoneCallIncomingInfo>> msg = new TMsgResponse<Page<TFollowupPhoneCallIncomingInfo>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = this.followupCallIncomingService.queryFollowupCallIncoming(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1417.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value = "phone/call/incoming/save", method = RequestMethod.POST)
	public TMsgResponse<TFollowupPhoneCallIncomingInfo> savePhoneCallIncoming(@RequestBody TFollowupPhoneCallIncomingInfo followupPhoneCallIncomingInfo, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<TFollowupPhoneCallIncomingInfo> msg = new TMsgResponse<TFollowupPhoneCallIncomingInfo>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = this.followupCallIncomingService.insertFollowupCallIncoming(followupPhoneCallIncomingInfo);
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
	* @date 2017年7月4日
	* @param 
	* @description:查询随访短信答复记录
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "sms/record/query", method = RequestMethod.POST)
	public TMsgResponse<List<HashMap<String,String>>> queryFollowupSmsReplyRecords(@RequestBody FollowupSmsSendReq req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<List<HashMap<String,String>>> msg = new TMsgResponse<List<HashMap<String,String>>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupSmsResultService.queryFollowupSmsRecord(req);
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
	* @date 2017年7月4日
	* @param 
	* @description:获取指定随访任务的短信回复的buff记录
	* @return
	 */
	@ResponseBody
	@RequestMapping(value = "sms/followup/buff/query", method = RequestMethod.POST)
	public TMsgResponse<HashMap<String,Object>> queryFollowupBuffBySms(@RequestBody TFollowupSmsReqInfo req, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<HashMap<String,Object>> msg = new TMsgResponse<HashMap<String,Object>>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupSmsResultService.queryFollowupBuffBySms(req);
		} catch (Exception ex) {
			// 设置错误代码及提示消息
			msg.respCode = ErrorMessage.E1500.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1500.info, null, locale);
			LogUtil.logError.error(ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 修改来电患者的状态
	 * @author zhuguo
	 * @date 2017-8-9 17:40:45
	 * @param patientId
	 * @param taskId
	 * @param callIncomingPhone
	 * @param locale
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "phone/call/incoming/state", method = RequestMethod.GET)
	public TMsgResponse<Integer> patienPhoneCallIncomingStateModify(String incomingCallId, Locale locale) {
		// 设置返回成功代码及提示消息
		TMsgResponse<Integer> msg = new TMsgResponse<Integer>();
		msg.respCode = ErrorMessage.SUCCESS.code;
		msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);

		try {
			msg.result = followupCallIncomingService.patienPhoneCallIncomingStateModify(incomingCallId);
			if (msg.result == 0) {
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
}
