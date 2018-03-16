package com.westangel.commonservice.trade.service.impl.pay.weixin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.westangel.common.util.Codec;
import com.westangel.common.util.LogUtil;

@Component
public class WeiXinUtil {
	
	public static  String appid;
	private static  String secret;
	public static String MCH_ID ;
	
	private static final String TOKEN ="e26840969e1d87b8866669abd3578c7f";//自己的token
	
	
	/*start   此字段值  在一个半小时内有效*/
	public static String access_token="";
	public static String jsapi_ticket="";
	/*end   此字段值  在一个半小时内有效*/
	
	
//===========================================================================================	
	
	@Value("${appid}")
	public void setAppid(String appid)
	{
		WeiXinUtil.appid=appid;
	}

	@Value("${secret}")
	public void setSecret(String secret)
	{
		WeiXinUtil.secret=secret;
	}
	
	@Value("${mch.id}")
	public void setMchId(String mchId)
	{
		WeiXinUtil.MCH_ID=mchId;
	}
	
	public static String getappid(){
		String temAppid = appid;
		return temAppid;
	}

	
	/**解析微信服务器传过来的xml文件
	 * 
	 * @param xml   xml类型字符串
	 * @param maps  用于存储解析的xml字段值
	 * @return
	 * @throws DocumentException
	 */
	public static Map<String,String> AnalysisXml(String xml,Map<String,String> maps) {
		try{
			SAXReader reader = new SAXReader();
			//InputStream  is = request.body;
			//Document document = reader.read(is);
			Document document = reader.read(new StringReader(xml));
			Element root = document.getRootElement();
			List<Element> roots = root.elements();
			for(Element element:roots){
				maps.put(element.getName(), element.getText());//将解析的信息保存到map中
				System.out.println("==================="+element.getName()+":"+element.getText());
			}
		}
		catch(Exception e){
			LogUtil.logError.error(e.getMessage());
		}
		return maps;
	}
	
	public static Map<String,String> AnalysisXml(InputStream is,Map<String,String> maps) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document document = reader.read(is);
		Element root = document.getRootElement();
		List<Element> roots = root.elements();
		for(Element element:roots){
			maps.put(element.getName(), element.getText());//将解析的信息保存到map中
			LogUtil.log.debug("AnalysisXml:==================="+element.getName()+":"+element.getText());
		}
		return maps;
	}

	
	/**
	 * 调用微信接口 返回数据
	 * @param url
	 * @param type
	 * @param param json格式的参数
	 * @return
	 */
	public static String methodHttpClientData(String url,String type,String param){
		return methodHttpClientData(url,type,param,"json");
	}
	/**
	 * get post请求
	 * @param url
	 * @param type get 或post
	 * @param param
	 * @param paramType "json" 或者'xml'
	 * @return
	 */
	public static String methodHttpClientData(String url,String type,String param,String paramType){
		String result = null;
		try {
			HttpClient httpClient = new HttpClient();
			if("get".equals(type)){
				GetMethod get = new GetMethod(url);
				get.releaseConnection();
				httpClient.executeMethod(get);
				httpClient.getParams().setContentCharset("UTF-8");
				result = get.getResponseBodyAsString();
			}else if("post".equals(type)){
				PostMethod post = new PostMethod(url);
				if("xml".equals(paramType)){
					post.setRequestHeader("Content-Type","text/xml;charset=utf-8");	
				}else{
					post.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");	
				}
			    post.setRequestBody(param);
			    post.releaseConnection();
			    httpClient.executeMethod(post);
			    httpClient.getParams().setContentCharset("UTF-8");
			    result = post.getResponseBodyAsString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**加密字符串(转化成十六进制)*/
	public static String SHA1StringReturn(String message){
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(message.getBytes());
			for (int i = 0; i < digest.length; i++) {
				String shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}
	
	private static String convertStreamToString(InputStream is){
		BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		try {
			String line = bf.readLine();
			while(line!=null){
				sb.append(line+"\n");
				line=bf.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(is!=null){
					is.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return sb.toString();
	}	
	
    /**
	 * 作用：产生随机字符串，不长于32位
	 * @return
	 */
    public static String createRandomStr(Integer length){
		String source="abcdefghijklmnopqrstuvwxyz0123456789";
		String result="";
		int start=0;
		for(int i=0;i<length;i++){
			start=Double.valueOf(Math.random()*source.length()).intValue();
			result+=source.substring(start, start+1);
		}
		return result;
	}
    /**
	 * 获取微信的sign签名
	 * @param params ：list参数格式：key=value 如：params.add("body=test");
	 * @return
	 */
    public static String getWeiXinSign(List<String> params,String key){
		Collections.sort(params);
		StringBuffer result=new StringBuffer();
		for(String param:params){
			result.append(param).append("&");
		}
		result.append("key=").append(key);
		return Codec.hexMD5(result.toString()).toUpperCase();
	}
    /**
     * 把list数据装好为json，
     * @param list数据格式，如：list[0]="openid=1111213123"
     * @return
     */
	public static String listToJson(List<String> list){
		StringBuffer json=new StringBuffer();
		json.append("{");
		for(int i=0;i<list.size();i++){
			String[] items=list.get(i).split("=");
			if(i==list.size()-1){
				json.append("\"").append(items[0]).append("\":\"").append(items[1]).append("\"");
			}else{
				json.append("\"").append(items[0]).append("\":\"").append(items[1]).append("\",");
			}
		}
		json.append("}");
		return json.toString();
	}
	 /**
     * 把list数据装好为xml，
     * @param list数据格式，如：list[0]="openid=1111213123"
     * @return
     */
	public static String listToXml(List<String> list){
		StringBuffer xml=new StringBuffer();
		xml.append("<xml>");
		for(int i=0;i<list.size();i++){
			String[] items=list.get(i).split("=");
			if(StringUtils.isNumeric(items[1])){
				xml.append("<").append(items[0]).append(">").append(items[1]).append("</").append(items[0]).append(">");
			}else{
				xml.append("<").append(items[0]).append("> <![CDATA[").append(items[1]).append("]]></").append(items[0]).append(">");
			}
		}
		xml.append("</xml>");
		return xml.toString();
	}
	/**
	 * 把xml解析为map
	 * @param xml
	 * @return
	 * @throws DocumentException
	 */
	public static Map<String,String> xmlToMap(String xml) throws DocumentException {
		Map<String,String> maps=new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		Document document = reader.read(new StringReader(xml));
		Element root = document.getRootElement();
		List<Element> roots = root.elements();
		for(Element element:roots){
			maps.put(element.getName(), element.getText());//将解析的信息保存到map中
		}
		return maps;
	}
	
	/*****
	 * @author jiayanzhao
	 * @param args
	 */
	public static String getJSSignature(long timestamp,String nonceStr,String url){
		String jsapi = "jsapi_ticket="+jsapi_ticket+"&noncestr="+nonceStr+"&timestamp="+timestamp+"&url="+url;
		String signature = SHA1StringReturn(jsapi);
		return signature;
	}
	
	
		

}	
