/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service.impl<br/>  
 * <b>文件名：</b>PatientServiceImpl.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-下午6:46:24<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.esuizhen.base.service.organization.OrganizationDoctorService;
import com.esuizhen.cloudservice.user.bean.AutiCancerLinkManContact;
import com.esuizhen.cloudservice.user.bean.AutiCancerPatientInfo;
import com.esuizhen.cloudservice.user.bean.AutiCancerTreatmentsInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientApproveInfo;
import com.esuizhen.cloudservice.user.bean.AutiPatientListResp;
import com.esuizhen.cloudservice.user.bean.AutiPatientReq;
import com.esuizhen.cloudservice.user.bean.GeneticDiseaseContact;
import com.esuizhen.cloudservice.user.bean.MedicalRecordPatientCreateReq;
import com.esuizhen.cloudservice.user.bean.PatientBaseDataStatistics;
import com.esuizhen.cloudservice.user.bean.PatientCreateByMobileReq;
import com.esuizhen.cloudservice.user.bean.PatientHospitalCertificateConfirmReq;
import com.esuizhen.cloudservice.user.bean.PatientHospitalCertificateReq;
import com.esuizhen.cloudservice.user.bean.PatientKeywordSearchReq;
import com.esuizhen.cloudservice.user.bean.PatientNoListReq;
import com.esuizhen.cloudservice.user.bean.PatientProfileDetailReq;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseReq;
import com.esuizhen.cloudservice.user.bean.SpecialDiseaseResp;
import com.esuizhen.cloudservice.user.bean.UserInfo;
import com.esuizhen.cloudservice.user.bean.followuppatient.TPatientSearchInfo;
import com.esuizhen.cloudservice.user.common.Const;
import com.esuizhen.cloudservice.user.dao.ConfHospitalWXDao;
import com.esuizhen.cloudservice.user.dao.DiagnosisInfoDao;
import com.esuizhen.cloudservice.user.dao.DoctorDao;
import com.esuizhen.cloudservice.user.dao.DoctorPatientDao;
import com.esuizhen.cloudservice.user.dao.FamilyGeneticHistoryDao;
import com.esuizhen.cloudservice.user.dao.HospitalDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientCertificatedHistoryDao;
import com.esuizhen.cloudservice.user.dao.HospitalPatientDao;
import com.esuizhen.cloudservice.user.dao.MetaCDiseaseTypeDao;
import com.esuizhen.cloudservice.user.dao.MetaEicd10Dao;
import com.esuizhen.cloudservice.user.dao.MetaRDiseaseTypeIcd10Dao;
import com.esuizhen.cloudservice.user.dao.OperationHistoryDao;
import com.esuizhen.cloudservice.user.dao.PatientDao;
import com.esuizhen.cloudservice.user.dao.PatientFamilyDao;
import com.esuizhen.cloudservice.user.dao.PatientGroupMembersDao;
import com.esuizhen.cloudservice.user.dao.PatientSpecialDiseaseRegisterDao;
import com.esuizhen.cloudservice.user.dao.SpecialDiseaseApprovalDao;
import com.esuizhen.cloudservice.user.dao.ThirdPartyDao;
import com.esuizhen.cloudservice.user.dao.UserDao;
import com.esuizhen.cloudservice.user.dao.VarPatientDoctorMedicalDao;
import com.esuizhen.cloudservice.user.model.HospitalPatientCertificatedHistory;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.esuizhen.cloudservice.user.model.PatientHospitalCertificateInfo;
import com.esuizhen.cloudservice.user.model.TPatientNoInfo;
import com.esuizhen.cloudservice.user.service.DoctorPatientService;
import com.esuizhen.cloudservice.user.service.DoctorService;
import com.esuizhen.cloudservice.user.service.ExportUtilService;
import com.esuizhen.cloudservice.user.service.HospitalPatientService;
import com.esuizhen.cloudservice.user.service.PatientFamilyService;
import com.esuizhen.cloudservice.user.service.PatientService;
import com.esuizhen.cloudservice.user.service.UserService;
import com.esuizhen.cloudservice.user.service.UuidRelationshipService;
import com.esuizhen.common.util.match.MatchMergeUtil;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.DoctorPatient;
import com.westangel.common.bean.DoctorProfile;
import com.westangel.common.bean.DoctorSimpleInfo;
import com.westangel.common.bean.HospitalProfile;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.PatientProfile;
import com.westangel.common.bean.PatientProfileDetailResp;
import com.westangel.common.bean.PatientSimpleInfo;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.bean.ThirdParty;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.bean.ehr.DiagnosisInfo;
import com.westangel.common.bean.ehr.MetaCDiseaseType;
import com.westangel.common.bean.ehr.MetaEicd10;
import com.westangel.common.bean.ehr.MetaRDiseaseTypeIcd10;
import com.westangel.common.bean.message.ImChatMemberInfo;
import com.westangel.common.bean.message.ImMessageInfo;
import com.westangel.common.bean.message.structuration.TButtonItemInfo;
import com.westangel.common.bean.message.structuration.TButtonMsg;
import com.westangel.common.bean.message.structuration.TStructuredMsg;
import com.westangel.common.bean.push.PushContent;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sms.SmsTemplateSendReq;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.bean.user.ConfHospitalWX;
import com.westangel.common.bean.user.HospitalPatientBriefInfo;
import com.westangel.common.bean.user.PatientFamily;
import com.westangel.common.bean.user.ServiceSubscriptionInfo;
import com.westangel.common.bean.user.TRDoctor;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.ParamFormatErrorExcption;
import com.westangel.common.excption.ParamMismatchExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.excption.VerifyFailureExcption;
import com.westangel.common.service.FollowupService;
import com.westangel.common.service.MessageInnerService;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.service.SmsInnerService;
import com.westangel.common.util.Codec;
import com.westangel.common.util.DateUtil;
import com.westangel.common.util.GeneralUtil;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.ImMessageUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;
import com.westangel.common.util.PushContentUtil;
import com.westangel.common.util.PushUtil;
import com.westangel.common.util.SmsUtil;

/** 
* @ClassName: PatientServiceImpl 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月3日 下午6:46:24  
*/
@Service(value = "patientService")
public class PatientServiceImpl implements PatientService, com.westangel.common.service.PatientService {
	private Locale locale = Locale.getDefault();
	
	@Autowired
	private ExportUtilService exportUtilService;
	@Autowired
	private PushInnerService pushInnerService;
	@Autowired
	private MessageSource messageSource;
	@Autowired
	public PatientDao patientDao;
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	public DoctorDao doctorDao;
	@Autowired
	public UserDao userDao;
	@Autowired
	public DoctorPatientDao doctorPatientDao;
	@Autowired
	public OperationHistoryDao operationHistoryDao;
	@Autowired
	private HospitalPatientDao hospitalPatientDao;
	@Autowired
	private ThirdPartyDao thirdPartyDao;
	@Autowired
	private MetaCDiseaseTypeDao metaCDiseaseTypeDao;
	@Autowired
	private VarPatientDoctorMedicalDao varPatientDoctorMedicalDao;
	@Autowired
	private MetaRDiseaseTypeIcd10Dao metaRDiseaseTypeIcd10Dao;
	@Autowired
	private MetaEicd10Dao metaEicd10Dao;
	@Autowired
	private DiagnosisInfoDao diagnosisInfoDao;
	@Autowired
	private ConfHospitalWXDao confHospitalWXDao;
	@Autowired
	private PatientGroupMembersDao patientGroupMembersDao;
	@Resource(name="followupService")
	private FollowupService followupService;

	@Autowired
	private SmsInnerService smsInnerService;
	@Autowired
	private MessageInnerService messageInnerService;
	@Autowired
	private UserService userService;
	@Autowired
	private PatientFamilyService patientFamilyService;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private HospitalPatientService hospitalPatientService;
	@Autowired
	private DoctorPatientService doctorPatientService;
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientFamilyDao patientFamilyDao;
	@Autowired
	private FamilyGeneticHistoryDao familyGeneticHistoryDao;
	@Autowired
	private SpecialDiseaseApprovalDao specialApprovalDao;
	
	@Autowired
	private MatchMergeUtil matchMergeUtil;
	
	@Autowired
	private HospitalPatientCertificatedHistoryDao hospitalPatientCertificatedHistoryDao;
	@Autowired
	private OrganizationDoctorService organizationDoctorService;
	
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${url.api.business.doctor.inite.patient.do.something}")
	private String patientDoSomething;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${url.h5.user.my.doctor}")
	private String myDoctor;
	@Value("${server.h5.patient.followup.follow}")
	private String followupPage;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;
	@Value("${sync.confirm}")
	private String syncConfirm;
	
	@Autowired
	private PatientSpecialDiseaseRegisterDao specialDiseaseRegisterDao;
	

	/**(非 Javadoc) 
	* <p>Title: serarchPatient</p> 
	* <p>Description: 根据用户编号查询患者信息</p> 
	* @param userId
	* @return 
	* @see com.esuizhen.cloudservice.user.service.PatientService#serarchPatient(java.lang.Long) 
	*/
	@Override
	public Patient serarchPatient(Long userId) {
		return patientDao.findByUserId(userId);
	}

	/**(非 Javadoc) 
	* <p>Title: savePatient</p> 
	* <p>Description: 患者信息保存</p> 
	* @param patient
	* @return 
	* @see com.esuizhen.cloudservice.user.service.PatientService#savePatient(com.esuizhen.cloudservice.user.model.Patient) 
	*/
	@Override
	public boolean savePatient(Patient patient) {
		return patientDao.insert(patient) > 0;
	}

	/**(非 Javadoc) 
	* <p>Title: searchPatientById</p> 
	* <p>Description: </p> 
	* @param patientId
	* @return 
	* @see com.esuizhen.cloudservice.user.service.PatientService#searchPatientById(java.lang.Long) 
	*/
	@Override
	public PatientProfileDetailResp searchPatientById(PatientProfileDetailReq req) {
		PatientProfile patientProfile = patientDao.selectPatientProfileByPatientId(req.getPatientId(), req.getDoctorId());
		if (patientProfile != null) {
			patientProfile.setSourceDiagnosisList(this.patientDao.findSourceDiagnosisInfoes(patientProfile.getPatientId()));
			PatientProfileDetailResp patientProfileDetailResp = new PatientProfileDetailResp();
			patientProfileDetailResp.setPatientProfile(patientProfile);
			Long userId = patientProfile.getUserId();
			UserProfile userProfile = userDao.findUserProfileByUserId(userId);
			patientProfileDetailResp.setUserProfile(userProfile);
			//获取一个病案号
			HospitalPatientBriefInfo hospitalPatientBriefInfo = this.hospitalPatientDao.findANotNullPatientNo(patientProfile.getPatientId(),req.getHospitalId());
			if (hospitalPatientBriefInfo != null) {
				if(StringUtils.isNotEmpty(hospitalPatientBriefInfo.getPatientNo())){
					patientProfile.setPatientNo(hospitalPatientBriefInfo.getPatientNo());
					patientProfileDetailResp.setPatientProfile(patientProfile);
				}
			}
			return patientProfileDetailResp;
		}else{
			return null;
		}
	}

	/**(非 Javadoc) 
	* <p>Title: searchPatientSimpleInfo</p> 
	* <p>Description: 分页查询患者信息列表</p> 
	* @param doctorId
	* @param reqFlag
	* @param page
	* @param num
	* @return 
	 * @throws EmptyParamExcption 
	* @see com.esuizhen.cloudservice.user.service.PatientService#searchPatientSimpleInfo(java.lang.Long, java.lang.Integer, java.lang.Integer, java.lang.Integer) 
	*/
	@SuppressWarnings("unchecked")
	@Override
	public Page<PatientSimpleInfo> searchPatientSimpleInfoList(Long doctorId, String patientName, Integer reqFlag, Integer page, Integer num) throws EmptyParamExcption {
		if (doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		String sql = organizationDoctorService.getPatientSql(doctorId, null);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("sql", sql);
		param.put("doctorId", doctorId);
		param.put("patientName", patientName);
		param.put("reqFlag", reqFlag);
		if (page == null || page < 0) {
			page = 0;
		}
		if (num == null || num < 1) {
			num = 10;
		}
		PageHelper.startPage(page + 1, num);
		List<PatientSimpleInfo> list = this.patientDao.searchPatientSimpleInfoList(param);
		return PageUtil.returnPage((com.github.pagehelper.Page<PatientSimpleInfo>)list);
	}

	/**(非 Javadoc) 
	* <p>Title: createPatientByMobile</p> 
	* <p>Description: </p> 
	* @param patientCreateByMobileReq 
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParamFormatErrorExcption 
	* @see com.esuizhen.cloudservice.user.service.PatientService#createPatientByMobile(com.esuizhen.cloudservice.user.bean.PatientCreateByMobileReq) 
	*/
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Object createPatientByMobile(PatientCreateByMobileReq req) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption {
		req.setSourceFlag(Constant.User.USERSOURCEFLAG_DOCTOR);
		Map<String,Object> map = new HashMap<String,Object>();
		String message;
		// 判断用户是否存在主动
		User user = userDao.findByUserName(req.getMobile(), Constant.User.ROLE_PATIENT);
		if(user==null){//判断是否存在被动患者
			user = userDao.findByMobile(false, req.getMobile(), Constant.User.ROLE_PATIENT);
		}
		Date nowTime = new Date();
		if (user == null) {
			user = new User();
			user.setUserName(req.getMobile()); // 用户名称
			user.setTrueName(req.getTrueName());// 真实姓名
			user.setMobile(req.getMobile());// 电话
			user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
			user.setAccountType(Constant.User.ACCOUNTTYPE_NONACTIVATED);// 普通账号
			user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);// 未完善个人信息
			user.setState(Constant.User.USERSTATE_NORMAL);// 正常
			user.setRole(Constant.User.ROLE_PATIENT);// 患者
			user.setSyncFlag(Constant.User.SYNCFLAG_YES);//同步
			user.setCreateTime(nowTime);
			user.setSourceFlag(req.getSourceFlag());
			user.setPoints(0);
			userDao.insert(user);
			map.put("userId", user.getUserId());
			// 插入患者信息
			// 查询患者是否存在
			Patient patient = patientDao.searchPatientByMobile(req.getMobile());
			if (patient == null) {
				patient = new Patient();
				patient.setUserId(user.getUserId());// 用户编号
				patient.setTrueName(req.getTrueName());// 真实姓名
				patient.setMobile(req.getMobile());// 手机号
				patient.setLiveStatus(Constant.User.LIVESTATUS_ALIVE);// 生存状态
				patient.setSourceDiseaseCode(req.getSourceDiseaseCode()); // 原发诊断编码
				patient.setSourceDiagnosis(req.getSourceDiagnosis()); // 原发诊断
				patient.setHasVisibleMedicalRecord(0);//是否有病历
				patient.setSyncFlag(Constant.User.SYNCFLAG_YES);//同步
				patient.setPatientRelation(0);//本人
				patient.setCreateTime(nowTime);
				patientDao.insert(patient);
				map.put("patientId", patient.getPatientId());
			}
			// 插入医生与患者关系表
			this.createPatientOfDoctorRelation(req.getDoctorId(), patient.getPatientId(), req.getSourceFlag());
			sendToFollowupPatient(req.getDoctorId(),req.getMobile());
		}else{
			map.put("userId", user.getUserId());
			//找到患者
			Patient patient = patientDao.findByUserId(user.getUserId());
			map.put("patientId", patient.getPatientId());
			//查看是否存在医患关系
			DoctorPatient docpatient = doctorPatientDao.searchDoctorPatient(patient.getPatientId(),req.getDoctorId());
			if(docpatient==null){//判断不存在医患关系
				
				//创建医患关系
				this.createPatientOfDoctorRelation(req.getDoctorId(), patient.getPatientId(), req.getSourceFlag());
				
				//微信判断
				String openId = userDao.findUserOpenId(user.getUserId());
				
				//关注微信
				if(openId!=null||user.getAccountType()==Constant.User.ACCOUNTTYPE_WEIXINBINDPHONE){//已关注
					message = messageSource.getMessage("push.by.mobile.create.patient.haswx.alert.message", null, locale);
				}else{//未关注
					message = messageSource.getMessage("push.by.mobile.create.patient.com.Tob.message", null, locale);
					sendToFollowupPatient(req.getDoctorId(),req.getMobile());
				}
				map.put("message", message);
			}
		}
		return map;
	}
	
