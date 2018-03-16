/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.model;<br/>  
 * <b>文件名：</b>ConfTableInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月20日上午10:23:14<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.model;
/** 
* @ClassName: ConfTableInfo
* @Description: 
* @author lichenghao
* @date 2017年3月20日 上午10:23:14  
*/
public class ConfTableInfo {
	private Integer tableId;
	private String tableCode;
	private Integer syncSize;
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
	public Integer getSyncSize() {
		return syncSize;
	}
	public void setSyncSize(Integer syncSize) {
		this.syncSize = syncSize;
	}
}
