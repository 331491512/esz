package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;
import java.util.Map;

public interface TMetaInfoICD10Dao<T> {

	/**
	 * 模糊查询ICD10
	 * 
	 * @param param
	 * @return
	 */
	List<T> queryListLike(Map<String, String> param);

	List<T> queryTumorListLike(Map<String, String> param);
}
