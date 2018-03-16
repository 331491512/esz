package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.authorization.RUserRole;

public interface RUserRoleDao {
	/**
	 * <p>Title:insert</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午7:57:47
	 * @param userRole
	 * @return
	 */
	public int insert(RUserRole userRole);
	
	/**
	 * <p>Title:update</p>
	 * <p>Description:更新</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:41:40
	 * @param userRole
	 * @return
	 */
	public int update(RUserRole userRole);
	/**
	 * <p>Title:delete</p>
	 * <p>Description:删除</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:43:32
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	/**
	 * <p>Title:findByUserId</p>
	 * <p>Description:通过userId获取账号权限</p>
	 * @author YYCHEN
	 * @date 2016年7月8日 下午8:36:30
	 * @param userId
	 * @return
	 */
	public List<RUserRole> findByUserId(@Param("userId")Long userId);

	int userRoleRelation(@Param("userId")Long userId, @Param("userRole")Integer userRole);
	
	/**
	 * <p>Title:deleteByUserId</p>
	 * <p>Description:通过userId删除用户角色关系</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午1:05:29
	 * @param userId
	 * @param userRole
	 * @return
	 */
	public int deleteByUserId(@Param("userId")Long userId, @Param("userRole")Integer userRole);
}
