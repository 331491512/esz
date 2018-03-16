package com.esuizhen.client.sync.dao.sc;

import java.util.List;

import com.esuizhen.client.sync.model.ConfSyncInfo;
import com.esuizhen.client.sync.model.ConfTableInfo;

public interface ConfSyncDao {
	public ConfSyncInfo getConfSyncInfo();
	
	public  List<ConfTableInfo> getConfTableInfoList();
}
