package com.esuizhen.server.sync.dao.server;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.model.server.User;

/**
 * Created by Nidan on 2017年03月21 上午 11:45
 */
public interface UserDao {
	//查询
	public User queryUser(Object obj);
	//插入
	public int insertUser(Object obj);
	//修改
	public int update(Object obj);
	//删除
	public void delete(@Param("userId")Long userId);
}