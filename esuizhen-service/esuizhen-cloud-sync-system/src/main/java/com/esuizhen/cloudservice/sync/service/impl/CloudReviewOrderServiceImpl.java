package com.esuizhen.cloudservice.sync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.bean.TSyncReviewRecord;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudReviewOrderDao;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.CloudReviewOrderService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.PageUtil;

@Service
public class CloudReviewOrderServiceImpl implements CloudReviewOrderService {
	@Autowired
	private CloudReviewOrderDao cloudReviewOrderDao;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;
	/**
	 * 设置复查预约同步标记
	 */
	@Override
	public void setReviewSyncedFlag(TSyncResultNotify notify) {
		if (notify.getUuids() == null || notify.getUuids().isEmpty()) {
			return;
		}
		//修改医院、患者关系的同步时间
		this.cloudReviewOrderDao.setReviewSyncedFlag(notify.getUuids());
	}
	
	/**
	 * 获取预约结果
	 * @throws HospitalWithoutRightExcption 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TSyncReviewRecord> syncReviewOrderFromCloud(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption {
		if(!checkBeforeSyncService.checkHospitalId(hospitalId)){
			throw new HospitalWithoutRightExcption();
		}
		PageHelper.startPage(pageIndex + 1, pageSize);
		List<TSyncReviewRecord> reviewRecords = this.cloudReviewOrderDao.getReviewOrderByHospital(hospitalId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TSyncReviewRecord>)reviewRecords);
	}
}
