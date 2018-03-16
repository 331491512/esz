package com.esuizhen.cloudservice.ehr.service.treatment.impl;

import java.util.ArrayList;  
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.treatment.PatientTreatmentDao;
import com.esuizhen.cloudservice.ehr.model.treatment.PatientTreatmentInfoReq;
import com.esuizhen.cloudservice.ehr.model.treatment.RadiationSourceInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TInhospitallSurgeryMsg;
import com.esuizhen.cloudservice.ehr.model.treatment.TPatientTreatmentInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentChemotherapyMedicationInfo;
import com.esuizhen.cloudservice.ehr.model.treatment.TreatmentRadiotherapyInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.treatment.PatientTreatmentService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentChemotherapyMedicationInfoService;
import com.esuizhen.cloudservice.ehr.service.treatment.TreatmentRadiotherapyInfoService;
import com.esuizhen.cloudservice.ehr.util.UtilValidate;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
@Transactional
@Service("treatmentService")
public class PatientTreatmentServiceImpl extends CommonServiceImpl<TPatientTreatmentInfo> implements PatientTreatmentService {

	@Autowired
	private PatientTreatmentDao patientTreatmentDao;
	
	@Autowired
	private TreatmentChemotherapyMedicationInfoService chemotherapyMedicationInfoService;
	
	@Autowired
	private TreatmentRadiotherapyInfoService radiotherapyInfoService;
	
	@Override
	public CommonDao<TPatientTreatmentInfo> getCommonDao() {
		return null;
	}

	@Override
	public List<TPatientTreatmentInfo> queryPatientTreatmentInfoByInHospitalId(CommonReq req) {
		return this.patientTreatmentDao.queryPatientTreatmentInfoByInHospitalId(req);
	}

	@Override
	public String insertPatientTreatmentInfo(TPatientTreatmentInfo patientTreatmentInfo) {
		String newTreatmentId = null;
		if (patientTreatmentInfo.getSourceFlag() == null) {
			patientTreatmentInfo.setSourceFlag(3);
		}
		if (UtilValidate.isEmpty(patientTreatmentInfo.getTreatmentId())) {
			patientTreatmentInfo.setTreatmentId(GeneralUtil.generatorUUID("TRE"));
			newTreatmentId = patientTreatmentInfo.getTreatmentId();
			this.patientTreatmentDao.insertPatientTreatmentInfo(patientTreatmentInfo);
		}else {
			this.patientTreatmentDao.updatePatientTreatmentInfo(patientTreatmentInfo);
			newTreatmentId = patientTreatmentInfo.getTreatmentId();
		}
		return newTreatmentId;
	}

	@Override
	public void deletePatientTreatmentInfo(Map<String,Object> paramsMap) {
		this.patientTreatmentDao.deletePatientTreatmentInfo(paramsMap);
	}

	@Override
	public void savePatientTreatmentInfo(List<TPatientTreatmentInfo> patientTreatmentInfoList) {
		String inhospitalId = null;
		// 先将治疗项目删除
		if (UtilValidate.isNotEmpty(patientTreatmentInfoList)) {
			inhospitalId = patientTreatmentInfoList.get(0).getInhospitalId();
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("inhospitalId", inhospitalId);
			this.deletePatientTreatmentInfo(paramsMap);
		}
		// 再添加治疗项目
		for (TPatientTreatmentInfo patientTreatmentInfo : patientTreatmentInfoList) {
			this.insertPatientTreatmentInfo(patientTreatmentInfo);
		}

	}
	
