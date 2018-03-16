package com.esuizhen.cloudservice.sync.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.dao.cloud.CheckBeforeSyncDao;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;


@Service
public class CheckBeforeSyncServiceImpl implements CheckBeforeSyncService {

	@Autowired
	private CheckBeforeSyncDao checkBeforeSyncDao;
	/**
	 * author:fanpanwei
	 */
	@Override
	public boolean checkHospitalId(Integer hospitalId) {
		// TODO Auto-generated method stub
		Integer resultNum = this.checkBeforeSyncDao.judgeHospitalRight(hospitalId);
		if(resultNum!=null&&1==resultNum)return true;
		return false;
	}
	
}
