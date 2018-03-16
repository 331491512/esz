package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.PatientMedicalTreatmentResp;
import com.westangel.common.bean.Page;

/**
 * @ClassName: PatientMedicalTreatmentService
 * @Description: 历次就诊
 * @author zhuguo
 * @date 2017-5-27 18:02:05
 */
public interface PatientMedicalTreatmentService {

	public PatientMedicalTreatmentResp getPatientMedicalTreatmentTotal(
			PatientMedicalTreatmentResp resp);

	public Page<PatientMedicalTreatmentResp> getPatientMedicalTreatmentList(
			PatientMedicalTreatmentResp resp);

	public PatientMedicalTreatmentResp getPatientMedicalTreatmentDetail(
			PatientMedicalTreatmentResp resp);

	public List<String> getOtherDiagnosisList(PatientMedicalTreatmentResp resp);
}