	@Transactional
	@Override
	public void savePatientTreatmentInfo(TInhospitallSurgeryMsg<TPatientTreatmentInfo> inhospitalSurgeryMsg) {
		String inhospitalId = inhospitalSurgeryMsg.getInhospitalId();
		List<TPatientTreatmentInfo> patientTreatmentInfoList = inhospitalSurgeryMsg.getResultList();
		// 再添加治疗项目
		if (UtilValidate.isNotEmpty(patientTreatmentInfoList)) {
			for (TPatientTreatmentInfo patientTreatmentInfo : patientTreatmentInfoList) {
				if(StringUtils.isNotEmpty(patientTreatmentInfo.getTreatmentId())&&patientTreatmentInfo.getActionFlag() != null && patientTreatmentInfo.getActionFlag() == 3) {
					// 先将治疗项目删除
					Map<String, Object> paramsMap = new HashMap<String, Object>();
					paramsMap.put("treatmentId", patientTreatmentInfo.getTreatmentId());
					radiotherapyInfoService.deleteRadiotherapyInfo(paramsMap);
					chemotherapyMedicationInfoService.deleteChemotherapyMedicationInfo(paramsMap);
					this.deletePatientTreatmentInfo(paramsMap);
					continue;
				}
				patientTreatmentInfo.setInhospitalId(inhospitalId);
				patientTreatmentInfo.setClinicMedicalId(inhospitalSurgeryMsg.getClinicMedicalId());
				patientTreatmentInfo.setPatientId(inhospitalSurgeryMsg.getPatientId());
				this.insertPatientTreatmentInfo(patientTreatmentInfo);
				switch(patientTreatmentInfo.getTreatmentTypeId()) {
					case 3:
						TreatmentRadiotherapyInfo radiotherapyInfo = patientTreatmentInfo.getRadiotherapyInfo();
						if(radiotherapyInfo != null) {
							radiotherapyInfo.setTreatmentId(patientTreatmentInfo.getTreatmentId());
							radiotherapyInfo.setPatientId(inhospitalSurgeryMsg.getPatientId());
							radiotherapyInfo.setInhospitalId(inhospitalId);
							radiotherapyInfo.setClinicMedicalId(inhospitalSurgeryMsg.getClinicMedicalId());
							List<RadiationSourceInfo> radiationSourceArr = radiotherapyInfo.getRadiationSourceArr();
							if(radiationSourceArr != null && radiationSourceArr.size() > 0) {
								StringBuffer radiationSourceBuffer = new StringBuffer();
								StringBuffer radiationSourceDescBuffer = new StringBuffer();
								for(int i = 0;i < radiationSourceArr.size();i++) {
									RadiationSourceInfo rs = radiationSourceArr.get(i);
									if(i == radiationSourceArr.size()-1) {
										radiationSourceBuffer.append(rs.getRadiationSource());
										radiationSourceDescBuffer.append(rs.getRadiationSourceDesc());
									}else {
										radiationSourceBuffer.append(rs.getRadiationSource() + ",");
										radiationSourceDescBuffer.append(rs.getRadiationSourceDesc() + ",");
									}
								}
								radiotherapyInfo.setRadiationSource(radiationSourceBuffer.toString());
								radiotherapyInfo.setRadiationSourceDesc(radiationSourceDescBuffer.toString());
							}
							radiotherapyInfoService.saveRadiotherapyInfo(radiotherapyInfo);
						}
						break;
					case 2:
					case 4:
					case 5:
					case 6:
					case 8:
					case 9:
					case 12:
					case 17:
						if(patientTreatmentInfo.getChemotherapyMedication() != null) {
							patientTreatmentInfo.getChemotherapyMedication().setTreatmentId(patientTreatmentInfo.getTreatmentId());
							patientTreatmentInfo.getChemotherapyMedication().setPatientId(inhospitalSurgeryMsg.getPatientId());
							patientTreatmentInfo.getChemotherapyMedication().setInhospitalId(inhospitalId);
							patientTreatmentInfo.getChemotherapyMedication().setClinicMedicalId(inhospitalSurgeryMsg.getClinicMedicalId());
							patientTreatmentInfo.getChemotherapyMedication().setOperatorId(inhospitalSurgeryMsg.getOperatorId());
							chemotherapyMedicationInfoService.saveChemotherapyMedicationInfo(patientTreatmentInfo.getChemotherapyMedication());
						}
						break;
				}
			}
		}
	}

	@Override
	public List<TPatientTreatmentInfo> queryPatientTreatmentInfo(
			PatientTreatmentInfoReq req) {
		return patientTreatmentDao.queryPatientTreatmentInfo(req);
	}

