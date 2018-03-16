package com.esuizhen.cloudservice.statistics.service;

import java.util.List;

import com.esuizhen.cloudservice.statistics.model.TStatsExportTemplateInfo;


public interface StatsExportInfoService {
	
	/**
	 * 查询统计导出模板
	 * @param exportTemplateId
	 * @return
	 */
	TStatsExportTemplateInfo statsExportTemplate(String exportTemplateId);
	
	/**
	 *  统计导出
	 * @param paramsMap
	 * @return
	 */
	List<String> statsExportValue(String exportTemplateId, Integer searchId);
}
