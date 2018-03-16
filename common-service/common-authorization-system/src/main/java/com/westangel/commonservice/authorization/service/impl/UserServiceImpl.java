package com.westangel.commonservice.authorization.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.github.pagehelper.PageHelper;
import com.westangel.common.bean.Doctor;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.bean.authorization.RUserRole;
import com.westangel.common.constant.Constant;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.common.excption.RemoteCallExcption;
import com.westangel.common.util.PageUtil;
import com.westangel.commonservice.authorization.bean.TUserDoctorInfo;
import com.westangel.commonservice.authorization.dao.DoctorDao;
import com.westangel.commonservice.authorization.dao.RHospitalDoctorDao;
import com.westangel.commonservice.authorization.dao.RUserRoleDao;
import com.westangel.commonservice.authorization.dao.UUserPingDao;
import com.westangel.commonservice.authorization.dao.UserDao;
import com.westangel.commonservice.authorization.model.UUserPing;
import com.westangel.commonservice.authorization.service.DoctorService;
import com.westangel.commonservice.authorization.service.RHospitalDoctorService;
import com.westangel.commonservice.authorization.service.UserService;

/**
 * <p>Title:UserServiceImpl</p>
 * <p>Description:用户业务层实现</p>
 * @author YYCHEN
 * @date 2016年7月5日 上午9:56:59
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DoctorDao doctorDao;
	@Autowired
	private RUserRoleDao userRoleDao;
	@Autowired
	private UUserPingDao userPingDao;
	@Autowired
	private RHospitalDoctorDao hospitalDoctorDao;
	
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private RHospitalDoctorService hospitalDoctorService;
	
	@Transactional
	@Override
	public boolean addUser(TUserDoctorInfo userDoctorInfo) throws ObjectAlreadyExistExcption, InsufficientParameterExcption {
		User userProfile = userDoctorInfo.getUserProfile();
		Doctor doctorProfile = userDoctorInfo.getDoctorProfile();
		if (userProfile == null || doctorProfile == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		userProfile.setRole(Constant.User.ROLE_DOCTOR);//账号身份——医生
		this.addUser(userProfile);
		//如果分配了角色
		if (userProfile.getUserRole() != null) {
			RUserRole userRole = new RUserRole();
			userRole.setUserId(userProfile.getUserId());
			userRole.setUserRole(userProfile.getUserRole());
			this.userRoleDao.insert(userRole);
			//用户分配员工号
			if (StringUtils.isEmpty(doctorProfile.getStaffNo())) {
				doctorProfile.setStaffNo(this.hospitalDoctorDao.findStaffNo(doctorProfile.getHospitalId(), "T"));
			}
		}
		doctorProfile.setUserId(userProfile.getUserId());//userId
		//医生手机号
		if (StringUtils.isEmpty(doctorProfile.getMobile())) {
			doctorProfile.setMobile(userProfile.getMobile());
		}
		doctorProfile.setTrueName(userProfile.getTrueName());
		doctorProfile.setMobile(userProfile.getMobile());
		doctorProfile.setSex(userProfile.getSex());
		this.doctorService.addDoctor(doctorProfile);
		this.hospitalDoctorService.addOrUpdateHospitalDoctor(doctorProfile);
		return true;
	}
	
	/**
	 * <p>Title:addUser</p>
	 * <p>Description:新增用户基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:32:33
	 * @param user
	 * @return
	 * @throws ObjectAlreadyExistExcption 
	 * @throws InsufficientParameterExcption 
	 */
	private boolean addUser(User user) throws ObjectAlreadyExistExcption, InsufficientParameterExcption{
		//验证手机号
		if (StringUtils.isEmpty(user.getMobile()) ||
				StringUtils.isEmpty(user.getUserName()) ||
				StringUtils.isEmpty(user.getCryptPasswd())) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		//验证用户是否存在
		User oldUser = this.userDao.findByMobile(user.getMobile(), user.getRole());
		if (oldUser != null) {
			throw new ObjectAlreadyExistExcption("User already exists!");
		}
		oldUser = this.userDao.findByUserName(user.getUserName(), user.getRole());
		if (oldUser != null) {
			throw new ObjectAlreadyExistExcption("User already exists!");
		}
		//同步标识
		if (user.getSyncFlag() == null) {
			user.setSyncFlag(Constant.SYNC_NO);//同步
		}
		user.setCryptPasswd(user.getCryptPasswd());
		user.setAccountType(user.getAccountType());//用户类型
		user.setAppFlag(0);//APP注册用户标识:否
		user.setWeixinFlag(0);//微信用户标识：否
		user.setPcFlag(1);//PC注册用户标识：否
		user.setInfoState(Constant.User.INFOSTATE_NOTPERFECT);//信息填写状态
		//用户状态
		if (null == user.getState()) {
			user.setState(Constant.User.USERSTATE_NORMAL);
		}
		user.setState(user.getState());//用户状态
		user.setPoints(0);//积分（爱心）
		user.setSourceFlag(Constant.User.USERSOURCEFLAG_UNKNOWN);//用户来源标志
		user.setUserFlag(0);//用户类型标识
		user.setMigrateFlag(0);//老系统迁移过来的用户，会打上此标志。用于统计和识别
		user.setAppFlag(0);
		user.setWeixinFlag(0);
		user.setPcFlag(0);
		this.userDao.insert(user);
		return true;
	}

	@Transactional
	@Override
	public boolean updateUserState(Long userId, Integer state) throws InsufficientParameterExcption, ObjectNotAvailableExcption {
		if (userId == null || state == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		User user = this.userDao.findByUserId(userId);
		if (user == null) {
			throw new ObjectNotAvailableExcption("user does not exist!");
		}
		user.setState(state);
		this.userDao.update(user);
		//如果是删除用户，删除用户与角色关系
		if (state == -3) {
			this.userRoleDao.deleteByUserId(userId, null);
		}
		return true;
	}

	@Override
	public UserProfileDetailResp login(User user) throws InsufficientParameterExcption, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption {
		if (StringUtils.isEmpty(user.getUserName()) ||
				(user.isNeedPwFlag()&&StringUtils.isEmpty(user.getCryptPasswd()))) {
			throw new InsufficientParameterExcption("Account or password can not be empty!");
		}
		if (null == user.getRole()) {
			user.setRole(Constant.User.ROLE_DOCTOR);
		}
		UserProfile userProfile = this.userDao.findUserProfileByUserName(user.getUserName(), user.getRole());
		if (userProfile == null) {
			throw new ObjectNotAvailableExcption(user.getUserName() + ", Account error!");
		}
		//账号状态
		if (Constant.User.USERSTATE_NORMAL != userProfile.getState()) {
			throw new RemoteCallExcption("Account is locked!");
		}
		//账号是否激活
		if (Constant.User.ACCOUNTTYPE_NONACTIVATED >= userProfile.getAccountType()) {
			throw new RemoteCallExcption("Account is not activated!");
		}
		if (user.isNeedPwFlag()&&!user.getCryptPasswd().equals(userProfile.getCryptPasswd())) {
			throw new RejectRequestExcption(user.getUserName() + ", Password error!");
		}
		Calendar calendar = Calendar.getInstance();
		//处理登录时间
		/*User currentUser = new User();
		if (userProfile.getFirstLoginTime() == null) {
			currentUser.setFirstLoginTime(calendar.getTime());
		}
		currentUser.setUserId(userProfile.getUserId());
		currentUser.setLastLoginTime(calendar.getTime());
		this.userDao.update(currentUser);*/
		
		/*UUserPing userPing=new UUserPing();
		userPing.setLuid(userProfile.getUserId()+"");
		userPing.setRole(2);
		userPing.setUserId(userProfile.getUserId());
		userPing.setBusinessId(1);
		userPing.setProductId(3);
		userPing.setAppVersion("tob263");
		userPing.setBeginTime(new Date());
		userPing.setEndTime(new Date());
		userPing.setUsageDuration(1l);
		userPing.setUploadTime(new Date());
		userPingDao.insert(userPing);*/
		
		//查询角色
		List<RUserRole> userRoles = this.userRoleDao.findByUserId(userProfile.getUserId());
		if (userRoles == null || userRoles.isEmpty()) {
			throw new RemoteCallExcption("Users without any permission!");
		} else {
			
			RUserRole userRole = userRoles.get(0);
			userProfile.setUserRole(userRole.getUserRole());
			userProfile.setRoleName(userRole.getRoleName());
			userProfile.setRoleType(userRole.getRoleType());
			
			userProfile.setUserRoleList(userRoles);
		}
		UserProfileDetailResp userProfileDetailResp = new UserProfileDetailResp();
		userProfileDetailResp.setUserProfile(userProfile);
		userProfileDetailResp.setDoctorProfile(this.doctorDao.findDoctorProfileByUserId(userProfile.getUserId()));
		return userProfileDetailResp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<UserProfile> getUserList(TUserDoctorInfo userDoctorInfo) {
		if (userDoctorInfo.getPage() == null || userDoctorInfo.getPage() < 0) {
			userDoctorInfo.setPage(0);
		}
		if (userDoctorInfo.getNum() == null || userDoctorInfo.getNum() < 1) {
			userDoctorInfo.setNum(10);
		}
		PageHelper.startPage(userDoctorInfo.getPage() + 1, userDoctorInfo.getNum());
		List<UserProfile> userProfiles = this.userDao.searchUserProfiles(userDoctorInfo);
		if (userProfiles != null && !userProfiles.isEmpty()) {
			for (UserProfile userProfile : userProfiles) {
				if (userProfile.getParentId() != null) {
					userProfile.setParent(this.doctorDao.findByDoctorId(userProfile.getParentId()));
				}
				userProfile.setSubordinateUserList(this.doctorDao.findSubordinateDoctorList(userProfile.getDoctorId()));
			}
		}
		return PageUtil.returnPage((com.github.pagehelper.Page<UserProfile>)userProfiles);
	}

	@Transactional
	@Override
	public boolean modifyPasswd(UserProfile userProfile) throws InsufficientParameterExcption, ObjectNotAvailableExcption, RejectRequestExcption {
		if (userProfile.getUserId() == null ||
				StringUtils.isEmpty(userProfile.getCryptPasswd())) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		if (null != userProfile.getConfirmFlag() && userProfile.getConfirmFlag() == 1 &&
				StringUtils.isEmpty(userProfile.getObsoletePassword())) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		User user = this.userDao.findByUserId(userProfile.getUserId());
		if (user == null) {
			throw new ObjectNotAvailableExcption("user does not exist!");
		}
		if (userProfile.getConfirmFlag()!=null&&1==userProfile.getConfirmFlag() &&
				!userProfile.getObsoletePassword().equals(user.getCryptPasswd())) {
			throw new RejectRequestExcption("Original password error!");
		}
		user.setCryptPasswd(userProfile.getCryptPasswd());
		this.userDao.update(user);
		return true;
	}

	@Transactional
	@Override
	public boolean updateUser(TUserDoctorInfo userDoctorInfo) throws InsufficientParameterExcption, ObjectNotAvailableExcption {
		User userProfile = userDoctorInfo.getUserProfile();
		Doctor doctorProfile = userDoctorInfo.getDoctorProfile();
		if (userProfile == null || doctorProfile == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		if (userProfile == null || doctorProfile == null || userProfile.getUserId() == null) {
			throw new InsufficientParameterExcption("Parameters cannot be empty!");
		}
		User user = this.userDao.findByUserId(userProfile.getUserId());
		if (user == null) {
			throw new ObjectNotAvailableExcption("user does not exist!");
		}
		//用户基本信息
		user.setUserName(userProfile.getUserName());
		user.setCryptPasswd(userProfile.getCryptPasswd());
		user.setAccountType(userProfile.getAccountType());
		user.setState(userProfile.getState());
		user.setSex(userProfile.getSex());
		user.setTrueName(userProfile.getTrueName());
		user.setMobile(userProfile.getMobile());
		user.setEmail(userProfile.getEmail());
		
		//医生基本信息
		Doctor doctor = this.doctorDao.findByUserId(user.getUserId());
		doctor.setTrueName(user.getTrueName());
		doctor.setMobile(user.getMobile());
		doctor.setSex(user.getSex());
		doctor.setPositionTitle(doctorProfile.getPositionTitle());
		doctor.setProfessionalRank(doctorProfile.getProfessionalRank());
		this.userDao.update(user);
		//用户权限
		if(userProfile.getUserRole() != null){
			this.userRoleDao.deleteByUserId(user.getUserId(), null);
			RUserRole userRole = new RUserRole();
			userRole.setUserId(user.getUserId());
			userRole.setUserRole(userProfile.getUserRole());
			this.userRoleDao.insert(userRole);
		}else{
			//上级
			doctor.setParentId(doctorProfile.getParentId());
			List<Doctor> subordinateUserList = doctorProfile.getSubordinateUserList();
			//下级
			this.doctorDao.removeParentRelation(doctor.getDoctorId());
			if (subordinateUserList != null && !subordinateUserList.isEmpty()) {
				//更新下级医生
				this.doctorDao.updateSubordinate(doctor.getDoctorId(), subordinateUserList);
			}
		}
		this.doctorDao.update(doctor);

		//医院、医生关系
		doctorProfile.setDoctorId(doctor.getDoctorId());
		this.hospitalDoctorService.addOrUpdateHospitalDoctor(doctorProfile);
		return true;
	}

	@Override
	public UserProfile getManagerInfo(Long userId) throws InsufficientParameterExcption {
		if (userId == null) {
			//获取一个有电话联系方式的管理员，如果没有有联系电话的管理员，则随机返回一个管理员信息
			return this.userDao.findHasContactInformationManager();
		}
		UserProfile userProfile = this.userDao.findUserProfileByUserId(userId);
		if (userProfile == null) {
			throw new InsufficientParameterExcption("userId can not be empty!");
		}
		//查询权限
		userProfile.setUserRoleList(this.userRoleDao.findByUserId(userProfile.getUserId()));
		return userProfile;
	}

	@Override
	public boolean updateManagerInfo(User user) throws InsufficientParameterExcption {
		if (user == null ||
				user.getUserId() == null) {
			throw new InsufficientParameterExcption("params can not be empty!");
		}
		this.userDao.update(user);
		return true;
	}

	@Override
	public boolean activationOrCancellation(UserProfile userProfile) throws InsufficientParameterExcption {
		if (userProfile == null || userProfile.getUserId() == null || userProfile.getAccountType() == null) {
			throw new InsufficientParameterExcption("params can not be empty!");
		}
		this.userDao.activationOrCancellation(userProfile);
		return true;
	}
}
