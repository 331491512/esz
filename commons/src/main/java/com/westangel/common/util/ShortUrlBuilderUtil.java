package com.westangel.common.util;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

/**
 * @className ShortUrlBuilderUtil
 * @Description:
 * @author yuanwenming
 * @date 2017年8月15日
 */
public class ShortUrlBuilderUtil {
	/**
	 * 生成短链接
	 */
	public static List<Map> buiderShortUrl(String url_long) {
		String source = "3271760578";
		String openUrl = "http://api.t.sina.com.cn/short_url/shorten.json";
		String url = openUrl + "?source=" + source + "&url_long=" + url_long;
		LogUtil.log.debug("http get request url==>" + url);
		String ret = HttpUtil.get(url);
		LogUtil.log.debug("send http get successed,return msg==>" + ret);
		List<Map> resultList = JSONArray.parseArray(ret, Map.class);
		return resultList;
	}
	
	/**
	 * 生成短链接-utf8
	 * @throws Exception 
	 */
	public static List<Map> buiderShortUrlUTF(String url_long) throws Exception {
		String longUrl = URLEncoder.encode(url_long, "UTF-8");
		return buiderShortUrl(longUrl);
	}
}
