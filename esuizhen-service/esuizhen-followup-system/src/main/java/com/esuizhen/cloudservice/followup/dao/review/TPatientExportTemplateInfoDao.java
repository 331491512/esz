package com.esuizhen.cloudservice.followup.dao.review;

import com.esuizhen.cloudservice.followup.model.review.TPatientExportTemplateInfo;


public interface TPatientExportTemplateInfoDao {
	/**
	 * 根据模板id获取对应的title等信息
	 * @param id
	 * @return
	 */
	TPatientExportTemplateInfo getPatientExportTemplateById(String id);
}