/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.westangel.common.bean.search;<br/>  
 * <b>文件名：</b>RetrievalConditionReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月10日下午4:05:14<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.westangel.common.bean.search;

import java.util.List;

/** 
* @ClassName: RetrievalConditionReq
* @Description: 
* @author lichenghao
* @date 2016年8月10日 下午4:05:14  
*/
public class RetrievalConditionReq {
	private Integer conditionId;
//	private List<String[]> values;
	private List<String> values;
	public Integer getConditionId() {
		return conditionId;
	}
	public void setConditionId(Integer conditionId) {
		this.conditionId = conditionId;
	}
	public List<String> getValues() {
		return values;
	}
	public void setValues(List<String> values) {
		this.values = values;
	}
	
//	public List<String[]> getValues() {
//		return values;
//	}
//	public void setValues(List<String[]> values) {
//		this.values = values;
//	}
}
