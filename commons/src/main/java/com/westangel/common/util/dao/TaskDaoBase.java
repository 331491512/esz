package com.westangel.common.util.dao;

import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.log4j.Logger;

import com.westangel.common.util.LoggerFactory;
import com.westangel.common.util.dao.DaoBase;
import com.westangel.common.util.jdbc.DataSourceFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TaskDaoBase extends DaoBase {

	protected final static Logger LOG = LoggerFactory.getLogger(TaskDaoBase.class);
	
	public TaskDaoBase(){
		setDataSource(DataSourceFactory.getDataSource());
	}

    /**
     * 根据UserId判断用户是否存在
     * @param userId
     * @return
     * @throws SQLException
     */
    public boolean checkUserIdIsExist(String userId) throws SQLException {
        try {
            String sqlString = "select userID from accountinfo where userID = ? ";
            Integer count = findBean(sqlString, new ResultSetHandler<Integer>() {
                @Override
                public Integer handle(ResultSet rs) throws SQLException {
                    if(!rs.next()){
                        return -1;
                    }
                    return rs.getRow();
                }
            }, userId);

            return count > 0 ? true : false;
        } catch (SQLException e) {
            LOG.error("查询用户ID是否存在出现错误! "+e.getMessage());
            throw e;
        }
    }
}
