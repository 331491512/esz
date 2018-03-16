package com.esuizhen.cloudservice.ehr.service.outhospital.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.TOutHospitalInfo;
import com.esuizhen.cloudservice.ehr.dao.patient.InHospitalDao;
import com.esuizhen.cloudservice.ehr.service.outhospital.OuthospitalService;
import com.westangel.common.excption.EmptyObjectExcption;

@Service
public class OuthospitalServiceImpl implements OuthospitalService {
	
	@Autowired
	private InHospitalDao inhospitalDao;
	
	@Override
	public List<TOutHospitalInfo> getOutHospitalDateList(Long patientId, Integer hospitalId)throws EmptyObjectExcption {
		// TODO Auto-generated method stub
		if(patientId==null)
			throw new EmptyObjectExcption(" patientId is empty");
		if(hospitalId==null)
			throw new EmptyObjectExcption(" hospitalId is empty");
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("patientId", patientId);
		param.put("hospitalId", hospitalId);
		return inhospitalDao.queryPatientOutHospitalDate(param);
	}
}
