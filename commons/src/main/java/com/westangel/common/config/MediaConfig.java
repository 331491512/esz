package com.westangel.common.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class MediaConfig extends BaseConfig {
	
	private MediaConfig(){
	}
	private static MediaConfig mediaConfig;
	public static MediaConfig getMediaConfig(){
		if(mediaConfig == null){
			mediaConfig = new MediaConfig();
		}
		return mediaConfig;
	}
	
	static{
		loadConfig();
	}
	
	public String rootDir;
	public String portraitDir;
	public String imMediaDir;
	public String urlRoot;
	public String h5UrlRoot;
	public int    qrCodeSize=300;
	
	private static void loadConfig(){
		try {
			String confFileDir = getConfFileDir();
			if (confFileDir == null) {
				throw new RuntimeException("获取media配置文件目录出错！");
			}
			String fileName = confFileDir + "/etc/" + "media-dir.conf";
			InputStream input = new FileInputStream(new File(fileName));
			Properties properties = new Properties();
			properties.load(input);
			String mediaRootDir = properties.getProperty("mediaRootDir");
			String urlRoot = properties.getProperty("urlRoot");
			String h5UrlRoot = properties.getProperty("h5UrlRoot");
			String qrCodeSize = properties.getProperty("qrcodeSize");
					
			input.close();
			if(isBlank(mediaRootDir) || isBlank(urlRoot)){
				throw new RuntimeException("不能为空的配置项为空！");
			}
			mediaConfig = new MediaConfig();
			mediaConfig.rootDir = mediaRootDir;
			mediaConfig.urlRoot = urlRoot;
			mediaConfig.h5UrlRoot = h5UrlRoot;
			mediaConfig.portraitDir = mediaConfig.rootDir + "/user";
			mediaConfig.imMediaDir = mediaConfig.rootDir + "/im";
			mediaConfig.qrCodeSize = Integer.parseInt(qrCodeSize);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("读取media-dir.conf配置文件出错！！");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取media-dir.conf配置文件出错！！");
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("media-dir.conf配置文件有误！！");
		}
	}
	
	public static boolean isBlank(String string){
		if(string == null)
			return true;
		else {
			return (string.trim().length()<=0);
		}
	}
	
	public static String getDefaultUserPicUrl(){
		return getMediaConfig().urlRoot +"/user/user-default_s.png";
	
	}
	
	

}
