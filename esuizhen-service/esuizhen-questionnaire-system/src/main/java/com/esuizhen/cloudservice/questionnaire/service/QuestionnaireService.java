package com.esuizhen.cloudservice.questionnaire.service;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.questionnaire.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.questionnaire.bean.FollowupQuestionnaireResultReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireListQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireQueryReq;
import com.esuizhen.cloudservice.questionnaire.bean.QuestionnaireResultListReq;
import com.esuizhen.cloudservice.questionnaire.bean.TFollowupQuestionnaireDetailInfoReq;
import com.esuizhen.cloudservice.questionnaire.bean.WXSendReq;
import com.esuizhen.cloudservice.questionnaire.model.TFollowupQuestionnaireDetailInfo;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnairePatientInfo;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResult;
import com.esuizhen.cloudservice.questionnaire.model.TQuestionnaireResultStem;
import com.westangel.common.bean.Page;

/**
* @ClassName: QuestionnaireService 
* @Description: 问卷服务接口
* @author wang_hw
* @date 2015年12月7日 下午1:59:28
 */
public interface QuestionnaireService
{
	/**
	 * @author wang_hw
	 * @title :updateFollowupQuestionnaire
	 * @Description:修改随访问卷
	 * @return String
	 * @date 2015年12月7日 下午8:24:25
	 */
	public String updateFollowupQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo);
	
	/**
	 * 
	 * @author wang_hw
	 * @title :addFollowupQuestionnaire
	 * @Description:添加问卷
	 * @return String
	 * @date 2015年12月7日 下午1:59:46
	 */
	public String addFollowupQuestionnaire(TFollowupQuestionnaireDetailInfo detailInfo);
	
	/**
	 * @author wang_hw
	 * @title :deleteFollowupQuestionnaire
	 * @Description:根据问卷ID删除问卷
	 * @return String
	 * @date 2015年12月7日 下午7:26:30
	 */
	public void deleteFollowupQuestionnaire(String questionnaireId);
	
	/**
	 * @author wang_hw
	 * @title :queryFollowupQuestionnaire
	 * @Description:查看问卷明细
	 * @return TFollowupQuestionnaireDetailInfo
	 * @date 2015年12月8日 下午2:39:51
	 */
	public TFollowupQuestionnaireDetailInfoReq queryFollowupQuestionnaire(QuestionnaireQueryReq req);
	
	/**
	 * @author wang_hw
	 * @title :followupQuestionnaireResultList
	 * @Description:查看患者问卷结果列表
	 * @return Page<TQuestionnaireResultSimpleInfo>
	 * @date 2015年12月11日 下午5:40:45
	 */
	public Page<TQuestionnaireResult> followupQuestionnaireResultList(QuestionnaireResultListReq req);
	
	/**
	 * 查看问卷结果
	 * @author wang_hw
	 * @title :queryFollowupQuestionnaireResult
	 * @Description:TODO
	 * @return LinkedHashMap<String,Object>
	 * @date 2015年12月11日 下午7:43:40
	 */
	public List<TQuestionnaireResultStem> queryFollowupQuestionnaireResult(String questionnaireResultId , String followupItemId);
	
	/**
	 * @author wang_hw
	 * @title :writeFollowupQuestionnaireResult
	 * @Description:问卷结果填写
	 * @return List<TQuestionnaireResultStem>
	 * @date 2015年12月31日 下午2:13:04
	 */
	public String writeFollowupQuestionnaireResult(TQuestionnaireResult result);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowupQuestionnaireList
	 * @Description:问卷列表获取
	 * @return Page<TFollowupQuestionnaireDetailInfo>
	 * @date 2016年8月5日 下午4:42:08
	 */
	public Page<TFollowupQuestionnaireDetailInfo> queryFollowupQuestionnaireList(QuestionnaireListQueryReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :saveFollowupQuestionnaireResult
	 * @Description:问卷结果保存
	 * @return void
	 * @date 2016年8月20日 下午5:49:21
	 */
	public String saveFollowupQuestionnaireResult(TQuestionnaireResult result);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowupQuestionnaireResult
	 * @Description:问卷结果查询
	 * @return TQuestionnaireResult
	 * @date 2016年8月20日 下午6:19:51
	 */
	public TQuestionnaireResult queryFollowupQuestionnaireResult(FollowupQuestionnaireResultReq req);
	
	/**
	 * 查询患者问卷内容列表
	 * @param questionnaireId
	 * @return
	 */
	public List<TQuestionnairePatientInfo> queryPatientAnswerByQuestionnaireId(String questionnaireId,String followupTaskId);
	
	/**
	 * 给患者发送问卷随访
	 * @param followupMsgSendReq
	 * @return
	 * @throws Exception
	 */
	Map<String,Integer> sendQuestionnaireFollowup(FollowupMsgSendReq followupMsgSendReq) throws Exception;
	/**
	 * 推送微信消息
	 * @param req
	 */
	void sendWXMessage(WXSendReq req);
	/**
	 * 扫描问卷回复结果===========单元测试用，正式环境走定时任务
	 */
	void scanQuestionnaireReply();
}
