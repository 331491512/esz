package com.esuizhen.base.service.global.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.base.dao.global.GreyTestControlDao;
import com.esuizhen.base.dao.global.GreyTestPatientDao;
import com.esuizhen.base.model.GreyTestControl;
import com.esuizhen.base.model.GreyTestPatient;
import com.esuizhen.base.service.global.GreyTestService;

@Service
public class GreyTestServiceImpl implements GreyTestService{

	@Autowired 
	private GreyTestControlDao greyTestControlDao;
	
	@Autowired
	private GreyTestPatientDao greyTestPatientDao;
	
	@Override
	public Integer getTwGreyTestControl() {
		Integer greyTestCtlFlag=0;
		GreyTestControl greyTestControl=this.greyTestControlDao.getGreyTestControlByProductType(1);
		if(greyTestControl!=null){
			greyTestCtlFlag=greyTestControl.getGreyTestCtlFlag();
		}
		return greyTestCtlFlag;
	}

	@Override
	public List<GreyTestPatient> listTwGreyTestPatient() {
		return this.greyTestPatientDao.listGreyTestPatient(1);
	}
}
