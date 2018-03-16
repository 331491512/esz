/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TContactWaySpread.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午2:33:37<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TContactWaySpread
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午2:33:37  
*/
public class TContactWaySpread {
	//患者总人数
	private Integer totalNum;
	//既有微信又有手机号
	private Integer hasWeixinAndMobile;
	//只有微信
	private Integer justWeixin;
	//只有手机号
	private Integer justMobile;
	//没有联系方式的
	private Integer noContactMethod;
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public Integer getHasWeixinAndMobile() {
		return hasWeixinAndMobile;
	}
	public void setHasWeixinAndMobile(Integer hasWeixinAndMobile) {
		this.hasWeixinAndMobile = hasWeixinAndMobile;
	}
	public Integer getJustWeixin() {
		return justWeixin;
	}
	public void setJustWeixin(Integer justWeixin) {
		this.justWeixin = justWeixin;
	}
	public Integer getJustMobile() {
		return justMobile;
	}
	public void setJustMobile(Integer justMobile) {
		this.justMobile = justMobile;
	}
	public Integer getNoContactMethod() {
		return noContactMethod;
	}
	public void setNoContactMethod(Integer noContactMethod) {
		this.noContactMethod = noContactMethod;
	}
}
