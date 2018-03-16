package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.RejectRequestExcption;

public interface TxOutHospitalNoteService {

	MedicalRecord syncOutHospitalNote(TOutHospitalNoteInfo outHospitalNoteInfo) throws RejectRequestExcption;
	
	boolean mergeOuthospitalNote(String patientFinalUuid, Long patientId);
}
