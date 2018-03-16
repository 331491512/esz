package com.esuizhen.cloudservice.user.service;


public interface UserRoleService {
	/**
	 * <p>Title:addDefaultUserRole</p>
	 * <p>Description:给用户添加默认用户角色</p>
	 * @author YYCHEN
	 * @date 2016年9月28日 上午11:23:47
	 * @param userId
	 * @return
	 */
	public boolean addDefaultUserRole(Long userId);
	
	/**
	 * 查询指定的用户和角色关系是否存在
	 * @param userId
	 * @param userRole
	 * @return
	 */
	int existUserRoleRelationship(Long doctorId, Integer userRole);
}
