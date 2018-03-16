package com.westangel.common.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.westangel.common.bean.push.PushClientEventInfo;
import com.westangel.common.bean.push.PushConstValue;
import com.westangel.common.bean.push.PushNotifyInfo;
import com.westangel.common.bean.push.PushWeixinTemplate;
import com.westangel.common.constant.Constant;

/**
 * Push工具类
 */
public class PushUtil {

	public static PushNotifyInfo getAppPushNotifyInfo(){
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(1);//给App发送，填1
		notifyInfo.setPushType(3);
		notifyInfo.setUserRole(2);//医生
	
		return notifyInfo;
	}
	
	public static PushNotifyInfo getWxDataPushNotifyInfo(){
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(2); //给微信发送，填2
		notifyInfo.setPushType(1);
		notifyInfo.setUserRole(1);//微信患者
		
		return notifyInfo;
	}
	

	public static PushNotifyInfo getAppPushNotifyInfo(Long userId,int eventType,String eventInfo,String eventTip){
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(1);//给App发送，填1
		notifyInfo.setPushType(3);
		notifyInfo.setUserRole(2);//医生
		
		PushClientEventInfo event = new PushClientEventInfo();
		event.setEventType(eventType);
		event.setEventInfo(eventInfo);
		event.setEventTip(eventTip);
		notifyInfo.setContent(JSON.toJSONString(event));
		notifyInfo.setUserId(userId);
		notifyInfo.setTipText(eventTip);
		LogUtil.log.info("send notify to app doctor: userId="+userId+
				",notifyInfo="+JSON.toJSONString(notifyInfo));

		return notifyInfo;
	}
	
