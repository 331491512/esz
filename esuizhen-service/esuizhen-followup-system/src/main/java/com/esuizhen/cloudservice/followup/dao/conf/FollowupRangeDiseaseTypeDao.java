package com.esuizhen.cloudservice.followup.dao.conf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.TFollowupConfigDiseaseType;

public interface FollowupRangeDiseaseTypeDao {

	public void batchInsertFollowupDiseaseType(@Param("followupConfigDiseaseTypeList")List<TFollowupConfigDiseaseType> followupConfigDiseaseTypeList);
	
	public void deleteAllFollowupDiseaseType();
	
	public List<TFollowupConfigDiseaseType> queryAllFollowupDiseaseType();
}
