package com.esuizhen.cloudservice.sync.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TPatientAndPatientNoRelationSync;
import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.bean.TPatientWeixinOpenIdInfo;
import com.esuizhen.cloudservice.sync.bean.TSyncResultNotify;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncrePatientContactInfoDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncrePatientDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncrePatientPatientNoDao;
import com.esuizhen.cloudservice.sync.dao.incre.IncreUserDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientContacInfoDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUserDao;
import com.esuizhen.cloudservice.sync.model.HospitalPatient;
import com.esuizhen.cloudservice.sync.service.CheckBeforeSyncService;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.esuizhen.cloudservice.sync.service.TxPatientPatientNoService;
import com.esuizhen.cloudservice.sync.txservice.TxPatientService;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.excption.HospitalWithoutRightExcption;
import com.westangel.common.service.FollowupService;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PageUtil;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	private IncreUserDao increUserDao;
	@Autowired
	private IncrePatientDao increPatientDao;
	@Autowired
	private IncrePatientContactInfoDao increPatientContactInfoDao;
	@Autowired
	private IncreHospitalPatientDao increHospitalPatientDao;
	@Autowired
	private IncrePatientPatientNoDao increPatientPatientNoDao;

	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private CloudHospitalPatientDao cloudHospitalPatientDao;
	
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private MatchPatientContacInfoDao matchPatientContacInfoDao;
	@Autowired
	private MatchUserDao matchUserDao;
	@Autowired
	private MatchHospitalPatientDao matchHospitalPatientDao;
	@Autowired
	private CheckBeforeSyncService checkBeforeSyncService;

	@Resource(name="followupService")
	private FollowupService followupService;
	@Resource(name="patientService")
	private com.westangel.common.service.PatientService userSystemPatientService;
	
	@Autowired
	private TxPatientService txPatientService;
	@Autowired
	private TxPatientPatientNoService txPatientPatientNoService;
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;
	
	private static boolean RUNING_FLAG = false;
	
	/**
	 * @param patientSyncProfile
	 * @return
	 * @throws HospitalWithoutRightExcption 
	 */
	@Override
	public boolean syncPatientInfo(TPatientSyncProfile patientSyncProfile) throws HospitalWithoutRightExcption{
		if(patientSyncProfile==null||!checkBeforeSyncService.checkHospitalId(patientSyncProfile.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		if (patientSyncProfile.getPatientContactList() == null) {
			patientSyncProfile.setPatientContactList(new ArrayList<TPatientContactInfo>());
		}
		//将数据保存到增量库
		this.saveIncreUserAndPatient(patientSyncProfile);
		return this.txPatientService.syncPatientInfo(patientSyncProfile);
	}
	
	
	/**
	 * 将数据保存到匹配中间库
	 * @param patientSyncProfile
	 * @return
	 */
	public boolean saveMatchUserAndPatient(TPatientSyncProfile patientSyncProfile){
		LogUtil.log.debug("Sync patient data to the Middle Library--------->>");
		//判断是否有未处理的数据
		User user = this.matchUserDao.findByUuid(patientSyncProfile.getUuid());
		if (user != null) {
			return false;
		}
		//User数据保存
		user = patientSyncProfile.createUser();
		this.matchUserDao.insert(user);
		//患者数据保存
		Patient patient = patientSyncProfile.createPatient();
		patient.setUserId(user.getUserId());
		this.matchPatientDao.insert(patient);
		//联系人数据保存
		List<TPatientContactInfo> patientContactList = patientSyncProfile.getPatientContactList();
		if (patientContactList != null && !patientContactList.isEmpty()) {
			for (int i = 0, size = patientContactList.size(); i < size; i++) {
				TPatientContactInfo patientContactInfo = patientContactList.get(i);
				patientContactInfo.setPatientId(patient.getPatientId());
				patientContactInfo.setPatientUuid(patient.getUuid());
				if(patientContactInfo.getCreateTime()==null){
					patientContactInfo.setCreateTime(new Date());
				}
				if (patientContactInfo.getFamilyPhone() != null) {
					String mobile = patientContactInfo.getFamilyPhone();
					if (mobile.length() > 15) {
						if (mobile.startsWith("1")) {
							patientContactInfo.setFamilyPhone(mobile.substring(0, 11));
						} else {
							patientContactInfo.setFamilyPhone(mobile.substring(0, 15));
						}
					}
				}
				
				this.matchPatientContacInfoDao.insert(patientContactInfo);
			}
		}
		//保存医院、患者关系
		HospitalPatient hospitalPatient = patientSyncProfile.createHospitalPatient();
		this.matchHospitalPatientDao.insert(hospitalPatient);
		LogUtil.log.debug("Synchronization patient data is saved to the middle of the library to complete---------<<");
		return true;
	}

	/**
	 * 将需同步的患者数据保存到增量数据库
	 * @param patientSyncProfile
	 * @return
	 */
	private boolean saveIncreUserAndPatient(TPatientSyncProfile patientSyncProfile){
		LogUtil.log.debug("Sync patient data to the incremental Library---------->>");
		Date nowTime = new Date();
		if(patientSyncProfile.getCreateTime()==null)
			patientSyncProfile.setCreateTime(nowTime);
		if(patientSyncProfile.getUpdateTime()==null)
			patientSyncProfile.setUpdateTime(nowTime);
		patientSyncProfile.setSyncTime(nowTime);
		//保存User数据
		User user = patientSyncProfile.createUser();
		this.increUserDao.insert(user);
		//保存患者数据
		Patient patient = patientSyncProfile.createPatient();
		patient.setUserId(user.getUserId());
		this.increPatientDao.insert(patient);
		//保存患者联系人数据
		List<TPatientContactInfo> patientContactList = patientSyncProfile.getPatientContactList();
		if (patientContactList != null && !patientContactList.isEmpty()) {
			for (int i = 0, size = patientContactList.size(); i < size; i++) {
				TPatientContactInfo patientContactInfo = patientContactList.get(i);
				patientContactInfo.setPatientId(patient.getPatientId());
				patientContactInfo.setPatientUuid(patient.getUuid());
				this.increPatientContactInfoDao.insert(patientContactInfo);
			}
		}
		//保存医院、患者关系
		HospitalPatient hospitalPatient = patientSyncProfile.createHospitalPatient();
		this.increHospitalPatientDao.insert(hospitalPatient);
		LogUtil.log.debug("Synchronous patient data is saved to the incremental database to complete----------<<");
		return true;
	}
	
	/**
	 * 获取微信患者增量
	 * @throws HospitalWithoutRightExcption 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<TPatientWeixinOpenIdInfo> getIncrWeixinPatients(Integer hospitalId, Integer pageIndex, Integer pageSize) throws HospitalWithoutRightExcption {
		if(!checkBeforeSyncService.checkHospitalId(hospitalId)){
			throw new HospitalWithoutRightExcption();
		}
		PageHelper.startPage(pageIndex + 1, pageSize);
		List<TPatientWeixinOpenIdInfo> followupResultDetailInfos = this.cloudPatientDao.getIncrWeixinPatientOfHospital(hospitalId);
		return PageUtil.returnPage((com.github.pagehelper.Page<TPatientWeixinOpenIdInfo>)followupResultDetailInfos);
	}

	/**
	 * 设置微信同步标记
	 */
	@Override
	public void setWeixinSyncedFlag4Uuids(TSyncResultNotify notify) {
		if (notify.getUuids() == null || notify.getUuids().isEmpty()) {
			return;
		}
		//修改医院、患者关系的同步时间
		this.cloudHospitalPatientDao.setWeixinSyncedFlag4Uuids(notify.getUuids());
	}

	@Override
	public TConfirmUserResp confirmPateint(TConfirmUserReq confirmReq) {
		if (confirmReq.getIsConfirmed() == null) {
			throw new EmptyParamExcption("isConfirmed is empty!");
		}
		User user = null;
		//确认是本人
		if (confirmReq.getIsConfirmed() == 1) {
			//合并数据
			user = this.txPatientService.mergePatient(confirmReq.getUuid(), confirmReq.getUserId(), false);
			//给患者开启随访计划
			this.userSystemPatientService.enableFollowupPlan(this.cloudPatientDao.findByUserId(user.getUserId()));
		} else {
			matchUserDao.updateAccountType(confirmReq.getUuid(), Constant.User.ACCOUNTTYPE_REFUSE);
			user = this.cloudUserDao.findByUserId(confirmReq.getUserId(), Constant.User.ROLE_PATIENT);
			Map<String,Object> params = new HashMap<String,Object>();
			params.put("targetUserId", confirmReq.getUserId());
			params.put("matchUuid", confirmReq.getUuid());
			params.put("affirm", -1);
			matchPatientDao.setAffirm(params);
		}
		Patient patient = this.cloudPatientDao.findByUserId(user.getUserId());
		TConfirmUserResp resp = new TConfirmUserResp();
		resp.setUserId(user.getUserId());
		resp.setInfoState(user.getInfoState());
		resp.setPatientId(patient.getPatientId());
		resp.setAccountType(user.getAccountType());
		resp.setRegisterFlag(1);
		return resp;
	}
	
	@Transactional
	@Override
	public boolean setPatientDeathState(Long patientId, Date deathDate){
		Patient patient = this.cloudPatientDao.findById(patientId);
		if (patient == null) {
			return false;
		}
		if (patient.getLiveStatus() == Constant.User.LIVESTATUS_DEATH) {
			return true;
		}
		patient.setLiveStatus(Constant.User.LIVESTATUS_DEATH);
		patient.setDeathDate(deathDate);
		this.cloudPatientDao.setPatientDeatch(patient);
		return true;
	}
	
	@Override
	public boolean setPatientDeathState(Long patientId, Date deathDate,
			String deathCause, Integer isInHospitalDeath, Integer isTumourDeath) {
		// TODO Auto-generated method stub
		Patient patient = this.cloudPatientDao.findById(patientId);
		if (patient == null) {
			return false;
		}
		if (patient.getLiveStatus() == Constant.User.LIVESTATUS_DEATH) {
			return true;
		}
		patient.setLiveStatus(Constant.User.LIVESTATUS_DEATH);
		patient.setDeathDate(deathDate);
		patient.setDeathCause(deathCause);
		patient.setIsInHospitalDeath(isInHospitalDeath);
		patient.setIsTumourDeath(isTumourDeath);
		this.cloudPatientDao.setPatientDeatch(patient);
		return true;
	}

	@Override
	public boolean transferDataToCloud(){
		if (!RUNING_FLAG) {
			PatientServiceImpl.RUNING_FLAG = true;
			new Thread(){
				public void run() {
					transferData();
					PatientServiceImpl.RUNING_FLAG = false;
				}
			}.start();
		}
		return true;
	}
	
	private boolean transferData(){
		int sum = 0, num = 50;
		//处理住院信息
		for(int i = 0; i < 10; i++){
			PageHelper.startPage(i + 1, num);
			List<Patient> patients = this.matchPatientDao.findNotCombinedInhospital();
			if (patients == null || patients.isEmpty()) {
				break;
			}
			for (Patient patient : patients) {
				try {
					//合并数据
					this.txPatientService.mergePatient(patient.getUuid(), patient.getUserId(), true);
					//给患者开启随访计划
					this.userSystemPatientService.enableFollowupPlan(patient);
					sum++;
				} catch (Exception e) {
					LogUtil.logError.error("Combined information error:" + e.getMessage());
				}
			}
		}
		LogUtil.log.debug("------------ inhospital: Merge information " + sum + " ------------");
		//处理随访信息
		sum = 0;
		for(int i = 0; i < 10; i++){
			PageHelper.startPage(i + 1, num);
			List<Patient> patients = this.matchPatientDao.findNotCombinedFollowupResult();
			if (patients == null || patients.isEmpty()) {
				break;
			}
			for (Patient patient : patients) {
				try {
					//合并数据
					this.txPatientService.mergePatient(patient.getUuid(), patient.getUserId(), true);
					//给患者开启随访计划
					this.userSystemPatientService.enableFollowupPlan(patient);
					sum++;
				} catch (Exception e) {
					LogUtil.logError.error("Combined information error:" + e.getMessage());
				}
			}
		}
		LogUtil.log.debug("------------ followupResult: Merge information " + sum + " ------------");
		//处理诊断信息
		sum = 0;
		for(int i = 0; i < 10; i++){
			PageHelper.startPage(i + 1, num);
			List<Patient> patients = this.matchPatientDao.findNotCombinedDiagnosis();
			if (patients == null || patients.isEmpty()) {
				break;
			}
			for (Patient patient : patients) {
				try {
					//合并数据
					this.txPatientService.mergePatient(patient.getUuid(), patient.getUserId(), true);
					//给患者开启随访计划
					this.userSystemPatientService.enableFollowupPlan(patient);
					sum++;
				} catch (Exception e) {
					LogUtil.logError.error("Combined information error:" + e.getMessage());
				}
			}
		}
		LogUtil.log.debug("------------ diagnosis: Merge information " + sum + " ------------");
		//处理手术信息
		sum = 0;
		for(int i = 0; i < 10; i++){
			PageHelper.startPage(i + 1, num);
			List<Patient> patients = this.matchPatientDao.findNotCombinedSurgery();
			if (patients == null || patients.isEmpty()) {
				break;
			}
			for (Patient patient : patients) {
				try {
					//合并数据
					this.txPatientService.mergePatient(patient.getUuid(), patient.getUserId(), true);
					//给患者开启随访计划
					this.userSystemPatientService.enableFollowupPlan(patient);
					sum++;
				} catch (Exception e) {
					LogUtil.logError.error("Combined information error:" + e.getMessage());
				}
			}
		}
		LogUtil.log.debug("------------ surgery: Merge information " + sum + " ------------");
		return true;
	}
	
	/**
	 * 患者病案号同步接口
	 * @throws HospitalWithoutRightExcption 
	 */
	@Override
	public void syncPatientOfPatientNoRelation(TPatientAndPatientNoRelationSync patientOfPatientNo) throws HospitalWithoutRightExcption {
		if(patientOfPatientNo==null||!checkBeforeSyncService.checkHospitalId(patientOfPatientNo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		// TODO Auto-generated method stub
		//保存到增量库
		this.saveIncreUserAndPatient(patientOfPatientNo);
		//进行匹配
		this.txPatientPatientNoService.syncPatientPatientNo(patientOfPatientNo);
	}

	private void saveIncreUserAndPatient(TPatientAndPatientNoRelationSync patientOfPatientNo) {
		// TODO Auto-generated method stub
		if(patientOfPatientNo.getCreateTime()==null)
			patientOfPatientNo.setCreateTime(new Date());
		this.increPatientPatientNoDao.insert(patientOfPatientNo);
	}


	/**
	 * 同步患者联系人信息
	 * fanpanwei
	 */
	@Override
	public void syncPatientContactInfo(TPatientContactInfo tPatientContactInfo)
			throws HospitalWithoutRightExcption {
		// TODO Auto-generated method stub
		if(tPatientContactInfo==null||!checkBeforeSyncService.checkHospitalId(tPatientContactInfo.getHospitalId())){
			throw new HospitalWithoutRightExcption();
		}
		//1.插入增量库
		this.increPatientContactInfoDao.insert(tPatientContactInfo);
		//2.插入正式或者匹配库
		this.txPatientService.syncPatientContactInfo(tPatientContactInfo);
		
	}


	@Override
	public Map<String, Object> getWxUser(String uuid) {
		return cloudPatientDao.getWxUser(uuid);
	}
}
