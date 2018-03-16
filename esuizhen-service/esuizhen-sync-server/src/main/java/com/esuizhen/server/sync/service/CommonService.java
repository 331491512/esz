package com.esuizhen.server.sync.service;

import java.util.LinkedHashMap;

/**
 * Created by Nidan on 2017年03月20 下午 17:48
 */
public interface CommonService {

    public void insert(LinkedHashMap column, String tableName,String dbName);

    public void update(LinkedHashMap column, String tableName,String dbName);
}
