package com.esuizhen.cloudservice.ehr.service.medicalRecord;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.dao.medicalRecord.CommonDao;
import com.westangel.common.bean.Page;


public interface CommonService<T> {
	CommonDao<T> getCommonDao();
	/**
	 * 根据条件查询列表
	 * @param obj
	 * @return
	 */
	List<T> queryList(Object obj);
	
	/**
	 * 查询单条记录
	 * @param obj
	 * @return
	 */
	T queryOne(Object obj);
	
	/**
	 * 查询分页列表
	 * @param paramsMap
	 * @return
	 */
	Page<T> queryPageList(Map<String,Object> paramsMap);
	/**
	 * 插入
	 * @param t
	 * @return
	 */
	int save(T t);
	
	/**
	 * 根据主键删除
	 * @param keyId 主键id
	 * @return
	 */
	int deleteByPrimaryKey(String primaryKeyId);
}
