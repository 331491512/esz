package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.http.client.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TPatientContactInfo;
import com.esuizhen.cloudservice.sync.bean.TPatientSyncProfile;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDiagnosisInfoDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDiseaseTypeICD10Dao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMetaCDiseaseTypeDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudMetaEIcd10Dao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientContacInfoDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudVarPatientFollowupDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchHospitalPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientContacInfoDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUserDao;
import com.esuizhen.cloudservice.sync.model.DiagnosisInfo;
import com.esuizhen.cloudservice.sync.model.DiseaseTypeICD10;
import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.esuizhen.cloudservice.sync.model.Hospital;
import com.esuizhen.cloudservice.sync.model.HospitalPatient;
import com.esuizhen.cloudservice.sync.service.DiseaseTypeICD10Service;
import com.esuizhen.cloudservice.sync.service.HospitalPatientService;
import com.esuizhen.cloudservice.sync.service.PatientService;
import com.esuizhen.cloudservice.sync.service.TxPatientPatientNoService;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxClinicMedicalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxDiagnosisInfoService;
import com.esuizhen.cloudservice.sync.txservice.TxFollowupService;
import com.esuizhen.cloudservice.sync.txservice.TxInhospitalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxOutHospitalNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxPatientService;
import com.esuizhen.cloudservice.sync.txservice.TxSurgeryNoteService;
import com.esuizhen.cloudservice.sync.txservice.TxTreatmentNoteService;
import com.esuizhen.cloudservice.sync.txservice.check.PatientCheck;
import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.bean.ehr.MetaCDiseaseType;
import com.westangel.common.bean.ehr.MetaEicd10;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.service.PushInnerService;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;
import com.westangel.common.util.PushUtil;
import com.esuizhen.common.util.match.MatchMergeUtil;

@Service
public class TxPatientServiceImpl implements TxPatientService {
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudPatientContacInfoDao cloudPatientContacInfoDao;
	@Autowired
	private CloudHospitalPatientDao cloudHospitalPatientDao;
	@Autowired
	private CloudHospitalDao cloudHospitalDao;
	@Autowired
	private CloudDoctorPatientDao cloudDoctorPatientDao;
	@Autowired
	private CloudDiagnosisInfoDao cloudDiagnosisInfoDao;
	@Autowired
	private CloudDiseaseTypeICD10Dao cloudDiseaseTypeICD10Dao;
	@Autowired
	private CloudMetaEIcd10Dao cloudMetaEIcd10Dao;
	@Autowired
	private CloudVarPatientFollowupDao varPatientFollowupDao;
	@Autowired
	private CloudMetaCDiseaseTypeDao cloudMetaCDiseaseTypeDao;
	@Autowired
	private PatientCheck patientCheck;
	@Autowired
	private MatchPatientDao matchPatientDao;
	@Autowired
	private MatchPatientContacInfoDao matchPatientContacInfoDao;
	@Autowired
	private MatchUserDao matchUserDao;
	@Autowired
	private MatchDoctorPatientDao matchDoctorPatientDao;
	@Autowired
	private MatchHospitalPatientDao matchHospitalPatientDao;

	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	@Autowired
	private HospitalPatientService hospitalPatientService;
	@Autowired
	private PatientService patientService;
	@Resource(name="patientService")
	private com.westangel.common.service.PatientService userSystemPatientService;
	@Autowired
	private DiseaseTypeICD10Service diseaseTypeICD10Service;
	
	@Autowired
	private TxFollowupService txFollowupService;
	@Autowired
	private TxInhospitalNoteService txInhospitalNoteService;
	@Autowired
	private TxClinicMedicalNoteService txClinicMedicalNoteService;
	@Autowired
	private TxDiagnosisInfoService txDiagnosisInfoService;
	@Autowired
	private TxSurgeryNoteService txSurgeryNoteService;
	@Autowired
	private TxTreatmentNoteService txTreatmentNoteService;
	@Autowired
	private TxPatientPatientNoService txPatientPatientNoService;
	@Autowired
	private TxOutHospitalNoteService txOutHospitalNoteService;
	
	@Autowired
	private MatchMergeUtil matchMergeUtil;
	
	private Locale locale = Locale.getDefault();
	@Autowired
	private MessageSource messageSource;
	@Autowired
	private PushInnerService pushService;
	@Value("${server.h5.url.root}")
	private String serverH5UrlRoot;
	@Value("${followu.wx.template.name}")
	private String followuWxTtemplateName;
	@Value("${server.h5.patient.confirm.match.info.content}")
	private String patientConfirmMatchInfoContent;

	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	@Override
	public User mergePatient(String patientUuid, Long cloudPatientUserId, boolean transferFlag) {
		if (StringUtils.isEmpty(patientUuid)) {
			throw new EmptyParamExcption("\"patientUuid\" is empty!");
		}
		if (cloudPatientUserId == null) {
			throw new EmptyParamExcption("\"patientUserId\" is empty!");
		}
		//验证云端是否有该id对应的患者
		User cloudUser = this.cloudUserDao.findByUserId(cloudPatientUserId, Constant.User.ROLE_PATIENT);
		if (cloudUser == null) {
			throw new EmptyObjectExcption("cloudPatientUserId \" " + cloudPatientUserId + " \" does not exist in the Cloud Library!");
		}
		if(StringUtils.isNotBlank(patientUuid)&&StringUtils.isNotBlank(cloudUser.getUuid())&&!patientUuid.equals(cloudUser.getUuid())){//整合处理
			MatchUserMergeReq req = new MatchUserMergeReq(patientUuid, cloudUser.getUuid(), Constant.User.ROLE_PATIENT);
			matchMergeUtil.matchUserMergeRequest(req);
			//重查返回用户信息
			return this.cloudUserDao.findByUserId(cloudPatientUserId, Constant.User.ROLE_PATIENT);
		}
		//云端患者
		Patient cloudPatient = this.cloudPatientDao.findByUserId(cloudUser.getUserId());
		//验证匹配中间库是否有该uuid对应的患者
		User matchUser = this.matchUserDao.findByUuid(patientUuid);
		if (transferFlag && matchUser == null) {
			matchUser = new User();
			matchUser.setUuid(patientUuid);
		}
		if (matchUser == null) {
			throw new EmptyObjectExcption("uuid \" " + patientUuid + " \" does not exist in the Middle Library!");
		}
		//匹配中间库患者
		Patient matchPatient = this.matchPatientDao.findByUuid(matchUser.getUuid());
		if (matchPatient == null && matchPatient == null) {
			matchPatient = new Patient();
			matchPatient.setUuid(patientUuid);
		}
		//建立uuid映射
		String patientFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(patientUuid);
		if (StringUtils.isEmpty(patientFinalUuid)) {
			patientFinalUuid = this.uuidRelationshipService.getUserId(cloudPatientUserId);
			//还没有uuid映射关系
			if (StringUtils.isEmpty(patientFinalUuid)) {
				patientFinalUuid = patientUuid;
			}
			if (StringUtils.isNotEmpty(patientFinalUuid)) {
				UuidRelationship uuidRelationship = new UuidRelationship();
				uuidRelationship.setUuidFinal(patientFinalUuid);
				uuidRelationship.setUuid(patientUuid);
				uuidRelationship.setUserId(cloudPatientUserId);
				uuidRelationship.setSyncFlag(Constant.User.SYNCFLAG_NO);
				uuidRelationship.setCreateTime(new Date());
				List<HospitalPatient> hospitalPatients = this.matchHospitalPatientDao.findByPatientUuid(patientUuid);
				if (hospitalPatients != null && hospitalPatients.size() > 0) {
					uuidRelationship.setHospitalId(hospitalPatients.get(0).getHospitalId());
				}
				this.uuidRelationshipService.save(uuidRelationship);
			}
		}
		matchUser.setUuid(patientFinalUuid);
		//合并随访随访结果
		this.txFollowupService.mergeFollowup(patientFinalUuid, cloudPatient.getPatientId());
		//合并住院信息
		this.txInhospitalNoteService.mergeInhospitalNote(patientFinalUuid, cloudPatient.getPatientId());
		//合并门诊信息
		this.txClinicMedicalNoteService.mergeClinicMedicalNote(patientFinalUuid, cloudPatient.getPatientId());
		//合并诊断信息
		this.txDiagnosisInfoService.mergeDiagnosisInfo(patientFinalUuid, cloudPatient.getPatientId());
		//合并手术信息
		this.txSurgeryNoteService.mergeSurgeryNote(patientFinalUuid, cloudPatient.getPatientId());
		//合并治疗信息
		this.txTreatmentNoteService.mergeTreatmentNote(patientFinalUuid, cloudPatient.getPatientId());
		//合并出院小结信息
		this.txOutHospitalNoteService.mergeOuthospitalNote(patientFinalUuid, cloudPatient.getPatientId());
		//合并patientPatientNo
		this.txPatientPatientNoService.mergePatientPatientNo(patientFinalUuid, cloudPatient.getPatientId());
		//合并HospitalPaitent
		this.mergeHospitalPatient(patientFinalUuid, cloudPatient.getPatientId());
		//合并DoctorPaitent
		this.mergeDoctorPatient(patientFinalUuid, cloudPatient.getPatientId());
		//合并Patient
		if (StringUtils.isEmpty(cloudPatient.getUuid())) {
			cloudPatient.setUuid(matchUser.getUuid());
		}
		this.mergePatient(matchPatient, cloudPatient);
		cloudPatient = this.cloudPatientDao.findByUserId(cloudPatient.getUserId());
		//合并原发诊断
		this.mergePatientSourceDiagnosisInfo(cloudUser, cloudPatient);
		//合并patientContactList
		this.mergePatientContact(matchPatient, cloudPatient);
		cloudUser = this.cloudUserDao.findByUserId(cloudUser.getUserId(), Constant.User.ROLE_PATIENT);
		//合并User
		this.mergeUser(matchUser, matchPatient, cloudUser, cloudPatient);
		LogUtil.log.debug("Start deleting the patient data that matches the Middle Library---------->>");
		//删除匹配中间库的用户数据
		this.matchPatientDao.delete(matchPatient.getPatientId());
		LogUtil.log.debug("Delete the patient data to match the Middle Library----------<<");
		LogUtil.log.debug("Start deleting users of the matching Middle Library---------->>");
		this.matchUserDao.delete(matchUser.getUserId());
		LogUtil.log.debug("Delete the user to complete the match between the library----------<<");
		return cloudUser;
	}

