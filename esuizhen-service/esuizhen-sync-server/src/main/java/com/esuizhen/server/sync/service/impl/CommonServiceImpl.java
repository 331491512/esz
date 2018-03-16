package com.esuizhen.server.sync.service.impl;

import com.esuizhen.server.sync.dao.sc.ConfSyncTableDao;
import com.esuizhen.server.sync.service.CommonService;
import com.esuizhen.server.sync.utils.ComUtils;
import com.westangel.common.util.LogUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nidan on 2017年03月20 下午 18:12
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private ConfSyncTableDao confSyncTableDao;

    @Transactional
    @Override
    public void insert(LinkedHashMap column, String tableName, String dbName) {
        LogUtil.log.info("异步向正式库{1}.{2}中添加数据开始",dbName,tableName);
        Map<String,String> columns=ComUtils.getColumns(column);
        String columnNames=columns.get("columnNames");
        String columnValues=columns.get("columnValues");
        if(!StringUtils.isBlank(columnNames)){
            //不为空插入数据
            try {
                confSyncTableDao.insertData(dbName+"."+tableName, columnNames, columnValues);
            } catch (Exception e) {
                LogUtil.logError.error("数据插入异常:"+e.getMessage(),e);
            }
        }

    }

    @Override
    public void update(LinkedHashMap column, String tableName, String dbName) {

    }
}
