package com.esuizhen.cloudservice.ehr.dao.disease;

import java.util.List;

import org.apache.ibatis.annotations.Param;
/**
 * 
* @ClassName: MetaEdiseaseTypeKeywordDao 
* @Description: 根据诊断反查疾病Id 
* @author LIPENG
* @date 2016年3月1日 下午2:38:06 
*
 */
public interface MetaEdiseaseTypeKeywordDao {
	public List<Integer> queryDieasetypeByDiagnosis(@Param("diagnosis") String diagnosis);
}