	private void sendToFollowupPatient(Long doctorId,String patientMobile){
		SmsTemplateSendReq req = SmsUtil.getSmsTemplateSendReq("ShouDongTianJiaSuiFanHuanZhe", patientMobile, null);
		Doctor doctor = doctorDao.selectByPrimaryKey(doctorId);
		req.getValues().add(doctor.getTrueName());
		smsInnerService.sendTemplate(req);
	}
	/**(非 Javadoc) 
	* <p>Title: createPatientByMedicalRecord</p> 
	* <p>Description: </p> 
	* @param medicalRecordPatientCreateReq 
	 * @throws ObjectNotAvailableExcption 
	 * @throws ParamFormatErrorExcption 
	* @see com.esuizhen.cloudservice.user.service.PatientService#createPatientByMedicalRecord(com.esuizhen.cloudservice.user.bean.MedicalRecordPatientCreateReq) 
	*/
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean createPatientByMedicalRecord(MedicalRecordPatientCreateReq medicalRecordPatientCreateReq) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption {
		if (medicalRecordPatientCreateReq.getSourceFlag() == null) {
			throw new EmptyParamExcption("\"sourceFlag\" is empty!");
		}
		// 判断用户是否存在
		User user = userDao.findByUserName(medicalRecordPatientCreateReq.getMobile(), Constant.User.ROLE_PATIENT);
		if (user == null) {
			Date nowTime = new Date();
			user = new User();
			user.setUserName(medicalRecordPatientCreateReq.getMobile()); // 用户名称
			user.setTrueName(medicalRecordPatientCreateReq.getTrueName());// 真实姓名
			user.setMobile(medicalRecordPatientCreateReq.getMobile());// 电话
			user.setCryptPasswd(Codec.hexMD5(GeneralUtil.getCaptchaNum()));
			user.setAccountType(Constant.User.ACCOUNTTYPE_NONACTIVATED);// 普通账号
			user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);// 未完善个人信息
			user.setState(Constant.User.USERSTATE_NORMAL);// 正常
			user.setRole(Constant.User.ROLE_PATIENT);// 患者
			user.setCreateTime(nowTime);
			userDao.insert(user);
			// 插入患者信息
			// 查询患者是否存在
			Patient patient = patientDao.searchPatientByMobile(medicalRecordPatientCreateReq.getMobile());
			if (patient == null) {
				patient = new Patient();
				patient.setUserId(user.getUserId());// 用户编号
				patient.setTrueName(medicalRecordPatientCreateReq.getTrueName());// 真实姓名
				patient.setMobile(medicalRecordPatientCreateReq.getMobile());// 手机号
				patient.setLiveStatus(Constant.User.LIVESTATUS_ALIVE);// 生存状态
				patient.setSourceDiseaseCode(medicalRecordPatientCreateReq.getSourceDiseaseCode()); // 原发诊断编码
				patient.setSourceDiagnosis(medicalRecordPatientCreateReq.getSourceDiagnosis()); // 原发诊断
				patient.setConfirmedDate(medicalRecordPatientCreateReq.getConfirmedDate());// 首次确诊日期
				patient.setCreateTime(nowTime);// 创建时间
				patientDao.insert(patient);
			}
			// 插入医生与患者关系表
			this.createPatientOfDoctorRelation(medicalRecordPatientCreateReq.getDoctorId(), patient.getPatientId(), medicalRecordPatientCreateReq.getSourceFlag());
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientSimpleInfo> searchPatientBykeyword(PatientKeywordSearchReq patientKeywordSearchReq) {
		// 默认返回100个记录
		PageHelper.startPage(1, 100);
		// 如果字符串为空，则按姓名排序返回200条结果
		if (patientKeywordSearchReq == null || StringUtils.isBlank(patientKeywordSearchReq.getKeyword())) {
			patientKeywordSearchReq.setKeyword(null);
			PageHelper.startPage(1, 200);
		}
		//治疗类型设空值
		if(patientKeywordSearchReq.getTreatmentTypeIds()!=null&&patientKeywordSearchReq.getTreatmentTypeIds().size()==0)
			patientKeywordSearchReq.setTreatmentTypeIds(null);
		List<PatientSimpleInfo> list = this.patientDao.searchPatientBykeyword(patientKeywordSearchReq);
		com.github.pagehelper.Page<PatientSimpleInfo> data = new com.github.pagehelper.Page<PatientSimpleInfo>();
		data.addAll(list);
		Page<PatientSimpleInfo> pageList = PageUtil.returnPage(data);
		return pageList.getDataList();
	}

	

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public boolean createPatientOfHospitalRelation(Integer hospitalId, Long patientId, Integer sourceFlag) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption {
		LogUtil.log.debug("创建医院、患者关系---------->>hospitalId=" + hospitalId + ",patientId=" + patientId + ",sourceFlag=" + sourceFlag);
		//关注的医院ID不能为空
		if (hospitalId == null) {
			throw new EmptyParamExcption("\"hospitalId\" cannot be empty!");
		}
		//患者ID不能为空
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		//来源不能为空
		if (sourceFlag == null) {
			throw new EmptyParamExcption("\"sourceFlag\" cannot be empty!");
		}
		HospitalPatientBriefInfo hospitalPatientBriefInfo = this.hospitalPatientDao.find(hospitalId, patientId);
		//如果已存在不用处理
		if (hospitalPatientBriefInfo != null) {
			//如果来源是5，扫码医院并且已存在的来源是3,tob同步。则以扫码医院为准
			if(sourceFlag.equals(5)&&hospitalPatientBriefInfo.getSourceFlag().equals(3)){
				hospitalPatientBriefInfo.setSourceFlag(sourceFlag);
				hospitalPatientDao.update(hospitalPatientBriefInfo);
			}
			return true;
		}
		//判断医院是否存在
		if (this.hospitalDao.existHospital(hospitalId) < 1) {
			throw new EmptyObjectExcption("hospitalId=" + hospitalId + ",Non existing hospital!");
		}
		//判断患者是否存在
		Patient patient = this.patientDao.findById(patientId);
		if(patient == null){
			throw new EmptyObjectExcption("patientId=" + patientId + ",Patients not present!");
		}
		//不存在新创建
		hospitalPatientBriefInfo = new HospitalPatientBriefInfo();
		hospitalPatientBriefInfo.setHospitalId(hospitalId);
		hospitalPatientBriefInfo.setPatientId(patientId);
		hospitalPatientBriefInfo.setPatientNo("");
		hospitalPatientBriefInfo.setSourceFlag(sourceFlag);
		hospitalPatientBriefInfo.setSyncFlag(Constant.User.SYNCFLAG_NO);
		
		User user = this.userDao.findByUserId(patient.getUserId());
		if (user.getSourceFlag() < 1) {
			user.setSourceFlag(sourceFlag);
			this.userDao.updateUser(user);
		}
		
		this.hospitalPatientDao.insertRelationOfHospitalPatient(hospitalPatientBriefInfo);
		LogUtil.log.debug("完成创建医院、患者关系----------<<<<<<<<<<<");
		return true;
	}
	
	/**
	 * 创建医患关系
	 */
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean createPatientOfDoctorRelation(Long doctorId, Long patientId, Integer sourceFlag) throws EmptyParamExcption, ParamFormatErrorExcption, ObjectNotAvailableExcption {
		//关注的医生ID不能为空
		if (doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		//患者ID不能为空
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		//关注操作来源不能为空
		if (sourceFlag == null) {
			throw new EmptyParamExcption("\"source\" cannot be empty!");
		}
		//查询是否已存在此医患关系
		DoctorPatient doctorPatient = this.doctorPatientDao.searchDoctorPatient(patientId, doctorId);
		if (doctorPatient != null) {
			//如果来源是1，扫码关注并且已存在的来源是3,tob同步。则以扫码关注为准
			if(sourceFlag.equals(1)&&doctorPatient.getSourceFlag().equals(3)){
				doctorPatient.setSourceFlag(1);
				doctorPatient.setAttentionTime(new Date());
				doctorPatientDao.updateDoctorPatient(doctorPatient);
			}
			return true;
		}
		//Added by Daloong. 2016/1/16
		//必须确认patientId和doctorId分别在数据库中存在
		PatientProfile patientProfile = this.patientDao.selectPatientProfileByPatientId(patientId, doctorId);
		if(patientProfile == null){
			throw new ObjectNotAvailableExcption("\"patientId\" "+patientId+" not exist!");
		}
		DoctorProfile doctorProfile = this.doctorDao.selectDoctorProfileByDoctorId(doctorId, patientId, null, null);
		if(doctorProfile == null){
			throw new ObjectNotAvailableExcption("\"doctorId\" "+doctorId+" not exist!");
		}
		//记录操作日志
		OperationHistory operationHistory = new OperationHistory();
		switch (sourceFlag) {
		case 0:
			operationHistory.setOperatorId(patientId);
			operationHistory.setDescription("未知来源，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 1:
			operationHistory.setOperatorId(patientId);
			operationHistory.setDescription("患者扫码关注，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			//扫码关注医生时自动关注医生所在医院
			if(doctorProfile!=null&&doctorProfile.getHospitalId()!=null&&doctorProfile.getHospitalSignedFlag()==1)
				createPatientOfHospitalRelation(Integer.parseInt(doctorProfile.getHospitalId()+""), patientId, sourceFlag);
			break;
		case 2:
			operationHistory.setOperatorId(doctorId);
			operationHistory.setDescription("患者微信关注，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 3:
			operationHistory.setOperatorId(-1L);
			operationHistory.setDescription("院内同步，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 4:
			operationHistory.setOperatorId(-1L);
			operationHistory.setDescription("医生创建，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 7:
			operationHistory.setOperatorId(-1L);
			operationHistory.setDescription("MDT创建，创建医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		default:
			throw new ParamFormatErrorExcption("The \"source\" parameter format error");
		}
		operationHistory.setOperationName("创建医患关系");
		operationHistory.setActionType(1);
		operationHistory.setCreateTime(new Date());
		this.operationHistoryDao.insert(operationHistory);
		//不存在此医患关系则创建
		doctorPatient = new DoctorPatient();
		doctorPatient.setDoctorId(doctorId);
		doctorPatient.setPatientId(patientId);
		doctorPatient.setAttentionTime(new Date());
		doctorPatient.setCreateTime(doctorPatient.getAttentionTime());
		doctorPatient.setHasMedicalRecord(0);
		doctorPatient.setSourceFlag(sourceFlag);
		this.doctorPatientDao.insert(doctorPatient);
		//创建医患关系病历数表
		this.varPatientDoctorMedicalDao.createVarPatientDoctorMedical(doctorPatient);
		//Added by Daloong. 2016/1/16
		//发出一条‘新患者’推送给医生
		this.sendNotifyToDoctorForNewPatient(doctorProfile.getUserId(), patientProfile.getUserId());
		//如果患者有病历，给被关注的医生推送一条有病历通知
		if (Constant.User.HASVISIBLEMEDICALRECORD_YES == patientProfile.getHasVisibleMedicalRecord()) {
			//获取最新的病例ID
			String emrId = this.patientDao.findPatientEmrId(patientId);
			if (StringUtils.isNotEmpty(emrId)) {
				this.sendImMessageNotifyToDoctor(doctorProfile.getUserId(), patientProfile, emrId);
			}
		}
		//如果患者未开启随访计划信息，由医生邀请患者填写
		if (this.patientDao.findFollowupByPatientId(patientProfile.getPatientId()) < 1) {
			if (patientProfile.getSourceFlag() == null) {
				patientProfile.setSourceFlag(sourceFlag);
			}
			this.sendButtonsToDoctorForNewPatient(doctorProfile, patientProfile);
		}else{
			this.sendNotifyToDoctorForPatientOpenFollowupPlan(patientProfile, doctorProfile);
		}
		return true;
	}
	/**
	 * 患者开启了随访计划，通知医生
	 * @param patientProfile
	 * @return
	 */
	private boolean sendNotifyToDoctorForPatientOpenFollowupPlan(PatientProfile patientProfile, DoctorProfile doctorProfile) {
		String content = messageSource.getMessage("push.doctors.ofpatient.followup.progress", null, locale);
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, patientProfile.getUserId(), doctorProfile.getUserId(), 
				content, Const.PATIENTIMPOVEDISEASE + patientProfile.getPatientId(), patientProfile.getSourceDiseaseTypeName());
		im.setHideInChatList(1);
		im.setContentType(1);
		
		return messageInnerService.sendInnerMessage(im);
	}
	
	/**
	 * @author Daloong
	 * 给医生端发出推送，通知有新患者
	 * @param doctorId
	 * @param patientId
	 */
	private void sendNotifyToDoctorForNewPatient(Long doctorUserId, Long patientUserId) {
		try{
			if(patientUserId!=null && doctorUserId!=null && patientUserId>0 && doctorUserId>0){
				String patientName = userDao.findUserTrueName(patientUserId);
				if (StringUtils.isEmpty(patientName)) {
					patientName = "";
				}
				String content = messageSource.getMessage("push.newpatient.todoctor", new Object[]{patientName}, locale);
				PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForNewPatient(patientUserId,doctorUserId, content);
				pushInnerService.push(notifyInfo);
			}
		}
		catch(Exception e){
			LogUtil.logError.error("sendNotifyToDoctorForNewPatient() failed: "+e.getMessage());
		}
	}
	/**
	 * 患者关注医生后，如果患者未完善疾病信息，给医生推送一条消息，消息里带按钮，按钮点击后给患者推送一条邀请完善疾病信息的消息
	 * @param doctorProfile
	 * @param patientProfile
	 * @return
	 */
	private boolean sendButtonsToDoctorForNewPatient(DoctorProfile doctorProfile, PatientProfile patientProfile){
		String content = null;
		switch (patientProfile.getSourceFlag()) {
		case 1://扫码关注
			content = messageSource.getMessage("button.tips.patient.with.qrcode.attention.todoctor", null, locale);
			break;
		case 2://搜索医生关注
			content = messageSource.getMessage("button.tips.patient.with.channelconcern.attention.todoctor", null, locale);
			break;
		case 3://院内同步关系
			content = messageSource.getMessage("button.tips.patient.with.hospital.attention.todoctor", null, locale);
			break;
		default:
			break;
		}
		TStructuredMsg<TButtonMsg>  struMsg = new TStructuredMsg<TButtonMsg>();
		TButtonMsg buttonMsg = new TButtonMsg();
		struMsg.setMsgType("button");
		struMsg.setMsgBody(buttonMsg);
		//设置标题。带颜色
		//buttonMsg.setTitle(content);
		buttonMsg.setDescription(content);
		
		//生成按钮
		List<TButtonItemInfo> buttonList = new LinkedList<TButtonItemInfo>();
		buttonMsg.setButton(buttonList);
		//按钮信息
		TButtonItemInfo button = new TButtonItemInfo();
		button.setText(messageSource.getMessage("button.title.invite.patients.to.improve.disease.information", null, locale));
		button.setEventKey("SERVICE_APPLY_ACCEPT_OK");
		button.setEventUrl(serverUrlRoot + patientDoSomething);
		HashMap<String, Object> param = new HashMap<String,Object>(5);
		param.put("doctorId", doctorProfile.getDoctorId());
		param.put("doctorName", doctorProfile.getTrueName());
		param.put("hospitalName", doctorProfile.getHospitalName());
		param.put("inviteType", 2);
		param.put("patients", new Long[]{patientProfile.getPatientId()});
		button.setParam(param);
		buttonList.add(button);
		//buttonMsg.setStyle("horizontal");
		
		//整个struMsg转换成json消息
		content = JSON.toJSONString(struMsg);
		String tipText = messageSource.getMessage("button.title.invite.patients.to.improve.disease.information", null, locale);//chat提示
		ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, patientProfile.getUserId(), doctorProfile.getUserId(), content, 
				Const.PATIENTIMPOVEDISEASE + patientProfile.getPatientId(), tipText);
		im.setHideInChatList(1);//隐藏
		
		return messageInnerService.sendInnerMessage(im);
	}
	
	/**
	 * 
	 * @param doctorUserId
	 * @param patientId
	 * @param emrId
	 */
	private void sendImMessageNotifyToDoctor(Long doctorUserId, PatientProfile patientProfile, String emrId) {
		//上传新病历时，给医生发出推送
		try{
			String patientName = patientProfile.getTrueName();
		    String content = messageSource.getMessage("push.emr.new.upload.todoctor", new Object[]{patientName}, locale);
			int count = this.patientDao.findPatientMedicalRecordCount(patientProfile.getPatientId(), null);
			if (count > 0) {
				PushNotifyInfo notifyInfo = PushUtil.getAppPushNotifyInfoForEmr(doctorUserId, patientProfile.getPatientId(), patientName, emrId, content, count);
				pushInnerService.push(notifyInfo);
			}
		} catch(Exception e) {
			//没有调用成功时，不对外抛异常，不能影响正常业务
			LogUtil.logError.error("sendPushNotifyToDoctor failed: patientId="+patientProfile.getPatientId() +";"+e.getMessage());
		}
	}

	/**(非 Javadoc) 
	* <p>Title: releasePatientOfDoctor</p> 
	* <p>Description: 解除医患关系</p> 
	* @param patientId
	* @return 
	 * @throws RejectRequestExcption 
	* @see com.esuizhen.cloudservice.user.service.PatientService#releasePatientOfDoctor(java.util.Locale, java.lang.Long, java.lang.Long, java.lang.Integer) 
	*/
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean releasePatientOfDoctor(Long doctorId, Long patientId, Integer source) throws EmptyParamExcption, ParamFormatErrorExcption, RejectRequestExcption, ParamMismatchExcption  {
		DoctorPatient doctorPatient = this.doctorPatientDao.searchDoctorPatient(patientId, doctorId);
		if (doctorPatient == null) {
			return true;
		}
		PatientProfile patientProfile = this.patientDao.selectPatientProfileByPatientId(patientId, doctorId);
		if (patientProfile.getServiceSubscriptionInfo() != null &&
				patientProfile.getServiceSubscriptionInfo().getVipFlag() == 1) {
			throw new RejectRequestExcption("patients with ID is " + patientId + " of the patient is " + doctorId + " of the doctor's VIP, can not be deleted!");
		}
		OperationHistory operationHistory = new OperationHistory();
		PatientSimpleInfo patientSimpleInfo = this.patientDao.selectPatientSimpleInfo(patientId, "patient", doctorId);
		ServiceSubscriptionInfo serviceSubscriptionInfo = patientSimpleInfo.getServiceSubscriptionInfo();
		if (serviceSubscriptionInfo != null && (serviceSubscriptionInfo.getSubscriptionFlag() > -1||serviceSubscriptionInfo.getAgentApplyFlag()>-1)) {
			throw new RejectRequestExcption("patientId " + patientId + " ordered the doctorId " + doctorId + " service, can not be deleted!");
		}
		switch (source) {
		case 1:
			operationHistory.setOperatorId(patientId);
			operationHistory.setDescription("患者解除医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 2:
			operationHistory.setOperatorId(doctorId);
			operationHistory.setDescription("医生解除医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		case 3:
			operationHistory.setOperatorId(-1L);
			operationHistory.setDescription("系统解除医患关系. doctorId=" + doctorId + ",patientId=" + patientId);
			break;
		default:
			throw new ParamMismatchExcption("The \"source\" parameter format error");
		}
		operationHistory.setOperationName("解除医患关系");
		operationHistory.setActionType(2);
		operationHistory.setCreateTime(new Date());
		this.operationHistoryDao.insert(operationHistory);
		//删除医患聊天记录
		delChatViamembers(doctorId, patientId);
		this.doctorPatientDao.deleteByDcotorIdAndPatientId(doctorPatient.getDoctorId(), doctorPatient.getPatientId());
		//删除医患中间表
		this.varPatientDoctorMedicalDao.deleteVarPatientDoctorMedical(doctorPatient);
		//删除分组表
		this.patientGroupMembersDao.deletePatientOfGroupMember(doctorPatient);
		return true;
	}

	private void delChatViamembers(Long doctorId, Long patientId) {
		PatientProfile patientProfile = this.patientDao.selectPatientProfileByPatientId(patientId, doctorId);
		DoctorProfile doctorProfile = this.doctorDao.selectDoctorProfileByDoctorId(doctorId, patientId, null, null);
		List<ImChatMemberInfo> members = new ArrayList<ImChatMemberInfo>();
		ImChatMemberInfo imDoctor = new ImChatMemberInfo();
		imDoctor.setId(doctorProfile.getUserId());
		imDoctor.setRole(Constant.User.ROLE_DOCTOR);
		ImChatMemberInfo imPatient = new ImChatMemberInfo();
		imPatient.setId(patientProfile.getUserId());
		imPatient.setRole(Constant.User.ROLE_PATIENT);
		members.add(imDoctor);
		members.add(imPatient);
		messageInnerService.deleteChatViaMembers(1, members);
	}

	@Override
	public PatientProfileDetailResp searchPatientById(Long patientId) {
		return this.searchPatientById(new PatientProfileDetailReq(patientId,null,null));
	}

	@Override
	public PatientSimpleInfo getPatientSimpleInfoById(Long id, String tag, Long doctorId) throws EmptyParamExcption {
		if (tag == null) {
			throw new EmptyParamExcption("\"tag\" cannot be empty!");
		}
		tag = tag.toLowerCase();
		return this.patientDao.selectPatientSimpleInfo(id, tag, doctorId);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean hasVisibleMedicalRecord(Integer visibleFlag, Integer sourceFlag, Long doctorId, Long patientId) throws EmptyParamExcption, EmptyObjectExcption {
		LogUtil.log.debug("hasVisibleMedicalRecord()------------>>");
		if (visibleFlag == null) {
			throw new EmptyParamExcption("\"visibleFlag\" cannot be empty!");
		}
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		if ((visibleFlag == 2 || visibleFlag == 3) && doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		switch (visibleFlag) {
		case 1:
			this.eidtPatientMedicalRecordFlag(patientId, Constant.User.HASVISIBLEMEDICALRECORD_YES);
			break;
		case 2:
		case 3:
			this.editDoctorPatientMedicalRecordFlag(doctorId, patientId, Constant.User.HASVISIBLEMEDICALRECORD_YES);
			break;
		case 4:
			List<DoctorPatient> doctorPatients = this.doctorPatientDao.findByHospitalIdAndDoctorId(doctorId, doctorId);
			for (DoctorPatient doctorPatient : doctorPatients) {
				if (doctorPatient.getHasMedicalRecord() != 1) {
					doctorPatient.setHasMedicalRecord(1);
					this.doctorPatientDao.updateHasMedicalRecord(doctorPatient);
				}
			}
			break;
		}
		return true;
	}

	@Override
	public boolean delHasVisibleMedicalRecord(Integer visibleFlag, Integer sourceFlag, Long doctorId, Long patientId) throws EmptyParamExcption, EmptyObjectExcption {
		LogUtil.log.debug("delHasVisibleMedicalRecord()---------->> params:visibleFlag=" + visibleFlag +",sourceFlag=" + sourceFlag + ",doctorId=" + doctorId + ",patientId=" + patientId);
		if (sourceFlag == null) {
			throw new EmptyParamExcption("\"sourceFlag\" cannot be empty!");
		}
		if (patientId == null) {
			throw new EmptyParamExcption("\"patientId\" cannot be empty!");
		}
		if ((sourceFlag == 2 || sourceFlag == 3) && doctorId == null) {
			throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
		}
		if (visibleFlag == 1) {
			this.eidtPatientMedicalRecordFlag(patientId, Constant.User.HASVISIBLEMEDICALRECORD_NO);
		}else{
			switch (sourceFlag) {
			case 1:
				this.eidtPatientMedicalRecordFlag(patientId, Constant.User.HASVISIBLEMEDICALRECORD_NO);
				break;
			case 2:
				if (doctorId == null) {
					throw new EmptyParamExcption("\"doctorId\" cannot be empty!");
				}
				this.editDoctorPatientMedicalRecordFlag(doctorId, patientId, Constant.User.HASVISIBLEMEDICALRECORD_NO);
				break;
			default:
				break;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param doctorId
	 * @param patientId
	 */
	private void editDoctorPatientMedicalRecordFlag(Long doctorId, Long patientId, Integer hasMedicalRecord) {
		DoctorPatient doctorVisiblePatient = this.doctorPatientDao.searchDoctorPatient(patientId, doctorId);
		if (doctorVisiblePatient == null) {
			throw new EmptyObjectExcption("\"DoctorPatient\" is null!");
		}
		if (doctorVisiblePatient.getHasMedicalRecord() != hasMedicalRecord) {
			doctorVisiblePatient.setHasMedicalRecord(hasMedicalRecord);
			this.doctorPatientDao.updateHasMedicalRecord(doctorVisiblePatient);
		}
	}

	/**
	 * 
	 * @param patientId
	 */
	private void eidtPatientMedicalRecordFlag(Long patientId, Integer hasVisibleMedicalRecord) {
		Patient patient = this.patientDao.findById(patientId);
		if (patient == null) {
			throw new EmptyObjectExcption("\"Patient\" is empty!");
		}
		if (patient.getHasVisibleMedicalRecord() != hasVisibleMedicalRecord) {
			patient.setHasVisibleMedicalRecord(hasVisibleMedicalRecord);
			patient.setUpdateTime(new Date());
			this.patientDao.updateHasVisibleMedicalRecord(patient);
		}
	}
	
	/**
	 * 修改患者基本信息
	 * @param userProfileModifyReq
	 * @param user
	 * @param patient
	 * @return
	 * @throws EmptyParamExcption
	 * @throws EmptyObjectExcption
	 * @throws ParamMismatchExcption
	 * @throws RemoteCallExcption
	 * @throws RejectRequestExcption
	 */
	@Transactional
	public LoginByThirdPartyResp modifyPatientProfile(UserProfileModifyReq userProfileModifyReq, User user, Patient patient) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption {
		UserProfile userProfile = userProfileModifyReq.getUserProfile();
		//修改用户信息
		if (userProfile.getRole() == Constant.User.ROLE_PATIENT &&
				StringUtils.isNotEmpty(userProfile.getIdentification())&&
				userProfileModifyReq.getPatientProfile().getAuditState() == Constant.User.AUDITSTATE_ADVANCEDPASS) {
			if (userProfile.getIdType() == null) {
				userProfile.setIdType(Constant.User.IDTYPE_ID);
			}
			if(!this.userService.verificationIdentification(userProfile)){
				throw new RejectRequestExcption("User id " + userProfile.getUserId() + " use Certificate type " + userProfile.getIdType() + ", Identification " + userProfile.getIdentification() + " has been registered");
			}
			user.setIdType(userProfile.getIdType());
			user.setIdentification(userProfile.getIdentification());
		}
		//预处理身份证号
		if (userProfile.getRole() == Constant.User.ROLE_PATIENT &&
				StringUtils.isNotEmpty(userProfile.getPreIdentification())) {
			if (userProfile.getIdType() == null) {
				userProfile.setIdType(Constant.User.IDTYPE_ID);
			}
			if(!this.userService.verificationPreIdentification(userProfile)){
				throw new RejectRequestExcption("User id " + userProfile.getUserId() + " use Certificate type " + userProfile.getIdType() + ", PreIdentification " + userProfile.getPreIdentification() + " has been registered");
			}
			user.setIdType(userProfile.getIdType());
			user.setPreIdentification(userProfile.getPreIdentification());
			//给患者推送消息
			this.sendNotifyToPatientCertification(user.getUserId());
		}
		if(userProfile.getCity()!=null){
			if(StringUtils.isNotEmpty(userProfile.getCity()) && user.getCityId()==null){
				user.setCityId(userDao.queryUserCityId(userProfile.getCity()));
			}
			userProfile.setCity(null);
		}
		this.userService.modifyUserProfile(userProfile, user);
		PatientProfile patientProfile = userProfileModifyReq.getPatientProfile();
		Date nowTime = new Date();
		
		patient.setNickName(user.getNickName());
		patient.setSex(user.getSex());
		patient.setBirthDate(user.getBirthDate());
		patient.setUserPictureUrl(user.getUserPictureUrl());
		
		if (patientProfile != null) {
			patient.setPreTrueName(patientProfile.getPreTrueName());
			patient.setTrueName(patientProfile.getTrueName());
			patient.setMobile(patientProfile.getMobile());
			patient.setPatientRelation(patientProfile.getPatientRelation());
			patient.setFamilyName(patientProfile.getFamilyName());
			patient.setFamilyPhone(patientProfile.getFamilyPhone());
			patient.setBloodType(patientProfile.getBloodType());
			patient.setBloodTypeRH(patientProfile.getBloodTypeRH());
			patient.setBodyHeight(patientProfile.getBodyHeight());
			patient.setDisabilityStatus(patientProfile.getDisabilityStatus());
			patient.setGeneticDiseaseHistory(patientProfile.getGeneticDiseaseHistory());
			patient.setDrugAllergyHistory(patientProfile.getDrugAllergyHistory());
			patient.setMedicalPayType(patientProfile.getMedicalPayType());
			patient.setLatestClinicDate(patientProfile.getLatestClinicDate());
			patient.setLatestOutHospitalDate(patientProfile.getLatestOutHospitalDate());
			patient.setSourcePathologyDiagnosis(patientProfile.getSourcePathologyDiagnosis());
			patient.setSourcePathologyDiseaseCode(patientProfile.getSourcePathologyDiseaseCode());
			patient.setAttendingDoctor(patientProfile.getAttendingDoctor());
			patient.setAuditRemark(patientProfile.getAuditRemark());
			this.patientFamilyService.addOrModifyPatientFamily(patient);
		}
		//填写了证件类型和证件号，审核变为“实名认证待审核”
		if (patient.getAuditState() < Constant.User.AUDITSTATE_SENIOR &&
				user.getIdType() != null &&
				StringUtils.isNotBlank(user.getPreIdentification())) {
			patient.setAuditState(Constant.User.AUDITSTATE_SENIOR);
		}
		patient.setUpdateTime(nowTime);
		patientDao.updateByPrimaryKey(patient);
		/*
		if (followupFlag && StringUtils.isNotBlank(patient.getSourceDiseaseCode())) {
			//生成随访计划
			createFollowupPlan(patient);
			//给患者推送消息病患知识
			sendNotifyToPatientForPerfectInformation(patient.getUserId());
		}
		*/
		LoginByThirdPartyResp loginByThirdPartyResp = new LoginByThirdPartyResp();
		loginByThirdPartyResp.setUserId(user.getUserId());
		loginByThirdPartyResp.setAccountType(user.getAccountType());
		loginByThirdPartyResp.setInfoState(user.getInfoState());
		return loginByThirdPartyResp;
	}

	/**
	 * <p>Title:sendNotifyToPatientCertification</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年5月13日 下午6:06:03
	 * @param patientUserId
	 * @return
	 */
	private boolean sendNotifyToPatientCertification(Long patientUserId){
		try{
			if(patientUserId != null && patientUserId > 0){
				List<ThirdParty> thirdParties = this.thirdPartyDao.findByUserId(patientUserId);
				if (thirdParties == null || thirdParties.isEmpty()) {
					return false;
				}
				String content = messageSource.getMessage("push.patient.perfect.certification.info", null, locale);
				PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(patientUserId, content);
				pushInnerService.push(notifyInfo);
			}
		} catch (Exception e){
			LogUtil.logError.error("sendNotifyToPatientForOpenFollowupPlan() failed:" + e.getMessage());
		}
		return true;
	}

	
	@Override
	public boolean certificatePatient(PatientSimpleInfo patientSimpleInfo) throws EmptyParamExcption, EmptyObjectExcption, RejectRequestExcption {
		if (patientSimpleInfo.getPatientId() == null || patientSimpleInfo.getCertificateResult() == null) {
			throw new EmptyParamExcption("The parameters can not be empty! patientId=" + patientSimpleInfo.getPatientId() + ",certificateResult=" + patientSimpleInfo.getCertificateResult() + "!");
		}
		Patient patient = this.patientDao.findById(patientSimpleInfo.getPatientId());
		if (patient == null) {
			throw new EmptyObjectExcption("Patient is empty!");
		}
		patient.setAuditRemark(patientSimpleInfo.getAuditRemark());
		User user = this.userDao.findByUserId(patient.getUserId());
		switch (patientSimpleInfo.getCertificateResult()) {
		case -1:
			//高级审核失败
			patient.setAuditState(Constant.User.AUDITSTATE_DISAGREE);
			this.patientDao.updateByPrimaryKey(patient);
			return true;
		case 0:
			if (StringUtils.isEmpty(user.getIdentification()) || StringUtils.isEmpty(user.getTrueName())) {
				throw new RejectRequestExcption("Patients with insufficient data, unable to operate!");
			}
			patient.setAuditState(Constant.User.AUDITSTATE_ADVANCEDPASS);//高级审核通过
			this.patientDao.updateByPrimaryKey(patient);
			
//			user.setInfoState(Constant.User.INFOSTATE_REALNAME);//信息高级完善
			if (user.getIdType() == null) {
				user.setIdType(Constant.User.IDTYPE_ID);
				this.userDao.updateByPrimaryKey(user);
			}
			//合并ToB导入的患者
			this.advancedAuditMatchingToBIdentification(user);
			return true;
		default:
			throw new EmptyParamExcption("Parameter mismatch, certificateResult=" + patientSimpleInfo.getCertificateResult() + "!");
		}
	}
	
	/**
	 * 患者高级审核时与ToB导入的患者的证件进行匹配，匹配上后进行数据合并
	 * 并给患者推送合并消息
	 * @param user
	 * @return
	 */
	private boolean advancedAuditMatchingToBIdentification(User user){
		LogUtil.log.debug("合并ToB导入的患者信息----------->>");
		Patient patient = this.patientDao.findByUserId(user.getUserId());
		//查询是否有ToB导入的患者
		Patient tobPatient = this.patientDao.findToBPatientByIdentification(user.getIdType(), user.getIdentification());
		if (patient == null ||
				tobPatient == null ||
				patient.getPatientId() == tobPatient.getPatientId()) {
			LogUtil.log.debug("合并ToB导入的患者信息，条件不符合，拒绝处理-----------<<");
			return false;
		}
		User tobUser = this.userDao.findByUserId(tobPatient.getUserId());

		this.mergerPatient(user, tobUser, patient, tobPatient);
		patient = this.patientDao.findByUserId(user.getUserId());
		//给患者推送告知消息
		MetaCDiseaseType metaCDiseaseType = this.metaCDiseaseTypeDao.findByDiseaseTypeId(patient.getSourceDiseaseTypeId());
		String diseaseTypeName = "未知";
		if (metaCDiseaseType != null) {
			diseaseTypeName = metaCDiseaseType.getDiseaseTypeName();
		}
		this.sendNotifyToPatientForRealnameMatchTobPatient(user, patient.getTrueName(), diseaseTypeName);
		return true;
	}
	
	@Override
	public void certificateFollowupPlan(Long patientId) {
		Patient patient = this.patientDao.findById(patientId);
		//给患者补充随访计划
		int productId = Constant.Push.WEIXIN_BIND_DEFAULT_PRODUCT_ID;
		HospitalPatientBriefInfo hospitalPatientBriefInfo = this.hospitalPatientDao.findFirstHasPatientNo(patient.getPatientId());
		if (hospitalPatientBriefInfo != null) {
			ConfHospitalWX confHospitalWX = this.confHospitalWXDao.findByHospitalId(hospitalPatientBriefInfo.getHospitalId());
			if (confHospitalWX != null) {
				productId = confHospitalWX.getProductId();
			}
		}
		//给患者开启随访计划
		patient = this.supplementaryFollowupPlan(patient, productId);
		LogUtil.log.debug("合并ToB导入的患者信息完成-----------<<<");
	}
	
	private void mergePatient(Patient patient, Patient tobPatient) {
		//处理真实姓名
		if (StringUtils.isNotEmpty(tobPatient.getTrueName()) &&
				!tobPatient.getTrueName().equals(patient.getTrueName())) {
			patient.setTrueName(tobPatient.getTrueName());
		}
		//处理性别
		if (tobPatient.getSex() != null && tobPatient.getSex() != 0) {
			patient.setSex(tobPatient.getSex());
		}
		//处理出生日期
		if (tobPatient.getBirthDate() != null &&
				(patient.getBirthDate() == null ||
				tobPatient.getBirthDate().compareTo(patient.getBirthDate()) != 0)) {
			patient.setBirthDate(tobPatient.getBirthDate());
		}
		//处理病案号
		if(StringUtils.isBlank(patient.getPatientNo())&&!StringUtils.isBlank(tobPatient.getPatientNo()))
			patient.setPatientNo(tobPatient.getPatientNo());
		//处理联系方式，如果联系方式不同，将联系方式添加到患者联系人中
		if (StringUtils.isNotEmpty(tobPatient.getMobile())) {
			Patient tobPatientFamliyRelation = new Patient();
			tobPatientFamliyRelation.setPatientId(patient.getPatientId());
			tobPatientFamliyRelation.setMobile(tobPatient.getMobile());
			String familyName = tobPatient.getTrueName();
			if (StringUtils.isEmpty(familyName)) {
				familyName = "";
			}
			tobPatientFamliyRelation.setTrueName(familyName);
			
			this.patientFamilyService.addOrModifyPatientFamily(tobPatientFamliyRelation);
		}
		patient.setMatchFlag(1);
		patient.setSyncFlag(Constant.User.SYNCFLAG_YES);
		this.patientDao.updateByPrimaryKey(patient);
	}
	
	/**
	 * 通知患者已与ToB导入的患者信息合并完成
	 * @param patientUserId
	 */
	private void sendNotifyToPatientForRealnameMatchTobPatient(User user, String name, String diseaseTypeName) {
		try{
			if(user != null && user.getUserId() > 0 && user.getWeixinFlag() != null){
				String identification = user.getIdentification().substring(0, 10);
				String content = messageSource.getMessage("push.patient.realname.information.audit.matching.tobpatient", new String[]{identification + "xxxxxx" + user.getIdentification().substring(16)}, locale);
				List<String> values = new ArrayList<String>();
				values.add(content);
				values.add(name);
				values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
				values.add("确认身份信息");
				String sex = user.getSex() == 2 ? "女" : "男";
				String birthDate = "未知";
				if (null != user.getBirthDate()) {
					birthDate = DateUtils.formatDate(user.getBirthDate(), "yyyy年MM月dd日");
				}
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, this.serverH5UrlRoot + this.patientConfirmMatchInfoContent + "?trueName=" + name + 
						"&tipText=性别=" + sex + ",出生日期=" + birthDate + ",身份证号=" + user.getIdentification() + ",主要诊断=" + diseaseTypeName, values);
				notify.setUserId(user.getUserId());
				notify.setProductId(user.getWeixinFlag());
				this.pushInnerService.push(notify);
			}
		} catch (Exception e){
			LogUtil.logError.error("sendNotifyToPatientForRealnameAuthentication() failed:" + e.getMessage());
		}
	}

	/**
	 * 患者医院认证
	 * @throws VerifyFailureExcption 
	 */
	@Override

	public Object certificateHospitalPatient(PatientHospitalCertificateReq patientSimpleInfo) throws VerifyFailureExcption {
		if (patientSimpleInfo.getPatientId() == null || patientSimpleInfo.getHospitalId()==null || patientSimpleInfo.getPatientNo()==null ||StringUtils.isEmpty(patientSimpleInfo.getTrueName())) {

			throw new EmptyParamExcption("The parameters can not be empty! patientId=" + patientSimpleInfo.getPatientId() + "!");
		}
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("certificatedState", 0);
		//String result=this.checkCertificateHospitalPatientResult(patientSimpleInfo);
		HospitalPatientCertificatedHistory history=checkCertificateHospitalPatient(patientSimpleInfo);
		if(!history.getCertificatedState().equals(1))
		{
			LogUtil.log.info("patientNo check failed! patientId="+patientSimpleInfo.getPatientId()+",hospitalId="+ patientSimpleInfo.getHospitalId()
					+",patientNo="+patientSimpleInfo.getPatientNo()+",trueName="+patientSimpleInfo.getTrueName());

		}
		if(history.getCertificatedState().equals(1)){
			resultMap.put("certificatedState", 1);
		}else if(history.getCertificatedState().equals(0)){
			resultMap.put("certificatedState", -1);
		}else if(history.getCertificatedState().equals(-1)){
			resultMap.put("certificatedState", 0);
		}
		String result=this.getMessgaeByCertificateHospitalResult(history.getFailState());
		resultMap.put("checkResult",result);
		return resultMap;
	}

	public String getMessgaeByCertificateHospitalResult(Integer state) {
		StringBuilder sf=new StringBuilder("");
		if(state.equals(-1)||state.equals(-2)){
			sf.append("您好，由于您提交的“患者姓名”和医院预留信息不匹配，医院认证失败。 请等待客服处理！");
		}else if(state.equals(-3)){
			sf.append("您好，由于您提交的“病案号”和医院预留信息不匹配，医院认证失败。 请等待客服处理！");
		}else if(state.equals(-4)){
			sf.append("您好，由于您提交的“手机号码”和医院预留信息不匹配，医院认证失败。 请等待客服处理！");
		}else if(state.equals(-5)){
			sf.append("您好，由于您提交的信息和医院预留信息冲突，医院认证失败。 请等待客服处理！");
		}else if(state.equals(-6)){
			sf.append("您好，由于您提交的信息已被其他用户认证，医院认证失败。 请等待客服处理！");
		}else{
			sf=new StringBuilder("");
		}
		return sf.toString();
	}

	/**
	 * 
	 * @author lichenghao
	 * @title :checkCertificateHospitalPatient
	 * @Description:检查医院认证
	 * @return boolean
	 * @date 2017年1月9日 上午11:07:50
	 */
	public HospitalPatientCertificatedHistory checkCertificateHospitalPatient(PatientHospitalCertificateReq req){
		Patient patient = this.patientDao.findById(req.getPatientId());
		if (patient == null) {
			throw new EmptyObjectExcption("Patient is empty!");
		}
		HospitalPatientCertificatedHistory historyInfo = new HospitalPatientCertificatedHistory();
		BeanUtils.copyProperties(req, historyInfo);
		historyInfo.setCertificatedState(1);//默认成功
		historyInfo.setFailState(0);//默认没有失败
		historyInfo.setUserId(patient.getUserId());//写入用户编号
		//条件查询
		PatientHospitalCertificateInfo info = hospitalPatientDao.checkPatientNoInRelation(req);
		PatientHospitalCertificateInfo info1 = hospitalPatientDao.checkPatientNoInMatchRelation(req);
		if(info==null&&info1==null){//病案号不存在云端和B端
			historyInfo.setCertificatedState(-1);
			historyInfo.setFailState(-3);//无认证患者
		}else if(info!=null){//存在云端
			historyInfo.setCertificatedParam(JsonUtil.toJson(info));
			historyInfo.setMatchPatientId(info.getPatientId());
			if(!info.getPatientId().equals(req.getPatientId())&&info.getTobFlag()==1){//如果匹配非自身，且自身已合并
				historyInfo.setCertificatedState(-1);
				historyInfo.setFailState(-5);
			}else if(!info.getPatientId().equals(req.getPatientId())&&info.getWeixinFlag()==1){//如果匹配非自身，且匹配为微信患者
				historyInfo.setCertificatedState(-1);
				historyInfo.setFailState(-6);
			}else if(StringUtils.isNotEmpty(req.getMobile())&&info.getMobileFlag()!=null&&info.getMobileFlag()==0){
				historyInfo.setCertificatedState(-1);
				historyInfo.setFailState(-4);//留院手机号认证失败
			}else{
				if(info.getPatientId().equals(req.getPatientId())){
					historyInfo.setMatchFlag(0);
				}else{
					historyInfo.setMatchFlag(1);
				}
				if(info.getTrueName()!=null){
					if(!info.getPatientId().equals(req.getPatientId())){
						//待合并
						this.certificateHospitalMergerPatient(historyInfo);
					}
					updatePatientHospitaCertificateState(info);//更新认证状态
				}else{//姓名不存在，待确认
					historyInfo.setCertificatedState(0);//待确认
					historyInfo.setCertificatedParam(JsonUtil.toJson(info));
					if(info.getPatientId().equals(req.getPatientId())){
						//待认证
						historyInfo.setFailState(-1);
					}else{
						//待匹配
						historyInfo.setFailState(-2);
					}
				}
			}
		}else{//存在B端
			info = info1;
			historyInfo.setCertificatedParam(JsonUtil.toJson(info));
			historyInfo.setMatchPatientUuid(info.getPatientUuid());
			historyInfo.setMatchFlag(2);
			if(StringUtils.isNotEmpty(req.getMobile())&&info.getMobileFlag()!=null&&info.getMobileFlag()==0){
				historyInfo.setCertificatedState(-1);
				historyInfo.setFailState(-4);//留院手机号认证失败
			}else{
				if(info.getTrueName()!=null){//判断姓名是否匹配
					this.certificateHospitalMergerPatient(historyInfo);//合并调用
					info = hospitalPatientDao.checkPatientNoInRelation(req);
					if(info!=null){//更新认证状态
						updatePatientHospitaCertificateState(info);
					}else{
						historyInfo.setCertificatedState(-1);
						historyInfo.setFailState(-3);//无认证患者
					}
				}else{//姓名不匹配，待确认合并
					historyInfo.setCertificatedState(0);//待确认
					historyInfo.setFailState(-2);//待合并
				}
			}
		}
		switch (historyInfo.getFailState()) {
		case -1:
			historyInfo.setCause("姓名不匹配，待认证");
			break;
		case -2:
			historyInfo.setCause("数据待合并");
			break;
		case -3:
			historyInfo.setCause("无认证患者");
			break;
		case -4:
			historyInfo.setCause("手机号认证失败");
			break;
		case -5:
			historyInfo.setCause("该患者已合并，匹配到非自身患者");
			break;
		case -6:
			historyInfo.setCause("匹配到微信患者");
			break;
		}
		historyInfo.setAuditWay(1);//系统认证
		historyInfo.setCertificatedParam(JsonUtil.toJson(info));
		hospitalPatientCertificatedHistoryDao.insert(historyInfo);
		certificateHospitalPatientNotify(historyInfo);
		return historyInfo;
	}

	private String checkCertificateHospitalPatientResult(PatientHospitalCertificateReq req){
		Patient pt=patientDao.findPatientByPatientIdAndhospitalId(req.getPatientId(),req.getHospitalId());
		StringBuilder sf=new StringBuilder("");
		if(pt!=null){
			if(!req.getPatientNo().equals(pt.getPatientNo())){
				sf.append("住院号,");
			}
			if(!req.getTrueName().equals(pt.getTrueName())){
				sf.append("患者姓名,");
			}
			List<PatientFamily> list=patientFamilyDao.findByPatientId(req.getPatientId());
			boolean result=false;
			for (PatientFamily patientFamily : list) {
				if(req.getMobile().equals(patientFamily.getFamilyPhone())){
					result=true;
				}
			}
			if(!result){
				sf.append("手机号码,");
			}
			return sf.substring(0,sf.length()-1);
		}else{
			return sf.toString();
		}
	}

	//更新医院认证状态
	private void updatePatientHospitaCertificateState(PatientHospitalCertificateInfo info){
		//认证成功且修改状态
		if(info.getRid()!=null)
			hospitalPatientDao.updateRelationHospitalCertificateState(info.getRid(),2);
		else
			hospitalPatientDao.updateHospitalCertificateState(info.getId(),2);
	}
	
	//认证合并
	private void certificateHospitalMergerPatient(HospitalPatientCertificatedHistory info){
		if(info.getMatchFlag()!=null&&info.getMatchFlag()==2){//匹配库患者合并
			String url= serverUrlRoot+syncConfirm;
			PatientSimpleInfo patientSimpleInfo = patientDao.selectPatientSimpleInfo(info.getPatientId(), "patient", null);
			if(patientSimpleInfo==null){
				LogUtil.logError.error("patient hospital certificate error:patient is null,patientId="+info.getPatientId());
			}
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("userId", patientSimpleInfo.getUserId());
			params.put("userRole", Constant.User.ROLE_PATIENT);
			params.put("isConfirmed", 1);
			params.put("uuid", info.getMatchPatientUuid());
			try{
				String result = HttpUtil.postWithJSON(url, JsonUtil.toJson(params));
				TMsgResponse resp = JSON.parseObject(result,TMsgResponse.class);
				if(resp.getRespCode()!=0){
					throw new Exception(resp.getRespMsg());
				}
			}catch(Exception e){
				LogUtil.logError.error("patient hospital certificate match patient merger error:params"+ JsonUtil.toJson(params)+"\r\n"+e.getMessage());
			}
		}else{//正式库患者合并
			Patient cloudPatient = patientDao.findById(info.getPatientId());
			Patient tobPatient = patientDao.findById(info.getMatchPatientId());
			User cloudUser = userDao.findByUserId(cloudPatient.getUserId());
			User tobUser = userDao.findByUserId(tobPatient.getUserId());
			this.mergerPatient(cloudUser, tobUser, cloudPatient, tobPatient);
		}
	}
	//消息发送
	private void certificateHospitalPatientNotify(HospitalPatientCertificatedHistory info){
		if(info.getCertificatedState()==0)//待审核不推送
			return;
		HospitalProfile hospital = this.hospitalDao.findHospitalProfileById(info.getHospitalId(), "");
		List<String> values = new ArrayList<String>();
		String tagId="2";
		if(info.getCertificatedState()==-1){//认证失败推送
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.fail.first")));
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.keyword1", new Object[]{hospital.getHospitalName(),info.getPatientNo()})));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.fail.remark", new Object[]{hospital.getHospitalName(),StringUtils.isEmpty(info.getRemark())?"未知":info.getRemark()})));
		}else if(info.getCertificatedState()==1){//认证成功推送
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.success.first")));
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.keyword1", new Object[]{hospital.getHospitalName(),info.getPatientNo()})));
			values.add(DateUtil.getDateStr(new Date()));
			values.add(pushInnerService.getMessage(PushContentUtil.getUserPushContent(tagId, "hospital.patient.certificate.success.remark", new Object[]{hospital.getHospitalName()})));
		}
		PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo("shenhetixing", null, values);
		notify.setUserId(info.getUserId());
		pushInnerService.push(notify);
	}
	
	@Transactional
	@Override
	public void confirmHospitalPatientCertificated(PatientHospitalCertificateConfirmReq req) {
		// 医院认证信息确认
		if(req==null||req.getHistoryId()==null||req.getPatientId()==null||req.getHospitalId()==null){
			throw new EmptyParamExcption(" confirmHospitalPatientCertificated param error"+JsonUtil.toJson(req));
		}
		//查询认证记录
		HospitalPatientCertificatedHistory info = this.hospitalPatientCertificatedHistoryDao.queryByHistoryId(req.getHistoryId());
		if(info==null)//记录不存在
			throw new EmptyObjectExcption(" confirmHospitalPatientCertificated object error:query info is null historyId="+req.getHistoryId());
		if(!info.getHospitalId().equals(req.getHospitalId())||!info.getPatientId().equals(req.getPatientId()))//确认患者和医院与记录不符
			throw new EmptyObjectExcption(" confirmHospitalPatientCertificated object error:query info patient or hospital not match param="+JsonUtil.toJson(req));
		if(req.getCertificatedFlag()==1){
			//获取首次认证查询信息
			PatientHospitalCertificateInfo matchInfo = JsonUtil.toObject(info.getCertificatedParam(), PatientHospitalCertificateInfo.class);
			if(info.getMatchFlag()>0)
				this.certificateHospitalMergerPatient(info);
			if(info.getMatchFlag()!=2){
				this.updatePatientHospitaCertificateState(matchInfo);
			}else{
				matchInfo = hospitalPatientDao.checkPatientNoInRelation(info);
				if(matchInfo==null){
					LogUtil.logError.error("confirm Hospital Patient Certificated error,match data no merger");
				}else{
					this.updatePatientHospitaCertificateState(matchInfo);
				}
			}
			info.setCertificatedState(1);
		}else if(req.getCertificatedFlag()==-1){
			info.setCertificatedState(-1);
			info.setRemark(req.getRemark());
		}
		info.setAuditWay(2);//人工认证
		hospitalPatientCertificatedHistoryDao.modifyState(info);
		this.certificateHospitalPatientNotify(info);//推送消息
	}
	
	@Transactional
	@Override
	public boolean enableFollowupPlan(Patient patient){
		PageHelper.startPage(1, 1);
		List<DiagnosisInfo> diagnosisInfos = this.diagnosisInfoDao.findByPatientId(patient.getPatientId(), 1);
		//如果该患者还没有原发诊断信息，不处理
		if (diagnosisInfos == null || diagnosisInfos.isEmpty()) {
			return false;
		}
		DiagnosisInfo diagnosisInfo = diagnosisInfos.get(0);
		if (diagnosisInfo.getDiseaseTypeId() == null ||
				StringUtils.isEmpty(diagnosisInfo.getDiseaseCode()) ||
				StringUtils.isEmpty(diagnosisInfo.getDiagnosis()) ||
				diagnosisInfo.getVisitTime() == null) {
			return false;
		}
		patient.setSourceDiagnosis(diagnosisInfo.getDiagnosis());
		patient.setSourceDiseaseTypeId(diagnosisInfo.getDiseaseTypeId());
		patient.setSourceDiseaseCode(diagnosisInfo.getDiseaseCode());
		patient.setConfirmedDate(diagnosisInfo.getVisitTime());

		List<ThirdParty> thirdParties = this.thirdPartyDao.findByUserId(patient.getUserId());
		if(!followupService.checkPatientHasFollowup(patient.getPatientId()) &&
				thirdParties != null && !thirdParties.isEmpty()){
			int productId = Constant.Push.WEIXIN_BIND_DEFAULT_PRODUCT_ID;
			HospitalPatientBriefInfo hospitalPatientBriefInfo = this.hospitalPatientDao.findFirstHasPatientNo(patient.getPatientId());
			if (hospitalPatientBriefInfo != null) {
				ConfHospitalWX confHospitalWX = this.confHospitalWXDao.findByHospitalId(hospitalPatientBriefInfo.getHospitalId());
				if (confHospitalWX != null) {
					productId = confHospitalWX.getProductId();
				}
			}
			//开启随访计划
			this.createFollowupPlan(patient, null, null, productId);
		}
		this.patientDao.updateByPrimaryKey(patient);
		return true;
	}

	/**
	 * 给患者开启随访计划
	 * @param patient
	 */
	@Override
	public void createFollowupPlan(Patient patient, Long doctorId, String doctorName, Integer wxProductId) {
		Long patientId = patient.getPatientId();
		try {
			if(this.followupService.initNormalFollowupPlan(patientId, DateUtil.getDateOfDay(patient.getConfirmedDate(), "yyyy-MM-dd HH:mm:ss"), new Long(patient.getSourceDiseaseTypeId()), doctorName, wxProductId)){
				//给患者推送消息，告诉患者开启了随访计划   如果有doctorId  则不推送此消息
				this.sendNotifyToPatientForOpenFollowupPlan(patient.getUserId(), wxProductId);
				//通知医生此患者开启了随访计划
				this.sendNotifyToDoctorForPatientOpenFollowupPlan(patient, wxProductId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RemoteCallExcption("An error occurred while generating a follow-up plan, patientId is " + patientId + "," + e.getMessage());
		}
	}

	/**
	 * 
	 * @param patientUserId
	 */
	private void sendNotifyToPatientForOpenFollowupPlan(Long patientUserId,Integer wxProductId) {
		try{
			if(patientUserId != null && patientUserId > 0){
				List<ThirdParty> thirdParties = this.thirdPartyDao.findByUserId(patientUserId);
				if (thirdParties == null || thirdParties.isEmpty()) {
					return;
				}
				//User user = userDao.findByUserId(patientUserId);
				PushContent pushContent = null;
				Map<String,Object> params = new HashMap<String,Object>();
				params.put("userId", patientUserId);
				params.put("productId", wxProductId);
				LinkedHashMap<String, Object> result = patientDao.queryPatientSource(params);
				String source = result.get("trueName")==null?result.get("weixinName")+"":result.get("trueName")+"";
				pushContent = PushContentUtil.getUserPushContent(null, "push.patients.improve.disease.information.tips" ,new Object[]{source,serverH5UrlRoot+followupPage});
//				if(user.getSourceFlag()!=null){
//					if(user.getSourceFlag()==Constant.User.USERSOURCEFLAG_SCANCODE){
//						pushContent = PushContentUtil.getUserPushContent(null,
//								"push.patients.improve.disease.information.tips.doctor", new Object[] {serverH5UrlRoot+myDoctor});
//					}else if(user.getSourceFlag()==Constant.User.USERSOURCEFLAG_HOSPITAL_QRCODE){
//						pushContent = PushContentUtil.getUserPushContent(null,
//								"push.patients.improve.disease.information.tips.hospital");
//					}
//				}
				String content = 
						pushInnerService.getMessage(pushContent);
				PushNotifyInfo notifyInfo = PushUtil.getWxDataPushNotifyInfo(patientUserId, content);
				if(wxProductId!=null)
					notifyInfo.setProductId(wxProductId);
				pushInnerService.push(notifyInfo);
			}
		} catch (Exception e){
			LogUtil.logError.error("sendNotifyToPatientForOpenFollowupPlan() failed:" + e.getMessage());
		}
	}
	
	private boolean sendNotifyToDoctorForPatientOpenFollowupPlan(Patient patient,Integer wxProductId) {
		String content = messageSource.getMessage("push.doctors.ofpatient.followup.progress", null, locale);
		PatientProfile patientProfile = this.patientDao.selectPatientProfileByPatientId(patient.getPatientId(), null);
		List<DoctorSimpleInfo> doctors = this.doctorDao.findDoctorIdAndNameByPatientIdOrPatientUserId(patient.getPatientId(), "patient_patientId");
		for (DoctorSimpleInfo doctorSimpleInfo : doctors) {
			ImMessageInfo im = ImMessageUtil.getSysImMessageButton(1, patient.getUserId(), doctorSimpleInfo.getUserId(), 
					content, Const.PATIENTIMPOVEDISEASE + patientProfile.getPatientId(), patientProfile.getSourceDiseaseTypeName());
			im.setHideInChatList(1);
			im.setContentType(1);
			if(wxProductId!=null)
				im.setProductId(wxProductId);
			this.messageInnerService.sendInnerMessage(im);
		}
		return true;
	}
	
	@Override
	public Patient supplementaryFollowupPlan(Patient patient, int productId) {
		//还没有随访计划
		if (this.patientDao.findFollowupByPatientId(patient.getPatientId()) < 1) {
			boolean flag = false;
			if (StringUtils.isNotEmpty(patient.getSourceDiagnosis()) &&
					patient.getSourceDiseaseTypeId() != null &&
					StringUtils.isNotEmpty(patient.getSourceDiseaseCode()) &&
					patient.getConfirmedDate() != null) {
				flag = true;
			}else{
				//PageHelper.startPage(1, 3);
				List<DiagnosisInfo> diagosisInfoes = this.diagnosisInfoDao.findByPatientId(patient.getPatientId(), 1);
				if (diagosisInfoes != null && !diagosisInfoes.isEmpty()) {
					for (int i = 0, size = diagosisInfoes.size(), count = 0; i < size; i++) {
						DiagnosisInfo diagnosisInfo = diagosisInfoes.get(i);
						if (StringUtils.isEmpty(diagnosisInfo.getDiagnosis()) ||
								StringUtils.isEmpty(diagnosisInfo.getDiseaseCode()) ||
								diagnosisInfo.getDiseaseTypeId() == null) {
							if (StringUtils.isNotEmpty(diagnosisInfo.getDiseaseCode())) {
								MetaRDiseaseTypeIcd10 diseaseTypeICD10 = this.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
								if (diseaseTypeICD10 != null) {
									diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
									diagnosisInfo.setDiseaseBodyPartId(diagnosisInfo.getDiseaseBodyPartId());

									if (StringUtils.isEmpty(diagnosisInfo.getDiagnosis())) {
										PageHelper.startPage(1, 1);
										List<MetaEicd10> metaEicd10s = this.metaEicd10Dao.findByDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
										if (metaEicd10s != null && !metaEicd10s.isEmpty()) {
											if (StringUtils.isEmpty(diagnosisInfo.getDiagnosis())) {
												diagnosisInfo.setDiagnosis(metaEicd10s.get(0).getDiseaseName());
											}
										}
									}
								}else if(StringUtils.isNotEmpty(diagnosisInfo.getDiagnosis())){
									PageHelper.startPage(1, 1);
									List<MetaRDiseaseTypeIcd10> diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseContent(0, diagnosisInfo.getDiagnosis());
									if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
										diseaseTypeICD10 = diseaseTypeICD10s.get(0);
										
										diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
									}
								}
							} else if(StringUtils.isNotEmpty(diagnosisInfo.getDiagnosis())){
								PageHelper.startPage(1, 1);
								List<MetaRDiseaseTypeIcd10> diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseContent(0, diagnosisInfo.getDiagnosis());
								if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
									MetaRDiseaseTypeIcd10 diseaseTypeICD10 = diseaseTypeICD10s.get(0);
									
									diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
								}
							}
						}
						if (StringUtils.isEmpty(diagnosisInfo.getDiseaseCode()) ||
								diagnosisInfo.getDiseaseTypeId() == null) {
							continue;
						}
						if (diagnosisInfo.getVisitTime() == null) {
							diagnosisInfo.setVisitTime(new Date());
						}
						switch (count) {
						case 0:
							patient.setSourceDiseaseCode(diagnosisInfo.getDiseaseCode());
							if (diagnosisInfo.getDiseaseTypeId() == null) {
								PageHelper.startPage(1, 1);
								MetaRDiseaseTypeIcd10 metaRDiseaseTypeIcd10 = this.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
								if (metaRDiseaseTypeIcd10 == null) {
									continue;
								}
								diagnosisInfo.setDiseaseTypeId(metaRDiseaseTypeIcd10.getDiseaseTypeId());
							}
							patient.setSourceDiagnosis(diagnosisInfo.getDiagnosis());
							patient.setSourceDiseaseTypeId(diagnosisInfo.getDiseaseTypeId());
							patient.setConfirmedDate(diagnosisInfo.getVisitTime());
							
							patient.setSourcePathologyDiagnosis(diagnosisInfo.getPathologyDiagnosis());
							patient.setSourcePathologyDiseaseCode(diagnosisInfo.getPathologyDiagnosisCode());
							break;
						case 1:
							patient.setSourceDiseaseCode2(diagnosisInfo.getDiseaseCode());
							if (diagnosisInfo.getDiseaseTypeId() == null) {
								PageHelper.startPage(1, 1);
								MetaRDiseaseTypeIcd10 metaRDiseaseTypeIcd10 = this.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
								if (metaRDiseaseTypeIcd10 == null) {
									continue;
								}
								diagnosisInfo.setDiseaseTypeId(metaRDiseaseTypeIcd10.getDiseaseTypeId());
							}
							patient.setSourceDiagnosis2(diagnosisInfo.getDiagnosis());
							patient.setSourceDiseaseTypeId2(diagnosisInfo.getDiseaseTypeId());
							patient.setConfirmedDate2(diagnosisInfo.getVisitTime());
							break;
						case 2:
							patient.setSourceDiseaseCode3(diagnosisInfo.getDiseaseCode());
							if (diagnosisInfo.getDiseaseTypeId() == null) {
								PageHelper.startPage(1, 1);
								MetaRDiseaseTypeIcd10 metaRDiseaseTypeIcd10 = this.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
								if (metaRDiseaseTypeIcd10 == null) {
									continue;
								}
								diagnosisInfo.setDiseaseTypeId(metaRDiseaseTypeIcd10.getDiseaseTypeId());
							}
							patient.setSourceDiagnosis3(diagnosisInfo.getDiagnosis());
							patient.setSourceDiseaseTypeId3(diagnosisInfo.getDiseaseTypeId());
							patient.setConfirmedDate3(diagnosisInfo.getVisitTime());
							break;
						}
						if (count == 2) {
							break;
						}
						count++;
					}
					this.patientDao.updateByPrimaryKey(patient);
					flag = true;
				}
			}
			if (flag) {
				//生成随访计划
				// #TODO 需优化，后面执行出错，随访计划无法回滚
				this.createFollowupPlan(patient, null, null, productId);
			}
		}
		return patient;
	}
	
	/**
	 * <p>Title:getDiseaseTypeIdByDiseaseCode</p>
	 * <p>Description:通过ICD编码反查病种</p>
	 * @author YYCHEN
	 * @date 2016年6月17日 上午11:00:20
	 * @param diseaseCode
	 * @return
	 */
	private MetaRDiseaseTypeIcd10 getDiseaseTypeIdByDiseaseCode(String diseaseCode) {
		if (StringUtils.isEmpty(diseaseCode)) {
			return null;
		}
		//使用完整的ICD-10编码查找病种
		PageHelper.startPage(1, 1);
		List<MetaRDiseaseTypeIcd10> diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseCode(0L, diseaseCode, diseaseCode.length());
		if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
			return diseaseTypeICD10s.get(0);
		}
		//使用完整的ICD-10编码的前4位查找病种
		if (diseaseCode.indexOf('.') > 0) {
			PageHelper.startPage(1, 1);
			diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseCode(0L, diseaseCode.substring(0, 5), 5);
			if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
				return diseaseTypeICD10s.get(0);
			}
		}else{
			PageHelper.startPage(1, 1);
			diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseCode(0L, diseaseCode.substring(0, 4), 4);
			if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
				return diseaseTypeICD10s.get(0);
			}
		}
		//使用完整的ICD-10编码的前3位查找病种
		PageHelper.startPage(1, 1);
		diseaseTypeICD10s = this.metaRDiseaseTypeIcd10Dao.findByDiseaseCode(0L, diseaseCode.substring(0, 3), 3);
		if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
			return diseaseTypeICD10s.get(0);
		}
		return null;
	}

	/**
	 * 
	* @Title: matchDoctor 
	* @Description: 注册患者
	* @param 
	* @return TMsgResponse<UserRegisterResp>
	* @throws
	 */
	public Patient registerPatient(User user) {
		Patient patient = new Patient();
		patient.setMobile(user.getUserName());
		patient.setMedicalPayType(0);
		patient.setLiveStatus(1);
		patient.setPatientRelation(0);
		patient.setHasVisibleMedicalRecord(0);
		patient.setSex(0);
		patient.setCreateTime(new Date());
		patient.setUpdateTime(patient.getCreateTime());
		patient.setSyncFlag(Constant.User.SYNCFLAG_NO);
		
		patient.setUserId(user.getUserId());
		this.patientDao.insert(patient);

		// TODO 此处需要调用邀请码信息保存的接口
		// 查询出注册账号的编号

		// TODO 随诊助手推送消息
		// TODO 调用发送短信的公共接口服务
		return patient;
	}

	
	
	//************************Start By fanpanwei **************************************************
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 获取防癌患者列表
	* @return
	 */
	@Override
	public Page<AutiPatientListResp> searchAutiPatientList(
			AutiPatientReq autiPatientReq) {
		Integer num = 10;
		Integer page = 0;
		if (autiPatientReq != null){
			if(autiPatientReq.getNum()==null){
				autiPatientReq.setNum(num);
			}else{
				num = autiPatientReq.getNum();
			}
			if(autiPatientReq.getPage()==null){
				autiPatientReq.setPage(page);
			}else{
				page = autiPatientReq.getPage();
			}
		}else{
			autiPatientReq = new AutiPatientReq();
			autiPatientReq.setNum(num);
			autiPatientReq.setPage(page);
		}
		
		//PageHelper.startPage(page + 1, num);
		//List<AutiPatientListResp> autiPatientList = patientDao.getAutiPatientList(autiPatientReq);
		//List<PatientSimpleInfo> list = patientDao.searchPatientSimpleInfoList(rDoctor.getDoctorId(), reqFlag,rDoctor.getDoctorLevel());
		
		int totalNum =  patientDao.getAutiPatientTotal(autiPatientReq);
		int currPage = page+1;
		int totalPage = (int) Math.ceil((double)totalNum/(double)num);//进位取整
		int currSize = currPage<totalPage?num:(totalNum%num==0?num:totalNum%num);
		//List<TMetaInfoDiseaseTypeIcd> subList = list.subList(req.getPage()*req.getNum(), req.getPage()*req.getNum()+currSize);
		autiPatientReq.setStartIndex(page*num);
		List<AutiPatientListResp> autiPatientList = patientDao.getAutiPatientList(autiPatientReq);
		Page<AutiPatientListResp> page_autiPatient = new Page<AutiPatientListResp>();
		page_autiPatient.setCurrPage(page);
		page_autiPatient.setTotalNum(totalNum);
		page_autiPatient.setTotalPage(totalPage);
		page_autiPatient.setDataList(autiPatientList);
		page_autiPatient.setCurrSize(currSize);
		
		return page_autiPatient;
		//return PageUtil.returnPage((com.github.pagehelper.Page<?>) autiPatientList);
	}
	
	@Override
	public int getAutiPatientTotal(){
		int total = patientDao.getAutiPatientTotal(null);
		return total;
	}

	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 获取对应患者基本信息
	* @return
	 */
	@Override
	public AutiCancerPatientInfo getAutiPatientInfoById(SpecialDiseaseReq req) {
		req.setSpecialDiseaseRegisterId(null);
		AutiCancerPatientInfo autiPatientInfo = patientDao.getAutiPatientInfo(req);
		List<AutiCancerLinkManContact> contactsList = patientFamilyDao.findLinkMan(req);
		if(contactsList!=null)autiPatientInfo.setContactsList(contactsList);
		List<GeneticDiseaseContact> geneticDiseaseList = familyGeneticHistoryDao.findGeneticHistory(req);
		if(geneticDiseaseList!=null)autiPatientInfo.setGeneticDiseaseList(geneticDiseaseList);
		return autiPatientInfo;
	}
	//add by fanpanwei
	@Override
	public int searchPatientByMobile(AutiCancerPatientInfo autiCancerPatientInfo) {
		if(autiCancerPatientInfo!=null){
			Patient existPatient = patientDao.searchPatientByMobile(autiCancerPatientInfo.getMobile());
			if(existPatient!=null){
				if(autiCancerPatientInfo.getPatientId()==null){
					return 1;
				}else{
					if(existPatient.getPatientId().intValue()!=autiCancerPatientInfo.getPatientId().intValue()){
						return 1;
					}
				}
			}
		}
		return 0;
	}
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 保存患者基本信息
	* @return
	 */
	@Override
	@Transactional
	public Map<String,Object> saveAntiCancerPatientInfo(
			AutiCancerPatientInfo autiCancerPatientInfo) {
		Map<String,Object> resultMap = new HashMap<String,Object>();
		Long patientId=null;
		
		if(autiCancerPatientInfo!=null){
			if(autiCancerPatientInfo.getPatientId()!=null){//不是空执行更新操作
				Patient p = patientDao.findById(autiCancerPatientInfo.getPatientId());
				autiCancerPatientInfo.setUserId(p.getUserId());
				userDao.updateAutiCancerUser(autiCancerPatientInfo);
				patientDao.updateAutiPatientInfo(autiCancerPatientInfo);
				patientId = autiCancerPatientInfo.getPatientId();
			}else{//为null执行新增操作
				userDao.insertAutiCancerUser(autiCancerPatientInfo);
				//long userId = autiCancerPatientInfo.getUserId();
				//autiCancerPatientInfo.setUserId(userId);
				patientDao.insertAutiPatientInfo(autiCancerPatientInfo);
				patientId = autiCancerPatientInfo.getPatientId();
			}
			
			//执行删除联系人操作
			/*List<AutiCancerLinkManContact> delContactsList = autiCancerPatientInfo.getDelContactsList();
			if(delContactsList!=null)
			for (Iterator<AutiCancerLinkManContact> iterator = delContactsList.iterator(); iterator
					.hasNext();) {
				AutiCancerLinkManContact delLinkMan = iterator.next();
				
			}*/
			patientFamilyDao.deleteLinkManInfo(patientId,null);
			//开始保存患者联系人信息
			List<AutiCancerLinkManContact> linkMenList = autiCancerPatientInfo.getContactsList();
			if(linkMenList!=null)
			for (Iterator<AutiCancerLinkManContact> iterator = linkMenList.iterator(); iterator
					.hasNext();) {
				AutiCancerLinkManContact linkMan =  iterator.next();
				/*if(linkMan.getId()!=null){//不是空执行更新操作
					linkMan.setPatientId(patientId);
					patientFamilyDao.updateLinkManInfo(linkMan);
				}else{//为null执行新增操作
					linkMan.setPatientId(patientId);
					patientFamilyDao.insertLinkManInfo(linkMan);
				}*/
				linkMan.setPatientId(patientId);
//				linkMan.setSpecialDiseaseRegisterId(autiCancerPatientInfo.getSpecialDiseaseRegisterId());
				if(StringUtils.isBlank(linkMan.getContactId()))
					linkMan.setContactId(GeneralUtil.getSmallUserPicUrl("CONT"));
				patientFamilyDao.insertLinkManInfo(linkMan);
			}
			//执行删除家族遗传史操作
			/*List<GeneticDiseaseContact> delGeneDiseaseList = autiCancerPatientInfo.getDelGeneDiseaseList();
			if(delGeneDiseaseList!=null)
		    for (Iterator<GeneticDiseaseContact> iterator = delGeneDiseaseList.iterator(); iterator
					.hasNext();) {
				GeneticDiseaseContact delGeneticDisease = iterator.next();
				familyGeneticHistoryDao.deleteGeneticHistory(delGeneticDisease);
			}*/
			familyGeneticHistoryDao.deleteGeneticHistory(patientId,null);
			//开始保存家族遗传病史信息
			List<GeneticDiseaseContact> geneticDiseaseList = autiCancerPatientInfo.getGeneticDiseaseList();
			if(geneticDiseaseList!=null)
			for (Iterator<GeneticDiseaseContact> iterator = geneticDiseaseList.iterator(); iterator
					.hasNext();) {
				GeneticDiseaseContact GeneticDisease =  iterator.next();
				/*if(GeneticDisease.getId()!=null){//不是空执行更新操作
					familyGeneticHistoryDao.updateGeneticHistory(GeneticDisease);
				}else{//为null执行新增操作
					GeneticDisease.setPatientId(patientId);
					familyGeneticHistoryDao.insertGeneticHistory(GeneticDisease);
				}*/
				GeneticDisease.setPatientId(patientId);
//				GeneticDisease.setSpecialDiseaseRegisterId(autiCancerPatientInfo.getSpecialDiseaseRegisterId());
				familyGeneticHistoryDao.insertGeneticHistory(GeneticDisease);
			}
			if(autiCancerPatientInfo.getOperateFlag() != null && autiCancerPatientInfo.getOperateFlag() == 1) {
				specialDiseaseRegisterDao.insertSpecialDisease(autiCancerPatientInfo);
				patientDao.updateAutiPatientInfo(autiCancerPatientInfo);
			}else {
				specialDiseaseRegisterDao.updateSpecialDisease(autiCancerPatientInfo);
			}
			resultMap.put("patientId", patientId);
			resultMap.put("specialDiseaseRegisterId", autiCancerPatientInfo.getSpecialDiseaseRegisterId());
		}
		return resultMap;
	}
	
	//获取防癌患者审批信息
	@Override
	public AutiPatientApproveInfo getAutiPatientApproveInfoById(SpecialDiseaseReq req) {
		AutiPatientApproveInfo approveInfo = specialApprovalDao.getAutiPatientApproveInfo(req);
		return approveInfo;
	}

	@Override
	public void saveAntiPatientApproveInfo(
			AutiPatientApproveInfo autiPatientApproveInfo) {
		if(autiPatientApproveInfo!=null){
			if(autiPatientApproveInfo.getApprovalId()!=null){//不是空执行更新操作
				//表：special_disease_ approval
				specialApprovalDao.updateAutiPatientApproveInfo(autiPatientApproveInfo);
			}else{//为null执行新增操作
				specialApprovalDao.insertAutiPatientApproveInfo(autiPatientApproveInfo);	
			}
		}
	}

	@Override
	public Page<SpecialDiseaseResp> getSpecialDiseaseRecord(SpecialDiseaseReq specialDiseaseReq) {

		Integer num = 10;
		Integer page = 0;
		if (specialDiseaseReq != null){
			if(specialDiseaseReq.getNum()==null){
				specialDiseaseReq.setNum(num);
			}else{
				num = specialDiseaseReq.getNum();
			}
			if(specialDiseaseReq.getPage()==null){
				specialDiseaseReq.setPage(page);
			}else{
				page = specialDiseaseReq.getPage();
			}
		}else{
			specialDiseaseReq = new SpecialDiseaseReq();
			specialDiseaseReq.setNum(num);
			specialDiseaseReq.setPage(page);
		}
		int totalNum =  patientDao.getSpecialDiseaseTotal(specialDiseaseReq);
		int currPage = page+1;
		int totalPage = (int) Math.ceil((double)totalNum/(double)num);//进位取整
		int currSize = currPage<totalPage?num:(totalNum%num==0?num:totalNum%num);
		specialDiseaseReq.setStartIndex(page*num);
		List<SpecialDiseaseResp> autiPatientList = patientDao.getSpecialDiseaseList(specialDiseaseReq);
		Page<SpecialDiseaseResp> page_specialDisease = new Page<SpecialDiseaseResp>();
		page_specialDisease.setCurrPage(page);
		page_specialDisease.setTotalNum(totalNum);
		page_specialDisease.setTotalPage(totalPage);
		page_specialDisease.setDataList(autiPatientList);
		page_specialDisease.setCurrSize(currSize);
		
		return page_specialDisease;
	/*	PageHelper.startPage(page + 1, num);
		List<SpecialDiseaseResp> autiPatientList = patientDao.getSpecialDiseaseList(specialDiseaseReq);
		return PageUtil.returnPage((com.github.pagehelper.Page<?>) autiPatientList);*/
	}
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 导出防癌患者列表
	* @return
	 */
	@Override
	public String exportAutiPatientList(AutiPatientReq  autiPatientReq,String outFilePath) {
		String fileName="AutiCancerPatientList";
		String[] heads = null;
		String[] columns = null;
		//String headsStr="患者ID,首诊医院,姓名,性别,电话,身份证号,医保类型,参保地区,主要诊断,特病诊断,诊断依据,诊断医生,出院诊断";
		String headsStr="序号,姓名,性别,电话,身份证号,医保类型,参保地区,特病诊断,诊断依据,诊断医生,首诊医院|门诊号,出院诊断";
		String fieldsStr="rowno,patientName,sex,mobile,idNo,medicalCareType,";
		//fieldsStr+="medicalCareArea,sourceDiagnosis1,specialDiseaseDiagnosis,diagnosisBasis,doctorName,outdiagnosis";
		fieldsStr+="medicalCareArea,specialDiseaseDiagnosis,diagnosisBasis,doctorName,firstHospital,outdiagnosis";
		heads = headsStr.split(",");
		columns = fieldsStr.split(",");
		
		StringBuffer str=new StringBuffer("SELECT (@rowNO := @rowNo+1) AS rowno,p.trueName patientName,");
			str.append("CASE p.sex WHEN 1 THEN '男' ELSE '女' END sex,p.mobile,CONCAT(u.identification,'\t') idNo,epc.payChannelName medicalCareType,");
			str.append("mc.cityName medicalCareArea,");//met.diagnosisTypeName sourceDiagnosis1,");
			str.append("msd.specialDiseaseDiagnosisName specialDiseaseDiagnosis,");
			str.append("edi.diseaseBasis diagnosisBasis,edi.diagnosisDoctorName doctorName,CONCAT(edi.firstdiagnosisHospitalName,'|',edi.clinicNo) firstHospital,edi.outhospitalDiagnosis outdiagnosis ");
			str.append(" FROM user_db.u_patient p ");
			if(autiPatientReq!=null&&autiPatientReq.getFirstHospitalId()!=null){
				str.append(" INNER JOIN ehr_db.e_diagnosis_info edi ON p.patientId=edi.patientId  and edi.diagnosisTypeId=1  and p.specialDiseaseRegisterId=edi.specialDiseaseRegisterId and edi.firstdiagnosisHospitalId="+autiPatientReq.getFirstHospitalId());
			}else{
				str.append(" LEFT JOIN ehr_db.e_diagnosis_info edi ON p.patientId=edi.patientId  and edi.diagnosisTypeId=1  and p.specialDiseaseRegisterId=edi.specialDiseaseRegisterId ");
			}
			str.append(" LEFT JOIN user_db.u_user u ON u.userId=p.userId ");
			str.append(" LEFT JOIN user_db.meta_city mc ON mc.cityCode=p.medicalCareAreaId ");
			str.append(" LEFT JOIN ehr_db.meta_special_disease_diagnosis msd ON msd.specialDiseaseDiagnosisId=edi.specialDiseaseDiagnosisId ");
			//str.append(" LEFT JOIN ehr_db.meta_e_diagnosis_type met ON met.diagnosisTypeId=edi.diagnosisTypeId ");
			str.append(" LEFT JOIN ehr_db.meta_e_pay_channel epc ON epc.payChannelId=p.medicalPayType");
			str.append(" INNER JOIN (select @rowNO :=0) b ");
			str.append(" WHERE p.patientType=2 ");
			if(autiPatientReq!=null){
				if(StringUtils.isNotBlank(autiPatientReq.getPatientName())){
					str.append(" AND p.trueName like '%"+autiPatientReq.getPatientName()+"%'");
				}
				if(StringUtils.isNotBlank(autiPatientReq.getMedicalcareCardNo())){
					str.append(" AND p.medicareCardNo like '%"+autiPatientReq.getMedicalcareCardNo()+"%'");
				}
				if(StringUtils.isNotBlank(autiPatientReq.getIdNo())){
					str.append(" AND u.identification like '%"+autiPatientReq.getIdNo()+"%'");
				}
			}
		String url = exportUtilService.exportFile(str.toString(), outFilePath, heads, columns,fileName);
		return url;
	}
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 导出防癌患者特病记录
	* @return
	 */
	@Override
	public String exportSpecialDiseaseRecord(SpecialDiseaseReq specialDiseaseReq,String outFilePath) {
		String fileName="SpecialDiseaseRecordList";
		String[] heads = null;
		String[] columns = null;
		String headsStr="序号,姓名,性别,年龄,医保类型,参保地区,特病诊断,诊断依据,诊断医生,首诊医院|门诊号,登记日期,现场咨询建议";
		String fieldsStr="rowno,patientName,sex,age,medicalCareType,medicalCareArea,specialDiseaseDiagnosis,diagnosisBasis,";
		fieldsStr+="diagnosisDoctorName,firstdiagnosisHospitalName,handleDate,advice";
		heads = headsStr.split(",");
		columns = fieldsStr.split(",");
		
		StringBuffer str=new StringBuffer("SELECT (@rowNO := @rowNo+1) AS rowno,p.trueName patientName,CASE p.sex WHEN 1 THEN '男' ELSE '女' END sex,");
		str.append("DATE_FORMAT(NOW(), '%Y') - DATE_FORMAT(u.birthDate, '%Y') - (DATE_FORMAT(NOW(), '00-%m-%d') < DATE_FORMAT(u.birthDate, '00-%m-%d'))  age,");
		str.append("epc.payChannelName medicalCareType, mc.cityName medicalCareArea,");
		str.append("sdd.specialDiseaseDiagnosisName specialDiseaseDiagnosis,edi.diseaseBasis diagnosisBasis,");
		str.append("edi.diagnosisDoctorName,CONCAT(edi.firstdiagnosisHospitalName,'|',edi.clinicNo) firstdiagnosisHospitalName,");
		str.append("sda.updateTime handleDate,sdt.sdtName advice");
		str.append(" FROM user_db.u_patient p");
		str.append(" LEFT JOIN user_db.u_user u ON u.userid=p.userid");
		str.append(" LEFT JOIN user_db.u_patient_special_disease_register t9 ON p.patientId=t9.patientId");
		str.append(" LEFT JOIN ehr_db.e_diagnosis_info edi ON edi.patientId=p.patientId  AND t9.specialDiseaseRegisterId=edi.specialDiseaseRegisterId and edi.diagnosisTypeId=1 ");
		str.append(" LEFT JOIN ehr_db.meta_special_disease_diagnosis sdd ON sdd.specialDiseaseDiagnosisId=edi.specialDiseaseDiagnosisId");
		str.append(" LEFT JOIN followup_db.special_disease_approval sda ON sda.patientId=p.patientId AND t9.specialDiseaseRegisterId=sda.specialDiseaseRegisterId ");
		str.append(" LEFT JOIN followup_db.meta_special_disease_treatment sdt ON sdt.sdtId=sda.adviceId");
		str.append(" LEFT JOIN user_db.meta_city mc ON mc.cityCode=p.medicalCareAreaId");
		str.append(" LEFT JOIN ehr_db.meta_e_pay_channel epc ON epc.payChannelId=p.medicalPayType");
		str.append(" INNER JOIN (select @rowNO :=0) b ");
		str.append(" WHERE p.patientType=2");
		if(specialDiseaseReq!=null){
			if(StringUtils.isNotBlank(specialDiseaseReq.getPatientName())){
				str.append(" AND p.trueName like '%"+specialDiseaseReq.getPatientName()+"%'");
			}
			if(StringUtils.isNotBlank(specialDiseaseReq.getSpecialDiseaseDiagnosis())){
				str.append(" AND sdd.specialDiseaseDiagnosisName like '%"+specialDiseaseReq.getSpecialDiseaseDiagnosis()+"%'");
			}
			if(specialDiseaseReq.getBeginDate()!=null){
				str.append(" AND DATE_FORMAT(sda.updateTime,'%Y-%m-%d')>=DATE_FORMAT('"+specialDiseaseReq.getBeginDate()+"','%Y-%m-%d')");
			}
			if(specialDiseaseReq.getEndDate()!=null){
				str.append(" AND DATE_FORMAT(sda.updateTime,'%Y-%m-%d')<=DATE_FORMAT('"+specialDiseaseReq.getEndDate()+"','%Y-%m-%d')");
			}
			
		}
		String url = exportUtilService.exportFile(str.toString(), outFilePath, heads, columns,fileName);
		return url;
	}
	
	/**
	 * 
	* @author fanpanwei
	* @date 2016年9月23日
	* @param 
	* @description 获取特病诊治及建议元数据元
	* @return
	 */
	@Override
	public List<AutiCancerTreatmentsInfo> queryTreatmentMethods(
			AutiCancerTreatmentsInfo treatmentsInfo) {
		List<AutiCancerTreatmentsInfo> treatmentsList = patientDao.getTreatmentMethods(treatmentsInfo);
		return treatmentsList;
	}
	//************************End By fanpanwei **************************************************

	@Override
	public void uploadPatientIDFileUrl(UserInfo user) {
		patientDao.updateUserByPatientId(user);
		
		if(!StringUtils.isBlank(user.getPatientNo())){
			updatePatientNo(user);
		}
	}

	@Override
	public void updatePatientNo(UserInfo user) {
		Integer hospitalId=doctorDao.selectDoctorHospitalBydoctorId(user.getDoctorId());
		Integer result=patientDao.findPatientHospital(user.getPatientId(),hospitalId);
		if(result<0){
			patientDao.insertPatientHospital(user,hospitalId);
		}else{
			patientDao.updatePatientNo(user,hospitalId);
		}
	}

	@Override
	public List<TPatientNoInfo> getPatientNoList(PatientNoListReq req) {
		if(req==null||req.getPatientId()==null)
			throw new EmptyParamExcption("param error");
		return patientDao.queryPatientNoList(req);
	}



	@Override
	public void mergerPatient(User cloudUser, User tobUser, Patient cloudPatient, Patient tobPatient) {
		// TODO Auto-generated method stub
//		Map<String, Number> params = new HashMap<String, Number>(3);
//		params.put("cloudPatientId", cloudPatient.getPatientId());
//		params.put("tobPatientId", tobPatient.getPatientId());
//		this.patientDao.mergeTobPatientInfoToFormalPatientInfo(params);
		//如果ToC患者同tob患者原发病种不一致 删除ToC患者的随访计划
//		if (cloudPatient.getSourceDiseaseTypeId() != tobPatient.getSourceDiseaseTypeId())
//			this.patientDao.cleanCloudPatientFollowupPlan(cloudPatient.getPatientId());
		if(StringUtils.isNotBlank(cloudUser.getUuid())&&StringUtils.isNotBlank(tobUser.getUuid())&&!cloudUser.getUuid().equals(tobUser.getUuid())){
			MatchUserMergeReq req = new MatchUserMergeReq(tobUser.getUuid(), cloudUser.getUuid(), Constant.User.ROLE_PATIENT);
			matchMergeUtil.matchUserMergeRequest(req);
		}
		else{//废弃代码
			//合并医患关系
			this.doctorPatientService.mergeDoctorPatient(cloudPatient, tobPatient);
			//合并医院患者关系
			this.hospitalPatientService.mergeHospitalPatient(cloudPatient, tobPatient);
			//合并患者家属信息
			this.patientFamilyService.mergePatientFamily(cloudPatient.getPatientId(), tobPatient.getPatientId());
			
			//删除患者数据
			this.patientDao.deletePatientByUserId(tobPatient.getUserId());
			//删除用户数据
			this.userDao.deleteByPrimaryKey(tobUser.getUserId());
			
			cloudPatient.setSyncFlag(Constant.SYNC_OK);
			//合并患者信息
			this.mergePatient(cloudPatient, tobPatient);
			//合并用户信息
			this.userService.mergeToBPatientUserInfo(cloudUser, tobUser);
			
			if (StringUtils.isEmpty(cloudPatient.getUuid())) {
				cloudPatient.setUuid(cloudUser.getUuid());
				this.patientDao.updateByPrimaryKey(cloudPatient);
			}
			//建立uuid映射关系
			this.uuidRelationshipService.saveUuidMapper(cloudUser, tobUser.getUuid());
		}
		//补充随访计划
		this.certificateFollowupPlan(cloudPatient.getPatientId());
	}

	@Override
	public int isExistsIdentification(SpecialDiseaseReq req) {
		Long patientId = patientDao.isExistsIdentification(req);
		if(patientId != null) {
			if(req.getPatientId() != null) {//查看和登记
				if(req.getPatientId() == patientId) {
					return 0;
				}
			}
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public Map<String,Object> findPatientHospitalPhone(PatientHospitalCertificateReq patientSimpleInfo) {
		if (patientSimpleInfo.getPatientId() == null || patientSimpleInfo.getHospitalId()==null || patientSimpleInfo.getPatientNo()==null ||StringUtils.isEmpty(patientSimpleInfo.getTrueName())) {
			throw new EmptyParamExcption("The parameters can not be empty! patientId=" + patientSimpleInfo.getPatientId() + "!");
		}
		Patient patient = this.patientDao.findById(patientSimpleInfo.getPatientId());
		if (patient == null) {
			throw new EmptyObjectExcption("Patient is empty!");
		}
		Map<String,Object> map=new HashMap<String,Object>();
		//条件查询
		PatientHospitalCertificateInfo info = hospitalPatientDao.checkPatientNoInRelation(patientSimpleInfo);
		PatientHospitalCertificateInfo info1 = hospitalPatientDao.checkPatientNoInMatchRelation(patientSimpleInfo);
		if(info==null&&info1==null){//病案号不存在云端和B端
			map.put("errorCode",-1);
		}else if(info!=null){//存在云端
			if(info.getTrueName()!=null){
				List<String> phones=patientDao.findPatientFamilyPhone(info.getPatientId(),3);
				if(phones!=null&&phones.size()>0){
					map.put("errorCode",0);
					map.put("phoneList",phones);
				}else{
					map.put("errorCode",-3);
				}
			}else{
				map.put("errorCode",-2);
			}
		}else{//存在B端
			info = info1;
			if(info.getTrueName()!=null){//判断姓名是否匹配
				List<String> phones=patientDao.findSyncMatchPatientFamilyPhone(info.getPatientUuid(),3);
				if(phones!=null&&phones.size()>0){
					map.put("errorCode",0);
					map.put("phoneList",phones);
				}else{
					map.put("errorCode",-3);
				}
			}else{//姓名不匹配，待确认合并
				map.put("errorCode",-2);
			}
		}
		return map;
	}

	@Override
	public PatientBaseDataStatistics getPatientBaseDataBydoctorId(Long doctorId){
		// TODO Auto-generated method stub
		TPatientSearchInfo req = new TPatientSearchInfo();
		TRDoctor doctor = doctorService.getTRDoctorByDoctorId(doctorId);
		if(doctor!=null){
			req.setDoctorId(doctorId);
			req.setDoctorLevel(doctor.getDoctorLevel());
		}
		
		PatientBaseDataStatistics patientBaseDataStatistics = patientDao.getPatientBaseDataBydoctorId(req);
		PatientBaseDataStatistics followupStatistics = patientDao.getFollowupStatisticsBydoctorId(req);
		
		if(followupStatistics==null)return patientBaseDataStatistics;
			
		patientBaseDataStatistics.setValidFollowupTotal(followupStatistics.getValidFollowupTotal());
		patientBaseDataStatistics.setStabileTotal(followupStatistics.getStabileTotal());
		patientBaseDataStatistics.setRecidivationTotal(followupStatistics.getRecidivationTotal());
		patientBaseDataStatistics.setMetastaticTotal(followupStatistics.getMetastaticTotal());
		patientBaseDataStatistics.setDeathTotal(followupStatistics.getDeathTotal());
	
		return patientBaseDataStatistics;
	}

	@Override
	public Map<String, Object> getPatientCertificateFlag(Long patientId) {
		if(patientId==null){
			throw new EmptyParamExcption("patientId is null");
		}
		Integer certificateFlag=patientDao.getPatientCertificateFlag(patientId);
		if(certificateFlag==null){
			certificateFlag=0;
		}
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("certificateFlag",certificateFlag);
		return map;
	}
}
