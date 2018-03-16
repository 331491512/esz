package com.westangel.common.bean.message.structuration;

import java.io.Serializable;

/**
 * 消息底部栏定义
 * @author bigdragon
 *
 */
public class TBottomInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String  text;//显示文字
	
	private String  url; //链接url

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
