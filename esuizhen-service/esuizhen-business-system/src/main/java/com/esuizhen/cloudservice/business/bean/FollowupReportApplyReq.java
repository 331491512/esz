/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>FollowupReportApplyReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午6:48:47<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: FollowupReportApplyReq
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午6:48:47  
*/
public class FollowupReportApplyReq {
	//申请者UserId
	private Long userId;
	//邮件
	private String email;
	
	//申请号
	private String productapplyId;
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
	public String getProductapplyId() {
		return productapplyId;
	}
	public void setProductapplyId(String productapplyId) {
		this.productapplyId = productapplyId;
	}
}
