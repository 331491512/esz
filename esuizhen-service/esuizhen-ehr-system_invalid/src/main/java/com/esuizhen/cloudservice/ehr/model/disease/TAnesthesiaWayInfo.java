/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.model.disease<br/>  
 * <b>文件名：</b>TAnesthesiaWayInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午10:21:55<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.model.disease;
 
/** 
* @ClassName: TAnesthesiaWayInfo
* @Description: 
* @author NiDan
* @date 2016年8月15日上午10:21:55 
*/
public class TAnesthesiaWayInfo {
	
	private Integer anesthesiaId;//麻醉方式ID
	
	private String anesthesiaCode;//麻醉方式编码
	
	private String anesthesiaName;//麻醉方式名称
	
	public Integer getAnesthesiaId() {
		return anesthesiaId;
	}
	public void setAnesthesiaId(Integer anesthesiaId) {
		this.anesthesiaId = anesthesiaId;
	}
	public String getAnesthesiaCode() {
		return anesthesiaCode;
	}
	public void setAnesthesiaCode(String anesthesiaCode) {
		this.anesthesiaCode = anesthesiaCode;
	}
	public String getAnesthesiaName() {
		return anesthesiaName;
	}
	public void setAnesthesiaName(String anesthesiaName) {
		this.anesthesiaName = anesthesiaName;
	}

}
