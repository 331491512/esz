package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireOptions;
import com.esuizhen.cloudservice.sync.model.TFollowupQuestionnaireStem;

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
	int queryQuestionnaireById(String questionnaireId);
	
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
}
