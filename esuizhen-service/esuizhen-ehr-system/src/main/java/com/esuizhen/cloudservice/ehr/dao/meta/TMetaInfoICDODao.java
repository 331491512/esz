package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;
import java.util.Map;


public interface TMetaInfoICDODao<T>{
	
	/**
	 * 模糊查询ICD-O
	 * @param param
	 * @return
	 */
	List<T> queryListLike(Map<String,String> param);
}
