package com.esuizhen.cloudservice.followup.service.followupTable.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.bean.FollowupTableReq;
import com.esuizhen.cloudservice.followup.dao.followupTableDao.FollowupTableDao;
import com.esuizhen.cloudservice.followup.service.followupTable.FollowupTableService;


@Service
public class FollowupTableServiceImpl implements FollowupTableService {
	@Autowired
	private FollowupTableDao followupTableDao;
	
	@Override
	public Integer isOpenedFollowupTable(Integer patientId) {
		// TODO Auto-generated method stub
		return followupTableDao.isOpenedFollowupTable(patientId);
	}
	
	@Override
	public FollowupTableReq getFollowupTable(Integer patientId) {
		// TODO Auto-generated method stub
		return followupTableDao.getFollowupTable(patientId,patientId);
	}


	@Override
	public void updateFollowupTable(FollowupTableReq followupTableReq) {
		// TODO Auto-generated method stub
		followupTableDao.updateDiagnosis(followupTableReq);
		String str="";
		if(StringUtils.isNotBlank(followupTableReq.getTumourPeriodizationT())){
			str+=followupTableReq.getTumourPeriodizationT();
		}
		if(StringUtils.isNotBlank(followupTableReq.getTumourPeriodizationN())){
			str+=followupTableReq.getTumourPeriodizationN();
		}
		if(StringUtils.isNotBlank(followupTableReq.getTumourPeriodizationM1())){
			str+=followupTableReq.getTumourPeriodizationM1();
		}
		if(StringUtils.isNotBlank(str)){
			followupTableReq.setTumourPeriodization(str);
		}
		followupTableDao.updateInhospitalNote(followupTableReq);
		followupTableDao.updateUser(followupTableReq);
		followupTableDao.updateVarPatientMedical(followupTableReq);
		followupTableDao.updatePatient(followupTableReq);
	}

}
