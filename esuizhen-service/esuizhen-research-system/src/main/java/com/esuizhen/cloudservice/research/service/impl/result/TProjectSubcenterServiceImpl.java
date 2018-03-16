package com.esuizhen.cloudservice.research.service.impl.result;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.bean.TProjectSimpleInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterRoleInfo;
import com.esuizhen.cloudservice.research.dao.result.HospitalDao;
import com.esuizhen.cloudservice.research.dao.result.TProjectSubcenterDao;
import com.esuizhen.cloudservice.research.dao.result.TSubcenterDoctorRoleDao;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.model.result.TProjectSubcenter;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterDoctorRole;
import com.esuizhen.cloudservice.research.service.result.DoctorService;
import com.esuizhen.cloudservice.research.service.result.TProjectInvitationService;
import com.esuizhen.cloudservice.research.service.result.TProjectSubcenterService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ParameterCannotBeNullException;
import com.westangel.common.excption.RejectRequestExcption;

@Service
public class TProjectSubcenterServiceImpl implements TProjectSubcenterService {
	@Autowired
	private TProjectSubcenterDao projectSubcenterDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private TSubcenterDoctorRoleDao subcenterDoctorRoleDao;
	
	@Autowired
	private TProjectInvitationService projectInvitationService;

	@Transactional
	@Override
	public TProjectSubcenter getCreatorProjectSubCenter(TCrfResultMainInfo<?> crfResultMainInfo) {
		TProjectSubcenter projectSubcenter = this.projectSubcenterDao.findByDoctorId(crfResultMainInfo.getProjectId(), crfResultMainInfo.getDoctorId());
		if (projectSubcenter != null) {
			return projectSubcenter;
		}
		return this.createProjectSubcenter(crfResultMainInfo);
	}

	//基于医生信息创建专题分中心
	private TProjectSubcenter createProjectSubcenter(TCrfResultMainInfo<?> crfResultMainInfo) {
		HospitalProfile hospitalProfile = this.hospitalDao.findByDoctorId(crfResultMainInfo.getDoctorId());
		if (hospitalProfile == null) {
			return null;
		}
		TProjectSubcenter projectSubcenter = new TProjectSubcenter();
		projectSubcenter.setProjectId(crfResultMainInfo.getProjectId());
		projectSubcenter.setSubcenterDirector(crfResultMainInfo.getDoctorId());
		projectSubcenter.setSubcenterName(hospitalProfile.getHospitalName());
		projectSubcenter.setState(1);
		
		this.projectSubcenterDao.insert(projectSubcenter);
		//添加默认角色为主要研究者
		TRSubcenterDoctorRole subcenterDoctorRole = new TRSubcenterDoctorRole();
		subcenterDoctorRole.setProjectId(projectSubcenter.getProjectId());
		subcenterDoctorRole.setSubcenterId(projectSubcenter.getSubcenterId());
		subcenterDoctorRole.setDoctorId(projectSubcenter.getSubcenterDirector());
		subcenterDoctorRole.setRoleId(10);//主要研究者
		this.subcenterDoctorRoleDao.insert(subcenterDoctorRole);
		return projectSubcenter;
	}

	@Transactional
	@Override
	public boolean createProjectSubcenter(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException, ObjectAlreadyExistExcption, UnsupportedEncodingException, RejectRequestExcption {
		Doctor doctor = this.doctorService.createDoctor(projectSubcenterDetailInfo);
		projectSubcenterDetailInfo.setSubcenterDirector(doctor.getDoctorId());
		//验证该医生是否已在该专题的分中心里
		if(this.projectSubcenterDao.findByDoctorId(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterDirector()) != null){
			throw new ObjectAlreadyExistExcption("The doctor is in the center of the subject.");
		}
		//判断该分中心名称是否已存在
		if(this.projectSubcenterDao.existProjectSubcenterName(projectSubcenterDetailInfo.getProjectId(), projectSubcenterDetailInfo.getSubcenterName()) > 0){
			throw new RejectRequestExcption("Sub center already exists.");
		}
		//补充医生信息，如果库中医生信息不全，使用这里的参数补充部分信息
		this.doctorService.supplyDoctorInfo(doctor, projectSubcenterDetailInfo);
		//保存分中心基本信息
		this.projectSubcenterDao.insert(projectSubcenterDetailInfo);
		//保存分中心医生的角色关系
		if (projectSubcenterDetailInfo.getSubcenterRoleList() != null &&
				!projectSubcenterDetailInfo.getSubcenterRoleList().isEmpty()) {
			for (TProjectSubcenterRoleInfo item : projectSubcenterDetailInfo.getSubcenterRoleList()) {
				item.setProjectId(projectSubcenterDetailInfo.getProjectId());
				item.setSubcenterId(projectSubcenterDetailInfo.getSubcenterId());
				item.setDoctorId(doctor.getDoctorId());
			}
			this.subcenterDoctorRoleDao.insertByBatch(projectSubcenterDetailInfo.getSubcenterRoleList());
		}
		//保存专题邀请信息
		this.projectInvitationService.addProjectInvitation(projectSubcenterDetailInfo);
		return true;
	}

	@Override
	public List<TProjectSubcenter> listProjectSubcenter(String projectId) {
		return this.projectSubcenterDao.findProjectSubcenters(projectId);
	}

	@Transactional
	@Override
	public boolean createDefaultProjectSubcenter(TProjectSimpleInfo projectSimpleInfo) {
		HospitalProfile hospitalProfile = this.hospitalDao.findByDoctorId(projectSimpleInfo.getProjectDirector());
		
		TProjectSubcenter projectSubcenter = new TProjectSubcenter();
		projectSubcenter.setProjectId(projectSimpleInfo.getProjectId());
		projectSubcenter.setSubcenterDirector(projectSimpleInfo.getProjectDirector());
		if (hospitalProfile == null) {
			projectSubcenter.setSubcenterName(projectSimpleInfo.getProjectName());
		} else {
			projectSubcenter.setSubcenterName(hospitalProfile.getHospitalName());
		}
		projectSubcenter.setState(1);
		
		this.projectSubcenterDao.insert(projectSubcenter);
		
		List<TRSubcenterDoctorRole> doctorRoles = new ArrayList<TRSubcenterDoctorRole>();
		//添加默认角色为数据管理员和主要研究者
		/*
		TRSubcenterDoctorRole dataManager = new TRSubcenterDoctorRole();
		dataManager.setProjectId(projectSubcenter.getProjectId());
		dataManager.setSubcenterId(projectSubcenter.getSubcenterId());
		dataManager.setDoctorId(projectSubcenter.getSubcenterDirector());
		dataManager.setRoleId(10);//数据管理员
		doctorRoles.add(dataManager);
		*/
		TRSubcenterDoctorRole mainResearcher = new TRSubcenterDoctorRole();
		mainResearcher.setProjectId(projectSubcenter.getProjectId());
		mainResearcher.setSubcenterId(projectSubcenter.getSubcenterId());
		mainResearcher.setDoctorId(projectSubcenter.getSubcenterDirector());
		mainResearcher.setRoleId(20);//主要研究者
		doctorRoles.add(mainResearcher);

		this.subcenterDoctorRoleDao.insertByBatch(doctorRoles);
		return true;
	}
}
