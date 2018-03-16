package com.esuizhen.cloudservice.followup.service.followupdo.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.dao.followupresult.FollowupSmsSendCountDao;
import com.esuizhen.cloudservice.followup.model.followupresult.TFollowupSmsSendCountInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupSmsSendCountService;
import com.esuizhen.cloudservice.followup.util.UtilValidate;

@Service
public class FollowupSmsSendCountServiceImpl implements FollowupSmsSendCountService {

	@Autowired
	private FollowupSmsSendCountDao followupSmsSendCountDao;

	@Override
	public List<TFollowupSmsSendCountInfo> queryFollowupSmsSendCount(Map<String, Object> searchParams) {
		return followupSmsSendCountDao.queryFollowupSmsSendCount(searchParams);
	}

	@Override
	public TFollowupSmsSendCountInfo getFollowupSmsSendCount(Map<String, Object> searchParams) {
		List<TFollowupSmsSendCountInfo> list = followupSmsSendCountDao.queryFollowupSmsSendCount(searchParams);
		if (UtilValidate.isNotEmpty(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void insertFollowupSmsSendCount(TFollowupSmsSendCountInfo info) {
		followupSmsSendCountDao.insertFollowupSmsSendCount(info);
	}

	@Override
	public void updateFollowupSmsSendCount(TFollowupSmsSendCountInfo info) {
		followupSmsSendCountDao.updateFollowupSmsSendCount(info);
	}

}
