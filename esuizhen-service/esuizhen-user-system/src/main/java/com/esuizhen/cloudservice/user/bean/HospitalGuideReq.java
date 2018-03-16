/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>HospitalGuideReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月19日下午7:09:48<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: HospitalGuideReq
* @Description: 
* @author lichenghao
* @date 2016年7月19日 下午7:09:48  
*/
public class HospitalGuideReq {
	
	//指南编号
	private String guideId;
	//医院编号
	private Integer hospitalId;
	//关键字
	private String keyword;
	public String getGuideId() {
		return guideId;
	}
	public void setGuideId(String guideId) {
		this.guideId = guideId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
