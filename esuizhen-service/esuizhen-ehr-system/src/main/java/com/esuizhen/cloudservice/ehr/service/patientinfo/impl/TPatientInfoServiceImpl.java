package com.esuizhen.cloudservice.ehr.service.patientinfo.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.ehr.bean.CommonReq;
import com.esuizhen.cloudservice.ehr.dao.hospitalinfo.HospitalPatientDao;
import com.esuizhen.cloudservice.ehr.dao.inhospital.TInhospitalDetailInfoDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TPatientInfoDao;
import com.esuizhen.cloudservice.ehr.dao.patientinfo.TUserInfoDao;
import com.esuizhen.cloudservice.ehr.model.inhospital.TInhospitalDetailInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.PatientInfoReq;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientInfo;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TPatientProfile;
import com.esuizhen.cloudservice.ehr.model.patientinfo.TUserInfo;
import com.esuizhen.cloudservice.ehr.service.patientinfo.TPatientInfoService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.util.BeanUtils;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PageUtil;
@Transactional
@Service
public class TPatientInfoServiceImpl implements TPatientInfoService
{
	
	@Autowired
	private TPatientInfoDao patientInfoDao;
	
	@Autowired
	private TInhospitalDetailInfoDao inhospitalDetailInfoDao;
	
	@Autowired
	private TUserInfoDao userInfoDao;
	
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	
	@Override
	public Page queryPatientProfile(String patientNo, String trueName, Integer page , Integer num)
	{
		PageHelper.startPage(page+1, num);
		List<TPatientProfile> list = patientInfoDao.queryPatientProfile(patientNo, trueName);
		return PageUtil.returnPage((com.github.pagehelper.Page<TPatientProfile>)list);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<Map<String,Object>> queryPatientVisitInfo(PatientInfoReq req) {
		PageHelper.startPage(req.getPage()+1, req.getNum());
		Map<String,Object> beanMap = BeanUtils.toMap(req);
		List<Map<String,Object>> list = patientInfoDao.queryPatientVisitInfo(beanMap);
		return PageUtil.returnPage((com.github.pagehelper.Page<Map<String,Object>>)list);
	}

	@Override
	public int insert(TPatientInfo patient) {
		patient.setPatientRelation(0);
		patient.setHasVisibleMedicalRecord(0);
		patient.setHandleFlag(0);
		return patientInfoDao.insert(patient);
	}

	@Override
	public int insertUserInfo(TUserInfo userInfo) {
		userInfo.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		userInfo.setAccountType(0);
		userInfo.setRole(1);
		userInfo.setInfoState(0);
		userInfo.setSyncFlag(0);
		userInfo.setState(1);
		userInfo.setPoints(0);
		userInfo.setTobFlag(1);
		userInfo.setIdType(1);
		return userInfoDao.insert(userInfo);
	}

	@Override
	public TInhospitalDetailInfo queryPatientVisitInfoLastest(CommonReq req) {
		Map<String,Object> paraMap  = BeanUtils.toMap(req);
		return patientInfoDao.queryPatientVisitInfoLastest(paraMap);
	}
	
	@Override
	public void insert(Map<String, Object> paramsMap) {
		TUserInfo userInfo = new TUserInfo();
		TPatientInfo patient = new TPatientInfo();
		userInfo.setSourceFlag(9);
		userInfo.setUserName(GeneralUtil.generatorUUID());
		userInfo.setTrueName((String) paramsMap.get("trueName"));
		String familyTel = (String) paramsMap.get("familyTel");
		if (StringUtils.isNotEmpty(familyTel) && familyTel.startsWith("1")) {
			//add by fanpanwei  user表mobile是唯一的，不能随便插入
			//userInfo.setMobile(familyTel);
			patient.setMobile(familyTel);
		}
//		userInfo.setMobile((String)paramsMap.get("mobile"));
		userInfo.setSex((Integer)paramsMap.get("sex"));
		userInfo.setBirthDate((Date)paramsMap.get("birthDate"));
		userInfo.setNationId((Integer)paramsMap.get("nationId"));
		userInfo.setNation((String)paramsMap.get("nation"));
		userInfo.setNationalityId((Integer)paramsMap.get("nationalityId"));
		userInfo.setCountry((String)paramsMap.get("nationalityName"));
		userInfo.setCityCode((String)paramsMap.get("liveCityCode"));
		userInfo.setAddress((String)paramsMap.get("liveAddress"));
		userInfo.setNativePlace((String)paramsMap.get("nativePlace"));
		userInfo.setProfession((String)paramsMap.get("occupationName"));
		userInfo.setOccupationId((Integer)paramsMap.get("occupationId"));
		userInfo.setCompany((String)paramsMap.get("companyAddress"));
		userInfo.setIdType((Integer)paramsMap.get("idType"));
		userInfo.setIdentification((String)paramsMap.get("identification"));
		userInfo.setMarriageStatus((Integer)paramsMap.get("marriageStatus"));
		userInfo.setBirthPlaceCode((String)paramsMap.get("birthPlaceCountyCode"));
		userInfo.setBirthPlaceAddress((String)paramsMap.get("birthPlaceAddress"));
		
		this.insertUserInfo(userInfo);
		patient.setUserId(userInfo.getUserId());
		patient.setPatientNo((String)paramsMap.get("patientNo"));
		patient.setTrueName((String)paramsMap.get("trueName"));
		patient.setSex((Integer)paramsMap.get("sex"));
		patient.setBirthDate((Date)paramsMap.get("birthDate"));
		patient.setPatientRelation((Integer)paramsMap.get("patientRelation"));
		patient.setFamilyName((String)paramsMap.get("familyName"));
		patient.setFamilyPhone((String)paramsMap.get("familyTel"));
//		patient.setMobile((String)paramsMap.get("mobile"));
		patient.setLiveStatus(1);
		patient.setMedicalPayType((Integer)paramsMap.get("medicalPayType"));
		if(paramsMap.get("inhospitalTimes") != null && (Integer)paramsMap.get("inhospitalTimes") == 1) {
			patient.setInchargeDoctor((Long)paramsMap.get("inchargeDoctor"));
		}
		patient.setOutPatientFlag((Integer)paramsMap.get("outPatientFlag"));
		this.insert(patient);
		paramsMap.put("patientId", patient.getPatientId());
		Number operatorId = (Number)paramsMap.get("operatorId");
		if(operatorId != null) {
			List<DoctorPatient> doctorPatientList = patientInfoDao.searchDoctorPatient(patient.getPatientId(), operatorId.longValue());
			if(doctorPatientList == null || doctorPatientList.size() == 0) {
				DoctorPatient doctorPatient = new DoctorPatient();
				doctorPatient.setDoctorId(operatorId.longValue());
				doctorPatient.setPatientId(patient.getPatientId());
				doctorPatient.setAttentionTime(new Date());
				doctorPatient.setCreateTime(new Date());
				doctorPatient.setHasMedicalRecord(1);
				doctorPatient.setSourceFlag(4);
				patientInfoDao.insertDoctorPatient(doctorPatient);
			}
		}
		if(paramsMap.get("hospitalId") != null) {
			HospitalPatientBriefInfo briefInfo = new HospitalPatientBriefInfo();
			briefInfo.setPatientId(patient.getPatientId());
			briefInfo.setHospitalId((Integer)paramsMap.get("hospitalId"));
			briefInfo.setPatientNo((String)paramsMap.get("patientNo"));
			if(hospitalPatientDao.hasRelationOfHospitalPatient(briefInfo) == 0) {
				briefInfo.setSourceFlag(9);
				hospitalPatientDao.insertRelationOfHospitalPatient(briefInfo);
			}
		}
	}

	public void updateUserPatient(TUserInfo userInfo,TPatientInfo patient){
		userInfoDao.updateByPrimaryKeySelective(userInfo);
		patientInfoDao.updatePatient(patient);
	}
	
	@Override
	public void update(Map<String, Object> paramsMap) {
		TPatientProfile patient = patientInfoDao.queryPatientById((Long)paramsMap.get("patientId"));
		TUserInfo user = new TUserInfo();
		user.setUserId(patient.getUserId());
		user.setTrueName((String)paramsMap.get("trueName"));
		user.setBirthDate((Date)paramsMap.get("birthDate"));
		user.setNativePlace((String)paramsMap.get("nativePlace"));
		user.setBirthPlaceCode((String)paramsMap.get("birthPlaceCountyCode"));
		user.setBirthPlaceAddress((String)paramsMap.get("birthPlaceAddress"));
		user.setNationId((Integer)paramsMap.get("nationId"));
		user.setNation((String)paramsMap.get("nation"));
		user.setIdType((Integer)paramsMap.get("idType"));
		user.setIdentification((String)paramsMap.get("identification"));
		user.setSex((Integer)paramsMap.get("sex"));
		user.setCompany((String)paramsMap.get("companyAddress"));
		userInfoDao.updateByPrimaryKey(user);
		patient.setTrueName((String)paramsMap.get("trueName"));
		String familyTel = (String) paramsMap.get("familyTel");
		if (StringUtils.isNotEmpty(familyTel) && familyTel.startsWith("1")) {
			//add by fanpanwei  user表mobile是唯一的，不能随便插入
			//userInfo.setMobile(familyTel);
			patient.setMobile(familyTel);
		}
		patient.setSex((Integer)paramsMap.get("sex"));
		patient.setBirthDate((Date)paramsMap.get("birthDate"));
		patient.setInchargeDoctor((Long)paramsMap.get("inchargeDoctor"));
		patient.setCatalogState((Integer)paramsMap.get("catalogState"));
		if(paramsMap.get("inhospitalTimes") != null && (Integer)paramsMap.get("inhospitalTimes") == 1) {
			patient.setInchargeDoctor((Long)paramsMap.get("inchargeDoctor"));
		}
		patientInfoDao.updatePatientInfo(patient);
		if(paramsMap.get("hospitalId") != null) {
			HospitalPatientBriefInfo briefInfo = new HospitalPatientBriefInfo();
			briefInfo.setPatientId(patient.getPatientId());
			briefInfo.setHospitalId((Integer)paramsMap.get("hospitalId"));
			briefInfo.setPatientNo((String)paramsMap.get("patientNo"));
			if(hospitalPatientDao.hasRelationOfHospitalPatient(briefInfo) == 0) {
				briefInfo.setSourceFlag(9);
				hospitalPatientDao.insertRelationOfHospitalPatient(briefInfo);
			}
		}
		HospitalProfile hospital = new HospitalProfile();
		hospital.setHospitalId((Integer)paramsMap.get("hospitalId"));
		hospital.setMetaDataType(1);
		hospital.setCreator((Long)paramsMap.get("operatorId"));
		HospitalProfile hospitalInfo = hospitalPatientDao.queryHospital(hospital);
		if(hospitalInfo != null) {
			if(hospitalInfo.getUseCount() == null) {
				hospitalInfo.setUseCount(0);
			}
			hospital.setUseCount(hospitalInfo.getUseCount()+1);
			hospitalPatientDao.updateHospital(hospital);
		}
	}
	
}
