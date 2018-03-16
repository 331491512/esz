package com.esuizhen.cloudservice.sync.service;

import com.esuizhen.cloudservice.sync.model.DiseaseTypeICD10;

public interface DiseaseTypeICD10Service {
	/**
	 * <p>Title:getDiseaseTypeIdByDiseaseCode</p>
	 * <p>Description:通过ICD编码值获取病种与ICD-10对应关系</p>
	 * @author YYCHEN
	 * @date 2016年6月14日 下午5:56:48
	 * @param diseaseCode
	 * @return
	 */
	public DiseaseTypeICD10 getDiseaseTypeIdByDiseaseCode(String diseaseCode);
}
