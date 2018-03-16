package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.esuizhen.cloudservice.sync.bean.TPatientInHospitalNoteDetailInfo;
import com.westangel.common.excption.HospitalWithoutRightExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface InhospitalNoteService {
	
	public MedicalRecord syncInhospitalNote(TPatientInHospitalNoteDetailInfo patientInHospitalNoteDetailInfo) throws HospitalWithoutRightExcption;
}
