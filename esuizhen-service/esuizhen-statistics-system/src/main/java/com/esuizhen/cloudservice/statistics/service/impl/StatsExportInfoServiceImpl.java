package com.esuizhen.cloudservice.statistics.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.statistics.dao.StatsExportInfoDao;
import com.esuizhen.cloudservice.statistics.model.TStatsExportTemplateInfo;
import com.esuizhen.cloudservice.statistics.service.StatsExportInfoService;

@Service
public class StatsExportInfoServiceImpl implements StatsExportInfoService{
	
	@Autowired
	private StatsExportInfoDao statsExportInfoDao;

	@Override
	public TStatsExportTemplateInfo statsExportTemplate(String exportTemplateId) {
		TStatsExportTemplateInfo statsExportInfo = statsExportInfoDao.statsExportTemplate(exportTemplateId);
		return statsExportInfo;
	}

	@Override
	public List<String> statsExportValue(String exportTemplateId,
			Integer searchId) {
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("exportTemplateId", exportTemplateId);
		paramsMap.put("searchId", searchId);
		List<String> statsExportValueInfo = statsExportInfoDao.statsExportValue(paramsMap);
		return statsExportValueInfo;
	}
	
}
