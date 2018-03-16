package com.esuizhen.cloudservice.research.service.impl.result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.research.bean.TProjectSubcenterDetailInfo;
import com.esuizhen.cloudservice.research.dao.result.HospitalDoctorDao;
import com.esuizhen.cloudservice.research.service.result.HospitalDoctorService;
import com.westangel.common.bean.HospitalDoctor;

@Service
public class HospitalDoctorServiceImpl implements HospitalDoctorService {
	@Autowired
	private HospitalDoctorDao hospitalDoctorDao;
	
	@Override
	public HospitalDoctor createHospitalDoctor(TProjectSubcenterDetailInfo projectSubcenterDetailInfo) {
		HospitalDoctor hospitalDoctor = this.hospitalDoctorDao.findByDoctorId(projectSubcenterDetailInfo.getSubcenterDirector());
		if (hospitalDoctor != null) {
			return hospitalDoctor;
		}
		hospitalDoctor = new HospitalDoctor();
		hospitalDoctor.setHospitalId(projectSubcenterDetailInfo.getHospitalId());
		hospitalDoctor.setDoctorId(projectSubcenterDetailInfo.getSubcenterDirector());
		hospitalDoctor.setDeptId(projectSubcenterDetailInfo.getDeptId());
		hospitalDoctor.setHospitalName(projectSubcenterDetailInfo.getSubcenterName());
		this.hospitalDoctorDao.insert(hospitalDoctor);
		
		return hospitalDoctor;
	}
	
}