	/**
	 * 
	 * @param matchUser
	 * @param matchPatient
	 * @param cloudUser
	 * @param cloudPatient
	 * @return
	 */
	private boolean mergeUser(User matchUser, Patient matchPatient, User cloudUser, Patient cloudPatient) {
		LogUtil.log.debug("Start merging user data---------->>");
		//uuid
		if (StringUtils.isNotEmpty(matchUser.getUuid()) &&
				StringUtils.isEmpty(cloudUser.getUuid())) {
			cloudUser.setUuid(matchUser.getUuid());
		}
		//trueName
		if (StringUtils.isNotEmpty(matchUser.getTrueName()) &&
				(StringUtils.isEmpty(cloudUser.getTrueName()) ||
						"匿名".equals(cloudUser.getTrueName().trim()))) {
			cloudUser.setTrueName(matchUser.getTrueName());
		}
		//sex
		if (matchUser.getSex() != null) {
			cloudUser.setSex(matchUser.getSex());
		}
		//mobile
		if (StringUtils.isNotEmpty(matchUser.getMobile()) &&
				StringUtils.isEmpty(cloudUser.getMobile())) {
			//add by fanpanwei 手机号已经被使用，则不传，否则违反唯一性约束
			List<Patient> patients = this.cloudPatientDao.findByMobile(matchUser.getMobile(), Constant.User.PATIENTRELATION_ONESELF);
			if (patients == null || patients.get(0)==null||patients.size()==0) {
				cloudUser.setMobile(matchUser.getMobile());
			}
		}
		//birthDate
		if (matchUser.getBirthDate() != null) {
			cloudUser.setBirthDate(matchUser.getBirthDate());
		}
		//country
		if (StringUtils.isNotEmpty(matchUser.getCountry())) {
			cloudUser.setCountry(matchUser.getCountry());
		}
		//city
		if (StringUtils.isNotEmpty(matchUser.getCity())) {
			cloudUser.setCity(matchUser.getCity());
		}
		//nativePlace
		if (StringUtils.isNotEmpty(matchUser.getNativePlace())) {
			cloudUser.setNativeplace(matchUser.getNativeplace());
		}
		//nation
		if (StringUtils.isNotEmpty(matchUser.getNation())) {
			cloudUser.setNation(matchUser.getNation());
		}
		//identification
		if (StringUtils.isNotEmpty(matchUser.getIdentification()) &&
				(cloudPatient.getAuditState() == null ||
				cloudPatient.getAuditState() < Constant.User.AUDITSTATE_SENIOR)) {
			if (matchUser.getIdType() == null) {
				matchUser.setIdType(Constant.User.IDTYPE_ID);
			}
			if (StringUtils.isNotEmpty(matchUser.getTrueName())) {
				cloudPatient.setTrueName(matchUser.getTrueName());
			}
			
			cloudUser.setIdType(matchUser.getIdType());
			cloudUser.setIdentification(matchUser.getIdentification());
			if (cloudPatient.getPatientRelation() == null ||
					cloudPatient.getPatientRelation() == 0) {
				if (StringUtils.isNotEmpty(cloudPatient.getTrueName())) {
					cloudUser.setTrueName(cloudPatient.getTrueName());
				}
			}
		}
		//marriageStatus
		if (matchUser.getMarriageStatus() != null) {
			cloudUser.setMarriageStatus(matchUser.getMarriageStatus());
		}
		//profession
		if (StringUtils.isNotEmpty(matchUser.getProfession())) {
			cloudUser.setProfession(matchUser.getProfession());
		}
		//原始职业相关 add by fanpanwei 
		if (StringUtils.isNotBlank(matchUser.getRawOccupationId()) &&
				!matchUser.getRawOccupationId().equals(cloudUser.getRawOccupationId())){
			cloudUser.setRawOccupationId(matchUser.getRawOccupationId());
		}
		if (StringUtils.isNotBlank(matchUser.getRawProfession()) &&
				!matchUser.getRawProfession().equals(cloudUser.getRawProfession())){
			cloudUser.setRawProfession(matchUser.getRawProfession());
		}
		cloudUser.setSyncFlag(Constant.User.SYNCFLAG_YES);
		cloudUser.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		this.cloudUserDao.update(cloudUser);
		//处理cityId
		if (StringUtils.isNotEmpty(cloudUser.getCity())) {
			this.cloudUserDao.updateCityId(cloudUser);
		}
		LogUtil.log.debug("Merge user data to complete----------<<");
		return true;
	}

	/**
	 * 
	 * @param matchPatient
	 * @param cloudPatient
	 * @return
	 */
	private boolean mergePatient(Patient matchPatient, Patient cloudPatient) {
		LogUtil.log.debug("Start with patient data---------->>");
		TPatientSyncProfile patientSyncProfile = new TPatientSyncProfile();
		BeanUtils.copyProperties(matchPatient, patientSyncProfile);
		//合并后
		Patient targetpatient = patientSyncProfile.mergerPatient(cloudPatient);
		targetpatient.setSyncFlag(Constant.User.SYNCFLAG_YES);
		targetpatient.setMatchFlag(1);
		this.cloudPatientDao.update(targetpatient);
		LogUtil.log.debug("Combined patient data completion----------<<");
		return true;
	}

