package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import com.westangel.common.bean.ehr.MetaEicd10;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MetaEicd10Dao {
	/**
	 * <p>Title: findByDiseaseTypeId</p>
	 * <p>Description: </p>
	 * @date 2016年4月13日 下午4:16:08
	 * @param diseaseTypeId
	 * @return
	 */
	public List<MetaEicd10> findByDiseaseTypeId(Integer diseaseTypeId);
}
