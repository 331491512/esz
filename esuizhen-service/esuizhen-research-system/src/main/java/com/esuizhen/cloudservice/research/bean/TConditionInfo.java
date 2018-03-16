/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TConditionInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日上午10:42:51<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.research.bean;
/** 
* @ClassName: TConditionInfo
* @Description: 高级检索条件类
* @author lichenghao
* @date 2016年8月10日 上午10:42:51  
*/
public class TConditionInfo {
	//条件编号
	private Integer conditionId;
	//条件名称
	private String conditionName;
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public String getConditionName() {
		return conditionName;
	}
	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}
}
