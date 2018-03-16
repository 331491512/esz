package com.esuizhen.cloudservice.followup.dao.followupresult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.FollowupMsgSendReq;
import com.esuizhen.cloudservice.followup.bean.FollowupPatientInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultDetailInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupResultValueInfo;
import com.westangel.common.bean.PatientSimpleInfo;

public interface FollowupResultWayDao {

	public List<TFollowupResultDetailInfo> queryFollowupResultHistory(Map<String, Object> searchParams);

	public List<TFollowupResultDetailInfo> queryFollowupResult(Map<String, Object> searchParams);
	
	public TFollowupResultDetailInfo queryLastFollowupResultByPatientUuid(String patientUuid);

	public List<TFollowupResultDetailInfo> queryFollowupResultBuff(Map<String, Object> searchParams);
	
	public TFollowupResultDetailInfo queryFollowupResultBuffByPrimaryKey(String followupResultBuffId);

	public void insertFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo);

	public void updateFollowupResultBuff(TFollowupResultDetailInfo followupResultDetailInfo);
	
	public void updateFollowupResultBuffNotSelective(TFollowupResultDetailInfo followupResultDetailInfo);
	
	public void updateFollowupResultNotSelective(TFollowupResultDetailInfo followupResultDetailInfo);

	public void insertFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	public void updateFollowupResult(TFollowupResultDetailInfo followupResultDetailInfo);

	public List<FollowupPatientInfo> queryPatientIdsByFollowupResult(FollowupMsgSendReq followupMsgSendReq);

	public Integer queryPatientIdCountByFollowupResult(FollowupMsgSendReq followupMsgSendReq);

	public Map<String,Object> getFollowupTaskNameById(@Param("followupTaskId") String followupTaskId);
	
	public List<TFollowupResultValueInfo> getMetaInfoFollowupResultValueList();

	public List<TFollowupResultDetailInfo> queryFollowupResultFormalHistory(Object param);


	/**
	 * 查询患者列表的最后一次随访结果
	 * @param params
	 * @return
	 */
	public List<TFollowupResultDetailInfo> findLastFollowupResultList(@Param("params")List<PatientSimpleInfo> params);

	/**
	 * 给患者复制随访结果
	 * @param patientSimpleInfo
	 * @return
	 */
	public int copyFollowupResultToPatient(PatientSimpleInfo patientSimpleInfo);
	
	public TFollowupResultDetailInfo queryFollowupResultById(@Param("followupResultId")String followupResultId);
	
	/**
	 * 删除随访结果
	 * @param followupResultId
	 */
	public void deleteFollowupResult(String followupResultId);
	
	/**
	 * 删除随访缓存结果
	 * @param followupResultBuffId
	 */
	public void deleteFollowupResultBuff(String followupResultBuffId);
	/**
	* @author fanpanwei
	* @date 2017年8月9日
	* @param 
	* @description:查询当前条件下所有有微信记录的患者总数
	* @return
	 */
	public Integer getHadWxRecordTotal(FollowupMsgSendReq followupMsgSendReq);
	
	public Integer getHadSmsRecordTotal(FollowupMsgSendReq followupMsgSendReq);
	
	//查询有效随访标识
	public String queryValidFollowupFlag(FollowupMsgSendReq followupMsgSendReq);
}
