package com.esuizhen.cloudservice.ehr.service.visitdoctor;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.PatientMedicalTreatmentResp;
import com.westangel.common.bean.Page;

public interface VisitDoctorService {
	
	public Page<PatientMedicalTreatmentResp> getPatientMedicalTreatmentList(
			PatientMedicalTreatmentResp resp);
	
	public PatientMedicalTreatmentResp getPatientMedicalTreatmentTotal(
			PatientMedicalTreatmentResp resp);
	
	public PatientMedicalTreatmentResp getPatientMedicalTreatmentDetail(
			PatientMedicalTreatmentResp resp);

	public List<String> getOtherDiagnosisList(PatientMedicalTreatmentResp resp);
	
}
