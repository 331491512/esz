package com.esuizhen.cloudservice.ehr.service.diagnose;

import com.esuizhen.cloudservice.ehr.bean.PatientDiagnosisListReq;
import com.esuizhen.cloudservice.ehr.bean.TDiagnose;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.PatientDiagnosisReq;

public interface DiagnoseService {

	//获取患者诊断列表
	Page<TDiagnose> getPatientDiagnosisList(PatientDiagnosisListReq req);
	
	//创建患者诊断
	void createPatientDiagnosis(PatientDiagnosisReq req);
	
	//修改患者诊断
	void modifyPatientDiagnosis(PatientDiagnosisReq req);
	
	//删除患者诊断信息
	public void delPatientDiagnosis(PatientDiagnosisReq req);
	
}
