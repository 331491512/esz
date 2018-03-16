package com.westangel.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

/**
 * 
* @ClassName: HttpUtil 
* @Description: http工具类 
* @author LIPENG
* @date 2015年12月18日 上午11:29:18 
*
 */
public final class HttpUtil {
	/**
	 * 
	* @Title: get 
	* @Description: get 
	* @param @param url
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String get(String url){
		String result = null;
		try {
			HttpGet request = new HttpGet(url);
			request.releaseConnection();
			HttpResponse response = new DefaultHttpClient().execute(request);
			BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();		
	        LogUtil.log.info("======= Send http GET request succeed. url="+url+". result="+result);
	        
		} catch (Exception e) {
			e.printStackTrace();
	        LogUtil.logError.error("###### Send http GET request failed. url="+url+". result="+result);

		}
		return result;
	} 
	 
	/**
	 * 
	* @Title: getToFile 
	* @Description: Get 保存到文件里 
	* @param @param url
	* @param @param path    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	static public boolean getToFile(String url, String path)
	{
		try {
			HttpGet request = new HttpGet(url);
			request.releaseConnection();
			HttpResponse response = new DefaultHttpClient().execute(request);
			InputStream is = response.getEntity().getContent();
			File file = new File(path);
			file.getParentFile().mkdirs();
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buffer = new byte[1024];
			int ch = 0;
			while ((ch = is.read(buffer)) != -1){
				fos.write(buffer, 0, ch);
			}
			is.close();
			fos.flush();
			fos.close();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 
	* @Title: post 
	* @Description: post 
	* @param @param url
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String postForm(String url, List<NameValuePair> paras){
		String result = null;
		try {
			HttpPost request = new HttpPost(url);
			
	        UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(paras, "UTF-8");  
	        request.setEntity(formEntiry);
	        request.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
	        request.releaseConnection();
	        HttpResponse response = new DefaultHttpClient().execute(request);
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
        return result;
	}
	
	/**
	 * 
	* @Title: postForm 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param url
	* @param @param paras
	* @param @param charset
	* @param @param headerMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String postForm(String url, List<NameValuePair> paras, String charset, Map<String, String> headerMap){
		String result = null;
		try {
			HttpPost request = new HttpPost(url);
			
	        UrlEncodedFormEntity formEntiry = new UrlEncodedFormEntity(paras, charset);  
	        request.setEntity(formEntiry);
	        if (null != headerMap) {
				for(String key:headerMap.keySet()){
					request.setHeader(key, headerMap.get(key));		
				}
			}
	        
	        request.releaseConnection();
	        HttpResponse response = new DefaultHttpClient().execute(request);
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			
		}
		
        return result;
	}	

	/**
	 * 
	* @Title: postString 
	* @Description:  
	* @param @param url
	* @param @param string
	* @param @param charset
	* @param @param headerMap
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String postString(String url, String string, String charset, Map<String, String> headerMap){
		String result = null;
		BufferedReader in = null;
		HttpPost request = null;
		try {
			request = new HttpPost(url);
			request.setEntity(new StringEntity(string, charset));
	        if (null != headerMap) {
				for(String key:headerMap.keySet()){
					request.setHeader(key, headerMap.get(key));		
				}
			}
			request.releaseConnection();
	        HttpResponse response = new DefaultHttpClient().execute(request);
	        in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			LogUtil.logError.error("连接出错！！", e);
		}finally {
			try {
				if(in != null) {
					in.close();
				}
			} catch (IOException e) {
				LogUtil.logError.error("关闭连接出错！！", e);
			}
			request.releaseConnection();
		}
		return result;
	}
	
	/**
	 * 
	* @Title: postString 
	* @Description: POST String 
	* @param @param url
	* @param @param string
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String postString(String url, String string){
		String result = null;
		try {
			HttpPost request = new HttpPost(url);
			request.setEntity(new StringEntity(string));
			request.releaseConnection();
	        HttpResponse response = new DefaultHttpClient().execute(request);
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	
	public static boolean postFile(String url , String fileName)
	{
		try {
			HttpClient client=new DefaultHttpClient();// 开启一个客户端 HTTP 请求 
			HttpPost post = new HttpPost(url);//创建 HTTP POST 请求  
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addPart("file", new FileBody(new File(fileName)));	
			builder.setCharset(Charset.forName("UTF-8"));
			HttpEntity entity = builder.build();// 生成 HTTP POST 实体  	
			post.setEntity(entity);//设置请求参数
			HttpResponse response =  client.execute(post);// 发起请求 并返回请求的响应
			if (response.getStatusLine().getStatusCode()==200) {
				return true;
			}
		} catch (Exception e) 
		{
			LogUtil.logError.error(e.getMessage());
			throw new RuntimeException();
		}
		
		return false;	
	}
	public static String postWithJSON(String url, String json) {
		
		String result = null;
		try {
	        DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(url); 
	        httpPost.addHeader(HTTP.CONTENT_TYPE,  "application/json");
	        
	        httpPost.setEntity(new StringEntity(json.toString(), HTTP.UTF_8));  
	        
	        HttpResponse response = httpClient.execute(httpPost);
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
    }

	/**
	 * 
	* @Title: postString 
	* @Description: POST String 
	* @param @param url
	* @param @param string
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	static public String postString(DefaultHttpClient httpClient, String url, String string, Map<String, String> headerMap){
		String result = null;
		try {
			HttpPost request = new HttpPost(url);
	        if (null != headerMap) {
				for(String key:headerMap.keySet()){
					request.setHeader(key, headerMap.get(key));		
				}
			}
			
			request.setEntity(new StringEntity(string));
			request.releaseConnection();
	        HttpResponse response = ((null == httpClient) ? new DefaultHttpClient() : httpClient).execute(request);
	        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));  
	        StringBuffer sb = new StringBuffer("");  
	        String line = "";
	        String NL = System.getProperty("line.separator");  
	        while ((line = in.readLine()) != null) {  
	            sb.append(line + NL);  
	        }  
	        in.close();
	        result = sb.toString();			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
}
