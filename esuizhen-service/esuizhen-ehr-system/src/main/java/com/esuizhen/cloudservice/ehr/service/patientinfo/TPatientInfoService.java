package com.esuizhen.cloudservice.ehr.service.patientinfo;

import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TUserInfo;
import com.westangel.common.bean.Page;


public interface TPatientInfoService
{
	public Page queryPatientProfile(String patientNo , String trueName , Integer page , Integer num);
	
	Page<Map<String,Object>> queryPatientVisitInfo(PatientInfoReq req);
	
	int insert(TPatientInfo patient);
	
	/**
	 * 插入与患者相关的一系列信息。用户信息、患者信息、医生患者关系、院患关系
	 * @param paramsMap
	 */
	void insert(Map<String,Object> paramsMap);
	/**
	 * 插入用户信息
	 * @param patient
	 * @return
	 */
	int insertUserInfo(TUserInfo userInfo);
	
	/**
	 * 更新与患者相关的一系列信息。用户信息、患者信息、医生患者关系、院患关系
	 * @param paramsMap
	 */
	void update(Map<String,Object> paramsMap); 
	void updateUserPatient(TUserInfo userInfo, TPatientInfo patient);
	/**
	 * 查询最后一次住院信息
	 * @param req
	 * @return
	 */
	TInhospitalDetailInfo queryPatientVisitInfoLastest(CommonReq req);
}
