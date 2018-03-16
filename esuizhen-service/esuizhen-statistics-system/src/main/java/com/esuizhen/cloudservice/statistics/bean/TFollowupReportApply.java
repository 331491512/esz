/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TFollowupReportApply.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午8:18:56<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.Date;

/** 
* @ClassName: TFollowupReportApply
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午8:18:56  
*/
public class TFollowupReportApply {
	//服务申请号
	private String productapplyId;
	//用户编号
	private Long userId;
	//邮箱地址
	private String email;
	//姓名
	private String trueName;
	//医生编号
	private Long doctorId;
	
	//申请时间
	private Date applyDate;
	
	public String getProductapplyId() {
		return productapplyId;
	}
	public void setProductapplyId(String productapplyId) {
		this.productapplyId = productapplyId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public Long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
}
