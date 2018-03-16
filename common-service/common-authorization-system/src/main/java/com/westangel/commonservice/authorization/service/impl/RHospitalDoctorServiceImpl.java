package com.westangel.commonservice.authorization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.HospitalDoctor;
import com.westangel.commonservice.authorization.dao.RHospitalDoctorDao;
import com.westangel.commonservice.authorization.service.RHospitalDoctorService;

@Service
public class RHospitalDoctorServiceImpl implements RHospitalDoctorService {
	@Autowired
	private RHospitalDoctorDao hospitalDoctorDao;
	
	@Override
	public boolean addOrUpdateHospitalDoctor(Doctor doctor) {
		/*
		if (StringUtils.isEmpty(doctor.getStaffNo())) {
			return false;
		}
		*/
		if (doctor.getHospitalId() == null) {
			doctor.setHospitalId(0);
		}
		if (doctor.getDeptId() == null) {
			doctor.setDeptId(0);
		}
		HospitalDoctor hospitalDoctor = this.hospitalDoctorDao.find(doctor.getHospitalId(), doctor.getDoctorId());
		//已存在的医院、医生关系
		if (hospitalDoctor == null) {
			hospitalDoctor = new HospitalDoctor();
			hospitalDoctor.setDoctorId(doctor.getDoctorId());
			hospitalDoctor.setHospitalId(doctor.getHospitalId());
			hospitalDoctor.setDeptId(doctor.getDeptId());
			hospitalDoctor.setStaffNo(doctor.getStaffNo());
			hospitalDoctor.setPositionTitle(doctor.getPositionTitle());
			this.hospitalDoctorDao.insert(hospitalDoctor);
		}else{
			hospitalDoctor.setDoctorId(doctor.getDoctorId());
			hospitalDoctor.setStaffNo(doctor.getStaffNo());
			hospitalDoctor.setDeptId(doctor.getDeptId());
			hospitalDoctor.setPositionTitle(doctor.getPositionTitle());
			this.hospitalDoctorDao.updateByDoctorId(hospitalDoctor);
		}
		return true;
	}

}
