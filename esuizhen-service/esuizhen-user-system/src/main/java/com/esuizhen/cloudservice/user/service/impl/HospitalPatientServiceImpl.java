package com.esuizhen.cloudservice.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.dao.HospitalDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientDao;
import com.esuizhen.cloudservice.user.service.HospitalPatientService;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;

@Service(value="hospitalPatientService")
public class HospitalPatientServiceImpl implements HospitalPatientService, com.westangel.common.service.HospitalPatientService {
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	
	@Override
	public HospitalPatientBriefInfo existRelation(Integer hospitalId, Long patientId) {
		return this.hospitalPatientDao.find(hospitalId, patientId);
	}

	/**
	 * <p>Title:mergeHospitalPatient</p>
	 * <p>Description:合并ToB导入的医院患者关系</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午8:22:00
	 * @param patient
	 * @param tobPatient
	 * @return
	 */
	@Transactional
	public boolean mergeHospitalPatient(Patient patient, Patient tobPatient){
		//获取云端存在医院患者关系
		List<HospitalPatientBriefInfo> briefInfos = this.hospitalPatientDao.screening(patient.getPatientId(), tobPatient.getPatientId());
		if (briefInfos == null || briefInfos.isEmpty()) {
			briefInfos = null;
		}
		//合并医院患者关系
		this.hospitalPatientDao.updateToBHospitalPatientToCloudRelation(patient.getPatientId(), tobPatient.getPatientId(), briefInfos);
		//删除未合并的医院患者关系
		this.hospitalPatientDao.deleteByPatientId(tobPatient.getPatientId());
		
		//获取没有病案号的医院患者关系
		briefInfos = this.hospitalPatientDao.findNoPatientNoes(patient.getPatientId());
		for (int i = 0, size = briefInfos.size(); i < size; i++) {
			HospitalPatientBriefInfo hospitalPatientBriefInfo = briefInfos.get(i);
			String patientNo = this.hospitalPatientDao.findPatientNo(hospitalPatientBriefInfo.getPatientId(), hospitalPatientBriefInfo.getHospitalId());
			if (StringUtils.isNotEmpty(patientNo)) {
				hospitalPatientBriefInfo.setPatientNo(patientNo);
				this.hospitalPatientDao.update(hospitalPatientBriefInfo);
			}
		}
		return true;
	}

	@Transactional
	@Override
	public boolean handleHospitalPatientRelation(Patient cloudPatient, Patient toBPatient) {
		if (cloudPatient == null || cloudPatient.getPatientId() == null ||
				toBPatient == null || toBPatient.getPatientId() == null ||
				cloudPatient.getPatientId() == toBPatient.getPatientId()) {
			return false;
		}
		List<HospitalPatientBriefInfo> hospitalPatientBriefInfos = this.hospitalPatientDao.findByPatientId(toBPatient.getPatientId());
		if (hospitalPatientBriefInfos == null || hospitalPatientBriefInfos.isEmpty()) {
			return true;
		}
		for (int i = 0, size = hospitalPatientBriefInfos.size(); i < size; i++) {
			HospitalPatientBriefInfo hospitalPatientBriefInfo = hospitalPatientBriefInfos.get(i);
			//生产库是否有ToB导入的医院患者关系
			HospitalPatientBriefInfo hsopitalPatient = this.hospitalPatientDao.find(hospitalPatientBriefInfo.getHospitalId(), cloudPatient.getPatientId());
			if (hsopitalPatient == null) {
				//没有时，将医院患者关系修改为ToB患者
				hospitalPatientBriefInfo.setPatientId(cloudPatient.getPatientId());
				this.hospitalPatientDao.update(hospitalPatientBriefInfo);
			} else {
				if (StringUtils.isNotEmpty(hospitalPatientBriefInfo.getPatientNo()) && 
						StringUtils.isEmpty(hsopitalPatient.getPatientNo())) {
					hsopitalPatient.setPatientNo(hospitalPatientBriefInfo.getPatientNo());
					this.hospitalPatientDao.update(hsopitalPatient);
				}
				//已存在ToB导入的医院患者关系，将之前的生产库的关系删除
				this.hospitalPatientDao.delete(hospitalPatientBriefInfo.getId());
			}
		}
		//删除医院患者关系
		this.hospitalPatientDao.deleteByPatientId(toBPatient.getPatientId());
		return true;
	}

	@Override
	public boolean changeHospitalPatientRelation(Long cloudPatientId, Long tobPatientId){
		List<HospitalPatientBriefInfo> hospitalPatientBriefInfos = this.hospitalPatientDao.findByPatientId(tobPatientId);
		if (hospitalPatientBriefInfos == null || hospitalPatientBriefInfos.isEmpty()) {
			return true;
		}
		for (HospitalPatientBriefInfo hospitalPatientBriefInfo : hospitalPatientBriefInfos) {
			HospitalPatientBriefInfo hospitalPatient = this.hospitalPatientDao.find(hospitalPatientBriefInfo.getHospitalId(), cloudPatientId);
			if (hospitalPatient != null) {
				hospitalPatientBriefInfo.setSourceFlag(hospitalPatient.getSourceFlag());//保持之前的来源
				this.hospitalPatientDao.delete(hospitalPatient.getId());
			}
			hospitalPatientBriefInfo.setPatientId(cloudPatientId);
			this.hospitalPatientDao.update(hospitalPatientBriefInfo);
		}
		return true;
	}
}
