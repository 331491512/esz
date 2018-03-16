package com.esuizhen.server.sync.dao.temp;

import com.esuizhen.server.sync.model.temp.SyncUser;

/**
 * author:lhy
 * descp:user dao 
 * date:2017.03.17
 */

public interface TempUserDao {

	void insert(SyncUser user);
	
	SyncUser queryUser(Object obj);
}
