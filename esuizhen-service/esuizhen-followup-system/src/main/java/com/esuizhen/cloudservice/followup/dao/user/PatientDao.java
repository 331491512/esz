package com.esuizhen.cloudservice.followup.dao.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.model.followupresult.TPatientContactInfo;
import com.esuizhen.cloudservice.followup.model.followupresult.TTreatmentInfo;
import com.westangel.common.bean.Patient;

public interface PatientDao {

	public Integer updatePatientContactInfo(
			TPatientContactInfo patientContactInfo);

	public Integer updatePatientFamilyStatusIsValueOrNull(
			TPatientContactInfo patientContactInfo);

	public void savePatientFollowupFlag(
			@Param("patientId") Long patientId,
			@Param("followupFlag") Integer followupFlag,
			@Param("lostFollowupCauseResultValue") Integer lostFollowupCauseResultValue,
			@Param("lostFollowupCause") String lostFollowupCause,
			@Param("lostFollowupTime") Date lostFollowupTime);

	public List<TPatientContactInfo> getPatientContactList(
			@Param("patientId") Long patientId);

	public List<TTreatmentInfo> queryEciTreatmentNoteByPatientId(Long patientId);

	public List<TTreatmentInfo> getTreatmentNameByPatientId(Long patientId);

	/**
	 * 获取患者所在医院
	 * 
	 * @param patientId
	 * @return
	 */
	Integer queryHospitalByPatientId(Long patientId);

	/**
	 * 
	 * @author lichenghao
	 * @title :queryPatientSyncFlagByPatientId
	 * @Description:获取患者同步信息
	 * @return Integer
	 * @date 2016年10月29日 下午1:28:40
	 */
	Integer queryPatientSyncFlagByPatientId(@Param("patientId") Long patientId);

	/**
	 * 更新患者表的随访结果
	 * 
	 * @param patient
	 */
	public void updatePatientByFollowupResult(Patient patient);

	/**
	 * 更新患者表的随访结果（主键更新）
	 * 
	 * @param patient
	 */
	public void updatePatientByPrimaryKey(Patient patient);

	/**
	 * 查询患者
	 * 
	 * @param patientId
	 * @return
	 */
	public Patient queryPatientByPrimaryKey(Long patientId);

	// start add by zhuguo
	public TPatientContactInfo findPatientInfoById(TPatientContactInfo pf);

	public int updatePatientFamilyPhoneStatus(TPatientContactInfo pf);
	
	public int updatePatientFamilyPhoneStatusToOther(TPatientContactInfo pf);
	// end add by zhuguo
	void updateSearchTableInfo(Map<String,Object> searchMap);
}
