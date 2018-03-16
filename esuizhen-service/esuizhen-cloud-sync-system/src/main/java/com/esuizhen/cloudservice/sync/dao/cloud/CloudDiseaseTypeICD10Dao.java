package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.sync.model.DiseaseTypeICD10;

/**
 * 
 * @author YYCHEN
 *
 */
public interface CloudDiseaseTypeICD10Dao {

	/**
	 * 
	 * @param hospitalId
	 * @param diseaseCode
	 * @param length
	 * @return
	 */
	public List<DiseaseTypeICD10> findByDiseaseCode(@Param("hospitalId")Integer hospitalId, @Param("diseaseCode")String diseaseCode, @Param("length") Integer length);
	/**
	 * <p>Title: findByDiseaseContent</p>
	 * <p>Description: 根据诊断内容查找病种</p>
	 * @date 2016年4月8日 下午2:54:47
	 * @param diseaseContent
	 * @return
	 */
	public List<DiseaseTypeICD10> findByDiseaseContent(@Param("hospitalId")Integer hospitalId, @Param("diseaseContent")String diseaseContent);
}
