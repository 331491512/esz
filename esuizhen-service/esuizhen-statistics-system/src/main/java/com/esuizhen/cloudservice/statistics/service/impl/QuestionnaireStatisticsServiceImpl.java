package com.esuizhen.cloudservice.statistics.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireOptionsStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireStemStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireSurveyInfo;
import com.esuizhen.cloudservice.statistics.dao.QuestionnaireStatisticsDao;
import com.esuizhen.cloudservice.statistics.service.QuestionnaireStatisticsService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class QuestionnaireStatisticsServiceImpl implements QuestionnaireStatisticsService {
	@Autowired
	private QuestionnaireStatisticsDao questionnaireStatisticsDao;

	@SuppressWarnings("unchecked")
	@Override
	public Page<TQuestionnaireSurveyInfo> searchQuestionnaireSurvey(TCommonParam commonParam) {
		PageHelper.startPage(commonParam.getPage() + 1, commonParam.getNum());
		List<TQuestionnaireSurveyInfo> questionnaireSurveyInfos = this.questionnaireStatisticsDao.findQuestionnaireSurvey(commonParam);
		return PageUtil.returnPage((com.github.pagehelper.Page<TQuestionnaireSurveyInfo>) questionnaireSurveyInfos);
	}

	@Override
	public List<TQuestionnaireStemStatisInfo> statisQuestionnaireSurveyResult(String questionnaireId,String followupTaskId) {
		//获取所有题干
		List<TQuestionnaireStemStatisInfo> questionnaireStemStatisInfos = this.questionnaireStatisticsDao.findQuestionnaireStems(questionnaireId,followupTaskId);
		this.getQuestionnaireOptions(questionnaireStemStatisInfos);
		return questionnaireStemStatisInfos;
	}

	// 查询并统计题干的答案
	private void getQuestionnaireOptions(List<TQuestionnaireStemStatisInfo> questionnaireStemStatisInfos) {
		if (questionnaireStemStatisInfos == null || questionnaireStemStatisInfos.isEmpty()) {
			return;
		}
		for (TQuestionnaireStemStatisInfo questionnaireStemStatisInfo : questionnaireStemStatisInfos) {
			// 获取并统计题干的答案
			List<TQuestionnaireOptionsStatisInfo> firstFloorOptions = this.questionnaireStatisticsDao.findFirstFloorOptions(questionnaireStemStatisInfo);
			// #TODO 查询并统计答案嵌套的题干
			this.getNestedOptions(firstFloorOptions);
			if (firstFloorOptions != null && !firstFloorOptions.isEmpty()) {
				questionnaireStemStatisInfo.setOptionList(firstFloorOptions);
			}
		}
	}

	// 查询并统计答案嵌套的答案
	private void getNestedOptions(List<TQuestionnaireOptionsStatisInfo> questionnaireOptionsStatisInfos) {
		if (questionnaireOptionsStatisInfos == null || questionnaireOptionsStatisInfos.isEmpty()) {
			return;
		}
		for (TQuestionnaireOptionsStatisInfo questionnaireOptionsStatisInfo : questionnaireOptionsStatisInfos) {
			// 查询并统计嵌套的答案
			List<TQuestionnaireOptionsStatisInfo> optionsStatisInfos = this.questionnaireStatisticsDao.findNestedOptions(questionnaireOptionsStatisInfo);
			// #TODO 查询并统计答案嵌套的题干
			this.getNestedOptions(optionsStatisInfos);
			if (optionsStatisInfos != null && !optionsStatisInfos.isEmpty()) {
				questionnaireOptionsStatisInfo.setOptionList(optionsStatisInfos);
			}
		}
	}

}
