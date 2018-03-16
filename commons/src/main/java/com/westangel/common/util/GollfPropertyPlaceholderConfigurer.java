package com.westangel.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @ClassName: GollfPropertyPlaceholderConfigurer
 * @Description: 自定义熟悉加载器
 * @author wang_hw
 * @date 2016年3月23日 下午3:47:44
 */
public class GollfPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{
	public void setGollfPropFiles(Set<String> gollfPropFiles)
	{
		String deployPath = getDeployPath();
		Properties properties = new Properties();
		for (String gollfPropFile : gollfPropFiles) 
		{
			try 
			{
				Properties prop = new Properties();
				if(gollfPropFile.contains("common/url.properties") || gollfPropFile.contains("db/jdbc.properties")||gollfPropFile.contains("config/trade.properties"))
				{
					gollfPropFile = StringUtils.isEmpty(deployPath) ? gollfPropFile : gollfPropFile.replace(".properties", "-" +deployPath + ".properties") ;
				}
				
				if(gollfPropFile.contains("classpath:"))
				{
					LogUtil.log.info("加载"+gollfPropFile.replace("classpath:", ""));
					InputStream is = this.getClass().getClassLoader().getResourceAsStream(gollfPropFile.replace("classpath:", ""));
					properties.load(is);
				}else
				{
					LogUtil.log.info("加载"+gollfPropFile);
					InputStream is = new FileInputStream(gollfPropFile);
					properties.load(is);
				}
				
				properties.putAll(prop);
			} catch (Exception e) {
				LogUtil.logError.error(e.getMessage());
			}
		}
		transJdbcProperties(properties);
		//配置统一的加载文件
		List<String> fileList = new ArrayList<String>();
		fileList.add("api_url.properties");
		fileList.add("dubbo.properties");
		for(String file : fileList){
			loadingCommonProperties(properties, file);
		}
		setProperties(properties);
	}
	
	public String getDeployPath()
	{
		String deployPath = null ;
		try
		{
			Properties properties = new Properties();
			properties.load(new FileInputStream(System.getProperty("catalina.base")+"/conf/customer.properties"));
			deployPath = properties.getProperty("DEPLOY_PATH");
			LogUtil.log.info("DEPLOY_PATH="+deployPath);
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
		return deployPath;
	}
	
	//统一加载jdbc
	public void transJdbcProperties(Properties properties){
		try
		{
			Properties pro = new Properties();
			pro.load(new FileInputStream(System.getProperty("catalina.base")+"/conf/jdbc.properties"));
			String jdbcUrl = properties.getProperty("jdbc.url");
			pro.put("jdbc.url", pro.get("jdbc.url")+getDataBase(jdbcUrl));
			LogUtil.log.info("trancat after:jdbc.url="+pro.get("jdbc.url"));
			properties.putAll(pro);
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
	}
	//加载公共配置
	public void loadingCommonProperties(Properties properties,String file){
		try
		{
			Properties pro = new Properties();
			pro.load(new FileInputStream(System.getProperty("catalina.base")+"/conf/"+file));
			properties.putAll(pro);
		}catch(Exception ex)
		{
			LogUtil.logError.error("loading "+file+" error:"+ex.getMessage());
		}
	}
	
	public String getDataBase(String url){
		return url.substring(url.indexOf("/",15));
	}
}
