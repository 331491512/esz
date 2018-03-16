/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.util;<br/>  
 * <b>文件名：</b>PushNotifyUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月6日上午9:49:15<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import com.westangel.common.bean.push.PushNotifyInfo;

/** 
* @ClassName: PushNotifyUtil
* @Description: 
* @author lichenghao
* @date 2016年6月6日 上午9:49:15  
*/
public class PushNotifyUtil {
	
	//患者微信消息推送
	public final static void setSendWxProductId(PushNotifyInfo notifyInfo,Integer wxProductId){
		if(notifyInfo!=null&&wxProductId!=null){
			notifyInfo.setProductId(wxProductId);
		}
	}
}
