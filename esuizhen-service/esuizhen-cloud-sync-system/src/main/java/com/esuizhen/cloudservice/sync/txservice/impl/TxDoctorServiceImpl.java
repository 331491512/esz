package com.esuizhen.cloudservice.sync.txservice.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.sync.bean.TDoctorSyncProfile;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDepartmentDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudHospitalDoctorDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudPatientDao;
import com.esuizhen.cloudservice.sync.dao.cloud.CloudUserDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchDoctorPatientDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchHospitalDoctorDao;
import com.esuizhen.cloudservice.sync.dao.match.MatchUserDao;
import com.esuizhen.cloudservice.sync.model.Department;
import com.esuizhen.cloudservice.sync.model.DoctorPatient;
import com.esuizhen.cloudservice.sync.model.Hospital;
import com.esuizhen.cloudservice.sync.model.HospitalDoctor;
import com.esuizhen.cloudservice.sync.service.UuidRelationshipService;
import com.esuizhen.cloudservice.sync.txservice.TxDoctorService;
import com.esuizhen.common.util.match.MatchMergeUtil;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Patient;
import com.westangel.common.bean.User;
import com.westangel.common.bean.sync.MatchUserMergeReq;
import com.westangel.common.bean.sync.UuidRelationship;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.EmptyObjectExcption;
import com.westangel.common.excption.EmptyParamExcption;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Service
public class TxDoctorServiceImpl implements TxDoctorService {
	@Autowired
	private CloudUserDao cloudUserDao;
	@Autowired
	private CloudDoctorDao cloudDoctorDao;
	@Autowired
	private CloudHospitalDoctorDao cloudHospitalDoctorDao;
	@Autowired
	private CloudHospitalDao cloudHospitalDao;
	@Autowired
	private CloudDepartmentDao cloudDepartmentDao;
	@Autowired
	private CloudPatientDao cloudPatientDao;
	@Autowired
	private CloudDoctorPatientDao cloudDoctorPatientDao;
	
	@Autowired
	private MatchDoctorDao matchDoctorDao;
	@Autowired
	private MatchHospitalDoctorDao matchHospitalDoctorDao;
	@Autowired
	private MatchUserDao matchUserDao;
	@Autowired
	private MatchDoctorPatientDao matchDoctorPatientDao;
	@Autowired
	private UuidRelationshipService uuidRelationshipService;
	
	@Autowired
	private MatchMergeUtil matchMergeUtil;
	
