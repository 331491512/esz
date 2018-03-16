package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List;


public interface TMetaInfoICD10Service<T>{
	
	/**
	 * 模糊查询ICD10
	 * @param searchItem
	 * @return
	 */
	List<T> queryListLike(String searchItem);
}
