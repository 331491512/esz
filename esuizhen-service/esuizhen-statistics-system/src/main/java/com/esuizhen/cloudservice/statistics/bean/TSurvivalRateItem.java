/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TSurvivalRateItem.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年4月11日下午6:52:03<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TSurvivalRateItem
* @Description: 
* @author lichenghao
* @date 2016年4月11日 下午6:52:03  
*/
public class TSurvivalRateItem {
	
	//月份
	private Integer month;
	
	//生存率
	private String survivalRate;
	
	//有效人数
	private Integer valid;
	
	//有效率
	private String validRate;
	
	//生存人数
	private Integer survivalNumber;
	
	//失访人数
	private Integer censoringNumber;
	
	//总人数
	private Integer totalNumber;
	
	public TSurvivalRateItem(){
		
	}
	
	public TSurvivalRateItem(String month,String survivalRate){
		this.month = Integer.parseInt(month);
		this.survivalRate = survivalRate;
	}
	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getSurvivalRate() {
		return survivalRate;
	}

	public void setSurvivalRate(String survivalRate) {
		this.survivalRate = survivalRate;
	}

	public Integer getSurvivalNumber() {
		return survivalNumber;
	}

	public void setSurvivalNumber(Integer survivalNumber) {
		this.survivalNumber = survivalNumber;
	}

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}

	public String getValidRate() {
		return validRate;
	}

	public void setValidRate(String validRate) {
		this.validRate = validRate;
	}

	public Integer getCensoringNumber() {
		return censoringNumber;
	}

	public void setCensoringNumber(Integer censoringNumber) {
		this.censoringNumber = censoringNumber;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}
}
