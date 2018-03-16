package com.esuizhen.cloudservice.demob.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 获取Spring上下文
 * @author wang_hw
 *
 */
public class SpringContext implements ApplicationContextAware
{

	private static ApplicationContext applicationContext; // Spring应用上下文环境

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		SpringContext.applicationContext = applicationContext;
	}

	/**
	 * 获取对象
	 * 
	 * @param name
	 * @return Object 一个以所给名字注册的bean的实例
	 * @throws BeansException
	 */
	public static Object getBean(String name) throws BeansException
	{
		return applicationContext.getBean(name);
	}
}
