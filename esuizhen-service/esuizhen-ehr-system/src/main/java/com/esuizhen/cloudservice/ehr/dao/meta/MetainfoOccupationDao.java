package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoOccupation;

public interface MetainfoOccupationDao{
	
	public List<TMetaInfoOccupation> getMetaInfoOccupationList(@Param("occupationName")String occupationName);
	public List<TMetaInfoOccupation> getMetaInfoOccupationListByName(@Param("occupationName")String occupationName);
	
}
