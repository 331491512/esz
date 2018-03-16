package com.esuizhen.cloudservice.ehr.dao.patientinfo;

import java.util.List; 
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientProfile;
import com.westangel.common.bean.DoctorPatient;

public interface TPatientInfoDao extends CommonDao<TPatientInfo> {

	public List<TPatientProfile> queryPatientProfile(@Param("patientNo") String patientNo, @Param("trueName") String trueName);

	/**
	 * 根据患者id获取患者信息
	 * 
	 * @param patientId
	 * @return
	 */
	TPatientProfile queryPatientById(@Param("patientId") Long patientId);

	public void updatePatientInfo(TPatientProfile patient);

	public void updatePatient(TPatientInfo patient);

	void updatePatientById(Map<String, Object> paramsMap);

	/**
	 * 修改患者住院医师
	 * 
	 * @param patientId
	 */
	void updateDoctorOfPatient(Long patientId);

	/**
	 * 获取患者信息
	 * 
	 * @param patientId
	 * @return
	 */
	TPatientProfile queryPatient(Map<String, Object> paramsMap);

	/**
	 * 查询患者就诊信息列表
	 * 
	 * @param paramsMap
	 * @return
	 */
	List<Map<String, Object>> queryPatientVisitInfo(Map<String, Object> paramsMap);

	List<DoctorPatient> searchDoctorPatient(@Param("patientId") Long patientId, @Param("doctorId") Long doctorId);

	/**
	 * 插入医患关系
	 * 
	 * @param doctorpatient
	 * @return
	 */
	long insertDoctorPatient(DoctorPatient doctorpatient);

	long batchInsertDoctorPatient(Map<String, Object> doctorPatientMap);

	/**
	 * 查询最后一次住院信息
	 * 
	 * @param req
	 * @return
	 */
	TInhospitalDetailInfo queryPatientVisitInfoLastest(Map<String, Object> paraMap);

	TPatientProfile queryPatientByHospitalName(@Param("patientNo") String patientNo, @Param("hospitalName") String hospitalName);

	void updatePatientFromInhospitalNote(@Param("patientId") Long patientId);

	void updateRDoctorPatientFromInhospitalNote(@Param("patientId") Long patientId);
}
