package com.esuizhen.cloudservice.followup.dao.exporttemplate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.followup.bean.PatientExportTemplate;

public interface PatientExportTemplateDao {
	/**
	 * 通过id获取导出模板信息
	 * @param exportTemplateId
	 * @return
	 */
	PatientExportTemplate queryById(@Param("exportTemplateId") String exportTemplateId);
	/**
	 * 查询需要导出的数据
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List queryExprotData(@Param("sql") String sql);
}
