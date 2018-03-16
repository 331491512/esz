package com.esuizhen.cloudservice.user.dao.followuppatient;

import java.util.List;

import com.esuizhen.cloudservice.user.model.followuppatient.TMetaInfoSimilarType;

public interface TMetaInfoSimilarTypeDao {
    int deleteByPrimaryKey(Integer id);

    int insert(TMetaInfoSimilarType record);

    int insertSelective(TMetaInfoSimilarType record);

    TMetaInfoSimilarType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TMetaInfoSimilarType record);

    int updateByPrimaryKey(TMetaInfoSimilarType record);
    
    /**
	 * 查询所有疑似重复数据
	 * @return
	 */
    List<TMetaInfoSimilarType> selectAllList();
}