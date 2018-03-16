package com.esuizhen.cloudservice.statistics.controller;

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

import com.esuizhen.cloudservice.statistics.bean.FollowupPatientStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsReq;
import com.esuizhen.cloudservice.statistics.bean.FollowupScheduleStatisticsResult;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TDailyGainPatient;
import com.esuizhen.cloudservice.statistics.bean.TFollowupProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TFollowupResultStatistics;
import com.esuizhen.cloudservice.statistics.bean.TFollowupWayProgressInfo;
import com.esuizhen.cloudservice.statistics.bean.TStatisticResultInfo;
import com.esuizhen.cloudservice.statistics.service.FollowupStatisticsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.util.LogUtil;

@Controller
public class FollowupStatisticsController {
	/**
	 * 消息服务
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private FollowupStatisticsService followupStatisticsService;

	/**
	 * <p>
	 * Title:statisticsFollowupProgress
	 * </p>
	 * <p>
	 * Description:统计随访进展情况，各个随访任务的分布情况
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年8月8日 下午5:00:16
	 * @param locale
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/progress/statistics", method = RequestMethod.GET)
	public TMsgResponse<TFollowupProgressInfo> statisticsFollowupProgress(Locale locale, String followupTaskId,
			String followupAssignId, Long userId) {
		TMsgResponse<TFollowupProgressInfo> tMsgResponse = new TMsgResponse<TFollowupProgressInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TFollowupProgressInfo followupProgressInfo = this.followupStatisticsService
					.statisticsFollowupProgress(followupTaskId, followupAssignId, userId);
			if (followupProgressInfo == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(followupProgressInfo);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/followup/result/statistics", method = RequestMethod.GET)
	public TMsgResponse<List<TFollowupResultStatistics>> statisticsFollowupResult(Locale locale, String followupTaskId,
			String followupAssignId, Long userId) {
		TMsgResponse<List<TFollowupResultStatistics>> tMsgResponse = new TMsgResponse<List<TFollowupResultStatistics>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TFollowupResultStatistics> followupResultStatistics = this.followupStatisticsService
					.statisticsFollowupResult(followupTaskId, followupAssignId, userId);
			if (followupResultStatistics == null || followupResultStatistics.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(followupResultStatistics);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>
	 * Title:statisticsFollowupWayProgress
	 * </p>
	 * <p>
	 * Description:统计随访方式分布情况
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年8月10日 下午4:21:18
	 * @param locale
	 * @param followupTaskId
	 * @param followupAssignId
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/way/statistics", method = RequestMethod.GET)
	public TMsgResponse<List<TFollowupWayProgressInfo>> statisticsFollowupWayProgress(Locale locale,
			String followupTaskId, String followupAssignId, Long userId) {
		TMsgResponse<List<TFollowupWayProgressInfo>> tMsgResponse = new TMsgResponse<List<TFollowupWayProgressInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TFollowupWayProgressInfo> followupWayProgressInfos = this.followupStatisticsService
					.statisticsFollowupWayProgress(followupTaskId, followupAssignId, userId);
			if (followupWayProgressInfos == null || followupWayProgressInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(followupWayProgressInfos);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	@ResponseBody
	@RequestMapping(value = "/follow/lost", method = RequestMethod.GET)
	public TMsgResponse<List<Map<String, Object>>> statisticsLostFollowPatient(Locale locale, Integer allFlag, Long doctorId) {
		TMsgResponse<List<Map<String, Object>>> tMsgResponse = new TMsgResponse<List<Map<String, Object>>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<Map<String, Object>> result = this.followupStatisticsService.statisticsLostFollowPatient(allFlag, doctorId);
			if (result == null || result.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(result);
			}
		} catch (InsufficientParameterExcption e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>
	 * Title:statisticsDailyGainPatientList
	 * </p>
	 * <p>
	 * Description:统计每日新增患者信息，及患者信息变化总数
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年8月11日 上午10:26:33
	 * @param locale
	 * @param commonParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/daily/gain/patient/statistics", method = RequestMethod.POST)
	public TMsgResponse<TDailyGainPatient> statisticsDailyGainPatientList(Locale locale,
			@RequestBody TCommonParam commonParam) {
		TMsgResponse<TDailyGainPatient> tMsgResponse = new TMsgResponse<TDailyGainPatient>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TDailyGainPatient dailyGainPatient = this.followupStatisticsService
					.statisticsDailyGainPatientList(commonParam);
			if (dailyGainPatient == null) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(dailyGainPatient);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>
	 * Title:statisticsFollowupWayProgress
	 * </p>
	 * <p>
	 * Description:分别通过按科室、按随访人员、按病种统计随访工作量
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年8月10日 下午6:15:34
	 * @param locale
	 * @param commonParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/workload/statistics", method = RequestMethod.POST)
	public TMsgResponse<TStatisticResultInfo> statisticsFollowupWorkload(Locale locale,
			@RequestBody TCommonParam commonParam) {
		TMsgResponse<TStatisticResultInfo> tMsgResponse = new TMsgResponse<TStatisticResultInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			TStatisticResultInfo statisticResultInfo = this.followupStatisticsService
					.statisticsFollowupWorkload(commonParam);
			if (statisticResultInfo == null || statisticResultInfo.getValues() == null
					|| statisticResultInfo.getValues().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}
			tMsgResponse.setResult(statisticResultInfo);
		} catch(InsufficientParameterExcption e){
			tMsgResponse.setRespCode(ErrorMessage.E1403.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1403.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	/**
	 * <p>
	 * Title:statisticsFollowupTelephoneConnRate
	 * </p>
	 * <p>
	 * Description:分别通过按科室、按随访人员、按病种统计随访电话接通率情况。
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年8月10日 下午8:21:01
	 * @param locale
	 * @param commonParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/followup/telephone/connection/rate/statistics", method = RequestMethod.POST)
	public TMsgResponse<TStatisticResultInfo> statisticsFollowupTelephoneConnRate(Locale locale,
			@RequestBody TCommonParam commonParam) {
		TMsgResponse<TStatisticResultInfo> tMsgResponse = new TMsgResponse<TStatisticResultInfo>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (commonParam.getCategory() == null) {
			commonParam.setCategory(-1);
		}
		try {
			TStatisticResultInfo statisticResultInfo = this.followupStatisticsService
					.statisticsFollowupTelephoneConnRate(commonParam);
			if (statisticResultInfo == null || statisticResultInfo.getValues() == null
					|| statisticResultInfo.getValues().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			}
			tMsgResponse.setResult(statisticResultInfo);
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}

	// @ResponseBody
	// @RequestMapping(value="/test", method=RequestMethod.GET)
	// public TMsgResponse<TStatisticResultInfo> test(Locale locale) {
	// TMsgResponse<TStatisticResultInfo> tMsgResponse = new
	// TMsgResponse<TStatisticResultInfo>();
	// tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
	// tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info,
	// null, locale));
	// try {
	// TStatisticResultInfo statisticResultInfo = new TStatisticResultInfo();
	// statisticResultInfo.setShow("[{'name':'理想','age':12}]");
	//
	//
	// tMsgResponse.setResult(statisticResultInfo);
	// } catch (Exception e) {
	// LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
	// tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
	// tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info,
	// null, locale));
	// tMsgResponse.setErrorDesc(e.getMessage());
	// }
	// return tMsgResponse;
	// }
	
	/**
	 * 随访进度统计
	 * @author Nidan
	 * @title:statisticsFollowupSchedule
	 * @Description:统计随访进度情况，生存状态统计，随访方式分布，无效随访原因统计
	 * @return TMsgResponse<FollowupScheduleStatisticsResult>
	 * @date 2016年11月25日下午5:21:29
	 */
	@RequestMapping(value="/followup/schedule/statistics",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<FollowupScheduleStatisticsResult> statisticsFollowupSchedule(@RequestBody FollowupScheduleStatisticsReq req,Locale locale){
		TMsgResponse<FollowupScheduleStatisticsResult> msg=new TMsgResponse<FollowupScheduleStatisticsResult>();
		try {
			FollowupScheduleStatisticsResult result=followupStatisticsService.statisticsFollowupSchedule(req);
			msg.setResult(result);
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
	 * 随访肿瘤患者数统计
	 * @author Nidan
	 * @title:statisticsFollowupPatient
	 * @Description:统计肿瘤患者数，随访有效无效患者数
	 * @return TMsgResponse<FollowupPatientStatisticsResult>
	 * @date 2016年11月25日下午5:24:51
	 */
	@RequestMapping(value="/followup/patient/statistics",method=RequestMethod.POST)
	@ResponseBody
	public TMsgResponse<Object> statisticsFollowupPatient(Locale locale,@RequestBody FollowupPatientStatisticsReq req){
		TMsgResponse<Object> msg=new TMsgResponse<Object>();
		try {
			msg.result=followupStatisticsService.statisticsFollowupPatient(req);
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
	

}
