package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 
import java.util.Map;

import com.esuizhen.cloudservice.ehr.model.meta.SpecialDiseaseDiagnosisMeta;



public interface TMetaInfoDiagnosisBasisDao<T>{
	
	
	public List<SpecialDiseaseDiagnosisMeta> getSpecialDiseaseDiagnosisMeta(Map<String,String> param);
}
