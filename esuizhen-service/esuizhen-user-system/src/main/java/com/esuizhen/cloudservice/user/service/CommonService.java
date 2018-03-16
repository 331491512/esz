package com.esuizhen.cloudservice.user.service;


import com.westangel.common.bean.Page;

public interface CommonService<T> {
	/**
	 * 分页查询列表
	 * @param obj
	 * @param page
	 * @param num
	 * @return
	 */
	Page<T> queryList(Object obj,Integer page,Integer num);
	
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
	int insert(T t);
	
	int update(T t);
}
