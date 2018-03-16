package com.esuizhen.cloudservice.sync.txservice;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.RejectRequestExcption;

public interface TxClinicMedicalNoteService {
	public MedicalRecord syncClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalInfo) throws RejectRequestExcption;

	/**
	 * <p>Title:mergeClinicMedicalNote</p>
	 * <p>Description:将患者的门诊信息合并到生产库</p>
	 * @author YYCHEN
	 * @date 2016年9月8日 上午11:24:47
	 * @param patientFinalUuid
	 * @param patientId
	 * @return
	 */
	public boolean mergeClinicMedicalNote(String patientFinalUuid, Long patientId);
}
