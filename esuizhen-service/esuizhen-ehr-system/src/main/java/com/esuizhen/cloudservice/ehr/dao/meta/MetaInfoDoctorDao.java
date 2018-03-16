package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoDoctor;

public interface MetaInfoDoctorDao{
	
	public List<TMetaInfoDoctor> getMetaInfoDoctorList (@Param("trueName")String trueName);
	
}
