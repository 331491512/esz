package com.westangel.common.bean.push;

import java.io.Serializable;

/**
 * 
* @ClassName: PushWeixinData 
* @Description: 微信数据 
* @author LIPENG
* @date 2015年12月16日 下午5:18:47 
*
 */
public class PushWeixinData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String ContentTypeText = "text"; 
	
	/**
	 * 类型 text
	 */
	private String contentType;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * url地址
	 */
	private String url;

	/** 
	* @return content 
	*/
	public String getContent() {
		return content;
	}
	/** 
	* @param content 要设置的 content 
	*/
	public void setContent(String content) {
		this.content = content;
	}
	/** 
	* @return url 
	*/
	public String getUrl() {
		return url;
	}
	/** 
	* @param url 要设置的 url 
	*/
	public void setUrl(String url) {
		this.url = url;
	}
	/** 
	* @return contentType 
	*/
	public String getContentType() {
		return contentType;
	}
	/** 
	* @param contentType 要设置的 contentType 
	*/
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}
