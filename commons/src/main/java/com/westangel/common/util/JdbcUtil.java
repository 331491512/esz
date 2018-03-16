package com.westangel.common.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.westangel.common.util.LogUtil;

/**
 * Jdbc工具类
 * 
 * @author Administrator
 * 
 */
public class JdbcUtil
{
	static {
		try {
			Class.forName(ConfigUtil.get("jdbc.driverClassName"));
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
	}

	/**
	 * @author wang_hw
	 * @title :getConection
	 * @Description:获取连接
	 * @return Connection
	 * @date 2016年1月13日 下午4:29:23
	 */
	public static Connection getConection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(ConfigUtil.get("jdbc.url"), ConfigUtil.get("jdbc.username"), ConfigUtil.get("jdbc.password"));

		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.logError.error(e.getMessage());
		}
		return con;
	}

	/**
	 * @author wang_hw
	 * @title :execSql
	 * @Description:执行SQL
	 * @return void
	 * @date 2016年1月13日 下午4:23:55
	 */
	public static boolean execSql(String sql)
	{
		boolean flag = true;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConection();
			pst = conn.prepareStatement(sql);
			pst.execute();
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			flag = false;
		} finally {
			closePst(pst);
			closeConn(conn);
		}
		return flag;
	}

	/**
	 * @author wang_hw
	 * @title :execProcedure
	 * @Description:执行存储过程
	 * @return void
	 * @date 2016年1月13日 下午4:27:10
	 */
	public static boolean execProcedure (String procedure)
	{
		boolean flag = true;
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = getConection();
			pst = conn.prepareCall("{"+procedure+"}");
			LogUtil.log.info("-------perpareCall:{},result:{}","{"+procedure+"}",pst.execute());
		} catch (Exception ex) {
			LogUtil.logError.error(ex.getMessage());
			flag = false;
		} finally {
			closePst(pst);
			closeConn(conn);
		}
		return flag;
	}
	
	/**
	 * @author wang_hw
	 * @title :closeConn
	 * @Description:关闭连接
	 * @return void
	 * @date 2016年1月13日 下午4:23:39
	 */
	public static void closeConn(Connection conn)
	{
		try {
			conn.close();
		} catch (Exception ex) {
		}
	}

	/**
	 * @author wang_hw
	 * @title :closePst
	 * @Description:关闭SQL执行器
	 * @return void
	 * @date 2016年1月13日 下午4:24:10
	 */
	public static void closePst(PreparedStatement pst)
	{
		try {
			pst.close();
		} catch (Exception ex) {
		}
	}

}
