package com.esuizhen.cloudservice.ehr.dao.common;

import java.util.List;
import java.util.Map;

import com.esuizhen.cloudservice.ehr.model.patientinfo.OperationHistory;

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
}
