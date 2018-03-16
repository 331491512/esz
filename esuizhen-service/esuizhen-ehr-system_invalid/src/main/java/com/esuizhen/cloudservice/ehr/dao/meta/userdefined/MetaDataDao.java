package com.esuizhen.cloudservice.ehr.dao.meta.userdefined;

import java.util.List;

import com.westangel.common.bean.UserDefinedMetaData;

public interface MetaDataDao {

	public int insertMetaData(UserDefinedMetaData data);
	
	public void updateMetaData(UserDefinedMetaData data);
	
	public Integer getUseCount(UserDefinedMetaData data);
	
	public List<Integer> getMetaDataCountByName(UserDefinedMetaData data);
}
