package com.esuizhen.cloudservice.followup.service.followupdo.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.base.model.OrganizationDoctorInfo;
import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.followup.bean.FollowupPhoneCallIncomingQueryReq;
import com.esuizhen.cloudservice.followup.common.DataAccessFilter;
import com.esuizhen.cloudservice.followup.dao.followupdo.FollowupCallIncomingDao;
import com.esuizhen.cloudservice.followup.model.followupdo.TFollowupPhoneCallIncomingInfo;
import com.esuizhen.cloudservice.followup.service.followupdo.FollowupCallIncomingService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class FollowupCallIncomingServiceImpl implements FollowupCallIncomingService {
	@Autowired
	private FollowupCallIncomingDao followupCallIncomingDao;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	@Override
	public TFollowupPhoneCallIncomingInfo insertFollowupCallIncoming(TFollowupPhoneCallIncomingInfo followupPhoneCallIncomingInfo) {
		followupPhoneCallIncomingInfo.setCallTime(new Date());
		// 按前台传入的值 modify by zhuguo
		// followupPhoneCallIncomingInfo.setResultProcessState(2);
		
		// modify by zhuguo
		int result = followupCallIncomingDao.queryRepeatCallIncoming(followupPhoneCallIncomingInfo);
		if (result == 0) {
			followupCallIncomingDao.insertFollowupCallIncoming(followupPhoneCallIncomingInfo);
		} else {
			LogUtil.log.info("查询获得60秒之内已经存在相同病案号、来电号码、回电号码的患者信息，不允许再次插入！");
		}
		// end
		
		// 插入数据的时候，获取这条数据的id，以便在修改这条数据的处理状态时使用 add by zhuguo
		return followupPhoneCallIncomingInfo;
		// end
	}

	@Override
	public Page<TFollowupPhoneCallIncomingInfo> queryFollowupCallIncoming(FollowupPhoneCallIncomingQueryReq req) {
		// 数据筛选
		OrganizationDoctorInfo orgInfo = organizationDoctorService.getOrganzationDoctorInfo(req.getOperator(), null);
		req.setHospitalId(orgInfo.getHospitalId());
		String sql = organizationDoctorService.getDoctorIdSql(req.getOperator(), null);
		req.setSql(sql);
		req.setOperator(DataAccessFilter.getOperator(req.getUserRole(), req.getOperator()));

		PageHelper.startPage(req.getPage() + 1, req.getNum());
		List<TFollowupPhoneCallIncomingInfo> list = followupCallIncomingDao.queryFollowupCallIncoming(req);
		return PageUtil.returnPage((com.github.pagehelper.Page<TFollowupPhoneCallIncomingInfo>) list);
	}

	/**
	 * 修改来电患者的状态 add by zhuguo
	 */
	@Override
	public int patienPhoneCallIncomingStateModify(String incomingCallId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("incomingCallId", incomingCallId);

		int result = followupCallIncomingDao.patienPhoneCallIncomingStateModify(map);
		return result;
	}

}
