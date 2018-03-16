package com.esuizhen.cloudservice.ehr.dao.meta;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.model.meta.MetaInfoDosageUnit;

public interface MetaInfoDosageUnitDao extends CommonDao<MetaInfoDosageUnit>{
	public Integer selectMetaInfoDosageUnitByName(String name);
}