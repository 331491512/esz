package com.esuizhen.cloudservice.ehr.service.inhospital.impl;

import java.util.ArrayList;
import java.util.Date;
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

import com.alibaba.fastjson.JSON;
import com.esuizhen.cloudservice.ehr.dao.common.OperationHistoryDao;
import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.HospitalPatientDao;
import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaDataUserDefinedDao;
import com.esuizhen.cloudservice.ehr.dao.meta.MetaInfoCountyDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TUserInfoDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.InhospitalPigeonholeReq;
import com.esuizhen.cloudservice.ehr.model.inhospital.PatientClinicInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalInfo;
import com.esuizhen.cloudservice.ehr.model.meta.TMetaInfoCounty;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientProfile;
import com.esuizhen.cloudservice.ehr.service.common.CommonService;
import com.esuizhen.cloudservice.ehr.service.inhospital.TInhospitalDetailInfoService;
import com.esuizhen.cloudservice.ehr.service.meta.MetaDataUserDefinedService;
import com.esuizhen.cloudservice.ehr.service.meta.userdefined.MetaDataService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.PatientFamilyService;
import com.esuizhen.cloudservice.ehr.service.patientinfo.TPatientInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.Page;
import com.westangel.common.util.BeanUtils;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
@Transactional
public class TInhospitalDetailInfoServiceImpl implements TInhospitalDetailInfoService {

	@Autowired
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;
	
	@Autowired
	private PatientFamilyService patientFamilyService;
 
	@Autowired
	private TUserInfoDao userInfoDao;

	@Autowired
	private MetaDataUserDefinedDao metaDataUserDefinedDao;

	@Autowired
	private MetaDataUserDefinedService metaDataUserDefinedService;

	@Autowired
	private TPatientInfoDao patientInfoDao;
	@Autowired
	private OperationHistoryDao operationHistoryDao;

	@Autowired
	private TPatientInfoService patientInfoService;

	@Autowired
	private CommonService<PatientClinicInfo> patientClinicInfoService;

	@Autowired
	private HospitalPatientDao hospitalPatientDao;

	@Autowired
	private MetaDataService metaDataService;

	@Autowired
	private MetaInfoCountyDao metaInfoCountyDao;

	@SuppressWarnings("unchecked")
	@Override
	public Page<TInhospitalInfo> queryInhospitalInfo(Long patientId, String outhospitalDateStart, String outhospitalDateEnd, Integer outhospitalDeptId, Integer page, Integer num) {
		if (page != null) {
			PageHelper.startPage(page + 1, num);
		}
		Map<String, Object> paraMap = new HashMap<String, Object>();
		paraMap.put("patientId", patientId);
		paraMap.put("outhospitalDateStart", outhospitalDateStart);
		paraMap.put("outhospitalDateEnd", outhospitalDateEnd);
		paraMap.put("outhospitalDeptId", outhospitalDeptId);
		List<TInhospitalInfo> list = inhospitalDetailInfoDao.queryInhospitalInfoByPatientId(paraMap);
		Page<TInhospitalInfo> pages = null;
		if (page != null) {
			pages = PageUtil.returnPage((com.github.pagehelper.Page<TInhospitalInfo>) list);
		} else {
			pages = new Page<TInhospitalInfo>();
			pages.setDataList(list);
		}
		return pages;
	}

