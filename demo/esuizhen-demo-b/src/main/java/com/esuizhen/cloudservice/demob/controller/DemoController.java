package com.esuizhen.cloudservice.demob.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.demoa.bean.User;
import com.esuizhen.cloudservice.demob.service.FollowupService;

/**
 * 控制器类
 * @author wang_hw
 *
 */
@Controller
public class DemoController
{
	/**
	 * 消息资源类（获取属性配置信息）
	 */
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private FollowupService followUpService;
	
	/**
	 * 用户信息
	 * @param id
	 * @param locale
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/")
	public User getPatient(Locale locale , ModelMap map)
	{
		
		User result = null ;
		try
		{
			//业务处理逻辑
			result = followUpService.getPatient();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return result;
	}
}
