package com.westangel.common.bean.message;

import java.io.Serializable;

/**
 * 
* @ClassName: ImImageMessage 
* @Description: 图片消息 
* @author LIPENG
* @date 2016年1月5日 下午7:08:07 
*
 */
public class ImImageMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	private String url;
	private Integer width;
	private Integer height;
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
	* @return width 
	*/
	public Integer getWidth() {
		return width;
	}
	/** 
	* @param width 要设置的 width 
	*/
	public void setWidth(Integer width) {
		this.width = width;
	}
	/** 
	* @return height 
	*/
	public Integer getHeight() {
		return height;
	}
	/** 
	* @param height 要设置的 height 
	*/
	public void setHeight(Integer height) {
		this.height = height;
	}
}
