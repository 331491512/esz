package com.esuizhen.cloudservice.statistics.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireStemStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireSurveyInfo;
import com.esuizhen.cloudservice.statistics.service.QuestionnaireStatisticsService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;

@Controller
public class QuestionnaireStatisticsController {
	/**
	 * 消息服务
	 */
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private QuestionnaireStatisticsService questionnaireStatisticsService;

	@Autowired
	private OrganizationDoctorService organizationDoctorService;

	/**
	 * <p>
	 * Title:searchQuestionnaireSurvey
	 * </p>
	 * <p>
	 * Description:查询调查问卷列表，并统计问卷部分数据
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年9月1日 下午12:05:36
	 * @param locale
	 * @param commonParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/questionnaire/survey/search", method = RequestMethod.POST)
	public TMsgResponse<Page<TQuestionnaireSurveyInfo>> searchQuestionnaireSurvey(Locale locale, @RequestBody TCommonParam commonParam) {
		TMsgResponse<Page<TQuestionnaireSurveyInfo>> tMsgResponse = new TMsgResponse<Page<TQuestionnaireSurveyInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		if (StringUtils.isEmpty(commonParam.getSubject())) {
			commonParam.setSubject(null);
		}
		if (StringUtils.isEmpty(commonParam.getFollowupTaskName())) {
			commonParam.setFollowupTaskName(null);
		}
		try {
			String sql = organizationDoctorService.getDoctorIdSql(commonParam.getOperator(), commonParam.getUserId());
			commonParam.setSql(sql);
			Page<TQuestionnaireSurveyInfo> questionnaireSurveyInfoes = this.questionnaireStatisticsService.searchQuestionnaireSurvey(commonParam);
			if (questionnaireSurveyInfoes == null || questionnaireSurveyInfoes.getDataList() == null || questionnaireSurveyInfoes.getDataList().isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(questionnaireSurveyInfoes);
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
	@RequestMapping(value="/questionnaire/survey/result/statis", method=RequestMethod.GET)
	public TMsgResponse<List<TQuestionnaireStemStatisInfo>> statisQuestionnaireSurveyResult(Locale locale, String questionnaireId,String followupTaskId) {
		TMsgResponse<List<TQuestionnaireStemStatisInfo>> tMsgResponse = new TMsgResponse<List<TQuestionnaireStemStatisInfo>>();
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale));
		try {
			List<TQuestionnaireStemStatisInfo> questionnaireStemStatisInfos = this.questionnaireStatisticsService.statisQuestionnaireSurveyResult(questionnaireId,followupTaskId);
			if (questionnaireStemStatisInfos == null || questionnaireStemStatisInfos.isEmpty()) {
				tMsgResponse.setRespCode(ErrorMessage.E1404.getCode());
				tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1404.info, null, locale));
			} else {
				tMsgResponse.setResult(questionnaireStemStatisInfos);
			}
		} catch (Exception e) {
			LogUtil.logError.error(e.getCause() + "\t" + e.getMessage());
			tMsgResponse.setRespCode(ErrorMessage.E1500.getCode());
			tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.E1500.info, null, locale));
			tMsgResponse.setErrorDesc(e.getMessage());
		}
		return tMsgResponse;
	}
}
