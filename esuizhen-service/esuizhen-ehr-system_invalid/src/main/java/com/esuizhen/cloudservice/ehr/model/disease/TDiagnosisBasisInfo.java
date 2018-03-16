/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.model.disease<br/>  
 * <b>文件名：</b>TDiagnosisBasisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午10:26:15<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.model.disease;
 
/** 
* @ClassName: TDiagnosisBasisInfo
* @Description: 
* @author NiDan
* @date 2016年8月15日上午10:26:15 
*/
public class TDiagnosisBasisInfo {
	
	private Integer diagnosisBasisId;//诊断依据ID
	
	private String diagnosisBasisCode;//诊断依据编码
	
	private String diagnosisBasisName;//诊断依据名称
	
	public Integer getDiagnosisBasisId() {
		return diagnosisBasisId;
	}
	public void setDiagnosisBasisId(Integer diagnosisBasisId) {
		this.diagnosisBasisId = diagnosisBasisId;
	}
	public String getDiagnosisBasisCode() {
		return diagnosisBasisCode;
	}
	public void setDiagnosisBasisCode(String diagnosisBasisCode) {
		this.diagnosisBasisCode = diagnosisBasisCode;
	}
	public String getDiagnosisBasisName() {
		return diagnosisBasisName;
	}
	public void setDiagnosisBasisName(String diagnosisBasisName) {
		this.diagnosisBasisName = diagnosisBasisName;
	}
}
