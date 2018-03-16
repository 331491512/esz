package com.westangel.commonservice.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.authorization.MetaRole;
import com.westangel.common.bean.authorization.RUserRole;
import com.westangel.common.bean.user.RConfDataPrivilege;
import com.westangel.commonservice.authorization.dao.DoctorDao;
import com.westangel.commonservice.authorization.dao.MetaRoleDao;
import com.westangel.commonservice.authorization.dao.RConfDataPrivilegeDao;
import com.westangel.commonservice.authorization.dao.RUserRoleDao;
import com.westangel.commonservice.authorization.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService, com.westangel.common.service.AuthorizationService {
	@Autowired
	private MetaRoleDao metaRoleDao;
	@Autowired
	private RUserRoleDao userRoleDao;
	
	/**
	 * 医生dao
	 */
	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private RConfDataPrivilegeDao rConfDataPrivilegeDao;

	@Override
	public List<MetaRole> getMetaInfoRoleList(Long userId) {
		return this.metaRoleDao.findAll(userId);
	}

	@Override
	public boolean configAuthorization(Long userId, Integer userRole) {
		//判断用户是否有指定的权限
		if(this.userRoleDao.userRoleRelation(userId, userRole) > 0){
			return true;
		}
		//添加新的权限
		RUserRole rUserRole = new RUserRole();
		rUserRole.setUserId(userId);
		rUserRole.setUserRole(userRole);
		this.userRoleDao.insert(rUserRole);
		return true;
	}

	@Override
	public boolean removeAuthorization(Long userId, Integer userRole) {
		this.userRoleDao.deleteByUserId(userId, userRole);
		return true;
	}

	@Override
	public RConfDataPrivilege findDataPrivilegeByDoctor(Long doctorId) {
		RConfDataPrivilege rConfDataPrivilege = null;
		Doctor doctor = doctorDao.findByDoctorId(doctorId);
		if(doctor != null) {
			rConfDataPrivilege = rConfDataPrivilegeDao.findByOperator(doctor.getUserId());
		}
		return rConfDataPrivilege;
	}
}