	/**
	 * 添加住院病案首页省市县的显示 add by xueyongyan
	 * 20170518
	 */
	@Override
	public TInhospitalDetailInfo queryInhospitalDetail(String inhospitalId) {
		TInhospitalDetailInfo inhospitalInfo = inhospitalDetailInfoDao.queryInhospitalDetailByInhospitalId(inhospitalId);
		String birthCountyCode = inhospitalInfo.getBirthPlaceCountyCode();
		if (StringUtils.isNotEmpty(birthCountyCode)) {
			List<TMetaInfoCounty> countyList = metaInfoCountyDao.getMetaInfoCountyList(null, null, birthCountyCode);
			if (countyList.size() == 0) {
				List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, birthCountyCode, null);
				if (cityList.size() == 0) {
					List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(birthCountyCode, null, null);
					if (proList.size() > 0) {
						inhospitalInfo.setBirthPlaceProvinceCode(proList.get(0).getProvinceCode());
					}
				} else {
					inhospitalInfo.setBirthPlaceProvinceCode(cityList.get(0).getProvinceCode());
					inhospitalInfo.setBirthPlaceCityCode(birthCountyCode);
				}
			} else {
				inhospitalInfo.setBirthPlaceProvinceCode(countyList.get(0).getProvinceCode());
				inhospitalInfo.setBirthPlaceCityCode(countyList.get(0).getCityCode());
				inhospitalInfo.setBirthPlaceCountyCode(birthCountyCode);
			}
		}
		String liveCountyCode = inhospitalInfo.getLiveCountyCode();
		if (StringUtils.isNotEmpty(liveCountyCode)) {
			List<TMetaInfoCounty> countyList = metaInfoCountyDao.getMetaInfoCountyList(null, null, liveCountyCode);
			if (countyList.size() == 0) {
				List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, liveCountyCode, null);
				if (cityList.size() == 0) {
					List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(liveCountyCode, null, null);
					if (proList.size() > 0) {
						inhospitalInfo.setLiveProvinceCode(proList.get(0).getProvinceCode());
					}
				} else {
					inhospitalInfo.setLiveProvinceCode(cityList.get(0).getProvinceCode());
					inhospitalInfo.setLiveCityCode(liveCountyCode);
				}
			} else {
				inhospitalInfo.setLiveProvinceCode(countyList.get(0).getProvinceCode());
				inhospitalInfo.setLiveCityCode(countyList.get(0).getCityCode());
				inhospitalInfo.setLiveCountyCode(liveCountyCode);
			}
		}
		String companyCountyCode = inhospitalInfo.getCompanyCountyCode();
		if (StringUtils.isNotEmpty(companyCountyCode)) {
			List<TMetaInfoCounty> countyList = metaInfoCountyDao.getMetaInfoCountyList(null, null, companyCountyCode);
			if (countyList.size() == 0) {
				List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, companyCountyCode, null);
				if (cityList.size() == 0) {
					List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(companyCountyCode, null, null);
					if (proList.size() > 0) {
						inhospitalInfo.setCompanyProvinceCode(proList.get(0).getProvinceCode());
					}
				} else {
					inhospitalInfo.setCompanyProvinceCode(cityList.get(0).getProvinceCode());
					inhospitalInfo.setCompanyCityCode(companyCountyCode);
				}
			} else {
				inhospitalInfo.setCompanyProvinceCode(countyList.get(0).getProvinceCode());
				inhospitalInfo.setCompanyCityCode(countyList.get(0).getCityCode());
				inhospitalInfo.setCompanyCountyCode(companyCountyCode);
			}
		}
		String householdCountyCode = inhospitalInfo.getHouseholdCountyCode();
		if (StringUtils.isNotEmpty(householdCountyCode)) {
			List<TMetaInfoCounty> countyList = metaInfoCountyDao.getMetaInfoCountyList(null, null, householdCountyCode);
			if (countyList.size() == 0) {
				List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, householdCountyCode, null);
				if (cityList.size() == 0) {
					List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(householdCountyCode, null, null);
					if (proList.size() > 0) {
						inhospitalInfo.setHouseholdProvinceCode(proList.get(0).getProvinceCode());
					}
				} else {
					inhospitalInfo.setHouseholdProvinceCode(cityList.get(0).getProvinceCode());
					inhospitalInfo.setHouseholdCityCode(householdCountyCode);
				}
			} else {
				inhospitalInfo.setHouseholdProvinceCode(countyList.get(0).getProvinceCode());
				inhospitalInfo.setHouseholdCityCode(countyList.get(0).getCityCode());
				inhospitalInfo.setHouseholdCountyCode(householdCountyCode);
			}
		}
		String nativePlaceCityCode = inhospitalInfo.getNativePlaceCityCode();
		if (StringUtils.isNotEmpty(nativePlaceCityCode)) {
			List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, nativePlaceCityCode, null);
			if (cityList.size() == 0) {
				List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(nativePlaceCityCode, null, null);
				if (proList.size() > 0) {
					inhospitalInfo.setNativePlaceProvinceCode(proList.get(0).getProvinceCode());
				}
			} else {
				inhospitalInfo.setNativePlaceProvinceCode(cityList.get(0).getProvinceCode());
				inhospitalInfo.setNativePlaceCityCode(nativePlaceCityCode);
			}
		}
		String familyCountyCode = inhospitalInfo.getFamilyCountyCode();
		if (StringUtils.isNotEmpty(familyCountyCode)) {
			List<TMetaInfoCounty> countyList = metaInfoCountyDao.getMetaInfoCountyList(null, null, familyCountyCode);
			if (countyList.size() == 0) {
				List<TMetaInfoCounty> cityList = metaInfoCountyDao.getMetaInfoCountyList(null, familyCountyCode, null);
				if (cityList.size() == 0) {
					List<TMetaInfoCounty> proList = metaInfoCountyDao.getMetaInfoCountyList(familyCountyCode, null, null);
					if (proList.size() > 0) {
						inhospitalInfo.setFamilyProvinceCode(proList.get(0).getProvinceCode());
					}
				} else {
					inhospitalInfo.setFamilyProvinceCode(cityList.get(0).getProvinceCode());
					inhospitalInfo.setFamilyCityCode(familyCountyCode);
				}
			} else {
				inhospitalInfo.setFamilyProvinceCode(countyList.get(0).getProvinceCode());
				inhospitalInfo.setFamilyCityCode(countyList.get(0).getCityCode());
				inhospitalInfo.setFamilyCountyCode(familyCountyCode);
			}
		}
		return inhospitalInfo;
	}

	@Override
	public void deleteInhospitalDetail(String inhospitalId) {
		inhospitalDetailInfoDao.deleteInhospitalDetail(inhospitalId);
	}

	/**
	 * 保存诊断信息的医患关系
	 * 
	 * add by xueyongyan 20170512
	 * 
	 * @param inhospitalDetailInfo
	 */
	public void updateRDoctorPatient(TInhospitalDetailInfo inhospitalDetailInfo) {
		LogUtil.log.info("= = 更新医患关系开始= =");
		List<DoctorPatient> dpList = patientInfoDao.searchDoctorPatient(inhospitalDetailInfo.getPatientId(), null);
		List<DoctorPatient> doctorPatientList = new ArrayList<DoctorPatient>();
		if (inhospitalDetailInfo.getDeptDoctor() != null) {
			if (dpList != null && dpList.size() > 0) { // 排除已经存在的医患关系
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getDeptDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getDeptDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else { // 没有医患关系存在时
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getDeptDoctor());
				doctorPatientList.add(dp);
			}
		}

		if (inhospitalDetailInfo.getDirectorDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getDirectorDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getDirectorDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getDirectorDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getInchargeDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getInchargeDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getInchargeDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getInchargeDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getInhospitalDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getInhospitalDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getInhospitalDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getInhospitalDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getAttendingDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getAttendingDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getAttendingDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getAttendingDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getPostgraduateDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getPostgraduateDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getPostgraduateDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getPostgraduateDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getInternshipDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getInternshipDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getInternshipDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getInternshipDoctor());
				doctorPatientList.add(dp);
			}
		}
		if (inhospitalDetailInfo.getQualityControlDoctor() != null) {
			if (dpList != null && dpList.size() > 0) {
				for (int i = 0; i < dpList.size(); i++) {
					Long doctorId = dpList.get(i).getDoctorId();
					if (doctorId.equals(inhospitalDetailInfo.getQualityControlDoctor())) {
						break;
					} else {
						if (i == dpList.size() - 1) {
							DoctorPatient dp = new DoctorPatient();
							dp.setDoctorId(inhospitalDetailInfo.getQualityControlDoctor());
							doctorPatientList.add(dp);
						}
					}
				}
			} else {
				DoctorPatient dp = new DoctorPatient();
				dp.setDoctorId(inhospitalDetailInfo.getQualityControlDoctor());
				doctorPatientList.add(dp);
			}
		}

		List<DoctorPatient> doctorPatientList2 = new ArrayList<DoctorPatient>();
		Set<Long> idSet = new HashSet<Long>(); // 去除重复的
		for (int i = 0; i < doctorPatientList.size(); i++) {
			idSet.add(doctorPatientList.get(i).getDoctorId());
		}
		Iterator<Long> it = idSet.iterator();
		while (it.hasNext()) {
			DoctorPatient dp = new DoctorPatient();
			dp.setDoctorId(it.next());
			dp.setPatientId(inhospitalDetailInfo.getPatientId());
			dp.setSourceFlag(3);
			doctorPatientList2.add(dp);
		}

		// for (int i = 0; i <
		// doctorPatientList.size();
		// i++) {更好
		// doctorPatientList.get(i).setPatientId(inhospitalDetailInfo.getPatientId());
		// doctorPatientList.get(i).setSourceFlag(0);
		// }
		LogUtil.log.info("== doctorPatientList=" + JSON.toJSONString(doctorPatientList2));
		if (doctorPatientList2.size() > 0) {
			Map<String, Object> doctorPatientMap = new HashMap<String, Object>();
			doctorPatientMap.put("doctorPatientList", doctorPatientList2);
			patientInfoDao.batchInsertDoctorPatient(doctorPatientMap);
		}
		LogUtil.log.info("= = 更新医患关系结束= =");
	}

	@Override
	public void updateInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo) {
		long start = System.currentTimeMillis();
		if (inhospitalDetailInfo.getPatientId() != null) {
			updateRDoctorPatient(inhospitalDetailInfo); // 更新医患关系
		}
		long end = System.currentTimeMillis();
		long time = end - start;
		LogUtil.log.info("== updateRDoctorPatient == 更新医患关系耗时 == " + time);
		updateInhospitalDetailTran(inhospitalDetailInfo);
	}

	@Transactional
	private void updateInhospitalDetailTran(TInhospitalDetailInfo inhospitalDetailInfo) {
		// 更新诊断类型元数据信息
		/*UserDefinedMetaData metaData = new UserDefinedMetaData();
		boolean updateMataFlag = true;
		metaData.setMetaDataTable("ehr_db.meta_e_icd_10");
		metaData.setMainKeyField("diseaseName");
		metaData.setQueryCondition("diseaseCode='" + inhospitalDetailInfo.getDiseaseCode() + "'");
		List<String> diseaseNameList = metaDataUserDefinedDao.getMetaDataListByNameToStr(metaData);
		if (diseaseNameList != null && diseaseNameList.size() > 0) {
			for (String diseaseName : diseaseNameList) {
				if (StringUtils.isBlank(diseaseName))
					continue;
				// code和元数据表相同，name不同，不修改元数据表
				if (!diseaseName.equals(inhospitalDetailInfo.getDiagnose()))
					updateMataFlag = false;
			}
		}
		if (updateMataFlag && StringUtils.isNotBlank(inhospitalDetailInfo.getDiseaseCode())) {
			metaData = new UserDefinedMetaData();
			metaData.setCreator(inhospitalDetailInfo.getOperatorId());
			metaData.setMainKey(inhospitalDetailInfo.getDiseaseCode());
			metaData.setMetaName(inhospitalDetailInfo.getDiagnose());

			metaData.setMetaDataTable("ehr_db.meta_e_icd_10");
			metaData.setMainKeyField("diseaseCode");
			metaData.setMetaNameField("diseaseName");

			metaData.setQueryCondition("diseaseCode='" + inhospitalDetailInfo.getDiseaseCode() + "'");
			this.metaDataUserDefinedService.addMetaDateInStrKey(metaData);
		}*/
		// 更新业务数据
		Map<String, Object> paramsMap = BeanUtils.toMap(inhospitalDetailInfo);
		TInhospitalDetailInfo inhospitalDetail = inhospitalDetailInfoDao.queryInhospitalDetailByInhospitalId(inhospitalDetailInfo.getInhospitalId());
		if (inhospitalDetail != null) {
			paramsMap.put("oldFamilyTel", inhospitalDetail.getFamilyTel());
			paramsMap.put("oldFamilyName", inhospitalDetail.getFamilyName());
		}
		StringBuffer tumourPeriodization = new StringBuffer();
		tumourPeriodization.append(inhospitalDetailInfo.getTumourPeriodizationT() == null ? "" : inhospitalDetailInfo.getTumourPeriodizationT());
		tumourPeriodization.append(inhospitalDetailInfo.getTumourPeriodizationN() == null ? "" : inhospitalDetailInfo.getTumourPeriodizationN());
		tumourPeriodization.append(inhospitalDetailInfo.getTumourPeriodizationM1() == null ? "" : inhospitalDetailInfo.getTumourPeriodizationM1());
		tumourPeriodization.append(" ");
		tumourPeriodization.append(inhospitalDetailInfo.getTumourPeriodizationClinic() == null ? "" : inhospitalDetailInfo.getTumourPeriodizationClinic());
		inhospitalDetailInfo.setTumourPeriodization(tumourPeriodization.toString());
		TPatientProfile patient = patientInfoDao.queryPatientById(inhospitalDetailInfo.getPatientId());
		Date oldDate = patient.getBirthDate();
		Date newDate = inhospitalDetailInfo.getBirthDate();
		if (oldDate != null && newDate != null && oldDate.getTime() != newDate.getTime()) {
			inhospitalDetailInfoDao.updateInhospitalAge(inhospitalDetailInfo.getPatientId(), inhospitalDetailInfo.getBirthDate());
		}
		Date inhospitalDate = inhospitalDetailInfo.getInhospitalDate();
		Date birthDate = inhospitalDetailInfo.getBirthDate();
		long age = 0l;
		if (inhospitalDetailInfo.getAge() != null) {
			age = inhospitalDetailInfo.getAge();
		}
		if (inhospitalDate != null && birthDate != null) {
			age = (inhospitalDate.getTime() - birthDate.getTime()) / (24 * 60 * 60 * 1000) / 365;
		}
		if (age < 0) {
			age = 0;
		}
		inhospitalDetailInfo.setAge(Integer.parseInt(age + ""));
		// Integer inhospitalTimes =
		// inhospitalDetailInfo.getInhospitalTimes();
		// Integer binhospitalTimes =
		// inhospitalDetailInfoDao.queryInhospitalTime(inhospitalDetail.getPatientId(),
		// inhospitalDetail.getInhospitalDate());
		// if (binhospitalTimes == null)
		// {
		// binhospitalTimes = 0;
		// }
		// inhospitalTimes =
		// binhospitalTimes + 1;
		//
		// inhospitalDetailInfo.setInhospitalTimes(inhospitalTimes);
		inhospitalDetailInfoDao.updateInhospitalDetail(inhospitalDetailInfo);
		inhospitalDetailInfoDao.updateInhospitalTimes(inhospitalDetailInfo.getPatientId());
		// add by fanpanwei 添加联系人信息
		patientFamilyService.addOrModifyPatientFamily(paramsMap);
		LogUtil.log.info("更新患者住院信息结束");
		LogUtil.log.info("开始更新用户&患者信息");
		paramsMap.put("catalogState", 2);
		patientInfoService.update(paramsMap);
		LogUtil.log.info("更新用户&患者信息结束");
	}

	@Transactional
	@Override
	public void updateInhospitalFiling(PatientInfoReq req) {
		TPatientProfile patient = patientInfoDao.queryPatientById(req.getPatientId());
		if (patient != null) {
			if (req != null && req.getPigeonholeReq() != null && req.getPigeonholeReq().size() > 0) {
				TPatientInfo p = new TPatientInfo();
				for (InhospitalPigeonholeReq pigeonholeReq : req.getPigeonholeReq()) {
					if (pigeonholeReq.getClinicMedicalId() != null) {
						PatientClinicInfo clinicInfo = new PatientClinicInfo();
						if (pigeonholeReq.getFlag() != null && pigeonholeReq.getFlag() == 1) {
							clinicInfo.setCatalogState(3);
						} else {
							clinicInfo.setCatalogState(2);
						}
						clinicInfo.setClinicMedicalId(pigeonholeReq.getClinicMedicalId());
						patientClinicInfoService.updateByPrimaryKeySelective(clinicInfo);
					} else {
						inhospitalDetailInfoDao.updateInhospitalFiling(pigeonholeReq.getInhospitalId(), pigeonholeReq.getFlag() == null ? 0 : pigeonholeReq.getFlag());
					}
				}
				int counter = 0;
				int tmpState = 0;
				Map<String, Object> paramsMap = new HashMap<String, Object>();
				paramsMap.put("patientId", req.getPatientId());
				List<Map<String, Object>> list = patientInfoDao.queryPatientVisitInfo(paramsMap);
				if (list != null && list.size() > 0) {
					for (Map<String, Object> resultMap : list) {
						Integer catalogState = (Integer) resultMap.get("catalogState");
						if (catalogState == 2) {// 编目状态。0-未编目，1-已编目，2-编目中，3-归档
							tmpState = catalogState;
							break;
						} else if (catalogState == 3) {
							counter++;
						}
					}
					if (counter == list.size()) {
						tmpState = 3;
					}
					p.setCatalogState(tmpState);
					p.setPatientId(req.getPatientId());
					patientInfoDao.updateByPrimaryKeySelective(p);
				}

			}
		}
	}

	@Transactional
	@Override
	public TInhospitalDetailInfo createInhospitalDetail(TInhospitalDetailInfo inhospitalDetailInfo) {
		TInhospitalDetailInfo inhospitalDetai = null;
		if ("-1".equals(inhospitalDetailInfo.getOccupationId())) {
			inhospitalDetailInfo.setOccupationId(null);
		}
		Map<String, Object> paramsMap = BeanUtils.toMap(inhospitalDetailInfo);
		if (inhospitalDetailInfo.getPatientId() == null) {
			patientInfoService.insert(paramsMap);
			inhospitalDetailInfo.setPatientId((Long) paramsMap.get("patientId"));
		}
		//add by fanpanwei  添加联系人信息
		patientFamilyService.addOrModifyPatientFamily(paramsMap);
		
		// 生成病案首页ID
		String inhospitalId = GeneralUtil.generateUniqueID("EINH");
		inhospitalDetailInfo.setInhospitalId(inhospitalId);
		inhospitalDetailInfoDao.createInhospitalDetail(inhospitalDetailInfo);
		patientInfoService.update(paramsMap);
		inhospitalDetai = inhospitalDetailInfo;
		return inhospitalDetai;
	}
	
}
