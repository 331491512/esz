package com.esuizhen.cloudservice.followup.util;

import java.text.SimpleDateFormat;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import com.westangel.common.util.LogUtil;

/**
 * @ClassName: MyJsonUtil
 * @Description: json转换封装
 * @author raox
 * @date 2016年8月20日 上午10:32:47
 */
public class MyJsonUtil {
	public static <T> T toObject(String json, Class<T> clazz) {
		T t = null;
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			DeserializationConfig cfg = objectMapper.getDeserializationConfig();
			cfg.withDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
			objectMapper = objectMapper.setDeserializationConfig(cfg);
			t = objectMapper.readValue(json, clazz);
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.log.error("JSON转换错误！" + e.getMessage());
		}

		return t;

	}
}
