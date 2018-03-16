package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.ehr.bean.RiskfactorsExerciseInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsExerciseInfoDao;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsExerciseInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("riskfactorsExerciseInfoService")
public class RiskfactorsExerciseInfoServiceImpl extends CommonServiceImpl<RiskfactorsExerciseInfo> implements
		RiskfactorsExerciseInfoService {
	@Autowired
	private RiskfactorsExerciseInfoDao exerciseInfoDao;
	
	@Override
	public CommonDao<RiskfactorsExerciseInfo> getCommonDao() {
		return exerciseInfoDao;
	}

	@Override
	public int insertRiskfactorsExerciseInfo(
			RiskfactorsExerciseInfo exerciseInfo) {
		exerciseInfo.setExerciseInfoId(GeneralUtil.generateUniqueID("EXER"));
		return super.save(exerciseInfo);
	}

}
