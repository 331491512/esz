package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.FollowupRecordInfo;
import com.esuizhen.cloudservice.research.dao.result.FollowupResultDao;
import com.esuizhen.cloudservice.research.service.result.FollowupResultService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupResultServiceImpl implements FollowupResultService {
	@Autowired
	private FollowupResultDao followupResultDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public Page<FollowupRecordInfo> followupRecordList(Long patientId, Integer page, Integer num, String orderBy, String orderType) {
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<FollowupRecordInfo> followupRecordInfos = this.followupResultDao.findFollowupResults(patientId, orderBy, orderType);
		return PageUtil.returnPage((com.github.pagehelper.Page<FollowupRecordInfo>)followupRecordInfos);
	}

}
