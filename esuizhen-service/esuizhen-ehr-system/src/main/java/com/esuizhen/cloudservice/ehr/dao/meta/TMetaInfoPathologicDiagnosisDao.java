package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List;
import java.util.Map;


public interface TMetaInfoPathologicDiagnosisDao<T>{
	
	/**
	 * 模糊查询病理诊断
	 * @param param
	 * @return
	 */
	List<T> queryListLike(Map<String,String> param);
}
