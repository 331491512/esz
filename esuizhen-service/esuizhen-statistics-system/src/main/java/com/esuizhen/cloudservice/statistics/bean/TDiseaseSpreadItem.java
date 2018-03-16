/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.statistics.bean;<br/>  
 * <b>文件名：</b>TDiseaseSpreadItem.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月27日下午3:57:10<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.statistics.bean;
/** 
* @ClassName: TDiseaseSpreadItem
* @Description: 
* @author lichenghao
* @date 2016年5月27日 下午3:57:10  
*/
public class TDiseaseSpreadItem {
	//病种名称
	private String diseaseTypeName;
	//病种人数
	private Integer diseaseNum;
	//病种比率
	private String diseaseRate;
	
	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}
	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}
	public Integer getDiseaseNum() {
		return diseaseNum;
	}
	public void setDiseaseNum(Integer diseaseNum) {
		this.diseaseNum = diseaseNum;
	}
	public String getDiseaseRate() {
		return diseaseRate;
	}
	public void setDiseaseRate(String diseaseRate) {
		this.diseaseRate = diseaseRate;
	}
}
