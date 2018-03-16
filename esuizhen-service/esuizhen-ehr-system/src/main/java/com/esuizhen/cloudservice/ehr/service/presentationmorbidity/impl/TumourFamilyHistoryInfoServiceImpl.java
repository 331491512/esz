package com.esuizhen.cloudservice.ehr.service.presentationmorbidity.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.TumourFamilyHistoryInfo;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.TumourFamilyHistoryInfoDao;
import com.esuizhen.cloudservice.ehr.service.presentationmorbidity.TumourFamilyHistoryInfoService;
import com.westangel.common.util.GeneralUtil;
@Service("tumourFamilyHistoryInfoService")
public class TumourFamilyHistoryInfoServiceImpl extends CommonServiceImpl<TumourFamilyHistoryInfo> implements
		TumourFamilyHistoryInfoService {
	@Autowired
	private TumourFamilyHistoryInfoDao familyHistoryInfoDao;

	@Override
	public CommonDao<TumourFamilyHistoryInfo> getCommonDao() {
		return familyHistoryInfoDao;
	}
	
	@Transactional
	@Override
	public int batchInsertTumourFamilyHistoryInfo(
			List<TumourFamilyHistoryInfo> tumourFamilyHistoryInfos) {
		int res = 0;
		if(tumourFamilyHistoryInfos != null && tumourFamilyHistoryInfos.size() > 0) {
			
			for(TumourFamilyHistoryInfo familyHistoryInfo : tumourFamilyHistoryInfos) {
				familyHistoryInfo.setFamilyHistoryId(GeneralUtil.generateUniqueID("TFHI"));
				res += super.save(familyHistoryInfo);
			}
		}
		return res;
	}

	@Override
	public void deleteTumourFamilyHistoryInfo(Map<String, Object> paramsMap) {
		familyHistoryInfoDao.deleteTumourFamilyHistoryInfo(paramsMap);
	}
}
