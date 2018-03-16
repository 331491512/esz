package com.westangel.commonservice.authorization.service;

import java.util.List;

import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.bean.authorization.MetaRole;
import com.westangel.common.bean.authorization.RUserRole;
import com.westangel.common.excption.InsufficientParameterExcption;
import com.westangel.common.excption.ObjectAlreadyExistExcption;
import com.westangel.common.excption.RejectRequestExcption;

public interface RoleService {

	/**
	 * <p>Title:getRoleResourceList</p>
	 * <p>Description:用户角色资源列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 上午11:25:54
	 * @param userId
	 * @return
	 */
	List<MetaResource> getRoleResourceList(Long userId, Integer userRole);

	/**
	 * <p>Title:getUserRoleList</p>
	 * <p>Description:用户角色列表查询，查询出当前用户所拥有的角色</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午1:02:44
	 * @param userId
	 * @return
	 */
	List<RUserRole> getUserRoleList(Long userId);

	/**
	 * <p>Title:addRole</p>
	 * <p>Description:新增角色</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:37:14
	 * @param metaRole
	 * @return
	 * @throws InsufficientParameterExcption 
	 * @throws ObjectAlreadyExistExcption 
	 */
	boolean addRole(MetaRole metaRole) throws InsufficientParameterExcption, ObjectAlreadyExistExcption;

	/**
	 * <p>Title:deleteRole</p>
	 * <p>Description:删除角色</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:49:36
	 * @param metaResource
	 * @return
	 * @throws RejectRequestExcption 
	 * @throws InsufficientParameterExcption 
	 */
	boolean deleteRole(MetaResource metaResource) throws RejectRequestExcption, InsufficientParameterExcption;

	/**
	 * <p>Title:getMetaInfoRoleList</p>
	 * <p>Description:角色列表元数据查询</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午3:01:53
	 * @param userId
	 * @return
	 */
	List<MetaRole> getMetaInfoRoleList(Long userId);
}
