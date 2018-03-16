package com.westangel.commonservice.sms.model;

import java.util.HashMap;

import org.springframework.stereotype.Component;
/**
 * 
* @ClassName: SmsTemplateMap 
* @Description: 模版名称到模版的对应关系 
* @author LIPENG
* @date 2015年12月23日 上午11:16:28 
*
 */
@Component
public class SmsTemplateMap extends HashMap<String, SmsTemplateInfo> {

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -330474108888800594L;

}
