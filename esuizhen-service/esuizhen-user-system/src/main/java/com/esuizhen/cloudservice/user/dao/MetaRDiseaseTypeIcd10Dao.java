package com.esuizhen.cloudservice.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.ehr.MetaRDiseaseTypeIcd10;

/**
 * 
 * @author YYCHEN
 *
 */
public interface MetaRDiseaseTypeIcd10Dao {
	
	public List<MetaRDiseaseTypeIcd10> findByDiseaseCode(@Param("hospitalId") Long hospitalId, @Param("diseaseCode")String diseaseCode, @Param("length") Integer length);
	
	public List<MetaRDiseaseTypeIcd10> findByDiseaseContent(@Param("hospitalId")Integer hospitalId, @Param("diseaseContent")String diseaseContent);
}
