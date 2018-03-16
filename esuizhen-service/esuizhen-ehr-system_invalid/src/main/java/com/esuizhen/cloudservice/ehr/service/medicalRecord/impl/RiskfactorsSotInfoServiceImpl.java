package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSotInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsSotInfoDao;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsSotInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("riskfactorsSotInfoService")
public class RiskfactorsSotInfoServiceImpl extends CommonServiceImpl<RiskfactorsSotInfo> implements RiskfactorsSotInfoService {
	@Autowired
	private RiskfactorsSotInfoDao sotInfoDao;

	@Override
	public CommonDao<RiskfactorsSotInfo> getCommonDao() {
		return sotInfoDao;
	}

	@Override
	public int insertRiskfactorsSotInfo(RiskfactorsSotInfo sotInfo) {
		sotInfo.setSotInfoId(GeneralUtil.generateUniqueID("RSOT"));
		return super.save(sotInfo);
	}
}
