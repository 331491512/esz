package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.followuppatient.TMetaInfoSimilarTypeDao;
import com.esuizhen.cloudservice.user.model.followuppatient.TMetaInfoSimilarType;
import com.esuizhen.cloudservice.user.service.followuppatient.TMetaInfoSimilarTypeService;

@Service
public class TMetaInfoSimilarTypeServiceImpl implements
		TMetaInfoSimilarTypeService {
	
	@Autowired
	private TMetaInfoSimilarTypeDao similarTypeDao;

	@Override
	public List<TMetaInfoSimilarType> selectAllList() {
		return similarTypeDao.selectAllList();
	}
}
