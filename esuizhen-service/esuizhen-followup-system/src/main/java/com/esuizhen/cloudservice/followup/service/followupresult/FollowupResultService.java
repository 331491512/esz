package com.esuizhen.cloudservice.followup.service.followupresult;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPatientInfo;
import com.esuizhen.cloudservice.followup.bean.FollowupResultDeleteReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultHistoryQueryReq;
import com.esuizhen.cloudservice.followup.bean.FollowupResultReq;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientSimpleInfo;

public interface FollowupResultService {

	public Page<TFollowupResultDetailInfo> queryFollowupResultHistory(Map<String, Object> searchParams, Integer page, Integer num);

	public void insertFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo);

	public void updateFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo);

	public void insertFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	public void updateFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	/**
	 * @Title: saveVarPatientFollowup
	 * @Description: 随访结果保存时保存动态结果
	 */
	public void saveVarPatientFollowup(Long patientId, TFollowupResultDetailInfo followupResultDetailInfo);

	public TFollowupResultDetailInfo storeRuleFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	public List<FollowupPatientInfo> queryPatientIdsByFollowupResult(FollowupMsgSendReq followupMsgSendReq);

	public Integer queryPatientIdCountByFollowupResult(FollowupMsgSendReq followupMsgSendReq);

	public void setFollowupNeedless(Long patientId,Integer searchId);

	void completeFollowupTask(String followupTaskId, String followupAssignId);

	List<TFollowupResultDetailInfo> queryFollowupResultHistory(Map<String, Object> searchParams);
	
	TFollowupResultDetailInfo queryLastFollowupResultByPatientUuid(String patientUuid);

	void scanSmsReply();

	void storeRuleSyncFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	public void createFollowupResult(FollowupResultReq req);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :queryFollowupResultFormalHistory
	 * @Description:获取正式随访结果历史
	 * @return Page
	 * @date 2016年10月18日 下午8:03:50
	 */
	public Page queryFollowupResultFormalHistory(FollowupResultHistoryQueryReq req);
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :updateFollowupResultToC
	 * @Description:云端随访结果处理
	 * @return void
	 * @date 2016年10月29日 下午1:36:43
	 */
	public void updateFollowupResultToC(TFollowupResultDetailInfo followupResultBuff);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :setTocVarPatientFollowup
	 * @Description:更新患者随访动态信息
	 * @return void
	 * @date 2016年10月29日 下午4:20:14
	 */
	public void updateTocVarPatientFollowup(TFollowupResultDetailInfo followupResult);

	/**
	 * 获取患者列表的最后一次随访结果
	 * @param params
	 * @return
	 */
	public List<TFollowupResultDetailInfo> queryLastFollowupResultList(List<PatientSimpleInfo> params);

	/**
	 * 保存随访结果
	 * @param followupResultDetailInfo
	 */
	public void saveFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	/**
	 * 根据随访结果更新患者标识
	 * @param followupResult
	 * @param patient
	 */
	void updatePatientByFollowupResult(Long patientId,TFollowupResultDetailInfo followupResult);

	/**
	 * 删除随访结果
	 * @param followupResultId
	 * @param followupResultBuffId
	 */
	void deleteFollowupResult(FollowupResultDeleteReq req);

	Integer queryHadWxRecordTotal(FollowupMsgSendReq followupMsgSendReq);
	
	Integer queryHadSmsRecordTotal(FollowupMsgSendReq followupMsgSendReq);
	public String getValidFollowupFlag(FollowupMsgSendReq followupMsgSendReq);

	Date guessDeathDate(Date deathDate, Long patientId);

	Date calculateDeathDate(Date deathDate, Date latestFollowupTime,
			Date replyDate);
}
