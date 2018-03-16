/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TFollowupSpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午3:08:19<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TFollowupSpread
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午3:08:19  
*/
public class TFollowupSpread {
	//患者总数
	private Integer totalNum;
	//没有随访
	private Integer noFollowup;
	//无效随访
	private Integer invalidFollowup;
	//有效随访
	private Integer effectiveFollowup;
	/**
	 * 无需随访率
	 */
	private String noFollowupRate;
	/**
	 * 有效随访率
	 */
	private String effectiveRate;
	/**
	 * 无效随访率
	 */
	private String invalidRate;
	
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getNoFollowup() {
		return noFollowup;
	}
	public void setNoFollowup(Integer noFollowup) {
		this.noFollowup = noFollowup;
	}
	public Integer getInvalidFollowup() {
		return invalidFollowup;
	}
	public void setInvalidFollowup(Integer invalidFollowup) {
		this.invalidFollowup = invalidFollowup;
	}
	public Integer getEffectiveFollowup() {
		return effectiveFollowup;
	}
	public void setEffectiveFollowup(Integer effectiveFollowup) {
		this.effectiveFollowup = effectiveFollowup;
	}
	public String getNoFollowupRate() {
		return noFollowupRate;
	}
	public void setNoFollowupRate(String noFollowupRate) {
		this.noFollowupRate = noFollowupRate;
	}
	public String getEffectiveRate() {
		return effectiveRate;
	}
	public void setEffectiveRate(String effectiveRate) {
		this.effectiveRate = effectiveRate;
	}
	public String getInvalidRate() {
		return invalidRate;
	}
	public void setInvalidRate(String invalidRate) {
		this.invalidRate = invalidRate;
	}
}
