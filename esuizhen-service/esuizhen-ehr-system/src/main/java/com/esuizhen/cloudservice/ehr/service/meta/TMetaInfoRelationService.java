package com.esuizhen.cloudservice.ehr.service.meta;

import java.util.List; 

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoRelation;



public interface TMetaInfoRelationService{
	
	/**
	 * 查询所有与患者相关的亲属
	 * @return
	 */
	List<TMetaInfoRelation> selectListAll();
}
