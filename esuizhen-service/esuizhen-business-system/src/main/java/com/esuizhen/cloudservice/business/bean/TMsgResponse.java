/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.business.bean;<br/>  
 * <b>文件名：</b>TMsgResponse.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月12日下午5:22:59<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.business.bean;

import com.westangel.common.bean.ErrorMessage;

/** 
* @ClassName: TMsgResponse.java
* @Description: MsgResponse扩展
* @author lichenghao
* @date 2015年12月12日 下午5:22:59  
*/
public class TMsgResponse<T> extends com.westangel.common.bean.TMsgResponse<T>{
	
	public TMsgResponse(Integer respCode,String respMsg){
		this.setCodeAndrespMsg(respCode, respMsg);
	}
	public void setCodeAndrespMsg(Integer respCode,String respMsg){
		setRespCode(respCode);
		setRespMsg(respMsg);
	}
	public TMsgResponse(){};
}
