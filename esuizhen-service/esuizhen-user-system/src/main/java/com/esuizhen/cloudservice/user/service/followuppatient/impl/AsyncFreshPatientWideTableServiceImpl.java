package com.esuizhen.cloudservice.user.service.followuppatient.impl;

import com.esuizhen.cloudservice.user.dao.followuppatient.FollowupPatientDao;
import com.westangel.common.util.LogUtil;

public class AsyncFreshPatientWideTableServiceImpl implements Runnable{
	private Long patientId;
	private FollowupPatientDao patientFollowupDao;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public FollowupPatientDao getPatientFollowupDao() {
		return patientFollowupDao;
	}

	public void setPatientFollowupDao(FollowupPatientDao patientFollowupDao) {
		this.patientFollowupDao = patientFollowupDao;
	}

	@Override
	public void run() {
		LogUtil.log.debug("开始调用存储过程刷新患者宽表...");
		long start = System.currentTimeMillis();
		patientFollowupDao.freshPatientWideTable(patientId);
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.debug("调用存储过程刷新患者宽表结束，共花了："+diff+"秒");
	}
}
