package com.westangel.common.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.westangel.common.util.JsonUtil;
import com.westangel.common.util.LogUtil;

@Component
@Aspect
public class ControllerLogAspect
{

	// 配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
	@Pointcut("@within(org.springframework.stereotype.Controller)")
	public void aspect()
	{
	}

	/*
	 * 配置前置通知,使用在方法aspect()上注册的切入点 同时接受JoinPoint切入点对象,可以没有该参数
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint)
	{
		LogUtil.log.info("请求参数开始输出");
		Signature signature = joinPoint.getSignature();
		LogUtil.log.info("请求方法:" + signature.getDeclaringTypeName() + "." + signature.getName());
		Object[] args = joinPoint.getArgs();
		for(int i=0; i<args.length; i++)
		{
			if(args[i]!=null&&args[i].getClass().getName().equals("java.util.Locale"))
			{
				//暂不处理
			}else if(args[i]==null )
			{
				LogUtil.log.info("第"+(i+1)+"个参数:" + args[i] );
			}else{
				LogUtil.log.info("第"+(i+1)+"个参数:" + JsonUtil.toJson(args[i]));
			}
		}
		LogUtil.log.info("请求参数结束输出");
	}


	@AfterReturning(pointcut = "aspect()", returning = "result")
	public void doAfterReturning(Object result)
	{
		LogUtil.log.info("返回参数" + JsonUtil.toJson(result));
	}
}