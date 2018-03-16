package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoSurgeryIntensive;


public interface MetaInfoSurgeryIntensiveDao{
	
	public List<TMetaInfoSurgeryIntensive> getMetaInfoSurgeryIntensiveList(@Param("surgeryCode")String surgeryCode,@Param("surgeryName")String surgeryName);
	
}
