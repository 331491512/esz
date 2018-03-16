package com.esuizhen.cloudservice.sync.dao.incre;

import com.westangel.common.bean.User;

/**
 * 增量数据库用户数据访问接口
 * @author YYCHEN
 *
 */
public interface IncreUserDao {
	/**
	 * 新增用户信息
	 * @param user
	 * @return
	 */
	public long insert(User user);
	
	public int delete(Long userId);
}
