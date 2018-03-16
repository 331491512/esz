package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;

public interface PatientSurgeryDao {

	public List<TPatientSurgeryInfo> queryPatientSurgeryInfoByInHospitalId(CommonReq req);

	public void insertPatientSurgeryInfo(TPatientSurgeryInfo patientSurgeryInfo);

	public void updatePatientSurgeryInfo(TPatientSurgeryInfo patientSurgeryInfo);

	public void deletePatientSurgeryInfo(Map<String, Object> delMap);

	/**
	 * 获取第一手术
	 * 
	 * @param inhospitalId
	 * @return
	 */
	public TPatientSurgeryInfo queryFirstOperatorByInHospitalId(String inhospitalId);

	/**
	 * 批量插入手术信息
	 */
	void batchInsertSurgeryInfo(Map<String, Object> paramsMap);
}
