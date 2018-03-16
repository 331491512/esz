package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.statistics.bean.TCommonParam;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireOptionsStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireStemStatisInfo;
import com.esuizhen.cloudservice.statistics.bean.TQuestionnaireSurveyInfo;

/**
 * <p>Title:QuestionnaireStatisticsDao</p>
 * <p>Description:问卷相关统计数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年9月1日 下午2:13:50
 */
public interface QuestionnaireStatisticsDao {
	/**
	 * <p>Title:findQuestionnaireSurvey</p>
	 * <p>Description:查询并统计问卷</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午2:18:00
	 * @param commonParam
	 * @return
	 */
	List<TQuestionnaireSurveyInfo> findQuestionnaireSurvey(TCommonParam commonParam);

	/**
	 * <p>Title:findQuestionnaireStems</p>
	 * <p>Description:查询并统计问卷题干</p>
	 * @author YYCHEN
	 * @date 2016年9月1日 下午7:07:00
	 * @param questionnaireId
	 * @return
	 */
	List<TQuestionnaireStemStatisInfo> findQuestionnaireStems(@Param("questionnaireId")String questionnaireId,@Param("followupTaskId")String followupTaskId);

	/**
	 * <p>Title:findFirstFloorOptions</p>
	 * <p>Description:获取问卷题干的第一级答案，不包含嵌套的答案与题干</p>
	 * @author YYCHEN
	 * @date 2016年9月2日 上午9:33:37
	 * @param questionnaireStemStatisInfo
	 * @return
	 */
	List<TQuestionnaireOptionsStatisInfo> findFirstFloorOptions(TQuestionnaireStemStatisInfo questionnaireStemStatisInfo);

	/**
	 * <p>Title:findNestedOptions</p>
	 * <p>Description:查询并统计嵌套答案</p>
	 * @author YYCHEN
	 * @date 2016年9月2日 上午9:49:35
	 * @param questionnaireOptionsStatisInfo
	 * @return
	 */
	List<TQuestionnaireOptionsStatisInfo> findNestedOptions(TQuestionnaireOptionsStatisInfo questionnaireOptionsStatisInfo);
}
