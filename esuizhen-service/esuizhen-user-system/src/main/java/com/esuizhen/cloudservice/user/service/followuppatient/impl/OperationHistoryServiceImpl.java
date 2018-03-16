package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.service.followuppatient.OperationHistoryService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class OperationHistoryServiceImpl implements OperationHistoryService {
	
	@Autowired
	private OperationHistoryDao operationHistoryDao;

	@SuppressWarnings("unchecked")
	@Override
	public Page<OperationHistory> getList(TwiceSearchReq twiceSearchReq) {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("operator", twiceSearchReq.getOperator());
		paramMap.put("actionType", twiceSearchReq.getActionType());
		PageHelper.startPage(twiceSearchReq.getPage()+1, twiceSearchReq.getNum());
		List<OperationHistory> list = operationHistoryDao.getList(paramMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<?>) list);
	}

}
