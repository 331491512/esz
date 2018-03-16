/**
 * 
 */
package com.esuizhen.cloudservice.followup.service.meta.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.dao.meta.FollowupMetaInfoDao;
import com.esuizhen.cloudservice.followup.model.meta.FollowupOperatorInfo;
import com.esuizhen.cloudservice.followup.model.meta.FollowupResultValue;
import com.esuizhen.cloudservice.followup.model.meta.FollowupWay;
import com.esuizhen.cloudservice.followup.service.meta.FollowupMetaInfoService;

/**
 * @author DaLoong
 * @date  2016-8-13 上午11:28:20
 */
@Service
@Transactional
public class FollowupMetaInfoServiceImpl implements FollowupMetaInfoService{

	@Autowired
	private FollowupMetaInfoDao dao;
	
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	/**
	 * 随访人员元数据
	 */
	@Override
	public List<FollowupOperatorInfo> getFollowupOperatorList(Integer hospitalId,String followupTaskId, Long doctorId) {
		// TODO Auto-generated method stub
		String sql = organizationDoctorService.getDoctorIdSql(doctorId, null);
		if(followupTaskId!=null)
			//从随访人员分配表中取得随访人员
			return dao.getFollowupOperatorListInTask(followupTaskId, sql);
		else
			//从u_doctor表取得userRole为随访人员的所有用户
			return dao.getAllOpertorList(hospitalId, sql); 
	}
	
	/**
	 * 随访结果元数据
	 */
	@Override
	public List<FollowupResultValue> getMetaInfoFollowupResultValueList(
			Integer type) {
		// TODO Auto-generated method stub
		return dao.getMetaInfoFollowupResultValueList(type);
	}
	
	/**
	 * 随访方式元数据
	 */
	@Override
	public List<FollowupWay> getMetaInfoFollowupWayList() {
		// TODO Auto-generated method stub
		return dao.getMetaInfoFollowupWayList();
	}



}