	private boolean mergePatientSourceDiagnosisInfo(User cloudUser, Patient cloudPatient) {
		LogUtil.log.debug("Start with patient diagnosis data---------->>");
		if (StringUtils.isNotEmpty(cloudPatient.getSourceDiagnosis()) &&
				StringUtils.isNotEmpty(cloudPatient.getSourceDiseaseCode()) &&
				cloudPatient.getConfirmedDate() != null &&
						cloudPatient.getSourceDiseaseTypeId() != null) {
			return true;
		}
		//PageHelper.startPage(1, 3);
		List<DiagnosisInfo> diagnosisInfos = this.cloudDiagnosisInfoDao.findSourceDiagnosisByPatientId(cloudPatient.getPatientId());
		for (int i = 0, size = diagnosisInfos.size(), count = 1; i < size; i++) {
			DiagnosisInfo diagnosisInfo = diagnosisInfos.get(i);
			if (StringUtils.isEmpty(diagnosisInfo.getDiagnosis()) ||
					StringUtils.isEmpty(diagnosisInfo.getDiseaseCode()) ||
					diagnosisInfo.getDiseaseTypeId() == null) {
				if (StringUtils.isNotEmpty(diagnosisInfo.getDiseaseCode())) {
					DiseaseTypeICD10 diseaseTypeICD10 = this.diseaseTypeICD10Service.getDiseaseTypeIdByDiseaseCode(diagnosisInfo.getDiseaseCode());
					if (diseaseTypeICD10 != null) {
						diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
						diagnosisInfo.setDiseaseBodyPartId(diagnosisInfo.getDiseaseBodyPartId());
					}else{
						//非肿瘤
						//病种9999
						diagnosisInfo.setDiseaseTypeId(9999);
						diagnosisInfo.setDiseaseBodyPartId(99);
					}
				} else if(StringUtils.isNotEmpty(diagnosisInfo.getDiagnosis())){
					PageHelper.startPage(1, 1);
					List<DiseaseTypeICD10> diseaseTypeICD10s = this.cloudDiseaseTypeICD10Dao.findByDiseaseContent(0, diagnosisInfo.getDiagnosis());
					if (diseaseTypeICD10s != null && !diseaseTypeICD10s.isEmpty()) {
						DiseaseTypeICD10 diseaseTypeICD10 = diseaseTypeICD10s.get(0);
						
						diagnosisInfo.setDiseaseTypeId(diseaseTypeICD10.getDiseaseTypeId());
						diagnosisInfo.setDiseaseBodyPartId(diseaseTypeICD10.getDiseaseBodyPartId());
					}else{
						diagnosisInfo.setDiseaseTypeId(null);
						diagnosisInfo.setDiseaseBodyPartId(null);
						diagnosisInfo.setDiseaseCode(null);
					}
				}
			}
			if (StringUtils.isEmpty(diagnosisInfo.getDiagnosis()) ||
					StringUtils.isEmpty(diagnosisInfo.getDiseaseCode()) ||
					diagnosisInfo.getDiseaseTypeId() == null) {
				continue;
			}
			if (diagnosisInfo.getVisitTime() == null) {
				diagnosisInfo.setVisitTime(new Date());
			}
			this.setPatientSourceDiagnosis(diagnosisInfo, cloudPatient);
			count++;
			if (count == 3) {
				diagnosisInfos = null;
				break;
			}
		}
		//处理InfoState
		if (cloudUser.getInfoState() == null ||
				cloudUser.getInfoState() < Constant.User.INFOSTATE_PRIMARY) {
			cloudUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			this.cloudUserDao.update(cloudUser);
		}
		//开启随访计划
		//this.userSystemPatientService.enableFollowupPlan(cloudPatient);
		LogUtil.log.debug("Combined patient diagnostic data complete----------<<");
		return true;
	}
	
	private boolean setPatientSourceDiagnosis(DiagnosisInfo diagnosisInfo, Patient patient){
		LogUtil.log.debug("Primary diagnosis was added to the patients.---------->>");
		String sourceDiagnosis = diagnosisInfo.getDiagnosis();
		if (StringUtils.isEmpty(sourceDiagnosis)) {
			PageHelper.startPage(1, 1);
			List<MetaEicd10> metaEicd10s = this.cloudMetaEIcd10Dao.findByDiseaseTypeId(diagnosisInfo.getDiagnosisTypeId());
			if (metaEicd10s == null || metaEicd10s.isEmpty()) {
				LogUtil.log.debug("通过病种Id=" + diagnosisInfo.getDiagnosisTypeId() + "没查询到诊断内容。");
				return false;
			}
			sourceDiagnosis = metaEicd10s.get(0).getDiseaseName();
		}
		boolean flag = false;
		//判断患者基本信息里是否有原发诊断信息
		if (StringUtils.isEmpty(patient.getSourceDiagnosis()) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode()) ||
				patient.getConfirmedDate() == null ||
				patient.getSourceDiseaseTypeId() == null) {
			patient.setSourceDiagnosis(sourceDiagnosis);
			patient.setSourceDiseaseCode(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate(diagnosisInfo.getVisitTime());
			flag = true;
		}else if (StringUtils.isEmpty(patient.getSourceDiagnosis2()) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode2()) ||
				patient.getConfirmedDate2() == null ||
				patient.getSourceDiseaseTypeId2() == null) {
			patient.setSourceDiagnosis2(sourceDiagnosis);
			patient.setSourceDiseaseCode2(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId2(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate2(diagnosisInfo.getVisitTime());
			flag = true;
		}else if (StringUtils.isEmpty(sourceDiagnosis) ||
				StringUtils.isEmpty(patient.getSourceDiseaseCode3()) ||
				patient.getConfirmedDate3() == null ||
				patient.getSourceDiseaseTypeId3() == null) {
			patient.setSourceDiagnosis3(diagnosisInfo.getDiagnosis());
			patient.setSourceDiseaseCode3(diagnosisInfo.getDiseaseCode());
			patient.setSourceDiseaseTypeId3(diagnosisInfo.getDiseaseTypeId());
			patient.setConfirmedDate3(diagnosisInfo.getVisitTime());
			flag = true;
		}
		if (patient.getAuditState() == null ||
				patient.getAuditState() < Constant.User.AUDITSTATE_PRIMARYPASS) {
			patient.setAuditState(Constant.User.AUDITSTATE_PRIMARYPASS);
			flag = true;
		}
		if (flag) {
			this.cloudPatientDao.update(patient);
		}
		User cloudUser = this.cloudUserDao.findByUserId(patient.getUserId(), Constant.User.ROLE_PATIENT);
		if (cloudUser != null &&
				(cloudUser.getInfoState() == null ||
				cloudUser.getInfoState() < Constant.User.INFOSTATE_PRIMARY)) {
			cloudUser.setInfoState(Constant.User.INFOSTATE_PRIMARY);
			this.cloudUserDao.update(cloudUser);
		}
		LogUtil.log.debug("To patients with primary diagnosis----------<<");
		return true;
	}

	/**
	 * 
	 * @param patientFinalUuid
	 * @param patientId
	 * @return
	 */
	private boolean mergeDoctorPatient(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with the doctor-patient relationship data---------->>");
		//将医患关系里的患者uuid值修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchDoctorPatientDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<DoctorPatient> doctorPatients = this.matchDoctorPatientDao.findByPatientUuid(patientFinalUuid);
		if (doctorPatients == null || doctorPatients.isEmpty()) {
			return true;
		}
		for (int i = doctorPatients.size() - 1; i >= 0; i--) {
			DoctorPatient doctorPatient = doctorPatients.get(i);
			Long rid = doctorPatient.getId();
			doctorPatient.setPatientId(patientId);
			
			//获取该医生的finalUuid
			String doctorFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorPatient.getDoctorUuid());
			if (StringUtils.isEmpty(doctorFinalUuid)) {
				doctorFinalUuid = doctorPatient.getDoctorUuid();
			}
			Doctor doctor = this.cloudDoctorDao.findByUuid(doctorFinalUuid);
			if (doctor == null) {
				continue;
			}
			doctorPatient.setDoctorId(doctor.getDoctorId());
			
			DoctorPatient cloudDoctorPatient = this.cloudDoctorPatientDao.findDoctorPatient(doctorPatient.getPatientId(), doctorPatient.getDoctorId());
			if (cloudDoctorPatient == null) {
				//处理sourceFlag
				if (doctorPatient.getSourceFlag() == null) {
					doctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
				}
				//云端库还不存在，则创建
				this.cloudDoctorPatientDao.insert(doctorPatient);
			} else {
				//云端库有对应的医患关系，则修改
				Date nowTime = new Date();
				boolean flag = false;
				//如果来源为空时，将来源修改为来自医院
				if (cloudDoctorPatient.getSourceFlag() == null) {
					cloudDoctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
					flag = true;
				}
				//如果关注时间为空，当前时间为关注时间
				if (cloudDoctorPatient.getAttentionTime() == null) {
					cloudDoctorPatient.setAttentionTime(nowTime);
					flag = true;
				}
				if (flag) {
					this.cloudDoctorPatientDao.update(cloudDoctorPatient);
				}
			}
			this.matchDoctorPatientDao.delete(rid);
		}
		LogUtil.log.debug("Combined patient relationship data----------<<");
		return true;
	}

