package com.esuizhen.cloudservice.ehr.service.disease.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.disease.MetaEdiseaseBodyPartDao;
import com.esuizhen.cloudservice.ehr.model.disease.MetaEdiseaseBodyPart;
import com.esuizhen.cloudservice.ehr.service.disease.MetaEdiseaseBodyPartService;

@Service
@Transactional
public class MetaEdiseaseBodyPartServiceImpl implements MetaEdiseaseBodyPartService{
	
	@Autowired
	private MetaEdiseaseBodyPartDao dao;

	@Override
	public void insertMetaEdiseaseBodyPart(MetaEdiseaseBodyPart metaEdiseaseBodyPart)
	{
		dao.insertMetaEdiseaseBodyPart(metaEdiseaseBodyPart);
	}

	@Override
	public void updateMetaEdiseaseBodyPart(MetaEdiseaseBodyPart metaEdiseaseBodyPart)
	{
		dao.updateMetaEdiseaseBodyPart(metaEdiseaseBodyPart);
	}

	@Override
	public void deleteMetaEdiseaseBodyPart(Long metaEdiseaseBodyPartId)
	{
		dao.deleteMetaEdiseaseBodyPart(metaEdiseaseBodyPartId);
	}

	@Override
	public MetaEdiseaseBodyPart queryMetaEdiseaseBodyPart(Long metaEdiseaseBodyPartId)
	{
		return dao.queryMetaEdiseaseBodyPart(metaEdiseaseBodyPartId);
	}

	@Override
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartTypeList(String diseaseTypeId, String createTime)
	{
		return dao.selectMetaEdiseaseBodyPartTypeList(diseaseTypeId, createTime);
	}

	@Override
	public List<MetaEdiseaseBodyPart> selectMetaEdiseaseBodyPartList()
	{
		return dao.selectMetaEdiseaseBodyPartList();
	}
	
	
}
