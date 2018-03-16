package com.westangel.commonservice.authorization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.commonservice.authorization.bean.ConfGlobal;
import com.westangel.commonservice.authorization.dao.MetaResourceDao;
import com.westangel.commonservice.authorization.dao.RUserRoleDao;
import com.westangel.commonservice.authorization.service.MetaResourceService;

@Service
public class MetaResourceServiceImpl implements MetaResourceService {
	@Autowired
	private MetaResourceDao metaResourceDao;
	@Autowired
	private RUserRoleDao rUserRoleDao;
	
	@Override
	public List<MetaResource> getMetaInfoResourceSubList(Long userId, Integer resourceId) {
		return this.metaResourceDao.findSubResources(userId, null, resourceId, null);
	}

	@Override
	public List<MetaResource> getResourceMenuList(Long userId) {
		List<MetaResource> metaResources = null;
		ConfGlobal conf = metaResourceDao.queryConfGlobal();
		Integer deployLocation=conf.getDeployLocation();
//		if(deployLocation==null || deployLocation==2){
//			metaResources = this.metaResourceDao.findMetaInfoResourceMenuList(null, null, 1);
//			for (MetaResource metaResource : metaResources) {
//				metaResource.setSubResourceList(this.getSubResources(metaResource, null, null, 1));
//			}
//		}else{
			//判断是否是超级管理员
			if (this.rUserRoleDao.userRoleRelation(userId, 12) > 0) {
				metaResources = this.metaResourceDao.findMetaInfoResourceMenuList(null, null, 1);
				for (MetaResource metaResource : metaResources) {
					metaResource.setSubResourceList(this.getSubResources(metaResource, null, null, 1));
				}
			}else{
				metaResources = this.metaResourceDao.findMetaInfoResourceMenuList(userId, null, 1);
				for (MetaResource metaResource : metaResources) {
					metaResource.setSubResourceList(this.getSubResources(metaResource, userId, null, 1));
				}
			}
//		}
		
		return metaResources;
	}
	
	@Override
	public List<MetaResource> getSubResources(MetaResource metaResource, Long userId, Integer userRole, Integer resourceType){
		if (metaResource == null) {
			return null;
		}
		List<MetaResource> metaResources = this.metaResourceDao.findSubResources(userId, userRole, metaResource.getResourceId(), resourceType);
		if (metaResources != null && !metaResources.isEmpty()) {
			for (MetaResource mr : metaResources) {
				mr.setSubResourceList(this.getSubResources(mr, userId, userRole, resourceType));
			}
		}
		return metaResources;
	}

	@Override
	public List<MetaResource> getRoleResourceSubList(Long userId, Integer resourceId) throws InsufficientParameterExcption {
		if (userId == null || resourceId == null) {
			throw new InsufficientParameterExcption();
		}
		return this.metaResourceDao.findSubResources(userId, null, resourceId, 2);
	}

	@Override
	public List<MetaResource> getMetaInfoResourceList() {
		List<MetaResource> metaResources = this.metaResourceDao.findMetaInfoResourceMenuList(null, null, null);
		for (MetaResource metaResource : metaResources) {
			metaResource.setSubResourceList(this.getSubResources(metaResource, null, null, null));
		}
		return metaResources;
	}
}
