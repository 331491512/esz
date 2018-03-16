package com.esuizhen.cloudservice.ehr.service.meta;

import com.westangel.common.bean.UserDefinedMetaData;

public interface MetaDataUserDefinedService {

	public int addMetaDateInIntKey(UserDefinedMetaData metaData);

	public String addMetaDateInStrKey(UserDefinedMetaData metaData);
	
}
