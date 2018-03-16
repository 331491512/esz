/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.model.disease<br/>  
 * <b>文件名：</b>TDiagnosisTypeInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午10:20:54<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.model.disease;
 
/** 
* @ClassName: TDiagnosisTypeInfo
* @Description: 
* @author NiDan
* @date 2016年8月15日上午10:20:54 
*/
public class TDiagnosisTypeInfo {
	
	private Integer diagnosisTypeId;//诊断类型ID
	
	private String diagnosisTypeName;//诊断类型名称

	public Integer getDiagnosisTypeId() {
		return diagnosisTypeId;
	}

	public void setDiagnosisTypeId(Integer diagnosisTypeId) {
		this.diagnosisTypeId = diagnosisTypeId;
	}

	public String getDiagnosisTypeName() {
		return diagnosisTypeName;
	}

	public void setDiagnosisTypeName(String diagnosisTypeName) {
		this.diagnosisTypeName = diagnosisTypeName;
	}

}
