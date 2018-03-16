package com.westangel.common.util.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.log4j.Logger;
import com.westangel.common.util.jdbc.Filler;
import com.westangel.common.util.jdbc.SimpleQueryRunner;

/**
 * 提供一些基础的访问数据库操作
 * 
 * 
 */
public class DaoBase {
	private final Logger logger = Logger.getLogger(DaoBase.class);
	//protected final NodeLogger logger = NodeLogger.instance();
	protected DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/**
	 * 执行批量sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            二维参数数组
	 * @return 受影响的行数的数组
	 * @throws SQLException
	 */
	protected int[] batch(String sql, Object[][] params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		int[] affectedRows = new int[0];
		try {
			affectedRows = queryRunner.batch(sql, params);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to batch update data:"+e.getMessage());
			throw e;
		}
		return affectedRows;
	}

	/**
	 * 执行批量sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            二维参数数组
	 * @return 受影响的行数的数组
	 * @throws SQLException
	 */
	protected int[] batch(String sql, Filler filler) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		int[] affectedRows = new int[0];
		try {
			affectedRows = queryRunner.batch(sql, filler);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to batch update data:"+e.getMessage());
			throw e;
		}
		return affectedRows;
	}

	/**
	 * 执行批量sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数list
	 * @return 受影响的行数的数组
	 * @throws SQLException
	 */
	protected int[] batch(String sql, List<Object[]> params) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		int[] affectedRows = new int[0];
		try {
			affectedRows = queryRunner.batch(sql, params);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to batch update data: "+e.getMessage());
			throw e;
		}
		return affectedRows;
	}

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 受影响的行数
	 * @throws SQLException
	 */
	public int update(String sql, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		int affectedRows = 0;
		try {
			if (params == null) {
				affectedRows = queryRunner.update(sql);
			} else {
				affectedRows = queryRunner.update(sql, params);
			}
		} catch (SQLException e) {
			logger.error("Error occured while attempting to update data:"+e.getMessage());
			throw e;
		}
		return affectedRows;
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param entityClass
	 *            类名
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 查询结果
	 * @throws SQLException
	 */
	public <T> List<T> findBeans(String sql, Class<T> entityClass, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		List<T> list = new ArrayList<T>();
		try {
			if (params == null || params.length == 0) {
				list = (List<T>) queryRunner.query(sql, new BeanListHandler<T>(entityClass));
			} else {
				list = (List<T>) queryRunner.query(sql, new BeanListHandler<T>(entityClass), params);
			}
		} catch (SQLException e) {
			logger.error("Error occured while attempting to query data: "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	/**
	 * 查询所有某一列的值
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 查询结果
	 * @throws SQLException
	 */
	public <T> List<T> findColumes(String sql, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		List<T> columns = new ArrayList<T>();
		ResultSetHandler<List<T>> handler = new ResultSetHandler<List<T>>() {
			@Override
			public List<T> handle(ResultSet rs) throws SQLException {
				List<T> lists = new ArrayList<T>();
				while (rs.next()) {
					@SuppressWarnings("unchecked")
					T t = (T) rs.getObject(1);
					lists.add(t);
				}
				return lists;
			}

		};
		try {
			if (params == null) {
				columns = queryRunner.query(sql, handler);
			} else {
				columns = queryRunner.query(sql, handler, params);
			}
			return columns;
		} catch (SQLException e) {
			logger.error("Error occured while attempting to findColume: "+e.getMessage());
			throw e;
		}
	}

	/**
	 * 查询所有某一列的值
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return 查询结果
	 * @throws SQLException
	 */
	public <T> List<T> findColumes(String sql, final Class<T> clazz, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		List<T> columns = new ArrayList<T>();
		ResultSetHandler<List<T>> handler = new ResultSetHandler<List<T>>() {
			@SuppressWarnings("unchecked")
			@Override
			public List<T> handle(ResultSet rs) throws SQLException {
				List<T> lists = new ArrayList<T>();
				while (rs.next()) {
					T t = null;
					if (clazz.equals(Integer.class)) {
						t = (T) new Integer(rs.getInt(1));
					} else {
						t = (T) rs.getObject(1);
					}

					lists.add(t);
				}
				return lists;
			}

		};
		try {
			if (params == null) {
				columns = queryRunner.query(sql, handler);
			} else {
				columns = queryRunner.query(sql, handler, params);
			}
			return columns;
		} catch (SQLException e) {
			logger.error("Error occured while attempting to findColume: "+e.getMessage());
			throw e;
		}
	}

	/**
	 * 查询某一列的第一个值
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return
	 * @return 查询结果
	 * @throws SQLException
	 */
	public <T> T findColume(String sql, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		ResultSetHandler<T> handler = new ResultSetHandler<T>() {
			@Override
			public T handle(ResultSet rs) throws SQLException {
				if (rs.next()) {
					@SuppressWarnings("unchecked")
					T t = (T) rs.getObject(1);
					return t;
				}
				return null;
			}

		};
		try {
			if (params == null) {
				return queryRunner.query(sql, handler);
			} else {
				return queryRunner.query(sql, handler, params);
			}
		} catch (SQLException e) {
			logger.error("Error occured while attempting to findColume: "+e.getMessage());
			throw e;
		}
	}

	/**
	 * 查询某一列的第一个值
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数数组
	 * @return
	 * @return 查询结果
	 * @throws SQLException
	 */
	public <T> T findColume(String sql, final Class<T> clazz, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		ResultSetHandler<T> handler = new ResultSetHandler<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public T handle(ResultSet rs) throws SQLException {
				if (rs.next()) {
					T t = null;
					if (clazz.equals(Integer.class)) {
						t = (T) new Integer(rs.getInt(1));
					} else {
						t = (T) rs.getObject(1);
					}
					return t;
				}
				return null;
			}

		};
		try {
			if (params == null) {
				return queryRunner.query(sql, handler);
			} else {
				return queryRunner.query(sql, handler, params);
			}
		} catch (SQLException e) {
			logger.error("Error occured while attempting to findColume: "+e.getMessage());
			throw e;
		}
	}

	/**
	 * 根据条件获取bean
	 * 
	 * @param <T>
	 * @param sql
	 * @param handler
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public <T> T findBean(String sql, ResultSetHandler<T> handler, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		T t;
		try {
			t = queryRunner.query(sql, handler, params);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to findBean: "+e.getMessage());
			throw e;
		}

		return t;
	}

	/**
	 * 执行查询，将每行的结果保存到Bean中，然后将所有Bean保存到List中
	 * 
	 * @param <T>
	 * @param sql
	 * @param handler
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public <T> List<T> findBeans(String sql, ResultSetHandler<List<T>> handler, Object... params) throws SQLException {
		QueryRunner queryRunner = getInstance();
		List<T> list = new ArrayList<T>();
		try {
			if (params == null) {
				list = queryRunner.query(sql, handler);
			} else {
				list = queryRunner.query(sql, handler, params);
			}
		} catch (SQLException e) {
			logger.error("Error occured while attempting to query data list: "+e.getMessage());
			e.printStackTrace();
			throw e;
		}
		return list;
	}

	/**
	 * 插入并返回自增主键的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Integer insertWithKey(String sql, Object... params) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		try {
			return queryRunner.insertWithKey(sql, params);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to insertwithkey:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * 插入并返回自增主键的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKeys(String sql, Filler filler) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		try {
			return queryRunner.insertWithKey(sql, filler);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to insertwithkey: "+e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * 插入并返回自增主键的方法
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Integer> insertWithKey(String sql, List<Object[]> params) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		try {
			return queryRunner.insertWithKey(sql, params);
		} catch (SQLException e) {
			logger.error("Error occured while attempting to insertwithkey batch:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * 在mysql中模拟序列，拿到一个序列值
	 * 
	 * @param sequenceName
	 *            所模拟序列用到的表的表名
	 * @return
	 * @throws SQLException
	 */
	public Integer getSequence(String sequenceName) throws SQLException {
		SimpleQueryRunner queryRunner = getInstance();
		try {
			String sql = "UPDATE " + sequenceName + " SET id=LAST_INSERT_ID(id+1)";
			Integer id = queryRunner.insertWithKey(sql);
			return id;
		} catch (SQLException e) {
			logger.error("Error occured while obtain sequence:"+e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

	/**
	 * 获取queryrunner
	 * 
	 * @return
	 */
	public SimpleQueryRunner getInstance() {
		return new SimpleQueryRunner(dataSource);
	}
}
