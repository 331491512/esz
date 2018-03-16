package com.esuizhen.cloudservice.ehr.service.diagnose.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.common.Common;
import com.esuizhen.cloudservice.ehr.dao.common.CommonDao;
import com.esuizhen.cloudservice.ehr.dao.diagnose.TDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaDataUserDefinedDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoDao;
import com.esuizhen.cloudservice.ehr.dao.progressdiagnosis.TProgressDiagnosisInfoDao;
import com.esuizhen.cloudservice.ehr.model.diagnose.PatientDiagnosisInfoReq;
import com.esuizhen.cloudservice.ehr.model.diagnose.TDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.progressdiagnosis.TProgressDiagnosisInfo;
import com.esuizhen.cloudservice.ehr.service.common.impl.CommonServiceImpl;
import com.esuizhen.cloudservice.ehr.service.diagnose.TDiagnosisInfoService;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
@Transactional
@Service("diagnosisInfoService")
public class TDiagnosisInfoServiceImpl extends CommonServiceImpl<TDiagnosisInfo> implements TDiagnosisInfoService<TDiagnosisInfo> {

	@Autowired
	private TDiagnosisInfoDao<TDiagnosisInfo> diagnosisInfoDao;

	@Autowired
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;

	@Autowired
	private MetaDataUserDefinedDao metaDataUserDefinedDao;
	
	@Autowired
	private MetaInfoDao metaInfoDao;

	@Autowired
	private TProgressDiagnosisInfoDao<TProgressDiagnosisInfo> progressDiagnosisInfoDao;
	
	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;

	@Override
	public CommonDao<TDiagnosisInfo> getCommonDao() {
		return null;
	}

