package com.westangel.common.util.jdbc;

/**
 * 
 * 数据库连接池配制
 *
 */
public class Config {
	private String jdbcUrl;
	private String user;
	private String password;
	private String driverClass;
	private int minPoolSize=1;//连接池中保留的最小连接数
	private int maxPoolSize=5;//连接池中保留的最大连接数
	private int maxIdleTime=600;
	private int acquireIncrement=3;
	private int maxStatements=10;
	private int maxStatementsPerConnection=3;
	private int numHelperThreads=3;
	private int initialPoolSize=3;
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public int getMinPoolSize() {
		return minPoolSize;
	}
	public void setMinPoolSize(int minPoolSize) {
		this.minPoolSize = minPoolSize;
	}
	public int getMaxPoolSize() {
		return maxPoolSize;
	}
	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}
	public int getMaxIdleTime() {
		return maxIdleTime;
	}
	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}
	public int getAcquireIncrement() {
		return acquireIncrement;
	}
	public void setAcquireIncrement(int acquireIncrement) {
		this.acquireIncrement = acquireIncrement;
	}
	public int getMaxStatements() {
		return maxStatements;
	}
	public void setMaxStatements(int maxStatements) {
		this.maxStatements = maxStatements;
	}
	public int getMaxStatementsPerConnection() {
		return maxStatementsPerConnection;
	}
	public void setMaxStatementsPerConnection(int maxStatementsPerConnection) {
		this.maxStatementsPerConnection = maxStatementsPerConnection;
	}
	public int getNumHelperThreads() {
		return numHelperThreads;
	}
	public void setNumHelperThreads(int numHelperThreads) {
		this.numHelperThreads = numHelperThreads;
	}
	public int getInitialPoolSize() {
		return initialPoolSize;
	}
	public void setInitialPoolSize(int initialPoolSize) {
		this.initialPoolSize = initialPoolSize;
	}
	

}
