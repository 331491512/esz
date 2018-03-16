package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.westangel.common.util.LogUtil;

public class AsyncOperationHistoryServiceImpl implements Runnable {
	private List<Long> ids = new ArrayList<Long>();
	private Long operatorId;
	private OperationHistoryDao operationHistoryDao;
	
	public List<Long> getIds() {
		return ids;
	}

	public void setIds(List<Long> ids) {
		this.ids = ids;
	}

	public Long getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}

	public OperationHistoryDao getOperationHistoryDao() {
		return operationHistoryDao;
	}

	public void setOperationHistoryDao(OperationHistoryDao operationHistoryDao) {
		this.operationHistoryDao = operationHistoryDao;
	}

	@Override
	public void run() {
		StringBuffer description = new StringBuffer();
		int len = ids.size();
		int subLen = len -1;
		description.append("将");
		for(int i = 0;i < len;i++) {
			int j = i + 1;
			if(i == subLen) {
				description.append("患者"+j).append("(id:"+ids.get(i)+")");
			}else {
				description.append("患者"+j).append("(id:"+ids.get(i)+")").append(",");
			}
		}
		description.append("合并为患者1(id: "+ids.get(0)+")");
		OperationHistory operationHistory = new OperationHistory();
		operationHistory.setActionType(5);
		operationHistory.setDescription(description.toString());
		operationHistory.setCreateTime(new Date());
		LogUtil.log.info("开始插入合并日志");
		operationHistoryDao.insert(operationHistory);
		LogUtil.log.info("插入合并日志结束");
	}
}
