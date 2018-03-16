package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsExerciseInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsFoodInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSleepInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSmokeInfo;
import com.esuizhen.cloudservice.ehr.bean.RiskfactorsSotInfo;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.RiskfactorsInfoDao;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.CommonService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsExerciseInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsFoodInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsSleepInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsSmokeInfoService;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.RiskfactorsSotInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("riskfactorsInfoService")
public class RiskfactorsInfoServiceImpl extends CommonServiceImpl<RiskfactorsInfo> implements RiskfactorsInfoService {
	@Autowired
	private RiskfactorsInfoDao riskfactorsInfoDao;
	
	@Autowired
	private RiskfactorsExerciseInfoService riskFactorsExerciseService;
	@Autowired
	private RiskfactorsFoodInfoService riskFactorsFoodService;
	@Autowired
	private RiskfactorsSleepInfoService riskFactorsSleepService;
	@Autowired
	private RiskfactorsSmokeInfoService riskFactorsSmokeService;
	@Autowired
	private RiskfactorsSotInfoService riskFactorsSotService;
	
	@Autowired
	@Qualifier("riskfactorsExerciseInfoService")
	private CommonService<RiskfactorsExerciseInfo> riskfactorsExerciseInfoService;
	
	@Autowired
	@Qualifier("riskfactorsFoodInfoService")
	private CommonService<RiskfactorsFoodInfo> riskfactorsFoodInfoService;
	
	@Autowired
	@Qualifier("RiskfactorsSleepInfoService")
	private CommonService<RiskfactorsSleepInfo> riskfactorsSleepInfoService;
	
	@Autowired
	@Qualifier("riskfactorsSmokeInfoService")
	private CommonService<RiskfactorsSmokeInfo> riskfactorsSmokeInfoService;
	
	@Autowired
	@Qualifier("riskfactorsSotInfoService")
	private CommonService<RiskfactorsSotInfo> riskfactorsSotInfoService;
	
	@Override
	public CommonDao<RiskfactorsInfo> getCommonDao() {
		return riskfactorsInfoDao;
	}
	
	@Transactional
	@Override
	public int insertRiskfactorsInfo(RiskfactorsInfo riskfactorsInfo){
		int res = 0;
		if(riskfactorsInfo != null) {
			String[] riskfactorsTypeIds = riskfactorsInfo.getRiskfactorsTypeId().split(",");
			riskfactorsInfo.setRiskfactorsId(GeneralUtil.generateUniqueID("RISK"));
			res += super.save(riskfactorsInfo);
			for(int i = 0;i < riskfactorsTypeIds.length;i++) {
				switch(Integer.valueOf(riskfactorsTypeIds[i])) {
					case 1:
						RiskfactorsSmokeInfo smokeInfo = riskfactorsInfo.getSmokeInfo();
						if(smokeInfo != null) {
							smokeInfo.setRiskfactorsId(riskfactorsInfo.getRiskfactorsId());
							res += riskFactorsSmokeService.insertRiskfactorsSmokeInfo(smokeInfo);
						}
						break;
					case 2:
						RiskfactorsSotInfo sotInfo = riskfactorsInfo.getSotInfo();
						if(sotInfo != null) {
							sotInfo.setRiskfactorsId(riskfactorsInfo.getRiskfactorsId());
							res += riskFactorsSotService.insertRiskfactorsSotInfo(sotInfo);
						}
						break;
					case 3:
						RiskfactorsFoodInfo foodInfo = riskfactorsInfo.getFoodInfo();
						if(foodInfo != null) {
							foodInfo.setRiskfactorsId(riskfactorsInfo.getRiskfactorsId());
							res += riskFactorsFoodService.insertRiskfactorsFoodInfo(foodInfo);
						}
						break;
					case 4:
						RiskfactorsExerciseInfo exerciseInfo = riskfactorsInfo.getExerciseInfo();
						if(exerciseInfo != null) {
							exerciseInfo.setRiskfactorsId(riskfactorsInfo.getRiskfactorsId());
							res += riskFactorsExerciseService.insertRiskfactorsExerciseInfo(exerciseInfo);
						}
						break;
					case 5:
						RiskfactorsSleepInfo sleepInfo = riskfactorsInfo.getSleepInfo();
						if(sleepInfo != null) {
							sleepInfo.setRiskfactorsId(riskfactorsInfo.getRiskfactorsId());
							res += riskFactorsSleepService.insertRiskfactorsSleepInfo(sleepInfo);
						}
						break;
				}
			}
		}
		return res;
	}

	@Override
	public RiskfactorsInfo queryRiskfactorsInfo(CommonReq req) {
		RiskfactorsInfo riskfactorsInfo = super.queryOne(req);
		if(riskfactorsInfo != null) {
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("riskfactorsId", riskfactorsInfo.getRiskfactorsId());
			riskfactorsInfo.setSmokeInfo(riskfactorsSmokeInfoService.queryOne(paramsMap));
			riskfactorsInfo.setSotInfo(riskfactorsSotInfoService.queryOne(paramsMap));
			riskfactorsInfo.setFoodInfo(riskfactorsFoodInfoService.queryOne(paramsMap));
			riskfactorsInfo.setExerciseInfo(riskfactorsExerciseInfoService.queryOne(paramsMap));
			riskfactorsInfo.setSleepInfo(riskfactorsSleepInfoService.queryOne(paramsMap));
		}
		return riskfactorsInfo;
	}

	@Override
	public void deleteRiskfactorsInfo(Map<String, Object> paramsMap) {
		riskfactorsInfoDao.deleteRiskfactorsInfo(paramsMap);
	}
}
