package com.esuizhen.cloudservice.user.dao.followuppatient;

import com.esuizhen.cloudservice.user.model.followuppatient.TPatientExportTemplateInfo;


public interface TPatientExportTemplateInfoDao {
	/**
	 * 根据模板id获取对应的title等信息
	 * @param id
	 * @return
	 */
	TPatientExportTemplateInfo getPatientExportTemplateById(String id);
}