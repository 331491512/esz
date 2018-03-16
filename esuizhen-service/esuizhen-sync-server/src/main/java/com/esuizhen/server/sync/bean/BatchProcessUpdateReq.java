/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>BatchProcessUpdateReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午9:04:20<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import java.io.Serializable;

/** 
* @ClassName: BatchProcessUpdateReq
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午9:04:20  
*/
public class BatchProcessUpdateReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String batchId;
	private Integer state;
	private String tableCode;
	private Integer tableId;
	private Long pushTimes;
	private Long processTimes;
	private Long getTimes;
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getTableCode() {
		return tableCode;
	}
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Long getPushTimes() {
		return pushTimes;
	}
	public void setPushTimes(Long pushTimes) {
		this.pushTimes = pushTimes;
	}
	public Long getProcessTimes() {
		return processTimes;
	}
	public void setProcessTimes(Long processTimes) {
		this.processTimes = processTimes;
	}
	public Long getGetTimes() {
		return getTimes;
	}
	public void setGetTimes(Long getTimes) {
		this.getTimes = getTimes;
	}
}
