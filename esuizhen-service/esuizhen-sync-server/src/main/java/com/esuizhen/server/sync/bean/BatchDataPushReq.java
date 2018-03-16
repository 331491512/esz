/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>TBatchDataPushReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:49:29<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: TBatchDataPushReq
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午8:49:29  
*/
public class BatchDataPushReq implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String batchId;
	private Integer tableId;
	private String tableCode;
	private List dataList;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
	public List getDataList() {
		return dataList;
	}
	public void setDataList(List dataList) {
		this.dataList = dataList;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
}