	@Override
	public List<TPatientTreatmentInfo> queryImpl(CommonReq req) {
		if(req.getPatientType() != null && req.getPatientType() == 2) {
			PatientTreatmentInfoReq treatment = new PatientTreatmentInfoReq();
			treatment.setPatientId(req.getPatientId());
			treatment.setPatientType(req.getPatientType());
			treatment.setSpecialDiseaseRegisterId(req.getSpecialDiseaseRegisterId());
			return queryPatientTreatmentInfo(treatment);
		}else {
			if(req.getInhospitalId() == null && req.getClinicMedicalId() == null) {
				LogUtil.logError.debug("查询患者治疗信息，住院id为空、住院门诊为空");
				return null;
			}
			List<TreatmentRadiotherapyInfo> radiotherapyList = radiotherapyInfoService.queryRadiotherapyInfo(req);
			List<TreatmentChemotherapyMedicationInfo> chemotherapyMedicationList = chemotherapyMedicationInfoService.queryChemotherapyMedicationInfo(req);
			List<TPatientTreatmentInfo> patientTreatmentInfos = queryPatientTreatmentInfoByInHospitalId(req);
			for(TPatientTreatmentInfo patientTreatmentInfo : patientTreatmentInfos) {
				String treatmentId = patientTreatmentInfo.getTreatmentId();
				Integer treatmentTypeId = patientTreatmentInfo.getTreatmentTypeId();
				switch(treatmentTypeId) {
					case 3:
						if(radiotherapyList != null && radiotherapyList.size() > 0) {
							for(TreatmentRadiotherapyInfo radiotherapyInfo :radiotherapyList) {
								if(treatmentId.equals(radiotherapyInfo.getTreatmentId())) {
									List<RadiationSourceInfo> radiationSourceArr = new ArrayList<RadiationSourceInfo>();
									String radiationSource = radiotherapyInfo.getRadiationSource();
									if(StringUtils.isNotEmpty(radiationSource))  {
										String[] radiationSources = radiotherapyInfo.getRadiationSource().split(",");
										String[] radiationSourceDesc = null;
										if(radiotherapyInfo.getRadiationSourceDesc() != null) {
											radiationSourceDesc = radiotherapyInfo.getRadiationSourceDesc().split(",");
										}else {
											radiationSourceDesc = new String[0];
										}
										int radiationSourceDescIndex = radiationSourceDesc.length-1;
										for(int i = 0;i < radiationSources.length;i++) {
											RadiationSourceInfo rs = new RadiationSourceInfo();
											rs.setRadiationSource(radiationSources[i]);
											if(i <= radiationSourceDescIndex) {
												rs.setRadiationSourceDesc(radiationSourceDesc[i]);
											}
											radiationSourceArr.add(rs);
										}
									}
									radiotherapyInfo.setRadiationSourceArr(radiationSourceArr);
									patientTreatmentInfo.setRadiotherapyInfo(radiotherapyInfo);
									break;
								}
							}
						}
						break;
					case 2:
					case 4:
					case 5:
					case 6:
					case 8:
					case 9:
					case 12:
					case 17:
						if(chemotherapyMedicationList != null && chemotherapyMedicationList.size() > 0) {
							for(TreatmentChemotherapyMedicationInfo chemotherapyMedicationInfo:chemotherapyMedicationList) {
								if(treatmentId.equals(chemotherapyMedicationInfo.getTreatmentId())) {
									patientTreatmentInfo.setChemotherapyMedication(chemotherapyMedicationInfo);
									break;
								}
							}
						}
						break;
				}
			}
			return patientTreatmentInfos;
		}
	}

