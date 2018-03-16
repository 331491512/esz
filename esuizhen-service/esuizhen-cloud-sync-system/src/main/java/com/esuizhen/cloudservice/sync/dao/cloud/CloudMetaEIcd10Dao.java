package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import com.westangel.common.bean.ehr.MetaEicd10;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudMetaEIcd10Dao {
	/**
	 * 根据病种查找诊断
	 * @param diseaseTypeId
	 * @return
	 */
	public List<MetaEicd10> findByDiseaseTypeId(Integer diseaseTypeId);
}
