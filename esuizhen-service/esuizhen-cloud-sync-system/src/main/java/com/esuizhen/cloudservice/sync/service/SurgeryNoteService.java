package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TPatientSurgeryNoteDetailInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;

/**
 * 
 * @author YYCHEN
 *
 */
public interface SurgeryNoteService {
	/**
	 * 
	 * @param surgeryInfo
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws HospitalWithoutRightExcption 
	 */
	public MedicalRecord syncSurgery(TPatientSurgeryNoteDetailInfo surgeryInfo) throws RejectRequestExcption, HospitalWithoutRightExcption;
}
