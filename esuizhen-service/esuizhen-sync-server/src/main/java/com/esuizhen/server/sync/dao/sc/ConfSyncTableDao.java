package com.esuizhen.server.sync.dao.sc;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.bean.ConfSyncTableInfo;

/**
 * Created by Nidan on 2017年03月20 下午 17:58
 */
public interface ConfSyncTableDao {

    /**
     * 根据tableCode获取表配置信息
     * @param tableCode
     * @return
     */
    public ConfSyncTableInfo getConfSyncTableInfo(String tableCode);

    /**
     * 为指定表添加数据
     * @param tableName
     * @param columnNames
     * @param columnValues
     */
    public void insertData(@Param("tableName") String tableName, @Param("columnNames") String columnNames,
                           @Param("columnValues") String columnValues);




}