	public static PushNotifyInfo getAppPushNotifyInfo(Long userId,String content){
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(1);//给App发送，填1
		notifyInfo.setPushType(3);
		notifyInfo.setUserRole(2);//医生
		
		notifyInfo.setContent(content);
		notifyInfo.setUserId(userId);
		Map<String , Object> map = JsonUtil.toObject(content, Map.class);
		notifyInfo.setTipText(map.get("eventTip")+"");
		LogUtil.log.info("send notify to app doctor: userId="+userId+
				",notifyInfo="+JSON.toJSONString(notifyInfo));

		return notifyInfo;
	}
	/**
	 * 系统给App发推送-有业务状态更新
	 * @param userId
	 * @param eventTip
	 * @return
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForServiceStateChange(Long fromUser,Long toUser,int productType,String eventTip){
		
		JSONObject json = new JSONObject();
		json.put("userId", fromUser);
		json.put("productType", productType);
		String eventInfo = json.toJSONString();
		return getAppPushNotifyInfo(toUser,Constant.Push.EVENT_TYPE_SERVICE_STATE_CHANGE,eventInfo,eventTip);
	}
	/**
	 * 系统给App发推送-有新患者
	 * @param userId
	 * @param eventTip
	 * @return
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForNewPatient(Long fromUser,Long toUser,String tips){
		JSONObject json = new JSONObject();
		json.put("userId", fromUser);
		String eventInfo = json.toJSONString();
		String eventTip = tips;
		return getAppPushNotifyInfo(toUser,Constant.Push.EVENT_TYPE_NEW_PATIENT,eventInfo,eventTip);
	}
	
	/**
	 * 
	 * @author lichenghao
	 * @title :getAppPushNotifyInfoForApplyWaitHandle
	 * @Description:待处理申请
	 * @return PushNotifyInfo
	 * @date 2017年9月27日 下午2:15:23
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForApplyWaitHandle(Long fromUser,Long toUser,String tips){
		JSONObject json = new JSONObject();
		json.put("userId", fromUser);
		String eventInfo = json.toJSONString();
		String eventTip = tips;
		return getAppPushNotifyInfo(toUser,Constant.Push.EVENT_TYPE_APPLY_WAIT_HANDLE,eventInfo,eventTip);
	}
	
	/**
	 * 系统给App发推送-有新病历
	 * @param userId
	 * @param content 
	 * @param eventTip
	 * @return
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForEmr(Long userId,Long patientId,String patientName,String emrId, String content,int number){

		JSONObject json = new JSONObject();
		json.put("patientId", patientId);
		json.put("emrId", emrId);
		json.put("num", number);
		json.put("tips", "患者新增"+number+"份病历");
		String eventInfo = json.toJSONString();
		String eventTip = content;
		return getAppPushNotifyInfo(userId,Constant.Push.EVENT_TYPE_NEW_EMR,eventInfo,eventTip);

	}
	
	public static PushNotifyInfo getAppPushNotifyInfoForEmr(Long userId,Long patientId,String patientName,String emrId, String content){
		return getAppPushNotifyInfoForEmr(userId,patientId,patientName,emrId, content,1);
	}
	
	/**
	 * 系统给App发推送-有新随访问卷
	 * @param userId
	 * @param eventTip
	 * @return
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForFollowupQuestionnaire(Long userId,Long patientId,String patientName,String followupId,String followupItemId){

		JSONObject json = new JSONObject();
		json.put("patientId", patientId);
		json.put("followupId", followupId);
		json.put("followupItemId", followupItemId);
		String eventInfo = json.toJSONString();
		String eventTip = "患者"+patientName+"新反馈了1份随访问卷";
		return getAppPushNotifyInfo(userId,Constant.Push.EVENT_TYPE_NEW_FOLLOWUP,eventInfo,eventTip);

	}
	
	/**
	 * 系统给App发推送-有业务状态更新
	 * @param userId
	 * @param eventTip
	 * @return
	 */
	public static PushNotifyInfo getAppPushNotifyInfoForNewProfit(Long fromUser,Long toUser,int productType,float profit,String debitRecId,String eventTip){
		
		JSONObject json = new JSONObject();
		json.put("profit", profit);
		json.put("recId", debitRecId);
		String eventInfo = json.toJSONString();
		return getAppPushNotifyInfo(toUser,Constant.Push.EVENT_TYPE_NEW_PROFIT,eventInfo,eventTip);
	}

	
	/**
	 * 给微信发推送
	 * @param userId
	 * @param content
	 * @return
	 */
	public static PushNotifyInfo getWxDataPushNotifyInfo(Long userId,String content){
		return getWxDataPushNotifyInfo(userId,content,"text");
	}
	public static PushNotifyInfo getWxDataPushNotifyInfo(Long userId,String content,String msgtype){
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(2); //给微信发送，填2
		notifyInfo.setPushType(1);
		notifyInfo.setUserRole(1);//微信患者
		JSONObject json = new JSONObject();
		json.put("contentType", msgtype);
		json.put("content", content);
		notifyInfo.setContent(json.toJSONString());
		notifyInfo.setUserId(userId);
		LogUtil.log.info("send notify to WeiXin patient: userId="+userId+
				",content="+notifyInfo.getContent());

		return notifyInfo;
	}
	
	/**
	 * 
	* @Title: getWxTemplatePushNotifyInfo 
	* @Description: 给微信发送模版消息 
	* @param @param name
	* @param @param url
	* @param @param values
	* @param @return    设定文件 
	* @return PushNotifyInfo    返回类型 
	* @throws
	 */
	public static PushNotifyInfo getWxTemplatePushNotifyInfo(String name, String url, List<String> values){
		PushWeixinTemplate weixinTemplate = new PushWeixinTemplate();
		weixinTemplate.setName(name);
		weixinTemplate.setUrl(url);
		weixinTemplate.setValues(values);
		
		PushNotifyInfo notifyInfo = new PushNotifyInfo();
		notifyInfo.setBusinessId(1);
		notifyInfo.setProductId(2); //发出方为app
		notifyInfo.setUserRole(1);//微信患者		
		notifyInfo.setPushType(PushConstValue.NotifyType.NotifyTypeWXTemplate.ordinal());
		notifyInfo.setContent(JsonUtil.toJson(weixinTemplate));
	
		return notifyInfo;
	}
}
