package com.westangel.commonservice.authorization.dao;

import com.westangel.commonservice.authorization.model.UUserPing;

/**
 * <p>Title: UUserPingDao</p>
 * <p>Description: </p>
 * @author YYCHEN
 * @date 2016年4月20日 下午5:34:57
 */
public interface UUserPingDao {
	/**
	 * <p>Title: insert</p>
	 * <p>Description: 保存Ping信息</p>
	 * @date 2016年4月20日 下午5:35:02
	 * @param userPing
	 * @return
	 */
	public int insert(UUserPing userPing);
}
