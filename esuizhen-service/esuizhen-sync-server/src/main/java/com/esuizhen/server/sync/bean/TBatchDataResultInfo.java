/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>TBatchDataResultInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:55:53<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

/** 
* @ClassName: TBatchDataResultInfo
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午8:55:53  
*/
public class TBatchDataResultInfo {
	private String resultId;
	private Integer syncFlag;
	private Integer opFlag;
	private Date syncTime;
	private String cause;
	private String batchId;
	private Integer tableId;
	private String id;//关系表Id
	public String getResultId() {
		return resultId;
	}
	public void setResultId(String resultId) {
		this.resultId = resultId;
	}
	public Integer getSyncFlag() {
		return syncFlag;
	}
	public void setSyncFlag(Integer syncFlag) {
		this.syncFlag = syncFlag;
	}
	public Date getSyncTime() {
		return syncTime;
	}
	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Integer getOpFlag() {
		return opFlag;
	}
	public void setOpFlag(Integer opFlag) {
		this.opFlag = opFlag;
	}
	public void checkCause(){
		if(StringUtils.isNotBlank(this.cause)&&this.cause.length()>100){
			this.cause = this.cause.substring(0,100);
		}
	}
}
