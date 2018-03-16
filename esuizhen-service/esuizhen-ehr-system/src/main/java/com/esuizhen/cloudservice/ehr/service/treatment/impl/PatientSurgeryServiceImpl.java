package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.PatientSurgeryDao;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientSurgeryInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientSurgeryService;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientTreatmentService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;

@Service
@Transactional
public class PatientSurgeryServiceImpl implements PatientSurgeryService {

	@Autowired
	private PatientSurgeryDao patientSurgeryDao;

	@Autowired
	private PatientTreatmentService patientTreatmentService;

	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;
	@Autowired
	private TPatientInfoDao patientInfoDao;

	@Override
	public List<TPatientSurgeryInfo> queryPatientSurgeryInfoByInHospitalId(CommonReq req) {
		return this.patientSurgeryDao.queryPatientSurgeryInfoByInHospitalId(req);
	}

	@Override
	public void insertPatientSurgeryInfo(TPatientSurgeryInfo patientSurgeryInfo) {
		if (UtilValidate.isEmpty(patientSurgeryInfo.getSurgeryId()) && patientSurgeryInfo.getActionFlag() != null && patientSurgeryInfo.getActionFlag() == 1) {
			patientSurgeryInfo.setSurgeryId(GeneralUtil.generatorUUID("SUR"));
			this.patientSurgeryDao.insertPatientSurgeryInfo(patientSurgeryInfo);
		} else if (UtilValidate.isNotEmpty(patientSurgeryInfo.getSurgeryId()) && patientSurgeryInfo.getActionFlag() != null && patientSurgeryInfo.getActionFlag() == 2) {
			this.patientSurgeryDao.updatePatientSurgeryInfo(patientSurgeryInfo);
		}
	}

	@Override
	public void deletePatientSurgeryInfo(Map<String, Object> delMap) {
		this.patientSurgeryDao.deletePatientSurgeryInfo(delMap);
	}

	@Override
	public void savePatientSurgeryInfo(List<TPatientSurgeryInfo> patientSurgeryInfoList) {
		String inhospitalId = null;
		// 先将手术记录删除
		if (UtilValidate.isNotEmpty(patientSurgeryInfoList)) {
			inhospitalId = patientSurgeryInfoList.get(0).getInhospitalId();
			Map<String, Object> delMap = new HashMap<String, Object>();
			delMap.put("inhospitalId", inhospitalId);
			this.deletePatientSurgeryInfo(delMap);
		}
		// 再添加手术记录
		for (TPatientSurgeryInfo patientSurgeryInfo : patientSurgeryInfoList) {
			this.insertPatientSurgeryInfo(patientSurgeryInfo);
		}
	}

	/**
	 * 保存手术的医患关系表 add by xueyongyan 20170512
	 * 
	 * @param inhospitalSurgeryMsg
	 */
	void savaSurgeryPatientDoctor(TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitalSurgeryMsg) {
		Long patientId = inhospitalSurgeryMsg.getPatientId();
		List<DoctorPatient> dpList = patientInfoDao.searchDoctorPatient(patientId, null);
		List<DoctorPatient> doctorPatientList = new ArrayList<DoctorPatient>();
		List<TPatientSurgeryInfo> surgeryList = inhospitalSurgeryMsg.getResultList();
		if (surgeryList != null && surgeryList.size() > 0) {
			for (int i = 0; i < surgeryList.size(); i++) {
				Integer surgeryDoctor = surgeryList.get(i).getSurgeryDoctor();
				Integer surgeryAssistant1 = surgeryList.get(i).getSurgeryAssistant1();
				Integer surgeryAssistant2 = surgeryList.get(i).getSurgeryAssistant2();
				if (dpList != null && dpList.size() > 0) {
					for (int j = 0; j < dpList.size(); j++) {
						if (surgeryDoctor != null && dpList.get(j).getDoctorId() != null) {
							if (surgeryDoctor.toString().equals(dpList.get(j).getDoctorId().toString())) {
								break;
							} else {
								if (j == dpList.size() - 1) {
									DoctorPatient dp = new DoctorPatient();
									dp.setDoctorId(Long.parseLong(surgeryDoctor.toString()));
									doctorPatientList.add(dp);
								}
							}

						}
					}
					for (int j = 0; j < dpList.size(); j++) {
						if (surgeryAssistant1 != null && dpList.get(j).getDoctorId() != null) {
							if (surgeryAssistant1.toString().equals(dpList.get(j).getDoctorId().toString())) {
								break;
							} else {
								if (j == dpList.size() - 1) {
									DoctorPatient dp2 = new DoctorPatient();
									dp2.setDoctorId(Long.parseLong(surgeryAssistant1.toString()));
									doctorPatientList.add(dp2);
								}
							}
						}
					}
					for (int j = 0; j < dpList.size(); j++) {
						if (surgeryAssistant2 != null && dpList.get(j).getDoctorId() != null) {
							if (surgeryAssistant2.toString().equals(dpList.get(j).getDoctorId().toString())) {
								break;
							} else {
								if (j == dpList.size() - 1) {
									DoctorPatient dp3 = new DoctorPatient();
									dp3.setDoctorId(Long.parseLong(surgeryAssistant2.toString()));
									doctorPatientList.add(dp3);
								}
							}
						}
					}
				} else {
					if (surgeryDoctor != null) {
						DoctorPatient dp = new DoctorPatient();
						dp.setDoctorId(Long.parseLong(surgeryDoctor.toString()));
						doctorPatientList.add(dp);

					}
					if (surgeryAssistant1 != null) {
						DoctorPatient dp2 = new DoctorPatient();
						dp2.setDoctorId(Long.parseLong(surgeryAssistant1.toString()));
						doctorPatientList.add(dp2);
					}
					if (surgeryAssistant2 != null) {
						DoctorPatient dp3 = new DoctorPatient();
						dp3.setDoctorId(Long.parseLong(surgeryAssistant2.toString()));
						doctorPatientList.add(dp3);
					}
				}
			}
			Set<Long> idSet = new HashSet<Long>(); // 去除重复的
			for (int i = 0; i < doctorPatientList.size(); i++) {
				idSet.add(doctorPatientList.get(i).getDoctorId());
			}
			List<DoctorPatient> doctorPatientList2 = new ArrayList<DoctorPatient>();
			Iterator<Long> it = idSet.iterator();
			while (it.hasNext()) {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(it.next());
				dp.setPatientId(patientId);
				dp.setSourceFlag(3);
				doctorPatientList2.add(dp);
			}
			if (doctorPatientList2.size() > 0) {
				Map<String, Object> doctorPatientMap = new HashMap<String, Object>();
				doctorPatientMap.put("doctorPatientList", doctorPatientList2);
				patientInfoDao.batchInsertDoctorPatient(doctorPatientMap);
			}
		}
	}

