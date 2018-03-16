package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TRSubcenterPatientDao;
import com.esuizhen.cloudservice.research.model.result.TRSubcenterPatient;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.TRSubcenterPatientService;
import com.westangel.common.bean.PatientSimpleInfo;

@Service
public class TRSubcenterPatientServiceImpl implements TRSubcenterPatientService {
	@Autowired
	private TRSubcenterPatientDao rSubcenterPatientDao;

	@Transactional
	@Override
	public boolean addByBatch(TCrfResultMainInfo<List<PatientSimpleInfo>> crfResultMainInfo) {
		TRSubcenterPatient rSubcenterPatient = new TRSubcenterPatient();
		rSubcenterPatient.setProjectId(crfResultMainInfo.getProjectId());
		rSubcenterPatient.setGroupId(crfResultMainInfo.getGroupId());
		rSubcenterPatient.setSubcenterId(crfResultMainInfo.getSubcenterId());
		for (PatientSimpleInfo patientSimpleInfo : crfResultMainInfo.getCrfResult()) {
			if (this.rSubcenterPatientDao.findPatientCount(crfResultMainInfo.getProjectId(), patientSimpleInfo.getPatientId()) > 0) {
				continue;
			}
			rSubcenterPatient.setPatientId(patientSimpleInfo.getPatientId());
			this.rSubcenterPatientDao.insert(rSubcenterPatient);
		}
		return true;
	}
}
