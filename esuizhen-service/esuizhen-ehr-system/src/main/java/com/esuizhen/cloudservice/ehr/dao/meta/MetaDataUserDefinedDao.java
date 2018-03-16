package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;

import com.westangel.common.bean.UserDefinedMetaData;

public interface MetaDataUserDefinedDao {

	public int insertMetaData(UserDefinedMetaData data);
	
	public void updateMetaData(UserDefinedMetaData data);
	
	public Integer getUseCount(UserDefinedMetaData data);
	
	public List<Integer> getMetaDataListByNameToInt(UserDefinedMetaData data);
	
	public List<String> getMetaDataListByNameToStr(UserDefinedMetaData data);
}
