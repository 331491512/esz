package com.esuizhen.cloudservice.ehr.service.medicalRecord.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.PatientMedicalTreatmentResp;
import com.esuizhen.cloudservice.ehr.dao.medicalRecord.PatientMedicalTreatmentDao;
import com.esuizhen.cloudservice.ehr.service.medicalRecord.PatientMedicalTreatmentService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.util.PageUtil;

/**
 * @ClassName: PatientMedicalTreatmentServiceImpl
 * @Description: 历次就诊
 * @author zhuguo
 * @date 2017-5-27 18:02:05
 */
@Service
@Transactional
public class PatientMedicalTreatmentServiceImpl implements
		PatientMedicalTreatmentService {

	@Autowired
	private PatientMedicalTreatmentDao patientMedicalTreatmentDao;

	/**
	 * 患者历次就诊次数
	 * 
	 * @author zhuguo
	 */
	@Override
	public PatientMedicalTreatmentResp getPatientMedicalTreatmentTotal(
			PatientMedicalTreatmentResp resp) {

		return patientMedicalTreatmentDao.getPatientMedicalTreatmentTotal(resp);
	}

	/**
	 * 患者历次就诊记录列表
	 * 
	 * @author zhuguo
	 */
	@Override
	public Page<PatientMedicalTreatmentResp> getPatientMedicalTreatmentList(
			PatientMedicalTreatmentResp resp) {

		List<PatientMedicalTreatmentResp> list = null;
		PageHelper.startPage(resp.getPage() + 1, resp.getNum());

		list = patientMedicalTreatmentDao.getPatientMedicalTreatmentList(resp);

		return PageUtil
				.returnPage((com.github.pagehelper.Page<PatientMedicalTreatmentResp>) list);
	}

	/**
	 * 患者历次就诊记录详情
	 * 
	 * @author zhuguo
	 */
	@Override
	public PatientMedicalTreatmentResp getPatientMedicalTreatmentDetail(
			PatientMedicalTreatmentResp resp) {

		return patientMedicalTreatmentDao
				.getPatientMedicalTreatmentDetail(resp);
	}

	/**
	 * 查询其他诊断信息列表
	 * 
	 * @author zhuguo
	 */
	@Override
	public List<String> getOtherDiagnosisList(PatientMedicalTreatmentResp resp) {

		List<String> list = patientMedicalTreatmentDao
				.getOtherDiagnosisList(resp);

		if (null != list && list.size() > 0) {
			
			return list;
		}
		
		return null;
	}
}
