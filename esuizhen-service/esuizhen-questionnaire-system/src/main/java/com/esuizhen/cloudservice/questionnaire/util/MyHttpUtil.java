package com.esuizhen.cloudservice.questionnaire.util;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.HttpUtil;
import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

/**
 * @ClassName: MyHttpUtil
 * @Description: http请求封装
 * @author raox
 * @date 2016年8月20日 上午10:32:18
 */
public class MyHttpUtil {

	public static TMsgResponse<Object> postJson(String url, Map<String, Object> paramMap) {
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");

		String paramJson = JsonUtil.toJson(paramMap);
		LogUtil.log.debug("调用服务地址：" + url + "调用参数：" + paramJson);
		String messageJson = HttpUtil.postString(url, paramJson, "utf-8", headerMap);
		TMsgResponse<Object> tMsgResponse = JsonUtil.toObject(messageJson, TMsgResponse.class);
		LogUtil.log.debug("调用REST服务返回结果：" + tMsgResponse.getRespCode());
		return tMsgResponse;
	}

	public static <T> TMsgResponse<Object> postJson(String url, T t) {
		Map<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-type", "application/json");

		String paramJson = JsonUtil.toJson(t);
		LogUtil.log.debug("调用服务地址：" + url + "调用参数：" + paramJson);
		String messageJson = HttpUtil.postString(url, paramJson, "utf-8", headerMap);
		LogUtil.log.debug("------------------：" + messageJson);
		TMsgResponse<Object> tMsgResponse = JsonUtil.toObject(messageJson, TMsgResponse.class);
		LogUtil.log.debug("调用REST服务返回结果：" + tMsgResponse.getRespCode());
		return tMsgResponse;
	}

	/**
	 * 
	 * @Title: get
	 * @Description: get
	 * @param @param url
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String httpGet(String url) {
		try {
			HttpGet httpGet = new HttpGet(url);
			HttpClient client = new DefaultHttpClient();
			HttpResponse resp = client.execute(httpGet);

			HttpEntity entity = resp.getEntity();
			String respContent = EntityUtils.toString(entity, "GBK").trim();
			httpGet.abort();
			client.getConnectionManager().shutdown();

			return respContent;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getContentCharSet(final HttpEntity entity) throws ParseException {

		if (entity == null) {
			throw new IllegalArgumentException("HTTP entity may not be null");
		}
		String charset = null;
		if (entity.getContentType() != null) {
			HeaderElement values[] = entity.getContentType().getElements();
			if (values.length > 0) {
				NameValuePair param = values[0].getParameterByName("charset");
				if (param != null) {
					charset = param.getValue();
				}
			}
		}

		if (StringUtils.isEmpty(charset)) {
			charset = "UTF-8";
		}
		return charset;
	}

}
