package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TClinicMedicalNoteInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;

public interface ClinicMedicalNoteService {

	/**
	 * <p>Title:syncClinicMedicalInfo</p>
	 * <p>Description:同步患者门诊信息到云端生产库</p>
	 * @author YYCHEN
	 * @date 2016年9月7日 上午11:45:11
	 * @param clinicMedicalInfo
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws HospitalWithoutRightExcption 
	 */
	MedicalRecord syncClinicMedicalInfo(TClinicMedicalNoteInfo clinicMedicalNoteInfo) throws RejectRequestExcption, HospitalWithoutRightExcption;

}
