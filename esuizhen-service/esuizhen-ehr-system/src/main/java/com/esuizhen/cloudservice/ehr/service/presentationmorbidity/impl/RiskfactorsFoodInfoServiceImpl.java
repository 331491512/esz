package com.esuizhen.cloudservice.ehr.service.presentationmorbidity.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsFoodInfo;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsFoodInfoDao;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.RiskfactorsFoodInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("riskfactorsFoodInfoService")
public class RiskfactorsFoodInfoServiceImpl extends CommonServiceImpl<RiskfactorsFoodInfo> implements
		RiskfactorsFoodInfoService {
	@Autowired
	private RiskfactorsFoodInfoDao foodInfoDao;
	
	@Override
	public CommonDao<RiskfactorsFoodInfo> getCommonDao() {
		return foodInfoDao;
	}

	@Override
	public int insertRiskfactorsFoodInfo(RiskfactorsFoodInfo foodInfo) {
		foodInfo.setFoodInfoId(GeneralUtil.generateUniqueID("FOOD"));
		this.save(foodInfo);
		return 0;
	}

}
