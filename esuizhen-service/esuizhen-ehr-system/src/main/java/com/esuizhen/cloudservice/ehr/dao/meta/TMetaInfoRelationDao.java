package com.esuizhen.cloudservice.ehr.dao.meta;

import java.util.List; 

import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoRelation;


public interface TMetaInfoRelationDao {
    TMetaInfoRelation selectByPrimaryKey(Integer relationId);
    
    List<TMetaInfoRelation> selectListAll();
}