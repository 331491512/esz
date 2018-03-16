package com.westangel.commonservice.authorization.service;

import java.util.List;

import com.westangel.common.bean.authorization.MetaRole;

public interface AuthorizationService {

	/**
	 * <p>Title:getMetaInfoRoleList</p>
	 * <p>Description:获取角色数据列表</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午5:22:37
	 * @param userId
	 * @return
	 */
	List<MetaRole> getMetaInfoRoleList(Long userId);
}
