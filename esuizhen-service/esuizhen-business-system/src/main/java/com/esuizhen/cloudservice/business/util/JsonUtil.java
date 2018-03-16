package com.esuizhen.cloudservice.business.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.westangel.common.util.LogUtil;

/**
 * 
* @ClassName: JsonUtil 
* @Description: Json工具类
* @author wang_hw
* @date 2015年12月3日 下午1:59:31
 */
public class JsonUtil
{
	/**
	 * @author wang_hw
	 * @title :toJson
	 * @Description:将对象转换为Json
	 * @return String
	 * @date 2015年12月3日 下午2:00:23
	 */
	public static String toJson(Object obj)
	{
		String json = null;
		
		try 
		{
			ObjectMapper objectMapper = new ObjectMapper();
			json = objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
		
		return json;
	}
	
	/**
	 * 
	 * @author wang_hw
	 * @title :beautiful
	 * @Description:Json美化
	 * @return String
	 * @date 2015年12月3日 下午7:35:51
	 */
	public static String beautiful(String json)
	{
		try 
		{
			ObjectMapper objectMapper = new ObjectMapper();
			Object obj = objectMapper.readValue(json, Object.class);	
			json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
		
		return json;
	}
	
	
}
