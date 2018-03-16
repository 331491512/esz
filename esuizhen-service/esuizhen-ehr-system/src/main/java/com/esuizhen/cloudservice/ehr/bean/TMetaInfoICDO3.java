/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.bean;<br/>  
 * <b>文件名：</b>TMetaInfoICDO3.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年6月12日下午6:21:52<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.bean;
/** 
* @ClassName: TMetaInfoICDO3
* @Description: 
* @author lichenghao
* @date 2016年6月12日 下午6:21:52  
*/
public class TMetaInfoICDO3 {
	/**
	 * 病理诊断编码
	 */
	private String pathologyDiagnosisCode;
	/**
	 * 病理诊断名称
	 */
	private String pathologyDiagnosisName;
	/**
	 * 创建时间
	 */
	private String createTime;
	public String getPathologyDiagnosisCode() {
		return pathologyDiagnosisCode;
	}
	public void setPathologyDiagnosisCode(String pathologyDiagnosisCode) {
		this.pathologyDiagnosisCode = pathologyDiagnosisCode;
	}
	public String getPathologyDiagnosisName() {
		return pathologyDiagnosisName;
	}
	public void setPathologyDiagnosisName(String pathologyDiagnosisName) {
		this.pathologyDiagnosisName = pathologyDiagnosisName;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
}
