package com.esuizhen.cloudservice.ehr.service.inhospital;

import java.util.List;

import com.esuizhen.cloudservice.ehr.bean.PatientInHospitalNoteListReq;
import com.esuizhen.cloudservice.ehr.bean.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalTurnRecord;
import com.westangel.common.bean.Page;

public interface InhospitalService {
	//获取患者入院信息
	Page<TInhospitalInfo> getPatienInhospitalList(PatientInHospitalNoteListReq req);
	
	// add by zhuguo 转科情况添加功能
	int addInhospitalTurnRecord(List<InhospitalTurnRecord> req);
	
	// add by zhuguo 转科情况删除功能
	int delInhospitalTurnRecord(List<InhospitalTurnRecord> req);
	
	// add by zhuguo 转科情况查询功能
	List<InhospitalTurnRecord> queryInhospitalTurnRecord(InhospitalTurnRecord req);
}
