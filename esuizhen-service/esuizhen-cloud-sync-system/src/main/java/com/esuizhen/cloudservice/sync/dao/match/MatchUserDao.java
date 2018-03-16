package com.esuizhen.cloudservice.sync.dao.match;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.User;

/**
 * 匹配数据库用户数据访问接口
 * @author YYCHEN
 *
 */
public interface MatchUserDao {
	
	public long insert(User user);
	
	public int setAffirm(User user);
	
	public int delete(Long userId);
	/**
	 * <p>Title: setNotifyDoctorAgain</p>
	 * <p>Description: 设置医生可再次通知状态</p>
	 * @date 2016年4月14日 上午11:26:33
	 * @return
	 */
	public int setNotifyDoctorAgain();
	/**
	 * <p>Title: setNotifyPatientAgain</p>
	 * <p>Description: 设置患者可再次通知</p>
	 * @date 2016年4月14日 上午11:26:36
	 * @return
	 */
	public int setNotifyPatientAgain();
	
	//更新推送标志
	public int updatePushFlag(@Param("userUuids")List<String> userUuids, @Param("pushFlag") Integer pushFlag, @Param("role") Integer role);

	public User findByUuid(String uuid);
	
	public int updateAccountType(@Param("uuid")String uuid,@Param("accountType")Integer accountType);
}
