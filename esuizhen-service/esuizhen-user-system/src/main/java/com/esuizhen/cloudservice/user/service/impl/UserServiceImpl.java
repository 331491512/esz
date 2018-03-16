/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service.impl<br/>  
 * <b>文件名：</b>UserServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月2日-下午6:22:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;

import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.esuizhen.cloudservice.user.bean.PasswordModifyReq;
import com.esuizhen.cloudservice.user.bean.UserLoginOutReq;
import com.esuizhen.cloudservice.user.bean.UserProfileDetailReq;
import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.common.Const;
import com.esuizhen.cloudservice.user.dao.ConfHospitalWXDao;
import com.esuizhen.cloudservice.user.dao.DoctorDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientDao;
import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.PatientFamilyDao;
import com.esuizhen.cloudservice.user.dao.PushDao;
import com.esuizhen.cloudservice.user.dao.QRcodeDao;
import com.esuizhen.cloudservice.user.dao.ThirdPartyDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.dao.UserDeviceDao;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.UUserDevice;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.esuizhen.cloudservice.user.txService.TxUserService;
import com.google.gson.internal.LinkedTreeMap;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.DoctorTag;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.LoginByThirdPartyReq;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientDiagnosisReq;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.SourceDiagnosisInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.ThirdParty;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.bean.UserStatisProfile;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.trade.CouponTemplateInfoGetReq;
import com.westangel.common.bean.trade.CouponTemplateReq;
import com.westangel.common.bean.trade.TAccountInfo;
import com.westangel.common.bean.trade.TCouponTemplateInfo;
import com.westangel.common.bean.user.ConfHospitalWX;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.bean.user.QRCode;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.bean.user.TTobeconfirmedDoctor;
import com.westangel.common.bean.user.TUserSyncConfirmInfo;
import com.westangel.common.bean.user.UserLoginOutResp;
import com.westangel.common.bean.user.UserRegisterResp;
import com.westangel.common.bean.weixin.WeixinQRReq;
import com.westangel.common.bean.weixin.WeixinUserGetReq;
import com.westangel.common.bean.weixin.WeixinUserInfo;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.BindingDataExcption;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParamFormatErrorExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.service.AccountService;
import com.westangel.common.service.CouponInnerService;
import com.westangel.common.service.DiagInnerService;
import com.westangel.common.service.FollowupService;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.service.WeixinInnerService;
import com.westangel.common.util.Codec;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.StringUtil;

