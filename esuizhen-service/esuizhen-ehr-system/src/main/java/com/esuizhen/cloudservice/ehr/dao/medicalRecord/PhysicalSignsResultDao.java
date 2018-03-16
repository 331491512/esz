package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.PhysicalSigns;

public interface PhysicalSignsResultDao {
	
	public List<PhysicalSigns>queryPhysicalSigns(AttendPatientReq req);
	
	public Integer insertPhysicalSigns(PhysicalSigns info);
	
	public Integer updatePhysicalSigns(PhysicalSigns info);
	
	public void deletePhysicalSigns(@Param("physicalSignsResultId") String physicalSignsResultId);
	
}
