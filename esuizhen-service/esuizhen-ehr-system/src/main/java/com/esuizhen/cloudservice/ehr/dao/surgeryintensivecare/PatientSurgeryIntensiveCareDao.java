package com.esuizhen.cloudservice.ehr.dao.surgeryintensivecare;

import java.util.List;

import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;

public interface PatientSurgeryIntensiveCareDao {
	
	public List<TPatientSurgeryIntensiveCareInfo> queryPatientSurgeryIntensiveCareInfoByInHospitalId(String inhospitalId);

	public void insertPatientSurgeryIntensiveCareInfo(TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo);

	public void deletePatientSurgeryIntensiveCareInfo(String inhospitalId);
	
	// add by zhuguo
	public void updatePatientSurgeryIntensiveCareInfo(TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo); 
	
	public void deletePatientSurgeryIntensiveCareInfoByintensiveId(TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo); 
	// end

}
