package com.westangel.commonservice.authorization.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.westangel.common.bean.authorization.MetaRole;

/**
 * <p>Title:MetaRoleDao</p>
 * <p>Description:角色数据访问层接口</p>
 * @author YYCHEN
 * @date 2016年7月5日 下午5:18:02
 */
public interface MetaRoleDao {
	/**
	 * <p>Title:findAll</p>
	 * <p>Description:查找所有的角色数据列表</p>
	 * @author YYCHEN
	 * @date 2016年7月5日 下午5:19:02
	 * @return
	 */
	List<MetaRole> findAll(@Param("userId")Long userId);

	/**
	 * <p>Title:findRoleNameCount</p>
	 * <p>Description:统计角色名称个数</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:41:37
	 * @param roleName
	 * @return
	 */
	int findRoleNameCount(String roleName);

	/**
	 * <p>Title:insert</p>
	 * <p>Description:新增角色</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:43:30
	 * @param metaRole
	 * @return
	 */
	int insert(MetaRole metaRole);

	/**
	 * <p>Title:delete</p>
	 * <p>Description:删除角色</p>
	 * @author YYCHEN
	 * @date 2016年7月10日 下午2:58:51
	 * @param userRole
	 * @return
	 */
	int delete(Integer userRole);
	
	/**
	 * <p>Title:findUserRoleValue</p>
	 * <p>Description:获取当前userRole的取值</p>
	 * @author YYCHEN
	 * @date 2016年8月19日 上午9:54:50
	 * @return
	 */
	int findUserRoleValue();
}
