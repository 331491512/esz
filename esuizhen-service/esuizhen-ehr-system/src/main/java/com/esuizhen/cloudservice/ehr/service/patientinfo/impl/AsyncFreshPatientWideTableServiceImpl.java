package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.westangel.common.util.LogUtil;

public class AsyncFreshPatientWideTableServiceImpl implements Runnable{
	private Long patientId;
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public TInhospitalDetailInfoDao getInhospitalDetailInfoDao() {
		return inhospitalDetailInfoDao;
	}

	public void setInhospitalDetailInfoDao(
			TInhospitalDetailInfoDao inhospitalDetailInfoDao) {
		this.inhospitalDetailInfoDao = inhospitalDetailInfoDao;
	}

	@Override
	public void run() {
		LogUtil.log.debug("开始调用存储过程刷新患者宽表...");
		long start = System.currentTimeMillis();
		inhospitalDetailInfoDao.freshPatientWideTable(patientId);
		long end = System.currentTimeMillis();
		long diff = (end-start)/1000l;
		LogUtil.log.debug("调用存储过程刷新患者宽表结束，共花了："+diff+"秒");
	}
}
