package com.westangel.commonservice.message.bean;

import java.io.Serializable;

/**
* @author 作者 :LIPENG
* @des 聊天简要信息
* @version 创建时间：2015年12月5日 下午12:27:09
* 类说明
*/

public class ImChatBriefInfo implements Serializable {
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4158828540314744567L;
	//
	private Long chatId;
	//
	private Integer chatType;
	
	public void setChatId(Long chatId) {
		this.chatId = chatId;
	}
	public Long getChatId() {
		return chatId;
	}
	public void setChatType(Integer chatType) {
		this.chatType = chatType;
	}
	public Integer getChatType() {
		return chatType;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
