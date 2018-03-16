package com.westangel.commonservice.push.model.weixin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WeixinTemplateMap extends HashMap<String, WeixinTemplateInfo> {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -512382138297031542L;
	
	/**
	 * 
	* @Title: templateList 
	* @Description: 转成LIST 
	* @param @return    设定文件 
	* @return List<WeixinTemplateInfo>    返回类型 
	* @throws
	 */
	public List<WeixinTemplateInfo> templateList()
	{
		List<WeixinTemplateInfo> list = new ArrayList<WeixinTemplateInfo>();
		for(WeixinTemplateInfo template:values()){
			list.add(template);
		}
		return list;
	}
}
