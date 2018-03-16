/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>PatientDiagnosisListReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年5月24日下午3:13:53<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;

public class TMetaDiseaseTypeIcdListReq {
private String name;
private Integer page;
private Integer num;

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}
public Integer getPage() {
	return page;
}

public void setPage(Integer page) {
	this.page = page;
}

public Integer getNum() {
	return num;
}

public void setNum(Integer num) {
	this.num = num;
}
}
