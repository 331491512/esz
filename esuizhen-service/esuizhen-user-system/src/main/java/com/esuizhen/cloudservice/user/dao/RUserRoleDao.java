package com.esuizhen.cloudservice.user.dao;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title:RUserRoleDao</p>
 * <p>Description:用户角色关系数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年9月28日 上午10:56:54
 */
public interface RUserRoleDao {
	/**
	 * <p>Title:addUserRoleRelationship</p>
	 * <p>Description:建立用户角色关系</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 上午10:58:31
	 * @param userId
	 * @param userRole
	 * @return
	 */
	int addUserRoleRelationship(@Param("userId")Long userId, @Param("userRole")Integer userRole);
	
	/**
	 * <p>Title:deleteByUserId</p>
	 * <p>Description:通过</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 上午10:59:00
	 * @param userId
	 * @return
	 */
	int deleteByUserId(@Param("userId")Long userId);

	/**
	 * <p>Title:findByUserId</p>
	 * <p>Description:查询指定的用户和角色关系是否存在</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 上午11:27:54
	 * @param userId
	 * @param userRole
	 * @return
	 */
	int existUserRoleRelationship(@Param("userId")Long userId, @Param("userRole")Integer userRole);
}
