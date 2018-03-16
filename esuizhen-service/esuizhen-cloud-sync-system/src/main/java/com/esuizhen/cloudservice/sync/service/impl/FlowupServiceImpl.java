package com.esuizhen.cloudservice.sync.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TPatientFollowupResultDetailInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudFlowupDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreFlowupDao;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.FlowupService;
import com.esuizhen.cloudservice.sync.txservice.TxFollowupService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.DuplicateRecordExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.util.PageUtil;

@Service
public class FlowupServiceImpl implements FlowupService {
	@Autowired
	private IncreFlowupDao increFlowupDao;

	@Autowired
	private CloudFlowupDao cloudFlowupDao;
	@Autowired
	private CloudHospitalPatientDao cloudHospitalPatientDao;

	@Autowired
	private TxFollowupService txFollowupService;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;

	/**
	 * B端到C端同步随访结果
	 * @throws HospitalWithoutRightExcption 
	 */
	@Override
	public String syncB2CResultRecord(TPatientFollowupResultDetailInfo detail) throws HospitalWithoutRightExcption,DuplicateRecordExcption {
		if(detail==null||!checkBeforeSyncService.checkHospitalId(detail.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		detail.setSyncFlag(Constant.User.SYNCFLAG_YES);
		//创建时间为空
		if (detail.getCreateTime() == null) {
			detail.setCreateTime(detail.getFollowupTime());
		}
		//如果buffId为空，说明是老随访数据，单独处理
		if(StringUtils.isEmpty(detail.getFollowupResultBuffId()))
			detail.setFollowupResultBuffId(detail.getFollowupResultId());
		// 插入到增量库 考虑到上边的情况，所以需要做排重
		this.increFlowupDao.addResultRecord2Incr(detail);

		return this.txFollowupService.syncB2CFollowupResultRecord(detail);
	}

	/**
	 * 获取为同步的C端到B端同步随访结果
	 * @throws HospitalWithoutRightExcption 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TPatientFollowupResultDetailInfo> syncFollowupResultFromCloud(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption {
		// modily by zhuguo 其中 -1 是在conf_global表中配置的
		if(hospitalId != -1){
			if(!checkBeforeSyncService.checkHospitalId(hospitalId)){
				throw new HospitalWithoutRightExcption();
			}
		}
		
		PageHelper.startPage(pageIndex + 1, pageSize);
		List<TPatientFollowupResultDetailInfo> followupResultDetailInfos = this.cloudFlowupDao.findIncrResultsOfHostpital(hospitalId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TPatientFollowupResultDetailInfo>)followupResultDetailInfos);
	}

	/**
	 * 设置随访同步标记
	 */
	@Transactional
	@Override
	public void setSyncedFlag4Uuids(TSyncResultNotify notify) {
		if (notify.getUuids() == null || notify.getUuids().isEmpty()) {
			return;
		}
		//修改医院、患者关系的同步时间
		this.cloudHospitalPatientDao.setSyncedTime4Uuids(notify.getHospitalId(), notify.getUuids());
		//重置followupResultBuffId
		notify.initFollowupResultBuffId();
		//更新随访结果的同步标识及同步时间
		this.cloudFlowupDao.setC2BSyncMark(notify.getHospitalId(), notify.getUuids());
	}
}
