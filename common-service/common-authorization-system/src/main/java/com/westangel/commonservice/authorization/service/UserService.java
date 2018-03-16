package com.westangel.commonservice.authorization.service;

import com.westangel.common.bean.Page;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.excption.DisableExcption;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.ObjectNotAvailableExcption;
import com.westangel.common.excption.RejectRequestExcption;
import com.westangel.commonservice.authorization.bean.TUserDoctorInfo;

/**
 * <p>Title:UserService</p>
 * <p>Description:用户业务层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 上午9:55:17
 */
public interface UserService {

	/**
	 * <p>Title:addUserDoctor</p>
	 * <p>Description:医生用户信息添加</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:22:52
	 * @param userDoctorInfo
	 * @return
	 * @throws ObjectAlreadyExistExcption 
	 * @throws InsufficientParameterExcption 
	 */
	boolean addUser(TUserDoctorInfo userDoctorInfo) throws ObjectAlreadyExistExcption, InsufficientParameterExcption;

	/**
	 * <p>Title:updateUserState</p>
	 * <p>Description:更新用户的状态</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午4:55:59
	 * @param userId
	 * @param state
	 * @return
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean updateUserState(Long userId, Integer state) throws InsufficientParameterExcption, ObjectNotAvailableExcption;

	/**
	 * <p>Title:login</p>
	 * <p>Description:用户登录功能</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午4:51:48
	 * @param user
	 * @return
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectNotAvailableExcption 
	 * @throws RejectRequestExcption 
	 * @throws DisableExcption 
	 */
	UserProfileDetailResp login(User user) throws InsufficientParameterExcption, ObjectNotAvailableExcption, RejectRequestExcption, DisableExcption;

	/**
	 * <p>Title:getDoctorUserList</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午7:03:45
	 * @param userDoctorInfo
	 * @return
	 */
	Page<UserProfile> getUserList(TUserDoctorInfo userDoctorInfo);

	/**
	 * <p>Title:modifyPasswd</p>
	 * <p>Description:修改账号密码</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午7:49:31
	 * @param userProfile
	 * @return
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectNotAvailableExcption 
	 * @throws RejectRequestExcption 
	 */
	boolean modifyPasswd(UserProfile userProfile) throws InsufficientParameterExcption, ObjectNotAvailableExcption, RejectRequestExcption;

	/**
	 * <p>Title:updateUser</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:04:29
	 * @param userDoctorInfo
	 * @return
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectNotAvailableExcption 
	 */
	boolean updateUser(TUserDoctorInfo userDoctorInfo) throws InsufficientParameterExcption, ObjectNotAvailableExcption;

	/**
	 * <p>Title:getManagerInfo</p>
	 * <p>Description:管理员信息获取</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午3:05:50
	 * @param userId
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	UserProfile getManagerInfo(Long userId) throws InsufficientParameterExcption;

	/**
	 * <p>Title:updateManagerInfo</p>
	 * <p>Description:管理员个人信息修改</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午4:04:40
	 * @param user
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	boolean updateManagerInfo(User user) throws InsufficientParameterExcption;

	/**
	 * <p>Title:activationOrCancellation</p>
	 * <p>Description:激活与注销用户</p>
	 * @author YYCHEN
	 * @date 2016年9月3日 下午3:30:37
	 * @param userProfile
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	boolean activationOrCancellation(UserProfile userProfile) throws InsufficientParameterExcption;
}
