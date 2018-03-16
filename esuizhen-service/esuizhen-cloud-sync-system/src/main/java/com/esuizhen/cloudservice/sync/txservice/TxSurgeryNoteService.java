package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;

public interface TxSurgeryNoteService {

	MedicalRecord syncSurgery(TPatientSurgeryNoteDetailInfo surgeryInfo);

	boolean mergeSurgeryNote(String patientUuid, Long patientId);

}
