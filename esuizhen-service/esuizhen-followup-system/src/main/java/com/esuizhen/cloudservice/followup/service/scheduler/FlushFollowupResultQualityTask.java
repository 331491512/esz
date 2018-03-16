package com.esuizhen.cloudservice.followup.service.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.followup.dao.conf.FollowupGlobalConfigInfoDao;
import com.esuizhen.cloudservice.followup.model.conf.TFollowupGlobalConfigInfo;
import com.esuizhen.cloudservice.followup.service.followupresult.FollowupResultQualityAnalysisService;
import com.westangel.common.util.LogUtil;

@Service(value = "flushFollowupResultQualityTask")
public class FlushFollowupResultQualityTask {

	@Autowired
	private FollowupResultQualityAnalysisService followupResultQualityAnalysisService;

	@Autowired
	private FollowupGlobalConfigInfoDao followupGlobalConfigInfoDao;

	public void flushFollowupResultQualityFlag() {
		TFollowupGlobalConfigInfo globalConfig = followupGlobalConfigInfoDao.selectFollowupGlobalConfigInfo();
		if (1 == globalConfig.getDeployLocation()) {
			try {
				followupResultQualityAnalysisService.flushFollowupResultQualityFlag();
			} catch (Exception e) {
				LogUtil.log.error("[刷新随访结果过程中失败！]," + e.getMessage());
			}
		}
	}
}
