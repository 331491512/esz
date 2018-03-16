/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.search;<br/>  
 * <b>文件名：</b>RetrievalParamentReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:03:02<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.search;

import java.util.List;

/** 
* @ClassName: RetrievalParamentReq
* @Description: 
* @author lichenghao
* @date 2016年8月10日 下午4:03:02  
*/
public class RetrievalParamentReq {
	//类型
	private String parament;
	//类型编号
	private Integer paramentId;
	//设置项
	private String childParaments;
	//设置项编号
	private Integer childParamentsId;
	//条件值类型
	private String paramentType;
	//条件
	private List<RetrievalConditionReq> conditions;
	private String paramentName;
	
	public String getParamentName() {
		return paramentName;
	}
	public void setParamentName(String paramentName) {
		this.paramentName = paramentName;
	}
	public String getParament() {
		return parament;
	}
	public void setParament(String parament) {
		this.parament = parament;
	}
	public String getChildParaments() {
		return childParaments;
	}
	public void setChildParaments(String childParaments) {
		this.childParaments = childParaments;
	}
	public String getParamentType() {
		return paramentType;
	}
	public void setParamentType(String paramentType) {
		this.paramentType = paramentType;
	}
	public List<RetrievalConditionReq> getConditions() {
		return conditions;
	}
	public void setConditions(List<RetrievalConditionReq> conditions) {
		this.conditions = conditions;
	}
	public Integer getParamentId() {
		return paramentId;
	}
	public void setParamentId(Integer paramentId) {
		this.paramentId = paramentId;
	}
	public Integer getChildParamentsId() {
		return childParamentsId;
	}
	public void setChildParamentsId(Integer childParamentsId) {
		this.childParamentsId = childParamentsId;
	}
}
