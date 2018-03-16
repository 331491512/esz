package com.westangel.common.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import com.westangel.common.config.MediaConfig;

/**
 * 工具类
 * 
 * @author bigdragon
 * 
 */
public class GeneralUtil {
	
	
	
		
	/**
	 * 产生一个24位的全局唯一的数字字符串。格式: 前缀（4个字符）+YYYYMMDDHHMMSSnnnnnn
	 * @return
	 */
	public static String generateUniqueID(String prefix){
		if(prefix==null) prefix="UUID";
		if(prefix.length()>4) prefix = prefix.substring(0,4);
		return prefix+generatorTimeUUID();
	}

	/**
	 * 生成一个uuid,全局的唯一标识符
	 * 
	 * @return String
	 */
	public static String generatorUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String generatorUUID(int length){
		String uuid = generatorUUID();
		if(uuid.length() > length){
			return uuid.substring(0, length);
		}
		else {
			return uuid;
		}
	}

	/**
	 * 生成一个随机数， 小于reference的整数
	 * 
	 * @param reference
	 * @return 一个小于reference的随机整数
	 */
	public static int generatorRandom(int reference) {
		return (int) Math.floor((Math.random() * reference));
	}

   static Random mRandom = new Random();

    /**
     * 按照时间生成唯一的id
     * @return
     */
    public static String generatorTimeUUID(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String id = dateFormat.format(date)+String.valueOf(mRandom.nextInt(899999)+100000);
        return id;
    }
    
    /**
     * @author wang_hw
     * @title :generatorAppleUUID
     * @Description:生成APPLID
     * @return String
     * @date 2015年12月15日 下午3:58:37
     */
    public static String generatorUUID(String obj){
        return obj+generatorTimeUUID();
    }
    
	/**
	 * 计算地球上任意两点(经纬度)距离
	 * 
	 * @param long1
	 *            第一点经度
	 * @param lat1
	 *            第一点纬度
	 * @param long2
	 *            第二点经度
	 * @param lat2
	 *            第二点纬度
	 * @return 返回距离 单位：米
	 */
	public static double DistanceByPI(double long1, double lat1, double long2,
			double lat2) {
		double a, b, R;
		R = 6371393; // 地球半径
		lat1 = lat1 * Math.PI / 180.0;
		lat2 = lat2 * Math.PI / 180.0;
		a = lat1 - lat2;
		b = (long1 - long2) * Math.PI / 180.0;
		double d;
		double sa2, sb2;
		sa2 = Math.sin(a / 2.0);
		sb2 = Math.sin(b / 2.0);
		d = 2* R * Math.asin(Math.sqrt(sa2 * sa2 + Math.cos(lat1)
						* Math.cos(lat2) * sb2 * sb2));
		return d;
	}
	
	
	public static double Distance(double long1, double lat1, double long2,
			double lat2){
		
		return 111199.233*Math.sqrt(Math.pow(lat1-lat2, 2)+Math.pow(long1-long2, 2)) ;

	}
	
	public static String getSmallUserPicUrl(String userPicUrl){
		if(userPicUrl==null || userPicUrl.isEmpty()) return getDefaultUserPicUrl();
        if(!userPicUrl.contains("_s.")){
        	int index = userPicUrl.lastIndexOf(".jpg");
        	if(index>0){
        		return  userPicUrl.substring(0, index) + "_s.jpg";
        	}
        }
        return userPicUrl;

	}
	
	public static String getDefaultUserPicUrl(){
		return MediaConfig.getMediaConfig().getDefaultUserPicUrl();
	
	}
	

	 
	public static boolean isDigital(String str){
		if(str==null || str.isEmpty()) return false;
		try{
		    Long.parseLong(str);
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	public static Map<String, String> parseQueryStringParameters(String queryString){
		Map<String, String> parameters = new HashMap<String, String>();
        String[] params = queryString.split("&");
        if (params.length == 0) {
        	return parameters;
        }
        for (int i = 0; i < params.length; i++) {
        	int indexSplit = params[i].indexOf("=");
        	if(indexSplit==-1){
        		parameters.put(params[i],"");
        	}
        	else{
        		String name = params[i].substring(0, indexSplit);
        		String value = params[i].substring(indexSplit+1,params[i].length());
    			parameters.put(name, value);
        	}
        
		}
        return parameters;
	}
	
	/**
	 * 产生随机六位数字（0-9）
	 */
	public static String getCaptchaNum(){
		String sRand = "";
        for (int i = 0; i < 6; i++){
        	String randChar = "";
	        randChar = String.valueOf(Math.round(Math.random() * 9));
	        sRand = sRand.concat(randChar); 
	    }
        return sRand;
	}
	
	
	public static void main(String[] argv){
		
		
	}
}
