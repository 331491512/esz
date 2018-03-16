package com.esuizhen.server.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.server.sync.bean.BatchDataPushReq;
import com.esuizhen.server.sync.bean.BatchDataResultGetReq;
import com.esuizhen.server.sync.bean.TBatchDataResultInfo;
import com.esuizhen.server.sync.bean.TBatchDetailInfo;
import com.esuizhen.server.sync.dao.sc.UserSyncResultServerDao;
import com.esuizhen.server.sync.dao.temp.TempUserDao;
import com.esuizhen.server.sync.model.temp.SyncUser;
import com.esuizhen.server.sync.service.DataSyncService;
import com.westangel.common.util.JsonUtil;

/**
 * author:lhy
 * descp:user service 
 * date:2017.03.17
 */

@Component
public class UserServiceImpl implements DataSyncService{
    
	@Autowired
	private TempUserDao tempUserDao;
	@Autowired
	private UserSyncResultServerDao userSyncResultServerDao;
	
	@Transactional
	@Override
	public void pushBatchData(BatchDataPushReq req) {
		for (Object object : req.getDataList()) {
			SyncUser user = JsonUtil.toObject(JsonUtil.toJson(object), SyncUser.class);
			user.setBatchId(req.getBatchId());
			tempUserDao.insert(user);
		}
		
	}

	@Override
	public List<TBatchDataResultInfo> getBatChDataResult(BatchDataResultGetReq req) {
		return userSyncResultServerDao.getBatchDataResult(req.getBatchId());
	}

	@Override
	public void dataProcessSync(TBatchDetailInfo detail) {
		
	}
	
	
}
