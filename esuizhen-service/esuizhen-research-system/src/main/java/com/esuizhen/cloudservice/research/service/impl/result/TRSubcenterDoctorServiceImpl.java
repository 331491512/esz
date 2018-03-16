package com.esuizhen.cloudservice.research.service.impl.result;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterRoleInfo;
import com.esuizhen.cloudservice.research.dao.pro.ProjectDao;
import com.esuizhen.cloudservice.research.dao.result.ProjectInvitationDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectInvitationPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectSubcenterDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterDoctorDao;
import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.dao.result.TSubcenterDoctorRoleDao;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterDoctor;
import com.esuizhen.cloudservice.research.service.result.DoctorService;
import com.esuizhen.cloudservice.research.service.result.TProjectInvitationService;
import com.esuizhen.cloudservice.research.service.result.TRSubcenterDoctorService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;

@Service
public class TRSubcenterDoctorServiceImpl implements TRSubcenterDoctorService {
	@Autowired
	private TRSubcenterDoctorDao rSubcenterDoctorDao;
	@Autowired
	private TProjectSubcenterDao projectSubcenterDao;
	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private TSubcenterDoctorRoleDao subcenterDoctorRoleDao;
	@Autowired
	private TRSubcenterPatientDao subcenterPatientDao;
	@Autowired
	private TProjectInvitationPatientDao projectInvitationPatientDao;
	@Autowired
	private ProjectInvitationDao projectInvitationDao;
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private TProjectInvitationService projectInvitationService;
	
	@Override
	public List<TRSubcenterDoctor> searchSubcenterDoctorList(String projectId, Integer allFlag) {
		return this.rSubcenterDoctorDao.querySubcenterDoctorList(projectId, allFlag);
	}

	@Override
	public List<TProjectSubcenterDetailInfo> getProjectSubcenterDoctor(String projectId, Long subcenterId, Long doctorId) throws ParameterCannotBeNullException {
		if (StringUtils.isEmpty(projectId)) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		TProjectSimpleInfo projectSimpleInfo = this.projectDao.findById(projectId);
		if (projectSimpleInfo == null) {
			return null;
		}
		if (projectSimpleInfo.getProjectDirector() == doctorId) {
			return this.rSubcenterDoctorDao.findProjectSubcenterDoctorsBySubcenterId(projectId, null);
		}
		if (subcenterId != null) {
			return this.rSubcenterDoctorDao.findProjectSubcenterDoctorsBySubcenterId(projectId, subcenterId);
		} else {
			TProjectSubcenter projectSubcenter = this.projectSubcenterDao.findByDoctorId(projectId, doctorId);
			if (projectSubcenter == null) {
				return this.rSubcenterDoctorDao.findProjectSubcenterDoctorsBySubcenterId(projectId, null);
			}
			return this.rSubcenterDoctorDao.findProjectSubcenterDoctorsBySubcenterId(projectId, projectSubcenter.getSubcenterId());
		}
	}

	@Transactional
	@Override
	public boolean addProjectSubcenterMember(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException, ObjectAlreadyExistExcption, UnsupportedEncodingException {
		//如果医生不存在
		Doctor doctor = this.doctorService.createDoctor(projectSubcenterDetailInfo);
		projectSubcenterDetailInfo.setSubcenterDirector(doctor.getDoctorId());
		//验证该医生是否已在该专题的分中心里
		if(this.projectSubcenterDao.findByDoctorId(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterDirector()) != null){
			throw new ObjectAlreadyExistExcption("The doctor is in the center of the subject.");
		}
		//补充医生信息，如果库中医生信息不全，使用这里的参数补充部分信息
		this.doctorService.supplyDoctorInfo(doctor, projectSubcenterDetailInfo);
		
		//删除分中心医生角色
		this.subcenterDoctorRoleDao.deleteBySubcenterIdAndDoctorId(projectSubcenterDetailInfo.getSubcenterId(), projectSubcenterDetailInfo.getSubcenterDirector());
		//删除分中心医生关系
		this.rSubcenterDoctorDao.deleteBySubcenterIdAndDoctorId(projectSubcenterDetailInfo.getSubcenterId(), projectSubcenterDetailInfo.getSubcenterDirector());
		
		//保存分中心医生关系
		this.rSubcenterDoctorDao.insert(projectSubcenterDetailInfo);
		//保存分中心医生角色关系
		List<TProjectSubcenterRoleInfo> projectSubcenterRoleInfos = projectSubcenterDetailInfo.getSubcenterRoleList();
		if (projectSubcenterRoleInfos != null && !projectSubcenterRoleInfos.isEmpty()) {
			for (TProjectSubcenterRoleInfo projectSubcenterRoleInfo : projectSubcenterRoleInfos) {
				projectSubcenterRoleInfo.setProjectId(projectSubcenterDetailInfo.getProjectId());
				projectSubcenterRoleInfo.setSubcenterId(projectSubcenterDetailInfo.getSubcenterId());
				projectSubcenterRoleInfo.setDoctorId(projectSubcenterDetailInfo.getSubcenterDirector());
			}
			this.subcenterDoctorRoleDao.insertByBatch(projectSubcenterRoleInfos);
		}
		//保存专题邀请信息
		this.projectInvitationService.addProjectInvitation(projectSubcenterDetailInfo);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteProjectSubcenterMember(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws RejectRequestExcption {
		TProjectSubcenter projectSubcenter = this.projectSubcenterDao.findBySubcenterId(projectSubcenterDetailInfo.getSubcenterId(), projectSubcenterDetailInfo.getSubcenterDirector());
		//如果是分中心负责人，需要分中心成员
		if (projectSubcenter != null) {
			//根据分中心ID删除邀请的患者
			this.subcenterPatientDao.deleteBySubcenterId(projectSubcenter.getSubcenterId());
			this.projectInvitationPatientDao.deleteBySubcenterId(projectSubcenter.getSubcenterId());
			//根据分中心ID删除医生角色
			this.subcenterDoctorRoleDao.deleteBySubcenterId(projectSubcenter.getSubcenterId());
			//删除分中心成员
			this.rSubcenterDoctorDao.deleteBySubcenterId(projectSubcenter.getSubcenterId());
			//删除分中心
			this.projectSubcenterDao.delete(projectSubcenter.getSubcenterId());
		}else{
			//删除该医生邀请的患者
			this.subcenterPatientDao.deleteByDoctorId(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterDirector());
			this.projectInvitationPatientDao.deleteByDoctorId(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterDirector());
			//删除专题医生角色
			this.subcenterDoctorRoleDao.deleteBySubcenterIdAndDoctorId(projectSubcenterDetailInfo.getSubcenterId(), projectSubcenterDetailInfo.getSubcenterDirector());
			//如果是分中心成员直接删除
			this.rSubcenterDoctorDao.deleteBySubcenterIdAndDoctorId(projectSubcenterDetailInfo.getSubcenterId(), projectSubcenterDetailInfo.getSubcenterDirector());
			//删除专题邀请关系
			this.projectInvitationDao.deleteByInvitee(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterDirector());
		}
		return true;
	}

}
