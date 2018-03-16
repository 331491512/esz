package com.esuizhen.cloudservice.sync.dao.cloud;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.User;

/**
 * 云端数据库用户数据访问层接口
 * @author YYCHEN
 *
 */
public interface CloudUserDao {
	
	public User findByUuid(String uuid);
	
	public List<User> findByMobile(@Param("mobile")String mobile, @Param("role")Integer role);
	
	public long insert(User user);
	
	public int update(User user);
	
	/**
	 * <p>Title:updateCityId</p>
	 * <p>Description:更新设置cityId</p>
	 * @author YYCHEN
	 * @date 2016年6月3日 下午6:58:46
	 * @param user
	 * @return
	 */
	public int updateCityId(User user);

	public User findByIdentification(@Param("idType")Integer idType, @Param("identification")String identification, @Param("role")Integer role, @Param("auditState")Integer auditState);

	public User findByUserId(@Param("userId")Long userId, @Param("role")Integer role);
}
