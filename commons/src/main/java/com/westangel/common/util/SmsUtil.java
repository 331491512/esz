/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.util;<br/>  
 * <b>文件名：</b>SmsUtil.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年1月29日下午7:52:16<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.util;

import java.util.ArrayList;
import java.util.List;

import com.westangel.common.bean.sms.SmsContentSendReq;
import com.westangel.common.bean.sms.SmsTemplateSendReq;

/** 
* @ClassName: SmsUtil
* @Description: 
* @author lichenghao
* @date 2016年1月29日 下午7:52:16  
*/
public class SmsUtil {
	//创建短信
	public static SmsContentSendReq getSmsContentSendReq(String content,List mobiles){
		SmsContentSendReq req = new SmsContentSendReq();
		req.setBusinessId(1);
		req.setProductId(1);
		req.setMobiles(mobiles);
		if(mobiles==null)
			req.setMobiles(new ArrayList());
		return req;
	}
	
	//创建短信模版
	public static SmsTemplateSendReq getSmsTemplateSendReq(String templateName,String mobile,List values){
		SmsTemplateSendReq req	= new SmsTemplateSendReq();
		req.setTemplateName(templateName);
		req.setBusinessId(1);
		req.setProductId(1);
		req.setMobile(mobile);
		req.setValues(values);
		if(values==null){
			req.setValues(new ArrayList());
		}
		return req;
	}
}
