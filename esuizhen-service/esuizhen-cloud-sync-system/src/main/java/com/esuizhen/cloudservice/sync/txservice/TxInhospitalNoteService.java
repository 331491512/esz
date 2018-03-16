package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;

public interface TxInhospitalNoteService {

	MedicalRecord syncInhospitalNote(TPatientInHospitalNoteDetailInfo patientInHospitalNoteDetailInfo);

	boolean mergeInhospitalNote(String patientFinalUuid, Long patientId);

}
