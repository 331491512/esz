package com.esuizhen.cloudservice.user.dao;

import com.esuizhen.cloudservice.user.model.UUserPing;

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
	
	
	/**
	 * 
	 * @author lichenghao
	 * @title :insertWX
	 * @Description:保存ping信息
	 * @return int
	 * @date 2017年9月14日 下午5:38:55
	 */
	public int insertWX(UUserPing userPing);
}
