package com.esuizhen.cloudservice.ehr.service.surgeryintensivecare.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.dao.surgeryintensivecare.PatientSurgeryIntensiveCareDao;
import com.esuizhen.cloudservice.ehr.model.surgeryintensivecare.TPatientSurgeryIntensiveCareInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.service.surgeryintensivecare.PatientSurgeryIntensiveCareService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class PatientSurgeryIntensiveCareServiceImpl implements PatientSurgeryIntensiveCareService {

	@Autowired
	private PatientSurgeryIntensiveCareDao patientSurgeryIntensiveCareDao;

	@Override
	public List<TPatientSurgeryIntensiveCareInfo> queryPatientSurgeryIntensiveCareInfoByInHospitalId(String inhospitalId) {
		return this.patientSurgeryIntensiveCareDao.queryPatientSurgeryIntensiveCareInfoByInHospitalId(inhospitalId);
	}

	@Override
	public void insertPatientSurgeryIntensiveCareInfo(TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo) {
		if (UtilValidate.isEmpty(patientSurgeryIntensiveCareInfo.getIntensiveId())) {
			patientSurgeryIntensiveCareInfo.setIntensiveId(GeneralUtil.generatorUUID("SIC"));
		}
		this.patientSurgeryIntensiveCareDao.insertPatientSurgeryIntensiveCareInfo(patientSurgeryIntensiveCareInfo);

	}

	@Override
	public void deletePatientSurgeryIntensiveCareInfo(String inhospitalId) {
		this.patientSurgeryIntensiveCareDao.deletePatientSurgeryIntensiveCareInfo(inhospitalId);
	}

	@Override
	public void savePatientSurgeryIntensiveCareInfo(List<TPatientSurgeryIntensiveCareInfo> patientSurgeryIntensiveCareInfoList) {
		String inhospitalId = null;
		// 先将重症删除
		if (UtilValidate.isNotEmpty(patientSurgeryIntensiveCareInfoList)) {
			inhospitalId = patientSurgeryIntensiveCareInfoList.get(0).getInhospitalId();
			this.deletePatientSurgeryIntensiveCareInfo(inhospitalId);
		}
		// 再添加重症记录
		for (TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo : patientSurgeryIntensiveCareInfoList) {
			this.insertPatientSurgeryIntensiveCareInfo(patientSurgeryIntensiveCareInfo);
		}
	}

	@Override
	public void savePatientSurgeryIntensiveCareInfo(
			TInhospitallSurgeryMsg<TPatientSurgeryIntensiveCareInfo> inhospitalSurgeryMsg) {
		String inhospitalId = inhospitalSurgeryMsg.getInhospitalId();
		List<TPatientSurgeryIntensiveCareInfo> patientSurgeryIntensiveCareInfoList = inhospitalSurgeryMsg
				.getResultList();

		if (UtilValidate.isNotEmpty(patientSurgeryIntensiveCareInfoList)) {

			// modify by zhuguo 根据actionFlag判断，1：增加，2：修改，3：删除
			for (TPatientSurgeryIntensiveCareInfo patientSurgeryIntensiveCareInfo : patientSurgeryIntensiveCareInfoList) {

				// 增加
				if (patientSurgeryIntensiveCareInfo.getActionFlag() == 1) {
					patientSurgeryIntensiveCareInfo
							.setInhospitalId(inhospitalId);
					this.insertPatientSurgeryIntensiveCareInfo(patientSurgeryIntensiveCareInfo);
				}

				// 修改
				if (patientSurgeryIntensiveCareInfo.getActionFlag() == 2) {
					if ("".equals(patientSurgeryIntensiveCareInfo
							.getIntensiveId())
							|| null == patientSurgeryIntensiveCareInfo
									.getIntensiveId()) {
						throw new EmptyParamExcption(
								"param error [IntensiveId] is null");
					}

					patientSurgeryIntensiveCareDao
							.updatePatientSurgeryIntensiveCareInfo(patientSurgeryIntensiveCareInfo);
				}

				// 删除
				if (patientSurgeryIntensiveCareInfo.getActionFlag() == 3) {
					if ("".equals(patientSurgeryIntensiveCareInfo
							.getIntensiveId())
							|| null == patientSurgeryIntensiveCareInfo
									.getIntensiveId()) {
						throw new EmptyParamExcption(
								"param error [IntensiveId] is null");
					}
					
					patientSurgeryIntensiveCareDao
							.deletePatientSurgeryIntensiveCareInfoByintensiveId(patientSurgeryIntensiveCareInfo);
				}
			}
		}
	}

}