	/**
	 * 1.将最早一次住院主治主诊医生更新到患者表 2.将最早一次住院医生更新到医患关系表
	 * 
	 * @param patientId
	 */
	public void updatePatientAndDoctorPatient(Long patientId) {
		LogUtil.log.info("== 1.将最早一次住院主治主诊医生更新到患者表 2.将最早一次住院医生更新到医患关系表 ==");
		LogUtil.log.info("== 开始 == ");
		patientInfoDao.updatePatientFromInhospitalNote(patientId);
		patientInfoDao.updateRDoctorPatientFromInhospitalNote(patientId);
		LogUtil.log.info("== 1.将最早一次住院主治主诊医生更新到患者表 2.将最早一次住院医生更新到医患关系表 ==");
		LogUtil.log.info("== 结束 == ");
	}

	@Override
	@Transactional
	public void savePatientSurgeryInfo(TInhospitallSurgeryMsg<TPatientSurgeryInfo> inhospitalSurgeryMsg) {
		String inhospitalId = inhospitalSurgeryMsg.getInhospitalId();
		String clinicMedicalId = inhospitalSurgeryMsg.getClinicMedicalId();
		Long patientId = inhospitalSurgeryMsg.getPatientId();
		long start = System.currentTimeMillis();
		if (patientId != null) {
			savaSurgeryPatientDoctor(inhospitalSurgeryMsg);
		}
		long end = System.currentTimeMillis();
		long time = end - start;
		LogUtil.log.info("== savaSurgeryPatientDoctor == 更新医患关系耗时 == " + time);
		try {
			updatePatientAndDoctorPatient(patientId);
		} catch (Exception e) {
			LogUtil.log.info(e.getMessage());
		}
		List<TPatientSurgeryInfo> patientSurgeryInfoList = inhospitalSurgeryMsg.getResultList();

		// 先将手术记录删除
		// Map<String, Object> delMap =
		// new HashMap<String,
		// Object>();
		// delMap.put("clinicMedicalId",
		// clinicMedicalId);
		// delMap.put("inhospitalId",
		// inhospitalId);
		// this.deletePatientSurgeryInfo(delMap);
		String treatmentId = null;
		/*CommonReq req = new CommonReq();
		req.setPatientId(patientId);
		req.setTreatmentTypeId(1);// 1:手术
		req.setInhospitalId(inhospitalId);
		req.setClinicMedicalId(clinicMedicalId);
		List<TPatientTreatmentInfo> treatmentInfoList = patientTreatmentService.queryPatientTreatmentInfoByInHospitalId(req);
		if (treatmentInfoList != null && treatmentInfoList.size() > 0 && treatmentInfoList.get(0) != null)
			treatmentId = treatmentInfoList.get(0).getTreatmentId();*/
		// 再添加手术记录
		if (UtilValidate.isNotEmpty(patientSurgeryInfoList)) {
			for (TPatientSurgeryInfo patientSurgeryInfo : patientSurgeryInfoList) {
				/*TPatientTreatmentInfo treatment = patientTreatmentService.queryPatientTreatmentInfoByKey(patientSurgeryInfo.getTreatmentId());
				if(treatment != null) {
					treatmentId = treatment.getTreatmentId();
				}*/
				if (StringUtils.isNotEmpty(patientSurgeryInfo.getSurgeryId()) && patientSurgeryInfo.getActionFlag() != null && patientSurgeryInfo.getActionFlag() == 3) {
					Map<String, Object> delMap = new HashMap<String, Object>();
					delMap.put("surgeryId", patientSurgeryInfo.getSurgeryId());
					this.deletePatientSurgeryInfo(delMap);
					delMap.put("treatmentId", patientSurgeryInfo.getTreatmentId());
					if(StringUtils.isNotEmpty(patientSurgeryInfo.getTreatmentId())) {
						patientTreatmentService.deletePatientTreatmentInfo(delMap);
					}
				} else {
					// add by
					// fanpanwei更新手术类型元数据信息
					/*
					 * UserDefinedMetaData
					 * metaData = new
					 * UserDefinedMetaData
					 * ();
					 * metaData.setCreator
					 * (
					 * patientSurgeryInfo
					 * .
					 * getOperatorId());
					 * metaData
					 * .setMainKeyCode
					 * (patientSurgeryInfo
					 * .getOpCode());
					 * metaData
					 * .setMetaName
					 * (patientSurgeryInfo
					 * .
					 * getSurgeryName())
					 * ;
					 * 
					 * metaData.
					 * setMetaDataTable(
					 * "ehr_db.meta_e_icd_9_cm3"
					 * ); metaData.
					 * setMainKeyField
					 * ("opId");
					 * metaData
					 * .setMainKeyCodeField
					 * ("opCode");
					 * metaData
					 * .setMetaNameField
					 * ("opName");
					 * metaData
					 * .setQueryCondition
					 * (" AND opCode='"
					 * +
					 * patientSurgeryInfo
					 * .getOpCode() +
					 * "'"); this.
					 * metaDataUserDefinedService
					 * .
					 * addMetaDateInIntKey
					 * (metaData);
					 */
					// 更新业务数据
					// add by fanpanwei
					// 治疗表记录手术
					if (org.apache.commons.lang.StringUtils.isBlank(patientSurgeryInfo.getTreatmentId())) {
						TPatientTreatmentInfo treatmentInfo = new TPatientTreatmentInfo();
						treatmentInfo.setClinicMedicalId(clinicMedicalId);
						treatmentInfo.setInhospitalId(inhospitalId);
						treatmentInfo.setPatientId(patientId);
						treatmentInfo.setSourceFlag(2);
						treatmentInfo.setTreatmentBeginTime(patientSurgeryInfo.getSurgeryBeginTime());
						treatmentInfo.setTreatmentBeginTime(patientSurgeryInfo.getSurgeryEndTime());
						treatmentInfo.setTreatmentTypeId(1);
						treatmentInfo.setTreatmentName("手术治疗");
						treatmentInfo.setEmrId("1");
						if(patientSurgeryInfo.getOpCharacter() != null && !(patientSurgeryInfo.getOpCharacter() == 1 || patientSurgeryInfo.getOpCharacter() == 2)) {
							treatmentId = patientTreatmentService.insertPatientTreatmentInfo(treatmentInfo);
						}
					}
					patientSurgeryInfo.setInhospitalId(inhospitalId);
					patientSurgeryInfo.setClinicMedicalId(clinicMedicalId);
					patientSurgeryInfo.setPatientId(inhospitalSurgeryMsg.getPatientId());
					if (StringUtils.isEmpty(patientSurgeryInfo.getPatientNo())) {
						patientSurgeryInfo.setPatientNo(inhospitalSurgeryMsg.getPatientNo());
					}
					patientSurgeryInfo.setHospitalId(inhospitalSurgeryMsg.getHospitalId());
					patientSurgeryInfo.setTreatmentId(treatmentId);
					String incision = patientSurgeryInfo.getIncisionLevel() == null ? "" : patientSurgeryInfo.getIncisionLevel();
					String heal = patientSurgeryInfo.getHealing() == null ? "" : patientSurgeryInfo.getHealing();
					patientSurgeryInfo.setIncisionHealing(incision + "/" + heal);
					if(patientSurgeryInfo.getTreatmentId() == null) {
						patientSurgeryInfo.setTreatmentId("");
					}
					this.insertPatientSurgeryInfo(patientSurgeryInfo);
				}
			}
		}

	}

}
