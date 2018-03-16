package com.esuizhen.cloudservice.research.service.impl.pro;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.bean.TProjectGroupInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.dao.pro.ProjectGroupDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectInvitationPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.service.pro.ProjectGroupService;
import com.westangel.common.util.GeneralUtil;

@Service
public class ProjectGroupServiceImpl implements ProjectGroupService {
	@Autowired
	private ProjectGroupDao projectGroupDao;
	@Autowired
	private TProjectInvitationPatientDao projectInvitationPatientDao;
	@Autowired
	private TRSubcenterPatientDao subcenterPatientDao;

	@Transactional
	@Override
	public boolean addProjectGroup(TProjectSimpleInfo projectSimpleInfo) {
		//删除专题患者组
		List<TProjectGroupInfo> projectGroupList = projectSimpleInfo.getProjectGroupList();
		//如果是不分组
		if (projectGroupList == null ||
				projectGroupList.isEmpty() ||
				projectSimpleInfo.getGroupType() == 0) {
			/*
			//删除专题邀请患者
			this.projectInvitationPatientDao.deleteByProjectId(projectSimpleInfo.getProjectId());
			//删除专题分中心患者
			this.subcenterPatientDao.deleteByProjectId(projectSimpleInfo.getProjectId());
			*/
			//删除现有的专题患者组
			this.projectGroupDao.deleteByProjectId(projectSimpleInfo.getProjectId());
			return true;
		}
		//更新分组
		List<TProjectGroupInfo> groupInfos = this.projectGroupDao.findProjectGroupList(projectSimpleInfo.getProjectId(), null);
		boolean exist = true;
		for (TProjectGroupInfo tProjectGroupInfo : groupInfos) {
			for (TProjectGroupInfo groupInfo : projectGroupList) {
				if (StringUtils.isNotEmpty(groupInfo.getGroupId()) &&
					tProjectGroupInfo.getGroupId().equals(groupInfo.getGroupId())) {
					exist = true;
					break;
				}
				exist = false;
			}
			//分中心被删除
			if (!exist) {
				//删除该分组下的患者
				this.projectInvitationPatientDao.deleteByGroupId(tProjectGroupInfo.getGroupId());
				//删除该分组邀请的患者
				this.subcenterPatientDao.deleteByGroupId(tProjectGroupInfo.getGroupId());
				//删除该分中心
				this.projectGroupDao.deleteById(tProjectGroupInfo.getGroupId());
			}
			exist = true;
		}
		
		for (TProjectGroupInfo projectGroupInfo : projectGroupList) {
			if (StringUtils.isNotEmpty(projectGroupInfo.getGroupId())) {
				this.projectGroupDao.update(projectGroupInfo);
			}else{
				projectGroupInfo.setGroupId(GeneralUtil.generateUniqueID("GRUP"));
				projectGroupInfo.setProjectId(projectSimpleInfo.getProjectId());
				projectGroupInfo.setEnableFlag(1);
				
				this.projectGroupDao.insert(projectGroupInfo);
			}
		}
		return true;
	}

	@Override
	public List<TProjectGroupInfo> queryProjectGroupList(String projectId, Long doctorId) {
		return this.projectGroupDao.findProjectGroupList(projectId, doctorId);
	}

}
