package com.esuizhen.cloudservice.user.service.followuppatient;

import com.esuizhen.cloudservice.user.bean.followuppatient.TwiceSearchReq;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.westangel.common.bean.Page;

public interface OperationHistoryService {
	/**
	 * 获取操作列表
	 * @param operation
	 * @return
	 */
	Page<OperationHistory> getList(TwiceSearchReq twiceSearchReq);
}
