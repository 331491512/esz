/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TFollowupResultSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午3:16:32<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TFollowupResultSpread
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午3:16:32  
*/
public class TFollowupResultSpread {
	//有效人数
	private Integer totalNum;
	//稳定人数
	private Integer stableNum;
	//稳定率
	private String stableRate;
	//复发人数
	private Integer recurrenceNum;
	//复发率
	private String recurrenceRate;
	//转移人数
	private Integer transferNum;
	//转移率
	private String transferRate;
	//死亡人数
	private Integer deathNum;
	//死亡率
	private String deathRate;
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getStableNum() {
		return stableNum;
	}
	public void setStableNum(Integer stableNum) {
		this.stableNum = stableNum;
	}
	public String getStableRate() {
		return stableRate;
	}
	public void setStableRate(String stableRate) {
		this.stableRate = stableRate;
	}
	public Integer getRecurrenceNum() {
		return recurrenceNum;
	}
	public void setRecurrenceNum(Integer recurrenceNum) {
		this.recurrenceNum = recurrenceNum;
	}
	public String getRecurrenceRate() {
		return recurrenceRate;
	}
	public void setRecurrenceRate(String recurrenceRate) {
		this.recurrenceRate = recurrenceRate;
	}
	public Integer getTransferNum() {
		return transferNum;
	}
	public void setTransferNum(Integer transferNum) {
		this.transferNum = transferNum;
	}
	public String getTransferRate() {
		return transferRate;
	}
	public void setTransferRate(String transferRate) {
		this.transferRate = transferRate;
	}
	public Integer getDeathNum() {
		return deathNum;
	}
	public void setDeathNum(Integer deathNum) {
		this.deathNum = deathNum;
	}
	public String getDeathRate() {
		return deathRate;
	}
	public void setDeathRate(String deathRate) {
		this.deathRate = deathRate;
	}
}
