package com.esuizhen.cloudservice.ehr.service.hospitalinfo.impl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.THospitalDeptInfoDao;
import com.esuizhen.cloudservice.ehr.model.hospitalinfo.THospitalDeptInfo;
import com.esuizhen.cloudservice.ehr.service.hospitalinfo.THospitalDeptInfoService;


@Service
@Transactional
public class THospitalDeptInfoServiceImpl implements THospitalDeptInfoService{
	
	@Autowired
	private THospitalDeptInfoDao dao;

	@Override
	public List<THospitalDeptInfo> getHospitalDeptList(Long hospitalId)
	{
		return dao.getHospitalDeptList(hospitalId);
	}
	
	
}
