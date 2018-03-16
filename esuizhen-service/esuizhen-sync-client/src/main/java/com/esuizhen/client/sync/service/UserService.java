package com.esuizhen.client.sync.service;

import java.util.LinkedHashMap;
import java.util.List;

public interface UserService {
	List<LinkedHashMap> getBatchSyncUser(String userIds);
}
