/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.service<br/>  
 * <b>文件名：</b>UserService.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月2日-下午5:37:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.service;

import java.util.HashMap;
import java.util.List;

import com.esuizhen.cloudservice.user.bean.PasswordModifyReq;
import com.esuizhen.cloudservice.user.bean.UserLoginOutReq;
import com.esuizhen.cloudservice.user.bean.UserProfileDetailReq;
import com.esuizhen.cloudservice.user.bean.UserRegisterReq;
import com.esuizhen.cloudservice.user.model.OperationHistory;
import com.westangel.common.bean.LoginByThirdPartyReq;
import com.westangel.common.bean.LoginByThirdPartyResp;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.common.bean.UserProfileDetailResp;
import com.westangel.common.bean.UserProfileModifyReq;
import com.westangel.common.bean.UserStatisProfile;
import com.westangel.common.bean.user.TConfirmUserReq;
import com.westangel.common.bean.user.TConfirmUserResp;
import com.westangel.common.bean.user.UserLoginOutResp;
import com.westangel.common.bean.user.UserRegisterResp;
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

/** 
* @ClassName: UserService 
* @Description: TODO
* @author YYCHEN
* @date 2015年12月2日 下午5:37:19  
*/
public interface UserService {
//	/**
//	 * 
//	* @Title: verify 
//	* @Description: 通过用户名严重用户是否已经存在
//	* @param userName
//	* @return boolean
//	* @throws
//	 */
//	public boolean verify(String userName);


	/**
	 * @throws ObjectAlreadyExistExcption 
	 * @throws BindingDataExcption 
	 * 
	* @Title: confirmUserInfo 
	* @Description: 确认用户信息 
	* @param @param confirmUserInfo
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public TConfirmUserResp confirmUserInfo(TConfirmUserReq confirmUserReq) throws EmptyParamExcption, RemoteCallExcption, BindingDataExcption, ObjectAlreadyExistExcption;
	
	/**
	 * @throws 
	 * @throws ParamMismatchExcption 
	 * @throws EmptyObjectExcption 
	 * 
	* @Title: login 
	* @Description: 根据用户登录信息查询登录账号信息
	* @param 
	* @return UserRegisterResp
	* @throws
	 */
	public UserRegisterResp loginselectUser(UserRegisterReq userRegisterReq) throws EmptyObjectExcption, ParamMismatchExcption, ObjectNotAvailableExcption;

	/**
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectAlreadyExistExcption 
	 * @throws RejectRequestExcption 
	 * @throws EmptyParamExcption 
	 * @throws ParamFormatErrorExcption 
	 * 
	* @Title: register 
	* @Description: 用户注册
	* @param 
	* @return TMsgResponse<UserRegisterResp>
	* @throws
	 */
	public UserRegisterResp register(UserRegisterReq userRegisterReq) throws ParamFormatErrorExcption, EmptyParamExcption, RejectRequestExcption, ObjectAlreadyExistExcption, ObjectNotAvailableExcption, InsufficientParameterExcption;

	/**
	 * @throws RejectRequestExcption 
	 * @throws ParamFormatErrorExcption 
	 * @throws EmptyObjectExcption 
	 * 
	* @Title: modifyPassword 
	* @Description: 忘记密码和密码修改
	* @param 
	* @return TMsgResponse
	* @throws
	 */
	public boolean modifyPassword(PasswordModifyReq passwordModifyReq) throws EmptyObjectExcption, ParamFormatErrorExcption, RejectRequestExcption, ObjectNotAvailableExcption, EmptyParamExcption;

	/**
	 * 
	* @Title: selectUserById 
	* @Description: 根据用户编号查询用户详细信息
	* @param 
	* @return User
	* @throws
	 */
	public User selectUserById(Long userId);
	/**
	 * @throws EmptyParamExcption 
	 * 
	* @Title: loginByThirdParty 
	* @Description: 第三方登录接口
	* @param 
	* @return LoginByThirdPartyResp
	* @throws
	 */
	public LoginByThirdPartyResp loginByThirdParty(LoginByThirdPartyReq loginByThirdPartyReq) throws EmptyParamExcption;
	
