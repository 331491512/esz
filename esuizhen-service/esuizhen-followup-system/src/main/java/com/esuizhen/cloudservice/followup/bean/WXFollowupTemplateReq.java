/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.bean;<br/>  
 * <b>文件名：</b>FollowupWXTemplateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年7月18日下午7:10:25<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.bean;
/** 
* @ClassName: FollowupWXTemplateReq
* @Description: 
* @author lichenghao
* @date 2016年7月18日 下午7:10:25  
*/
public class WXFollowupTemplateReq {
	//模版编号
	private String templateId;
	//医院编号
	private Integer hospitalId;
	//签名
	private String siganature;
	//内容
	private String content;
	//回复内容
	private String replyContent;
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getSiganature() {
		return siganature;
	}
	public void setSiganature(String siganature) {
		this.siganature = siganature;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
}
