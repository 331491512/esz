package com.esuizhen.cloudservice.statistics.dao;

/**
 * 导出数据文件模板配置信息
 * @author YYCHEN
 *
 */
public interface StatsExportTemplateDao {

	/**
	 * 根据模板ID获取导出文件的表头定义信息
	 * @param exportTemplateId
	 * @return
	 */
	String findExportTitleInfo(String exportTemplateId);
	
}
