package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List; 

import com.esuizhen.cloudservice.ehr.model.meta.SpecialDiseaseDiagnosisMeta;



public interface TMetaInfoDiagnosisBasisService<T>{
	
	/**
	 * @Title: getSpecialDiseaseDiagnosisMeta
	 * @Description:获取特病诊断元
	 **/
	public List<SpecialDiseaseDiagnosisMeta> getSpecialDiseaseDiagnosisMeta(String key);

}
