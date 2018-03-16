package com.esuizhen.server.sync.dao.sc;

import org.apache.ibatis.annotations.Param;

import com.esuizhen.server.sync.model.sc.TSyncResultServer;

/**
 * Created by Nidan on 2017年03月22 下午 15:05
 */
public interface SyncResultDao {

    /**
     * 指定结果表添加数据
     * @param srs
     * @param tableName
     * @param idColumnName
     * @param id
     */
    void insert(@Param("srs") TSyncResultServer srs,
                @Param("tableName") String tableName,@Param("idColumnName") String idColumnName,@Param("id") Object id);

    /**
     * 更新指定结果表的数据
     * @param srs
     * @param tableName
     * @param idColumnName
     * @param id
     */
    void update(@Param("srs") TSyncResultServer srs,
                @Param("tableName") String tableName,@Param("idColumnName") String idColumnName,@Param("id") Object id);

    /**
     * 获取指定结果表的数据
     * @param id
     * @param tableName
     * @param inhospitalIdColumnName
     * @return
     */
    TSyncResultServer findByKey(@Param("id") Object id,
                                @Param("tableName") String tableName,@Param("inhospitalIdColumnName") String inhospitalIdColumnName);
}
