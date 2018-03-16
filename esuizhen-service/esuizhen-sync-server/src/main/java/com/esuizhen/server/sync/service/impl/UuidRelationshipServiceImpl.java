package com.esuizhen.server.sync.service.impl;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.esuizhen.server.sync.dao.server.PatientDao;
import com.esuizhen.server.sync.dao.server.UuidRelationshipDao;
import com.esuizhen.server.sync.service.UuidRelationshipService;

/**
 * Created by Nidan on 2017年03月21 上午 11:54
 */
public class UuidRelationshipServiceImpl implements UuidRelationshipService {

    @Autowired
    private UuidRelationshipDao uuidRelationshipDao;

    @Autowired
    private PatientDao patientDao;

    @Override
    public LinkedHashMap getTruePatientInfo(LinkedHashMap map) {
        return map;
    }

	@Override
	public String getFinalUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPatientId(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDoctorId(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDeptId(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}
}
