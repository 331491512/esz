/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.followup.model.daily;<br/>  
 * <b>文件名：</b>TDailyStatisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年2月5日上午11:48:17<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.followup.model.daily;

import java.util.List;

/** 
* @ClassName: TDailyStatisInfo
* @Description: 
* @author lichenghao
* @date 2016年2月5日 上午11:48:17  
*/
public class TDailyStatisInfo {
	private Integer countNum;
	private Integer contrastum;
	private List dataList;
	private List dataListTwo;
	public Integer getCountNum() {
		return countNum;
	}
	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}
	public Integer getContrastum() {
		return contrastum;
	}
	public void setContrastum(Integer contrastum) {
		this.contrastum = contrastum;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	public List getDataListTwo() {
		return dataListTwo;
	}
	public void setDataListTwo(List dataListTwo) {
		this.dataListTwo = dataListTwo;
	}
}
