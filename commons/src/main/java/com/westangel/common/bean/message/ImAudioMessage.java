package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: ImAudioMessage 
* @Description: 音频消息 
* @author LIPENG
* @date 2016年1月5日 下午6:27:02 
*
 */
public class ImAudioMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * url地址
	 */
	private String url;
	/**
	 * 时长
	 */
	private float time_length;
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
	* @return time_length 
	*/
	public float getTime_length() {
		return time_length;
	}
	/** 
	* @param time_length 要设置的 time_length 
	*/
	public void setTime_length(float time_length) {
		this.time_length = time_length;
	}
	
	
}
