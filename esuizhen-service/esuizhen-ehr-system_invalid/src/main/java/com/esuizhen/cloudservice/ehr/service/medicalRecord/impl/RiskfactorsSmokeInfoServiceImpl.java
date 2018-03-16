package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSmokeInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsSmokeInfoDao;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsSmokeInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("riskfactorsSmokeInfoService")
public class RiskfactorsSmokeInfoServiceImpl extends CommonServiceImpl<RiskfactorsSmokeInfo> implements
		RiskfactorsSmokeInfoService {
	@Autowired
	private RiskfactorsSmokeInfoDao smokeInfoDao;

	@Override
	public CommonDao<RiskfactorsSmokeInfo> getCommonDao() {
		return smokeInfoDao;
	}

	@Override
	public int insertRiskfactorsSmokeInfo(RiskfactorsSmokeInfo smokeInfo) {
		smokeInfo.setSmokeInfoId(GeneralUtil.generateUniqueID("SMOK"));
		return super.save(smokeInfo);
	}
}
