package com.esuizhen.cloudservice.ehr.service.meta.impl;

import org.springframework.beans.factory.annotation.Autowired;   
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoDosageUnitDao;
import com.esuizhen.cloudservice.ehr.model.meta.MetaInfoDosageUnit;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.meta.MetaInfoDosageUnitService;


@Service("metaInfoDosageUnitService")
public class MetaInfoDosageUnitServiceImpl extends CommonServiceImpl<MetaInfoDosageUnit> implements MetaInfoDosageUnitService {
	@Autowired
	private MetaInfoDosageUnitDao metaInfoDosageUnitDao;

	@Override
	public CommonDao<MetaInfoDosageUnit> getCommonDao() {
		return metaInfoDosageUnitDao;
	}
}
