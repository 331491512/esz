package com.esuizhen.cloudservice.followup.common;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.esuizhen.cloudservice.followup.dao.user.DoctorDao;
import com.esuizhen.cloudservice.followup.util.BeanUtils;
import com.esuizhen.cloudservice.followup.util.UtilValidate;
import com.westangel.common.bean.search.ConfGlobal;
import com.westangel.common.bean.user.RConfDataPrivilege;
import com.westangel.common.dao.search.ConfGlobalDao;

@Component
public class DataAccessFilter {

	@Autowired
	private DoctorDao doctorDao;
	
	@Autowired
	private ConfGlobalDao confGlobalDao;
	/**
	 * 按登陆角色设置是否返回操作员ID
	 * @param userRole
	 * @param operator
	 * @return
	 */
	public static Long getOperator(Integer userRole, Long operator) {
		if (UtilValidate.isNotEmpty(userRole) && userRole != 1 && userRole != 3) {
			operator = null;
		}
		return operator;

	}
	
	/**
	 * 获取数据访问权限
	 */
	public Map<String,Object> decorteDataAccessParams(Object bean,Long operator){
		// 数据筛选
		Map<String,Object> paramsMap=BeanUtils.toMap(bean);
		paramsMap.put("operator", operator);
		RConfDataPrivilege rConfDataPrivilege = doctorDao.getDataPrivilegeByDoctorId(operator);
		if(rConfDataPrivilege != null) {
			paramsMap.put("dataId", rConfDataPrivilege.getDataId());
		}else {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			paramsMap.put("deployLocation", conf.getDeployLocation());
		}
		return paramsMap;
	}
	
	/**
	 * 获取数据访问权限
	 */
	public Map<String,Object> decorteDataAccessParams(Map<String,Object> paramsMap,Long operator){
		// 数据筛选
		RConfDataPrivilege rConfDataPrivilege = doctorDao.getDataPrivilegeByDoctorId(operator);
		if(rConfDataPrivilege != null) {
			paramsMap.put("dataId", rConfDataPrivilege.getDataId());
		}else {
			ConfGlobal conf = confGlobalDao.queryConfGlobal();
			paramsMap.put("deployLocation", conf.getDeployLocation());
		}
		return paramsMap;
	}
	
}