	/**
	 * 
	 * @param patientFinalUuid
	 * @param patientId
	 * @return
	 */
	private boolean mergeHospitalPatient(String patientFinalUuid, Long patientId) {
		LogUtil.log.debug("Start with the hospital, patient data---------->>");
		//将医院、患者关系里的患者uuid值全部修改为患者的finalUuid值
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(patientFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchHospitalPatientDao.updatePatientUuid(patientFinalUuid, uuidRelationships);
		}
		List<HospitalPatient> hospitalPatients = this.matchHospitalPatientDao.findByPatientUuid(patientFinalUuid);
		if (hospitalPatients == null || hospitalPatients.isEmpty()) {
			return true;
		}
		for (int i = hospitalPatients.size() - 1; i >= 0; i--) {
			HospitalPatient hospitalPatient = hospitalPatients.get(i);
			long rid=hospitalPatient.getId();
			hospitalPatient.setPatientId(patientId);
			//sourceFlag
			if (hospitalPatient.getSourceFlag() == null) {
				hospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			}
			//处理hospitalId
			if (hospitalPatient.getHospitalId() == null) {
				Hospital hospital = this.cloudHospitalDao.findByUuid(hospitalPatient.getHospitalUuid());
				if (hospital == null) {
					continue;
				}
				hospitalPatient.setHospitalId(hospital.getHospitalId());
			}
			HospitalPatient cloudHospitalPatient = this.cloudHospitalPatientDao.find(hospitalPatient);
			if (cloudHospitalPatient == null) {
				if (hospitalPatient.getSourceFlag() == null) {
					hospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
				}
				this.cloudHospitalPatientDao.insert(hospitalPatient);
			} else {
				//处理患者病案号
				if (StringUtils.isEmpty(cloudHospitalPatient.getPatientNo()) ||
						!hospitalPatient.getPatientNo().equals(cloudHospitalPatient.getPatientNo())) {
					cloudHospitalPatient.setPatientNo(hospitalPatient.getPatientNo());
					if (StringUtils.isEmpty(hospitalPatient.getPatientNo())) {
						String patientNo = this.cloudHospitalPatientDao.findPatientNo(hospitalPatient.getPatientId(), hospitalPatient.getHospitalId());
						if (StringUtils.isNotEmpty(patientNo)) {
							hospitalPatient.setPatientNo(patientNo);
						}
					}
					if (StringUtils.isNotEmpty(hospitalPatient.getPatientNo())) {
						this.cloudHospitalPatientDao.update(cloudHospitalPatient);
					}
				}
			}
			//删除
			this.matchHospitalPatientDao.delete(rid);
		}
		//获取没有patientNo的医院患者关系
		List<HospitalPatient> noPatientNoes = this.cloudHospitalPatientDao.findNoPatientNoes(patientId);
		for (int i = 0, size = noPatientNoes.size(); i < size; i++) {
			HospitalPatient hospitalPatient = noPatientNoes.get(i);
			String patientNo = this.cloudHospitalPatientDao.findPatientNo(hospitalPatient.getPatientId(), hospitalPatient.getHospitalId());
			if (StringUtils.isNotEmpty(patientNo)) {
				hospitalPatient.setPatientNo(patientNo);
				this.cloudHospitalPatientDao.update(hospitalPatient);
			}
		}
		LogUtil.log.debug("Hospital and patient data were completed.----------<<");
		return true;
	}

	/**
	 * 
	 * @param matchPatient
	 * @param cloudPatient
	 * @return
	 */
	private boolean mergePatientContact(Patient matchPatient, Patient cloudPatient) {
		LogUtil.log.debug("Start with patient contact data---------->>");
		List<TPatientContactInfo> matchPatientFamilies = this.matchPatientContacInfoDao.findByPatientUuid(matchPatient.getUuid());
		if (matchPatientFamilies == null || matchPatientFamilies.isEmpty()) {
			return true;
		}
		for (int i = matchPatientFamilies.size() - 1; i >= 0; i--) {
			TPatientContactInfo patientFamily = matchPatientFamilies.get(i);
			patientFamily.setPatientId(cloudPatient.getPatientId());
			List<TPatientContactInfo> cloudPatientFamilys = this.cloudPatientContacInfoDao.find(patientFamily);
			if (cloudPatientFamilys == null || cloudPatientFamilys.isEmpty()) {
				if (StringUtils.isEmpty(patientFamily.getFamilyName())) {
					patientFamily.setFamilyName("");
				}
				this.cloudPatientContacInfoDao.insert(patientFamily);
			} else {
				for (int j = cloudPatientFamilys.size() - 1; j >= 0; j--) {
					TPatientContactInfo cloudPatientFamily = cloudPatientFamilys.get(j);
					boolean flag = false;
					if (cloudPatientFamily.getPatientRelation() != patientFamily.getPatientRelation()) {
						cloudPatientFamily.setPatientRelation(patientFamily.getPatientRelation());
						flag = true;
					}
					if (StringUtils.isNotEmpty(patientFamily.getFamilyName()) &&
							(StringUtils.isEmpty(cloudPatientFamily.getFamilyName()) ||
									!patientFamily.getFamilyName().equals(cloudPatientFamily.getFamilyName()))) {
						cloudPatientFamily.setFamilyName(patientFamily.getFamilyName());
						flag = true;
					}
					if (StringUtils.isNotEmpty(patientFamily.getAddress()) &&
							(StringUtils.isEmpty(cloudPatientFamily.getAddress()) ||
									!patientFamily.getAddress().equals(cloudPatientFamily.getAddress()))) {
						cloudPatientFamily.setAddress(patientFamily.getAddress());
						flag = true;
					}
					if (StringUtils.isNotEmpty(patientFamily.getRemark()) &&
							(StringUtils.isEmpty(cloudPatientFamily.getRemark()) ||
									!patientFamily.getRemark().equals(cloudPatientFamily.getRemark()))) {
						cloudPatientFamily.setRemark(cloudPatientFamily.getRemark() + "\n" + patientFamily.getRemark());
						flag = true;
					}
					if (patientFamily.getSourceFlag()!=null &&
							(cloudPatientFamily.getSourceFlag()==null ||
									patientFamily.getSourceFlag()!=cloudPatientFamily.getSourceFlag())) {
						cloudPatientFamily.setSourceFlag(patientFamily.getSourceFlag());
						flag = true;
					}
					if (patientFamily.getFamilyPhone() != null) {
						String mobile = patientFamily.getFamilyPhone();
						if (mobile.length() > 15) {
							if (mobile.startsWith("1")) {
								patientFamily.setFamilyPhone(mobile.substring(0, 11));
							} else {
								patientFamily.setFamilyPhone(mobile.substring(0, 15));
							}
						}
					}
					if (flag) {
						this.cloudPatientContacInfoDao.update(cloudPatientFamily);
					}
				}
			}
			this.matchPatientContacInfoDao.delete(patientFamily.getId());
		}
		LogUtil.log.debug("Combined patient contact data is complete----------<<");
		return true;
	}
	
