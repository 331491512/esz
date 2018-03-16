package com.esuizhen.cloudservice.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.common.Const;
import com.esuizhen.cloudservice.user.dao.RUserRoleDao;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.UserRoleService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.service.AuthorizationService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	@Autowired
	private AuthorizationService authorizationService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private RUserRoleDao rUserRoleDao;
	
	@Override
	public boolean addDefaultUserRole(Long userId) {
		//配置通用权限
		this.authorizationService.configAuthorization(userId, Const.USERROLE_COMMON);
		//配置基层医生权限
		this.authorizationService.configAuthorization(userId, Const.USERROLE_BASICDOCTOR);
		return true;
	}

	@Override
	public int existUserRoleRelationship(Long doctorId, Integer userRole) {
		Doctor docotor = doctorService.searchDoctor(doctorId);
		if(docotor != null) {
			return rUserRoleDao.existUserRoleRelationship(docotor.getUserId(), userRole);
		}
		return 0;
	}
	
}
