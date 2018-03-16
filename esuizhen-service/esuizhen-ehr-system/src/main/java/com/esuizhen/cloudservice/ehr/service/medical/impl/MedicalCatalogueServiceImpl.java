package com.esuizhen.cloudservice.ehr.service.medical.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.medical.MedicalCatalogueDao;
import com.esuizhen.cloudservice.ehr.model.medical.ChangeVersion;
import com.esuizhen.cloudservice.ehr.service.medical.MedicalCatalogueService;
import com.westangel.common.excption.EmptyParamExcption;

/**
 * 
 * @author zhuguo
 * @date 2017-9-15 10:47:02
 */
@Service
@Transactional
public class MedicalCatalogueServiceImpl implements MedicalCatalogueService {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private MedicalCatalogueDao medicalCatalogueDao;

	@Override
	public Integer insertChangeVersion(ChangeVersion changeVersion) {
		if (null == changeVersion.getPatientId()) {
			throw new EmptyParamExcption("param error [PatientId] is null");
		}
		if (StringUtils.isEmpty(changeVersion.getVisitId())) {
			throw new EmptyParamExcption("param error [VisitId] is null");
		}
		if (null == changeVersion.getVisitType()) {
			throw new EmptyParamExcption("param error [VisitType] is null");
		}
		if (null == changeVersion.getOperator()) {
			throw new EmptyParamExcption("param error [Operator] is null");
		}
		Integer result = medicalCatalogueDao.insertChangeVersion(changeVersion);
		return result;
	}

	@Override
	public Integer deleteChangeVersion(ChangeVersion changeVersion) {
		if (changeVersion.getChangeVersionId() == null) {
			throw new EmptyParamExcption("param error [changeVersionId] is null");
		}
		Integer result = medicalCatalogueDao.deleteChangeVersion(changeVersion);
		return result;
	}

	@Override
	public List<ChangeVersion> queryChangeVersionList(Long patientId,Integer hospitalId,String visitId) {
		List<ChangeVersion> list = null;
		list = medicalCatalogueDao.queryChangeVersionList(patientId,hospitalId,visitId);
		return list;
	}

	@Override
	public ChangeVersion queryChangeVersionInfo(ChangeVersion changeVersion) {
		if (changeVersion.getChangeVersionId() == null) {
			throw new EmptyParamExcption("param error [changeVersionId] is null");
		}
		ChangeVersion result = medicalCatalogueDao.queryChangeVersionInfo(changeVersion);
		return result;
	}
}
