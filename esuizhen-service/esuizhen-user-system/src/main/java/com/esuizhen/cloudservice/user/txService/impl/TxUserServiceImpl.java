package com.esuizhen.cloudservice.user.txService.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.dao.DoctorDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.PatientFamilyDao;
import com.esuizhen.cloudservice.user.dao.ThirdPartyDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.dao.VarPatientDoctorMedicalDao;
import com.esuizhen.cloudservice.user.service.DoctorPatientService;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.HospitalPatientService;
import com.esuizhen.cloudservice.user.service.PatientFamilyService;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.esuizhen.cloudservice.user.txService.TxUserService;
import com.esuizhen.common.util.match.MatchMergeUtil;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.ThirdParty;
import com.westangel.common.bean.User;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.BindingDataExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.LogUtil;

/**
 * <p>Title:TxUserServiceImpl</p>
 * <p>Description:为UserServiceImpl能够调用，这样才能开启事物</p>
 * @author YYCHEN
 * @date 2016年6月16日 下午4:25:19
 */
@Service
public class TxUserServiceImpl implements TxUserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private ThirdPartyDao thirdPartyDao;
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	@Autowired
	private VarPatientDoctorMedicalDao varPatientDoctorMedicalDao;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PatientFamilyService patientFamilyService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private HospitalPatientService hospitalPatientService;
	@Autowired
	private DoctorPatientService doctorPatientService;
	@Autowired
	private MatchMergeUtil matchMergeUtil;

	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${operating.strategy.user.create}")
	private String createUserToStrategy;
	
	@Override
	public TConfirmUserResp confirmInfo(TConfirmUserReq confirmUserReq) throws EmptyParamExcption {
		if (confirmUserReq.getIsConfirmed() == null) {
			throw new EmptyParamExcption("isConfirmed is empty!");
		}
		User user = userDao.findByUserId(confirmUserReq.getUserId());
		Patient patient = null;
		if (Constant.User.ROLE_PATIENT == confirmUserReq.getUserRole())//如果是患者
			patient = patientDao.findByUserId(user.getUserId());
		TConfirmUserResp resp = new TConfirmUserResp();
		resp.setRegisterFlag(0);
		//确认是本人
		if (1 == confirmUserReq.getIsConfirmed()){
			//患者
			if (Constant.User.ROLE_PATIENT == confirmUserReq.getUserRole()) {
				ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(confirmUserReq.getOpenId());
				//正式患者
				User cloudUser = this.userDao.findByUserId(thirdParty.getUserId());
				Patient cloudPatient = null;
				if(StringUtils.isNotBlank(cloudUser.getUuid())&&StringUtils.isNotBlank(user.getUuid())&&!cloudUser.getUuid().equals(user.getUuid())){
					MatchUserMergeReq req = new MatchUserMergeReq(user.getUuid(), cloudUser.getUuid(), Constant.User.ROLE_PATIENT);
					matchMergeUtil.matchUserMergeRequest(req);
					cloudUser = this.userDao.findByUserId(cloudUser.getUserId());
					cloudPatient = this.patientDao.findByUserId(cloudUser.getUserId());
					cloudUser.setUserName(confirmUserReq.getMobile());
					cloudUser.setMobile(confirmUserReq.getMobile());
					cloudUser.setAccountType(Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE);
					userDao.updateUserWithBind(cloudUser);
					cloudPatient = this.patientDao.findByUserId(thirdParty.getUserId());
					cloudPatient.setMobile(confirmUserReq.getMobile());
					patientDao.updateByPrimaryKey(cloudPatient);
				}else{
					cloudPatient = this.patientDao.findByUserId(thirdParty.getUserId());
					//将ToB导入的信息转移到正式患者信息下
					this.mergeToBPatientToCloudPatient(cloudUser, cloudPatient, user, patient, confirmUserReq);
				}
				user = cloudUser;
				patient = cloudPatient;
				//抵用券
				this.userService.initUserCoupon(user.getUserId());
			}
			//医生
			else if (Constant.User.ROLE_DOCTOR == confirmUserReq.getUserRole()){
				user.setAccountType(Constant.User.ACCOUNTTYPE_APP);
				user.setInfoState(Constant.User.INFOSTATE_PRIMARY);
				user.setUserName(confirmUserReq.getMobile());
				user.setAppFlag(Constant.User.APPFLAG_YES);
				this.userDao.updateUserWithBind(user);
				/*
				Doctor doctor = this.doctorDao.findByUserId(confirmUserReq.getUserId());
				//审核通过
				if (doctor.getAuditState() == null ||
						doctor.getAuditState() <= Constant.User.AUDITSTATE_PRIMARYPASS) {
					doctor.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
					this.doctorDao.updateByPrimaryKey(doctor);
					//向医生推送消息
					this.auditDoctorSmsContentSend(confirmUserReq.getMobile(), doctor.getAuditState());
				}
				//生成医生的二维码
				this.generateQRCode(confirmUserReq.getUserId());
				*/
			}
			//保存uuid映射关系，以后toB端可以直接同步数据
			//this.uuidRelationshipService.saveUuidMapper(user, user.getUuid());
		} else {
			user.setAccountType(Constant.User.ACCOUNTTYPE_REFUSE);
			this.userDao.updateUser(user);
			//患者
			if (1 == confirmUserReq.getUserRole()) {
				ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(confirmUserReq.getOpenId());
				user = this.userDao.findByUserId(thirdParty.getUserId());
				patient =  this.patientDao.findByUserId(user.getUserId());
				perfectPatient(user, patient, null, null, confirmUserReq);
				//抵用券
				this.userService.initUserCoupon(user.getUserId());
			}
			//医生
			else if (2 == confirmUserReq.getUserRole()){
				UserRegisterReq req = new UserRegisterReq();
				req.setUserName(confirmUserReq.getMobile());
				req.setRole(confirmUserReq.getUserRole());
				user = this.userService.registerUser(req);
			}
		}
		resp.setUserId(user.getUserId());
		resp.setAccountType(user.getAccountType());
		resp.setInfoState(user.getInfoState());
		
		//如果是患者
		if (Constant.User.ROLE_PATIENT == user.getRole()) {
			Long patientId = this.patientDao.findIdByUserId(user.getUserId());
			if (null == patientId) {
				patientId = this.patientService.registerPatient(user).getPatientId();
			}
			resp.setPatientId(patientId);				
		}
		//如果是医生
		else if (Constant.User.ROLE_DOCTOR == user.getRole()) {
			Long doctorId = this.doctorDao.findDoctorIdByUserId(user.getUserId());
			if (null == doctorId) {
				doctorId = this.doctorService.registerDoctor(user).getDoctorId();
			}
			resp.setDoctorId(doctorId);
			//调用运维系统建立关系
			this.createUserToStrategy(user);
		}
		return resp;
	}
	
	
	@Transactional
	@Override
	public TConfirmUserResp wxFuse(TConfirmUserReq confirmUserReq) throws BindingDataExcption, ObjectAlreadyExistExcption {
		TConfirmUserResp resp = new TConfirmUserResp();
		//通过手机号取user
		List<ThirdParty> currentThirdParties = this.thirdPartyDao.findByUserId(confirmUserReq.getUserId());
		ThirdParty thirdParty = currentThirdParties.get(0);
		User user = this.userDao.findByUserId(thirdParty.getUserId());
		Patient patient = this.patientDao.findByUserId(thirdParty.getUserId());
		if (confirmUserReq.getIsConfirmed() == 1) {//确认是一个人
			//新增的用户
			ThirdParty currentThirdParty = this.thirdPartyDao.searchThirdPartyByOpenId(confirmUserReq.getOpenId());
			Patient currentPatient = this.patientDao.findByUserId(currentThirdParty.getUserId());
			
			//将微信修改为之前的用户下
			currentThirdParty.setUserId(user.getUserId());
			this.thirdPartyDao.updateByPrimaryKey(currentThirdParty);
			//合并医院、患者关系
			this.hospitalPatientService.handleHospitalPatientRelation(patient, currentPatient);
			this.patientFamilyService.addOrModifyPatientFamily(patient);
			
			//删除新增的患者
			this.patientDao.deletePatientByUserId(currentPatient.getUserId());
			//删除新增的用户
			this.userDao.deleteByPrimaryKey(currentPatient.getUserId());
			//抵用券
			//this.userService.initUserCoupon(currentPatient.getUserId());
			
			resp.setRegisterFlag(1);
		}else{//确认不是一个人
			/*
			//补全user，patient，生成family
			if (null == patient) {
				patient = this.patientService.registerPatient(user);
			}
			PatientFamily patientFamily = new PatientFamily();
			Date nowTime = new Date();
			//更新user
			user.setTrueName(confirmUserReq.getTrueName());
			user.setAccountType(Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE);
			user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
			user.setMobile(confirmUserReq.getMobile());
			user.setUserName(confirmUserReq.getMobile());
			
			//未审核
			patient.setAuditState(Constant.User.AUDITSTATE_NOT);
			patient.setMobile(confirmUserReq.getMobile());
			patient.setTrueName(confirmUserReq.getTrueName());
			patient.setPatientRelation(confirmUserReq.getPatientRelation());
			
			//更新family
			patientFamily.setPatientId(patient.getPatientId());
			patientFamily.setPatientRelation(confirmUserReq.getPatientRelation() == Constant.User.PATIENTRELATION_ONESELF ? Constant.User.PATIENTRELATION_ONESELF : Constant.User.PATIENTRELATION_FAMILIES);
			patientFamily.setFamilyName(confirmUserReq.getTrueName());
			patientFamily.setFamilyPhone(confirmUserReq.getMobile());
			patientFamily.setCreateTime(nowTime);

			this.patientFamilyDao.insert(patientFamily);
			
			resp.setPatientId(patient.getPatientId());	
			resp.setRegisterFlag(0);

			try {
				this.patientDao.updateByPrimaryKey(patient);
			} catch (Exception e) {
				throw new BindingDataExcption("Cell phone number " + patient.getMobile() + " has been bound to patients!");
			}
			this.userDao.updateUserWithBind(user);
			*/
			//手机号冲突
			throw new ObjectAlreadyExistExcption("The User already exist!");
		}
		resp.setUserId(patient.getUserId());
		resp.setPatientId(patient.getPatientId());
		resp.setInfoState(user.getInfoState());
		resp.setAccountType(user.getAccountType());
		resp.setRegisterFlag(1);
		return resp;
	}
	
	/**
	 * 
	* @Title: clearTempPatientByOpenId 
	* @Description: 通过openId移除临时患者相关信息 
	* @param @param opendId    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void mergeToBPatientToCloudPatient(User cloudUser, Patient cloudPatient, User tobUser, Patient tobPatient, TConfirmUserReq confirmUserReq)
	{
		//合并病历和随访信息
		Map<String, Number> params = new HashMap<String, Number>(3);
		params.put("cloudPatientId", cloudPatient.getPatientId());
		params.put("tobPatientId", tobPatient.getPatientId());
		this.patientDao.mergeTobPatientInfoToFormalPatientInfo(params);
		//如果ToC患者同tob患者原发病种不一致 删除ToC患者的随访计划
		if(cloudPatient.getSourceDiseaseTypeId()!=tobPatient.getSourceDiseaseTypeId())
			this.patientDao.cleanCloudPatientFollowupPlan(cloudPatient.getPatientId());
		//处理医院、患者关系
		this.hospitalPatientService.handleHospitalPatientRelation(cloudPatient, tobPatient);
		//合并患者家属数据
		this.patientFamilyDao.updateToBPatientFamilyToCloudRelation(cloudPatient.getPatientId(), tobPatient.getPatientId());
		//合并医患关系
		this.doctorPatientService.mergeDoctorPatient(cloudPatient, tobPatient);
		//防重所以要删除
		this.varPatientDoctorMedicalDao.updateInfoToCloudPatientInfo(cloudPatient.getPatientId(), tobPatient.getPatientId());
		this.varPatientDoctorMedicalDao.deleteByPatientId(tobPatient.getPatientId());
		this.patientFamilyService.addOrModifyPatientFamily(cloudPatient);
		this.patientDao.deletePatientByUserId(tobUser.getUserId());
		this.userDao.deleteByPrimaryKey(tobUser.getUserId());
		//使用ToB端导入的患者信息作为患者的线上数据
		this.perfectPatient(cloudUser, cloudPatient, tobUser, tobPatient, confirmUserReq);
	}
	
	/**
	 * 
	* @Title: perfectPatient 
	* @Description: 完善患者信息 
	* @param @param user
	* @param @param confirmUserInfo
	* @param @param isCreate    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	private void perfectPatient(User cloudUser, Patient cloudPatient, User tobUser, Patient tobPatient, TConfirmUserReq confirmUserReq)
	{
		this.userService.mergeToBPatientUserInfo(cloudUser, tobUser);
		//更新user
		cloudUser.setUserName(confirmUserReq.getMobile());
		cloudUser.setMobile(confirmUserReq.getMobile());
		cloudUser.setAccountType(Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE);
		if (tobUser != null && StringUtils.isNotEmpty(tobUser.getTrueName())) {
			cloudUser.setTrueName(tobUser.getTrueName());
		}
		
		//更新patient
		cloudPatient.setMobile(confirmUserReq.getMobile());
		cloudPatient.setTrueName(cloudUser.getTrueName());
		cloudPatient.setUuid(cloudUser.getUuid());
		cloudPatient.setSyncFlag(cloudUser.getSyncFlag());
		if(tobUser!=null)
			cloudPatient.setMatchFlag(1);
		//未审核
		cloudPatient.setAuditState(Constant.User.AUDITSTATE_NOT);
		if (tobPatient != null) {
			//病案号合并
			if(StringUtils.isBlank(cloudPatient.getPatientNo())&&!StringUtils.isBlank(tobPatient.getPatientNo()))
				cloudPatient.setPatientNo(tobPatient.getPatientNo());
			cloudPatient.setSourceDiagnosis(tobPatient.getSourceDiagnosis());
			cloudPatient.setSourceDiseaseTypeId(tobPatient.getSourceDiseaseTypeId());
			cloudPatient.setSourceDiseaseCode(tobPatient.getSourceDiseaseCode());
			cloudPatient.setConfirmedDate(tobPatient.getConfirmedDate());
			
			cloudPatient.setSourceDiagnosis2(tobPatient.getSourceDiagnosis2());
			cloudPatient.setSourceDiseaseTypeId2(tobPatient.getSourceDiseaseTypeId2());
			cloudPatient.setSourceDiseaseCode2(tobPatient.getSourceDiseaseCode2());
			cloudPatient.setConfirmedDate2(tobPatient.getConfirmedDate2());
			
			cloudPatient.setSourceDiagnosis3(tobPatient.getSourceDiagnosis3());
			cloudPatient.setSourceDiseaseTypeId3(tobPatient.getSourceDiseaseTypeId3());
			cloudPatient.setSourceDiseaseCode3(tobPatient.getSourceDiseaseCode3());
			cloudPatient.setConfirmedDate3(tobPatient.getConfirmedDate3());
		}
		//如果有疾病信息
		if (StringUtils.isNotEmpty(cloudPatient.getSourceDiagnosis()) &&
				cloudPatient.getSourceDiseaseTypeId() != null &&
				StringUtils.isNotEmpty(cloudPatient.getSourceDiseaseCode()) &&
				cloudPatient.getConfirmedDate() != null) {
			if (cloudUser.getInfoState() < Constant.User.INFOSTATE_PRIMARY) {
				cloudUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			}
			if (cloudPatient.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
				cloudPatient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
			}
		}
		//如果有证件号
		if (StringUtils.isNotEmpty(cloudUser.getIdentification())) {
//			if (user.getInfoState() < Constant.User.INFOSTATE_REALNAME) {
//				user.setInfoState(Constant.User.INFOSTATE_REALNAME);
//			}
			/*if (cloudPatient.getAuditState() < Constant.User.AUDITSTATE_ADVANCEDPASS) {
				cloudPatient.setAuditState(Constant.User.AUDITSTATE_ADVANCEDPASS);
			}*/
		}
		this.userDao.updateUserWithBind(cloudUser);
		this.patientDao.updateByPrimaryKey(cloudPatient);
		this.patientFamilyService.addOrModifyPatientFamily(cloudPatient);
	}

	/**
	 * <p>Title: createUserToStrategy</p>
	 * <p>Description: </p>
	 * @date 2016年4月28日 上午10:44:32
	 * @param user
	 */
	public void createUserToStrategy(User user) {
		LogUtil.log.debug("调用运维系统，建立关系---------->>");
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		//String json = JsonUtil.toJson(user);
		try {
			//HttpUtil.postWithJSON(this.serverUrlRoot + this.createUserToStrategy, json);
			HttpUtil.get(this.serverUrlRoot + this.createUserToStrategy + "?userId=" + user.getUserId() + "&role=" + user.getRole());
		} catch (Exception e) {
			LogUtil.log.error("添加用户与策略关联关系(createUserToStrategy)出错;" + e.getMessage());
		}
		LogUtil.log.debug("调用运维系统，建立关系完成----------<<");
	}
}
