package com.esuizhen.cloudservice.ehr.service.posttreatment;

import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentListReq;
import com.esuizhen.cloudservice.ehr.bean.PatientPastTreatmentReq;
import com.esuizhen.cloudservice.ehr.bean.TTreatmentInfo;
import com.westangel.common.bean.Page;

public interface PastTreatmentService {
	
	//获取患者既往治疗
	Page<TTreatmentInfo> getPatientPastTreatmentList(PatientPastTreatmentListReq req);

	//新建既往治疗
	void addPatientPastTreatment(PatientPastTreatmentReq req);

	//修改既往治疗
	void modifyPatientPastTreatment(PatientPastTreatmentReq req);

	//删除既往治疗
	void delPatientPastTreatment(PatientPastTreatmentReq req);
		
}
