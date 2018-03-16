package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.bean.TOutHospitalNoteInfo;
import com.esuizhen.cloudservice.sync.model.MedicalRecord;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.excption.RejectRequestExcption;

public interface OutHospitalNoteService {

	/**
	 * <p>Title:syncOutHospitalNoteInfo</p>
	 * <p>Description:同步出院小结表到云端生产库</p>
	 * @author fanpanwei
	 * @date 2016年9月7日 上午11:45:11
	 * @param clinicMedicalInfo
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws HospitalWithoutRightExcption 
	 */
	MedicalRecord syncOutHospitalInfo(TOutHospitalNoteInfo outHospitalNoteInfo) throws RejectRequestExcption, HospitalWithoutRightExcption;

}
