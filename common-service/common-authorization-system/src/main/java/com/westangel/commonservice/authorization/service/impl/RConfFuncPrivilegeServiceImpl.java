package com.westangel.commonservice.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.westangel.common.bean.authorization.RConfFuncPrivilege;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.commonservice.authorization.dao.RConfFuncPrivilegeDao;
import com.westangel.commonservice.authorization.service.RConfFuncPrivilegeService;

@Service
public class RConfFuncPrivilegeServiceImpl implements RConfFuncPrivilegeService {
	@Autowired
	private RConfFuncPrivilegeDao confFuncPrivilegeDao;

	@Transactional
	@Override
	public boolean saveRoleResource(List<RConfFuncPrivilege> confFuncPrivileges) throws InsufficientParameterExcption {
		if (confFuncPrivileges == null || confFuncPrivileges.isEmpty()) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		//先删除之前的角色权限
		this.confFuncPrivilegeDao.deleteByUserRole(confFuncPrivileges.get(0).getUserRole(), null);
		this.addBybatch(confFuncPrivileges);
		return true;
	}
	
	//批量新增角色资源关系
	private boolean addBybatch(List<RConfFuncPrivilege> confFuncPrivileges){
		if (confFuncPrivileges == null || confFuncPrivileges.isEmpty()) {
			return true;
		}
		this.confFuncPrivilegeDao.batchInsert(confFuncPrivileges);
		for (RConfFuncPrivilege confFuncPrivilege : confFuncPrivileges) {
			this.addBybatch(confFuncPrivilege.getSubResourceList());
		}
		return true;
	}
}
