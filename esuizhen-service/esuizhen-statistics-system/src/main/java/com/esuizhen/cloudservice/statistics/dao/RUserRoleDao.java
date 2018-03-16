package com.esuizhen.cloudservice.statistics.dao;

import org.apache.ibatis.annotations.Param;

/**
 * <p>Title:RUserRoleDao</p>
 * <p>Description:用户角色关系数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年9月28日 上午10:56:54
 */
public interface RUserRoleDao {

	/**
	 * 查询指定的用户和角色关系是否存在
	 * @param doctorId
	 * @param userRole
	 * @return
	 */
	int existUserRoleRelationship(@Param("doctorId")Long doctorId, @Param("userRole")Integer userRole);
}