	@Override
	protected Map<String, Object> saveImpl(CommonReq req,List<TPatientTreatmentInfo> t) {
		Map<String, Object> resMap = null;
		if(req.getPatientType() != null && req.getPatientType() == 2) {
			resMap = saveSpecialDiseaseTreatment(req,t);
		}else {
			String inhospitalId = t.get(0).getInhospitalId();
			String clinicMedicalId = t.get(0).getClinicMedicalId();
			Long patientId = t.get(0).getPatientId();
			if(inhospitalId == null && clinicMedicalId == null) {
				LogUtil.logError.debug("保存患者治疗信息，住院id、门诊id为空。");
				return null;
			}
			if(patientId == null) {
				LogUtil.logError.debug("保存患者治疗信息，患者id为空");
				return null;
			}
			TInhospitallSurgeryMsg<TPatientTreatmentInfo> inhospitalSurgeryMsg = new TInhospitallSurgeryMsg<TPatientTreatmentInfo>();
			inhospitalSurgeryMsg.setInhospitalId(inhospitalId);
			inhospitalSurgeryMsg.setClinicMedicalId(clinicMedicalId);
			inhospitalSurgeryMsg.setPatientId(patientId);
			inhospitalSurgeryMsg.setResultList(t);
			inhospitalSurgeryMsg.setOperatorId(req.getOperatorId());
			if(req.getTreatmentSchemeId()!=null){
				inhospitalSurgeryMsg.setTreatmentSchemeId(req.getTreatmentSchemeId());
			}
			savePatientTreatmentInfo(inhospitalSurgeryMsg);
		}
		return resMap;
	}
	/**
	 * 特病治疗添加
	 * @param req
	 * @param t
	 * @return
	 */
	@Transactional
	private Map<String, Object> saveSpecialDiseaseTreatment(CommonReq req,List<TPatientTreatmentInfo> t) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		// 先将治疗项目删除
		Map<String,Object> paramsMap = new HashMap<String,Object>();
		paramsMap.put("patientId", req.getPatientId());
		paramsMap.put("specialDiseaseRegisterId", req.getSpecialDiseaseRegisterId());
		this.deletePatientTreatmentInfo(paramsMap);
		List<String> emptyTreatmentIdList = new ArrayList<String>();
		// 再添加治疗项目
		for (TPatientTreatmentInfo patientTreatmentInfo : t) {
			String newTreatmentId = this.insertPatientTreatmentInfo(patientTreatmentInfo);
			if(newTreatmentId != null) {
				emptyTreatmentIdList.add(newTreatmentId);
			}
		}
		resMap.put("emptyTreatmentIdList", emptyTreatmentIdList);
		return resMap;
	}

	@Override
	public String savePatientTreatmentDetail(TPatientTreatmentInfo t) {
		String inhospitalId = t.getInhospitalId();
		String clinicMedicalId = t.getClinicMedicalId();
		String treatmentId = t.getTreatmentId();
		Long patientId = t.getPatientId();
		if(inhospitalId == null && clinicMedicalId == null) {
			LogUtil.logError.debug("保存患者治疗信息，住院id、门诊id为空。");
			return null;
		}
		if(patientId == null) {
			LogUtil.logError.debug("保存患者治疗信息，患者id为空");
			return null;
		}
		// 先将治疗项目删除
		if(StringUtils.isNotEmpty(treatmentId)) {
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("patientId", patientId);
			paramsMap.put("inhospitalId", inhospitalId);
			paramsMap.put("clinicMedicalId", clinicMedicalId);
			paramsMap.put("treatmentId", treatmentId);
			radiotherapyInfoService.deleteRadiotherapyInfo(paramsMap);
			chemotherapyMedicationInfoService.deleteChemotherapyMedicationInfo(paramsMap);
			this.deletePatientTreatmentInfo(paramsMap);
		}
		
		// 再添加治疗项目
		this.insertPatientTreatmentInfo(t);
		switch(t.getTreatmentTypeId()) {
			case 3:
				TreatmentRadiotherapyInfo radiotherapyInfo = t.getRadiotherapyInfo();
				if(radiotherapyInfo != null) {
					radiotherapyInfo.setTreatmentId(t.getTreatmentId());
					radiotherapyInfo.setPatientId(patientId);
					radiotherapyInfo.setInhospitalId(inhospitalId);
					radiotherapyInfo.setClinicMedicalId(clinicMedicalId);
					List<RadiationSourceInfo> radiationSourceArr = radiotherapyInfo.getRadiationSourceArr();
					if(radiationSourceArr != null && radiationSourceArr.size() > 0) {
						StringBuffer radiationSourceBuffer = new StringBuffer();
						StringBuffer radiationSourceDescBuffer = new StringBuffer();
						for(int i = 0;i < radiationSourceArr.size();i++) {
							RadiationSourceInfo rs = radiationSourceArr.get(i);
							if(i == radiationSourceArr.size()-1) {
								radiationSourceBuffer.append(rs.getRadiationSource());
								radiationSourceDescBuffer.append(rs.getRadiationSourceDesc());
							}else {
								radiationSourceBuffer.append(rs.getRadiationSource() + ",");
								radiationSourceDescBuffer.append(rs.getRadiationSourceDesc() + ",");
							}
						}
						radiotherapyInfo.setRadiationSource(radiationSourceBuffer.toString());
						radiotherapyInfo.setRadiationSourceDesc(radiationSourceDescBuffer.toString());
					}
					radiotherapyInfoService.saveRadiotherapyInfo(radiotherapyInfo);
				}
				break;
			case 2:
			case 4:
			case 5:
			case 6:
			case 8:
			case 9:
			case 12:
			case 17:
				if(t.getChemotherapyMedication() != null) {
					t.getChemotherapyMedication().setTreatmentId(t.getTreatmentId());
					t.getChemotherapyMedication().setPatientId(patientId);
					t.getChemotherapyMedication().setInhospitalId(inhospitalId);
					t.getChemotherapyMedication().setClinicMedicalId(clinicMedicalId);
					t.getChemotherapyMedication().setOperatorId(t.getOperatorId());
					chemotherapyMedicationInfoService.saveChemotherapyMedicationInfo(t.getChemotherapyMedication());
				}
				break;
		}
		return null;
	}
}