/**
 * @ClassName: UserServiceImpl
 * @Description: 用户相关服务方法
 * @author YYCHEN
 * @date 2015年12月2日 下午6:22:01
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService, com.westangel.common.service.UserService {
	private Locale locale = Locale.getDefault();
	@Autowired
	private UserDao userDao;
	@Autowired
	private PushDao pushDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private PatientDao patientDao;
	@Autowired
	private UserDeviceDao userDeviceDao;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private ThirdPartyDao thirdPartyDao;
	@Autowired
	private AccountService accountService;
	@Autowired
	private DiagInnerService diagInnerService;
	@Autowired
	private QRcodeDao qrcodeDao;
	@Resource(name = "followupService")
	private FollowupService followupService;
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private SmsInnerService smsInnerService;
	@Autowired
	private MessageInnerService messageInnerService;
	@Autowired
	private WeixinInnerService weixinInnerService;
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	@Autowired
	public OperationHistoryDao operationHistoryDao;

	@Autowired
	public CouponInnerService couponService;

	@Autowired
	private PatientService patientService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private TxUserService txUserService;

	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${server.h5.patient.followup.follow}")
	private String patientFollowupFollow;
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${url.api.business.doctor.inite.patient.do.something}")
	private String patientDoSomething;
	@Value("${push.weixin.qr.get}")
	private String pushWeixinQrGetUrl;
	@Value("${server.wx.service.url.root}")
	private String serverWXServiceUrlRoot;
	@Value("${default.doctor.man.userPictureUrl}")
	private String defaultDoctorManUserPictureUrl;
	@Value("${default.doctor.wonman.userPictureUrl}")
	private String defaultDoctorWonmanUserPictureUrl;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;
	@Value("${operating.strategy.user.create}")
	private String createUserToStrategy;
	@Value("${url.h5.coupon.list}")
	private String couponList;

	// /**(非 Javadoc)
	// * <p>Title: verify</p>
	// * <p>Description: 通过用户名验证是否已经存在用户名</p>
	// * @param userName
	// * @return
	// * @see
	// com.esuizhen.cloudservice.user.service.UserService#verify(java.lang.String)
	// */
	// @Override
	// public boolean verify(String userName) {
	// User user = dao.selectUserByUserName(userName, null);
	// return user == null;
	// }

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: selectUser
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userLoginReq
	 * @return
	 * @throws EmptyObjectExcption
	 * @see com.esuizhen.cloudservice.user.service.UserService#selectUser(com.esuizhen.cloudservice.user.bean.UserLoginReq)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public UserRegisterResp loginselectUser(UserRegisterReq userRegisterReq)
			throws EmptyObjectExcption, ParamMismatchExcption, ObjectNotAvailableExcption {
		String username = userRegisterReq.getUserName();
		Integer role = userRegisterReq.getRole();
		if (StringUtils.isBlank(username)) {
			throw new EmptyParamExcption("\"username\" is empty!");
		}
		if (role == null) {
			throw new EmptyParamExcption("\"role\" is empty, username is \"" + username + "\"!");
		}
		User user = userDao.findByUserName(username, role);
		if (!(null != user && (3 == user.getAccountType() || 4 == user.getAccountType()))) {
			throw new EmptyObjectExcption("\"user\" does not exist, username is \"" + username + "\"!");
		} else if (!user.getCryptPasswd().equals(userRegisterReq.getCryptPasswd())) {
			throw new ParamMismatchExcption("The password mismatch, username is \"" + username + "\"!");
		}
		UserRegisterResp userRegisterResp = new UserRegisterResp();
		switch (role) {
		// 如果是患者登录查询患者编号和用户编号
		case 1:
			Patient patient = patientDao.findByUserId(user.getUserId());
			if (patient == null) {
				throw new EmptyObjectExcption(
						"\"Patient\" does not exist, username is \"" + username + "\", role is " + role + "!");
			}
			userRegisterResp.setPatientId(patient.getPatientId());
			break;
		// 如果是医生登录查询医生编号和用户编号
		case 2:
			DoctorProfile doctorProfile = doctorDao.selectDoctorProfileByUserId(user.getUserId(), null,
					serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl,
					serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
			if (doctorProfile == null) {
				throw new EmptyObjectExcption(
						"\"Doctor\" does not exist, username is \"" + username + "\", role is " + role + "!");
			}
			// 医生APP登录标识
			user.setAppFlag(Constant.User.APPFLAG_YES);
			userRegisterResp.setDoctorId(doctorProfile.getDoctorId());
			break;
		default:
			break;
		}
		// 记录设备信息
		userRegisterResp.setLuid(this.recordingUserDeviceInfoWhenLogin(userRegisterReq.getDeviceInfo(), user));
		// 更新登录时间
		this.userDao.updateLastLogin(user);
		userRegisterResp.setUserId(user.getUserId());
		return userRegisterResp;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: register
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userLoginResp
	 * @return
	 * @throws ObjectAlreadyExistExcption
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#register(com.esuizhen.cloudservice.user.bean.UserLoginReq)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public UserRegisterResp register(UserRegisterReq userRegisterReq)
			throws ParamFormatErrorExcption, EmptyParamExcption, RejectRequestExcption, ObjectAlreadyExistExcption,
			ObjectNotAvailableExcption, InsufficientParameterExcption {
		if (StringUtils.isBlank(userRegisterReq.getUserName())) {
			throw new EmptyParamExcption("param \"username\" is empty!");
		}
		if (userRegisterReq.getRole() == null) {
			throw new EmptyParamExcption(
					"param \"role\" is empty, \"username\" is " + userRegisterReq.getUserName() + "!");
		}
		return registerOrLoginByAuthcode(userRegisterReq);
	}

	/**
	 * 
	 * @Title: getSyncConfirmInfoOfDoctor @Description: 我是被动医生 @param @param
	 *         user @param @return 设定文件 @return UserRegisterResp 返回类型 @throws
	 */
	private TUserSyncConfirmInfo getSyncConfirmInfoOfDoctor(User user) {
		TTobeconfirmedDoctor doctor = doctorDao.selectToconfirmedDoctor(user.getUserId());
		StringBuilder tipText = new StringBuilder();
		if (!StringUtils.isEmpty(doctor.getStaffNo())) {
			tipText.append(messageSource.getMessage("push.synchronized.information.todoctor.job.number", null, locale));
			tipText.append(doctor.getStaffNo());
			tipText.append("\n");
		}
		if (!StringUtils.isEmpty(doctor.getProfessionalRankName())) {
			tipText.append(doctor.getProfessionalRankName());
		}
		if (StringUtils.isNotEmpty(doctor.getSubDeptName())) {
			tipText.append("  " + doctor.getSubDeptName());
		} else if (!StringUtils.isEmpty(doctor.getDeptName())) {
			tipText.append("  " + doctor.getDeptName());
		}
		if (!StringUtils.isEmpty(doctor.getHospitalName())) {
			tipText.append("\n" + doctor.getHospitalName());
		}

		// 同步信息
		TUserSyncConfirmInfo info = new TUserSyncConfirmInfo();
		info.setUserId(doctor.getUserId());
		info.setTrueName(doctor.getTrueName());
		info.setUuid(user.getUuid());
		info.setTipText(tipText.toString());
		return info;
	}

	/**
	 * 
	 * @Title: getSyncConfirmInfoOfPatient @Description: 获取患者确认信息 @param @param
	 *         user @param @return 设定文件 @return TUserSyncConfirmInfo
	 *         返回类型 @throws
	 */
	private TUserSyncConfirmInfo getSyncConfirmInfoOfPatient(User user) {
		String tipText = messageSource.getMessage("push.synchronized.information.todoctor.register.confirm.content",
				new String[] { user.getMobile(), user.getTrueName() }, locale);
		tipText += messageSource.getMessage("push.synchronized.information.todoctor.register.confirm.clickbutton.text",
				null, locale);
		tipText += messageSource.getMessage("push.synchronized.information.todoctor.register.cancel.clickbutton.text",
				null, locale);
		// 同步信息
		TUserSyncConfirmInfo info = new TUserSyncConfirmInfo();
		info.setUserId(user.getUserId());
		info.setTrueName(user.getTrueName());
		info.setUuid(user.getUuid());
		info.setTipText(tipText);

		return info;
	}

	@Autowired
	private ConfHospitalWXDao confHospitalWXDao;

	/**
	 * <p>
	 * Title:getFuseConfirmInfoOfPatient
	 * </p>
	 * <p>
	 * Description:微信融合提示信息
	 * </p>
	 * 
	 * @author YYCHEN
	 * @date 2016年6月16日 下午2:21:41
	 * @param user
	 * @param productId
	 * @return
	 */
	private TUserSyncConfirmInfo getFuseConfirmInfoOfPatient(User user, Integer productId) {
		String sex = null;
		if (user.getSex() != null) {
			if (1 == user.getSex()) {
				sex = messageSource.getMessage("sex.male", null, locale);
			} else if (2 == user.getSex()) {
				sex = messageSource.getMessage("sex.female", null, locale);
			}
		}
		String birthDay = null;
		if (user.getBirthDate() != null) {
			birthDay = DateUtils.formatDate(user.getBirthDate(), "yyyy-MM-dd");
		}
		StringBuilder additional = new StringBuilder(user.getTrueName());
		if (sex != null || birthDay != null) {
			additional.append("（");
			if (sex != null) {
				additional.append(sex);
			}
			if (birthDay != null) {
				additional.append("，");
				additional.append(birthDay);
			}
			additional.append("）");
		}
		ConfHospitalWX confHospitalWX = this.confHospitalWXDao.findByProductId(productId);
		String tipText = messageSource.getMessage("tips.patient.bind.mobile.fuese",
				new String[] { confHospitalWX.getWeixinName(), additional.toString() }, locale);

		// 同步信息
		TUserSyncConfirmInfo info = new TUserSyncConfirmInfo();
		info.setUserId(user.getUserId());
		info.setTrueName(user.getTrueName());
		info.setTipText(tipText);
		info.setMatchType(Const.MATCHTYPE_WXFUSE);
		return info;
	}

	/**
	 * 
	 * @Title: getSyncConfirmInfoOfUser @Description: 获取确认信息 @param @param
	 *         user @param @return 设定文件 @return TUserSyncConfirmInfo
	 *         返回类型 @throws
	 */
	private TUserSyncConfirmInfo getSyncConfirmInfoOfUser(User user) {
		// 如果是医生角色
		if (2 == user.getRole()) {
			return getSyncConfirmInfoOfDoctor(user);
		}
		// 如果是患者
		else if (1 == user.getRole()) {
			return getSyncConfirmInfoOfPatient(user);
		}
		return null;
	}

	/**
	 * 通过验证码注册或登陆
	 * 
	 * @param userRegisterReq
	 * @param tmsgReponse
	 * @param userRegisterResp
	 * @param user
	 * @return
	 * @throws ObjectAlreadyExistExcption
	 * @throws RejectRequestExcption
	 * @throws ObjectNotAvailableExcption
	 * @throws Exception
	 */
	private UserRegisterResp registerOrLoginByAuthcode(UserRegisterReq userRegisterReq) throws ParamFormatErrorExcption,
			RejectRequestExcption, ObjectAlreadyExistExcption, ObjectNotAvailableExcption {
		UserRegisterResp resp = new UserRegisterResp();
		resp.setPingInterval(4);// 统计Ping时间间隔。单位：小时
		// 登录判断 被动用户
		User user = null;
		String luid = null;
		user = userDao.findUserByUserName(userRegisterReq);
		if(user!=null){//存在用户 返回用户信息
			resp.setRegisterFlag(1);
			this.userDao.updateLastLogin(user);
			luid = this.recordingUserDeviceInfoWhenLogin(userRegisterReq.getDeviceInfo(), user);
		}else{//不存在用户 查询是否存在被动用户
			user=userDao.findByMobile(false, userRegisterReq.getUserName(), userRegisterReq.getRole());
			if(user!=null){//被动用户存在 返回被动用户信息
				resp.setRegisterFlag(-1);
				TUserSyncConfirmInfo info = getSyncConfirmInfoOfUser(user);
				resp.setConfirmInfo(info);
			}else{//注册新用户
				resp.setRegisterFlag(0);
				user = this.registerUser(userRegisterReq);
				// 调用运维系统建立关系
				this.txUserService.createUserToStrategy(user);
			}
			luid = this.registerUserDevice(userRegisterReq, user);
		}
		/*
		user=userDao.findByMobile(false, userRegisterReq.getUserName(), userRegisterReq.getRole());
		if (user == null)// 查询注册用户
			user = userDao.findByUserName(userRegisterReq.getUserName(), userRegisterReq.getRole());
		String luid = null;
		// 用户信息已存在
		if (null != user) {
			if (0 == user.getAccountType()) {// 如果是被动用户，需要发送确认信息
				resp.setRegisterFlag(-1);
				TUserSyncConfirmInfo info = getSyncConfirmInfoOfUser(user);
				// 验证设备
				luid = this.registerUserDevice(userRegisterReq, user);
				resp.setConfirmInfo(info);
			} else {// 正常注册用户
				resp.setRegisterFlag(1);
				// 更新登录时间
				this.userDao.updateLastLogin(user);
				luid = this.recordingUserDeviceInfoWhenLogin(userRegisterReq.getDeviceInfo(), user);
			}
			// 记录设备信息
			luid = this.recordingUserDeviceInfoWhenLogin(userRegisterReq.getDeviceInfo(), user);
		} else {// 否则注册新用户
			resp.setRegisterFlag(0);
			user = this.registerUser(userRegisterReq);
			// 验证设备
			luid = this.registerUserDevice(userRegisterReq, user);
			// 调用运维系统建立关系
			this.txUserService.createUserToStrategy(user);
		}
		*/
		resp.setLuid(luid);
		resp.setUserId(user.getUserId());
		// 设置doctorId或者patientId
		if (Constant.User.ROLE_PATIENT == user.getRole()) {
			Long patientId = this.patientDao.findIdByUserId(user.getUserId());
			if (null == patientId) {
				patientId = this.patientService.registerPatient(user).getPatientId();
			}
			resp.setPatientId(patientId);
		} else if (Constant.User.ROLE_DOCTOR == user.getRole()) {
			Long doctorId = this.doctorDao.findDoctorIdByUserId(user.getUserId());
			if (null == doctorId) {
				doctorId = this.doctorService.registerDoctor(user).getDoctorId();
			}
			resp.setDoctorId(doctorId);
		}
		return resp;
	}

	/**
	 * <p>
	 * Title: recordingUserDeviceInfoWhenLogin
	 * </p>
	 * <p>
	 * Description: 记录用户登陆使用的设备信息
	 * </p>
	 * 
	 * @date 2016年4月21日 下午5:26:27
	 * @param deviceInfo
	 * @param user
	 */
	private String recordingUserDeviceInfoWhenLogin(UUserDevice deviceInfo, User user) {
		if (deviceInfo == null) {
			return null;
		}
		if (deviceInfo.getBussinessId() == null) {
			deviceInfo.setBussinessId(1);
		}
		if (deviceInfo.getProductId() == null) {
			deviceInfo.setProductId(1);
		}
		deviceInfo.setOpFlag(1);// 登录保存设备信息
		if (deviceInfo.getUserId() == null) {
			deviceInfo.setUserId(user.getUserId());
		}
		if (deviceInfo.getRole() == null) {
			deviceInfo.setRole(user.getRole());
		}
		// 处理luid
		StringBuilder luid = new StringBuilder();
		luid.append(deviceInfo.getBussinessId());
		luid.append("-");
		luid.append(deviceInfo.getProductId());
		luid.append("-");
		luid.append(deviceInfo.getDeviceType());
		luid.append("-");
		luid.append(deviceInfo.getDeviceId());
		luid.append("-");
		luid.append(deviceInfo.getRole());
		luid.append("-");
		luid.append(deviceInfo.getUserId());
		deviceInfo.setLuid(luid.toString());

		UUserDevice userDevice = this.userDeviceDao.findByLuid(luid.toString(), null);
		if (userDevice == null) {
			// 新增设备登录信息
			this.userDeviceDao.insert(deviceInfo);
		} else {
			// 更新设备登录信息
			deviceInfo.setId(userDevice.getId());
			this.userDeviceDao.update(deviceInfo, deviceInfo.getRole(), deviceInfo.getProductId());
		}
		return deviceInfo.getLuid();
	}

	/**
	 * 
	 * @Title: matchDoctor @Description: 注册账号 @param @return TMsgResponse
	 *         <UserRegisterResp> @throws
	 */
	public User registerUser(UserRegisterReq userRegisterReq) {
		Date nowTime = new Date();
		User user = new User();
		String password = userRegisterReq.getCryptPasswd();
		if (StringUtils.isBlank(password)) {
			password = Codec.hexMD5(GeneralUtil.getCaptchaNum());
		}
		user.setUserName(userRegisterReq.getUserName());
		user.setCryptPasswd(password);
		user.setRole(userRegisterReq.getRole());
		user.setAccountType(Constant.User.ACCOUNTTYPE_APP);
		user.setMobile(userRegisterReq.getUserName());
		user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
		user.setState(Constant.User.USERSTATE_NORMAL);
		user.setPoints(0);
		user.setSourceFlag(Constant.User.USERSOURCEFLAG_DOCTOR);
		user.setAppFlag(Constant.User.APPFLAG_YES);// 默认APP标识
		//user.setFirstLoginTime(nowTime);
		user.setLastLoginTime(nowTime);
		user.setSyncFlag(Constant.User.SYNCFLAG_NO);

		this.userDao.insert(user);
		return user;
	}

	/**
	 * 注册用户的设备
	 * 
	 * @param userRegisterReq
	 * @param user
	 * @return
	 * @throws RejectRequestExcption
	 * @throws ObjectAlreadyExistExcption
	 */
	private String registerUserDevice(UserRegisterReq userRegisterReq, User user)
			throws RejectRequestExcption, ObjectAlreadyExistExcption {
		UUserDevice deviceInfo = userRegisterReq.getDeviceInfo();
		if (deviceInfo == null) {
			throw new EmptyParamExcption("param \"DeviceInfo\" is empty!");
		} else {
			// 验证是否有设备信息
			List<UUserDevice> userDevices = this.userDeviceDao.selectByUserIdAndDeviceId(user.getUserId(),
					deviceInfo.getDeviceId());
			if (userDevices != null && !userDevices.isEmpty()) {
				return userDevices.get(0).getLuid();
			}
			// 验证该设备注册的账号数
			List<UUserDevice> deviceList = this.userDeviceDao.searchUserDeviceListByDeviceId(deviceInfo.getDeviceId(),
					user.getRole());
			if (deviceList != null && deviceList.size() >= 3) {
				throw new RejectRequestExcption(
						"Equipment \"" + deviceInfo.toString() + "\" registered account has been 3");
			} else {
				for (UUserDevice userbean : deviceList) {
					Date registerTime = userbean.getCreateTime();
					Date add24registerTime = DateUtil.addTimeByHours(registerTime, 24);
					// 如果注册当前时间大于设备注册时间+24小时那么可以注册否则则不能注册
					if (DateUtil.comparDate(new Date(), add24registerTime) <= 0) {
						throw new ObjectAlreadyExistExcption("Equipment \"" + deviceInfo.toString()
								+ "\" registered account number less than 24 hours according to the last registered account!");
					}
				}
			}
		}
		if (deviceInfo.getBussinessId() == null) {
			deviceInfo.setBussinessId(1);
		}
		if (deviceInfo.getProductId() == null) {
			deviceInfo.setProductId(1);
		}
		if (deviceInfo.getUserId() == null) {
			deviceInfo.setUserId(user.getUserId());
		}
		if (deviceInfo.getRole() == null) {
			deviceInfo.setRole(user.getRole());
		}
		// 该设备还没有用户注册，则保持该设备的信息
		// UUserDevice userDevice = new UUserDevice();
		// 处理luid
		StringBuilder luid = new StringBuilder();
		luid.append(deviceInfo.getBussinessId());
		luid.append("-");
		luid.append(deviceInfo.getProductId());
		luid.append("-");
		luid.append(deviceInfo.getDeviceType());
		luid.append("-");
		luid.append(deviceInfo.getDeviceId());
		luid.append("-");
		luid.append(deviceInfo.getRole());
		luid.append("-");
		luid.append(deviceInfo.getUserId());
		deviceInfo.setLuid(luid.toString());
		deviceInfo.setOpFlag(0);
		this.userDeviceDao.insert(deviceInfo);
		return deviceInfo.getLuid();
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: modifyPassword
	 * </p>
	 * <p>
	 * Description: 忘记密码重置密码
	 * </p>
	 * 
	 * @param paaswordModifyReq
	 * @throws RejectRequestExcption
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#modifyPassword(com.esuizhen.cloudservice.user.bean.PasswordModifyReq)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public boolean modifyPassword(PasswordModifyReq passwordModifyReq) throws EmptyObjectExcption,
			ParamFormatErrorExcption, RejectRequestExcption, ObjectNotAvailableExcption, EmptyParamExcption {
		if (passwordModifyReq.getRole() == null) {
			throw new EmptyParamExcption(
					"\"role\" cannot be empty, the mobile is " + passwordModifyReq.getMobile() + "!");
		}
		User user = this.userDao.findByMobile(true, passwordModifyReq.getMobile(), passwordModifyReq.getRole());
		if (!(null != user && (3 == user.getAccountType() || 4 == user.getAccountType()))) {
			throw new EmptyObjectExcption(
					"\"User\" does not exist, the mobile is " + passwordModifyReq.getMobile() + "!");
		}
		if (passwordModifyReq.getUserId() != null && passwordModifyReq.getUserId() != 0
				&& !passwordModifyReq.getUserId().equals(user.getUserId())) {
			throw new RejectRequestExcption(
					"userId is " + user.getUserId() + ", but request userId is " + passwordModifyReq.getUserId());
		}
		if (!passwordModifyReq.getMobile().equals(user.getMobile())) {
			throw new ParamFormatErrorExcption("The \"Mobile\" parameter format error");
		}
		String password = passwordModifyReq.getNewPasswd();
		Date nowTime = new Date();
		user.setCryptPasswd(password);
		user.setUpdateTime(nowTime);
		this.userDao.updatePassword(user);
		return true;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: selectUserById
	 * </p>
	 * <p>
	 * Description: 根据用户编号查询用户详细信息
	 * </p>
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#selectUserById(java.lang.Long)
	 */
	@Override
	public User selectUserById(Long userId) {
		return userDao.findByUserId(userId);
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: loginByThirdParty
	 * </p>
	 * <p>
	 * Description: 第三方账号登录
	 * </p>
	 * 
	 * @param loginByThirdPartyReq
	 * @return
	 * @throws EmptyParamExcption
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#loginByThirdParty(com.westangel.common.bean.LoginByThirdPartyReq)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginByThirdPartyResp loginByThirdParty(LoginByThirdPartyReq loginByThirdPartyReq)
			throws EmptyParamExcption {
		if (StringUtils.isBlank(loginByThirdPartyReq.getOpenId())) {
			throw new EmptyParamExcption("\"openId\" is empty!");
		}
		if (loginByThirdPartyReq.getThirdPartyType() == null) {
			throw new EmptyParamExcption("\"thirdPartyType\" is empty!");
		}
		ThirdParty thirdParty = this.thirdPartyDao.searchThirdPartyByOpenId(loginByThirdPartyReq.getOpenId());
		// 如果不存在OpenID,则创建
		if (thirdParty == null) {
			if (loginByThirdPartyReq.getSourceFlag() == null) {
				throw new EmptyParamExcption("\"sourceFlag\" is empty!");
			}
			return registerByOpenID(loginByThirdPartyReq);
		}
		// 存在OpenID，直接获取返回
		User user = userDao.findByUserId(thirdParty.getUserId());
		user.setWeixinFlag(Constant.User.WEIXINFLAG_YES);
		// 设置openId 为上线状态
		userDao.settingThridCancelTime(loginByThirdPartyReq.getOpenId(), user.getUserId(), 1);
		// 如果用户为下线 也将状态设为上线
		if (user.getState() != null && user.getState() == Constant.User.USERSTATE_LOCKED) {
			user.setState(Constant.User.USERSTATE_NORMAL);
		}
		this.userDao.updateLastLogin(user);
		Patient patient = this.patientDao.findByUserId(user.getUserId());

		LoginByThirdPartyResp loginByThirdPartyResp = new LoginByThirdPartyResp();
		loginByThirdPartyResp.setUserId(user.getUserId());
		loginByThirdPartyResp.setPatientId(patient.getPatientId());
		loginByThirdPartyResp.setAccountType(user.getAccountType());
		loginByThirdPartyResp.setInfoState(user.getInfoState());
		loginByThirdPartyResp.setRegisterFlag(Constant.User.REGISTERFLAG_ALEARDYREGISTER);
		if (user.getTrueName() != null)
			loginByThirdPartyResp.setTrueName(user.getTrueName());
		else
			loginByThirdPartyResp.setTrueName(user.getNickName());
		loginByThirdPartyResp.setMobile(user.getMobile());
		loginByThirdPartyResp.setAuditState(patient.getAuditState());
		loginByThirdPartyResp.setWxProductId(thirdParty.getProductId());
		return loginByThirdPartyResp;
	}

	/**
	 * 第三方账号注册
	 * 
	 * @param loginByThirdPartyReq
	 * @return
	 */
	private LoginByThirdPartyResp registerByOpenID(LoginByThirdPartyReq loginByThirdPartyReq) {
		User user = new User();
		ThirdParty thirdParty = new ThirdParty();
		Patient patient = new Patient();
		Date nowTime = new Date();

		user.setUserName(loginByThirdPartyReq.getOpenId().trim());
		user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
		user.setRole(Constant.User.ROLE_PATIENT);
		user.setAccountType(Constant.User.ACCOUNTTYPE_WEIXIN);// 账号类型为第三方账号
		user.setState(Constant.User.USERSTATE_NORMAL);
		user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
		user.setPoints(0);
		user.setSourceFlag(loginByThirdPartyReq.getSourceFlag());
		user.setWeixinFlag(Constant.User.WEIXINFLAG_YES);// 微信标识
		//modify by fanpanwei 这个时间改为存注册时间（运营患者管理需求）
		//user.setFirstLoginTime(nowTime);
		user.setLastLoginTime(nowTime);
		user.setSyncFlag(Constant.User.SYNCFLAG_NO);
		userDao.insert(user);

		thirdParty.setUserId(user.getUserId());
		thirdParty.setOpenId(loginByThirdPartyReq.getOpenId());
		thirdParty.setThirdPartyType(loginByThirdPartyReq.getThirdPartyType());
		thirdParty.setCreateTime(nowTime);
		// 如果存在productId
		if (loginByThirdPartyReq.getWxProductId() != null)
			thirdParty.setProductId(loginByThirdPartyReq.getWxProductId());
		else
			thirdParty.setProductId(2);
		thirdPartyDao.insert(thirdParty);

		patient.setUserId(user.getUserId());
		patient.setCreateTime(nowTime);
		patient.setPatientRelation(Constant.User.PATIENTRELATION_ONESELF);
		patient.setLiveStatus(Constant.User.LIVESTATUS_ALIVE);
		patient.setHasVisibleMedicalRecord(Constant.User.HASVISIBLEMEDICALRECORD_NO);
		patient.setAuditState(Constant.User.AUDITSTATE_NOT);
		patient.setSyncFlag(Constant.User.SYNCFLAG_NO);
		this.patientDao.insert(patient);

		LoginByThirdPartyResp loginByThirdPartyResp = new LoginByThirdPartyResp();
		loginByThirdPartyResp.setUserId(patient.getUserId());
		loginByThirdPartyResp.setPatientId(patient.getPatientId());
		loginByThirdPartyResp.setAccountType(user.getAccountType());
		loginByThirdPartyResp.setInfoState(user.getInfoState());
		loginByThirdPartyResp.setRegisterFlag(Constant.User.REGISTERFLAG_FIRSTREGISTER);
		loginByThirdPartyResp.setTrueName(user.getTrueName());
		loginByThirdPartyResp.setMobile(user.getMobile());
		loginByThirdPartyResp.setAuditState(patient.getAuditState());
		loginByThirdPartyResp.setWxProductId(thirdParty.getProductId());

		return loginByThirdPartyResp;
	}

	@Override
	public void initUserCoupon(Long userId) {
		CouponTemplateInfoGetReq req = new CouponTemplateInfoGetReq();
		req.setReqFlag(Constant.Coupon.COUPON_TEMPLATE_STATE_ON);
		req.setRequirementType(Constant.Coupon.COUPON_TEMPLATE_REQ_REGIST);
		List<PushNotifyInfo> pushInfos = new ArrayList<PushNotifyInfo>();
		// 获取 条件为注册 且上架的服务
		TMsgResponse<List<TCouponTemplateInfo>> msg = couponService.getCouponTemplateInfoList(req);
		if (msg.getRespCode() == 0) {
			if (msg.getResult() != null)
				for (TCouponTemplateInfo info : msg.result) {
					CouponTemplateReq mreq = new CouponTemplateReq();
					List<Long> userIds = new ArrayList<Long>();
					userIds.add(userId);
					mreq.setUserIds(userIds);
					mreq.setCouponTemplateId(info.getCouponTemplateId());
					couponService.initCoupon(mreq);
					PushContent pushContent = PushContentUtil.getUserPushContent(null, "user.regist.success",
							new Object[] { info.getCouponNumber(), serverH5UrlRoot + couponList });
					String content = pushInnerService.getMessage(pushContent);
					Integer productId = userDao.findUserProductId(userId);
					PushNotifyInfo notify = PushUtil.getWxDataPushNotifyInfo(userId, content);
					if (productId != null)
						notify.setProductId(productId);
					pushInnerService.push(notify);
				}
		}
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: bindThirdPartyUser
	 * </p>
	 * <p>
	 * Description: 绑定第三方账户
	 * </p>
	 * 
	 * @param loginByThirdPartyReq
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 * @throws ParamFormatErrorExcption
	 * @throws ParamMismatchExcption
	 * @throws ObjectAlreadyExistExcption
	 * @throws BindingDataExcption
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#bindThirdPartyUser(com.westangel.common.bean.LoginByThirdPartyReq)
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public LoginByThirdPartyResp bindThirdPartyUser(LoginByThirdPartyReq loginByThirdPartyReq)
			throws EmptyParamExcption, EmptyObjectExcption, ParamFormatErrorExcption, ParamMismatchExcption,
			ObjectAlreadyExistExcption, BindingDataExcption {
		ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(loginByThirdPartyReq.getOpenId());
		User user = this.userDao.findByUserId(loginByThirdPartyReq.getUserId());
		if (user == null || thirdParty == null || !thirdParty.getUserId().equals(loginByThirdPartyReq.getUserId())) {
			throw new EmptyObjectExcption("Missing parameter when Binding!");
		}
		if (user.getAccountType() != Constant.User.ACCOUNTTYPE_WEIXIN) {
			throw new ParamMismatchExcption("The \"AccountType\" Not equal to 1");
		}
		if (loginByThirdPartyReq.getMobile().equals(user.getMobile())) {
			throw new ParamMismatchExcption("The \"Mobile\" not equal User mobile!");
		}
		LoginByThirdPartyResp resp = new LoginByThirdPartyResp();
		// 获取患者信息
		Patient patient = this.patientDao.findByUserId(user.getUserId());
		// 通过手机号取被动用户
		User muser = this.userDao.findPatientUserByMobile(loginByThirdPartyReq.getMobile());
		LogUtil.log.debug("bind patient find passive patient muser="+muser);
		if (null == muser) {// 如果被动用户不存在
			muser = this.userDao.findByUserName(loginByThirdPartyReq.getMobile(), Constant.User.ROLE_PATIENT);
		}
		// 用户信息已存在
		if (null != muser) {
			// 如果是被动用户，需要发送确认信息
			if (Constant.User.ACCOUNTTYPE_NONACTIVATED >= muser.getAccountType()) {
				resp.setConfirmInfo(getSyncConfirmInfoOfPatient(muser));
				Long patientId = this.patientDao.findIdByUserId(user.getUserId());
				if (null == patientId) {
					patientId = this.patientService.registerPatient(user).getPatientId();
				}
				resp.setPatientId(patientId);
				resp.setRegisterFlag(-1);
				resp.setTrueName(user.getTrueName());
				resp.setMobile(user.getMobile());
				resp.setUserId(user.getUserId());
				resp.setAccountType(user.getAccountType());
				resp.setInfoState(user.getInfoState());
				resp.setMatchType(2);// 三位一体信息同步
				return resp;
			} else {
				List<ThirdParty> oldThirdParties = this.thirdPartyDao.findByUserId(muser.getUserId());
				if (oldThirdParties != null && !oldThirdParties.isEmpty()) {
					// 微信融合确认
					for (ThirdParty tp : oldThirdParties) {
						if (tp.getProductId() == thirdParty.getProductId()) {
							// 手机号冲突
							throw new ObjectAlreadyExistExcption("The User already exist!");
						}
					}
					resp.setConfirmInfo(getFuseConfirmInfoOfPatient(muser, oldThirdParties.get(0).getProductId()));
					Long patientId = this.patientDao.findIdByUserId(user.getUserId());
					if (null == patientId) {
						patientId = this.patientService.registerPatient(user).getPatientId();
					}
					resp.setPatientId(patientId);
					resp.setRegisterFlag(-1);
					resp.setTrueName(user.getTrueName());
					resp.setMobile(user.getMobile());
					resp.setUserId(user.getUserId());
					resp.setAccountType(user.getAccountType());
					resp.setInfoState(user.getInfoState());
					resp.setMatchType(1);// 微信融合
					return resp;

				}
			}
		} else {
			// 补全user，patient，生成family
			if (null == patient) {
				patient = this.patientService.registerPatient(user);
			}
			PatientFamily patientFamily = new PatientFamily();
			Date nowTime = new Date();
			// 更新user
			user.setTrueName(loginByThirdPartyReq.getTrueName());
			user.setAccountType(Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE);
			user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);
			user.setUpdateTime(nowTime);

			// 未审核
			patient.setAuditState(Constant.User.AUDITSTATE_NOT);
			patient.setUpdateTime(nowTime);

			// 更新family
			patientFamily.setPatientId(patient.getPatientId());
			patientFamily.setPatientRelation(
					loginByThirdPartyReq.getPatientRelation() == Constant.User.PATIENTRELATION_ONESELF
							? Constant.User.PATIENTRELATION_ONESELF : Constant.User.PATIENTRELATION_FAMILIES);
			patientFamily.setFamilyName(loginByThirdPartyReq.getTrueName());
			patientFamily.setFamilyPhone(loginByThirdPartyReq.getMobile());
			patientFamily.setIsDefault(1);
			patientFamily.setIsValid(1);
			patientFamily.setCreateTime(nowTime);
			patientFamily.setContactId(GeneralUtil.generateUniqueID("CONT"));

			this.patientFamilyDao.insert(patientFamily);

			resp.setPatientId(patient.getPatientId());
			resp.setRegisterFlag(0);
		}
		user.setUserName(loginByThirdPartyReq.getMobile());
		user.setMobile(loginByThirdPartyReq.getMobile());
		//运营需求，字段存注册时间
		user.setFirstLoginTime(new Date());
		// 更新patient
		patient.setMobile(loginByThirdPartyReq.getMobile());
		patient.setTrueName(loginByThirdPartyReq.getTrueName());
		patient.setPatientRelation(loginByThirdPartyReq.getPatientRelation());

		this.userDao.updateUserWithBind(user);
		try {
			this.patientDao.updateByPrimaryKey(patient);
		} catch (Exception e) {
			throw new BindingDataExcption(
					"Cell phone number " + loginByThirdPartyReq.getMobile() + " has been bound to patients!");
		}
		// 抵用券
		this.initUserCoupon(user.getUserId());

		resp.setTrueName(user.getTrueName());
		resp.setMobile(user.getMobile());
		resp.setUserId(user.getUserId());
		resp.setAccountType(user.getAccountType());
		resp.setInfoState(user.getInfoState());

		LogUtil.log.debug(Constant.LOGTAG.INF + "bindThirdPartyUser ok! Resuylt LoginByThirdPartyResp-----------<<");
		// 完善疾病信息，给患者推送待审核的消息
		// sendNotifyToPatientForRealnameAuthentication(patient.getUserId());
		// 邀请完善疾病信息
		// sendNotifyToPatientForPatientToImproveDiseaseInformation(patient.getUserId(),
		// loginByThirdPartyReq.getDoctorUserId());
		return resp;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: modifyUserProfile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param userProfileDetailReq
	 * @return
	 * @throws EmptyParamExcption
	 * @throws ParamMismatchExcption
	 * @throws RejectRequestExcption
	 * @throws Exception
	 * @see com.esuizhen.cloudservice.user.service.UserService#modifyUserProfile(com.esuizhen.cloudservice.user.bean.UserProfileDetailReq)
	 */
	@Override
	public LoginByThirdPartyResp modifyUserProfile(UserProfileModifyReq userProfileModifyReq) throws EmptyParamExcption,
			EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption {
		LogUtil.log.debug(
				"modifyUserProfile()------------>>userProfileModifyReq:" + JsonUtil.toJson(userProfileModifyReq));
		UserProfile userProfile = userProfileModifyReq.getUserProfile();
		// 是否开启随访计划
		Integer isFollowup = 0;
		if (userProfile == null || userProfile.getRole() == null) {
			throw new ParamMismatchExcption("Not enough parameters, can not be modified!");
		}
		User user = this.userDao.findByUserId(userProfile.getUserId());
		if (user == null) {
			throw new EmptyObjectExcption("User is empty!");
		}
		LoginByThirdPartyResp loginByThirdPartyResp = null;
		// 身份证号转换
		if (StringUtils.isNotEmpty(userProfile.getPreIdentification())) {
			userProfile.setPreIdentification(userProfile.getPreIdentification().toUpperCase());
		}
		if (StringUtils.isNotEmpty(userProfile.getIdentification())) {
			userProfile.setIdentification(userProfile.getIdentification().toUpperCase());
		}
		// 修改患者信息
		if (userProfile.getRole() == Constant.User.ROLE_PATIENT) {
			Patient patient = this.patientDao.findByUserId(user.getUserId());
			if (patient == null) {
				throw new EmptyObjectExcption("Patient is empty, userId is " + userProfile.getUserId() + "!");
			}
			PatientProfile patientProfile = userProfileModifyReq.getPatientProfile();
			if (patientProfile != null) {
				List<SourceDiagnosisInfo> sourceDiagnosisInfoes = patientProfile.getSourceDiagnosisList();
				if (sourceDiagnosisInfoes != null && !sourceDiagnosisInfoes.isEmpty()) {
					for (SourceDiagnosisInfo sourceDiagnosisInfo : sourceDiagnosisInfoes) {
						// 部位不做判断
						// if (sourceDiagnosisInfo.getDiseaseBodyPartId() ==
						// null) {
						// throw new EmptyParamExcption("疾病部位不能为空！");
						// }
						if (sourceDiagnosisInfo.getSourceDiseaseTypeId() == null) {
							throw new EmptyParamExcption("病种类型不能为空！");
						}
						if (StringUtils.isEmpty(sourceDiagnosisInfo.getSourceDiagnosis())) {
							throw new EmptyParamExcption("诊断内容不能为空！");
						}
						if (sourceDiagnosisInfo.getSourceDiseaseTypeId() != 9999
								&& sourceDiagnosisInfo.getConfirmedDate() == null) {
							throw new EmptyParamExcption("确诊日期不能为空！");
						}
					}
				}
				if (StringUtils.isEmpty(patient.getSourceDiseaseCode())) {
					// 诊断信息
					// 对原发诊断进行排序
					if (sourceDiagnosisInfoes != null && !sourceDiagnosisInfoes.isEmpty()) {
						sourceDiagnosisInfoes = sourceDiagnosisInfoesSort(sourceDiagnosisInfoes);
						for (SourceDiagnosisInfo sourceDiagnosisInfo : sourceDiagnosisInfoes) {
							this.modifyPatientSourceDiagosis(patient, sourceDiagnosisInfo);
						}
					}
					if (patient.getSourceDiseaseTypeId() != null && patient.getSourceDiseaseTypeId() == 9999) {
						if (user.getInfoState() == null || user.getInfoState() < Constant.User.INFOSTATE_PRIMARY) {
							user.setInfoState(Constant.User.INFOSTATE_PRIMARY);
						}
						if (patient.getAuditState() == null
								|| patient.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
							patient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);// 完善个人资料，初级认证
						}
					}
					if (StringUtils.isNotEmpty(patient.getSourceDiseaseCode())
							&& StringUtils.isNotEmpty(patient.getSourceDiagnosis())
							&& patient.getSourceDiseaseTypeId() != null && patient.getSourceDiseaseTypeId() != 9999
							&& patient.getConfirmedDate() != null) {
						// 生成随访计划
						// 没有开通微信暂不生成随访计划
						// #TODO 需优化，后面执行出错，随访计划无法回滚， 应该使用REST请求去开启随访计划能够解决
						if (user.getAccountType() > Constant.User.ACCOUNTTYPE_NONACTIVATED
								&& StringUtils.isNotEmpty(userDao.findUserOpenId(patient.getUserId())))
							if (!followupService.checkPatientHasFollowup(patient.getPatientId())) {
								this.patientService.createFollowupPlan(patient,
										patientProfile.getSourceDiagnosisCreatorId(),
										patientProfile.getSourceDiagnosisCreatorName(),
										patientProfile.getWxProductId());
								isFollowup = 1;
							}
						LogUtil.log
								.warn("the 'infoState' is " + user.getInfoState() + ", userId is " + user.getUserId());
						if (StringUtils.isNotBlank(patient.getSourceDiseaseCode())) {
							if (patient.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
								patient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);// 完善个人资料，初级认证
							}
							LogUtil.log.warn(
									"the 'infoState' is " + user.getInfoState() + ", userId is " + user.getUserId());
							if (user.getInfoState() < Constant.User.INFOSTATE_PRIMARY) {// 完善基本信息
								user.setInfoState(Constant.User.INFOSTATE_PRIMARY);
								LogUtil.log.warn("the 'infoState' is " + user.getInfoState() + ", userId is "
										+ user.getUserId());
							}
						}

						// 生成诊断信息
						PatientDiagnosisReq req = null;
						// 判断是医生
						if (patientProfile.getSourceDiagnosisCreatorId() != null)
							req = new PatientDiagnosisReq(patient.getPatientId(), 1, 2,
									patientProfile.getSourceDiagnosisCreatorId());
						else
							req = new PatientDiagnosisReq(patient.getPatientId(), 1, 1, patient.getPatientId());
						for (SourceDiagnosisInfo sourceDiagnosisInfo : sourceDiagnosisInfoes) {
							if (sourceDiagnosisInfo.getSourceDiseaseCode() == patient.getSourceDiseaseCode())
								req.setIsSourceDiagnosis(1);
							else
								req.setIsSourceDiagnosis(0);
							req.setDiseaseTypeId(sourceDiagnosisInfo.getSourceDiseaseTypeId());
							req.setDiagnosis(sourceDiagnosisInfo.getSourceDiagnosis());
							req.setDiseaseCode(sourceDiagnosisInfo.getSourceDiseaseCode());
							req.setDisagnosisPeriodizationId(sourceDiagnosisInfo.getDisagnosisPeriodizationId());
							// 去掉部位
							// req.setDiseaseBodyPartId(Integer.parseInt(sourceDiagnosisInfo.getDiseaseBodyPartId()+""));
							req.setVisitTime(sourceDiagnosisInfo.getConfirmedDate());
							diagInnerService.createcreateDiagnosis(req);
						}
						// 生成诊断信息结束
					}
				}
			}
			loginByThirdPartyResp = this.patientService.modifyPatientProfile(userProfileModifyReq, user, patient);
			loginByThirdPartyResp.setIsFollowup(isFollowup);
		}
		// 修改医生信息
		else if (userProfile.getRole() == Constant.User.ROLE_DOCTOR) {
			Doctor doctor = this.doctorDao.findByUserId(user.getUserId());
			if (doctor == null) {
				throw new EmptyObjectExcption("\"Doctor\" is empty, userId is " + userProfile.getUserId() + "!");
			}
			loginByThirdPartyResp = this.doctorService.modifyDoctorProfile(userProfileModifyReq, user, doctor);
		}
		return loginByThirdPartyResp;
	}

	/**
	 * 修改用户账号信息
	 * 
	 * @param userProfile
	 * @param user
	 * @return
	 * @throws EmptyParamExcption
	 */
	public boolean modifyUserProfile(UserProfile userProfile, User user)
			throws EmptyParamExcption, RejectRequestExcption {
		Date nowTime = new Date();
		user.setTrueName(userProfile.getTrueName());
		user.setNickName(userProfile.getNickName());
		user.setSex(userProfile.getSex());
		user.setBirthDate(userProfile.getBirthDate());
		user.setMobile(userProfile.getMobile());
		user.setCity(userProfile.getCity());
		user.setCityCode(userProfile.getCityCode());
		user.setAddress(userProfile.getAddress());
		user.setSignature(userProfile.getSignature());
		user.setUserPictureUrl(userProfile.getUserPictureUrl());
		user.setIdFileUrl(userProfile.getIdFileUrl());
		user.setUpdateTime(nowTime);
		user.setBirthPlaceAddress(userProfile.getBirthPlaceAddress());
		userDao.updateUser(user);
		LogUtil.log.warn("Modify user information" + user.getInfoState() + ", userId is " + user.getUserId() + "!");
		return true;
	}

	/**
	 * 使用证件类型、证件号、角色查询用户 获取用户ID是否使用当前需要修改的账号
	 * 
	 * @param userProfile
	 * @return 可以修改 true；不可修改false
	 */
	public boolean verificationIdentification(UserProfile userProfile) {
		int count = -1;
		if (userProfile.getRole() == Constant.User.ROLE_PATIENT) {
			count = this.userDao.findByIdentificationCount(Constant.User.ROLE_PATIENT, userProfile.getIdType(),
					userProfile.getIdentification(), null, userProfile.getUserId());
		} else {
			count = this.userDao.findByIdentificationCount(Constant.User.ROLE_DOCTOR, userProfile.getIdType(),
					userProfile.getIdentification(), null, userProfile.getUserId());
		}
		LogUtil.log.debug("verificationIdentification:find IdType=" + userProfile.getIdType() + ",Identification="
				+ userProfile.getIdentification() + ",Role=" + userProfile.getRole() + ",Count=" + count + "!");
		if (count < 1) {
			return true;
		}
		return false;
	}

	public boolean verificationPreIdentification(UserProfile userProfile) {
		int count = -1;
		if (userProfile.getRole() == Constant.User.ROLE_PATIENT) {
			count = this.userDao.findByIdentificationCount(Constant.User.ROLE_PATIENT, userProfile.getIdType(),
					userProfile.getPreIdentification(), null, userProfile.getUserId());
		} else {
			count = this.userDao.findByIdentificationCount(Constant.User.ROLE_DOCTOR, userProfile.getIdType(),
					userProfile.getPreIdentification(), null, userProfile.getUserId());
		}
		LogUtil.log.debug("verificationIdentification:find IdType=" + userProfile.getIdType() + ",Identification="
				+ userProfile.getPreIdentification() + ",Role=" + userProfile.getRole() + ",Count=" + count + "!");
		if (count < 1) {
			return true;
		}
		return false;
	}

	/**
	 * @author Daloong 给医生端发出推送，通知有新患者
	 * @param doctorId
	 * @param patientId
	 */
	private void sendNotifyToDoctorForNewPatient(Long doctorUserId, Long patientUserId, String patientName) {
		try {
			if (patientUserId != null && doctorUserId != null && patientUserId > 0 && doctorUserId > 0) {
				String content = messageSource.getMessage("push.newpatient.todoctor", new Object[] { patientName },
						locale);
				PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForNewPatient(patientUserId, doctorUserId,
						content);
				pushInnerService.push(notifyInfo);
			}
		} catch (Exception e) {
			LogUtil.logError.error("sendNotifyToDoctorForNewPatient() failed: " + e.getMessage());
		}
	}

	/**
	 * 对原发诊断进行排序
	 * 
	 * @param patient
	 * @param sourceDiagnosisInfoes
	 * @return
	 */
	private List<SourceDiagnosisInfo> sourceDiagnosisInfoesSort(List<SourceDiagnosisInfo> sourceDiagnosisInfoes) {
		switch (sourceDiagnosisInfoes.size()) {
		case 2:
			if (sourceDiagnosisInfoes.get(0).getConfirmedDate()
					.compareTo(sourceDiagnosisInfoes.get(1).getConfirmedDate()) < 0) {
				Collections.reverse(sourceDiagnosisInfoes);
			}
			break;
		case 3:
			SourceDiagnosisInfo sourceDiagnosisInfo3 = sourceDiagnosisInfoes.remove(2);
			if (sourceDiagnosisInfoes.get(0).getConfirmedDate()
					.compareTo(sourceDiagnosisInfoes.get(1).getConfirmedDate()) < 0) {
				Collections.reverse(sourceDiagnosisInfoes);
			}
			ArrayList<SourceDiagnosisInfo> list = new ArrayList<SourceDiagnosisInfo>(3);
			boolean flag = true;
			for (int i = 0; i < 2; i++) {
				if (flag && sourceDiagnosisInfoes.get(i).getConfirmedDate()
						.compareTo(sourceDiagnosisInfo3.getConfirmedDate()) < 0) {
					list.add(sourceDiagnosisInfo3);
					flag = false;
				}
				list.add(sourceDiagnosisInfoes.get(i));
			}
			if (flag) {
				list.add(sourceDiagnosisInfo3);
				flag = false;
			}
			sourceDiagnosisInfoes = list;
			break;
		}
		return sourceDiagnosisInfoes;
	}

	/**
	 * 修改患者的原发诊断
	 * 
	 * @param patient
	 * @param index
	 * @return
	 */
	private Patient modifyPatientSourceDiagosis(Patient patient, SourceDiagnosisInfo sourceDiagnosisInfo) {
		if (sourceDiagnosisInfo == null) {
			return patient;
		}
		String targetSourceDiseaseCode = sourceDiagnosisInfo.getSourceDiseaseCode();
		if (StringUtils.isBlank(targetSourceDiseaseCode)) {
			return patient;
		}
		List<String> sourceDiseaseCodes = new ArrayList<String>(3);
		sourceDiseaseCodes.add(patient.getSourceDiseaseCode());
		sourceDiseaseCodes.add(patient.getSourceDiseaseCode2());
		sourceDiseaseCodes.add(patient.getSourceDiseaseCode3());
		int equalsIndex = StringUtil.matchEqualsFromList(targetSourceDiseaseCode, sourceDiseaseCodes);
		if (equalsIndex >= 0) {
			return patient;
		}
		int nullIndex = StringUtil.findNullIndexFromList(sourceDiseaseCodes);
		switch (nullIndex) {
		case 0:
			patient.setSourceDiagnosis(sourceDiagnosisInfo.getSourceDiagnosis());
			patient.setSourceDiseaseCode(targetSourceDiseaseCode);
			patient.setSourceDiseaseTypeId(sourceDiagnosisInfo.getSourceDiseaseTypeId());
			patient.setConfirmedDate(sourceDiagnosisInfo.getConfirmedDate());

			patient.setSourceDiagnosis2(null);
			patient.setSourceDiseaseCode2(null);
			patient.setSourceDiseaseTypeId2(null);
			patient.setConfirmedDate2(null);

			patient.setSourceDiagnosis3(null);
			patient.setSourceDiseaseCode3(null);
			patient.setSourceDiseaseTypeId3(null);
			patient.setConfirmedDate3(null);
			break;
		case 1:
			patient.setSourceDiagnosis2(sourceDiagnosisInfo.getSourceDiagnosis());
			patient.setSourceDiseaseCode2(targetSourceDiseaseCode);
			patient.setSourceDiseaseTypeId2(sourceDiagnosisInfo.getSourceDiseaseTypeId());
			patient.setConfirmedDate2(sourceDiagnosisInfo.getConfirmedDate());

			patient.setSourceDiagnosis3(null);
			patient.setSourceDiseaseCode3(null);
			patient.setSourceDiseaseTypeId3(null);
			patient.setConfirmedDate3(null);
			break;
		case 2:
			patient.setSourceDiagnosis3(sourceDiagnosisInfo.getSourceDiagnosis());
			patient.setSourceDiseaseCode3(targetSourceDiseaseCode);
			patient.setSourceDiseaseTypeId3(sourceDiagnosisInfo.getSourceDiseaseTypeId());
			patient.setConfirmedDate3(sourceDiagnosisInfo.getConfirmedDate());
			break;
		}
		return patient;
	}

	/**
	 * (非 Javadoc)
	 * <p>
	 * Title: selectUserProfileByUserId
	 * </p>
	 * <p>
	 * Description: 根据用户编号查询用户基本信息
	 * </p>
	 * 
	 * @param userId
	 * @return
	 * @throws EmptyParamExcption
	 * @see com.esuizhen.cloudservice.user.service.UserService#findUserProfileByUserId(java.lang.Long)
	 */

	@Override
	public UserProfileDetailResp getDetailUserProfile(Long userId, Integer role, Long relationId)
			throws EmptyParamExcption, EmptyObjectExcption {
		UserProfileDetailReq req = new UserProfileDetailReq();
		req.setUserId(userId);
		req.setRole(role);
		req.setRelationId(relationId);
		return getDetailUserProfile(req);
	}

	@Override
	public UserProfileDetailResp getDetailUserProfile(UserProfileDetailReq req)
			throws EmptyParamExcption, EmptyObjectExcption {
		if (req == null) {
			throw new EmptyParamExcption("\"param\" cannot be empty!");
		}
		if (req.getUserId() == null) {
			throw new EmptyParamExcption("\"userId\" cannot be empty!");
		}
		if (req.getRole() == null) {
			throw new EmptyParamExcption("\"role\" cannot be empty!");
		}
		UserProfileDetailResp profileDetailResp = new UserProfileDetailResp();
		UserProfile userProfile = userDao.findUserProfileByUserId(req.getUserId());
		if (userProfile == null) {
			throw new EmptyObjectExcption("\"User\" does not exist, userId is " + req.getUserId());
		}
		if (req.getRole() != null) {
			switch (req.getRole()) {
			case 1:
				PatientProfile patientProfile = this.patientDao.selectPatientProfileByUserId(req.getUserId(),
						req.getRelationId());
				if (patientProfile == null) {
					throw new EmptyObjectExcption("\"patient\" does not exist!");
				}
				// 获取一个病案号
				HospitalPatientBriefInfo hospitalPatientBriefInfo = this.hospitalPatientDao
						.findANotNullPatientNo(patientProfile.getPatientId(), req.getHospitalId());
				if (hospitalPatientBriefInfo != null) {
					patientProfile.setPatientNo(hospitalPatientBriefInfo.getPatientNo());
				}
				List<SourceDiagnosisInfo> sourceDiagnosisList = this.patientDao
						.findSourceDiagnosisInfoes(patientProfile.getPatientId());
				for (SourceDiagnosisInfo sourceDiagnosisInfo : sourceDiagnosisList) {
					if (null == sourceDiagnosisInfo.getConfirmedDate()) {
						try {
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							sourceDiagnosisInfo.setConfirmedDate(simpleDateFormat.parse("1900-01-01 00:00:00"));
						} catch (Exception e) {
						}
					}
				}
				patientProfile.setSourceDiagnosisList(sourceDiagnosisList);
				profileDetailResp.setPatientProfile(patientProfile);
				break;
			case 2:
				DoctorProfile doctorProfile = this.doctorDao.selectDoctorProfileByUserId(req.getUserId(),
						req.getRelationId(), serverWXServiceUrlRoot + defaultDoctorManUserPictureUrl,
						serverWXServiceUrlRoot + defaultDoctorWonmanUserPictureUrl);
				if (doctorProfile == null) {
					throw new EmptyObjectExcption("\"Doctor\" does not exist!");
				}
				String tagIds = doctorProfile.getTagIds();
				if (StringUtils.isNotBlank(tagIds)) {
					String tags = doctorProfile.getTags();
					String[] ids = tagIds.split(",");
					String[] ts = tags.split(",");
					int size = ids.length;
					if (size > ts.length) {
						size = ts.length;
					}
					List<DoctorTag> tagList = new ArrayList<DoctorTag>();
					for (int i = 0; i < size; i++) {
						String id = ids[i];
						if (ts[i] == null) {
							break;
						}
						DoctorTag doctorTag = new DoctorTag();
						doctorTag.setTagId(Long.parseLong(id));
						doctorTag.setTagName(ts[i]);

						tagList.add(doctorTag);
					}
					doctorProfile.setTagList(tagList);
				}
				profileDetailResp.setDoctorProfile(doctorProfile);
				break;
			}
		}
		UserStatisProfile statisProfile = this.getUserStatisProfile(userProfile, req.getRole());
		profileDetailResp.setUserProfile(userProfile);
		profileDetailResp.setStatisProfile(statisProfile);

		return profileDetailResp;
	}

	@Override
	public UserStatisProfile getUserStatisProfile(UserProfile userProfile, Integer role) {
		UserStatisProfile userStatisProfile = new UserStatisProfile();
		Integer questionnaireAnswerNum = 0, totalOrderNum = 0;
		TAccountInfo accountInfo = null;
		try {
			accountInfo = this.accountService.getAccountInfo(userProfile.getUserId(), role);
		} catch (Exception e) {

		}
		if (role == null) {
			role = userProfile.getRole();
		}
		if (role == Constant.User.ROLE_PATIENT) {
			questionnaireAnswerNum = this.patientDao.findQuestionnaireAnswerNum(userProfile.getUserId());
		}
		if (accountInfo != null) {
			totalOrderNum = accountInfo.getTotalOrderNum();
		}
		userStatisProfile.setTotalOrderNum(totalOrderNum);
		userStatisProfile.setQuestionnaireAnswerNum(questionnaireAnswerNum);
		if (role == Constant.User.ROLE_PATIENT) {
			userStatisProfile
					.setLatestFollowupResult(followupService.getLastFollowupResultByUserId(userProfile.getUserId()));
		}
		return userStatisProfile;
	}

	@Override
	public UserLoginOutResp queryUserInfoByTicket(String ticket) throws EmptyParamExcption, EmptyObjectExcption {
		TMsgResponse<UserLoginOutResp> tMsgResponse = new TMsgResponse<UserLoginOutResp>();
		if (StringUtils.isBlank(ticket)) {
			throw new EmptyParamExcption("String \"ticket\" cannot be empty!");
		}
		UserLoginOutResp userLoginOutResp = this.qrcodeDao.findUserLoginOutRespByTicket(ticket.trim());
		if (userLoginOutResp == null) {
			throw new EmptyObjectExcption("\"QRcode\" is null!");
		}
		tMsgResponse.setRespCode(ErrorMessage.SUCCESS.getCode());
		tMsgResponse.setRespMsg(messageSource.getMessage(ErrorMessage.SUCCESS.info, null, null));
		return userLoginOutResp;
	}

	/**
	 * 给患者端发出推送，当患者完善疾病信息时推送与患者相关的疾病知识
	 * 
	 * @param patientId
	 */
	private void sendNotifyToPatientForPerfectInformation(Long patientUserId) {
		try {
			if (patientUserId != null && patientUserId > 0) {
				String content = messageSource.getMessage("push.patient.knowledge.ofdisease", null, locale);
				PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(patientUserId, content);
				pushInnerService.push(notifyInfo);
			}
		} catch (Exception e) {
			LogUtil.logError.error("sendNotifyToPatientForPerfectInformation() failed:" + e.getMessage());
		}
	}

	/**
	 * 患者跳过完善疾病信息页
	 * 
	 * @param patientUserId
	 */
	private void sendNotifyToPatientForSkipPush(Long patientUserId) {
		try {
			if (patientUserId != null && patientUserId > 0) {
				List<ThirdParty> thirdParties = this.thirdPartyDao.findByUserId(patientUserId);
				if (thirdParties == null || thirdParties.isEmpty()) {
					return;
				}
				String link = serverH5UrlRoot + patientFollowupFollow + "?fromUserName="
						+ thirdParties.get(0).getOpenId();
				PushContent pushContent = PushContentUtil.getUserPushContent("2",
						"push.patient.continue.improve.disease.information.tips", link);
				String content = pushInnerService.getMessage(pushContent);
				PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(patientUserId, content);
				pushInnerService.push(notifyInfo);
			}
		} catch (Exception e) {
			LogUtil.logError.error("sendNotifyToPatientForOpenFollowupPlan() failed:" + e.getMessage());
		}
	}

	/**
	 * 确认是否本人
	 * 
	 * @throws BindingDataExcption
	 * @throws ObjectAlreadyExistExcption
	 */
	@Override
	public TConfirmUserResp confirmUserInfo(TConfirmUserReq confirmUserReq)
			throws EmptyParamExcption, RemoteCallExcption, BindingDataExcption, ObjectAlreadyExistExcption {
		TConfirmUserResp resp = null;
		if (Const.MATCHTYPE_WXFUSE == confirmUserReq.getMatchType()) {// 微信融合
			resp = this.txUserService.wxFuse(confirmUserReq);
		} else {// 合并ToB导入的患者信息
			resp = this.txUserService.confirmInfo(confirmUserReq);
			if (Constant.User.ROLE_PATIENT == confirmUserReq.getUserRole() && confirmUserReq.getIsConfirmed() == 1) {
				ThirdParty thirdParty = thirdPartyDao.searchThirdPartyByOpenId(confirmUserReq.getOpenId());
				Patient patient = this.patientDao.findByUserId(thirdParty.getUserId());
				Integer wxProductId = Constant.Push.WEIXIN_BIND_DEFAULT_PRODUCT_ID;
				if (StringUtils.isNotEmpty(confirmUserReq.getOpenId())) {
					ThirdParty thirdPart = thirdPartyDao.searchThirdPartyByOpenId(confirmUserReq.getOpenId());
					if (thirdPart != null && thirdPart.getProductId() != null)
						wxProductId = thirdPart.getProductId();
				}
				this.patientService.supplementaryFollowupPlan(patient, wxProductId);
			}
		}
		return resp;
	}

	/**
	 * 
	 * @param userId
	 * @return
	 */
	private boolean generateQRCode(Long userId) {
		// 审核通过获取二维码
		WeixinQRReq weixinQRReq = new WeixinQRReq();
		weixinQRReq.setBusinessId(1);
		weixinQRReq.setProductId(2);
		weixinQRReq.setUserId(userId);
		weixinQRReq.setUserRole(2);

		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");
		String weixinQRJson = HttpUtil.postString(serverUrlRoot + pushWeixinQrGetUrl, JsonUtil.toJson(weixinQRReq),
				"utf-8", headerMap);
		TMsgResponse<LinkedTreeMap<String, Object>> tMsgResponse = JsonUtil.toObject(weixinQRJson, TMsgResponse.class);
		Map<String, Object> weixinQRMap = (Map<String, Object>) tMsgResponse.getResult();
		QRCode qrCode = new QRCode();
		qrCode.setUserRole(Constant.User.ROLE_DOCTOR);
		qrCode.setQrcodeUrl((String) weixinQRMap.get("QRUrl"));
		qrCode.setTicket((String) weixinQRMap.get("ticket"));
		qrCode.setTargetId((String) weixinQRMap.get("targetId"));
		qrCode.setBusinessId(1);
		qrCode.setProductId(2);
		qrCode.setUserId(userId);
		String ticketId = weixinQRMap.get("ticketId").toString();
		int index = ticketId.indexOf(".");
		if (index > 0) {
			ticketId = ticketId.substring(0, index);
		}
		qrCode.setTicketId(Long.parseLong(ticketId));
		QRCode oldQRCode = this.qrcodeDao.findByUserId(userId, Constant.User.ROLE_DOCTOR);
		if (oldQRCode != null) {
			this.qrcodeDao.delete(oldQRCode.getId());
		}
		oldQRCode = this.qrcodeDao.findByTicket(qrCode.getTicket());
		if (oldQRCode != null) {
			this.qrcodeDao.delete(oldQRCode.getId());
		}
		this.qrcodeDao.insert(qrCode);
		// 向随诊助手发送推送
		this.pushImMessageSuizhenAssist(userId, Constant.User.AUDITSTATE_PRIMARYPASS, qrCode.getQrcodeUrl());
		return true;
	}

	/**
	 * 医生二维码生成，推送消息
	 * 
	 * @param doctorUserId
	 * @param auditState
	 */
	private boolean pushImMessageSuizhenAssist(Long doctorUserId, Integer auditState, String qrCodePath) {
		try {
			if (doctorUserId != null && doctorUserId > 0) {
				String content = null;
				String tipText = null;
				ImMessageInfo im = null;
				switch (auditState) {
				case 2:
					tipText = messageSource.getMessage("push.tips.audit.doctor.basepass", null, locale);
					List<String> picUrls = new ArrayList<String>(1);
					picUrls.add(qrCodePath);
					content = ImMessageUtil.getPicTextMessage(
							messageSource.getMessage("push.suizhenassist.audit.doctor.basepass", null, locale),
							picUrls);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					im.setContentType(101);
					break;
				case 4:
					tipText = messageSource.getMessage("push.tips.audit.doctor.advpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.advpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				case -1:
					tipText = messageSource.getMessage("push.tips.audit.doctor.basenotpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.basenotpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				case -2:
					tipText = messageSource.getMessage("push.tips.audit.doctor.advnotpass", null, locale);
					content = messageSource.getMessage("push.suizhenassist.audit.doctor.advnotpass", null, locale);
					im = ImMessageUtil.getEDoctorAssistTextMessage(doctorUserId, content, tipText);
					break;
				}
				this.messageInnerService.sendInnerMessage(im);
				return true;
			}
		} catch (Exception e) {
			LogUtil.logError.error("sendNotifyToPatientForOpenFollowupPlan() failed:" + e.getMessage());
		}
		return false;
	}

	/**
	 * 
	 * @Title: auditDoctorSmsContentSend @Description: 向医生发送短信 @param @param
	 *         mobile 医生手机号 @param @param auditState 审核状态 @return void
	 *         返回类型 @throws
	 */
	private boolean auditDoctorSmsContentSend(String mobile, Integer auditState) {
		SmsContentSendReq smsContentSendReq = new SmsContentSendReq();
		smsContentSendReq.setBusinessId(1);
		smsContentSendReq.setProductId(1);
		List<String> mobiles = new ArrayList<String>();
		mobiles.add(mobile);
		smsContentSendReq.setMobiles(mobiles);
		String mobileContent = null;
		switch (auditState) {
		case -2:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.m2", null, locale);
			break;
		case -1:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.m1", null, locale);
			break;
		case 2:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.2", null, locale);
			break;
		case 4:
			mobileContent = messageSource.getMessage("doctor.audit.mobile.send.4", null, locale);
			break;
		}
		smsContentSendReq.setContent(mobileContent);
		try {
			this.smsInnerService.sendContent(smsContentSendReq);
		} catch (Exception e) {
			LogUtil.log.debug("给医生" + mobile + "发送短信出错！" + e.getMessage());
		}
		return true;
	}

	public void mergeToBPatientUserInfo(User user, User tobUser) {
		if (tobUser == null) {
			return;
		}
		// 处理uuid
		if (StringUtils.isEmpty(user.getUuid())) {
			user.setUuid(tobUser.getUuid());
		}
		// 处理真实姓名
		if (StringUtils.isNotEmpty(tobUser.getTrueName()) && !tobUser.getTrueName().equals(user.getTrueName())) {
			user.setTrueName(tobUser.getTrueName());
		}
		// 处理性别
		if (tobUser.getSex() != null && tobUser.getSex() != 0 && (user.getSex() == null || user.getSex() == 0)) {
			user.setSex(tobUser.getSex());
		}
		// 处理国籍
		if (StringUtils.isNotEmpty(tobUser.getCountry()) && StringUtils.isEmpty(user.getCountry())) {
			user.setCountry(tobUser.getCountry());
		}
		// 处理城市
		if (StringUtils.isNotEmpty(tobUser.getCity()) && StringUtils.isEmpty(user.getCity())) {
			user.setCity(tobUser.getCity());
		}
		// 处理籍贯
		if (StringUtils.isNotEmpty(tobUser.getNativePlace()) && StringUtils.isEmpty(user.getNativePlace())) {
			user.setNativePlace(tobUser.getNativeplace());
		}
		// 处理民族
		if (StringUtils.isNotEmpty(tobUser.getNation()) && StringUtils.isEmpty(user.getNation())) {
			user.setNation(tobUser.getNation());
		}
		// 处理职业
		if (StringUtils.isNotEmpty(tobUser.getProfession()) && StringUtils.isEmpty(user.getProfession())) {
			user.setProfession(tobUser.getProfession());
		}
		// 出生日期
		if (user.getBirthDate() == null && tobUser.getBirthDate() != null) {
			user.setBirthDate(tobUser.getBirthDate());
		}
		// 证件号
		if (StringUtils.isNotEmpty(tobUser.getIdentification()) && StringUtils.isEmpty(user.getIdentification())) {
			if (tobUser.getIdType() == null) {
				tobUser.setIdType(Constant.User.IDTYPE_ID);
			}
			user.setIdType(tobUser.getIdType());
			user.setIdentification(tobUser.getIdentification());
		}
		// user.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		user.setSyncFlag(Constant.User.SYNCFLAG_YES);
		this.userDao.updateByPrimaryKey(user);
	}

	public void initUserCity() {
		ExecutorService exec = Executors.newFixedThreadPool(1);

		Runnable run = new Runnable() {
			@Override
			public void run() {
				List<LinkedHashMap<String, Object>> list = userDao.queryNotHasCityUser();
				while (!list.isEmpty()) {
					int i = 0;
					while (i < 100) {
						if (list.isEmpty()) {
							break;
						}
						LinkedHashMap<String, Object> map = list.get(0);
						LogUtil.log.debug("-----------------" + map.get("userId"));
						initUserCity((Long) map.get("userId"), (String) map.get("openId"),
								(Integer) map.get("businessId"), (Integer) map.get("productId"));
						list.remove(0);
						i++;
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

			// 加载用户城市
			private void initUserCity(Long userId, String openId, Integer businessId, Integer productId) {
				WeixinUserGetReq req = new WeixinUserGetReq();
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("userId", userId);
				param.put("cityId", 0);
				req.setBusinessId(businessId);
				req.setProductId(productId);
				req.setOpenId(openId);
				try {
					WeixinUserInfo info = weixinInnerService.getUser(req);
					String cityName = "";
					if (StringUtils.isNotEmpty(info.getCity()) && StringUtils.isNotEmpty(info.getProvince())) {
						if (StringUtils.isNotEmpty(info.getCity()))
							cityName = info.getCity();
						else if (StringUtils.isNotEmpty(info.getProvince()))
							cityName = info.getProvince();
						else if (StringUtils.isNotEmpty(info.getCountry()))
							cityName = info.getCountry();
					}
					param.put("cityName", cityName);
					if (StringUtils.isNotEmpty(cityName))
						if (userDao.modifyUserCity(param) == 0) {
							userDao.insertUserCity(param);
						}
				} catch (Exception e) {
					LogUtil.logError.error("update user city error ------------------- userId:" + userId
							+ " -------------errorMessage:" + e.getMessage());
				}
			}
		};
		exec.execute(run);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public TMsgResponse<Object> cancelUserAttention(Long userId, String fromUserName) {
		// TODO Auto-generated method stub
		TMsgResponse<Object> msg = new TMsgResponse<Object>();
		try {
			if (userId == null || fromUserName == null) {
				throw new EmptyParamExcption();
			}
			msg.respCode = ErrorMessage.SUCCESS.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
			// 设置第三方登录表 状态为-2
			if (userDao.settingThridCancelTime(fromUserName, userId, -2) == 0) {
				// 说明userId与openId不符
				throw new ObjectNotAvailableExcption();
			}
			// 如果全部取关注设置用户下线
			if (userDao.findOpenIdTotalByUserId(userId) == 0) {
				User user = userDao.findByUserId(userId);
				// 设为下线
				user.setState(Constant.User.USERSTATE_LOCKED);
				userDao.updateLastLogin(user);
			}
			// 添加操作日志
			OperationHistory operationHistory = new OperationHistory();
			operationHistory.setOperatorId(userId);
			operationHistory.setOperationName("cancelUserAttention");
			operationHistory.setDescription(" cancelUserAttention userId = " + userId + "  openId=" + fromUserName);
			operationHistory.setActionType(3);
			operationHistory.setCreateTime(new Date());
			operationHistoryDao.insert(operationHistory);
		} catch (EmptyParamExcption e) {
			msg.respCode = ErrorMessage.E1400.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1400.info, null, locale);
		} catch (EmptyObjectExcption e) {
			msg.respCode = ErrorMessage.E1402.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1402.info, null, locale);
		} catch (ObjectNotAvailableExcption e) {
			msg.respCode = ErrorMessage.E1403.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1403.info, null, locale);
		} catch (Exception e) {
			msg.respCode = ErrorMessage.E1401.code;
			msg.respMsg = messageSource.getMessage(ErrorMessage.E1401.info, null, locale);
		}
		return msg;
	}

	// 退出登录
	@Override
	public void loginout(UserLoginOutReq req) {
		// TODO Auto-generated method stub
		pushDao.removeBind(req);
		userDao.updateLastLoginOut(req);
	}
	
	@Override
	public void addOperationHistory(OperationHistory operationHistory) {
		// 添加操作日志
		operationHistoryDao.insert(operationHistory);
	}
	/**
	 * add by fanpanwei
	 */
	public List<HashMap<String,Object>> getOperationHistory(OperationHistory operationHistory){
		List<HashMap<String, Object>> historyList = operationHistoryDao.getOperationHistory(operationHistory);
		if(historyList!=null&&historyList.size()!=0&&historyList.get(0)!=null){
			String key=null;
			String value=null;
			for (HashMap<String, Object> hm : historyList) {
				Object jsonObj = hm.get("description");
		        if(jsonObj!=null){
			        String jsonstr = jsonObj.toString();
			        try
			        {
			        	JSONObject parseObject = JSONObject.parseObject(jsonstr);
			        	if(parseObject==null)continue;
			            Set<String> keySet = parseObject.keySet();
			            if(keySet==null||keySet.size()==0)continue;
			            Iterator<String> iterator = keySet.iterator();
			            while(iterator.hasNext()){
			            	key = (String) iterator.next();
			            	value = parseObject.getString(key);
			            	hm.put(key, value);
			            }
			        }
			        catch (Exception e)
			        {//"json格式有误"
			        	continue;
			        }
		        }
			}
		}
		
		return historyList;
	}
}
