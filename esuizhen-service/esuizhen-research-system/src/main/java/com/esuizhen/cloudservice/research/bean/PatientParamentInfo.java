/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.research.bean<br/>  
 * <b>文件名：</b>PatientParamentInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年10月12日下午5:36:23<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.research.bean;

import java.util.List;

/** 
* @ClassName: PatientParamentInfo
* @Description: 
* @author NiDan
* @date 2016年10月12日下午5:36:23 
*/
public class PatientParamentInfo {
	//参数编号
	private Integer paramentId;
	//参数名称
	private String paramentName;
	//参数值
	private String paramentValue;
	//子参数集合
	private List<PatientParamentInfo> childParaments;
	//参数类型
	private Integer paramentType;
	//参数数据获取类型
	private Integer paramentGetType;
	//参数内容
	private String paramentContent;
	//扩展参数
	private String expansion;
	//描述
	private String description;
	//条件
	private List<TConditionInfo> conditions;
	public Integer getParamentId() {
		return paramentId;
	}
	public void setParamentId(Integer paramentId) {
		this.paramentId = paramentId;
	}
	public String getParamentName() {
		return paramentName;
	}
	public void setParamentName(String paramentName) {
		this.paramentName = paramentName;
	}
	public String getParamentValue() {
		return paramentValue;
	}
	public void setParamentValue(String paramentValue) {
		this.paramentValue = paramentValue;
	}
	public List<PatientParamentInfo> getChildParaments() {
		return childParaments;
	}
	public void setChildParaments(List<PatientParamentInfo> childParaments) {
		this.childParaments = childParaments;
	}
	public Integer getParamentType() {
		return paramentType;
	}
	public void setParamentType(Integer paramentType) {
		this.paramentType = paramentType;
	}
	public Integer getParamentGetType() {
		return paramentGetType;
	}
	public void setParamentGetType(Integer paramentGetType) {
		this.paramentGetType = paramentGetType;
	}
	public String getParamentContent() {
		return paramentContent;
	}
	public void setParamentContent(String paramentContent) {
		this.paramentContent = paramentContent;
	}
	public String getExpansion() {
		return expansion;
	}
	public void setExpansion(String expansion) {
		this.expansion = expansion;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<TConditionInfo> getConditions() {
		return conditions;
	}
	public void setConditions(List<TConditionInfo> conditions) {
		this.conditions = conditions;
	}
}
