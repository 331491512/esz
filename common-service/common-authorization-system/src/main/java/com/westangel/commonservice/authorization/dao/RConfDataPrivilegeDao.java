package com.westangel.commonservice.authorization.dao;

import com.westangel.common.bean.user.RConfDataPrivilege;

public interface RConfDataPrivilegeDao {
	/**
	 * 通过操作员获取数据权限
	 * @param operator
	 * @return
	 */
	RConfDataPrivilege findByOperator(Long operator);
}
