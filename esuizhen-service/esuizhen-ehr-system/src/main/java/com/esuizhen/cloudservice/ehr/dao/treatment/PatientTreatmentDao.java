package com.esuizhen.cloudservice.ehr.dao.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.PatientTreatmentInfoReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;

public interface PatientTreatmentDao {

	public List<TPatientTreatmentInfo> queryPatientTreatmentInfoByInHospitalId(CommonReq req);
	
	public void insertPatientTreatmentInfo(TPatientTreatmentInfo patientTreatmentInfo);
	
	public void deletePatientTreatmentInfo(Map<String,Object> paramsMap);
	
	/**
	 * 查询患者治疗信息
	 * @param req
	 * @return
	 */
	public List<TPatientTreatmentInfo> queryPatientTreatmentInfo(PatientTreatmentInfoReq req);
	
	void updatePatientTreatmentInfo(TPatientTreatmentInfo patientTreatmentInfo);
}