	@Override
	public List<TDiagnosisInfo> queryDiagnosisInfoByInhospitalId(CommonReq req) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("inhospitalId", req.getInhospitalId());
		param.put("clinicMedicalId", req.getClinicMedicalId());
		param.put("diagnosisNoSort", "ASC");
		List<TDiagnosisInfo> diagnosisInfoList = diagnosisInfoDao.queryDiagnosisInfoBySelective(param);
		if (diagnosisInfoList == null) {
			return null;
		}
		if (req.getInhospitalId() != null) {
			TInhospitalDetailInfo inhospitalDetailInfo = inhospitalDetailInfoDao.queryInhospitalDetailByPrimaryKeyId(req.getInhospitalId());
			if (inhospitalDetailInfo != null) {
				Integer flag = metaInfoDao.findMetaInfoFromDiseaseTypeICD(inhospitalDetailInfo.getMainDiagnosisCode());
				if (flag != null && flag == 1) { // 恶性肿瘤
					for (TDiagnosisInfo d : diagnosisInfoList) {
						if (d.getDiagnosisCode() != null && d.getDiagnosisCode().equals(inhospitalDetailInfo.getMainDiagnosisCode())) {
							if (StringUtils.isEmpty(d.getTumourPeriodizationT())) {
								if (inhospitalDetailInfo.getTumourPeriodizationTId() != null) {
									d.setTumourPeriodizationTId(String.valueOf(inhospitalDetailInfo.getTumourPeriodizationTId()));
								}
								d.setTumourPeriodizationT(inhospitalDetailInfo.getTumourPeriodizationT());
							}
							if (StringUtils.isEmpty(d.getTumourPeriodizationN())) {
								if (inhospitalDetailInfo.getTumourPeriodizationNId() != null) {
									d.setTumourPeriodizationNId(String.valueOf(inhospitalDetailInfo.getTumourPeriodizationNId()));
								}
								d.setTumourPeriodizationN(inhospitalDetailInfo.getTumourPeriodizationN());
							}
							if (StringUtils.isEmpty(d.getTumourPeriodizationM1())) {
								if (inhospitalDetailInfo.getTumourPeriodizationM1Id() != null) {
									d.setTumourPeriodizationM1Id(String.valueOf(inhospitalDetailInfo.getTumourPeriodizationM1Id()));
								}
								d.setTumourPeriodizationM1(inhospitalDetailInfo.getTumourPeriodizationM1());
							}
							if (StringUtils.isEmpty(d.getTumourPeriodizationClinic())) {
								d.setTumourPeriodizationClinic(inhospitalDetailInfo.getTumourPeriodizationClinic());
							}
						}
					}

				}
			}
		}
		return diagnosisInfoList;
	}

	private Map<String,Object> saveTranDiagnosisInfo(List<TDiagnosisInfo> diagnosises) {
		int resCode = 0;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("resCode", 0);
		List<String> emptyDiagnosisIdList = new ArrayList<String>();
		String inhospitalId = diagnosises.get(0).getInhospitalId();
		String clinicMedicalId = diagnosises.get(0).getClinicMedicalId();
		if(inhospitalId != null) {
			TInhospitalDetailInfo inhospitalDetailInfo = inhospitalDetailInfoDao.queryInhospitalDetailByPrimaryKeyId(inhospitalId);
			if (inhospitalDetailInfo != null) {
				// 删除该住院首页下的诊断信息
				// diagnosisInfoDao.deleteDiagnosisInfoByInhospitalId(inhospitalDetailInfo.getInhospitalId());
				// 创建诊断信息
				// Map<String,Object>
				// sourceDiagnosisMap =
				// new
				// HashMap<String,Object>();
				int count = 0;
				for (TDiagnosisInfo diagnosis : diagnosises) {
					if (StringUtils.isNotEmpty(diagnosis.getDiagnosisId()) && diagnosis.getActionFlag() != null && diagnosis.getActionFlag() == 3) {
						diagnosisInfoDao.deleteDiagnosisInfoById(diagnosis.getDiagnosisId());
					}
					if (diagnosis.getActionFlag() != null) {
						// 更新业务数据
						// 更新诊断类型元数据信息
						/*
						 * UserDefinedMetaData
						 * metaData =
						 * new
						 * UserDefinedMetaData
						 * (); boolean
						 * updateMataFlag
						 * = true;
						 * metaData
						 * .setMetaDataTable
						 * (
						 * "ehr_db.meta_e_icd_10"
						 * ); metaData.
						 * setMainKeyField
						 * (
						 * "diseaseName"
						 * ); metaData.
						 * setQueryCondition
						 * (
						 * "diseaseCode='"
						 * + diagnosis.
						 * getDiagnosisCode
						 * () + "'");
						 * List<String>
						 * diseaseNameList
						 * =
						 * metaDataUserDefinedDao
						 * .
						 * getMetaDataListByNameToStr
						 * (metaData);
						 * if
						 * (diseaseNameList
						 * != null &&
						 * diseaseNameList
						 * .size() > 0)
						 * { for (String
						 * diseaseName :
						 * diseaseNameList
						 * ) { if
						 * (StringUtils
						 * .isBlank
						 * (diseaseName
						 * )) continue;
						 * //
						 * code和元数据表相同
						 * ，name不同
						 * ，不修改元数据表 if
						 * (!
						 * diseaseName.
						 * equals
						 * (diagnosis
						 * .getDiagnosis
						 * ()))
						 * updateMataFlag
						 * = false; } }
						 * if
						 * (updateMataFlag
						 * &&
						 * StringUtils
						 * .isNotBlank
						 * (diagnosis
						 * .getDiagnosisCode
						 * ())) {
						 * metaData =
						 * new
						 * UserDefinedMetaData
						 * (); metaData.
						 * setCreator
						 * (diagnosis
						 * .getOperatorId
						 * ());
						 * metaData.
						 * setMainKey
						 * (diagnosis
						 * .getDiagnosisCode
						 * ());
						 * metaData.
						 * setMetaName
						 * (diagnosis
						 * .getDiagnosis
						 * ());
						 * 
						 * metaData.
						 * setMetaDataTable
						 * (
						 * "ehr_db.meta_e_icd_10"
						 * ); metaData.
						 * setMainKeyField
						 * (
						 * "diseaseCode"
						 * ); metaData.
						 * setMetaNameField
						 * (
						 * "diseaseName"
						 * );
						 * 
						 * metaData.
						 * setQueryCondition
						 * (
						 * "diseaseCode='"
						 * + diagnosis.
						 * getDiagnosisCode
						 * () + "'");
						 * this.
						 * metaDataUserDefinedService
						 * .
						 * addMetaDateInStrKey
						 * (metaData); }
						 */

						diagnosis.setEmrId(inhospitalDetailInfo.getEmrId());
						diagnosis.setPatientId(inhospitalDetailInfo.getPatientId());
						diagnosis.setPatientNo(inhospitalDetailInfo.getPatientNo());
						diagnosis.setInhospitalId(inhospitalDetailInfo.getInhospitalId());
						if (diagnosis.getVisitTime() == null) {
							diagnosis.setVisitTime(inhospitalDetailInfo.getInhospitalDate());
						}
						diagnosis.setCreateTime(new Date());
						diagnosis.setUpdateTime(new Date());
						String diagnosisId = diagnosis.getDiagnosisId();

						StringBuffer tumourPeriodization = new StringBuffer();
						tumourPeriodization.append(diagnosis.getTumourPeriodizationT() == null ? "" : diagnosis.getTumourPeriodizationT());
						tumourPeriodization.append(diagnosis.getTumourPeriodizationN() == null ? "" : diagnosis.getTumourPeriodizationN());
						tumourPeriodization.append(diagnosis.getTumourPeriodizationM1() == null ? "" : diagnosis.getTumourPeriodizationM1());
						tumourPeriodization.append(" ");
						tumourPeriodization.append(diagnosis.getTumourPeriodizationClinic() == null ? "" : diagnosis.getTumourPeriodizationClinic());
						diagnosis.setTumourPeriodization(tumourPeriodization.toString());

						if (StringUtils.isEmpty(diagnosisId) && diagnosis.getActionFlag() == 1) {
							diagnosis.setDiagnosisId(GeneralUtil.generateUniqueID(Common.DIAGNOSIS_ID_PRE));
							emptyDiagnosisIdList.add(diagnosis.getDiagnosisId());
							resCode += diagnosisInfoDao.createDiagnosisInfo(diagnosis);
						} else if (StringUtils.isNotEmpty(diagnosisId) && diagnosis.getActionFlag() == 2) {
							// if
							// (StringUtils.isNotEmpty(diagnosis.getDiagnosisCode()))
							// {
							// TInhospitalDetailInfo
							// info =
							// new
							// TInhospitalDetailInfo();
							// info.setMainDiagnosisCode(diagnosis.getDiagnosisCode());
							// info.setTumourPeriodizationM1Id(null);
							// info.setTumourPeriodizationM1(diagnosis.getTumourPeriodizationM1());
							// info.setTumourPeriodizationNId(null);
							// info.setTumourPeriodizationN(diagnosis.getTumourPeriodizationN());
							// info.setTumourPeriodizationTId(null);
							// info.setTumourPeriodizationT(diagnosis.getTumourPeriodizationT());
							// info.setTumourPeriodizationClinic(diagnosis.getTumourPeriodizationClinic());
							// inhospitalDetailInfoDao.updateInhospitalByCode(info);
							// }
							resCode += diagnosisInfoDao.updateDiagnosisInfo(diagnosis);
						}
						// 把住院诊断提取到住院表中，实时更新住院主要诊断信息
						if (StringUtils.isNotEmpty(diagnosis.getDiagnosis())) {
							if (diagnosis.getDiagnosisTypeId() != null && diagnosis.getDiagnosisTypeId() == 1) {
								inhospitalDetailInfo.setMainDiagnosis(diagnosis.getDiagnosis());
								inhospitalDetailInfo.setMainDiagnosisCode(diagnosis.getDiagnosisCode());
								inhospitalDetailInfo.setInhospitalCondition(diagnosis.getInHospitalCondition());
							}
							Integer flag = metaInfoDao.findMetaInfoFromDiseaseTypeICD(diagnosis.getDiagnosisCode());
							if (flag != null && flag == 1) { // 恶性肿瘤
								count++;
								if (count == 1) {
									if (StringUtils.isNotEmpty(diagnosis.getTumourPeriodizationM1Id())) {
										inhospitalDetailInfo.setTumourPeriodizationM1Id(Integer.parseInt(diagnosis.getTumourPeriodizationM1Id()));
									} else {
										inhospitalDetailInfo.setTumourPeriodizationM1Id(null);
									}
									inhospitalDetailInfo.setTumourPeriodizationM1(diagnosis.getTumourPeriodizationM1());
									if (StringUtils.isNotEmpty(diagnosis.getTumourPeriodizationNId())) {
										inhospitalDetailInfo.setTumourPeriodizationNId(Integer.parseInt(diagnosis.getTumourPeriodizationNId()));
									} else {
										inhospitalDetailInfo.setTumourPeriodizationNId(null);
									}
									inhospitalDetailInfo.setTumourPeriodizationN(diagnosis.getTumourPeriodizationN());
									if (StringUtils.isNotEmpty(diagnosis.getTumourPeriodizationTId())) {
										inhospitalDetailInfo.setTumourPeriodizationTId(Integer.parseInt(diagnosis.getTumourPeriodizationTId()));
									} else {
										inhospitalDetailInfo.setTumourPeriodizationTId(null);
									}
									inhospitalDetailInfo.setTumourPeriodizationT(diagnosis.getTumourPeriodizationT());
									inhospitalDetailInfo.setTumourPeriodizationClinic(diagnosis.getTumourPeriodizationClinic());
								}

							}
							inhospitalDetailInfoDao.updateInhospitalDetailSelective(inhospitalDetailInfo);
						}
					}
				}
				//只提取第一次原发诊断
				
				/*TDiagnosisInfo diagnosis = diagnosisInfoDao.queryDiagnosisInfoByPatientId(inhospitalDetailInfo.getPatientId());
				if(diagnosis != null && diagnosis.getInhospitalId() != null && diagnosis.getInhospitalId().equals(inhospitalId)) {
					Map<String,Object> sourceDiagnosisMap = new HashMap<String,Object>();
					sourceDiagnosisMap.put("sourceDiagnosis", diagnosis.getDiagnosis());
					sourceDiagnosisMap.put("sourceDiseaseCode", diagnosis.getDiagnosisCode());
					sourceDiagnosisMap.put("sourcePathologyDiagnosis", diagnosis.getPathologyDiagnosis());
					sourceDiagnosisMap.put("sourcePathologyDiseaseCode", diagnosis.getPathologyDiagnosisCode());
					sourceDiagnosisMap.put("diagnosisId", diagnosis.getDiagnosisId());
					sourceDiagnosisMap.put("diagnosisType", diagnosis.getDiagnosisTypeId());
					sourceDiagnosisMap.put("sourceDiseaseTypeId", diagnosis.getDiseaseTypeId());
					sourceDiagnosisMap.put("confirmedDate", diagnosis.getVisitTime());
					sourceDiagnosisMap.put("icdDiseaseTypeId", diagnosis.getIcdDiseaseTypeId());
					sourceDiagnosisMap.put("inhospitalId", diagnosis.getInhospitalId());
					sourceDiagnosisMap.put("sourceTumorFlag", diagnosis.getTumorFlag());
					sourceDiagnosisMap.put("patientId", inhospitalDetailInfo.getPatientId());
					patientInfoDao.updatePatientById(sourceDiagnosisMap);
					
					//更新诊断表原发标示
					TDiagnosisInfo diagnosisInfo = new TDiagnosisInfo();
					diagnosisInfo.setDiagnosisId(diagnosis.getDiagnosisId());
					diagnosisInfo.setIsSourceDiagnosis(1);
					diagnosisInfoDao.updateDiagnosisInfo(diagnosisInfo);
				}*/
			}
		}else if(clinicMedicalId !=null) {
			//删除该门诊记录下的诊断信息
			Map<String,Object> delDiagnosisMap = new HashMap<String,Object>();
			delDiagnosisMap.put("clinicMedicalId", clinicMedicalId);
			diagnosisInfoDao.deleteDiagnosisInfo(delDiagnosisMap);
			for(TDiagnosisInfo diagnosis : diagnosises) {
				String diagnosisId = diagnosis.getDiagnosisId();
				if (StringUtils.isEmpty(diagnosisId)) {
					diagnosis.setDiagnosisId(GeneralUtil.generateUniqueID(Common.DIAGNOSIS_ID_PRE));
					emptyDiagnosisIdList.add(diagnosis.getDiagnosisId());
				}
				diagnosis.setCreateTime(new Date());
				diagnosis.setUpdateTime(new Date());
				resCode += diagnosisInfoDao.createDiagnosisInfo(diagnosis);
			}
		}
		if(resCode > 0) {
			resultMap.put("resCode", resCode);
		}
		resultMap.put("emptyDiagnosisIdList", emptyDiagnosisIdList);
		return resultMap;
	}
	
	@Override
	public Map<String, Object> saveDiagnosisInfo(List<TDiagnosisInfo> diagnosises) {
		Map<String, Object> resultMap = saveTranDiagnosisInfo(diagnosises);
		return resultMap;
	}
	
	private Map<String,Object> saveInternalDiagnosis(List<TDiagnosisInfo> diagnosises) {
		int resCode = 0;
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("resCode", 0);
		List<String> emptyDiagnosisIdList = new ArrayList<String>();
		if(diagnosises.get(0).getPatientId() != null) {
			//删除诊断信息
			Map<String,Object> paramsMap = new HashMap<String,Object>();
			paramsMap.put("patientId", diagnosises.get(0).getPatientId());
			paramsMap.put("specialDiseaseRegisterId", diagnosises.get(0).getSpecialDiseaseRegisterId());
			diagnosisInfoDao.deleteDiagnosisInfo(paramsMap);
			// 创建诊断信息
			for(TDiagnosisInfo diagnosis : diagnosises) {
				String diagnosisId = diagnosis.getDiagnosisId();
				if (StringUtils.isEmpty(diagnosisId)) {
					diagnosis.setDiagnosisId(GeneralUtil.generateUniqueID(Common.DIAGNOSIS_ID_PRE));
					emptyDiagnosisIdList.add(diagnosis.getDiagnosisId());
				}
				diagnosis.setPatientId(diagnosis.getPatientId());
				diagnosis.setPatientNo(diagnosis.getPatientNo());
				diagnosis.setVisitTime(new Date());
				diagnosis.setCreateTime(new Date());
				diagnosis.setUpdateTime(new Date());
				//保存患者诊断信息
				resCode += diagnosisInfoDao.createDiagnosisInfo(diagnosis);
			}
		}
		
		if(resCode > 0) {
			resultMap.put("resCode", resCode);
		}
		resultMap.put("emptyDiagnosisIdList", emptyDiagnosisIdList);
		return resultMap;
	}
	
	@Override
	public List<TDiagnosisInfo> queryPatientDiagnosisInfo(
			PatientDiagnosisInfoReq req) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("patientId", req.getPatientId());
		param.put("patientType", req.getPatientType());
		param.put("specialDiseaseRegisterId", req.getSpecialDiseaseRegisterId());
		return diagnosisInfoDao.queryDiagnosisInfoBySelective(param);
	}

	@Override
	protected List<TDiagnosisInfo> queryImpl(CommonReq req) {
		if(req.getPatientType() != null && req.getPatientType() == 2) {
			PatientDiagnosisInfoReq pd = new PatientDiagnosisInfoReq();
			pd.setPatientId(req.getPatientId());
			pd.setPatientType(req.getPatientType());
			pd.setSpecialDiseaseRegisterId(req.getSpecialDiseaseRegisterId());
			return queryPatientDiagnosisInfo(pd);
		}else {
			if(req.getInhospitalId() == null && req.getClinicMedicalId() == null) {
				LogUtil.logError.debug("查询患者诊断信息，住院id为空、住院门诊为空");
				return null;
			}
			return queryDiagnosisInfoByInhospitalId(req);
		}
	}

	@Override
	protected Map<String, Object> saveImpl(CommonReq req, List<TDiagnosisInfo> t) {
		if(req.getPatientType() != null && req.getPatientType() == 2) {
			return saveInternalDiagnosis(t);
		}else {
			String inhospitalId = t.get(0).getInhospitalId();
			String clinicMedicalId = t.get(0).getInhospitalId();
			Long patientId = t.get(0).getPatientId();
			if(inhospitalId == null && clinicMedicalId == null) {
				LogUtil.logError.debug("保存患者诊断信息，住院id为空");
				return null;
			}
			if(patientId == null) {
				LogUtil.logError.debug("保存患者诊断信息，患者id为空");
				return null;
			}
			return saveDiagnosisInfo(t);
		}
	}
}
