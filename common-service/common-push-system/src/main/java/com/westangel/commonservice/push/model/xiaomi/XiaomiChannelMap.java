package com.westangel.commonservice.push.model.xiaomi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class XiaomiChannelMap extends HashMap<String, XiaomiChannelInfo>{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -5430179038775736621L;
	
	/**
	 * 
	* @Title: channelList 
	* @Description: 转成LIST 
	* @param @return    设定文件 
	* @return List<WeixinTemplateInfo>    返回类型 
	* @throws
	 */
	public List<XiaomiChannelInfo> channelList()
	{
		List<XiaomiChannelInfo> list = new ArrayList<XiaomiChannelInfo>();
		for(XiaomiChannelInfo template:values()){
			list.add(template);
		}
		return list;
	}
}
