package com.esuizhen.cloudservice.statistics.service;

import java.util.List;

import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireStemStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireSurveyInfo;
import com.westangel.common.bean.Page;

public interface QuestionnaireStatisticsService {

	/**
	 * <p>Title:searchQuestionnaireSurvey</p>
	 * <p>Description:查询调查问卷列表，并统计问卷部分数据</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午12:04:59
	 * @param commonParam
	 * @return
	 */
	Page<TQuestionnaireSurveyInfo> searchQuestionnaireSurvey(TCommonParam commonParam);

	/**
	 * <p>Title:statisQuestionnaireSurveyResult</p>
	 * <p>Description:统计调查问卷各个题目选项选择情况</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午6:25:20
	 * @param questionnaireId
	 * @return
	 */
	List<TQuestionnaireStemStatisInfo> statisQuestionnaireSurveyResult(String questionnaireId,String followupTaskId);

}
