package com.westangel.common.util;

import java.util.Properties;

import com.westangel.common.util.LogUtil;

/**
 * 配置文件工具类
 * @author wang_hw
 *
 */
public class ConfigUtil
{
	
	/**
	 * 属性文件类
	 */
	private static Properties properties = null ;
	
	public static void load(String path)
	{//加载配置信息
		try{
			properties = new Properties();
			properties.load(ConfigUtil.class.getClassLoader().getResourceAsStream(path==null?"db/jdbc.properties":path));
		}catch(Exception ex)
		{
			LogUtil.logError.error(ex.getMessage());
		}
	}
	
	public static String get(String key)
	{
		if(properties==null)
		{
			load(null);
		}
		return properties.getProperty(key);
	}
	
	public void setPath(String path)
	{
		load(path);
	}
}
