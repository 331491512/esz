/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>PushContentUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月22日上午10:40:20<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.westangel.common.bean.push.PushContent;
import com.westangel.common.constant.Constant;

/** 
* @ClassName: PushContentUtil
* @Description: 
* @author lichenghao
* @date 2016年6月22日 上午10:40:20  
*/
public class PushContentUtil {
	
	public static PushContent getPushContent(Integer serviceType,String targetId,String tag,Object ... args){
		return new PushContent(serviceType, targetId, tag, args);
	}
	
	public static PushContent getUserPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_USER, targetId, tag, args);
	}
	
	public static PushContent getBusinessPushContent(String targetId,String tag,Object[] args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_BUSINESS, targetId, tag, args);
	}
	
	public static PushContent getBusinessPushContent(String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_BUSINESS, null, tag, args);
	}
	
	
	
	public static PushContent getFollowupPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_FOLLOWUP, targetId, tag, args);
	}
	
	public static PushContent getMedicalRecordPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_MEDICALRECORD, targetId, tag, args);
	}
	
	public static PushContent getProjectPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_PROJECT, targetId, tag, args);
	}
	
	public static PushContent getStatisticsPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_STATISTICS, targetId, tag, args);
	}
	
	public static PushContent getWeiXinPushContent(String targetId,String tag,Object ... args){
		return getPushContent(Constant.Push.PUSH_CONTENT_SERVICETYPE_WEIXIN, targetId, tag, args);
	}
	
	
	/**
	 * 扫描push_content 生成插入语句
	 * @author lichenghao
	 * @title :main
	 * @Description:TODO
	 * @return void
	 * @date 2016年6月23日 上午10:15:14
	 */
	public static void main(String[] args) {
//		Properties prop = new OrderedProperties();  
//        InputStream in = PushContentUtil.class.getResourceAsStream("/message/push_content.properties");
//        String message = "INSERT INTO `com_push_db`.`push_content` (`tag`, `serviceType`, `targetId`,`pushContent` , `createTime`) VALUES ({0}, 1, {2}, {1}, {3});";
//        try {   
//            prop.load(in);
//            Enumeration<Object> en = prop.keys();
//            while(en.hasMoreElements()){
//            	String key = (String)en.nextElement();
//            	String sql = MessageFormat.format(message, "'"+key+"'","'"+prop.getProperty(key).replace("\n", "\\n")+"'","'2'","'2016-06-23 09:25:48'");
//            	System.out.println(sql);
//            }
//        } catch (IOException e) {   
//            e.printStackTrace();   
//        }
		Resource resource = new ClassPathResource("D:/certificate/rootca.pem");
		try{
		File caFile = new File("D:/certificate/rootca.pem");//resource.getFile();
		System.out.println(caFile.getParent());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
