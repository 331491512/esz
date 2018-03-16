package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.authorization.MetaResource;
import com.westangel.commonservice.authorization.bean.ConfGlobal;

/**
 * <p>Title:MetaResourceDao</p>
 * <p>Description:资源元数据数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午6:28:40
 */
public interface MetaResourceDao {
	/**
	 * <p>Title:findSubResources</p>
	 * <p>Description:查询子资源列表</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午6:40:00
	 * @param userId
	 * @param resourceId
	 * @param resourceType
	 * @return
	 */
	List<MetaResource> findSubResources(@Param("userId")Long userId, @Param("userRole")Integer userRole, @Param("resourceId")Integer resourceId, @Param("resourceType")Integer resourceType);

	/**
	 * <p>Title:findMetaInfoResourceMenuList</p>
	 * <p>Description:资源菜单列表查询</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午7:22:29
	 * @param userId
	 * @param userRole
	 * @param resourceType
	 * @return
	 */
	List<MetaResource> findMetaInfoResourceMenuList(@Param("userId")Long userId, @Param("userRole")Integer userRole, @Param("resourceType")Integer resourceType);
	
	/**
	 * 查询随访公共配置
	 * @return
	 */
	public ConfGlobal queryConfGlobal();
	
}
