/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>RichTextFirstSendMessageReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月17日下午5:41:20<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;
/** 
* @ClassName: RichTextFirstSendMessageReq
* @Description: 
* @author lichenghao
* @date 2016年10月17日 下午5:41:20  
*/
public class RichTextFirstSendMessageReq {
	//服务内容
	private String productApplyId;
	//次数
	private Integer num = 0;
	//消息json
	private String message;
	
	private Integer messageSource;
	
	public String getProductApplyId() {
		return productApplyId;
	}
	public void setProductApplyId(String productApplyId) {
		this.productApplyId = productApplyId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(Integer messageSource) {
		this.messageSource = messageSource;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
}
