package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.dao.DoctorPatientDao;
import com.esuizhen.cloudservice.user.service.DoctorPatientService;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.Patient;

@Service
public class DoctorPatientServiceImpl implements DoctorPatientService {
	@Autowired
	public DoctorPatientDao doctorPatientDao;
	
	/**
	 * <p>Title:mergeDoctorPatient</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午7:50:44
	 * @param patient
	 * @param tobPatient
	 * @return
	 */
	public boolean mergeDoctorPatient(Patient patient, Patient tobPatient){
		//云端存在的医患关系
		List<DoctorPatient> doctorPatients = this.doctorPatientDao.screening(patient.getPatientId(), tobPatient.getPatientId());
		if (doctorPatients == null || doctorPatients.isEmpty()) {
			doctorPatients = null;
		}
		//修改医患关系
		this.doctorPatientDao.updateToBDoctorPatientToCloudRelation(patient.getPatientId(), tobPatient.getPatientId(), doctorPatients);
		//删除未合并的医患关系
		this.doctorPatientDao.deleteByPatientId(tobPatient.getPatientId());
		return true;
	}
}
