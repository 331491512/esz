package com.esuizhen.cloudservice.ehr.service.icd10.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.icd10.MetaEicd10Dao;
import com.esuizhen.cloudservice.ehr.model.icd10.MetaEicd10;
import com.esuizhen.cloudservice.ehr.service.icd10.MetaEicd10Service;

@Service
@Transactional
public class MetaEicd10ServiceImpl implements MetaEicd10Service{
	
	@Autowired
	private MetaEicd10Dao dao;
	
	@Override
	public void insertMetaEicd10(MetaEicd10 metaEicd10)
	{
		dao.insertMetaEicd10(metaEicd10);
	}
	
	@Override
	public void updateMetaEicd10(MetaEicd10 metaEicd10)
	{
		dao.updateMetaEicd10(metaEicd10);
	}
	
	@Override
	public void deleteMetaEicd10(Long diseaseCode)
	{
		dao.deleteMetaEicd10ByCode(diseaseCode);
	}
	
	@Override
	public MetaEicd10 queryMetaEicd10(Long diseaseCode)
	{
		return dao.queryMetaEicd10ByCode(diseaseCode);
	}

	@Override
	public List<MetaEicd10> selectMetaEicd10List(String createTime)
	{
		return dao.selectMetaEicd10List(null , null , null , createTime);
	}

	@Override
	public List<MetaEicd10> selectMetaEicd10List(String diseaseTypeId, String diseaseBodyPartId, String diseaseCode)
	{
		return dao.selectMetaEicd10List(diseaseCode, diseaseTypeId, diseaseBodyPartId, null);
	}
	
}
