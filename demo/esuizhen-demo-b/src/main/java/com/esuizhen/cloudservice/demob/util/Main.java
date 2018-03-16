package com.esuizhen.cloudservice.demob.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
		   
	    public static void main(String[] args) throws Exception {  
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/application.xml"});  
//	        UserService ds = (UserService) context.getBean("demoService");
//	        System.out.println(ds.getClass());
//	        System.out.println(ds.getName());
//	        ds.getName();
//	        for(Demo demo : ds.selectUser())
//	        {
//	        	System.out.println("name="+demo.getName());
//	        }
	    }  
	   
}
