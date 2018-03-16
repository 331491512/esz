package com.westangel.common.config;

public abstract class BaseConfig {
	
	
	/**
	 * 返回配置文件的文件夹
	 * @return
	 */
	public static String getConfFileDir(){
		String confFileDir = System.getenv("ESUIZHEN_HOME");
		if(confFileDir==null){
			confFileDir = System.getenv("ESUIZHEN_HOME");
			if(confFileDir==null){
				System.out.println("ERROR in TNodeLibLoader.init(): The environment variable 'ESUIZHEN_HOME' is not defined.");
			}
		}
		return confFileDir;
	}
}
