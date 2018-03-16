/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.user.bean;<br/>  
 * <b>文件名：</b>TDiseaseInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月18日上午11:05:45<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.user.bean;
/** 
* @ClassName: TDiseaseInfo
* @Description: 
* @author lichenghao
* @date 2016年5月18日 上午11:05:45  
*/
public class TDiseaseInfo {
	
	//病种类型
	private Integer diseaseTypeId;
	
	//病种Id
	private String diseaseTypeName;

	public Integer getDiseaseTypeId() {
		return diseaseTypeId;
	}

	public void setDiseaseTypeId(Integer diseaseTypeId) {
		this.diseaseTypeId = diseaseTypeId;
	}

	public String getDiseaseTypeName() {
		return diseaseTypeName;
	}

	public void setDiseaseTypeName(String diseaseTypeName) {
		this.diseaseTypeName = diseaseTypeName;
	}
}
