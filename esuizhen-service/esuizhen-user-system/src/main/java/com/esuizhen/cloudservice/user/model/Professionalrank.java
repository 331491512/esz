/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>com.esuizhen.cloudservice.user.bean<br/>  
 * <b>文件名：</b>DeviceInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2015年12月3日-上午11:54:01<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.model;

import java.io.Serializable;

/** 
* @ClassName: DeviceInfo 
* @Description: 科室bean
* @author YYCHEN
* @date 2015年12月14日 下午14:54:01  
*/
public class Professionalrank implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long professionalRankId;
	private String professionalRankName;
	
	public Long getProfessionalRankId() {
		return professionalRankId;
	}
	public void setProfessionalRankId(Long professionalRankId) {
		this.professionalRankId = professionalRankId;
	}
	public String getProfessionalRankName() {
		return professionalRankName;
	}
	public void setProfessionalRankName(String professionalRankName) {
		this.professionalRankName = professionalRankName;
	}
}
