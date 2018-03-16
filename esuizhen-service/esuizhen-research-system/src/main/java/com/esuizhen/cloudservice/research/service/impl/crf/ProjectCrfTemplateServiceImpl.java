package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.bean.TProjectTemplateDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.common.Const;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.service.crf.ProjectCrfTemplateService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/**
 * <p>Title: ProjectCrfTemplateServiceImpl</p>
 * <p>Description: </p>
 * @author YYCHEN
 * @date 2016年4月8日 下午7:21:50
 */
@Service
public class ProjectCrfTemplateServiceImpl implements ProjectCrfTemplateService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;

	@Transactional
	@Override
	public RCrftemplateProject createProjectTemplate(TProjectTemplateDetailInfo projectTemplateDeatilInfo) throws EmptyParamExcption {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", projectTemplateDeatilInfo.getProjectId());
		params.put("state", -1);
		LogUtil.log.debug("调用创建明细proCrfTemplateItemsCreate，开始创建...");
		this.projectCrfTemplateDao.proCrfTemplateItemsCreate(params);
		LogUtil.log.debug("调用创建明细proCrfTemplateItemsCreate，创建完成");
		LogUtil.log.debug("设置专题" + projectTemplateDeatilInfo.getProjectId() + "有专题模板状态");
		this.projectDao.setIsProjectTemplateSet(projectTemplateDeatilInfo.getProjectId(), Constant.Research.ISPROJECTTEMPLATESET_YES);
		LogUtil.log.debug("设置专题" + projectTemplateDeatilInfo.getProjectId() + "有专题模板状态完成");
		RCrftemplateProject crftemplateProject = this.rCrftemplateProjectDao.findByProjectId(projectTemplateDeatilInfo.getProjectId());
		return crftemplateProject;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TProjectTemplateSimpleInfo> listProjectPublicTempaltes(Long author, Integer mainDiseaseTypeId,
			Integer pageNum, Integer pageSize) {
		//page
		if (pageNum == null || pageNum < 0) {
			pageNum = 0;
		}
		//num
		if (pageSize == null || pageSize < 1) {
			pageSize = 10;
		}
		if (mainDiseaseTypeId == null) {
			mainDiseaseTypeId = 0;
		}
		PageHelper.startPage(pageNum + 1, pageSize);
		List<TProjectTemplateSimpleInfo> projectSimpleInfos = this.projectCrfTemplateDao.queryPublicTemplate(author, mainDiseaseTypeId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TProjectTemplateSimpleInfo>)projectSimpleInfos);
	}

	@Override
	public boolean projectTemplatePublish(Long author, String crfTemplateId) throws EmptyParamExcption {
		//crfTemplateType
		if (StringUtils.isEmpty(crfTemplateId)) {
			throw new EmptyParamExcption("crfTemplateId is empty!");
		}
		this.projectCrfTemplateDao.setProjectTemplatePublish(author, crfTemplateId);
		return true;
	}

	@Override
	public TProjectTemplateDetailInfo projectTempalatePreview(Long doctorId, String crfTemplateId) {
		//crfTemplateType
		if (StringUtils.isEmpty(crfTemplateId)) {
			throw new EmptyParamExcption("crfTemplateId is empty!");
		}
		return this.projectCrfTemplateDao.findProjectTemplateDetail(crfTemplateId);
	}

	@Transactional
	@Override
	public RCrftemplateProject projectTemplateCopy(String projectId, String crfTemplateId, Long doctorId) throws EmptyParamExcption, EmptyObjectExcption, RejectRequestExcption {
		//projectId
		if (StringUtils.isEmpty(projectId)) {
			throw new EmptyParamExcption("projectId is empty!");
		}
		//crfTemplateId
		if (StringUtils.isEmpty(crfTemplateId)) {
			throw new EmptyParamExcption("crfTemplateId is empty!");
		}
		//doctorId
		if (doctorId == null) {
			throw new EmptyParamExcption("doctorId is empty!");
		}
		if(this.rCrftemplateProjectDao.findByProjectId(projectId) != null){
			throw new RejectRequestExcption("Special \"" + projectId + "\" topics to reference template!");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("projectId", projectId);
		params.put("crfTemplateId", crfTemplateId);
		params.put("state", -1);
		LogUtil.log.debug("科研专题" + projectId + "应用" + crfTemplateId + "...");
		this.projectCrfTemplateDao.proCrfTemplateReference(params);
		LogUtil.log.debug("科研专题" + projectId + "应用" + crfTemplateId + "完成！");
		LogUtil.log.debug("修改科研专题" + projectId + "有科研专题模板专题...");
		this.projectCrfTemplateDao.increaseCitations(crfTemplateId);
		this.projectDao.setIsProjectTemplateSet(projectId, Constant.Research.ISPROJECTTEMPLATESET_YES);
		this.projectDao.updateProjectState(projectId, Const.PROJECT_STATE_NOTSCREENEDPATIENTS);
		LogUtil.log.debug("修改科研专题" + projectId + "有科研专题模板专题完成!");
		RCrftemplateProject crftemplateProject = this.rCrftemplateProjectDao.findByProjectId(projectId);
		return crftemplateProject;
	}

}
