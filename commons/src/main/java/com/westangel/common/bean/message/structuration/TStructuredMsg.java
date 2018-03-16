package com.westangel.common.bean.message.structuration;

import java.io.Serializable;

/**
 * 结构化消息定义
 * 应用层发送结构化的自定义消息时使用
 * @author bigdragon
 * @param <T>
 * @date 2016/1/6
 */
public class TStructuredMsg<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private String msgType; //button, richtext
	
	private T      msgBody; //消息体

	/**
	 * @return the msgType
	 */
	public String getMsgType() {
		return msgType;
	}

	/**
	 * @param msgType the msgType to set
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	/**
	 * @return the msgBody
	 */
	public T getMsgBody() {
		return msgBody;
	}

	/**
	 * @param msgBody the msgBody to set
	 */
	public void setMsgBody(T msgBody) {
		this.msgBody = msgBody;
	}
	
	
	
}
