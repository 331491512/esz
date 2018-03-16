package com.westangel.commonservice.authorization.service;

import java.util.List;

import com.westangel.common.bean.authorization.RConfFuncPrivilege;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface RConfFuncPrivilegeService {

	/**
	 * <p>Title:saveConfFuncPrivilege</p>
	 * <p>Description:</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午7:38:22
	 * @param commonInfo
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	boolean saveRoleResource(List<RConfFuncPrivilege> confFuncPrivileges) throws InsufficientParameterExcption;

}
