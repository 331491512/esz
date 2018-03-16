package com.westangel.common.util.jdbc;

import com.westangel.common.config.BaseConfig;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang.StringUtils;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataSourceFactory extends BaseConfig {
	private static DataSource dataSource;
	private static Config config;

	static {
		try {
			initConfig();
			initDataSource();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("数据源初使化失败，请配制文件和数据库");
		} catch (PropertyVetoException e) {
			e.printStackTrace();
			throw new RuntimeException("数据源初使化失败，可能是数据库驱动类的配制问题！");
		}

	}

	private static void initConfig() throws IOException {
		InputStream input = ClassLoader.getSystemResourceAsStream("jdbc.properties");
		String confFileDir = getConfFileDir();
		if (confFileDir != null) {
			String fileName = confFileDir + "/etc/" + "jdbc.properties";
			input = new FileInputStream(new File(fileName));
		}
		else {
			System.err.println("ERROR! NODE_HOME env is not set!");
			//throw new RuntimeException("获取配置文件目录出错！");
		}
		Properties properties = new Properties();
		properties.load(input);
		config = new Config();
		String jdbcUrl = properties.getProperty("jdbcUrl");
		String driverClass = properties.getProperty("driverClass");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");

		if (StringUtils.isBlank(jdbcUrl) || StringUtils.isBlank(driverClass) || StringUtils.isBlank(user)
				|| StringUtils.isBlank(password)) {
			throw new RuntimeException("配制文件不合法，不能为空的字段为");
		}
		config.setDriverClass(driverClass);
		config.setJdbcUrl(jdbcUrl);
		config.setUser(user);
		config.setPassword(password);
	}

	private static void initDataSource() throws PropertyVetoException {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(config.getDriverClass());
		dataSource.setUrl(config.getJdbcUrl());
		dataSource.setUsername(config.getUser());
		dataSource.setPassword(config.getPassword());

		// TODO 处理其他配制项目
		//初始化连接数
        dataSource.setInitialSize(3);
        //连接池的最大活动个数
        dataSource.setMaxActive(300);
        //没有人用连接的时候，最大闲置的连接数
        dataSource.setMaxIdle(100);
        //没有人用连接的时候，最小闲置的连接数
        dataSource.setMinIdle(10);
        //超时等待时间，一毫秒为单位
        dataSource.setMaxWait(10000);
        //是否自动回收超时连接
        dataSource.setRemoveAbandoned(true);
        //设置被遗弃的连接的超时的时间（以秒数为单位），即当一个连接被遗弃的时间超过设置的时间，则它会自动转换成可利用的连接。默认的超时时间是300秒
        dataSource.setRemoveAbandonedTimeout(60);
        //是否在自动回收超时连接的时候打印连接的超时错误
        dataSource.setLogAbandoned(true);
        //给出一条简单的 sql语句进行验证
        dataSource.setValidationQuery("select 1 from dual");
        //在取出连接时进行有效验证
        dataSource.setTestOnBorrow(true);

		DataSourceFactory.dataSource = dataSource;

	}

	public static DataSource getDataSource() {
		return dataSource;
	}

}
