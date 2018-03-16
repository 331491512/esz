/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.bean;<br/>  
 * <b>文件名：</b>TBatchDataResultInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:55:53<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.bean;

/** 
* @ClassName: TBatchDataResultDetailInfo
* @Description: 
* @author lhy
* @date 2017年3月29日 
*/
public class TBatchDataResultDetailInfo extends TBatchDataResultInfo {
	private String batchId;
	private Integer tableId;
	
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
}
