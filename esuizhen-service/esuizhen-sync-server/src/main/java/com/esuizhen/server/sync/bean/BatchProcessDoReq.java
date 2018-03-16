/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>BatchProcessDoReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月21日上午11:02:24<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import java.io.Serializable;

/** 
* @ClassName: BatchProcessDoReq
* @Description: 
* @author lichenghao
* @date 2017年3月21日 上午11:02:24  
*/
public class BatchProcessDoReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String batchId;
	private String tableId;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getTableId() {
		return tableId;
	}
	public void setTableId(String tableId) {
		this.tableId = tableId;
	}
}
