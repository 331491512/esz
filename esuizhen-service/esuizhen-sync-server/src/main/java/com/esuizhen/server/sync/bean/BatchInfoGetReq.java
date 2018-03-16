/**
 * <b>项目名：</b>易随诊<br/>  
 * <b>包名：</b>package com.esuizhen.server.sync.bean;<br/>
 * <b>文件名：</b>BatchInfoGetReq.java<br/>  
 * <b>版本信息：</b><br/>  
 * <b>日期：</b>2017年3月17日下午8:10:44<br/>  
 * <b>Copyright (c)</b> 2017西部天使公司-版权所有<br/>  
 *   
 */
package com.esuizhen.server.sync.bean;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: BatchInfoGetReq
* @Description: 
* @author lichenghao
* @date 2017年3月17日 下午8:10:44  
*/
public class BatchInfoGetReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer hospitalId;
	private List<TBatchDetailInfo> tableList;
	private String batchId;
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public List<TBatchDetailInfo> getTableList() {
		return tableList;
	}
	public void setTableList(List<TBatchDetailInfo> tableList) {
		this.tableList = tableList;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}
