package com.esuizhen.cloudservice.business.service.business.mdt.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.business.bean.TPatientActivitySignupReq;
import com.esuizhen.cloudservice.business.dao.business.mdt.PatientActivityDao;
import com.esuizhen.cloudservice.business.service.business.mdt.PatientActivityService;



/** 
 * @ClassName: PatientActivityServiceImpl.java
 * @Description: 
 * @author fanpanwei	
 * @date   2016年9月28日
 */
@Service
public class PatientActivityServiceImpl implements PatientActivityService {
	@Autowired
	private PatientActivityDao patientActivityDao;
	
	
	@Override
	public Integer searchPatientActivity(TPatientActivitySignupReq req) {
		// TODO Auto-generated method stub
		Integer id = patientActivityDao.searchPatientActivity(req);
		return id;
	}
	
	@Override
	public void markPatientActivity(TPatientActivitySignupReq req) {
		// TODO Auto-generated method stub
		patientActivityDao.insertPatientActivity(req);
	}




}
