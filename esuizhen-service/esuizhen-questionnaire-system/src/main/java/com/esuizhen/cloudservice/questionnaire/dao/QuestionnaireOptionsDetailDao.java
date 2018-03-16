package com.esuizhen.cloudservice.questionnaire.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireOptions;

/**
 * 
* @ClassName: QuestionnaireOptionsDetailDao 
* @Description: 问卷选项数据操作接口类
* @author wang_hw
* @date 2015年12月29日 下午4:26:16
 */
public interface QuestionnaireOptionsDetailDao{
	
	/**
	 * @author wang_hw
	 * @title :insertQuestionnaireOptionsDetail
	 * @Description:录入问题选项
	 * @return void
	 * @date 2015年12月29日 下午4:38:12
	 */
	public void insertQuestionnaireOptionsDetail(TFollowupQuestionnaireOptions questionnaireOptionsDetail);
	
	/**
	 * @author wang_hw
	 * @title :updateQuestionnaireOptionsDetail
	 * @Description:修改问题选项
	 * @return void
	 * @date 2015年12月29日 下午4:39:15
	 */
	public void updateQuestionnaireOptionsDetail(TFollowupQuestionnaireOptions questionnaireOptionsDetail);
	
	/**
	 * @author wang_hw
	 * @title :deleteQuestionnaireOptionsDetail
	 * @Description:删除问题选项
	 * @return void
	 * @date 2015年12月29日 下午4:39:31
	 */
	public void deleteQuestionnaireOptionsDetail(Long questionnaireOptionsDetailId);
	
	/**
	 * @author wang_hw
	 * @title :queryQuestionnaireOptionsDetail
	 * @Description:修改问题选项
	 * @return TFollowupQuestionnaireOptions
	 * @date 2015年12月29日 下午4:41:49
	 */
	public TFollowupQuestionnaireOptions queryQuestionnaireOptionsDetail(Long questionnaireOptionsDetailId);
	
	/**
	 * @author wang_hw
	 * @title :queryOptionsDetailByStemId
	 * @Description:根据题干ID查询选项
	 * @return List<TFollowupQuestionnaireOptions>
	 * @date 2015年12月29日 下午5:43:47
	 */
	public List<TFollowupQuestionnaireOptions> queryOptionsDetailByStemId(@Param("questionnaireStemId") String questionnaireStemId , @Param("diseaseTypeId")String diseaseTypeId);
	
	/**
	 * @author wang_hw
	 * @title :queryOptionsDetailByParentOptionId
	 * @Description:根据parentOptionId查询问题选项
	 * @return List<TFollowupQuestionnaireOptions>
	 * @date 2015年12月29日 下午5:44:11
	 */
	public List<TFollowupQuestionnaireOptions> queryOptionsDetailByParentOptionId(String parentOptionId);
	
	/**
	 * @author wang_hw
	 * @title :queryPatientDiseaseTypeId
	 * @Description:根据患者ID获取疾病种类
	 * @return String
	 * @date 2016年1月11日 下午8:13:45
	 */
	public String queryPatientDiseaseTypeId(String patientId);

	public TFollowupQuestionnaireOptions queryQuestionnaireOptionsDetailById(@Param("id") String questionnaireOptionsDetailId);
	
	/**
	 * 通过题干查询题支信息
	 * @param questionnaireStemId
	 * @return
	 */
	List<TFollowupQuestionnaireOptions> queryQuestionnaireOptionsByStemId(@Param("questionnaireStemId") String questionnaireStemId);
	
}
