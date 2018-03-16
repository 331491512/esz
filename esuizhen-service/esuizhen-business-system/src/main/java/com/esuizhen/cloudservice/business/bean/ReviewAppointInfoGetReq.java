/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>ReviewAppointInfoGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月9日下午4:09:58<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: ReviewAppointInfoGetReq
* @Description: 
* @author lichenghao
* @date 2016年10月9日 下午4:09:58  
*/
public class ReviewAppointInfoGetReq {
	//复查预约Id
	private String appointId;

	public String getAppointId() {
		return appointId;
	}

	public void setAppointId(String appointId) {
		this.appointId = appointId;
	}
}
