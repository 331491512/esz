/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>DoctorClinicSchedule.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午3:38:08<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;

import java.util.Date; 

/**
 * @ClassName: DoctorClinicSchedule.java
 * @Description: 医生门诊时间实体
 * @author lichenghao
 * @date 2015年12月12日 下午3:38:08
 */
public class CallHandupModle {
	public String event; 	/*string 	必选 	值为：callhangup*/
	public String callid; 	/*string 	必选 	呼叫的唯一标识（沿用原来机制，由sdk组件生成）*/
	public String accountid; 	/*string 	必选 	开发者账号id*/
	public String appid; 	/*string 	必选 	应用id*/
	public String confid; 	/*string 	必选 	群聊id (仅语音群聊场景)*/
	public String calltype; 	/*int 	必选 	1：免费*/
	public String subcalltype; 	/*int 	可选 	1:音频、2:视频（此字段当calltype=1时生效 ）*/
	public String callertype; 	/*int 	必选 	主叫号码类型，0：Client账号，1：普通电话，2：userid*/
	public String callernum;	/*String	必选 	用户绑定的号码*/
	public String displaynum;	/*String	必选 	用户显号号码*/
	public String caller; 	/*String 	必选 	主叫号码 普通电话：18612345678 Client号码：60000000000017*/
	public String calledtype; 	/*int 	必选 	被叫号码类型，0：Client账号，1：普通电话，2：userid*/
	public String called; 	/*string 	必选 	被叫号码普通电话：18612345678 Client号码：60000000000017*/
	public String starttime; 	/*string 	必选 	开始通话时间。时间格式如：2014-06-16 16:47:28*/
	public String stoptime;	/*string 	必选 	结束通话时间。时间格式如：2014-06-16 17:31:14*/
	public int length; 	/*int 	必选 	通话时长(s)*/
	public String recordurl; 	/*String 	可选 	通话录音完整下载地址，默认为空。*/
	public String userData;	/*string 	可选 	用户自定义数据字符串，最大长度128字节*/
	public String reason; 	/*int 	必选 	挂机原因描述，0：正常挂断；1：余额不足；2：媒体超时；3：无法接通；4：拒接；
								5：超时未接；6：拒接或超时未接；7：平台服务器网络错误；8：用户请求取消通话；
								9：第三方鉴权错误；255：其他原因。*/
	public int subreason; 	/*可选 	挂机原因补充描述，1：主叫挂断；2：被叫挂断；目前当reason=0时有效。 */
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getCallid() {
		return callid;
	}
	public void setCallid(String callid) {
		this.callid = callid;
	}
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getConfid() {
		return confid;
	}
	public void setConfid(String confid) {
		this.confid = confid;
	}
	public String getCalltype() {
		return calltype;
	}
	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}
	public String getSubcalltype() {
		return subcalltype;
	}
	public void setSubcalltype(String subcalltype) {
		this.subcalltype = subcalltype;
	}
	public String getCallertype() {
		return callertype;
	}
	public void setCallertype(String callertype) {
		this.callertype = callertype;
	}
	public String getCallernum() {
		return callernum;
	}
	public void setCallernum(String callernum) {
		this.callernum = callernum;
	}
	public String getDisplaynum() {
		return displaynum;
	}
	public void setDisplaynum(String displaynum) {
		this.displaynum = displaynum;
	}
	public String getCaller() {
		return caller;
	}
	public void setCaller(String caller) {
		this.caller = caller;
	}
	public String getCalledtype() {
		return calledtype;
	}
	public void setCalledtype(String calledtype) {
		this.calledtype = calledtype;
	}
	public String getCalled() {
		return called;
	}
	public void setCalled(String called) {
		this.called = called;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getStoptime() {
		return stoptime;
	}
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getRecordurl() {
		return recordurl;
	}
	public void setRecordurl(String recordurl) {
		this.recordurl = recordurl;
	}
	public String getUserData() {
		return userData;
	}
	public void setUserData(String userData) {
		this.userData = userData;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getSubreason() {
		return subreason;
	}
	public void setSubreason(int subreason) {
		this.subreason = subreason;
	}
}
