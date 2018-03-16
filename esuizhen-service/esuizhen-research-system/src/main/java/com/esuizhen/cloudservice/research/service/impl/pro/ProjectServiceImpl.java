package com.esuizhen.cloudservice.research.service.impl.pro;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.bean.TProjectCountInfo;
import com.esuizhen.cloudservice.research.bean.TProjectDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectGroupInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterRoleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectTemplateSimpleInfo;
import com.esuizhen.cloudservice.research.dao.crf.ProjectCrfTemplateDao;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.pro.ProjectGroupDao;
import com.esuizhen.cloudservice.research.dao.pro.RCrftemplateProjectDao;
import com.esuizhen.cloudservice.research.dao.result.ProjectInvitationDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultAdverseReactionInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicAllergiesDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicDemographyDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultBasicPastmedicalHistoryDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultClinicalSymptomsDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultClinicalSymptomsInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultDiagnosisInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultExamDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultExamDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultGenenalPhysicalExaminationDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultMainInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPainScaleDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPhysicalSignsDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultPhysicalStatusScoreDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultQualityoflifeInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTcmSymptomsDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTestDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTestInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentChemotherapyInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentChemotherapyMedicationDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentOperationInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentOtherInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentRadiotherapyDetailDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentRadiotherapyInfoDao;
import com.esuizhen.cloudservice.research.dao.result.TCrfResultTreatmentResultDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectInvitationPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectSubcenterDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectThresholdPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterDoctorDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TSubcenterDoctorRoleDao;
import com.esuizhen.cloudservice.research.model.pro.RCrftemplateProject;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.esuizhen.cloudservice.research.service.pro.ProjectGroupService;
import com.esuizhen.cloudservice.research.service.pro.ProjectService;
import com.esuizhen.cloudservice.research.service.result.TProjectSubcenterService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

