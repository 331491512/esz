package com.esuizhen.cloudservice.ehr.service.meta.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.dao.meta.TMetaInfoIncisionHealingDao;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoIncisionHealing;
import com.esuizhen.cloudservice.ehr.service.meta.TMetaInfoIncisionHealingService;


@Service("incisionHealingService")
public class TMetaInfoIncisionHealingServiceImpl implements
		TMetaInfoIncisionHealingService<TMetaInfoIncisionHealing> {
	
	@Autowired
	private TMetaInfoIncisionHealingDao<TMetaInfoIncisionHealing> incisionHealingDao;

	@Override
	public List<TMetaInfoIncisionHealing> selectByListAll() {
		return incisionHealingDao.selectByListAll();
	}

}
