package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List;


public interface TMetaInfoICDOService<T>{
	
	/**
	 * 模糊查询ICD-O
	 * @param searchItem
	 * @return
	 */
	List<T> queryListLike(String searchItem);
}
