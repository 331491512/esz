package com.westangel.common.bean.message.structuration;

import java.io.Serializable;

/**
 * 富文本消息定义
 * @author bigdragon
 *
 */
public class TRichTextMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	private String title; //标题
	
	private String description; //描述
	
	private String picUrl; //图片地址，直接加载
	
	private String bottomText; //底部文字
	 
	private String linkUrl;    //底部或图片点击后的链接

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the picUrl
	 */
	public String getPicUrl() {
		return picUrl;
	}

	/**
	 * @param picUrl the picUrl to set
	 */
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	/**
	 * @return the bottomText
	 */
	public String getBottomText() {
		return bottomText;
	}

	/**
	 * @param bottomText the bottomText to set
	 */
	public void setBottomText(String bottomText) {
		this.bottomText = bottomText;
	}

	/**
	 * @return the linkUrl
	 */
	public String getLinkUrl() {
		return linkUrl;
	}

	/**
	 * @param linkUrl the linkUrl to set
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	
	
}
