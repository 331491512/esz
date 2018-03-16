package com.esuizhen.cloudservice.ehr.service.treatment;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;

public interface PatientSurgeryService {
	
	public List<TPatientSurgeryInfo> queryPatientSurgeryInfoByInHospitalId(CommonReq req);
	
	public void savePatientSurgeryInfo(List<TPatientSurgeryInfo> patientSurgeryInfoList);

	public void insertPatientSurgeryInfo(TPatientSurgeryInfo patientSurgeryInfo);

	public void deletePatientSurgeryInfo(Map<String,Object> delMap);

	public void savePatientSurgeryInfo(TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitalSurgeryMsg);

}
