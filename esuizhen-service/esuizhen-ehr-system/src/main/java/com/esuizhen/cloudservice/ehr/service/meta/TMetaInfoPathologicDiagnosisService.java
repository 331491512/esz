package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List;


public interface TMetaInfoPathologicDiagnosisService<T>{
	
	/**
	 * 模糊查询病理诊断
	 * @param searchItem
	 * @return
	 */
	List<T> queryListLike(String searchItem);
}
