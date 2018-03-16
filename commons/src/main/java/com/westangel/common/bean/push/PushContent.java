/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.push;<br/>  
 * <b>文件名：</b>PushConten.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月16日下午2:42:21<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.push;

import java.io.Serializable;

/** 
* @ClassName: PushConten
* @Description: 
* @author lichenghao
* @date 2016年6月16日 下午2:42:21  
*/
public class PushContent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 内容编号
	 */
	private Integer pushContentId;
	//推送或消息内容
	private String pushContent;
	//业务类型
	private Integer serviceType;
	//业务目标项的ID
	private String targetId;
	//推送标识
	private String tag;
	
	//内容补充项
	private Object[] args;

	public Integer getPushContentId() {
		return pushContentId;
	}

	public void setPushContentId(Integer pushContentId) {
		this.pushContentId = pushContentId;
	}

	public String getPushContent() {
		return pushContent;
	}

	public void setPushContent(String pushContent) {
		this.pushContent = pushContent;
	}

	public Integer getServiceType() {
		return serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getTargetId() {
		return targetId;
	}

	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}
	
	public PushContent(){}
	
	public PushContent(Integer serviceType,String targetId,String tag,Object ... args){
		this.serviceType=serviceType;
		this.targetId = targetId;
		this.tag = tag;
		this.args = args;
	}
}
