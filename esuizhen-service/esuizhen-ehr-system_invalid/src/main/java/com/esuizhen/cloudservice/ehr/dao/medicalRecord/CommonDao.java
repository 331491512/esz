package com.esuizhen.cloudservice.ehr.dao.medicalRecord;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface CommonDao<T> {
	/**
	 * 根据主键删除
	 * @param keyId 主键id
	 * @return
	 */
	int deleteByPrimaryKey(@Param("primaryKeyId") String primaryKeyId);
	/**
	 * 插入
	 * @param t
	 * @return
	 */
    int insert(T t);
    /**
     * 选择性插入
     * @param record
     * @return
     */
    int insertSelective(T t);
    
    /**
     * 根据主键id查询
     * @param keyId 主键id
     * @return
     */
    T selectByPrimaryKey(String keyId);
    
    /**
     * 根据主键选择性更新
     * @param t 更新内容
     * @return
     */
    int updateByPrimaryKeySelective(T t);
    
    /**
     * 根据主键更新
     * @param t 更新内容
     * @return
     */
    int updateByPrimaryKey(T t);
    
    List<T> queryList(Object obj);
    
    /**
     * 查询单条记录
     * @param obj
     * @return
     */
    T queryOne(Object obj);
}
