package com.westangel.commonservice.authorization.service;

import java.util.List;

import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.common.excption.InsufficientParameterExcption;

public interface MetaResourceService {

	/**
	 * <p>Title:getMetaInfoResourceSubList</p>
	 * <p>Description:子资源列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午6:53:15
	 * @param userId
	 * @param resourceId
	 * @return
	 */
	List<MetaResource> getMetaInfoResourceSubList(Long userId, Integer resourceId);

	/**
	 * <p>Title:getMetaInfoResourceMenuList</p>
	 * <p>Description:资源菜单列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午7:10:55
	 * @param userId
	 * @return
	 */
	List<MetaResource> getResourceMenuList(Long userId);

	/**
	 * <p>Title:getSubResources</p>
	 * <p>Description:获取所有子资源列表</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 上午11:53:07
	 * @param metaResource
	 * @param userId
	 * @param resourceType
	 * @return
	 */
	public List<MetaResource> getSubResources(MetaResource metaResource, Long userId, Integer userRole, Integer resourceType);

	/**
	 * <p>Title:getRoleResourceSubList</p>
	 * <p>Description:子资源列表查询。即功能按钮资源权限查询</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午12:14:14
	 * @param userId
	 * @param resourceId
	 * @return
	 * @throws InsufficientParameterExcption 
	 */
	List<MetaResource> getRoleResourceSubList(Long userId, Integer resourceId) throws InsufficientParameterExcption;

	/**
	 * <p>Title:getMetaInfoResourceList</p>
	 * <p>Description:资源列表元数据查询</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午3:16:47
	 * @return
	 */
	List<MetaResource> getMetaInfoResourceList();
}
