package com.esuizhen.cloudservice.user.dao;

import java.util.List;
import java.util.Map;

public interface CommonDao<T> {
	/**
	 * 列表查询（包括分页、非分页列表）
	 * @param paramsMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<T> queryList(Map paramsMap);
	
	/**
	 * 查询单条记录
	 * @param obj
	 * @return
	 */
	T queryOne(Object obj);
	
	/**
	 * 插入信息
	 * @param obj
	 * @return
	 */
	int insert(Object obj);
	
	int update(T t);
}
