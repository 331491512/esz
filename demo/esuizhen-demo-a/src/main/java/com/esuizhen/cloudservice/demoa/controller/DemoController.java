package com.esuizhen.cloudservice.demoa.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.esuizhen.cloudservice.demob.service.EhrService;

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
	private EhrService service;
	/**
	 * 用户信息
	 * @param id
	 * @param locale
	 * @param map
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/")
	public String getPatient(Locale locale , ModelMap map)
	{
		return service.getName();
	}
}
