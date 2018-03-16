/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.ehr.model.disease<br/>  
 * <b>文件名：</b>TDiagnosisBasisInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2016年8月15日上午10:26:15<br/>  
 * <b>Copyright (c)</b> 2015西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.cloudservice.ehr.model.detection;

import java.util.List; 
 
/** 
* @ClassName: TDiagnosisBasisInfo
* @Description: 
* @author fanpanwei
* @date 2016年8月15日上午10:26:15 
*/
public class DetectionReport {
	private String detectionTypeId;
	private String detectionTypeName;
	private List<DetectionItem> resultData;
	private List<DetectionItemDetail> itemDetailList;
	
	public String getDetectionTypeId() {
		return detectionTypeId;
	}
	public void setDetectionTypeId(String detectionTypeId) {
		this.detectionTypeId = detectionTypeId;
	}
	public String getDetectionTypeName() {
		return detectionTypeName;
	}
	public void setDetectionTypeName(String detectionTypeName) {
		this.detectionTypeName = detectionTypeName;
	}
	public List<DetectionItem> getDetectionItemList() {
		return resultData;
	}
	public void setDetectionItemList(List<DetectionItem> resultData) {
		this.resultData = resultData;
	}
	public List<DetectionItemDetail> getItemDetailList() {
		return itemDetailList;
	}
	public void setItemDetailList(List<DetectionItemDetail> itemDetailList) {
		this.itemDetailList = itemDetailList;
	}
}
