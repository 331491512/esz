package com.esuizhen.cloudservice.research.service.impl.result;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.result.TProjectThresholdPatientDao;
import com.esuizhen.cloudservice.research.model.result.TProjectThresholdPatient;
import com.esuizhen.cloudservice.research.model.result.TCrfResultMainInfo;
import com.esuizhen.cloudservice.research.service.result.ProjectThresholdPatientService;
import com.westangel.common.excption.ParameterCannotBeNullException;

@Service
public class ProjectThresholdPatientServiceImpl implements ProjectThresholdPatientService {
	@Autowired
	private TProjectThresholdPatientDao projectThresholdPatientDao;
	
	@Override
	public List<TProjectThresholdPatient> queryCrfProfilePhysicalExamThreshold(String projectId, Long patientId,
			Long doctorId) {
		List<TProjectThresholdPatient> projectThresholdPatients = projectThresholdPatientDao.findCrfProfilePhysicalExamThreshold(projectId, patientId, doctorId);
		if (projectThresholdPatients == null || projectThresholdPatients.isEmpty()) {
			projectThresholdPatients = projectThresholdPatientDao.findCrfProfilePhysicalExamThreshold(null, null, doctorId);
		}
		return projectThresholdPatients;
	}

	@Transactional
	@Override
	public boolean saveCrfProfilePhysicalExamThreshol(TCrfResultMainInfo<List<TProjectThresholdPatient>> crfResultMainInfo) throws ParameterCannotBeNullException {
		if (StringUtils.isEmpty(crfResultMainInfo.getProjectId()) || crfResultMainInfo.getPatientId() == null) {
			throw new ParameterCannotBeNullException("Parameters cannot be empty!");
		}
		List<TProjectThresholdPatient> projectThresholdPatients = crfResultMainInfo.getCrfResult();
		if (projectThresholdPatients == null || projectThresholdPatients.isEmpty()) {
			return false;
		}
		//删除之前的阈值信息
		this.projectThresholdPatientDao.deleteByProjectIdAndPatientId(crfResultMainInfo.getProjectId(), crfResultMainInfo.getPatientId());
		for (int i = 0; i < projectThresholdPatients.size(); i++) {
			TProjectThresholdPatient projectThresholdPatient = projectThresholdPatients.get(i);
			//处理专题ID
			if (projectThresholdPatient.getProjectId() == null) {
				projectThresholdPatient.setProjectId(crfResultMainInfo.getProjectId());
			}
			//处理患者ID
			if (projectThresholdPatient.getPatientId() == null) {
				projectThresholdPatient.setPatientId(crfResultMainInfo.getPatientId());
			}
			//creatorId
			if (projectThresholdPatient.getCreatorId() == null) {
				projectThresholdPatient.setCreatorId(crfResultMainInfo.getCreatorId());
			}
		}
		this.projectThresholdPatientDao.insertByBatch(projectThresholdPatients);
		return true;
	}

}
