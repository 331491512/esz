/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.bean;<br/>  
 * <b>文件名：</b>BatchDataResultGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午9:01:43<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.bean;
/** 
* @ClassName: BatchDataResultGetReq
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午9:01:43  
*/
public class BatchDataResultGetReq {
	private String batchId;
	private Integer tableId;
	private String tableCode;
	
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
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
}
