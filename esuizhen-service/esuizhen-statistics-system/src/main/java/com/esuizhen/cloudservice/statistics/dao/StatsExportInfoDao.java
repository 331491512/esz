package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.statistics.model.TStatsExportTemplateInfo;

public interface StatsExportInfoDao {
	
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
	List<String> statsExportValue(Map<String,Object> paramsMap);
}
