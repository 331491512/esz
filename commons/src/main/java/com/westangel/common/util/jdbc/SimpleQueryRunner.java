package com.westangel.common.util.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.Statement;

/**
 * 增加一些dbutil中没有封装方法
 * 
 * 
 */
public class SimpleQueryRunner extends QueryRunner {

	/**
	 * 只使用单一的有datasource构造器
	 * 
	 * @param dataSource
	 */
	public SimpleQueryRunner(DataSource dataSource) {
		super(dataSource);
	}

	/**
	 * Execute a batch of SQL INSERT, UPDATE, or DELETE queries.
	 * 
	 * @param conn
	 *            The Connection to use to run the query. The caller is
	 *            responsible for closing this Connection.
	 * @param sql
	 *            The SQL to execute.
	 * @param params
	 *            An array of query replacement parameters. Each row in this
	 *            array is one set of batch replacement values.
	 * @return The number of rows updated per statement.
	 * @throws SQLException
	 *             if a database access error occurs
	 * @since DbUtils 1.1
	 */
	public int[] batch(Connection conn, String sql, Collection<Object[]> params)
			throws SQLException {

		PreparedStatement stmt = null;

		int[] rows = null;
		try {
			stmt = this.prepareStatement(conn, sql);

			for (Object[] param : params) {
				this.fillStatement(stmt, param);
				stmt.addBatch();
			}

			rows = stmt.executeBatch();

		} catch (SQLException e) {
			this.rethrow(e, sql, params.toArray());
		} finally {
			close(stmt);
		}

		return rows;
	}

	/**
	 * Execute a batch of SQL INSERT, UPDATE, or DELETE queries. The
	 * <code>Connection</code> is retrieved from the <code>DataSource</code> set
	 * in the constructor. This <code>Connection</code> must be in auto-commit
	 * mode or the update will not be saved.
	 * 
	 * @param sql
	 *            The SQL to execute.
	 * @param params
	 *            An list of query replacement parameters. Each row in this
	 *            array is one set of batch replacement values.
	 * @return The number of rows updated per statement.
	 * @throws SQLException
	 *             if a database access error occurs
	 * @since DbUtils 1.1
	 */
	public int[] batch(String sql, Collection<Object[]> params)
			throws SQLException {
		Connection conn = this.prepareConnection();

		try {
			return this.batch(conn, sql, params);
		} finally {
			close(conn);
		}
	}

	/**
	 * 插入并返回自增主键的方法
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Integer insertWithKey(Connection conn, String sql, Object... params)
			throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = this.prepareKeyStatement(conn, sql);
			this.fillStatement(stmt, params);
			stmt.executeUpdate();
			ResultSet rsKey = stmt.getGeneratedKeys();
			int k = 0;
			if (rsKey.next()) {
				k = rsKey.getInt(1);
			}
			return k;

		} catch (SQLException e) {
			this.rethrow(e, sql, params);

		} finally {
			close(stmt);
		}
		return null;
	}

	/**
	 * 插入并返回自增主键的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Integer insertWithKey(String sql, Object... params)
			throws SQLException {
		Connection conn = this.prepareConnection();

		try {
			return this.insertWithKey(conn, sql, params);
		} finally {
			close(conn);
		}
	}

	/**
	 * 插入并返回自增主键的方法 批处理方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKey(String sql, List<Object[]> params)
			throws SQLException {
		Connection conn = this.prepareConnection();

		try {
			return this.insertWithKey(conn, sql, params);
		} finally {
			close(conn);
		}
	}

	
	/**
	 * 插入并返回自增主键的方法 批处理方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKey(String sql, Filler filler)
			throws SQLException {
		Connection conn = this.prepareConnection();

		try {
			return this.insertWithKey(conn, sql, filler);
		} finally {
			close(conn);
		}
	}
	
	
	/**
	 * 插入并返回自增主键的方法 批处理方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKey(Connection conn, String sql,
			Filler filler) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = this.prepareKeyStatement(conn, sql);
			filler.bind(stmt);

			stmt.executeBatch();
			ResultSet rsKey = stmt.getGeneratedKeys();
			List<Integer> keys=new ArrayList<Integer>();
			while (rsKey.next()) {
				int k = rsKey.getInt(1);
				keys.add(k);
			}
			return keys;

		} catch (SQLException e) {
			this.rethrow(e, sql);

		} finally {
			close(stmt);
		}
		return null;
	}
	
	/**
	 * 插入并返回自增主键的方法 批处理方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKey(Connection conn, String sql,
			List<Object[]> params) throws SQLException {

		PreparedStatement stmt = null;

		try {
			stmt = this.prepareKeyStatement(conn, sql);
			for (Object[] param : params) {
				this.fillStatement(stmt, param);
				stmt.addBatch();
			}

			stmt.executeBatch();
			ResultSet rsKey = stmt.getGeneratedKeys();
			List<Integer> keys=new ArrayList<Integer>();
			while (rsKey.next()) {
				int k = rsKey.getInt(1);
				keys.add(k);
			}
			return keys;

		} catch (SQLException e) {
			this.rethrow(e, sql, params);

		} finally {
			close(stmt);
		}
		return null;
	}

	/**
	 * 插入并返回自增主键的方法 批处理方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public int[] batch( String sql,
			Filler filler) throws SQLException {
		Connection conn = this.prepareConnection();
		PreparedStatement stmt = null;
		int[] rows = null;
		try {
			stmt = this.prepareStatement(conn, sql);
			filler.bind(stmt);

			rows=stmt.executeBatch();
			

		} catch (SQLException e) {
			this.rethrow(e, sql);

		} finally {
			close(stmt);
		}
		return rows;
	}
	
	/**
	 * 有返回主键值的statement
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	protected PreparedStatement prepareKeyStatement(Connection conn, String sql)
			throws SQLException {

		return conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
	}
}
