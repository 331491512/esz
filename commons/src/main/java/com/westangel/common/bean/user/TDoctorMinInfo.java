/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DeviceInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:54:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.user;

import java.io.Serializable;

/** 
* @ClassName: TDoctorMinInfo 
* @Description: 医生最简信息
* @author YYCHEN
* @date 2016年04月05日 下午17:26:01  
*/
public class TDoctorMinInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	//
	private Long id;
	//医生ID
	private Long doctorId;
	//医生姓名
	private String trueName;
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public String getTrueName() {
		return trueName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
}
