package com.westangel.common.bean.push;

import java.io.Serializable;
import java.util.List;

/**
 * 
* @ClassName: PushWeixinTemplate 
* @Description: 微信模版 
* @author LIPENG
* @date 2015年12月16日 下午5:17:31 
*
 */
public class PushWeixinTemplate implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 模版名称
	 */
	private String name;
	/**
	 * URL地址
	 */
	private String url;
	/**
	 * value列表
	 */
	private List<String> values;


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
	* @return values 
	*/
	public List<String> getValues() {
		return values;
	}

	/** 
	* @param values 要设置的 values 
	*/
	public void setValues(List<String> values) {
		this.values = values;
	}

	/** 
	* @return name 
	*/
	public String getName() {
		return name;
	}

	/** 
	* @param name 要设置的 name 
	*/
	public void setName(String name) {
		this.name = name;
	}
	
}
