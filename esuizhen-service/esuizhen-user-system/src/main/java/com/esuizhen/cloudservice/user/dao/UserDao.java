package com.esuizhen.cloudservice.user.dao;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.cloudservice.user.bean.AutiCancerPatientInfo;
import com.esuizhen.cloudservice.user.bean.UserLoginOutReq;
import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;

public interface UserDao {

	public int deleteByPrimaryKey(Long userId);

	public long insert(User record);

	public User findByUserId(Long userid);

	public int updateByPrimaryKey(User record);
	
	public int updateInfoState(User record);

	public int updatePassword(User record);
	
	/**
	 * <p>Title: setLastLogin</p>
	 * <p>Description: 更新用户最后一次的登录信息</p>
	 * @date 2016年4月21日 上午11:50:59
	 * @param user
	 * @return
	 */
	public int updateLastLogin(User user);
	
	public int existUserNameOrMobile(@Param("username") String username, @Param("role") Integer role);
	
	/**
	* @Title: selectUser 
	* @Description: 根据用户名和角色查询是否注册用户名已经存在
	* @param username 用户名  role 角色编号
	* @return User
	* @return role
	* @throws
	 */
	public User findByUserName(@Param("userName") String userName, @Param("role") Integer role);
	
	public User findByUuid(String uuid);

	public int updateUser(@Param("record") User record);

	public int updateUserWithBind(@Param("record") User user);
	
	public UserProfile findUserProfileByUserId(Long userId);
	
	/**
	 * 
	 * @param accountTypeFlag accountType是否大于0
	 * @param mobile
	 * @param role
	 * @return
	 */
	public User findByMobile(@Param("accountTypeFlag")boolean accountTypeFlag, @Param("mobile") String mobile, @Param("role") Integer role);

	public String findUserTrueName(Long patientUserId);
	
	public String findUserOpenId(@Param("userId")Long userId);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :findOpenIdTotalByUserIdAndOpenId
	 * @Description:获取用户可用openId数
	 * @return Integer
	 * @date 2016年10月12日 下午2:55:11
	 */
	public Integer findOpenIdTotalByUserId(@Param("userId")Long userId);
	
	public Integer findUserProductId(@Param("userId")Long userId);
	
	public List<LinkedHashMap<String,Object>> queryNotHasCityUser();
	
	public Integer queryUserCityId(@Param("cityName")String cityName);
	
	public int modifyUserCity(Object param);
	public int insertUserCity(Object param);
	
	/**
	 * 
	 * @author lichenghao
	 * @title :settingThridCancelTime
	 * @Description:设置第三方登录表数据    flag  1 上线   -2 取关
	 * @return int
	 * @date 2016年10月12日 下午3:16:35
	 */
	public int settingThridCancelTime(@Param("openId")String fromUserName,@Param("userId")Long userId,@Param("flag")Integer flag);
	
	//最后退出登录
	public void updateLastLoginOut(UserLoginOutReq req);
	
	/**
	 * 更新随访患者基本信息
	 * @param user
	 * @return
	 */
	int updateFollowupPatientByPrimaryKey(User user);
	
	public int findByIdentificationCount(@Param("role")Integer role,@Param("idType")Integer idType, @Param("identification")String identification, @Param("auditState") Integer auditState,@Param("userId") Long userId);
	
	/**
	 * 判断用户是否存在
	 * @param paramMap
	 * @return
	 */
	int existsUser(Map<String,Object> paramMap);
	/*******************add by fanpanwei**************************/
	void updateAutiCancerUser(AutiCancerPatientInfo autiCancerPatientInfo);
	int insertAutiCancerUser(AutiCancerPatientInfo autiCancerPatientInfo);
	/********************end by fanpanwei***********************/
	//获取被动患者用户信息
	public User findPatientUserByMobile(@Param("mobile")String mobile);
	public User findUserByUserName(Object obj);
}