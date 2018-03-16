package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.dao.result.DoctorDao;
import com.esuizhen.cloudservice.research.dao.result.UserDao;
import com.esuizhen.cloudservice.research.service.result.DoctorService;
import com.esuizhen.cloudservice.research.service.result.HospitalDoctorService;
import com.esuizhen.cloudservice.research.service.result.UserService;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.User;
import com.westangel.common.excption.ParameterCannotBeNullException;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	private UserService userService;
	@Autowired
	private HospitalDoctorService hospitalDoctorService;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private DoctorDao doctorDao;
	
	@Transactional
	@Override
	public Doctor createDoctor(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) throws ParameterCannotBeNullException {
		if (StringUtils.isEmpty(projectSubcenterDetailInfo.getMobile()) ||
				projectSubcenterDetailInfo.getDeptId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<Doctor> doctors = this.doctorDao.findByMobile(projectSubcenterDetailInfo.getMobile());
		Doctor doctor = null;
		if (doctors != null && !doctors.isEmpty()) {
			doctor = doctors.get(0);
		}else{
			//账号信息
			User user = this.userService.createUser(projectSubcenterDetailInfo);
			//医生基本信息
			doctor = new Doctor();
			doctor.setUserId(user.getUserId());
			doctor.setMobile(projectSubcenterDetailInfo.getMobile());
			doctor.setTrueName(projectSubcenterDetailInfo.getTrueName());
			doctor.setProfessionalRank(projectSubcenterDetailInfo.getProfessionalRankId());
			this.doctorDao.insert(doctor);
		}
		projectSubcenterDetailInfo.setSubcenterDirector(doctor.getDoctorId());
		//医院医生关系
		this.hospitalDoctorService.createHospitalDoctor(projectSubcenterDetailInfo);
		return doctor;
	}

	@Override
	public boolean supplyDoctorInfo(Doctor doctor, TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		doctor = this.doctorDao.findByDoctorId(doctor.getDoctorId());
		if (doctor == null) {
			return false;
		}
		boolean editFlag = false;
		//职称
		if (projectSubcenterDetailInfo.getProfessionalRankId() != null &&
				doctor.getProfessionalRank() == null) {
			doctor.setProfessionalRank(projectSubcenterDetailInfo.getProfessionalRankId());
			editFlag = true;
		}
		//姓名
		if (StringUtils.isNotEmpty(projectSubcenterDetailInfo.getTrueName()) &&
				StringUtils.isEmpty(doctor.getTrueName())) {
			doctor.setTrueName(projectSubcenterDetailInfo.getTrueName());
			editFlag = true;
		}
		if (editFlag) {
			this.doctorDao.update(doctor);
		}
		//邮箱
		if (StringUtils.isNotEmpty(projectSubcenterDetailInfo.getEmail()) &&
				StringUtils.isEmpty(doctor.getEmail())) {
			this.userDao.update(doctor);
		}
		//医院科室医生关系
		projectSubcenterDetailInfo.setSubcenterDirector(doctor.getDoctorId());
		this.hospitalDoctorService.createHospitalDoctor(projectSubcenterDetailInfo);
		return true;
	}

}
