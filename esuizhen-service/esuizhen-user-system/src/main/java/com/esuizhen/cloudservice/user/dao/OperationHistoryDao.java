package com.esuizhen.cloudservice.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.user.model.OperationHistory;

/**
 * 操作日志
 * @author YYCHEN
 *
 */
public interface OperationHistoryDao {
	public long insert(OperationHistory operationHistory);
	
	/**
	 * 获取操作列表
	 * @param operation
	 * @return
	 */
	List<OperationHistory> getList(Map<String,Object> paramMap);
	
	List<HashMap<String,Object>> getOperationHistory(OperationHistory operationHistory);
}
