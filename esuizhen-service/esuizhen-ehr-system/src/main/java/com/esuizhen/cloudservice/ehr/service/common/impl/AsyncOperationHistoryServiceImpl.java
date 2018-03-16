package com.esuizhen.cloudservice.ehr.service.common.impl;

import java.util.Date;

import com.esuizhen.cloudservice.ehr.dao.common.OperationHistoryDao;
import com.esuizhen.cloudservice.ehr.model.patientinfo.OperationHistory;
import com.westangel.common.util.LogUtil;

public class AsyncOperationHistoryServiceImpl implements Runnable {
	private OperationHistory operationHistory;
	private OperationHistoryDao operationHistoryDao;

	public OperationHistory getOperationHistory() {
		return operationHistory;
	}

	public void setOperationHistory(OperationHistory operationHistory) {
		this.operationHistory = operationHistory;
	}

	public OperationHistoryDao getOperationHistoryDao() {
		return operationHistoryDao;
	}

	public void setOperationHistoryDao(OperationHistoryDao operationHistoryDao) {
		this.operationHistoryDao = operationHistoryDao;
	}

	@Override
	public void run() {
		operationHistory.setActionType(6);
		operationHistory.setCreateTime(new Date());
		LogUtil.log.info("开始插入合并日志");
		operationHistoryDao.insert(operationHistory);
		LogUtil.log.info("插入合并日志结束");
	}
}
