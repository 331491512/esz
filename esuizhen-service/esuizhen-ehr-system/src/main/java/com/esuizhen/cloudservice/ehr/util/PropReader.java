package com.esuizhen.cloudservice.ehr.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
/**
 * Title:PropReader
 * Description:提供读取properity文件资源的功能
 * @Create_by:yuanwenming
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:1.0
 * 
 */
public class PropReader {

	private ResourceBundle res = null;
	Logger log = Logger.getLogger(PropReader.class);
	
	/**
	 * 根据properity文件初始化ResourceBundle对象
	 * @param fileName:String  properity文件名
	 * @throws Exception
	 */
	public PropReader(final String fileName) throws Exception
	{
		try{
			res = AccessController.doPrivileged(
					new PrivilegedAction<ResourceBundle>() {
						public ResourceBundle run() {
							return ResourceBundle.getBundle(fileName);
						}
					});
		}catch(Exception e){
			 log.error(e);
			 throw e; 
		}
	}
	
	/**
	 *  根据properity文件,Local 初始化ResourceBundle对象
	 * @param fileName:String  properity文件名
	 * @param local:Local  Local对象
	 * @throws Exception   
	 */
	public PropReader(final String fileName,final Locale local) throws Exception
	{
		try{
			res = AccessController.doPrivileged(
					new PrivilegedAction<ResourceBundle>() {
						public ResourceBundle run() {
							return ResourceBundle.getBundle(fileName,local);
						}
					});
		}catch(Exception e){
			 log.error(e);
			 throw e;
		}
	}
	
	/**
	 * 根据key得到properity文件中的value值
	 * @param strKey:String  properity文件的key
	 * @return strValue:String  properity文件key对应的value
	 * @throws Exception   UnsupportedEncodingException
	 */ 
	public String getString(String strKey) throws Exception
	{
		String strValue = null;
		
		try{	
			
			String value = res.getString(strKey);
			
			if( value != null )
			{
				byte[] bytes = value.getBytes("UTF-8");
				strValue = new String (bytes);
			}
			
		}catch(Exception e){
			
			 log.error(e);
			 throw e;
		}
		
		return strValue ;
	}
	
	/**
	 * 根据key得到properity文件中的value值,如果value值为null,或"",则赋默认值defaultValue
	 * @param strKey:String  properity文件的key
	 * @param defaultValue:String  key默认值
	 * @return strValue:String  properity文件的key对应值
	 * @throws Exception   UnsupportedEncodingException
	 */
	public String getString(String strKey,String defaultValue) throws Exception
	{
		String strValue = defaultValue;
		
		try{		
			
			String value = res.getString(strKey);
			
			if( value != null && (!"".equals(value.trim())))
			{
				byte[] bytes = value.getBytes("ISO-8859-1");
				strValue = new String (bytes);
			}
			
		}catch(Exception e){
			
			 log.error(e);
			 throw e;
		}
		
		return strValue ;
	}  
}
