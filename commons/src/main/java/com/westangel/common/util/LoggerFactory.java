package com.westangel.common.util;

import org.apache.log4j.Logger;

import com.westangel.common.config.BaseConfig;

public class LoggerFactory {
	
	static {
		String nodeHomeEnv = BaseConfig.getConfFileDir();
		String outLogsDir = "logs";
		if(nodeHomeEnv != null){
			outLogsDir = nodeHomeEnv + "/logs";
		}
		System.setProperty("out.logs", outLogsDir);
	}

	/**
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class clazz){
		return Logger.getLogger(clazz);
	}
}
