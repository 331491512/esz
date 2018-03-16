package com.westangel.common.bean.message.structuration;

import java.io.Serializable;
import java.util.Map;

/**
 * button项结构定义
 * @author bigdragon
 *
 */
public class TButtonItemInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String  text; //按钮上的文字
	
	private String  eventUrl; //如果给出了eventUrl,则使用此url进行http请求，包括完整的url和queryString。否则，由客户端根据eventKey自行组装。
							  //【对于GET类型的事件，通常用eventUrl即可。凡是给出了下面的param参数的，都是POST方法；未给出param参数的，都是GET方法】
	
	private String  eventKey;//通过eventKey区别不同种类的事件，例如更改电话咨询时间eventKey= SERVICE_MODIFY_TEL_CONSULT_TIME
	
	private Map<String,Object>  param; //参数。客户端需要原样+组装新参数返回。
	

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
	 * @return the eventUrl
	 */
	public String getEventUrl() {
		return eventUrl;
	}

	/**
	 * @param eventUrl the eventUrl to set
	 */
	public void setEventUrl(String eventUrl) {
		this.eventUrl = eventUrl;
	}

	/**
	 * @return the eventKey
	 */
	public String getEventKey() {
		return eventKey;
	}

	/**
	 * @param eventKey the eventKey to set
	 */
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @return the param
	 */
	public Map<String, Object> getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(Map<String, Object> param) {
		this.param = param;
	}


	
	
}
