package com.esuizhen.client.sync.dao.sc;

import org.apache.ibatis.annotations.Param;

public interface DoIncreSyncResultDao {

	void doIncreSyncResultPre(@Param("tableId")int tableId);
	
}
