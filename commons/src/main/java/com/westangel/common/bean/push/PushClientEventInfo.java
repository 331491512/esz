package com.westangel.common.bean.push;

import java.io.Serializable;

/**
 * 
* @ClassName: PushClientEventInfo 
* @Description: 客户端推送事件 
* @author LIPENG
* @date 2016年1月5日 下午6:35:12 
*
 */
public class PushClientEventInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum EventType{
		EventTypeUnknown,
		/**
		 * 新消息
		 */
		EventTypeMessage
	};
	
	/**
	 * 事件类型
	 */
	private Integer eventType;
	/**
	 * 事件内容
	 */
	private String eventInfo;
	/**
	 * 提示语
	 */
	private String eventTip;
	/** 
	* @return eventType 
	*/
	public Integer getEventType() {
		return eventType;
	}
	/** 
	* @param eventType 要设置的 eventType 
	*/
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	/** 
	* @return eventInfo 
	*/
	public String getEventInfo() {
		return eventInfo;
	}
	/** 
	* @param eventInfo 要设置的 eventInfo 
	*/
	public void setEventInfo(String eventInfo) {
		this.eventInfo = eventInfo;
	}
	/** 
	* @return eventTip 
	*/
	public String getEventTip() {
		return eventTip;
	}
	/** 
	* @param eventTip 要设置的 eventTip 
	*/
	public void setEventTip(String eventTip) {
		this.eventTip = eventTip;
	}
}