/** 
* @ClassName: ProjectServiceImpl 
* @Description: 科研专题业务层接口实现
* @author YYCHEN
* @date 2016年04月01日 下午15:58:01  
*/
@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private TProjectSubcenterDao projectSubcenterDao;
	@Autowired
	private ProjectGroupDao projectGroupDao;
	@Autowired
	private ProjectCrfTemplateDao projectCrfTemplateDao;
	@Autowired
	private RCrftemplateProjectDao rCrftemplateProjectDao;
	@Autowired
	private TSubcenterDoctorRoleDao subcenterDoctorRoleDao;
	@Autowired
	private TRSubcenterDoctorDao subcenterDoctorDao;
	@Autowired
	private ProjectInvitationDao projectInvitationDao;
	@Autowired
	private TProjectInvitationPatientDao projectInvitationPatientDao;
	@Autowired
	private TRSubcenterPatientDao subcenterPatientDao;
	@Autowired
	private TCrfResultAdverseReactionInfoDao crfResultAdverseReactionInfoDao;
	@Autowired
	private TCrfResultTreatmentOtherInfoDao crfResultTreatmentOtherInfoDao;
	@Autowired
	private TCrfResultTreatmentOperationInfoDao crfResultTreatmentOperationInfoDao;
	@Autowired
	private TCrfResultTreatmentChemotherapyMedicationDetailDao crfResultTreatmentChemotherapyMedicationDetailDao;
	@Autowired
	private TCrfResultTreatmentChemotherapyInfoDao crfResultTreatmentChemotherapyInfoDao;
	@Autowired
	private TCrfResultTreatmentRadiotherapyDetailDao crfResultTreatmentRadiotherapyDetailDao;
	@Autowired
	private TCrfResultTreatmentRadiotherapyInfoDao crfResultTreatmentRadiotherapyInfoDao;
	@Autowired
	private TCrfResultQualityoflifeInfoDao crfResultQualityoflifeInfoDao;
	@Autowired
	private TCrfResultTcmSymptomsDetailDao crfResultTcmSymptomsDetailDao;
	@Autowired
	private TCrfResultPainScaleDao crfResultPainScaleDao;
	@Autowired
	private TCrfResultClinicalSymptomsDetailDao crfResultClinicalSymptomsDetailDao;
	@Autowired
	private TCrfResultClinicalSymptomsInfoDao crfResultClinicalSymptomsInfoDao;
	@Autowired
	private TCrfResultTreatmentResultDao crfResultTreatmentResultDao;
	@Autowired
	private TCrfResultTestDetailDao crfResultTestDetailDao;
	@Autowired
	private TCrfResultTestInfoDao crfResultTestInfoDao;
	@Autowired
	private TCrfResultExamDetailDao crfResultExamDetailDao;
	@Autowired
	private TCrfResultExamDao crfResultExamDao;
	@Autowired
	private TCrfResultPhysicalStatusScoreDao crfResultPhysicalStatusScoreDao;
	@Autowired
	private TCrfResultPhysicalSignsDao crfResultPhysicalSignsDao;
	@Autowired
	private TCrfResultGenenalPhysicalExaminationDao crfResultGenenalPhysicalExaminationDao;
	@Autowired
	private TCrfResultDiagnosisInfoDao crfResultDiagnosisInfoDao;
	@Autowired
	private TCrfResultBasicPastmedicalHistoryDao crfResultBasicPastmedicalHistoryDao;
	@Autowired
	private TCrfResultBasicAllergiesDao crfResultBasicAllergiesDao;
	@Autowired
	private TCrfResultBasicDemographyDao crfResultBasicDemographyDao;
	@Autowired
	private TCrfResultMainInfoDao crfResultMainInfoDao;
	@Autowired
	private TProjectThresholdPatientDao projectThresholdPatientDao;
	
	@Autowired
	private ProjectGroupService projectGroupService;
	@Autowired
	private TProjectSubcenterService projectSubcenterService;
	
	@Transactional
	@Override
	public TProjectSimpleInfo createProject(TProjectSimpleInfo projectSimpleInfo) throws EmptyParamExcption, RejectRequestExcption {
		//projectName
		if (StringUtils.isEmpty(projectSimpleInfo.getProjectName())) {
			throw new EmptyParamExcption("projectName is empty!");
		}
		//projectDirector
		if (projectSimpleInfo.getProjectDirector() == null) {
			throw new EmptyParamExcption("projectDirector is empty!");
		}
		//projectBeginTime
		if (projectSimpleInfo.getProjectBeginTime() == null) {
			throw new EmptyParamExcption("projectBeginTime is empty!");
		}
		//mainDiseaseTypeId
		if (projectSimpleInfo.getMainDiseaseTypeId() == null) {
			throw new EmptyParamExcption("mainDiseaseTypeId is empty!");
		}
		//icfConfirmWay
		if (projectSimpleInfo.getIcfConfirmWay() == null) {
			throw new EmptyParamExcption("icfConfirmWay is empty!");
		}
		//isProjectTemplateSet
		if (projectSimpleInfo.getIsProjectTemplateSet() == null) {
			projectSimpleInfo.setIsProjectTemplateSet(Constant.Research.ISPROJECTTEMPLATESET_NO);
		}
		//state
		if (projectSimpleInfo.getState() == null) {
			projectSimpleInfo.setState(Constant.Research.PROJECT_STATE_NOTSTART);
		}
		//projectId
		projectSimpleInfo.setProjectId(GeneralUtil.generateUniqueID("PROJ"));
		LogUtil.log.debug("保存新创建的科研专题信息>>>>>>>>>>>>>");
		this.projectDao.insert(projectSimpleInfo);
		//保存专题患者组
		this.projectGroupService.addProjectGroup(projectSimpleInfo);
		//创建默认分中心
		this.projectSubcenterService.createDefaultProjectSubcenter(projectSimpleInfo);
		LogUtil.log.debug("保存新创建的科研专题信息完成<<<<<<<<<<");
		return projectSimpleInfo;
	}

	@Transactional
	@Override
	public int projectModify(TProjectSimpleInfo projectSimpleInfo) throws EmptyParamExcption, RejectRequestExcption {
		//projectId
		if (StringUtils.isEmpty(projectSimpleInfo.getProjectId())) {
			throw new EmptyParamExcption("projectId is empty!");
		}
		//projectName
		if (StringUtils.isEmpty(projectSimpleInfo.getProjectName())) {
			throw new EmptyParamExcption("projectName is empty!");
		}
		//projectDirector
		if (projectSimpleInfo.getProjectDirector() == null) {
			throw new EmptyParamExcption("projectDirector is empty!");
		}
		//projectBeginTime
		if (projectSimpleInfo.getProjectBeginTime() == null) {
			throw new EmptyParamExcption("projectBeginTime is empty!");
		}
		//mainDiseaseTypeId
		if (projectSimpleInfo.getMainDiseaseTypeId() == null) {
			throw new EmptyParamExcption("mainDiseaseTypeId is empty!");
		}
		//isProjectTemplateSet
		if (projectSimpleInfo.getIsProjectTemplateSet() == null) {
			projectSimpleInfo.setIsProjectTemplateSet(Constant.Research.ISPROJECTTEMPLATESET_NO);
		}
		//icfConfirmWay
		if (projectSimpleInfo.getIcfConfirmWay() == null) {
			throw new EmptyParamExcption("icfConfirmWay is empty!");
		}
		//state
		if (projectSimpleInfo.getState() == null) {
			projectSimpleInfo.setState(Constant.Research.PROJECT_STATE_NOTSTART);
		}
		TProjectSimpleInfo simpleInfo = this.projectDao.findById(projectSimpleInfo.getProjectId());
		this.projectDao.update(projectSimpleInfo);
		//修改专题模板信息
		RCrftemplateProject rCrftemplateProject = this.rCrftemplateProjectDao.findByProjectId(projectSimpleInfo.getProjectId());
		if (rCrftemplateProject != null) {
			TProjectTemplateSimpleInfo projectTemplateSimpleInfo = new TProjectTemplateSimpleInfo();
			projectTemplateSimpleInfo.setCrfTemplateId(rCrftemplateProject.getCrfTemplateId());
			projectTemplateSimpleInfo.setCrfTemplateName(projectSimpleInfo.getProjectName());
			this.projectCrfTemplateDao.update(projectTemplateSimpleInfo);
		}
		//保存专题患者组
		this.projectGroupService.addProjectGroup(projectSimpleInfo);
		if ((simpleInfo.getGroupType() == null || simpleInfo.getGroupType() == 0) &&
				projectSimpleInfo.getGroupType() != 0) {
			//分组方式由未分组改为分组方式，将之前邀请的患者转移到第一个分组里
			for (TProjectGroupInfo projectGroupInfo : projectSimpleInfo.getProjectGroupList()) {
				if (projectGroupInfo.getIndex() == 0) {
					if (projectGroupInfo != null) {
						//将邀请患者改为第一个分组里
						this.projectInvitationPatientDao.updatePatientIntoGroup(projectSimpleInfo.getProjectId(), projectGroupInfo.getGroupId());
						//将分中心患者改为第一个分组里
						this.subcenterPatientDao.updatePatientIntoGroup(projectSimpleInfo.getProjectId(), projectGroupInfo.getGroupId());
					}
					break;
				}
			}
		}
		LogUtil.log.debug("修改科研专题信息(projectModify)----------<<");
		return 0;
	}

	@Transactional
	@Override
	public int removeProject(String projectId, Long doctorId) {
		if (StringUtils.isEmpty(projectId)) {
			return 0;
		}
		//删除专题分中心医生角色关系
		this.subcenterDoctorRoleDao.deleteByProjectId(projectId);
		//删除专题分中心医生关系
		this.subcenterDoctorDao.deleteByProjectId(projectId);
		//删除专题分中心
		this.projectSubcenterDao.deleteByProjectId(projectId);
		//删除专题患者组
		this.projectGroupDao.deleteByProjectId(projectId);
		
		//删除专题邀请结果
		this.projectInvitationDao.deleteByProjectId(projectId);
		//删除患者邀请信息
		this.projectInvitationPatientDao.deleteByProjectId(projectId);
		//删除分中心患者信息
		this.subcenterPatientDao.deleteByProjectId(projectId);
		//删除不良反应结果
		this.crfResultAdverseReactionInfoDao.deleteByProjectId(projectId);
		//删除治疗及用药其他结果
		this.crfResultTreatmentOtherInfoDao.deleteByProjectId(projectId);
		//删除治疗及用药-手术结果
		this.crfResultTreatmentOperationInfoDao.deleteByProjectId(projectId);
		//删除治疗及用药-化疗详情结果
		this.crfResultTreatmentChemotherapyMedicationDetailDao.deleteByProjectId(projectId);
		//删除治疗及用药-化疗结果
		this.crfResultTreatmentChemotherapyInfoDao.deleteByProjectId(projectId);
		//删除治疗及用药-放疗详情结果
		this.crfResultTreatmentRadiotherapyDetailDao.deleteByProjectId(projectId);
		//删除治疗及用药-放疗结果
		this.crfResultTreatmentRadiotherapyInfoDao.deleteByProjectId(projectId);
		//删除生存质量结果
		this.crfResultQualityoflifeInfoDao.deleteByProjectId(projectId);
		//删除临床症状-中医项目结果
		this.crfResultTcmSymptomsDetailDao.deleteByProjectId(projectId);
		//删除疼痛指数结果
		this.crfResultPainScaleDao.deleteByProjectId(projectId);
		//删除临床症状详情
		this.crfResultClinicalSymptomsDetailDao.deleteByProjectId(projectId);
		//删除临床症状结果
		this.crfResultClinicalSymptomsInfoDao.deleteByProjectId(projectId);
		//删除治疗效果
		this.crfResultTreatmentResultDao.deleteByProjectId(projectId);
		//删除检验效果详情
		this.crfResultTestDetailDao.deleteByProjectId(projectId);
		//删除检验效果结果
		this.crfResultTestInfoDao.deleteByProjectId(projectId);
		//删除检查详情
		this.crfResultExamDetailDao.deleteByProjectId(projectId);
		//删除检查结果
		this.crfResultExamDao.deleteByProjectId(projectId);
		//删除身体状况评分结果
		this.crfResultPhysicalStatusScoreDao.deleteByProjectId(projectId);
		//删除体格检查-体征情况结果
		this.crfResultPhysicalSignsDao.deleteByProjectId(projectId);
		//删除体格检查-常规体检结果
		this.crfResultGenenalPhysicalExaminationDao.deleteByProjectId(projectId);
		//删除专题患者阈值
		this.projectThresholdPatientDao.deleteByProjectId(projectId);
		//删除诊断结果
		this.crfResultDiagnosisInfoDao.deleteByProjectId(projectId);
		//删除基本信息-既往病史结果
		this.crfResultBasicPastmedicalHistoryDao.deleteByProjectId(projectId);
		//删除基本信息-过敏史
		this.crfResultBasicAllergiesDao.deleteByProjectId(projectId);
		//删除基本信息-人口学结果
		this.crfResultBasicDemographyDao.deleteByProjectId(projectId);
		//删除采集结果
		this.crfResultMainInfoDao.deleteByProjectId(projectId);
		Map<String, Object> params = new HashMap<String, Object>();
		//删除专题模板
		List<RCrftemplateProject> crftemplateProjects = this.rCrftemplateProjectDao.findProjectTemplateByProjectId(projectId);
		if (crftemplateProjects != null && !crftemplateProjects.isEmpty()) {
			for (RCrftemplateProject crftemplateProject : crftemplateProjects) {
				params.put("projectId", crftemplateProject.getCrfTemplateId());
				params.put("state", -1);
				LogUtil.log.debug("调用删除明细proCrfTemplateItemsDelete，开始删除...");
				this.projectCrfTemplateDao.proCrfTemplateItemsDelete(params);
				LogUtil.log.debug("调用删除明细proCrfTemplateItemsDelete，删除完成");
			}
		}
		//删除专题基本信息
		this.projectDao.delete(projectId);
		LogUtil.log.debug("删除科研专题基本信息完成");
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<TProjectSimpleInfo> listProject(Long doctorId, Integer stateFlag, Integer state, Integer attributeFlag, Integer pageNum, Integer pageSize) throws EmptyParamExcption {
		if (doctorId == null) {
			throw new EmptyParamExcption("doctorId is empty!");
		}
		if (pageNum == null) {
			pageNum = 0;
		}
		if (pageSize == null) {
			pageSize = 10;
		}
		if (attributeFlag == null) {
			attributeFlag = 0;
		}else if(attributeFlag == 3){
			PageHelper.startPage(pageNum + 1, pageSize);
			List<TProjectSimpleInfo> projectSimpleInfos = this.projectDao.findParticipateInProjects(doctorId, state, stateFlag, attributeFlag);
			return PageUtil.returnPage((com.github.pagehelper.Page<TProjectSimpleInfo>)projectSimpleInfos);
		}
		PageHelper.startPage(pageNum + 1, pageSize);
		List<TProjectSimpleInfo> projectSimpleInfos = this.projectDao.findProjects(doctorId, state, stateFlag, attributeFlag);
		return PageUtil.returnPage((com.github.pagehelper.Page<TProjectSimpleInfo>)projectSimpleInfos);
	}

	@Override
	public TProjectCountInfo queryProjectStatistics(String projectId, Long doctorId) throws EmptyParamExcption {
		/*
		if (StringUtils.isEmpty(projectId)) {
			throw new EmptyParamExcption("projectId is empty!");
		}
		*/
		if (doctorId == null) {
			throw new EmptyParamExcption("doctorId is empty!");
		}
		return this.projectDao.queryCountByDirector(doctorId);
	}

	@Override
	public TProjectDetailInfo queryProjectDetail(String projectId, Long subcenterId, Long doctorId) throws EmptyParamExcption {
		if (StringUtils.isEmpty(projectId)) {
			throw new EmptyParamExcption("projectId is empty!");
		}
		
		TProjectDetailInfo projectDetailInfo = this.projectDao.findDetailById(projectId, subcenterId, doctorId);
		if (projectDetailInfo != null && doctorId != null) {
			TProjectSubcenter projectSubcenter = projectSubcenterDao.findByDoctorId(projectId, doctorId);
			if (projectSubcenter != null) {
				//医生所在的分中心ID
				projectDetailInfo.setSubcenterId(projectSubcenter.getSubcenterId());
				projectDetailInfo.setSubcenterName(projectSubcenter.getSubcenterName());
			}
			//查询专题创建人所在的分中心
			if (projectDetailInfo.getProjectDirector() == doctorId) {
				projectDetailInfo.setProjectCreaterSubcenterId(projectSubcenter.getSubcenterId());
			} else {
				TProjectSubcenter projectCreaterSubcenter = projectSubcenterDao.findByDoctorId(projectId, projectDetailInfo.getProjectDirector());
				if (projectCreaterSubcenter != null) {
					projectDetailInfo.setProjectCreaterSubcenterId(projectCreaterSubcenter.getSubcenterId());
				}
			}
			//医生在专题中的角色列表
			List<TProjectSubcenterRoleInfo> projectSubcenterRoleInfos = this.subcenterDoctorRoleDao.findByDoctorId(projectId, doctorId);
			if (projectSubcenterRoleInfos != null && !projectSubcenterRoleInfos.isEmpty()) {
				projectDetailInfo.setProjectRoleList(projectSubcenterRoleInfos);
				switch (projectSubcenterRoleInfos.get(0).getRoleId()) {
				case 10:
				case 20:
					projectDetailInfo.setPendingNum(this.projectInvitationPatientDao.findCount(projectId, null, null));
					break;
				case 50:
					//研究助理与专题创建人在同一个分中心，可以看全院数据
					if ((projectDetailInfo.getProjectCreaterSubcenterId() != null &&
					projectDetailInfo.getSubcenterId() != null) &&
							(projectDetailInfo.getProjectCreaterSubcenterId() == projectDetailInfo.getSubcenterId() ||
							projectDetailInfo.getProjectCreaterSubcenterId().equals(projectDetailInfo.getSubcenterId()))) {
						projectDetailInfo.setPendingNum(this.projectInvitationPatientDao.findCount(projectId, null, null));
						break;
					}
				case 30:
				case 40:
					projectDetailInfo.setPendingNum(this.projectInvitationPatientDao.findCount(projectId, projectDetailInfo.getSubcenterId(), null));
					break;
				default:
					break;
				}
			}
		}
		return projectDetailInfo;
	}

	@Override
	public boolean releaseProject(String projectId, Long doctorId) {
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(projectId);
		//如果专题有结束时间，启用定时，时间到将专题修改为结束状态
		if (projectSimpleInfo.getProjectEndTime() != null) {
			//this.timedUpdateProjectState(projectSimpleInfo);
		}
		return this.projectDao.releaseProject(projectId, 1, 2) > 0;
	}


	/**
	 * 创建定时任务，定时更新专题状态
	 */
	/*
	@Override
	public boolean timedUpdateProjectState(TProjectSimpleInfo projectSimpleInfo){
		Timertask timetask = new Timertask();
		timetask.setTaskType(1);
		timetask.setActionType(2);
		timetask.setSqlContent("UPDATE pro_db.project SET state=-1, updateTime=NOW() WHERE projectId='" + projectSimpleInfo.getProjectId() + "'");
		timetask.setServiceType(23);
		timetask.setServiceTargetId(projectSimpleInfo.getProjectId());
		timetask.setActionTime(projectSimpleInfo.getProjectEndTime());
		this.timertaskService.createTimetask(timetask);
		return true;
	}
	
	@Autowired
	private TimertaskService timertaskService;
	*/
}
