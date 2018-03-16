package com.esuizhen.cloudservice.sync.dao.cloud;

import com.westangel.common.bean.ehr.MetaCDiseaseType;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudMetaCDiseaseTypeDao {
	public MetaCDiseaseType findByDiseaseTypeId(Integer diseaseTypeId);
}
