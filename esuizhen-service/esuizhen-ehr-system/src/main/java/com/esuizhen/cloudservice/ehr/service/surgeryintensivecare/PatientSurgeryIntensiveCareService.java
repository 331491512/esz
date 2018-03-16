package com.esuizhen.cloudservice.ehr.service.surgeryintensivecare;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;

public interface PatientSurgeryIntensiveCareService {

	public List<TPatientSurgeryIntensiveCareInfo> queryPatientSurgeryIntensiveCareInfoByInHospitalId(String inhospitalId);

	public void insertPatientSurgeryIntensiveCareInfo(TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo);

	public void deletePatientSurgeryIntensiveCareInfo(String inhospitalId);

	public void savePatientSurgeryIntensiveCareInfo(List<TPatientSurgeryIntensiveCareInfo> patientSurgeryIntensiveCareInfoList);

	public void savePatientSurgeryIntensiveCareInfo(TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo> inhospitalSurgeryMsg);

}
