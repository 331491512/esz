package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.PatientMedicalTreatmentResp;

/**
 * @ClassName: PatientMedicalTreatmentDao
 * @Description: 历次就诊
 * @author zhuguo
 * @date 2017-5-27 18:02:05
 */
public interface PatientMedicalTreatmentDao {

	public PatientMedicalTreatmentResp getPatientMedicalTreatmentTotal(
			PatientMedicalTreatmentResp resp);

	public List<PatientMedicalTreatmentResp> getPatientMedicalTreatmentList(
			PatientMedicalTreatmentResp resp);

	public PatientMedicalTreatmentResp getPatientMedicalTreatmentDetail(
			PatientMedicalTreatmentResp resp);

	public List<String> getOtherDiagnosisList(PatientMedicalTreatmentResp resp);
}
