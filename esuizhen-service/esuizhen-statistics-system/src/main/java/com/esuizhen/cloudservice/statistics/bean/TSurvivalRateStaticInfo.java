/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TSurvivalRateStaticInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月12日下午3:42:26<br/>  
 * <b>Copyright (c)</b> 2016西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;

import java.util.List;

/** 
* @ClassName: TSurvivalRateStaticInfo
* @Description: 生存率统计信息
* @author lichenghao
* @date 2016年8月12日 下午3:42:26  
*/
public class TSurvivalRateStaticInfo {
	//中位生存月
	private String middleMonth;
	//生存统计信息
	private List<TSurvivalRateItem> survivalRates;
	public String getMiddleMonth() {
		return middleMonth;
	}
	public void setMiddleMonth(String middleMonth) {
		this.middleMonth = middleMonth;
	}
	public List<TSurvivalRateItem> getSurvivalRates() {
		return survivalRates;
	}
	public void setSurvivalRates(List<TSurvivalRateItem> survivalRates) {
		this.survivalRates = survivalRates;
	}
}