	@Value("${server.api.url.root}")
	private String serverUrlRoot;
	@Value("${push.weixin.qr.get}")
	private String pushWeixinQrGetUrl;
	@Value("${sms.captcha.check}")
	private String smsCaptchaCheck;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW,isolation=Isolation.READ_COMMITTED)
	@Override
	public User mergeDoctor(String doctorUuid, Long cloudDoctorUserId) throws EmptyParamExcption, EmptyObjectExcption {
		if (StringUtils.isEmpty(doctorUuid)) {
			throw new EmptyParamExcption("\"doctorUuid\" is empty!");
		}
		if (cloudDoctorUserId == null) {
			throw new EmptyParamExcption("\"cloudDoctorUserId\" is empty!");
		}
		User matchUser = this.cloudUserDao.findByUuid(doctorUuid);
		if (matchUser == null) {
			throw new EmptyObjectExcption("uuid \"" + doctorUuid + "\" does not exist in the Middle Library!");
		}
		User cloudUser = this.cloudUserDao.findByUserId(cloudDoctorUserId, Constant.User.ROLE_DOCTOR);
		if (cloudUser == null) {
			throw new EmptyObjectExcption("cloudDoctorUserId \"" + cloudDoctorUserId + "\" does not exist in the Cloud Library!");
		}
		// 特殊处理
		if(StringUtils.isNotBlank(doctorUuid)&&StringUtils.isNotBlank(cloudUser.getUuid())&&!doctorUuid.equals(cloudUser.getUuid())){//整合处理
			MatchUserMergeReq req = new MatchUserMergeReq(doctorUuid, cloudUser.getUuid(), Constant.User.ROLE_DOCTOR);
			matchMergeUtil.matchUserMergeRequest(req);
			//重查返回用户信息
			return this.cloudUserDao.findByUserId(cloudDoctorUserId, Constant.User.ROLE_DOCTOR);
		}
		//建立uuid映射
		List<Hospital> hospitals = this.matchHospitalDoctorDao.findByDoctorUuid(doctorUuid);
		if (hospitals == null || hospitals.isEmpty()) {
			hospitals = this.cloudHospitalDao.findByDoctorId(cloudDoctorUserId);
		}
		Hospital hospital = null;
		if (hospitals != null && !hospitals.isEmpty()) {
			hospital = hospitals.get(0);
		}
		String doctorFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorUuid);
		if (StringUtils.isEmpty(doctorFinalUuid)) {
			doctorFinalUuid = this.uuidRelationshipService.getUserId(cloudDoctorUserId);
			//uuid还没有映射关系，则建立
			if (StringUtils.isEmpty(doctorFinalUuid)) {
				doctorFinalUuid = doctorUuid;
			}
			if (StringUtils.isNotEmpty(doctorFinalUuid)) {
				UuidRelationship uuidRelationship = new UuidRelationship();
				uuidRelationship.setUuidFinal(doctorFinalUuid);
				uuidRelationship.setUuid(doctorUuid);
				uuidRelationship.setUserId(cloudDoctorUserId);
				uuidRelationship.setCreateTime(new Date());
				if (hospital != null) {
					uuidRelationship.setHospitalId(hospital.getHospitalId());
				}
				this.uuidRelationshipService.save(uuidRelationship);
			}
		}
		matchUser.setUuid(doctorFinalUuid);
		Doctor cloudDoctor = this.cloudDoctorDao.findByUserId(cloudDoctorUserId);
		//合并医院、科室、医生关系
		this.mergeHospitalDoctor(doctorFinalUuid, cloudDoctor, cloudUser);
		//合并科室、子科室、医生关系
		//this.mergeSubdeptDoctor(doctorFinalUuid, cloudDoctor.getDoctorId());
		//合并医患关系
		this.mergeDoctorPatient(doctorFinalUuid, cloudDoctor);
		//合并doctor
		if (StringUtils.isEmpty(cloudDoctor.getUuid())) {
			cloudDoctor.setUuid(matchUser.getUuid());
		}
		this.mergeDoctor(matchUser.getUserId(), cloudDoctor);
		//合并user
		this.mergeUser(matchUser, cloudUser);
		LogUtil.log.debug("Start deleting user data that matches the Middle Library---------->>");
		//删除匹配中间库的用户数据
		this.matchUserDao.delete(matchUser.getUserId());
		LogUtil.log.debug("Delete user data complete with matching Middle Library----------<<");
		return cloudUser;
	}

	/**
	 * 
	 * @param matchUserId
	 * @param cloudDoctor
	 * @return
	 */
	private boolean mergeDoctor(Long matchUserId, Doctor cloudDoctor) {
		LogUtil.log.debug("Start with physician data---------->>");
		Doctor matchDoctor = this.matchDoctorDao.findByUserId(matchUserId);
		if (matchDoctor == null || cloudDoctor == null) {
			return false;
		}
		//trueName
		if (StringUtils.isNotEmpty(matchDoctor.getTrueName())) {
			cloudDoctor.setTrueName(matchDoctor.getTrueName());
		}
		//uuid
		if (StringUtils.isEmpty(cloudDoctor.getUuid())) {
			cloudDoctor.setUuid(matchDoctor.getUuid());
		}
		//sex
		if (matchDoctor.getSex() != null && matchDoctor.getSex() != 0) {
			cloudDoctor.setSex(matchDoctor.getSex());
		}
		//mobile
		if (StringUtils.isNotEmpty(matchDoctor.getMobile()) &&
				StringUtils.isEmpty(cloudDoctor.getMobile())) {
			cloudDoctor.setMobile(matchDoctor.getMobile());
		}
		//professionalRankId
		if (matchDoctor.getProfessionalRank() != null &&
				matchDoctor.getProfessionalRank() != 0) {
			cloudDoctor.setProfessionalRank(matchDoctor.getProfessionalRank());
		}
		//positionTitleId
		if (matchDoctor.getPositionTitle() != null &&
				matchDoctor.getPositionTitle() != 0) {
			cloudDoctor.setPositionTitle(matchDoctor.getPositionTitle());
		}
		//birthDate
		if (matchDoctor.getBirthDate() != null) {
			cloudDoctor.setBirthDate(matchDoctor.getBirthDate());
		}
		cloudDoctor.setSyncFlag(Constant.User.SYNCFLAG_YES);
		this.cloudDoctorDao.update(cloudDoctor);
		this.matchDoctorDao.delete(matchDoctor.getDoctorId());
		LogUtil.log.debug("Combined doctor data is completed----------<<");
		return true;
	}
	
	/**
	 * 
	 * @param doctorFinalUuid
	 * @param cloudDoctorId
	 * @return
	 */
	private boolean mergeDoctorPatient(String doctorFinalUuid, Doctor cloudDoctor) {
		LogUtil.log.debug("Start with the doctor-patient relationship----------->>");
		if (cloudDoctor == null) {
			return false;
		}
		//将医生、患者关系里的医生uuid全部修改为医生的finalUuid
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(doctorFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchDoctorPatientDao.updateDoctorUuid(doctorFinalUuid, uuidRelationships);
		}
		List<DoctorPatient> doctorPatients = this.matchDoctorPatientDao.findByDoctorUuid(doctorFinalUuid);
		if (doctorPatients == null || doctorPatients.isEmpty()) {
			return true;
		}
		Date nowTime = new Date();
		for (int index = doctorPatients.size() - 1; index >= 0; index--) {
			DoctorPatient doctorPatient = doctorPatients.get(index);
			Long rid = doctorPatient.getId();
			//doctorId
			doctorPatient.setDoctorId(cloudDoctor.getDoctorId());
			//处理sourceFlag
			if (doctorPatient.getSourceFlag() == null) {
				doctorPatient.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
			}
			//关注时间
			if (doctorPatient.getAttentionTime() == null) {
				doctorPatient.setAttentionTime(nowTime);
			}
			//创建时间
			if (doctorPatient.getCreateTime() == null) {
				doctorPatient.setCreateTime(nowTime);
			}
			//patientId
			if (StringUtils.isEmpty(doctorPatient.getPatientUuid())) {
				continue;
			}else{
				String patientFinalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorPatient.getPatientUuid());
				if (StringUtils.isEmpty(patientFinalUuid)) {
					patientFinalUuid = doctorPatient.getPatientUuid();
				}
				//查找患者
				Patient patient = this.cloudPatientDao.findByUuid(patientFinalUuid);
				if (patient == null) {
					continue;
				}
				doctorPatient.setPatientId(patient.getPatientId());
			}
			DoctorPatient cloudDoctorPatient = this.cloudDoctorPatientDao.findDoctorPatient(doctorPatient.getPatientId(), doctorPatient.getDoctorId());
			//云端不存在该医患关系，则创建
			if (cloudDoctorPatient == null) {
				this.cloudDoctorPatientDao.insert(doctorPatient);
			}
			//删除中间库的本条医患关系
			this.matchDoctorPatientDao.delete(rid);
		}
		LogUtil.log.debug("The relationship between doctors and patients is completed-----------<<");
		return true;
	}

	
	/**
	 * 
	 * @param doctorFinalUuid
	 * @param cloudDoctorId
	 * @return
	 */
	private boolean mergeHospitalDoctor(String doctorFinalUuid, Doctor cloudDoctor, User cloudUser) {
		LogUtil.log.debug("Start with the hospital, Department, doctor relationship---------->>");
		//将医院、科室、医生关系里的医生uuid全部修改为医生的finalUuid
		List<UuidRelationship> uuidRelationships = this.uuidRelationshipService.getByFinalUuid(doctorFinalUuid);
		if (uuidRelationships != null && !uuidRelationships.isEmpty()) {
			this.matchHospitalDoctorDao.updateDoctorUuid(doctorFinalUuid, uuidRelationships);
		}
		//获取匹配中间库中的所有医院、科室、医生关系
		List<HospitalDoctor> hospitalDoctors = this.matchHospitalDoctorDao.findByDoctorFinalUuid(doctorFinalUuid);
		if (hospitalDoctors != null && !hospitalDoctors.isEmpty()) {
			for (int i = hospitalDoctors.size() - 1; i >= 0; i--) {
				HospitalDoctor hospitalDoctor = hospitalDoctors.get(i);
				Long rid = hospitalDoctor.getId();
				hospitalDoctor.setDoctorId(cloudDoctor.getDoctorId());
				//处理hospitalId
				if (hospitalDoctor.getHospitalId() == null) {
					if (StringUtils.isEmpty(hospitalDoctor.getHospitalUuid())) {
						continue;
					}
					Hospital hospital = this.cloudHospitalDao.findByUuid(hospitalDoctor.getHospitalUuid());
					if (hospital == null) {
						continue;
					}
					hospitalDoctor.setHospitalId(hospital.getHospitalId());
				}
				//处理deptId
				if (StringUtils.isEmpty(hospitalDoctor.getDeptUuid())) {
					continue;
				}else{
					Department dept = this.cloudDepartmentDao.findByUuid(hospitalDoctor.getDeptUuid());
					if (dept == null) {
						continue;
					}
					hospitalDoctor.setDeptId(dept.getDeptId());
				}
				HospitalDoctor cloudHospitalDoctor = this.cloudHospitalDoctorDao.find(hospitalDoctor);
				if (cloudHospitalDoctor == null) {
					if(this.verificationHospitalDoctor(hospitalDoctor)){
						this.cloudHospitalDoctorDao.insert(hospitalDoctor);
						cloudHospitalDoctor = hospitalDoctor;
					}
				}else{
					boolean flag = false;
					if (cloudHospitalDoctor.getDeptId() != hospitalDoctor.getDeptId()) {
						cloudHospitalDoctor.setDeptId(hospitalDoctor.getDeptId());
						flag = true;
					}
					//员工号
					if (StringUtils.isNotEmpty(hospitalDoctor.getStaffNo()) &&
							(StringUtils.isEmpty(cloudHospitalDoctor.getStaffNo()) ||
									!hospitalDoctor.getStaffNo().equals(cloudHospitalDoctor.getStaffNo()))) {
						cloudHospitalDoctor.setStaffNo(hospitalDoctor.getStaffNo());
						flag = true;
					}
					//职位
					if(cloudHospitalDoctor.getPositionTitle()!=hospitalDoctor.getPositionTitle())
						cloudHospitalDoctor.setPositionTitle(hospitalDoctor.getPositionTitle());
					if (flag) {
						if(this.verificationHospitalDoctor(cloudHospitalDoctor)){
							this.cloudHospitalDoctorDao.update(cloudHospitalDoctor);
						}
					}
				}
				this.matchHospitalDoctorDao.delete(rid);
			}
		}
		LogUtil.log.debug("The relationship between the hospital, the Department and the doctor is completed.----------<<");
		return true;
	}
	
	private boolean verificationHospitalDoctor(HospitalDoctor hospitalDoctor) {
		if(this.cloudHospitalDao.existHospital(hospitalDoctor.getHospitalId()) < 1){
			return false;
		}
		if (this.cloudDepartmentDao.existDepartment(hospitalDoctor.getDeptId()) < 1) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param matchUser
	 * @param cloudUser
	 * @return
	 */
	private boolean mergeUser(User matchUser, User cloudUser) {
		LogUtil.log.debug("Start merging user data--------->>");
		//uuid
		if (StringUtils.isEmpty(cloudUser.getUuid())) {
			cloudUser.setUuid(matchUser.getUuid());
		}
		//trueName
		if (StringUtils.isNotEmpty(matchUser.getTrueName())) {
			cloudUser.setTrueName(matchUser.getTrueName());
		}
		//sex
		if (matchUser.getSex() != null && matchUser.getSex() != 0) {
			cloudUser.setSex(matchUser.getSex());
		}
		//mobile
		if (StringUtils.isNotEmpty(matchUser.getMobile()) &&
				StringUtils.isEmpty(cloudUser.getMobile())) {
			cloudUser.setMobile(matchUser.getMobile());
		}
		//email
		if (StringUtils.isNotEmpty(matchUser.getEmail())) {
			cloudUser.setEmail(matchUser.getEmail());
		}
		//birthDate
		if (matchUser.getBirthDate() != null) {
			cloudUser.setBirthDate(matchUser.getBirthDate());
		}
		//idType和identification
		if (StringUtils.isNotEmpty(matchUser.getIdentification())) {
			if (matchUser.getIdType() == null) {
				matchUser.setIdType(Constant.User.IDTYPE_ID);
			}
			cloudUser.setIdType(matchUser.getIdType());
			cloudUser.setIdentification(matchUser.getIdentification());
		}
		//sourceFlag
		if (cloudUser.getSourceFlag() == null) {
			cloudUser.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		cloudUser.setSyncFlag(Constant.User.SYNCFLAG_YES);
		this.cloudUserDao.update(cloudUser);
		LogUtil.log.debug("Merge user data to complete---------<<");
		return true;
	}

	@Transactional
	@Override
	public boolean syncDoctor(TDoctorSyncProfile doctorSyncProfile) {
		if (doctorSyncProfile.getSourceFlag() == null) {
			doctorSyncProfile.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		// 1. 查找是否有云端对应的uuid值
		String finalUuid = this.uuidRelationshipService.getFinalUuidByUuid(doctorSyncProfile.getUuid());
		//如果有对应的uuid值，使用云端的uuid值
		if (StringUtils.isNotEmpty(finalUuid)) {
			doctorSyncProfile.setUuid(finalUuid);
		}
		//手机号处理
		if (doctorSyncProfile.getMobile() != null) {
			String mobile = doctorSyncProfile.getMobile();
			if (mobile.length() > 15) {
				if (mobile.startsWith("1")) {
					doctorSyncProfile.setMobile(mobile.substring(0, 11));
				} else {
					doctorSyncProfile.setMobile(mobile.substring(0, 15));
				}
			}
		}
		//2.使用uuid查找用户
		User clouduser = this.cloudUserDao.findByUuid(doctorSyncProfile.getUuid());
		//有此uuid的用户
		if(clouduser != null){
			if (!comparisonDoctorFullProperty(clouduser, doctorSyncProfile)) {
				//合并到云端库
				this.syncToCloudUserAndDoctor(doctorSyncProfile, clouduser);
			}
			return true;
		}
		//3.如果传入的有手机号码，先使用手机号码匹配
		if (StringUtils.isNotEmpty(doctorSyncProfile.getMobile())) {
			List<User> users = this.cloudUserDao.findByMobile(doctorSyncProfile.getMobile(), Constant.User.ROLE_DOCTOR);
			//存在手机号
			if (users != null && !users.isEmpty()) {
				//逐个对比
				for (User user : users) {
					if (StringUtils.isNotEmpty(user.getUuid())) {
						//对比uuid值
						//if (doctorSyncProfile.getUuid().equals(user.getUuid())) {
							boolean flag = comparisonDoctorFullProperty(user, doctorSyncProfile);
							if (!flag) {
								//保存到匹配中间库
								doctorSyncProfile.setUserId(user.getUserId());
								this.saveMatchUserAndDoctor(doctorSyncProfile);
								break;
							}
						//}
					} else {
						//主动用户不用对比uuid值
						boolean flag = comparisonDoctorFullProperty(user, doctorSyncProfile);
						if (flag) {
							if (StringUtils.isEmpty(user.getUuid())) {
								//将云端数据库的数据修改为以ToB端为准
								this.updateUserAndDoctorToCloud(user, doctorSyncProfile);
							}
						}else{
							//保存到匹配中间库
							doctorSyncProfile.setUserId(user.getUserId());
							this.saveMatchUserAndDoctor(doctorSyncProfile);
						}
					}
				}
				return true;
			}
		}
		//还没有这条医生数据则使用传入的数据在云端数据库创建被动医生
		this.saveUuidMapAddDoctorToCloud(doctorSyncProfile);
		return true;
	}
	//保存uuid映射并将数据保存到云端数据库
	private boolean saveUuidMapAddDoctorToCloud(TDoctorSyncProfile doctorSyncProfile){
		//将数据保存到云端数据库
		this.saveDoctorToCloud(doctorSyncProfile);
		//保存uuid映射值
		createUuidMaper(doctorSyncProfile);
		return true;
	}

	/**
	 * 在云端数据库创建一条医生数据
	 * @param doctorSyncProfile
	 * @return
	 */
	private boolean saveDoctorToCloud(TDoctorSyncProfile doctorSyncProfile){
		LogUtil.log.debug("Synchronize physician data to the production database---------->>");
		//用户数据
		User user = doctorSyncProfile.createCloudUser();
		this.cloudUserDao.insert(user);
		doctorSyncProfile.setUserId(user.getUserId());
		//医生数据
		Doctor doctor = doctorSyncProfile.createCloudDoctor();
		doctor.setUserId(user.getUserId());
		this.cloudDoctorDao.insert(doctor);
		//医院、科室、医生关系数据
		HospitalDoctor hospitalDoctor = doctorSyncProfile.createHospitalDoctor();
		Department dept = this.cloudDepartmentDao.findByUuid(hospitalDoctor.getDeptUuid());
		if(dept != null)
			hospitalDoctor.setDeptId(dept.getDeptId());
		hospitalDoctor.setDoctorId(doctor.getDoctorId());
		this.cloudHospitalDoctorDao.insert(hospitalDoctor);
		
		//将uuid记录到Uuid关系表中
		UuidRelationship uuidRelationship = new UuidRelationship();
		uuidRelationship.setUuidFinal(doctor.getUuid());
		uuidRelationship.setUuid(doctor.getUuid());
		uuidRelationship.setHospitalId(doctorSyncProfile.getHospitalId());
		uuidRelationship.setSyncFlag(1);
		uuidRelationship.setUserId(user.getUserId());
		this.uuidRelationshipService.save(uuidRelationship);
		LogUtil.log.debug("Synchronize physician data to the production database----------<<");
		return true;
	}

	private void createUuidMaper(TDoctorSyncProfile doctorSyncProfile) {
		UuidRelationship uuidRelationship = new UuidRelationship();
		uuidRelationship.setHospitalId(doctorSyncProfile.getHospitalId());
		uuidRelationship.setSyncFlag(Constant.User.SYNCFLAG_YES);
		uuidRelationship.setUserId(doctorSyncProfile.getUserId());
		uuidRelationship.setUuid(doctorSyncProfile.getUuid());
		uuidRelationship.setUuidFinal(doctorSyncProfile.getUuid());
		uuidRelationship.setCreateTime(new Date());
		this.uuidRelationshipService.save(uuidRelationship);
	}
	
	/**
	 * 将传入的信息保存在匹配中间库
	 * 
	 *  "uuid":”350000es34n6i3n790djjde33s”，
	 *	"userNumber":”001256”,
	 *	"trueName”:”老王”,
	 *	"sex":1,
	 *	"mobile":"13566666666",
	 *	"email":"laowang@test.com"，
	 *	"deptUuid":"asfasdfasdf415454",
	 *	"childDeptUuid":1,
	 *	"professionalRankId":13,
	 *	"positionTitleId":101, 
	 *	"hospitalId ":15,
	 *	"idType":1,
	 *	"identification”:”10045614782215455555”,
	 *	"birthDate":"2015-09-08 09:06:06"
	 * 
	 * @param doctorSyncProfile
	 * @return
	 */
	private boolean saveMatchUserAndDoctor(TDoctorSyncProfile doctorSyncProfile){
		LogUtil.log.debug("Synchronize the doctor's data to the Middle Library--------->>");
		//判断是否有未处理的数据
		User user = this.matchUserDao.findByUuid(doctorSyncProfile.getUuid());
		if (user != null) {
			return false;
		}
		//用户表数据
		user = doctorSyncProfile.createUser();
		this.matchUserDao.insert(user);
		//保存医生数据
		Doctor doctor = doctorSyncProfile.createDoctor();
		doctor.setUserId(user.getUserId());
		this.matchDoctorDao.insert(doctor);
		//保存医院、科室、医生关系
		HospitalDoctor hospitalDoctor = doctorSyncProfile.createHospitalDoctor();
		this.matchHospitalDoctorDao.insert(hospitalDoctor);
		LogUtil.log.debug("Synchronize physician data to the Middle Library---------<<");
		return true;
	}
	
	private boolean syncToCloudUserAndDoctor(TDoctorSyncProfile doctorSyncProfile, User user) {
		LogUtil.log.debug("同步医生信息（syncToCloudUserAndDoctor()）---------->>>");
		Doctor doctor = this.cloudDoctorDao.findByUserId(user.getUserId());
		//合并医院、科室、医生关系
		this.syncHospitalDept(doctorSyncProfile, doctor);
		//合并医生信息
		this.syncDoctorInfo(doctorSyncProfile, doctor);
		//合并用户信息
		this.syncUserInfo(doctorSyncProfile, user);
		LogUtil.log.debug("同步医生信息完成（syncToCloudUserAndDoctor()）----------<<<");
		return true;
	}

	private void syncHospitalDept(TDoctorSyncProfile doctorSyncProfile, Doctor doctor) {
		LogUtil.log.debug("同步医院、科室、医生关系（syncHospitalDept()）---------->>>");
		if (StringUtils.isEmpty(doctorSyncProfile.getChildDeptUuid())) {
			return;
		}
		Department dept = this.cloudDepartmentDao.findByUuid(doctorSyncProfile.getChildDeptUuid());
		if (dept == null) {
			LogUtil.log.debug("SubDept uuid=" + doctorSyncProfile.getChildDeptUuid() + " does not exist！");
			return;
		}
		List<HospitalDoctor> hospitalDoctors = this.cloudHospitalDoctorDao.findByDoctorId(doctorSyncProfile.getHospitalId(), doctor.getDoctorId());
		HospitalDoctor hospitalDoctor = null;
		if (hospitalDoctors == null || hospitalDoctors.isEmpty()) {
			hospitalDoctor = doctorSyncProfile.createHospitalDoctor();
			hospitalDoctor.setDoctorId(doctor.getDoctorId());
			hospitalDoctor.setDeptId(dept.getDeptId());
			this.cloudHospitalDoctorDao.insert(hospitalDoctor);
			LogUtil.log.debug("add hospitalDoctor:" + JsonUtil.toJson(hospitalDoctor));
		} else {
			hospitalDoctor = hospitalDoctors.get(0);
			if(hospitalDoctor.getDeptId() != dept.getDeptId()){
				LogUtil.log.debug("befor update hospitalDoctor:" + JsonUtil.toJson(hospitalDoctor));
				boolean flag = false;
				if (hospitalDoctor.getDeptId() != dept.getDeptId()) {
					hospitalDoctor.setDeptId(dept.getDeptId());
					flag = true;
				}
				if (StringUtils.isNotEmpty(doctorSyncProfile.getStaffNo()) &&
						!doctorSyncProfile.getStaffNo().equals(hospitalDoctor.getStaffNo())) {
					hospitalDoctor.setStaffNo(doctorSyncProfile.getStaffNo());
					flag = true;
				}
				if (doctorSyncProfile.getHospitalId() != hospitalDoctor.getHospitalId()) {
					hospitalDoctor.setHospitalId(doctorSyncProfile.getHospitalId());
					flag = true;
				}
				if (doctorSyncProfile.getPositionTitleId() != null &&
						doctorSyncProfile.getPositionTitleId() != hospitalDoctor.getPositionTitle()) {
					hospitalDoctor.setPositionTitle(doctorSyncProfile.getPositionTitleId());
					flag = true;
				}
				if (flag) {
					hospitalDoctor.setSyncTime(doctorSyncProfile.getSyncTime());
					this.cloudHospitalDoctorDao.update(hospitalDoctor);
				}
				LogUtil.log.debug("after update hospitalDoctor:" + JsonUtil.toJson(hospitalDoctor));
			}
		}
		LogUtil.log.debug("同步医院、科室、医生关系完成（syncHospitalDept()）----------<<<");
	}

	private void syncUserInfo(TDoctorSyncProfile doctorSyncProfile, User user) {
		LogUtil.log.debug("同步用户信息（syncToCloudUserAndDoctor()）---------->>>");
		boolean flag = false;
		//合并uuid
		if (StringUtils.isEmpty(user.getUuid())) {
			user.setUuid(doctorSyncProfile.getUuid());
			flag = true;
		}
		//合并真实姓名
		if (StringUtils.isNotEmpty(doctorSyncProfile.getTrueName()) &&
				!doctorSyncProfile.getTrueName().equals(user.getTrueName())) {
			user.setTrueName(doctorSyncProfile.getTrueName());
			flag = true;
		}
		//合并性别
		if (doctorSyncProfile.getSex() != null && doctorSyncProfile.getSex() != user.getSex()) {
			user.setSex(doctorSyncProfile.getSex());
			flag = true;
		}
		//合并电话
		if (StringUtils.isNotEmpty(doctorSyncProfile.getMobile()) &&
				StringUtils.isEmpty(user.getMobile())) {
			user.setMobile(doctorSyncProfile.getMobile());
			if (StringUtils.isEmpty(user.getUserName())) {
				user.setUserName(user.getMobile());
			}
			flag = true;
		}
		//合并email
		if (StringUtils.isNotEmpty(doctorSyncProfile.getEmail()) &&
				(StringUtils.isEmpty(user.getEmail()) || !doctorSyncProfile.getEmail().equals(user.getEmail()))) {
			user.setEmail(doctorSyncProfile.getEmail());
			flag = true;
		}
		//合并证件号
		if (StringUtils.isNotEmpty(doctorSyncProfile.getIdentification()) &&
				(StringUtils.isEmpty(user.getIdentification()) ||
						!doctorSyncProfile.getIdentification().equals(user.getIdentification()))) {
			if (doctorSyncProfile.getIdType() == null) {
				doctorSyncProfile.setIdType(Constant.IDTYPE_ID);
			}
			user.setIdType(doctorSyncProfile.getIdType());
			user.setIdentification(doctorSyncProfile.getIdentification());
			flag = true;
		}
		//合并生日
		if (doctorSyncProfile.getBirthDate() != null &&
				(user.getBirthDate() == null ||
				doctorSyncProfile.getBirthDate().compareTo(user.getBirthDate()) != 0)) {
			user.setBirthDate(doctorSyncProfile.getBirthDate());
			flag = true;
		}
		//sourceFlag
		if (user.getSourceFlag() == null) {
			user.setSourceFlag(Constant.User.USERSOURCEFLAG_HOSPITAIL);
		}
		if (flag) {
			user.setSyncFlag(Constant.User.SYNCFLAG_YES);
			user.setSyncTime(doctorSyncProfile.getSyncTime());
			this.cloudUserDao.update(user);
		}
		LogUtil.log.debug("同步用户信息完成（syncToCloudUserAndDoctor()）----------<<<");
	}

	private void syncDoctorInfo(TDoctorSyncProfile doctorSyncProfile, Doctor doctor) {
		LogUtil.log.debug("同步医生基本信息（syncToCloudUserAndDoctor()）---------->>>");
		boolean flag = false;
		//合并uuid
		if (StringUtils.isEmpty(doctor.getUuid())) {
			doctor.setUuid(doctorSyncProfile.getUuid());
			flag = true;
		}
		//合并真实姓名
		if (StringUtils.isNotEmpty(doctorSyncProfile.getTrueName()) &&
				!doctorSyncProfile.getTrueName().equals(doctor.getTrueName())) {
			doctor.setTrueName(doctorSyncProfile.getTrueName());
			flag = true;
		}
		//合并性别
		if (doctorSyncProfile.getSex() != null && doctorSyncProfile.getSex() != doctor.getSex()) {
			doctor.setSex(doctorSyncProfile.getSex());
			flag = true;
		}
		//合并电话
		if (StringUtils.isNotEmpty(doctorSyncProfile.getMobile()) &&
				StringUtils.isEmpty(doctor.getMobile())) {
			doctor.setMobile(doctorSyncProfile.getMobile());
			flag = true;
		}
		//合并职务
		if (doctorSyncProfile.getPositionTitleId() != null &&
				doctorSyncProfile.getPositionTitleId() != doctor.getPositionTitle()) {
			doctor.setPositionTitle(doctorSyncProfile.getPositionTitleId());
			flag = true;
		}
		//合并职责
		if (doctorSyncProfile.getProfessionalRankId() != null &&
				doctorSyncProfile.getProfessionalRankId() != doctor.getProfessionalRank()) {
			doctor.setProfessionalRank(doctorSyncProfile.getProfessionalRankId());
			flag = true;
		}
		//合并生日
		if (doctorSyncProfile.getBirthDate() != null &&
				(doctor.getBirthDate() == null || doctorSyncProfile.getBirthDate().compareTo(doctor.getBirthDate()) != 0)) {
			doctor.setBirthDate(doctorSyncProfile.getBirthDate());
			flag = true;
		}
		if (flag) {
			doctor.setSyncFlag(Constant.User.SYNCFLAG_YES);
			doctor.setSyncTime(doctorSyncProfile.getSyncTime());
			this.cloudDoctorDao.update(doctor);
		}
		LogUtil.log.debug("同步医生基本信息完成（syncToCloudUserAndDoctor()）----------<<<");
	}

	/**
	 * 更新云端用户的数据
	 * @param user
	 * @param doctorSyncProfile
	 * @return
	 */
	private boolean updateUserAndDoctorToCloud(User user, TDoctorSyncProfile doctorSyncProfile) {
		//更新云端用户的数据
		user.setUuid(doctorSyncProfile.getUuid());
		user.setSyncTime(doctorSyncProfile.getSyncTime());
		this.cloudUserDao.update(user);
		//创建uuid映射
		this.createUuidMaper(doctorSyncProfile);
		return true;
	}

	/**
	 * 逐个比对对象中的值
	 * @param user
	 * @param doctorSyncProfile
	 * @return
	 */
	private boolean comparisonDoctorFullProperty(User user, TDoctorSyncProfile doctorSyncProfile) {
		//真实姓名
		if (StringUtils.isNotEmpty(doctorSyncProfile.getTrueName()) &&
				!user.getTrueName().equals(doctorSyncProfile.getTrueName())) {
			return false;
		}
		//性别
		if (doctorSyncProfile.getSex() != null &&
				doctorSyncProfile.getSex() != user.getSex()) {
			return false;
		}
		//邮箱
		if (StringUtils.isNotEmpty(doctorSyncProfile.getEmail()) &&
				!doctorSyncProfile.getEmail().equals(user.getEmail())) {
			return false;
		}
		//出生日期
		if (doctorSyncProfile.getBirthDate() != null) {
			if (user.getBirthDate() == null) {
				return false;
			}
			if (doctorSyncProfile.getBirthDate().compareTo(user.getBirthDate()) != 0) {
				return false;
			}
		}
		//证件类型
		if (doctorSyncProfile.getIdType() != null &&
				doctorSyncProfile.getIdType() != user.getIdType()) {
			return false;
		}
		//证件号
		if (StringUtils.isNotEmpty(doctorSyncProfile.getIdentification()) &&
				!doctorSyncProfile.getIdentification().equals(user.getIdentification())) {
			return false;
		}
		//将医生数据获取出来对比
		Doctor doctor = this.cloudDoctorDao.findByUserId(user.getUserId());
		//职务
		if (doctorSyncProfile.getProfessionalRankId() != null &&
				doctorSyncProfile.getProfessionalRankId() != doctor.getProfessionalRank()) {
			return false;
		}
		if (doctorSyncProfile.getHospitalId() != null &&
				StringUtils.isNotEmpty(doctorSyncProfile.getDeptUuid())) {
			//医院、科室、子科室、医生关系
			List<HospitalDoctor> hospitalDoctors = this.cloudHospitalDoctorDao.findByDoctorId(doctorSyncProfile.getHospitalId(), doctor.getDoctorId());
			if (hospitalDoctors != null && !hospitalDoctors.isEmpty()) {
				HospitalDoctor hospitalDoctor = hospitalDoctors.get(0);
				if (doctorSyncProfile.getHospitalId() != hospitalDoctor.getHospitalId()
						|| !doctorSyncProfile.getDeptUuid().equals(hospitalDoctor.getDeptUuid())) {
					return false;
				}
				//员工号
				if (StringUtils.isNotEmpty(doctorSyncProfile.getStaffNo())
						&& !doctorSyncProfile.getStaffNo().equals(hospitalDoctor.getStaffNo())) {
					return false;
				}
			} else {
				//如果医院、科室、医生关系，说明云端没有该关系
				if (doctorSyncProfile.getHospitalId() != null
						&& StringUtils.isNotEmpty(doctorSyncProfile.getDeptUuid())) {
					return false;
				}
			} 
		}
		return true;
	}
}
