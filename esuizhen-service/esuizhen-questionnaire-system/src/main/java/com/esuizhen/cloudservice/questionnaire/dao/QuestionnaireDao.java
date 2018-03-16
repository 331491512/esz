package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireStem;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnairePatientInfo;

/**
 * 
* @ClassName: QuestionnaireDao 
* @Description: 问卷数据操作接口 
* @author wang_hw
* @date 2015年12月7日 下午2:06:41
 */
@Repository
public interface QuestionnaireDao
{
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowups
	 * @Description:获取问卷明细
	 * @return List<TFollowupQuestionnaireDetailInfo>
	 * @date 2016年8月8日 上午8:07:46
	 */
	public List<TFollowupQuestionnaireDetailInfo> queryFollowups(Object obj);
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaire
	 * @Description:添加问卷信息
	 * @return void
	 * @date 2015年12月7日 下午2:06:37
	 */
	public void insertQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireById
	 * @Description:根据问卷ID查看问卷明细
	 * @return TFollowupQuestionnaireDetailInfo
	 * @date 2015年12月8日 下午2:38:54
	 */
	public TFollowupQuestionnaireDetailInfo queryQuestionnaireById(Object param);
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireStem
	 * @Description:保存题目
	 * @return void
	 * @date 2015年12月7日 下午2:42:32
	 */
	public void insertQuestionnaireStem(TFollowupQuestionnaireStem stem);
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireOptions
	 * @Description:保存题目选项
	 * @return void
	 * @date 2015年12月7日 下午2:42:57
	 */
	//public void insertQuestionnaireOption(TFollowupQuestionnaireOptions options);
	public void insertQuestionnaireOptions(@Param("options")List<TFollowupQuestionnaireOptions> options);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireById
	 * @Description:根据ID删除问卷
	 * @return void
	 * @date 2015年12月7日 下午7:24:16
	 */
	public void deleteQuestionnaireById(String questionnaireId);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireStemByQuestionnaireId
	 * @Description:根据问卷ID删除问题
	 * @return void
	 * @date 2015年12月7日 下午7:24:34
	 */
	public void deleteQuestionnaireStemByQuestionnaireId(String questionnaireId);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireOptionsByQuestionnaireId
	 * @Description:根据问卷ID删除问题选项
	 * @return void
	 * @date 2015年12月7日 下午7:24:52
	 */
	public void deleteQuestionnaireOptionsByQuestionnaireId(String questionnaireId);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireById
	 * @Description:根据ID修改问卷
	 * @return void
	 * @date 2015年12月7日 下午8:28:08
	 */
	public void updateQuestionnaireById(TFollowupQuestionnaireDetailInfo detailInfo);
	
	/**
	 * @author zhuguo
	 * @title :updateQuestionnaireContentTemplateByQuestionnaireId
	 * @Description:根据ID修改问卷内容模板
	 * @return void
	 * @date 2017年5月11日17:34:31
	 */
	public void updateQuestionnaireContentTemplateByQuestionnaireId(TFollowupQuestionnaireDetailInfo detailInfo);
	
	
	/**
	 * 根据问卷ID查询用户问卷答案
	 * @param questionnaireId
	 * @return
	 */
	public List<TQuestionnairePatientInfo> queryPatientAnswerByQuestionnaireId(@Param("questionnaireId")String questionnaireId,@Param("followupTaskId")String followupTaskId);
	
	/**
	 * 根据问卷ID查询问卷问题
	 * @param questionnaireId
	 * @return
	 */
	public List<Map<String,String>> queryQuestionnaireSubjectByQuestionnaireId(String questionnaireId);
	
	/**
	 * 对数据软删除
	 * @author lichenghao
	 * @title :deleteSoftQuestionnaireById
	 * @Description:TODO
	 * @return int
	 * @date 2017年7月28日 下午3:18:03
	 */
	public int deleteSoftQuestionnaireById(String questionnaireId);
	
	/**
	 * @author zhuguo
	 * @Description:根据ID删除模板
	 * @date 2017-8-22 16:45:58
	 */
	public void deleteTemplateById(String questionnaireId);
	
}