	/**
	 * <p>Title:sendNotifyToPatientForMatchMobilePatient</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年6月14日 上午11:08:50
	 * @param user
	 * @param name
	 * @param diseaseTypeName
	 */
//	private void sendNotifyToPatientForMatchMobilePatient(User user, String name, String diseaseTypeName) {
//		try{
//			if(user != null && user.getUserId() > 0){
//				String mobile = user.getMobile().substring(0, 3);
//				String content = messageSource.getMessage("push.patient.match.mobile.tobpatient", new String[]{mobile + "xxxx" + user.getMobile().substring(7)}, locale);
//				List<String> values = new ArrayList<String>();
//				values.add(content);
//				values.add(name);
//				values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
//				values.add("确认身份信息");
//				String sex = user.getSex() == 2 ? "女" : "男";
//				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, this.serverH5UrlRoot + this.patientConfirmMatchInfoContent + 
//						"?trueName=" + name + "&tipText=性别=" + sex + ",出生日期=" + DateUtils.formatDate(user.getBirthDate(), "yyyy年MM月dd日") +  
//						",手机号=" + user.getMobile() + ",主要诊断=" + diseaseTypeName + ",uuid:" + user.getUuid() + ",userId:" + user.getUserId() + ",userRole:" + user.getRole(), values);
//				notify.setUserId(user.getUserId());
//				this.pushService.push(notify);
//			}
//		} catch (Exception e){
//			e.printStackTrace();
//			LogUtil.logError.error("sendNotifyToPatientForRealnameAuthentication() failed:" + e.getMessage());
//		}
//	}
	//加载患者uuid数据
	private boolean inMatchPatient(TPatientSyncProfile patientSyncProfile){
		String uuid;
		Long doctorId;
		// 主诊医生
		uuid = patientSyncProfile.getAttendingDoctorUuid();
		if (StringUtils.isNotEmpty(uuid)){
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if(doctorId!=null)
				patientSyncProfile.setAttendingDoctorUuid(null);
			patientSyncProfile.setAttendingDoctor(doctorId);
		}
		// 主治医生
		uuid = patientSyncProfile.getInchargeDoctorUuid();
		if(StringUtils.isNotEmpty(uuid)){
			doctorId = this.uuidRelationshipService.getDoctorId(uuid);
			if(doctorId==null)
				patientSyncProfile.setInchargeDoctorUuid(null);
			patientSyncProfile.setInchargeDoctor(doctorId);
		}
		return false;
	}
	@Transactional
	@Override
	public boolean syncPatientInfo(TPatientSyncProfile patientSyncProfile) {
		//查找是否有云端对应的uuid值
		String finalUuid = this.uuidRelationshipService.getFinalUuidByUuid(patientSyncProfile.getUuid());
		//如果有对应的uuid值，使用云端的uuid值
		if (StringUtils.isNotEmpty(finalUuid)) {
			patientSyncProfile.setUuid(finalUuid);
		}
		//设置用户来源
		if (patientSyncProfile.getSourceFlag() == null) {
			patientSyncProfile.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		//手机号处理
		if (patientSyncProfile.getMobile() != null) {
			String mobile = patientSyncProfile.getMobile();
			if (mobile.length() > 15) {
				if (mobile.startsWith("1")) {
					patientSyncProfile.setMobile(mobile.substring(0, 11));
				} else {
					patientSyncProfile.setMobile(mobile.substring(0, 15));
				}
			}
		}
		//主诊 和 主治 去除
		inMatchPatient(patientSyncProfile);
		//使用uuid值进行匹配
		if(mathcByUserUuId(patientSyncProfile))
			return true;
		//使用证件号进行匹配
		if (StringUtils.isNotEmpty(patientSyncProfile.getIdentification())) {
			if(matchByPatientIdentification(patientSyncProfile))
				return true;
		}
		//使用手机号进行匹配
		if (StringUtils.isNotEmpty(patientSyncProfile.getMobile())) {
			if(this.matchByPatientMobile(patientSyncProfile))
				return true;
		}else 
			//使用患者联系人的手机号匹配
			if (this.matchByPatientContactList(patientSyncProfile)){
			return true;
		}
		//在云端新增一条患者数据
		this.saveCloudUserAndPatient(patientSyncProfile);
		return true;
	}

	
	/**
	 * 数据保存到云端数据库
	 * @param patientSyncProfile
	 * @return
	 */
	private boolean saveCloudUserAndPatient(TPatientSyncProfile patientSyncProfile){
		LogUtil.log.debug("Synchronize patient data to the production base---------->>");
		Date nowTime = new Date();
		//1.保存User数据
		User user = patientSyncProfile.createColudUser();
		this.cloudUserDao.insert(user);
		//处理cityId
		if (StringUtils.isNotEmpty(user.getCity())) {
			this.cloudUserDao.updateCityId(user);
		}
		//2.保存患者数据
		Patient patient = patientSyncProfile.createColudPatient();
		patient.setUuid(user.getUuid());
		patient.setUserId(user.getUserId());
		this.cloudPatientDao.insert(patient);
		//保存映射关系
		this.createUuidMaper(patient);
		//3.保存患者联系人数据
		List<TPatientContactInfo> patientContactList = patientSyncProfile.getPatientContactList();
		if (patientContactList != null && !patientContactList.isEmpty()) {
			for (int i = 0, size = patientContactList.size(); i < size; i++) {
				TPatientContactInfo patientContactInfo = patientContactList.get(i);
				patientContactInfo.setPatientId(patient.getPatientId());
				patientContactInfo.setCreateTime(nowTime);
				
				if (StringUtils.isEmpty(patientContactInfo.getFamilyPhone())) {
					continue;
				}
				String familyPhone = patientContactInfo.getFamilyPhone();
				if (familyPhone.length() > 15) {
					if (familyPhone.startsWith("1")) {
						patientContactInfo.setFamilyPhone(familyPhone.substring(0, 11));
					} else {
						patientContactInfo.setFamilyPhone(familyPhone.substring(0, 15));
					}
				}
				if (StringUtils.isEmpty(patientContactInfo.getFamilyName())) {
					patientContactInfo.setFamilyName("");
				}
				//判断是否有该联系人关系
				List<TPatientContactInfo> cloudTPatientContactInfos = this.cloudPatientContacInfoDao.find(patientContactInfo);
				if (cloudTPatientContactInfos == null || cloudTPatientContactInfos.isEmpty()) {
					this.cloudPatientContacInfoDao.insert(patientContactInfo);
				}else{ 
					for (int f = cloudTPatientContactInfos.size() - 1; f >= 0; f--) {
						TPatientContactInfo tPatientContactInfo = cloudTPatientContactInfos.get(f);
						if (StringUtils.isNotEmpty(patientContactInfo.getFamilyName()) &&
								StringUtils.isEmpty(tPatientContactInfo.getFamilyName())) {
							tPatientContactInfo.setFamilyName(patientContactInfo.getFamilyName());
						}
						if (tPatientContactInfo.getPatientRelation() == null) {
							tPatientContactInfo.setPatientRelation(Constant.User.PATIENTRELATION_RELATIVE);
						}
						tPatientContactInfo.setSourceFlag(patientContactInfo.getSourceFlag());
						tPatientContactInfo.setUpdateTime(nowTime);
						this.cloudPatientContacInfoDao.update(tPatientContactInfo);
					}
				}
			}
		}
		//4.增加医院、患者关系
		HospitalPatient hospitalPatient = patientSyncProfile.createHospitalPatient();
		hospitalPatient.setPatientId(patient.getPatientId());
		hospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		this.hospitalPatientService.saveHospitalPatient(hospitalPatient);
		LogUtil.log.debug("Synchronization patient data is saved to the production database to complete----------<<");
		return true;
	}
	//患者云端映射关系
	private void createUuidMaper(Patient patient) {
		UuidRelationship uuidRelationship = new UuidRelationship();
		uuidRelationship.setHospitalId(patient.getHospitalId());
		uuidRelationship.setSyncFlag(Constant.User.SYNCFLAG_YES);
		uuidRelationship.setUserId(patient.getUserId());
		uuidRelationship.setUuid(patient.getUuid());
		uuidRelationship.setUuidFinal(patient.getUuid());
		uuidRelationship.setCreateTime(new Date());
		this.uuidRelationshipService.save(uuidRelationship);
	}
	/**
	 * 通过UuId匹配
	 * @author lichenghao
	 * @title :mathcByUserUuId
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年12月15日 上午11:49:43
	 */
	private boolean mathcByUserUuId(TPatientSyncProfile patientSyncProfile){
		User uuidUser = this.cloudUserDao.findByUuid(patientSyncProfile.getUuid());
		if (uuidUser != null) {
			Patient patient = this.cloudPatientDao.findByUserId(uuidUser.getUserId());
			//判断属性
			if(!patientCheck.comparisonPatientFullProperty(uuidUser, patient, patientSyncProfile)){
				//合并到云端库
				patientSyncProfile.setUserId(uuidUser.getUserId());
				this.syncUserAndPatientInfo(patientSyncProfile, uuidUser, patient);
			}
			return true;
		}
		return false;
	}
	/**
	 * 通过证件号匹配
	 * @author lichenghao
	 * @title :matchByPatientIdentification
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年12月15日 上午11:53:57
	 */
	private boolean matchByPatientIdentification(TPatientSyncProfile patientSyncProfile){
		//默认证件类型是身份证
		if (patientSyncProfile.getIdType() == null) {
			patientSyncProfile.setIdType(Constant.IDTYPE_ID);
		}
		User user = this.cloudUserDao.findByIdentification(patientSyncProfile.getIdType(), patientSyncProfile.getIdentification(), Constant.User.ROLE_PATIENT, Constant.User.AUDITSTATE_ADVANCEDPASS);
		if (user != null) {
			// 如果存在同步数据
//			if (user.getUuid() != null &&
//					!patientSyncProfile.getUuid().equals(user.getUuid())) {
//				//保存uuid映射值
//				UuidRelationship uuidRelationship = new UuidRelationship();
//				uuidRelationship.setUuidFinal(user.getUuid());
//				uuidRelationship.setUuid(patientSyncProfile.getUuid());
//				uuidRelationship.setUserId(user.getUserId());
//				uuidRelationship.setCreateTime(new Date());
//				uuidRelationship.setHospitalId(patientSyncProfile.getHospitalId());
//				this.uuidRelationshipService.save(uuidRelationship);
//			}
			//对比传入的值
			Patient patient = this.cloudPatientDao.findByUserId(user.getUserId());
			if (!patientCheck.comparisonPatientFullProperty(user, patient, patientSyncProfile)) {
				//放到匹配库
				patientSyncProfile.setUserId(user.getUserId());
				this.patientService.saveMatchUserAndPatient(patientSyncProfile);
				//this.syncUserAndPatientInfo(patientSyncProfile, user, patient);
				//通知患者
				sendMergerNotifyToPatient(patientSyncProfile, patient, user);
			}
			return true;
		}
		return false;
	}
	
	/**
	 * 通过患者手机号匹配
	 * @author lichenghao
	 * @title :matchByPatientMobile
	 * @Description:TODO
	 * @return boolean
	 * @date 2016年12月15日 上午11:59:31
	 */
	private boolean matchByPatientMobile(TPatientSyncProfile patientSyncProfile){
		List<Patient> patients = this.cloudPatientDao.findByMobile(patientSyncProfile.getMobile(), Constant.User.PATIENTRELATION_ONESELF);
		if (patients != null && !patients.isEmpty()) {
			User user = this.cloudUserDao.findByUserId(patients.get(0).getUserId(), null);
			if (!patientCheck.comparisonPatientFullProperty(user, patients.get(0), patientSyncProfile)) {
				//将数据保存到匹配中间库
				patientSyncProfile.setUserId(user.getUserId());
				this.patientService.saveMatchUserAndPatient(patientSyncProfile);
			}
			return true;
		}
		return false;
	}
	/**
	 * 通过患者的联系人进行匹配
	 * @param patientSyncProfile
	 * @return
	 */
	private boolean matchByPatientContactList(TPatientSyncProfile patientSyncProfile){
		List<TPatientContactInfo> patientContactList = patientSyncProfile.getPatientContactList();
		if (patientContactList != null && !patientContactList.isEmpty()) {
			for (TPatientContactInfo patientContactInfo : patientContactList) {
				if (StringUtils.isEmpty(patientContactInfo.getFamilyPhone())) {
					continue;
				}
				//通过患者联系人与患者联系方式匹配
				List<Patient> patients = this.cloudPatientDao.findByMobile(patientContactInfo.getFamilyPhone(), Constant.User.PATIENTRELATION_RELATIVE);
				if (patients != null && !patients.isEmpty()) {
					User user = this.cloudUserDao.findByUserId(patients.get(0).getUserId(), null);
					boolean flag = patientCheck.comparisonPatientFullProperty(user, patients.get(0), patientSyncProfile);
					if (!flag) {
						//将数据保存到匹配中间库
						patientSyncProfile.setUserId(user.getUserId());
						this.patientService.saveMatchUserAndPatient(patientSyncProfile);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//数据合并
	private boolean syncUserAndPatientInfo(TPatientSyncProfile patientSyncProfile, User user, Patient patient){
		LogUtil.log.debug("合并用户信息（syncPatientContactInfo()）---------->>>");
		//合并医院、患者关系
		this.syncHospitalPatient(patientSyncProfile, patient);
		//合并医生、患者关系?
		//this.syncDoctorPatient(patientSyncProfile, patient);
		//合并患者信息
		this.syncPatientInfo(patientSyncProfile, patient);
		//合并用户信息
		this.syncUserInfo(patientSyncProfile, user, patient);
		//合并患者家属
		this.syncPatientContactInfo(patientSyncProfile, patient);
		LogUtil.log.debug("合并用户信息完成（syncPatientContactInfo()）----------<<<");
		return true;
	}

	
	/**
	 * 合并患者家属
	 * @param patientSyncProfile
	 * @param patient
	 * @return
	 */
	private boolean syncPatientContactInfo(TPatientSyncProfile patientSyncProfile, Patient patient) {
		LogUtil.log.debug("合并患者家属信息（syncPatientContactInfo()）---------->>>");
		List<TPatientContactInfo> patientContactInfos = patientSyncProfile.getPatientContactList();
		if (patientContactInfos == null) {
			patientContactInfos = new ArrayList<TPatientContactInfo>();
		}
		if (StringUtils.isNotEmpty(patientSyncProfile.getMobile())) {
			TPatientContactInfo patientContactInfo = new TPatientContactInfo();
			patientContactInfo.setFamilyPhone(patientSyncProfile.getMobile());
			patientContactInfo.setPatientRelation(Constant.User.PATIENTRELATION_ONESELF);
			String familyName = patientSyncProfile.getTrueName();
			if (StringUtils.isEmpty(familyName)) {
				familyName = "";
			}
			patientContactInfo.setFamilyName(familyName);
			patientContactInfo.setRemark("ToB端增量同步时增加的患者家属");
			patientContactInfos.add(patientContactInfo);
		}
		for (TPatientContactInfo patientContactInfo : patientContactInfos) {
			//手机号码不能为空
			if (StringUtils.isEmpty(patientContactInfo.getFamilyPhone())) {
				continue;
			}
			patientContactInfo.setPatientId(patient.getPatientId());
			String familyName = patientContactInfo.getFamilyName();
			if (StringUtils.isEmpty(familyName)) {
				familyName = "";
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
			patientContactInfo.setFamilyName(familyName);
			patientContactInfo.setRemark("ToB端增量同步时增加的患者家属");
			
			List<TPatientContactInfo> cloudTPatientContactInfos = this.cloudPatientContacInfoDao.find(patientContactInfo);
			if (cloudTPatientContactInfos == null || cloudTPatientContactInfos.isEmpty()) {
				this.cloudPatientContacInfoDao.insert(patientContactInfo);
			}else{//add by fanpanwei将云端已存在的联系人的sourceFlag更新为B端传过来的
				for (TPatientContactInfo tPatientContactInfo : cloudTPatientContactInfos) {
					tPatientContactInfo.setSourceFlag(patientContactInfo.getSourceFlag());
					this.cloudPatientContacInfoDao.update(tPatientContactInfo);
				}
			}
		}
		LogUtil.log.debug("合并患者家属信息完成（syncPatientContactInfo()）----------<<<");
		return true;
	}

	/**
	 * 合并用户信息
	 * @param patientSyncProfile
	 * @param user
	 * @return
	 */
	private boolean syncUserInfo(TPatientSyncProfile patientSyncProfile, User user, Patient patient) {
		LogUtil.log.debug("合并用户基本信息（syncUserInfo()）---------->>>");
		boolean flag = false;
		//合并uuid
		if (StringUtils.isEmpty(user.getUuid())) {
			user.setUuid(patientSyncProfile.getUuid());
			flag = true;
		}
		//合并真实姓名
		if (StringUtils.isNotBlank(patientSyncProfile.getTrueName()) &&
				(StringUtils.isBlank(user.getTrueName()) ||
				"匿名".equals(user.getTrueName().trim()))) {
			user.setTrueName(patientSyncProfile.getTrueName());
			flag = true;
		}
		//合并性别
		if (patientSyncProfile.getSex() != null &&
				patientSyncProfile.getSex() != 0 &&
				(user.getSex() == null || user.getSex() == 0)) {
			user.setSex(patientSyncProfile.getSex());
			flag = true;
		}
		//合并出生日期
		if (patientSyncProfile.getBirthDate() != null &&
				user.getBirthDate() == null) {
			user.setBirthDate(patientSyncProfile.getBirthDate());
			flag = true;
		}
		//合并国家
		if (StringUtils.isNotEmpty(patientSyncProfile.getCountry()) &&
				StringUtils.isEmpty(user.getCountry())) {
			user.setCountry(patientSyncProfile.getCountry());
			flag = true;
		}
		//合并城市
		if (StringUtils.isNotEmpty(patientSyncProfile.getCity()) &&
				StringUtils.isEmpty(user.getCity())) {
			user.setCity(patientSyncProfile.getCity());
			flag = true;
		}
		//合并籍贯
		if (StringUtils.isNotEmpty(patientSyncProfile.getNativePlace()) &&
				StringUtils.isEmpty(user.getNativePlace())) {
			user.setNativePlace(patientSyncProfile.getNativePlace());
			flag = true;
		}
		//合并民族
		if (StringUtils.isNotEmpty(patientSyncProfile.getNation()) &&
				StringUtils.isEmpty(user.getNation())){
			user.setNation(patientSyncProfile.getNation());
			flag = true;
		}
		//身份证
		if (StringUtils.isNotEmpty(patientSyncProfile.getIdentification()) &&
				(patient.getAuditState() == null || patient.getAuditState() < Constant.User.AUDITSTATE_SENIOR)) {
			if (patientSyncProfile.getIdType() == null) {
				patientSyncProfile.setIdType(Constant.User.IDTYPE_ID);
			}
			user.setIdType(patientSyncProfile.getIdType());
			user.setIdentification(patientSyncProfile.getIdentification());
			flag = true;
		}
		//原始职业相关 add by fanpanwei 
		if (StringUtils.isNotBlank(patientSyncProfile.getRawOccupationId()) &&
				!patientSyncProfile.getRawOccupationId().equals(user.getRawOccupationId())){
			user.setRawOccupationId(patientSyncProfile.getRawOccupationId());
			flag = true;
		}
		if (StringUtils.isNotBlank(patientSyncProfile.getRawProfession()) &&
				!patientSyncProfile.getRawProfession().equals(user.getRawProfession())){
			user.setRawProfession(patientSyncProfile.getRawProfession());
			flag = true;
		}
		if (flag) {
			user.setSyncFlag(Constant.User.SYNCFLAG_YES);
			this.cloudUserDao.update(user);
		}
		//处理cityId
		if (StringUtils.isNotEmpty(user.getCity())) {
			this.cloudUserDao.updateCityId(user);
		}
		LogUtil.log.debug("合并用户基本信息完成（syncUserInfo()）----------<<<");
		return true;
	}

	/**
	 * 合并患者信息
	 * @param patientSyncProfile
	 * @param patient
	 * @return
	 */
	private boolean syncPatientInfo(TPatientSyncProfile patientSyncProfile, Patient patient) {
		LogUtil.log.debug("合并患者信息（syncPatientInfo()）---------->>>");
		Patient targetPatient = patientSyncProfile.mergerPatient(patient);
		//合并生存状态
		if (targetPatient.getLiveStatus()==0 && patient.getLiveStatus() == 1) {
			//将随访计划的状态改为死亡
			this.varPatientFollowupDao.setPatientDeathStatus(patient.getPatientId(), 2);
		}
		targetPatient.setSyncFlag(Constant.User.SYNCFLAG_YES);
		if(targetPatient.getMobile()!=null){//add by fanpanwei 手机号已经被使用，则不传，否则违反唯一性约束
			List<Patient> patients = this.cloudPatientDao.findByMobile(patientSyncProfile.getMobile(), Constant.User.PATIENTRELATION_ONESELF);
			if (patients != null && !patients.isEmpty()) {
				targetPatient.setMobile(null);
			}
		}
		this.cloudPatientDao.update(targetPatient);
		LogUtil.log.debug("合并患者基本信息完成（syncPatientInfo()）----------<<<");
		return true;
	}
	
	/**
	 * 合并医院、患者关系
	 * @param patientSyncProfile
	 * @param patient
	 * @return
	 */
	private boolean syncHospitalPatient(TPatientSyncProfile patientSyncProfile, Patient patient){
		HospitalPatient hospitalPatient = patientSyncProfile.createHospitalPatient();
		hospitalPatient.setPatientId(patient.getPatientId());
		HospitalPatient cloudHospitalPatient = this.cloudHospitalPatientDao.find(hospitalPatient);
		//云端数据库还没有医院、患者关系
		if (cloudHospitalPatient == null) {
			if (hospitalPatient.getSourceFlag() == null) {
				hospitalPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			}
			this.cloudHospitalPatientDao.insert(hospitalPatient);
		}else//病案号不同则修改
			if(StringUtils.isNotEmpty(cloudHospitalPatient.getPatientNo()) &&
				(StringUtils.isEmpty(hospitalPatient.getPatientNo())) ||
				!hospitalPatient.getPatientNo().equals(hospitalPatient.getPatientNo())){
			cloudHospitalPatient.setPatientNo(hospitalPatient.getPatientNo());
			this.cloudHospitalPatientDao.update(cloudHospitalPatient);
		}
		return true;
	}
	
	/**
	 * 
	 * @param patientSyncProfile
	 * @param patient
	 * @return
	 */
	private boolean syncDoctorPatient(TPatientSyncProfile patientSyncProfile, Patient patient) {
		LogUtil.log.debug("合并医生、患者关系（syncDoctorPatient()）---------->>>");
		if(StringUtils.isEmpty(patientSyncProfile.getAttendingDoctorUuid())){
			return false;
		}
		String finalDoctorUuid = this.uuidRelationshipService.getFinalUuidByUuid(patientSyncProfile.getAttendingDoctorUuid());
		if (finalDoctorUuid == null) {
			return false;
		}
		Doctor doctor = this.cloudDoctorDao.findByUuid(finalDoctorUuid);
		if (doctor == null) {
			return false;
		}
		DoctorPatient doctorPatient = new DoctorPatient();
		doctorPatient.setDoctorId(doctor.getDoctorId());
		doctorPatient.setPatientId(patient.getPatientId());
		doctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		doctorPatient.setAttentionTime(new Date());
		
		DoctorPatient cloudDoctorPatient = this.cloudDoctorPatientDao.findDoctorPatient(doctorPatient.getPatientId(), doctorPatient.getDoctorId());
		if (cloudDoctorPatient == null) {
			this.cloudDoctorPatientDao.insert(doctorPatient);
		}
		LogUtil.log.debug("合并医生、患者关系完成（syncDoctorPatient()）----------<<<");
		return true;
	}
	/**
	 * 通知患者已与ToB导入的患者信息合并完成
	 * @param patientUserId
	 */
	private void sendNotifyToPatientForRealnameMatchTobPatient(User user, String name, String text) {
		LogUtil.log.debug("身份证匹配上，给患者推送通知，user：" + JsonUtil.toJson(user) + ", name=" + name + ", text=" + text);
		try{
			String identification = user.getIdentification();
			if(user != null && user.getUserId() > 0 && StringUtils.isNotEmpty(identification) && identification.length() > 16 && user.getWeixinFlag()!=null){
				identification = identification.substring(0, 10);
				String content = this.messageSource.getMessage("push.patient.realname.information.audit.matching.tobpatient", new String[]{identification + "xxxxxx" + user.getIdentification().substring(16)}, locale);
				List<String> values = new ArrayList<String>();
				values.add(content);
				values.add(name);
				values.add(DateUtils.formatDate(new Date(), "yyyy-MM-dd"));
				values.add("确认身份信息");
				PushNotifyInfo notify = PushUtil.getWxTemplatePushNotifyInfo(followuWxTtemplateName, this.serverH5UrlRoot + this.patientConfirmMatchInfoContent + 
						"?trueName=" + name + "&tipText=" + text + ",uuid:" + user.getUuid() + ",userId:" + user.getUserId() + ",userRole:" + user.getRole(), values);
				notify.setUserId(user.getUserId());
				notify.setProductId(user.getWeixinFlag());
				this.pushService.push(notify);
			}
		} catch (Exception e){
			LogUtil.logError.error("sendNotifyToPatientForRealnameAuthentication() failed:" + e.getMessage());
		}
	}
	
	
	/**
	 * 通知患者合并
	 * @author lichenghao
	 * @title :sendMergerNotifyToPatient
	 * @Description:TODO
	 * @return void
	 * @date 2016年12月15日 下午12:01:11
	 */
	private void sendMergerNotifyToPatient(TPatientSyncProfile patientSyncProfile,Patient patient,User user){
		//通知患者
		String name = patientSyncProfile.getTrueName();
		if (StringUtils.isEmpty(name)) {
			name = patient.getTrueName();
		}
		StringBuilder text = new StringBuilder();
		if (patient.getSex() != null && patient.getSex() != 0) {
			text.append("性别=");
			text.append(patient.getSex() == Constant.SEX_WOMAN ? "女" : "男");
		}
		if (patient.getBirthDate() != null) {
			text.append(",出生日期=" + DateUtils.formatDate(patient.getBirthDate(), "yyyy年MM月dd日"));
		}
		text.append(",身份证号=" + user.getIdentification());
		Hospital hospital = this.cloudHospitalDao.findById(patientSyncProfile.getHospitalId());
		if (hospital != null) {
			text.append(",就诊医院=" + hospital.getHospitalName());
		}
		if (patientSyncProfile.getInhospitalDate() != null) {
			text.append(",就诊日期=" + DateUtils.formatDate(patientSyncProfile.getInhospitalDate(), "yyyy年MM月dd日"));
		}
		if (patient.getSourceDiseaseTypeId() != null) {
			MetaCDiseaseType metaCDiseaseType = this.cloudMetaCDiseaseTypeDao.findByDiseaseTypeId(patient.getSourceDiseaseTypeId());
			if (metaCDiseaseType != null) {
				text.append(",主要诊断=" + metaCDiseaseType.getDiseaseTypeName());
			}
		}
		if (text.toString().indexOf(",") == 0) {
			text = text.replace(0, 1, "");
		}
		this.sendNotifyToPatientForRealnameMatchTobPatient(user, name, text.toString());
	}
	
	public void syncPatientContactInfo(TPatientContactInfo tPatientContactInfo) throws EmptyObjectExcption{
		//1.判断患者存在性//2.判断患者在哪个库//3.匹配或正式都需判断联系人是更新还是插入
		//查找是否有云端对应的uuid值
		String finalUuid = this.uuidRelationshipService.getFinalUuidByUuid(tPatientContactInfo.getPatientUuid());
		Long patientId = this.uuidRelationshipService.getPatientId(finalUuid);
		Date nowDate=new Date();
		if(patientId!=null){
			//患者在云端
			tPatientContactInfo.setPatientId(patientId);
			if(tPatientContactInfo.getCreateTime()==null){
				tPatientContactInfo.setCreateTime(nowDate);
			}
			if(tPatientContactInfo.getUpdateTime()==null){
				tPatientContactInfo.setUpdateTime(nowDate);
			}
			//设置用户来源
			if (tPatientContactInfo.getSourceFlag() == null) {
				tPatientContactInfo.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			}
			this.saveCloudPatientFamily(tPatientContactInfo);
		}else{
			Patient matchPatient = matchPatientDao.findByUuid(finalUuid);
			if(matchPatient!=null){
				//患者存在匹配库
				tPatientContactInfo.setPatientId(matchPatient.getPatientId());
				tPatientContactInfo.setPatientUuid(finalUuid);
				if(tPatientContactInfo.getCreateTime()==null){
					tPatientContactInfo.setCreateTime(nowDate);
				}
				if(tPatientContactInfo.getUpdateTime()==null){
					tPatientContactInfo.setUpdateTime(nowDate);
				}
				//设置用户来源
				if (tPatientContactInfo.getSourceFlag() == null) {
					tPatientContactInfo.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
				}
				this.saveMatchPatientFamily(tPatientContactInfo);
			}else{
				//患者不存在
				throw new EmptyObjectExcption("patient is null when sync patientFamily");
			}
		}
	}
	private void saveMatchPatientFamily(TPatientContactInfo patientContactInfo){//保存患者联系人到匹配库
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
	
	private void saveCloudPatientFamily(TPatientContactInfo patientContactInfo){//保存患者联系人到正式库
		if (StringUtils.isEmpty(patientContactInfo.getFamilyPhone())) {
			return;
		}
		String familyPhone = patientContactInfo.getFamilyPhone();
		if (familyPhone.length() > 15) {
			if (familyPhone.startsWith("1")) {
				patientContactInfo.setFamilyPhone(familyPhone.substring(0, 11));
			} else {
				patientContactInfo.setFamilyPhone(familyPhone.substring(0, 15));
			}
		}
		if (StringUtils.isEmpty(patientContactInfo.getFamilyName())) {
			patientContactInfo.setFamilyName("");
		}
		//判断是否有该联系人关系
		List<TPatientContactInfo> cloudTPatientContactInfos = this.cloudPatientContacInfoDao.find(patientContactInfo);
		if (cloudTPatientContactInfos == null || cloudTPatientContactInfos.isEmpty()) {
			this.cloudPatientContacInfoDao.insert(patientContactInfo);
		}else{ 
			for (int f = cloudTPatientContactInfos.size() - 1; f >= 0; f--) {
				TPatientContactInfo tPatientContactInfo = cloudTPatientContactInfos.get(f);
				if (StringUtils.isNotEmpty(patientContactInfo.getFamilyName()) &&
						StringUtils.isEmpty(tPatientContactInfo.getFamilyName())) {
					tPatientContactInfo.setFamilyName(patientContactInfo.getFamilyName());
				}
				if (tPatientContactInfo.getPatientRelation() == null) {
					tPatientContactInfo.setPatientRelation(Constant.User.PATIENTRELATION_RELATIVE);
				}
				tPatientContactInfo.setSourceFlag(patientContactInfo.getSourceFlag());
				this.cloudPatientContacInfoDao.update(tPatientContactInfo);
			}
		}
	}
	
	
}
