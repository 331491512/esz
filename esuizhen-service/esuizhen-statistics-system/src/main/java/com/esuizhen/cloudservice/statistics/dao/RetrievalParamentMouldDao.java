package com.esuizhen.cloudservice.statistics.dao;

import java.util.List;

import com.esuizhen.cloudservice.statistics.model.TRetrievalParamentMould;

public interface RetrievalParamentMouldDao {

	/**
	 * 新增用户设置的高级查询模板
	 * @param retrievalParamentMould
	 * @return
	 */
	int insert(TRetrievalParamentMould retrievalParamentMould);
	
	/**
	 * 修改用户设置的高级查询模板
	 * @param retrievalParamentMould
	 * @return
	 */
	int update(TRetrievalParamentMould retrievalParamentMould);

	/**
	 * 查询用户设置的高级查询模板列表数据
	 * @param retrievalParamentMould
	 * @return
	 */
	List<TRetrievalParamentMould> findRetrievalParamentMouldList(TRetrievalParamentMould retrievalParamentMould);

	/**
	 * 查询用户设置的高级查询模板详细数据
	 * @param mouldId
	 * @return
	 */
	TRetrievalParamentMould findRetrievalParamentMouldDetail(String mouldId);

	/**
	 * 删除用户设置的高级查询模板数据
	 * @param mouldId
	 * @return
	 */
	int delete(String mouldId);

}
