package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.bean.AttendPatientReq;
import com.esuizhen.cloudservice.ehr.model.medicalRecord.QualityoflifeInfo;

public interface QualityoflifeInfoDao {

	public QualityoflifeInfo queryQualityoflifeInfo(AttendPatientReq req);
	
	public Integer insertQualityoflifeInfo(QualityoflifeInfo info);
	
	public Integer updateQualityoflifeInfoSelective(QualityoflifeInfo info);
	
	public Integer updateQualityoflifeInfo(QualityoflifeInfo info);
	
	public void deleteQualityoflifeInfo(@Param("qolId") String qolId);
	
}
