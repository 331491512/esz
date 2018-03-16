package com.esuizhen.cloudservice.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.esuizhen.cloudservice.user.bean.TWeixinPatientProfile;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncDiseaseInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncPatientInfo;
import com.esuizhen.cloudservice.user.bean.TWeixinSyncRelationInfo;
import com.esuizhen.cloudservice.user.dao.DoctorDao;
import com.esuizhen.cloudservice.user.dao.DoctorPatientDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientDao;
import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.QRcodeDao;
import com.esuizhen.cloudservice.user.dao.ThirdPartyDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.dao.WXHospitalDoctorDao;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.RWXHospitalDoctor;
import com.esuizhen.cloudservice.user.service.WeixinSyncService;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.ThirdParty;
import com.westangel.common.bean.User;
import com.westangel.common.bean.ehr.TSyncDiagnosisInfo;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.bean.user.QRCode;
import com.westangel.common.constant.Constant;
import com.westangel.common.service.EmrInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.Codec;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.PushUtil;
@Service
public class WeixinSyncServiceImpl implements WeixinSyncService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private DoctorPatientDao doctorPatientDao;
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	@Autowired
	private ThirdPartyDao thirdPartyDao;
	@Autowired
	private QRcodeDao qrcodeDao;
	@Autowired
	private WXHospitalDoctorDao wxHospitalDoctorDao;
	@Autowired
	private OperationHistoryDao operationHistoryDao;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private EmrInnerService emrInnerService;
	
	/**
	 * 
	* @Title: syncPatient 
	* @Description: 同步患者信息 
	* @param @param patientInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void syncPatient(TWeixinSyncPatientInfo patientInfo) 
	{
		TUserPatient userPatient = createOrUpdatePatient(
				patientInfo.getBussinessId(), 
				patientInfo.getProductId(), 
				patientInfo.getOpenId(), 
				patientInfo.getHospitalId(),
				patientInfo.getProfile());
		//医院/患者关系

		createOrUpdateRelationOfHospitalAndPatient(
				patientInfo.getHospitalId(), 
				userPatient.patient.getPatientId(),
				this.hospitalPatientDao.findPatientNo(userPatient.patient.getPatientId(), patientInfo.getHospitalId()));
		//创建默认医患关系
		createRelationOfHospitalAndKemi(
				patientInfo.getHospitalId(), 
				userPatient.patient.getPatientId(), 
				userPatient.user.getUserId(), 
				userPatient.user.getTrueName());
	}

	/**
	 * 
	* @Title: syncDisease 
	* @Description: 同步疾病信息 
	* @param @param diseaseInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void syncDisease(TWeixinSyncDiseaseInfo diseaseInfo) 
	{
		ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(diseaseInfo.getOpenId());
		if (null != thirdParty) {
			User user = userDao.findByUserId(thirdParty.getUserId());
			if (null != user) {
				List<String> diagnosisList = new ArrayList<String>();
				
				Patient patient = patientDao.findByUserId(thirdParty.getUserId());
				if (null != patient) {
					//更新patient诊断信息
					if (diseaseInfo.getProfile().size() > 0) {
						String diagnosis = diseaseInfo.getProfile().get(0).getDiagnosis(); 
						if (!StringUtils.isEmpty(diagnosis)) {
							diagnosisList.add(diagnosis);
							patient.setSourceDiagnosis(diagnosis);
							patient.setSourceDiseaseCode("1");
//							if (null == patient.getConfirmedDate()) {
//								patient.setConfirmedDate(new Date());	
//							}
							List<Integer> typeList = emrInnerService.getDiseaseTypeIdViaDiagnosis(diagnosis);
							if (null != typeList && typeList.size() > 0) {
								patient.setSourceDiseaseTypeId(typeList.get(0));	
							} else {
								patient.setSourceDiseaseTypeId(0);
							}
						}
					}
					if (diseaseInfo.getProfile().size() > 1) {
						String diagnosis = diseaseInfo.getProfile().get(1).getDiagnosis(); 
						if (!StringUtils.isEmpty(diagnosis)) {
							diagnosisList.add(diagnosis);
							patient.setSourceDiagnosis2(diagnosis);
							patient.setSourceDiseaseCode2("0");
//							if (null == patient.getConfirmedDate2()) {
//								patient.setConfirmedDate2(new Date());	
//							}							
							List<Integer> typeList = emrInnerService.getDiseaseTypeIdViaDiagnosis(diagnosis);
							if (null != typeList && typeList.size() > 0) {
								patient.setSourceDiseaseTypeId2(typeList.get(0));
							} else {
								patient.setSourceDiseaseTypeId2(0);
							}
						}
					}
					if (diseaseInfo.getProfile().size() > 2) {
						String diagnosis = diseaseInfo.getProfile().get(2).getDiagnosis(); 
						if (!StringUtils.isEmpty(diagnosis)) {
							diagnosisList.add(diagnosis);
							patient.setSourceDiagnosis3(diagnosis);
							patient.setSourceDiseaseCode3("0");
//							if (null == patient.getConfirmedDate3()) {
//								patient.setConfirmedDate3(new Date());	
//							}							
							
							List<Integer> typeList = emrInnerService.getDiseaseTypeIdViaDiagnosis(diagnosis);
							if (null != typeList && typeList.size() > 0) {
								patient.setSourceDiseaseTypeId3(typeList.get(0));
							} else {
								patient.setSourceDiseaseTypeId3(0);								
							}
						}
					}
					if (diagnosisList.size() > 0){
						patientDao.updateByPrimaryKey(patient);
						//添加或者更新emr表
						TSyncDiagnosisInfo disgnosis = new TSyncDiagnosisInfo();
						disgnosis.setPatientId(patient.getPatientId());
						disgnosis.setPatientNo(diseaseInfo.getPatientNo());
						disgnosis.setHospitalId(diseaseInfo.getHospitalId());
						disgnosis.setDiagnosis(diagnosisList);
						emrInnerService.syncDiagnosis(disgnosis);						
					}
					//医院/患者关系
					createOrUpdateRelationOfHospitalAndPatient(
							diseaseInfo.getHospitalId(), 
							patient.getPatientId(), 
							diseaseInfo.getPatientNo());
					
					//创建默认医患关系		
					createRelationOfHospitalAndKemi(
							diseaseInfo.getHospitalId(), 
							patient.getPatientId(), patient.getUserId(), 
							patient.getTrueName());
				}
			}
		}
	}

	/**
	 * 
	* @Title: syncRelation 
	* @Description: 同步关系 
	* @param @param relationInfo    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	@Override
	public void syncRelation(TWeixinSyncRelationInfo relationInfo) 
	{
		//同步患者信息
		TUserPatient userPatient = createOrUpdatePatient(
				relationInfo.getBussinessId(), 
				relationInfo.getProductId(),
				relationInfo.getPatientOpenId(), 
				relationInfo.getHospitalId(),
				relationInfo.getPatientProfile());
		
		//医院/患者关系
		createOrUpdateRelationOfHospitalAndPatient(
				relationInfo.getHospitalId(), 
				userPatient.patient.getPatientId(),
				relationInfo.getPatientNo());
		
		//同步疾病信息
		if (null != relationInfo.getDiseaseProfile()) {
			TWeixinSyncDiseaseInfo diseaseInfo = new TWeixinSyncDiseaseInfo();
			diseaseInfo.setBussinessId(relationInfo.getBussinessId());
			diseaseInfo.setProductId(relationInfo.getProductId());
			diseaseInfo.setOpenId(relationInfo.getPatientOpenId());
			diseaseInfo.setPatientNo(relationInfo.getPatientNo());
			diseaseInfo.setHospitalId(relationInfo.getHospitalId());
			diseaseInfo.setProfile(relationInfo.getDiseaseProfile());
			syncDisease(diseaseInfo);
		}
		
		QRCode code = qrcodeDao.findByTicket(relationInfo.getDoctorTicket());
		Long patientId = userPatient.patient.getPatientId();
		Long doctorId = doctorDao.findDoctorIdByUserId(code.getUserId());
		//创建医患关系
		createRelationOfHospitalAndDoctor(
				relationInfo.getHospitalId(), 
				patientId, userPatient.user.getUserId(), userPatient.user.getTrueName(), 
				doctorId, code.getUserId());
		//创建默认医患关系		
		createRelationOfHospitalAndKemi(
				relationInfo.getHospitalId(), 
				patientId, userPatient.user.getUserId(), 
				userPatient.user.getTrueName());

	}
	
	private void createRelationOfHospitalAndKemi(Integer hospitalId, Long patientId, Long patientUserId, String patientName)
	{
		//创建默认医患关系
		List<RWXHospitalDoctor> wxhd = wxHospitalDoctorDao.selectDoctorOfHospital(hospitalId); 
		if (null != wxhd) {
			for (RWXHospitalDoctor doctor:wxhd){
				createRelationOfHospitalAndDoctor(hospitalId,
						patientId, patientUserId, patientName,
						doctor.getDoctorId(), doctor.getDoctorUserId());
			}
		}		
	}
	
	/**
	 * 
	* @Title: createRelationOfHospitalAndDoctor 
	* @Description: 创建医患关系 
	* @param @param hospitalId
	* @param @param patientId
	* @param @param patientUserId
	* @param @param patientName
	* @param @param doctorId
	* @param @param doctorUserId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void createRelationOfHospitalAndDoctor(
			Integer hospitalId,
			Long patientId, Long patientUserId, String patientName,
			Long doctorId, Long doctorUserId)
	{
		if (null == doctorPatientDao.searchDoctorPatient(patientId, doctorId)){
			//创建医患关系
			DoctorPatient doctorPatient = new DoctorPatient();
			doctorPatient.setDoctorId(doctorId);
			doctorPatient.setPatientId(patientId);
			doctorPatient.setAttentionTime(new Date());
			doctorPatient.setCreateTime(new Date());
			doctorPatient.setHasMedicalRecord(0);
			doctorPatient.setSourceFlag(1);
			doctorPatientDao.insert(doctorPatient);
			
			if (StringUtils.isEmpty(patientName)){
				patientName="";
			}
			//记录日志
			OperationHistory operationHistory = new OperationHistory();
			operationHistory.setOperatorId(patientId);
			operationHistory.setDescription("患者扫码关注，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			operationHistory.setOperationName("创建医患关系");
			operationHistory.setActionType(1);
			operationHistory.setCreateTime(new Date());
			operationHistoryDao.insert(operationHistory);		
			
			String content = messageSource.getMessage("push.newpatient.todoctor", new Object[]{patientName}, Locale.getDefault());
			PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForNewPatient(patientUserId, doctorUserId, content);
			pushInnerService.push(notifyInfo);
		}
	}
	
	/**
	 * 
	* @Title: createOrUpdateRelationOfHospitalAndPatient 
	* @Description: 建立医院和患者的关系 
	* @param     设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void createOrUpdateRelationOfHospitalAndPatient(Integer hospitalId, Long patientId, String patientNo)
	{
		//建立医院/患者关系
		HospitalPatientBriefInfo briefInfo = new HospitalPatientBriefInfo();
		briefInfo.setSourceFlag(2);
		briefInfo.setSyncFlag(0);
		briefInfo.setHospitalId(hospitalId);
		briefInfo.setPatientId(patientId);
		briefInfo.setPatientNo(StringUtils.isEmpty(patientNo)?null:patientNo);
		if (0 == hospitalPatientDao.hasRelationOfHospitalPatient(briefInfo)) {
			hospitalPatientDao.insertRelationOfHospitalPatient(briefInfo);
		}
	}
	/**
	 * 
	* @Title: createOrUpdatePatient 
	* @Description: 创建或者更新用户 
	* @param @param businessId
	* @param @param productId
	* @param @param openId
	* @param @param profile
	* @param @return    设定文件 
	* @return TUserPatient    返回类型 
	* @throws
	 */
	private TUserPatient createOrUpdatePatient(
			Integer businessId,
			Integer productId, 
			String openId,
			Integer hospitalId,
			TWeixinPatientProfile profile)
	{
		TUserPatient userPatient = new TUserPatient();
		ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(openId);
		String userName = profile.getName();
		String mobile = profile.getMobile();
		
		if (StringUtils.isEmpty(userName)) {
			userName = openId;
		}
		
		if (StringUtils.isEmpty(mobile)){
			mobile = null;
		}
		
		User user = null;
		Patient patient = null;
		//创建用户
		if (null == thirdParty) {
			if (!StringUtils.isEmpty(profile.getMobile())) {
				user = userDao.findByUserName(profile.getMobile(), Constant.User.ROLE_PATIENT);
			} 
		} else {
			user = userDao.findByUserId(thirdParty.getUserId());
		}	
		if (null == user){ 
			user = new User();
			user.setUserName(!StringUtils.isEmpty(mobile)?mobile:userName);
			user.setTrueName(userName);
			user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
			user.setRole(Constant.User.ROLE_PATIENT);
			user.setAccountType(!StringUtils.isEmpty(mobile)?Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE:Constant.User.ACCOUNTTYPE_WEIXIN);
			user.setMobile(mobile);
			user.setUserPictureUrl(profile.getHeadUrl());
			user.setInfoState(profile.getInfoState());
			user.setIdType(profile.getIdType());
			user.setIdentification(profile.getIdentification());
			user.setState(Constant.User.USERSTATE_NORMAL);
			user.setPoints(0);
			user.setCreateTime(new Date());
			user.setUpdateTime(user.getCreateTime());
			user.setSourceFlag(1);
			user.setSyncFlag(0);
			userDao.insert(user);
			
			patient = new Patient();
			patient.setTrueName(userName);
			patient.setMobile(mobile);
			patient.setMedicalPayType(0);
			patient.setLiveStatus(1);
			patient.setPatientRelation(0);
			patient.setHasVisibleMedicalRecord(0);
			patient.setSex(profile.getSex());
			patient.setAuditState(profile.getAuditState());
			patient.setCreateTime(new Date());
			patient.setUpdateTime(patient.getCreateTime());
			
			patient.setUserId(user.getUserId());
			patientDao.insert(patient);
		} else {
			user.setUserPictureUrl(profile.getHeadUrl());
			user.setUserName(!StringUtils.isEmpty(mobile)?mobile:userName);
			user.setTrueName(userName);
			user.setAccountType(!StringUtils.isEmpty(mobile)?Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE:Constant.User.ACCOUNTTYPE_WEIXIN);
			user.setMobile(mobile);
			user.setIdType(profile.getIdType());
			user.setIdentification(profile.getIdentification());
			user.setInfoState(profile.getInfoState());
			user.setUpdateTime(new Date());
			userDao.updateByPrimaryKey(user);
			
			patient = patientDao.findByUserId(user.getUserId());
			patient.setMobile(mobile);
			patient.setTrueName(userName);
			patient.setSex(profile.getSex());
			patient.setAuditState(profile.getAuditState());
			patient.setUpdateTime(new Date());
			patientDao.updateByPrimaryKey(patient);				
		}
		
		//创建第三方登录信息
		if (null == thirdParty){
			thirdParty = new ThirdParty();
			thirdParty.setThirdPartyType(2);
			thirdParty.setOpenId(openId);
			thirdParty.setBusinessId(businessId);
			thirdParty.setProductId(productId);
			thirdParty.setUserId(user.getUserId());
			thirdParty.setCreateTime(new Date());
			thirdPartyDao.insert(thirdParty);			
		}

		userPatient.user = user;
		userPatient.patient = patient;
		return userPatient;
	}
	
	class TUserPatient{
		User user;
		Patient patient;
	}

}
