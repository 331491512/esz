package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoRelationDao;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoRelation;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoRelationService;


@Service("relationService")
public class TMetaInfoRelationServiceImpl implements TMetaInfoRelationService {
	
	@Autowired
	private TMetaInfoRelationDao relationDao;

	@Override
	public List<TMetaInfoRelation> selectListAll() {
		return relationDao.selectListAll();
	}

}
