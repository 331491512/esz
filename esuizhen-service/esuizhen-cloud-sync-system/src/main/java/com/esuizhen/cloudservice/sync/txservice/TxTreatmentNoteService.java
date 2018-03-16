package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.RejectRequestExcption;

public interface TxTreatmentNoteService {

	public MedicalRecord syncTreatmentNote(EciTreatmentNote treatmentNote) throws RejectRequestExcption;
	
	public boolean mergeTreatmentNote(String patientFinalUuid, Long patientId);

}
