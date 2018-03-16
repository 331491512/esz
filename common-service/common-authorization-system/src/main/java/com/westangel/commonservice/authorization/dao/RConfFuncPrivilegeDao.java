package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.authorization.RConfFuncPrivilege;

/**
 * <p>Title:RConfFuncPrivilegeDao</p>
 * <p>Description:角色功能权限数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午6:00:17
 */
public interface RConfFuncPrivilegeDao {
	/**
	 * <p>Title:deleteByUserRole</p>
	 * <p>Description:通过角色ID删除角色功能</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午7:26:09
	 * @param userRole
	 * @return
	 */
	int deleteByUserRole(@Param("userRole")Integer userRole, @Param("resourceType")Integer resourceType);
	
	/**
	 * <p>Title:batchInsert</p>
	 * <p>Description:批量新增角色功能权限</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午7:30:05
	 * @param confFuncPrivileges
	 * @return
	 */
	int batchInsert(@Param("confFuncPrivileges")List<RConfFuncPrivilege> confFuncPrivileges);

	/**
	 * <p>Title:findUserRoleCount</p>
	 * <p>Description:通过userRole统计角色资源关系</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:56:11
	 * @param userRole
	 * @return
	 */
	int findUserRoleCount(Integer userRole);
}
