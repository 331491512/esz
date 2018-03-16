package com.westangel.common.util;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

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
			Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
			json = gson.toJson(obj);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
		
		return json;
	}
	
	public static <T> T toObject(String json , Class<T> clazz)
	{
		Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		T t = gson.fromJson(json, clazz);
		return t;
	}
	
	public static List<Integer> toList(String json )
    {

        Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        List<Integer> list = gson.fromJson(json, new TypeToken<List<Integer>>(){}.getType() );
        return list;
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
			Gson gson3 = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
			JsonParser jp = new JsonParser();
			JsonElement je = jp.parse(json);
			json = gson3.toJson(je);
		} catch (Exception e) {
			LogUtil.logError.error(e.getMessage());
		}
		
		return json;
	}
	
	
}
