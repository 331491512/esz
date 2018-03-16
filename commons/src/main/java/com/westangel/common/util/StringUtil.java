package com.westangel.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class StringUtil {

	/**
	 * 从字符串集合中查找第一个出现NULL的下标
	 * @param strings
	 * @return
	 */
	public static int findNullIndexFromList(List<String> strings){
		for (int i = 0, size = strings.size(); i < size; i++) {
			if (StringUtils.isBlank(strings.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 从字符串集合中查找与指定字符串相等的字符串位置的下标
	 * @param string
	 * @param strings
	 * @return
	 */
	public static int matchEqualsFromList(String string, List<String> strings){
		if (string == null) {
			return -1;
		}
		for (int i = 0, size = strings.size(); i < size; i++) {
			if(string.equals(strings.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 
	* @Title: getRandomString 
	* @Description: 随机字符串 
	* @param @param max
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getRandomString(int max){
	      String str ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      char[] chs = str.toCharArray();
	      String tem = "";
	      if(max>=1){
	        for(int count=1; count<=max;count++){
	          int n = (int)Math.floor(62*Math.random());
	          tem += chs[n];
	        }
	      }
	      return tem;
	  }
	
	/**
	 * 
	* @Title: SHA1StringReturn 
	* @Description:  获取SHA1加密串 
	* @param @param message
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws
	 */
	public static String getSHA1String(String message){
		StringBuffer hexString = new StringBuffer();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] digest = md.digest(message.getBytes());
			for (int i = 0; i < digest.length; i++) {
				String shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexString.append(0);
				}
				hexString.append(shaHex);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return hexString.toString();
	}	
}
