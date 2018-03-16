package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.model.EciTreatmentNote;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;

public interface TreatmentNoteService {

	/**
	 * <p>syncTreatmentNote</p>
	 * <p>Description:同步治疗表到云端生产库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 上午11:45:11
	 * @param clinicMedicalInfo
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws HospitalWithoutRightExcption 
	 */
	void syncTreatmentNote(EciTreatmentNote treatmentNoteInfo) throws RejectRequestExcption, HospitalWithoutRightExcption;

}
