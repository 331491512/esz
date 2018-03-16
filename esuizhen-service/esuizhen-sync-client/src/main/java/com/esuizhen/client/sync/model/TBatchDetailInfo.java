/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.cloudservice.sync.bean;<br/>  
 * <b>文件名：</b>TBatchInfo.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:11:15<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.client.sync.model;

import com.esuizhen.client.sync.bean.TBatchDataResultInfo;
import com.westangel.common.constant.ConstantSync;

/** 
* @ClassName: TBatchInfo
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午8:11:15  
*/
public class TBatchDetailInfo {
	private String batchId;
	private String tableCode;
	private Integer tableId;
	private Integer state;
	private Integer syncSize;
	private Integer hospitalId;
	
	private Integer pushNum;
	private Integer handleNum;
	private Integer successNum;
	private Integer failNum;
	
	private Long pushTimes;
	private Long processTimes;
	private Long getTimes;
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
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getSyncSize() {
		return syncSize;
	}
	public void setSyncSize(Integer syncSize) {
		this.syncSize = syncSize;
	}
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public Integer getPushNum() {
		return pushNum;
	}
	public void setPushNum(Integer pushNum) {
		this.pushNum = pushNum;
	}
	public Integer getHandleNum() {
		return handleNum;
	}
	public void setHandleNum(Integer handleNum) {
		this.handleNum = handleNum;
	}
	public Integer getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}
	public Integer getFailNum() {
		return failNum;
	}
	public void setFailNum(Integer failNum) {
		this.failNum = failNum;
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
	public void handleSyncFlag(TBatchDataResultInfo result) {//处理同步状态
		if(result!=null){
			handleNum++;
			if(result.getSyncFlag()==ConstantSync.SYNCFLAG.SYNC_OK)//如果成功  成功次数+1
				successNum++;
			else//如果失败 失败次数 +1
				failNum++;
		}
	}
}
