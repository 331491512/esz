package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.User;
import com.westangel.common.bean.UserProfile;
import com.westangel.commonservice.authorization.bean.TUserDoctorInfo;

/**
 * <p>Title:UserDao</p>
 * <p>Description:用户基本信息数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 上午9:50:17
 */
public interface UserDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增用户基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:16:45
	 * @param user
	 * @return
	 */
	int insert(User user);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:更新用户信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午5:00:49
	 * @param user
	 * @return
	 */
	int update(User user);
	
	/**
	 * <p>Title:findByMobile</p>
	 * <p>Description:通过手机号查找用户信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 上午11:40:03
	 * @param mobile
	 * @param role
	 * @return
	 */
	User findByMobile(@Param("mobile")String mobile, @Param("role")Integer role);
	
	/**
	 * <p>Title:findByUserName</p>
	 * <p>Description:通过账号查找用户信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午2:25:33
	 * @param userName
	 * @param role
	 * @return
	 */
	User findByUserName(@Param("userName")String userName, @Param("role")Integer role);
	
	/**
	 * <p>Title:findByUserId</p>
	 * <p>Description:通过用户ID获取用户基本信息</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午4:57:36
	 * @param userId
	 * @return
	 */
	User findByUserId(Long userId);
	
	/**
	 * <p>Title:findUserProfileByUserName</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午6:41:22
	 * @param userName
	 * @param role
	 * @return
	 */
	UserProfile findUserProfileByUserName(@Param("userName")String userName, @Param("role")Integer role);
	
	/**
	 * <p>Title:findUserProfileByUserId</p>
	 * <p>Description:根据userId获取用户信息</p>
	 * @author YYCHEN
	 * @date 2016年8月4日 下午3:12:21
	 * @param userId
	 * @return
	 */
	UserProfile findUserProfileByUserId(@Param("userId")Long userId);

	/**
	 * <p>Title:searchUserProfiles</p>
	 * <p>Description:搜索用户基本信息列表</p>
	 * @author YYCHEN
	 * @date 2016年7月6日 下午7:08:46
	 * @param userDoctorInfo
	 * @return
	 */
	List<UserProfile> searchUserProfiles(TUserDoctorInfo userDoctorInfo);

	/**
	 * <p>Title:findHasContactInformationManager</p>
	 * <p>Description:查询一个有电话联系方式的管理员</p>
	 * @author YYCHEN
	 * @date 2016年8月29日 上午11:07:02
	 * @return
	 */
	UserProfile findHasContactInformationManager();

	/**
	 * <p>Title:activationOrCancellation</p>
	 * <p>Description:注销用户</p>
	 * @author YYCHEN
	 * @date 2016年9月2日 下午8:34:38
	 * @param userProfile
	 * @return
	 */
	int activationOrCancellation(UserProfile userProfile);
}
