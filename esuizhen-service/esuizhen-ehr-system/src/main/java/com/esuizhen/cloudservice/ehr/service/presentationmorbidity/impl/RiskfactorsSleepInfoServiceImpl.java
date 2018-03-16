package com.esuizhen.cloudservice.ehr.service.presentationmorbidity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSleepInfo;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsSleepInfoDao;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.RiskfactorsSleepInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("RiskfactorsSleepInfoService")
public class RiskfactorsSleepInfoServiceImpl extends CommonServiceImpl<RiskfactorsSleepInfo> implements
		RiskfactorsSleepInfoService {
	@Autowired
	private RiskfactorsSleepInfoDao sleepInfoDao;
	
	@Override
	public CommonDao<RiskfactorsSleepInfo> getCommonDao() {
		return sleepInfoDao;
	}

	@Override
	public int insertRiskfactorsSleepInfo(RiskfactorsSleepInfo sleepInfo) {
		sleepInfo.setSleepInfoId(GeneralUtil.generateUniqueID("SLEE"));
		return super.save(sleepInfo);
	}

}
