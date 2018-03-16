package com.westangel.commonservice.authorization.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.bean.authorization.MetaRole;
import com.westangel.common.bean.authorization.RConfFuncPrivilege;
import com.westangel.common.bean.authorization.RUserRole;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.commonservice.authorization.dao.MetaResourceDao;
import com.westangel.commonservice.authorization.dao.MetaRoleDao;
import com.westangel.commonservice.authorization.dao.RConfFuncPrivilegeDao;
import com.westangel.commonservice.authorization.dao.RUserRoleDao;
import com.westangel.commonservice.authorization.service.MetaResourceService;
import com.westangel.commonservice.authorization.service.RConfFuncPrivilegeService;
import com.westangel.commonservice.authorization.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private MetaResourceDao metaResourceDao;
	@Autowired
	private RUserRoleDao userRoleDao;
	@Autowired
	private MetaRoleDao metaRoleDao;
	@Autowired
	private RConfFuncPrivilegeDao confFuncPrivilegeDao;
	
	@Autowired
	private MetaResourceService metaResourceService;
	@Autowired
	private RConfFuncPrivilegeService confFuncPrivilegeService;
	
	@Override
	public List<MetaResource> getRoleResourceList(Long userId, Integer userRole) {
		if (userRole != null && userRole == 12) {
			userRole = null;
		}
		List<MetaResource> metaResources = this.metaResourceDao.findMetaInfoResourceMenuList(userId, userRole, null);
		for (MetaResource metaResource : metaResources) {
			metaResource.setSubResourceList(this.metaResourceService.getSubResources(metaResource, userId, userRole, null));
		}
		return metaResources;
	}

	@Override
	public List<RUserRole> getUserRoleList(Long userId) {
		return this.userRoleDao.findByUserId(userId);
	}

	@Transactional
	@Override
	public boolean addRole(MetaRole metaRole) throws InsufficientParameterExcption, ObjectAlreadyExistExcption {
		if (StringUtils.isEmpty(metaRole.getRoleName()) ||
				metaRole.getRoleType() == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		if (this.metaRoleDao.findRoleNameCount(metaRole.getRoleName()) > 0) {
			throw new ObjectAlreadyExistExcption("Role name already exists!");
		}
		//获取当期userRole的值
		metaRole.setUserRole(this.metaRoleDao.findUserRoleValue());
		this.metaRoleDao.insert(metaRole);
		//给角色添加默认权限
		this.addDefaultAuthorityToRole(metaRole);
		return true;
	}

	/*
	 * 给角色添加默认权限
	 */
	private void addDefaultAuthorityToRole(MetaRole metaRole) {
		List<RConfFuncPrivilege> confFuncPrivileges = new ArrayList<RConfFuncPrivilege>();
		//随访患者管理
		RConfFuncPrivilege flupPatientManage = new RConfFuncPrivilege();
		flupPatientManage.setResourceId(100);
		flupPatientManage.setUserRole(metaRole.getUserRole());
		confFuncPrivileges.add(flupPatientManage);
		//全部患者列表
		List<RConfFuncPrivilege> menu1 = new ArrayList<RConfFuncPrivilege>();
		RConfFuncPrivilege allPatientList = new RConfFuncPrivilege();
		allPatientList.setResourceId(1000);
		allPatientList.setUserRole(metaRole.getUserRole());
		menu1.add(allPatientList);
		flupPatientManage.setSubResourceList(menu1);
		//查看患者列表
		List<RConfFuncPrivilege> menu1_1 = new ArrayList<RConfFuncPrivilege>();
		RConfFuncPrivilege seePatientList = new RConfFuncPrivilege();
		seePatientList.setResourceId(10000);
		seePatientList.setUserRole(metaRole.getUserRole());
		menu1_1.add(seePatientList);
		allPatientList.setSubResourceList(menu1_1);
		
		//随访工作管理
		RConfFuncPrivilege flupJobManage = new RConfFuncPrivilege();
		flupJobManage.setResourceId(150);
		flupJobManage.setUserRole(metaRole.getUserRole());
		confFuncPrivileges.add(flupJobManage);
		//随访任务管理
		List<RConfFuncPrivilege> menu2 = new ArrayList<RConfFuncPrivilege>();
		RConfFuncPrivilege flupTaskManage = new RConfFuncPrivilege();
		flupTaskManage.setResourceId(1050);
		flupTaskManage.setUserRole(metaRole.getUserRole());
		menu2.add(flupTaskManage);
		flupJobManage.setSubResourceList(menu2);
		
		try {
			//保存默认权限
			this.confFuncPrivilegeService.saveRoleResource(confFuncPrivileges);
		} catch (InsufficientParameterExcption e) {
			LogUtil.logError.error("给角色添加默认权限出错：" + e.getMessage());
		}
	}

	@Transactional
	@Override
	public boolean deleteRole(MetaResource metaResource) throws RejectRequestExcption, InsufficientParameterExcption {
		if (metaResource == null || metaResource.getUserRole() == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		if(this.userRoleDao.userRoleRelation(null, metaResource.getUserRole()) > 0){
			throw new RejectRequestExcption("Role assigned resources!"); 
		}
		//删除角色权限
		this.confFuncPrivilegeDao.deleteByUserRole(metaResource.getUserRole(), null);
		//删除角色
		this.metaRoleDao.delete(metaResource.getUserRole());
		return true;
	}

	@Override
	public List<MetaRole> getMetaInfoRoleList(Long userId) {
		return this.metaRoleDao.findAll(userId);
	}
}
