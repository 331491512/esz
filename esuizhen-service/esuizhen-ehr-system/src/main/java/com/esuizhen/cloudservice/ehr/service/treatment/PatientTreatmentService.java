package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.PatientTreatmentInfoReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;

public interface PatientTreatmentService{

	public List<TPatientTreatmentInfo> queryPatientTreatmentInfoByInHospitalId(CommonReq req);
	
	public String insertPatientTreatmentInfo(TPatientTreatmentInfo patientTreatmentInfo);
	
	public void deletePatientTreatmentInfo(Map<String,Object> paramsMap);

	public void savePatientTreatmentInfo(List<TPatientTreatmentInfo> patientTreatmentInfoList);

	public void savePatientTreatmentInfo(TInhospitallSurgeryMsg<TPatientTreatmentInfo> inhospitalSurgeryMsg);
	/**
	 * 查询患者治疗信息
	 * @param req
	 * @return
	 */
	public List<TPatientTreatmentInfo> queryPatientTreatmentInfo(PatientTreatmentInfoReq req);
	
	/**
	 * 患者治疗明细保存
	 * @return
	 */
	String savePatientTreatmentDetail(TPatientTreatmentInfo t);
}
