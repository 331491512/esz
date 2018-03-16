package com.esuizhen.cloudservice.user.dao.followuppatient;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.dao.CommonDao;
import com.esuizhen.cloudservice.user.model.followuppatient.TMedicalPicInfo;

public interface PatientMedicalPhotoDao extends CommonDao<TMedicalPicInfo>{
	
	List<String> queryEMRPhotoList(@Param("emrId")String emrId);
}
