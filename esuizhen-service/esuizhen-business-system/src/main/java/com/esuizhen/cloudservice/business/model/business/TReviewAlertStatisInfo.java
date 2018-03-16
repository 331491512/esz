/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.model.business;<br/>  
 * <b>文件名：</b>TReviewAlertStatisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年9月22日下午2:19:29<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.model.business;
/** 
* @ClassName: TReviewAlertStatisInfo
* @Description: 
* @author lichenghao
* @date 2017年9月22日 下午2:19:29  
*/
public class TReviewAlertStatisInfo {
	//待提醒
	private Integer waitAlert;
	//已预约
	private Integer appointing;
	//赴约中
	private Integer appointment;
	
	//已过期
	private Integer expire;
	public Integer getWaitAlert() {
		return waitAlert;
	}
	public void setWaitAlert(Integer waitAlert) {
		this.waitAlert = waitAlert;
	}
	public Integer getAppointing() {
		return appointing;
	}
	public void setAppointing(Integer appointing) {
		this.appointing = appointing;
	}
	public Integer getAppointment() {
		return appointment;
	}
	public void setAppointment(Integer appointment) {
		this.appointment = appointment;
	}
	public Integer getExpire() {
		return expire;
	}
	public void setExpire(Integer expire) {
		this.expire = expire;
	}
}