	/**
	 * @throws BindingDataExcption 
	 * @throws ObjectAlreadyExistExcption 
	 * @throws ParamMismatchExcption 
	 * @throws ParamFormatErrorExcption 
	 * @throws EmptyObjectExcption 
	 * 
	* @Title: bindThirdPartyUser 
	* @Description: 第三方账号绑定
	* @param 
	* @return LoginByThirdPartyResp
	* @throws
	 */
	public LoginByThirdPartyResp bindThirdPartyUser(LoginByThirdPartyReq loginByThirdPartyReq)throws EmptyParamExcption, EmptyObjectExcption, ParamFormatErrorExcption, ParamMismatchExcption, ObjectAlreadyExistExcption, BindingDataExcption;
	
	/**
	 * @throws ParamFormatErrorExcption 
	 * @throws RejectRequestExcption 
	 * @throws RemoteCallExcption 
	 * @throws ParamMismatchExcption 
	 * @throws EmptyParamExcption 
	* @Title: modifyUserProfile 
	* @Description: 用户详细信息资料设置
	* @param 
	* @return Long
	* @throws
	 */
	public LoginByThirdPartyResp modifyUserProfile(UserProfileModifyReq userProfileModifyReq) throws EmptyParamExcption, EmptyObjectExcption, ParamMismatchExcption, RemoteCallExcption, RejectRequestExcption;
	
	/**
	 * @throws EmptyObjectExcption 
	 * @throws EmptyParamExcption 
	 * 
	* @Title: selectUserProfileByUserId 
	* @Description: 根据用户编号查询用户基本信息
	* @param 
	* @return UserProfile
	* @throws
	 */
	public UserProfileDetailResp getDetailUserProfile(UserProfileDetailReq req) throws EmptyParamExcption, EmptyObjectExcption;

	/**
	 * 
	* @Title: getUserStatisProfile 
	* @Description: 根据用户编号查询用户统计信息
	* @param 
	* @return UserStatisProfile
	* @return role
	* @throws
	 */
	public UserStatisProfile getUserStatisProfile(UserProfile userProfile, Integer role);

	/**
	 * 通过微信二维码ticket反查用户信息
	 * @param ticket
	 * @return
	 * @throws EmptyObjectExcption 
	 * @throws EmptyParamExcption 
	 */
	public UserLoginOutResp queryUserInfoByTicket(String ticket) throws EmptyParamExcption, EmptyObjectExcption;
	
	/**
	 * 初始化用户城市
	 * @author lichenghao
	 * @title :initUserCity
	 * @Description:TODO
	 * @return void
	 * @date 2016年4月18日 下午2:03:40
	 */
	public void initUserCity();
	
	/**
	 * 使用证件类型、证件号、角色查询用户
	 * 获取用户ID是否使用当前需要修改的账号
	 * @param userProfile
	 * @return 可以修改 true；不可修改false
	 */
	public boolean verificationIdentification(UserProfile userProfile);
	public boolean verificationPreIdentification(UserProfile userProfile);


	/**
	 * 修改用户账号信息
	 * @param userProfile
	 * @param user
	 * @return
	 * @throws EmptyParamExcption
	 */
	public boolean modifyUserProfile(UserProfile userProfile, User user) throws EmptyParamExcption, RejectRequestExcption;
	/**
	 * <p>Title:mergeToBPatientUserInfo</p>
	 * <p>Description:合并患者的用户信息</p>
	 * @author YYCHEN
	 * @date 2016年5月16日 下午3:02:23
	 * @param user
	 * @param tobUser
	 */
	public void mergeToBPatientUserInfo(User user, User tobUser);
	
	/**
	 * 用户退出登录
	 * @author lichenghao
	 * @title :loginout
	 * @Description:TODO
	 * @return void
	 * @date 2016年5月18日 上午9:43:17
	 */
	public void loginout(UserLoginOutReq req);
	
	/**
	 * <p>Title:registerUser</p>
	 * <p>Description:新建用户</p>
	 * @author YYCHEN
	 * @date 2016年6月16日 下午4:14:34
	 * @param userRegisterReq
	 * @return
	 */
	public User registerUser(UserRegisterReq userRegisterReq);
	
	//抵用券
	public void initUserCoupon(Long userId);
	/**
	* @author fanpanwei
	* @date 2017年4月21日
	* @param 
	* @description
	* @return
	 */
	public void addOperationHistory(OperationHistory operationHistory);
	public List<HashMap<String,Object>> getOperationHistory(OperationHistory operationHistory);
}
