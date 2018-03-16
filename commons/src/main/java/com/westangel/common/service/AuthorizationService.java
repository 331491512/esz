package com.westangel.common.service;

import com.westangel.common.bean.user.RConfDataPrivilege;

/**
 * <p>Title:AuthorizationService</p>
 * <p>Description:用户权限业务接口</p>
 * @author YYCHEN
 * @date 2016年11月22日 下午6:47:49
 */
public interface AuthorizationService {
	/**
	 * <p>Title:configAuthorization</p>
	 * <p>Description:给用户分配指定的权限</p>
	 * @author YYCHEN
	 * @date 2016年11月22日 下午6:49:21
	 * @param userId
	 * @param userRole
	 * @return
	 */
	public boolean configAuthorization(Long userId, Integer userRole);
	
	/**
	 * <p>Title:removeAuthorization</p>
	 * <p>Description:将用户指定的权限移除</p>
	 * @author YYCHEN
	 * @date 2016年11月24日 上午10:59:11
	 * @param userId
	 * @param userRole
	 * @return
	 */
	public boolean removeAuthorization(Long userId, Integer userRole);
	
	RConfDataPrivilege findDataPrivilegeByDoctor(Long doctorId);
}
