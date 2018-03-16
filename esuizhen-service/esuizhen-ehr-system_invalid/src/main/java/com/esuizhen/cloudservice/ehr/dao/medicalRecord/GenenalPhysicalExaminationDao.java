package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.GenenalExaminationInfo;

public interface GenenalPhysicalExaminationDao {

	public GenenalExaminationInfo queryGenenalPhysicalExamination(AttendPatientReq req);
	
	public Integer insertGenenalPhysicalExamination(GenenalExaminationInfo info);
	
	public Integer updateGenenalPhysicalExaminationSelective(GenenalExaminationInfo info);
	
	public Integer updateGenenalPhysicalExamination(GenenalExaminationInfo info);
	
	public void deleteGenenalPhysicalExamination(@Param("physicalExaminationResultId") String physicalExaminationResultId);
	
}
