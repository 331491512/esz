package com.esuizhen.cloudservice.ehr.service.common;

import java.util.List;  
import java.util.Map;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.westangel.common.bean.Page;


public interface CommonService<T> {
	CommonDao<T> getCommonDao();
	/**
	 * 供外部调用查询
	 * @param req
	 * @return
	 */
	List<T> query(CommonReq req);
	
	/**
	 * 供外部调用保存
	 * @param req
	 * @param t
	 * @return
	 */
	Map<String,Object> save(CommonReq req,List<T> t);
	
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
	 * 分页查询
	 * @param paramsMap
	 * @return
	 */
	Page<T> queryPageList(Object obj);
	
	/**
	 * 自定义分页查询-采用人工编写统计总数
	 * @param paramsMap
	 * @return
	 */
	Page<T> queryCustomPageList(Object obj);
	
	/**
	 * 插入
	 * @param t
	 * @return
	 */
	int save(T t);
	
	int update(T t);
	int updateByPrimaryKeySelective(T t);
}
